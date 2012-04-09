/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.composites.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.composites.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.composites.IClassNameConstants.MAP_ENTRY;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.EMPTY_STACK_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.STACK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.util.StringUtil;

@SyntaxDependent
public class AbstractInterpreterGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private ConcreteSyntax concreteSyntax;
	private Set<GenClass> allGenClasses;
	private GenClassCache genClassCache;
	
	private class InheritanceComparator implements Comparator<GenClass>{

		public int compare(GenClass g1, GenClass g2) {
			List<GenClass> superClasses = g1.getAllBaseGenClasses();
			if (superClasses.contains(g2)) {
				return -1;
			} else {
				return 1;
			}
		}
		
	}

	@Override
	public void generateJavaContents(JavaComposite sc) {
		concreteSyntax = getContext().getConcreteSyntax();
		genClassCache = concreteSyntax.getGenClassCache();
		allGenClasses = getAllGenClasses();

		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
				"This class provides basic infrastructure to interpret models. " +
				"To implement concrete interpreters, subclass this abstract interpreter " +
				"and override the interprete_* methods. The interpretation can be customized " +
				"by binding the two type parameters (ResultType, ContextType). The former " +
				"is returned by all interprete_* methods, while the latter is passed from " +
				"method to method while traversing the model. The concrete traversal strategy " +
				"can also be exchanged. One can use a static traversal strategy by pushing " +
				"all objects to interpret on the interpretation stack (using addObjectToInterprete()) " +
				"before calling interprete(). Alternatively, the traversal strategy can be dynamic " +
				"by pushing objects on the interpretation stack during interpretation."
		);
		sc.add("public class " + getResourceClassName() + "<ResultType, ContextType> {");
		sc.addLineBreak();
		addFields(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addInterpreteMethod(sc);
		addContinueInterpretationMethod(sc);
		addDoSwitchMethod(sc);
		addInterpreteTypeMethods(sc);
		addNotifyListenersMethod(sc);
		addAddObjectToInterpreteMethod(sc);
		addAddObjectsToInterpreteMethod(sc);
		addAddObjectsToInterpreteInReverseOrderMethod(sc);
		addAddObjectTreeToInterpreteTopDownMethod(sc);
		addAddListenerMethod(sc);
		addRemoveListenerMethod(sc);
		addGetNextObjectToInterpreteMethod(sc);
		addGetInterpretationStackMethod(sc);
		addTerminateMethod(sc);
		addGetCurrentContextMethod(sc);
	}

	private void addAddObjectTreeToInterpreteTopDownMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Adds the given object and all its children to the interpretation stack such that they are interpret in top down order."
		);
		sc.add("public void addObjectTreeToInterpreteTopDown(" + E_OBJECT + " root) {");
		sc.add(LIST + "<" + E_OBJECT + "> objects = new " + ARRAY_LIST + "<" + E_OBJECT + ">();");
		sc.add("objects.add(root);");
		sc.add(ITERATOR + "<" + E_OBJECT + "> it = root.eAllContents();");
		sc.add("while (it.hasNext()) {");
		sc.add(E_OBJECT + " eObject = (" + E_OBJECT + ") it.next();");
		sc.add("objects.add(eObject);");
		sc.add("}");
		sc.add("addObjectsToInterpreteInReverseOrder(objects);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetNextObjectToInterpreteMethod(JavaComposite sc) {
		sc.add("public " + E_OBJECT + " getNextObjectToInterprete() {");
		sc.add("return nextObjectToInterprete;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetInterpretationStackMethod(JavaComposite sc) {
		sc.add("public " + STACK + "<" + E_OBJECT + "> getInterpretationStack() {");
		sc.add("return interpretationStack;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addTerminateMethod(JavaComposite sc) {
		sc.add("public void terminate() {");
		sc.add("interpretationStack.clear();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetCurrentContextMethod(JavaComposite sc) {
		sc.add("public Object getCurrentContext() {");
		sc.add("return currentContext;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addAddListenerMethod(JavaComposite sc) {
		sc.add("public void addListener(" + iInterpreterListenerClassName + " newListener) {");
		sc.add("listeners.add(newListener);");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addRemoveListenerMethod(JavaComposite sc) {
		sc.add("public boolean removeListener(" + iInterpreterListenerClassName + " listener) {");
		sc.add("return listeners.remove(listener);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addContinueInterpretationMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Override this method to stop the overall interpretation depending on " +
			"the result of the interpretation of a single model elements."
		);
		sc.add("public boolean continueInterpretation(ContextType context, ResultType result) {");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDoSwitchMethod(StringComposite sc) {
		sc.add("public ResultType interprete(" + E_OBJECT + " object, ContextType context) {");
		sc.add("ResultType result = null;");
		// sort genClasses by inheritance
		List<GenClass> sortedClasses = new ArrayList<GenClass>();
		sortedClasses.addAll(allGenClasses);
		Collections.sort(sortedClasses, new InheritanceComparator());
		
		// add if statement for each class
		for (GenClass genClass : sortedClasses) {
			String methodName = getMethodName(genClass);
			String typeName = getTypeName(genClass);
			sc.add("if (object instanceof " + typeName + ") {");
			sc.add("result = " + methodName + "((" + typeName + ") object, context);");
			sc.add("}");
			sc.add("if (result != null) {");
			sc.add("return result;");
			sc.add("}");
		}
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private String getTypeName(GenClass genClass) {
		String typeName = genClassCache.getQualifiedInterfaceName(genClass);
		// for maps we add type arguments to avoid compiler warnings
		if (MAP_ENTRY.equals(typeName)) {
			typeName += "<?,?>";
		}
		return typeName;
	}

	private void addInterpreteTypeMethods(StringComposite sc) {
		for (GenClass genClass : allGenClasses) {
			addInterpreteTypeMethod(sc, genClass);
		}
	}

	private Set<GenClass> getAllGenClasses() {
		Set<GenPackage> usedGenPackages = new LinkedHashSet<GenPackage>();
		usedGenPackages.add(concreteSyntax.getPackage());
		for (Import importElement : concreteSyntax.getImports()) {
			usedGenPackages.add(importElement.getPackage());
		}
		
		Set<GenClass> usedGenClasses = collectAllGenClasses(usedGenPackages);
		return usedGenClasses;
	}

	private void addInterpreteTypeMethod(StringComposite sc, GenClass genClass) {
		String typeName = getTypeName(genClass);
		String methodName = getMethodName(genClass);
		String objectName = StringUtil.firstToLower(genClass.getName());
		if ("context".equals(objectName) || StringUtil.isReserveredWord(objectName)) {
			objectName = "_" + objectName;
		}
		sc.add("public ResultType " + methodName + "(" + typeName + " " + objectName + ", ContextType context) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private String getMethodName(GenClass genClass) {
		String escapedTypeName = genClassCache.getEscapedTypeName(genClass);
		String methodName = "interprete_" + escapedTypeName;
		return methodName;
	}

	private Set<GenClass> collectAllGenClasses(Set<GenPackage> usedGenPackages) {
		Set<GenClass> allGenClasses = new LinkedHashSet<GenClass>();
		for (GenPackage genPackage : usedGenPackages) {
			for (GenClass genClass : genPackage.getGenClasses()) {
				allGenClasses.add(genClass);
			}
		}
		return allGenClasses;
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + STACK + "<" + E_OBJECT + "> interpretationStack = new " + STACK + "<" + E_OBJECT + ">();");
		sc.add("private " + LIST + "<" + iInterpreterListenerClassName + "> listeners = new " + ARRAY_LIST + "<" + iInterpreterListenerClassName + ">();");
		sc.add("private " + E_OBJECT + " nextObjectToInterprete;");
		sc.add("private Object currentContext;");
		sc.addLineBreak();
	}

	private void addInterpreteMethod(JavaComposite sc) {
		sc.add("public ResultType interprete(ContextType context) {");
		sc.add("ResultType result = null;");
		sc.add(E_OBJECT + " next = null;");
		sc.add("currentContext = context;");
		sc.add("while (!interpretationStack.empty()) {");
		sc.add("try {");
		sc.add("next = interpretationStack.pop();");
		sc.add("} catch (" + EMPTY_STACK_EXCEPTION + " ese) {");
		sc.addComment(
			"this can happen when the interpreter was terminated between " +
			"the call to empty() and pop()"
		);
		sc.add("break;");
		sc.add("}");
		sc.add("nextObjectToInterprete = next;");
		sc.add("notifyListeners(next);");
		sc.add("result = interprete(next, context);");
		sc.add("if (!continueInterpretation(context, result)) {");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("currentContext = null;");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addNotifyListenersMethod(StringComposite sc) {
		sc.add("private void notifyListeners(" + E_OBJECT + " element) {");
		sc.add("for (" + iInterpreterListenerClassName + " listener : listeners) {");
		sc.add("listener.handleInterpreteObject(element);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddObjectToInterpreteMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Adds the given object to the interpretation stack. Attention: " +
			"Objects that are added first, are interpret last."
		);
		sc.add("public void addObjectToInterprete(" + E_OBJECT + " object) {");
		sc.add("interpretationStack.push(object);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddObjectsToInterpreteMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Adds the given collection of objects to the interpretation stack. Attention: " +
			"Collections that are added first, are interpret last."
		);
		sc.add("public void addObjectsToInterprete(" + COLLECTION + "<? extends " + E_OBJECT + "> objects) {");
		sc.add("for (" + E_OBJECT + " object : objects) {");
		sc.add("addObjectToInterprete(object);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddObjectsToInterpreteInReverseOrderMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Adds the given collection of objects in reverse order to the interpretation stack."
		);
		sc.add("public void addObjectsToInterpreteInReverseOrder(" + COLLECTION + "<? extends " + E_OBJECT + "> objects) {");
		sc.add(LIST + "<" + E_OBJECT + "> reverse = new " + ARRAY_LIST + "<" + E_OBJECT + ">(objects.size());");
		sc.add("reverse.addAll(objects);");
		sc.add(COLLECTIONS + ".reverse(reverse);");
		sc.add("addObjectsToInterprete(reverse);");
		sc.add("}");
		sc.addLineBreak();
	}
}

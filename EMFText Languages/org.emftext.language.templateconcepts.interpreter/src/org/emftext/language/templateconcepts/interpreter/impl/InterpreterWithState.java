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
package org.emftext.language.templateconcepts.interpreter.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.templateconcepts.ExpressionChecker;
import org.emftext.language.templateconcepts.ForEach;
import org.emftext.language.templateconcepts.If;
import org.emftext.language.templateconcepts.IfElse;
import org.emftext.language.templateconcepts.Placeholder;
import org.emftext.language.templateconcepts.Template;
import org.emftext.language.templateconcepts.TemplateConcept;
import org.emftext.language.templateconcepts.TemplateMetamodelConstants;
import org.emftext.language.templateconcepts.TemplateconceptsPackage;
import org.emftext.language.templateconcepts.interpreter.exceptions.InterpreterException;
import org.emftext.language.templateconcepts.interpreter.exceptions.TemplateException;
import org.emftext.language.templateconcepts.interpreter.exceptions.TemplateMetamodelException;

/**
 * This is the actual interpreter. It maintains a state. Thus,
 * all different parameters can be interrogated just
 * after interpretation or later on.
 *
 * TODO InputModels shouldn't contain StringBox, etc. to be working
 * TODO use EPackage of object language instead of template language to create tiObjects
 *
 * @author Marcel Boehme
 */
public class InterpreterWithState {

	private final Template template;

	private EObject templateInstanceRoot;

	private Stack<EObject> inputObjectStack;
	private Stack<EObject> inputMetaClassStack;
	private LoopVariablesStack loopVariableStack;

	private ExpressionChecker expressionChecker;

	private Map<EObject, EObject> templateToInstanceObjectMap;
	private Map<EObject, EObject> instanceToTemplateObjectMap;

	public InterpreterWithState(Template template, EObject inputModelRoot) throws InterpreterException{
		this.template = template;

		inputObjectStack = new Stack<EObject>();
		inputMetaClassStack = new Stack<EObject>();
		loopVariableStack = new LoopVariablesStack();

		inputObjectStack.push(inputModelRoot);
		inputMetaClassStack.push(inputModelRoot.eClass());

		templateToInstanceObjectMap = new HashMap<EObject, EObject>();
		instanceToTemplateObjectMap = new HashMap<EObject, EObject>();

		expressionChecker = new ExpressionChecker();

		load();
	}

	private void load() throws InterpreterException {

		//find templateBody
		EStructuralFeature templateBodySF = template.eClass().getEStructuralFeature(TemplateMetamodelConstants.REFERENCE_TEMPLATE_BODY);
		if (templateBodySF == null) {
			throw new TemplateMetamodelException("Template has no body");
		}

		EObject templateBodyO = (EObject) template.eGet(templateBodySF);
		if (templateBodyO == null) {
			throw new TemplateMetamodelException("Template has no body");
		}
		if (templateBodyO instanceof List<?>) {
			//Can be a list
			throw new TemplateMetamodelException("Template contains multiple root elements");
		} else {
			//or a single element
			templateInstanceRoot = evaluate(templateBodyO, templateBodyO, templateBodyO.eContainingFeature());
			copyCrossReferences();
		}
	}

	/**
	 * mboehme: What does this do? Thought we already check *.getEAllReferences() by *.eContents()?
	 */
	private void copyCrossReferences() {
		if (templateInstanceRoot == null) {
			return;
		}
		// Copy cross reference
		TreeIterator<EObject> contents = templateInstanceRoot.eAllContents();
		while (contents.hasNext()) {
			EObject nextTiObject = contents.next();
			for (EReference reference : nextTiObject.eClass().getEAllReferences()) {
				if (reference.isContainment()) {
					continue;
				}
				if (reference.isContainer()) {
					continue;
				}
				EObject tObject = instanceToTemplateObjectMap.get(nextTiObject);
				EObject referencedObjectInTemplate = (EObject) tObject.eGet(reference);
				EObject referencedObjectInInstance = templateToInstanceObjectMap.get(referencedObjectInTemplate);

				//System.out.println("copy cross reference " + reference.getName() + " target = " + referencedObjectInInstance);
				if (referencedObjectInInstance == null) {
					//cross-resource reference: set link to original
					referencedObjectInInstance = referencedObjectInTemplate;
				}
				nextTiObject.eSet(reference, referencedObjectInInstance);
			}
		}
	}

	/**
	 * @param tObject eObject in the template language
	 * @param tiPackage an ePackage in the template instance
	 * @return Returns the representative of parent in the template instance
	 */
	private EObject evaluate(EObject tObject, EObject currentTiParent, EStructuralFeature currentTiReference) throws InterpreterException {
		if (tObject == null) {
			return null;
		}
		//TODO treat cycles (if needed), but watch context!
		//if(templateToInstanceObjectMap.get(tObject)!=null){
		//	return templateToInstanceObjectMap.get(tObject); (Code not watching variable context)
	    //}

		//find respective language class in this package
		//and instantiate it as EObject
		EObject tiObjectCopy = createObjectOfSameClass(tObject);
		if (tiObjectCopy == null) {
			String className = tObject.eClass().getName();
			throw new InterpreterException("Didn't find respective template instance class for template class '" + className + "'");
		}

		boolean isTemplateConcept = isTemplateConcept(tiObjectCopy);
		if (!isTemplateConcept) {
			copyAttributes(tObject, tiObjectCopy);
			currentTiParent = tiObjectCopy;
		}

		//System.out.println("Copied " + tObject + " to " + tiObject);
		//FIXME mboehme: doesn't work! For instance in a forLoop the same tObject results in different tiObjects
		templateToInstanceObjectMap.put(tObject, currentTiParent);
		instanceToTemplateObjectMap.put(currentTiParent, tObject);

		for (EObject tContentObject : tObject.eContents()) {
			if (tContentObject == null) {
				throw new InterpreterException("tContentObject was null?");
			}
			if (!isTemplateConcept) {
				currentTiReference = tContentObject.eContainingFeature();
				System.out.println("TI Reference := " + currentTiReference.getName());
			}
			// evaluate template concepts
			if (tContentObject instanceof TemplateConcept) {
				if (tContentObject instanceof Placeholder) {
					EObject result = evaluatePlaceHolder((Placeholder) tContentObject, currentTiParent);
					attach(currentTiParent, result, currentTiReference);
				} else if (tContentObject instanceof ForEach) {
					List<EObject> result = evaluateForLoop((ForEach) tContentObject, currentTiParent, currentTiReference);
					attach(currentTiParent, result, currentTiReference);
				} else if (tContentObject instanceof If) {
					EObject result = evaluateIfCondition((If) tContentObject, currentTiParent, currentTiReference);
					// may be null
					if (result != null) {
						attach(currentTiParent, result, currentTiReference);
					}
				} else if (tContentObject instanceof IfElse) {
					EObject result = evaluateIfElseCondition((IfElse) tContentObject, currentTiParent, currentTiReference);
					attach(currentTiParent, result, currentTiReference);
				} else {
					throw new TemplateMetamodelException("Unkown TemplateConcept: " + tContentObject.getClass());
				}
			// evaluate object language elements (recursively)
			} else {
				EObject subResult = evaluate(tContentObject, currentTiParent, currentTiReference);
				attach(currentTiParent, subResult, currentTiReference);
			}
		}

		return currentTiParent;
	}

	/**
	 * Copies all attributes from 'tObject' to 'tiObject'. This method is used
	 * to transfer the attribute value for copied object language elements.
	 *
	 * @param tObject
	 * @param tiObject
	 * @throws TemplateMetamodelException
	 */
	private void copyAttributes(EObject tObject, EObject tiObject) throws TemplateMetamodelException {
		// copy all attributes
		for (EAttribute tiAttributeClass : tiObject.eClass().getEAllAttributes()) {

			//TODO Check if this is an instance of primitive_type (only primitive type has attributes)
			//TODO Import primitive_type into project dependencies
			//AND every primitive type should inherit an abstract type: PrimitiveType
			//if(!(tiObject instanceof PrimitiveType)) throw new TemplateMetamodelException("Attributes must be wrapped in a Primitive Type");

			String attributeName = tiAttributeClass.getName();
			//find respective langParentAttributeClass

			EAttribute tAttributeClass = null;
			for (EAttribute attributeOfTemplateObject : tObject.eClass().getEAllAttributes()) {
				if (attributeOfTemplateObject.getName().matches(attributeName)) {
					tAttributeClass = attributeOfTemplateObject;
					break;
				}
			}
			if (tAttributeClass == null) {
				throw new TemplateMetamodelException("No tAttributeClass found for tiAttributeClass " + tObject.eClass().getName()+"."+attributeName);
			}
			Object tAttribute = tObject.eGet(tAttributeClass);
			//System.out.println("Copied attribute " + attributeName + " (" + tAttribute + ") to " + tiObject);
			//attribute-OBJECTS just need to be set. No need to transform them
			tiObject.eSet(tiAttributeClass, tAttribute);
		}
	}

	private boolean isTemplateConcept(EObject tiObject) {
		List<EClass> supertypes = tiObject.eClass().getEAllSuperTypes();
		for (EClass supertype : supertypes) {
			if (supertype.getEPackage().getNsURI().equals(TemplateconceptsPackage.eNS_URI)) {
				return true;
			}
		}
		return false;
	}

	private EObject evaluatePlaceHolder(Placeholder placeHolder, EObject currentTiParent) throws InterpreterException{

		Object evaluatedObject = evaluateExpression(placeHolder);

		//placeHolder extends from PlaceHolder and the tiAttributeClass
		List<EClass> superClasses = placeHolder.eClass().getESuperTypes();
		if (superClasses.size() != 2) {
			throw new TemplateMetamodelException("The type of a concrete placeholder extends from PlaceHolder and the extended attribute");
		}
		EClass tAttributeElementClass = null;
		for (EClass superClass : superClasses) {
			if (!superClass.equals(TemplateconceptsPackage.eINSTANCE.getPlaceholder())) {
				tAttributeElementClass = superClass;
			}
		}
		if (tAttributeElementClass == null) {
			throw new TemplateMetamodelException("The type of a concrete placeholder extends from PlaceHolder and the extended attribute");
		}

		EClass tiConcreteAttributeClass = findSubClass(tAttributeElementClass);

		//find tiAttributeElement
		EObject tiAttributeElement = createObject(tiConcreteAttributeClass);
		if (tiAttributeElement == null) {
			throw new TemplateMetamodelException("Couldn't create tiAttributeElement - class: " + tAttributeElementClass);
		}

		// TODO mseifert: this is a dirty hack, but it works, since all primitive types
		// have the attribute 'value'.
		// mboehme: Should be resolved when no PrimitiveTypes are needed in inputModels anymore
		if (evaluatedObject instanceof EObject) {
			EObject evaluatedEObject = (EObject) evaluatedObject;
			EClass evaluateEObjectClass = evaluatedEObject.eClass();
			tiAttributeElement.eSet(tiConcreteAttributeClass.getEStructuralFeature("value"), evaluatedEObject.eGet(evaluateEObjectClass.getEStructuralFeature("value")));
		}
		else {
			tiAttributeElement.eSet(tiConcreteAttributeClass.getEStructuralFeature("value"), evaluatedObject);
		}
		return tiAttributeElement;
	}

	/**
	 * Adds all 'children' to 'feature' in 'parent'.
	 */
	private void attach(EObject parent, List<EObject> children, EStructuralFeature feature) throws InterpreterException {
		for (EObject child : children) {
			attach(parent, child, feature);
		}
	}

	/**
	 * Adds 'child' to 'feature' in 'parent'.
	 */
	@SuppressWarnings("unchecked")
	private void attach(EObject parent, EObject child, EStructuralFeature feature) throws InterpreterException {
		if (feature == null) {
			throw new InterpreterException("Placeholder must be contained by some container");
		}
		System.out.println("attach() " + parent.eClass().getName() + "." + feature.getName() + " <- " + child.eClass().getName());
		//multiplicity > 1
		Object value = parent.eGet(feature);
		if (value instanceof List<?>) {
			((EList<EObject>)value).add(child);
		//multiplicity <=1
		} else {
			parent.eSet(feature, child);
		}
	}

	/**
	 * Finds the subclass which extends from this attribute-wrapper,
	 * which is not the placeholder
	 * TODO Use EPackage of object language instead
	 * @param abstractAttributeClass The attribute-wrapper
	 * @return Returns the subclass extending from abstractAttributeClass (NOT the placeholder)
	 */
	private EClass findSubClass(EClass abstractAttributeClass) {
		EPackage ePackage = (EPackage) abstractAttributeClass.eContainer();
		for (EClassifier classifier : ePackage.getEClassifiers()) {
			if (!(classifier instanceof EClass)) {
				continue;
			}
			EClass eClass = (EClass) classifier;
			//mboehme: Bugfix: Shouldn't return eClass if it is a template concept (e.g. placeholder)
			if (eClass.getEAllSuperTypes().contains(abstractAttributeClass)
					&& !eClass.getEAllSuperTypes().contains(TemplateconceptsPackage.eINSTANCE.getTemplateConcept())) {
				return eClass;
			}
		}
		return null;
	}

	private Object evaluateExpression(TemplateConcept concept) {
		EObject peek = inputObjectStack.peek();
		return expressionChecker.evaluateExpression(
				peek.eClass(),
				peek,
				loopVariableStack.getTopMostVariables(),
				concept.getExpression());
	}

	/**
	 *
	 * @param forLoop the loop object
	 * @param tiObject the parent object that contains the loop
	 *
	 * @throws InterpreterException
	 */
	private List<EObject> evaluateForLoop(ForEach forLoop, EObject currentTiParent, EStructuralFeature currentTiReference) throws InterpreterException{
		//Find forBody
		Object forBodyO = forLoop.eGet(forLoop.eClass().getEStructuralFeature(TemplateMetamodelConstants.REFERENCE_FOR_BODY));
		if (forBodyO == null) {
			throw new TemplateMetamodelException("ForLoop without body: " + forLoop);
		}

		//Resolve the collection
		Collection<?> inputCollection = (Collection<?>) evaluateExpression(forLoop);

		List<EObject> bodyElements = new ArrayList<EObject>();
		//THE FORLOOP
		for (Object o : inputCollection) {
			if (!(o instanceof EObject)) {
				throw new TemplateException("For-loop methodCall ("+forLoop.getExpression()+") does not return a list of ModelElements but Attributes");
			}
			EObject next = (EObject) o;
			inputObjectStack.push(next);
			String variableName = forLoop.getVariable();
			if (variableName != null) {
				loopVariableStack.push(variableName, next);
			}
			//BODY (can contain multiple elements)
			if (forBodyO instanceof List<?>) {
				List<?> forBodyList = (List<?>)forBodyO;
				for (Object forBody : forBodyList) {
					if (forBody instanceof EObject) {
						bodyElements.add(evaluate((EObject) forBody, currentTiParent, currentTiReference));
					}
				}
			} else {
				bodyElements.add(evaluate((EObject) forBodyO, currentTiParent, currentTiReference));
			}
			if (variableName != null) {
				loopVariableStack.pop();
			}
			inputObjectStack.pop();
		}
		return bodyElements;
	}

	private EObject evaluateIfCondition(If ifCondition, EObject currentTiParent, EStructuralFeature currentTiReference) throws InterpreterException{
		EObject ifBodyO = (EObject) ifCondition.eGet(ifCondition.eClass().getEStructuralFeature(TemplateMetamodelConstants.REFERENCE_IF_BODY));
		if (ifBodyO == null) {
			throw new TemplateMetamodelException("IfCondition without body: " + ifCondition);
		}

		return evaluateIfOrIfElse(ifCondition, ifBodyO, null, currentTiParent, currentTiReference);
	}

	private EObject evaluateIfElseCondition(IfElse ifElseCondition, EObject currentTiParent, EStructuralFeature currentTiReference) throws InterpreterException{
		EObject ifBodyO = (EObject) ifElseCondition.eGet(ifElseCondition.eClass().getEStructuralFeature(TemplateMetamodelConstants.REFERENCE_IF_BODY));
		if (ifBodyO == null) {
			throw new TemplateMetamodelException("IfElseCondition without ifBody: " + ifElseCondition);
		}
		EObject elseBodyO = (EObject) ifElseCondition.eGet(ifElseCondition.eClass().getEStructuralFeature(TemplateMetamodelConstants.REFERENCE_ELSE_BODY));
		if (elseBodyO == null) {
			throw new TemplateMetamodelException("IfElseCondition without elseBody: " + ifElseCondition);
		}

		return evaluateIfOrIfElse(ifElseCondition, ifBodyO, elseBodyO, currentTiParent, currentTiReference);
	}

	private EObject evaluateIfOrIfElse(TemplateConcept ifOrIfElse, EObject ifBodyO, EObject elseBodyO, EObject currentTiParent, EStructuralFeature currentTiReference) throws InterpreterException{

		List<EObject> bodyElements = new ArrayList<EObject>();//;ListUtil.castListUnchecked(tiObject.eGet(tiReference));

		Boolean condition = (Boolean) evaluateExpression(ifOrIfElse);

		//IF-CONDITION
		if (condition) {
			//ifBody
			if (ifBodyO instanceof List<?>) {
				List<?> ifBodyList = (List<?>)ifBodyO;
				for (Object ifBody : ifBodyList) {
					if (ifBody instanceof EObject) {
						bodyElements.add(evaluate((EObject) ifBody, currentTiParent, currentTiReference));
					}
				}
			} else {
				bodyElements.add(evaluate(ifBodyO, currentTiParent, currentTiReference));
			}
		} else {
			// elseBody can be null (this method is also used to evaluate IF statements
			if (elseBodyO != null) {
				if (elseBodyO instanceof List<?>) {
					List<?> elseBodyList = (List<?>) elseBodyO;
					for (Object elseBody : elseBodyList) {
						if (elseBody instanceof EObject) {
							bodyElements.add(evaluate((EObject) elseBody, currentTiParent, currentTiReference));
						}
					}
				} else {
					bodyElements.add(evaluate(elseBodyO, currentTiParent, currentTiReference));
				}
			}
		}
		if (bodyElements.size() > 1) {
			throw new InterpreterException("IF/IFELSE body should not contain more than one element.");
		} if (bodyElements.size() == 1) {
			return bodyElements.get(0);
		} else {
			return null;
		}
	}

	/**
	 * TODO: Actually tiObject should be created from object language.
	 * Returning one is created from template language
	 */
	private EObject createObjectOfSameClass(EObject original) throws InterpreterException {
		return createObject(original.eClass());
	}

	private EObject createObject(EClass eClass) throws InterpreterException {
		EPackage ePackage = (EPackage) eClass.eContainer();
		EObject newInstance = ePackage.getEFactoryInstance().create(eClass);
		//System.out.println("createObject() created " + newInstance.getClass().getSimpleName());
		return newInstance;
	}

	public EObject getTemplateInstanceRoot() {
		return templateInstanceRoot;
	}
}

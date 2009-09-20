/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.codegen.composites.StringComposite;

/**
 * A utility class used by all generators.
 */
public class GeneratorUtil {

	public String createGetFeatureCall(GenClass genClass, GenFeature genFeature) {
		return "getEStructuralFeature(" + getFeatureConstant(genClass, genFeature) + ")";
	}

	public String getFeatureConstant(GenClass genClass, GenFeature genFeature) {
		GenPackage genPackage = genClass.getGenPackage();
		return genPackage.getQualifiedPackageInterfaceName() + "." + genClass.getFeatureID(genFeature);
	}

	public GenFeature findGenFeature(GenClass genClass, String name) {
		for (GenFeature genFeature : genClass.getAllGenFeatures()) {
			if (genFeature.getName().equals(name)) {
				return genFeature;
			}
		}
		return null;
	}

	public void addCodeToSetFeature(StringComposite sc,
			final GenClass genClass, final String featureConstant,
			final EStructuralFeature eFeature, String expressionToBeSet) {
		
		if (eFeature.getUpperBound() == 1) {
			if (Map.Entry.class.getName().equals(eFeature.getEType().getInstanceClassName())) {
				sc.add("addMapEntry(element, element.eClass().getEStructuralFeature("
								+ featureConstant
								+ "), "
								+ expressionToBeSet
								+ ");");
			} else {
				sc.add("element.eSet(element.eClass().getEStructuralFeature("
						+ featureConstant
						+ "), " + expressionToBeSet + ");");
			}
		} else {
			if (Map.Entry.class.getName().equals(eFeature.getEType().getInstanceClassName())) {
				sc.add("addMapEntry(element, element.eClass().getEStructuralFeature("
								+ featureConstant
								+ "), "
								+ expressionToBeSet
								+ ");");
			} else {
				sc.add("addObjectToList(element, "
						+ featureConstant
						+ ", " + expressionToBeSet + ");");
			}
		}
	}

	public void addAddMapEntryMethod(StringComposite sc, String qualifiedDummyEObjectClassName, ClassNameHelper classNameHelper) {
		sc.add("protected void addMapEntry(" + E_OBJECT + " element, " + E_STRUCTURAL_FEATURE + " structuralFeature, " + qualifiedDummyEObjectClassName + " dummy) {");
		sc.add(OBJECT + " value = element.eGet(structuralFeature);");
		sc.add(OBJECT + " mapKey = dummy.getValueByName(\"key\");");
		sc.add(OBJECT + " mapValue = dummy.getValueByName(\"value\");");
		sc.add("if (value instanceof " + E_MAP + "<?, ?>) {");
		sc.add(E_MAP + "<" + OBJECT + ", " + OBJECT + "> valueMap = " + classNameHelper.getMAP_UTIL() + ".castToEMap(value);");
		sc.add("if (mapKey != null && mapValue != null) {");
		sc.add("valueMap.put(mapKey, mapValue);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	public void addAddObjectToListMethod(StringComposite sc) {
		//sc.add("@SuppressWarnings(\"unchecked\")");
        sc.add("private boolean addObjectToList(" + E_OBJECT + " element, int featureID, " + OBJECT + " proxy) {");
        sc.add("return ((" + LIST + "<" + OBJECT + ">) element.eGet(element.eClass().getEStructuralFeature(featureID))).add(proxy);");
        sc.add("}");
        sc.addLineBreak();
	}

	public void addGetFreshTokenResolveResultMethod(StringComposite sc, String qualifiedTokenResolveResultClassName) {
		sc.add("private " + qualifiedTokenResolveResultClassName + " getFreshTokenResolveResult() {");
        sc.add("tokenResolveResult.clear();");
        sc.add("return tokenResolveResult;");
        sc.add("}");
        sc.addLineBreak();
	}

	public void addRegisterContextDependentProxyMethod(StringComposite sc, String qualifiedContextDependentURIFragmentFactoryClassName, boolean addTypeParameters, ClassNameHelper classNameHelper) {
		String typeParameters = "";
		if (addTypeParameters) {
			typeParameters = "<ContainerType extends " + E_OBJECT + ", ReferenceType extends " + E_OBJECT + "> ";
		}
		sc.add("protected " + typeParameters + "void registerContextDependentProxy(final " + qualifiedContextDependentURIFragmentFactoryClassName + "<ContainerType, ReferenceType> factory, final " + "ContainerType element, final " + E_REFERENCE + " reference, final String id, final " + E_OBJECT
				+ " proxy) {");

		sc.add("postParseCommands.add(new " + classNameHelper.getI_COMMAND() + "<" + classNameHelper.getI_TEXT_RESOURCE() + ">() {");
		sc.add("public boolean execute(" + classNameHelper.getI_TEXT_RESOURCE() + " resource) {");
		sc.add("if (resource == null) {");
		sc.add("// the resource can be null if the parser is used for");
		sc.add("// code completion");
		sc.add("return true;");
		sc.add("}");
		sc.add("resource.registerContextDependentProxy(factory, element, reference, id, proxy);");
		sc.add("return true;");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}

	public void addGetReferenceResolverSwitchMethod(GenerationContext context, StringComposite sc) {
		final String qualifiedReferenceResolverSwitchClassName = context.getQualifiedClassName(EArtifact.REFERENCE_RESOLVER_SWITCH);
		sc.add("protected " + qualifiedReferenceResolverSwitchClassName + " getReferenceResolverSwitch() {");
        sc.add("return (" + qualifiedReferenceResolverSwitchClassName + ") getMetaInformation().getReferenceResolverSwitch();");
        sc.add("}");
        sc.addLineBreak();
	}

	public void addAddErrorToResourceMethod(StringComposite sc, ClassNameHelper classNameHelper) {
		sc.add("protected void addErrorToResource(final " + STRING + " errorMessage, final int line, final int charPositionInLine, final int startIndex, final int stopIndex) {");

		sc.add("postParseCommands.add(new " + classNameHelper.getI_COMMAND() + "<" + classNameHelper.getI_TEXT_RESOURCE() + ">() {");
		sc.add("public boolean execute(" + classNameHelper.getI_TEXT_RESOURCE() + " resource) {");
		sc.add("if (resource == null) {");
		sc.add("// the resource can be null if the parser is used for");
		sc.add("// code completion");
		sc.add("return true;");
		sc.add("}");
		sc.add("resource.addProblem(new " + classNameHelper.getI_PROBLEM() + "() {");
		sc.add("public " + classNameHelper.getE_PROBLEM_TYPE() + " getType() {");
		sc.add("return " + classNameHelper.getE_PROBLEM_TYPE() + ".ERROR;");
		sc.add("}");
		sc.add("public " + STRING + " getMessage() {");
		sc.add("return errorMessage;");
		sc.add("}");
		sc.add("}, line, charPositionInLine, startIndex, stopIndex);");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.add(");");
		sc.add("}");
		sc.addLineBreak();
	}

	public void addSetOptionsMethod(StringComposite sc, String body) {
		sc.add("public void setOptions(" + MAP + "<?,?> options) {");
		sc.add(body);
		sc.add("}");
	    sc.addLineBreak();
	}
}

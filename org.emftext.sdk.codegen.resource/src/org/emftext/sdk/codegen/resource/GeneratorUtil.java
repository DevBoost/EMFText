/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.resource;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ADAPTER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.STRING;

import java.io.File;
import java.util.Collection;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.Constants;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.antlr.ANTLRPluginArtifacts;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * A utility class used by all generators.
 */
public class GeneratorUtil {
	
	private static final String RESOURCE_PLUGIN_SUFFIX = ".resource.";
	private static final String RESOURCE_UI_PLUGIN_SUFFIX = "." + Constants.UI_PACKAGE;
	
	private ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();

	public String createGetFeatureCall(GenClass genClass, GenFeature genFeature) {
		return "getEStructuralFeature(" + getFeatureConstant(genClass, genFeature) + ")";
	}

	public String getFeatureConstant(GenClass genClass, GenFeature genFeature) {
		GenPackage genPackage = genClass.getGenPackage();
		return genPackage.getQualifiedPackageInterfaceName() + "." + genClass.getFeatureID(genFeature);
	}

	public String getFeatureAccessor(GenClass genClass, GenFeature genFeature) {
		return getClassAccessor(genClass) + "." + createGetFeatureCall(genClass, genFeature);
	}

	public String getClassAccessor(GenClass genClass) {
		return genClass.getGenPackage().getReflectionPackageName() + "."
								+ genClass.getGenPackage().getPackageInterfaceName()
								+ ".eINSTANCE.get" + genClass.getClassifierAccessorName()
								+ "()";
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
			GenClass genClass, String featureConstant,
			EStructuralFeature eFeature, String expressionToBeSet, boolean isContainment) {
		
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
		sc.add("completedElement(" + expressionToBeSet + ", " + isContainment + ");");
	}

	public void addAddMapEntryMethod(StringComposite sc, String qualifiedDummyEObjectClassName, GenerationContext context) {
		String mapUtil = context.getQualifiedClassName(TextResourceArtifacts.MAP_UTIL);

		sc.add("protected void addMapEntry(" + E_OBJECT + " element, " + E_STRUCTURAL_FEATURE + " structuralFeature, " + qualifiedDummyEObjectClassName + " dummy) {");
		sc.add(OBJECT + " value = element.eGet(structuralFeature);");
		sc.add(OBJECT + " mapKey = dummy.getValueByName(\"key\");");
		sc.add(OBJECT + " mapValue = dummy.getValueByName(\"value\");");
		sc.add("if (value instanceof " + E_MAP + "<?, ?>) {");
		sc.add(E_MAP + "<" + OBJECT + ", " + OBJECT + "> valueMap = " + mapUtil  + ".castToEMap(value);");
		sc.add("if (mapKey != null && mapValue != null) {");
		sc.add("valueMap.put(mapKey, mapValue);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	public void addAddObjectToListMethod(StringComposite sc) {
		sc.add("@SuppressWarnings(\"unchecked\")");
		sc.addLineBreak();
        sc.add("public boolean addObjectToList(" + E_OBJECT + " element, int featureID, " + OBJECT + " proxy) {");
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

	public void addRegisterContextDependentProxyMethod(JavaComposite sc, String qualifiedContextDependentURIFragmentFactoryClassName, boolean addTypeParameters, GenerationContext context) {
		String iCommand = context.getQualifiedClassName(TextResourceArtifacts.I_COMMAND);
		String iTextResource = context.getQualifiedClassName(TextResourceArtifacts.I_TEXT_RESOURCE);

		String typeParameters = "";
		if (addTypeParameters) {
			typeParameters = "<ContainerType extends " + E_OBJECT + ", ReferenceType extends " + E_OBJECT + "> ";
		}
		sc.add("protected " + typeParameters + "void registerContextDependentProxy(final " + qualifiedContextDependentURIFragmentFactoryClassName + "<ContainerType, ReferenceType> factory, final " + "ContainerType element, final " + E_REFERENCE + " reference, final String id, final " + E_OBJECT
				+ " proxy) {");

		sc.add("postParseCommands.add(new " + iCommand + "<" + iTextResource + ">() {");
		sc.add("public boolean execute(" + iTextResource + " resource) {");
		sc.add("if (resource == null) {");
		sc.addComment("the resource can be null if the parser is used for code completion");
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
		final String qualifiedReferenceResolverSwitchClassName = context.getQualifiedClassName(TextResourceArtifacts.REFERENCE_RESOLVER_SWITCH);
		sc.add("protected " + qualifiedReferenceResolverSwitchClassName + " getReferenceResolverSwitch() {");
        sc.add("return (" + qualifiedReferenceResolverSwitchClassName + ") getMetaInformation().getReferenceResolverSwitch();");
        sc.add("}");
        sc.addLineBreak();
	}

	public void addAddErrorToResourceMethod(JavaComposite sc, GenerationContext context) {
		String iCommand = context.getQualifiedClassName(TextResourceArtifacts.I_COMMAND);
		String iTextResource = context.getQualifiedClassName(TextResourceArtifacts.I_TEXT_RESOURCE);
		String iProblem = context.getQualifiedClassName(TextResourceArtifacts.I_PROBLEM);
		String eProblemType = context.getQualifiedClassName(TextResourceArtifacts.E_PROBLEM_TYPE);

		sc.add("protected void addErrorToResource(final " + STRING + " errorMessage, final int line, final int charPositionInLine, final int startIndex, final int stopIndex) {");

		sc.add("postParseCommands.add(new " + iCommand + "<" + iTextResource + ">() {");
		sc.add("public boolean execute(" + iTextResource + " resource) {");
		sc.add("if (resource == null) {");
		sc.addComment("the resource can be null if the parser is used for code completion");
		sc.add("return true;");
		sc.add("}");
		sc.add("resource.addProblem(new " + iProblem + "() {");
		sc.add("public " + eProblemType + " getType() {");
		sc.add("return " + eProblemType + ".ERROR;");
		sc.add("}");
		sc.add("public " + STRING + " getMessage() {");
		sc.add("return errorMessage;");
		sc.add("}");
		sc.add("}, line, charPositionInLine, startIndex, stopIndex);");
		sc.add("return true;");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}

	public void addSetOptionsMethod(StringComposite sc, String body) {
		sc.add("public void setOptions(" + MAP + "<?,?> options) {");
		sc.add(body);
		sc.add("}");
	    sc.addLineBreak();
	}

	public void addGetLayoutAdapterMethod(StringComposite sc, String layoutInformationAdapterClassName) {
		sc.add("protected " + layoutInformationAdapterClassName + " getLayoutInformationAdapter(" + E_OBJECT + " element) {");
		sc.add("for (" + ADAPTER + " adapter : element.eAdapters()) {");
		sc.add("if (adapter instanceof " + layoutInformationAdapterClassName + ") {");
		sc.add("return (" + layoutInformationAdapterClassName + ") adapter;");
		sc.add("}");
		sc.add("}");
		sc.add(layoutInformationAdapterClassName + " newAdapter = new " + layoutInformationAdapterClassName + "();");
		sc.add("element.eAdapters().add(newAdapter);");
		sc.add("return newAdapter;");
		sc.add("}");
		sc.addLineBreak();
	}

	public File getResolverFile(ConcreteSyntax syntax, GenFeature proxyReference, String projectFolder) {
		OptionTypes overrideOption = OptionTypes.OVERRIDE_REFERENCE_RESOLVERS;
		boolean doOverride = overrideOption == null || OptionManager.INSTANCE.getBooleanOptionValue(syntax, overrideOption);
		File resolverFile = new File(csUtil.getSourceFolder(syntax, doOverride, projectFolder) + File.separator + getResolverPackagePath(syntax) + File.separator + csUtil.getReferenceResolverClassName(proxyReference) + Constants.JAVA_FILE_EXTENSION);
		return resolverFile;
	}

	public File getResolverPackageFile(ConcreteSyntax syntax, boolean doOverride, String pluginProjectFolder) {
		return new File(csUtil.getSourceFolder(syntax, doOverride, pluginProjectFolder).getAbsolutePath() + File.separator + getResolverPackagePath(syntax));
	}

	public IPath getResolverPackagePath(ConcreteSyntax syntax) {
		return new Path(getResolverPackageName(syntax).replaceAll("\\.","/"));
	}

	/**
	 * Returns the name of the package where token and reference resolvers 
	 * must go to depending on the given syntax.
	 */
	public String getResolverPackageName(ConcreteSyntax syntax) {
		String csPackageName = getPackageName(syntax, Constants.ANALYSIS_PACKAGE);
		return (csPackageName == null || csPackageName.equals("") ? "" : csPackageName);
	}

	public String getPackageName(ArtifactDescriptor<?, ?> artifact, ConcreteSyntax syntax) {
		return getPackageName(syntax, artifact);
	}

	public String getPackageName(ConcreteSyntax syntax, ArtifactDescriptor<?, ?> artifact) {
		return getPackageName(syntax, artifact.getPackage());
	}
	
	public IPluginDescriptor getResourcePluginDescriptor(ConcreteSyntax syntax) {
		final String pluginName = getPluginName(syntax, OptionTypes.RESOURCE_PLUGIN_ID, RESOURCE_PLUGIN_SUFFIX, "", OptionTypes.BASE_PACKAGE);
		
		IPluginDescriptor resourcePlugin = new IPluginDescriptor() {

			public String getName() {
				return pluginName;
			}
		};
		return resourcePlugin;
	}

	public IPluginDescriptor getResourceUIPluginDescriptor(ConcreteSyntax syntax) {
		final String pluginName = getPluginName(syntax, OptionTypes.RESOURCE_UI_PLUGIN_ID, RESOURCE_PLUGIN_SUFFIX, RESOURCE_UI_PLUGIN_SUFFIX, OptionTypes.UI_BASE_PACKAGE);
		IPluginDescriptor resourcePlugin = new IPluginDescriptor() {

			public String getName() {
				return pluginName;
			}
		};
		return resourcePlugin;
	}

	public String getPackageName(ConcreteSyntax syntax, String packageSuffix) {
		/*
		if (plugin == null) {
			// this is the case for artifacts that are generated for
			// multiple plug-ins
			return null;
		}
		*/
		String basePackage = getBasePackage(syntax, RESOURCE_PLUGIN_SUFFIX, "", OptionTypes.BASE_PACKAGE);
		if (basePackage == null || "".equals(basePackage)) {
			return packageSuffix;
		} else {
			if ("".equals(packageSuffix)) {
				return basePackage;
			} else {
				return basePackage + "." + packageSuffix;
			}
		}
	}

	public String getBasePackage(ConcreteSyntax syntax, String suffix, String prefix, OptionTypes basePackageOption) {
		String basePackage = OptionManager.INSTANCE.getStringOptionValue(syntax, basePackageOption);
		if (basePackage != null) {
			// use package name from option
			return basePackage;
		} else {
			String packageName = "";
			// use default package name
			GenPackage concreteSyntaxPackage = syntax.getPackage();
			boolean hasBasePackage = concreteSyntaxPackage.getBasePackage() != null;
			if (hasBasePackage) {
				packageName = concreteSyntaxPackage.getBasePackage() + ".";
			}
			packageName += concreteSyntaxPackage.getEcorePackage().getName();
			packageName += suffix + syntax.getName() + prefix;
			return packageName;
		}
	}


	public String getPluginName(ConcreteSyntax syntax, OptionTypes pluginIDOption, String suffix, String prefix, OptionTypes basePackageOption) {
		String pluginID = OptionManager.INSTANCE.getStringOptionValue(syntax, pluginIDOption);
		if (pluginID != null) {
			// use package plug-in from option
			return pluginID;
		} else {
			// use default plug-in name
			return getBasePackage(syntax, suffix, prefix, basePackageOption);
		}
	}

	public void addImports(GenerationContext context, Collection<String> requiredBundles, ConcreteSyntax syntax) {
		// first add the syntax itself
		String syntaxPluginID = context.getResourcePlugin().getName();
		requiredBundles.add(syntaxPluginID);
		String antlrPluginID = ANTLRPluginArtifacts.ANTLR_PLUGIN.getName();
		requiredBundles.add(antlrPluginID);
		
		// second add the main generator package
		GenPackage mainPackage = syntax.getPackage();
		addImports(requiredBundles, mainPackage);
		
		// third add imported generator packages and syntaxes recursively
		for (Import nextImport : syntax.getImports()) {
			GenPackage importedPackage = nextImport.getPackage();
			addImports(requiredBundles, importedPackage);

			ConcreteSyntax importedSyntax = nextImport.getConcreteSyntax();
			if (importedSyntax != null) {
				addImports(context, requiredBundles, importedSyntax);
			}
		}
	}

	/**
	 * Adds imports for the given generator package and all used
	 * generator packages.
	 * 
	 * @param requiredBundles
	 * @param genPackage
	 * @return
	 */
	private GenModel addImports(Collection<String> requiredBundles, GenPackage genPackage) {
		// add the package itself
		addImport(requiredBundles, genPackage);
		
		// add used generator packages
		GenModel genModel = genPackage.getGenModel();
		for (GenPackage usedGenPackage : genModel.getUsedGenPackages()) {
			addImport(requiredBundles, usedGenPackage);
		}
		return genModel;
	}

	/**
	 * Adds one import for the given generator package.
	 * 
	 * @param requiredBundles
	 * @param genPackage
	 * @return
	 */
	private void addImport(Collection<String> requiredBundles, GenPackage genPackage) {
		GenModel genModel = genPackage.getGenModel();
		String modelPluginID = genModel.getModelPluginID();
		requiredBundles.add(modelPluginID);
	}
}

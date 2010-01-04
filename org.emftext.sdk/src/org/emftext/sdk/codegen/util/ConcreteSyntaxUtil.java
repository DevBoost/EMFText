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
package org.emftext.sdk.codegen.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.sdk.Constants;
import org.emftext.sdk.EPlugins;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.PLUS;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.STAR;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.finders.GenClassFinder;
import org.emftext.sdk.util.EClassUtil;
import org.emftext.sdk.util.EObjectUtil;
import org.emftext.sdk.util.StringUtil;

/**
 * A utility class that provides methods used by the code generators
 * to analyse CS specifications.
 */
public class ConcreteSyntaxUtil {

	private final EClassUtil eClassUtil = new EClassUtil();
	private final GenClassUtil genClassUtil = new GenClassUtil();
	private final GenClassCache genClassCache = new GenClassCache();
	private final GenClassFinder genClassFinder = new GenClassFinder();

	public boolean isAbstract(ConcreteSyntax concreteSyntax) {
		if (concreteSyntax.getModifier() != null) {
			return true;
		}
		return false;
	}

	public boolean isImportedToken(ConcreteSyntax syntax, TokenDefinition tokenDefinition) {
		return !syntax.equals(getContainingSyntax(syntax, tokenDefinition));
	}

	public ConcreteSyntax getContainingSyntax(ConcreteSyntax syntax, TokenDefinition baseDefinition) {
		EObject container = baseDefinition.eContainer();
		if (container instanceof ConcreteSyntax) {
			return (ConcreteSyntax) container;
		}
		return syntax;
	}

	/**
	 * Returns true if the given rule was defined in the given syntax.
	 * If the rule is defined in an imported syntax, this method returns
	 * false.
	 * 
	 * @param syntax the syntax that refers to the rule
	 * @param rule the rule to check
	 * @return true if the rule is contained, false if it is imported
	 */
	public boolean isImportedRule(ConcreteSyntax syntax, Rule rule) {
		return rule.getSyntax() != syntax;
	}

	public boolean hasMinimalCardinalityOneOrHigher(Definition definition) {
		if (definition instanceof CardinalityDefinition) {
			CardinalityDefinition cd = (CardinalityDefinition) definition;
			return (cd.getCardinality() == null || cd.getCardinality() instanceof PLUS);
		} else {
			return true;
		}
	}

	public boolean hasNoOptionalPart(Definition definition) {
		if (definition instanceof CardinalityDefinition) {
			CardinalityDefinition cd = (CardinalityDefinition) definition;
			return !
				(cd.getCardinality() instanceof QUESTIONMARK ||
				 cd.getCardinality() instanceof STAR);
		} else {
			return false;
		}
	}
	
	/**
	 * Collects all the subclasses for which concrete syntax is defined.
	 */
	public Collection<GenClass> getSubClassesWithSyntax(GenClass genClass,
			ConcreteSyntax syntax) {
		Collection<GenClass> subClasses = new LinkedList<GenClass>();

		EClass ecoreClass = genClass.getEcoreClass();
		for (GenClass subClassCand : getClassesWithSyntax(syntax)) {
			if (eClassUtil.isSubClass(subClassCand.getEcoreClass(), ecoreClass)) {
				subClasses.add(subClassCand);
			}
		}
		return subClasses;
	}

	public boolean hasSyntax(GenClass genClass,
			ConcreteSyntax syntax) {

		return genClassUtil.contains(getClassesWithSyntax(syntax), genClass);
	}

	/**
	 * Collects all the subclasses for which concrete syntax is defined.
	 */
	public Collection<GenClass> getClassesWithSyntax(ConcreteSyntax syntax) {
		Collection<Rule> rules = syntax.getAllRules();
		Collection<GenClass> foundGenClasses = new LinkedList<GenClass>();

		for (Rule rule : rules) {
			GenClass subClassCand = rule.getMetaclass();
			foundGenClasses.add(subClassCand);
		}
		return foundGenClasses;
	}

	/**
	 * Checks whether a subclass with concrete syntax does exist.
	 */
	public boolean hasSubClassesWithCS(GenClass genClass,
			Collection<Rule> source) {
		for (Rule rule : source) {
			GenClass subClassCand = rule.getMetaclass();
			for (EClass superClass : subClassCand.getEcoreClass()
					.getEAllSuperTypes()) {
				EClass ecoreClass = genClass.getEcoreClass();
				if (eClassUtil.namesAndPackageURIsAreEqual(superClass, ecoreClass)) {
					return true;
				}
			}
		}
		return false;

	}

	/**
	 * Checks whether the given syntax contains rules for the given
	 * GenClass or a sub type of it. If such rules are found, all
	 * of them are returned.
	 * 
	 * @param concreteSyntax the syntax to search for rules in
	 * @param genClass the class to search for
	 * 
	 * @return a set of rules that reference 'genClass' or a sub type
	 */
	public Collection<Rule> getRules(ConcreteSyntax concreteSyntax, GenClass genClass) {
		Collection<Rule> foundRules = new ArrayList<Rule>();
		for (Rule rule : concreteSyntax.getAllRules()) {
			GenClass metaclass = rule.getMetaclass();
			if (genClassCache.getQualifiedInterfaceName(metaclass).equals(genClassCache.getQualifiedInterfaceName(genClass))) {
				foundRules.add(rule);
			}
			if (genClassUtil.contains(metaclass.getAllBaseGenClasses(), genClass)) {
				foundRules.add(rule);
			}
		}
		return foundRules;
	}

	/**
	 * Returns a collection that contains the names of all resolver
	 * classes (both token and reference resolvers) that are needed.
	 * Each resolver that is not part of an imported plug-in should 
	 * be added to this list. 
	 * 
	 * @return the collection of already generated resolver classes
	 */
	public Collection<String> getResolverFileNames(ConcreteSyntax syntax) {
		Collection<String> resolverFileNames = getReferenceResolverFileNames(syntax);
		resolverFileNames.addAll(getTokenResolverFileNames(syntax));
		return resolverFileNames;
	}

	/**
	 * Returns a list that contains the names of all resolver classes that are needed.
	 * Some of them might be generated during the generation process, others
	 * may already exist. This list does not contain resolver classes that are
	 * contained in imported syntaxes and that are reused.
	 */
	public Collection<String> getReferenceResolverFileNames(ConcreteSyntax syntax) {
		Collection<GenFeature> features = getNonContainmentFeaturesNeedingResolver(syntax);
		Collection<String> resolverFileNames = new LinkedHashSet<String>(features.size());
		for (GenFeature feature : features) {
			resolverFileNames.add(getReferenceResolverClassName(feature) + Constants.JAVA_FILE_EXTENSION);
		}
		return resolverFileNames;
	}

	public Collection<String> getTokenResolverFileNames(ConcreteSyntax syntax) {
		Collection<String> resolverFileNames = new LinkedHashSet<String>();
		
		for (TokenDefinition tokenDefinition : syntax.getActiveTokens()) {
			if (!tokenDefinition.isUsed()) {
				continue;
			}
			// do not generate a resolver for imported tokens
			if (isImportedToken(syntax, tokenDefinition)) {
				continue;
			}
			resolverFileNames.add(getTokenResolverClassName(syntax, tokenDefinition) + Constants.JAVA_FILE_EXTENSION);
		}
		return resolverFileNames;
	}

	public Collection<GenFeature> getNonContainmentFeaturesNeedingResolver(ConcreteSyntax syntax) {
		Collection<GenFeature> features = new LinkedHashSet<GenFeature>();
		Collection<Rule> allRules = syntax.getAllRules();
		for (Rule rule : allRules) {
			Collection<Placeholder> placeholders = EObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getPlaceholder());
			for (Placeholder placeholder : placeholders) {
				features.add(placeholder.getFeature());
			}
		}
		return features;
	}

	public String getReferenceResolverClassName(GenFeature proxyReference) {
		return proxyReference.getGenClass().getName() + StringUtil.capitalize(proxyReference.getName()) + Constants.CLASS_SUFFIX_REFERENCE_RESOLVER;
	}

	public String getTokenResolverClassName(ConcreteSyntax syntax, TokenDefinition tokenDefinition) {

		String syntaxName = getCapitalizedConcreteSyntaxName(getContainingSyntax(syntax, tokenDefinition));
		boolean isCollect = tokenDefinition.getAttributeName() != null;
		if (isCollect) {
			String attributeName = tokenDefinition.getAttributeName();
			return syntaxName +  "COLLECT_" + attributeName + Constants.CLASS_SUFFIX_TOKEN_RESOLVER;
		} else {
			return syntaxName +  tokenDefinition.getName() + Constants.CLASS_SUFFIX_TOKEN_RESOLVER;
		}
	}

	public String getCapitalizedConcreteSyntaxName(ConcreteSyntax syntax) {
		String csName = "";
		String[] csNameParts = syntax.getName().split("\\.");
		for(String part : csNameParts) {
			csName = csName + StringUtil.capitalize(part);
		}
		return csName;
	}


	public String getDefaultResolverDelegateName(ConcreteSyntax syntax) {
		return getCapitalizedConcreteSyntaxName(syntax) + Constants.CLASS_SUFFIX_DEFAULT_RESOLVER_DELEFATE;
	}

	public String getPackageName(ConcreteSyntax syntax, EPlugins plugin, String packageSuffix) {
		if (plugin == null) {
			// this is the case for artifacts that are generated for
			// multiple plug-ins
			return null;
		}
		String basePackage = plugin.getBasePackage(syntax);
		if ("".equals(basePackage)) {
			return packageSuffix;
		} else {
			if ("".equals(packageSuffix)) {
				return basePackage;
			} else {
				return basePackage + "." + packageSuffix;
			}
		}
	}

	// feature may be contained in imported rules and thus belong to a different
	// CS specification
	public ConcreteSyntax getConcreteSyntax(ConcreteSyntax syntax, GenFeature genFeature) {
		for (Import nextImport : syntax.getImports()) {
			ConcreteSyntax nextSyntax = nextImport.getConcreteSyntax();
			if (nextSyntax == null) {
				continue;
			}
			if (genClassFinder.contains(genClassFinder.findAllGenClasses(nextSyntax, true, true), genFeature.getGenClass())) {
				ConcreteSyntax cs = genClassFinder.getContainingSyntax(nextSyntax, genFeature.getGenClass());
				return cs;
			}
		}
		return syntax;
	}

	/**
	 * Returns the name of the package where token and reference resolvers 
	 * must go to depending on the given syntax.
	 */
	public String getResolverPackageName(ConcreteSyntax syntax) {
		String csPackageName = getPackageName(syntax, EPlugins.RESOURCE_PLUGIN, Constants.ANALYSIS_PACKAGE);
		return (csPackageName == null || csPackageName.equals("") ? "" : csPackageName);
	}

	/**
	 * Returns the name of the package where token and reference resolvers 
	 * must go to. Depending on the given generator feature this package
	 * might be part of a resource plug-in that belongs to an imported
	 * syntax.
	 */
	public String getResolverPackageName(ConcreteSyntax syntax, GenFeature genFeature, boolean inImportedSyntax) {
		if (inImportedSyntax) {
			syntax = getConcreteSyntax(syntax, genFeature);
		}
		return getResolverPackageName(syntax);
	}

	public IPath getResolverPackagePath(ConcreteSyntax syntax) {
		return new Path(getResolverPackageName(syntax).replaceAll("\\.","/"));
	}

	public File getResolverPackageFile(ConcreteSyntax syntax, boolean doOverride, String pluginProjectFolder) {
		return new File(getSourceFolder(syntax, doOverride, pluginProjectFolder).getAbsolutePath() + File.separator + getResolverPackagePath(syntax));
	}

	public File getSourceFolder(ConcreteSyntax syntax, boolean doOverride, String pluginProjectFolder) {
		String srcFolderName = getSourceFolderName(syntax, OptionTypes.SOURCE_FOLDER);
		String srcGenFolderName = getSourceFolderName(syntax, OptionTypes.SOURCE_GEN_FOLDER);
		if (doOverride) {
			return new File(pluginProjectFolder + File.separator + srcGenFolderName);
		} else {
			return new File(pluginProjectFolder + File.separator + srcFolderName);
		}
	}

	public String getSourceFolderName(ConcreteSyntax syntax, OptionTypes option) {
		String defaultValue;
		if (option == OptionTypes.SOURCE_FOLDER) {
			defaultValue = "src";
		} else if (option == OptionTypes.SOURCE_GEN_FOLDER) {
			defaultValue = "src-gen";
		} else {
			throw new RuntimeException("Illegal option: " + option);
		}
		return getSourceFolderName(syntax, option, defaultValue);
	}
	
	private String getSourceFolderName(ConcreteSyntax syntax, OptionTypes option, String defaultValue) {
		String folderName;
		String folderOptionValue = OptionManager.INSTANCE.getStringOptionValue(syntax, option);
		if (folderOptionValue != null) {
			// use package plug-in from option
			folderName = folderOptionValue;
		} else {
			// use default plug-in name
			folderName = defaultValue;
		}
		return folderName;
	}

	public String computeCardinalityString(Definition definition) {
		Cardinality cardinality = null;
		if (definition instanceof CardinalityDefinition) {
			cardinality = ((CardinalityDefinition) definition).getCardinality();
		}
		if (cardinality == null) {
			return "";
		} else if (cardinality instanceof PLUS) {
			return "+";
		} else if (cardinality instanceof QUESTIONMARK) {
			return "?";
		} else {
			return "*";
		}
	}

	public String getScopeID(EObject object) {
		String scopeID = null;
		
		EObject container = object.eContainer();
		while (container != null) {
			EReference reference = object.eContainmentFeature();
			final Object referenceValue = container.eGet(reference);
			int index = 1;
			if (referenceValue instanceof List<?>) {
				List<?> referenceList = (List<?>) referenceValue;
				index = referenceList.indexOf(object) + 1;
			}
			String prefix = "_";
			if (object instanceof Sequence) {
				prefix = "s";
			}
			if (object instanceof Choice) {
				prefix = "c";
			}
			if (object instanceof Rule) {
				prefix = "r";
			}
			if (object instanceof CsString) {
				prefix = "C";
			}
			if (object instanceof Terminal) {
				prefix = "T";
			}
			if (scopeID == null) {
				scopeID = index + prefix;
			} else {
				scopeID = index + prefix + "." + scopeID;
			}
			object = container;
			container = object.eContainer();
		}
		return scopeID;
	}

	public Rule findContainingRule(EObject syntaxElement) {
		if (syntaxElement == null) {
			return null;
		}
		if (syntaxElement instanceof Rule) {
			return (Rule) syntaxElement;
		}
		return findContainingRule(syntaxElement.eContainer());
	}

	public CsString findKeyword(ConcreteSyntax syntax, String keyword) {
		Collection<CsString> keywords = EObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getCsString());
		for (CsString nextKeyword : keywords) {
			if (keyword.equals(nextKeyword.getValue())) {
				return nextKeyword;
			}
		}
		return null;
	}

	// TODO add check for meta class name
	public List<CompoundDefinition> findCompounds(ConcreteSyntax syntax, String metaClassName) {
		Collection<CompoundDefinition> compounds = EObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition());
		return new ArrayList<CompoundDefinition>(compounds);
	}

	public List<Terminal> findTerminals(ConcreteSyntax syntax) {
		Collection<Terminal> terminals = EObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getTerminal());
		return new ArrayList<Terminal>(terminals);
	}

	public EList<GenClass> getAllowedSubTypes(Containment containment) {
		EList<GenClass> types;
		// is there an explicit type defined?
		if (!containment.getTypes().isEmpty()) {
			types = containment.getTypes();
		} else {
			types = new BasicEList<GenClass>();
			types.add(containment.getFeature().getTypeGenClass());
		}
		return types;
	}

	public List<Containment> findContainments(ConcreteSyntax syntax) {
		Collection<Containment> containments = EObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getContainment());
		return new ArrayList<Containment>(containments);
	}
}

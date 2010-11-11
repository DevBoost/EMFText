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
package org.emftext.sdk.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.emftext.sdk.OptionManager;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.BooleanTerminal;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.EClassUtil;
import org.emftext.sdk.concretesyntax.EnumTerminal;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.OperatorAnnotationProperty;
import org.emftext.sdk.concretesyntax.OperatorAnnotationType;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.SyntaxElement;
import org.emftext.sdk.concretesyntax.WhiteSpaces;
import org.emftext.sdk.finders.GenClassFinder;

/**
 * A utility class that provides methods used by the code generators
 * to analyze CS specifications.
 */
public class ConcreteSyntaxUtil {

	/**
	 * This feature is connected to all placeholders that are anonymous (denoted
	 * by the name '_').
	 */
	public final static GenFeature ANONYMOUS_GEN_FEATURE = GenModelFactory.eINSTANCE.createGenFeature();
	private final static EAttribute ANONYMOUS_EATTRIBUTE = EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_EATTRIBUTE.setName("_");
		ANONYMOUS_GEN_FEATURE.setEcoreFeature(ANONYMOUS_EATTRIBUTE);
	}
	
	private final GenClassUtil genClassUtil = new GenClassUtil();
	private final GenClassFinder genClassFinder = new GenClassFinder();

	public boolean hasSyntax(GenClass genClass,
			ConcreteSyntax syntax, boolean excludeOperatorRules) {

		return genClassUtil.contains(syntax.getClassesWithSyntax(excludeOperatorRules), genClass, syntax.getGenClassCache());
	}

	/**
	 * Checks whether a subclass with concrete syntax does exist.
	 */
	public boolean hasSubClassesWithCS(GenClass genClass,
			Collection<Rule> rules) {
		for (Rule rule : rules) {
			EClassUtil eClassUtil = rule.getSyntax().getEClassUtil();
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
	// this should be moved to ConcreteSyntax.ejava, but since 'genClassUtil'
	// is not known there, it must stay here until this is resolved
	public Collection<Rule> getRules(ConcreteSyntax concreteSyntax, GenClass genClass) {
		GenClassCache genClassCache = concreteSyntax.getGenClassCache();
		Collection<Rule> foundRules = new ArrayList<Rule>();
		for (Rule rule : concreteSyntax.getAllRules()) {
			GenClass metaclass = rule.getMetaclass();
			if (genClassCache.getQualifiedInterfaceName(metaclass).equals(genClassCache.getQualifiedInterfaceName(genClass))) {
				foundRules.add(rule);
			}
			if (genClassUtil.contains(metaclass.getAllBaseGenClasses(), genClass, concreteSyntax.getGenClassCache())) {
				foundRules.add(rule);
			}
		}
		return foundRules;
	}

	/**
	 * Returns all non-containment references that are used in the given syntax and which
	 * need a reference resolver class. This excluded all anonymous features (denoted by
	 * an underscore as name in the syntax rule).
	 * 
	 * @param syntax the syntax containing references
	 * @return all non-containment references excluding anonymous features
	 */
	public Collection<GenFeature> getNonContainmentFeaturesNeedingResolver(ConcreteSyntax syntax) {
		Collection<GenFeature> features = new LinkedHashSet<GenFeature>();
		Collection<Rule> allRules = syntax.getAllRules();
		for (Rule rule : allRules) {
			Collection<Placeholder> placeholders = EObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getPlaceholder());
			for (Placeholder placeholder : placeholders) {
				GenFeature feature = placeholder.getFeature();
				EStructuralFeature ecoreFeature = feature.getEcoreFeature();
				// ignore attribute, only references must be collected
				if (ecoreFeature instanceof EAttribute) {
					continue;
				}
				// anonymous features do not need an resolver
				if (feature == ConcreteSyntaxUtil.ANONYMOUS_GEN_FEATURE) {
					continue;
				}
				features.add(feature);
			}
		}
		return features;
	}

	/**
	 * Searches in syntaxes imported by 'syntax' for occurrences of the
	 * given feature. Feature may be contained in imported rules and thus 
	 * belong to a different syntax specification.
	 * 
	 * @param syntax the syntax to search in
	 * @param genFeature the feature to search for
	 * @return the syntax containing the feature
	 */
	public ConcreteSyntax getConcreteSyntax(ConcreteSyntax syntax, GenFeature genFeature) {
		GenClassCache genClassCache = syntax.getGenClassCache();
		for (Import nextImport : syntax.getImports()) {
			ConcreteSyntax nextSyntax = nextImport.getConcreteSyntax();
			if (nextSyntax == null) {
				continue;
			}
			Set<GenClass> allGenClasses = genClassFinder.findAllGenClasses(nextSyntax, true, true);
			if (genClassUtil.contains(allGenClasses, genFeature.getGenClass(), genClassCache)) {
				ConcreteSyntax cs = genClassFinder.getContainingSyntax(nextSyntax, genFeature.getGenClass());
				return cs;
			}
		}
		return syntax;
	}

	/**
	 * Returns the source folder (either the one for generated source or 
	 * the one for custom code).
	 * 
	 * @param syntax
	 * @param doOverride
	 * @param pluginPath the absolute path to the plug-in that will contain the folder
	 * @return
	 */
	public File getSourceFolder(ConcreteSyntax syntax, boolean doOverride, boolean isUiPlugin, String pluginPath) {
		OptionTypes sourceFolderOption = isUiPlugin ? OptionTypes.UI_SOURCE_FOLDER : OptionTypes.SOURCE_FOLDER;
		OptionTypes sourceGenFolderOption = isUiPlugin ? OptionTypes.UI_SOURCE_GEN_FOLDER : OptionTypes.SOURCE_GEN_FOLDER;

		String srcFolderName = getSourceFolderName(syntax, sourceFolderOption);
		String srcGenFolderName = getSourceFolderName(syntax, sourceGenFolderOption);
		if (doOverride) {
			return new File(pluginPath + File.separator + srcGenFolderName);
		} else {
			return new File(pluginPath + File.separator + srcFolderName);
		}
	}

	/**
	 * Returns the name of a source folder (either the one for generated
	 * source or the one for custom code).
	 * 
	 * @param syntax
	 * @param option
	 * @return
	 */
	public String getSourceFolderName(ConcreteSyntax syntax, OptionTypes option) {
		String defaultValue;
		if (option == OptionTypes.SOURCE_FOLDER || option == OptionTypes.UI_SOURCE_FOLDER) {
			defaultValue = "src";
		} else if (option == OptionTypes.SOURCE_GEN_FOLDER || option == OptionTypes.UI_SOURCE_GEN_FOLDER) {
			defaultValue = "src-gen";
		} else {
			throw new IllegalArgumentException("Illegal option: " + option);
		}
		return OptionManager.INSTANCE.getStringOptionValue(syntax, option, defaultValue);
	}
	
	public OperatorAnnotationType getOperatorAnnotationType(Annotation annotation) {
		return OperatorAnnotationType.get(annotation.getValue(OperatorAnnotationProperty.TYPE.getLiteral()));
	}


	/**
	 * Checks whether the syntax rule tree that is rooted at 'element' produce
	 * the empty word.
	 * 
	 * @param element
	 * @param ignoreBooleanAndEnumTerminals
	 * @return
	 */
	public boolean canBeEmpty(SyntaxElement element, boolean ignoreBooleanAndEnumTerminals) {
		if (element instanceof LineBreak) {
			return true;
		}
		if (element instanceof WhiteSpaces) {
			return true;
		}
		if (element instanceof CsString) {
			return false;
		}
		if (element instanceof CardinalityDefinition) {
			CardinalityDefinition cd = (CardinalityDefinition) element;
			Cardinality cardinality = cd.getCardinality();
			boolean canBeEmpty = cardinality == Cardinality.STAR || cardinality == Cardinality.QUESTIONMARK;
			if (canBeEmpty) {
				return true;
			}
			if (!ignoreBooleanAndEnumTerminals) {
				if (element instanceof BooleanTerminal) {
					BooleanTerminal terminal = (BooleanTerminal) element;
					return terminal.containsEmptyLiteral();
				}
				if (element instanceof EnumTerminal) {
					EnumTerminal terminal = (EnumTerminal) element;
					return terminal.containsEmptyLiteral();
				}
			} else {
				return false;
			}
		}
		if (element instanceof CompoundDefinition) {
			CompoundDefinition compound = (CompoundDefinition) element;
			EList<SyntaxElement> children = compound.getChildren();
			boolean canBeEmpty = true;
			for (SyntaxElement child : children) {
				canBeEmpty &= canBeEmpty(child, ignoreBooleanAndEnumTerminals);
			}
			return canBeEmpty;
		}
		if (element instanceof Choice) {
			Choice choice = (Choice) element;
			EList<SyntaxElement> children = choice.getChildren();
			boolean canBeEmpty = true;
			for (SyntaxElement child : children) {
				// TODO mseifert: check how ANTLR behaves in this case
				canBeEmpty &= canBeEmpty(child, ignoreBooleanAndEnumTerminals);
			}
			return canBeEmpty;
		}
		if (element instanceof Sequence) {
			Sequence sequence = (Sequence) element;
			EList<SyntaxElement> children = sequence.getChildren();
			for (SyntaxElement child : children) {
				if (!canBeEmpty(child, ignoreBooleanAndEnumTerminals)) {
					return false;
				}
			}
			return true;
		}
		if (element instanceof Rule) {
			Rule rule = (Rule) element;
			EList<SyntaxElement> children = rule.getChildren();
			boolean canBeEmpty = true;
			for (SyntaxElement child : children) {
				canBeEmpty &= canBeEmpty(child, ignoreBooleanAndEnumTerminals);
			}
			return canBeEmpty;
		}
		throw new RuntimeException("Unknown syntax element found.");
	}

	public boolean isInEmptyCompound(SyntaxElement syntaxElement) {
		EObject parent = syntaxElement.eContainer();
		while (parent != null) {
			if (parent instanceof SyntaxElement) {
				SyntaxElement element = (SyntaxElement) parent;
				if (element instanceof CompoundDefinition && canBeEmpty(element, false)) {
					return true;
				}
			}
			parent = parent.eContainer();
		}
		return false;
	}
}

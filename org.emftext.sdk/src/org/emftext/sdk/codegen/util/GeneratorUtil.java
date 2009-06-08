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
package org.emftext.sdk.codegen.util;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClass;
import org.emftext.runtime.util.EClassUtil;
import org.emftext.runtime.util.EObjectUtil;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.PLUS;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.STAR;
import org.emftext.sdk.concretesyntax.TokenDefinition;

/**
 * A utility class used by all generators.
 */
public class GeneratorUtil {

	private final EClassUtil eClassUtil = new EClassUtil();
	private final NameUtil nameUtil = new NameUtil();
	private final ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();

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

	/**
	 * Checks whether the given syntax contains a rule for the given
	 * GenClass or a sub type of it. If such a rule is found, it is 
	 * returned.
	 * 
	 * @param concreteSyntax the syntax to search for rules in
	 * @param genClass the class to search for
	 * 
	 * @return a rule that references 'genClass' or a sub type, null if 
	 *         no rule is found.
	 */
	public Rule getRule(ConcreteSyntax concreteSyntax, GenClass genClass) {
		for (Rule rule : concreteSyntax.getAllRules()) {
			GenClass metaclass = rule.getMetaclass();
			if (metaclass.getQualifiedInterfaceName().equals(genClass.getQualifiedInterfaceName())) {
				return rule;
			}
			if (contains(metaclass.getAllBaseGenClasses(), genClass)) {
				return rule;
			}
		}
		return null;
	}

	private boolean contains(List<GenClass> genClasses,
			GenClass genClass) {
		for (GenClass next : genClasses) {
			if (next.getQualifiedInterfaceName().equals(genClass.getQualifiedInterfaceName())) {
				return true;
			}
		}
		return false;
	}

	public Collection<GenFeature> getNonContainmentFeaturesNeedingResolver(ConcreteSyntax syntax) {
		Collection<Placeholder> placeholders = EObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getPlaceholder());
		Collection<GenFeature> features = new LinkedHashSet<GenFeature>(placeholders.size());
		for (Placeholder placeholder : placeholders) {
			features.add(placeholder.getFeature());
		}
		return features;
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
			resolverFileNames.add(nameUtil.getReferenceResolverClassName(feature) + GenerationContext.JAVA_FILE_EXTENSION);
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
			if (csUtil.isImportedToken(syntax, tokenDefinition)) {
				continue;
			}
			resolverFileNames.add(nameUtil.getTokenResolverClassName(syntax, tokenDefinition) + GenerationContext.JAVA_FILE_EXTENSION);
		}
		return resolverFileNames;
	}
}

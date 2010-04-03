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
package org.emftext.sdk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.GenPackageDependentElement;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.finders.ConcreteSyntaxByHintFinder;
import org.emftext.sdk.finders.ConcreteSyntaxInRegistryFinder;
import org.emftext.sdk.finders.GenPackageByHintFinder;
import org.emftext.sdk.finders.GenPackageByNameFinder;
import org.emftext.sdk.finders.GenPackageInRegistryFinder;
import org.emftext.sdk.finders.IConcreteSyntaxFinder;
import org.emftext.sdk.finders.IGenPackageFinder;
import org.emftext.sdk.finders.IGenPackageFinderResult;

/**
 * A helper class that can be used search for generator packages, 
 * syntaxes and finders.
 */
public class MetamodelHelper {
	
	private static final ConcreteSyntaxInRegistryFinder CONCRETE_SYNTAX_IN_REGISTRY_FINDER = new ConcreteSyntaxInRegistryFinder();
	private static final ConcreteSyntaxByHintFinder CONCRETE_SYNTAX_BY_HINT_FINDER = new ConcreteSyntaxByHintFinder();
	
	private static final GenPackageInRegistryFinder GEN_PACKAGE_IN_REGISTRY_FINDER = new GenPackageInRegistryFinder();
	private static final GenPackageByNameFinder GEN_PACKAGE_BY_NAME_FINDER = new GenPackageByNameFinder();
	private static final GenPackageByHintFinder GEN_PACKAGE_BY_HINT_FINDER = new GenPackageByHintFinder();
	
	public final static String GEN_PACKAGE_FINDER_KEY = "GEN_PACKAGE_FINDER";
	public final static String CONCRETE_SYNTAX_FINDER_KEY = "CONCRETE_SYNTAX_FINDER";

	private MetamodelManager mmManager = new MetamodelManager();

	public Collection<GenPackage> findGenPackages(Map<?,?> options, GenPackageDependentElement container, String uri, String locationHint, Resource resource, boolean resolveFuzzy) {
		configureMetaModelManager(options);
		final Collection<IGenPackageFinderResult> result = mmManager.findGenPackages(uri, locationHint, container, resource, resolveFuzzy);
		if (result != null) {
			Collection<GenPackage> foundPackages = new LinkedHashSet<GenPackage>();
			for (IGenPackageFinderResult resolvedPackage : result) {
				GenPackage genPackage = resolvedPackage.getResult();
				if (genPackage != null) {
					foundPackages.add(genPackage);
				}
			}
			return foundPackages;
		} else {
			return null;
		}
	}

	public ConcreteSyntax findConcreteSyntax(Map<?, ?> options, String fragment, String locationHint, 
			Import container, GenPackage genPackage, Resource resource) {
		configureMetaModelManager(options);
		return mmManager.findConcreteSyntax(fragment, locationHint, container, genPackage, resource);
	}

	private void configureMetaModelManager(Map<?, ?> options) {
		mmManager.clearFinders();
		
		mmManager.addGenPackageFinder(GEN_PACKAGE_BY_HINT_FINDER);
		mmManager.addGenPackageFinder(GEN_PACKAGE_BY_NAME_FINDER);
		mmManager.addGenPackageFinder(GEN_PACKAGE_IN_REGISTRY_FINDER);
		
		mmManager.addConcreteSyntaxFinder(CONCRETE_SYNTAX_BY_HINT_FINDER);
		mmManager.addConcreteSyntaxFinder(CONCRETE_SYNTAX_IN_REGISTRY_FINDER);
		
		List<IGenPackageFinder> genPackageFinders = findFinders(options, GEN_PACKAGE_FINDER_KEY, IGenPackageFinder.class);
		for (IGenPackageFinder finder : genPackageFinders) {
			mmManager.addGenPackageFinder(finder);
		}
		List<IConcreteSyntaxFinder> concreteSyntaxFinders = findFinders(options, CONCRETE_SYNTAX_FINDER_KEY, IConcreteSyntaxFinder.class);
		for (IConcreteSyntaxFinder finder : concreteSyntaxFinders) {
			mmManager.addConcreteSyntaxFinder(finder);
		}
	}

	@SuppressWarnings("unchecked")
	private <T> List<T> findFinders(Map<?, ?> options, String key, Class<T> type) {
		List<T> finders = new ArrayList<T>();
		if (options == null) {
			return finders;
		}
		if (!options.containsKey(key)) {
			return finders;
		}
		Object value = options.get(key);
		if (value == null) {
			return finders;
		}
		if (type.isInstance(value)) {
			finders.add((T) value);
			return finders;
		}
		if (value instanceof List) {
			List<?> values = (List<?>) value;
			for (Object next : values) {
				if (type.isInstance(next)) {
					finders.add((T) next);
				}
			}
		}
		return finders;
	}
}

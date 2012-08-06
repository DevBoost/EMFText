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
/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.petrinets.resource.petrinets.analysis;

public class PetrinetsDefaultResolverDelegate<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> {
	
	private static class StringMatch {
		
		private String exactMatch;
		private String similarMatch;
		
		public StringMatch() {
			super();
		}
		
		public StringMatch(String exactMatch) {
			super();
			this.exactMatch = exactMatch;
		}
		
		public String getExactMatch() {
			return exactMatch;
		}
		
		public void setSimilarMatch(String similarMatch) {
			this.similarMatch = similarMatch;
		}
		
		public String getSimilarMatch() {
			return similarMatch;
		}
		
	}
	
	/**
	 * The maximal distance between two identifiers according to the Levenshtein
	 * distance to qualify for a quick fix.
	 */
	public int MAX_DISTANCE = 2;
	
	private boolean enableScoping = true;
	
	/**
	 * This is a cache for the external objects that are referenced by the current
	 * resource. We must cache this set because determining this set required to
	 * resolve proxy objects, which causes reference resolving to slow down
	 * exponentially.
	 */
	private java.util.Set<org.eclipse.emf.ecore.EObject> referencedExternalObjects;
	
	/**
	 * We store the number of proxy objects that were present when
	 * <code>referencedExternalObjects</code> was resolved, to recompute this set when
	 * a proxy was resolved. This is required, because a resolved proxy may point to a
	 * new external object.
	 */
	private int oldProxyCount = -1;
	
	private org.emftext.language.petrinets.resource.petrinets.IPetrinetsNameProvider nameProvider = new org.emftext.language.petrinets.resource.petrinets.mopp.PetrinetsMetaInformation().createNameProvider();
	
	/**
	 * This standard implementation searches for objects in the resource, which have
	 * the correct type and a name/id attribute matching the identifier. If no
	 * matching object is found, the identifier is used as URI. If the resource at
	 * this URI has a root element of the correct type, this element is returned.
	 */
	protected void resolve(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.petrinets.resource.petrinets.IPetrinetsReferenceResolveResult<ReferenceType> result) {
		try {
			org.eclipse.emf.ecore.EObject root = container;
			if (!enableScoping) {
				root = org.eclipse.emf.ecore.util.EcoreUtil.getRootContainer(container);
			}
			while (root != null) {
				boolean continueSearch = tryToResolveIdentifierInObjectTree(identifier, container, root, reference, position, resolveFuzzy, result, !enableScoping);
				if (!continueSearch) {
					return;
				}
				root = root.eContainer();
			}
			boolean continueSearch = tryToResolveIdentifierAsURI(identifier, container, reference, position, resolveFuzzy, result);
			if (continueSearch) {
				java.util.Set<org.eclipse.emf.ecore.EObject> crossReferencedObjectsInOtherResource = findReferencedExternalObjects(container);
				for (org.eclipse.emf.ecore.EObject externalObject : crossReferencedObjectsInOtherResource) {
					continueSearch = tryToResolveIdentifierInObjectTree(identifier, container, externalObject, reference, position, resolveFuzzy, result, !enableScoping);
					if (!continueSearch) {
						return;
					}
				}
			}
			if (continueSearch) {
				continueSearch = tryToResolveIdentifierInGenModelRegistry(identifier, container, reference, position, resolveFuzzy, result);
			}
		} catch (java.lang.RuntimeException rte) {
			// catch exception here to prevent EMF proxy resolution from swallowing it
			rte.printStackTrace();
		}
	}
	
	/**
	 * Returns all EObjects that are referenced by EObjects in the resource that
	 * contains <code>object</code>, but that are located in different resources.
	 */
	private java.util.Set<org.eclipse.emf.ecore.EObject> findReferencedExternalObjects(org.eclipse.emf.ecore.EObject object) {
		org.eclipse.emf.ecore.EObject root = org.eclipse.emf.ecore.util.EcoreUtil.getRootContainer(object);
		java.util.Map<org.eclipse.emf.ecore.EObject, java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting>> proxies = org.eclipse.emf.ecore.util.EcoreUtil.ProxyCrossReferencer.find(root);
		int proxyCount = 0;
		for (java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting> settings : proxies.values()) {
			proxyCount += settings.size();
		}
		// Use the cache if it is still valid
		if (referencedExternalObjects != null && oldProxyCount == proxyCount) {
			return referencedExternalObjects;
		}
		referencedExternalObjects = new java.util.LinkedHashSet<org.eclipse.emf.ecore.EObject>();
		oldProxyCount = proxyCount;
		java.util.Set<org.eclipse.emf.ecore.EObject> referencedExternalObjects = new java.util.LinkedHashSet<org.eclipse.emf.ecore.EObject>();
		referencedExternalObjects.addAll(getExternalObjects(root.eCrossReferences(), object));
		java.util.Iterator<org.eclipse.emf.ecore.EObject> eAllContents = root.eAllContents();
		while (eAllContents.hasNext()) {
			org.eclipse.emf.ecore.EObject next = eAllContents.next();
			referencedExternalObjects.addAll(getExternalObjects(next.eCrossReferences(), object));
		}
		return referencedExternalObjects;
	}
	
	/**
	 * Returns all EObjects that are not contained in the same resource as the given
	 * EObject.
	 */
	private java.util.Set<org.eclipse.emf.ecore.EObject> getExternalObjects(java.util.Collection<org.eclipse.emf.ecore.EObject> objects, org.eclipse.emf.ecore.EObject object) {
		java.util.Set<org.eclipse.emf.ecore.EObject> externalObjects = new java.util.LinkedHashSet<org.eclipse.emf.ecore.EObject>();
		for (org.eclipse.emf.ecore.EObject next : objects) {
			if (next.eResource() != object.eResource()) {
				externalObjects.add(next);
			}
		}
		return externalObjects;
	}
	
	/**
	 * Searches for objects in the tree of EObjects that is rooted at
	 * <code>root</code>, which have the correct type and a name/id attribute matching
	 * the identifier. This method can be used to quickly implement custom reference
	 * resolvers which require to search in a particular scope for referenced
	 * elements, rather than in the whole resource as done by resolve().
	 */
	protected boolean tryToResolveIdentifierInObjectTree(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EObject root, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.petrinets.resource.petrinets.IPetrinetsReferenceResolveResult<ReferenceType> result, boolean checkRootFirst) {
		org.eclipse.emf.ecore.EClass type = reference.getEReferenceType();
		boolean continueSearch;
		if (checkRootFirst) {
			// check whether the root element matches
			continueSearch = checkElement(container, root, reference, position, type, identifier, resolveFuzzy, true, result);
			if (!continueSearch) {
				return false;
			}
		}
		// check the contents
		for (java.util.Iterator<org.eclipse.emf.ecore.EObject> iterator = root.eAllContents(); iterator.hasNext(); ) {
			org.eclipse.emf.ecore.EObject element = iterator.next();
			continueSearch = checkElement(container, element, reference, position, type, identifier, resolveFuzzy, true, result);
			if (!continueSearch) {
				return false;
			}
		}
		// if the root element was already checked, we can return.
		if (checkRootFirst) {
			return true;
		}
		// check whether the root element matches
		continueSearch = checkElement(container, root, reference, position, type, identifier, resolveFuzzy, true, result);
		if (!continueSearch) {
			return false;
		}
		return true;
	}
	
	private boolean tryToResolveIdentifierAsURI(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.petrinets.resource.petrinets.IPetrinetsReferenceResolveResult<ReferenceType> result) {
		org.eclipse.emf.ecore.EClass type = reference.getEReferenceType();
		org.eclipse.emf.ecore.resource.Resource resource = container.eResource();
		if (resource != null) {
			org.eclipse.emf.common.util.URI uri = getURI(identifier, resource.getURI());
			if (uri != null) {
				org.eclipse.emf.ecore.EObject element = loadResource(container.eResource().getResourceSet(), uri);
				if (element == null) {
					return true;
				}
				return checkElement(container, element, reference, position, type, identifier, resolveFuzzy, false, result);
			}
		}
		return true;
	}
	
	private boolean tryToResolveIdentifierInGenModelRegistry(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.petrinets.resource.petrinets.IPetrinetsReferenceResolveResult<ReferenceType> result) {
		org.eclipse.emf.ecore.EClass type = reference.getEReferenceType();
		
		final java.util.Map<String, org.eclipse.emf.common.util.URI> packageNsURIToGenModelLocationMap = org.eclipse.emf.ecore.plugin.EcorePlugin.getEPackageNsURIToGenModelLocationMap();
		for (String nextNS : packageNsURIToGenModelLocationMap.keySet()) {
			org.eclipse.emf.common.util.URI genModelURI = packageNsURIToGenModelLocationMap.get(nextNS);
			try {
				final org.eclipse.emf.ecore.resource.ResourceSet rs = container.eResource().getResourceSet();
				org.eclipse.emf.ecore.resource.Resource genModelResource = rs.getResource(genModelURI, true);
				if (genModelResource == null) {
					continue;
				}
				final java.util.List<org.eclipse.emf.ecore.EObject> contents = genModelResource.getContents();
				if (contents == null || contents.size() == 0) {
					continue;
				}
				org.eclipse.emf.ecore.EObject genModel = contents.get(0);
				boolean continueSearch = checkElement(container, genModel, reference, position, type, identifier, resolveFuzzy, false, result);
				if (!continueSearch) {
					return false;
				}
			} catch (Exception e) {
				// ignore exceptions that are raised by faulty genmodel registrations
			}
		}
		return true;
	}
	
	private boolean checkElement(org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EReference reference, int position, org.eclipse.emf.ecore.EClass type, String identifier, boolean resolveFuzzy, boolean checkStringWise, org.emftext.language.petrinets.resource.petrinets.IPetrinetsReferenceResolveResult<ReferenceType> result) {
		if (element.eIsProxy()) {
			return true;
		}
		
		boolean hasCorrectType = hasCorrectType(element, type.getInstanceClass());
		if (!hasCorrectType) {
			return true;
		}
		
		StringMatch match;
		// do not compare string-wise if identifier is a URI
		if (checkStringWise) {
			match = matches(element, identifier, resolveFuzzy);
		} else {
			match = new StringMatch(identifier);
		}
		String exactMatch = match.getExactMatch();
		if (exactMatch == null) {
			String similarMatch = match.getSimilarMatch();
			if (similarMatch != null) {
				org.eclipse.emf.ecore.EObject oldTarget;
				Object value = container.eGet(reference);
				if (value instanceof java.util.List) {
					java.util.List<?> list = (java.util.List<?>) container.eGet(reference);
					oldTarget = (org.eclipse.emf.ecore.EObject) list.get(position);
				} else {
					oldTarget = (org.eclipse.emf.ecore.EObject) container.eGet(reference, false);
				}
				result.addQuickFix(new org.emftext.language.petrinets.resource.petrinets.mopp.PetrinetsChangeReferenceQuickFix("Replace with " + similarMatch, "IMG_TOOL_FORWARD", container, reference, oldTarget, element));
			}
			return true;
		}
		// we can safely cast 'element' to 'ReferenceType' here, because we've checked the
		// type of 'element' against the type of the reference. unfortunately the compiler
		// does not know that this is sufficient, so we must call cast(), which is not
		// type safe by itself.
		result.addMapping(exactMatch, cast(element));
		if (!resolveFuzzy) {
			return false;
		}
		return true;
	}
	
	/**
	 * This method encapsulates an unchecked cast from EObject to ReferenceType. We
	 * cannot do this cast strictly type safe, because type parameters are erased by
	 * compilation. Thus, an instanceof check cannot be performed at runtime.
	 */
	@SuppressWarnings("unchecked")	
	private ReferenceType cast(org.eclipse.emf.ecore.EObject element) {
		return (ReferenceType) element;
	}
	
	protected String produceDeResolveErrorMessage(org.eclipse.emf.ecore.EObject refObject, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, org.emftext.language.petrinets.resource.petrinets.IPetrinetsTextResource resource) {
		String msg = getClass().getSimpleName() + ": " + reference.getEType().getName() + " \"" + refObject.toString() + "\" not de-resolveable";
		return msg;
	}
	
	protected String deResolve(ReferenceType element, ContainerType container, org.eclipse.emf.ecore.EReference reference) {
		org.eclipse.emf.ecore.resource.Resource elementResource = element.eResource();
		// For elements in external resources we return the resource URI instead of the
		// name of the element.
		if (elementResource != null && !elementResource.equals(container.eResource())) {
			return elementResource.getURI().toString();
		}
		return getName(element);
	}
	
	private StringMatch matches(org.eclipse.emf.ecore.EObject element, String identifier, boolean matchFuzzy) {
		for (Object name : getNames(element)) {
			StringMatch match = matches(identifier, name, matchFuzzy);
			if (match.getExactMatch() != null) {
				return match;
			}
		}
		return new StringMatch();
	}
	
	/**
	 * This method is only kept for compatibility reasons. The current version
	 * delegates all calls to a name provider, but previous custom implementation of
	 * this class may have overridden this method.
	 */
	public java.util.List<String> getNames(org.eclipse.emf.ecore.EObject element) {
		return nameProvider.getNames(element);
	}
	
	private StringMatch matches(String identifier, Object attributeValue, boolean matchFuzzy) {
		if (attributeValue != null && attributeValue instanceof String) {
			String name = (String) attributeValue;
			if (name.equals(identifier) || matchFuzzy) {
				return new StringMatch(name);
			}
			if (isSimilar(name, identifier)) {
				StringMatch match = new StringMatch();
				match.setSimilarMatch(name);
				return match;
			}
		}
		return new StringMatch();
	}
	
	private String getName(ReferenceType element) {
		String deresolvedReference = null;
		if (element instanceof org.eclipse.emf.ecore.EObject) {
			org.eclipse.emf.ecore.EObject eObjectToDeResolve = (org.eclipse.emf.ecore.EObject) element;
			if (eObjectToDeResolve.eIsProxy()) {
				deresolvedReference = ((org.eclipse.emf.ecore.InternalEObject) eObjectToDeResolve).eProxyURI().fragment();
				if (deresolvedReference != null && deresolvedReference.startsWith(org.emftext.language.petrinets.resource.petrinets.IPetrinetsContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX)) {
					deresolvedReference = deresolvedReference.substring(org.emftext.language.petrinets.resource.petrinets.IPetrinetsContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX.length());
					deresolvedReference = deresolvedReference.substring(deresolvedReference.indexOf("_") + 1);
				}
			}
		}
		if (deresolvedReference != null) {
			return deresolvedReference;
		}
		// if the referenced element was not a proxy, we try the same magic that was used
		// while resolving elements to obtain names for elements
		java.util.List<String> names = getNames(element);
		for (String name : names) {
			if (name != null) {
				return name;
			}
		}
		return null;
	}
	
	private boolean hasCorrectType(org.eclipse.emf.ecore.EObject element, Class<?> expectedTypeClass) {
		return expectedTypeClass.isInstance(element);
	}
	
	private org.eclipse.emf.ecore.EObject loadResource(org.eclipse.emf.ecore.resource.ResourceSet resourceSet, org.eclipse.emf.common.util.URI uri) {
		try {
			org.eclipse.emf.ecore.resource.Resource resource = resourceSet.getResource(uri, true);
			org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.EObject> contents = resource.getContents();
			if (contents.size() > 0) {
				return contents.get(0);
			}
		} catch (java.lang.RuntimeException re) {
			// do nothing here. if no resource can be loaded the uriString is probably not a
			// valid resource URI
		}
		return null;
	}
	
	private org.eclipse.emf.common.util.URI getURI(String identifier, org.eclipse.emf.common.util.URI baseURI) {
		if (identifier == null) {
			return null;
		}
		try {
			org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createURI(identifier);
			if (uri.isRelative()) {
				uri = uri.resolve(baseURI);
			}
			return uri;
		} catch (java.lang.IllegalArgumentException iae) {
			// the identifier string is not a valid URI
			return null;
		}
	}
	
	protected org.emftext.language.petrinets.resource.petrinets.IPetrinetsReferenceCache getCache(org.eclipse.emf.ecore.EObject object) {
		org.eclipse.emf.ecore.EObject root = org.eclipse.emf.ecore.util.EcoreUtil.getRootContainer(object);
		org.eclipse.emf.common.notify.Adapter adapter = org.emftext.language.petrinets.resource.petrinets.util.PetrinetsEObjectUtil.getEAdapter(root, org.emftext.language.petrinets.resource.petrinets.analysis.PetrinetsReferenceCache.class);
		org.emftext.language.petrinets.resource.petrinets.analysis.PetrinetsReferenceCache cache = org.emftext.language.petrinets.resource.petrinets.util.PetrinetsCastUtil.cast(adapter);
		if (cache != null) {
			return cache;
		} else {
			// cache does not exist. create a new one.
			cache = new org.emftext.language.petrinets.resource.petrinets.analysis.PetrinetsReferenceCache(nameProvider);
			cache.initialize(root);
			root.eAdapters().add(cache);
			return cache;
		}
	}
	
	public void setEnableScoping(boolean enableScoping) {
		this.enableScoping = enableScoping;
	}
	
	public boolean getEnableScoping() {
		return enableScoping;
	}
	
	private boolean isSimilar(String identifier, Object attributeValue) {
		if (attributeValue != null && attributeValue instanceof String) {
			String name = (String) attributeValue;
			if (org.emftext.language.petrinets.resource.petrinets.util.PetrinetsStringUtil.computeLevenshteinDistance(identifier, name) <= MAX_DISTANCE) {
				return true;
			}
		}
		return false;
	}
	
}

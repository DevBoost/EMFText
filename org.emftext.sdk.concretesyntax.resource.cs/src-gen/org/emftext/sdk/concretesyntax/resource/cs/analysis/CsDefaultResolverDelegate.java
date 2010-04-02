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

package org.emftext.sdk.concretesyntax.resource.cs.analysis;

public class CsDefaultResolverDelegate<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> {
	
	private static class ReferenceCache implements org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceCache, org.eclipse.emf.common.notify.Adapter {
		
		private java.util.Map<java.lang.String, java.lang.Object> cache = new java.util.LinkedHashMap<java.lang.String, java.lang.Object>();
		private org.eclipse.emf.common.notify.Notifier target;
		
		public org.eclipse.emf.common.notify.Notifier getTarget() {
			return target;
		}
		
		public boolean isAdapterForType(java.lang.Object arg0) {
			return false;
		}
		
		public void notifyChanged(org.eclipse.emf.common.notify.Notification arg0) {
		}
		
		public void setTarget(org.eclipse.emf.common.notify.Notifier arg0) {
			target = arg0;
		}
		
		public java.lang.Object get(java.lang.String identifier) {
			return cache.get(identifier);
		}
		
		public void put(java.lang.String identifier, java.lang.Object newObject) {
			cache.put(identifier, newObject);
		}
		
	}
	
	public final static java.lang.String NAME_FEATURE = "name";
	
	// This standard implementation searches the tree for objects of the 
	// correct type with a name attribute matching the identifier.
	protected void resolve(java.lang.String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult<ReferenceType> result) {
		try {
			org.eclipse.emf.ecore.EClass type = reference.getEReferenceType();
			org.eclipse.emf.ecore.EObject root = org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil.findRootContainer(container);
			// first check whether the root element matches
			boolean continueSearch = checkElement(root, type, identifier, resolveFuzzy, true, result);
			if (!continueSearch) {
				return;
			}
			// then check the contents
			for (java.util.Iterator<org.eclipse.emf.ecore.EObject> iterator = root.eAllContents(); iterator.hasNext(); ) {
				org.eclipse.emf.ecore.EObject element = iterator.next();
				continueSearch = checkElement(element, type, identifier, resolveFuzzy, true, result);
				if (!continueSearch) {
					return;
				}
			}
			if (isURI(identifier)) {
				org.eclipse.emf.ecore.resource.Resource resource = container.eResource();
				if (resource != null) {
					org.eclipse.emf.ecore.EObject element = loadResource(container.eResource().getResourceSet(), identifier);
					if (element == null) {
						return;
					}
					checkElement(element, type, identifier, resolveFuzzy, false, result);
				}
			}
		} catch (java.lang.RuntimeException rte) {
			// catch exception here to prevent EMF proxy resolution from swallowing it
			rte.printStackTrace();
		}
	}
	
	private boolean checkElement(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EClass type, java.lang.String identifier, boolean resolveFuzzy, boolean checkStringWise, org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult<ReferenceType> result) {
		if (element.eIsProxy()) {
			return true;
		}
		
		boolean hasCorrectType = hasCorrectType(element, type.getInstanceClass());
		if (!hasCorrectType) {
			return true;
		}
		
		java.lang.String match;
		// do not compare string-wise if identifier is a URI
		if (checkStringWise) {
			match = matches(element, identifier, resolveFuzzy);
		} else {
			match = identifier;
		}
		if (match == null) {
			return true;
		}
		// we can safely cast 'element' to 'ReferenceType' here,
		// because we've checked the type of 'element' against
		// the type of the reference. unfortunately the compiler
		// does not know that this is sufficient, so we must call
		// cast(), which is not type safe by itself.
		result.addMapping(match, cast(element));
		if (!resolveFuzzy) {
			return false;
		}
		return true;
	}
	
	// This method encapsulates an unchecked cast from EObject to
	// ReferenceType. We can not do this cast strictly type safe,
	// because type parameters are erased by compilation. Thus, an
	// instanceof check can not be performed at runtime.
	@SuppressWarnings("unchecked")	
	private ReferenceType cast(org.eclipse.emf.ecore.EObject element) {
		return (ReferenceType) element;
	}
	
	protected java.lang.String produceDeResolveErrorMessage(org.eclipse.emf.ecore.EObject refObject, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource resource) {
		java.lang.String msg = getClass().getSimpleName() + ": " + reference.getEType().getName() + " \"" + refObject.toString() + "\" not de-resolveable";
		return msg;
	}
	
	protected java.lang.String deResolve(ReferenceType element, ContainerType container, org.eclipse.emf.ecore.EReference reference) {
		return getName(element);
	}
	
	private java.lang.String matches(org.eclipse.emf.ecore.EObject element, java.lang.String identifier, boolean matchFuzzy) {
		// first check for attributes that have set the ID flag to true
		java.util.List<org.eclipse.emf.ecore.EStructuralFeature> features = element.eClass().getEStructuralFeatures();
		for (org.eclipse.emf.ecore.EStructuralFeature feature : features) {
			if (feature instanceof org.eclipse.emf.ecore.EAttribute) {
				org.eclipse.emf.ecore.EAttribute attribute = (org.eclipse.emf.ecore.EAttribute) feature;
				if (attribute.isID()) {
					java.lang.Object attributeValue = element.eGet(attribute);
					java.lang.String match = matches(identifier, attributeValue, matchFuzzy);
					if (match != null) {
						return match;
					}
				}
			}
		}
		
		// then check for an attribute that is called 'name'
		org.eclipse.emf.ecore.EStructuralFeature nameAttr = element.eClass().getEStructuralFeature(NAME_FEATURE);
		if (nameAttr instanceof org.eclipse.emf.ecore.EAttribute) {
			java.lang.Object attributeValue = element.eGet(nameAttr);
			return matches(identifier, attributeValue, matchFuzzy);
		} else {
			//try any other string attribute found
			for (org.eclipse.emf.ecore.EAttribute stringAttribute : element.eClass().getEAllAttributes()) {
				if (stringAttribute.getEType().getInstanceClassName().equals(java.lang.String.class.getName())) {
					java.lang.Object attributeValue = element.eGet(stringAttribute);
					java.lang.String match = matches(identifier, attributeValue, matchFuzzy);
					if (match != null) {
						return match;
					}
				}
			}
			
			for (org.eclipse.emf.ecore.EOperation o : element.eClass().getEAllOperations()) {
				if (o.getName().toLowerCase().endsWith(NAME_FEATURE) && o.getEParameters().size() == 0 ) {
					java.lang.String result = (java.lang.String) org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil.invokeOperation(element, o);
					java.lang.String match = matches(identifier, result, matchFuzzy);
					if (match != null) {
						return match;
					}
				}
			}
		}
		return null;
	}
	
	private java.lang.String matches(java.lang.String identifier, java.lang.Object attributeValue, boolean matchFuzzy) {
		if (attributeValue != null && attributeValue instanceof java.lang.String) {
			java.lang.String name = (java.lang.String) attributeValue;
			if (name.equals(identifier) || matchFuzzy) {
				return name;
			}
		}
		return null;
	}
	
	private java.lang.String getName(ReferenceType element) {
		org.eclipse.emf.ecore.EStructuralFeature nameAttr = element.eClass().getEStructuralFeature(NAME_FEATURE);
		if(element.eIsProxy()) {
			java.lang.String fragment = ((org.eclipse.emf.ecore.InternalEObject) element).eProxyURI().fragment();
			if (fragment != null && fragment.startsWith(org.emftext.sdk.concretesyntax.resource.cs.ICsContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX)) {
				fragment = fragment.substring(org.emftext.sdk.concretesyntax.resource.cs.ICsContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX.length());
				fragment = fragment.substring(fragment.indexOf("_") + 1);
			}
			return fragment;
		}
		else if (nameAttr instanceof org.eclipse.emf.ecore.EAttribute) {
			return (java.lang.String) element.eGet(nameAttr);
		} else {
			//try any other string attribute found
			for (org.eclipse.emf.ecore.EAttribute strAttribute : element.eClass().getEAllAttributes()) {
				if (!strAttribute.isMany() &&				strAttribute.getEType().getInstanceClassName().equals(java.lang.String.class.getName())) {
					return (java.lang.String) element.eGet(strAttribute);
				}
			}
			for (org.eclipse.emf.ecore.EOperation o : element.eClass().getEAllOperations()) {
				if (o.getName().toLowerCase().endsWith(NAME_FEATURE) && o.getEParameters().size() == 0 ) {
					java.lang.String result = (java.lang.String) org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil.invokeOperation(element, o);
					if (result != null) {
						return result;
					}
				}
			}
		}
		return null;
	}
	
	private boolean hasCorrectType(org.eclipse.emf.ecore.EObject element, Class<?> expectedTypeClass) {
		return expectedTypeClass.isInstance(element);
	}
	
	private org.eclipse.emf.ecore.EObject loadResource(org.eclipse.emf.ecore.resource.ResourceSet resourceSet, java.lang.String uriString) {
		try {
			org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createURI(uriString);
			org.eclipse.emf.ecore.resource.Resource resource = resourceSet.getResource(uri, true);
			org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.EObject> contents = resource.getContents();
			if (contents.size() > 0) {
				return contents.get(0);
			}
		} catch (java.lang.RuntimeException re) {
			// do nothing here. if no resource can be loaded the uriString is probably not a valid resource URI
		}
		return null;
	}
	
	private boolean isURI(java.lang.String identifier) {
		if (identifier == null) {
			return false;
		}
		try {
			org.eclipse.emf.common.util.URI.createURI(identifier);
		} catch (java.lang.IllegalArgumentException iae) {
			// the identifier string is not a valid URI
			return false;
		}
		return true;
	}
	
	private org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceCache getCache(org.eclipse.emf.ecore.EObject object) {
		org.eclipse.emf.ecore.EObject root = org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil.findRootContainer(object);
		java.util.List<org.eclipse.emf.common.notify.Adapter> eAdapters = root.eAdapters();
		for (org.eclipse.emf.common.notify.Adapter adapter : eAdapters) {
			if (adapter instanceof ReferenceCache) {
				ReferenceCache cache = (ReferenceCache) adapter;
				return cache;
			}
		}
		ReferenceCache cache = new ReferenceCache();
		root.eAdapters().add(cache);
		return cache;
	}
}

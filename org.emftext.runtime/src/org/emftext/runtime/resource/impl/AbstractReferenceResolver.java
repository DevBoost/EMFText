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
package org.emftext.runtime.resource.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.resource.IContextDependentURIFragment;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.IReferenceResolver;
import org.emftext.runtime.resource.ITextResource;

/**
 * Base implementation for all generated reference resolvers. 
 * It implements the specifications from {@link IReferenceResolver}.
 * 
 * @param <ContainerType> the type of the container that contains
 * the reference that is resolved by this resolver
 * 
 * @param <ReferenceType> the type of the reference that is resolved 
 * by this resolver
 * 
 * @author Jendrik Johannes <jendrik.johannes@tu-dresden.de>
 */
public abstract class AbstractReferenceResolver<ContainerType extends EObject, ReferenceType extends EObject> implements IReferenceResolver<ContainerType, ReferenceType> {

	public final static String NAME_FEATURE = "name";

	private Map<?, ?> options;

	public AbstractReferenceResolver() {
		init();
	}
	
	protected void init() {
	}
	
	public void resolve(String identifier, ContainerType container, 
			EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<ReferenceType> result) {
		try {
			doResolve(identifier, container, reference, position, resolveFuzzy, result);
		} catch (RuntimeException rte) {
			// catch exception here to prevent EMF proxy resolution from swallowing it
			rte.printStackTrace();
		}
	}
	
	/**
	 * This method is called by <code>resolve()</code>. Clients may or may not override
	 * it manually. This standard implementation searches the tree for objects of the 
	 * correct type with a name attribute matching the proxy URI fragment.
	 * 
	 * @param proxy The proxy.
	 * @param container The object referencing the proxy.
	 * @param reference The reference that holds the proxy.
	 * @param resource  The resource containing the proxy and replacement candidates. 
	 * @param resolveFuzzy 
	 * @return The resolved object or null if resolving fails.
	 */
	protected void doResolve(String identifier, ContainerType container,
			EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<ReferenceType> result) {

		EClass type = reference.getEReferenceType();
		EObject root = findRoot(container);
		// first check whether the root element matches
		boolean continueSearch = checkElement(root, type, identifier, resolveFuzzy, result);
		if (!continueSearch) {
			return;
		}
		// then check the contents
		for (Iterator<EObject> iterator = root.eAllContents(); iterator.hasNext(); ) {
			EObject element = iterator.next();
			continueSearch = checkElement(element, type, identifier, resolveFuzzy, result);
			if (!continueSearch) {
				return;
			}
		}
	}
	
	private boolean checkElement(EObject element, EClass type, String identifier, 
			boolean resolveFuzzy, IReferenceResolveResult<ReferenceType> result) {
		if (element.eIsProxy()) {
			return true;
		}
		
		EClass eClass = element.eClass();
		boolean hasCorrectType = eClass.equals(type) || eClass.getEAllSuperTypes().contains(type);
		if (!hasCorrectType) {
			return true;
		}
		
		final String match = matches(element, identifier, resolveFuzzy);
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

	/**
	 * This method encapsulates an unchecked cast from EObject to
	 * ReferenceType. We can not do this cast strictly type safe,
	 * because type parameters are erased by compilation. Thus, an
	 * instanceof check can not be performed at runtime.
	 * 
	 * @param element
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private ReferenceType cast(EObject element) {
		return (ReferenceType) element;
	}
	
	protected EObject findRoot(EObject object) {
		EObject container = object.eContainer();
		if (container != null) {
			return findRoot(container);
		} else {
			return object;
		}
	}

	protected String produceDeResolveErrorMessage(EObject refObject, EObject container,
			EReference reference, ITextResource resource) {
		
		String msg = getClass().getSimpleName() + ": " + reference.getEType().getName() + " \"" + refObject.toString() + "\" not de-resolveable";  
		return msg;
		
	}
	
	protected String doDeResolve(ReferenceType element, ContainerType container,
			EReference reference) {
		return getName(element);
	}
	
	private String matches(EObject element, String identifier, boolean matchFuzzy) {
		EStructuralFeature nameAttr = element.eClass().getEStructuralFeature(NAME_FEATURE);
		if (nameAttr instanceof EAttribute) {
			Object attributeValue = element.eGet(nameAttr);
			return matches(identifier, attributeValue, matchFuzzy);
		}
		else {
			//try any other string attribute found
			for (EAttribute stringAttribute : element.eClass().getEAllAttributes()) {
				if (stringAttribute.getEType().getInstanceClassName().equals(String.class.getName())) {
					Object attributeValue = element.eGet(stringAttribute);
					String match = matches(identifier, attributeValue, matchFuzzy);
					if (match != null) {
						return match;
					}
				}
			}
			
			for (EOperation o : element.eClass().getEAllOperations()) {
				if (o.getName().toLowerCase().endsWith(NAME_FEATURE) && o.getEParameters().size() == 0 ) {
					String result = invokeOperation(element, o);
					String match = matches(identifier, result, matchFuzzy);
					if (match != null) {
						return match;
					}
				}
			}
		}
		return null;
	}

	private String matches(String identifier, Object attributeValue, boolean matchFuzzy) {
		if (attributeValue != null && attributeValue instanceof String) {
			String name = (String) attributeValue;
			if (name.startsWith(identifier) && matchFuzzy) {
				return name;
			}
			if (name.equals(identifier)) {
				return identifier;
			}
		}
		return null;
	}

	private String getName(ReferenceType element) {
		EStructuralFeature nameAttr = element.eClass().getEStructuralFeature(NAME_FEATURE);
		if(element.eIsProxy()) {
			String fragment = ((InternalEObject)element).eProxyURI().fragment();
			if (fragment != null && fragment.startsWith(IContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX)) {
				fragment = fragment.substring(IContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX.length());
			}
			return fragment;
		}
		else if (nameAttr instanceof EAttribute) {
			return (String) element.eGet(nameAttr);
		}
		else {
			//try any other string attribute found
			for(EAttribute strAttribute : element.eClass().getEAllAttributes()) {
				if (!strAttribute.isMany() &&
						strAttribute.getEType().getInstanceClassName().equals(java.lang.String.class.getName())) {
					return (String) element.eGet(strAttribute);
				}
			}
			
			for (EOperation o : element.eClass().getEAllOperations()) {
				if (o.getName().toLowerCase().endsWith(NAME_FEATURE) && o.getEParameters().size() == 0 ) {
					String result = invokeOperation(element, o);
					if (result != null) {
						return result;
					}
				}
			}
			
		}
		return null;
	}

	private String invokeOperation(EObject element, EOperation o) {
		Method method;
		try {
			method = element.getClass().getMethod(o.getName(), new Class[]{});
			if (method != null) {
				Object result = method.invoke(element, new Object[]{});
				return (String) result;
			}
		} catch (SecurityException e) {
			EMFTextRuntimePlugin.logError("Exception while matching proxy URI.", e);
		} catch (NoSuchMethodException e) {
			EMFTextRuntimePlugin.logError("Exception while matching proxy URI.", e);
		} catch (IllegalArgumentException e) {
			EMFTextRuntimePlugin.logError("Exception while matching proxy URI.", e);
		} catch (IllegalAccessException e) {
			EMFTextRuntimePlugin.logError("Exception while matching proxy URI.", e);
		} catch (InvocationTargetException e) {
			EMFTextRuntimePlugin.logError("Exception while matching proxy URI.", e);
		}
		return null;
	}

	
	public String deResolve(ReferenceType element, ContainerType container,
			EReference reference) {
		return doDeResolve(element, container, reference);
	}

	public void setOptions(Map<?, ?> options) {
		this.options = options;
	}

	public Map<?, ?> getOptions() {
		return options;
	}
}

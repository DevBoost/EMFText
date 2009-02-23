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
import org.emftext.runtime.EMFTextPlugin;
import org.emftext.runtime.resource.IReferenceResolver;
import org.emftext.runtime.resource.IReferenceResolveResult;
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

		EClass type     = reference.getEReferenceType();
		EObject root = findRoot(container);
		for (Iterator<EObject> i = root.eAllContents(); i.hasNext(); ) {
			EObject element = i.next();
			if (!element.eIsProxy()) {
				EClass eClass = element.eClass();
				if (eClass.equals(type) || eClass.getEAllSuperTypes().contains(type)) {
					final String match = matches(element, identifier, resolveFuzzy);
					if (match != null) {
						result.addMapping(match, (ReferenceType) element);
						if (!resolveFuzzy) {
							return;
						}
					}
				}
			}
		}
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
		if (nameAttr instanceof EAttribute) {
			return (String) element.eGet(nameAttr);
		}
		else {
			//try any other string attribute found
			for(EAttribute strAttribute : element.eClass().getEAllAttributes()) {
				if (strAttribute.getEType().getInstanceClassName().equals(java.lang.String.class.getName())) {
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
			EMFTextPlugin.logError("Exception while matching proxy URI.", e);
		} catch (NoSuchMethodException e) {
			EMFTextPlugin.logError("Exception while matching proxy URI.", e);
		} catch (IllegalArgumentException e) {
			EMFTextPlugin.logError("Exception while matching proxy URI.", e);
		} catch (IllegalAccessException e) {
			EMFTextPlugin.logError("Exception while matching proxy URI.", e);
		} catch (InvocationTargetException e) {
			EMFTextPlugin.logError("Exception while matching proxy URI.", e);
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

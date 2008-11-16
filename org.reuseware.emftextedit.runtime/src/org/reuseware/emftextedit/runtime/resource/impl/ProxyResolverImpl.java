package org.reuseware.emftextedit.runtime.resource.impl;

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
import org.reuseware.emftextedit.runtime.resource.ProxyResolver;
import org.reuseware.emftextedit.runtime.resource.TextResource;

/**
 * Base implementation for all generated proxy resolvers. 
 * It implements the specifications from {@link ProxyResolver}.
 * 
 * @author Jendrik Johannes (jj2)
 */
public class ProxyResolverImpl implements ProxyResolver {

	private Map<?, ?> options;

	public ProxyResolverImpl() {
		init();
	}
	
	protected void init() {
	}
	
	public EObject resolve(EObject proxy, EObject container,
			EReference reference, TextResource resource) {
		return resolve(proxy, container, reference, resource, true);
	}

	public EObject resolve(EObject proxy, EObject container,
			EReference reference, TextResource resource, boolean reportErrors) {
		
		if (!((InternalEObject)proxy).eIsProxy()) {
			return proxy;
		}
		
		EObject element = doResolve((InternalEObject)proxy, container, reference, resource);
		EClass type     = reference.getEReferenceType();	
		if (element == null || (!element.eClass().equals(type) && 
				!element.eClass().getEAllSuperTypes().contains(type))) {

			if (reportErrors) {
				String msg = produceResolveErrorMessage((InternalEObject)proxy, container, reference, resource);
				resource.addError(msg, proxy);
			}
			return null;
		}
		
		return element;
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
	 * @return The resolved object or null if resolving fails.
	 */
	protected EObject doResolve(InternalEObject proxy, EObject container,
			EReference reference, TextResource resource) {
		
		//TODO trivial implementation - enhancements:
		//      - take tree depths into account
		//      - use not only name attribute (e.g. "id", or only existing String attribute)
	
		EClass type     = reference.getEReferenceType();
		String proxyURI = proxy.eProxyURI().fragment();

		for(Iterator<EObject> i = resource.getAllContents(); i.hasNext(); ) {
			EObject element = i.next();
			if (!element.eIsProxy()) {
				if (element.eClass().equals(type) || element.eClass().getEAllSuperTypes().contains(type)) {
					if (matches(element, proxyURI)) {
						return element;
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * This method is called by <code>resolve()</code>. Clients may or may not override
	 * it manually.
	 * This method is called if error reporting is activated and a proxy resolving failed.
	 * This implementation produces a standard error message using the reference type
	 * and the proxy URI fragment.
	 * 
	 * @param proxy The proxy.
	 * @param container The object referencing the proxy.
	 * @param reference The reference that holds the proxy.
	 * @param resource  The resource containing the proxy and replacement candidates. 
	 * @return The error message.
	 */
	protected String produceResolveErrorMessage(InternalEObject proxy, EObject container,
			EReference reference, TextResource resource) {
		String msg = getClass().getSimpleName() + ": " + reference.getEType().getName() + " \"" + proxy.eProxyURI().fragment() + "\" not declared";  
		return msg;
		
	}
	
	protected String produceDeResolveErrorMessage(EObject refObject, EObject container,
			EReference reference, TextResource resource) {
		
		String msg = getClass().getSimpleName() + ": " + reference.getEType().getName() + " \"" + refObject.toString() + "\" not de-resolveable";  
		return msg;
		
	}
	
	protected String doDeResolve(EObject element, EObject container,
			EReference reference) {
		return getName(element);
	}
	
	private boolean matches(EObject element, String proxyUri) {
		EStructuralFeature nameAttr = element.eClass().getEStructuralFeature("name");
		if (nameAttr instanceof EAttribute) {
			if (proxyUri.equals(element.eGet(nameAttr))) return true;
		}
		else {
			//try any other string attribute found
			for(EAttribute strAttribute : element.eClass().getEAllAttributes()) {
				if (strAttribute.getEType().getInstanceClassName().equals("java.lang.String")) {
					if (proxyUri.equals(element.eGet(strAttribute))) return true;
				}
			}
			
			for (EOperation o : element.eClass().getEAllOperations()) {
				if (o.getName().toLowerCase().endsWith("name") && o.getEParameters().size() == 0 ) {
					Method method;
					try {
						method = element.getClass().getMethod(o.getName(), new Class[]{});
						if (method != null) {
							Object result = method.invoke(element, new Object[]{});
							if (proxyUri.equals(result)) return true;
						}
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			
		}
		return false;
	}

	private String getName(EObject element) {
		EStructuralFeature nameAttr = element.eClass().getEStructuralFeature("name");
		if (nameAttr instanceof EAttribute) {
			return (String) element.eGet(nameAttr);
		}
		else {
			//try any other string attribute found
			for(EAttribute strAttribute : element.eClass().getEAllAttributes()) {
				if (strAttribute.getEType().getInstanceClassName().equals("java.lang.String")) {
					return (String) element.eGet(strAttribute);
				}
			}
			
			for (EOperation o : element.eClass().getEAllOperations()) {
				if (o.getName().toLowerCase().endsWith("name") && o.getEParameters().size() == 0 ) {
					Method method;
					try {
						method = element.getClass().getMethod(o.getName(), new Class[]{});
						if (method != null) {
							Object result = method.invoke(element, new Object[]{});
							return (String) result;
						}
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			
		}
		return null;
	}

	
	public String deResolve(EObject element, EObject container,
			EReference reference) {
		return doDeResolve(element,container,reference);
	}

	public void setOptions(Map<?, ?> options) {
		this.options = options;
	}

	public Map<?, ?> getOptions() {
		return options;
	}
}

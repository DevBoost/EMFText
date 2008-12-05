package org.reuseware.emftextedit.runtime.resource.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.reuseware.emftextedit.runtime.resource.EMFTextTreeAnalyser;
import org.reuseware.emftextedit.runtime.resource.ElementMapping;
import org.reuseware.emftextedit.runtime.resource.IdentifierMapping;
import org.reuseware.emftextedit.runtime.resource.ReferenceMapping;
import org.reuseware.emftextedit.runtime.resource.ResolveResult;
import org.reuseware.emftextedit.runtime.resource.TextResource;

/**
 * Base implementation for all generated tree analysers. 
 * It implements the specifications from {@link EMFTextTreeAnalyser}.
 * 
 * @author Jendrik Johannes (jj2)
 */
public abstract class EMFTextTreeAnalyserImpl implements EMFTextTreeAnalyser {
	
	private final static String DUPLICATE_EXCEPTION_MESSAGE = "The 'no duplicates' constraint is violated";
	
	private class UnresolvedProxy {
		private final EObject proxy;
		private final EObject container;
		private final EReference reference;
		private final InternalEList<EObject> list;
		private ResolveResult result;
		
		public UnresolvedProxy(EObject proxy, EObject container,
				EReference reference, InternalEList<EObject> list) {
			super();
			this.proxy = proxy;
			this.container = container;
			this.reference = reference;
			this.list = list;
		}
		
		public ResolveResult getResolveResult() {
			return result;
		}

		public void setResolveResult(ResolveResult result) {
			assert !result.wasResolved();
			this.result = result;
		}

		public EObject getProxy() {
			return proxy;
		}

		public EObject getContainer() {
			return container;
		}

		public EReference getReference() {
			return reference;
		}

		public InternalEList<EObject> getList() {
			return list;
		}
	}
	
	public void analyse(TextResource resource) {
		// collect an initial set of unresolved proxies
		List<UnresolvedProxy> unresolvedProxies = getUnresolvedProxies(resource);
		// prepare a set of resolved proxies that can be thrown away after one iteration
		List<UnresolvedProxy> resolvedProxies = new ArrayList<UnresolvedProxy>(); 

		// stop flag for fix-point iteration
		boolean changed = true;
		// stop the fix-point iteration if the set has not changed or all proxies are resolved
		while (changed && unresolvedProxies.size() > 0) {
			changed = false;
			resolvedProxies.clear();
			// try to resolve each proxy in the current list of unresolved proxies
			for (UnresolvedProxy nextProxy : unresolvedProxies) {
				tryToResolve(nextProxy);
				boolean wasResolved = nextProxy.getResolveResult().wasResolved();
				if (wasResolved) {
					resolvedProxies.add(nextProxy);
					changed = true;
				}
			}
			
			// remove the resolved proxies from the set of unresolved proxies
			unresolvedProxies.removeAll(resolvedProxies);
		}
		
		// mark errors for the remaining unresolved proxies
		attachErrors(resource, unresolvedProxies);
	}

	private void attachErrors(TextResource resource,
			List<UnresolvedProxy> unresolvedProxies) {
		// attach errors to resource
		for (UnresolvedProxy unresolvedProxy : unresolvedProxies) {
			ResolveResult result = unresolvedProxy.getResolveResult();
			assert result != null;
			String errorMessage = result.getErrorMessage();
			if (errorMessage == null) {
				resource.addError(getErrorMessage(((InternalEObject) unresolvedProxy).eProxyURI().fragment()), unresolvedProxy.getProxy());
			} else {
				resource.addError(errorMessage, unresolvedProxy.getProxy());
			}
		}
	}

	private List<UnresolvedProxy> getUnresolvedProxies(TextResource resource) {
		List<UnresolvedProxy> unresolvedProxies = new ArrayList<UnresolvedProxy>();
		
		for (Iterator<EObject> it = resource.getAllContents(); it.hasNext();) {
			EObject container = it.next();
			for (EStructuralFeature sf : container.eClass().getEAllStructuralFeatures()) {
				
				if (sf instanceof EReference) {
					EReference reference = (EReference) sf;
					Object value = container.eGet(reference, false);
					
					if (value instanceof InternalEList<?>) {
						InternalEList<EObject> list = castTo(value);
						//iterate over a list copy with unresolved value
						final Iterator<?> iterator = list.basicList().iterator();
						while (iterator.hasNext()) {
							Object nextObject = iterator.next();
							if (!(nextObject instanceof EObject)) {
								continue;
							}
							EObject proxy = (EObject) nextObject;
							if (!proxy.eIsProxy()) {
								continue;
							}
							unresolvedProxies.add(new UnresolvedProxy(proxy, container, reference, list));
						}
					} else if (value != null && ((EObject) value).eIsProxy()) {
						EObject proxy = (EObject) value;
						unresolvedProxies.add(new UnresolvedProxy(proxy, container, reference, null));
					}
				}
			}
		}
		return unresolvedProxies;
	}

	@SuppressWarnings("unchecked")
	private InternalEList<EObject> castTo(Object value) {
		return (InternalEList<EObject>) value;
	}
	
	private void tryToResolve(UnresolvedProxy unresolvedProxy) {
		InternalEList<EObject> list = unresolvedProxy.getList();
		if (list == null) {
			tryToResolveObject(unresolvedProxy);
		} else {
			tryToResolveListItem(unresolvedProxy);
		}
	}

	private void tryToResolveListItem(UnresolvedProxy unresolvedProxy) {
		EObject proxy = unresolvedProxy.getProxy();
		EObject container = unresolvedProxy.getContainer();
		EReference reference = unresolvedProxy.getReference();
		InternalEList<EObject> list = unresolvedProxy.getList();
		
		if (!isInternalProxy(proxy, container)) {
			return;
		}
		ResolveResult result = new ResolveResultImpl();
		resolve(getFragment(proxy), container, 
				reference, list.indexOf(proxy), false, result);
		unresolvedProxy.setResolveResult(result);
		
		assert result != null;
		if (result.wasResolved()) {
			int proxyPosition = list.indexOf(proxy);
			boolean success = list.remove(proxy);
			assert success;
			for (ReferenceMapping mapping : result.getMappings()) {
				EObject target = null;
				if (mapping instanceof ElementMapping) {
					target = ((ElementMapping) mapping).getTargetElement();
				} else if (mapping instanceof IdentifierMapping) {
					target = EcoreUtil.copy(proxy);
					String uri = ((IdentifierMapping) mapping).getTargetIdentifier();
					((InternalEObject) target).eSetProxyURI(URI.createURI(uri));
				} else {
					assert false;
				}
				try {
					if (proxyPosition == list.size()) {
						list.add(target);
					} else {
						list.add(proxyPosition, target);
					}
					return;
				} catch (IllegalArgumentException iae) {
					if (DUPLICATE_EXCEPTION_MESSAGE.equals(iae.getMessage())) {
						((TextResource) container.eResource()).addError("Reference " + container.eClass().getName() + "." + reference.getName() + " is unique, but same element of type " + target.eClass().getName() + " was found twice.", proxy);
					} else {
						iae.printStackTrace();
					}
				}
			}
		}
		return;
	}

	private void tryToResolveObject(UnresolvedProxy unresolvedProxy) {
		EObject proxy = unresolvedProxy.getProxy();
		EObject container = unresolvedProxy.getContainer();
		EReference reference = unresolvedProxy.getReference();
		
		if (!isInternalProxy(proxy, container)) {
			return;
		}
		ResolveResult result = new ResolveResultImpl();
		resolve(getFragment(proxy), container, reference, 0, false, result);
		unresolvedProxy.setResolveResult(result);
		
		assert result != null;
		if (!result.wasResolved()) {
			// do nothing
		} else if (result.wasResolvedUniquely()) {
			ReferenceMapping mapping = result.getMappings().iterator().next();
			if (mapping instanceof ElementMapping) {
				EObject target = ((ElementMapping) mapping).getTargetElement();
				container.eSet(reference, target);
			} else if (mapping instanceof IdentifierMapping) {
				String uri = ((IdentifierMapping) mapping).getTargetIdentifier();
				((InternalEObject) proxy).eSetProxyURI(URI.createURI(uri));
			} else {
				assert false;
			}
			return;
		} else {
			// TODO mseifert: add error if multiple objects returned by a resolver
		}
		return;
	}

	private String getFragment(EObject proxy) {
		return ((InternalEObject) proxy).eProxyURI().fragment();
	}

	private boolean isInternalProxy(EObject proxy, EObject container) {
		return ((InternalEObject) proxy).eProxyURI().trimFragment().equals(container.eResource().getURI());
	}

	/**
	 * Produces a standard error message using the reference type
	 * and the proxy URI fragment.
	 * 
	 * @param identifier The proxy.
	 * @param container The object referencing the proxy.
	 * @param reference The reference that holds the proxy.
	 * @param resource  The resource containing the proxy and replacement candidates. 
	 * @return The error message.
	 */
	private String getErrorMessage(String identifier) {
		return " \"" + identifier + "\" not declared";  
	}
}

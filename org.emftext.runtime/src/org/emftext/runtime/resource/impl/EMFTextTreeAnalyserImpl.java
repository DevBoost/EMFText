package org.emftext.runtime.resource.impl;

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
import org.emftext.runtime.resource.EMFTextTreeAnalyser;
import org.emftext.runtime.resource.ElementMapping;
import org.emftext.runtime.resource.URIMapping;
import org.emftext.runtime.resource.ReferenceMapping;
import org.emftext.runtime.resource.ResolveResult;
import org.emftext.runtime.resource.TextResource;
import org.emftext.runtime.resource.TextDiagnostic.TextDiagnosticType;

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
			assert this.result == null || !this.result.wasResolved();
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
	/* TODO delete this method and all calls in to it in generator
	 
	   // collect an initial set of unresolved proxies
	 
		List<UnresolvedProxy> unresolvedProxies = getUnresolvedProxies(resource);
		// prepare a set of resolved proxies that can be thrown away after one iteration
		List<UnresolvedProxy> resolvedProxiesInIteration = new ArrayList<UnresolvedProxy>();
		List<UnresolvedProxy> allResolvedProxies = new ArrayList<UnresolvedProxy>();

		// stop flag for fix-point iteration
		boolean changed = true;
		// stop the fix-point iteration if the set has not changed or all proxies are resolved
		while (changed && unresolvedProxies.size() > 0) {
			changed = false;
			resolvedProxiesInIteration.clear();
			// try to resolve each proxy in the current list of unresolved proxies
			for (UnresolvedProxy nextProxy : unresolvedProxies) {
				tryToResolve(nextProxy);
				boolean wasResolved = nextProxy.getResolveResult().wasResolved();
				if (wasResolved) {
					resolvedProxiesInIteration.add(nextProxy);
					changed = true;
				}
			}
			
			// remove the resolved proxies from the set of unresolved proxies
			unresolvedProxies.removeAll(resolvedProxiesInIteration);
			allResolvedProxies.addAll(resolvedProxiesInIteration);
		}
		
		// mark errors for the remaining unresolved proxies
		attachErrors(resource, unresolvedProxies);
		// mark warnings for all resolved proxies
		attachWarnings(resource, allResolvedProxies);
		*/
	}

	private void attachErrors(TextResource resource,
			List<UnresolvedProxy> unresolvedProxies) {
		// attach errors to resource
		for (UnresolvedProxy unresolvedProxy : unresolvedProxies) {
			ResolveResult result = unresolvedProxy.getResolveResult();
			assert result != null;
			String errorMessage = result.getErrorMessage();
			final EObject proxy = unresolvedProxy.getProxy();
			if (errorMessage == null) {
				assert(false);
			} else {
				resource.addError(errorMessage, proxy, TextDiagnosticType.RESOLVE_PROBLEM);
			}
		}
	}

	private void attachWarnings(TextResource resource,
			List<UnresolvedProxy> resolvedProxies) {
		for (UnresolvedProxy resolvedProxy : resolvedProxies) {
			ResolveResult result = resolvedProxy.getResolveResult();
			assert result != null;
			assert result.wasResolved();
			final EObject proxy = resolvedProxy.getProxy();
			
			for (ReferenceMapping mapping : result.getMappings()) {
				String warningMessage = mapping.getWarning();
				if (warningMessage == null) {
					continue;
				}
				if (mapping instanceof ElementMapping) {
					final EObject target = ((ElementMapping) mapping).getTargetElement();
					resource.addWarning(warningMessage, target);
				} else if (mapping instanceof URIMapping) {
					resource.addWarning(warningMessage, proxy);
				} else {
					assert false;
				}
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
		ResolveResult result = new ResolveResultImpl(false);
		//set an initial default error message
		result.setErrorMessage(getErrorMessage(proxy, reference));
		
		resolve(getFragment(proxy), container, 
				reference, list.basicIndexOf(proxy), false, result);
		unresolvedProxy.setResolveResult(result);
		
		assert result != null;
		if (result.wasResolved()) {
			int proxyPosition = list.basicIndexOf(proxy);
			//use the position rather than the object to call remove, resolve() might be called for the element
			list.remove(proxyPosition);
			for (ReferenceMapping mapping : result.getMappings()) {
				EObject target = null;
				if (mapping instanceof ElementMapping) {
					target = ((ElementMapping) mapping).getTargetElement();
				} else if (mapping instanceof URIMapping) {
					target = EcoreUtil.copy(proxy);
					URI uri = ((URIMapping) mapping).getTargetIdentifier();
					((InternalEObject) target).eSetProxyURI(uri);
				} else {
					assert false;
				}
				try {
					if (proxyPosition == list.size()) {
						list.add(target);
					} else {
						//TODO jjohannes: if target is an external proxy and list is "unique" 
						//     add() will try to resolve the external proxy to check for uniqueness.
						//     That should be avoided somehow...
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
		ResolveResult result = new ResolveResultImpl(false);
		//set an initial default error message
		result.setErrorMessage(getErrorMessage(proxy, reference));
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
			} else if (mapping instanceof URIMapping) {
				URI uri = ((URIMapping) mapping).getTargetIdentifier();
				((InternalEObject) proxy).eSetProxyURI(uri);
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
		return ((InternalEObject) proxy).eProxyURI().trimFragment().toString().equals(container.eResource().getURI().toString());
	}

	/**
	 * Produces a standard error message using the reference type
	 * and the proxy URI fragment.
	 * 
	 * @param proxy The proxy.
	 * @param reference The reference that holds the proxy.
	 * @return The error message.
	 */
	private String getErrorMessage(EObject proxy, EReference reference) {
		String identifier = ((InternalEObject)proxy).eProxyURI().fragment();
		String typeName   = reference.getEType().getName();
		String msg = typeName + " '" + identifier + "' not declared";  
		return msg;
	}
}

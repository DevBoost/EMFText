package org.emftext.runtime.resource.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.runtime.EMFTextPlugin;
import org.emftext.runtime.IOptionProvider;
import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.IResourcePostProcessorProvider;
import org.emftext.runtime.resource.IContextDependentURIFragment;
import org.emftext.runtime.resource.IElementMapping;
import org.emftext.runtime.resource.ILocationMap;
import org.emftext.runtime.resource.IReferenceMapping;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.ITextDiagnostic;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.IURIMapping;

/**
 * Base implementation for all generated text resources. 
 * It implements the specifications from {@link ITextResource}.
 * 
 * @author Jendrik Johannes <jendrik.johannes@tu-dresden.de>
 */
public abstract class AbstractTextResource extends ResourceImpl implements ITextResource {
	
	private static final String ARBITRARY_SYNTAX_NAME = "*";

	private ILocationMap locationMap = new LocationMap();
	
	private Map<String, IContextDependentURIFragment<? extends EObject>> internalURIFragmentMap =
		new HashMap<String, IContextDependentURIFragment<? extends EObject>>();
	
    private int proxyCounter = 0;
    
	public <ReferenceType extends EObject> void registerContextDependentProxy(EObject container, EReference reference, String id, EObject proxyElement) {
		int pos = -1;
		if (reference.isMany()) {
			pos = ((List<?>)container.eGet(reference)).size();
		}
		InternalEObject proxy = (InternalEObject) proxyElement; 
		String internalURIFragment = IContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX + proxyCounter++ + "_" + id;
		IContextDependentURIFragment<? extends EObject> uriFragment = new ContextDependentURIFragment<ReferenceType>(
				id,
				container,
				reference,
				pos,
				proxy
			);
		proxy.eSetProxyURI(this.getURI().appendFragment(internalURIFragment));
		internalURIFragmentMap.put(internalURIFragment, uriFragment);
	}

	@Override
	public EObject getEObject(String id) {
		if (internalURIFragmentMap.containsKey(id)) {
			IContextDependentURIFragment<? extends EObject> uriFragment = 
				internalURIFragmentMap.get(id);

			boolean wasResolvedBefore = uriFragment.isResolved();
			IReferenceResolveResult<? extends EObject> result = uriFragment.resolve(getReferenceResolverSwitch());
			
			if (result == null) {
				//the resolving did call itself
				return null;
			}
			
			if (!wasResolvedBefore && !result.wasResolved()) {
				attachErrors(result, uriFragment.getProxy());
				return null;
			}
			else if (!result.wasResolved()) {
				return null;
			}
			else {
				//remove an error that might have been added by an earlier attempt
				removeError(uriFragment.getProxy());
				attachWarnings(result);

				IReferenceMapping mapping = result.getMappings().iterator().next();
				
				return getResultElement(uriFragment, mapping);
			}
		}
		else {
			return super.getEObject(id);
		}
	}

	private EObject getResultElement(IContextDependentURIFragment<? extends EObject> uriFragment,
			IReferenceMapping mapping) {
		if (mapping instanceof IURIMapping) {
			return this.getResourceSet().getEObject(((IURIMapping)mapping).getTargetIdentifier(), true);
		}
		else if (mapping instanceof IElementMapping) {
			EObject element = ((IElementMapping<? extends EObject>)mapping).getTargetElement();
			EReference reference = uriFragment.getReference();
			EReference oppositeReference = uriFragment.getReference().getEOpposite();
			if (!uriFragment.getReference().isContainment() && oppositeReference != null) {
				if (reference.isMany()) {
					EObjectWithInverseResolvingEList.ManyInverse<EObject> list = Util.cast(element.eGet(oppositeReference, false));					
					//avoids duplicate entries in the reference caused by adding to the oppositeReference 
					list.basicAdd(uriFragment.getContainer(),null);
					
				}
				else {
					uriFragment.getContainer().eSet(uriFragment.getReference(), element);
				}
			}
			return element;
		}
		else {
			assert(false);
			return null;
		}
	}

	private void removeError(EObject proxy) {
		// attach errors to resource
		for(Diagnostic errorCand : new BasicEList<Diagnostic>(getErrors())) {
			if(errorCand instanceof ITextDiagnostic) {
				if(((ITextDiagnostic) errorCand).wasCausedBy(proxy)) {
					getErrors().remove(errorCand);
				}
			}
		}
	}
	
	private void attachErrors(IReferenceResolveResult<?> result, EObject proxy) {
		// attach errors to resource
		assert result != null;
		String errorMessage = result.getErrorMessage();
		if (errorMessage == null) {
			assert(false);
		} else {
			addError(errorMessage, proxy);
		}
	}

	private void attachWarnings(IReferenceResolveResult<? extends EObject> result) {
		assert result != null;
		assert result.wasResolved();
		
		if (result.wasResolved()) {
			for (IReferenceMapping mapping : result.getMappings()) {
				String warningMessage = mapping.getWarning();
				if (warningMessage == null) {
					continue;
				}
				if (mapping instanceof IElementMapping) {
					final EObject target = ((IElementMapping<? extends EObject>) mapping).getTargetElement();
					addWarning(warningMessage, target);
				} else {
					assert false;
				}
			}
		}
	}
	
	/**
	 * Extends the super implementation by clearing all information about element
	 * positions.
	 */
	protected void doUnload() {
		super.doUnload();
		
		//clear concrete syntax information
		locationMap = new LocationMap();
		internalURIFragmentMap.clear();
		proxyCounter = 0;
	}
	
	@Override
	public void load(Map<?, ?> options) throws IOException {
		boolean wasLoaded = !isLoaded;
		java.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(options);
		super.load(loadOptions);

		if (wasLoaded) {
			Object resourcePostProcessorProvider = loadOptions.get(org.emftext.runtime.IOptions.RESOURCE_POSTPROCESSOR_PROVIDER);
			if (resourcePostProcessorProvider != null) {
				if (resourcePostProcessorProvider instanceof org.emftext.runtime.IResourcePostProcessorProvider) {
					((org.emftext.runtime.IResourcePostProcessorProvider) resourcePostProcessorProvider).getResourcePostProcessor().process(this);
				} else if (resourcePostProcessorProvider instanceof Collection) {
					@SuppressWarnings("unchecked")
					Collection<IResourcePostProcessorProvider> resourcePostProcessorProviderCollection = (Collection<IResourcePostProcessorProvider>) resourcePostProcessorProvider;
					for (IResourcePostProcessorProvider processorProvider : resourcePostProcessorProviderCollection) {
						IResourcePostProcessor postProcessor = processorProvider.getResourcePostProcessor();
						try {
							postProcessor.process(this);
						} catch (Exception e) {
							EMFTextPlugin.logError("Exception while running a post-processor.", e);
						}
					}
				}
			}
			
		
		}
	}

	/**
	 * Creates a empty instance.
	 */
	public AbstractTextResource() {
		super();
	}

	/**
	 * Creates an instance with the given URI.
	 * 
	 * @param uri The URI.
	 */
	public AbstractTextResource(URI uri) {
		super(uri);	
	}
	
	public void setURI(URI uri) {
		//because of the context dependent proxy resolving it is 
		//essential to resolve all proxies before the URI is changed
		//which can cause loss of object identities
		EcoreUtil.resolveAll(this);
		super.setURI(uri);
	}
	
	public ILocationMap getLocationMap() {
		return locationMap;
	}
	  
	public void addError(String message, EObject element) {
		getErrors().add(new ElementBasedTextDiagnostic(locationMap, getURI(), message, element));
	}
	
	public void addError(String message, int column, int line, int charStart,
			int charEnd) {
		getErrors().add(new PositionBasedTextDiagnostic(getURI(), message, column, line, charStart, charEnd));
	}

	public void addWarning(String message, EObject element) {
		getWarnings().add(new ElementBasedTextDiagnostic(locationMap, getURI(), message, element));
	}
	
	public void addWarning(String message, int column, int line, int charStart,
			int charEnd) {
		getWarnings().add(new PositionBasedTextDiagnostic(getURI(), message, column, line, charStart, charEnd));
	}
	
	protected Map<Object, Object> addDefaultLoadOptions(Map<?, ?> loadOptions) {
		Map<Object, Object> loadOptionsCopy = copySafelyToObjectToObjectMap(loadOptions); 
		if (Platform.isRunning()) {
			// find default load option providers
			IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
			IConfigurationElement configurationElements[] = extensionRegistry.getConfigurationElementsFor(EMFTextPlugin.EP_DEFAULT_LOAD_OPTIONS_ID);
			for (IConfigurationElement element : configurationElements) {
				try {
					String csName = element.getAttribute(IOptionProvider.CS_NAME);
					if (getSyntaxName().equals(csName) || ARBITRARY_SYNTAX_NAME.equals(csName)) {
						IOptionProvider provider = (IOptionProvider) element.createExecutableExtension("class");//$NON-NLS-1$
						final Map<?, ?> options = provider.getOptions();
						final Collection<?> keys = options.keySet();
						for (Object key : keys) {
							addLoadOption(loadOptionsCopy, key, options.get(key));
						}
						
					} else {
						continue;
					}
					
				} catch (CoreException ce) {
					EMFTextPlugin.logError("Exception while getting default options.", ce);
				}
			}
		}
		return loadOptionsCopy;
	}

	protected abstract String getSyntaxName();

	/**
	 * Adds a new key,value pair to the list of options. If there
	 * is already an option with the same key, the two values are 
	 * collected in a list.
	 * 
	 * @param options
	 * @param key
	 * @param value
	 */
	private void addLoadOption(Map<Object, Object> options,
			Object key, Object value) {
		// check if there is already an option set
		if (options.containsKey(key)) {
			Object currentValue = options.get(key);
			if (currentValue instanceof List) {
				// if the current value is a list, we add the new value to
				// this list
				List<?> currentValueAsList = (List<?>) currentValue;
				List<Object> currentValueAsObjectList = copySafelyToObjectList(currentValueAsList);
				if (value instanceof Collection) {
					currentValueAsObjectList.addAll((Collection<?>) value);
				}
				else {
					currentValueAsObjectList.add(value);
				}
				
				options.put(key, currentValueAsObjectList);
			} else {
				// if the current value is not a list, we create a fresh list
				// and add both the old (current) and the new value to this list
				List<Object> newValueList = new ArrayList<Object>();
				newValueList.add(currentValue);
				if (value instanceof Collection) {
					newValueList.addAll((Collection<?>) value);
				}
				else {
					newValueList.add(value);
				}
				
				options.put(key, newValueList);
			}
		} else {
			options.put(key, value);
		}
	}

	protected Map<Object, Object> copySafelyToObjectToObjectMap(Map<?, ?> map) {
		Map<Object, Object> castedCopy = new HashMap<Object, Object>();
		
		if(map == null) {
			return castedCopy;
		}
		
		Iterator<?> it = map.keySet().iterator();
		while (it.hasNext()) {
			Object nextKey = it.next();
			castedCopy.put(nextKey, map.get(nextKey));
		}
		return castedCopy;
	}

	private List<Object> copySafelyToObjectList(List<?> list) {
		Iterator<?> it = list.iterator();
		List<Object> castedCopy = new ArrayList<Object>();
		while (it.hasNext()) {
			castedCopy.add(it.next());
		}
		return castedCopy;
	}
}

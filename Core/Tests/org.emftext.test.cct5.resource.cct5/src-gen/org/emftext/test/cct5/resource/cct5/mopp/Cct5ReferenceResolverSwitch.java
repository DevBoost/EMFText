/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class Cct5ReferenceResolverSwitch implements org.emftext.test.cct5.resource.cct5.ICct5ReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private Map<Object, Object> options;
	
	
	public void setOptions(Map<?, ?> options) {
		if (options != null) {
			this.options = new LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
	}
	
	public void resolveFuzzy(String identifier, EObject container, EReference reference, int position, org.emftext.test.cct5.resource.cct5.ICct5ReferenceResolveResult<EObject> result) {
		if (container == null) {
			return;
		}
	}
	
	public org.emftext.test.cct5.resource.cct5.ICct5ReferenceResolver<? extends EObject, ? extends EObject> getResolver(EStructuralFeature reference) {
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public <ContainerType extends EObject, ReferenceType extends EObject> org.emftext.test.cct5.resource.cct5.ICct5ReferenceResolver<ContainerType, ReferenceType> getResolverChain(EStructuralFeature reference, org.emftext.test.cct5.resource.cct5.ICct5ReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(org.emftext.test.cct5.resource.cct5.ICct5Options.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof Map)) {
			// send this to the error log
			new org.emftext.test.cct5.resource.cct5.util.Cct5RuntimeUtil().logWarning("Found value with invalid type for option " + org.emftext.test.cct5.resource.cct5.ICct5Options.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		Map<?,?> resolverMap = (Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof org.emftext.test.cct5.resource.cct5.ICct5ReferenceResolver) {
			org.emftext.test.cct5.resource.cct5.ICct5ReferenceResolver replacingResolver = (org.emftext.test.cct5.resource.cct5.ICct5ReferenceResolver) resolverValue;
			if (replacingResolver instanceof org.emftext.test.cct5.resource.cct5.ICct5DelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((org.emftext.test.cct5.resource.cct5.ICct5DelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof Collection) {
			Collection replacingResolvers = (Collection) resolverValue;
			org.emftext.test.cct5.resource.cct5.ICct5ReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof org.emftext.test.cct5.resource.cct5.ICct5ReferenceCache) {
					org.emftext.test.cct5.resource.cct5.ICct5ReferenceResolver nextResolver = (org.emftext.test.cct5.resource.cct5.ICct5ReferenceResolver) next;
					if (nextResolver instanceof org.emftext.test.cct5.resource.cct5.ICct5DelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((org.emftext.test.cct5.resource.cct5.ICct5DelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new org.emftext.test.cct5.resource.cct5.util.Cct5RuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.emftext.test.cct5.resource.cct5.ICct5Options.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.emftext.test.cct5.resource.cct5.ICct5DelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new org.emftext.test.cct5.resource.cct5.util.Cct5RuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.emftext.test.cct5.resource.cct5.ICct5Options.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.emftext.test.cct5.resource.cct5.ICct5DelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}

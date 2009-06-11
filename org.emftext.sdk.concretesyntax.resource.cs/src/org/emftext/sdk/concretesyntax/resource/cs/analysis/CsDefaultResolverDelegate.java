package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.emftext.runtime.resource.IContextDependentURIFragment;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.util.EObjectUtil;

public class CsDefaultResolverDelegate<ContainerType extends EObject, ReferenceType extends EObject> {

	public final static String NAME_FEATURE = "name";

	/**
	 * This standard implementation searches the tree for objects of the 
	 * correct type with a name attribute matching the identifier.
	 * 
	 * @param identifier the name to search for.
	 * @param container the object referencing the proxy.
	 * @param reference the reference that holds the proxy.
	 * @param resolveFuzzy
	 *  
	 * @return The resolved object or null if resolving fails.
	 */
	protected void resolve(String identifier, ContainerType container,
			EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<ReferenceType> result) {

		try {
			EClass type = reference.getEReferenceType();
			EObject root = EObjectUtil.findRootContainer(container);
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
		} catch (RuntimeException rte) {
			// catch exception here to prevent EMF proxy resolution from swallowing it
			rte.printStackTrace();
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
	
	protected String produceDeResolveErrorMessage(EObject refObject, EObject container,
			EReference reference, ITextResource resource) {
		
		String msg = getClass().getSimpleName() + ": " + reference.getEType().getName() + " \"" + refObject.toString() + "\" not de-resolveable";  
		return msg;
		
	}
	
	protected String deResolve(ReferenceType element, ContainerType container,
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
					String result = (String) EObjectUtil.invokeOperation(element, o);
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
					String result = (String) EObjectUtil.invokeOperation(element, o);
					if (result != null) {
						return result;
					}
				}
			}
			
		}
		return null;
	}
}

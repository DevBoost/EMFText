package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.emftext.sdk.concretesyntax.resource.cs.analysis.helper.MetaclassReferenceResolver;

public class ContainmentTypeReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.sdk.concretesyntax.Containment> {

	private MetaclassReferenceResolver resolver = new MetaclassReferenceResolver();
	
	@Override
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.EObject element, org.emftext.sdk.concretesyntax.Containment container, org.eclipse.emf.ecore.EReference reference) {
		return resolver.deResolve(element, container, reference);
	}

	@Override
	protected void doResolve(java.lang.String identifier, org.emftext.sdk.concretesyntax.Containment container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult result) {
		GenClass superType = null;
		if (container.getFeature() != null) {
			superType = container.getFeature().getTypeGenClass();
		}
		resolver.doResolve(identifier, container, reference, position, resolveFuzzy, result, superType, true);
	}
}

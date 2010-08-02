package org.emftext.sdk.quickfixes;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsQuickFix;

/**
 * A quick fix that removes references to a collection of target
 * objects.
 */
public class RemoveReferenceQuickFix extends CsQuickFix {

	private EObject container;
	private EReference reference;
	private List<? extends EObject> targets;

	public RemoveReferenceQuickFix(
			String label, 
			EObject container,
			EReference reference, 
			List<? extends EObject> targets) {
		super(label, "IMG_ELCL_REMOVE", container);
		this.container = container;
		this.reference = reference;
		this.targets = targets;
	}

	@Override
	public void applyChanges() {
		for (EObject target : targets) {
			EcoreUtil.remove(container, reference, target);
		}
	}
}

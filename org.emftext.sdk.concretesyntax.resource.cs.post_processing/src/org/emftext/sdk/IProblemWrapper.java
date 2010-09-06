package org.emftext.sdk;

import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.concretesyntax.resource.cs.ICsProblem;

public interface IProblemWrapper {
	public ICsProblem getProblem();
	public boolean wasCausedBy(EObject element);
}
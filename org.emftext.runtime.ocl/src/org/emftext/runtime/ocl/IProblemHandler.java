package org.emftext.runtime.ocl;

import org.eclipse.emf.ecore.EObject;

public interface IProblemHandler {

	public void addProblem(String message, EObject cause, boolean isError);
}

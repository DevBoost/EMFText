package org.emftext.sdk;

import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

public interface IConcreteSyntaxFinder {
	public ConcreteSyntax findConcreteSyntax(String csURI, Resource resource);
}

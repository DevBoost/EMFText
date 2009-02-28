package org.emftext.sdk.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.IResourcePostProcessorProvider;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.impl.TextResourceHelper;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

public abstract class AbstractAnalyser implements IResourcePostProcessorProvider, IResourcePostProcessor {

	private static final TextResourceHelper resourceHelper = new TextResourceHelper();
	
	public IResourcePostProcessor getResourcePostProcessor() {
		return this;
	}
	
	public void process(ITextResource resource) {
		if (!resourceHelper.resolveAll(resource)) {
			return;
		}
		EList<EObject> objects = resource.getContents();
		for (EObject next : objects) {
			if (next instanceof ConcreteSyntax) {
				analyse(resource, (ConcreteSyntax) next);
			}
		}
	}

	public abstract void analyse(ITextResource resource, ConcreteSyntax syntax);
}

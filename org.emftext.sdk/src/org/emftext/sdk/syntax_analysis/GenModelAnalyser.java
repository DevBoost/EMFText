package org.emftext.sdk.syntax_analysis;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * An analyser that checks whether the EMF generator model referenced
 * by a syntax is valid. If not, an error is raised.
 */
public class GenModelAnalyser extends AbstractPostProcessor {

	public static final String INVALID_GENMODEL_MESSAGE = "The genmodel is invalid. Please reconcile it.";

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		GenPackage genPackage = syntax.getPackage();
		if (genPackage == null) {
			return;
		}
		GenModel genModel = genPackage.getGenModel();
		if (genModel == null) {
			return;
		}
		IStatus status = genModel.validate();
		if (status.getSeverity() == IStatus.ERROR) {
			resource.addError(INVALID_GENMODEL_MESSAGE, 0, 0, 0, 0);
		}
	}
}

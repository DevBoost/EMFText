package org.emftext.sdk.analysis;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

public class GenModelAnalyser extends AbstractAnalyser {

	public static final String INVALID_GENMODEL_MESSAGE = "The genmodel is invalid. Please validate it using the EMF genmodel editor.";

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

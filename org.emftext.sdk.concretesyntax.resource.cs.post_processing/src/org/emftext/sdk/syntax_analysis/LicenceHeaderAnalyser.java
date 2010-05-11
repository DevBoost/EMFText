package org.emftext.sdk.syntax_analysis;

import org.eclipse.emf.common.util.EList;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;
import org.emftext.sdk.util.LicenceHeaderUtil;

public class LicenceHeaderAnalyser extends AbstractPostProcessor {
	
	private LicenceHeaderUtil headerUtil = new LicenceHeaderUtil();

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		String licenceLocation = headerUtil.getLicenceLocation(syntax);
		if (licenceLocation == null) {
			// no licence option given
			return;
		}
		String licenceText = headerUtil.loadLicenceHeaderText(syntax);
		if (licenceText == null) {
			// licence option was given, but the licence file can not be found
			EList<Option> options = syntax.getOptions();
			for (Option option : options) {
				if (option.getType().equals(OptionTypes.LICENCE_HEADER)) {
					addProblem(resource, ECsProblemType.LICENCE_HEADER_NOT_FOUND, "The licence header could not be loaded from the given location.", option);
					break;
				}
			}
		}
	}
}

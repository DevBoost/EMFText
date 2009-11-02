package org.emftext.sdk.syntax_analysis;

import java.util.Collection;

import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil;

/**
 * A post processor that checks whether the syntax contains empty
 * CsStrings, which are not allowed.
 */
public class CsStringAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		Collection<CsString> csStrings = CsEObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getCsString());
		for (CsString csString : csStrings) {
			final String value = csString.getValue();
			if ("".equals(value)) {
				addProblem(resource, ECsProblemType.EMPTY_CS_STRING, "Empty strings are not allowed.", csString);
			}
		}
	}
}

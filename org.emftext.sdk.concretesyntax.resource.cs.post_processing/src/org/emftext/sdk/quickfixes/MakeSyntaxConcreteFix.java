package org.emftext.sdk.quickfixes;

import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsQuickFix;

public class MakeSyntaxConcreteFix extends CsQuickFix {

	private ConcreteSyntax syntax;

	public MakeSyntaxConcreteFix(ConcreteSyntax syntax) {
		super("Remove modifier ABSTRACT", "IMG_ETOOL_DELETE", syntax);
		this.syntax = syntax;
	}

	public void applyChanges() {
		syntax.setModifier(null);
	}
}

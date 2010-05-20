package org.emftext.sdk.codegen.resource.ui.generators;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.IArtifactParameter;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.util.LicenceHeaderUtil;

// TODO mseifert: some of this code is copied from JavaBaseGenerator
public abstract class UIJavaBaseGenerator<ParameterType extends IArtifactParameter<GenerationContext, ParameterType>> extends UIResourceBaseGenerator<ParameterType> {

	private LicenceHeaderUtil licenceHeaderUtil = new LicenceHeaderUtil();

	@Override
	public final void doGenerate(PrintWriter out) {
		super.doGenerate(out);
		JavaComposite sc = new JavaComposite();
		addLicenceHeader(sc);
		generateJavaContents(sc);
		out.write(sc.toString());
	}

	private void addLicenceHeader(StringComposite sc) {
		String licenceText = getLicenceText();
		if (licenceText != null) {
			sc.add(licenceText);
		}
	}

	private String getLicenceText() {
		// check whether the licence header was loaded before and 
		// stored in the context
		if (getContext().getLicenceText() == null) {
			// the licence header was not loaded before
			ConcreteSyntax concreteSyntax = getContext().getConcreteSyntax();
			String licenceHeaderText = licenceHeaderUtil.loadLicenceHeaderText(concreteSyntax);
			if (licenceHeaderText == null) {
				// file was not found - use default text
				licenceHeaderText = JavaBaseGenerator.DEFAULT_LICENCE_HEADER_TEXT;
			}
			// store text in context to avoid unnecessary loading
			getContext().setLicenceText(licenceHeaderText);
		}
		return getContext().getLicenceText();
	}

	public abstract void generateJavaContents(JavaComposite sc);
}

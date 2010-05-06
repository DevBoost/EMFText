package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.util.LicenceHeaderUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

public abstract class JavaBaseGenerator extends BaseGenerator {

	private static final String DEFAULT_LICENCE_HEADER_TEXT = "/**\n" + " * <copyright>\n" + " * </copyright>\n"
	+ " *\n" + " * \n" + " */";

	private LicenceHeaderUtil licenceHeaderUtil = new LicenceHeaderUtil();

	protected JavaBaseGenerator() {
		super();
	}

	public JavaBaseGenerator(GenerationContext context, ArtifactDescriptor<GenerationContext> artifact) {
		super(context, artifact);
	}

	final public boolean generate(PrintWriter out) {
		JavaComposite sc = new JavaComposite();
		addLicenceHeader(sc);
		boolean success = generateJavaContents(sc);
		out.write(sc.toString());
		return success;
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
				licenceHeaderText = DEFAULT_LICENCE_HEADER_TEXT;
			}
			// store text in context to avoid unnecessary loading
			getContext().setLicenceText(licenceHeaderText);
		}
		return getContext().getLicenceText();
	}

	public abstract boolean generateJavaContents(JavaComposite sc);
}

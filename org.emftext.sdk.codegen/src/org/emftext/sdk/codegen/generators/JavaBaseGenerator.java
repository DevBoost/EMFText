package org.emftext.sdk.codegen.generators;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.util.StreamUtil;

public abstract class JavaBaseGenerator extends BaseGenerator {

	protected JavaBaseGenerator() {
		super();
	}

	public JavaBaseGenerator(GenerationContext context, EArtifact artifact) {
		super(context, artifact);
	}

	final public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
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
		// if (getContext() == null) return null;
		String licenceText = getContext().getLicenceText();
		if (licenceText != null)
			return licenceText;
		else {
			ConcreteSyntax concreteSyntax = getContext().getConcreteSyntax();
			String licenceLocation = OptionManager.INSTANCE
					.getStringOptionValue(concreteSyntax,
							OptionTypes.LICENCE_HEADER);
			if (licenceLocation == null) {
				getContext().setLicenceText(
						"/**\n" + " * <copyright>\n" + " * </copyright>\n"
								+ " *\n" + " * \n" + " */");
				return getContext().getLicenceText();
			}
			URI resourceUri = concreteSyntax.eResource().getURI();
			URI liceneUri = URI.createURI(licenceLocation);
			if (liceneUri.isRelative()) {
				liceneUri = liceneUri.resolve(resourceUri);
			}
			try {

				InputStream newFileStream = concreteSyntax.eResource()
						.getResourceSet().getURIConverter().createInputStream(
								liceneUri);
				licenceText = StreamUtil.getContent(newFileStream);
				getContext().setLicenceText(licenceText);
				return getContext().getLicenceText();
			} catch (IOException e) {
				EList<Option> options = concreteSyntax.getOptions();
				for (Option option : options) {
					if (option.getType().equals(OptionTypes.LICENCE_HEADER)) {
						addProblem(new GenerationProblem(
								"The licence header could not be loaded from the given location.",
								option, GenerationProblem.Severity.WARNING, e));
						break;
					}
				}

				getContext().setLicenceText(
						"/**\n" + " * <copyright>\n" + " * </copyright>\n"
								+ " *\n" + " * \n" + " */");
				return getContext().getLicenceText();

			}
		}

	}

	public abstract boolean generateJavaContents(StringComposite sc);
}

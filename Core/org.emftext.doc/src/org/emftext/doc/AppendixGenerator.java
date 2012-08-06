/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.doc;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.resource.cs.CsEProblemSeverity;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;
import org.emftext.sdk.util.StreamUtil;

public class AppendixGenerator {

	public static void main(String[] args) throws IOException {
		generateOptionsTex();
		generateWarningsTex();
		generateSyntaxDependentArtifactsTex();
	}

	private static void generateSyntaxDependentArtifactsTex() throws IOException {
		List<String> syntaxDependentClasses = new ArrayList<String>();
		Field[] fields = TextResourceArtifacts.class.getFields();
		for (Field field : fields) {
			try {
				Object value = field.get(null);
				if (value instanceof ArtifactDescriptor) {
					ArtifactDescriptor<?,?> descriptor = (ArtifactDescriptor<?,?>) value;
					Class<?> generatorClass = descriptor.getGeneratorClass();
					String artifactName = descriptor.getClassNamePrefix() + descriptor.getClassNameSuffix();
					if (generatorClass == null) {
						//System.out.println("Artifact " + field.getName() + " has no generator.");
						continue;
					}
					Annotation annotation = generatorClass.getAnnotation(SyntaxDependent.class);
					if (annotation != null) {
						//System.out.println("Artifact " + artifactName + " is syntax dependent.");
						syntaxDependentClasses.add(artifactName);
					}
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		Collections.sort(syntaxDependentClasses);
		StringBuilder latexCode = new StringBuilder();
		latexCode.append("\\begin{itemize}\n");
		for (String className : syntaxDependentClasses) {
			latexCode.append("\\item \\texttt{" + className+ "}\n");
		}
		latexCode.append("\\end{itemize}\n");
		StreamUtil.setContent(new File("latex" + File.separator + "generated" + File.separator + "SyntaxDependentClasses.tex"), latexCode.toString().getBytes());
	}

	private static void generateOptionsTex() throws IOException {
		StringBuilder latexCode = new StringBuilder();
		List<OptionTypes> values = new ArrayList<OptionTypes>();
		values.addAll(OptionTypes.VALUES);
		Collections.sort(values, new Comparator<OptionTypes>() {
			public int compare(OptionTypes o1, OptionTypes o2) {
				return o1.getLiteral().compareTo(o2.getLiteral());
			}
		});
		int overrideOptions = 0;
		for (OptionTypes optionTypes : values) {
			if (optionTypes.getLiteral().startsWith("override")) {
				overrideOptions++;
			}
		}
		latexCode.append(
			"EMFText currently supports " + values.size() + " code generation options. " +
			"However, most of them (" + overrideOptions + ") are only used to specify which generated artifacts shall be customized. " +
			"Subsequently, a list of all options and their description can be found." +
			"\n\n\\vspace{1cm}"
		);
		
		for (OptionTypes optionType : values) {
			EEnumLiteral enumLiteral = ConcretesyntaxPackage.eINSTANCE.getOptionTypes().getEEnumLiteral(optionType.getName());
			String literal = optionType.getLiteral();
			String documentation = EcoreUtil.getDocumentation(enumLiteral);
			if (documentation == null) {
				System.err.println("ERROR: Cannot find documentation for " + enumLiteral.getEEnum().getName() + "." + enumLiteral.getName());
				return;
			}
			documentation = documentation.replaceAll("<code>(.[^<]*)</code>", "\\\\texttt{$1}");
			documentation = documentation.replace("_", "\\_");
			//System.out.println(literal + " : " + documentation);
			latexCode.append("\\noindent\\texttt{" + literal + "}\n");
			latexCode.append("\\begin{myindentpar}{1cm}\n");
			latexCode.append(documentation);
			latexCode.append("\n");
			latexCode.append("\\end{myindentpar}\n");
			latexCode.append("\n");
		};
		StreamUtil.setContent(new File("latex" + File.separator + "generated" + File.separator + "Options.tex"), latexCode.toString().getBytes());
	}

	private static void generateWarningsTex() throws IOException {
		StringBuilder latexCode = new StringBuilder();
		List<CsAnalysisProblemType> values = new ArrayList<CsAnalysisProblemType>();
		values.addAll(Arrays.asList(CsAnalysisProblemType.values()));
		Collections.sort(values, new Comparator<CsAnalysisProblemType>() {
			public int compare(CsAnalysisProblemType o1, CsAnalysisProblemType o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		latexCode.append("\\begin{itemize}\n");
		for (CsAnalysisProblemType problemType : values) {
			if (problemType.getProblemSeverity() == CsEProblemSeverity.ERROR) {
				continue;
			}
			latexCode.append("\\item \\texttt{" + problemType.getName() + "}\n");
		};
		latexCode.append("\\end{itemize}\n");
		StreamUtil.setContent(new File("latex" + File.separator + "generated" + File.separator + "WarningTypes.tex"), latexCode.toString().getBytes());
	}
}

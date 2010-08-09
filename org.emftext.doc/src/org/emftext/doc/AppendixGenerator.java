package org.emftext.doc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;
import org.emftext.sdk.util.StreamUtil;

public class AppendixGenerator {

	public static void main(String[] args) throws IOException {
		generateOptionsTex();
		generateWarningsTex();
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
		
		for (OptionTypes optionType : values) {
			EEnumLiteral enumLiteral = ConcretesyntaxPackage.eINSTANCE.getOptionTypes().getEEnumLiteral(optionType.getName());
			String literal = optionType.getLiteral();
			String documentation = EcoreUtil.getDocumentation(enumLiteral);
			documentation = documentation.replaceAll("<code>(.[^<]*)</code>", "\\\\textbf{$1}");
			documentation = documentation.replace("_", "\\_");
			System.out.println(literal + " : " + documentation);
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
		List<ECsProblemType> values = new ArrayList<ECsProblemType>();
		values.addAll(Arrays.asList(ECsProblemType.values()));
		Collections.sort(values, new Comparator<ECsProblemType>() {
			public int compare(ECsProblemType o1, ECsProblemType o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		latexCode.append("\\begin{itemize}\n");
		for (ECsProblemType problemType : values) {
			if (problemType.getProblemType() == CsEProblemType.ERROR) {
				continue;
			}
			latexCode.append("\\item \\texttt{" + problemType.getName() + "}\n");
		};
		latexCode.append("\\end{itemize}\n");
		StreamUtil.setContent(new File("latex" + File.separator + "generated" + File.separator + "WarningTypes.tex"), latexCode.toString().getBytes());
	}
}

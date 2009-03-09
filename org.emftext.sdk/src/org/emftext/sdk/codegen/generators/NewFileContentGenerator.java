package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.ICodeGenOptions;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.util.GeneratorUtil;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.WhiteSpaces;

/**
 * The NewFileContentGenerator can be used to derive a minimal sample file
 * from a concrete syntax. All mandatory parts of the syntax are included 
 * in this sample file.
 */
public class NewFileContentGenerator implements IGenerator {
	
	public static final String LINE_BREAK = System.getProperty("line.separator");
	private final static GeneratorUtil helper = new GeneratorUtil();
	
	private GenerationContext context;
	private int tokenSpace;
	private StringBuffer sb;

	public NewFileContentGenerator(GenerationContext context) {
		this.context = context;
	}

	public boolean generate(PrintWriter out) {
		ConcreteSyntax concreteSyntax = context.getConcreteSyntax();
		tokenSpace = OptionManager.INSTANCE.getIntegerOptionValue(concreteSyntax, ICodeGenOptions.CS_OPTION_TOKENSPACE, true, null);
		
		List<GenClass> startSymbols = concreteSyntax.getAllStartSymbols();
		if (startSymbols.size() == 0) {
			return false;
		}
		GenClass firstStartSymbol = startSymbols.get(0);
		
		Rule startRule = helper.getRule(concreteSyntax, firstStartSymbol);
		if (startRule == null) {
			return false;
		}
		sb = new StringBuffer();
		generateContent(concreteSyntax, startRule);
		out.write(sb.toString());
		out.flush();
		return true;
	}

	private void generateContent(ConcreteSyntax concreteSyntax, Rule rule) {
		Choice choice = rule.getDefinition();
		List<Sequence> options = choice.getOptions();
		for (Sequence option : options) {
			List<Definition> definitions = option.getParts();
			for (Definition definition : definitions) {
				if (definition instanceof CardinalityDefinition) {
					CardinalityDefinition cardinalityDefinition = (CardinalityDefinition) definition;
					if (cardinalityDefinition.getCardinality() == null) {
						// is mandatory
						generateContent(concreteSyntax, definition);
					}
				} else {
					generateContent(concreteSyntax, definition);
				}
			}
			// use first option only
			break;
		}
	}

	private void generateContent(ConcreteSyntax concreteSyntax, Definition definition) {
		if (definition instanceof LineBreak) {
			LineBreak lineBreak = (LineBreak) definition;
			int count = lineBreak.getTab();
			for (int i = 0; i < count; i++) {
				append(LINE_BREAK, false);
			}
		} else if (definition instanceof WhiteSpaces) {
			WhiteSpaces ws = (WhiteSpaces) definition;
			int count = ws.getAmount();
			for (int i = 0; i < count; i++) {
				append(" ", true);
			}
		} else if (definition instanceof CsString) {
			CsString csString = (CsString) definition;
			append(csString.getValue(), false);
		} else if (definition instanceof Terminal) {
			Terminal terminal = (Terminal) definition;
			GenFeature genFeature = terminal.getFeature();
			EStructuralFeature ecoreFeature = genFeature.getEcoreFeature();
			if (ecoreFeature instanceof EAttribute) {
				EAttribute attribute = (EAttribute) ecoreFeature;
				append(getDefaultText(attribute), false);
			} else if (ecoreFeature instanceof EReference) {
				EReference reference = (EReference) ecoreFeature;
				boolean isContainment = reference.isContainment();
				if (isContainment) {
					GenClass type = genFeature.getTypeGenClass();
					Rule containedRule = helper.getRule(concreteSyntax, type);
					generateContent(concreteSyntax, containedRule);
				} else {
					append("identifier", false);
				}
			}
		}
	}

	private void append(String text, boolean isWhitespace) {
		boolean tokenSpaceIsSet = tokenSpace > 0;
		if (!(isWhitespace && tokenSpaceIsSet)) {
			sb.append(text);
		}
		if (tokenSpaceIsSet && !isWhitespace) {
			for (int i = 0; i < tokenSpace; i++) {
				sb.append(" ");
			}
		}
	}

	private String getDefaultText(EAttribute attribute) {
		EClassifier type = attribute.getEType();
		String typeName = type.getName();
		if (type instanceof EEnum) {
			EEnum enumType = (EEnum) type;
			List<EEnumLiteral> literals = enumType.getELiterals();
			if (literals.size() > 0) {
				EEnumLiteral firstLiteral = literals.get(0);
				return firstLiteral.getLiteral();
			}
		}
		if ("EInt".equals(typeName) ||
			"EIntegerObject".equals(typeName)) {
			return "0";
		}
		// TODO return values for different frequently used types such as EInteger
		return "value";
	}

	public Collection<GenerationProblem> getCollectedErrors() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<GenerationProblem> getCollectedProblems() {
		// TODO Auto-generated method stub
		return null;
	}
}

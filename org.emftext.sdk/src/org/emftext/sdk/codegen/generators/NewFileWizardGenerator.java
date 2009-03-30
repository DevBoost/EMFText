package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.ui.new_wizard.AbstractNewFileWizard;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.util.GeneratorUtil;
import org.emftext.sdk.codegen.util.StringUtil;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.WhiteSpaces;

/**
 * The NewFileContentGenerator can be used to derive a minimal sample file
 * from a concrete syntax. All mandatory parts of the syntax are included 
 * in this sample file.
 */
public class NewFileWizardGenerator implements IGenerator {
	
	public static final String LINE_BREAK = System.getProperty("line.separator");
	private final static GeneratorUtil helper = new GeneratorUtil();
	
	private GenerationContext context;
	private int tokenSpace;

	public NewFileWizardGenerator(GenerationContext context) {
		this.context = context;
	}

	public boolean generate(PrintWriter out) {
		String exampleDocument = getExampleDocument();
		// escape special characters to avoid compilation
		// problems in generated code
		exampleDocument = exampleDocument.replace("\"", "\\\"");
		exampleDocument = exampleDocument.replace("\n", "\\\n");
		exampleDocument = exampleDocument.replace("\r", "\\\r");
		
		StringComposite sc = new JavaComposite();
		sc.add("package " + context.getPackageName() + ";");
		sc.add("public class " + context.getNewFileActionClassName() + " extends " + AbstractNewFileWizard.class.getName() + " {");
		sc.add("public String getFileExtension() {");
		sc.add("return \"" + context.getConcreteSyntax().getName() + "\";");
		sc.add("}");
		sc.add("public String getExampleContent() {");
		sc.add("return \"" + exampleDocument + "\";");
		sc.add("}");
		sc.add("}");
		
		out.write(sc.toString());
		out.flush();
		return true;
	}

	public String getExampleDocument() {
		ConcreteSyntax concreteSyntax = context.getConcreteSyntax();
		tokenSpace = OptionManager.INSTANCE.getIntegerOptionValue(concreteSyntax, OptionTypes.TOKENSPACE, true, null);
		
		List<GenClass> startSymbols = concreteSyntax.getAllStartSymbols();
		if (startSymbols.size() == 0) {
			return "";
		}
		for (GenClass startSymbol : startSymbols) {
			StringBuffer sb = new StringBuffer();
			Rule startRule = helper.getRule(concreteSyntax, startSymbol);
			generateContent(concreteSyntax, startRule, sb);
			String result = sb.toString();
			// if the start symbol returns an empty string we can try the other ones
			if (result.trim().length() > 0) {
				return result;
			}
		}
		return "";
	}

	private void generateContent(ConcreteSyntax concreteSyntax, Rule rule, StringBuffer sb) {
		if (rule == null) {
			return;
		}
		Choice choice = rule.getDefinition();
		List<Sequence> options = choice.getOptions();
		for (Sequence option : options) {
			List<Definition> definitions = option.getParts();
			for (Definition definition : definitions) {
				if (definition instanceof CardinalityDefinition) {
					CardinalityDefinition cardinalityDefinition = (CardinalityDefinition) definition;
					if (cardinalityDefinition.getCardinality() == null) {
						// is mandatory
						generateContent(concreteSyntax, rule, definition, sb);
					}
				} else {
					generateContent(concreteSyntax, rule, definition, sb);
				}
			}
			// use first option only
			break;
		}
	}

	private void generateContent(ConcreteSyntax concreteSyntax, Rule rule, Definition definition, StringBuffer sb) {
		if (definition instanceof LineBreak) {
			LineBreak lineBreak = (LineBreak) definition;
			int count = lineBreak.getTab();
			for (int i = 0; i < count; i++) {
				append(LINE_BREAK, false, sb);
			}
		} else if (definition instanceof WhiteSpaces) {
			WhiteSpaces ws = (WhiteSpaces) definition;
			int count = ws.getAmount();
			for (int i = 0; i < count; i++) {
				append(" ", true, sb);
			}
		} else if (definition instanceof CsString) {
			CsString csString = (CsString) definition;
			append(csString.getValue(), false, sb);
		} else if (definition instanceof Terminal) {
			Terminal terminal = (Terminal) definition;
			PlaceholderInQuotes quotedPlaceholder = null;
			if (terminal instanceof PlaceholderInQuotes) {
				quotedPlaceholder = (PlaceholderInQuotes) terminal;
			}
			if (quotedPlaceholder != null) {
				append(quotedPlaceholder.getPrefix(), false, sb);
			}
			GenFeature genFeature = terminal.getFeature();
			EStructuralFeature ecoreFeature = genFeature.getEcoreFeature();
			if (ecoreFeature instanceof EAttribute) {
				EAttribute attribute = (EAttribute) ecoreFeature;
				append(getDefaultText(rule.getMetaclass().getEcoreClass(), attribute), false, sb);
			} else if (ecoreFeature instanceof EReference) {
				EReference reference = (EReference) ecoreFeature;
				boolean isContainment = reference.isContainment();
				if (isContainment) {
					GenClass type = genFeature.getTypeGenClass();
					Rule containedRule = helper.getRule(concreteSyntax, type);
					generateContent(concreteSyntax, containedRule, sb);
				} else {
					append("identifier", false, sb);
				}
			}
			if (quotedPlaceholder != null) {
				append(quotedPlaceholder.getSuffix(), false, sb);
			}
		}
	}

	private void append(String text, boolean isWhitespace, StringBuffer sb) {
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

	private String getDefaultText(EClass eClass, EAttribute attribute) {
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
		boolean isInteger = "EInt".equals(typeName) ||
				"EIntegerObject".equals(typeName) ||
				Integer.class.getName().equals(typeName);
		if (isInteger) {
			return "0";
		}
		boolean isString = "EString".equals(typeName) ||
			String.class.getName().equals(typeName);
		if (isString) {
			return "some" + StringUtil.capitalize(eClass.getName()) + StringUtil.capitalize(attribute.getName());
		}
		return "value";
	}

	public Collection<GenerationProblem> getCollectedErrors() {
		return new ArrayList<GenerationProblem>();
	}

	public Collection<GenerationProblem> getCollectedProblems() {
		return new ArrayList<GenerationProblem>();
	}
}

package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.*;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.util.GeneratorUtil;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.PLUS;
import org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken;
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.STAR;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.TokenDefinition;

/**
 * An experimental implementation of a Packrat parser. Currently a 
 * basic scannerless recursive descendant parser is created. The 
 * memoization of the Packrat parsing method is not yet implemented.
 * 
 * See: http://pdos.csail.mit.edu/~baford/packrat/thesis/thesis.pdf
 */
public class PackratParserGenerator extends BaseGenerator {
	
	private GenerationContext context;
	
	public PackratParserGenerator(GenerationContext context) {
		super(context.getPackageName(), context.getPackratParserClassName());
		this.context = context;
	}

	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " extends " + ABSTRACT_EMF_TEXT_PARSER + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructors(sc);
		addMethods(sc);
		addMethodsForRules(sc);
		sc.add("}");
		
		out.write(sc.toString());
		return true;
	}

	private void addMethods(StringComposite sc) {
		addCreateInstanceMethod(sc);
		addGetResourceMethod(sc);
		addParseMethod(sc);
		addParseToExpectedElementsMethod(sc);
		addSetResourceMethod(sc);
		addSetOptionsMethod(sc);

		addMatchesMethod(sc);
		addMatchesUsedTokenMethod(sc);
		addMatchUnusedTokensMethod(sc);
		addMatchesRegexpMethod(sc);
	}

	private void addConstructors(StringComposite sc) {
		addConstructor1(sc);
		addConstructor2(sc);
	}

	private void addMatchesRegexpMethod(StringComposite sc) {
		sc.add("public boolean matchesRegexp(" + PATTERN + " pattern, String name) {");
		sc.add("String tail = content.substring(offset);");
		sc.add(MATCHER + " matcher = pattern.matcher(tail);");
		sc.add("boolean matches = matcher.find();");
		sc.add("String found = null;");
		sc.add("System.out.println(\"Remaining input : \\\"\" + tail + \"\\\"\");");
		sc.add("System.out.print(\"Trying to match \" + name + \" at \" + offset + \" -> \" + matches);");
		sc.add("if (matches) {");
		sc.add("int start = matcher.start();");
		sc.add("int end = matcher.end();");
		sc.add("found = tail.substring(start, end);");
		sc.add("offset = offset + end;");
		sc.add("}");
		sc.add("System.out.println(matches ? (\" : \\\"\" + found + \"\\\"\") : \"\");");
		sc.add("return matches;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMatchUnusedTokensMethod(StringComposite sc) {
		sc.add("public boolean matchUnusedTokens() {");
		sc.add("while (true) {");
		sc.add("boolean found = false;");
		ConcreteSyntax syntax = context.getConcreteSyntax();
		for (TokenDefinition tokenDefinition : syntax.getActiveTokens()) {
			if (tokenDefinition.isHidden()) {
				String field = getFieldName(tokenDefinition);
				sc.add("found |= matchesRegexp(" + field + ", \"unused " + field + "\");");
			}
		}
		sc.add("if (!found) {");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMatchesUsedTokenMethod(StringComposite sc) {
		sc.add("public boolean matchesUsedToken(" + PATTERN + " pattern, String name) {");
		sc.add("boolean matches = matchesRegexp(pattern, name);");
		sc.add("if (matches) {");
		sc.add("matchUnusedTokens();");
		sc.add("}");
		sc.add("return matches;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMatchesMethod(StringComposite sc) {
		sc.add("public boolean matches(" + STRING + " keyword) {");
		sc.add("boolean matches = content.startsWith(keyword, offset);");
		sc.add("System.out.println(\"Trying to match \" + keyword + \" at \" + offset + \" -> \" + matches + \"\");");
		sc.add("if (matches) {");
		sc.add("offset += keyword.length();");
		sc.add("matchUnusedTokens();");
		sc.add("}");
		sc.add("return matches;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetOptionsMethod(StringComposite sc) {
		sc.add("public void setOptions(" + MAP + "<?, ?> options) {");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetResourceMethod(StringComposite sc) {
		sc.add("public void setResource(" + I_TEXT_RESOURCE + " resource) {");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addParseToExpectedElementsMethod(StringComposite sc) {
		sc.add("public " + LIST + "<" + I_EXPECTED_ELEMENT + "> parseToExpectedElements(" + E_CLASS + " type) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addParseMethod(StringComposite sc) {
		sc.add("public " + E_OBJECT + " parse() {");
		for (GenClass startSymbol : context.getConcreteSyntax().getActiveStartSymbols()) {
			sc.add("offset = 0;");
			sc.add("if (" + getRuleName(startSymbol) + "()) {");
			sc.add("// TODO return real root element");
			sc.add("return new " + DynamicEObjectImpl.class.getName() + "();");
			sc.add("}");
		}
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResourceMethod(StringComposite sc) {
		sc.add("public " + I_TEXT_RESOURCE + " getResource() {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor1(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super(null);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateInstanceMethod(StringComposite sc) {
		sc.add("public " + I_TEXT_PARSER + " createInstance(" + INPUT_STREAM + " inputStream, " + STRING + " encoding) {");
		sc.add("return new " + getResourceClassName() + "(inputStream, encoding);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor2(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + INPUT_STREAM + " inputStream, " + STRING + " encoding) {");
		sc.add("super(null);");
		sc.add("this.inputStream = new " + INPUT_STREAM_READER + "(inputStream);");
		sc.add("try {");
		sc.add("int next;");
		sc.add("while ((next = this.inputStream.read()) >= 0) {");
		sc.add("this.content += (char) next;");
		sc.add("}");
		sc.add("} catch (" + IO_EXCEPTION + " e) {");
		sc.add("e.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + INPUT_STREAM_READER + " inputStream;");
		sc.add("private int offset;");
		sc.add("private " + STRING + " content = \"\";");
		sc.addLineBreak();
		
		addTokenPatterns(sc);
		sc.addLineBreak();
	}

	private void addTokenPatterns(StringComposite sc) {
		ConcreteSyntax syntax = context.getConcreteSyntax();
		List<TokenDefinition> tokens = syntax.getActiveTokens();
		for (TokenDefinition tokenDefinition : tokens) {
			String fieldName = getFieldName(tokenDefinition);
			String regex = tokenDefinition.getRegex();
			if ("TEXT".equals(tokenDefinition.getName())) {
				regex = "[a-zA-Z]+";
			} else if ("WHITESPACE".equals(tokenDefinition.getName())) {
				regex = "[ ]";
			} else if ("COMMENT".equals(tokenDefinition.getName())) {
				regex = "//.*[\\\\n\\\\r]";
			} else if ("LINEBREAK".equals(tokenDefinition.getName())) {
				regex = "[\\\\n\\\\r]";
			} else {
				continue;
			}
			// the \a is needed to indicate the the begin of the input must be matched
			regex = "\\\\A" + regex;
			sc.add("private final static " + PATTERN + " " + fieldName + " = " + PATTERN + ".compile(\"" + regex + "\");");
		}
	}

	private String getFieldName(TokenDefinition tokenDefinition) {
		return "TOKEN_" + tokenDefinition.getName();
	}

	private void addMethodsForRules(StringComposite sc) {
		ConcreteSyntax syntax = context.getConcreteSyntax();
		List<Rule> rules = syntax.getAllRules();
		for (Rule rule : rules) {
			addMethodForRule(sc, syntax, rule);
		}
	}

	private void addMethodForRule(StringComposite sc, ConcreteSyntax syntax, Rule rule) {
		GenClass metaclass = rule.getMetaclass();
		sc.add("public boolean " + getRuleName(metaclass) + "() {");
		Choice choice = rule.getDefinition();
		sc.add("return " + getMethodName(choice) + "();");
		sc.add("}");
		sc.addLineBreak();
		
		addMethodForChoice(sc, syntax, choice);
	}

	private void addMethodForChoice(StringComposite sc, ConcreteSyntax syntax,
			Choice choice) {
		List<Sequence> options = choice.getOptions();

		sc.add("public boolean " + getMethodName(choice) + "() {");
		sc.add("// begin options");
		for (Sequence option : options) {
			sc.add("if (" + getMethodName(option) + "()) {");
			sc.add("return true;");
			sc.add("}");
		}
		sc.add("// end options");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
		
		for (Sequence option : options) {
			addMethodForSequence(sc, syntax, option);
		}
	}

	private void addMethodForSequence(StringComposite sc, ConcreteSyntax syntax,
			Sequence sequence) {

		sc.add("public boolean " + getMethodName(sequence) + "() {");
		sc.add("boolean matchedAll = true;");
		List<Definition> parts = sequence.getParts();
		for (Definition part : parts) {
			sc.add("// begin part");
			if (part instanceof CardinalityDefinition) {
				CardinalityDefinition cd = (CardinalityDefinition) part;
				addCardinalityCode(sc, syntax, cd);
			} else if (part instanceof CsString) {
				addCodeForCsString(sc, (CsString) part);
			} else {
				throw new RuntimeException("Found unknown subclass " + part.getClass().getName());
			}
			sc.add("if (!matchedAll) {");
			sc.add("// stop matching the sequence");
			sc.add("return false;");
			sc.add("}");
		}
		sc.add("// this sequence is valid");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
		
		for (Definition definition : parts) {
			if (definition instanceof CardinalityDefinition) {
				addMethodForCardinality(sc, syntax, (CardinalityDefinition) definition);
			}
		}
	}

	private void addMethodForCardinality(StringComposite sc, ConcreteSyntax syntax,
			CardinalityDefinition definition) {

		Cardinality cardinality = definition.getCardinality();

		sc.add("public boolean " +  getMethodName(definition) + "() {");
		sc.add("boolean matched = true;");
		if (cardinality == null) {
			// cardinality == 1
			addCodeForElementWithCardinality(sc, syntax, definition);
			sc.add("return matched;");
		} else if (cardinality instanceof STAR) {
			// cardinality == 0..*
			sc.add("while (matched) {");
			addCodeForElementWithCardinality(sc, syntax, definition);
			sc.add("}");
			sc.add("// TODO backtrack");
			sc.add("return true;");
		} else if (cardinality instanceof PLUS) {
			// cardinality == 1..*
			sc.add("boolean matchedAtLeastOnce = false;");
			sc.add("while (matched) {");
			addCodeForElementWithCardinality(sc, syntax, definition);
			sc.add("matchedAtLeastOnce |= match;");
			sc.add("}");
			sc.add("// TODO backtrack");
			sc.add("return matched;");
		} else if (cardinality  instanceof QUESTIONMARK) {
			// cardinality == 0..1
			addCodeForElementWithCardinality(sc, syntax, definition);
			sc.add("return true;");
		} else {
			throw new RuntimeException("Found unknown cardinality " + cardinality.getClass().getName());
		}
		sc.add("}");
		sc.addLineBreak();

		if (definition instanceof Containment) {
			addMethodForContainment(sc, syntax, (Containment) definition);
		}
	}

	private void addCardinalityCode(StringComposite sc, ConcreteSyntax syntax, CardinalityDefinition cd) {
		sc.add("matchedAll = " + getMethodName(cd) + "();");
	}

	private void addCodeForElementWithCardinality(StringComposite sc, ConcreteSyntax syntax, CardinalityDefinition cd) {
		if (cd instanceof Terminal) {
			addCodeForTerminal(sc, syntax, (Terminal) cd);
		} else {
			throw new RuntimeException("Found unknown subclass " + cd.getClass().getName());
		}
	}

	private void addMethodForContainment(StringComposite sc, ConcreteSyntax syntax, Containment containment) {
		sc.add("public boolean " + getMethodName(containment) + "() {");
		sc.add("int offsetCopy = this.offset;");
		GeneratorUtil generatorUtil = new GeneratorUtil();
		Collection<GenClass> subclasses = generatorUtil.getSubClassesWithSyntax(containment.getFeature().getTypeGenClass(), syntax);
		for (GenClass genClass : subclasses) {
			sc.add("// try subclass " + genClass.getName());
			sc.add("// restore old offset");
			sc.add("this.offset = offsetCopy;");
			sc.add("// TODO backtrack");
			sc.add("if (" + getRuleName(genClass) + "()) {");
			sc.add("return true;");
			sc.add("}");
		}
		sc.add("// no subclass matched");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCodeForCsString(StringComposite sc, CsString csString) {
		String value = csString.getValue();
		sc.add("// match cs string \"" + value + "\"");
		sc.add("matchedAll &= matches(\"" + value + "\");");
	}

	private void addCodeForTerminal(StringComposite sc, ConcreteSyntax syntax, Terminal terminal) {
		if (terminal instanceof PlaceholderUsingDefaultToken) {
			PlaceholderUsingDefaultToken defaultTokenTerminal = (PlaceholderUsingDefaultToken) terminal;
			TokenDefinition tokenDefinition = defaultTokenTerminal.getToken();
			String regexp = tokenDefinition.getRegex();
			sc.add("// match regexp \"" + regexp + "\"");
			String fieldName = getFieldName(tokenDefinition);
			sc.add("matched &= matchesUsedToken(" + fieldName + ", \"" + fieldName+ "\");");
		} else if (terminal instanceof Containment) {
			Containment containment = (Containment) terminal;
			addCodeForContainment(sc, syntax, containment);
		} else {
			throw new RuntimeException("Found unknown subclass " + terminal.getClass().getName());
		}
	}

	private void addCodeForContainment(StringComposite sc, ConcreteSyntax syntax, Containment containment) {
		sc.add("// handle containment reference " + containment.getFeature().getName());
		sc.add("matched &= " + getMethodName(containment) + "();");
	}

	private String getMethodName(Containment containment) {
		Sequence parent = (Sequence) containment.eContainer();
		int index = getIndex(containment, parent);
		if (parent != null) {
			return getMethodName(parent) + "_containment" + index;
		}
		return null;
	}

	private String getRuleName(GenClass metaClass) {
		// TODO use fully qualified name
		return "rule_" + metaClass.getName();
	}

	private String getMethodName(CardinalityDefinition cd) {
		Sequence parent = (Sequence) cd.eContainer();
		int index = getIndex(cd, parent);
		if (parent != null) {
			Cardinality cardinality = cd.getCardinality();
			// TODO do not use class name here
			return getMethodName(parent) + "_" + getName(cardinality) + index;
		}
		return null;
	}

	private String getName(Cardinality cardinality) {
		if (cardinality == null) {
			return "ONE";
		} else if (cardinality instanceof PLUS) {
			return "PLUS";
		} else if (cardinality instanceof STAR) {
			return "STAR";
		} else if (cardinality instanceof QUESTIONMARK) {
			return "QUESTIONMARK";
		} else {
			throw new RuntimeException("Found unknown cardinality " + cardinality.getClass().getName());
		}
	}

	private String getMethodName(Sequence option) {
		Choice parent = (Choice) option.eContainer();
		int index = getIndex(option, parent);
		if (parent != null) {
			return getMethodName(parent) + "_sequence" + index;
		}
		return null;
	}

	private String getMethodName(Choice choice) {
		EObject parent = (EObject) choice.eContainer();
		if (parent instanceof Rule) {
			Rule rule = (Rule) parent;
			return getRuleName(rule.getMetaclass()) + "_choice";
		} else if (parent instanceof Sequence) {
			int index = getIndex(choice, parent);
			return getMethodName((Sequence) parent) + "_choice" + index;
		}
		return null;
	}

	private int getIndex(EObject object, EObject parent) {
		EStructuralFeature feature = object.eContainingFeature();
		return ((List<?>) parent.eGet(feature)).indexOf(object);
	}
}

package org.emftext.sdk.codegen.regex;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.emftext.runtime.util.UnicodeConverter;
import org.emftext.sdk.concretesyntax.NewDefinedToken;
import org.emftext.sdk.concretesyntax.NormalToken;
import org.emftext.sdk.concretesyntax.QuotedToken;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.TokenDirective;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.RegExp;

public class TokenSorter {
	private class ComparableTokenDirective implements
			Comparable<ComparableTokenDirective> {
		private String regExp;
		private Automaton automaton;
		private TokenDirective def;

		public ComparableTokenDirective(String regString, Automaton aut,
				TokenDirective definition) {
			regExp = regString;
			automaton = aut;
			def = definition;
		}

		public String getRegExp() {
			return regExp;
		}

		public void setRegExp(String regExp) {
			this.regExp = regExp;
		}

		public Automaton getAutomaton() {
			return automaton;
		}

		public void setAutomaton(Automaton automaton) {
			this.automaton = automaton;
		}

		public TokenDirective getDef() {
			return def;
		}

		public void setDef(TokenDefinition def) {
			this.def = def;
		}

		public int compareTo(ComparableTokenDirective arg0) {
			boolean firstComparison = isSubLanguage(automaton, arg0
					.getAutomaton());
			boolean secondComparison = isSubLanguage(arg0.getAutomaton(),
					automaton);

			// The first language is contained in the second.
			if ((firstComparison == true) && (secondComparison == false))
				return -1;

			// The second language is contained in the first.
			if ((firstComparison == false) && (secondComparison == true))
				return 1;

			// The languages are equal.
			if ((firstComparison == true) && (secondComparison == true))
				return 0;

			// The languages can't be compared.
			if ((firstComparison == false) && secondComparison == false)
				return 0;
			return 0;
		}

	}

	private boolean doIntersect(Automaton firstLanguage,
			Automaton secondLanguage) {
		if (firstLanguage == null)
			return true;
		if (secondLanguage == null)
			return true;

		return (!firstLanguage.intersection(secondLanguage).isEmpty());
	}

	private boolean isSubLanguage(Automaton firstLanguage,
			Automaton secondLanguage) {
		Automaton complementSecond = secondLanguage.complement();

		Automaton result = firstLanguage.intersection(complementSecond);

		return result.isEmpty();

		// return firstLanguage.subsetOf(secondLanguage);
	}

	public List<TokenDirective> getNonReachables(List<TokenDirective> ds)
			throws SorterException {
		List<TokenDirective> nonReachables = new ArrayList<TokenDirective>();
		List<ComparableTokenDirective> compareables = translateToComparables(ds);
		for (int i = 0; i < compareables.size(); i++) {
			for (int j = 0; j < i; j++) {

				ComparableTokenDirective ci = compareables.get(i);
				ComparableTokenDirective cj = compareables.get(j);
				if (isSubLanguage(ci.getAutomaton(), cj.getAutomaton())) {
					nonReachables.add(ci.getDef());
				}

			}
		}
		return nonReachables;
	}

	public List<TokenDirective> getConflicting(List<TokenDirective> ds)
			throws SorterException {
		List<TokenDirective> conflicting = new ArrayList<TokenDirective>();
		List<ComparableTokenDirective> compareables = translateToComparables(ds);
		for (int i = 0; i < compareables.size(); i++) {
			for (int j = 0; j < i; j++) {

				ComparableTokenDirective ci = compareables.get(i);
				ComparableTokenDirective cj = compareables.get(j);
				if (doIntersect(ci.getAutomaton(), cj.getAutomaton())) {
					conflicting.add(ci.getDef());
				}

			}
		}
		return conflicting;
	}

	public List<TokenDirective> sortTokens(List<TokenDirective> toSort,
			boolean ignoreUnreachables) throws SorterException {
		List<ComparableTokenDirective> compareables = translateToComparables(toSort);

		Collections.sort(compareables);
		// doSort(compareables);

		List<TokenDirective> resultList = new ArrayList<TokenDirective>();
		for (ComparableTokenDirective directive : compareables) {
			resultList.add(directive.getDef());
		}
		if (!ignoreUnreachables) {
			List<TokenDirective> conflicting = getNonReachables(resultList);
			if (conflicting.size() > 0) {
				throw new SorterException(
						"Sorting Tokens failed. Grammar contains unreachable tokens",
						conflicting);
			}
		}
		return resultList;
	}

	private List<ComparableTokenDirective> translateToComparables(
			List<TokenDirective> toSort) throws SorterException {
		List<ComparableTokenDirective> compareables = new ArrayList<ComparableTokenDirective>();

		for (TokenDirective def : toSort) {

			if (def instanceof NewDefinedToken) {
				NewDefinedToken newToken = (NewDefinedToken) def;
				String original = newToken.getRegex();
				compareables.add(createComparableTokenDirective(original, def));
			} else if (def instanceof NormalToken) {
				NormalToken newToken = (NormalToken) def;
				String original = newToken.getRegex();
				compareables.add(createComparableTokenDirective(original, def));
			} else if (def instanceof QuotedToken) {
				QuotedToken newToken = (QuotedToken) def;
				String original = newToken.getRegex();
				compareables.add(createComparableTokenDirective(original, def));

			} else {
				throw new SorterException(
						"An undefined token class was found. Maybe you should adapt the sorter code. The unkown type was: "
								+ def.getClass().getName());
			}

		}
		return compareables;
	}

	private ComparableTokenDirective createComparableTokenDirective(
			String original, TokenDirective def) throws SorterException {
		String transformedRegExp = null;
		try {
			transformedRegExp = parseRegExp(original);
			RegExp regExp = new RegExp(transformedRegExp);
			Automaton automaton = regExp.toAutomaton();
			
			return new ComparableTokenDirective(transformedRegExp, automaton,
					def);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new SorterException(
					"An error occurred while parsing a regular expression. The expression was: "
							+ original);

		}
	}

	/**
	 * This method makes a transformation of the regular expression of the
	 * EMFText to the format of the University of Aarhus automaton
	 * package. For exmaple: the range operator in EMFText is '..' but in the
	 * automaton '-'.
	 * 
	 * @param exp
	 *            regular expression to be transformed
	 * @return the transformed regular expression
	 * @throws Exception
	 *             occurs if a parser error occurs
	 */
	private String parseRegExp(String exp) throws Exception {
		InputStream input = new ByteArrayInputStream(exp.getBytes());
		ANTLRInputStream inputStream = new ANTLRInputStream(input);

		AutomatonRexpLexer lexer = new AutomatonRexpLexer(inputStream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);

		AutomatonRexpParser parser = new AutomatonRexpParser(tokenStream);
		String regex = parser.root().toString();

		regex = convertUnicode(regex);
		
		return regex;
	}

	private String convertUnicode(String regex) {
		InputStream is = new ByteArrayInputStream(regex.getBytes());
		UnicodeConverter uc = new UnicodeConverter(is);
		BufferedReader reader = new BufferedReader(new InputStreamReader(uc));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		regex = sb.toString();
		return regex;
	}

//	private List<ComparableTokenDirective> doSort(
//			List<ComparableTokenDirective> toSorted) {
//		for (int i = 0; i < toSorted.size(); i++) {
//			ComparableTokenDirective runHolder = toSorted.get(i);
//
//			for (int j = i + 1; j < toSorted.size(); j++) {
//				ComparableTokenDirective compareHolder = toSorted.get(j);
//				int compare = runHolder.compareTo(compareHolder);
//
//				if (compare > 0) {
//					ComparableTokenDirective dummy = runHolder;
//					toSorted.set(i, compareHolder);
//					toSorted.set(j, dummy);
//
//					runHolder = compareHolder;
//				}
//
//			}
//		}
//
//		return toSorted;
//	}

}

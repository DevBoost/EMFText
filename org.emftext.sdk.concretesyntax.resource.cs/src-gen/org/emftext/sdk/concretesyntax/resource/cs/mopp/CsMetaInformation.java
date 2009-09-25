package org.emftext.sdk.concretesyntax.resource.cs.mopp;

public class CsMetaInformation implements org.emftext.sdk.concretesyntax.resource.cs.ICsMetaInformation {
	
	public class TokenStyleImpl implements org.emftext.sdk.concretesyntax.resource.cs.ICsTokenStyle {
		
		private int[] color;
		private boolean bold;
		private boolean italic;
		private boolean strikethrough;
		private boolean underline;
		
		public TokenStyleImpl(int[] color, boolean bold, boolean italic, boolean striketrough, boolean underline) {
			super();
			this.color = color;
			this.bold = bold;
			this.italic = italic;
			this.strikethrough = striketrough;
			this.underline = underline;
		}
		
		public int[] getColorAsRGB() {
			return color;
		}
		
		public boolean isBold() {
			return bold;
		}
		
		public boolean isItalic() {
			return italic;
		}
		
		public boolean isStrikethrough() {
			return strikethrough;
		}
		
		public boolean isUnderline() {
			return underline;
		}
	}
	
	public class BracketPair implements org.emftext.sdk.concretesyntax.resource.cs.ICsBracketPair {
		
		private String opening;
		private String closing;
		private boolean closingEnabledInside;
		
		public BracketPair(String opening, String closing, boolean closingEnabledInside) {
			super();
			this.opening = opening;
			this.closing = closing;
			this.closingEnabledInside = closingEnabledInside;
		}
		
		public String getOpeningBracket() {
			return opening;
		}
		
		public String getClosingBracket() {
			return closing;
		}
		
		public boolean isClosingEnabledInside() {
			return closingEnabledInside;
		}
	}
	
	public java.lang.String getSyntaxName() {
		return "cs";
	}
	
	public java.lang.String getURI() {
		return "http://www.emftext.org/sdk/concretesyntax";
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsTextScanner createLexer() {
		return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAntlrScanner(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLexer());
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsTextParser createParser(java.io.InputStream inputStream, java.lang.String encoding) {
		return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsParser().createInstance(inputStream, encoding);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalToken(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenPriorityDirective(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPLUS(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSTAR(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getQUESTIONMARK(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAbstract(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(),
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair(),
		};
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsReferenceResolverSwitch();
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolverFactory getTokenResolverFactory() {
		return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenResolverFactory();
	}
	
	public java.lang.String getPathToCSDefinition() {
		return "org.emftext.sdk.concretesyntax/metamodel/concretesyntax.cs";
	}
	
	public java.lang.String[] getTokenNames() {
		return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsParser(null).getTokenNames();
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsTokenStyle getDefaultTokenStyle(java.lang.String tokenName) {
		if ("NUMBER".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0xD0, 0xFF}, false, false, false, false);
		}
		if ("HEXNUMBER".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0xD0, 0xFF}, false, false, false, false);
		}
		if ("DEFINE".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0xFF, 0x90, 0x00}, true, false, false, false);
		}
		if ("COLLECT".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0xFF, 0x90, 0x00}, true, false, false, false);
		}
		if ("IN".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0xFF, 0x90, 0x00}, true, false, false, false);
		}
		if ("COLOR".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0xFF, 0x90, 0x00}, true, false, false, false);
		}
		if ("PRIORITIZE".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0xFF, 0x90, 0x00}, true, false, false, false);
		}
		if ("COMMENTS".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x80, 0x00}, false, false, false, false);
		}
		if ("ABSTRACT".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x40}, true, false, false, false);
		}
		if ("SYNTAXDEF".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x40}, true, false, false, false);
		}
		if ("FOR".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x40}, true, false, false, false);
		}
		if ("START".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x40}, true, false, false, false);
		}
		if ("IMPORTS".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x40}, true, false, false, false);
		}
		if ("OPTIONS".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x40}, true, false, false, false);
		}
		if ("TOKENS".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x40}, true, false, false, false);
		}
		if ("TOKENSTYLES".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x40}, true, false, false, false);
		}
		if ("RULES".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x40}, true, false, false, false);
		}
		if ("QUOTED_34_34_92".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x2A, 0x00, 0xFF}, false, false, false, false);
		}
		if ("QUOTED_60_62".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x00, 0x00}, false, false, false, false);
		}
		if ("QUOTED_39_39_92".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x2A, 0x00, 0xFF}, false, false, false, false);
		}
		if (":".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("WITH".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("SYNTAX".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x80, 0x00, 0x55}, true, false, false, false);
		}
		if ("QUOTED_36_36".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x2A, 0x00, 0xFF}, false, false, false, false);
		}
		return null;
	}
	
	public java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsBracketPair> getBracketPairs() {
		java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsBracketPair> result = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.ICsBracketPair>();
		result.add(new BracketPair("{", "}", true));
		result.add(new BracketPair("[", "]", true));
		result.add(new BracketPair("(", ")", true));
		result.add(new BracketPair("<", ">", false));
		result.add(new BracketPair("\"", "\"", false));
		result.add(new BracketPair("'", "'", false));
		return result;
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(),
		};
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsHoverTextProvider getHoverTextProvider() {
		return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsHoverTextProvider();
	}
	
}

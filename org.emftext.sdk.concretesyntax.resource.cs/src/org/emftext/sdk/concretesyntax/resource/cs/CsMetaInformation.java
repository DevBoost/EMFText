package org.emftext.sdk.concretesyntax.resource.cs;

import org.emftext.runtime.resource.ITextLexer;
import org.emftext.runtime.ui.AntlrTextLexer;

public class CsMetaInformation extends org.emftext.runtime.resource.impl.AbstractTextResourcePluginMetaInformation {
	
	public java.lang.String getSyntaxName() {
		return "cs";
	}
	public java.lang.String getURI() {
		return "http://www.emftext.org/sdk/concretesyntax";
	}
	public org.emftext.runtime.resource.ITextParser createParser(java.io.InputStream inputStream, java.lang.String encoding) {
		return new org.emftext.sdk.concretesyntax.resource.cs.CsParser().createInstance(inputStream, encoding);
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
	
	public org.emftext.runtime.resource.IReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.emftext.sdk.concretesyntax.resource.cs.CsReferenceResolverSwitch();
	}
	
	public org.emftext.runtime.resource.ITokenResolverFactory getTokenResolverFactory() {
		return new org.emftext.sdk.concretesyntax.resource.cs.CsTokenResolverFactory();
	}
	
	public java.lang.String getPathToCSDefinition() {
		return "org.emftext.sdk.concretesyntax/metamodel/concretesyntax.cs";
	}
	public java.lang.String[] getTokenNames() {
		return new org.emftext.sdk.concretesyntax.resource.cs.CsParser(null).getTokenNames();
	}
	
	public org.emftext.runtime.resource.ITokenStyle getDefaultTokenStyle(java.lang.String tokenName) {
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
		if ("QUOTED_34_34".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x2A, 0x00, 0xFF}, false, false, false, false);
		}
		if ("QUOTED_60_62".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x00, 0x00, 0x00}, false, false, false, false);
		}
		if ("QUOTED_39_39".equals(tokenName)) {
			return new TokenStyleImpl(new int[] {0x2A, 0x00, 0xFF}, false, false, false, false);
		}
		return null;
	}
	
	public ITextLexer createLexer() {
		return new AntlrTextLexer(
			this, 
			new org.emftext.sdk.concretesyntax.resource.cs.CsLexer()
			);
	}
	
	public class TokenStyleImpl implements org.emftext.runtime.resource.ITokenStyle {
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
}

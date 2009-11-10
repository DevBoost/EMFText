package org.emftext.sdk.concretesyntax.resource.cs.mopp;

public class CsBracketInformationProvider {
	
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
	
}

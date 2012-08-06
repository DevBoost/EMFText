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
package org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp;

public class GeneratorconfigBracketInformationProvider {

	public class BracketPair implements org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigBracketPair {

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

	public java.util.Collection<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigBracketPair> getBracketPairs() {
		java.util.Collection<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigBracketPair> result = new java.util.ArrayList<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigBracketPair>();
		result.add(new BracketPair("(", ")", true));
		result.add(new BracketPair("{", "}", true));
		result.add(new BracketPair("[", "]", true));
		result.add(new BracketPair("<", ">", false));
		result.add(new BracketPair("\"", "\"", false));
		result.add(new BracketPair("'", "'", false));
		return result;
	}

}

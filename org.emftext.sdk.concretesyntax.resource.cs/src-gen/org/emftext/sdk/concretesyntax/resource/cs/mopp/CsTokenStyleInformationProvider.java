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

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

public class CsTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("HEXNUMBER".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0x00, 0xD0, 0xFF}, null, false, false, false, false);
		}
		if ("TABNUMBER".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0x00, 0xD0, 0xFF}, null, false, false, false, false);
		}
		if ("DEFINE".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0xFF, 0x90, 0x00}, null, true, false, false, false);
		}
		if ("REDEFINE".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0xFF, 0x90, 0x00}, null, true, false, false, false);
		}
		if ("AS".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0xFF, 0x90, 0x00}, null, true, false, false, false);
		}
		if ("FRAGMENT".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0xFF, 0x90, 0x00}, null, true, false, false, false);
		}
		if ("COLLECT".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0xFF, 0x90, 0x00}, null, true, false, false, false);
		}
		if ("IN".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0xFF, 0x90, 0x00}, null, true, false, false, false);
		}
		if ("COLOR".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0xFF, 0x90, 0x00}, null, true, false, false, false);
		}
		if ("PRIORITIZE".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0xFF, 0x90, 0x00}, null, true, false, false, false);
		}
		if ("COMMENTS".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0x00, 0x80, 0x00}, null, false, false, false, false);
		}
		if ("ABSTRACT".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("SYNTAXDEF".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("FOR".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("START".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("IMPORTS".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("OPTIONS".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("TOKENS".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("TOKENSTYLES".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("RULES".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0x80, 0x00, 0x40}, null, true, false, false, false);
		}
		if ("STRING".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("QUOTED_39_39_92".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("QUOTED_60_62".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0x00, 0x00, 0x00}, null, false, false, false, false);
		}
		if ("WITH".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("SYNTAX".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_36_36".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}

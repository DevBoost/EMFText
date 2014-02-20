/*******************************************************************************
 * Copyright (c) 2006-2014
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

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class provides information about how brackets must be handled in the
 * editor (e.g., whether they must be closed automatically).
 */
public class CsBracketInformationProvider {
	
	public Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsBracketPair> getBracketPairs() {
		Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsBracketPair> result = new ArrayList<org.emftext.sdk.concretesyntax.resource.cs.ICsBracketPair>();
		result.add(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsBracketPair("{", "}", true, true));
		result.add(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsBracketPair("[", "]", true, false));
		result.add(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsBracketPair("(", ")", true, false));
		result.add(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsBracketPair("<", ">", false, false));
		result.add(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsBracketPair("'", "'", false, false));
		return result;
	}
	
}

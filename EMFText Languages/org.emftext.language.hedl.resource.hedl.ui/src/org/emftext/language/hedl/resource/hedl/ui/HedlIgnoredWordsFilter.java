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
package org.emftext.language.hedl.resource.hedl.ui;

import java.util.LinkedHashSet;
import java.util.Set;

import org.emftext.language.hedl.JavaType;
import org.emftext.language.hedl.resource.hedl.grammar.HedlGrammarInformationProvider;
import org.emftext.language.hedl.types.HedlBuiltinTypes;

/**
 * The IgnoredWordsFilter is customized to add the built-in types of HEDL to the 
 * list of words that must not be marked as misspelled.
 */
public class HedlIgnoredWordsFilter {
	
	/**
	 * Checks whether the given word must be ignored even it is misspelled.
	 */
	public boolean ignoreWord(String word) {
		Set<String> ignoredWords = new LinkedHashSet<String>(); 
		// By default we ignore all keywords that are defined in the syntax.
		ignoredWords.addAll(HedlGrammarInformationProvider.INSTANCE.getKeywords());
		// We also ignore the default data types.
		for (JavaType type : HedlBuiltinTypes.TYPES) {
			ignoredWords.add(type.getName());
		}
		return ignoredWords.contains(word);
	}
	
}

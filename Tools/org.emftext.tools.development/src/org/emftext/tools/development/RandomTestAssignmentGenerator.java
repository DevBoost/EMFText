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
package org.emftext.tools.development;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomTestAssignmentGenerator {

	public static void main(String[] args) {
		String[] languages = new String[] {
				"org.emftext.language.java",
				"org.emftext.language.java.javabehavior4uml",
				"org.emftext.language.java.ejava",
				"org.emftext.language.chess",
				"org.emftext.language.conference",
				"org.emftext.language.csv",
				"org.emftext.language.custom_sandwich",
				"org.emftext.language.customer",
				"org.emftext.language.dot",
				"org.emftext.language.ecore",
				"org.emftext.language.ecore.facade",
				"org.emftext.language.featherweight_java",
				"org.emftext.language.feature",
				"org.emftext.language.forms",
				"org.emftext.language.formular",
				"org.emftext.language.java_templates",
				"org.emftext.language.java.properties",
				"org.emftext.language.java.reusejava",
				"org.emftext.language.java.treejava",
				"org.emftext.language.km3",
				"org.emftext.language.martinfowlerdsl",
				"org.emftext.language.office",
				"org.emftext.language.owl",
				"org.emftext.language.quickuml",
				"org.emftext.language.petrinet",
				"org.emftext.language.pico",
				"org.emftext.language.regexp",
				"org.emftext.language.sandwich",
				"org.emftext.language.simple_c",
				"org.emftext.language.simple_gui",
				"org.emftext.language.simple_math",
				"org.emftext.language.statemachine",
				"org.emftext.language.textadventure",
				"org.emftext.language.threevaluedlogic",
				"org.emftext.language.usecaseinvariant",
				"org.emftext.language.valueflow",
		};
		
		String[] developers = new String[] {
				"Florian",
				"Jendrik",
				"Christian",
				"Sven",
				"Mirko",
		};

		Map<String, List<String>> assignments;
		while (true) {
			assignments = findAssignments(languages, developers);
			if (check(assignments)) {
				break;
			}
		}
		
		for (String developer : assignments.keySet()) {
			List<String> assignedLanguages = assignments.get(developer);
			System.out.println(developer + ":\n");
			int index = 1;
			for (String assignedLanguage : assignedLanguages) {
				System.out.println(index + ". " + assignedLanguage);
				index++;
			}
			System.out.println();
		}
	}

	private static boolean check(Map<String, List<String>> assignments) {
		for (List<String> assignedLanguages : assignments.values()) {
			// every developer should test at least seven languages
			if (assignedLanguages.size() < 7) {
				return false;
			}
		}
		return true;
	}

	private static Map<String, List<String>> findAssignments(
			String[] languages, String[] developers) {
		Map<String, List<String>> assignment = new HashMap<String, List<String>>();
		for (String language : languages) {
			int randomDeveloperIndex = (int) (Math.random() * developers.length);
			put(assignment, developers[randomDeveloperIndex], language);
		}
		return assignment;
	}

	private static void put(Map<String, List<String>> map,
			String key, String value) {
		List<String> valueList = map.get(key);
		if (valueList == null) {
			map.put(key, new ArrayList<String>());
			valueList = map.get(key);
		}
		valueList.add(value);
	}
}

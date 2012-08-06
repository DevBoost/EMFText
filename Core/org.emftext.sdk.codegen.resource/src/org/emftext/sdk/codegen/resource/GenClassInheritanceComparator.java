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
package org.emftext.sdk.codegen.resource;

import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;

/**
 * A comparator that sorts generator classes according to their inheritance
 * structure.
 */
public class GenClassInheritanceComparator implements Comparator<GenClass>{

	public int compare(GenClass g1, GenClass g2) {
		List<GenClass> superClasses1 = g1.getAllBaseGenClasses();
		if (superClasses1.contains(g2)) {
			return -1;
		} else {
			List<GenClass> superClasses2 = g2.getAllBaseGenClasses();
			if (superClasses2.contains(g1)) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
}
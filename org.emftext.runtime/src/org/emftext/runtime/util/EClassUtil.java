/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.runtime.util;

import org.eclipse.emf.ecore.EClass;

/**
 * A utility class that provides methods to handle EClasses.
 */
public class EClassUtil {
	
	public boolean isSubClass(EClass subClassCandidate, EClass superClass) {
		for (EClass superClassCandidate : subClassCandidate.getEAllSuperTypes()) {
			// There seem to be multiple instances of meta classes when accessed
			// through the generator model. Therefore, we compare by name.
			if (namesAndPackageURIsAreEqual(superClassCandidate, superClass)) {
				return true;
			}
		}
		return false;
	}

	public boolean namesAndPackageURIsAreEqual(EClass classA,
			EClass classB) {
		return namesAreEqual(classA, classB) && 
			packageURIsAreEqual(classA, classB);
	}

	public boolean packageURIsAreEqual(EClass classA,
			EClass classB) {
		String nsURI_A = classA.getEPackage().getNsURI();
		String nsURI_B = classB.getEPackage().getNsURI();
		return (nsURI_A == null && nsURI_B == null) || nsURI_A.equals(nsURI_B);
	}

	public boolean namesAreEqual(EClass classA, EClass classB) {
		return classA.getName().equals(classB.getName());
	}
}

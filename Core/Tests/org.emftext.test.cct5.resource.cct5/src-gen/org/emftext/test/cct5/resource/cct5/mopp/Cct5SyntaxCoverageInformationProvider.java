/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;

import org.eclipse.emf.ecore.EClass;

public class Cct5SyntaxCoverageInformationProvider {
	
	public EClass[] getClassesWithSyntax() {
		return new EClass[] {
			org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarm(),
			org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarmer(),
			org.emftext.test.cct5.Cct5Package.eINSTANCE.getAnimal(),
			org.emftext.test.cct5.Cct5Package.eINSTANCE.getDiet(),
		};
	}
	
	public EClass[] getStartSymbols() {
		return new EClass[] {
			org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarm(),
		};
	}
	
}

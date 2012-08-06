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
package org.emftext.language.rolecore.riehle97;

import org.emftext.language.rolecore.riehle97base.Customer;
import org.emftext.language.rolecore.riehle97base.Riehle97baseFactory;

import junit.framework.TestCase;

public class RiehleTest extends TestCase {

	public void testRoleHandling() {
		// create a clean core object
		Customer fred = Riehle97baseFactory.eINSTANCE.createCustomerCore();
//		boolean isBorrower = fred.hasRole(Borrower.class);
//		assertFalse(isBorrower);
//
//		// add a role
//		Borrower fredsBorrowerRole = Riehle97Factory.eINSTANCE.createBorrower();
//		fred.addRole(fredsBorrowerRole);
//
//		// check that the role is still there
//		isBorrower = fred.hasRole(Borrower.class);
//		assertTrue(isBorrower);
//
//		// get the role object
//		Borrower fredPlayingBorrower = fred.getRole(Borrower.class);
//		assertNotNull(fredPlayingBorrower);
//		// call a role specific method
//		fredPlayingBorrower.getCredits();
	}
}

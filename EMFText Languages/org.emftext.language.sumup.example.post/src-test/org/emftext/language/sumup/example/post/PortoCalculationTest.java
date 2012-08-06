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
package org.emftext.language.sumup.example.post;

import static org.junit.Assert.*;

import org.junit.Test;

public class PortoCalculationTest {

	@Test
	public void testCalculate() {
		// verschicke ein paeckchen
		PortoCalculation pc = new PortoCalculation();
		pc.setLaenge(30);
		pc.setBreite(30);
		pc.setHoehe(10);
		pc.setGewicht(1);
		pc.setSendungsAnzahl(1);
		
		pc.calculate();
		
		assertEquals("Unexpected price.", 3.9, pc.getEinzelPreis(), 0.0);
		assertEquals("Unexpected price.", 3.9, pc.getGesamtSumme(), 0.0);
	}
	
	// verschicke 20 x paket klein
	@Test
	public void testPaketKlein() {
		PortoCalculation pc = new PortoCalculation();
		pc.setLaenge(650);
		pc.setBreite(300);
		pc.setHoehe(100);
		pc.setGewicht(3000); // = 3kg
		pc.setSendungsAnzahl(20);
		
		pc.calculate();

		assertEquals("Unexpected price.", 5.9, pc.getEinzelPreis(), 0.0);
		assertEquals("Unexpected price.", 5.9 * 20, pc.getGesamtSumme(), 0.0);
	}
}

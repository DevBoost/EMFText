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

public class PortoCalculation {

	private double sendungsAnzahl;
	
	private double laenge;
	
	private double breite;
	
	private double hoehe;
	
	private double gewicht;
	
	private double einzelPreis;
	
	private double gesamtSumme;
	
	public double getSendungsAnzahl() {
		return this.sendungsAnzahl;
	}
	
	/**
	 * Set input parameter 'SendungsAnzahl'.
	 */
	public void setSendungsAnzahl(double newValue) {
		this.sendungsAnzahl = newValue / (1
		);
	}

	public double getLaenge() {
		return this.laenge;
	}
	
	/**
	 * Set input parameter 'Laenge'.
	 * Required unit is mm.
	 */
	public void setLaenge(double newValue) {
		this.laenge = newValue / (1
		);
	}

	public double getBreite() {
		return this.breite;
	}
	
	/**
	 * Set input parameter 'Breite'.
	 * Required unit is mm.
	 */
	public void setBreite(double newValue) {
		this.breite = newValue / (1
		);
	}

	public double getHoehe() {
		return this.hoehe;
	}
	
	/**
	 * Set input parameter 'Hoehe'.
	 * Required unit is mm.
	 */
	public void setHoehe(double newValue) {
		this.hoehe = newValue / (1
		);
	}

	public double getGewicht() {
		return this.gewicht;
	}
	
	/**
	 * Set input parameter 'Gewicht'.
	 * Required unit is g.
	 */
	public void setGewicht(double newValue) {
		this.gewicht = newValue / (1
		);
	}

	/**
	 * Returns output parameter 'EinzelPreis'.
	 * Unit is EUR.
	 */
	public double getEinzelPreis() {
		return this.einzelPreis / (((100 * 1
		)
		)
		
		);
	}
	
	/**
	 * Returns output parameter 'GesamtSumme'.
	 * Unit is EUR.
	 */
	public double getGesamtSumme() {
		return this.gesamtSumme / (((100 * 1
		)
		)
		
		);
	}
	
	public void calculate() {
		if ((((((this.laenge
		)
		 <= ((60 * ((10 * 1
		 )
		 )
		 
		 )
		 )
		 )
		 && ((this.breite
		 )
		  <= ((30 * ((10 * 1
		  )
		  )
		  
		  )
		  )
		  )
		 )
		 && ((this.hoehe
		 )
		  <= ((15 * ((10 * 1
		  )
		  )
		  
		  )
		  )
		  )
		 )
		 && ((this.gewicht
		 )
		  < ((2 * ((1000 * 1
		  )
		  )
		  
		  )
		  )
		  )
		 )
		) {	
		this.einzelPreis = ((3.9 * ((100 * 1
		)
		)
		
		)
		)
		;
		}
		if ((((((this.laenge
		)
		 > ((60 * ((10 * 1
		 )
		 )
		 
		 )
		 )
		 )
		 || ((this.breite
		 )
		  > ((30 * ((10 * 1
		  )
		  )
		  
		  )
		  )
		  )
		 )
		 || ((this.hoehe
		 )
		  > ((15 * ((10 * 1
		  )
		  )
		  
		  )
		  )
		  )
		 )
		 && ((this.gewicht
		 )
		  <= ((10 * ((1000 * 1
		  )
		  )
		  
		  )
		  )
		  )
		 )
		) {	
		this.einzelPreis = ((5.9 * ((100 * 1
		)
		)
		
		)
		)
		;
		}
		if (((((((this.laenge
		)
		 > ((60 * ((10 * 1
		 )
		 )
		 
		 )
		 )
		 )
		 || ((this.breite
		 )
		  > ((30 * ((10 * 1
		  )
		  )
		  
		  )
		  )
		  )
		 )
		 || ((this.hoehe
		 )
		  > ((15 * ((10 * 1
		  )
		  )
		  
		  )
		  )
		  )
		 )
		 && ((this.gewicht
		 )
		  > ((10 * ((1000 * 1
		  )
		  )
		  
		  )
		  )
		  )
		 )
		 && ((this.gewicht
		 )
		  <= ((20 * ((1000 * 1
		  )
		  )
		  
		  )
		  )
		  )
		 )
		) {	
		this.einzelPreis = ((10.9 * ((100 * 1
		)
		)
		
		)
		)
		;
		}
		if (((((((this.laenge
		)
		 > ((60 * ((10 * 1
		 )
		 )
		 
		 )
		 )
		 )
		 || ((this.breite
		 )
		  > ((30 * ((10 * 1
		  )
		  )
		  
		  )
		  )
		  )
		 )
		 || ((this.hoehe
		 )
		  > ((15 * ((10 * 1
		  )
		  )
		  
		  )
		  )
		  )
		 )
		 && ((this.gewicht
		 )
		  > ((20 * ((1000 * 1
		  )
		  )
		  
		  )
		  )
		  )
		 )
		 && ((this.gewicht
		 )
		  <= ((31.5 * ((1000 * 1
		  )
		  )
		  
		  )
		  )
		  )
		 )
		) {	
		this.einzelPreis = ((12.9 * ((100 * 1
		)
		)
		
		)
		)
		;
		}
		if (((this.sendungsAnzahl
		)
		 < ((500 * 1
		 )
		 )
		 )
		) {	
		this.gesamtSumme = ((this.sendungsAnzahl
		)
		 * (this.einzelPreis
		 )
		 )
		;
		}
		if (((this.sendungsAnzahl
		)
		 >= ((500 * 1
		 )
		 )
		 )
		) {	
		this.gesamtSumme = (((this.sendungsAnzahl
		)
		 * (this.einzelPreis
		 )
		 )
		 * ((0.8 * 1
		 )
		 )
		 )
		;
		}
	}
}

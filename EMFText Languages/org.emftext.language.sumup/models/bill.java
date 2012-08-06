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
package resource.org.emftext.language.sumup.models;

public class bill {

	private double apples;
	
	private double veal;
	
	private double sugar;
	
	private double sums;
	
	/**
	 * Returns output parameter 'Apples'.
	 */
	public double getApples() {
		return this.apples / (1
		);
	}
	
	/**
	 * Returns output parameter 'Veal'.
	 */
	public double getVeal() {
		return this.veal / (1
		);
	}
	
	/**
	 * Returns output parameter 'Sugar'.
	 */
	public double getSugar() {
		return this.sugar / (1
		);
	}
	
	/**
	 * Returns output parameter 'Sums'.
	 */
	public double getSums() {
		return this.sums / (1
		);
	}
	
	public void calculate() {
		this.apples = (((700 * 1
		)
		)
		 * ((2.99 * 1
		 )
		 )
		 )
		;
		this.veal = (((500 * 1
		)
		)
		 * ((3.99 * ((0.01 * 1
		 )
		 )
		 
		 )
		 )
		 )
		;
		this.sugar = ((1.49 * 1
		)
		)
		;
		this.sums = ((this.apples
		)
		 + (this.veal
		 )
		 )
		;
	}
}

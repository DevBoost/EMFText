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
package org.emftext.language.calc.interpreter.events;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.calc.Expression;
import org.emftext.language.calc.resource.calc.ICalcTextPrinter;
import org.emftext.language.calc.resource.calc.ICalcTextResource;
import org.emftext.language.calc.resource.calc.mopp.CalcMetaInformation;
import org.emftext.language.calc.resource.calc.mopp.CalcResource;

public class CheckConditionEvent implements ICalcInterpreterEvent {

	private Expression condition;
	private boolean value;

	public CheckConditionEvent(Expression condition, boolean value) {
		super();
		this.condition = condition;
		this.value = value;
	}
	
	public String toString() {
		String conditionText = getText(condition);
		return "Condition '" + conditionText.trim() + "' is " + value;
	}

	private String getText(EObject eObject) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ICalcTextResource resource = new CalcResource();
		ICalcTextPrinter printer = new CalcMetaInformation().createPrinter(outputStream , resource);
		try {
			printer.print(eObject);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return outputStream.toString();
	}
}

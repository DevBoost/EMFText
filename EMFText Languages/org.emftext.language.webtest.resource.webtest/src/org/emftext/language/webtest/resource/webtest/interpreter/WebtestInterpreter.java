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
package org.emftext.language.webtest.resource.webtest.interpreter;

import java.io.IOException;

import org.emftext.language.webtest.AssertText;
import org.emftext.language.webtest.AssertTitle;
import org.emftext.language.webtest.Input;
import org.emftext.language.webtest.Load;
import org.emftext.language.webtest.Submit;
import org.emftext.language.webtest.TestScript;
import org.emftext.language.webtest.resource.webtest.util.AbstractWebtestInterpreter;

import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * An interpreter for .webtest scripts that uses the HtmlUnit framework to 
 * communicate with the web. Failures that might occur during interpretation
 * can be handled by attaching an IWebtestFailureHandler to the context of
 * the interpreter.
 */
public class WebtestInterpreter extends AbstractWebtestInterpreter<Boolean, WebtestContext> {

	@Override
	public Boolean interprete_org_emftext_language_webtest_TestScript(TestScript object, WebtestContext context) {
		return true;
	}

	@Override
	public Boolean interprete_org_emftext_language_webtest_Load(Load object, WebtestContext context) {
		try {
			context.setCurrentPage(object.getUrl());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean interprete_org_emftext_language_webtest_AssertTitle(AssertTitle at, WebtestContext context) {
		String actualTitle = context.getCurrentPage().getTitleText();
		String expected = at.getExpected();
		if (!expected.equals(actualTitle)) {
			context.handleFailedAssertion("Wrong title.", expected, actualTitle);
		}
		return true;
	}
	
	@Override
	public Boolean interprete_org_emftext_language_webtest_AssertText(AssertText at, WebtestContext context) {
		String actualText = context.getCurrentPage().getTextContent();
		String expected = at.getExpected();
		if (!expected.contains(actualText)) {
			context.handleFailedAssertion("Wrong title.", expected, actualText);
		}
		return true;
	}
	
	@Override
	public Boolean interprete_org_emftext_language_webtest_Submit(Submit object, WebtestContext context) {
		String formName = object.getForm();
		HtmlForm form = (HtmlForm) context.getCurrentPage().getElementById(formName);
		String button = object.getButton();
		HtmlInput submitButton = form.getInputByName(button);
		try {
			context.setCurrentPage((HtmlPage) submitButton.click());
		} catch (IOException e) {
			context.handleFailedAssertion("Exception while clicking button (" + e.getMessage() + ").", button, null);
		}
		return true;
	}

	@Override
	public Boolean interprete_org_emftext_language_webtest_Input(Input object, WebtestContext context) {
		String formName = object.getForm();
		HtmlForm form = (HtmlForm) context.getCurrentPage().getElementById(formName);
		HtmlInput field = form.getInputByName(object.getField());
		field.setValueAttribute(object.getValue());
		return true;
	}

	@Override
	public boolean continueInterpretation(WebtestContext context, Boolean result) {
		if (result == null) {
			context.handleFailedAssertion("Stopping web test.", null, null);
			return false;
		}
		return result;
	}
}

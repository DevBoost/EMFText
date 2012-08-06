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
package org.emftext.language.forms.generator;

import java.util.Iterator;
import java.util.List;

import org.emftext.language.forms.Choice;
import org.emftext.language.forms.Date;
import org.emftext.language.forms.Decision;
import org.emftext.language.forms.Form;
import org.emftext.language.forms.FreeText;
import org.emftext.language.forms.Group;
import org.emftext.language.forms.Item;
import org.emftext.language.forms.Option;
import org.emftext.language.forms.resource.forms.custom.AbstractGenerator;

import de.devboost.commenttemplate.CommentTemplate;

public class HTMLFormGeneratorSource extends AbstractGenerator {

	@SuppressWarnings("unused")
	@CommentTemplate
	public String generateString(Object argument) {
		Form form = (Form) argument;
		String formCaption = form.getCaption();
		/*<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
		<html> 
		<head><title>formCaption</title></head>

		<body>
			<h1>Form: formCaption</h1>
*/
		for (Group gruppe : form.getGroups()) {
			String gruppenName = gruppe.getName();
/*				<fieldset>
		    	<legend>gruppenName</legend>
*/
			List<Item> list = gruppe.getItems();
		    for (Iterator<Item> iterator = list.iterator(); iterator.hasNext();) {
		    	Item frage = iterator.next();
		    	String frageText = frage.getText();
/*				<b>frageText</b>
*/
		    	if (frage.getExplanation() != null) { 
		    		String explanation = frage.getExplanation();
/*					explanation
*/
		    	}
/*				<br>*/
		    	if (frage.getDependentOf().size() > 0) {
/*				(Only if: &nbsp;*/
		    		for(Option option : frage.getDependentOf()) {
		    			String optionID = option.getId();
		    			String itemAddress = generateItemAddress(frage);
		    			/*optionID was selected for Item itemAddress*/
		    		}
/*				)*/
				}
/*				<br>
*/ 
		    	if (frage.getItemType() instanceof FreeText) {
		    		/*<input size=30></input>*/
				}
				if (frage.getItemType() instanceof Date) {
/*					<input size="2" maxlength="2" value="DD"/>.
					<input size="2" maxlength="2" value="MM"/>.
					<input size="4" maxlength="4" value="YYYY"/>	
*/ 
				} 
				if (frage.getItemType() instanceof org.emftext.language.forms.Number) {
					/*<input size=10></input>*/ 
				}
				if (frage.getItemType() instanceof Choice) { 
					Choice auswahl = (Choice) frage.getItemType();
					for (Option option : auswahl.getOptions()) {
						String auswahlText = frage.getText();
						String optionID = option.getId();
						if (auswahl.isMultiple()) {
							/*<input type="checkbox" name="auswahlText" value="auswahlText"> auswahlText*/
							if (optionID != null) {
								/* (mind: optionID )*/
							}
						} else {
							/*<input type="radio" name="auswahlText" value="auswahlText"> auswahlText*/
							if (optionID != null) {
								/* (mind: optionID )*/
							}
						}
/*				<br>
*/ 		
					}
				}
				if (frage.getItemType() instanceof Decision) { 
					Decision entscheidung = (Decision) frage.getItemType();
					String entscheidungsText = frage.getText();
					/*<input type="checkbox" name="entscheidungsText" title="Yes|No" checked="checked" value="ok" /> 
					<label for="entscheidungsText">entscheidungsText</label>
					 */ 
					String firstID = entscheidung.getOptions().get(0).getId();
					if (firstID != null) {
						/* (Yes: firstID ) */
					}
					String secondID = entscheidung.getOptions().get(1).getId();
					if (secondID != null) {
						/* (No: secondID ) */
					}
				}
/*			<br>
*/
		    }
/*			</fieldset>*/
		}
/*
		</body>
		</html>
*/
		return "";
	}
}

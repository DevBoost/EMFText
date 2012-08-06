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

public class HTMLFormGenerator extends AbstractGenerator {

	@SuppressWarnings("unused")
	public String generateString(Object argument) {
		StringBuilder __content = new StringBuilder();
		Form form = (Form) argument;
		String formCaption = form.getCaption();
		__content.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n");
		__content.append("<html> \n");
		__content.append("<head><title>");
		__content.append(formCaption.replaceAll("\\n\\z",""));
		__content.append("</title></head>\n");
		__content.append("\n");
		__content.append("<body>\n");
		__content.append("\t<h1>Form: ");
		__content.append(formCaption.replaceAll("\\n\\z","").replace("\n","\n\t"));
		__content.append("</h1>\n");
		__content.append("");
		/*<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
		<html> 
		<head><title>formCaption</title></head>

		<body>
			<h1>Form: formCaption</h1>
*/
		for (Group gruppe : form.getGroups()) {
			String gruppenName = gruppe.getName();
	__content.append("\t<fieldset>\n");
	__content.append("<legend>");
	__content.append(gruppenName.replaceAll("\\n\\z",""));
	__content.append("</legend>\n");
	__content.append("");
/*				<fieldset>
		    	<legend>gruppenName</legend>
*/
			List<Item> list = gruppe.getItems();
		    for (Iterator<Item> iterator = list.iterator(); iterator.hasNext();) {
		    	Item frage = iterator.next();
		    	String frageText = frage.getText();
	__content.append("<b>");
	__content.append(frageText.replaceAll("\\n\\z",""));
	__content.append("</b>\n");
	__content.append("");
/*				<b>frageText</b>
*/
		    	if (frage.getExplanation() != null) { 
		    		String explanation = frage.getExplanation();
	__content.append("");
	__content.append(explanation.replaceAll("\\n\\z",""));
	__content.append("\n");
	__content.append("");
/*					explanation
*/
		    	}
	__content.append("<br>");
/*				<br>*/
		    	if (frage.getDependentOf().size() > 0) {
	__content.append("(Only if: &nbsp;");
/*				(Only if: &nbsp;*/
		    		for(Option option : frage.getDependentOf()) {
		    			String optionID = option.getId();
		    			String itemAddress = generateItemAddress(frage);
	__content.append("");
	__content.append(optionID.replaceAll("\\n\\z",""));
	__content.append(" was selected for Item ");
	__content.append(itemAddress.replaceAll("\\n\\z",""));
	__content.append("");
		    			/*optionID was selected for Item itemAddress*/
		    		}
	__content.append(")");
/*				)*/
				}
	__content.append("<br>\n");
	__content.append("");
/*				<br>
*/ 
		    	if (frage.getItemType() instanceof FreeText) {
	__content.append("<input size=30></input>");
		    		/*<input size=30></input>*/
				}
				if (frage.getItemType() instanceof Date) {
	__content.append("<input size=\"2\" maxlength=\"2\" value=\"DD\"/>.\n");
	__content.append("<input size=\"2\" maxlength=\"2\" value=\"MM\"/>.\n");
	__content.append("<input size=\"4\" maxlength=\"4\" value=\"YYYY\"/>\t\n");
	__content.append("");
/*					<input size="2" maxlength="2" value="DD"/>.
					<input size="2" maxlength="2" value="MM"/>.
					<input size="4" maxlength="4" value="YYYY"/>	
*/ 
				} 
				if (frage.getItemType() instanceof org.emftext.language.forms.Number) {
	__content.append("<input size=10></input>");
					/*<input size=10></input>*/ 
				}
				if (frage.getItemType() instanceof Choice) { 
					Choice auswahl = (Choice) frage.getItemType();
					for (Option option : auswahl.getOptions()) {
						String auswahlText = frage.getText();
						String optionID = option.getId();
						if (auswahl.isMultiple()) {
	__content.append("<input type=\"checkbox\" name=\"");
	__content.append(auswahlText.replaceAll("\\n\\z",""));
	__content.append("\" value=\"");
	__content.append(auswahlText.replaceAll("\\n\\z",""));
	__content.append("\"> ");
	__content.append(auswahlText.replaceAll("\\n\\z",""));
	__content.append("");
							/*<input type="checkbox" name="auswahlText" value="auswahlText"> auswahlText*/
							if (optionID != null) {
	__content.append(" (mind: ");
	__content.append(optionID.replaceAll("\\n\\z",""));
	__content.append(" )");
								/* (mind: optionID )*/
							}
						} else {
	__content.append("<input type=\"radio\" name=\"");
	__content.append(auswahlText.replaceAll("\\n\\z",""));
	__content.append("\" value=\"");
	__content.append(auswahlText.replaceAll("\\n\\z",""));
	__content.append("\"> ");
	__content.append(auswahlText.replaceAll("\\n\\z",""));
	__content.append("");
							/*<input type="radio" name="auswahlText" value="auswahlText"> auswahlText*/
							if (optionID != null) {
	__content.append(" (mind: ");
	__content.append(optionID.replaceAll("\\n\\z",""));
	__content.append(" )");
								/* (mind: optionID )*/
							}
						}
	__content.append("<br>\n");
	__content.append("");
/*				<br>
*/ 		
					}
				}
				if (frage.getItemType() instanceof Decision) { 
					Decision entscheidung = (Decision) frage.getItemType();
					String entscheidungsText = frage.getText();
	__content.append("<input type=\"checkbox\" name=\"");
	__content.append(entscheidungsText.replaceAll("\\n\\z",""));
	__content.append("\" title=\"Yes|No\" checked=\"checked\" value=\"ok\" /> \n");
	__content.append("<label for=\"");
	__content.append(entscheidungsText.replaceAll("\\n\\z",""));
	__content.append("\">");
	__content.append(entscheidungsText.replaceAll("\\n\\z",""));
	__content.append("</label>\n");
	__content.append(" ");
					/*<input type="checkbox" name="entscheidungsText" title="Yes|No" checked="checked" value="ok" /> 
					<label for="entscheidungsText">entscheidungsText</label>
					 */ 
					String firstID = entscheidung.getOptions().get(0).getId();
					if (firstID != null) {
	__content.append(" (Yes: ");
	__content.append(firstID.replaceAll("\\n\\z",""));
	__content.append(" ) ");
						/* (Yes: firstID ) */
					}
					String secondID = entscheidung.getOptions().get(1).getId();
					if (secondID != null) {
	__content.append(" (No: ");
	__content.append(secondID.replaceAll("\\n\\z",""));
	__content.append(" ) ");
						/* (No: secondID ) */
					}
				}
	__content.append("<br>\n");
	__content.append("");
/*			<br>
*/
		    }
	__content.append("</fieldset>");
/*			</fieldset>*/
		}
		__content.append("\n");
		__content.append("</body>\n");
		__content.append("</html>\n");
		__content.append("");
/*
		</body>
		</html>
*/
		return __content.toString();
	}
}

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

import java.util.List;

import org.emftext.language.forms.Choice;
import org.emftext.language.forms.Decision;
import org.emftext.language.forms.Form;
import org.emftext.language.forms.Group;
import org.emftext.language.forms.Item;
import org.emftext.language.forms.ItemType;
import org.emftext.language.forms.Option;
import org.emftext.language.forms.resource.forms.custom.AbstractGenerator;

public class XMLFormGenerator extends AbstractGenerator {

	@SuppressWarnings("unused")
	public String generateString(Object argument) {
		StringBuilder __content = new StringBuilder();
		Form form = (Form) argument;
		String formCaption = form.getCaption() == null ? "My Form" : form.getCaption();
		__content.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"no\"?>\n");
		__content.append("\n");
		__content.append("<form titel=\"");
		__content.append(formCaption.replaceAll("\\n\\z",""));
		__content.append("\"\n");
		__content.append("\txmlns=\"http://org.emftext.language.forms/metamodel/FormMM.xsd\" \n");
		__content.append("\txmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" \n");
		__content.append("\txsi:schemaLocation=\"http://org.emftext.language.forms/metamodel/FormMM.xsd schema/FormMM.xsd\">\n");
		__content.append("");
		/*<?xml version="1.0" encoding="ISO-8859-1" standalone="no"?>

		<form titel="formCaption"
			xmlns="http://org.emftext.language.forms/metamodel/FormMM.xsd" 
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
			xsi:schemaLocation="http://org.emftext.language.forms/metamodel/FormMM.xsd schema/FormMM.xsd">
*/ 
		List<Group> gruppen=form.getGroups();
		for (Group gruppe:gruppen) {
			String gruppenName = gruppe.getName();
	__content.append("<gruppe name=\"");
	__content.append(gruppenName.replaceAll("\\n\\z",""));
	__content.append("\">\n");
	__content.append("");
/*	  		<gruppe name="gruppenName">
*/  
			List<Item> fragen = gruppe.getItems();
	   		for (Item frage :fragen) {
	   			ItemType typ = frage.getItemType();
	   			String typName = typ.eClass().getName().toLowerCase();
	   			String erklaerung = frage.getExplanation();
	   			String frageText = frage.getText();
	   			List<Option> vorbedingungen = frage.getDependentOf();
	__content.append("<");
	__content.append(typName.replaceAll("\\n\\z",""));
	__content.append(">\n");
	__content.append("");
/*				<typName>
*/ 
				if (frageText != null) {
	__content.append("<text>");
	__content.append(frageText.replaceAll("\\n\\z",""));
	__content.append("</text>\n");
	__content.append("");
/* 					<text>frageText</text>
*/ 
				}
				if (erklaerung != null) {
	__content.append("<");
	__content.append(erklaerung.replaceAll("\\n\\z",""));
	__content.append(">fragenErklaerung</");
	__content.append(erklaerung.replaceAll("\\n\\z",""));
	__content.append(">\n");
	__content.append("");
/* 					<erklaerung>fragenErklaerung</erklaerung>
*/
				}
				if (!vorbedingungen.isEmpty()) {
	__content.append("<vorbedingungen>\n");
	__content.append("");
/* 					<vorbedingungen>
*/ 
					for (Option option:vorbedingungen) {
						String optionID = option.getId();
	__content.append("<option id=\"");
	__content.append(optionID.replaceAll("\\n\\z",""));
	__content.append("\"/>\n");
	__content.append("");
/*						<option id="optionID"/>
*/ 
					}
	__content.append("</vorbedingungen>\n");
	__content.append("");
/*					</vorbedingungen>
*/ 
				}
				if (typ instanceof Choice) { 
					Choice auswahl = (Choice) typ;
					String isMultiple = Boolean.toString(auswahl.isMultiple());
	__content.append("<optionen mehrfach=\"");
	__content.append(isMultiple.replaceAll("\\n\\z",""));
	__content.append("\">\n");
	__content.append("");
/*					<optionen mehrfach="isMultiple">
*/ 
					for (Option option:auswahl.getOptions()) {
						String optionID = option.getId() == null ? "" : option.getId();
						String optionText = option.getText();
	__content.append("<option id=\"");
	__content.append(optionID.replaceAll("\\n\\z",""));
	__content.append("\">");
	__content.append(optionText.replaceAll("\\n\\z",""));
	__content.append("</option>\n");
	__content.append("");
/*						<option id="optionID">optionText</option>
*/
					}
	__content.append("</optionen>\n");
	__content.append("");
/*					</optionen>
*/
				} else if (typ instanceof Decision) {
					Decision entscheidung = (Decision) typ;
					for (Option option : entscheidung.getOptions()) {
						String optionID = option.getId() == null ? "" : option.getId();
						String optionText = option.getText();
	__content.append("<option id=\"");
	__content.append(optionID.replaceAll("\\n\\z",""));
	__content.append("\">");
	__content.append(optionText.replaceAll("\\n\\z",""));
	__content.append("</option>\n");
	__content.append("");
/*						<option id="optionID">optionText</option>
*/
					}
				}
	__content.append("</");
	__content.append(typName.replaceAll("\\n\\z",""));
	__content.append(">\n");
	__content.append("");
/*				</typName>
*/ 
	   		}
	__content.append("</gruppe>\n");
	__content.append("");
/*			</gruppe>
*/		}
		__content.append("</form>\n");
		__content.append("");
/*		</form>
*/
		return __content.toString();
	}
}

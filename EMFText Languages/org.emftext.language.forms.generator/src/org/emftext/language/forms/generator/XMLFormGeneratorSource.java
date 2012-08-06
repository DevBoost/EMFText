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

import de.devboost.commenttemplate.CommentTemplate;

public class XMLFormGeneratorSource extends AbstractGenerator {

	@SuppressWarnings("unused")
	@CommentTemplate
	public String generateString(Object argument) {
		Form form = (Form) argument;
		String formCaption = form.getCaption() == null ? "My Form" : form.getCaption();
		/*<?xml version="1.0" encoding="ISO-8859-1" standalone="no"?>

		<form titel="formCaption"
			xmlns="http://org.emftext.language.forms/metamodel/FormMM.xsd" 
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
			xsi:schemaLocation="http://org.emftext.language.forms/metamodel/FormMM.xsd schema/FormMM.xsd">
*/ 
		List<Group> gruppen=form.getGroups();
		for (Group gruppe:gruppen) {
			String gruppenName = gruppe.getName();
/*	  		<gruppe name="gruppenName">
*/  
			List<Item> fragen = gruppe.getItems();
	   		for (Item frage : fragen) {
	   			ItemType typ = frage.getItemType();
	   			String typName = typ.eClass().getName().toLowerCase();
	   			String erklaerung = frage.getExplanation();
	   			String frageText = frage.getText();
	   			List<Option> vorbedingungen = frage.getDependentOf();
/*				<typName>
*/ 
				if (frageText != null) {
/* 					<text>frageText</text>
*/ 
				}
				if (erklaerung != null) {
/* 					<erklaerung>fragenErklaerung</erklaerung>
*/
				}
				if (!vorbedingungen.isEmpty()) {
/* 					<vorbedingungen>
*/ 
					for (Option option:vorbedingungen) {
						String optionID = option.getId();
/*						<option id="optionID"/>
*/ 
					}
/*					</vorbedingungen>
*/ 
				}
				if (typ instanceof Choice) { 
					Choice auswahl = (Choice) typ;
					String isMultiple = Boolean.toString(auswahl.isMultiple());
/*					<optionen mehrfach="isMultiple">
*/ 
					for (Option option:auswahl.getOptions()) {
						String optionID = option.getId() == null ? "" : option.getId();
						String optionText = option.getText();
/*						<option id="optionID">optionText</option>
*/
					}
/*					</optionen>
*/
				} else if (typ instanceof Decision) {
					Decision entscheidung = (Decision) typ;
					for (Option option : entscheidung.getOptions()) {
						String optionID = option.getId() == null ? "" : option.getId();
						String optionText = option.getText();
/*						<option id="optionID">optionText</option>
*/
					}
				}
/*				</typName>
*/ 
	   		}
/*			</gruppe>
*/		}
/*		</form>
*/
		return "";
	}
}

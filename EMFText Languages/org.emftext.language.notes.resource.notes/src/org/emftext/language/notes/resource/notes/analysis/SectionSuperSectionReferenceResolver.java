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
/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.notes.NoteDocument;
import org.emftext.language.notes.Part;
import org.emftext.language.notes.Section;

public class SectionSuperSectionReferenceResolver implements org.emftext.language.notes.resource.notes.INotesReferenceResolver<org.emftext.language.notes.Section, org.emftext.language.notes.Section> {
	
	private org.emftext.language.notes.resource.notes.analysis.NotesDefaultResolverDelegate<org.emftext.language.notes.Section, org.emftext.language.notes.Section> delegate = new org.emftext.language.notes.resource.notes.analysis.NotesDefaultResolverDelegate<org.emftext.language.notes.Section, org.emftext.language.notes.Section>();
	
	public void resolve(String identifier, org.emftext.language.notes.Section container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.notes.resource.notes.INotesReferenceResolveResult<org.emftext.language.notes.Section> result) {
		EObject root = EcoreUtil.getRootContainer(container);
		if(root instanceof NoteDocument){
			NoteDocument doc = (NoteDocument) root;
			List<Part> parts = doc.getParts();
			List<Section> sections = collectSections(parts);
			for (Section section : sections) {
				if(resolveFuzzy || identifier.equals(section.getId())){
					result.addMapping(identifier, section);
				}
			}
		} else {
			result.setErrorMessage("Invalid Note Document");
		}
	}
	
	public String deResolve(org.emftext.language.notes.Section element, org.emftext.language.notes.Section container, org.eclipse.emf.ecore.EReference reference) {
		return element.getId();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
	private List<Section> collectSections(List<Part> parts){
		List<Section> sections = new ArrayList<Section>();
		for (Part part : parts) {
			if(part instanceof Section){
				Section sec = (Section) part;
				sections.add(sec);
			}
		}
		return sections;
	}
}

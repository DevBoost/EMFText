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
package org.emftext.language.bibtex.resource.bib;

import java.io.File;
import java.util.Collections;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.emftext.language.bibtex.Bibliography;
import org.emftext.language.bibtex.BibtexKeyField;
import org.emftext.language.bibtex.Entry;
import org.emftext.language.bibtex.InProceedingsEntry;
import org.emftext.language.bibtex.resource.bib.mopp.BibResource;

public class BibtexOptionProvider implements IBibOptionProvider,
		IBibResourcePostProcessor, IBibResourcePostProcessorProvider {

	public IBibResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public Map<?, ?> getOptions() {
		return Collections.singletonMap(
				IBibOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
	}

	public void process(BibResource resource) {
//		try {
			if (resource.getContents().size() == 1) {
				IFile file = WorkspaceSynchronizer.getFile(resource);
				IProject project = file.getProject();
				File root = project.getLocation().toFile();
				// get the root element which is the bibliography containing all
				// entries
				EObject rootElement = resource.getContents().get(0);
				if (rootElement instanceof Bibliography) {
					Bibliography bibliography = (Bibliography) rootElement;
					EList<Entry> entries = bibliography.getEntries();
//					for (Entry entry : entries) {
//						// check general fields first
//						checkGeneralFields(entry);
//						// check if required fields are given
//						checkEntry(entry);
//					}
				}
			}
//		} catch (EntryException e) {
//			resource.addError(e.getErrorMsg(), e.getType(), e.getEntry());
//		}
	}

	private void checkEntry(Entry entry) {
		if (entry instanceof InProceedingsEntry) {
			InProceedingsEntry inproceedings = (InProceedingsEntry) entry;
		}
	}

	private void checkGeneralFields(Entry entry) throws EntryException {
		checkBibtexKey(entry);
		// TODO: insert more general checks here
	}

	private void checkBibtexKey(Entry entry) throws EntryException
	{
		BibtexKeyField bibtexKey = entry.getBibtexKey();
		if (bibtexKey == null || isEmpty(bibtexKey.getValue())) {
			throw new EntryException("Bibtexkey is not set", entry);
		}
	}
	
	private boolean isEmpty(String str)
	{
		return (str == null || "".equals(str));
	}
	
	class EntryException extends Exception {

		/**
		 * default id.
		 */
		private static final long serialVersionUID = 1L;
		private final String errorMsg;

		private final BibEProblemType type;
		private final Entry entry;

		public EntryException(String errorMsg, BibEProblemType type, Entry entry) {
			super();
			this.errorMsg = errorMsg;
			this.type = type;
			this.entry = entry;
		}

		public EntryException(String errorMsg, Entry entry) {
			this(errorMsg, BibEProblemType.ANALYSIS_PROBLEM, entry);
		}

		protected String getErrorMsg() {
			return errorMsg;
		}

		protected BibEProblemType getType() {
			return type;
		}

		protected Entry getEntry() {
			return entry;
		}

	}

	public void terminate() { }

}

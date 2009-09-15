/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.runtime.ui;

import org.eclipse.jface.text.DocumentEvent;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.ui.editor.EMFTextEditor;

/**
 * Implementation of this interface can be used to determine whether
 * background parsing is required depending of the change made to a 
 * text document.
 */
// TODO mseifert: remove this interface the corresponding abstact class once the
// editors are generated
public interface IBackgroundParsingStrategy {
	
	/**
	 * Implementations of this method must decide whether the
	 * given event should trigger a complete parse of the 
	 * text resource.
	 * 
	 * @param event the event that changed the document
	 * @param resource the resource the is associated with the document
	 * @param editor the editor that shows the document
	 */
	public void parse(DocumentEvent event, ITextResource resource, EMFTextEditor editor);
}

/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.runtime.ui.editor.bg_parsing;

import org.eclipse.jface.text.DocumentEvent;

/**
 * Implementation of this interface can be used to determine whether
 * background parsing is required depending of the change made to a 
 * text document.
 */
public interface IBackgroundParsingStrategy {
	
	/**
	 * Implementations of this method must decide whether the
	 * given event should trigger a complete parse of the 
	 * text resource.
	 * 
	 * @param event
	 * @return
	 */
	public boolean isParsingRequired(DocumentEvent event);
}

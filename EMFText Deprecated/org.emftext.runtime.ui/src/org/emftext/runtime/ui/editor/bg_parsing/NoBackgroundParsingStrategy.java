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
 * A simple parsing strategy that never triggers background parsing.
 */
@Deprecated public class NoBackgroundParsingStrategy implements IBackgroundParsingStrategy {

	public boolean isParsingRequired(DocumentEvent event) {
		return false;
	}

}

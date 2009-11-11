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
package org.emftext.sdk.concretesyntax.resource.cs.mopp;

// A InputStreamProcessor can be used like a normal java.io.InputStream,
// but provides information about the encoding that is used to
// represent characters as bytes.
public abstract class CsInputStreamProcessor extends java.io.InputStream {
	
	// Returns the encoding of the characters that can be read
	// from this InputStreamProcessor. This encoding is passed
	// to subsequent streams (e.g., the ANTLRInputStream).
	public abstract String getOutputEncoding();
}

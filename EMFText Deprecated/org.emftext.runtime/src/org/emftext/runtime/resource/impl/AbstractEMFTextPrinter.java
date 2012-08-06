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
package org.emftext.runtime.resource.impl;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ITextPrinter;
import org.emftext.runtime.resource.ITextResource;

/**
 * Base implementation for all generated printers. 
 * It implements the specifications from {@link ITextPrinter}.
 */
public abstract class AbstractEMFTextPrinter implements ITextPrinter {
	
	protected final static String NEW_LINE = System.getProperties().getProperty("line.separator");
	
    protected OutputStream outputStream;
    protected ITextResource resource;
	private Map<?, ?> options;
    
    /**
     * Standard constructor.
     * 
     * @param o Output stream to print to.
     * @param resource The associated resource.
     */
    public AbstractEMFTextPrinter(OutputStream outputStream, ITextResource resource) {
        this.outputStream = outputStream;
        this.resource = resource;
    }
    
    public void setOptions(Map<?,?> options) {
    	this.options = options;
    }
    
    public Map<?,?> getOptions() {
    	return options;
    }
    
    /**
     * This method must be overridden by generated subclasses.
     */
    protected abstract void doPrint(EObject element, PrintWriter out, String globaltab);
    
    /**
     * Calls {@link #doPrint(EObject, String)} and writes the result to the underlying
     * output stream.
     */
    public void print(EObject element)  {
        PrintWriter out = new PrintWriter(new BufferedOutputStream(outputStream));
        doPrint(element,out,"");
    	out.flush();
    	out.close();
    }
}

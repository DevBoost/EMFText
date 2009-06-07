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
    
    /** 
     * Holds the resource that is associated with this
     * printer. may be null if the printer is used
     * stand alone.
     */
    private ITextResource resource;
    
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
    
    public ITextResource getResource() {
    	return resource;
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

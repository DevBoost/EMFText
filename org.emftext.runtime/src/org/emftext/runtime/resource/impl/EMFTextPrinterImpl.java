package org.emftext.runtime.resource.impl;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.EMFTextPrinter;
import org.emftext.runtime.resource.TextResource;

/**
 * Base implementation for all generated printers. 
 * It implements the specifications from {@link EMFTextPrinter}.
 * 
 * @author Jendrik Johannes
 */
public abstract class EMFTextPrinterImpl implements EMFTextPrinter {
	
	protected static String newline = (System.getProperties().getProperty("line.separator"));
    protected OutputStream o;
    protected TextResource resource;
	private Map<?, ?> options;
    
    /**
     * Standard constructor.
     * 
     * @param o Output stream to print to.
     * @param resource The associated resource.
     */
    public EMFTextPrinterImpl(OutputStream o, TextResource resource) {
        this.o = o;
        this.resource = resource;
    }
    
    public void setOptions(Map<?,?> options) {
    	this.options = options;
    }
    
    public Map<?,?> getOptions() {
    	return options;
    }
    
    /**
     * This method should will be overridden by generated subclasses.
     * This implementation does nothing.
     */
    protected abstract void doPrint(EObject element,PrintWriter out,String globaltab);
    
    /**
     * Calls {@link #doPrint(EObject, String)} and writes the result to the underlying
     * output stream.
     */
    public void print(EObject element)  {
        PrintWriter out = new PrintWriter(new BufferedOutputStream(o));
        doPrint(element,out,"");
    	out.flush();
    	out.close();
    }

}

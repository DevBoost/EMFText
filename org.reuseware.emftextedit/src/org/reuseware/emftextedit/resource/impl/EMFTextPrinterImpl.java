package org.reuseware.emftextedit.resource.impl;

import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.emf.ecore.EObject;
import org.reuseware.emftextedit.resource.EMFTextPrinter;
import org.reuseware.emftextedit.resource.TextResource;

/**
 * Base implementation for all generated printers. 
 * It implements the specifications from {@link EMFTextPrinter}.
 * 
 * @author Jendrik Johannes
 */
public abstract class EMFTextPrinterImpl implements EMFTextPrinter {

    protected OutputStream o;
    protected TextResource resource;
    
    /**
     * Standard constructor.
     * 
     * @param o Output stream to print to.
     * @param resource The associated resource.
     */
    public EMFTextPrinterImpl(OutputStream o, TextResource resource) {
        this.o =o;
        this.resource = resource;
    }
    
    /**
     * This method should will be overridden by generated subclasses.
     * This implementation does nothing.
     */
    protected String doPrint(EObject element, String globaltab) {return "";};
    
    /**
     * Calls {@link #doPrint(EObject, String)} and writes the result to the underlying
     * output stream.
     */
    public void print(EObject element) throws IOException {
        String result = doPrint(element, "");

        o.write(result.getBytes());
    }

}

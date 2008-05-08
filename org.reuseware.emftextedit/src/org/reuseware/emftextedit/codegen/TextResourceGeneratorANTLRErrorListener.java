package org.reuseware.emftextedit.codegen;

import org.antlr.tool.ANTLRErrorListener;
import org.antlr.tool.Message;
import org.antlr.tool.ToolMessage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

/**
 * An error listener for the ANTLR Tool that reports errors by attaching diagnostics to
 * the given resource (containing a concrete syntax model). This ensures that errors that
 * occur when the generated grammar file is processed by the ANTLR Tool, are reported. However,
 * since the file is generated, such errors should not occur.
 * 
 * @author Jendrik Johannes (jj2)
 */
public class TextResourceGeneratorANTLRErrorListener implements ANTLRErrorListener {

    protected Resource csResource;
    
    public TextResourceGeneratorANTLRErrorListener(Resource csResource) {
        this.csResource = csResource;
    }
    
    public void error(Message msg) {
    	csResource.getErrors().add(produceDiagnostic(msg));
    }

    public void error(ToolMessage msg) {
    	csResource.getErrors().add(produceDiagnostic(msg));    
    }

    public void info(String msg) {
    	csResource.getWarnings().add(produceDiagnostic(msg));   
    }

    public void warning(Message msg) {
    	csResource.getWarnings().add(produceDiagnostic(msg)); 
    }
    
    private Diagnostic produceDiagnostic(Message msg) {
        return produceDiagnostic(msg + "");
    }
    
    /**
     * Produces a diagnostic that can be attached to a resource.
     * The line and column information will be removed from the 
     * given message, since they only apply to the generated file
     * and not the concrete syntax model itself.
     * 
     * @param msg Message from the ANTLR Tool
     * @return the diagnostic
     */
    private Diagnostic produceDiagnostic(String msg) {
    	msg = msg.substring(msg.indexOf(":") + 1);
    	msg = msg.substring(msg.indexOf(":") + 1);
        msg = msg.substring(msg.indexOf(":") + 2);        
        msg = msg.toString();
        
        final String text = msg.substring(msg.indexOf(":") + 1);
        
        Diagnostic diagnostic = new Diagnostic() {
			public int getColumn() {
				return 0;
			}

			public int getLine() {
				return 0;
			}

			public String getLocation() {
				return csResource.getURI().toString();
			}

			public String getMessage() {
				return text;
			}
        };
        
        return diagnostic;
     }

}

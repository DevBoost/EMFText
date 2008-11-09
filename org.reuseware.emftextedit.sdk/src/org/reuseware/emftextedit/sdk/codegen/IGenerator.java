package org.reuseware.emftextedit.sdk.codegen;

import java.io.PrintWriter;
import java.util.Collection;
import org.eclipse.emf.ecore.EObject;

/**
 * Basic generator interfaces which should be implemented by all generators 
 * in org.reuseware.emftextedit.codegen.* .
 * 
 * @author skarol
 */
public interface IGenerator {
	
	public static class GenerationProblem {
		
		public static enum Severity {WARNING, ERROR}
		
		private Severity severity ; 
		private String message ;
		private Exception exceptionThrown;
		private EObject cause;
		
		public GenerationProblem(String message, EObject cause, Severity severity, Exception e){
			this.message = message;
			this.cause = cause;
			this.severity = severity;
			this.exceptionThrown = e;
		}
		
		public GenerationProblem(String message, EObject cause, Severity severity){
			this(message, cause, severity, null);
		}
		
		public GenerationProblem(String message, EObject cause){
			this(message, cause, Severity.ERROR);
		}
		
		public Severity getSeverity() {
			return severity;
		}
	
		public String getMessage() {
			return message;
		}
	
		public Exception getExceptionThrown() {
			return exceptionThrown;
		}
		
		public EObject getCause(){
			return cause;
		}
	
	}

	public boolean generate(PrintWriter out);
	
	public Collection<GenerationProblem> getOccuredErrors();
	public Collection<GenerationProblem> getOccuredWarningsAndErrors();
}

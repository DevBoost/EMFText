package org.reuseware.emftextedit.codegen;

import java.io.PrintWriter;
import java.util.Collection;
import org.eclipse.emf.ecore.EObject;

/**
 * Basic generator interfaces which should be implemented by all generators 
 * in org.reuseware.emftextedit.codegen.* .
 * 
 * @author skarol
 *
 */

public interface IGenerator {
	
	public static class GenerationProblem {
		
		public static enum Severity {HINT, ERROR}
		
		private Severity severity ; 
		private String message ;
		private Exception exceptionThrown;
		private EObject cause;
		
		public GenerationProblem(String message, Severity severity,EObject cause, Exception e){
			this.message = message;
			this.severity = severity;
			this.cause = cause;
			this.exceptionThrown = e;
		}
		
		public GenerationProblem(String message, EObject cause){
			this(message,Severity.ERROR,cause,null);
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

	public abstract boolean generate(PrintWriter out);
	
	public abstract Collection<GenerationProblem> getOccuredProblems();

}

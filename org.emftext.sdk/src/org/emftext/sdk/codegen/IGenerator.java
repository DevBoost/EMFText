package org.emftext.sdk.codegen;

import java.io.PrintWriter;
import java.util.Collection;

/**
 * Basic generator interfaces which should be implemented by all generators 
 * in org.emftext.sdk.codegen.* .
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
public interface IGenerator {
	
	public boolean generate(PrintWriter out);
	
	public Collection<GenerationProblem> getCollectedProblems();
	public Collection<GenerationProblem> getCollectedErrors();
}

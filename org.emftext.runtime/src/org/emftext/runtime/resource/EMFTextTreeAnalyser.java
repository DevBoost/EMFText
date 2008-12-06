package org.emftext.runtime.resource;

/**
 * Analyses the output of a <code>EMFTextParser</code> (that is a tree of <code>EObject</code>s)
 * and resolves reference in this output.
 * 
 * @author Jendrik Johannes (jj2)
 */
public interface EMFTextTreeAnalyser extends ReferenceResolver, Configurable {
	
	/**
	 * Do the analysis. Resolves all proxies or attaches diagnostics to the given text resource,
	 * if resolving is not possible.
	 * 
	 * @param resource The text resource with the content to analyse.
	 */
	public void analyse(TextResource resource);
}

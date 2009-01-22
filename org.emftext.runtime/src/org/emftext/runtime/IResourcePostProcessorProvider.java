package org.emftext.runtime;

/**
 * Implementors of this interface can provide a post-processor
 * for text resources.
 */
public interface IResourcePostProcessorProvider {

	/**
	 * Returns the processor that shall be called after text
	 * resource are successfully parsed.
	 */
	public IResourcePostProcessor getResourcePostProcessor();
}

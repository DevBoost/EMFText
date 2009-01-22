package org.emftext.runtime;

import org.emftext.runtime.resource.ITextResource;

/**
 * Implementors of this interface can be used to post-process
 * parsed text resources. This can be useful to validate or 
 * modify the model that was instantiated for the text.
 */
public interface IResourcePostProcessor {

	/**
	 * Processes the resource after it was parsed.
	 * 
	 * @param resource the resource to validate of modify
	 */
	public void process(ITextResource resource);
}

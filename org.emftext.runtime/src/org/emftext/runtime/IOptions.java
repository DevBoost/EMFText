package org.emftext.runtime;

/**
 * A list of constants that contains the keys for some options that
 * are built into EMFText. Generated resource plug-ins do automatically
 * recognize this options and use them if they are configured properly.
 */
public interface IOptions {
	
	/**
	 * The key for the option to provide a stream pre-processor.
	 */
	public String INPUT_STREAM_PREPROCESSOR_PROVIDER = "INPUT_STREAM_PREPROCESSOR_PROVIDER";
	
	/**
	 * The key for the option to provide a resource post-processor.
	 */
	public String RESOURCE_POSTPROCESSOR_PROVIDER = "RESOURCE_POSTPROCESSOR_PROVIDER";
}

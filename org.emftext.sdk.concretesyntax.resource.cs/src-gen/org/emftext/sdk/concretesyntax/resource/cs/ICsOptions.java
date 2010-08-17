/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs;

/**
 * A list of constants that contains the keys for some options that are built into
 * EMFText. Generated resource plug-ins do automatically recognize this options
 * and use them if they are configured properly.
 */
public interface ICsOptions {
	
	/**
	 * The key for the option to provide a stream pre-processor.
	 */
	public String INPUT_STREAM_PREPROCESSOR_PROVIDER = "INPUT_STREAM_PREPROCESSOR_PROVIDER";
	
	/**
	 * The key for the option to provide a resource post-processor.
	 */
	public String RESOURCE_POSTPROCESSOR_PROVIDER = "RESOURCE_POSTPROCESSOR_PROVIDER";
	
	/**
	 * The key for the option to specify an expected content type in text resources
	 * and text parsers. A content type is an EClass that specifies the root object of
	 * a text resource. If this option is set, the parser does not use the start
	 * symbols defined in the .cs specification, use the given EClass as start symbol
	 * instead.
	 */
	public final String RESOURCE_CONTENT_TYPE = "RESOURCE_CONTENT_TYPE";
	
	/**
	 * The key for the options to disable marker creation for resource problems. If
	 * this options is set (the value does not matter) when loading resources,
	 * reported problems will not be added as Eclipse workspace markers. This option
	 * is used by the MarkerResolutionGenerator class, which will end up in an
	 * infinite loop if marker are created when loading resources as this creation
	 * triggers the loading of the same resource and so on.
	 */
	public final String DISABLE_CREATING_MARKERS_FOR_PROBLEMS = "DISABLE_CREATING_MARKERS_FOR_PROBLEMS";
	
}

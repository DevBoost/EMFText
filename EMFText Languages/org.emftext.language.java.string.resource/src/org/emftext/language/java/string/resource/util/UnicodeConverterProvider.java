/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.string.resource.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.emftext.language.java.string.resource.stringjava.IStringjavaInputStreamProcessorProvider;
import org.emftext.language.java.string.resource.stringjava.IStringjavaOptionProvider;
import org.emftext.language.java.string.resource.stringjava.IStringjavaOptions;
import org.emftext.language.java.string.resource.stringjava.mopp.StringjavaInputStreamProcessor;
import org.emftext.language.java.string.resource.stringjava.util.StringjavaUnicodeConverter;

/**
 * Provides the instances of the UnicodeConverter class to be used when
 * reading Java source files. The UnicodeConverter convert Unicode escape
 * sequences to real characters.
 * Adds the UnicodeConverterProvider to the list of input stream pre-processor
 * providers.
 */
public class UnicodeConverterProvider implements
	IStringjavaOptionProvider,
	IStringjavaInputStreamProcessorProvider {

	public StringjavaInputStreamProcessor getInputStreamProcessor(InputStream inputStream) {
		return new StringjavaUnicodeConverter(inputStream);
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IStringjavaOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER, new UnicodeConverterProvider());
		return map;
	}
}

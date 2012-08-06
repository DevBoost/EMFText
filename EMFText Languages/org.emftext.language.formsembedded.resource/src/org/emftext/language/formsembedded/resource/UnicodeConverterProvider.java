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
package org.emftext.language.formsembedded.resource;

import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

import org.emftext.language.formsembedded.resource.formsembedded.IFormsembeddedInputStreamProcessorProvider;
import org.emftext.language.formsembedded.resource.formsembedded.IFormsembeddedOptionProvider;
import org.emftext.language.formsembedded.resource.formsembedded.IFormsembeddedOptions;
import org.emftext.language.formsembedded.resource.formsembedded.mopp.FormsembeddedInputStreamProcessor;
import org.emftext.language.formsembedded.resource.formsembedded.util.FormsembeddedUnicodeConverter;

/**
 * Provides the instances of the UnicodeConverter class to be used when
 * reading Java source files. The UnicodeConverter convert Unicode escape
 * sequences to real characters.
 * Adds the UnicodeConverterProvider to the list of input stream pre-processor
 * providers.
 */
public class UnicodeConverterProvider implements IFormsembeddedOptionProvider, IFormsembeddedInputStreamProcessorProvider {

	public FormsembeddedInputStreamProcessor getInputStreamProcessor(InputStream inputStream) {
		return new FormsembeddedUnicodeConverter(inputStream);
	}

	public Map<?, ?> getOptions() {
		return Collections.singletonMap(
				IFormsembeddedOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER,
				new UnicodeConverterProvider());
	}
}

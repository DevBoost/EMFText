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
package org.emftext.runtime.ocl;

import java.util.HashMap;
import java.util.Map;

import org.emftext.runtime.IOptions;

/**
 * A provider for the OCL validator that is registered to an extension point
 * of EMFText.
 * 
 * @deprecated
 */
public class OCLValidationOptionProvider implements org.emftext.runtime.IOptionProvider {

	public OCLValidationOptionProvider() {
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(IOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new OCLModelValidator());
		return options;
	}

}

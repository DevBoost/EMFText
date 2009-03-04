/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.runtime.ocl;

import java.util.HashMap;
import java.util.Map;

import org.emftext.runtime.IOptions;

/**
 * A provider for the OCL validator that is registered to an extension point
 * of EMFText.
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

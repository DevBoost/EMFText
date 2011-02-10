/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.sdk;

import java.util.Collections;
import java.util.Map;

import org.emftext.sdk.concretesyntax.resource.cs.ICsOptionProvider;
import org.emftext.sdk.concretesyntax.resource.cs.ICsOptions;

/**
 * The SDKOptionProvider adds post-processors to the default 
 * load options for CS files. This post-processors check
 * whether CS files contain potential problems. For example,
 * checks for cases which might cause problems when parsed 
 * resources are printed are detected.
 */
public class SDKOptionProvider implements ICsOptionProvider {

	public Map<?, ?> getOptions() {
		return Collections.singletonMap(ICsOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new CompositePostProcessor());
	}
}

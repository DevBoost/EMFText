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
package org.emftext.sdk.antlr3_2_0;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class EMFTextSDKAntlrPlugin extends Plugin {

	public static final String PLUGIN_ID = "org.emftext.sdk.antlr3_2_0";

	private static EMFTextSDKAntlrPlugin plugin;

	/**
	 * The constructor
	 */
	public EMFTextSDKAntlrPlugin() {
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static EMFTextSDKAntlrPlugin getDefault() {
		return plugin;
	}
}

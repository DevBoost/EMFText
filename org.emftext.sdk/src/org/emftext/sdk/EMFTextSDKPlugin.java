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

import java.lang.reflect.Method;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the EMFText SDK plug-in life cycle.
 */
public class EMFTextSDKPlugin extends Plugin {

	public static final String PLUGIN_ID = "org.emftext.sdk";

	public static final String VERSION = "1.4.0";
	
	private static EMFTextSDKPlugin plugin;
	
	/**
	 * The constructor.
	 */
	public EMFTextSDKPlugin() {
		super();
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		Bundle bundle = getBundle();
		// we need to use reflection here, because getVersion()
		// was not available before Galileo
		Method getVersionMethod = bundle.getClass().getMethod("getVersion");
		if (getVersionMethod != null) {
			Object version = getVersionMethod.invoke(bundle);
			if (!version.toString().startsWith(VERSION)) {
				logError("Bundle version does not match VERSION constant in " + EMFTextSDKPlugin.class.getSimpleName(), null);
			}
		}
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 *
	 * @return the shared instance
	 */
	public static EMFTextSDKPlugin getDefault() {
		return plugin;
	}

	/**
	 * Helper method for logging errors.
	 * 
	 * @param message
	 *            the error message
	 * @param exception
	 *            the exception that describes the error in detail
	 * @return the status object describing the error
	 */
	public static IStatus logError(String message, Throwable exception) {
		return logProblem(Status.ERROR, message, exception);
	}

	/**
	 * Helper method for logging warnings.
	 * 
	 * @param message
	 *            the warning message
	 * @param exception
	 *            the exception that describes the warning in detail
	 * @return the status object describing the warning
	 */
	public static IStatus logWarning(String message, Throwable exception) {
		return logProblem(Status.WARNING, message, exception);
	}
	
	/**
	 * Helper method for logging problems.
	 * 
	 * @param message
	 *            the problem message
	 * @param exception
	 *            the exception that describes the problem in detail
	 * @return the status object describing the problem
	 */
	public static IStatus logProblem(int severity, String message, Throwable exception) {
		IStatus status;
		if (exception != null) {
			status = new Status(severity, EMFTextSDKPlugin.PLUGIN_ID,
					0, message, exception);
		}
		else {
			status = new Status(severity, EMFTextSDKPlugin.PLUGIN_ID,
					message);
		}
		
		final EMFTextSDKPlugin pluginInstance = EMFTextSDKPlugin.getDefault();
		if (pluginInstance == null) {
			System.err.println(message);
			if (exception != null) {
				exception.printStackTrace();
			}
		} else {
			pluginInstance.getLog().log(status);
		}
		return status;
	}
}

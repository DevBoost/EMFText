/*******************************************************************************
 * Copyright (c) 2006-2013
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

package org.emftext.sdk.concretesyntax.resource.cs.util;

import org.eclipse.core.runtime.Platform;

/**
 * This utility class provides methods to obtain information about the current
 * runtime, for example whether Eclipse is available or not.
 */
public class CsRuntimeUtil {
	
	/**
	 * Checks whether the class <code>EMFModelValidationPlugin</code> is available on
	 * the classpath. This can be used to determine if Eclipse is available in the
	 * current runtime environment.
	 */
	public boolean isEMFValidationAvailable() {
		try {
			Class.forName("org.eclipse.emf.validation.internal.EMFModelValidationPlugin");
			return true;
		} catch (ClassNotFoundException cnfe) {
		}
		return false;
	}
	
	/**
	 * Checks whether the class <code>Platform</code> is available on the classpath.
	 * This can be used to determine if EMF Validation is available in the current
	 * runtime environment.
	 */
	public boolean isEclipsePlatformAvailable() {
		try {
			Class.forName("Platform");
			return true;
		} catch (ClassNotFoundException cnfe) {
		}
		return false;
	}
	
	/**
	 * Logs the given error. If Eclipse is running, the error is added to the error
	 * log otherwise the message is printed to System.err.
	 */
	public void logError(String message, Throwable exception) {
		if (isEclipsePlatformAvailable()) {
			org.emftext.sdk.concretesyntax.resource.cs.mopp.CsPlugin.logError(message, exception);
			return;
		}
		System.err.println(message);
		if (exception != null) {
			exception.printStackTrace();
		}
	}
	
	/**
	 * Logs the given warning. If Eclipse is running, the warning is added to the
	 * error log otherwise the message is printed to System.err.
	 */
	public void logWarning(String message, Throwable exception) {
		if (isEclipsePlatformAvailable()) {
			org.emftext.sdk.concretesyntax.resource.cs.mopp.CsPlugin.logWarning(message, exception);
			return;
		}
		System.err.println(message);
		if (exception != null) {
			exception.printStackTrace();
		}
	}
	
	/**
	 * Checks whether the Eclipse platform is running.
	 */
	public boolean isEclipsePlatformRunning() {
		if (!isEclipsePlatformAvailable()) {
			return false;
		}
		return Platform.isRunning();
	}
	
}

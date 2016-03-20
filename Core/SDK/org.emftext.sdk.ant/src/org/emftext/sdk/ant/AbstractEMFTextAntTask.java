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
package org.emftext.sdk.ant;

import org.apache.tools.ant.AntClassLoader;
import org.apache.tools.ant.Task;

public abstract class AbstractEMFTextAntTask extends Task {

	private final static Object TASK_LOADER_LOCK = new Object();
	
	private static int threadCount = 0;
	
	protected AntClassLoader setClassLoader() {
		// Get the task class loader we used to load this tag.
		AntClassLoader taskloader = null;
		ClassLoader loader = this.getClass().getClassLoader();
		if (loader instanceof AntClassLoader) {
			taskloader = (AntClassLoader) loader;
		}
		// Shove it into the Thread, replacing the thread's ClassLoader:
		synchronized (TASK_LOADER_LOCK) {
			if (taskloader != null && threadCount == 0) {
				taskloader.setThreadContextLoader();
			}
			threadCount++;
		}
		return taskloader;
	}

	protected void resetClassLoader(AntClassLoader taskloader) {
		synchronized (TASK_LOADER_LOCK) {
			threadCount--;
			// Reset the Thread's original ClassLoader.
			if (taskloader != null && threadCount == 0) {
				taskloader.resetThreadContextLoader();
			}
		}
	}
}

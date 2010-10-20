package org.emftext.sdk.ant;

import org.apache.tools.ant.AntClassLoader;
import org.apache.tools.ant.Task;

public abstract class AbstractEMFTextAntTask extends Task {

	private final static Object taskloaderLock = new Object();
	private static int threadCount = 0;
	
	protected AntClassLoader setClassLoader() {
		// Get the task class loader we used to load this tag.
		AntClassLoader taskloader = null;
		ClassLoader loader = this.getClass().getClassLoader();
		if (loader instanceof AntClassLoader) {
			taskloader = (AntClassLoader) loader;
		}
		// Shove it into the Thread, replacing the thread's ClassLoader:
		synchronized (taskloaderLock) {
			if (taskloader != null && threadCount == 0) {
				taskloader.setThreadContextLoader();
			}
			threadCount++;
		}
		return taskloader;
	}

	protected void resetClassLoader(AntClassLoader taskloader) {
		synchronized (taskloaderLock) {
			threadCount--;
			// Reset the Thread's original ClassLoader.
			if (taskloader != null && threadCount == 0) {
				taskloader.resetThreadContextLoader();
			}
		}
	}
}

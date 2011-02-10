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
package org.emftext.sdk.ant;

import org.apache.tools.ant.Task;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * This class delegates progress events that are passed to an
 * IProgressMonitor to an ANT task. The progress is sent to the
 * console using the log() method in org.apache.tools.ant.Task.
 */
public class AntDelegateProgressMonitor implements IProgressMonitor {

	private Task antTask;

	public AntDelegateProgressMonitor(Task antTask) {
		this.antTask = antTask;
	}

	public void beginTask(String name, int totalWork) {
		if (name == null || name.trim().length() == 0) {
			return;
		}
		antTask.log(name);
	}

	public void done() {
	}

	public void internalWorked(double work) {
	}

	public boolean isCanceled() {
		return false;
	}

	public void setCanceled(boolean value) {
	}

	public void setTaskName(String name) {
		antTask.log(name);
	}

	public void subTask(String name) {
	}

	public void worked(int work) {
	}
}

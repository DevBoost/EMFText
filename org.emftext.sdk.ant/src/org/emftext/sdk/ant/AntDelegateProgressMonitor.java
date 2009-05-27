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

package org.emftext.sdk.ant;

import org.apache.tools.ant.Task;
import org.eclipse.core.runtime.IProgressMonitor;

public class AntDelegateProgressMonitor implements IProgressMonitor {

	private Task antTask;

	public AntDelegateProgressMonitor(Task antTask) {
		this.antTask = antTask;
	}

	public void beginTask(String name, int totalWork) {
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

package org.emftext.sdk.concretesyntax.resource.cs.ui;

// A background parsing strategy that starts parsing after a amount of
// time after the last key stroke. If keys are pressed within the delay
// interval, the delay is reset. If keys are pressed during background
// parsing the parse thread is stopped and a new parse task is scheduled.
public class CsBackgroundParsingStrategy {
	
	private static long DELAY = 500;
	
	// this timer is used to schedule a parsing task and execute
	// it after a given delay
	private Object lock = new Object();
	// the background parsing task (may be null)
	private org.eclipse.core.runtime.jobs.Job job;
	
	// Schedules a task for background parsing that will be started after
	// a delay.
	public void parse(org.eclipse.jface.text.DocumentEvent event, final org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource resource, final org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditor editor) {
		final String contents = event.getDocument().get();
		
		// this synchronization is needed to avoid the creation
		// of multiple tasks. without the synchronization this
		// could easily happen, when this method is accessed by
		// multiple threads. the creation of multiple task would
		// imply the multiple background parsing threads for one
		// editor are created, which is not desired.
		synchronized (lock) {
			// cancel old task
			if (job != null) {
				// stop current parser (if there is one)
				job.cancel();
				try {
					job.join();
				} catch (InterruptedException e) {}
			}
			
			// schedule new task
			job = new org.eclipse.core.runtime.jobs.Job("parsing document") {
				
				protected org.eclipse.core.runtime.IStatus run(org.eclipse.core.runtime.IProgressMonitor monitor) {
					try {
						resource.reload(new java.io.ByteArrayInputStream(contents.getBytes()), null);
					} catch (java.io.IOException e) {
						e.printStackTrace();
					}
					editor.notifyBackgroundParsingFinished();
					return org.eclipse.core.runtime.Status.OK_STATUS;
				}
				
				protected void canceling() {
					resource.cancelReload();
				}
			};
			job.schedule(DELAY);
		}
	}
}

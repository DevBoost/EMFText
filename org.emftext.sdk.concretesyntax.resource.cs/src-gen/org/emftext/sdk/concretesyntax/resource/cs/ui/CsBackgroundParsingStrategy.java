package org.emftext.sdk.concretesyntax.resource.cs.ui;

// A background parsing strategy that starts parsing after a amount of
// time after the last key stroke. If keys are pressed within the delay
// interval, the delay is reset. If keys are pressed during background
// parsing the parse thread is stopped and a new parse task is scheduled.
public class CsBackgroundParsingStrategy {
	
	private static long DELAY = 500;
	
	// this timer is used to schedule a parsing task and execute
	// it after a given delay
	private java.util.Timer timer = new java.util.Timer();
	// the background parsing task (may be null)
	private java.util.TimerTask task;
	
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
		synchronized (timer) {
			// cancel old task
			if (task != null) {
				// stop current parser (if there is one)
				task.cancel();
			}
			timer.purge();
			
			// schedule new task
			task = new java.util.TimerTask() {
				
				public void run() {
					try {
						resource.reload(new java.io.ByteArrayInputStream(contents.getBytes()), null);
					} catch (java.io.IOException e) {
						e.printStackTrace();
					}
					editor.notifyBackgroundParsingFinished();
				}
				
				public boolean cancel() {
					super.cancel();
					resource.cancelReload();
					return true;
				}
			};
			timer.schedule(task, DELAY);
		}
	}
}

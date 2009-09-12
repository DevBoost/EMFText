package org.emftext.runtime.ui.editor.bg_parsing;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.jface.text.DocumentEvent;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.ui.editor.EMFTextEditor;

/**
 * A background parsing strategy that starts parsing after a amount of
 * time after the last key stroke. If keys are pressed within the delay
 * interval, the delay is reset. If keys are pressed during background
 * parsing the parse thread is stopped and a new parse task is scheduled.
 */
public class DelayedBackgroundParsingStrategy implements IBackgroundParsingStrategy {
	
	private static long DELAY = 500;
	
	// this timer is used to schedule a parsing task and execute
	// it after a given delay
	private Timer timer = new Timer();
	// the background parsing task (may be null)
	private TimerTask task;

	/**
	 * Returns true. Parsing is always required.
	 */
	public boolean isParsingRequired(DocumentEvent event) {
		return true;
	}

	/**
	 * Schedules a task for background parsing that will be started after
	 * a delay.
	 */
	public void parse(DocumentEvent event, final ITextResource resource, final EMFTextEditor editor) {
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
			task = new TimerTask() {
				
				@Override
				public void run() {
					try {
						resource.reload(new ByteArrayInputStream(contents.getBytes()), null);
					} catch (IOException e) {
						e.printStackTrace();
					}
					editor.notifyBackgroundParsingFinished();
				}

				@Override
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

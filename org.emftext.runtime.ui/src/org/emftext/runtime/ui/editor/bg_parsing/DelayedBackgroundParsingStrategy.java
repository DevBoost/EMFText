package org.emftext.runtime.ui.editor.bg_parsing;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.jface.text.DocumentEvent;
import org.emftext.runtime.resource.ITextResource;

public class DelayedBackgroundParsingStrategy implements IBackgroundParsingStrategy {
	
	private static long DELAY = 1000;
	
	private Object parseLock = new Object();
	private Timer timer = new Timer();
	private TimerTask task;

	public boolean isParsingRequired(DocumentEvent event) {
		synchronized (parseLock) {
			// TODO stop current parser (if there is one)
			
			// parsing is always required
			return true;
		}
	}

	// TODO interface instead of class EMFTextEditor
	public void parse(DocumentEvent event, final ITextResource resource) {
		final String contents = event.getDocument().get();

		// cancel old task
		if (task != null) {
			task.cancel();
		}
		timer.purge();

		// schedule new task
		task = new TimerTask() {

			@Override
			public void run() {
				synchronized (parseLock) {
					try {
						resource.unload();
						resource.load(new ByteArrayInputStream(contents.getBytes()), null);
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println("finished background parsing.");
				}
			}
		};
		timer.schedule(task, DELAY);
	}
}

package org.emftext.runtime.ui;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * A singleton class for the EMFText Runtime UI plug-in.
 */
public class EMFTextRuntimeUIPlugin extends AbstractUIPlugin {
	
	private static EMFTextRuntimeUIPlugin plugin;
	
	public EMFTextRuntimeUIPlugin() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static EMFTextRuntimeUIPlugin getDefault() {
		return plugin;
	}

	public void showErrorDialog(final String title, final String message) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				Shell parent = new Shell();
				MessageDialog dialog = new MessageDialog(parent, title, null, message, MessageDialog.ERROR,
						new String[] { IDialogConstants.OK_LABEL }, 0) {
				};
				dialog.open();
			}
		});
	}
}

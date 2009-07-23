package org.emftext.runtime.ui.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

// TODO add some meaningful content to this global preference page
// maybe links to the preference pages below or a link to the web 
// site
public class EMFTextPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage{

	public void init(IWorkbench workbench) {
	}
	
    @Override
    protected Control createContents(Composite parent) {
    	return null;
    }
}

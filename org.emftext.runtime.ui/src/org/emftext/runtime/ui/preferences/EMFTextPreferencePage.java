package org.emftext.runtime.ui.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

//TODO mseifert: align this class with the EMFText coding style
public class EMFTextPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage{
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
		
	}
    @Override
    protected Control createContents(Composite parent) {
    	
    	return null;
    }
}

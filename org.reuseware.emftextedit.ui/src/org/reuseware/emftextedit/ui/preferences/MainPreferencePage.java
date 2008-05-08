package org.reuseware.emftextedit.ui.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class MainPreferencePage extends PreferencePage implements
        IWorkbenchPreferencePage {

    @Override
    protected Control createContents(Composite parent) {
        return null;
    }

    public void init(IWorkbench workbench) {
        noDefaultAndApplyButton();
    }

}

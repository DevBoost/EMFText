package org.emftext.sdk.ui.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.emftext.sdk.ui.EMFTextSDKUIPlugin;

public class MainPreferencePage extends FieldEditorPreferencePage implements
        IWorkbenchPreferencePage {
	
	
	public MainPreferencePage(){
		super(FieldEditorPreferencePage.FLAT);
		setPreferenceStore(EMFTextSDKUIPlugin.getDefault().getPreferenceStore());
	}
  	
    public void init(IWorkbench workbench) {
        //noDefaultAndApplyButton();
    }

	@Override
	protected void createFieldEditors() {
		Composite parent = getFieldEditorParent();
		GridLayout gl = new GridLayout();
		gl.numColumns = 1;
		parent.setLayout(gl);
		Group platformGeneratorGroup = new Group(parent,SWT.NONE);
		
		platformGeneratorGroup.setText("Eclipse specific settings");
		platformGeneratorGroup.setLayoutData(new GridData((GridData.GRAB_HORIZONTAL|GridData.FILL_HORIZONTAL)));

		Group generatorGroup = new Group(parent,SWT.NONE);
		
		generatorGroup.setText("General generator settings");
		generatorGroup.setLayoutData(new GridData((GridData.GRAB_HORIZONTAL|GridData.FILL_HORIZONTAL)));

		gl = new GridLayout();
		gl.numColumns = 1;
		gl.marginHeight = 5;
		gl.marginWidth = 5;
		gl.marginLeft = 5;
		
		generatorGroup.setLayout(gl);
		platformGeneratorGroup.setLayout(gl);
	}
	
	protected void performDefaults() {
		 super.performDefaults();
	}

}

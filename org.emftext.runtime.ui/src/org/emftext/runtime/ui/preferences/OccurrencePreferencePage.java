package org.emftext.runtime.ui.preferences;

import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.emftext.runtime.ui.EMFTextRuntimeUIPlugin;
import org.emftext.runtime.ui.editor.EMFTextEditor;

public class OccurrencePreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {
	
	private Button enableCheckbox;
	private Label defColorLabel;
	private ColorSelector defColorSelector;
	private Button defColorButton;
	private Label useColorLabel;
	private ColorSelector useColorSelector;
	private Button useColorButton;
	
	@Override
	protected Control createContents(Composite parent) {
        Composite settingComposite = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        GridData gd;
        layout.numColumns= 2;
        layout.marginHeight= 0;
        layout.marginWidth= 0;
        gd = new GridData(GridData.BEGINNING);
        settingComposite.setLayout(layout);
        settingComposite.setLayoutData(gd);
    
        enableCheckbox = new Button(settingComposite, SWT.CHECK);
        enableCheckbox.setText("Enable");
        gd = new GridData(GridData.BEGINNING);
        gd.horizontalAlignment= GridData.BEGINNING;
        gd.horizontalSpan= 2;
        enableCheckbox.setLayoutData(gd);
        
        defColorLabel = new Label(settingComposite, SWT.LEFT);
        defColorLabel.setText("Definition color:"); 
        gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
        gd.horizontalIndent= 20;
        defColorLabel.setLayoutData(gd);
        defColorSelector = new ColorSelector(settingComposite);
        defColorButton = defColorSelector.getButton();
        gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
        defColorButton.setLayoutData(gd);
		
        useColorLabel = new Label(settingComposite, SWT.LEFT);
        useColorLabel.setText("Proxy color:"); 
        gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
        gd.horizontalIndent= 20;
        useColorLabel.setLayoutData(gd);
        useColorSelector = new ColorSelector(settingComposite);
        useColorButton = useColorSelector.getButton();
        gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
        useColorButton.setLayoutData(gd);
		
        addListenersToStyleButtons();
        initializeValues();
        
        settingComposite.layout(false);
        return settingComposite;
	}

	public void init(IWorkbench workbench) {
		setPreferenceStore(EMFTextRuntimeUIPlugin.getDefault().getPreferenceStore());
		setDescription("Define the highlight coloring of occurrences.");
	}
	
	private void addListenersToStyleButtons() {
    	enableCheckbox.addSelectionListener(new SelectionListener(){
    		public void widgetDefaultSelected(SelectionEvent e){
    		}
    		
    		public void widgetSelected(SelectionEvent e) {
    			defColorButton.setEnabled(enableCheckbox.getSelection());
    			useColorButton.setEnabled(enableCheckbox.getSelection());
            }
    	});
	}

	private void initializeValues() {
		boolean enable = getPreferenceStore().getBoolean(PreferenceConstants.EDITOR_OCCURRENCE_CHECKBOX);
		enableCheckbox.setSelection(enable);
		
		defColorButton.setEnabled(enable);
    	RGB rgb = PreferenceConverter.getColor(getPreferenceStore(), PreferenceConstants.EDITOR_DEFINITION_COLOR);
    	defColorSelector.setColorValue(rgb);
    	
    	useColorButton.setEnabled(enable);
    	rgb = PreferenceConverter.getColor(getPreferenceStore(), PreferenceConstants.EDITOR_PROXY_COLOR);
    	useColorSelector.setColorValue(rgb);
	}
	
    /**
     * Set the default values for this preference page.
     */
    protected void performDefaults() {
    	boolean enable = getPreferenceStore().getDefaultBoolean(PreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX);
    	enableCheckbox.setSelection(enable);
    	defColorButton.setEnabled(enable);
    	useColorButton.setEnabled(enable);
    	defColorSelector.setColorValue(PreferenceConverter.getDefaultColor(getPreferenceStore(), PreferenceConstants.EDITOR_DEFINITION_COLOR));
    	useColorSelector.setColorValue(PreferenceConverter.getDefaultColor(getPreferenceStore(), PreferenceConstants.EDITOR_PROXY_COLOR));
    }
    
    public boolean performOk() {
    	if(!super.performOk()) {
    		return false;
    	}
    	updateActiveEditor();
		return true;
    }
    
    protected void performApply() {
    	updateActiveEditor();
    }
    
    private void updateActiveEditor() {
    	getPreferenceStore().setValue(PreferenceConstants.EDITOR_OCCURRENCE_CHECKBOX, enableCheckbox.getSelection());
    	PreferenceConverter.setValue(getPreferenceStore(), PreferenceConstants.EDITOR_DEFINITION_COLOR, defColorSelector.getColorValue());
    	PreferenceConverter.setValue(getPreferenceStore(), PreferenceConstants.EDITOR_PROXY_COLOR, useColorSelector.getColorValue());
        
        IWorkbench workbench = org.eclipse.ui.PlatformUI.getWorkbench();
        IEditorPart editor = workbench.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (editor != null && editor instanceof EMFTextEditor) {
			((EMFTextEditor) editor).invalidateTextRepresentation();
		}
    }
}

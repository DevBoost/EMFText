/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
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

/**
 * The preference page to set the occurrence highlighting with folling features:
 * <ul>
 * <li>enables the occurrence highlighting</li>
 * <li>chooses the highlight color for definition</li>
 * <li>chooses the highlight color for the proxy elements</li>
 * </ul>
 * @author Tan-Ky Hoang-Kim
 *
 */
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
    /**
    * Sets the chosen options to the preference store and refreshs it in the <code>EMFTextEditor</code>.
    */
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

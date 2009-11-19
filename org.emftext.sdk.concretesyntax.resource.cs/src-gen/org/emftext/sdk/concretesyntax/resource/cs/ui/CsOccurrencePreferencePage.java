/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.ui;

// The preference page to set the occurrence highlighting with folling features:
// <ul>
// <li>enables the occurrence highlighting</li>
// <li>chooses the highlight color for definition</li>
// <li>chooses the highlight color for the proxy elements</li>
// </ul>
//
public class CsOccurrencePreferencePage extends org.eclipse.jface.preference.PreferencePage implements org.eclipse.ui.IWorkbenchPreferencePage {
	
	private org.eclipse.swt.widgets.Button enableCheckbox;
	private org.eclipse.swt.widgets.Label defColorLabel;
	private org.eclipse.jface.preference.ColorSelector defColorSelector;
	private org.eclipse.swt.widgets.Button defColorButton;
	private org.eclipse.swt.widgets.Label useColorLabel;
	private org.eclipse.jface.preference.ColorSelector useColorSelector;
	private org.eclipse.swt.widgets.Button useColorButton;
	
	@Override	protected org.eclipse.swt.widgets.Control createContents(org.eclipse.swt.widgets.Composite parent) {
		org.eclipse.swt.widgets.Composite settingComposite = new org.eclipse.swt.widgets.Composite(parent, org.eclipse.swt.SWT.NONE);
		org.eclipse.swt.layout.GridLayout layout = new org.eclipse.swt.layout.GridLayout();
		org.eclipse.swt.layout.GridData gd;
		layout.numColumns= 2;
		layout.marginHeight= 0;
		layout.marginWidth= 0;
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.BEGINNING);
		settingComposite.setLayout(layout);
		settingComposite.setLayoutData(gd);
		
		enableCheckbox = new org.eclipse.swt.widgets.Button(settingComposite, org.eclipse.swt.SWT.CHECK);
		enableCheckbox.setText("Enable");
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.BEGINNING);
		gd.horizontalAlignment= org.eclipse.swt.layout.GridData.BEGINNING;
		gd.horizontalSpan= 2;
		enableCheckbox.setLayoutData(gd);
		
		defColorLabel = new org.eclipse.swt.widgets.Label(settingComposite, org.eclipse.swt.SWT.LEFT);
		defColorLabel.setText("Definition color:");
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalIndent= 20;
		defColorLabel.setLayoutData(gd);
		defColorSelector = new org.eclipse.jface.preference.ColorSelector(settingComposite);
		defColorButton = defColorSelector.getButton();
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.HORIZONTAL_ALIGN_BEGINNING);
		defColorButton.setLayoutData(gd);
		
		useColorLabel = new org.eclipse.swt.widgets.Label(settingComposite, org.eclipse.swt.SWT.LEFT);
		useColorLabel.setText("Proxy color:");
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalIndent= 20;
		useColorLabel.setLayoutData(gd);
		useColorSelector = new org.eclipse.jface.preference.ColorSelector(settingComposite);
		useColorButton = useColorSelector.getButton();
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.HORIZONTAL_ALIGN_BEGINNING);
		useColorButton.setLayoutData(gd);
		
		addListenersToStyleButtons();
		initializeValues();
		
		settingComposite.layout(false);
		return settingComposite;
	}
	
	public void init(org.eclipse.ui.IWorkbench workbench) {
		setPreferenceStore(org.emftext.sdk.concretesyntax.resource.cs.mopp.CsPlugin.getDefault().getPreferenceStore());
		setDescription("Define the highlight coloring of occurrences.");
	}
	
	private void addListenersToStyleButtons() {
		enableCheckbox.addSelectionListener(new org.eclipse.swt.events.SelectionListener(){
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e){
			}
			
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				defColorButton.setEnabled(enableCheckbox.getSelection());
				useColorButton.setEnabled(enableCheckbox.getSelection());
			}
		});
	}
	
	private void initializeValues() {
		boolean enable = getPreferenceStore().getBoolean(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_OCCURRENCE_CHECKBOX);
		enableCheckbox.setSelection(enable);
		
		defColorButton.setEnabled(enable);
		org.eclipse.swt.graphics.RGB rgb = org.eclipse.jface.preference.PreferenceConverter.getColor(getPreferenceStore(), org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_DEFINITION_COLOR);
		defColorSelector.setColorValue(rgb);
		
		useColorButton.setEnabled(enable);
		rgb = org.eclipse.jface.preference.PreferenceConverter.getColor(getPreferenceStore(), org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_PROXY_COLOR);
		useColorSelector.setColorValue(rgb);
	}
	
	// Set the default values for this preference page.
	protected void performDefaults() {
		boolean enable = getPreferenceStore().getDefaultBoolean(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX);
		enableCheckbox.setSelection(enable);
		defColorButton.setEnabled(enable);
		useColorButton.setEnabled(enable);
		defColorSelector.setColorValue(org.eclipse.jface.preference.PreferenceConverter.getDefaultColor(getPreferenceStore(), org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_DEFINITION_COLOR));
		useColorSelector.setColorValue(org.eclipse.jface.preference.PreferenceConverter.getDefaultColor(getPreferenceStore(), org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_PROXY_COLOR));
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
	// Sets the chosen options to the preference store and refreshs it in the editor.
	private void updateActiveEditor() {
		getPreferenceStore().setValue(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_OCCURRENCE_CHECKBOX, enableCheckbox.getSelection());
		org.eclipse.jface.preference.PreferenceConverter.setValue(getPreferenceStore(), org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_DEFINITION_COLOR, defColorSelector.getColorValue());
		org.eclipse.jface.preference.PreferenceConverter.setValue(getPreferenceStore(), org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_PROXY_COLOR, useColorSelector.getColorValue());
		
		org.eclipse.ui.IWorkbench workbench = org.eclipse.ui.PlatformUI.getWorkbench();
		org.eclipse.ui.IEditorPart editor = workbench.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (editor != null && editor instanceof org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditor) {
			((org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditor) editor).invalidateTextRepresentation();
		}
	}
}

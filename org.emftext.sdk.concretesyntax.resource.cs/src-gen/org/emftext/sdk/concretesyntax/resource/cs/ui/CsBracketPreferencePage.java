package org.emftext.sdk.concretesyntax.resource.cs.ui;

// The preference page for the bracket setting with following features:
// <ul>
// <li>enables bracket matching</li>
// <li>chooses matching highlight color</li>
// <li>customizes bracket set</li>
// </ul>
//
public class CsBracketPreferencePage extends org.eclipse.jface.preference.PreferencePage implements org.eclipse.ui.IWorkbenchPreferencePage {
	
	private static final String[] ALL_LEFT_BRACKETS = new String[] { "{", "(", "[", "<", "\"", "'", };
	private static final String[] ALL_RIGHT_BRACKETS = new String[] { "}", ")", "]", ">", "\"", "'", };
	
	private String BRACKETS_COLOR = org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR;
	
	private java.util.Set<String> languageIDs = new java.util.LinkedHashSet<String>();
	
	private org.eclipse.jface.preference.ColorSelector matchingBracketsColorEditor;
	private org.eclipse.swt.widgets.Label colorEditorLabel;
	private org.eclipse.swt.widgets.Button enableCheckbox;
	private org.eclipse.swt.widgets.Button enableClosingInside;
	private org.eclipse.swt.widgets.Button matchingBracketsColorButton;
	private org.eclipse.swt.widgets.Label languagesLabel;
	private org.eclipse.swt.widgets.Combo languagesCombo;
	private org.eclipse.swt.widgets.Label bracketTokensLabel;
	private org.eclipse.swt.widgets.Combo leftBracketTokensCombo;
	private org.eclipse.swt.widgets.Combo rightBracketTokensCombo;
	private org.eclipse.swt.widgets.List bracketsList;
	private org.eclipse.swt.widgets.Button addBracketButton;
	private org.eclipse.swt.widgets.Button removeBracketButton;
	private java.util.Map<String, String> bracketSetTemp = new java.util.HashMap<String, String>();
	private String language;
	
	private org.emftext.sdk.concretesyntax.resource.cs.ui.CsBracketSet bracketsTmp;
	
	//*
	// Creates a preference page for bracket setting.
	///
	public CsBracketPreferencePage() {
		super();
		
		org.emftext.sdk.concretesyntax.resource.cs.ICsMetaInformation metaInformation = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation();
		String languageId = metaInformation.getSyntaxName();
		languageIDs.add(languageId);
	}
	
	//
	// @see
	// org.eclipse.ui.org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.org.eclipse.ui.IWorkbench)
	///
	public void init(org.eclipse.ui.IWorkbench workbench) {
		setPreferenceStore(org.emftext.sdk.concretesyntax.resource.cs.mopp.CsPlugin.getDefault().getPreferenceStore());
		setDescription("Define the coloring of matching brackets.");
		
		bracketsTmp = new org.emftext.sdk.concretesyntax.resource.cs.ui.CsBracketSet(null, null);
		for (String languageID : languageIDs) {
			bracketSetTemp.put(languageID, getPreferenceStore().getString(languageID + org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_BRACKETS_SUFFIX));
		}
	}
	
	@Override	protected org.eclipse.swt.widgets.Control createContents(org.eclipse.swt.widgets.Composite parent) {
		
		// outer Composite
		org.eclipse.swt.widgets.Composite settingComposite = new org.eclipse.swt.widgets.Composite(parent, org.eclipse.swt.SWT.NONE);
		org.eclipse.swt.layout.GridLayout layout = new org.eclipse.swt.layout.GridLayout();
		org.eclipse.swt.layout.GridData gd;
		layout.numColumns = 2;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.BEGINNING);
		settingComposite.setLayout(layout);
		settingComposite.setLayoutData(gd);
		
		enableCheckbox = new org.eclipse.swt.widgets.Button(settingComposite, org.eclipse.swt.SWT.CHECK);
		enableCheckbox.setText("Enable");
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.BEGINNING);
		gd.horizontalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		gd.horizontalSpan = 2;
		enableCheckbox.setLayoutData(gd);
		
		colorEditorLabel = new org.eclipse.swt.widgets.Label(settingComposite, org.eclipse.swt.SWT.LEFT);
		colorEditorLabel.setText("Color:");
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalIndent = 20;
		colorEditorLabel.setLayoutData(gd);
		
		matchingBracketsColorEditor = new org.eclipse.jface.preference.ColorSelector(settingComposite);
		matchingBracketsColorButton = matchingBracketsColorEditor.getButton();
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.HORIZONTAL_ALIGN_BEGINNING);
		matchingBracketsColorButton.setLayoutData(gd);
		
		org.eclipse.swt.widgets.Composite languageComposite = new org.eclipse.swt.widgets.Composite(settingComposite, org.eclipse.swt.SWT.NONE);
		layout = new org.eclipse.swt.layout.GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.numColumns = 2;
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.BEGINNING);
		gd.horizontalSpan = 2;
		gd.verticalIndent = 30;
		languageComposite.setLayout(layout);
		languageComposite.setLayoutData(gd);
		
		languagesLabel = new org.eclipse.swt.widgets.Label(languageComposite, org.eclipse.swt.SWT.LEFT);
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.BEGINNING);
		gd.horizontalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		languagesLabel.setLayoutData(gd);
		languagesLabel.setText("The available languages");
		
		languagesCombo = new org.eclipse.swt.widgets.Combo(languageComposite, org.eclipse.swt.SWT.DROP_DOWN		| org.eclipse.swt.SWT.READ_ONLY | org.eclipse.swt.SWT.LEFT);
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.BEGINNING);
		languagesCombo.setLayoutData(gd);
		
		org.eclipse.swt.widgets.Composite tokenSelectionComposite = new org.eclipse.swt.widgets.Composite(settingComposite,
		org.eclipse.swt.SWT.NONE);
		layout = new org.eclipse.swt.layout.GridLayout();
		layout.numColumns = 3;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		gd.verticalIndent = 20;
		tokenSelectionComposite.setLayout(layout);
		tokenSelectionComposite.setLayoutData(gd);
		
		bracketTokensLabel = new org.eclipse.swt.widgets.Label(tokenSelectionComposite, org.eclipse.swt.SWT.LEFT);
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.BEGINNING);
		gd.horizontalSpan = 3;
		bracketTokensLabel.setText("Select the desired bracket pair");
		bracketTokensLabel.setLayoutData(gd);
		
		leftBracketTokensCombo = new org.eclipse.swt.widgets.Combo(tokenSelectionComposite,
		org.eclipse.swt.SWT.DROP_DOWN | org.eclipse.swt.SWT.READ_ONLY);
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.BEGINNING);
		leftBracketTokensCombo.setLayoutData(gd);
		
		rightBracketTokensCombo = new org.eclipse.swt.widgets.Combo(tokenSelectionComposite,
		org.eclipse.swt.SWT.DROP_DOWN | org.eclipse.swt.SWT.READ_ONLY);
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.FILL);
		gd.horizontalSpan = 2;
		rightBracketTokensCombo.setLayoutData(gd);
		
		bracketsList = new org.eclipse.swt.widgets.List(tokenSelectionComposite, org.eclipse.swt.SWT.MULTI);
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.CENTER, org.eclipse.swt.layout.GridData.FILL, false, true);
		gd.horizontalSpan = 2;
		gd.verticalSpan = 4;
		gd.widthHint = 100;
		gd.heightHint = 300;
		bracketsList.setLayoutData(gd);
		
		enableClosingInside = new org.eclipse.swt.widgets.Button(tokenSelectionComposite, org.eclipse.swt.SWT.CHECK);
		enableClosingInside.setText("Enable closing inside");
		enableClosingInside		.setToolTipText("If this option is enabled, other bracket pair can close inside this pair automatically.");
		enableClosingInside.setLayoutData(new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.BEGINNING,
		org.eclipse.swt.layout.GridData.BEGINNING, false, false));
		
		addBracketButton = new org.eclipse.swt.widgets.Button(tokenSelectionComposite, org.eclipse.swt.SWT.PUSH);
		addBracketButton.setText("Add");
		addBracketButton.setLayoutData(new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.BEGINNING,
		org.eclipse.swt.layout.GridData.BEGINNING, false, false));
		
		removeBracketButton = new org.eclipse.swt.widgets.Button(tokenSelectionComposite, org.eclipse.swt.SWT.PUSH);
		removeBracketButton.setText("Remove");
		removeBracketButton.setLayoutData(new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.BEGINNING,
		org.eclipse.swt.layout.GridData.BEGINNING, false, false));
		
		addListenersToStyleButtons();
		
		settingComposite.layout(false);
		handleMatchingBracketsSelection();
		return settingComposite;
	}
	
	//*
	// Initialize and handle the values of this preference page
	///
	private void handleMatchingBracketsSelection() {
		// not for the case of none existing language
		enableCheckbox.setSelection(getPreferenceStore().getBoolean(		org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX));
		enableClosingInside.setSelection(false);
		matchingBracketsColorButton.setEnabled(getPreferenceStore().getBoolean(		org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX));
		org.eclipse.swt.graphics.RGB rgb = org.eclipse.jface.preference.PreferenceConverter.getColor(getPreferenceStore(),
		BRACKETS_COLOR);
		matchingBracketsColorEditor.setColorValue(rgb);
		
		String extension = null;
		org.eclipse.ui.IWorkbench workbench = org.eclipse.ui.PlatformUI.getWorkbench();
		final org.eclipse.ui.IEditorPart activeEditor = workbench.getActiveWorkbenchWindow()		.getActivePage().getActiveEditor();
		if (activeEditor != null) {
			if (activeEditor instanceof org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditor) {
				org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditor emfTextEditor = (org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditor) activeEditor;
				org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource resource = (org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource) emfTextEditor.getResource();
				extension = resource.getMetaInformation().getSyntaxName();
			}
		}
		
		languagesCombo.setItems(languageIDs.toArray(new String[0]));
		languagesCombo.select(0);
		if (extension != null) {
			int idx = languagesCombo.indexOf(extension);
			if (idx > -1) {
				languagesCombo.select(idx);
			} else {
				idx = 0;
			}
		}
		language = languagesCombo.getItem(languagesCombo.getSelectionIndex());
		leftBracketTokensCombo.setItems(ALL_LEFT_BRACKETS);
		leftBracketTokensCombo.select(0);
		rightBracketTokensCombo.setItems(ALL_RIGHT_BRACKETS);
		rightBracketTokensCombo.select(0);
		bracketsTmp.setBrackets(getPreferenceStore().getString(		language + org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_BRACKETS_SUFFIX));
		String[] brackets = bracketsTmp.getBracketArray();
		if (brackets != null) {
			bracketsList.setItems(brackets);
		}
	}
	
	private void addListenersToStyleButtons() {
		enableCheckbox.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
			
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				matchingBracketsColorButton.setEnabled(enableCheckbox.getSelection());
			}
		});
		languagesCombo.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
			
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				bracketSetTemp.put(language, bracketsTmp.getBracketString());
				language = languagesCombo.getText();
				bracketsTmp.setBrackets(bracketSetTemp.get(language));
				leftBracketTokensCombo.setItems(ALL_LEFT_BRACKETS);
				leftBracketTokensCombo.select(0);
				rightBracketTokensCombo.setItems(ALL_RIGHT_BRACKETS);
				rightBracketTokensCombo.select(0);
				bracketsList.setItems(bracketsTmp.getBracketArray());
			}
			
		});
		addBracketButton.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
			
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				String open = leftBracketTokensCombo.getText();
				String close = rightBracketTokensCombo.getText();
				if (bracketsTmp.isBracket(open) || bracketsTmp.isBracket(close)) {
					setErrorMessage("One or both bracket parts are set!");
				} else {
					bracketsTmp.addBracketPair(open, close, enableClosingInside.getSelection());
					bracketsList.setItems(bracketsTmp.getBracketArray());
					setErrorMessage(null);
					bracketSetTemp.put(language, bracketsTmp.getBracketString());
				}
			}
		});
		
		removeBracketButton.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
			
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				bracketsTmp.removeBracketPairs(bracketsList.getSelection());
				setErrorMessage(null);
				bracketsList.setItems(bracketsTmp.getBracketArray());
				bracketSetTemp.put(language, bracketsTmp.getBracketString());
			}
		});
		
		bracketsList.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				boolean isClosingInside = true;
				int[] itemIndices = bracketsList.getSelectionIndices();
				for (int index : itemIndices) {
					org.emftext.sdk.concretesyntax.resource.cs.ICsBracketPair bracketPair = bracketsTmp.getBracketPair(index);
					if (bracketPair != null					&& !bracketPair.isClosingEnabledInside()) {
						isClosingInside = false;
						break;
					}
				}
				enableClosingInside.setSelection(isClosingInside);
			}
			
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
		
		enableClosingInside.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				boolean isClosingInside = enableClosingInside.getSelection();
				int[] itemIndices = bracketsList.getSelectionIndices();
				for (int idx : itemIndices) {
					org.emftext.sdk.concretesyntax.resource.cs.ICsBracketPair bracketPair = bracketsTmp.getBracketPair(idx);
					if (bracketPair != null)					bracketsTmp.setClosingEnabledInside(bracketPair, isClosingInside);
				}
				bracketSetTemp.put(language, bracketsTmp.getBracketString());
			}
			
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
	}
	
	// Sets the default values for this preference page.
	protected void performDefaults() {
		enableCheckbox.setSelection(getPreferenceStore().getDefaultBoolean(		org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX));
		matchingBracketsColorButton.setEnabled(enableCheckbox.getSelection());
		matchingBracketsColorEditor.setColorValue(org.eclipse.jface.preference.PreferenceConverter.getDefaultColor(getPreferenceStore(), BRACKETS_COLOR));
		bracketSetTemp.put(language, getPreferenceStore().getDefaultString(		language + org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_BRACKETS_SUFFIX));
		bracketsTmp.setBrackets(bracketSetTemp.get(language));
		bracketsList.setItems(bracketsTmp.getBracketArray());
		enableClosingInside.setSelection(false);
	}
	
	public boolean performOk() {
		if (!super.performOk()) {
			return false;
		}
		updateActiveEditor();
		return true;
	}
	
	protected void performApply() {
		updateActiveEditor();
	}
	
	// Sets the chosen options to the preference store and refreshs it in the
	// editor.
	private void updateActiveEditor() {
		// set the values after ok or apply
		org.eclipse.jface.preference.PreferenceConverter.setValue(getPreferenceStore(), BRACKETS_COLOR, matchingBracketsColorEditor.getColorValue());
		getPreferenceStore().setValue(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, enableCheckbox.getSelection());
		
		for (String languageID : languagesCombo.getItems()) {
			getPreferenceStore().setValue(			languageID + org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_BRACKETS_SUFFIX,
			bracketSetTemp.get(languageID));
		}
		
		org.eclipse.ui.IWorkbench workbench = org.eclipse.ui.PlatformUI.getWorkbench();
		org.eclipse.ui.IEditorPart editor = workbench.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (editor != null && editor instanceof org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditor) {
			((org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditor) editor).invalidateTextRepresentation();
		}
	}
}

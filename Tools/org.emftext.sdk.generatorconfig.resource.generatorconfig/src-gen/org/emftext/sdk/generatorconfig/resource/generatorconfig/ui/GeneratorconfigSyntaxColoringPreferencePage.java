/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.generatorconfig.resource.generatorconfig.ui;

// Preference page for configuring syntax coloring.
// <p>
// <i>Parts of the code were taken from the JDT Java org.eclipse.emf.codegen.ecore.templates.editor.Editor</i>
///
public class GeneratorconfigSyntaxColoringPreferencePage extends org.eclipse.jface.preference.PreferencePage implements org.eclipse.ui.IWorkbenchPreferencePage {

	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigAntlrTokenHelper tokenHelper = new org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigAntlrTokenHelper();
	private static final java.util.Map<String, java.util.List<HighlightingColorListItem>> content = new java.util.HashMap<String, java.util.List<HighlightingColorListItem>>();
	private static final java.util.Collection<IChangedPreference> changedPreferences = new java.util.ArrayList<IChangedPreference>();

	private interface IChangedPreference {
		public void apply(org.eclipse.jface.preference.IPreferenceStore store);
	}

	private abstract static class AbstractChangedPreference implements IChangedPreference {

		private String key;

		public AbstractChangedPreference(String key) {
			super();
			this.key = key;
		}

		public String getKey() {
			return key;
		}
	}

	private static class ChangedBooleanPreference extends AbstractChangedPreference {

		private boolean newValue;

		public ChangedBooleanPreference(String key, boolean newValue) {
			super(key);
			this.newValue = newValue;
		}

		public void apply(org.eclipse.jface.preference.IPreferenceStore store) {
			store.setValue(getKey(), newValue);
		}
	}

	private static class ChangedRGBPreference extends AbstractChangedPreference {

		private org.eclipse.swt.graphics.RGB newValue;

		public ChangedRGBPreference(String key, org.eclipse.swt.graphics.RGB newValue) {
			super(key);
			this.newValue = newValue;
		}

		public void apply(org.eclipse.jface.preference.IPreferenceStore store) {
			org.eclipse.jface.preference.PreferenceConverter.setValue(store, getKey(), newValue);
		}
	}

	// Item in the highlighting color list.
	private static class HighlightingColorListItem implements Comparable<HighlightingColorListItem> {
		// Display name
		private String fDisplayName;
		// Color preference key
		private String fColorKey;
		// Bold preference key
		private String fBoldKey;
		// Italic preference key
		private String fItalicKey;
		// Strikethrough preference key.
		private String fStrikethroughKey;
		// Underline preference key.
		private String fUnderlineKey;
		private String fEnableKey;

		// Initialize the item with the given values.
		public HighlightingColorListItem(String languageID, String tokenName) {
			fDisplayName = tokenName;
			fColorKey = org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.StyleProperty.COLOR);
			fBoldKey = org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.StyleProperty.BOLD);
			fItalicKey = org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.StyleProperty.ITALIC);
			fStrikethroughKey = org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.StyleProperty.STRIKETHROUGH);
			fUnderlineKey = org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.StyleProperty.UNDERLINE);
			fEnableKey = org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigSyntaxColoringHelper.StyleProperty.ENABLE);
		}

		// @return the bold preference key
		public String getBoldKey() {
			return fBoldKey;
		}

		// @return the bold preference key
		public String getItalicKey() {
			return fItalicKey;
		}

		// @return the strikethrough preference key
		public String getStrikethroughKey() {
			return fStrikethroughKey;
		}

		// @return the underline preference key
		public String getUnderlineKey() {
			return fUnderlineKey;
		}

		// @return the color preference key
		public String getColorKey() {
			return fColorKey;
		}

		// @return the display name
		public String getDisplayName() {
			return fDisplayName;
		}

		public String getEnableKey() {
			return fEnableKey;
		}

		public int compareTo(HighlightingColorListItem o) {
			return fDisplayName.compareTo(o.getDisplayName());
		}
	}

	// Color list label provider.
	private class ColorListLabelProvider extends org.eclipse.jface.viewers.LabelProvider {

		public String getText(Object element) {
			if (element instanceof String)			return (String) element;
			return ((HighlightingColorListItem) element).getDisplayName();
		}
	}

	// Color list content provider.
	private class ColorListContentProvider implements org.eclipse.jface.viewers.ITreeContentProvider {

		public ColorListContentProvider() {
			super();
		}

		public Object[] getElements(Object inputElement) {
			java.util.List<HighlightingColorListItem> contentsList = new java.util.ArrayList<HighlightingColorListItem>();
			for(java.util.List<HighlightingColorListItem> l : content.values()) {
				contentsList.addAll(l);
			}
			return contentsList.toArray();
		}

		public void dispose() {
		}

		public void inputChanged(org.eclipse.jface.viewers.Viewer viewer, Object oldInput, Object newInput) {
		}

		public Object[] getChildren(Object parentElement) {
			return new Object[0];
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			return false;
		}
	}

	private org.eclipse.jface.preference.ColorSelector fSyntaxForegroundColorEditor;
	private org.eclipse.swt.widgets.Label fColorEditorLabel;
	private org.eclipse.swt.widgets.Button fBoldCheckBox;
	private org.eclipse.swt.widgets.Button fEnableCheckbox;
	// Check box for italic preference.
	private org.eclipse.swt.widgets.Button fItalicCheckBox;
	// Check box for strikethrough preference.
	private org.eclipse.swt.widgets.Button fStrikethroughCheckBox;
	// Check box for underline preference.
	private org.eclipse.swt.widgets.Button fUnderlineCheckBox;
	private org.eclipse.swt.widgets.Button fForegroundColorButton;

	// Highlighting color list viewer
	private org.eclipse.jface.viewers.StructuredViewer fListViewer;

	public void dispose() {
		super.dispose();
	}

	private void handleSyntaxColorListSelection() {
		HighlightingColorListItem item = getHighlightingColorListItem();
		if (item == null) {
			fEnableCheckbox.setEnabled(false);
			fSyntaxForegroundColorEditor.getButton().setEnabled(false);
			fColorEditorLabel.setEnabled(false);
			fBoldCheckBox.setEnabled(false);
			fItalicCheckBox.setEnabled(false);
			fStrikethroughCheckBox.setEnabled(false);
			fUnderlineCheckBox.setEnabled(false);
			return;
		}
		org.eclipse.swt.graphics.RGB rgb = org.eclipse.jface.preference.PreferenceConverter.getColor(getPreferenceStore(), item.getColorKey());
		fSyntaxForegroundColorEditor.setColorValue(rgb);
		fBoldCheckBox.setSelection(getPreferenceStore().getBoolean(		item.getBoldKey()));
		fItalicCheckBox.setSelection(getPreferenceStore().getBoolean(		item.getItalicKey()));
		fStrikethroughCheckBox.setSelection(getPreferenceStore().getBoolean(		item.getStrikethroughKey()));
		fUnderlineCheckBox.setSelection(getPreferenceStore().getBoolean(		item.getUnderlineKey()));

		fEnableCheckbox.setEnabled(true);
		boolean enable = getPreferenceStore().getBoolean(item.getEnableKey());
		fEnableCheckbox.setSelection(enable);
		fSyntaxForegroundColorEditor.getButton().setEnabled(enable);
		fColorEditorLabel.setEnabled(enable);
		fBoldCheckBox.setEnabled(enable);
		fItalicCheckBox.setEnabled(enable);
		fStrikethroughCheckBox.setEnabled(enable);
		fUnderlineCheckBox.setEnabled(enable);
	}

	private org.eclipse.swt.widgets.Control createSyntaxPage(final org.eclipse.swt.widgets.Composite parent) {

		org.eclipse.swt.widgets.Composite colorComposite = new org.eclipse.swt.widgets.Composite(parent, org.eclipse.swt.SWT.NONE);
		org.eclipse.swt.layout.GridLayout layout = new org.eclipse.swt.layout.GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		colorComposite.setLayout(layout);

		addFiller(colorComposite, 1);

		org.eclipse.swt.widgets.Label label = new org.eclipse.swt.widgets.Label(colorComposite, org.eclipse.swt.SWT.LEFT);
		label.setText("Element:");
		label.setLayoutData(new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.FILL, org.eclipse.swt.layout.GridData.BEGINNING,
		true, false));

		org.eclipse.swt.widgets.Composite editorComposite = createEditorComposite(colorComposite);
		createListViewer(editorComposite);
		createStylesComposite(editorComposite);

		addListenersToStyleButtons();
		colorComposite.layout(false);
		handleSyntaxColorListSelection();

		return colorComposite;
	}

	private org.eclipse.swt.widgets.Composite createEditorComposite(org.eclipse.swt.widgets.Composite colorComposite) {
		org.eclipse.swt.layout.GridLayout layout;
		org.eclipse.swt.widgets.Composite editorComposite = new org.eclipse.swt.widgets.Composite(colorComposite, org.eclipse.swt.SWT.NONE);
		layout = new org.eclipse.swt.layout.GridLayout();
		layout.numColumns = 2;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		editorComposite.setLayout(layout);
		org.eclipse.swt.layout.GridData gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.FILL, org.eclipse.swt.layout.GridData.FILL, true, true);
		editorComposite.setLayoutData(gd);
		return editorComposite;
	}

	private void createListViewer(org.eclipse.swt.widgets.Composite editorComposite) {
		fListViewer = new org.eclipse.jface.viewers.TreeViewer(editorComposite, org.eclipse.swt.SWT.SINGLE | org.eclipse.swt.SWT.BORDER);
		fListViewer.setLabelProvider(new ColorListLabelProvider());
		fListViewer.setContentProvider(new ColorListContentProvider());

		org.eclipse.swt.layout.GridData gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.FILL, org.eclipse.swt.layout.GridData.FILL, true, true);
		gd.heightHint = convertHeightInCharsToPixels(26);
		int maxWidth = 0;
		for (java.util.Iterator<java.util.List<HighlightingColorListItem>> it = content.values()		.iterator(); it.hasNext();) {
			for (java.util.Iterator<HighlightingColorListItem> j = it.next().iterator(); j.hasNext();) {
				HighlightingColorListItem item = j.next();
				maxWidth = Math.max(maxWidth, convertWidthInCharsToPixels(item.getDisplayName().length()));
			}
		}
		org.eclipse.swt.widgets.ScrollBar vBar = ((org.eclipse.swt.widgets.Scrollable) fListViewer.getControl()).getVerticalBar();
		if (vBar != null)		maxWidth += vBar.getSize().x * 3; // scrollbars and tree indentation
		// guess
		gd.widthHint = maxWidth;

		fListViewer.getControl().setLayoutData(gd);

		fListViewer.setInput(content);
		fListViewer.setSelection(new org.eclipse.jface.viewers.StructuredSelection(content.values().iterator().next()));
		fListViewer		.addSelectionChangedListener(new org.eclipse.jface.viewers.ISelectionChangedListener() {
			public void selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent event) {
				handleSyntaxColorListSelection();
			}
		});
	}

	private void addListenersToStyleButtons() {
		fForegroundColorButton.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				HighlightingColorListItem item = getHighlightingColorListItem();

				changedPreferences.add(new ChangedRGBPreference(item				.getColorKey(), fSyntaxForegroundColorEditor				.getColorValue()));
			}
		});

		fBoldCheckBox.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				HighlightingColorListItem item = getHighlightingColorListItem();
				changedPreferences.add(new ChangedBooleanPreference(item.getBoldKey(),
				fBoldCheckBox.getSelection()));
			}
		});

		fItalicCheckBox.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				HighlightingColorListItem item = getHighlightingColorListItem();
				changedPreferences.add(new ChangedBooleanPreference(item.getItalicKey(),
				fItalicCheckBox.getSelection()));
			}
		});
		fStrikethroughCheckBox.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				HighlightingColorListItem item = getHighlightingColorListItem();
				changedPreferences.add(new ChangedBooleanPreference(item.getStrikethroughKey(),
				fStrikethroughCheckBox.getSelection()));
			}
		});

		fUnderlineCheckBox.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				HighlightingColorListItem item = getHighlightingColorListItem();
				changedPreferences.add(new ChangedBooleanPreference(item.getUnderlineKey(),
				fUnderlineCheckBox.getSelection()));
			}
		});

		fEnableCheckbox.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				HighlightingColorListItem item = getHighlightingColorListItem();

				boolean enable = fEnableCheckbox.getSelection();
				changedPreferences.add(new ChangedBooleanPreference(item.getEnableKey(), enable));
				fEnableCheckbox.setSelection(enable);
				fSyntaxForegroundColorEditor.getButton().setEnabled(enable);
				fColorEditorLabel.setEnabled(enable);
				fBoldCheckBox.setEnabled(enable);
				fItalicCheckBox.setEnabled(enable);
				fStrikethroughCheckBox.setEnabled(enable);
				fUnderlineCheckBox.setEnabled(enable);
				// uninstallSemanticHighlighting();
				// installSemanticHighlighting();
			}
		});
	}

	private void createStylesComposite(org.eclipse.swt.widgets.Composite editorComposite) {
		org.eclipse.swt.layout.GridLayout layout;
		org.eclipse.swt.layout.GridData gd;
		org.eclipse.swt.widgets.Composite stylesComposite = new org.eclipse.swt.widgets.Composite(editorComposite, org.eclipse.swt.SWT.NONE);
		layout = new org.eclipse.swt.layout.GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.numColumns = 2;
		stylesComposite.setLayout(layout);
		stylesComposite.setLayoutData(new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.END, org.eclipse.swt.layout.GridData.FILL,
		false, true));

		fEnableCheckbox = new org.eclipse.swt.widgets.Button(stylesComposite, org.eclipse.swt.SWT.CHECK);
		fEnableCheckbox.setText("Enable");
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.FILL_HORIZONTAL);
		gd.horizontalAlignment = org.eclipse.swt.layout.GridData.BEGINNING;
		gd.horizontalSpan = 2;
		fEnableCheckbox.setLayoutData(gd);

		fColorEditorLabel = new org.eclipse.swt.widgets.Label(stylesComposite, org.eclipse.swt.SWT.LEFT);
		fColorEditorLabel.setText("Color:");
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalIndent = 20;
		fColorEditorLabel.setLayoutData(gd);

		fSyntaxForegroundColorEditor = new org.eclipse.jface.preference.ColorSelector(stylesComposite);
		fForegroundColorButton = fSyntaxForegroundColorEditor.getButton();
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.HORIZONTAL_ALIGN_BEGINNING);
		fForegroundColorButton.setLayoutData(gd);

		fBoldCheckBox = new org.eclipse.swt.widgets.Button(stylesComposite, org.eclipse.swt.SWT.CHECK);
		fBoldCheckBox.setText("Bold");
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalIndent = 20;
		gd.horizontalSpan = 2;
		fBoldCheckBox.setLayoutData(gd);

		fItalicCheckBox = new org.eclipse.swt.widgets.Button(stylesComposite, org.eclipse.swt.SWT.CHECK);
		fItalicCheckBox.setText("Italic");
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalIndent = 20;
		gd.horizontalSpan = 2;
		fItalicCheckBox.setLayoutData(gd);

		fStrikethroughCheckBox = new org.eclipse.swt.widgets.Button(stylesComposite, org.eclipse.swt.SWT.CHECK);
		fStrikethroughCheckBox.setText("Strikethrough");
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalIndent = 20;
		gd.horizontalSpan = 2;
		fStrikethroughCheckBox.setLayoutData(gd);

		fUnderlineCheckBox = new org.eclipse.swt.widgets.Button(stylesComposite, org.eclipse.swt.SWT.CHECK);
		fUnderlineCheckBox.setText("Underlined");
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalIndent = 20;
		gd.horizontalSpan = 2;
		fUnderlineCheckBox.setLayoutData(gd);
	}

	private void addFiller(org.eclipse.swt.widgets.Composite composite, int horizontalSpan) {
		org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigPixelConverter pixelConverter = new org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigPixelConverter(composite);
		org.eclipse.swt.widgets.Label filler = new org.eclipse.swt.widgets.Label(composite, org.eclipse.swt.SWT.LEFT);
		org.eclipse.swt.layout.GridData gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.HORIZONTAL_ALIGN_FILL);
		gd.horizontalSpan = horizontalSpan;
		gd.heightHint = pixelConverter.convertHeightInCharsToPixels(1) / 2;
		filler.setLayoutData(gd);
	}

	// Returns the current highlighting color list item.
	private HighlightingColorListItem getHighlightingColorListItem() {
		org.eclipse.jface.viewers.IStructuredSelection selection = (org.eclipse.jface.viewers.IStructuredSelection) fListViewer.getSelection();
		Object element = selection.getFirstElement();
		if (element instanceof String)		return null;
		return (HighlightingColorListItem) element;
	}

	public GeneratorconfigSyntaxColoringPreferencePage() {
		super();

		org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigMetaInformation syntaxPlugin = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigMetaInformation();

		String languageId = syntaxPlugin.getSyntaxName();

		java.util.List<HighlightingColorListItem> terminals = new java.util.ArrayList<HighlightingColorListItem>();
		String[] tokenNames = syntaxPlugin.getTokenNames();

		for (int i = 0; i < tokenNames.length; i++) {
			if (!tokenHelper.canBeUsedForSyntaxColoring(i)) {
				continue;
			}

			String tokenName = tokenHelper.getTokenName(tokenNames, i);
			if (tokenName == null) {
				continue;
			}
			HighlightingColorListItem item = new HighlightingColorListItem(languageId, tokenName);
			terminals.add(item);
		}
		java.util.Collections.sort(terminals);
		content.put(languageId, terminals);

		setPreferenceStore(org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigPlugin.getDefault().getPreferenceStore());
		setDescription("Configure syntax coloring for ." + languageId + " files.");
	}

	public void init(org.eclipse.ui.IWorkbench workbench) {
	}

	protected org.eclipse.swt.widgets.Control createContents(org.eclipse.swt.widgets.Composite parent) {
		org.eclipse.swt.widgets.Control content = createSyntaxPage(parent);
		return content;
	}

	public boolean performOk() {
		if (!super.performOk()) {
			return false;
		}
		performApply();
		return true;
	}

	public boolean performCancel() {
		if (!super.performCancel()) {
			return false;
		}
		// discard all changes that were made
		changedPreferences.clear();
		return true;
	}

	protected void performApply() {
		for (IChangedPreference changedPreference : changedPreferences) {
			changedPreference.apply(getPreferenceStore());
		}
		changedPreferences.clear();
		updateActiveEditor();
	}

	public void performDefaults() {
		super.performDefaults();

		org.eclipse.jface.preference.IPreferenceStore preferenceStore = getPreferenceStore();
		// reset all preferences to their default values
		for (String languageID : content.keySet()) {
			java.util.List<HighlightingColorListItem> items = content.get(languageID);
			for (HighlightingColorListItem item : items) {
				restoreDefaultBooleanValue(preferenceStore, item.getBoldKey());
				restoreDefaultBooleanValue(preferenceStore, item.getEnableKey());
				restoreDefaultBooleanValue(preferenceStore, item.getItalicKey());
				restoreDefaultBooleanValue(preferenceStore, item.getStrikethroughKey());
				restoreDefaultBooleanValue(preferenceStore, item.getUnderlineKey());
				restoreDefaultStringValue(preferenceStore, item.getColorKey());
			}
		}
		handleSyntaxColorListSelection();
		updateActiveEditor();
	}

	private void restoreDefaultBooleanValue(org.eclipse.jface.preference.IPreferenceStore preferenceStore, String key) {
		preferenceStore.setValue(key, preferenceStore.getDefaultBoolean(key));
	}

	private void restoreDefaultStringValue(org.eclipse.jface.preference.IPreferenceStore preferenceStore, String key) {
		preferenceStore.setValue(key, preferenceStore.getDefaultString(key));
	}

	private void updateActiveEditor() {
		org.eclipse.ui.IWorkbench workbench = org.eclipse.ui.PlatformUI.getWorkbench();
		org.eclipse.ui.IEditorPart editor = workbench.getActiveWorkbenchWindow()		.getActivePage().getActiveEditor();
		if (editor != null && editor instanceof org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigEditor) {
			org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigEditor emfTextEditor = (org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigEditor) editor;
			emfTextEditor.invalidateTextRepresentation();
		}
	}
}

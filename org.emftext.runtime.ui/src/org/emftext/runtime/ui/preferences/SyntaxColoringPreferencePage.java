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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
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
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Scrollable;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.resource.ITextResourcePluginMetaInformation;
import org.emftext.runtime.ui.EMFTextRuntimeUIPlugin;
import org.emftext.runtime.ui.AntlrTokenHelper;
import org.emftext.runtime.ui.editor.EMFTextEditor;
import org.emftext.runtime.ui.preferences.SyntaxColoringHelper.StyleProperty;

/**
 * Preference page for configuring syntax coloring.
 * <p>
 * <i>Parts of the code were taken from the JDT Java Editor</i>
 */
public class SyntaxColoringPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	private final static AntlrTokenHelper tokenHelper = new AntlrTokenHelper();

	private static final Map<String, List<HighlightingColorListItem>> content = new HashMap<String, List<HighlightingColorListItem>>();
	private static final Collection<IChangedPreference> changedPreferences = new ArrayList<IChangedPreference>();

	private interface IChangedPreference {
		public void apply(IPreferenceStore store);
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

		public void apply(IPreferenceStore store) {
			store.setValue(getKey(), newValue);
		}
	}
	
	private static class ChangedRGBPreference extends AbstractChangedPreference {

		private RGB newValue;

		public ChangedRGBPreference(String key, RGB newValue) {
			super(key);
			this.newValue = newValue;
		}

		public void apply(IPreferenceStore store) {
			PreferenceConverter.setValue(store, getKey(), newValue);
		}
	}
	
	/**
	 * Item in the highlighting color list.
	 */
	private static class HighlightingColorListItem implements Comparable<HighlightingColorListItem> {
		/** Display name */
		private String fDisplayName;
		/** Color preference key */
		private String fColorKey;
		/** Bold preference key */
		private String fBoldKey;
		/** Italic preference key */
		private String fItalicKey;
		/** Strikethrough preference key. */
		private String fStrikethroughKey;
		/** Underline preference key. */
		private String fUnderlineKey;

		private String fEnableKey;

		private String fparent;

		/**
		 * Initialize the item with the given values.
		 */
		public HighlightingColorListItem(String languageID, String tokenName) {
			fparent = languageID;
			fDisplayName = tokenName;
			
			fColorKey = SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, StyleProperty.COLOR);
			fBoldKey = SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, StyleProperty.BOLD);
			fItalicKey = SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, StyleProperty.ITALIC);
			fStrikethroughKey = SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, StyleProperty.STRIKETHROUGH);
			fUnderlineKey = SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, StyleProperty.UNDERLINE);
			fEnableKey = SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, StyleProperty.ENABLE);
		}

		public String getParent() {
			return fparent;
		}

		/**
		 * @return the bold preference key
		 */
		public String getBoldKey() {
			return fBoldKey;
		}

		/**
		 * @return the bold preference key
		 */
		public String getItalicKey() {
			return fItalicKey;
		}

		/**
		 * @return the strikethrough preference key
		 */
		public String getStrikethroughKey() {
			return fStrikethroughKey;
		}

		/**
		 * @return the underline preference key
		 */
		public String getUnderlineKey() {
			return fUnderlineKey;
		}

		/**
		 * @return the color preference key
		 */
		public String getColorKey() {
			return fColorKey;
		}

		/**
		 * @return the display name
		 */
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

	/**
	 * Color list label provider.
	 */
	private class ColorListLabelProvider extends LabelProvider {
		/*
		 * @see
		 * org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
		 */
		public String getText(Object element) {
			if (element instanceof String)
				return (String) element;
			return ((HighlightingColorListItem) element).getDisplayName();
		}
	}

	/**
	 * Color list content provider.
	 * 
	 * @since 3.0
	 */
	private class ColorListContentProvider implements ITreeContentProvider {

		public ColorListContentProvider() {
			super();
		}

		/*
		 * @see
		 * org.eclipse.jface.viewers.IStructuredContentProvider#getElements(
		 * java.lang.Object)
		 */
		public Object[] getElements(Object inputElement) {
			Set<String> contents = content.keySet();
			List<String> contentsList = new ArrayList<String>();
			contentsList.addAll(contents);
			Collections.sort(contentsList);
			return contentsList.toArray();
		}

		/*
		 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
		 */
		public void dispose() {
		}

		/*
		 * @see
		 * org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse
		 * .jface.viewers.Viewer, java.lang.Object, java.lang.Object)
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof String) {
				String entry = (String) parentElement;

				List<HighlightingColorListItem> items = content.get(entry);
				List<HighlightingColorListItem> itemsList = new ArrayList<HighlightingColorListItem>();
				itemsList.addAll(items);
				Collections.sort(itemsList);
				return itemsList.toArray();
			}
			return new Object[0];
		}

		public Object getParent(Object element) {
			if (element instanceof HighlightingColorListItem)
				return ((HighlightingColorListItem) element).getParent();
			return null;
		}

		public boolean hasChildren(Object element) {
			return content.containsKey(element);
		}
	}

	private ColorSelector fSyntaxForegroundColorEditor;
	private Label fColorEditorLabel;
	private Button fBoldCheckBox;
	private Button fEnableCheckbox;
	/**
	 * Check box for italic preference.
	 * 
	 * @since 3.0
	 */
	private Button fItalicCheckBox;
	/**
	 * Check box for strikethrough preference.
	 * 
	 * @since 3.1
	 */
	private Button fStrikethroughCheckBox;
	/**
	 * Check box for underline preference.
	 * 
	 * @since 3.1
	 */
	private Button fUnderlineCheckBox;
	private Button fForegroundColorButton;

	/**
	 * Highlighting color list viewer
	 * 
	 * @since 3.0
	 */
	private StructuredViewer fListViewer;

	/*
	 * @see
	 * org.eclipse.jdt.internal.ui.preferences.IPreferenceConfigurationBlock
	 * #dispose()
	 */
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
		RGB rgb = PreferenceConverter.getColor(getPreferenceStore(), item
				.getColorKey());
		fSyntaxForegroundColorEditor.setColorValue(rgb);
		fBoldCheckBox.setSelection(getPreferenceStore().getBoolean(
				item.getBoldKey()));
		fItalicCheckBox.setSelection(getPreferenceStore().getBoolean(
				item.getItalicKey()));
		fStrikethroughCheckBox.setSelection(getPreferenceStore().getBoolean(
				item.getStrikethroughKey()));
		fUnderlineCheckBox.setSelection(getPreferenceStore().getBoolean(
				item.getUnderlineKey()));

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

	private Control createSyntaxPage(final Composite parent) {

		Composite colorComposite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		colorComposite.setLayout(layout);

		addFiller(colorComposite, 1);

		Label label = new Label(colorComposite, SWT.LEFT);
		label.setText("Element:");
		label.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING,
				true, false));

		Composite editorComposite = createEditorComposite(colorComposite);
		createListViewer(editorComposite);
		createStylesComposite(editorComposite);

		addListenersToStyleButtons();
		colorComposite.layout(false);
		handleSyntaxColorListSelection();

		return colorComposite;
	}

	private Composite createEditorComposite(Composite colorComposite) {
		GridLayout layout;
		Composite editorComposite = new Composite(colorComposite, SWT.NONE);
		layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		editorComposite.setLayout(layout);
		GridData gd = new GridData(GridData.FILL, GridData.FILL, true, true);
		editorComposite.setLayoutData(gd);
		return editorComposite;
	}

	private void createListViewer(Composite editorComposite) {
		fListViewer = new TreeViewer(editorComposite, SWT.SINGLE | SWT.BORDER);
		fListViewer.setLabelProvider(new ColorListLabelProvider());
		fListViewer.setContentProvider(new ColorListContentProvider());

		GridData gd = new GridData(GridData.FILL, GridData.FILL, true, true);
		gd.heightHint = convertHeightInCharsToPixels(26);
		int maxWidth = 0;
		for (Iterator<List<HighlightingColorListItem>> it = content.values()
				.iterator(); it.hasNext();) {
			for (Iterator<HighlightingColorListItem> j = it.next().iterator(); j
					.hasNext();) {
				HighlightingColorListItem item = j.next();
				maxWidth = Math.max(maxWidth, convertWidthInCharsToPixels(item
						.getDisplayName().length()));
			}
		}
		ScrollBar vBar = ((Scrollable) fListViewer.getControl())
				.getVerticalBar();
		if (vBar != null)
			maxWidth += vBar.getSize().x * 3; // scrollbars and tree indentation
												// guess
		gd.widthHint = maxWidth;

		fListViewer.getControl().setLayoutData(gd);

		fListViewer.setInput(content);
		fListViewer.setSelection(new StructuredSelection(content.values()
				.iterator().next()));
		fListViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						handleSyntaxColorListSelection();
					}
				});
	}

	private void addListenersToStyleButtons() {
		fForegroundColorButton.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				HighlightingColorListItem item = getHighlightingColorListItem();
				
				changedPreferences.add(new ChangedRGBPreference(item
						.getColorKey(), fSyntaxForegroundColorEditor
						.getColorValue()));
			}
		});

		fBoldCheckBox.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				HighlightingColorListItem item = getHighlightingColorListItem();
				changedPreferences.add(new ChangedBooleanPreference(item.getBoldKey(),
						fBoldCheckBox.getSelection()));
			}
		});

		fItalicCheckBox.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				HighlightingColorListItem item = getHighlightingColorListItem();
				changedPreferences.add(new ChangedBooleanPreference(item.getItalicKey(),
						fItalicCheckBox.getSelection()));
			}
		});
		fStrikethroughCheckBox.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				HighlightingColorListItem item = getHighlightingColorListItem();
				changedPreferences.add(new ChangedBooleanPreference(item.getStrikethroughKey(),
						fStrikethroughCheckBox.getSelection()));
			}
		});

		fUnderlineCheckBox.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				HighlightingColorListItem item = getHighlightingColorListItem();
				changedPreferences.add(new ChangedBooleanPreference(item.getUnderlineKey(),
						fUnderlineCheckBox.getSelection()));
			}
		});

		fEnableCheckbox.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(SelectionEvent e) {
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

	private void createStylesComposite(Composite editorComposite) {
		GridLayout layout;
		GridData gd;
		Composite stylesComposite = new Composite(editorComposite, SWT.NONE);
		layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.numColumns = 2;
		stylesComposite.setLayout(layout);
		stylesComposite.setLayoutData(new GridData(GridData.END, GridData.FILL,
				false, true));

		fEnableCheckbox = new Button(stylesComposite, SWT.CHECK);
		fEnableCheckbox.setText("Enable");
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalAlignment = GridData.BEGINNING;
		gd.horizontalSpan = 2;
		fEnableCheckbox.setLayoutData(gd);

		fColorEditorLabel = new Label(stylesComposite, SWT.LEFT);
		fColorEditorLabel.setText("Color:");
		gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalIndent = 20;
		fColorEditorLabel.setLayoutData(gd);

		fSyntaxForegroundColorEditor = new ColorSelector(stylesComposite);
		fForegroundColorButton = fSyntaxForegroundColorEditor.getButton();
		gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		fForegroundColorButton.setLayoutData(gd);

		fBoldCheckBox = new Button(stylesComposite, SWT.CHECK);
		fBoldCheckBox.setText("Bold");
		gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalIndent = 20;
		gd.horizontalSpan = 2;
		fBoldCheckBox.setLayoutData(gd);

		fItalicCheckBox = new Button(stylesComposite, SWT.CHECK);
		fItalicCheckBox.setText("Italic");
		gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalIndent = 20;
		gd.horizontalSpan = 2;
		fItalicCheckBox.setLayoutData(gd);

		fStrikethroughCheckBox = new Button(stylesComposite, SWT.CHECK);
		fStrikethroughCheckBox.setText("Strikethrough");
		gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalIndent = 20;
		gd.horizontalSpan = 2;
		fStrikethroughCheckBox.setLayoutData(gd);

		fUnderlineCheckBox = new Button(stylesComposite, SWT.CHECK);
		fUnderlineCheckBox.setText("Underlined");
		gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalIndent = 20;
		gd.horizontalSpan = 2;
		fUnderlineCheckBox.setLayoutData(gd);
	}

	private void addFiller(Composite composite, int horizontalSpan) {
		PixelConverter pixelConverter = new PixelConverter(composite);
		Label filler = new Label(composite, SWT.LEFT);
		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gd.horizontalSpan = horizontalSpan;
		gd.heightHint = pixelConverter.convertHeightInCharsToPixels(1) / 2;
		filler.setLayoutData(gd);
	}

	/**
	 * Returns the current highlighting color list item.
	 * 
	 * @return the current highlighting color list item
	 * @since 3.0
	 */
	private HighlightingColorListItem getHighlightingColorListItem() {
		IStructuredSelection selection = (IStructuredSelection) fListViewer
				.getSelection();
		Object element = selection.getFirstElement();
		if (element instanceof String)
			return null;
		return (HighlightingColorListItem) element;
	}

	public SyntaxColoringPreferencePage() {
		super();

		List<ITextResourcePluginMetaInformation> syntaxPlugins = EMFTextRuntimePlugin.getConcreteSyntaxRegistry();
		for (ITextResourcePluginMetaInformation syntaxPlugin : syntaxPlugins) {

			String languageId = syntaxPlugin.getSyntaxName();

			List<HighlightingColorListItem> terminals = new ArrayList<HighlightingColorListItem>();
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
			content.put(languageId, terminals);
		}

		setPreferenceStore(EMFTextRuntimeUIPlugin.getDefault()
				.getPreferenceStore());
		setDescription("Define the syntax coloring for registered textual syntaxes.");
	}

	public void init(IWorkbench workbench) {
	}

	@Override
	protected Control createContents(Composite parent) {
		Control content = createSyntaxPage(parent);
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

		IPreferenceStore preferenceStore = getPreferenceStore();
		// reset all preferences to their default values
		for (String languageID : content.keySet()) {
			List<HighlightingColorListItem> items = content.get(languageID);
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

	private void restoreDefaultBooleanValue(IPreferenceStore preferenceStore,
			String key) {
		preferenceStore.setValue(key, preferenceStore.getDefaultBoolean(key));
	}

	private void restoreDefaultStringValue(IPreferenceStore preferenceStore,
			String key) {
		preferenceStore.setValue(key, preferenceStore.getDefaultString(key));
	}

	private void updateActiveEditor() {
		IWorkbench workbench = org.eclipse.ui.PlatformUI.getWorkbench();
		IEditorPart editor = workbench.getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor();
		if (editor != null && editor instanceof EMFTextEditor) {
			EMFTextEditor emfTextEditor = (EMFTextEditor) editor;
			emfTextEditor.invalidateTextRepresentation();
		}
	}
}

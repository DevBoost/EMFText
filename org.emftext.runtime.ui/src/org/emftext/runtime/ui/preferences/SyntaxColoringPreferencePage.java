package org.emftext.runtime.ui.preferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.preference.ColorSelector;
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
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.ui.EMFTextRuntimeUIPlugin;
import org.emftext.runtime.ui.TokenHelper;
import org.emftext.runtime.ui.editor.EMFTextEditor;

/**
 * Preference page for configuring syntax coloring.
 * <p>
 * <i>Parts of the code were taken from the JDT Java Editor</i>
 * 
 * @author Jendrik Johannes <jendrik.johannes@tu-dresden.de>
 */
public class SyntaxColoringPreferencePage
	extends PreferencePage
	implements IWorkbenchPreferencePage {
	
	private final static TokenHelper tokenHelper = new TokenHelper();
    
    private static final Map<String,List<HighlightingColorListItem>> content = new HashMap<String,List<HighlightingColorListItem>>();
    
        /**
         * Item in the highlighting color list.
         */
        private static class HighlightingColorListItem {
            /** Display name */
            private String fDisplayName;
            /** Color preference key */
            private String fColorKey;
            /** Bold preference key */
            private String fBoldKey;
            /** Italic preference key */
            private String fItalicKey;
            /**
             * Strikethrough preference key.
             * @since 3.1
             */
            private String fStrikethroughKey;
            /** Underline preference key.
             * @since 3.1
             */
            private String fUnderlineKey;
            
            private String fEnableKey;
            
            private String fparent;
            
            /**
             * Initialize the item with the given values.
             * @param displayName the display name
             * @param colorKey the color preference key
             * @param boldKey the bold preference key
             * @param italicKey the italic preference key
             * @param strikethroughKey the strikethrough preference key
             * @param underlineKey the underline preference key
             */
            public HighlightingColorListItem(String parent, String displayName, String colorKey, String boldKey, String italicKey, String strikethroughKey, String underlineKey, String enableKey) {
                fparent = parent;
                fDisplayName= displayName;
                fColorKey= colorKey;
                fBoldKey= boldKey;
                fItalicKey= italicKey;
                fStrikethroughKey= strikethroughKey; 
                fUnderlineKey= underlineKey; 
                fEnableKey = enableKey;
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
             * @since 3.1
             */
            public String getStrikethroughKey() {
                return fStrikethroughKey;
            }
            
            /**
             * @return the underline preference key
             * @since 3.1
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
        }
            
        /**
         * Color list label provider.
         */
        private class ColorListLabelProvider extends LabelProvider {
            /*
             * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
             */
            public String getText(Object element) {
                if (element instanceof String)
                    return (String) element;
                return ((HighlightingColorListItem)element).getDisplayName();
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
             * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
             */
            public Object[] getElements(Object inputElement) {
                return content.keySet().toArray();
            }
        
            /*
             * @see org.eclipse.jface.viewers.IContentProvider#dispose()
             */
            public void dispose() {
            }
        
            /*
             * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
             */
            public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
            }

            public Object[] getChildren(Object parentElement) {
                if (parentElement instanceof String) {
                    String entry= (String) parentElement;
                    return content.get(entry).toArray();
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

        private static final String COLOR = PreferenceConstants.EDITOR_COLOR_SUFFIX;

        private static final String BOLD= PreferenceConstants.EDITOR_BOLD_SUFFIX;
        /**
         * Preference key suffix for italic preferences.
         * @since  3.0
         */
        private static final String ITALIC= PreferenceConstants.EDITOR_ITALIC_SUFFIX;
        /**
         * Preference key suffix for strikethrough preferences.
         * @since  3.1
         */
        private static final String STRIKETHROUGH= PreferenceConstants.EDITOR_STRIKETHROUGH_SUFFIX;
        /**
         * Preference key suffix for underline preferences.
         * @since  3.1
         */
        private static final String UNDERLINE= PreferenceConstants.EDITOR_UNDERLINE_SUFFIX;

        private static final String ENABLE= PreferenceConstants.EDITOR_ENABLE_SUFFIX;
        
        
        private ColorSelector fSyntaxForegroundColorEditor;
        private Label fColorEditorLabel;
        private Button fBoldCheckBox;
        private Button fEnableCheckbox;
        /**
         * Check box for italic preference.
         * @since  3.0
         */
        private Button fItalicCheckBox;
        /**
         * Check box for strikethrough preference.
         * @since  3.1
         */
        private Button fStrikethroughCheckBox;
        /**
         * Check box for underline preference.
         * @since  3.1
         */
        private Button fUnderlineCheckBox;

        /**
         * Highlighting color list viewer
         * @since  3.0
         */
        private StructuredViewer fListViewer;


        public void performDefaults() {
            super.performDefaults();
            
            handleSyntaxColorListSelection();

            //fPreviewViewer.invalidateTextPresentation();
        }

        /*
         * @see org.eclipse.jdt.internal.ui.preferences.IPreferenceConfigurationBlock#dispose()
         */
        public void dispose() {
            
            super.dispose();
        }

        private void handleSyntaxColorListSelection() {
            HighlightingColorListItem item= getHighlightingColorListItem();
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
            RGB rgb= PreferenceConverter.getColor(getPreferenceStore(), item.getColorKey());
            fSyntaxForegroundColorEditor.setColorValue(rgb);        
            fBoldCheckBox.setSelection(getPreferenceStore().getBoolean(item.getBoldKey()));
            fItalicCheckBox.setSelection(getPreferenceStore().getBoolean(item.getItalicKey()));
            fStrikethroughCheckBox.setSelection(getPreferenceStore().getBoolean(item.getStrikethroughKey()));
            fUnderlineCheckBox.setSelection(getPreferenceStore().getBoolean(item.getUnderlineKey()));

            fEnableCheckbox.setEnabled(true);
            boolean enable= getPreferenceStore().getBoolean(item.getEnableKey());
            fEnableCheckbox.setSelection(enable);
            fSyntaxForegroundColorEditor.getButton().setEnabled(enable);
            fColorEditorLabel.setEnabled(enable);
            fBoldCheckBox.setEnabled(enable);
            fItalicCheckBox.setEnabled(enable);
            fStrikethroughCheckBox.setEnabled(enable);
            fUnderlineCheckBox.setEnabled(enable);
        }
        
        
        private Control createSyntaxPage(final Composite parent) {
            
            Composite colorComposite= new Composite(parent, SWT.NONE);
            GridLayout layout= new GridLayout();
            layout.marginHeight= 0;
            layout.marginWidth= 0;
            colorComposite.setLayout(layout);

            addFiller(colorComposite, 1);
            
            Label label;
            label= new Label(colorComposite, SWT.LEFT);
            label.setText("Element:"); 
            label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
            Composite editorComposite= new Composite(colorComposite, SWT.NONE);
            layout= new GridLayout();
            layout.numColumns= 2;
            layout.marginHeight= 0;
            layout.marginWidth= 0;
            editorComposite.setLayout(layout);
            GridData gd= new GridData(SWT.FILL, SWT.BEGINNING, true, false);
            editorComposite.setLayoutData(gd);      
        
            fListViewer= new TreeViewer(editorComposite, SWT.SINGLE | SWT.BORDER);
            fListViewer.setLabelProvider(new ColorListLabelProvider());
            fListViewer.setContentProvider(new ColorListContentProvider());

            gd= new GridData(SWT.BEGINNING, SWT.BEGINNING, false, true);
            gd.heightHint = convertHeightInCharsToPixels(26);
            int maxWidth= 0;
            for (Iterator<List<HighlightingColorListItem>> it= content.values().iterator(); it.hasNext();) {
                for (Iterator<HighlightingColorListItem> j= it.next().iterator(); j.hasNext();) {
                    HighlightingColorListItem item= j.next();
                    maxWidth= Math.max(maxWidth, convertWidthInCharsToPixels(item.getDisplayName().length()));
                }
            }
            ScrollBar vBar= ((Scrollable) fListViewer.getControl()).getVerticalBar();
            if (vBar != null)
                maxWidth += vBar.getSize().x * 3; // scrollbars and tree indentation guess
            gd.widthHint= maxWidth;
            
            fListViewer.getControl().setLayoutData(gd);
            
            fListViewer.setInput(content);
            fListViewer.setSelection(new StructuredSelection(content.values().iterator().next()));

                            
            Composite stylesComposite= new Composite(editorComposite, SWT.NONE);
            layout= new GridLayout();
            layout.marginHeight= 0;
            layout.marginWidth= 0;
            layout.numColumns= 2;
            stylesComposite.setLayout(layout);
            stylesComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
            
            fEnableCheckbox= new Button(stylesComposite, SWT.CHECK);
            fEnableCheckbox.setText("Enable"); 
            gd= new GridData(GridData.FILL_HORIZONTAL);
            gd.horizontalAlignment= GridData.BEGINNING;
            gd.horizontalSpan= 2;
            fEnableCheckbox.setLayoutData(gd);
            
            fColorEditorLabel= new Label(stylesComposite, SWT.LEFT);
            fColorEditorLabel.setText("Color:"); 
            gd= new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
            gd.horizontalIndent= 20;
            fColorEditorLabel.setLayoutData(gd);
        
            fSyntaxForegroundColorEditor= new ColorSelector(stylesComposite);
            Button foregroundColorButton= fSyntaxForegroundColorEditor.getButton();
            gd= new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
            foregroundColorButton.setLayoutData(gd);
            
            fBoldCheckBox= new Button(stylesComposite, SWT.CHECK);
            fBoldCheckBox.setText("Bold"); 
            gd= new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
            gd.horizontalIndent= 20;
            gd.horizontalSpan= 2;
            fBoldCheckBox.setLayoutData(gd);
            
            fItalicCheckBox= new Button(stylesComposite, SWT.CHECK);
            fItalicCheckBox.setText("Italic"); 
            gd= new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
            gd.horizontalIndent= 20;
            gd.horizontalSpan= 2;
            fItalicCheckBox.setLayoutData(gd);
            
            fStrikethroughCheckBox= new Button(stylesComposite, SWT.CHECK);
            fStrikethroughCheckBox.setText("Strikethrough"); 
            gd= new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
            gd.horizontalIndent= 20;
            gd.horizontalSpan= 2;
            fStrikethroughCheckBox.setLayoutData(gd);
            
            fUnderlineCheckBox= new Button(stylesComposite, SWT.CHECK);
            fUnderlineCheckBox.setText("Underlined"); 
            gd= new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
            gd.horizontalIndent= 20;
            gd.horizontalSpan= 2;
            fUnderlineCheckBox.setLayoutData(gd);
            
            fListViewer.addSelectionChangedListener(new ISelectionChangedListener() {
                public void selectionChanged(SelectionChangedEvent event) {
                    handleSyntaxColorListSelection();
                }
            });
            
            foregroundColorButton.addSelectionListener(new SelectionListener() {
                public void widgetDefaultSelected(SelectionEvent e) {
                    // do nothing
                }
                public void widgetSelected(SelectionEvent e) {
                    HighlightingColorListItem item= getHighlightingColorListItem();
                    PreferenceConverter.setValue(getPreferenceStore(), item.getColorKey(), fSyntaxForegroundColorEditor.getColorValue());
                }
            });
        
            fBoldCheckBox.addSelectionListener(new SelectionListener() {
                public void widgetDefaultSelected(SelectionEvent e) {
                    // do nothing
                }
                public void widgetSelected(SelectionEvent e) {
                    HighlightingColorListItem item= getHighlightingColorListItem();
                    getPreferenceStore().setValue(item.getBoldKey(), fBoldCheckBox.getSelection());
                }
            });
                    
            fItalicCheckBox.addSelectionListener(new SelectionListener() {
                public void widgetDefaultSelected(SelectionEvent e) {
                    // do nothing
                }
                public void widgetSelected(SelectionEvent e) {
                    HighlightingColorListItem item= getHighlightingColorListItem();
                    getPreferenceStore().setValue(item.getItalicKey(), fItalicCheckBox.getSelection());
                }
            });
            fStrikethroughCheckBox.addSelectionListener(new SelectionListener() {
                public void widgetDefaultSelected(SelectionEvent e) {
                    // do nothing
                }
                public void widgetSelected(SelectionEvent e) {
                    HighlightingColorListItem item= getHighlightingColorListItem();
                    getPreferenceStore().setValue(item.getStrikethroughKey(), fStrikethroughCheckBox.getSelection());
                }
            });
            
            fUnderlineCheckBox.addSelectionListener(new SelectionListener() {
                public void widgetDefaultSelected(SelectionEvent e) {
                    // do nothing
                }
                public void widgetSelected(SelectionEvent e) {
                    HighlightingColorListItem item= getHighlightingColorListItem();
                    getPreferenceStore().setValue(item.getUnderlineKey(), fUnderlineCheckBox.getSelection());
                }
            });
                    
            fEnableCheckbox.addSelectionListener(new SelectionListener() {
                public void widgetDefaultSelected(SelectionEvent e) {
                    // do nothing
                }
                public void widgetSelected(SelectionEvent e) {
                    HighlightingColorListItem item= getHighlightingColorListItem();
   
                    boolean enable= fEnableCheckbox.getSelection();
                    getPreferenceStore().setValue( item.getEnableKey(), enable);
                    fEnableCheckbox.setSelection(enable);
                    fSyntaxForegroundColorEditor.getButton().setEnabled(enable);
                    fColorEditorLabel.setEnabled(enable);
                    fBoldCheckBox.setEnabled(enable);
                    fItalicCheckBox.setEnabled(enable);
                    fStrikethroughCheckBox.setEnabled(enable);
                    fUnderlineCheckBox.setEnabled(enable);
                    //uninstallSemanticHighlighting();
                    //installSemanticHighlighting();
                }
            });
            colorComposite.layout(false);
                    
            return colorComposite;
        }
        
        private void addFiller(Composite composite, int horizontalSpan) {
            PixelConverter pixelConverter= new PixelConverter(composite);
            Label filler= new Label(composite, SWT.LEFT );
            GridData gd= new GridData(GridData.HORIZONTAL_ALIGN_FILL);
            gd.horizontalSpan= horizontalSpan;
            gd.heightHint= pixelConverter.convertHeightInCharsToPixels(1) / 2;
            filler.setLayoutData(gd);
        }

        /**
         * Returns the current highlighting color list item.
         * 
         * @return the current highlighting color list item
         * @since 3.0
         */
        private HighlightingColorListItem getHighlightingColorListItem() {
            IStructuredSelection selection= (IStructuredSelection) fListViewer.getSelection();
            Object element= selection.getFirstElement();
            if (element instanceof String)
                return null;
            return (HighlightingColorListItem) element;
        }
       

	public SyntaxColoringPreferencePage() {
		super();
        
		Map<String, Object> extensionToFactoryMap = 
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		
        for(String extension : extensionToFactoryMap.keySet()) {
        	ResourceSet rs = new ResourceSetImpl();
        	Resource tempResource = rs.createResource(URI.createURI("temp." + extension));
        	
        	if (tempResource instanceof ITextResource) {
        		ITextResource tr = (ITextResource) tempResource;
        		
	            String languageId = extension;
	            
	            List<HighlightingColorListItem> terminals = new ArrayList<HighlightingColorListItem>();
	            String[] tokenNames = tr.getTokenNames();
	            
				for (int i = 0; i < tokenNames.length; i++) {
					if (!tokenHelper.canBeUsedForSyntaxColoring(i)) {
						continue;
					}
					
					String tokenName = tokenHelper.getTokenName(tokenNames, i);
	                String prefix = languageId + "_" + tokenName;
	                HighlightingColorListItem item = new HighlightingColorListItem(
	                        languageId,
	                        tokenName,
	                        prefix + COLOR,
	                        prefix + BOLD,
	                        prefix + ITALIC,
	                        prefix + STRIKETHROUGH,
	                        prefix + UNDERLINE,
	                        prefix + ENABLE);
	                terminals.add(item);
	            }
	            content.put(languageId.substring(languageId.lastIndexOf('.')+1), terminals);
        	}
        }
   
		setPreferenceStore(EMFTextRuntimeUIPlugin.getDefault().getPreferenceStore());
		setDescription("Define the syntax coloring for registered textual syntaxes.");
    }
    

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
		
	}


    @Override
    protected Control createContents(Composite parent) {
    	Control content = createSyntaxPage(parent);
    	return content;
    }
    
    public boolean performOk(){
    	if(!super.performOk())
    		return false;
    	updateActiveEditor();
		return true;
    }
    
    protected void performApply(){
    	updateActiveEditor();
    }
    
    private void updateActiveEditor(){
		IWorkbench workbench = org.eclipse.ui.PlatformUI.getWorkbench();		
		IEditorPart editor = workbench.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(editor!=null&&editor instanceof EMFTextEditor){
			EMFTextEditor emfTextEditor = (EMFTextEditor) editor;
			emfTextEditor.invalidateTextRepresentation();
		}
    }
	
}
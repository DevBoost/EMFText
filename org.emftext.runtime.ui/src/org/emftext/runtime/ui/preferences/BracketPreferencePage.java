package org.emftext.runtime.ui.preferences;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.ITextResourcePluginMetaInformation;
import org.emftext.runtime.ui.EMFTextRuntimeUIPlugin;
import org.emftext.runtime.ui.editor.EMFTextEditor;
import org.emftext.runtime.ui.extensions.BracketSet;

//TODO hoang-kim add documentation
public class BracketPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	private static final String[] ALL_LEFT_BRACKETS = new String[] {"{","(","[","<","\"","'",};
	private static final String[] ALL_RIGHT_BRACKETS = new String[] {"}",")","]",">","\"","'",};

	private String BRACKETS_COLOR = PreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR;
	
    private Set<String> languageIDs = new LinkedHashSet<String>();
    
    private ColorSelector matchingBracketsColorEditor;
    private Label colorEditorLabel;
    private Button enableCheckbox;
    private Button matchingBracketsColorButton;
    private Label languagesLabel;
    private Combo languagesCombo;
    private Label bracketTokensLabel;
    private Combo leftBracketTokensCombo;
    private Combo rightBracketTokensCombo;
    private List bracketsList;
    private Button addBracketButton;
    private Button removeBracketButton;
    private Map<String, String> bracketSetTemp = new HashMap<String, String>();
	private String language;
	
	private BracketSet bracketsTmp;
	
	public BracketPreferencePage() {
		super();

		for (ITextResourcePluginMetaInformation metaInformation : EMFTextRuntimePlugin.getConcreteSyntaxRegistry()) {
            String languageId = metaInformation.getSyntaxName();
            /*
            java.util.List<String> terminals = new ArrayList<String>();
            String[] tokenNames = metaInformation.getTokenNames();
            String bracket;
			for (String tokenName : tokenNames) {
				// TODO this is ANTLR specific
				if (tokenName.length() == 3 && tokenName.startsWith("'") && tokenName.endsWith("'")) {
					bracket = tokenName.substring(1, tokenName.length() - 1).trim();
					terminals.add(bracket);
				}
            }
			terminals.add("\"");
			terminals.add("\'");
			*/
			languageIDs.add(languageId);
        }
    }
	
	/*
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
		setPreferenceStore(EMFTextRuntimeUIPlugin.getDefault().getPreferenceStore());
		setDescription("Define the coloring of matching brackets.");
		
		bracketsTmp = new BracketSet(null, null, null);
		for (String languageID : languageIDs) {
			bracketSetTemp.put(languageID, getPreferenceStore().getString(languageID + PreferenceConstants.EDITOR_BRACKETS_SUFFIX));
		}
	}
	
    @Override
    protected Control createContents(Composite parent) {
    	
    	//outer Composite
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
        
        colorEditorLabel = new Label(settingComposite, SWT.LEFT);
        colorEditorLabel.setText("Color:"); 
        gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
        gd.horizontalIndent= 20;
        colorEditorLabel.setLayoutData(gd);
        
        matchingBracketsColorEditor = new ColorSelector(settingComposite);
        matchingBracketsColorButton = matchingBracketsColorEditor.getButton();
        gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
        matchingBracketsColorButton.setLayoutData(gd);
        
        Composite languageComposite = new Composite(settingComposite, SWT.NONE);
        layout = new GridLayout();
        layout.marginHeight= 0;
        layout.marginWidth= 0;
        layout.numColumns=2;
        gd = new GridData(GridData.BEGINNING);
        gd.horizontalSpan=2;
        gd.verticalIndent=30;
        languageComposite.setLayout(layout);
        languageComposite.setLayoutData(gd);
        
        languagesLabel = new Label(languageComposite,SWT.LEFT);
        gd = new GridData(GridData.BEGINNING);
        gd.horizontalAlignment=GridData.BEGINNING;
        languagesLabel.setLayoutData(gd);
        languagesLabel.setText("The available languages");
        
        languagesCombo = new Combo(languageComposite,SWT.DROP_DOWN | SWT.READ_ONLY|SWT.LEFT);
        gd = new GridData(GridData.BEGINNING);
        languagesCombo.setLayoutData(gd);
        
		Composite tokenSelectionComposite = new Composite(settingComposite, SWT.NONE);
        layout = new GridLayout();
        layout.numColumns= 3;
        layout.marginHeight= 0;
        layout.marginWidth= 0;
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan=2;
        gd.verticalIndent=20;
        tokenSelectionComposite.setLayout(layout);
        tokenSelectionComposite.setLayoutData(gd);
        
        bracketTokensLabel = new Label(tokenSelectionComposite,SWT.LEFT);
        gd = new GridData(GridData.BEGINNING);
        gd.horizontalSpan=3;
        bracketTokensLabel.setText("Select the desired bracket pair");
        bracketTokensLabel.setLayoutData(gd);
        
        leftBracketTokensCombo = new Combo(tokenSelectionComposite,SWT.DROP_DOWN | SWT.READ_ONLY);
        gd = new GridData(GridData.BEGINNING);
        leftBracketTokensCombo.setLayoutData(gd);
        
        rightBracketTokensCombo = new Combo(tokenSelectionComposite,SWT.DROP_DOWN | SWT.READ_ONLY);
        gd = new GridData(GridData.FILL);
        gd.horizontalSpan=2;
        rightBracketTokensCombo.setLayoutData(gd);
        
        bracketsList = new List(tokenSelectionComposite, SWT.MULTI);
        gd = new GridData(GridData.CENTER,GridData.FILL,false, true);
        gd.horizontalSpan=2;
        gd.verticalSpan=4;
        gd.widthHint=100;
        gd.heightHint=300;
        bracketsList.setLayoutData(gd);
        
        addBracketButton = new Button(tokenSelectionComposite,SWT.PUSH);
        addBracketButton.setText("Add");
        addBracketButton.setLayoutData(new GridData(GridData.CENTER,GridData.BEGINNING,false, false));
        
        removeBracketButton = new Button(tokenSelectionComposite,SWT.PUSH);
        removeBracketButton.setText("Remove");
        removeBracketButton.setLayoutData(new GridData(GridData.CENTER,GridData.BEGINNING,false, false));
        
        addListenersToStyleButtons();
        
        settingComposite.layout(false);
        handleMatchingBracketsSelection();
        return settingComposite;
    }
    
    /**
     * Initialize and handle the values of this preference page
     */
    private void handleMatchingBracketsSelection() {
    	// not for the case of none existing language
    	enableCheckbox.setSelection(getPreferenceStore().getBoolean(PreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX));
    	matchingBracketsColorButton.setEnabled(getPreferenceStore().getBoolean(PreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX));
    	RGB rgb = PreferenceConverter.getColor(getPreferenceStore(), BRACKETS_COLOR);
    	matchingBracketsColorEditor.setColorValue(rgb);
    	
    	String extension = null;
    	IWorkbench workbench = org.eclipse.ui.PlatformUI.getWorkbench();
		final IEditorPart activeEditor = workbench.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (activeEditor != null) {
			if (activeEditor instanceof EMFTextEditor) {
				EMFTextEditor emfTextEditor = (EMFTextEditor) activeEditor;
				ITextResource resource = (ITextResource) emfTextEditor.getResource();
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
	    		idx=0;
	    	}
		}
        language = languagesCombo.getItem(languagesCombo.getSelectionIndex());
        leftBracketTokensCombo.setItems(ALL_LEFT_BRACKETS);
        leftBracketTokensCombo.select(0);
        rightBracketTokensCombo.setItems(ALL_RIGHT_BRACKETS);
        rightBracketTokensCombo.select(0);
        bracketsTmp.setBrackets(getPreferenceStore().getString(language+PreferenceConstants.EDITOR_BRACKETS_SUFFIX));
        String[] brackets = bracketsTmp.getBracketStringArray();
        if (brackets != null) {
        	bracketsList.setItems(brackets);
        }
    }
    
    private void addListenersToStyleButtons() {
    	
    	matchingBracketsColorButton.addSelectionListener(new SelectionListener(){
    		public void widgetDefaultSelected(SelectionEvent e){
    		}
    		
    		public void widgetSelected(SelectionEvent e) {
            }
    	});
    	
    	enableCheckbox.addSelectionListener(new SelectionListener(){
    		public void widgetDefaultSelected(SelectionEvent e){
    		}
    		
    		public void widgetSelected(SelectionEvent e) {
    			matchingBracketsColorButton.setEnabled(enableCheckbox.getSelection());
            }
    	});
    	languagesCombo.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				bracketSetTemp.put(language, bracketsTmp.getBracketString());
				language = languagesCombo.getText();
				bracketsTmp.setBrackets(bracketSetTemp.get(language));
				leftBracketTokensCombo.setItems(ALL_LEFT_BRACKETS);
				leftBracketTokensCombo.select(0);
				rightBracketTokensCombo.setItems(ALL_RIGHT_BRACKETS);
				rightBracketTokensCombo.select(0);
				bracketsList.setItems(bracketsTmp.getBracketStringArray());
			}
    		
    	});
    	addBracketButton.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				String open=leftBracketTokensCombo.getText();
				String close=rightBracketTokensCombo.getText();
				if (bracketsTmp.isBracket(open)||bracketsTmp.isBracket(close)) {
					setErrorMessage("One or both bracket parts are set!");
				} else {
					bracketsTmp.addBracketPair(open, close);
					bracketsList.setItems(bracketsTmp.getBracketStringArray());
					setErrorMessage(null);
					bracketSetTemp.put(language, bracketsTmp.getBracketString());
				}
			}
    	});
    	
    	removeBracketButton.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				bracketsTmp.removeBracketPairs(bracketsList.getSelection());
				setErrorMessage(null);
				bracketsList.setItems(bracketsTmp.getBracketStringArray());
				bracketSetTemp.put(language, bracketsTmp.getBracketString());
			}
    	});
    }
    
    /**
     * Set the default values for this preference page.
     */
    protected void performDefaults() {
    	enableCheckbox.setSelection(getPreferenceStore().getDefaultBoolean(PreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX));
    	matchingBracketsColorButton.setEnabled(enableCheckbox.getSelection());
    	matchingBracketsColorEditor.setColorValue(PreferenceConverter.getDefaultColor(getPreferenceStore(), BRACKETS_COLOR));
    	//no reset for bracket set
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
    	//set the values after ok or apply 
        PreferenceConverter.setValue(getPreferenceStore(), BRACKETS_COLOR, matchingBracketsColorEditor.getColorValue());
    	boolean b = enableCheckbox.getSelection();
        getPreferenceStore().setValue(PreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, b);
        matchingBracketsColorButton.setEnabled(b);
        
        for (String languageID : languagesCombo.getItems()) {
        	getPreferenceStore().setValue(languageID+PreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSetTemp.get(languageID));
        }
        
        IWorkbench workbench = org.eclipse.ui.PlatformUI.getWorkbench();
        IEditorPart editor = workbench.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (editor != null && editor instanceof EMFTextEditor) {
			((EMFTextEditor) editor).invalidateTextRepresentation();
		}
    }
}

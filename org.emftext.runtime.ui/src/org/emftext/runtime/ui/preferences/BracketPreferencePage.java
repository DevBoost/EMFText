package org.emftext.runtime.ui.preferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.ui.EMFTextRuntimeUIPlugin;
import org.emftext.runtime.ui.editor.EMFTextEditor;
import org.emftext.runtime.ui.extensions.BracketSet;

//TODO mseifert: align this class with the EMFText coding style
public class BracketPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {


    private static final String BRACKETS_COLOR = PreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR;
    
    private static final Map<String,ArrayList<String>> content = new HashMap<String,ArrayList<String>>();
    
    private ColorSelector fMatchingBracketsColorEditor;
    private Label fColorEditorLabel;
    private Button fEnableCheckbox;
    private Button fMatchingBracketsColorButton;
    private Label fLanguagesLabel;
    private Combo fLanguagesCombo;
    private Label fBracketTokensLabel;
    private Combo fLeftBracketTokensCombo;
    private Combo fRightBracketTokensCombo;
    private List fBracketsList;
    private Button fAddBracketButton;
    private Button fRemoveBracketButton;
    private Map<String, String> bracketSetTemp=new HashMap<String, String>();
	private String language;
	
	private BracketSet bracketsTmp;
	
	public BracketPreferencePage(){
		super();
		Map<String, Object> extensionToFactoryMap = 
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		
        for(String extension : extensionToFactoryMap.keySet()) {
        	ResourceSet rs = new ResourceSetImpl();
        	Resource tempResource = rs.createResource(URI.createURI("temp." + extension));
        	
        	if (tempResource instanceof ITextResource) {
        		ITextResource tr = (ITextResource) tempResource;
        		
	            String languageId = extension;
	            
	            ArrayList<String> terminals = new ArrayList<String>();
	            String[] tokenNames = tr.getMetaInformation().getTokenNames();
	            String bracket;
				for (String tokenName:tokenNames){
					if (tokenName.length()==3&&tokenName.startsWith("'")&&tokenName.endsWith("'")){
						bracket=tokenName.substring(1, tokenName.length() - 1).trim();
						terminals.add(bracket);
					}
	            }
				terminals.add("\"");
				terminals.add("\'");
	            content.put(languageId.substring(languageId.lastIndexOf('.')+1), terminals);
	        }
        }
        
        
    }
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
		setPreferenceStore(EMFTextRuntimeUIPlugin.getDefault().getPreferenceStore());
		setDescription("Define the coloring of matching brackets.");
		
		bracketsTmp=new BracketSet(null, null);
		for (String languageID:content.keySet().toArray(new String[0])){
			bracketSetTemp.put(languageID, getPreferenceStore().getString(languageID+PreferenceConstants.EDITOR_BRACKETS_SUFFIX));
		}
        

	}
    @Override
    protected Control createContents(Composite parent) {
    	
    	//outer Composite
        Composite settingComposite = new Composite(parent, SWT.NONE);
        GridLayout layout= new GridLayout();
        GridData gd;
        layout.numColumns= 2;
        layout.marginHeight= 0;
        layout.marginWidth= 0;
        gd=new GridData(GridData.BEGINNING);
        settingComposite.setLayout(layout);
        settingComposite.setLayoutData(gd);
    
        fEnableCheckbox= new Button(settingComposite, SWT.CHECK);
        fEnableCheckbox.setText("Enable");
        gd= new GridData(GridData.BEGINNING);
        gd.horizontalAlignment= GridData.BEGINNING;
        gd.horizontalSpan= 2;
        fEnableCheckbox.setLayoutData(gd);
        
        fColorEditorLabel= new Label(settingComposite, SWT.LEFT);
        fColorEditorLabel.setText("Color:"); 
        gd= new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
        gd.horizontalIndent= 20;
        fColorEditorLabel.setLayoutData(gd);
        
        fMatchingBracketsColorEditor = new ColorSelector(settingComposite);
        fMatchingBracketsColorButton= fMatchingBracketsColorEditor.getButton();
        gd= new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
        fMatchingBracketsColorButton.setLayoutData(gd);
        
        Composite languageComposite = new Composite(settingComposite, SWT.NONE);
        layout= new GridLayout();
        layout.marginHeight= 0;
        layout.marginWidth= 0;
        layout.numColumns=2;
        gd= new GridData(GridData.BEGINNING);
        gd.horizontalSpan=2;
        gd.verticalIndent=30;
        languageComposite.setLayout(layout);
        languageComposite.setLayoutData(gd);
        
        fLanguagesLabel=new Label(languageComposite,SWT.LEFT);
        gd= new GridData(GridData.BEGINNING);
        gd.horizontalAlignment=GridData.BEGINNING;
        fLanguagesLabel.setLayoutData(gd);
        fLanguagesLabel.setText("The available languages");
        
        fLanguagesCombo=new Combo(languageComposite,SWT.DROP_DOWN | SWT.READ_ONLY|SWT.LEFT);
        gd = new GridData(GridData.BEGINNING);
        fLanguagesCombo.setLayoutData(gd);
        
		Composite tokenSelectionComposite = new Composite(settingComposite, SWT.NONE);
        layout= new GridLayout();
        layout.numColumns= 3;
        layout.marginHeight= 0;
        layout.marginWidth= 0;
        gd= new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan=2;
        gd.verticalIndent=20;
        tokenSelectionComposite.setLayout(layout);
        tokenSelectionComposite.setLayoutData(gd);
        
        fBracketTokensLabel=new Label(tokenSelectionComposite,SWT.LEFT);
        gd = new GridData(GridData.BEGINNING);
        gd.horizontalSpan=3;
        fBracketTokensLabel.setText("Select the desired bracket pair");
        fBracketTokensLabel.setLayoutData(gd);
        
        fLeftBracketTokensCombo=new Combo(tokenSelectionComposite,SWT.DROP_DOWN | SWT.READ_ONLY);
        gd = new GridData(GridData.BEGINNING);
        fLeftBracketTokensCombo.setLayoutData(gd);
        
        fRightBracketTokensCombo=new Combo(tokenSelectionComposite,SWT.DROP_DOWN | SWT.READ_ONLY);
        gd = new GridData(GridData.FILL);
        gd.horizontalSpan=2;
        fRightBracketTokensCombo.setLayoutData(gd);
        
        fBracketsList =  new List(tokenSelectionComposite, SWT.MULTI);
        gd = new GridData(GridData.CENTER,GridData.FILL,false, true);
        gd.horizontalSpan=2;
        gd.verticalSpan=4;
        gd.widthHint=100;
        gd.heightHint=300;
        fBracketsList.setLayoutData(gd);
        
        fAddBracketButton=new Button(tokenSelectionComposite,SWT.PUSH);
        fAddBracketButton.setText("Add");
        fAddBracketButton.setLayoutData(new GridData(GridData.CENTER,GridData.BEGINNING,false, false));
        
        fRemoveBracketButton=new Button(tokenSelectionComposite,SWT.PUSH);
        fRemoveBracketButton.setText("Remove");
        fRemoveBracketButton.setLayoutData(new GridData(GridData.CENTER,GridData.BEGINNING,false, false));
        
        addListenersToStyleButtons();
        
        settingComposite.layout(false);
        handleMatchingBracketsSelection();
        return settingComposite;
    }
    /**
     * Initiate and handle the values of this preference page
     */
    private void handleMatchingBracketsSelection(){
    	// not for the case of none existing language
    	fEnableCheckbox.setSelection(getPreferenceStore().getBoolean(PreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX));
    	fMatchingBracketsColorButton.setEnabled(getPreferenceStore().getBoolean(PreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX));
    	RGB rgb= PreferenceConverter.getColor(getPreferenceStore(), BRACKETS_COLOR);
    	fMatchingBracketsColorEditor.setColorValue(rgb);
    	
    	IWorkbench workbench = org.eclipse.ui.PlatformUI.getWorkbench();
		String extension = workbench.getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor().getEditorInput().getName();
		extension = extension.substring(extension.lastIndexOf(".") + 1);
    	fLanguagesCombo.setItems((content.keySet().toArray(new String[0])));
    	int idx=fLanguagesCombo.indexOf(extension);
    	if (idx>-1)
    		fLanguagesCombo.select(idx);
    	else {
    		fLanguagesCombo.select(0);
    		idx=0;
    	}
        language=fLanguagesCombo.getItem(idx);
        String [] strA=content.get(language).toArray(new String[0]);
        fLeftBracketTokensCombo.setItems(strA);
        fLeftBracketTokensCombo.select(0);
        fRightBracketTokensCombo.setItems(strA);
        fRightBracketTokensCombo.select(0);
        bracketsTmp.setBrackets(getPreferenceStore().getString(language+PreferenceConstants.EDITOR_BRACKETS_SUFFIX));
        String[] brackets = bracketsTmp.getBracketStringArray();
        if (brackets!=null)
        	fBracketsList.setItems(brackets);
    }
    
    private void addListenersToStyleButtons() {
    	
    	fMatchingBracketsColorButton.addSelectionListener(new SelectionListener(){
    		public void widgetDefaultSelected(SelectionEvent e){
    			
    		}
    		public void widgetSelected(SelectionEvent e) {
            }
    	});
    	
    	fEnableCheckbox.addSelectionListener(new SelectionListener(){
    		public void widgetDefaultSelected(SelectionEvent e){
    			
    		}
    		public void widgetSelected(SelectionEvent e) {
    			fMatchingBracketsColorButton.setEnabled(fEnableCheckbox.getSelection());
            }
    	});
    	fLanguagesCombo.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
				
			}

			public void widgetSelected(SelectionEvent e) {
				bracketSetTemp.put(language, bracketsTmp.getBracketString());
				language=fLanguagesCombo.getText();
				bracketsTmp.setBrackets(bracketSetTemp.get(language));
				fLeftBracketTokensCombo.setItems(content.get(language).toArray(new String[0]));
				fLeftBracketTokensCombo.select(0);
				fRightBracketTokensCombo.setItems(content.get(language).toArray(new String[0]));
				fRightBracketTokensCombo.select(0);
				fBracketsList.setItems(bracketsTmp.getBracketStringArray());
			}
    		
    	});
    	fAddBracketButton.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				String open=fLeftBracketTokensCombo.getText();
				String close=fRightBracketTokensCombo.getText();
				if (bracketsTmp.isBracket(open)||bracketsTmp.isBracket(close))
					setErrorMessage("One or both bracket parts are set!");
				else{
					bracketsTmp.addBracketPair(open, close);
					fBracketsList.setItems(bracketsTmp.getBracketStringArray());
					setErrorMessage(null);
					bracketSetTemp.put(language, bracketsTmp.getBracketString());
				}
			}
    	});
    	
    	fRemoveBracketButton.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				bracketsTmp.removeBracketPairs(fBracketsList.getSelection());
				setErrorMessage(null);
				fBracketsList.setItems(bracketsTmp.getBracketStringArray());
				bracketSetTemp.put(language, bracketsTmp.getBracketString());
			}
    	});
    	
    	
    }
    
    /**
     * Set the default values for this preference page.
     */
   
    protected void performDefaults() {
    	fEnableCheckbox.setSelection(getPreferenceStore().getDefaultBoolean(PreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX));
    	fMatchingBracketsColorButton.setEnabled(fEnableCheckbox.getSelection());
    	fMatchingBracketsColorEditor.setColorValue(PreferenceConverter.getDefaultColor(getPreferenceStore(), BRACKETS_COLOR));
    	//no reset for bracket set
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
    	//set the values after ok or apply 
        PreferenceConverter.setValue(getPreferenceStore(), BRACKETS_COLOR, fMatchingBracketsColorEditor.getColorValue());
    	boolean b=fEnableCheckbox.getSelection();
        getPreferenceStore().setValue(PreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, b);
        fMatchingBracketsColorButton.setEnabled(b);
        
        for (String languageID:fLanguagesCombo.getItems()){
        	getPreferenceStore().setValue(languageID+PreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSetTemp.get(languageID));
        }
        
        IWorkbench workbench = org.eclipse.ui.PlatformUI.getWorkbench();
        IEditorPart editor = workbench.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(editor!=null&&editor instanceof EMFTextEditor){
			((EMFTextEditor) editor).invalidateTextRepresentation();
		}
    }
    


}

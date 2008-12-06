package org.emftext.sdk.ui.preferences;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.emftext.sdk.codegen.ResourcePackageGenerator;
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

		BooleanFieldEditor genTestAction = new BooleanFieldEditor(EMFTextSDKUIPlugin.GENERATE_TEST_ACTION_NAME, "&Contribute Test Action",BooleanFieldEditor.DEFAULT, platformGeneratorGroup);
		BooleanFieldEditor ovrPluginConfig = new BooleanFieldEditor(EMFTextSDKUIPlugin.OVERRIDE_PLUGIN_CONFIG_NAME, "&Allways Override 'plugin.xml' and 'MANIFEST.MF'",BooleanFieldEditor.DEFAULT, platformGeneratorGroup);
		BooleanFieldEditor genGenModel = new BooleanFieldEditor(EMFTextSDKUIPlugin.GENERATE_GEN_MODEL, "&Auto-generate GenModel from Ecore",BooleanFieldEditor.DEFAULT, platformGeneratorGroup);

		
		addField(genTestAction);
		addField(ovrPluginConfig);
		addField(genGenModel);
		
		Group generatorGroup = new Group(parent,SWT.NONE);
		
		generatorGroup.setText("General generator settings");
		generatorGroup.setLayoutData(new GridData((GridData.GRAB_HORIZONTAL|GridData.FILL_HORIZONTAL)));

		
		BooleanFieldEditor ovrAntlrSpec = new BooleanFieldEditor(ResourcePackageGenerator.OVERRIDE_ANTLR_SPEC_NAME, "&Allways Override ANTLR Grammar",BooleanFieldEditor.DEFAULT, generatorGroup);
		BooleanFieldEditor ovrReferenceResolvers = new BooleanFieldEditor(ResourcePackageGenerator.OVERRIDE_PROXY_RESOLVERS_NAME, "&Allways Override Proxy Resolvers",BooleanFieldEditor.DEFAULT, generatorGroup);
		BooleanFieldEditor ovrTreeAnalyser = new BooleanFieldEditor(ResourcePackageGenerator.OVERRIDE_TREE_ANALYSER_NAME, "&Allways Override Tree Analyser",BooleanFieldEditor.DEFAULT, generatorGroup);
		BooleanFieldEditor ovrTokenResolvers = new BooleanFieldEditor(ResourcePackageGenerator.OVERRIDE_TOKEN_RESOLVERS_NAME, "&Allways Override Token Resolvers",BooleanFieldEditor.DEFAULT, generatorGroup);
		BooleanFieldEditor ovrTokenResolverFactory = new BooleanFieldEditor(ResourcePackageGenerator.OVERRIDE_TOKEN_RESOLVER_FACTORY_NAME, "&Allways Override Token Resolver Factory",BooleanFieldEditor.DEFAULT, generatorGroup);
		BooleanFieldEditor genPrinterStubOnly = new BooleanFieldEditor(ResourcePackageGenerator.GENERATE_PRINTER_STUB_ONLY_NAME, "&Generate Printer Stub Only",BooleanFieldEditor.DEFAULT, generatorGroup);
		BooleanFieldEditor ovrPrinter = new BooleanFieldEditor(ResourcePackageGenerator.OVERRIDE_PRINTER_NAME, "&Allways Override Printer",BooleanFieldEditor.DEFAULT, generatorGroup);

		addField(ovrAntlrSpec);
		addField(ovrReferenceResolvers);
		addField(ovrTreeAnalyser);
		addField(ovrTokenResolvers);
		addField(ovrTokenResolverFactory);
		addField(genPrinterStubOnly);
		addField(ovrPrinter);
		
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

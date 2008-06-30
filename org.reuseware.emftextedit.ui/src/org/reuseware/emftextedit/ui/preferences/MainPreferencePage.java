package org.reuseware.emftextedit.ui.preferences;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.reuseware.emftextedit.ui.EMFTextEditUIPlugin;
import org.reuseware.emftextedit.codegen.ResourcePackageGenerator;

public class MainPreferencePage extends FieldEditorPreferencePage implements
        IWorkbenchPreferencePage {
	
	
	public MainPreferencePage(){
		super(FieldEditorPreferencePage.FLAT);
		setPreferenceStore(EMFTextEditUIPlugin.getDefault().getPreferenceStore());
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
		Group generatorGroup = new Group(parent,SWT.NONE);
	
		generatorGroup.setText("Generator settings");
		generatorGroup.setLayoutData(new GridData((GridData.GRAB_HORIZONTAL|GridData.FILL_HORIZONTAL)));
		
		BooleanFieldEditor genTestAction = new BooleanFieldEditor(EMFTextEditUIPlugin.GENERATE_TEST_ACTION_NAME, "&Contribute Test Action",BooleanFieldEditor.DEFAULT, generatorGroup);
		BooleanFieldEditor ovrPluginConfig = new BooleanFieldEditor(EMFTextEditUIPlugin.OVERRIDE_PLUGIN_CONFIG_NAME, "&Allways Override 'plugin.xml' and 'MANIFEST.MF'",BooleanFieldEditor.DEFAULT, generatorGroup);
		BooleanFieldEditor ovrAntlrSpec = new BooleanFieldEditor(ResourcePackageGenerator.OVERRIDE_ANTLR_SPEC_NAME, "&Allways Override ANTLR grammar",BooleanFieldEditor.DEFAULT, generatorGroup);
		BooleanFieldEditor ovrProxyResolvers = new BooleanFieldEditor(ResourcePackageGenerator.OVERRIDE_PROXY_RESOLVERS_NAME, "&Allways Override Proxy Resolvers",BooleanFieldEditor.DEFAULT, generatorGroup);
		BooleanFieldEditor ovrTreeAnalyser = new BooleanFieldEditor(ResourcePackageGenerator.OVERRIDE_TREE_ANALYSER_NAME, "&Allways Override Tree Analyser",BooleanFieldEditor.DEFAULT, generatorGroup);
		BooleanFieldEditor ovrTokenResolvers = new BooleanFieldEditor(ResourcePackageGenerator.OVERRIDE_TOKEN_RESOLVERS_NAME, "&Allways Override Token Resolvers",BooleanFieldEditor.DEFAULT, generatorGroup);
		BooleanFieldEditor ovrTokenResolverFactory = new BooleanFieldEditor(ResourcePackageGenerator.OVERRIDE_TOKEN_RESOLVER_FACTORY_NAME, "&Allways Override Token Resolver Factory",BooleanFieldEditor.DEFAULT, generatorGroup);
		BooleanFieldEditor genPrinterStubOnly = new BooleanFieldEditor(ResourcePackageGenerator.GENERATE_PRINTER_STUB_ONLY_NAME, "&Generate Printer Stub Only",BooleanFieldEditor.DEFAULT, generatorGroup);
		BooleanFieldEditor ovrPrinter = new BooleanFieldEditor(ResourcePackageGenerator.OVERRIDE_PRINTER_NAME, "&Allways Override Printer",BooleanFieldEditor.DEFAULT, generatorGroup);
	
		addField(genTestAction);
		addField(ovrPluginConfig);
		addField(ovrAntlrSpec);
		addField(ovrProxyResolvers);
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
	}
	
	protected void performDefaults() {
		 super.performDefaults();
	}

}

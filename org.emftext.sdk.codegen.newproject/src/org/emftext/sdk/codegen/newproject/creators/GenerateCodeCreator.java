package org.emftext.sdk.codegen.newproject.creators;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.newproject.NewProjectGenerationContext;
import org.emftext.sdk.codegen.util.GenModelUtil;

/**
 * This creator call the EMF code generation to obtain the EMF model code using
 * a generator model.
 */
public class GenerateCodeCreator implements IArtifactCreator<NewProjectGenerationContext> {

	public GenerateCodeCreator() {
		super();
	}

	public void createArtifacts(IPluginDescriptor plugin, NewProjectGenerationContext context) {
		new GenModelUtil().generateMetaModelCode(context.getGenPackage(), context.getMonitor());
	}

	public String getArtifactTypeDescription() {
		return "metamodel code";
	}
}

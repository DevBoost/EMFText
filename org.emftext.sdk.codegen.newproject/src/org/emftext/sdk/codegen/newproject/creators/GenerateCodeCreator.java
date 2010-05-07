package org.emftext.sdk.codegen.newproject.creators;

import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.newproject.NewProjectGenerationContext;
import org.emftext.sdk.codegen.util.GenModelUtil;

public class GenerateCodeCreator implements
		IArtifactCreator<NewProjectGenerationContext> {

	public void createArtifacts(NewProjectGenerationContext context) {
		new GenModelUtil().generateMetaModelCode(context.getGenPackage(), context.getMonitor());
	}

	public String getArtifactDescription() {
		return "metamodel code";
	}
}

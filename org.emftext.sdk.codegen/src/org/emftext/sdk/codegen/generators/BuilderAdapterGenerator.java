package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INCREMENTAL_PROJECT_BUILDER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_FILE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_PROJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_RESOURCE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_RESOURCE_DELTA;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_RESOURCE_DELTA_VISITOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCE_SET_IMPL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.URI;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;

public class BuilderAdapterGenerator extends JavaBaseGenerator {

	private String iBuilderClassName;
	private String builderClassName;
	private String textResourceClassName;

	public BuilderAdapterGenerator() {
		super();
	}

	private BuilderAdapterGenerator(GenerationContext context) {
		super(context, EArtifact.BUILDER_ADAPTER);
		iBuilderClassName = getContext().getQualifiedClassName(EArtifact.I_BUILDER);
		builderClassName = getContext().getQualifiedClassName(EArtifact.BUILDER);
		textResourceClassName = getContext().getQualifiedClassName(EArtifact.RESOURCE);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new BuilderAdapterGenerator(context);
	}


	@Override
	public boolean generateJavaContents(StringComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + INCREMENTAL_PROJECT_BUILDER + " {");
		sc.addLineBreak();
		sc.add("public final static String BUILDER_ID = \"" + getContext().getBuilderID() + "\";");
		sc.addLineBreak();
		sc.add("private " + iBuilderClassName + " builder = new " + builderClassName + "();");
		sc.addLineBreak();
		addBuildMethod(sc);
		sc.add("}");
		
		return true;
	}

	private void addBuildMethod(StringComposite sc) {
		sc.add("public " + I_PROJECT + "[] build(int kind, " + MAP + " args, final " + I_PROGRESS_MONITOR + " monitor) throws " + CORE_EXCEPTION + " {");
		sc.add("return build(kind, args, monitor, builder);");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public " + I_PROJECT + "[] build(int kind, " + MAP + " args, final " + I_PROGRESS_MONITOR + " monitor, final " + iBuilderClassName + " builder) throws " + CORE_EXCEPTION + " {");
		sc.add(I_PROJECT + " project = this.getProject();");
		sc.add(I_RESOURCE_DELTA + " delta = getDelta(project);");
		sc.add("if (delta == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("delta.accept(new " + I_RESOURCE_DELTA_VISITOR + "() {");
		sc.add("public boolean visit(" + I_RESOURCE_DELTA + " delta) throws " + CORE_EXCEPTION + " {");
		sc.add(I_RESOURCE + " resource = delta.getResource();");
		sc.add("if (resource instanceof " + I_FILE + " && \"" + getContext().getConcreteSyntax().getName() + "\".equals(resource.getFileExtension())) {");
		sc.add(URI + " uri = " + URI + ".createPlatformResourceURI(resource.getFullPath().toString(), true);");
		sc.add("if (builder.isBuildingNeeded(uri)) {");
		sc.add(textResourceClassName + " customResource = (" + textResourceClassName + ") new " + RESOURCE_SET_IMPL + "().getResource(uri, true);");
		sc.add("builder.build(customResource, monitor);");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.add("});");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}
}

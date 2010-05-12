package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INCREMENTAL_PROJECT_BUILDER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_FILE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_PROJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_RESOURCE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_RESOURCE_DELTA;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_RESOURCE_DELTA_VISITOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCE_SET_IMPL;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.URI;

import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.util.NameUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

public class BuilderAdapterGenerator extends JavaBaseGenerator<Object> {

	private final NameUtil nameUtil = new NameUtil();

	public BuilderAdapterGenerator() {
		super();
	}

	private BuilderAdapterGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.BUILDER_ADAPTER);
	}

	public IGenerator<GenerationContext, Object> newInstance(GenerationContext context, Object parameters) {
		return new BuilderAdapterGenerator(context);
	}


	@Override
	public boolean generateJavaContents(JavaComposite sc) {
		ConcreteSyntax syntax = context.getConcreteSyntax();

		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + INCREMENTAL_PROJECT_BUILDER + " {");
		sc.addLineBreak();
		sc.addJavadoc("the ID of the default, generated builder");
		sc.add("public final static String BUILDER_ID = \"" + nameUtil.getBuilderID(syntax) + "\";");
		sc.addLineBreak();
		sc.add("private " + iBuilderClassName + " builder = new " + builderClassName + "();");
		sc.addLineBreak();
		addBuildMethod1(sc);
		addBuildMethod2(sc);
		sc.add("}");
		
		return true;
	}

	private void addBuildMethod1(StringComposite sc) {
		sc.add("@SuppressWarnings(\"unchecked\")").addLineBreak();
		sc.add("public " + I_PROJECT + "[] build(int kind, " + MAP + " args, final " + I_PROGRESS_MONITOR + " monitor) throws " + CORE_EXCEPTION + " {");
		sc.add("return build(kind, args, monitor, builder, getProject());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addBuildMethod2(StringComposite sc) {
		sc.add("public " + I_PROJECT + "[] build(int kind, " + MAP + "<?,?> args, final " + I_PROGRESS_MONITOR + " monitor, final " + iBuilderClassName + " builder, " + I_PROJECT + " project) throws " + CORE_EXCEPTION + " {");
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
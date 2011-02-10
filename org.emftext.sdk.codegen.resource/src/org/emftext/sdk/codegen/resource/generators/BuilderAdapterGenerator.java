/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
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

import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.util.NameUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

@SyntaxDependent
public class BuilderAdapterGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private final NameUtil nameUtil = new NameUtil();

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + INCREMENTAL_PROJECT_BUILDER + " {");
		sc.addLineBreak();
		addFields(sc);
		addBuildMethod1(sc);
		addBuildMethod2(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		String builderID = nameUtil.getBuilderID(syntax);

		sc.addJavadoc("the ID of the default, generated builder");
		sc.add("public final static String BUILDER_ID = \"" + builderID + "\";");
		sc.addLineBreak();
		sc.add("private " + iBuilderClassName + " builder = new " + builderClassName + "();");
		sc.addLineBreak();
	}

	private void addBuildMethod1(StringComposite sc) {
		sc.add("public " + I_PROJECT + "[] build(int kind, @SuppressWarnings(\"rawtypes\") " + MAP + " args, final " + I_PROGRESS_MONITOR + " monitor) throws " + CORE_EXCEPTION + " {");
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
		sc.add("if (delta.getKind() == " + I_RESOURCE_DELTA + ".REMOVED) {");
		sc.add("return false;");
		sc.add("}");
		sc.add(I_RESOURCE + " resource = delta.getResource();");
		sc.add("if (resource instanceof " + I_FILE + " && resource.getName().endsWith(\".\" + \"" + getContext().getConcreteSyntax().getName() + "\")) {");
		sc.add(URI + " uri = " + URI + ".createPlatformResourceURI(resource.getFullPath().toString(), true);");
		sc.add("if (builder.isBuildingNeeded(uri)) {");
		sc.add(textResourceClassName + " customResource = (" + textResourceClassName + ") new " + RESOURCE_SET_IMPL + "().getResource(uri, true);");
    	sc.add(markerHelperClassName + ".unmark(customResource, " + eProblemTypeClassName + ".BUILDER_ERROR);");
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

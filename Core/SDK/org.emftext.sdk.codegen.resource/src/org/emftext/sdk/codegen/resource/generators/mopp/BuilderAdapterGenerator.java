/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.resource.generators.mopp;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INCREMENTAL_PROJECT_BUILDER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_FILE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_PROJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_RESOURCE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_RESOURCE_DELTA;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_RESOURCE_DELTA_VISITOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_RESOURCE_VISITOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCE_SET;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCE_SET_IMPL;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.URI;

import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.codegen.util.NameUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;

@SyntaxDependent
public class BuilderAdapterGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private final NameUtil nameUtil = new NameUtil();

	@Override
	public void generateJavaContents(JavaComposite sc) {
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		OptionManager optionManager = OptionManager.INSTANCE;
		boolean removeEclipseDependentCode = optionManager.getBooleanOptionValue(syntax, OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE);
		boolean disableBuilder = optionManager.getBooleanOptionValue(syntax, OptionTypes.DISABLE_BUILDER);

		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		String extendsClause = removeEclipseDependentCode ? "" : " extends " + INCREMENTAL_PROJECT_BUILDER + " implements " + I_RESOURCE_DELTA_VISITOR + ", " + I_RESOURCE_VISITOR;
		sc.add("public class " + getResourceClassName() + extendsClause + " {");
		sc.addLineBreak();

		if (!removeEclipseDependentCode) {
			addFields(sc);
			addMethods(sc, disableBuilder);
		} else {
			sc.addComment("This class is empty because option '" + OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE.getLiteral() + "' is set to true.");
		}
		sc.add("}");
	}

	private void addMethods(JavaComposite sc, boolean disableBuilder) {
		addBuildMethod1(sc);
		addBuildMethod2(sc);
		addGetBuilderMethod(sc);
		addGetBuilderMarkerIdMethod(sc);
		addRunTaskItemBuilderMethod(sc);
		addVisitMethod1(sc);
		addVisitMethod2(sc);
		addDoVisitMethod(sc, disableBuilder);
	}

	private void addFields(JavaComposite sc) {
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		String builderID = nameUtil.getBuilderID(syntax);

		sc.addJavadoc("The ID of the default, generated builder.");
		sc.add("public final static String BUILDER_ID = \"" + builderID + "\";");
		sc.addLineBreak();
		sc.add("private " + iBuilderClassName + " defaultBuilder = new " + builderClassName + "();");
		sc.addLineBreak();
		sc.addJavadoc("This resource set is used during the whole build.");
		sc.add("private " + RESOURCE_SET + " resourceSet;");
		sc.addLineBreak();
		sc.addJavadoc("This monitor is used during the build.");
		sc.add("private " + I_PROGRESS_MONITOR + " monitor;");
		sc.addLineBreak();
	}

	private void addBuildMethod1(JavaComposite sc) {
		sc.add("public " + I_PROJECT + "[] build(int kind, " + MAP + "<String, String> args, final " + I_PROGRESS_MONITOR + " monitor) throws " + CORE_EXCEPTION + " {");
		sc.addComment("Set context for build");
		sc.add("this.monitor = monitor;");
		sc.add("this.resourceSet = new " + RESOURCE_SET_IMPL + "();");
		sc.addComment("Perform build by calling the resource visitors");
		sc.add(I_RESOURCE_DELTA + " delta = getDelta(getProject());");
		sc.add("if (delta != null) {");
		sc.addComment("This is an incremental build");
		sc.add("delta.accept(this);");
		sc.add("} else {");
		sc.addComment("This is a full build");
		sc.add("getProject().accept(this);");
		sc.add("}");
		sc.addComment("Reset build context");
		sc.add("this.resourceSet = null;");
		sc.add("this.monitor = null;");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addVisitMethod1(JavaComposite sc) {
		sc.add("@Override").addLineBreak();
		sc.add("public boolean visit(" + I_RESOURCE_DELTA + " delta) throws " + CORE_EXCEPTION + " {");
		sc.add(I_RESOURCE + " resource = delta.getResource();");
		sc.add("return doVisit(resource, delta.getKind() == " + I_RESOURCE_DELTA + ".REMOVED);");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addVisitMethod2(JavaComposite sc) {
		sc.add("@Override").addLineBreak();
		sc.add("public boolean visit(" + I_RESOURCE + " resource) throws " + CORE_EXCEPTION + " {");
		sc.add("return doVisit(resource, false);");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addDoVisitMethod(JavaComposite sc, boolean disableBuilder) {
		sc.add("protected boolean doVisit(" + I_RESOURCE + " resource, boolean removed) throws " + CORE_EXCEPTION + " {");
		sc.add("if (removed) {");
		sc.add(URI + " uri = " + URI + ".createPlatformResourceURI(resource.getFullPath().toString(), true);");
		sc.add(iBuilderClassName + " builder = getBuilder();");
		sc.add("if (builder.isBuildingNeeded(uri)) {");
		sc.add("builder.handleDeletion(uri, monitor);");
		sc.add("}");
    	sc.add("new " + markerHelperClassName + "().removeAllMarkers(resource, getBuilderMarkerId());");
		sc.add("return false;");
		sc.add("}");
		sc.add("if (resource instanceof " + I_FILE + " && resource.getName().endsWith(\".\" + new " + metaInformationClassName + "().getSyntaxName())) {");
		if (disableBuilder) {
			sc.addComment(
					"Calling the default generated builder is disabled because of " +
					"syntax option '" + OptionTypes.DISABLE_BUILDER.getLiteral() + "'.");
		} else {
			sc.addComment(
					"First, call the default generated builder that is usually " +
					"customized to add compilation-like behavior.");
			sc.add("build((" + I_FILE + ") resource, resourceSet, monitor);");
		}
		sc.addComment(
				"Second, call the task item builder that searches " +
				"for task items in DSL documents and creates task markers.");
		sc.add("runTaskItemBuilder((" + I_FILE + ") resource, resourceSet, monitor);");
		sc.add("return false;");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addBuildMethod2(JavaComposite sc) {
		sc.add("public void build(" + I_FILE + " resource, " + RESOURCE_SET + " resourceSet, " + I_PROGRESS_MONITOR + " monitor) {");
		sc.add(URI + " uri = " + URI + ".createPlatformResourceURI(resource.getFullPath().toString(), true);");
		sc.add(iBuilderClassName + " builder = getBuilder();");
		sc.add("if (builder.isBuildingNeeded(uri)) {");
		sc.add(textResourceClassName + " customResource = (" + textResourceClassName + ") resourceSet.getResource(uri, true);");
		sc.add("new " + markerHelperClassName + "().removeAllMarkers(resource, getBuilderMarkerId());");
		sc.add("builder.build(customResource, monitor);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRunTaskItemBuilderMethod(JavaComposite sc) {
		sc.addJavadoc("Runs the task item builder to search for new task items in changed resources.");
		sc.add("public void runTaskItemBuilder(" + I_FILE + " resource, " + RESOURCE_SET + " resourceSet, " + I_PROGRESS_MONITOR + " monitor) {");
		sc.add(taskItemBuilderClassName + " taskItemBuilder = new " + taskItemBuilderClassName + "();");
		sc.add("new " + markerHelperClassName + "().removeAllMarkers(resource, taskItemBuilder.getBuilderMarkerId());");
		sc.add("taskItemBuilder.build(resource, resourceSet, monitor);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetBuilderMarkerIdMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns the id for the markers that are created by this " +
			"builder. This allows subclasses to produce different kinds of markers."
		);
		sc.add("public String getBuilderMarkerId() {");
		sc.add("return new " + markerHelperClassName + "().getMarkerID(" + eProblemTypeClassName + ".BUILDER_ERROR);");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addGetBuilderMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns the builder that shall be used by this adapter. " +
			"This allows subclasses to perform builds with different builders."
		);
		sc.add("public " + iBuilderClassName + " getBuilder() {");
		sc.add("return defaultBuilder;");
		sc.add("}");
		sc.addLineBreak();
	}
}

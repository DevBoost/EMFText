/*******************************************************************************
 * Copyright (c) 2006-2014
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

import static de.devboost.codecomposers.java.ClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.INCREMENTAL_PROJECT_BUILDER;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_FILE;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_PROJECT;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_RESOURCE;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_RESOURCE_DELTA;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_RESOURCE_DELTA_VISITOR;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_RESOURCE_VISITOR;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.RESOURCE_SET;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.RESOURCE_SET_IMPL;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.URI;

import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.codegen.resource.generators.ResourceBundleGenerator;
import org.emftext.sdk.codegen.util.NameUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;

import de.devboost.codecomposers.java.JavaComposite;

@SyntaxDependent
public class BuilderAdapterGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private final NameUtil nameUtil = new NameUtil();

	@Override
	public void generateJavaContents(JavaComposite sc) {
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		OptionManager optionManager = OptionManager.INSTANCE;
		boolean removeEclipseDependentCode = optionManager.getBooleanOptionValue(syntax, OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE);
		boolean disableBuilder = optionManager.getBooleanOptionValue(syntax, OptionTypes.DISABLE_BUILDER);

		sc.add("package " + getResourcePackageName() + ";")
		;sc.addLineBreak();
		sc.addImportsPlaceholder();
		sc.addLineBreak();
		String extendsClause = removeEclipseDependentCode ? "" : " extends " + INCREMENTAL_PROJECT_BUILDER(sc);
		sc.add("public class " + getResourceClassName() + extendsClause + " {");
		sc.addLineBreak();

		if (!removeEclipseDependentCode) {
			addInnerClassResourceCollector(sc);
			addFields(sc);
			addMethods(sc, disableBuilder);
		} else {
			sc.addComment("This class is empty because option '" + OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE.getLiteral() + "' is set to true.");
		}
		sc.add("}");
	}
	
	private void addInnerClassResourceCollector(JavaComposite sc) {
		sc.add("private static class ResourceCollector implements " + I_RESOURCE_DELTA_VISITOR(sc) + ", " + I_RESOURCE_VISITOR(sc) + " {");
		sc.addLineBreak();
		sc.add("private " + sc.declareLinkedHashMap("resourceMap", I_RESOURCE(sc), "Boolean"));
		sc.addLineBreak();
		sc.add("public boolean visit(" + I_RESOURCE_DELTA(sc) + " delta) throws " + CORE_EXCEPTION(sc) + " {");
		sc.add(I_RESOURCE(sc) + " resource = delta.getResource();");
		sc.add("return doVisit(resource, delta.getKind() == " + I_RESOURCE_DELTA(sc) + ".REMOVED);");
		sc.add("}");
		sc.addLineBreak();

		sc.add("public boolean visit(" + I_RESOURCE(sc) + " resource) throws " + CORE_EXCEPTION(sc) + " {");
		sc.add("return doVisit(resource, false);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private boolean doVisit(" + I_RESOURCE(sc) + " resource, boolean removed) throws " + CORE_EXCEPTION(sc) + " {");
		sc.add("resourceMap.put(resource, removed);");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private " + MAP(sc) +"<" + I_RESOURCE(sc) + ", Boolean> getResourceMap() {");
		sc.add("return resourceMap;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc, boolean disableBuilder) {
		addBuildMethod1(sc);
		addBuildMethod2(sc);
		addGetBuilderMethod(sc);
		addGetBuilderMarkerIdMethod(sc);
		addRunTaskItemBuilderMethod(sc);
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
	}

	private void addBuildMethod1(JavaComposite sc) {
		sc.add("public " + I_PROJECT(sc) + "[] build(int kind, " + MAP(sc) + "<String, String> args, final " + I_PROGRESS_MONITOR(sc) + " monitor) throws " + CORE_EXCEPTION(sc) + " {");
		sc.addComment("Collect resources that must be built");
		sc.add("ResourceCollector resourceCollector = new ResourceCollector();");
		sc.add(I_RESOURCE_DELTA(sc) + " delta = getDelta(getProject());");
		sc.add("if (delta != null) {");
		sc.addComment("This is an incremental build");
		sc.add("delta.accept(resourceCollector);");
		sc.add("} else {");
		sc.addComment("This is a full build");
		sc.add("getProject().accept(resourceCollector);");
		sc.add("}");
		sc.addLineBreak();
		sc.addComment("This resource set is used during the whole build.");
		sc.add(RESOURCE_SET(sc) + " resourceSet = new " + RESOURCE_SET_IMPL(sc) + "();");
		sc.add(MAP(sc) +"<" + I_RESOURCE(sc) + ", Boolean> resourceMap = resourceCollector.getResourceMap();");
		sc.add("monitor.beginTask(" + resourceBundleClassName + "." +  ResourceBundleGenerator.BUILDER_ADAPTER_TASK_NAME + ", resourceMap.size() * 2);");
		sc.add("for (" + I_RESOURCE(sc) + " resource : resourceMap.keySet()) {");
		sc.add("doVisit(resource, resourceMap.get(resource), monitor, resourceSet);");
		sc.add("}");
		sc.add("monitor.done();");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addDoVisitMethod(JavaComposite sc, boolean disableBuilder) {
		sc.add("protected boolean doVisit(" + I_RESOURCE(sc) + " resource, boolean removed, " + I_PROGRESS_MONITOR(sc) + " monitor, " + RESOURCE_SET(sc) + " resourceSet) throws " + CORE_EXCEPTION(sc) + " {");
		sc.add("if (removed) {");
		sc.add(URI(sc) + " uri = " + URI(sc) + ".createPlatformResourceURI(resource.getFullPath().toString(), true);");
		sc.add(iBuilderClassName + " builder = getBuilder();");
		sc.add("if (builder.isBuildingNeeded(uri)) {");
		sc.add("builder.handleDeletion(uri, monitor);");
		sc.add("}");
    	sc.add("new " + markerHelperClassName + "().removeAllMarkers(resource, getBuilderMarkerId());");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (resource instanceof " + I_FILE(sc) + " && resource.getName().endsWith(\".\" + new " + metaInformationClassName + "().getSyntaxName())) {");
		if (disableBuilder) {
			sc.addComment(
					"Calling the default generated builder is disabled because of " +
					"syntax option '" + OptionTypes.DISABLE_BUILDER.getLiteral() + "'.");
			sc.add("monitor.worked(1);");
		} else {
			sc.addComment(
					"First, call the default generated builder that is usually " +
					"customized to add compilation-like behavior. " +
					"The Builder may consume one tick from the progress monitor.");
			sc.add("build((" + I_FILE(sc) + ") resource, resourceSet, monitor);");
		}
		sc.addComment(
				"Second, call the task item builder that searches " +
				"for task items in DSL documents and creates task markers. " +
				"The TaskItemBuilder may consume one tick from the progress monitor.");
		sc.add("runTaskItemBuilder((" + I_FILE(sc) + ") resource, resourceSet, monitor);");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addBuildMethod2(JavaComposite sc) {
		sc.add("public void build(" + I_FILE(sc) + " resource, " + RESOURCE_SET(sc) + " resourceSet, " + I_PROGRESS_MONITOR(sc) + " monitor) {");
		sc.add(URI(sc) + " uri = " + URI(sc) + ".createPlatformResourceURI(resource.getFullPath().toString(), true);");
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
		sc.add("public void runTaskItemBuilder(" + I_FILE(sc) + " resource, " + RESOURCE_SET(sc) + " resourceSet, " + I_PROGRESS_MONITOR(sc) + " monitor) {");
		sc.add(taskItemBuilderClassName + " taskItemBuilder = new " + taskItemBuilderClassName + "();");
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

/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.sdk.codegen.resource.ui;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.AbstractCreatePluginJob;
import org.emftext.sdk.codegen.IResourceMarker;
import org.emftext.sdk.codegen.antlr.ANTLRGenerationContext;
import org.emftext.sdk.codegen.antlr.creators.ANTLRPluginContentCreator;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.resource.creators.AbstractPluginCreator;
import org.emftext.sdk.codegen.resource.creators.ResourcePluginContentCreator;
import org.emftext.sdk.codegen.resource.ui.creators.ResourceUIPluginContentCreator;
import org.emftext.sdk.codegen.util.GenModelUtil;
import org.emftext.sdk.codegen.util.NameUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.util.ResourceUtil;

/**
 * The CreateTextResourcePluginsJob creates all plug-ins for a
 * text resource (i.e., the resource plug-in, the resource UI
 * plug-in and the ANTLR common runtime plug-in).
 * 
 * It delegates tasks to the other creators.
 */
public abstract class CreateTextResourcePluginsJob extends AbstractCreatePluginJob {
	
	/**
	 * An enumeration of all possible results of the generation
	 * process.
	 */
	public enum Result {
		SUCCESS,
		ERROR_ABSTRACT_SYNTAX, 
		ERROR_SYNTAX_HAS_ERRORS, 
		ERROR_GEN_PACKAGE_NOT_FOUND, 
		ERROR_FOUND_UNRESOLVED_PROXIES;

		private List<EObject> unresolvedProxies;

		public void setUnresolvedProxies(List<EObject> unresolvedProxies) {
			this.unresolvedProxies = unresolvedProxies;
		}

		public List<EObject> getUnresolvedProxies() {
			return unresolvedProxies;
		}
	}
	
	// these must add up to 100
	protected static final int TICKS_CREATE_PROJECTS = 4;
	protected static final int TICKS_GENERATE_RESOURCE_PLUGIN = 18;
	protected static final int TICKS_GENERATE_UI_RESOURCE_PLUGIN = 18;
	protected static final int TICKS_GENERATE_ANTLR_PLUGIN = 20;
	protected static final int TICKS_GENERATE_METAMODEL_CODE = 40;

	private GeneratorUtil genUtil = new GeneratorUtil();
	private final NameUtil nameUtil = new NameUtil();
	
	public abstract void createProject(IPluginDescriptor plugin, GenerationContext context, SubMonitor progress) throws Exception;

	public Result run(
			GenerationContext context,
			IResourceMarker marker, 
			IProgressMonitor monitor) throws Exception {

		ConcreteSyntax concreteSyntax = context.getConcreteSyntax(); 
		IPluginDescriptor resourcePlugin = nameUtil.getResourcePluginDescriptor(concreteSyntax);
		context.setResourcePlugin(resourcePlugin);
		IPluginDescriptor resourceUIPlugin = nameUtil.getResourceUIPluginDescriptor(concreteSyntax);
		context.setResourceUIPlugin(resourceUIPlugin);
		IPluginDescriptor antlrPlugin = genUtil.getAntlrPluginDescriptor(concreteSyntax);
		context.setAntlrPlugin(antlrPlugin);

		SubMonitor progress = SubMonitor.convert(monitor, 100);

		Resource csResource = concreteSyntax.eResource();
		monitor.setTaskName("unmarking resource...");
		marker.unmark(csResource);
		if (ResourceUtil.containsErrors(csResource)) {
			marker.mark(csResource);
			return Result.ERROR_SYNTAX_HAS_ERRORS;
		}

		// perform some initial checks
		if (concreteSyntax.isAbstract()) {
			return Result.ERROR_ABSTRACT_SYNTAX;
		}
		GenPackage genPackage = concreteSyntax.getPackage();
		if (genPackage == null) {
			return Result.ERROR_GEN_PACKAGE_NOT_FOUND;
		}
		List<EObject> unresolvedProxies = ResourceUtil.findUnresolvedProxies(csResource);
		if (unresolvedProxies.size() > 0) {
			Result result = Result.ERROR_FOUND_UNRESOLVED_PROXIES;
			result.setUnresolvedProxies(unresolvedProxies);
			return result;
		}
		
		ANTLRGenerationContext antlrGenContext = new ANTLRGenerationContext(context.getFileSystemConnector(), context.getProblemCollector(), concreteSyntax, antlrPlugin);
		
		createProjects(context, progress);
		progress.internalWorked(TICKS_CREATE_PROJECTS);

		// generate the resource class, parser, and printer
		AbstractPluginCreator<Object> pluginGenerator = new ResourcePluginContentCreator();
		pluginGenerator.create(resourcePlugin, context, null, progress.newChild(TICKS_GENERATE_RESOURCE_PLUGIN));
		AbstractPluginCreator<Object> uiPluginGenerator = new ResourceUIPluginContentCreator();
		uiPluginGenerator.create(resourceUIPlugin, context, null, progress.newChild(TICKS_GENERATE_UI_RESOURCE_PLUGIN));

		if (context.getGenerateANTLRPlugin()) {
			// generate the ANTLR commons plug-in
			ANTLRPluginContentCreator antlrPluginGenerator = new ANTLRPluginContentCreator();
			antlrPluginGenerator.generate(antlrGenContext, progress.newChild(TICKS_GENERATE_ANTLR_PLUGIN));
		}

		// errors from parser generator?
		if (ResourceUtil.containsProblems(csResource)) {
			marker.mark(csResource);
		}

		markErrors(marker, context.getConcreteSyntax());

		createMetaModelCode(context, progress);

		return Result.SUCCESS;
	}

	private void createProjects(GenerationContext context, SubMonitor progress)
			throws Exception {
		// create the projects for the plug-ins
		createProject(context.getResourcePlugin(), context, progress);
		createProject(context.getResourceUIPlugin(), context, progress);
		if (context.getGenerateANTLRPlugin()) {
			createProject(context.getAntlrPlugin(), context, progress);
		}
	}

	private void createMetaModelCode(GenerationContext context, SubMonitor progress) {
		
		final ConcreteSyntax cSyntax = context.getConcreteSyntax();
		
		// do not generate code for generator models imported from deployed plug-ins
		if (cSyntax.getPackage().eResource().getURI().segments()[0].equals("plugin")) {
			return;
		}
		
		// call EMF code generator if specified
		if (OptionManager.INSTANCE.getBooleanOptionValue(cSyntax, OptionTypes.GENERATE_CODE_FROM_GENERATOR_MODEL)) {
			new GenModelUtil().generateMetaModelCode(cSyntax.getPackage(), progress
					.newChild(TICKS_GENERATE_METAMODEL_CODE));
		} else {
			progress.internalWorked(TICKS_GENERATE_METAMODEL_CODE);
		}
	}

	private void markErrors(IResourceMarker marker, final ConcreteSyntax cSyntax) throws CoreException {
		// also mark errors on imported concrete syntaxes
		for (Import aImport : cSyntax.getImports()) {
			ConcreteSyntax importedCS = aImport.getConcreteSyntax();
			if (importedCS != null) {
				marker.unmark(importedCS.eResource());
				marker.mark(aImport.eResource());
			}
		}
	}
}

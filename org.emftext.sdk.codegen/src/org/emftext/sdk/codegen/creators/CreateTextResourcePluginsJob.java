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
package org.emftext.sdk.codegen.creators;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.sdk.codegen.AbstractCreatePluginJob;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.PluginDescriptor;
import org.emftext.sdk.codegen.TextResourcePlugins;
import org.emftext.sdk.codegen.generators.IResourceMarker;
import org.emftext.sdk.codegen.util.GenModelUtil;
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
	protected static final int TICKS_GENERATE_RESOURCE_PLUGIN = 36;
	protected static final int TICKS_GENERATE_ANTLR_PLUGIN = 20;
	protected static final int TICKS_GENERATE_METAMODEL_CODE = 40;
	
	public abstract void createProject(GenerationContext context, SubMonitor progress, PluginDescriptor plugin) throws Exception;

	public Result run(
			GenerationContext context,
			IResourceMarker marker, 
			IProgressMonitor monitor) throws Exception {

		ConcreteSyntax concreteSyntax = context.getConcreteSyntax(); 

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
		
		// create the project for the plug-ins
		createProject(context, progress, TextResourcePlugins.RESOURCE_PLUGIN);
		if (context.getGenerateANTLRPlugin()) {
			createProject(context, progress, TextResourcePlugins.ANTLR_PLUGIN);
		}
		progress.internalWorked(TICKS_CREATE_PROJECTS);

		// generate the resource class, parser, and printer
		AbstractPluginCreator<Object> pluginGenerator = new ResourcePluginContentCreator();
		pluginGenerator.generate(context, null, progress.newChild(TICKS_GENERATE_RESOURCE_PLUGIN));

		if (context.getGenerateANTLRPlugin()) {
			// generate the ANTLR commons plug-in
			ANTLRPluginContentCreator antlrPluginGenerator = new ANTLRPluginContentCreator();
			antlrPluginGenerator.generate(context, progress.newChild(TICKS_GENERATE_ANTLR_PLUGIN));
		}

		// errors from parser generator?
		if (ResourceUtil.containsProblems(csResource)) {
			marker.mark(csResource);
		}

		markErrors(marker, context.getConcreteSyntax());

		createMetaModelCode(context, progress);

		return Result.SUCCESS;
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

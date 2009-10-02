/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.creators;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.sdk.EPlugins;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.generators.IResourceMarker;
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.util.ResourceUtil;

/**
 * The ResourcePluginCreator creates all plug-ins.
 * It delegates tasks to the other creators.
 */
public abstract class PluginsCreator {
	
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
	
	private ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();
	
	public abstract void createProject(GenerationContext context, SubMonitor progress, EPlugins plugin) throws Exception;

	public Result run(
			ConcreteSyntax concreteSyntax, 
			GenerationContext context,
			IResourceMarker marker, 
			IProgressMonitor monitor) throws Exception {
		
		SubMonitor progress = SubMonitor.convert(monitor, 100);

		Resource csResource = concreteSyntax.eResource();
		monitor.setTaskName("unmarking resource...");
		marker.unmark(csResource);
		if (ResourceUtil.containsErrors(csResource)) {
			marker.mark(csResource);
			return Result.ERROR_SYNTAX_HAS_ERRORS;
		}

		// perform some initial checks
		if (csUtil.isAbstract(concreteSyntax)) {
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
		createProject(context, progress, EPlugins.RESOURCE_PLUGIN);
		createProject(context, progress, EPlugins.ANTLR_PLUGIN);
		progress.internalWorked(TICKS_CREATE_PROJECTS);

		// generate the resource class, parser, and printer
		ResourcePluginContentCreator pluginGenerator = new ResourcePluginContentCreator();
		pluginGenerator.generate(context, progress.newChild(TICKS_GENERATE_RESOURCE_PLUGIN));

		// generate the resource class, parser, and printer
		AntlrPluginContentCreator antlrPluginGenerator = new AntlrPluginContentCreator();
		antlrPluginGenerator.generate(context, progress.newChild(TICKS_GENERATE_ANTLR_PLUGIN));

		// errors from parser generator?
		if (ResourceUtil.containsProblems(csResource)) {
			marker.mark(csResource);
		}

		markErrors(marker, context.getConcreteSyntax());

		createMetaModelCode(context, progress);

		return Result.SUCCESS;
	}

	private void generateMetaModelCode(GenPackage genPackage,
			IProgressMonitor monitor) {
		monitor.setTaskName("generating metamodel code...");
		
	
		GenModel genModel = genPackage.getGenModel();
		genModel.setCanGenerate(true);

		// generate the code
		Generator generator = new Generator();
		generator.setInput(genModel);
		generator.generate(genModel,
				GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE,
				new BasicMonitor.EclipseSubProgress(monitor, 100));
	}

	private void createMetaModelCode(GenerationContext context, SubMonitor progress) {
		
		final ConcreteSyntax cSyntax = context.getConcreteSyntax();
		
		// do not generate code for generator models imported from deployed plug-ins
		if (cSyntax.getPackage().eResource().getURI().segments()[0].equals("plugin")) {
			return;
		}
		
		// call EMF code generator if specified
		if (OptionManager.INSTANCE.getBooleanOptionValue(cSyntax, OptionTypes.GENERATE_CODE_FROM_GENERATOR_MODEL)) {
			generateMetaModelCode(cSyntax.getPackage(), progress
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

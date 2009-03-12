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
package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.util.GeneratorUtil.setContents;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.resource.impl.TextResourceHelper;
import org.emftext.runtime.ui.new_wizard.AbstractNewFileWizard;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.ICodeGenOptions;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;

/**
 * The ResourcePluginGenerator generates the complete resource plug-in.
 * It delegates generation task to the other generators to do so.
 */
public abstract class ResourcePluginGenerator {
	
	/**
	 * An enumeration of all possible result of the generation
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
	
	private final static TextResourceHelper resourceHelper = new TextResourceHelper();

	// these must add up to 100
	protected static final int TICKS_CREATE_PROJECT = 2;
	protected static final int TICKS_OPEN_PROJECT = 2;
	protected static final int TICKS_SET_CLASSPATH = 2;
	protected static final int TICKS_CREATE_META_FOLDER = 2;
	protected static final int TICKS_CREATE_MANIFEST = 2;
	protected static final int TICKS_CREATE_PLUGIN_XML = 2;
	protected static final int TICKS_CREATE_MODELS_FOLDER = 2;
	protected static final int TICKS_GENERATE_RESOURCE = 26;
	protected static final int TICKS_GENERATE_METAMODEL_CODE = 40;
	
	public abstract void createProject(GenerationContext context, SubMonitor progress) throws Exception;

	public Result run(
			ConcreteSyntax concreteSyntax, 
			GenerationContext context,
			IResourceMarker marker, 
			IProgressMonitor monitor) throws Exception {
		
		SubMonitor progress = SubMonitor.convert(monitor, 100);

		Resource csResource = concreteSyntax.eResource();
		monitor.setTaskName("unmarking resource...");
		marker.unmark(csResource);
		if (resourceHelper.containsErrors(csResource)) {
			marker.mark(csResource);
			return Result.ERROR_SYNTAX_HAS_ERRORS;
		}

		// perform some initial checks
		if (checkAbstract(concreteSyntax)) {
			return Result.ERROR_ABSTRACT_SYNTAX;
		}
		GenPackage genPackage = concreteSyntax.getPackage();
		if (genPackage == null) {
			return Result.ERROR_GEN_PACKAGE_NOT_FOUND;
		}
		List<EObject> unresolvedProxies = new TextResourceHelper().findUnresolvedProxies(csResource);
		if (unresolvedProxies.size() > 0) {
			Result result = Result.ERROR_FOUND_UNRESOLVED_PROXIES;
			result.setUnresolvedProxies(unresolvedProxies);
			return result;
		}
		
		// create a project
		createProject(context, progress);

		// generate the resource class, parser, and printer
		ResourcePluginContentGenerator pluginGenerator = new ResourcePluginContentGenerator();
		pluginGenerator.generate(context, progress.newChild(TICKS_GENERATE_RESOURCE));

		// errors from parser generator?
		if (resourceHelper.containsProblems(csResource)) {
			marker.mark(csResource);
		}

		createMetaFolder(context, progress);
		createManifest(context, progress);
		createPluginXML(context, progress);
		copyIcon(context, progress);

		markErrors(marker, context.getConcreteSyntax());

		createMetaModelCode(context, progress);

		return Result.SUCCESS;
	}

	private void copyIcon(GenerationContext context, SubMonitor progress) {
		File iconsDir = context.getIconsDir();
		iconsDir.mkdir();
		
		InputStream in = AbstractNewFileWizard.class.getResourceAsStream("default_new_icon.gif");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(context.getNewIconFile());
			int read;
			while ((read = in.read()) >= 0) {
				fos.write(read);
			}
			fos.close();
		} catch (IOException e) {
			EMFTextRuntimePlugin.logError("Error while copying icon.", e);
		}
	}

	private boolean checkAbstract(final ConcreteSyntax concreteSyntax) {
		if (concreteSyntax.getModifier() != null) {
			return true;
		}
		return false;
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
		
		// do not generate code for genmodels imported from deployed plugins
		if (cSyntax.getPackage().eResource().getURI().segments()[0].equals("plugin")) {
			return;
		}
		
		// call EMF code generator if specified
		if (OptionManager.INSTANCE.getBooleanOptionValue(cSyntax, ICodeGenOptions.GENERATE_CODE_FROM_GENERATOR_MODEL)) {
			generateMetaModelCode(cSyntax.getPackage(), progress
					.newChild(TICKS_GENERATE_METAMODEL_CODE));
		} else {
			progress.internalWorked(TICKS_GENERATE_METAMODEL_CODE);
		}
	}

	private void createMetaFolder(GenerationContext context, SubMonitor progress)
			throws CoreException {
		File project = context.getPluginProjectFolder();
		File metaFolder = new File(project.getAbsolutePath() + File.separator +  "META-INF");
		if (!metaFolder.exists()) {
			metaFolder.mkdir();
		}
		progress.internalWorked(TICKS_CREATE_META_FOLDER);
	}

	private void createManifest(GenerationContext context,
			SubMonitor progress) throws IOException {
		
		final ConcreteSyntax cSyntax = context.getConcreteSyntax();
		final File project = context.getPluginProjectFolder();

		boolean overrideManifest = OptionManager.INSTANCE.getBooleanOptionValue(cSyntax, ICodeGenOptions.OVERRIDE_MANIFEST);

		File manifestMFFile = new File(project.getAbsolutePath() + File.separator + "META-INF" + File.separator + "MANIFEST.MF");
		if (manifestMFFile.exists()) {
			if (overrideManifest) {
				InputStream stream = generateManifest(context);
				setContents(manifestMFFile, stream);
				progress.newChild(TICKS_CREATE_MANIFEST);
			} else {
				progress.internalWorked(TICKS_CREATE_MANIFEST);
			}
		} else {
			InputStream stream = generateManifest(context);
			setContents(manifestMFFile, stream);
			progress.newChild(TICKS_CREATE_MANIFEST);
		}
	}

	private InputStream generateManifest(GenerationContext context) {
		ManifestGenerator mGenerator = new ManifestGenerator(context);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		mGenerator.generate(new PrintWriter(outputStream));
		return new ByteArrayInputStream(outputStream.toByteArray());
	}

	private void createPluginXML(GenerationContext context, SubMonitor progress)
			throws IOException {
		
		final ConcreteSyntax cSyntax = context.getConcreteSyntax();
		File project = context.getPluginProjectFolder();
		
		boolean overridePluginXML = OptionManager.INSTANCE.getBooleanOptionValue(cSyntax, ICodeGenOptions.OVERRIDE_PLUGIN_XML);
		
		File pluginXMLFile = new File(project.getAbsolutePath() + File.separator + "plugin.xml");
		if (pluginXMLFile.exists()) {
			if (overridePluginXML) {
				PluginXMLGenerator pluginXMLGenerator = new PluginXMLGenerator(context);
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				pluginXMLGenerator.generate(new PrintWriter(outputStream));
				setContents(pluginXMLFile, new ByteArrayInputStream(outputStream.toByteArray()));
				progress.newChild(TICKS_CREATE_PLUGIN_XML);
			} else {
				progress.internalWorked(TICKS_CREATE_PLUGIN_XML);
			}
		} else {
			PluginXMLGenerator pluginXMLGenerator = new PluginXMLGenerator(context);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			pluginXMLGenerator.generate(new PrintWriter(outputStream));
			setContents(pluginXMLFile, new ByteArrayInputStream(outputStream.toByteArray()));
			progress.newChild(TICKS_CREATE_PLUGIN_XML);
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

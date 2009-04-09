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

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.antlr.Tool;
import org.antlr.tool.ErrorManager;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.util.TextResourceGeneratorANTLRErrorListener;

/**
 * A creator that uses multiple other creators to create
 * a resource plug-in from as CS specification and a meta model.
 */
public class ResourcePluginContentCreator {
	
	public void generate(GenerationContext context, IProgressMonitor monitor)throws IOException{
		SubMonitor progress = SubMonitor.convert(monitor, "generating resources...", 100);
	    
		ITextResource csResource = (ITextResource) context.getConcreteSyntax().eResource();
		EcoreUtil.resolveAll(csResource);
		
		IArtifactCreator targetFolderCreator = new SourceFolderCreator();
	    IArtifactCreator antlrGrammarCreator = new ANTLRGrammarCreator();
	    IArtifactCreator resourceCreator = new TextResourceCreator();
	    IArtifactCreator resourceFactoryCreator = new ResourceFactoryCreator();
	    IArtifactCreator printerCreator = new PrinterCreator();
	    IArtifactCreator printerBaseCreator = new PrinterBaseCreator();
	    IArtifactCreator dotClasspathCreator = new DotClasspathCreator();
	    IArtifactCreator dotProjectCreator = new DotProjectCreator();
	    IArtifactCreator referenceResolversCreator = new ReferenceResolversCreator();
	    IArtifactCreator referenceResolverSwitchCreator = new ReferenceResolverSwitchCreator();
	    IArtifactCreator tokenResolversCreator = new TokenResolversCreator();
	    IArtifactCreator tokenResolverFactoryCreator = new TokenResolverFactoryCreator();
	    IArtifactCreator newFileWizardCreator = new NewFileWizardCreator();
	    IArtifactCreator pluginXMLCreator = new PluginXMLCreator();
	    IArtifactCreator manifestCreator = new ManifestCreator();
	    
	    // TODO mseifert: the creators should all be handled the same
	    // there should be a list of creation steps where each one
	    // consists of a name, a creator and a progress value
		targetFolderCreator.createArtifacts(context);

		progress.setTaskName("setting classpath...");
	    dotClasspathCreator.createArtifacts(context);
	    
	    progress.setTaskName("setting project description...");
	    dotProjectCreator.createArtifacts(context);
	    
	    pluginXMLCreator.createArtifacts(context);

	    progress.setTaskName("creating grammar...");
	    antlrGrammarCreator.createArtifacts(context);
	    progress.worked(20);
	    
		progress.setTaskName("generating EMF resources...");
		resourceCreator.createArtifacts(context);
		resourceFactoryCreator.createArtifacts(context);
		progress.worked(5);
		
		progress.setTaskName("running ANTLR on grammar file...");
		runANTLR(context, progress);
        progress.worked(20);
    	
        progress.setTaskName("generating printer...");
		printerBaseCreator.createArtifacts(context);
		printerCreator.createArtifacts(context);
	    progress.worked(20);
	    
		monitor.setTaskName("generating reference resolvers...");
		referenceResolversCreator.createArtifacts(context);
		monitor.worked(20);
		
		progress.setTaskName("generating reference resolver switch...");
		referenceResolverSwitchCreator.createArtifacts(context);
		progress.worked(5);
		
		progress.setTaskName("generating new file wizard...");
		newFileWizardCreator.createArtifacts(context);
		progress.worked(5);
		
		progress.setTaskName("generating token resolvers...");
		tokenResolversCreator.createArtifacts(context);
		progress.worked(20);
		
		progress.setTaskName("generating token resolver factory...");
		tokenResolverFactoryCreator.createArtifacts(context);
		
		progress.setTaskName("generating manifest file...");
	    manifestCreator.createArtifacts(context);
	    
		searchForUnusedResolvers(context);
	}


	private void runANTLR(GenerationContext context, SubMonitor progress) {
		File antlrFile = context.getANTLRGrammarFile();
        ErrorManager.setErrorListener(new TextResourceGeneratorANTLRErrorListener(context.getConcreteSyntax().eResource()));
        Tool antlrTool = new Tool(new String[]{"-Xconversiontimeout", "10000", "-o", antlrFile.getParentFile().getAbsolutePath(), antlrFile.getAbsolutePath()});
        antlrTool.process();
	}
	
	// TODO mseifert: I think we could do this in a post processor
	private void searchForUnusedResolvers(GenerationContext context) {
		Set<String> resolverFiles = context.getResolverFileNames();
		
		File resolverPackageFolder = context.getResolverPackageFile();
		if (!resolverPackageFolder.exists()) {
			return;
		}
		File[] contents = resolverPackageFolder.listFiles();
		for (File member : contents) {
			if (!member.isDirectory()) {
				String fileName = member.getName();
				if (!resolverFiles.contains(fileName)) {
					// issue warning about unused resolver
					((ITextResource) context.getConcreteSyntax().eResource()).addWarning("Found unused class '" + fileName + "' in analysis package.", null);
				}
			}
		}
	}
}

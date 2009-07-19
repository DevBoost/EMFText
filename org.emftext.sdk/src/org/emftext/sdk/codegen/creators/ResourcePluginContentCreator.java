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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * A creator that uses multiple other creators to create
 * a resource plug-in from a CS specification and a meta 
 * model.
 */
public class ResourcePluginContentCreator {
	
	public void generate(GenerationContext context, IProgressMonitor monitor)throws IOException{
		SubMonitor progress = SubMonitor.convert(monitor, "generating resources...", 100);
	    
		ConcreteSyntax syntax = context.getConcreteSyntax();
		ITextResource csResource = (ITextResource) syntax.eResource();
		EcoreUtil.resolveAll(csResource);
	    
	    List<IArtifactCreator> creators = new ArrayList<IArtifactCreator>();
	    creators.add(new SourceFolderCreator());
	    creators.add(new DotClasspathCreator());
	    creators.add(new DotProjectCreator());
	    creators.add(new BuildPropertiesCreator());
	    if (OptionManager.INSTANCE.useScalesParser(syntax)) {
	    	creators.add(new ScannerlessScannerCreator());
	    	creators.add(new ScannerlessParserCreator());
	    	creators.add(new EmptyClassCreator(context.getParserFile(), context.getParserClassName()));
	    } else {
		    creators.add(new ANTLRGrammarCreator());
		    creators.add(new ANTLRParserCreator());
	    	creators.add(new EmptyClassCreator(context.getScannerlessScannerFile(), context.getScannerlessScannerClassName()));
	    	creators.add(new EmptyClassCreator(context.getScannerlessParserFile(), context.getScannerlessParserClassName()));
	    }
	    creators.add(new PluginXMLCreator());
	    creators.add(new TextResourceCreator());
	    creators.add(new ResourceFactoryCreator());
	    creators.add(new PrinterBaseCreator());
	    creators.add(new PrinterCreator());
	    creators.add(new ReferenceResolversCreator());
	    creators.add(new ReferenceResolverSwitchCreator());
	    creators.add(new NewFileWizardCreator());
	    creators.add(new NewFileIconCreator());
	    creators.add(new TokenResolversCreator());
	    creators.add(new TokenResolverFactoryCreator());
	    creators.add(new MetaInfFolderCreator());
	    creators.add(new ManifestCreator());
	    creators.add(new PluginMetaInformationCreator());
	    creators.add(new DefaultResolverDelegateCreator());
	    creators.add(new ProblemClassCreator());

		for (IArtifactCreator creator : creators) {
			progress.setTaskName("creating " + creator.getArtifactDescription() + "...");
			creator.createArtifacts(context);
		    progress.worked(100 / creators.size());
	    }
	}
}

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
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.generators.ui.BracketPreferencePageGenerator;
import org.emftext.sdk.codegen.generators.ui.OccurrencePreferencePageGenerator;
import org.emftext.sdk.codegen.generators.ui.PixelConverterGenerator;
import org.emftext.sdk.codegen.generators.ui.PreferenceConstantsGenerator;
import org.emftext.sdk.codegen.generators.ui.PreferenceInitializerGenerator;
import org.emftext.sdk.codegen.generators.ui.SyntaxColoringHelperGenerator;
import org.emftext.sdk.codegen.generators.ui.SyntaxColoringPreferencePageGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;

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
	    	creators.add(new GenericArtifactCreator(EArtifact.SCANNERLESS_SCANNER));
	    	creators.add(new GenericArtifactCreator(EArtifact.SCANNERLESS_PARSER));
	    	creators.add(new EmptyClassCreator(context.getFile(EArtifact.ANTLR_SCANNER), context.getClassName(EArtifact.ANTLR_SCANNER), OptionTypes.OVERRIDE_SCANNER));
	    	creators.add(new EmptyClassCreator(context.getFile(EArtifact.ANTLR_LEXER), context.getClassName(EArtifact.ANTLR_LEXER), OptionTypes.OVERRIDE_SCANNER));
	    	creators.add(new EmptyClassCreator(context.getFile(EArtifact.ANTLR_PARSER), context.getClassName(EArtifact.ANTLR_PARSER), OptionTypes.OVERRIDE_PARSER));
	    } else {
	    	creators.add(new GenericArtifactCreator(EArtifact.ANTLR_SCANNER));
		    creators.add(new ANTLRGrammarCreator());
		    creators.add(new ANTLRParserCreator());
	    	creators.add(new EmptyClassCreator(context.getFile(EArtifact.SCANNERLESS_SCANNER), context.getClassName(EArtifact.SCANNERLESS_SCANNER), OptionTypes.OVERRIDE_SCANNER));
	    	creators.add(new EmptyClassCreator(context.getFile(EArtifact.SCANNERLESS_PARSER), context.getClassName(EArtifact.SCANNERLESS_PARSER), OptionTypes.OVERRIDE_PARSER));
	    }
	    creators.add(new PluginXMLCreator());
	    creators.add(new GenericArtifactCreator(EArtifact.RESOURCE));
	    creators.add(new GenericArtifactCreator(EArtifact.RESOURCE_FACTORY));
	    creators.add(new PrinterBaseCreator());
	    creators.add(new PrinterCreator());
	    creators.add(new ReferenceResolversCreator());
	    creators.add(new GenericArtifactCreator(EArtifact.REFERENCE_RESOLVER_SWITCH));
	    creators.add(new GenericArtifactCreator(EArtifact.NEW_FILE_WIZARD));
	    creators.add(new NewFileIconCreator());
	    creators.add(new TokenResolversCreator());
	    creators.add(new GenericArtifactCreator(EArtifact.TOKEN_RESOLVER_FACTORY));
	    creators.add(new MetaInfFolderCreator());
	    creators.add(new ManifestCreator());
	    creators.add(new GenericArtifactCreator(EArtifact.META_INFORMATION));
	    creators.add(new GenericArtifactCreator(EArtifact.DEFAULT_RESOLVER_DELEGATE));
	    creators.add(new GenericArtifactCreator(EArtifact.PROBLEM));
	    creators.add(new GenericArtifactCreator(EArtifact.CONTEXT_DEPENDENT_URI_FRAGMENT));
	    creators.add(new GenericArtifactCreator(EArtifact.CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY));
	    creators.add(new GenericArtifactCreator(EArtifact.DELEGATING_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator(EArtifact.DUMMY_E_OBJECT));
	    creators.add(new GenericArtifactCreator(EArtifact.ELEMENT_MAPPING));
	    creators.add(new GenericArtifactCreator(EArtifact.FUZZY_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator(EArtifact.LOCATION_MAP));
	    creators.add(new GenericArtifactCreator(EArtifact.DEFAULT_TOKEN_RESOLVER));
	    creators.add(new GenericArtifactCreator(EArtifact.REFERENCE_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator(EArtifact.TOKEN_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator(EArtifact.URI_MAPPING));
	    creators.add(new GenericArtifactCreator(EArtifact.HOVER_TEXT_PROVIDER));
	    creators.add(new GenericArtifactCreator(EArtifact.PARSE_RESULT));
	    creators.add(new GenericArtifactCreator(EArtifact.PLUGIN_ACTIVATOR));
	    
	    // add UI generators
	    creators.add(new GenericArtifactCreator(EArtifact.ANTLR_TOKEN_HELPER));
	    creators.add(new GenericArtifactCreator(EArtifact.BRACKET_SET));
	    creators.add(new GenericArtifactCreator(EArtifact.BROWER_INFORMATION_CONTROL));
	    creators.add(new GenericArtifactCreator(EArtifact.CODE_FOLDING_MANAGER));
	    creators.add(new GenericArtifactCreator(EArtifact.COLOR_MANAGER));
	    creators.add(new GenericArtifactCreator(EArtifact.COMPLETION_PROCESSOR));
	    creators.add(new GenericArtifactCreator(EArtifact.BACKGROUND_PARSING_STRATEGY));
	    creators.add(new GenericArtifactCreator(EArtifact.DOC_BROWSER_INFORMATION_CONTROL_INPUT));
	    creators.add(new GenericArtifactCreator(EArtifact.EDITOR_CONFIGURATION));
	    creators.add(new GenericArtifactCreator(EArtifact.EDITOR));
	    creators.add(new GenericArtifactCreator(EArtifact.E_OBJECT_SELECTION));
	    creators.add(new GenericArtifactCreator(EArtifact.HIGHLIGHTING));
	    creators.add(new GenericArtifactCreator(EArtifact.HTML_PRINTER));
	    creators.add(new GenericArtifactCreator(EArtifact.HYPERLINK));
	    creators.add(new GenericArtifactCreator(EArtifact.HYPERLINK_DETECTOR));
	    creators.add(new GenericArtifactCreator(EArtifact.MARKER_HELPER));
	    creators.add(new GenericArtifactCreator(EArtifact.OCCURENCE));
	    creators.add(new GenericArtifactCreator(EArtifact.OUTLINE_PAGE));
	    creators.add(new GenericArtifactCreator(EArtifact.OUTLINE_PAGE_TREE_VIEWER));
	    creators.add(new GenericArtifactCreator(EArtifact.POSITION_CATEGORY));
	    creators.add(new GenericArtifactCreator(EArtifact.POSITION_HELPER));
	    creators.add(new GenericArtifactCreator(EArtifact.PROPERTY_SHEET_PAGE));
	    creators.add(new GenericArtifactCreator(EArtifact.TEXT_HOVER));
	    creators.add(new GenericArtifactCreator(EArtifact.TOKEN_SCANNER));
	    
	    creators.add(new GenericArtifactCreator(EArtifact.BRACKET_PREFERENCE_PAGE));
	    creators.add(new GenericArtifactCreator(EArtifact.PREFERENCE_CONSTANTS));
	    creators.add(new GenericArtifactCreator(EArtifact.OCCURRENCE_PREFERENCE_PAGE));
	    creators.add(new GenericArtifactCreator(EArtifact.PIXEL_CONVERTER));
	    creators.add(new GenericArtifactCreator(EArtifact.PREFERENCE_INITIALIZER));
	    creators.add(new GenericArtifactCreator(EArtifact.SYNTAX_COLORING_HELPER));
	    creators.add(new GenericArtifactCreator(EArtifact.SYNTAX_COLORING_PREFERENCE_PAGE));
	    
	    for (IArtifactCreator creator : creators) {
			progress.setTaskName("creating " + creator.getArtifactDescription() + "...");
			creator.createArtifacts(context);
		    progress.worked(100 / creators.size());
	    }
	}
}

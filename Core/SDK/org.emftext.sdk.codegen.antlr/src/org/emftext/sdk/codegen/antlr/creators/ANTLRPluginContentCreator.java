/*******************************************************************************
 * Copyright (c) 2006-2013
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
package org.emftext.sdk.codegen.antlr.creators;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.OptionManager;
import org.emftext.sdk.antlr3_4_0.EMFTextSDKAntlrPlugin;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.antlr.ANTLRGenerationContext;
import org.emftext.sdk.codegen.antlr.ANTLRPluginArtifacts;
import org.emftext.sdk.codegen.creators.BuildPropertiesCreator;
import org.emftext.sdk.codegen.creators.DotClasspathCreator;
import org.emftext.sdk.codegen.creators.DotProjectCreator;
import org.emftext.sdk.codegen.creators.FileCopier;
import org.emftext.sdk.codegen.creators.FoldersCreator;
import org.emftext.sdk.codegen.creators.ManifestCreator;
import org.emftext.sdk.codegen.parameters.BuildPropertiesParameters;
import org.emftext.sdk.codegen.parameters.ClassPathParameters;
import org.emftext.sdk.codegen.parameters.DotProjectParameters;
import org.emftext.sdk.codegen.parameters.ManifestParameters;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * This class creates the contents of the org.emftext.commons.antlr_version
 * plug-in by copying the ANTLR runtime classes from the
 * org.emftext.sdk.antlr_version plug-in. The creation of the commons plug-in
 * can be disable using the syntax option OptionTypes.OVERRIDE_ANTLR_PLUGIN.
 */
public class ANTLRPluginContentCreator {

	private static final String SRC_FOLDER = "src";
	
	/**
	 * A list of all classes to copy.
	 */
	private Class<?>[] antlrClassNames = new Class<?>[] {
			org.antlr.runtime3_4_0.ANTLRFileStream.class,
			org.antlr.runtime3_4_0.ANTLRInputStream.class,
			org.antlr.runtime3_4_0.ANTLRReaderStream.class,
			org.antlr.runtime3_4_0.ANTLRStringStream.class,
			org.antlr.runtime3_4_0.BaseRecognizer.class,
			org.antlr.runtime3_4_0.BitSet.class,
			org.antlr.runtime3_4_0.BufferedTokenStream.class,
			org.antlr.runtime3_4_0.CharStream.class,
			org.antlr.runtime3_4_0.CharStreamState.class,
			org.antlr.runtime3_4_0.ClassicToken.class,
			org.antlr.runtime3_4_0.CommonToken.class,
			org.antlr.runtime3_4_0.CommonTokenStream.class,
			org.antlr.runtime3_4_0.DFA.class,
			org.antlr.runtime3_4_0.EarlyExitException.class,
			org.antlr.runtime3_4_0.FailedPredicateException.class,
			org.antlr.runtime3_4_0.IntStream.class,
			org.antlr.runtime3_4_0.Lexer.class,
			org.antlr.runtime3_4_0.MismatchedNotSetException.class,
			org.antlr.runtime3_4_0.MismatchedRangeException.class,
			org.antlr.runtime3_4_0.MismatchedSetException.class,
			org.antlr.runtime3_4_0.MismatchedTokenException.class,
			org.antlr.runtime3_4_0.MismatchedTreeNodeException.class,
			org.antlr.runtime3_4_0.MissingTokenException.class,
			org.antlr.runtime3_4_0.NoViableAltException.class,
			org.antlr.runtime3_4_0.Parser.class,
			org.antlr.runtime3_4_0.ParserRuleReturnScope.class,
			org.antlr.runtime3_4_0.RecognitionException.class,
			org.antlr.runtime3_4_0.RecognizerSharedState.class,
			org.antlr.runtime3_4_0.RuleReturnScope.class,
			org.antlr.runtime3_4_0.SerializedGrammar.class,
			org.antlr.runtime3_4_0.Token.class,
			org.antlr.runtime3_4_0.TokenRewriteStream.class,
			org.antlr.runtime3_4_0.TokenSource.class,
			org.antlr.runtime3_4_0.TokenStream.class,
			org.antlr.runtime3_4_0.UnwantedTokenException.class,
			org.antlr.runtime3_4_0.debug.BlankDebugEventListener.class,
			org.antlr.runtime3_4_0.debug.DebugEventHub.class,
			org.antlr.runtime3_4_0.debug.DebugEventListener.class,
			org.antlr.runtime3_4_0.debug.DebugEventRepeater.class,
			org.antlr.runtime3_4_0.debug.DebugEventSocketProxy.class,
			org.antlr.runtime3_4_0.debug.DebugParser.class,
			org.antlr.runtime3_4_0.debug.DebugTokenStream.class,
			org.antlr.runtime3_4_0.debug.DebugTreeAdaptor.class,
			org.antlr.runtime3_4_0.debug.DebugTreeNodeStream.class,
			org.antlr.runtime3_4_0.debug.DebugTreeParser.class,
			org.antlr.runtime3_4_0.debug.ParseTreeBuilder.class,
			org.antlr.runtime3_4_0.debug.Profiler.class,
			org.antlr.runtime3_4_0.debug.RemoteDebugEventSocketListener.class,
			org.antlr.runtime3_4_0.debug.TraceDebugEventListener.class,
			org.antlr.runtime3_4_0.debug.Tracer.class,
			org.antlr.runtime3_4_0.misc.FastQueue.class,
			org.antlr.runtime3_4_0.misc.IntArray.class,
			org.antlr.runtime3_4_0.misc.LookaheadStream.class,
			org.antlr.runtime3_4_0.misc.Stats.class,
			org.antlr.runtime3_4_0.misc.DoubleKeyMap.class,
			org.antlr.runtime3_4_0.misc.IntToIntHashMap.class,
			org.antlr.runtime3_4_0.tree.BaseTree.class,
			org.antlr.runtime3_4_0.tree.BaseTreeAdaptor.class,
			org.antlr.runtime3_4_0.tree.BufferedTreeNodeStream.class,
			org.antlr.runtime3_4_0.tree.CommonErrorNode.class,
			org.antlr.runtime3_4_0.tree.CommonTree.class,
			org.antlr.runtime3_4_0.tree.CommonTreeAdaptor.class,
			org.antlr.runtime3_4_0.tree.CommonTreeNodeStream.class,
			org.antlr.runtime3_4_0.tree.ParseTree.class,
			org.antlr.runtime3_4_0.tree.RewriteCardinalityException.class,
			org.antlr.runtime3_4_0.tree.RewriteEarlyExitException.class,
			org.antlr.runtime3_4_0.tree.RewriteEmptyStreamException.class,
			org.antlr.runtime3_4_0.tree.RewriteRuleElementStream.class,
			org.antlr.runtime3_4_0.tree.RewriteRuleNodeStream.class,
			org.antlr.runtime3_4_0.tree.RewriteRuleSubtreeStream.class,
			org.antlr.runtime3_4_0.tree.RewriteRuleTokenStream.class,
			org.antlr.runtime3_4_0.tree.Tree.class,
			org.antlr.runtime3_4_0.tree.TreeAdaptor.class,
			org.antlr.runtime3_4_0.tree.TreeFilter.class,
			org.antlr.runtime3_4_0.tree.TreeIterator.class,
			org.antlr.runtime3_4_0.tree.TreeNodeStream.class,
			org.antlr.runtime3_4_0.tree.TreeParser.class,
			org.antlr.runtime3_4_0.tree.TreePatternLexer.class,
			org.antlr.runtime3_4_0.tree.TreePatternParser.class,
			org.antlr.runtime3_4_0.tree.TreeRewriter.class,
			org.antlr.runtime3_4_0.tree.TreeRuleReturnScope.class,
			org.antlr.runtime3_4_0.tree.TreeVisitor.class,
			org.antlr.runtime3_4_0.tree.TreeVisitorAction.class,
			org.antlr.runtime3_4_0.tree.TreeWizard.class
	};

	public void generate(ANTLRGenerationContext context, IProgressMonitor monitor) throws IOException {
		ConcreteSyntax syntax = context.getConcreteSyntax();
		boolean override = OptionManager.INSTANCE.getBooleanOptionValue(syntax, OptionTypes.OVERRIDE_ANTLR_PLUGIN);
		if (!override) {
			return;
		}
		SubMonitor progress = SubMonitor.convert(monitor, "generating antlr common plug-in...", 100);
		
		IPluginDescriptor antlrPlugin = context.getAntlrPlugin();
		
		List<IArtifactCreator<ANTLRGenerationContext>> creators = new ArrayList<IArtifactCreator<ANTLRGenerationContext>>();
	    File sourceFolder = 
	    	new File(context.getProjectFolder(antlrPlugin).getAbsolutePath() + File.separator + SRC_FOLDER);
		
	    String sourceFolderPath = sourceFolder.getAbsolutePath() + File.separator;
		creators.add(new FoldersCreator<ANTLRGenerationContext>(new File[] {
	    		sourceFolder,
	    		new File(sourceFolderPath + ANTLRPluginArtifacts.PACKAGE_ANTLR_RUNTIME.getPackage().getName(context).replace(".", File.separator)),
	    		new File(sourceFolderPath + ANTLRPluginArtifacts.PACKAGE_ANTLR_RUNTIME_DEBUG.getPackage().getName(context).replace(".", File.separator)),
	    		new File(sourceFolderPath + ANTLRPluginArtifacts.PACKAGE_ANTLR_RUNTIME_MISC.getPackage().getName(context).replace(".", File.separator)),
	    		new File(sourceFolderPath + ANTLRPluginArtifacts.PACKAGE_ANTLR_RUNTIME_TREE.getPackage().getName(context).replace(".", File.separator)),
	    }));
	    
	    ClassPathParameters<ANTLRGenerationContext> cpp = new ClassPathParameters<ANTLRGenerationContext>(ANTLRPluginArtifacts.DOT_CLASSPATH, antlrPlugin);
	    cpp.getSourceFolders().add(SRC_FOLDER);
		creators.add(new DotClasspathCreator<ANTLRGenerationContext>(cpp, override));
		
	    creators.add(new DotProjectCreator<ANTLRGenerationContext>(new DotProjectParameters<ANTLRGenerationContext>(ANTLRPluginArtifacts.DOT_PROJECT, antlrPlugin), override));
	    
		BuildPropertiesParameters<ANTLRGenerationContext> bpp = new BuildPropertiesParameters<ANTLRGenerationContext>(ANTLRPluginArtifacts.BUILD_PROPERTIES, antlrPlugin);
	    bpp.getSourceFolders().add(sourceFolder.getName() + "/");
		bpp.getBinIncludes().add("META-INF/");
		bpp.getBinIncludes().add(".");
		creators.add(new BuildPropertiesCreator<ANTLRGenerationContext>(bpp, override));
	    
	    ManifestParameters<ANTLRGenerationContext> manifestParameters = new ManifestParameters<ANTLRGenerationContext>(ANTLRPluginArtifacts.MANIFEST);
		// export the generated packages
		Collection<String> exports = manifestParameters.getExportedPackages();
		exports.add(ANTLRPluginArtifacts.PACKAGE_ANTLR_RUNTIME.getPackage().getName(context));
		exports.add(ANTLRPluginArtifacts.PACKAGE_ANTLR_RUNTIME_DEBUG.getPackage().getName(context));
		exports.add(ANTLRPluginArtifacts.PACKAGE_ANTLR_RUNTIME_MISC.getPackage().getName(context));
		exports.add(ANTLRPluginArtifacts.PACKAGE_ANTLR_RUNTIME_TREE.getPackage().getName(context));

		manifestParameters.setPlugin(antlrPlugin);
		// TODO Use constant for ANTLR version
		manifestParameters.setBundleName("ANTLR 3.4.0 Runtime Classes");
		creators.add(new ManifestCreator<ANTLRGenerationContext>(manifestParameters, true));

		Class<?> referenceClass = EMFTextSDKAntlrPlugin.class;
		SourceCodeStreamFactory sourceCodeStreamFactory = new SourceCodeStreamFactory();
	    // add copiers for ANTLR source files
	    for (Class<?> antlrClass : antlrClassNames) {
			String className = antlrClass.getName();
			InputStream sourceStream = sourceCodeStreamFactory.getSourceCodeStream(referenceClass,
					className);
			String pathFile = antlrClass.getName().replace(".", File.separator) + ".java";
			File targetFile = new File(sourceFolderPath + pathFile);
			FileCopier<ANTLRGenerationContext> fileCopier = new FileCopier<ANTLRGenerationContext>(sourceStream, 
					targetFile, true);
			creators.add(fileCopier);
	    }
	    
		for (IArtifactCreator<ANTLRGenerationContext> creator : creators) {
			if (override) {
				progress.setTaskName("creating " + creator.getArtifactTypeDescription() + "...");
				creator.createArtifacts(antlrPlugin, context);
			}
			progress.worked(100 / creators.size());
		}
	}
}

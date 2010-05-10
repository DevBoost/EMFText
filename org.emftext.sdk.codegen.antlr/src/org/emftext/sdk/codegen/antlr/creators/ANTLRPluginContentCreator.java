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
package org.emftext.sdk.codegen.antlr.creators;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.emftext.sdk.antlr3_2_0.EMFTextSDKAntlrPlugin;
import org.emftext.sdk.codegen.BuildPropertiesParameters;
import org.emftext.sdk.codegen.ClassPathParameters;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.ManifestParameters;
import org.emftext.sdk.codegen.antlr.ANTLRGenerationContext;
import org.emftext.sdk.codegen.antlr.ANTLRPluginArtifacts;
import org.emftext.sdk.codegen.creators.BuildPropertiesCreator;
import org.emftext.sdk.codegen.creators.DotClasspathCreator;
import org.emftext.sdk.codegen.creators.DotProjectCreator;
import org.emftext.sdk.codegen.creators.FileCopier;
import org.emftext.sdk.codegen.creators.FoldersCreator;

public class ANTLRPluginContentCreator {

	private static final String SRC_FOLDER = "src";
	private Class<?>[] antlrClassNames = new Class<?>[] {
			org.antlr.runtime3_2_0.ANTLRFileStream.class,
			org.antlr.runtime3_2_0.ANTLRInputStream.class,
			org.antlr.runtime3_2_0.ANTLRReaderStream.class,
			org.antlr.runtime3_2_0.ANTLRStringStream.class,
			org.antlr.runtime3_2_0.BaseRecognizer.class,
			org.antlr.runtime3_2_0.BitSet.class,
			org.antlr.runtime3_2_0.CharStream.class,
			org.antlr.runtime3_2_0.CharStreamState.class,
			org.antlr.runtime3_2_0.ClassicToken.class,
			org.antlr.runtime3_2_0.CommonToken.class,
			org.antlr.runtime3_2_0.CommonTokenStream.class,
			org.antlr.runtime3_2_0.DFA.class,
			org.antlr.runtime3_2_0.EarlyExitException.class,
			org.antlr.runtime3_2_0.FailedPredicateException.class,
			org.antlr.runtime3_2_0.IntStream.class,
			org.antlr.runtime3_2_0.Lexer.class,
			org.antlr.runtime3_2_0.MismatchedNotSetException.class,
			org.antlr.runtime3_2_0.MismatchedRangeException.class,
			org.antlr.runtime3_2_0.MismatchedSetException.class,
			org.antlr.runtime3_2_0.MismatchedTokenException.class,
			org.antlr.runtime3_2_0.MismatchedTreeNodeException.class,
			org.antlr.runtime3_2_0.MissingTokenException.class,
			org.antlr.runtime3_2_0.NoViableAltException.class,
			org.antlr.runtime3_2_0.Parser.class,
			org.antlr.runtime3_2_0.ParserRuleReturnScope.class,
			org.antlr.runtime3_2_0.RecognitionException.class,
			org.antlr.runtime3_2_0.RecognizerSharedState.class,
			org.antlr.runtime3_2_0.RuleReturnScope.class,
			org.antlr.runtime3_2_0.SerializedGrammar.class,
			org.antlr.runtime3_2_0.Token.class,
			org.antlr.runtime3_2_0.TokenRewriteStream.class,
			org.antlr.runtime3_2_0.TokenSource.class,
			org.antlr.runtime3_2_0.TokenStream.class,
			org.antlr.runtime3_2_0.UnwantedTokenException.class,
			org.antlr.runtime3_2_0.debug.BlankDebugEventListener.class,
			org.antlr.runtime3_2_0.debug.DebugEventHub.class,
			org.antlr.runtime3_2_0.debug.DebugEventListener.class,
			org.antlr.runtime3_2_0.debug.DebugEventRepeater.class,
			org.antlr.runtime3_2_0.debug.DebugEventSocketProxy.class,
			org.antlr.runtime3_2_0.debug.DebugParser.class,
			org.antlr.runtime3_2_0.debug.DebugTokenStream.class,
			org.antlr.runtime3_2_0.debug.DebugTreeAdaptor.class,
			org.antlr.runtime3_2_0.debug.DebugTreeNodeStream.class,
			org.antlr.runtime3_2_0.debug.DebugTreeParser.class,
			org.antlr.runtime3_2_0.debug.ParseTreeBuilder.class,
			org.antlr.runtime3_2_0.debug.Profiler.class,
			org.antlr.runtime3_2_0.debug.RemoteDebugEventSocketListener.class,
			org.antlr.runtime3_2_0.debug.TraceDebugEventListener.class,
			org.antlr.runtime3_2_0.debug.Tracer.class,
			org.antlr.runtime3_2_0.misc.FastQueue.class,
			org.antlr.runtime3_2_0.misc.IntArray.class,
			org.antlr.runtime3_2_0.misc.LookaheadStream.class,
			org.antlr.runtime3_2_0.misc.Stats.class,
			org.antlr.runtime3_2_0.tree.BaseTree.class,
			org.antlr.runtime3_2_0.tree.BaseTreeAdaptor.class,
			org.antlr.runtime3_2_0.tree.BufferedTreeNodeStream.class,
			org.antlr.runtime3_2_0.tree.CommonErrorNode.class,
			org.antlr.runtime3_2_0.tree.CommonTree.class,
			org.antlr.runtime3_2_0.tree.CommonTreeAdaptor.class,
			org.antlr.runtime3_2_0.tree.CommonTreeNodeStream.class,
			org.antlr.runtime3_2_0.tree.ParseTree.class,
			org.antlr.runtime3_2_0.tree.RewriteCardinalityException.class,
			org.antlr.runtime3_2_0.tree.RewriteEarlyExitException.class,
			org.antlr.runtime3_2_0.tree.RewriteEmptyStreamException.class,
			org.antlr.runtime3_2_0.tree.RewriteRuleElementStream.class,
			org.antlr.runtime3_2_0.tree.RewriteRuleNodeStream.class,
			org.antlr.runtime3_2_0.tree.RewriteRuleSubtreeStream.class,
			org.antlr.runtime3_2_0.tree.RewriteRuleTokenStream.class,
			org.antlr.runtime3_2_0.tree.Tree.class,
			org.antlr.runtime3_2_0.tree.TreeAdaptor.class,
			org.antlr.runtime3_2_0.tree.TreeFilter.class,
			org.antlr.runtime3_2_0.tree.TreeIterator.class,
			org.antlr.runtime3_2_0.tree.TreeNodeStream.class,
			org.antlr.runtime3_2_0.tree.TreeParser.class,
			org.antlr.runtime3_2_0.tree.TreePatternLexer.class,
			org.antlr.runtime3_2_0.tree.TreePatternParser.class,
			org.antlr.runtime3_2_0.tree.TreeRewriter.class,
			org.antlr.runtime3_2_0.tree.TreeRuleReturnScope.class,
			org.antlr.runtime3_2_0.tree.TreeVisitor.class,
			org.antlr.runtime3_2_0.tree.TreeVisitorAction.class,
			org.antlr.runtime3_2_0.tree.TreeWizard.class
	};

	public void generate(ANTLRGenerationContext context, IProgressMonitor monitor) throws IOException {
		SubMonitor progress = SubMonitor.convert(monitor, "generating antlr common plug-in...", 100);
		ANTLRPluginArtifacts artifacts = new ANTLRPluginArtifacts();
		
	    List<IArtifactCreator<ANTLRGenerationContext>> creators = new ArrayList<IArtifactCreator<ANTLRGenerationContext>>();
	    File sourceFolder = 
	    	new File(context.getProjectFolder(ANTLRPluginArtifacts.ANTLR_PLUGIN).getAbsolutePath() + File.separator + SRC_FOLDER);
		
	    creators.add(new FoldersCreator<ANTLRGenerationContext>(new File[] {
	    		sourceFolder,
	    		new File(sourceFolder.getAbsolutePath() + File.separator + artifacts.PACKAGE_ANTLR_RUNTIME.getPackage().replace(".", File.separator)),
	    		new File(sourceFolder.getAbsolutePath() + File.separator + artifacts.PACKAGE_ANTLR_RUNTIME_DEBUG.getPackage().replace(".", File.separator)),
	    		new File(sourceFolder.getAbsolutePath() + File.separator + artifacts.PACKAGE_ANTLR_RUNTIME_MISC.getPackage().replace(".", File.separator)),
	    		new File(sourceFolder.getAbsolutePath() + File.separator + artifacts.PACKAGE_ANTLR_RUNTIME_TREE.getPackage().replace(".", File.separator)),
	    }));
	    
	    ClassPathParameters<ANTLRGenerationContext> cpp = new ClassPathParameters<ANTLRGenerationContext>(ANTLRPluginArtifacts.ANTLR_PLUGIN);
	    cpp.getSourceFolders().add(SRC_FOLDER);
		creators.add(new DotClasspathCreator<ANTLRGenerationContext>(ANTLRPluginArtifacts.DOT_CLASSPATH, cpp));
		
	    creators.add(new DotProjectCreator<ANTLRGenerationContext>(ANTLRPluginArtifacts.DOT_PROJECT, ANTLRPluginArtifacts.ANTLR_PLUGIN));
	    
	    BuildPropertiesParameters<ANTLRGenerationContext> bpp = new BuildPropertiesParameters<ANTLRGenerationContext>(ANTLRPluginArtifacts.ANTLR_PLUGIN);
	    bpp.getSourceFolders().add(sourceFolder.getName() + "/");
		bpp.getBinIncludes().add("META-INF/");
		bpp.getBinIncludes().add(".");

		creators.add(new BuildPropertiesCreator<ANTLRGenerationContext>(ANTLRPluginArtifacts.BUILD_PROPERTIES, bpp));
	    
	    ManifestParameters<ANTLRGenerationContext> manifestParameters = new ManifestParameters<ANTLRGenerationContext>();
		// export the generated packages
		Collection<String> exports = manifestParameters.getExportedPackages();
		exports.add(artifacts.PACKAGE_ANTLR_RUNTIME.getPackage());
		exports.add(artifacts.PACKAGE_ANTLR_RUNTIME_DEBUG.getPackage());
		exports.add(artifacts.PACKAGE_ANTLR_RUNTIME_MISC.getPackage());
		exports.add(artifacts.PACKAGE_ANTLR_RUNTIME_TREE.getPackage());

		manifestParameters.setPlugin(ANTLRPluginArtifacts.ANTLR_PLUGIN);
		manifestParameters.setBundleName("ANTLR 3.2.0 Runtime Classes");
		creators.add(new ANTLRPluginManifestCreator(ANTLRPluginArtifacts.MANIFEST, manifestParameters));

	    // add copiers for ANTLR source files
	    for (Class<?> antlrClass : antlrClassNames) {
			String relativePathSourceFile = antlrClass.getName().replace(".", "/") + ".java";
			String pathFile = antlrClass.getName().replace(".", File.separator) + ".java";
			Class<EMFTextSDKAntlrPlugin> antlrPluginClass = EMFTextSDKAntlrPlugin.class;
			URL url = antlrPluginClass.getResource("");
			String packagePath = antlrPluginClass.getPackage().getName().replace(".", "/");
			String urlString = url.toString().replace("bin/" + packagePath + "/", "");
			urlString = urlString.replace(packagePath + "/", "");
			String pathToSourceFile = urlString + "/src-runtime/" + relativePathSourceFile;
			creators.add(new FileCopier<ANTLRGenerationContext>(new URL(pathToSourceFile).openStream(), 
					new File(sourceFolder.getAbsolutePath() + File.separator + pathFile)));
	    }
	    
	    // TODO mseifert: enable this option by invoking the creator only if override = true
	    /*
		OptionTypes overrideOption = OptionTypes.OVERRIDE_ANTLR_PLUGIN;
		boolean doOverride = overrideOption == null || OptionManager.INSTANCE.getBooleanOptionValue(context.getConcreteSyntax(), overrideOption);
		*/

		for (IArtifactCreator<ANTLRGenerationContext> creator : creators) {
			progress.setTaskName("creating " + creator.getArtifactDescription() + "...");
			creator.createArtifacts(ANTLRPluginArtifacts.ANTLR_PLUGIN, context);
		    progress.worked(100 / creators.size());
	    }
	}
}

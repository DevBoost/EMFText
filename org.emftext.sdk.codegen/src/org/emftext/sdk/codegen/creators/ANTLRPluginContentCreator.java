package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.emftext.sdk.EPlugins;
import org.emftext.sdk.antlr.EMFTextSDKAntlrPlugin;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class ANTLRPluginContentCreator {

	private Class<?>[] antlrClassNames = new Class<?>[] {
			org.antlr.runtime.ANTLRFileStream.class,
			org.antlr.runtime.ANTLRInputStream.class,
			org.antlr.runtime.ANTLRReaderStream.class,
			org.antlr.runtime.ANTLRStringStream.class,
			org.antlr.runtime.BaseRecognizer.class,
			org.antlr.runtime.BitSet.class,
			org.antlr.runtime.CharStream.class,
			org.antlr.runtime.CharStreamState.class,
			org.antlr.runtime.ClassicToken.class,
			org.antlr.runtime.CommonToken.class,
			org.antlr.runtime.CommonTokenStream.class,
			org.antlr.runtime.DFA.class,
			org.antlr.runtime.EarlyExitException.class,
			org.antlr.runtime.FailedPredicateException.class,
			org.antlr.runtime.IntStream.class,
			org.antlr.runtime.Lexer.class,
			org.antlr.runtime.MismatchedNotSetException.class,
			org.antlr.runtime.MismatchedRangeException.class,
			org.antlr.runtime.MismatchedSetException.class,
			org.antlr.runtime.MismatchedTokenException.class,
			org.antlr.runtime.MismatchedTreeNodeException.class,
			org.antlr.runtime.MissingTokenException.class,
			org.antlr.runtime.NoViableAltException.class,
			org.antlr.runtime.Parser.class,
			org.antlr.runtime.ParserRuleReturnScope.class,
			org.antlr.runtime.RecognitionException.class,
			org.antlr.runtime.RecognizerSharedState.class,
			org.antlr.runtime.RuleReturnScope.class,
			org.antlr.runtime.Token.class,
			org.antlr.runtime.TokenRewriteStream.class,
			org.antlr.runtime.TokenSource.class,
			org.antlr.runtime.TokenStream.class,
			org.antlr.runtime.UnwantedTokenException.class,
			org.antlr.runtime.debug.BlankDebugEventListener.class,
			org.antlr.runtime.debug.DebugEventHub.class,
			org.antlr.runtime.debug.DebugEventListener.class,
			org.antlr.runtime.debug.DebugEventRepeater.class,
			org.antlr.runtime.debug.DebugEventSocketProxy.class,
			org.antlr.runtime.debug.DebugParser.class,
			org.antlr.runtime.debug.DebugTokenStream.class,
			org.antlr.runtime.debug.DebugTreeAdaptor.class,
			org.antlr.runtime.debug.DebugTreeNodeStream.class,
			org.antlr.runtime.debug.DebugTreeParser.class,
			org.antlr.runtime.debug.ParseTreeBuilder.class,
			org.antlr.runtime.debug.Profiler.class,
			org.antlr.runtime.debug.RemoteDebugEventSocketListener.class,
			org.antlr.runtime.debug.TraceDebugEventListener.class,
			org.antlr.runtime.debug.Tracer.class,
			org.antlr.runtime.misc.IntArray.class,
			org.antlr.runtime.misc.Stats.class,
			org.antlr.runtime.tree.BaseTree.class,
			org.antlr.runtime.tree.BaseTreeAdaptor.class,
			org.antlr.runtime.tree.CommonErrorNode.class,
			org.antlr.runtime.tree.CommonTree.class,
			org.antlr.runtime.tree.CommonTreeAdaptor.class,
			org.antlr.runtime.tree.CommonTreeNodeStream.class,
			org.antlr.runtime.tree.ParseTree.class,
			org.antlr.runtime.tree.RewriteCardinalityException.class,
			org.antlr.runtime.tree.RewriteEarlyExitException.class,
			org.antlr.runtime.tree.RewriteEmptyStreamException.class,
			org.antlr.runtime.tree.RewriteRuleElementStream.class,
			org.antlr.runtime.tree.RewriteRuleNodeStream.class,
			org.antlr.runtime.tree.RewriteRuleSubtreeStream.class,
			org.antlr.runtime.tree.RewriteRuleTokenStream.class,
			org.antlr.runtime.tree.Tree.class,
			org.antlr.runtime.tree.TreeAdaptor.class,
			org.antlr.runtime.tree.TreeNodeStream.class,
			org.antlr.runtime.tree.TreeParser.class,
			org.antlr.runtime.tree.TreePatternLexer.class,
			org.antlr.runtime.tree.TreePatternParser.class,
			org.antlr.runtime.tree.TreeRuleReturnScope.class,
			org.antlr.runtime.tree.TreeWizard.class,
			org.antlr.runtime.tree.UnBufferedTreeNodeStream.class
	};

	public void generate(GenerationContext context, IProgressMonitor monitor) throws IOException {
		SubMonitor progress = SubMonitor.convert(monitor, "generating antlr common plug-in...", 100);
		
	    List<IArtifactCreator> creators = new ArrayList<IArtifactCreator>();
	    File sourceFolder = context.getSourceFolder(EPlugins.ANTLR_PLUGIN, false);
		
	    creators.add(new FoldersCreator(new File[] {
	    		sourceFolder,
	    		new File(sourceFolder.getAbsolutePath() + File.separator + EArtifact.PACKAGE_ANTLR_RUNTIME.getPackage().replace(".", File.separator)),
	    		new File(sourceFolder.getAbsolutePath() + File.separator + EArtifact.PACKAGE_ANTLR_RUNTIME_DEBUG.getPackage().replace(".", File.separator)),
	    		new File(sourceFolder.getAbsolutePath() + File.separator + EArtifact.PACKAGE_ANTLR_RUNTIME_MISC.getPackage().replace(".", File.separator)),
	    		new File(sourceFolder.getAbsolutePath() + File.separator + EArtifact.PACKAGE_ANTLR_RUNTIME_TREE.getPackage().replace(".", File.separator)),
	    }));
	    creators.add(new DotClasspathCreator(EPlugins.ANTLR_PLUGIN));
	    creators.add(new DotProjectCreator(EPlugins.ANTLR_PLUGIN));
	    creators.add(new BuildPropertiesCreator(EPlugins.ANTLR_PLUGIN));
	    creators.add(new ANTLRPluginManifestCreator());

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
			creators.add(new FileCopier(new URL(pathToSourceFile).openStream(), 
					new File(sourceFolder.getAbsolutePath() + File.separator + pathFile)));
	    }
	    
		OptionTypes overrideOption = OptionTypes.OVERRIDE_ANTLR_PLUGIN;
		boolean doOverride = overrideOption == null || OptionManager.INSTANCE.getBooleanOptionValue(context.getConcreteSyntax(), overrideOption);

		for (IArtifactCreator creator : creators) {
			if (doOverride) {
				progress.setTaskName("creating " + creator.getArtifactDescription() + "...");
				creator.createArtifacts(context);
			}
		    progress.worked(100 / creators.size());
	    }
	}
}

package org.emftext.sdk.codegen.antlr;

import java.io.File;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IContext;
import org.emftext.sdk.codegen.creators.AbstractGenerationComponent;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * This class is passed along the creators and generators of the ANTLR commons
 * plug-in. It carries a concrete syntax object, which is used to determine the
 * value of override options.
 */
public class ANTLRGenerationContext extends AbstractGenerationComponent implements IContext {

	private ConcreteSyntax concreteSyntax;
	private IPluginDescriptor antlrPlugin;

	public ANTLRGenerationContext(ICodeGenerationComponent parent, ConcreteSyntax concreteSyntax, IPluginDescriptor antlrPlugin) {
		super(parent);
		this.concreteSyntax = concreteSyntax;
		this.antlrPlugin = antlrPlugin;
	}

	public File getFile(IPluginDescriptor plugin, ArtifactDescriptor<?, ?> artifact) {
		throw new UnsupportedOperationException();
	}

	public File getProjectFolder(IPluginDescriptor plugin) {
		return getFileSystemConnector().getProjectFolder(plugin);
	}

	public ConcreteSyntax getConcreteSyntax() {
		return concreteSyntax;
	}

	public IPluginDescriptor getAntlrPlugin() {
		return antlrPlugin;
	}
}

package org.emftext.sdk.codegen.antlr;

import java.io.File;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IContext;
import org.emftext.sdk.codegen.creators.AbstractGenerationComponent;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

public class ANTLRGenerationContext extends AbstractGenerationComponent implements IContext {

	private ConcreteSyntax concreteSyntax;

	public ANTLRGenerationContext(ConcreteSyntax concreteSyntax) {
		super();
		this.concreteSyntax = concreteSyntax;
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
}

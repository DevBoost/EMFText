package org.emftext.test;

import java.io.File;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * A stub implementation of a generation context that can be used
 * to test generators.
 */
public class TestGenerationContext extends GenerationContext {

	public TestGenerationContext(ConcreteSyntax concreteSyntax,
			IProblemCollector problemCollector) {
		super(concreteSyntax, problemCollector);
	}

	@Override
	public File getPluginProjectFolder() {
		return null;
	}

	@Override
	public String getSyntaxProjectName() {
		return null;
	}

	@Override
	public String getSyntaxProjectRelativePath() {
		return null;
	}
}

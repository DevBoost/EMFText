package org.emftext.sdk.syntax_analysis;

import java.io.File;
import java.util.Collection;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.codegen.util.GeneratorUtil;
import org.emftext.sdk.codegen.util.NameUtil;
import org.emftext.sdk.codegen.util.PathUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

public class UnusedResolverAnalyser extends AbstractPostProcessor {
	
	private final GeneratorUtil generatorUtil = new GeneratorUtil();
	private final NameUtil nameUtil = new NameUtil();
	private final PathUtil pathUtil = new PathUtil();

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		// this analyser does only work when the platform is running, because
		// it needs the workspace to determine the folder the text resource 
		// is generated to
		if (!Platform.isRunning()) {
			return;
		}
		Collection<String> resolverFileNames = generatorUtil.getResolverFileNames(syntax);
		String workspaceRootFolder = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
		
		String pluginProjectFolder = workspaceRootFolder + File.separator + nameUtil.getPluginName(syntax);
		
		File resolverPackageFolder = pathUtil.getResolverPackageFile(syntax, pluginProjectFolder);
		if (!resolverPackageFolder.exists()) {
			return;
		}
		File[] contents = resolverPackageFolder.listFiles();
		for (File member : contents) {
			if (!member.isDirectory()) {
				String fileName = member.getName();
				if (!resolverFileNames.contains(fileName)) {
					// issue warning about unused resolver
					((ITextResource) syntax.eResource()).addWarning("Found unused class '" + fileName + "' in analysis package.", null);
				}
			}
		}
	}
}

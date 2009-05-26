package org.emftext.sdk.codegen.util;

import java.io.File;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.finders.GenClassFinder;

/**
 * A utility class that can be used to derive paths and packages where different artifacts
 * created by EMFText are stored in.
 */
public class PathUtil {

	private final GenClassFinder genClassFinder = new GenClassFinder();
	private final NameUtil nameUtil = new NameUtil();

	public File getSourceFolder(ConcreteSyntax syntax, String pluginProjectFolder) {
		String srcFolderName;
		String srcFolderOptionValue = OptionManager.INSTANCE.getStringOptionValue(syntax, OptionTypes.SOURCE_FOLDER);
		if (srcFolderOptionValue != null) {
			// use package plug-in from option
			srcFolderName = srcFolderOptionValue;
		} else {
			// use default plug-in name
			srcFolderName = "src";
		}
		return new File(pluginProjectFolder + File.separator + srcFolderName);
	}
	
	/**
	 * Returns the name of the package where token and reference resolvers 
	 * must go to. Depending on the given generator feature this package
	 * might be part of a resource plug-in that belongs to an imported
	 * syntax.
	 */
	public String getResolverPackageName(ConcreteSyntax syntax, GenFeature genFeature) {
		ConcreteSyntax featureSyntax = getConcreteSyntax(syntax, genFeature);
		return nameUtil.getResolverPackageName(featureSyntax);
	}

	// feature may be contained in imported rules and thus belong to a different
	// CS specification
	private ConcreteSyntax getConcreteSyntax(ConcreteSyntax syntax, GenFeature genFeature) {
		for (Import nextImport : syntax.getImports()) {
			ConcreteSyntax nextSyntax = nextImport.getConcreteSyntax();
			if (nextSyntax == null) {
				continue;
			}
			if (genClassFinder.contains(genClassFinder.findAllGenClasses(nextSyntax, true, true), genFeature.getGenClass())) {
				ConcreteSyntax cs = genClassFinder.getContainingSyntax(nextSyntax, genFeature.getGenClass());
				return cs;
			}
		}
		return syntax;
	}

	public IPath getResolverPackagePath(ConcreteSyntax syntax) {
		return new Path(nameUtil.getResolverPackageName(syntax).replaceAll("\\.","/"));
	}

	public File getResolverPackageFile(ConcreteSyntax syntax, String pluginProjectFolder) {
		return new File(getSourceFolder(syntax, pluginProjectFolder).getAbsolutePath() + File.separator + getResolverPackagePath(syntax));
	}
}

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
package org.emftext.sdk.codegen;

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

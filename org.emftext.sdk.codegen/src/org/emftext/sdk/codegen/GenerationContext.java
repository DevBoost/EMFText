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
import java.util.Collection;
import java.util.LinkedHashSet;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.sdk.Constants;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.finders.GenClassFinder;

/**
 * A GenerationContext provides all information that is needed by the 
 * generators. This includes a resolved concrete syntax, 
 * a package name for parser and printer, a package name for resolvers 
 * (reference and token resolvers) and a resource target folder. Furthermore,
 * the context collects information about the generation process as it
 * is executed.
 * 
 * @see org.emftext.sdk.codegen.creators.ResourcePluginContentCreator
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
public abstract class GenerationContext {
	
	private static final String ANTRL_GRAMMAR_FILE_EXTENSION = ".g";

	private static final String DEFAULT_NEW_ICON_NAME = "default_new_icon.gif";
	private static final String DEFAULT_EDITOR_ICON_NAME = "editor_icon.gif";
	private static final String DEFAULT_ICON_DIR = "icons";
	private static final String SCHEMA_DIR = "schema";
	
	private final NameUtil nameUtil = new NameUtil();

	private final ConcreteSyntax concreteSyntax;
	private final IProblemCollector problemCollector;
	private final GenClassFinder genClassFinder = new GenClassFinder();
	
	private Collection<GenFeature> nonContainmentReferences = new LinkedHashSet<GenFeature>();

	private ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();
	
	public GenerationContext(ConcreteSyntax concreteSyntax, IProblemCollector problemCollector) {
		if (concreteSyntax == null) {
			throw new IllegalArgumentException("A concrete syntax must be specified!");
		}
		this.concreteSyntax = concreteSyntax;
		this.problemCollector = problemCollector;
	}

	/**
	 * @return The concrete syntax to be processed and which is 
	 * assumed to contain all resolved information.
	 */
	public ConcreteSyntax getConcreteSyntax(){
		return concreteSyntax;
	}
	
	public abstract File getPluginProjectFolder();

	/**
	 * Returns the actual file which contains the CS specification.
	 */
	public File getConcreteSyntaxFile() {
		Resource resource = concreteSyntax.eResource();
		URI uri = resource.getURI();
		File file = new File(uri.toFileString());
		return file;
	}
	
	public File getOutputFolder() {
		return new File(getPluginProjectFolder().getAbsolutePath() + File.separator + "bin");
	}

	public String getPluginName() {
		return csUtil.getPluginName(concreteSyntax);
	}

	public String getPackageName(EArtifact artifact) {
		return getPackageName(artifact, concreteSyntax);
	}

	public String getPackageName(EArtifact artifact, ConcreteSyntax syntax) {
		return nameUtil.getPackageName(syntax, artifact);
	}

	/**
	 * Returns the name of the package where token and reference resolvers 
	 * must go to.
	 */
	public String getResolverPackageName() {
		return csUtil.getResolverPackageName(concreteSyntax);
	}
	
	public IProblemCollector getProblemCollector() {
		return problemCollector;
	}
	
	public String getCapitalizedConcreteSyntaxName(ConcreteSyntax syntax) {
		return csUtil.getCapitalizedConcreteSyntaxName(syntax);
	}
	
	public String getCapitalizedConcreteSyntaxName() {
		return getCapitalizedConcreteSyntaxName(getConcreteSyntax());
	}
	
    // TODO remove this method. the nc-references should not be added
    // by the parser generators
	public void addNonContainmentReference(GenFeature proxyReference) {
		nonContainmentReferences.add(proxyReference);
	}

	public Collection<GenFeature> getNonContainmentReferences() {
		return nonContainmentReferences;
	}

	public boolean isImportedWithSyntaxReference(GenFeature genFeature) {
		ConcreteSyntax containingSyntax = genClassFinder.getContainingSyntax(concreteSyntax, genFeature.getGenClass());
		if (containingSyntax == null) {
			return false;
		}
		if (containingSyntax == concreteSyntax) {
			return false;
		}
		return true;
	}

	/**
	 * Returns the qualified class name of the reference resolver for the given reference. If
	 * inImportedSyntax is set to true, the name of the resolver in the imported resource plug-in
	 * is returned if the rule containing the reference is imported. Otherwise (if the containing
	 * rule is not imported or inImportedSyntax is false), the name of the resolver in the currrent
	 * resource plug-in is returned.
	 * 
	 * @param proxyReference
	 * @param inImportedSyntax
	 * 
	 * @return the fully qualified reference resolver class name
	 */
	public String getQualifiedReferenceResolverClassName(GenFeature proxyReference, boolean inImportedSyntax) {
		return getResolverPackageName(proxyReference, inImportedSyntax) + "." + csUtil.getReferenceResolverClassName(proxyReference);
	}

	private String getResolverPackageName(GenFeature proxyReference, boolean inImportedSyntax) {
		return csUtil.getResolverPackageName(getConcreteSyntax(), proxyReference, inImportedSyntax);
	}

	public String getReferenceResolverAccessor(GenFeature genFeature) {
		String prefix = "getReferenceResolverSwitch() == null ? null : ";
		return prefix + "getReferenceResolverSwitch().get" + csUtil.getReferenceResolverClassName(genFeature) + "()";
	}

	public void addGetMetaInformationMethod(StringComposite sc) {
		sc.add("public " + getQualifiedClassName(EArtifact.META_INFORMATION) + " getMetaInformation() {");
		sc.add("return new " + getQualifiedClassName(EArtifact.META_INFORMATION) + "();");
		sc.add("}");
		sc.addLineBreak();
	}

	/**
	 * Returns the name of the project that contains the concrete 
	 * syntax definition. Note that this is usually NOT the text
	 * resource project.
	 */
	public abstract String getSyntaxProjectName();

	/**
	 * Returns the path of the concrete syntax definition
	 * file relative to the project that contains the
	 * file.
	 */
	public abstract String getProjectRelativePathToSyntaxFile();

	public File getIconsDir() {
		return new File(getPluginProjectFolder().getAbsolutePath() + File.separator + DEFAULT_ICON_DIR);
	}

	public File getSchemaFolder() {
		return new File(getPluginProjectFolder().getAbsolutePath() + File.separator + SCHEMA_DIR);
	}
	
	public File getNewIconFile() {
		return new File(getIconsDir().getAbsolutePath() + File.separator + DEFAULT_NEW_ICON_NAME);
	}

	public File getEditorIconFile() {
		return new File(getIconsDir().getAbsolutePath() + File.separator + DEFAULT_EDITOR_ICON_NAME);
	}

	public String getProjectRelativeNewIconPath() {
		// it is OK to use slashes here, because this path is put into
		// the plugin.xml
		return "/" + DEFAULT_ICON_DIR + "/" + DEFAULT_NEW_ICON_NAME;
	}

	public boolean isGenerateTestActionEnabled() {
		return OptionManager.INSTANCE.getBooleanOptionValue(getConcreteSyntax(), OptionTypes.GENERATE_TEST_ACTION);
	}

	public String getPackagePath(EArtifact artifact) {
		OptionTypes overrideOption = artifact.getOverrideOption();
		boolean doOverride = overrideOption == null || OptionManager.INSTANCE.getBooleanOptionValue(getConcreteSyntax(), overrideOption);
		File targetFolder = getSourceFolder(doOverride);
		IPath csPackagePath = new Path(getPackageName(artifact).replaceAll("\\.","/"));
		String targetFolderPath = targetFolder.getAbsolutePath();
		String packagePath = targetFolderPath + File.separator + csPackagePath + File.separator;
		return packagePath;
	}

	public File getSourceFolder(boolean doOverride) {
		return csUtil.getSourceFolder(getConcreteSyntax(), doOverride, getPluginProjectFolder().getAbsolutePath());
	}

	public File getResolverFile(GenFeature proxyReference) {
		OptionTypes overrideOption = OptionTypes.OVERRIDE_REFERENCE_RESOLVERS;
		boolean doOverride = overrideOption == null || OptionManager.INSTANCE.getBooleanOptionValue(getConcreteSyntax(), overrideOption);
		File resolverFile = new File(getSourceFolder(doOverride) + File.separator + getResolverPackagePath() + File.separator + csUtil.getReferenceResolverClassName(proxyReference) + Constants.JAVA_FILE_EXTENSION);
		return resolverFile;
	}

	private IPath getResolverPackagePath() {
		return csUtil.getResolverPackagePath(getConcreteSyntax());
	}

	public File getTokenResolverFile(ConcreteSyntax syntax, TokenDefinition tokenDefinition) {
		OptionTypes overrideOption = OptionTypes.OVERRIDE_TOKEN_RESOLVERS;
		boolean doOverride = overrideOption == null || OptionManager.INSTANCE.getBooleanOptionValue(getConcreteSyntax(), overrideOption);
		return new File(getSourceFolder(doOverride).getAbsolutePath() + File.separator + getResolverPackagePath() + File.separator + csUtil.getTokenResolverClassName(syntax, tokenDefinition) + Constants.JAVA_FILE_EXTENSION);
	}

	public File getANTLRGrammarFile() {
		String antlrName = getCapitalizedConcreteSyntaxName();
		String packagePath = getPackagePath(EArtifact.ANTLR_GRAMMAR);
  		File antlrFile = new File(packagePath + antlrName + ANTRL_GRAMMAR_FILE_EXTENSION);
		return antlrFile;
	}

	public String getDefaultResolverDelegateName() {
		return csUtil.getDefaultResolverDelegateName(getConcreteSyntax());
	}
	
	public String getQualifiedDefaultResolverDelegateName() {
		return getResolverPackageName() + "." + getDefaultResolverDelegateName();
	}

	public String getClassName(EArtifact artifact) {
		return getClassName(artifact, getConcreteSyntax());
	}

	public String getClassName(EArtifact artifact, ConcreteSyntax syntax) {
		return artifact.getClassNamePrefix() + getCapitalizedConcreteSyntaxName(syntax) + artifact.getClassNameSuffix();
	}

	public String getQualifiedClassName(EArtifact artifact) {
		return getPackageName(artifact) + "." + getClassName(artifact);
	}

	public String getQualifiedClassName(EArtifact artifact, ConcreteSyntax syntax) {
		return getPackageName(artifact, syntax) + "." + getClassName(artifact, syntax);
	}

	public File getFile(EArtifact artifact) {
		return new File(getPackagePath(artifact) + getClassName(artifact) + Constants.JAVA_FILE_EXTENSION);
	}
}

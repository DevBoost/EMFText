/*******************************************************************************
 * Copyright (c) 2006-2012
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
package org.emftext.sdk.codegen.resource;

import java.io.File;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.sdk.Constants;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.AbstractGenerationContext;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IFileSystemConnector;
import org.emftext.sdk.codegen.IPackage;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.codegen.ISyntaxContext;
import org.emftext.sdk.codegen.util.NameUtil;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.finders.GenClassFinder;
import org.emftext.sdk.util.ConcreteSyntaxUtil;

/**
 * A GenerationContext provides all information that is needed by the 
 * text resource plug-in generators. This includes a resolved concrete syntax, 
 * package names (e.g., for parsers, printers, and for reference and token 
 * resolvers). Furthermore, the context collects information about the 
 * generation process as it is executed.
 * 
 * @see org.emftext.sdk.codegen.resource.creators.ResourcePluginContentCreator
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
public abstract class GenerationContext extends AbstractGenerationContext<GenerationContext> implements ISyntaxContext {
	
	private static final String ANTRL_GRAMMAR_FILE_EXTENSION = ".g";
	private static final String SCHEMA_DIR = "schema";
	
	private final ConcreteSyntax concreteSyntax;
	
	private final GenClassFinder genClassFinder = new GenClassFinder();
	private final GeneratorUtil genUtil = new GeneratorUtil();
	private final NameUtil nameUtil = new NameUtil();
	private final ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();

	private String licenceText;
	private boolean antlrGrammarHasChanged;
	
	private ConstantsPool constantsPool = new ConstantsPool();
	
	private IPluginDescriptor resourcePlugin;
	private IPluginDescriptor resourceUIPlugin;
	private IPluginDescriptor antlrPlugin;

	public GenerationContext(IFileSystemConnector fileSystemConnector, IProblemCollector problemCollector, ConcreteSyntax concreteSyntax) {
		super(fileSystemConnector, problemCollector);
		if (concreteSyntax == null) {
			throw new IllegalArgumentException("A concrete syntax must be specified!");
		}
		this.concreteSyntax = concreteSyntax;
	}

	/**
	 * @return The concrete syntax to be processed and which is 
	 * assumed to contain all resolved information.
	 */
	public ConcreteSyntax getConcreteSyntax() {
		return concreteSyntax;
	}
	
	/**
	 * Returns the actual file which contains the CS specification.
	 */
	public File getConcreteSyntaxFile() {
		Resource resource = concreteSyntax.eResource();
		URI uri = resource.getURI();
		File file = new File(uri.toFileString());
		return file;
	}
	
	public String getPackageName(ArtifactDescriptor<GenerationContext, ?> artifact) {
		IPackage<ISyntaxContext> artifactPackage = artifact.getPackage();
		if (artifactPackage == null) {
			return "";
		}
		return artifactPackage.getName(this);
	}

	/**
	 * Returns the name of the package where token and reference resolvers 
	 * must go to. Depending on the given generator feature this package
	 * might be part of a resource plug-in that belongs to an imported
	 * syntax.
	 */
	public String getResolverPackageName(ConcreteSyntax syntax, GenFeature genFeature, boolean inImportedSyntax) {
		if (inImportedSyntax) {
			syntax = csUtil.getConcreteSyntax(syntax, genFeature);
		}
		return nameUtil.getResolverPackageName(syntax);
	}

	/**
	 * Returns the name of the package where token and reference resolvers 
	 * must go to.
	 */
	public String getResolverPackageName() {
		return nameUtil.getResolverPackageName(concreteSyntax);
	}
	
	public String getCapitalizedConcreteSyntaxName(ConcreteSyntax syntax) {
		return nameUtil.getCapitalizedConcreteSyntaxName(syntax);
	}
	
	public String getCapitalizedConcreteSyntaxName() {
		return getCapitalizedConcreteSyntaxName(getConcreteSyntax());
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
		return getResolverPackageName(proxyReference, inImportedSyntax) + "." + nameUtil.getReferenceResolverClassName(proxyReference);
	}

	private String getResolverPackageName(GenFeature proxyReference, boolean inImportedSyntax) {
		return getResolverPackageName(getConcreteSyntax(), proxyReference, inImportedSyntax);
	}

	public String getReferenceResolverAccessor(GenFeature genFeature) {
		String prefix = "getReferenceResolverSwitch() == null ? null : ";
		return prefix + "getReferenceResolverSwitch().get" + nameUtil.getReferenceResolverClassName(genFeature) + "()";
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

	public boolean isGenerateTestActionEnabled() {
		return OptionManager.INSTANCE.getBooleanOptionValue(getConcreteSyntax(), OptionTypes.GENERATE_TEST_ACTION);
	}

	public String getPackagePath(IPluginDescriptor plugin, ArtifactDescriptor<GenerationContext, ?> artifact) {
		OptionTypes overrideOption = artifact.getOverrideOption();
		boolean doOverride = overrideOption == null || OptionManager.INSTANCE.getBooleanOptionValue(getConcreteSyntax(), overrideOption);
		File targetFolder = getSourceFolder(plugin, doOverride);
		IPath csPackagePath = new Path(artifact.getPackage().getName(this).replaceAll("\\.","/"));
		String targetFolderPath = targetFolder.getAbsolutePath();
		String packagePath = targetFolderPath + File.separator + csPackagePath + File.separator;
		return packagePath;
	}

	public File getSourceFolder(IPluginDescriptor plugin, boolean doOverride) {
		boolean isUiPlugin = plugin == getResourceUIPlugin();
		return csUtil.getSourceFolder(getConcreteSyntax(), doOverride, isUiPlugin, getFileSystemConnector().getProjectFolder(plugin).getAbsolutePath());
	}

	public File getTokenResolverFile(ConcreteSyntax syntax, CompleteTokenDefinition tokenDefinition) {
		OptionTypes overrideOption = OptionTypes.OVERRIDE_TOKEN_RESOLVERS;
		boolean doOverride = overrideOption == null || OptionManager.INSTANCE.getBooleanOptionValue(getConcreteSyntax(), overrideOption);
		return new File(getSourceFolder(nameUtil.getResourcePluginDescriptor(syntax), doOverride).getAbsolutePath() + File.separator + genUtil.getResolverPackagePath(syntax) + File.separator + nameUtil.getTokenResolverClassName(syntax, tokenDefinition) + Constants.JAVA_FILE_EXTENSION);
	}

	public File getANTLRGrammarFile(IPluginDescriptor plugin) {
		String antlrName = getCapitalizedConcreteSyntaxName();
		String packagePath = getPackagePath(plugin, TextResourceArtifacts.ANTLR_GRAMMAR);
  		File antlrFile = new File(packagePath + antlrName + ANTRL_GRAMMAR_FILE_EXTENSION);
		return antlrFile;
	}

	public String getDefaultResolverDelegateName() {
		return nameUtil.getDefaultResolverDelegateName(getConcreteSyntax());
	}
	
	public String getQualifiedDefaultResolverDelegateName() {
		return getResolverPackageName() + "." + getDefaultResolverDelegateName();
	}

	public String getClassName(ArtifactDescriptor<?, ?> artifact) {
		return getClassName(artifact, getConcreteSyntax());
	}

	public String getClassName(ArtifactDescriptor<?, ?> artifact, ConcreteSyntax syntax) {
		return artifact.getClassNamePrefix() + getCapitalizedConcreteSyntaxName(syntax) + artifact.getClassNameSuffix();
	}

	public String getQualifiedClassName(ArtifactDescriptor<GenerationContext, ?> artifact) {
		return getPackageName(artifact) + "." + getClassName(artifact);
	}

	public String getQualifiedClassName(ArtifactDescriptor<GenerationContext, ?> artifact, final ConcreteSyntax syntax) {
		return artifact.getPackage().getName(new ISyntaxContext() {
			
			public ConcreteSyntax getConcreteSyntax() {
				return syntax;
			}
		}) + "." + getClassName(artifact, syntax);
	}

	public File getFile(IPluginDescriptor plugin, ArtifactDescriptor<GenerationContext, ?> artifact) {
		return new File(getPackagePath(plugin, artifact) + getClassName(artifact) + Constants.JAVA_FILE_EXTENSION);
	}

	public String getLicenceText() {
		return licenceText;
	}

	public void setLicenceText(String text) {
		this.licenceText = text;
	}

	/**
	 * The result of this method indicates whether generating 
	 * the ANTLR commons plug-in is required or not.
	 * 
	 * @return true if the ANTLR commons plug-in must be created
	 */
	public abstract boolean getGenerateANTLRPlugin();

	public void setANTLRGrammarHasChanged() {
		antlrGrammarHasChanged = true;
	}

	public boolean getANTLRGrammarHasChanged() {
		return antlrGrammarHasChanged;
	}

	public IPluginDescriptor getResourcePlugin() {
		return resourcePlugin;
	}

	public IPluginDescriptor getResourceUIPlugin() {
		return resourceUIPlugin;
	}

	public void setResourcePlugin(IPluginDescriptor resourcePlugin) {
		this.resourcePlugin = resourcePlugin;
	}

	public void setResourceUIPlugin(IPluginDescriptor resourceUIPlugin) {
		this.resourceUIPlugin = resourceUIPlugin;
	}

	public File getSchemaFolder(IPluginDescriptor plugin) {
		return new File(getFileSystemConnector().getProjectFolder(plugin).getAbsolutePath() + File.separator + SCHEMA_DIR);
	}

	public IPluginDescriptor getAntlrPlugin() {
		return antlrPlugin;
	}

	public void setAntlrPlugin(IPluginDescriptor antlrPlugin) {
		this.antlrPlugin = antlrPlugin;
	}

	public String getOccurrenceAnnotationTypeID() {
		return getResourceUIPlugin().getName() + ".occurences";
	}

	public String getDeclarationAnnotationTypeID() {
		return getOccurrenceAnnotationTypeID() + ".declaration";
	}

	public boolean getGeneratorModelCode() {
		return true;
	}

	public String getLaunchConfigurationTypeID() {
		return getResourceUIPlugin().getName() + ".launchConfigurationType";
	}

	public boolean isLaunchSupportEnabled() {
		ConcreteSyntax syntax = getConcreteSyntax();
		OptionManager optionManager = OptionManager.INSTANCE;
		boolean launchSupportDisabled = optionManager.getBooleanOptionValue(syntax, OptionTypes.DISABLE_LAUNCH_SUPPORT);
		boolean removeEclipseCode = optionManager.getBooleanOptionValue(syntax, OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE);
		return !launchSupportDisabled && !removeEclipseCode;
	}

	public boolean isDebugSupportEnabled() {
		ConcreteSyntax syntax = getConcreteSyntax();
		OptionManager optionManager = OptionManager.INSTANCE;
		boolean disableDebugSupport = optionManager.getBooleanOptionValue(syntax, OptionTypes.DISABLE_DEBUG_SUPPORT);
		boolean removeEclipseDependentCode = optionManager.getBooleanOptionValue(syntax, OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE);
		return !disableDebugSupport && !removeEclipseDependentCode;
	}

	public String getSourceLocatorID() {
		return getResourceUIPlugin().getName() + ".sourceLocator";
	}

	public String getSourcePathComputerID() {
		return getResourceUIPlugin().getName() + ".sourcePathComputer";
	}

	public String getLineBreakpointMarkerID() {
		return getResourcePlugin().getName() + ".debug.lineBreakpoint.marker";
	}

	public String getLineBreakpointAnnotationID() {
		return getResourceUIPlugin().getName() + ".debug.lineBreakpoint";
	}

	public String getDebugModelID() {
		return getResourcePlugin().getName() + ".debugModel";
	}

	public String getEditorContextID() {
		return getResourcePlugin().getName() + ".EditorContext";
	}

	public String getEditorRulerID() {
		return getResourcePlugin().getName() + ".EditorRuler";
	}

	public ConstantsPool getConstantsPool() {
		return constantsPool;
	}
}

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
import org.emftext.runtime.resource.IReferenceResolver;
import org.emftext.runtime.resource.ITextResourcePluginMetaInformation;
import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.ITokenResolverFactory;
import org.emftext.sdk.codegen.util.NameUtil;
import org.emftext.sdk.codegen.util.PathUtil;
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
 * 
 * TODO this class is a total mess. we must figure out what really belongs in here.
 * some of the code has already been move to NameUtil, PathUtil and ConcreteSyntaxUtil.
 */
public abstract class GenerationContext {
	
	public static final String CLASS_SUFFIX_TOKEN_RESOLVER = ITokenResolver.class.getSimpleName().substring(1);
	public static final String CLASS_SUFFIX_TOKEN_RESOLVER_FACTORY = ITokenResolverFactory.class.getSimpleName().substring(1);
	public static final String CLASS_SUFFIX_REFERENCE_RESOLVER = IReferenceResolver.class.getSimpleName().substring(1);
	public static final String CLASS_SUFFIX_META_INFORMATION = ITextResourcePluginMetaInformation.class.getSimpleName().substring("ITextResourcePlugin".length());
	public static final String CLASS_SUFFIX_DEFAULT_RESOLVER_DELEFATE = "DefaultResolverDelegate";

	private static final String CLASS_SUFFIX_PRINTER = "Printer";
	private static final String CLASS_SUFFIX_PRINTER_BASE = "PrinterBase";
	private static final String CLASS_SUFFIX_RESOURCE = "Resource";
	private static final String CLASS_SUFFIX_RESOURCE_FACTORY = "ResourceFactory";
	private static final String CLASS_SUFFIX_REFERENCE_RESOLVER_SWITCH = "ReferenceResolverSwitch";
	private static final String CLASS_SUFFIX_NEW_FILE_WIZARD = "NewFileWizard";
	
	private static final String ANTRL_GRAMMAR_FILE_EXTENSION = ".g";
	public static final String JAVA_FILE_EXTENSION = ".java";

	private static final String DEFAULT_NEW_ICON_NAME = "default_new_icon.gif";
	private static final String DEFAULT_ICON_DIR = "icons";
	
	private final NameUtil nameUtil = new NameUtil();
	private final PathUtil pathUtil = new PathUtil();

	private final ConcreteSyntax concreteSyntax;
	private final IProblemCollector problemCollector;
	private final GenClassFinder genClassFinder = new GenClassFinder();
	
	private Collection<GenFeature> nonContainmentReferences = new LinkedHashSet<GenFeature>();
	
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
		return nameUtil.getPluginName(concreteSyntax);
	}

	public String getPackageName() {
		return nameUtil.getPackageName(concreteSyntax);
	}

	/**
	 * Returns the name of the package where token and reference resolvers 
	 * must go to.
	 */
	public String getResolverPackageName() {
		return nameUtil.getResolverPackageName(concreteSyntax);
	}
	
	public IProblemCollector getProblemCollector() {
		return problemCollector;
	}
	
	public String getCapitalizedConcreteSyntaxName() {
		return nameUtil.getCapitalizedConcreteSyntaxName(getConcreteSyntax());
	}
	
    public String getPrinterName() {
    	return getCapitalizedConcreteSyntaxName() + CLASS_SUFFIX_PRINTER;
    }
    
    public String getPrinterBaseClassName() {
    	return getCapitalizedConcreteSyntaxName() + CLASS_SUFFIX_PRINTER_BASE;
    }
    
    public String getResourceClassName() {
    	return getCapitalizedConcreteSyntaxName() + CLASS_SUFFIX_RESOURCE;
    }
    
    public String getResourceFactoryClassName() {
    	return getCapitalizedConcreteSyntaxName() + CLASS_SUFFIX_RESOURCE_FACTORY;
    }
    
    public String getNewFileActionClassName() {
    	return getCapitalizedConcreteSyntaxName() + CLASS_SUFFIX_NEW_FILE_WIZARD;
    }
    
	public String getQualifiedNewFileActionName() {
		return getPackageName() + "." + getNewFileActionClassName();
	}

	public String getReferenceResolverSwitchClassName() {
    	return getCapitalizedConcreteSyntaxName() + CLASS_SUFFIX_REFERENCE_RESOLVER_SWITCH;
    }
    
    public String getQualifiedReferenceResolverSwitchClassName() {
    	return getPackageName() + "." + getReferenceResolverSwitchClassName();
    }
    
    public String getTokenResolverFactoryClassName() {
    	return getCapitalizedConcreteSyntaxName() + CLASS_SUFFIX_TOKEN_RESOLVER_FACTORY;
    }

    public String getQualifiedTokenResolverFactoryClassName() {
    	return getPackageName() + "." + getTokenResolverFactoryClassName();
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
		//Set<GenClass> classesExceptImports = genClassFinder.findAllGenClasses(concreteSyntax, false, false);
		ConcreteSyntax containingSyntax = genClassFinder.getContainingSyntax(concreteSyntax, genFeature.getGenClass());
		if (containingSyntax == null) return false;
		if (containingSyntax == concreteSyntax) return false;
		return true;
	}

	public String getQualifiedReferenceResolverClassName(
			GenFeature proxyReference) {
		return getResolverPackageName(proxyReference) + "." + nameUtil.getReferenceResolverClassName(proxyReference);
	}

	private String getResolverPackageName(GenFeature proxyReference) {
		return pathUtil.getResolverPackageName(getConcreteSyntax(), proxyReference);
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

	public File getIconsDir() {
		return new File(getPluginProjectFolder().getAbsolutePath() + File.separator + DEFAULT_ICON_DIR);
	}

	public File getNewIconFile() {
		return new File(getIconsDir().getAbsolutePath() + File.separator + DEFAULT_NEW_ICON_NAME);
	}

	public String getProjectRelativeNewIconPath() {
		// it is OK to use slashes here, because this path is put into
		// the plugin.xml
		return "/" + DEFAULT_ICON_DIR + "/" + DEFAULT_NEW_ICON_NAME;
	}

	public boolean isGenerateTestActionEnabled() {
		return OptionManager.INSTANCE.getBooleanOptionValue(getConcreteSyntax(), OptionTypes.GENERATE_TEST_ACTION);
	}

	public String getParserClassName() {
		return getCapitalizedConcreteSyntaxName() + "Parser";
	}

	public String getQualifiedParserClassName() {
		return getPackageName() + "." + getParserClassName();
	}

	public String getQualifiedLexerClassName() {
		return getPackageName() + "." + getCapitalizedConcreteSyntaxName() + "Lexer";
	}

	public String getQualifiedPrinterName() {
		return getPackageName() + "." + getPrinterName();
	}

	public String getPackagePath() {
		File targetFolder = getSourceFolder();
		IPath csPackagePath = new Path(getPackageName().replaceAll("\\.","/"));
		String targetFolderPath = targetFolder.getAbsolutePath();
		String packagePath = targetFolderPath + File.separator + csPackagePath + File.separator;
		return packagePath;
	}

	public File getSourceFolder() {
		return pathUtil.getSourceFolder(getConcreteSyntax(), getPluginProjectFolder().getAbsolutePath());
	}

	public File getPrinterFile() {
		return new File(getPackagePath() + getPrinterName() + JAVA_FILE_EXTENSION);
	}

	public File getPrinterBaseFile() {
		return new File(getPackagePath() + getPrinterBaseClassName() + JAVA_FILE_EXTENSION);
	}

	public File getTextResourceFile() {
		return new File(getPackagePath() + getResourceClassName() + JAVA_FILE_EXTENSION);
	}

	public File getTokenResolverFactoryFile() {
		return new File(getPackagePath() + getTokenResolverFactoryClassName() + JAVA_FILE_EXTENSION);
	}

	public File getNewFileWizardFile() {
		return new File(getPackagePath() + getNewFileActionClassName() + JAVA_FILE_EXTENSION);
	}

	public File getReferenceResolverSwitchFile() {
		return new File(getPackagePath() + getReferenceResolverSwitchClassName() + JAVA_FILE_EXTENSION);
	}

	public File getResourceFactoryFile() {
		return new File(getPackagePath() + getResourceFactoryClassName() + JAVA_FILE_EXTENSION);
	}

	public File getResolverFile(GenFeature proxyReference) {
		File resolverFile = new File(getSourceFolder() + File.separator + getResolverPackagePath() + File.separator + nameUtil.getReferenceResolverClassName(proxyReference) + JAVA_FILE_EXTENSION);
		return resolverFile;
	}

	private IPath getResolverPackagePath() {
		return pathUtil.getResolverPackagePath(getConcreteSyntax());
	}

	public File getTokenResolverFile(ConcreteSyntax syntax, TokenDefinition tokenDefinition) {
		return new File(getSourceFolder().getAbsolutePath() + File.separator + getResolverPackagePath() + File.separator + nameUtil.getTokenResolverClassName(syntax, tokenDefinition) + JAVA_FILE_EXTENSION);
	}

	public File getANTLRGrammarFile() {
		String antlrName = getCapitalizedConcreteSyntaxName();
		String packagePath = getPackagePath();
  		File antlrFile = new File(packagePath + antlrName + ANTRL_GRAMMAR_FILE_EXTENSION);
		return antlrFile;
	}

	public String getMetaInformationClassName() {
		return getCapitalizedConcreteSyntaxName() + CLASS_SUFFIX_META_INFORMATION;
	}

	public String getQualifiedMetaInformationClassName() {
		return getPackageName() + "." + getMetaInformationClassName();
	}

	public File getMetaInformationClassFile() {
		return new File(getPackagePath() + getMetaInformationClassName() + JAVA_FILE_EXTENSION);
	}

	public String getDefaultResolverDelegateName() {
		return nameUtil.getDefaultResolverDelegateName(getConcreteSyntax());
	}
	
	public String getQualifiedDefaultResolverDelegateName() {
		return getResolverPackageName() + "." + getDefaultResolverDelegateName();
	}
	
	public File getDefaultResolverDelegateFile() {
		return new File(getSourceFolder() + File.separator + getResolverPackagePath() + File.separator + nameUtil.getDefaultResolverDelegateName(getConcreteSyntax()) + JAVA_FILE_EXTENSION);
	}

	public String getProblemClassName() {
		return getCapitalizedConcreteSyntaxName() + "Problem";
	}

	public String getQualifiedProblemClassName() {
		return getPackageName() + "." + getProblemClassName();
	}

	public File getProblemClassFile() {
		return new File(getPackagePath() + getProblemClassName() + JAVA_FILE_EXTENSION);
	}

	public String getScannerlessParserClassName() {
		return getCapitalizedConcreteSyntaxName() + "ScannerlessParser";
	}

	public String getQualifiedScannerlessParserClassName() {
		return getPackageName() + "." + getScannerlessParserClassName();
	}

	public File getScannerlessParserFile() {
		return new File(getPackagePath() + getScannerlessParserClassName() + JAVA_FILE_EXTENSION);
	}

	public String getScannerlessScannerClassName() {
		return getCapitalizedConcreteSyntaxName() + "ScannerlessScanner";
	}

	public String getQualifiedScannerlessScannerClassName() {
		return getPackageName() + "." + getScannerlessScannerClassName();
	}

	public File getScannerlessScannerFile() {
		return new File(getPackagePath() + getScannerlessScannerClassName() + JAVA_FILE_EXTENSION);
	}

	public File getParserFile() {
		return new File(getPackagePath() + getParserClassName() + JAVA_FILE_EXTENSION);
	}
}

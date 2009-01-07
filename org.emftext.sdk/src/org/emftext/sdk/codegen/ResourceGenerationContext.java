package org.emftext.sdk.codegen;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.emftext.runtime.resource.IReferenceResolver;
import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.ITokenResolverFactory;
import org.emftext.sdk.codegen.TextParserGenerator.InternalTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * A ResourceGenerationContext provides all information that is needed by the 
 * ResourcePackageGenerator. This includes a resolved concrete syntax, 
 * a package name for parser and printer, a package name for resolvers 
 * (proxy and token resolvers) and a resource target folder. Furthermore,
 * the context collects information about the generation process as it
 * is executed.
 * 
 * @see org.emftext.sdk.codegen.ResourcePackageGenerator
 * 
 * @author skarol
 */
public class ResourceGenerationContext {
	
	public static final String CLASS_SUFFIX_TOKEN_RESOLVER = ITokenResolver.class.getSimpleName().substring(1);
	public static final String CLASS_SUFFIX_TOKEN_RESOLVER_FACTORY = ITokenResolverFactory.class.getSimpleName().substring(1);
	public static final String CLASS_SUFFIX_REFERENCE_RESOLVER = IReferenceResolver.class.getSimpleName().substring(1);
	
	private ConcreteSyntax concreteSyntax;
	private Collection<String> generatedResolverClasses = new LinkedHashSet<String>();
	private IJavaProject javaProject;
	private IProblemCollector problemCollector;
	
	public ResourceGenerationContext(ConcreteSyntax csSource, IProblemCollector problemCollector) {
		if (csSource == null) {
			throw new IllegalArgumentException("A concrete syntax must be specified!");
		}
		this.concreteSyntax = csSource;
		this.problemCollector = problemCollector;
	}

	/**	 
	 * @return The base package where token and proxy resolvers go to.
	 */
	public String getResolverPackageName() {
		String csPackageName = getPackageName();
		return (csPackageName==null || csPackageName.equals("") ? "" : csPackageName + ".") + "analysis";
	}
	
	/**
	 * @return The concrete syntax to be processed and which is 
	 * assumed to contain all resolved information.
	 */
	public ConcreteSyntax getConcreteSyntax(){
		return concreteSyntax;
	}
	
	/**
	 * @return The base folder to which generated packages are printed.
	 */
	public IFolder getTargetFolder(){
		return javaProject.getProject().getFolder("/src");
	}
	
	public IFolder getOutputFolder() {
		return javaProject.getProject().getFolder("/bin");
	}

	/**
	 * Returns a collection that contains the names of all resolver
	 * classes (both token and reference resolvers) that were generated
	 * before. Each new resolver should be added to this list.
	 * 
	 * @return the collection of already generated resolver classes
	 */
	public Collection<String> getGeneratedResolverClasses() {
		return generatedResolverClasses;
	}

	public String getPackageName() {
		GenPackage concreteSyntaxPackage = concreteSyntax.getPackage();
		boolean hasBasePackage = concreteSyntaxPackage.getBasePackage() != null;
		String baseName = "";
		if (hasBasePackage) {
			baseName = concreteSyntaxPackage.getBasePackage() + ".";
		}
		return baseName
				+ concreteSyntaxPackage.getEcorePackage().getName()
				+ ".resource." + concreteSyntax.getName();
	}

	public IProject getProject() {
		return javaProject.getProject();
	}

	public IJavaProject getJavaProject() {
		return javaProject;
	}

	public void setJavaProject(IJavaProject project) {
		this.javaProject = project;
	}

	public IProblemCollector getProblemCollector() {
		return problemCollector;
	}
	
	public String getCapCsName() {
		return BaseGenerator.cap(getConcreteSyntax().getName());
	}
	
    public String getPrinterName() {
    	return getCapCsName() + "Printer";
    }
    public String getPrinterBaseName() {
    	return getCapCsName() + "PrinterBase";
    }
    public String getResourceName() {
    	return getCapCsName() + "ResourceImpl";
    }
    public String getResourceFactoryName() {
    	return getCapCsName() + "ResourceFactoryImpl";
    }
    public String getTreeAnalyserName() {
    	return getCapCsName() + "TreeAnalyser";
    }
    public String getTokenResolverFactoryName() {
    	return getCapCsName() + CLASS_SUFFIX_TOKEN_RESOLVER_FACTORY;
    }

	public String getTokenResolverClassName(
			InternalTokenDefinition tokenDefinition) {
		return getCapCsName() +  tokenDefinition.getName() + CLASS_SUFFIX_TOKEN_RESOLVER;
	}

	public String getReferenceResolverClassName(GenFeature proxyReference) {
		return proxyReference.getGenClass().getName() + BaseGenerator.cap(proxyReference.getName()) + CLASS_SUFFIX_REFERENCE_RESOLVER;
	}
}

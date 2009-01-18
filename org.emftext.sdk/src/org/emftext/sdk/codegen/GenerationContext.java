package org.emftext.sdk.codegen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaProject;
import org.emftext.runtime.resource.IReferenceResolver;
import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.ITokenResolverFactory;
import org.emftext.sdk.GenClassFinder;
import org.emftext.sdk.codegen.TextParserGenerator.InternalTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.TokenDefinition;

/**
 * A GenerationContext provides all information that is needed by the 
 * generators. This includes a resolved concrete syntax, 
 * a package name for parser and printer, a package name for resolvers 
 * (reference and token resolvers) and a resource target folder. Furthermore,
 * the context collects information about the generation process as it
 * is executed.
 * 
 * @see org.emftext.sdk.codegen.ResourcePluginGenerator
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
public class GenerationContext {
	
	private static final String CLASS_SUFFIX_PRINTER = "Printer";
	private static final String CLASS_SUFFIX_PRINTER_BASE = "PrinterBase";
	private static final String CLASS_SUFFIX_RESOURCE = "ResourceImpl";
	private static final String CLASS_SUFFIX_RESOURCE_FACTORY = "ResourceFactoryImpl";
	private static final String CLASS_SUFFIX_REFERENCE_RESOLVER_SWITCH = "ReferenceResolverSwitch";
	public static final String CLASS_SUFFIX_TOKEN_RESOLVER = ITokenResolver.class.getSimpleName().substring(1);
	public static final String CLASS_SUFFIX_TOKEN_RESOLVER_FACTORY = ITokenResolverFactory.class.getSimpleName().substring(1);
	public static final String CLASS_SUFFIX_REFERENCE_RESOLVER = IReferenceResolver.class.getSimpleName().substring(1);
	
	private final GenClassFinder genClassFinder = new GenClassFinder();

	private ConcreteSyntax concreteSyntax;
	private Collection<String> generatedResolverClasses = new LinkedHashSet<String>();
	private IJavaProject javaProject;
	private IProblemCollector problemCollector;
	private Collection<GenFeature> nonContainmentReferences = new ArrayList<GenFeature>();
	private Collection<InternalTokenDefinition> usedTokenDefinitions = new ArrayList<InternalTokenDefinition>();
	
	public GenerationContext(ConcreteSyntax csSource, IProblemCollector problemCollector) {
		if (csSource == null) {
			throw new IllegalArgumentException("A concrete syntax must be specified!");
		}
		this.concreteSyntax = csSource;
		this.problemCollector = problemCollector;
		this.nonContainmentReferences = new ArrayList<GenFeature>();
	}

	/**	 
	 * @return The base package where token and proxy resolvers go to.
	 */
	public String getResolverPackageName(GenFeature genFeature) {
		ConcreteSyntax syntax = getConcreteSyntax(genFeature);
		return getResolverPackageName(syntax);
	}

	public String getResolverPackageName() {
		return getResolverPackageName(concreteSyntax);
	}
	
	public String getResolverPackageName(ConcreteSyntax syntax) {
		String csPackageName = getPackageName(syntax);
		return (csPackageName == null || csPackageName.equals("") ? "" : csPackageName + ".") + "analysis";
	}

	// feature may be contained in imported rules and thus belong to a different
	// CS specification
	private ConcreteSyntax getConcreteSyntax(GenFeature genFeature) {
		for (Import nextImport : concreteSyntax.getImports()) {
			ConcreteSyntax nextSyntax = nextImport.getConcreteSyntax();
			if (nextSyntax == null) {
				continue;
			}
			if (genClassFinder.findAllGenClasses(nextSyntax, true).contains(genFeature.getGenClass())) {
				return nextSyntax;
			}
		}
		return concreteSyntax;
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
		return getPackageName(concreteSyntax);
	}

	public String getPackageName(ConcreteSyntax syntax) {
		GenPackage concreteSyntaxPackage = syntax.getPackage();
		boolean hasBasePackage = concreteSyntaxPackage.getBasePackage() != null;
		String baseName = "";
		if (hasBasePackage) {
			baseName = concreteSyntaxPackage.getBasePackage() + ".";
		}
		return baseName
				+ concreteSyntaxPackage.getEcorePackage().getName()
				+ ".resource." + syntax.getName();
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
	
	public String getCapitalizedConcreteSyntaxName() {
		return getCapitalizedConcreteSyntaxName(getConcreteSyntax());
	}
	
	public String getCapitalizedConcreteSyntaxName(ConcreteSyntax syntax) {
		return capitalize(syntax.getName());
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
    
    public String getReferenceResolverSwitchClassName() {
    	return getCapitalizedConcreteSyntaxName() + CLASS_SUFFIX_REFERENCE_RESOLVER_SWITCH;
    }
    
    public String getTokenResolverFactoryClassName() {
    	return getCapitalizedConcreteSyntaxName() + CLASS_SUFFIX_TOKEN_RESOLVER_FACTORY;
    }

	public String getTokenResolverClassName(
			InternalTokenDefinition tokenDefinition) {
		return getCapitalizedConcreteSyntaxName(getContainingSyntax(tokenDefinition)) +  tokenDefinition.getName() + CLASS_SUFFIX_TOKEN_RESOLVER;
	}

	public String getReferenceResolverClassName(GenFeature proxyReference) {
		return proxyReference.getGenClass().getName() + capitalize(proxyReference.getName()) + CLASS_SUFFIX_REFERENCE_RESOLVER;
	}
	
	public ConcreteSyntax getContainingSyntax(InternalTokenDefinition def) {
		TokenDefinition baseDefinition = def.getBaseDefinition();
		if (baseDefinition != null) {
			EObject container = baseDefinition.eContainer();
			if (container instanceof ConcreteSyntax) {
				return (ConcreteSyntax) container;
			}
		}
		return concreteSyntax;
	}
	
    /**
     * Capitalizes the first letter of the given string.
     * 
     * @param text a string.
     * @return the modified string.
     */
    private String capitalize(String text) {
        String h = text.substring(0, 1).toUpperCase();
        String t = text.substring(1);      
        return h + t;
    }

	public void addNonContainmentReference(GenFeature proxyReference) {
		nonContainmentReferences.add(proxyReference);
	}

	public void addGeneratedReferenceResolverClass(String name) {
		generatedResolverClasses.add(name);
	}

	public void addGeneratedTokenResolverClass(String name) {
		generatedResolverClasses.add(name);
	}

	public Collection<GenFeature> getNonContainmentReferences() {
		return nonContainmentReferences;
	}

	public void addUsedToken(InternalTokenDefinition tokenDefinition) {
		usedTokenDefinitions.add(tokenDefinition);
	}

	public Collection<InternalTokenDefinition> getUsedTokens() {
		return usedTokenDefinitions;
	}

	public boolean isImportedReference(GenFeature genFeature) {
		List<GenClass> classes = genClassFinder.findAllGenClasses(concreteSyntax, false);
		for (GenClass genClass : classes) {
			if (genClass != null && genClass.equals(genFeature.getGenClass())) {
				return false;
			}
		}
		return true;
	}

	public boolean isImportedToken(InternalTokenDefinition tokenDefinition) {
		return !concreteSyntax.equals(getContainingSyntax(tokenDefinition));
	}
}

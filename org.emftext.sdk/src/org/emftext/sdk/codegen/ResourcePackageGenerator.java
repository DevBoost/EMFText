package org.emftext.sdk.codegen;

import static org.emftext.sdk.codegen.ICodeGenOptions.GENERATE_PRINTER_STUB_ONLY;
import static org.emftext.sdk.codegen.ICodeGenOptions.OVERRIDE_ANTLR_SPEC;
import static org.emftext.sdk.codegen.ICodeGenOptions.OVERRIDE_PRINTER;
import static org.emftext.sdk.codegen.ICodeGenOptions.OVERRIDE_REFERENCE_RESOLVERS;
import static org.emftext.sdk.codegen.ICodeGenOptions.OVERRIDE_TOKEN_RESOLVERS;
import static org.emftext.sdk.codegen.ICodeGenOptions.OVERRIDE_TOKEN_RESOLVER_FACTORY;
import static org.emftext.sdk.codegen.ICodeGenOptions.OVERRIDE_TREE_ANALYSER;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.antlr.Tool;
import org.antlr.tool.ErrorManager;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.emftext.runtime.resource.IReferenceResolver;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.ITokenResolverFactory;

public class ResourcePackageGenerator {
	
	public static final String CLASS_SUFFIX_TOKEN_RESOLVER = ITokenResolver.class.getSimpleName().substring(1);
	public static final String CLASS_SUFFIX_TOKEN_RESOLVER_FACTORY = ITokenResolverFactory.class.getSimpleName().substring(1);
	public static final String CLASS_SUFFIX_REFERENCE_RESOLVER = IReferenceResolver.class.getSimpleName().substring(1);
	
	private static final String JAVA_FILE_EXTENSION = ".java";
	
	public static void generate(ResourcePackage resourcePackage, IProgressMonitor monitor)throws CoreException{
		SubMonitor progress = SubMonitor.convert(monitor, "generating resources...", 100);
	    String capCsName = BaseGenerator.cap(resourcePackage.getConcreteSyntax().getName());
		IFolder targetFolder = resourcePackage.getTargetFolder();
		
		ITextResource csResource = (ITextResource)resourcePackage.getConcreteSyntax().eResource(); 
		if(!targetFolder.exists())
		   	targetFolder.create(false,true,progress.newChild(5));
  		
		IPath csPackagePath = new Path(resourcePackage.getCsPackageName().replaceAll("\\.","/"));
  		IPath resolverPackagePath = new Path(resourcePackage.getResolverPackageName().replaceAll("\\.","/"));
  		
	    String antlrName = capCsName;
	    String printerName = capCsName + "Printer";
	    String printerBaseName = capCsName + "PrinterBase";
	    String resourceName = capCsName + "ResourceImpl";
	    String resourceFactoryName = capCsName + "ResourceFactoryImpl";
	    String treeAnalyserName = capCsName + "TreeAnalyser";
	    String tokenResolverFactoryName = capCsName + CLASS_SUFFIX_TOKEN_RESOLVER_FACTORY;
        
  		IFile antlrFile = targetFolder.getFile(csPackagePath.append(antlrName + ".g"));
	    IFile printerFile = targetFolder.getFile(csPackagePath.append(printerName + JAVA_FILE_EXTENSION));
	    IFile printerBaseFile = targetFolder.getFile(csPackagePath.append(printerBaseName + JAVA_FILE_EXTENSION));
	    IFile resourceFile = targetFolder.getFile(csPackagePath.append(resourceName + JAVA_FILE_EXTENSION));
        IFile resourceFactoryFile = targetFolder.getFile(csPackagePath.append(resourceFactoryName + JAVA_FILE_EXTENSION));
	    IFile treeAnalyserFile = targetFolder.getFile(csPackagePath.append(treeAnalyserName + JAVA_FILE_EXTENSION));
	    IFile tokenResolverFactoryFile = targetFolder.getFile(csPackagePath.append(tokenResolverFactoryName + JAVA_FILE_EXTENSION));
	    	    
	    TextParserGenerator antlrGenenerator = new TextParserGenerator(resourcePackage.getConcreteSyntax(),antlrName,resourcePackage.getCsPackageName(),tokenResolverFactoryName);
	    IGenerator resourceGenenerator = new TextResourceGenerator(resourceName,resourcePackage.getCsPackageName(),capCsName,printerName,treeAnalyserName);
	    IGenerator resourceFactoryGenenerator = new ResourceFactoryGenerator(resourceFactoryName,resourcePackage.getCsPackageName(),resourceName);
	    
	    progress.setTaskName("deriving grammar...");
	    InputStream grammarStream = deriveGrammar(csResource, antlrGenenerator);
	    if (grammarStream == null) {
	    	return;
	    }
	    progress.worked(10);

	    progress.setTaskName("saving grammar...");
	    saveGrammar(grammarStream, resourcePackage, antlrFile);
	    progress.worked(10);
	    
	    generateEMFResources(progress, csResource, resourceFile,
				resourceFactoryFile, resourceGenenerator, resourceFactoryGenenerator);
		
		runANTLR(resourcePackage, progress, antlrFile);
    	
        generatePrettyPrinter(resourcePackage, progress, csResource, printerFile,
				printerBaseFile, antlrName, printerName, printerBaseName,
				treeAnalyserName, tokenResolverFactoryName, antlrGenenerator);
	    
	    Map<GenFeature, String> proxy2NameMap = generateReferenceResolvers(resourcePackage,
				progress, targetFolder, csResource, resolverPackagePath,
				antlrGenenerator);
		
		generateTreeAnalyser(resourcePackage, progress, csResource, treeAnalyserFile,
				treeAnalyserName, proxy2NameMap);
		
		Map<TextParserGenerator.InternalTokenDefinition, String> tokenToNameMap = generateTokenResolvers(
				resourcePackage, progress, capCsName, targetFolder, csResource,
				resolverPackagePath, antlrGenenerator);
		
		generateTokenResolverFactory(resourcePackage, progress, csResource,
				tokenResolverFactoryFile, tokenResolverFactoryName, tokenToNameMap);
		
		resourcePackage.getGeneratedResolverClasses().addAll(proxy2NameMap.values());
		resourcePackage.getGeneratedResolverClasses().addAll(tokenToNameMap.values());
		searchForUnusedResolvers(resourcePackage, resolverPackagePath);
	}

	private static void searchForUnusedResolvers(
			ResourcePackage resourcePackage, IPath resolverPackagePath) throws CoreException {
		
		Set<String> resolverFiles = new LinkedHashSet<String>();
		for (String className : resourcePackage.getGeneratedResolverClasses()) {
			resolverFiles.add(className + JAVA_FILE_EXTENSION);
		}
		
		IFolder resolverPackageFolder = resourcePackage.getTargetFolder().getFolder(resolverPackagePath);
		IResource[] contents = resolverPackageFolder.members();
		for (IResource member : contents) {
			if (member instanceof IFile) {
				IFile file = (IFile) member;
				String fileName = file.getName();
				if (!resolverFiles.contains(fileName)) {
					// issue warning about unused resolver
					((ITextResource) resourcePackage.getConcreteSyntax().eResource()).addWarning("Found unused class '" + fileName + "' in analysis package.", null);
				}
			}
		}
	}

	private static void generateTokenResolverFactory(
			ResourcePackage pck,
			SubMonitor progress,
			ITextResource csResource,
			IFile tokenResolverFactoryFile,
			String tokenResolverFactoryName,
			Map<TextParserGenerator.InternalTokenDefinition, String> tokenToNameMap)
			throws CoreException {
		progress.setTaskName("generating token resolver factory...");
		boolean generateTokenResolverFactory = !tokenResolverFactoryFile.exists() || OptionManager.INSTANCE.getBooleanOption(pck.getConcreteSyntax(), OVERRIDE_TOKEN_RESOLVER_FACTORY);
		if (generateTokenResolverFactory) {
			BaseGenerator factoryGen = new TokenResolverFactoryGenerator(tokenToNameMap,tokenResolverFactoryName,pck.getCsPackageName(),pck.getResolverPackageName());
			setContents(tokenResolverFactoryFile,invokeGeneration(factoryGen,csResource));
		}
	}

	private static Map<TextParserGenerator.InternalTokenDefinition, String> generateTokenResolvers(
			ResourcePackage pck, SubMonitor progress, String capCsName,
			IFolder targetFolder, ITextResource csResource,
			IPath resolverPackagePath, TextParserGenerator antlrGen)
			throws CoreException {
		progress.setTaskName("generating token resolvers...");
		Map<TextParserGenerator.InternalTokenDefinition,String> tokenToNameMap = new HashMap<TextParserGenerator.InternalTokenDefinition,String>();
		for(TextParserGenerator.InternalTokenDefinition definition : antlrGen.getPrintedTokenDefinitions()){
			if(!definition.isReferenced())
				continue;
			String className = capCsName + definition.getName() + CLASS_SUFFIX_TOKEN_RESOLVER;
			tokenToNameMap.put(definition,className);
			
			IFile resolverFile = targetFolder.getFile(resolverPackagePath.append(className + JAVA_FILE_EXTENSION));
			boolean generateResolver = !resolverFile.exists() || OptionManager.INSTANCE.getBooleanOption(pck.getConcreteSyntax(), OVERRIDE_TOKEN_RESOLVERS);
			if (generateResolver) {
				BaseGenerator resolverGenerator = new TokenResolverGenerator(className,pck.getResolverPackageName(),definition);
				setContents(resolverFile,invokeGeneration(resolverGenerator,csResource));
			}
		}
		progress.worked(20);
		return tokenToNameMap;
	}

	private static void generateTreeAnalyser(ResourcePackage pck,
			SubMonitor progress, ITextResource csResource,
			IFile treeAnalyserFile, String treeAnalyserName,
			Map<GenFeature, String> proxy2Name) throws CoreException {
		progress.setTaskName("generating tree analyser...");

		boolean generateTreeAnalyser = !treeAnalyserFile.exists() || OptionManager.INSTANCE.getBooleanOption(pck.getConcreteSyntax(), OVERRIDE_TREE_ANALYSER);
		if (generateTreeAnalyser) {
			BaseGenerator analyserGen = new TextTreeAnalyserGenerator(proxy2Name,treeAnalyserName,pck.getCsPackageName(),pck.getResolverPackageName());
			setContents(treeAnalyserFile,invokeGeneration(analyserGen,csResource));
		}
		progress.worked(5);
	}

	private static Map<GenFeature, String> generateReferenceResolvers(
			ResourcePackage resourcePackage, SubMonitor monitor, IFolder targetFolder,
			ITextResource csResource, IPath resolverPackagePath,
			TextParserGenerator antlrGenerator) throws CoreException {
		
		monitor.setTaskName("generating reference resolvers...");
		
		Map<GenFeature,String> proxy2Name = new HashMap<GenFeature,String>();
		for(GenFeature proxyReference : antlrGenerator.getProxyReferences()){
			String className = proxyReference.getGenClass().getName() + BaseGenerator.cap(proxyReference.getName()) + CLASS_SUFFIX_REFERENCE_RESOLVER;
			proxy2Name.put(proxyReference, className);
			String resolverFileName = className + JAVA_FILE_EXTENSION;
			IFile resolverFile = targetFolder.getFile(resolverPackagePath.append(resolverFileName));
			boolean generateResolver = !resolverFile.exists() || OptionManager.INSTANCE.getBooleanOption(resourcePackage.getConcreteSyntax(), OVERRIDE_REFERENCE_RESOLVERS);
			if (generateResolver) {
				BaseGenerator proxyGen = new ReferenceResolverGenerator(className,resourcePackage.getResolverPackageName());
				setContents(resolverFile, invokeGeneration(proxyGen,csResource));		
			}
		}
		
		monitor.worked(20);
		return proxy2Name;
	}

	private static void generatePrettyPrinter(ResourcePackage pck,
			SubMonitor progress, ITextResource csResource, IFile printerFile,
			IFile printerBaseFile, String antlrName, String printerName,
			String printerBaseName, String treeAnalyserName,
			String tokenResolverFactoryName, TextParserGenerator antlrGen)
			throws CoreException {
		
		progress.setTaskName("generating printer...");
		boolean generatePrinterStubOnly = OptionManager.INSTANCE.getBooleanOption(pck.getConcreteSyntax(), GENERATE_PRINTER_STUB_ONLY);
		boolean overridePrinter = OptionManager.INSTANCE.getBooleanOption(pck.getConcreteSyntax(), OVERRIDE_PRINTER);

		boolean printerExists = printerFile.exists();
		boolean printerBaseExists = printerBaseFile.exists();

    	boolean generatePrinter = !printerExists || overridePrinter;
		boolean generatePrinterBase = !printerBaseExists || overridePrinter;

		final String csPackageName = pck.getCsPackageName();
    	
	    // always generate printer base
		if (generatePrinterBase && !generatePrinterStubOnly) {
	        BaseGenerator printerBaseGen = new TextPrinterBaseGenerator(pck.getConcreteSyntax(), printerBaseName,csPackageName,antlrName,tokenResolverFactoryName, antlrGen.getPlaceHolderTokenMapping(),treeAnalyserName);
		    setContents(printerBaseFile, invokeGeneration(printerBaseGen, csResource));	    		
    	}
		if (generatePrinter) {
			BaseGenerator printerGen;
			if (generatePrinterStubOnly) {
	    		printerGen = new TextPrinterGenerator(printerName, csPackageName, null);
			} else {
	    		printerGen = new TextPrinterGenerator(printerName, csPackageName, printerBaseName);
			}
	    	setContents(printerFile, invokeGeneration(printerGen, csResource));
	    }
	    progress.worked(20);
	}

	private static void runANTLR(ResourcePackage pck, SubMonitor progress,
			IFile antlrFile) {
		progress.setTaskName("running ANTLR on grammar file...");
        ErrorManager.setErrorListener(new TextResourceGeneratorANTLRErrorListener(pck.getConcreteSyntax().eResource()));
        Tool antlrTool = new Tool(new String[]{"-Xconversiontimeout", "10000", "-o", antlrFile.getLocation().removeLastSegments(1).toOSString(), antlrFile.getLocation().toOSString()});
        antlrTool.process();
        progress.worked(20);
	}

	private static void generateEMFResources(SubMonitor progress,
			ITextResource csResource, IFile resourceFile,
			IFile resourceFactoryFile, IGenerator resourceGen,
			IGenerator resourceFactoryGen) throws CoreException {
		progress.setTaskName("generating EMF resources...");
		setContents(resourceFile,invokeGeneration(resourceGen,csResource));
		setContents(resourceFactoryFile,invokeGeneration(resourceFactoryGen,csResource));
		progress.worked(5);
	}

	public static InputStream deriveGrammar(ITextResource csResource, IGenerator antlrGen)
			throws CoreException {
		InputStream content = invokeGeneration(antlrGen, csResource);
		return content;
	}
	
	private static void saveGrammar(InputStream content, ResourcePackage pck, IFile antlrFile) throws CoreException {
		boolean generateANTLRSpecification = !antlrFile.exists() || OptionManager.INSTANCE.getBooleanOption(pck.getConcreteSyntax(), OVERRIDE_ANTLR_SPEC);
	    if (generateANTLRSpecification) {
	    	setContents(antlrFile, content);
	    }
	}
       
	private static InputStream invokeGeneration(IGenerator generator, ITextResource csResource){
       ByteArrayOutputStream stream = new ByteArrayOutputStream();
	   PrintWriter out = new PrintWriter(new BufferedOutputStream(stream));
       try {
    	   if(generator.generate(out)){
    		   out.flush();
    		   return new ByteArrayInputStream(stream.toByteArray());
       	   }
        }
        finally {
   	   	    out.close();
   	 	    Collection<GenerationProblem> occuredWarningsAndErrors = generator.getOccuredWarningsAndErrors();
			if(occuredWarningsAndErrors!=null) {
   	   	    	for(GenerationProblem problem:occuredWarningsAndErrors){
   	   	    		if(problem.getSeverity() == GenerationProblem.Severity.WARNING){
   	   	    			csResource.addWarning(problem.getMessage(),problem.getCause());
   	   	    		}
   	   	    		else{
   	   	    			csResource.addError(problem.getMessage(),problem.getCause());
   	   	    			
   	   	    		}
   	   	    	}
   	   	    }

        }

     	return null;

       }
	
       private static void setContents(IFile target, InputStream in)throws CoreException{
    	   if (target.exists()) {
    		   target.setContents(in,false,false,new NullProgressMonitor());
    	   }
    	   else{
    		   LinkedList<IResource> stack = new LinkedList<IResource>();
    		   if(!target.getParent().exists()){
    			   stack.addFirst(target.getParent());
    			   while(!stack.isEmpty()){
    				   if(!stack.peek().getParent().exists())
    					   stack.addFirst(stack.peek().getParent());
    				   else
    					   ((IFolder)stack.removeFirst()).create(false,false,new NullProgressMonitor());
    			   }
    		   }
       		   target.create(in,false,new NullProgressMonitor());
    	   }
       }
    
}

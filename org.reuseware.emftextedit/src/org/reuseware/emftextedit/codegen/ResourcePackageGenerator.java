package org.reuseware.emftextedit.codegen;

import java.io.ByteArrayOutputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

import org.reuseware.emftextedit.codegen.IGenerator.GenerationProblem;
import org.reuseware.emftextedit.resource.TextResource;
import org.antlr.Tool;
import org.antlr.tool.ErrorManager;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.core.runtime.SubMonitor;


public class ResourcePackageGenerator {
	
	public static final String CLASS_TOKEN_RESOLVER = "TokenResolver";
	public static final String CLASS_TOKEN_RESOLVER_FACTORY = "TokenResolverFactory";
	
	private static final String JAVA_EXT = ".java";
	
	public static String GENERATE_PRINTER_STUB_ONLY_NAME = "genPrinterStubOnly";
	public static String OVERRIDE_ANTLR_SPEC_NAME = "ovrAntlrSpec";
	public static String OVERRIDE_TOKEN_RESOLVERS_NAME = "ovrTokenResolvers";
	public static String OVERRIDE_PROXY_RESOLVERS_NAME = "ovrProxyResolvers";
	public static String OVERRIDE_TREE_ANALYSER_NAME = "ovrTreeAnalyser";
	public static String OVERRIDE_TOKEN_RESOLVER_FACTORY_NAME = "ovrTokenResolverFactory";
	public static String OVERRIDE_PRINTER_NAME = "ovrPrinter";

	public static void generate(ResourcePackage resourcePackage, IProgressMonitor monitor)throws CoreException{
		SubMonitor progress = SubMonitor.convert(monitor,"generating resources...",100);
	    String capCsName = BaseGenerator.cap(resourcePackage.getConcreteSyntax().getName());
		IFolder targetFolder = resourcePackage.getTargetFolder();
		
		TextResource csResource = (TextResource)resourcePackage.getConcreteSyntax().eResource(); 
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
	    String tokenResolverFactoryName = capCsName + CLASS_TOKEN_RESOLVER_FACTORY;
        
  		IFile antlrFile = targetFolder.getFile(csPackagePath.append(antlrName + ".g"));
	    IFile printerFile = targetFolder.getFile(csPackagePath.append(printerName + JAVA_EXT));
	    IFile printerBaseFile = targetFolder.getFile(csPackagePath.append(printerBaseName + JAVA_EXT));
	    IFile resourceFile = targetFolder.getFile(csPackagePath.append(resourceName + JAVA_EXT));
        IFile resourceFactoryFile = targetFolder.getFile(csPackagePath.append(resourceFactoryName + JAVA_EXT));
	    IFile treeAnalyserFile = targetFolder.getFile(csPackagePath.append(treeAnalyserName + JAVA_EXT));
	    IFile tokenResolverFactoryFile = targetFolder.getFile(csPackagePath.append(tokenResolverFactoryName + JAVA_EXT));
	    	    
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
	    
	    Map<GenFeature, String> proxy2Name = generateProxyResolver(resourcePackage,
				progress, targetFolder, csResource, resolverPackagePath,
				antlrGenenerator);
		
		generateTreeAnalyser(resourcePackage, progress, csResource, treeAnalyserFile,
				treeAnalyserName, proxy2Name);
		
		Map<TextParserGenerator.InternalTokenDefinition, String> tokenToNameMap = generateTokenResolvers(
				resourcePackage, progress, capCsName, targetFolder, csResource,
				resolverPackagePath, antlrGenenerator);
		
		generateTokenResolverFactory(resourcePackage, progress, csResource,
				tokenResolverFactoryFile, tokenResolverFactoryName, tokenToNameMap);
	}

	private static void generateTokenResolverFactory(
			ResourcePackage pck,
			SubMonitor progress,
			TextResource csResource,
			IFile tokenResolverFactoryFile,
			String tokenResolverFactoryName,
			Map<TextParserGenerator.InternalTokenDefinition, String> tokenToNameMap)
			throws CoreException {
		progress.setTaskName("generating token resolver factory...");
		if(!tokenResolverFactoryFile.exists()||pck.getPreference(OVERRIDE_TOKEN_RESOLVER_FACTORY_NAME)){
			BaseGenerator factoryGen = new TokenResolverFactoryGenerator(tokenToNameMap,tokenResolverFactoryName,pck.getCsPackageName(),pck.getResolverPackageName());
			setContents(tokenResolverFactoryFile,invokeGeneration(factoryGen,csResource));
		}
	}

	private static Map<TextParserGenerator.InternalTokenDefinition, String> generateTokenResolvers(
			ResourcePackage pck, SubMonitor progress, String capCsName,
			IFolder targetFolder, TextResource csResource,
			IPath resolverPackagePath, TextParserGenerator antlrGen)
			throws CoreException {
		progress.setTaskName("generating token resolvers...");
		Map<TextParserGenerator.InternalTokenDefinition,String> tokenToNameMap = new HashMap<TextParserGenerator.InternalTokenDefinition,String>();
		for(TextParserGenerator.InternalTokenDefinition definition : antlrGen.getPrintedTokenDefinitions()){
			if(!definition.isReferenced())
				continue;
			String className = capCsName + definition.getName() + CLASS_TOKEN_RESOLVER;
			tokenToNameMap.put(definition,className);
			
			IFile resolverFile = targetFolder.getFile(resolverPackagePath.append(className + JAVA_EXT));
			if (!resolverFile.exists() || pck.getPreference(OVERRIDE_TOKEN_RESOLVERS_NAME)){
				BaseGenerator resolverGenerator = new TokenResolverGenerator(className,pck.getResolverPackageName(),definition);
				setContents(resolverFile,invokeGeneration(resolverGenerator,csResource));
			}
		}
		progress.worked(20);
		return tokenToNameMap;
	}

	private static void generateTreeAnalyser(ResourcePackage pck,
			SubMonitor progress, TextResource csResource,
			IFile treeAnalyserFile, String treeAnalyserName,
			Map<GenFeature, String> proxy2Name) throws CoreException {
		progress.setTaskName("generating tree analyser...");
		if(!treeAnalyserFile.exists()||pck.getPreference(OVERRIDE_TREE_ANALYSER_NAME)){
			BaseGenerator analyserGen = new TextTreeAnalyserGenerator(proxy2Name,treeAnalyserName,pck.getCsPackageName(),pck.getResolverPackageName());
			setContents(treeAnalyserFile,invokeGeneration(analyserGen,csResource));
		}
		progress.worked(5);
	}

	private static Map<GenFeature, String> generateProxyResolver(
			ResourcePackage pck, SubMonitor progress, IFolder targetFolder,
			TextResource csResource, IPath resolverPackagePath,
			TextParserGenerator antlrGen) throws CoreException {
		progress.setTaskName("generating proxy resolvers...");
		Map<GenFeature,String> proxy2Name = new HashMap<GenFeature,String>();
		for(GenFeature proxyReference : antlrGen.getProxyReferences()){
			String className = proxyReference.getGenClass().getName() + BaseGenerator.cap(proxyReference.getName()) + "ProxyResolver";
			proxy2Name.put(proxyReference,className);
			IFile resolverFile = targetFolder.getFile(resolverPackagePath.append(className +JAVA_EXT));
			if(!resolverFile.exists()||pck.getPreference(OVERRIDE_PROXY_RESOLVERS_NAME)){
				BaseGenerator proxyGen = new ProxyResolverGenerator(className,pck.getResolverPackageName());
				setContents(resolverFile, invokeGeneration(proxyGen,csResource));		
			}
		}
		progress.worked(20);
		return proxy2Name;
	}

	private static void generatePrettyPrinter(ResourcePackage pck,
			SubMonitor progress, TextResource csResource, IFile printerFile,
			IFile printerBaseFile, String antlrName, String printerName,
			String printerBaseName, String treeAnalyserName,
			String tokenResolverFactoryName, TextParserGenerator antlrGen)
			throws CoreException {
		progress.setTaskName("generating printer...");
	    if(!pck.getPreference(GENERATE_PRINTER_STUB_ONLY_NAME)){
	    	if(!printerBaseFile.exists()||pck.getPreference(OVERRIDE_PRINTER_NAME)){
		        BaseGenerator printerBaseGen = new TextPrinterBaseGenerator(pck.getConcreteSyntax(),printerBaseName,pck.getCsPackageName(),antlrName,tokenResolverFactoryName, antlrGen.getPlaceHolderTokenMapping(),treeAnalyserName);
			    setContents(printerBaseFile,invokeGeneration(printerBaseGen,csResource));	    		
	    	}
		    if(!printerFile.exists()){
			    BaseGenerator printerGen = new TextPrinterGenerator(printerName,pck.getCsPackageName(),printerBaseName);
			    setContents(printerFile,invokeGeneration(printerGen,csResource));
		    }
	    }
	    else if(!printerFile.exists()||pck.getPreference(OVERRIDE_PRINTER_NAME)){
		    BaseGenerator printerGen = new TextPrinterGenerator(printerName,pck.getCsPackageName(),null);
		    setContents(printerFile,invokeGeneration(printerGen,csResource));
	    }
	    progress.worked(20);
	}

	private static void runANTLR(ResourcePackage pck, SubMonitor progress,
			IFile antlrFile) {
		progress.setTaskName("running ANTLR on grammar file...");
        ErrorManager.setErrorListener(new TextResourceGeneratorANTLRErrorListener(pck.getConcreteSyntax().eResource()));
        Tool antlrTool = new Tool(new String[]{"-o",antlrFile.getLocation().removeLastSegments(1).toOSString(), antlrFile.getLocation().toOSString()});
        antlrTool.process();
        progress.worked(20);
	}

	private static void generateEMFResources(SubMonitor progress,
			TextResource csResource, IFile resourceFile,
			IFile resourceFactoryFile, IGenerator resourceGen,
			IGenerator resourceFactoryGen) throws CoreException {
		progress.setTaskName("generating EMF resources...");
		setContents(resourceFile,invokeGeneration(resourceGen,csResource));
		setContents(resourceFactoryFile,invokeGeneration(resourceFactoryGen,csResource));
		progress.worked(5);
	}

	public static InputStream deriveGrammar(TextResource csResource, IGenerator antlrGen)
			throws CoreException {
		InputStream content = invokeGeneration(antlrGen, csResource);
		return content;
	}
	
	private static void saveGrammar(InputStream content, ResourcePackage pck, IFile antlrFile) throws CoreException {
	    if (!antlrFile.exists() || pck.getPreference(OVERRIDE_ANTLR_SPEC_NAME)) {
	    	setContents(antlrFile, content);
	    }
	}
       
	private static InputStream invokeGeneration(IGenerator generator, TextResource csResource){
	   PrintWriter out;
       ByteArrayOutputStream stream = new ByteArrayOutputStream();
       out = new PrintWriter(new BufferedOutputStream(stream));
       try{
    	   if(generator.generate(out)){
    		   out.flush();
    		   return new ByteArrayInputStream(stream.toByteArray());
       	   }	
        }
        finally{
   	   	    out.close();
   	 	    Collection<GenerationProblem> occuredWarningsAndErrors = generator.getOccuredWarningsAndErrors();
			if(occuredWarningsAndErrors!=null) {
   	   	    	for(IGenerator.GenerationProblem problem:occuredWarningsAndErrors){
   	   	    		if(problem.getSeverity() == IGenerator.GenerationProblem.Severity.HINT){
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

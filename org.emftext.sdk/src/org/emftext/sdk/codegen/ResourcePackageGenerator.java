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
import org.emftext.runtime.resource.ITextResource;

public class ResourcePackageGenerator {
	
	private static final String JAVA_FILE_EXTENSION = ".java";
	
	public static void generate(GenerationContext context, IProgressMonitor monitor)throws CoreException{
		SubMonitor progress = SubMonitor.convert(monitor, "generating resources...", 100);
	    
		IFolder targetFolder = context.getTargetFolder();
		
		ITextResource csResource = (ITextResource) context.getConcreteSyntax().eResource(); 
		if (!targetFolder.exists()) {
		   	targetFolder.create(false, true, progress.newChild(5));
		}
  		
		IPath csPackagePath = new Path(context.getPackageName().replaceAll("\\.","/"));
  		IPath resolverPackagePath = new Path(context.getResolverPackageName().replaceAll("\\.","/"));
  		
	    String antlrName = context.getCapCsName();
	    String printerName = context.getPrinterName();
	    String printerBaseName = context.getPrinterBaseName();
	    String resourceName = context.getResourceName();
	    String resourceFactoryName = context.getResourceFactoryName();
	    String treeAnalyserName = context.getTreeAnalyserName();
	    String tokenResolverFactoryName = context.getTokenResolverFactoryName();
        
  		IFile antlrFile = targetFolder.getFile(csPackagePath.append(antlrName + ".g"));
	    IFile printerFile = targetFolder.getFile(csPackagePath.append(printerName + JAVA_FILE_EXTENSION));
	    IFile printerBaseFile = targetFolder.getFile(csPackagePath.append(printerBaseName + JAVA_FILE_EXTENSION));
	    IFile resourceFile = targetFolder.getFile(csPackagePath.append(resourceName + JAVA_FILE_EXTENSION));
        IFile resourceFactoryFile = targetFolder.getFile(csPackagePath.append(resourceFactoryName + JAVA_FILE_EXTENSION));
	    IFile treeAnalyserFile = targetFolder.getFile(csPackagePath.append(treeAnalyserName + JAVA_FILE_EXTENSION));
	    IFile tokenResolverFactoryFile = targetFolder.getFile(csPackagePath.append(tokenResolverFactoryName + JAVA_FILE_EXTENSION));
	    	    
	    TextParserGenerator antlrGenenerator = new TextParserGenerator(context);
	    IGenerator resourceGenenerator = new TextResourceGenerator(context);
	    IGenerator resourceFactoryGenenerator = new ResourceFactoryGenerator(context);
	    
	    progress.setTaskName("deriving grammar...");
	    InputStream grammarStream = deriveGrammar(antlrGenenerator, context);
	    if (grammarStream == null) {
	    	return;
	    }
	    progress.worked(10);

	    progress.setTaskName("saving grammar...");
	    saveGrammar(grammarStream, context, antlrFile);
	    progress.worked(10);
	    
	    generateEMFResources(progress, resourceFile,
				resourceFactoryFile, resourceGenenerator, resourceFactoryGenenerator, context);
		
		runANTLR(context, progress, antlrFile);
    	
        generatePrettyPrinter(context, progress, csResource, printerFile,
				printerBaseFile, antlrName, printerName, printerBaseName,
				treeAnalyserName, tokenResolverFactoryName, antlrGenenerator);
	    
	    Map<GenFeature, String> proxy2NameMap = generateReferenceResolvers(context,
				progress, csResource, resolverPackagePath,
				antlrGenenerator);
		
		generateTreeAnalyser(context, progress, csResource, treeAnalyserFile,
				treeAnalyserName, proxy2NameMap);
		
		Map<TextParserGenerator.InternalTokenDefinition, String> tokenToNameMap = generateTokenResolvers(
				context, progress, csResource,
				resolverPackagePath, antlrGenenerator);
		
		generateTokenResolverFactory(context, progress, csResource,
				tokenResolverFactoryFile, tokenResolverFactoryName, tokenToNameMap);
		
		context.getGeneratedResolverClasses().addAll(proxy2NameMap.values());
		context.getGeneratedResolverClasses().addAll(tokenToNameMap.values());
		searchForUnusedResolvers(context, resolverPackagePath);
	}

	private static void searchForUnusedResolvers(
			GenerationContext resourcePackage, IPath resolverPackagePath) throws CoreException {
		
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
			GenerationContext context,
			SubMonitor progress,
			ITextResource csResource,
			IFile tokenResolverFactoryFile,
			String tokenResolverFactoryName,
			Map<TextParserGenerator.InternalTokenDefinition, String> tokenToNameMap)
			throws CoreException {
		progress.setTaskName("generating token resolver factory...");
		boolean generateTokenResolverFactory = !tokenResolverFactoryFile.exists() || OptionManager.INSTANCE.getBooleanOption(context.getConcreteSyntax(), OVERRIDE_TOKEN_RESOLVER_FACTORY);
		if (generateTokenResolverFactory) {
			BaseGenerator factoryGen = new TokenResolverFactoryGenerator(context, tokenToNameMap);
			setContents(tokenResolverFactoryFile,invokeGeneration(factoryGen, context.getProblemCollector()));
		}
	}

	private static Map<TextParserGenerator.InternalTokenDefinition, String> generateTokenResolvers(
			GenerationContext context, SubMonitor progress,
			ITextResource csResource,
			IPath resolverPackagePath, TextParserGenerator antlrGen)
			throws CoreException {
		progress.setTaskName("generating token resolvers...");
		IFolder targetFolder = context.getTargetFolder();
		Map<TextParserGenerator.InternalTokenDefinition,String> tokenToNameMap = new HashMap<TextParserGenerator.InternalTokenDefinition,String>();
		for(TextParserGenerator.InternalTokenDefinition tokenDefinition : antlrGen.getPrintedTokenDefinitions()){
			if (!tokenDefinition.isReferenced()) {
				continue;
			}
			String tokenResolverClassName = context.getTokenResolverClassName(tokenDefinition);
			tokenToNameMap.put(tokenDefinition,tokenResolverClassName);
			
			IFile resolverFile = targetFolder.getFile(resolverPackagePath.append(tokenResolverClassName + JAVA_FILE_EXTENSION));
			boolean generateResolver = !resolverFile.exists() || OptionManager.INSTANCE.getBooleanOption(context.getConcreteSyntax(), OVERRIDE_TOKEN_RESOLVERS);
			if (generateResolver) {
				BaseGenerator resolverGenerator = new TokenResolverGenerator(context, tokenResolverClassName, tokenDefinition);
				setContents(resolverFile,invokeGeneration(resolverGenerator, context.getProblemCollector()));
			}
		}
		progress.worked(20);
		return tokenToNameMap;
	}

	private static void generateTreeAnalyser(GenerationContext context,
			SubMonitor progress, ITextResource csResource,
			IFile treeAnalyserFile, String treeAnalyserName,
			Map<GenFeature, String> proxy2Name) throws CoreException {
		progress.setTaskName("generating tree analyser...");

		boolean generateTreeAnalyser = !treeAnalyserFile.exists() || OptionManager.INSTANCE.getBooleanOption(context.getConcreteSyntax(), OVERRIDE_TREE_ANALYSER);
		if (generateTreeAnalyser) {
			BaseGenerator analyserGen = new TextTreeAnalyserGenerator(context, proxy2Name);
			setContents(treeAnalyserFile,invokeGeneration(analyserGen, context.getProblemCollector()));
		}
		progress.worked(5);
	}

	private static Map<GenFeature, String> generateReferenceResolvers(
			GenerationContext context, SubMonitor monitor, 
			ITextResource csResource, IPath resolverPackagePath,
			TextParserGenerator antlrGenerator) throws CoreException {
		
		monitor.setTaskName("generating reference resolvers...");
		
		IFolder targetFolder = context.getTargetFolder();
		
		Map<GenFeature,String> proxy2Name = new HashMap<GenFeature,String>();
		for(GenFeature proxyReference : antlrGenerator.getProxyReferences()){
			String resolverClassName = context.getReferenceResolverClassName(proxyReference);
			proxy2Name.put(proxyReference, resolverClassName);
			String resolverFileName = resolverClassName + JAVA_FILE_EXTENSION;
			IFile resolverFile = targetFolder.getFile(resolverPackagePath.append(resolverFileName));
			boolean generateResolver = !resolverFile.exists() || OptionManager.INSTANCE.getBooleanOption(context.getConcreteSyntax(), OVERRIDE_REFERENCE_RESOLVERS);
			if (generateResolver) {
				BaseGenerator proxyGen = new ReferenceResolverGenerator(context, resolverClassName);
				setContents(resolverFile, invokeGeneration(proxyGen, context.getProblemCollector()));		
			}
		}
		
		monitor.worked(20);
		return proxy2Name;
	}

	private static void generatePrettyPrinter(GenerationContext context,
			SubMonitor progress, ITextResource csResource, IFile printerFile,
			IFile printerBaseFile, String antlrName, String printerName,
			String printerBaseName, String treeAnalyserName,
			String tokenResolverFactoryName, TextParserGenerator antlrGen)
			throws CoreException {
		
		progress.setTaskName("generating printer...");
		boolean generatePrinterStubOnly = OptionManager.INSTANCE.getBooleanOption(context.getConcreteSyntax(), GENERATE_PRINTER_STUB_ONLY);
		boolean overridePrinter = OptionManager.INSTANCE.getBooleanOption(context.getConcreteSyntax(), OVERRIDE_PRINTER);

		boolean printerExists = printerFile.exists();
		boolean printerBaseExists = printerBaseFile.exists();

    	boolean generatePrinter = !printerExists || overridePrinter;
		boolean generatePrinterBase = !printerBaseExists || overridePrinter;

	    // always generate printer base
		if (generatePrinterBase && !generatePrinterStubOnly) {
	        BaseGenerator printerBaseGenerator = new TextPrinterBaseGenerator(context, 
	        		antlrGen.getPlaceHolderTokenMapping()
	        );
		    setContents(printerBaseFile, invokeGeneration(printerBaseGenerator, context.getProblemCollector()));	    		
    	}
		if (generatePrinter) {
			BaseGenerator printerGen;
			if (generatePrinterStubOnly) {
	    		printerGen = new TextPrinterGenerator(context, false);
			} else {
	    		printerGen = new TextPrinterGenerator(context, true);
			}
	    	setContents(printerFile, invokeGeneration(printerGen, context.getProblemCollector()));
	    }
	    progress.worked(20);
	}

	private static void runANTLR(GenerationContext pck, SubMonitor progress,
			IFile antlrFile) {
		progress.setTaskName("running ANTLR on grammar file...");
        ErrorManager.setErrorListener(new TextResourceGeneratorANTLRErrorListener(pck.getConcreteSyntax().eResource()));
        Tool antlrTool = new Tool(new String[]{"-Xconversiontimeout", "10000", "-o", antlrFile.getLocation().removeLastSegments(1).toOSString(), antlrFile.getLocation().toOSString()});
        antlrTool.process();
        progress.worked(20);
	}

	private static void generateEMFResources(SubMonitor progress,
			IFile resourceFile,
			IFile resourceFactoryFile, IGenerator resourceGen,
			IGenerator resourceFactoryGen, GenerationContext context) throws CoreException {
		progress.setTaskName("generating EMF resources...");
		setContents(resourceFile, invokeGeneration(resourceGen, context.getProblemCollector()));
		setContents(resourceFactoryFile, invokeGeneration(resourceFactoryGen, context.getProblemCollector()));
		progress.worked(5);
	}

	public static InputStream deriveGrammar(IGenerator antlrGen, GenerationContext context)
			throws CoreException {
		InputStream content = invokeGeneration(antlrGen, context.getProblemCollector());
		return content;
	}
	
	private static void saveGrammar(InputStream content, GenerationContext pck, IFile antlrFile) throws CoreException {
		boolean generateANTLRSpecification = !antlrFile.exists() || OptionManager.INSTANCE.getBooleanOption(pck.getConcreteSyntax(), OVERRIDE_ANTLR_SPEC);
	    if (generateANTLRSpecification) {
	    	setContents(antlrFile, content);
	    }
	}
       
	private static InputStream invokeGeneration(IGenerator generator, IProblemCollector collector){
       ByteArrayOutputStream stream = new ByteArrayOutputStream();
	   PrintWriter out = new PrintWriter(new BufferedOutputStream(stream));
       try {
    	   if (generator.generate(out)) {
    		   out.flush();
    		   return new ByteArrayInputStream(stream.toByteArray());
       	   }
		}
		finally {
			out.close();
			Collection<GenerationProblem> collectedProblems = generator.getCollectedProblems();
			if (collectedProblems != null) {
				for (GenerationProblem problem : collectedProblems) {
					collector.addProblem(problem);
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

package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.ICodeGenOptions.GENERATE_PRINTER_STUB_ONLY;
import static org.emftext.sdk.codegen.ICodeGenOptions.OVERRIDE_ANTLR_SPEC;
import static org.emftext.sdk.codegen.ICodeGenOptions.OVERRIDE_PRINTER;
import static org.emftext.sdk.codegen.ICodeGenOptions.OVERRIDE_PRINTER_BASE;
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
import java.util.LinkedHashSet;
import java.util.LinkedList;
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.runtime.EMFTextPlugin;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.util.TextResourceGeneratorANTLRErrorListener;

/**
 * A generator that uses multiple other generators to create
 * a resource plug-in from as CS specification and a meta model.
 */
public class ResourcePluginGenerator {
	
	private static final String JAVA_FILE_EXTENSION = ".java";
	
	public void generate(GenerationContext context, IProgressMonitor monitor)throws CoreException{
		SubMonitor progress = SubMonitor.convert(monitor, "generating resources...", 100);
	    
		IFolder targetFolder = context.getTargetFolder();
		
		ITextResource csResource = (ITextResource) context.getConcreteSyntax().eResource();
		EcoreUtil.resolveAll(csResource);
		if (!targetFolder.exists()) {
		   	targetFolder.create(false, true, progress.newChild(5));
		}
  		
		IPath csPackagePath = new Path(context.getPackageName().replaceAll("\\.","/"));
  		IPath resolverPackagePath = new Path(context.getResolverPackageName().replaceAll("\\.","/"));
  		
	    String antlrName = context.getCapitalizedConcreteSyntaxName();
	    String printerName = context.getPrinterName();
	    String printerBaseName = context.getPrinterBaseClassName();
	    String resourceName = context.getResourceClassName();
	    String resourceFactoryName = context.getResourceFactoryClassName();
	    String treeAnalyserName = context.getReferenceResolverSwitchClassName();
	    String tokenResolverFactoryName = context.getTokenResolverFactoryClassName();
        
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
    	
        generatePrinterAndPrinterBase(context, progress, csResource, printerFile,
				printerBaseFile, antlrName, printerName, printerBaseName,
				treeAnalyserName, tokenResolverFactoryName, antlrGenenerator);
	    
	    generateReferenceResolvers(context,
				progress, csResource, resolverPackagePath,
				antlrGenenerator);
		
		generateReferenceResolverSwitch(context, progress, csResource, treeAnalyserFile,
				treeAnalyserName);
		
		generateTokenResolvers(
				context, progress, csResource,
				resolverPackagePath, antlrGenenerator);
		
		generateTokenResolverFactory(context, progress, csResource,
				tokenResolverFactoryFile, tokenResolverFactoryName);
		
		searchForUnusedResolvers(context, resolverPackagePath);
	}

	private static void searchForUnusedResolvers(
			GenerationContext context, IPath resolverPackagePath) throws CoreException {
		
		Set<String> resolverFiles = new LinkedHashSet<String>();
		for (String className : context.getResolverClasses()) {
			resolverFiles.add(className + JAVA_FILE_EXTENSION);
		}
		
		IFolder resolverPackageFolder = context.getTargetFolder().getFolder(resolverPackagePath);
		if (!resolverPackageFolder.exists()) {
			return;
		}
		IResource[] contents = resolverPackageFolder.members();
		for (IResource member : contents) {
			if (member instanceof IFile) {
				IFile file = (IFile) member;
				String fileName = file.getName();
				if (!resolverFiles.contains(fileName)) {
					// issue warning about unused resolver
					((ITextResource) context.getConcreteSyntax().eResource()).addWarning("Found unused class '" + fileName + "' in analysis package.", null);
				}
			}
		}
	}

	private static void generateTokenResolverFactory(
			GenerationContext context,
			SubMonitor progress,
			ITextResource csResource,
			IFile tokenResolverFactoryFile,
			String tokenResolverFactoryName)
			throws CoreException {
		progress.setTaskName("generating token resolver factory...");
		boolean generateTokenResolverFactory = !tokenResolverFactoryFile.exists() || OptionManager.INSTANCE.getBooleanOptionValue(context.getConcreteSyntax(), OVERRIDE_TOKEN_RESOLVER_FACTORY);
		if (generateTokenResolverFactory) {
			BaseGenerator factoryGen = new TokenResolverFactoryGenerator(context);
			setContents(tokenResolverFactoryFile,invokeGeneration(factoryGen, context.getProblemCollector()));
		}
	}

	private void generateTokenResolvers(
			GenerationContext context, SubMonitor progress,
			ITextResource csResource,
			IPath resolverPackagePath, TextParserGenerator parserGenerator)
			throws CoreException {
		progress.setTaskName("generating token resolvers...");
		IFolder targetFolder = context.getTargetFolder();
		for(TextParserGenerator.InternalTokenDefinition tokenDefinition : parserGenerator.getPrintedTokenDefinitions()){
			if (!tokenDefinition.isReferenced() && !tokenDefinition.isCollect()) {
				continue;
			}
			String tokenResolverClassName = context.getTokenResolverClassName(tokenDefinition);
			context.addUsedToken(tokenDefinition);
			// do not generate a resolver for imported tokens
			if (context.isImportedToken(tokenDefinition)) {
				continue;
			}
			IFile resolverFile = targetFolder.getFile(resolverPackagePath.append(tokenResolverClassName + JAVA_FILE_EXTENSION));
			boolean generateResolver = !resolverFile.exists() || OptionManager.INSTANCE.getBooleanOptionValue(context.getConcreteSyntax(), OVERRIDE_TOKEN_RESOLVERS);
			if (generateResolver) {
				BaseGenerator resolverGenerator = new TokenResolverGenerator(context, tokenResolverClassName, tokenDefinition);
				setContents(resolverFile, invokeGeneration(resolverGenerator, context.getProblemCollector()));
			}
			context.addTokenResolverClass(tokenResolverClassName);
		}
		progress.worked(20);
	}

	private static void generateReferenceResolverSwitch(GenerationContext context,
			SubMonitor progress, ITextResource csResource,
			IFile resolverSwitchFile, String referenceResolverName) throws CoreException {
		progress.setTaskName("generating reference resolver switch...");

		boolean generateReferenceResolverSwitch = !resolverSwitchFile.exists() || OptionManager.INSTANCE.getBooleanOptionValue(context.getConcreteSyntax(), OVERRIDE_TREE_ANALYSER);
		if (generateReferenceResolverSwitch) {
			BaseGenerator analyserGen = new ReferenceResolverSwitchGenerator(context);
			setContents(resolverSwitchFile,invokeGeneration(analyserGen, context.getProblemCollector()));
		}
		progress.worked(5);
	}

	private void generateReferenceResolvers(
			GenerationContext context, SubMonitor monitor, 
			ITextResource csResource, IPath resolverPackagePath,
			TextParserGenerator antlrGenerator) throws CoreException {
		
		monitor.setTaskName("generating reference resolvers...");
		
		IFolder targetFolder = context.getTargetFolder();
		
		for (GenFeature proxyReference : antlrGenerator.getProxyReferences()){
			String resolverClassName = context.getReferenceResolverClassName(proxyReference);
			context.addNonContainmentReference(proxyReference);
			// do not generate resolvers for references in imported rules
			if (context.isImportedReference(proxyReference)) {
				continue;
			}
			String resolverFileName = resolverClassName + JAVA_FILE_EXTENSION;
			IFile resolverFile = targetFolder.getFile(resolverPackagePath.append(resolverFileName));
			boolean generateResolver = !resolverFile.exists() || OptionManager.INSTANCE.getBooleanOptionValue(context.getConcreteSyntax(), OVERRIDE_REFERENCE_RESOLVERS);
			if (generateResolver) {
				BaseGenerator proxyGen = new ReferenceResolverGenerator(context, proxyReference);
				setContents(resolverFile, invokeGeneration(proxyGen, context.getProblemCollector()));		
			}
			context.addReferenceResolverClass(resolverClassName);
		}
		
		monitor.worked(20);
	}

	private static void generatePrinterAndPrinterBase(GenerationContext context,
			SubMonitor progress, ITextResource csResource, IFile printerFile,
			IFile printerBaseFile, String antlrName, String printerName,
			String printerBaseName, String treeAnalyserName,
			String tokenResolverFactoryName, TextParserGenerator antlrGen)
			throws CoreException {
		
		progress.setTaskName("generating printer...");
		boolean generatePrinterStubOnly = OptionManager.INSTANCE.getBooleanOptionValue(context.getConcreteSyntax(), GENERATE_PRINTER_STUB_ONLY);
		boolean overridePrinter = OptionManager.INSTANCE.getBooleanOptionValue(context.getConcreteSyntax(), OVERRIDE_PRINTER);
		boolean overridePrinterBase = OptionManager.INSTANCE.getBooleanOptionValue(context.getConcreteSyntax(), OVERRIDE_PRINTER_BASE);

		boolean printerExists = printerFile.exists();
		boolean printerBaseExists = printerBaseFile.exists();

    	boolean generatePrinter = !printerExists || overridePrinter;
		boolean generatePrinterBase = !printerBaseExists || overridePrinterBase;

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
		boolean generateANTLRSpecification = !antlrFile.exists() || OptionManager.INSTANCE.getBooleanOptionValue(pck.getConcreteSyntax(), OVERRIDE_ANTLR_SPEC);
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
		} catch (Exception e) {
			EMFTextPlugin.logError("Exception while invoking code generator.", e);
		} finally {
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

	private static void setContents(IFile target, InputStream in) throws CoreException {
		if (target.exists()) {
			target.setContents(in, false, false, new NullProgressMonitor());
		} else {
			LinkedList<IResource> stack = new LinkedList<IResource>();
			if (!target.getParent().exists()) {
				stack.addFirst(target.getParent());
				while (!stack.isEmpty()) {
					if (!stack.peek().getParent().exists())
						stack.addFirst(stack.peek().getParent());
					else
						((IFolder) stack.removeFirst()).create(false, false,
								new NullProgressMonitor());
				}
			}
			target.create(in, false, new NullProgressMonitor());
		}
	}
}

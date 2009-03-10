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
package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.ICodeGenOptions.GENERATE_PRINTER_STUB_ONLY;
import static org.emftext.sdk.codegen.ICodeGenOptions.OVERRIDE_ANTLR_SPEC;
import static org.emftext.sdk.codegen.ICodeGenOptions.OVERRIDE_PRINTER;
import static org.emftext.sdk.codegen.ICodeGenOptions.OVERRIDE_PRINTER_BASE;
import static org.emftext.sdk.codegen.ICodeGenOptions.OVERRIDE_REFERENCE_RESOLVERS;
import static org.emftext.sdk.codegen.ICodeGenOptions.OVERRIDE_TOKEN_RESOLVERS;
import static org.emftext.sdk.codegen.ICodeGenOptions.OVERRIDE_TOKEN_RESOLVER_FACTORY;
import static org.emftext.sdk.codegen.ICodeGenOptions.OVERRIDE_REFERENCE_RESOLVER_SWITCH;
import static org.emftext.sdk.codegen.util.GeneratorUtil.setContents;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.antlr.Tool;
import org.antlr.tool.ErrorManager;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.generators.adapter.IInternalTokenDefinition;
import org.emftext.sdk.codegen.util.TextResourceGeneratorANTLRErrorListener;

/**
 * A generator that uses multiple other generators to create
 * a resource plug-in from as CS specification and a meta model.
 */
public class ResourcePluginContentGenerator {
	
	private static final String ANTRL_GRAMMAR_FILE_EXTENSION = ".g";
	private static final String JAVA_FILE_EXTENSION = ".java";
	
	public void generate(GenerationContext context, IProgressMonitor monitor)throws IOException{
		SubMonitor progress = SubMonitor.convert(monitor, "generating resources...", 100);
	    
		File targetFolder = context.getSourceFolder();
		
		ITextResource csResource = (ITextResource) context.getConcreteSyntax().eResource();
		EcoreUtil.resolveAll(csResource);
		if (!targetFolder.exists()) {
		   	targetFolder.mkdir();
		}
  		
		IPath csPackagePath = new Path(context.getPackageName().replaceAll("\\.","/"));
  		IPath resolverPackagePath = new Path(context.getResolverPackageName().replaceAll("\\.","/"));
  		
	    String antlrName = context.getCapitalizedConcreteSyntaxName();
	    String printerName = context.getPrinterName();
	    String printerBaseName = context.getPrinterBaseClassName();
	    String resourceName = context.getResourceClassName();
	    String resourceFactoryName = context.getResourceFactoryClassName();
	    String newFileActionName = context.getNewFileActionClassName();
	    String referenceResolverSwitchName = context.getReferenceResolverSwitchClassName();
	    String tokenResolverFactoryName = context.getTokenResolverFactoryClassName();
        
  		String packagePath = targetFolder.getAbsolutePath() + File.separator + csPackagePath + File.separator;
		
  		File antlrFile = new File(packagePath + antlrName + ANTRL_GRAMMAR_FILE_EXTENSION);
	    File printerFile = new File(packagePath + printerName + JAVA_FILE_EXTENSION);
	    File printerBaseFile = new File(packagePath + printerBaseName + JAVA_FILE_EXTENSION);
	    File resourceFile = new File(packagePath + resourceName + JAVA_FILE_EXTENSION);
        File resourceFactoryFile = new File(packagePath + resourceFactoryName + JAVA_FILE_EXTENSION);
	    File referenceResolverFile = new File(packagePath + referenceResolverSwitchName + JAVA_FILE_EXTENSION);
	    File newFileActionFile = new File(packagePath + newFileActionName + JAVA_FILE_EXTENSION);
	    File tokenResolverFactoryFile = new File(packagePath + tokenResolverFactoryName + JAVA_FILE_EXTENSION);
	    	    
	    ANTLRGrammarGenerator antlrGenenerator = new ANTLRGrammarGenerator(context);
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
				referenceResolverSwitchName, tokenResolverFactoryName, antlrGenenerator);
	    
	    generateReferenceResolvers(context,
				progress, csResource, resolverPackagePath,
				antlrGenenerator);
		
		generateReferenceResolverSwitch(context, progress, csResource, referenceResolverFile,
				referenceResolverSwitchName);
		
		generateNewFileAction(context, progress, csResource, newFileActionFile, newFileActionName);
		
		generateTokenResolvers(
				context, progress, csResource,
				resolverPackagePath, antlrGenenerator);
		
		generateTokenResolverFactory(context, progress, csResource,
				tokenResolverFactoryFile, tokenResolverFactoryName);
		
		searchForUnusedResolvers(context, resolverPackagePath);
	}

	private static void searchForUnusedResolvers(
			GenerationContext context, IPath resolverPackagePath) {
		
		Set<String> resolverFiles = new LinkedHashSet<String>();
		for (String className : context.getResolverClasses()) {
			resolverFiles.add(className + JAVA_FILE_EXTENSION);
		}
		
		File resolverPackageFolder = new File(context.getSourceFolder().getAbsolutePath() + File.separator + resolverPackagePath);
		if (!resolverPackageFolder.exists()) {
			return;
		}
		File[] contents = resolverPackageFolder.listFiles();
		for (File member : contents) {
			if (!member.isDirectory()) {
				String fileName = member.getName();
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
			File tokenResolverFactoryFile,
			String tokenResolverFactoryName)
			throws IOException {
		progress.setTaskName("generating token resolver factory...");
		boolean generateTokenResolverFactory = !tokenResolverFactoryFile.exists() || OptionManager.INSTANCE.getBooleanOptionValue(context.getConcreteSyntax(), OVERRIDE_TOKEN_RESOLVER_FACTORY);
		if (generateTokenResolverFactory) {
			BaseGenerator factoryGen = new TokenResolverFactoryGenerator(context);
			setContents(tokenResolverFactoryFile, invokeGeneration(factoryGen, context.getProblemCollector()));
		}
	}

	private void generateTokenResolvers(
			GenerationContext context, SubMonitor progress,
			ITextResource csResource,
			IPath resolverPackagePath, ANTLRGrammarGenerator parserGenerator)
			throws IOException {
		progress.setTaskName("generating token resolvers...");
		File targetFolder = context.getSourceFolder();
		for(IInternalTokenDefinition tokenDefinition : parserGenerator.getPrintedTokenDefinitions()){
			if (!tokenDefinition.isReferenced() && !tokenDefinition.isCollect()) {
				continue;
			}
			String tokenResolverClassName = context.getTokenResolverClassName(tokenDefinition);
			context.addUsedToken(tokenDefinition);
			// do not generate a resolver for imported tokens
			if (context.isImportedToken(tokenDefinition)) {
				continue;
			}
			File resolverFile = new File(targetFolder.getAbsolutePath() + File.separator + resolverPackagePath + File.separator + tokenResolverClassName + JAVA_FILE_EXTENSION);
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
			File resolverSwitchFile, String referenceResolverName) throws IOException {
		progress.setTaskName("generating reference resolver switch...");

		boolean generateReferenceResolverSwitch = !resolverSwitchFile.exists() || OptionManager.INSTANCE.getBooleanOptionValue(context.getConcreteSyntax(), OVERRIDE_REFERENCE_RESOLVER_SWITCH);
		if (generateReferenceResolverSwitch) {
			BaseGenerator analyserGen = new ReferenceResolverSwitchGenerator(context);
			setContents(resolverSwitchFile,invokeGeneration(analyserGen, context.getProblemCollector()));
		}
		progress.worked(5);
	}

	private static void generateNewFileAction(GenerationContext context,
			SubMonitor progress, ITextResource csResource,
			File newFileActionFile, String newFileActionName) throws IOException {
		progress.setTaskName("generating new file action...");

		IGenerator analyserGen = new NewFileContentGenerator(context);
		setContents(newFileActionFile, invokeGeneration(analyserGen, context.getProblemCollector()));
		progress.worked(5);
	}

	private void generateReferenceResolvers(
			GenerationContext context, SubMonitor monitor, 
			ITextResource csResource, IPath resolverPackagePath,
			ANTLRGrammarGenerator antlrGenerator) throws IOException {
		
		monitor.setTaskName("generating reference resolvers...");
		
		File targetFolder = context.getSourceFolder();
		
		for (GenFeature proxyReference : antlrGenerator.getNonContainmentReferences()){
			String resolverClassName = context.getReferenceResolverClassName(proxyReference);
			context.addNonContainmentReference(proxyReference);
			// do not generate resolvers for references in imported rules
			final boolean isImportedReference = context.isImportedReference(proxyReference);
			if (isImportedReference) {
				continue;
			}
			String resolverFileName = resolverClassName + JAVA_FILE_EXTENSION;
			File resolverFile = new File(targetFolder + File.separator + resolverPackagePath + File.separator + resolverFileName);
			boolean generateResolver = 
				!resolverFile.exists() || 
				OptionManager.INSTANCE.getBooleanOptionValue(context.getConcreteSyntax(), OVERRIDE_REFERENCE_RESOLVERS);
			if (generateResolver) {
				BaseGenerator proxyGen = new ReferenceResolverGenerator(context, proxyReference);
				setContents(resolverFile, invokeGeneration(proxyGen, context.getProblemCollector()));		
			}
			context.addReferenceResolverClass(resolverClassName);
		}
		
		monitor.worked(20);
	}

	private static void generatePrinterAndPrinterBase(GenerationContext context,
			SubMonitor progress, ITextResource csResource, File printerFile,
			File printerBaseFile, String antlrName, String printerName,
			String printerBaseName, String referenceResolverName,
			String tokenResolverFactoryName, ANTLRGrammarGenerator antlrGen)
			throws IOException {
		
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

	private static void runANTLR(GenerationContext context, SubMonitor progress,
			File antlrFile) {
		progress.setTaskName("running ANTLR on grammar file...");
        ErrorManager.setErrorListener(new TextResourceGeneratorANTLRErrorListener(context.getConcreteSyntax().eResource()));
        Tool antlrTool = new Tool(new String[]{"-Xconversiontimeout", "10000", "-o", antlrFile.getParentFile().getAbsolutePath(), antlrFile.getAbsolutePath()});
        antlrTool.process();
        progress.worked(20);
	}

	private static void generateEMFResources(SubMonitor progress,
			File resourceFile,
			File resourceFactoryFile, IGenerator resourceGen,
			IGenerator resourceFactoryGen, GenerationContext context) throws IOException {
		progress.setTaskName("generating EMF resources...");
		setContents(resourceFile, invokeGeneration(resourceGen, context.getProblemCollector()));
		setContents(resourceFactoryFile, invokeGeneration(resourceFactoryGen, context.getProblemCollector()));
		progress.worked(5);
	}

	public static InputStream deriveGrammar(IGenerator antlrGen, GenerationContext context) {
		InputStream content = invokeGeneration(antlrGen, context.getProblemCollector());
		return content;
	}
	
	private static void saveGrammar(InputStream content, GenerationContext context, File grammarFile) throws IOException {
		boolean generateANTLRSpecification = !grammarFile.exists() || OptionManager.INSTANCE.getBooleanOptionValue(context.getConcreteSyntax(), OVERRIDE_ANTLR_SPEC);
	    if (generateANTLRSpecification) {
	    	setContents(grammarFile, content);
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
			EMFTextRuntimePlugin.logError("Exception while invoking code generator.", e);
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

	/*
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
	*/
}

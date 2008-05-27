package org.reuseware.emftextedit.codegen;

import java.io.ByteArrayOutputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.HashMap;

import org.reuseware.emftextedit.resource.TextResource;
import org.antlr.Tool;
import org.antlr.tool.ErrorManager;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.NullProgressMonitor;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;



public class ResourcePackageGenerator {
	
	public static void generate(ResourcePackage pck){
	    String capCsName = BaseGenerator.cap(pck.getConcreteSyntax().getName());
		IFolder targetFolder = pck.getTargetFolder();
		
		TextResource csResource = (TextResource)pck.getConcreteSyntax().eResource(); 
		try{
			if(!targetFolder.exists())
		    	targetFolder.create(false,true,new NullProgressMonitor());
  		IPath csPackagePath = new Path(pck.getCsPackageName().replaceAll("\\.","/"));
  		IPath resolverPackagePath = new Path(pck.getResolverPackageName().replaceAll("\\.","/"));
  		
  		IFile antlrFile = targetFolder.getFile(csPackagePath.append(capCsName + ".g"));
	    IFile printerFile = targetFolder.getFile(csPackagePath.append(capCsName + "Printer.java"));
	    IFile printerBaseFile = targetFolder.getFile(csPackagePath.append(capCsName + "PrinterBase.java"));
	    IFile resourceFile = targetFolder.getFile(csPackagePath.append(capCsName + "ResourceImpl.java"));
        IFile resourceFactoryFile = targetFolder.getFile(csPackagePath.append(capCsName + "ResourceFactoryImpl.java"));
	    IFile treeAnalyserFile = targetFolder.getFile(csPackagePath.append(capCsName + "TreeAnalyser.java"));
	    IFile tokenResolverFactoryFile = targetFolder.getFile(csPackagePath.append(capCsName + "TokenResolverFactory.java"));
	    
	    String antlrName = capCsName;
	    String printerName = capCsName + "Printer";
	    String printerBaseName = capCsName + "PrinterBase";
	    String resourceName = capCsName + "ResourceImpl";
	    String resourceFactoryName = capCsName + "ResourceFactoryImpl";
	    String treeAnalyserName = capCsName + "TreeAnalyser";
	    String tokenResolverFactoryName = capCsName + "TokenResolverFactory";
        
	    
	    BaseGenerator antlrGen = new TextParserGenerator(pck.getConcreteSyntax(),antlrName,pck.getCsPackageName(),tokenResolverFactoryName);
	    BaseGenerator resourceGen = new TextResourceGenerator(resourceName,pck.getCsPackageName(),capCsName,printerName,treeAnalyserName);
	    BaseGenerator resourceFactoryGen = new ResourceFactoryGenerator(resourceFactoryName,pck.getCsPackageName(),resourceName);
	    
	    InputStream content = null;
	    content = invokeGeneration(antlrGen,csResource);
	    if(content != null)
	    	setContents(antlrFile,content);
	    else
	    	return;
	    
		setContents(resourceFile,invokeGeneration(resourceGen,csResource));
		setContents(resourceFactoryFile,invokeGeneration(resourceFactoryGen,csResource));
		
        //run the ANTLR Tool on the g file
        ErrorManager.setErrorListener(new TextResourceGeneratorANTLRErrorListener(pck.getConcreteSyntax().eResource()));
        Tool antlrTool = new Tool(new String[]{"-o",antlrFile.getLocation().removeLastSegments(1).toOSString(), antlrFile.getLocation().toOSString()});
        antlrTool.process();

        
	    BaseGenerator printerBaseGen = new TextPrinterBaseGenerator(pck.getConcreteSyntax(),printerBaseName,pck.getCsPackageName(),antlrName,tokenResolverFactoryName,((TextParserGenerator)antlrGen).getPlaceHolderTokenMapping(),treeAnalyserName);
	    setContents(printerBaseFile,invokeGeneration(printerBaseGen,csResource));

	    if(!printerFile.exists()){
		    BaseGenerator printerGen = new TextPrinterGenerator(printerName,pck.getCsPackageName(),printerBaseName);
		    setContents(printerFile,invokeGeneration(printerGen,csResource));
	    }
		
		HashMap<GenFeature,String> proxy2Name = new HashMap<GenFeature,String>();
		for(GenFeature proxyReference:((TextParserGenerator)antlrGen).getProxyReferences()){
			String className = proxyReference.getGenClass().getName() + BaseGenerator.cap(proxyReference.getName()) + "ProxyResolver";
			proxy2Name.put(proxyReference,className);
			IFile resolverFile = targetFolder.getFile(resolverPackagePath.append(className +".java"));
			if(!resolverFile.exists()){
				BaseGenerator proxyGen = new ProxyResolverGenerator(className,pck.getResolverPackageName());
				setContents(resolverFile, invokeGeneration(proxyGen,csResource));				
			}
		}
		
		BaseGenerator analyserGen = new TextTreeAnalyserGenerator(proxy2Name,treeAnalyserName,pck.getCsPackageName(),pck.getResolverPackageName());
		setContents(treeAnalyserFile,invokeGeneration(analyserGen,csResource));
		
		
		HashMap<TextParserGenerator.InternalTokenDefinition,String> token2Name = new HashMap<TextParserGenerator.InternalTokenDefinition,String>();
		for(TextParserGenerator.InternalTokenDefinition definition:((TextParserGenerator)antlrGen).getPrintedTokenDefinitions()){
			if(!definition.isReferenced())
				continue;
			String className = capCsName + definition.getName() +"TokenResolver";
			token2Name.put(definition,className);
			IFile resolverFile = targetFolder.getFile(resolverPackagePath.append(className+".java"));
			if(!resolverFile.exists()){
				BaseGenerator resolverGen = new TokenResolverGenerator(className,pck.getResolverPackageName(),definition);
				setContents(resolverFile,invokeGeneration(resolverGen,csResource));
			}
		}
		
		BaseGenerator factoryGen = new TokenResolverFactoryGenerator(token2Name,tokenResolverFactoryName,pck.getCsPackageName(),pck.getResolverPackageName());
		setContents(tokenResolverFactoryFile,invokeGeneration(factoryGen,csResource));
		
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    }
	    
	  }
       
	private static InputStream invokeGeneration(BaseGenerator gen, TextResource csResource){
       PrintWriter out;
       ByteArrayOutputStream stream = new ByteArrayOutputStream();
       out = new PrintWriter(new BufferedOutputStream(stream));
       try{
    	   if(gen.generate(out)){
    		   out.flush();
    		   return new ByteArrayInputStream(stream.toByteArray());
       	   }	
        }
        finally{
   	   	    out.close();
   	 	    if(gen.getOccuredProblems()!=null){
   	   	    	for(IGenerator.GenerationProblem problem:gen.getOccuredProblems()){
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
    	
    	   if(target.exists()){
    		   target.setContents(in,false,false,new NullProgressMonitor());
    	   }
    	   else{
    		   LinkedList<IResource> stack = new LinkedList<IResource>();
    		   if(!target.getParent().exists()){
    			   stack.push(target.getParent());
    			   while(!stack.isEmpty()){
    				   if(!stack.peek().getParent().exists())
    					   stack.push(stack.peek().getParent());
    				   else
    					   ((IFolder)stack.pop()).create(false,false,new NullProgressMonitor());
    			   }
    		   }
       		   target.create(in,false,new NullProgressMonitor());
    	   }
       }
	
}

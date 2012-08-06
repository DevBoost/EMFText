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
package org.emftext.language.java.java2dsl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emftext.language.java.java2dsl.mediniqvt.MediniQVTDirectionEnum;
import org.emftext.language.java.java2dsl.mediniqvt.MediniQVTStarter;
import org.emftext.language.java.java2dsl.util.MetaModelName;
import org.emftext.sdk.util.StreamUtil;

public abstract class AbstractMediniBuilderAdapter {

	private static Stack<Thread> threads = new Stack<Thread>();
	private static Map<URI,Thread> semaphoreMap = new HashMap<URI,Thread>();
	
	public abstract int getTimeout();
	public abstract int getMaxActiveThreads();
	public abstract String getDirectoryWithScripts();
	public abstract String getScriptInOneDirection();
	public abstract String getScriptInOtherDirection();
	public abstract String getUtilClassName();
	public abstract MetaModelName getMetaModelInLeftDirection();
	public abstract MetaModelName getMetaModelInRightDirection();
	public abstract List<String> getImportantMappingOperationNameInLeftDirection();
	public abstract List<String> getImportantMappingOperationNameInRightDirection();
	public abstract String getFileExtension();
	public abstract String getDomainNameInLeftDirection();
	public abstract String getDomainNameInRightDirection();
	public abstract String getTransformationName();
	
	
	public boolean isBuildingNeeded(URI uri) {
		
		for(String segment : uri.segmentsList()){
			if(segment.toLowerCase().equals("bin"))
				return false;
		}
		
		if(uri.segment(uri.segmentCount()-1).contains("_transformed"))
			return false;
		
		if(semaphoreMap.containsKey(uri))
			return false;
		
		return true;
	}
	
	public IStatus build(final Resource resource, IProgressMonitor monitor) {
		
		Thread root = new Thread(new Runnable(){

			public void run() {
				callThreads(resource);
			}
			
		},"RootThread");
		
		semaphoreMap.put(resource.getURI(), root);
		root.start();
		semaphoreMap.remove(resource.getURI());
		
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}

	private void callThreads(final Resource resource){
	
		while(threads.size() >= getMaxActiveThreads()) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			continue;
		}
		
		Runnable runnable = new Runnable(){ 
			
			public void run() {
				convert(resource);
				
				threads.remove(Thread.currentThread());
			}
		};
		
		final Thread workerThread = new Thread(runnable,"PostProcessor");
		threads.add(workerThread);
		
		final Thread timeoutThread = new Thread(new Runnable() {
	
			@SuppressWarnings("deprecation")
			public void run() {
				try {
					workerThread.join(getTimeout());
					boolean wasStillAlive = workerThread.isAlive();
					if(wasStillAlive)
						System.out.println("interrupt: " + workerThread);
					workerThread.stop();
					while (workerThread.isAlive()) {
						System.out.println(workerThread.toString() + "is still there!");
						Thread.sleep(100);
					}
					if (wasStillAlive) {
						System.out.println("Run was interrupted by timeout.");
					}
				}
				catch (Exception e1) {
					System.out.println(e1);
				}
				threads.remove(workerThread);
			}
		}, "Timeout Thread");
		
		workerThread.start();
		timeoutThread.start();
	}
	
	private void convert(Resource resource){
		
		// java 2 DSL
		
		init(resource.getResourceSet());
		
		URI xmiSourceURI = 
			resource.getURI().appendFileExtension("xmi");
		
		URI resourceURI =
			resource.getURI().trimFileExtension().appendFileExtension(getFileExtension());
		
		URI xmiTargetURI = 
			resource.getURI().trimFileExtension().appendFileExtension(
					getFileExtension()+".xmi");
	
		URI transformationFileURI = 
			resource.getURI().trimFileExtension()
				.trimSegments(resource.getURI().segmentCount()-2)
				.appendSegment(getDirectoryWithScripts())
				.appendSegment(getScriptInOneDirection())
				.appendFileExtension("qvt");
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IPath rootPath = root.getLocation();
		File rootPathFile = rootPath.toFile();
		String transformationFileURIString = 
			rootPathFile.toString().concat(transformationFileURI.toPlatformString(true));
	//	transformationFileURIString =
	//		transformationFileURIString.replaceAll("\\\\", "/").concat("file:/");
		
		if(new File(transformationFileURIString).exists()){
		
			XMIResource xmiResource = 
				(XMIResource)resource.getResourceSet().createResource(xmiSourceURI);
			
			xmiResource.getContents().addAll(EcoreUtil.copyAll(resource.getContents()));
	
			try {
				xmiResource.save(null);
			} catch (IOException e) {
				System.out.println(e);
			}
	
			MediniQVTStarter starter = new MediniQVTStarter(
					xmiSourceURI, 
					xmiTargetURI,
					rootPathFile.toString(),
					transformationFileURIString, 
					rootPathFile.toString().concat(xmiSourceURI.toPlatformString(true)), 
					getTransformationName(), 
					getDomainNameInLeftDirection(), 
					getUtilClassName(), 
					getImportantMappingOperationNameInLeftDirection(),
					MediniQVTDirectionEnum.JAVA2DSL,
					getMetaModelInLeftDirection());
			
			if(starter.isHandledInterestingRules()){
			
				Resource javaResource = 
					resource.getResourceSet().createResource(resourceURI);
			
				XMIResource xmiResourceTransformed = 
					(XMIResource)resource.getResourceSet().createResource(xmiTargetURI);
				
				try {
					xmiResourceTransformed.load(null);
				} catch (IOException e) {
					System.out.println(e);
				}
				
				javaResource.getContents().addAll(
						EcoreUtil.copyAll(
								xmiResourceTransformed.getContents()));
				
				//TODO only save when necessary
				
				URI propertyTempResourceURI =
					resource.getURI().trimFileExtension().trimSegments(1).appendSegment(
							resource.getURI().trimFileExtension().segment(
									resource.getURI().segmentCount()-1)
									.concat("_transformed")).appendFileExtension(getFileExtension());
				Resource resourceTemp = 
					resource.getResourceSet().createResource(propertyTempResourceURI);
			
				resourceTemp.getContents().addAll(
						EcoreUtil.copyAll(xmiResourceTransformed.getContents()));
				try {
					resourceTemp.save(null);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				File propertyResourceTempFile = new File(
					rootPathFile.toString().concat(propertyTempResourceURI.toPlatformString(true)));
				File propertyResourceFile = new File(
						rootPathFile.toString().concat(resourceURI.toPlatformString(true)));
					
				boolean hasContentChanged = false;
				
				try {
					ByteArrayInputStream propertyResourceTempFileBytes =
						 new ByteArrayInputStream(StreamUtil.getContent(propertyResourceTempFile));
						
					hasContentChanged = 
						StreamUtil.storeContentIfChanged(
								propertyResourceFile, propertyResourceTempFileBytes);
					if(hasContentChanged)
						System.out.println(resourceURI + " content was changed!");
				
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				try {
					resourceTemp.delete(null);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			else{
				
				// try other direction of transformation -> embedded DSL 2 java
				
				xmiSourceURI = 
					resource.getURI().appendFileExtension("xmi");
				
				resourceURI =
					resource.getURI().trimFileExtension().appendFileExtension("java");
				
				xmiTargetURI = 
					resource.getURI().trimFileExtension().appendFileExtension(
							getFileExtension()+".xmi");
				
				transformationFileURI = 
					resource.getURI().trimFileExtension()
						.trimSegments(resource.getURI().segmentCount()-2)
						.appendSegment(getDirectoryWithScripts())
						.appendSegment(getScriptInOtherDirection())
						.appendFileExtension("qvt");
				
				if(new File(transformationFileURIString).exists()){
				
					xmiResource = 
						(XMIResource)resource.getResourceSet().createResource(xmiSourceURI);
					
					xmiResource.getContents().addAll(EcoreUtil.copyAll(resource.getContents()));
			
					try {
						xmiResource.save(null);
					} catch (IOException e) {
						System.out.println(e);
					}
			
					starter = new MediniQVTStarter(
							
							xmiSourceURI, 
							xmiTargetURI,
							rootPathFile.toString(),
							transformationFileURIString, 
							rootPathFile.toString().concat(xmiSourceURI.toPlatformString(true)), 
							getTransformationName(), 
							getDomainNameInRightDirection(), 
							getUtilClassName(), 
							getImportantMappingOperationNameInRightDirection(),
							MediniQVTDirectionEnum.DSL2JAVA,
							getMetaModelInRightDirection());
					
					if(starter.isHandledInterestingRules()){
						
						Resource javaResource = 
							resource.getResourceSet().createResource(resourceURI);
					
						XMIResource xmiResourceTransformed = 
							(XMIResource)resource.getResourceSet().createResource(xmiTargetURI);
						
						try {
							xmiResourceTransformed.load(null);
						} catch (IOException e) {
							System.out.println(e);
						}
						
						javaResource.getContents().addAll(
								EcoreUtil.copyAll(
										xmiResourceTransformed.getContents()));
										
						// TODO neu
						
						URI javaTempResourceURI =
							resource.getURI().trimFileExtension().trimSegments(1).appendSegment(
									resource.getURI().trimFileExtension().segment(
											resource.getURI().segmentCount()-1)
											.concat("_transformed")).appendFileExtension("java");
						Resource javaResourceTemp = 
							resource.getResourceSet().createResource(javaTempResourceURI);
					
						javaResourceTemp.getContents().addAll(
								EcoreUtil.copyAll(xmiResourceTransformed.getContents()));
						try {
							javaResourceTemp.save(null);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						File javaResourceTempFile = new File(
							rootPathFile.toString().concat(javaTempResourceURI.toPlatformString(true)));
						File javaResourceFile = new File(
								rootPathFile.toString().concat(resourceURI.toPlatformString(true)));
							
						boolean hasContentChanged = false;
						
						try {
							ByteArrayInputStream PropjavaResourceTempFileBytes =
								 new ByteArrayInputStream(StreamUtil.getContent(javaResourceTempFile));
								
							hasContentChanged = 
								StreamUtil.storeContentIfChanged(
										javaResourceFile, PropjavaResourceTempFileBytes);
							if(hasContentChanged)
								System.out.println(resourceURI + " content was changed!");
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						try {
							javaResourceTemp.delete(null);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			
			//TODO
	//		try {
	//			xmiResource.delete(null);
	//		} catch (IOException e) {}
		}
	}
	
	private void init(ResourceSet resourceSet){
		
		// initialize resource set of models
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
		    Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		
		
	}
	
}

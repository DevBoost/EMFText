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

import java.io.File;
import java.io.IOException;
import java.util.List;
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
import org.emftext.language.java.java2dsl.qvto.QVTOStarter;
import org.emftext.language.java.java2dsl.util.MetaModelName;


public abstract class AbstractQVTOBuilderAdapter {

	private Stack<Thread> threads = new Stack<Thread>();
	private boolean locker = false;

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
		
	public boolean isBuildingNeeded(URI uri) {
		
		for(String segment : uri.segmentsList()){
			if(segment.toLowerCase().equals("bin"))
				return false;
		}

		// need to avoid a deadlock call
		if(!locker){
			locker = true;
			return true;
		}
		else{
			locker = false;
			return false;
		}
	}
	
	public IStatus build(final Resource resource, IProgressMonitor monitor) {
		
		Thread root = new Thread(new Runnable(){

			public void run() {
				callThreads(resource);
			}
			
		},"RootThread");
		root.start();
		
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
		
		// java 2 embedded DSL
		
		init(resource.getResourceSet());
		
		URI xmiSourceURI = 
			resource.getURI().appendFileExtension("xmi");
		
		URI targetURI =
			resource.getURI().trimFileExtension().appendFileExtension(getFileExtension());
		
		URI xmiTargetURI = 
			resource.getURI().trimFileExtension().appendFileExtension(
					getFileExtension()+".xmi");

		URI transformationFileURI = 
			resource.getURI().trimFileExtension()
				.trimSegments(resource.getURI().segmentCount()-2)
				.appendSegment(getDirectoryWithScripts())
				.appendSegment(getScriptInOneDirection())
				.appendFileExtension("qvto");
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IPath rootPath = root.getLocation();
		File file = rootPath.toFile();
		String transformationFileURIString = 
			file.toString().concat(transformationFileURI.toPlatformString(true));
		
		if(new File(transformationFileURIString).exists()){
		
			XMIResource xmiSource = 
				(XMIResource)resource.getResourceSet().createResource(xmiSourceURI);
			
			xmiSource.getContents().addAll(EcoreUtil.copyAll(resource.getContents()));

			try {
				xmiSource.save(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			QVTOStarter starter = new QVTOStarter(
					xmiSourceURI,
					xmiTargetURI,
					transformationFileURI,
					file.toString().concat(xmiSourceURI.toPlatformString(true)),
					true,
					getUtilClassName(),
					getImportantMappingOperationNameInLeftDirection(),
					getMetaModelInLeftDirection());
			
			if(starter.isHandledInterestingRules()){
			
				Resource javaResource = 
					resource.getResourceSet().createResource(targetURI);
			
				xmiSource = 
					(XMIResource)resource.getResourceSet().createResource(xmiSourceURI);
				
				try {
					xmiSource.load(null);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				javaResource.getContents().addAll(
						EcoreUtil.copyAll(xmiSource.getContents()));
								
				try {
					javaResource.save(null);
				} catch (IOException e) {
					e.printStackTrace();					
				}
			}
			else{
				
				// try other direction of transformation -> embedded DSL 2 java
				
				xmiSourceURI = 
					resource.getURI().appendFileExtension("xmi");
				
				targetURI =
					resource.getURI().trimFileExtension().appendFileExtension("java");
				
				xmiTargetURI = 
					resource.getURI().trimFileExtension().appendFileExtension(
							getFileExtension()+".xmi");
				
				transformationFileURI = 
					resource.getURI().trimFileExtension()
						.trimSegments(resource.getURI().segmentCount()-2)
						.appendSegment(getDirectoryWithScripts())
						.appendSegment(getScriptInOtherDirection())
						.appendFileExtension("qvto");
				
				file = rootPath.toFile();
				transformationFileURIString = 
					file.toString().concat(transformationFileURI.toPlatformString(true));
				
				if(new File(transformationFileURIString).exists()){
				
					xmiSource = (XMIResource)
						resource.getResourceSet().createResource(xmiSourceURI);
					
					xmiSource.getContents().addAll(EcoreUtil.copyAll(resource.getContents()));
			
					try {
						xmiSource.save(null);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					starter = new QVTOStarter(
							xmiSourceURI,
							xmiTargetURI,
							transformationFileURI,
							file.toString().concat(xmiSourceURI.toPlatformString(true)),
							true,
							getUtilClassName(),
							getImportantMappingOperationNameInRightDirection(),
							getMetaModelInRightDirection());
					
					if(starter.isHandledInterestingRules()){
					
						Resource javaResource = 
							resource.getResourceSet().createResource(targetURI);
					
						xmiSource = 
							(XMIResource)resource.getResourceSet().createResource(xmiSourceURI);
						
						try {
							xmiSource.load(null);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						javaResource.getContents().addAll(
								xmiSource.getContents());
										
						try {
							javaResource.save(null);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	private void init(ResourceSet resourceSet){
		
		// initialize resource set of models
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
		    Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		
		
	}
}

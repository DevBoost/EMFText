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
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emftext.language.java.java2dsl.util.AbstractStatisticUtil;

public abstract class AbstractStarter {

	private List<Thread> threads = new ArrayList<Thread>();
	private int timeout;
	private int maxActiveThreads;
	
	private static Class<?> statisticUtilClass;
	private AbstractStatisticUtil statisticUtil;
	
	private EPackage.Registry registry;
	private ResourceSet resourceSet;
	private Collection<EPackage> metaPackages;
	
	private boolean handledInterestingRules = false;
	
	public AbstractStarter(int timeout, int maxActiveThreads) {
		this.timeout = timeout;
		this.maxActiveThreads = maxActiveThreads;
	}
	
	public List<File> loadAllFilesInFolder(
			File startFolder,
			String fileExtension,
			List<File> files) throws Exception{

		
		// file
		if(startFolder.isFile()){
			if (startFolder.getName().endsWith(fileExtension)) {
				files.add(startFolder);
			}
		}
		// directory
		else{
			for (File member : startFolder.listFiles()) {
				if (member.isFile()) {
					if (member.getName().endsWith(fileExtension)) {
						files.add(member);
					}
				}
				if (member.isDirectory()) {
					if (!member.getName().startsWith(".")) {
						loadAllFilesInFolder(member,fileExtension,files);
					}
				}
			}
		}
		
		return files;
	}
	
	public void init(){
		
		// initialize resource set of models
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
		    Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		
		// add meta models to registry
		registry = EPackage.Registry.INSTANCE;
		
		metaPackages = new ArrayList<EPackage>();
		
		for(EPackage _package : collectMetaModels()){
			registry.put(_package.getNsURI(), _package);
			metaPackages.add(_package);
		}
	}
	
	public void initStatistic(String statisticUtilClassName){
		
		try {
			statisticUtilClass =
				Class.forName("org.emftext.language.java.java2dsl.util." + statisticUtilClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			if(statisticUtilClass != null)
				statisticUtil = (AbstractStatisticUtil)statisticUtilClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public void callMethod(List<String> methodNames, int value){
		
		Method method = null;
		
		for(String methodName : methodNames){
			
			try {
				method = statisticUtilClass.getMethod(methodName, int.class);
				method.invoke(statisticUtil,value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public abstract void launch(File file) throws Exception;
	
	public abstract Collection<EPackage> collectMetaModels();
	
	public abstract void addStatistics(Object object);
	
	public void run(List<File> files) {

		Iterator<File> fileIter = files.iterator();
		
		while (fileIter.hasNext()){
			
			
			
			assert threads.size() <= maxActiveThreads;
			if (threads.size() >= maxActiveThreads) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue;
			}
			final File file = fileIter.next();

			Runnable runnable = new Runnable() {
				public void run() {
					try {
						launch(file);
					} catch (Exception e) {
						e.printStackTrace();
					}
					threads.remove(Thread.currentThread());
				}
			};
			final Thread workerThread = new Thread(runnable, "Worker Thread");
			threads.add(workerThread);

			final Thread timeoutThread = new Thread(new Runnable() {

				@SuppressWarnings("deprecation")
				public void run() {
					try {
						workerThread.join(timeout);
						boolean wasStillAlive = workerThread.isAlive();
						if(wasStillAlive)
							System.out.println("interrupt: " + workerThread);
//						workerThread.interrupt();
						workerThread.stop();
						while (workerThread.isAlive()) {
							System.out.println(workerThread.toString() + "is still there!");
							Thread.sleep(100);
						}
						if (wasStillAlive) {
							System.out.println("Run was interrupted by timeout.");
						}
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					threads.remove(workerThread);
				}
			}, "Timeout Thread");
			
			workerThread.start();
			timeoutThread.start();
		}
		// wait for last thread to end
		while (threads.size() > 0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean isHandledInterestingRules() {
		return handledInterestingRules;
	}

	public void setHandledInterestingRules(boolean handledInterestingRules) {
		this.handledInterestingRules = handledInterestingRules;
	}

	public AbstractStatisticUtil getStatisticUtil() {
		return statisticUtil;
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}
	
	public EPackage.Registry getRegistry() {
		return registry;
	}

	public Collection<EPackage> getMetaPackages() {
		return metaPackages;
	}
	
}

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
package org.emftext.language.java.mdsm2011.qvto;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.java.closures.resource.closure.mopp.ClosureResourceFactory;
import org.emftext.language.java.mdsm2011.statistics.AbstractStatisticsCollector;
import org.emftext.language.java.resource.JavaSourceOrClassFileResourceFactoryImpl;

public abstract class AbstractTransformationWrapper {

	private static Class<?> statisticUtilClass;
	private AbstractStatisticsCollector statisticUtil;
	
	private EPackage.Registry registry;
	private ResourceSetImpl resourceSet;
	private Collection<EPackage> metaPackages;
	
	private boolean handledInterestingRules = false;
	
	public AbstractTransformationWrapper(AbstractStatisticsCollector statisticUtil) {
		this.statisticUtil = statisticUtil;
	}
	
	public void init() {
		// initialize resource set of models
		registerResourceFactories();
		
		// add meta models to registry
		registry = EPackage.Registry.INSTANCE;
		
		metaPackages = new ArrayList<EPackage>();
		
		for (EPackage ePackage : MetamodelUtil.collectMetaModels()) {
			registry.put(ePackage.getNsURI(), ePackage);
			metaPackages.add(ePackage);
		}
	}

	protected void registerResourceFactories() {
		Map<String, Object> extensionToFactoryMap = getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap();
		
		extensionToFactoryMap.put(
			    "closure", new ClosureResourceFactory());
		extensionToFactoryMap.put(
			    "java", new JavaSourceOrClassFileResourceFactoryImpl());
		extensionToFactoryMap.put(
				"xmi", new UnmodifiableXMIResourceFactoryImpl());
		extensionToFactoryMap.put(
				"qvto", new UnmodifiableXMIResourceFactoryImpl());
	}
	
	public void callMethod(List<String> methodNames, int value) {
		
		Method method = null;
		
		for (String methodName : methodNames) {
			try {
				method = statisticUtilClass.getMethod(methodName, int.class);
				method.invoke(statisticUtil,value);
			} catch (Exception e) {}
		}
	}
	
	public abstract void launch(File file) throws Exception;
	
	public abstract void addStatistics(Object object);
	
	public void run(List<File> files) throws Exception {
		for (File file : files) {
			launch(file);
		}
	}
	
	public boolean isHandledInterestingRules() {
		return handledInterestingRules;
	}

	public void setHandledInterestingRules(boolean handledInterestingRules) {
		this.handledInterestingRules = handledInterestingRules;
	}

	public AbstractStatisticsCollector getStatisticsCollector() {
		return statisticUtil;
	}

	public ResourceSetImpl getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}
	
	public EPackage.Registry getRegistry() {
		return registry;
	}

	public Collection<EPackage> getMetaPackages() {
		return metaPackages;
	}
	
}

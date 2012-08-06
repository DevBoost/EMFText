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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.util.WriterLog;
import org.emftext.language.java.closures.resource.closure.IClosureOptions;
import org.emftext.language.java.closures.resource.closure.mopp.ClosurePostProcessor;
import org.emftext.language.java.closures.resource.closure.mopp.UnicodeConverterProvider;
import org.emftext.language.java.mdsm2011.statistics.AbstractStatisticsCollector;
import org.emftext.language.java.resource.java.IJavaOptions;
import org.emftext.language.java.resource.java.mopp.JavaPlugin;
import org.emftext.language.java.resource.java.util.JavaResourceUtil;

@SuppressWarnings("restriction")
public class QVTOTransformationWrapper extends AbstractTransformationWrapper {
	
	private URI inputURI;
	private URI outputURI;
	private URI transformationFileURI;
	private boolean debug = false;
	private boolean isInPlace = false;
	
	public QVTOTransformationWrapper(
			URI inputURI, 
			URI outputURI, 
			URI transformationFileUri, 
			boolean isInPlace, 
			boolean debug,
			AbstractStatisticsCollector statisticUtil) {
		
		super(statisticUtil);
		
		this.inputURI = inputURI;
		this.outputURI = outputURI;
		this.transformationFileURI = transformationFileUri;
		this.isInPlace = isInPlace;
		this.debug = debug;
	}

	protected void registerResourceFactories() {
		super.registerResourceFactories();
		new QVTORegisteringUtil().registerQVTResourceFactory(getResourceSet());
	
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		//throw new RuntimeException("New EMFText Versions generate language-specific constants! Post-processor registration must be adjusted.");
		map.put(IClosureOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER, new UnicodeConverterProvider());
		map.put(IClosureOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new ClosurePostProcessor());
	
		// TODO mseifert: I have removed this to get reference resolving working for
		// the JUnit transformation, but I'm not sure about the implications.
		// Maybe we need to create a fresh resource set for each test?
		//map.put(JavaClasspath.OPTION_USE_LOCAL_CLASSPATH, Boolean.TRUE);
		getResourceSet().getLoadOptions().putAll(map);
	}

	private void setStartTime() {
		getStatisticsCollector().setStartTime(System.currentTimeMillis());
	}
	
	private void setEndTime() {
		getStatisticsCollector().setEndTime(System.currentTimeMillis());
	}
	
	private void writeStatistics() {
		getStatisticsCollector().writeStatistic();
	}
	
	/**
	 * Executes the QVT transformation using the given file as input model.
	 */
	@Override
	public void launch(File file) throws Exception {
		init();
		URI inFileURI = URI.createFileURI(file.getAbsoluteFile().getCanonicalPath());
		URI outFileURI = MetamodelUtil.getTargetFileURI(
					inputURI, file, outputURI, super.getResourceSet());
		
		// setup the execution environment details -> 
		// configuration properties, logger, monitor object etc.
		ExecutionContextImpl context = new ExecutionContextImpl();
//		context.setConfigProperty("keepModeling", true);
		
		// set logger
		if (debug) {
			PrintWriter printWriter = new PrintWriter(System.out);
			printWriter.flush();
			context.setLog(new WriterLog(printWriter));
		}
		
		// run the transformation assigned to the executor with the given 
		// input and output and execution context -> ChangeTheWorld(in, out)
		// Remark: variable arguments count is supported
		
		List<URI> models = new ArrayList<URI>();
		models.add(inFileURI);
		if (!isInPlace) {
			models.add(outFileURI);
		}
		
		ResourceSetImpl resourceSet = getResourceSet();
		EcoreUtil.resolveAll(resourceSet);
		Resource inputResource = resourceSet.getResource(inFileURI, true);
		Collection<EObject> unresolvedProxies = JavaResourceUtil.findUnresolvedProxies(inputResource);
		for (EObject unresolvedProxy : unresolvedProxies) {
			System.err.println("found unresolvedProxy in " + inFileURI.lastSegment() + ": " + unresolvedProxy);
		}
		// new Executor
		QVTOTransformationRunner executor = 
			new QVTOTransformationRunner(transformationFileURI, super.getRegistry(), models, debug, resourceSet);
		
		if (debug) {
			URI traceFileURI =  outFileURI;
			traceFileURI = outFileURI.trimFileExtension().appendFileExtension("qvtotrace");
			executor.setTraceFile(traceFileURI);
		}
		
		System.out.println("Transforming file: " + file);
		// do transformation
		Diagnostic result = executor.execute(context);
		if (debug) {
			//System.out.println("result = " + result);
			//System.out.println("outFileURI = " + outFileURI);
		}
		
		// check the result for success
		if (result.getSeverity() == Diagnostic.OK) {
	
			Trace trace = executor.getTrace();
			// get statistics from trace file
			addStatistics(trace);
			
		} else {
			// turn the result diagnostic into status and send it to error log			
			IStatus status = BasicDiagnostic.toIStatus(result);
			//Activator.getDefault().getLog().log(status);
			if (!status.isOK()) {
				System.err.println(status);
				throw new RuntimeException("Error while running transformation");
			}
		}
	}

	@Override
	public void addStatistics(Object object) {
		if (object == null) {
			return;
		}
		Trace trace = null;
		if (object instanceof Trace) {
			trace = (Trace) object;
		}
		new TraceExtractor().extractOperationCalls(trace, getStatisticsCollector());
	}
}

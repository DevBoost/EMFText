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
package org.emftext.language.java.java2dsl.qvto;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.util.WriterLog;
import org.emftext.language.java.JavaPackage;
import org.emftext.language.java.closures.ClosuresPackage;
import org.emftext.language.java.java2dsl.AbstractStarter;
import org.emftext.language.java.java2dsl.util.MetaModelName;
import org.emftext.language.java.java2dsl.util.MetamodelUtil;
import org.emftext.language.java.properties.PropertiesPackage;

public class QVTOStarter extends AbstractStarter{

	
	private static URI inputURI;
	private static URI outputURI;
	private static File inputFolder;
	private static URI transformationFileURI;
	private static boolean debug = false;
	private static boolean isInPlace = false;
	private static boolean onlyOneFile = false;
	private static String metamodelName = "";
	
	private static String statisticUtilClassName = "";
	
	private List<String> interestingRules;
	
	public QVTOStarter(int timeout, int maxActiveThreads){
		
		// maximale Laufzeit pro Umwandlung: 5 min
		super(timeout,maxActiveThreads);
		
		QVTOStarter.onlyOneFile = false;
		
		// initialize statistic class
		initStatistic();
		
		// start time
		setStartTime();
		
		init();
		
		List<File> files = new ArrayList<File>();
		try {
			files = loadAllFilesInFolder(inputFolder,"java.xmi",files);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		run(files);
		
		// write statistics
		writeStatistics();
		
		// get end time
		writeEndTime();
	}
	
	public QVTOStarter(URI inputURI, 
						URI outputURI, 
						URI transformationFileUri, 
						String inputFolderString,
						boolean isInPlace, 
						String statisticUtilClassName,
						List<String> interestingRules,
						MetaModelName metamodelName){
		
		super(5*60*1000,1);
		
		QVTOStarter.inputURI = inputURI;
		QVTOStarter.outputURI = outputURI;
		QVTOStarter.transformationFileURI = transformationFileUri;
		QVTOStarter.isInPlace = isInPlace;
		QVTOStarter.statisticUtilClassName = statisticUtilClassName;
		QVTOStarter.onlyOneFile = true;
		QVTOStarter.metamodelName = metamodelName.toString();
		
		this.interestingRules = interestingRules;
		
		// initialize statistic class
		initStatistic();
		
		// start time
		setStartTime();
		
		init();
		
		List<File> files = new ArrayList<File>();
		files.add(new File(inputFolderString));
		
		run(files);
		
		// write statistics
		writeStatistics();
		
		// get end time
		writeEndTime();

	}
	
	public static void main(String[] args) throws Exception{
		
		if (args.length < 3) {
			System.out.println(
					"Usage: " +
					"QVTOStarter " +
					"<source folder path> " +
					"<target folder path> " +
					"<qvto file path> " +
					"<debug=true>  " +
					"<timeout> " +
					"<maxActiveThreads> " +
					"<inPlace=true> " +
					"<statisticUtilClassName>"+
					"<metamodel name>");
			return;
		}
				
		// input folder
		inputFolder = new File(args[0]);
		if (!inputFolder.exists()) {
			System.out.println("not found: " + args[0]);
			return;
		}
		inputURI = URI.createFileURI(inputFolder.getCanonicalPath());
		
		// output folder
		File outputFolder = new File(args[1]);
		if (!outputFolder.exists()) {
			try {
				outputFolder.mkdirs();
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		}
		outputURI = URI.createFileURI(outputFolder.getCanonicalPath());

		// qvto file
		File qvtoFile = new File(args[2]);
		if (!qvtoFile.exists()) {
			System.out.println("not found: " + args[2]);
			return;
		}
		transformationFileURI = URI.createFileURI(qvtoFile.getCanonicalPath());
		
		// debug
		if(args.length > 3){
			if(args[3].equals("debug=true") || args[3].equals("debug=True"))
				debug = true;
		}

		// timeout
		int timeout = 5*60*1000; // 5 min
		if(args.length > 4){
			try {
				timeout = Integer.parseInt(args[4]);
			} catch (NumberFormatException e) {}
		}
		
		int maxActiveThreads = 3;
		
		// threads
		if(args.length > 5){
			try {
				maxActiveThreads = Integer.parseInt(args[5]);
			} catch (NumberFormatException e) {}
		}
		
		// inPlace
		if(args.length > 6){
			if(args[6].equals("inPlace=true") || args[3].equals("inPlace=True"))
				isInPlace = true;
		}
		
		// statistic Util ClassName
		if(args.length > 7){
			statisticUtilClassName = args[7];
		}
		else{
			System.out.println("statisticUtilClassName not found");
			return;
		}
		
		// statistic Util ClassName
		if(args.length > 8){
			metamodelName = args[8];
		}
		else{
			System.out.println("metamodel name not found");
			return;
		}
		
		// new constructor
		new QVTOStarter(timeout, maxActiveThreads);
		

	}
	
	private void initStatistic(){
		super.initStatistic(statisticUtilClassName);
	}
	
	private void setStartTime(){
		super.getStatisticUtil().setStartTime(Calendar.getInstance().getTimeInMillis());
	}
	
	private void writeStatistics(){
		super.getStatisticUtil().writeStatistic();
	}
	
	private void writeEndTime(){
		super.getStatisticUtil().writeEndTime(Calendar.getInstance().getTimeInMillis());
	}
	
	/**
	 * Collect necessary meta model packages.
	 * 
	 * @return
	 */
	public Collection<EPackage> collectMetaModels() {
		
		Collection<EPackage> metaPackages = new ArrayList<EPackage>();
		metaPackages.add(JavaPackage.eINSTANCE);
		
		if(metamodelName.equals(MetaModelName.CLOSURE.toString()))
			metaPackages.add(ClosuresPackage.eINSTANCE);
		if(metamodelName.equals(MetaModelName.PROPERTY.toString()))
			metaPackages.add(PropertiesPackage.eINSTANCE);
		
		return metaPackages;
		
	}
	
	@Override
	public void launch(File file) throws Exception {
		
		URI inFileURI = URI.createFileURI(file.getCanonicalPath());
		URI outFileURI = null;
		if(!onlyOneFile)
			outFileURI = MetamodelUtil.getTargetFileURI(
					inputURI, file, outputURI, super.getResourceSet());
		
		// setup the execution environment details -> 
		// configuration properties, logger, monitor object etc.
		ExecutionContextImpl context = new ExecutionContextImpl();
//		context.setConfigProperty("keepModeling", true);
		
		// set logger
		if(debug){
			PrintWriter printWriter = new PrintWriter(System.out);
//			printWriter.flush();
			context.setLog(new WriterLog(printWriter));
		}
		
		// run the transformation assigned to the executor with the given 
		// input and output and execution context -> ChangeTheWorld(in, out)
		// Remark: variable arguments count is supported
		
		List<URI> models = new ArrayList<URI>();
		models.add(inFileURI);
		if(!isInPlace)
			models.add(outFileURI);
		
		// new Executor
		MyTransformationExecutor executor = 
			new MyTransformationExecutor(transformationFileURI,super.getRegistry(),models,debug);
		
		if(debug){
			URI traceFileURI =  outFileURI;
			traceFileURI = outFileURI.trimFileExtension().appendFileExtension("qvtotrace");
			executor.setTraceFile(traceFileURI);
		}
		
		System.out.println(file);
		// do transformation
		Diagnostic result = executor.execute(context);
		if(debug){
			System.out.println(result);
			System.out.println(outFileURI);
		}
		
		// check the result for success
		if(result.getSeverity() == Diagnostic.OK) {
	
			Trace trace = executor.getTrace();
			// get statistics from trace file
			addStatistics(trace);
			
		} else {
			// turn the result diagnostic into status and send it to error log			
			IStatus status = BasicDiagnostic.toIStatus(result);
			//Activator.getDefault().getLog().log(status);
			System.out.println(status);
		}
	}

	@Override
	public void addStatistics(Object object) {
		
		Trace trace = null;
		if(object instanceof Trace){
			trace = (Trace)object;
		}
		
		if(trace != null){
			for (EList<TraceRecord> entryData : trace.getTraceRecordMap().values()){
				for(TraceRecord data : entryData){
					
					for(String key : super.getStatisticUtil().getRuleNames().keySet()){
						if(key.equals(data.getMappingOperation().getName())){
							callMethod(super.getStatisticUtil().getRuleNames().get(key),1);
						}
					}
					if(interestingRules != null){
						for(String ruleName : interestingRules){
							if(ruleName.equals(data.getMappingOperation().getName()))
								setHandledInterestingRules(true);
						}
					}
				}
			}
		}
	}
}

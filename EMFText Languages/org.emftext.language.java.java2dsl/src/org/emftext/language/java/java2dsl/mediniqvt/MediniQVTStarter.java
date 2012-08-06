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
package org.emftext.language.java.java2dsl.mediniqvt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.java.JavaPackage;
import org.emftext.language.java.closures.ClosuresPackage;
import org.emftext.language.java.java2dsl.AbstractStarter;
import org.emftext.language.java.java2dsl.util.MetaModelName;
import org.emftext.language.java.java2dsl.util.MetamodelUtil;
import org.emftext.language.java.properties.PropertiesPackage;

import uk.ac.kent.cs.kmf.util.ILog;
import uk.ac.kent.cs.kmf.util.OutputStreamLog;
import de.ikv.emf.qvt.EMFQvtProcessorImpl;
import de.ikv.medini.qvt.QVTProcessorConsts;
import de.ikv.medini.qvt.Trace;

public class MediniQVTStarter extends AbstractStarter{
	
	private ILog logger;
//	protected ResourceSet resourceSet;
	
	private static String transformation;
	private static String direction; 
	private static URI inputURI;
	private static File inputFolder;
	private static URI outputURI;
	private static String qvtRuleFilePath;
	private static boolean debug = false;
	private static boolean onlyOneFile = false;
	private static MediniQVTDirectionEnum directionEnum;
	private List<String> interestingRules;
	private static String statisticUtilClassName = "";
	private static String metamodelName = "";
	
	/**
	 * Initializes the QVT processor
	 * 
	 * @param outputStream
	 *            an {@link OutputStream} for logging
	 */
	public MediniQVTStarter(
			int timeout, 
			int maxActiveThreads) {
		
		// maximale Laufzeit pro Umwandlung: 5 min
		super(timeout,maxActiveThreads);
		
		MediniQVTStarter.onlyOneFile = false;
		
		// initialize statistic class
		initStatistic();
		
		// start time
		setStartTime();
		
		// init logger
		initLogger();

		// init meta models
		init();
		
		// load all files in directory recursively
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
	

	public MediniQVTStarter(
			URI inputURI, 
			URI outputURI, 
			String rootPathFileString,			
			String qvtRuleFilePath, 
			String filePathString,
			String transformationName, 
			String direction,
			String statisticUtilClassName,
			List<String> interestingRules,
			MediniQVTDirectionEnum directionEnum,
			MetaModelName metamodelName){
		
		super(5*60*1000,1);
		
		MediniQVTStarter.inputURI = inputURI;
		MediniQVTStarter.outputURI = outputURI;
		MediniQVTStarter.qvtRuleFilePath = qvtRuleFilePath;
		MediniQVTStarter.direction = direction;
		MediniQVTStarter.transformation = transformationName;
		MediniQVTStarter.statisticUtilClassName = statisticUtilClassName;
		MediniQVTStarter.onlyOneFile = true;
		MediniQVTStarter.directionEnum = directionEnum;
		MediniQVTStarter.metamodelName = metamodelName.toString();
		this.interestingRules = interestingRules;
		
		
		inputFolder = new File(rootPathFileString);
		if (!inputFolder.exists()) {
			System.out.println("not found: " + filePathString);
			return;
		}
		
		// initialize statistic class
		initStatistic();
		
		// start time
		setStartTime();
		
		// init logger
		initLogger();
		
		// init meta models
		init();
		
		// only one file as input
		List<File> files = new ArrayList<File>();
		files.add(new File(filePathString));
		
		run(files);
		
		// write statistics
		writeStatistics();
		
		// get end time
		writeEndTime();

	}
	
	private void initLogger(){
	
		// log file
		File logFile = null;
		String filePathString = "";
		FileOutputStream fileOutputStream = null;
		
		if(!onlyOneFile){
			if(inputFolder.isFile())
				filePathString = outputURI.trimFileExtension().trimSegments(1).appendSegment("output").appendFileExtension("log").toFileString();
			else
				filePathString = outputURI.appendSegment("output").appendFileExtension("log").toFileString();
		}
		else{
			filePathString = inputFolder.toString().concat(
					outputURI.trimFileExtension().trimSegments(1).appendSegment("output").appendFileExtension("log").toPlatformString(false));
		}
		
		logFile = new File(filePathString);
		
		try {
			fileOutputStream = new FileOutputStream(logFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
		try {
			fileOutputStream.flush();
		} catch (IOException e) {}
		
		this.logger = new OutputStreamLog(fileOutputStream);
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
	 * Transform a QVT script in a specific direction.
	 * 
	 * @param qvtRuleSet
	 *            the QVT transformation
	 * @param transformation
	 *            name of the transformation
	 * @param direction
	 *            name of the target - must conform to your QVT transformation definition
	 * @throws Throwable
	 */
	@SuppressWarnings("unchecked")
	private synchronized void transform(
			EMFQvtProcessorImpl processorImpl,
			String transformation, 
			String direction,
			ArrayList<ArrayList<Resource>> modelResources){
		
		FileReader qvtFileReader = null;
		
		try{
			qvtFileReader = new FileReader(qvtRuleFilePath); 
		} catch (FileNotFoundException e) {
			System.out.println("not found: " + qvtRuleFilePath);
			return;
		}
		
		if(debug)
			System.out.println("start transformation");
		
		processorImpl.setModels(modelResources);
		
		Collection<Trace> traces = null;
		try {
			traces = processorImpl.evaluateQVT(
						qvtFileReader, 
						transformation, 
						true, 
						direction, 
						new Object[0], 
						null, 
						this.logger);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		if(debug){
			System.out.println("end transformation");
			System.out.println("read trace file");
		}
		
		// set statistics
		addStatistics(traces);

	}

	

	/**
	 * Example usage of the class {@link MediniQVTStarter}.
	 * 
	 * @param args
	 *            
	 */
	public static void main(String[] args) throws IOException{
		
		if (args.length < 3) {
			System.out.println(
					"Usage: " +
					"MediniQVTStarter " +
					"<source folder path> " +
					"<target folder path> " +
					"<rule path> " +
					"<debug=true> " +
					"<timeout> " +
					"<maxActiveThreads> " +
					"<transformation name>" +
					"<direction>" +
					"<statistic util class name>"+
					"<metamodel name>");
			return;
		}
		
		if(args.length > 3){
			if(args[3].equals("debug=true") || args[3].equals("debug=True"))
				debug = true;
		}
		
		int timeout = 5*60*1000; // 5 min
		
		if(args.length > 4){
			try {
				timeout = Integer.parseInt(args[4]);
			} catch (NumberFormatException e) {}
		}
		
		int maxActiveThreads = 3;
		
		if(args.length > 5){
			try {
				maxActiveThreads = Integer.parseInt(args[5]);
			} catch (NumberFormatException e) {}
		}
		
		// transformation name
		if(args.length > 6){
			transformation = args[6];
		}
		else{
			System.out.println("transformation name not found");
			return;
		}
		
		// transformation direction
		if(args.length > 7){
			direction = args[7];
		}
		else{
			System.out.println("transformation direction not found");
			return;
		}
		
		// statistic Util ClassName
		if(args.length > 8){
			statisticUtilClassName = args[8];
		}
		else{
			System.out.println("statistic util class name not found");
			return;
		}
		
		// statistic Util ClassName
		if(args.length > 9){
			metamodelName = args[9];
		}
		else{
			System.out.println("metamodel name not found");
			return;
		}
		
		// source folder
		inputFolder = new File(args[0]);
		if (!inputFolder.exists()) {
			System.out.println("not found: " + args[0]);
			return;
		}
		inputURI = URI.createFileURI(inputFolder.getCanonicalPath());
		
		// out folder
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
		
		// qvt file, only test if file exists
		try{
			new FileReader(args[2]); 
		} catch (FileNotFoundException e) {
			System.out.println("not found: " + args[2]);
			return;
		}
		qvtRuleFilePath = args[2];
		
		
		// initialize the engine
		new MediniQVTStarter(timeout, maxActiveThreads);

	}
	
	@Override
	public synchronized void launch(File sourceFile) {

		
		// create resources
		Resource inputResource = null;
		if(onlyOneFile){
			inputResource = 
				super.getResourceSet().createResource(inputURI);
		}
		else{
			inputResource = MetamodelUtil.getResource(
				sourceFile.getAbsolutePath(),super.getResourceSet());
		}
		
		try {
			inputResource.load(null);
		} catch (IOException e1) {
			if(debug)
				e1.printStackTrace();
		}
		
		URI outFileURI = null;
		if(onlyOneFile){
			outFileURI = outputURI;
			outputURI = outputURI.trimSegments(1);
		}
		else{
			try {
				outFileURI = 
					MetamodelUtil.getTargetFileURI(
							inputURI, sourceFile, outputURI, super.getResourceSet());
			} catch (Exception e) {
				System.out.println(e);
				return;
			}
		}
		
		Resource outputResource = 
			super.getResourceSet().createResource(outFileURI);

		try {
			outputResource.load(null);
		} catch (IOException e1) {
			if(debug)
				e1.printStackTrace();
		}
		outputResource.getContents().clear();
		
		// Collect the models, which should participate in the transformation.
		// You can provide a list of models for each direction.
		// The models must be added in the same order as defined in your transformation!
		ArrayList<ArrayList<Resource>> modelResources = new ArrayList<ArrayList<Resource>>();
		ArrayList<Resource> firstSetOfModels = new ArrayList<Resource>();
		ArrayList<Resource> secondSetOfModels = new ArrayList<Resource>();
		
		modelResources.add(firstSetOfModels);
		modelResources.add(secondSetOfModels);
		
		if(directionEnum != null){
			if(directionEnum.equals(MediniQVTDirectionEnum.JAVA2DSL)){
				firstSetOfModels.add(inputResource);
				secondSetOfModels.add(outputResource);
			}
			else{
				firstSetOfModels.add(outputResource);
				secondSetOfModels.add(inputResource);
			}
		}
		else{
			firstSetOfModels.add(inputResource);
			secondSetOfModels.add(outputResource);
		}

		EMFQvtProcessorImpl processorImpl = new EMFQvtProcessorImpl(this.logger);
		
		Iterator<EPackage> iterator = super.getMetaPackages().iterator();
		while (iterator.hasNext()) {
			processorImpl.addMetaModel(iterator.next());
		}

		// set directory for trace file and some parameters
		processorImpl.setWorkingLocation(outputURI);
		processorImpl.setModels(modelResources);
		
		processorImpl.setProperty(QVTProcessorConsts.PROP_CLEAR_TRACES, "true");
		if(debug){
			processorImpl.setProperty(QVTProcessorConsts.PROP_DEBUG, "true");
			processorImpl.setProperty(QVTProcessorConsts.PROP_DEBUG_TASKS, "true");
		}
		
		System.out.println("input file: " + sourceFile);
		// tell the QVT engine, which transformation to execute - there might be more than one in
		// the QVT file!
		// give the direction of the transformation (according to the transformation definition)
		// just do it ;-)
		
		this.transform(processorImpl, transformation, direction, modelResources);
		
		System.out.println("output resource: " + outputResource.getURI());
		
		// Note: the engine does not save the model resources, which were participating in the
		// transformation.
		// You have to take care on this.
		try {
			outputResource.save(null);
		} catch (IOException e) {
			System.out.println(e);
		}
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
	
	@SuppressWarnings("unchecked")
	@Override
	public void addStatistics(Object object) {
		
		Collection<Trace> traces = null;
		if(object instanceof Collection){
			traces = (Collection<Trace>)object;
		}
		
		if(traces != null){
			for(Iterator<Trace> iter = traces.iterator();iter.hasNext(); ){
				Trace trace = iter.next();
				
				for(String key : super.getStatisticUtil().getRuleNames().keySet()){
					if(key.equals(trace.getRelation().getName())){
						callMethod(
								super.getStatisticUtil().getRuleNames().get(key),
								trace.getBindings().size());
					}
				}
				if(interestingRules != null){
					for(String ruleName : interestingRules){
						if(ruleName.equals(trace.getRelation().getName()))
							setHandledInterestingRules(true);
					}
				}
				
//				if(trace.getRelation().getName().equals(propertyRelation)){
//					PropertyStatisticUtil.addProperty(trace.getBindings().size());
//					PropertyStatisticUtil.addField(trace.getBindings().size());
//				}
//				if(trace.getRelation().getName().equals(propertyRelatioReadOnly)){
//					PropertyStatisticUtil.addPropertyReadOnly(trace.getBindings().size());
//					PropertyStatisticUtil.addField(trace.getBindings().size());
//				}
//				if(trace.getRelation().getName().equals(fieldRelation)){
//					PropertyStatisticUtil.addField(trace.getBindings().size());
//				}
//				if(trace.getRelation().getName().equals(classRelation)){
//					PropertyStatisticUtil.addClass(trace.getBindings().size());
//				}
//				if(trace.getRelation().getName().equals(enumerationRelation)){
//					PropertyStatisticUtil.addEnumeration(trace.getBindings().size());
//				}
//				if(trace.getRelation().getName().equals(annotationRelation)){
//					PropertyStatisticUtil.addAnnotation(trace.getBindings().size());
//				}
//				if(trace.getRelation().getName().equals(interfaceRelation)){
//					PropertyStatisticUtil.addInterface(trace.getBindings().size());
//				}
				
			}
		}
		
	}

	
}

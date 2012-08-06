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
package org.emftext.language.appflow.postprocessor.ocl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.appflow.commons.Nameable;
import org.emftext.language.appflow.resource.appflow.AppflowEProblemType;
import org.emftext.language.appflow.resource.appflow.IAppflowOptionProvider;
import org.emftext.language.appflow.resource.appflow.IAppflowOptions;
import org.emftext.language.appflow.resource.appflow.IAppflowResourcePostProcessor;
import org.emftext.language.appflow.resource.appflow.IAppflowResourcePostProcessorProvider;
import org.emftext.language.appflow.resource.appflow.mopp.AppflowResource;
import org.emftext.language.appflow.resource.appflow.mopp.AppflowResourcePostProcessor;
import org.emftext.language.appflow.statemodel.StateModel;
import org.osgi.framework.Bundle;

import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBoolean;
import tudresden.ocl20.pivot.facade.Ocl2ForEclipseFacade;
import tudresden.ocl20.pivot.interpreter.IInterpretationResult;
import tudresden.ocl20.pivot.model.IModel;
import tudresden.ocl20.pivot.model.ModelAccessException;
import tudresden.ocl20.pivot.modelinstance.IModelInstance;
import tudresden.ocl20.pivot.modelinstancetype.exception.TypeNotFoundInModelException;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceElement;
import tudresden.ocl20.pivot.parser.ParseException;
import tudresden.ocl20.pivot.pivotmodel.Constraint;
import tudresden.ocl20.pivot.pivotmodel.ConstraintKind;

public class AppFlowOclWfrPostProcessor implements IAppflowOptionProvider,
		IAppflowResourcePostProcessorProvider, IAppflowResourcePostProcessor {

	/** The id of the Bundle containing the metamodel. */
	protected final static String METAMODEL_BUNDLE = "org.emftext.language.egui";

	/** Location of the EGui Metamodel. */
	protected final static String METAMODEL_LOCATION = "metamodel/egui.text.ecore";

	/** The id of the Bundle containing the WFRs. */
	protected final static String WFR_FILE_BUNDLE = "org.emftext.language.egui.postprocessor.ocl";

	/** Location of the OCL WFRs. */
	protected final static String WFR_FILE_LOCATION = "constraints/wfrs.ocl";

	/** The {@link IModel} used for WFR checks. */
	protected static IModel eguiMetaModel;

	/** The OCL WFRs to be checked. */
	protected static Set<Constraint> wfrs;

	/** Error messages for violated constraints. */
	protected static Map<String, String> messages = new java.util.HashMap<String, String>();

	static {
		messages.put("extactOneInitialState",
				"States Models should have exactly one initial state.");
		messages.put("atLeastOneEndState",
				"State Models should have at least one finite state.");
		messages.put("nameIsDefined", "Nameables should have an explicit name.");
		messages.put("uniqueNameInStateModel", "Names of elements must be unique within a StateModel.");
		messages.put("uniqueNameInScreen", "Names of elements must be unique within a Screen.");
	}

	/**
	 * <p>
	 * Returns the file object for a given path relative to the plug-in's
	 * directory.
	 * </p>
	 * 
	 * @param bundleId
	 *            The ID of the {@link Bundle} containing the resource to be
	 *            found.
	 * @param path
	 *            The path of the resource.
	 * @return The found {@link File} object.
	 * @throws IOException
	 * @throws Exception
	 *             Thrown, if the opening fails.
	 */
	protected static File getFile(String bundleId, String path)
			throws IOException, FileNotFoundException {

		URL fileLocation;

		Bundle bundle = Platform.getBundle(bundleId);

		if (bundle == null)
			throw new FileNotFoundException("Bundle " + bundleId
					+ " cannot be found.");
		// no else.

		fileLocation = bundle.getResource(path);
		fileLocation = FileLocator.resolve(fileLocation);

		File file;
		file = new File(fileLocation.getFile());

		if (!file.exists())
			throw new FileNotFoundException("The file " + path
					+ " cannot be found within the bundle " + bundleId + ".");
		// no else.

		return file;
	}

	/**
	 * Static method used to initialize this post processor.
	 */
	protected static void init() {

		/* Load the model. */
		if (eguiMetaModel == null) {
			try {
				/* TODO Probably adapt this. */
				File modelFile = getFile(METAMODEL_BUNDLE, METAMODEL_LOCATION);
				eguiMetaModel = Ocl2ForEclipseFacade.getModel(modelFile,
						Ocl2ForEclipseFacade.ECORE_META_MODEL);
			}

			catch (ModelAccessException e) {
				log(e.getMessage(), IStatus.ERROR);
			}

			catch (MalformedURLException e) {
				log(e.getMessage(), IStatus.ERROR);
			}

			catch (IOException e) {
				log(e.getMessage(), IStatus.ERROR);
			}
		}
		// no else.

		/* Parse the WFRs. */
		if (wfrs == null || wfrs.size() == 0) {
			try {
				File wfrFile = getFile(WFR_FILE_BUNDLE, WFR_FILE_LOCATION);
				wfrs = new HashSet<Constraint>();
				wfrs.addAll(Ocl2ForEclipseFacade.parseConstraints(wfrFile,
						eguiMetaModel, true));
			}

			catch (IllegalArgumentException e) {
				log(e.getMessage(), IStatus.ERROR);
			}

			catch (ParseException e) {
				log(e.getMessage(), IStatus.ERROR);
			}

			catch (MalformedURLException e) {
				log(e.getMessage(), IStatus.ERROR);
			}

			catch (IOException e) {
				log(e.getMessage(), IStatus.ERROR);
			}
		}
		// no else.
	}

	/**
	 * Loggs an error.
	 * 
	 * @param msg
	 *            The message to be logged.
	 * @param severity
	 *            The severity. Use fields in {@link IStatus} to set severity.
	 * @return <code>true</code> if the message could be logged.
	 */
	protected static boolean log(String msg, int severity) {

		boolean result;

		Bundle bundle = Platform.getBundle(WFR_FILE_BUNDLE);

		if (bundle != null) {
			IStatus status = new Status(severity, WFR_FILE_BUNDLE, msg);
			Platform.getLog(bundle).log(status);
			result = true;
		}

		else
			result = false;

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.emftext.language.egui.resource.egui.IEguiResourcePostProcessor#process
	 * (org.emftext.language.egui.resource.egui.mopp.EguiResource)
	 */
	public void process(AppflowResource resource) {

		init();
		EObject root = resource.getContents().get(0);

		// TODO perform model modifications here
		if (eguiMetaModel != null && wfrs != null) {
			try {
				IModelInstance currentModelInstance = Ocl2ForEclipseFacade
						.getEmptyModelInstance(eguiMetaModel,
								Ocl2ForEclipseFacade.ECORE_MODEL_INSTANCE_TYPE);

				TreeIterator<EObject> contents = root.eAllContents();

				while (contents.hasNext()) {
					currentModelInstance.addModelInstanceElement(contents
							.next());
				}

				contents = root.eAllContents();
				while (contents.hasNext()) {

					EObject element = contents.next();

					if (element instanceof Nameable
							|| element instanceof StateModel) {
						IModelInstanceElement elementToBeChecked = currentModelInstance
								.addModelInstanceElement(element);

						List<IInterpretationResult> results = Ocl2ForEclipseFacade
								.interpretConstraints(wfrs,
										currentModelInstance,
										elementToBeChecked);

						for (IInterpretationResult result : results) {

							if (result.getConstraint().getKind() == ConstraintKind.INVARIANT
									&& !result.getResult().oclIsInvalid()
											.isTrue()
									&& !result.getResult().oclIsUndefined()
											.isTrue()
									&& !((OclBoolean) result.getResult())
											.isTrue()) {

								String msg = result.getConstraint().getName();

								if (msg == null || msg.length() == 0)
									msg = result.getConstraint().toString();

								if (messages.containsKey(msg))
									msg = messages.get(msg);
								else
									msg = "Violation of WFR " + msg + ".";

								resource.addError(msg, AppflowEProblemType.ANALYSIS_PROBLEM, element);
							}
							// no else.

							// this is just for testing
//							else {
//								String msg;
//
//								if (result.getConstraint().getKind() == ConstraintKind.DERIVED)
//									msg = ((NamedElement) result
//											.getConstraint()
//											.getConstrainedElement().get(0))
//											.getName();
//
//								else if (result.getConstraint().getKind() == ConstraintKind.DEFINITION)
//									msg = result.getConstraint()
//											.getDefinedFeature().getName();
//								else
//									msg = result.getConstraint().getName();
//
//								resource.addWarning(msg + " : "
//										+ result.getResult().toString(),
//										element);
//							}
						}
						// end for.
					}
					// no else.
				}
				// end while.
			}

			catch (IllegalArgumentException e) {
				log(e.getMessage(), IStatus.ERROR);
			}

			catch (ModelAccessException e) {
				log(e.getMessage(), IStatus.ERROR);
			}

			catch (TypeNotFoundInModelException e) {
				log(e.getMessage(), IStatus.ERROR);
			}
		}
		// no else.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.emftext.language.egui.resource.egui.IEguiResourcePostProcessorProvider
	 * #getResourcePostProcessor()
	 */
	public IAppflowResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.emftext.language.egui.resource.egui.IEguiOptionProvider#getOptions()
	 */
	public Map<?, ?> getOptions() {
		return Collections.singletonMap(
				IAppflowOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
	}

	public void terminate() {
		// 
	}
}

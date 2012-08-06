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
package org.emftext.tools.restricted;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ParserException;
import org.emftext.access.EMFTextAccessProxy;
import org.emftext.access.resource.IResource;

public class RestrictEDProvider {
	
	private final static OCLFileReader oclFileReader = new OCLFileReader();

	private List<RestrictedExpression> readOCLQueries(IFile resourceFile) {
		List<RestrictedExpression> constraints = oclFileReader.read(resourceFile);
		return constraints;
	}

	private void readAndEvaluateOCLQueries(Resource resource, EObject context) {
		final IResource textResource = (IResource) EMFTextAccessProxy.get(resource, IResource.class);
		String platformURI = resource.getURI().toPlatformString(true);
		if (platformURI == null) {
			return;
		}
		IFile file = (IFile) ResourcesPlugin.getWorkspace().getRoot().findMember(platformURI);
		
		List<RestrictedExpression> constraints = readOCLQueries(file);
		if (constraints == null) {
			return;
		}
		Evaluator evaluator = new Evaluator(new IEvaluationResultHandler() {
			
			public void handleResult(EObject context, Object result, final String message) {
				if (result == null) {
					return;
				}
				if (result instanceof EObject) {
					EObject errorObject = (EObject) result;

					if (textResource.getLocationMap().getLine(errorObject) >= 0) {
						addError(textResource, message, errorObject);
					}
				} else if (result instanceof Boolean) {
					if (((Boolean) result).booleanValue() == false) {
						EObject errorObject = context;
						if (textResource.getLocationMap().getLine(errorObject) >= 0) {
							addError(textResource, message, errorObject);
						}
					}
				} else {
					Collection<?> eResult = (Collection<?>) result;
					if (eResult.size() > 0) {

						Object[] failed = eResult.toArray();
						for (int j = 0; j < failed.length; j++) {

							EObject errorObject = (EObject) failed[j];

							if (textResource.getLocationMap().getLine(errorObject) >= 0) {
								addError(textResource, message, errorObject);
								break;
							} else {
								TreeIterator<EObject> ti = errorObject.eAllContents();

								while (ti.hasNext()) {
									EObject n = ti.next();
									if (textResource.getLocationMap().getLine(n) >= 0) {
										addError(textResource, message, n);
										break;
									}
								}
							}
						}
					}
				}
			}

			public void handleException(EObject context, ParserException e) {
				// TODO do something clever here
			}
		});
		evaluator.evaluateOCLQueries(context, constraints);
	}

	private void addError(IResource textResource, final String message,
			final EObject errorObject) {
		textResource.addError(message, errorObject);
	}

	public void checkRestrictions(Resource resource) {
		List<EObject> contents = resource.getContents();
		if (contents == null) {
			return;
		}
		if (contents.size() == 0) {
			return;
		}
		readAndEvaluateOCLQueries(resource, contents.get(0));
	}
}

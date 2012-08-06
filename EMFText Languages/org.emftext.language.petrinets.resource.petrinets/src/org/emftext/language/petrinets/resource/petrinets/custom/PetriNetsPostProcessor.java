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
package org.emftext.language.petrinets.resource.petrinets.custom;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.petrinets.BooleanExpression;
import org.emftext.language.petrinets.Cast;
import org.emftext.language.petrinets.Function;
import org.emftext.language.petrinets.FunctionCall;
import org.emftext.language.petrinets.FunctionType;
import org.emftext.language.petrinets.Setting;
import org.emftext.language.petrinets.SettingOperator;
import org.emftext.language.petrinets.UnaryMinus;
import org.emftext.language.petrinets.resource.petrinets.IPetrinetsOptionProvider;
import org.emftext.language.petrinets.resource.petrinets.IPetrinetsOptions;
import org.emftext.language.petrinets.resource.petrinets.IPetrinetsResourcePostProcessor;
import org.emftext.language.petrinets.resource.petrinets.IPetrinetsResourcePostProcessorProvider;
import org.emftext.language.petrinets.resource.petrinets.PetrinetsEProblemType;
import org.emftext.language.petrinets.resource.petrinets.analysis.FunctionCallAnalysisHelper;
import org.emftext.language.petrinets.resource.petrinets.mopp.PetrinetsResource;

public class PetriNetsPostProcessor implements IPetrinetsOptionProvider,
		IPetrinetsResourcePostProcessor,
		IPetrinetsResourcePostProcessorProvider {

	public IPetrinetsResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	

	public void terminate() {
		// TODO Auto-generated method stub

	}

	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IPetrinetsOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return map;
	}



	public void process(PetrinetsResource resource) {
		EcoreUtil.resolveAll(resource);
			
	}

}

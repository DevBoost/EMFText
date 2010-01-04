/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.concretesyntax.resource.cs.analysis; 

import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.emftext.sdk.MetamodelHelper;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver;

public class ImportConcreteSyntaxReferenceResolver implements ICsReferenceResolver<Import, ConcreteSyntax> {

	private Map<?, ?> options;
	private MetamodelHelper mmHelper = new MetamodelHelper();

	public void resolve(String identifier, Import container,
			EReference reference, int position, boolean resolveFuzzy, ICsReferenceResolveResult<ConcreteSyntax> result) {
		
		String locationHint = container.getCsLocationHint();
		ConcreteSyntax concreteSyntax = mmHelper.findConcreteSyntax(options, identifier, locationHint, container,  
				container.getPackage(), container.eResource());

		if (concreteSyntax == null) {
			result.setErrorMessage(createErrorMessage(identifier, locationHint));
			return;
		}
		result.addMapping(identifier, concreteSyntax);
	}

	public String deResolve(ConcreteSyntax element, Import container,
			EReference reference) {
		// A location hint is defined in the import if needed. 
		// Here we only return the name of the syntax.
		return element.getName();
	}
	
	private String createErrorMessage(String identifier, String locationHint) {
		return "Concrete syntax definition for prefix \"" + identifier + "\" could not be resolved." +
			(locationHint == null ? "" : " Maybe " + locationHint + " is wrong?");
	}

	public void setOptions(Map<?, ?> options) {
		this.options = options;
	}
}

/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.concretesyntax.resource.cs.analysis; 

import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;
import org.emftext.sdk.MetamodelHelper;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;

public class ImportConcreteSyntaxReferenceResolver extends AbstractReferenceResolver<Import, ConcreteSyntax> {

	private Map<?, ?> options;
	private MetamodelHelper mmHelper = new MetamodelHelper();

	public void resolve(String identifier, Import container,
			EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<ConcreteSyntax> result) {
		
		String locationHint = container.getCsLocationHint();
		ConcreteSyntax concreteSyntax = mmHelper.findConcreteSyntax(options, identifier, locationHint, container,  
				container.getPackage(), (ITextResource) container.eResource());

		if (concreteSyntax == null) {
			result.setErrorMessage(createErrorMessage(identifier, locationHint));
			return;
		}
		result.addMapping(identifier, concreteSyntax);
	}

	public String deResolve(ConcreteSyntax element, Import container,
			EReference reference) {
		// TODO jendrik: implement this method
		return null;
	}
	
	private String createErrorMessage(String identifier, String locationHint) {
		return "Concrete syntax definition for prefix \"" + identifier + "\" could not be resolved." +
			(locationHint == null ? "" : " Maybe " + locationHint + " is wrong?");
	}

	public void setOptions(Map<?, ?> options) {
		this.options = options;
	}
}

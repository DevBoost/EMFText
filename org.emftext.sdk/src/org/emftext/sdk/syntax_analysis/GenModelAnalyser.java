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
package org.emftext.sdk.syntax_analysis;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * An analyser that checks whether the EMF generator model referenced
 * by a syntax is valid. If not, an error is raised.
 */
public class GenModelAnalyser extends AbstractPostProcessor {

	public static final String INVALID_GENMODEL_MESSAGE = "The genmodel is invalid. Please reconcile it.";

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		GenPackage genPackage = syntax.getPackage();
		if (genPackage == null) {
			return;
		}
		GenModel genModel = genPackage.getGenModel();
		if (genModel == null) {
			return;
		}
		IStatus status = genModel.validate();
		if (status.getSeverity() == IStatus.ERROR) {
			resource.addError(INVALID_GENMODEL_MESSAGE, 0, 0, 0, 0);
		}
	}
}

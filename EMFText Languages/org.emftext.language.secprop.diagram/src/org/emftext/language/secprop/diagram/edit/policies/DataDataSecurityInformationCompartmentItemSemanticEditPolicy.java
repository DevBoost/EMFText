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
/*
 * 
 */
package org.emftext.language.secprop.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.emftext.language.secprop.diagram.edit.commands.AccessCreateCommand;
import org.emftext.language.secprop.diagram.edit.commands.EncryptionCreateCommand;
import org.emftext.language.secprop.diagram.providers.SecpropElementTypes;

/**
 * @generated
 */
public class DataDataSecurityInformationCompartmentItemSemanticEditPolicy
		extends SecpropBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public DataDataSecurityInformationCompartmentItemSemanticEditPolicy() {
		super(SecpropElementTypes.Data_2002);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (SecpropElementTypes.Access_3001 == req.getElementType()) {
			return getGEFWrapper(new AccessCreateCommand(req));
		}
		if (SecpropElementTypes.Encryption_3002 == req.getElementType()) {
			return getGEFWrapper(new EncryptionCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}

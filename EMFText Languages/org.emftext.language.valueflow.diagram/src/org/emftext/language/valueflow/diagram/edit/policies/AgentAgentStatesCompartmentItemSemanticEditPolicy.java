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
package org.emftext.language.valueflow.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.emftext.language.valueflow.diagram.edit.commands.GiveStateCreateCommand;
import org.emftext.language.valueflow.diagram.edit.commands.TakeStateCreateCommand;
import org.emftext.language.valueflow.diagram.providers.ValueflowElementTypes;

/**
 * @generated
 */
public class AgentAgentStatesCompartmentItemSemanticEditPolicy extends
		ValueflowBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public AgentAgentStatesCompartmentItemSemanticEditPolicy() {
		super(ValueflowElementTypes.Agent_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ValueflowElementTypes.GiveState_3001 == req.getElementType()) {
			return getGEFWrapper(new GiveStateCreateCommand(req));
		}
		if (ValueflowElementTypes.TakeState_3002 == req.getElementType()) {
			return getGEFWrapper(new TakeStateCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}

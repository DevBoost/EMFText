/*******************************************************************************
 * Copyright (c) 2006-2015
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Dresden, Amtsgericht Dresden, HRB 34001
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs;

import java.util.Collection;

public interface ICsProblem {
	public String getMessage();
	public org.emftext.sdk.concretesyntax.resource.cs.CsEProblemSeverity getSeverity();
	public org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType getType();
	public Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix> getQuickFixes();
}

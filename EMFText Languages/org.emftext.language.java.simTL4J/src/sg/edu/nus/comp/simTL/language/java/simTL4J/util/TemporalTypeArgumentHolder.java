/*******************************************************************************
 * Copyright (c) 2006-2011
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
package sg.edu.nus.comp.simTL.language.java.simTL4J.util;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.common.util.EList;

import sg.edu.nus.comp.simTL.language.java.simTL4J.generics.TypeArgument;


/**
 * This adapter is used to attach type arguments to a type when it is passed through
 * several getBoundType() calls recursively. A better solution might be
 * to pass type references along whenever possible.
 * <p>
 * This however will require major changes in the API.
 */
public class TemporalTypeArgumentHolder extends AdapterImpl {
	private EList<TypeArgument> typeArguments = new UniqueEList<TypeArgument>();

	public EList<TypeArgument> getTypeArguments() {
		return typeArguments;
	}
}

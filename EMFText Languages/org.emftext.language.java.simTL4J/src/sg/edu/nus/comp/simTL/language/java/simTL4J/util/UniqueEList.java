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


public class UniqueEList<E> extends org.eclipse.emf.common.util.UniqueEList<E> {

	private static final long serialVersionUID = 1L;

	/**
	 * Ignores duplicates and throws NO IllegalArgumentException Exception.
	 */
	@Override
	public void add(int index, E object) {
		int size = size();
		if (index > size)
			throw new BasicIndexOutOfBoundsException(index, size);

		if (isUnique() && contains(object)) {
			//throw new IllegalArgumentException("The 'no duplicates' constraint is violated");
			return;
		}

		addUnique(index, object);
	}

}

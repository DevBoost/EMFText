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
package test1;

import java.util.ArrayList;
import java.util.List;

public class FTest2 {

	public void m() {
		List<String> list = new ArrayList<String>();
		// this should NOT be converted to a for-each loop, because the
		// index start at 1
		for (int i = 1; i < list.size(); i++) {
			String next = list.get(i);
		}
	}
}

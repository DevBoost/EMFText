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
package org.emftext.language.simplemath.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.simplemath.Additive;
import org.emftext.language.simplemath.Expression;
import org.emftext.language.simplemath.IntegerLiteralExp;
import org.emftext.language.simplemath.resource.sm.mopp.SmLayoutInformation;
import org.emftext.language.simplemath.resource.sm.mopp.SmLayoutInformationAdapter;

public class LayoutAdapterTest extends AbstractSimpleMathTestCase {

	public void testStartOffsets() {
		InputStream bais = new ByteArrayInputStream("1+2".getBytes());
		try {
			Expression expression = loadResource(bais, "memory");
			assertTrue(expression instanceof Additive);
			// the first character that belongs to the additive
			// expression is the plus, which is why the start offset
			// is 1
			assertStartOffset(expression, 1);
			
			Additive additive = (Additive) expression;
			Expression left = additive.getLeft();
			assertTrue(left instanceof IntegerLiteralExp);
			assertStartOffset(left, 0);

			Expression right = additive.getRight();
			assertTrue(right instanceof IntegerLiteralExp);
			assertStartOffset(right, 2);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	private void assertStartOffset(Expression expression, int expectedOffset) {
		int actualOffset = getStartOffset(expression);
		assertEquals("Offsets must match.", expectedOffset, actualOffset);
	}

	private int getStartOffset(Expression expression) {
		SmLayoutInformationAdapter adapter = getLayoutInformationAdapter(expression);
		assertNotNull(adapter);
		List<SmLayoutInformation> informations = adapter.getLayoutInformations();
		assertNotNull(informations);
		assertTrue(informations.size() > 0);
		SmLayoutInformation first = informations.get(0);
		assertNotNull(first);
		return first.getStartOffset();
	}

	private SmLayoutInformationAdapter getLayoutInformationAdapter(
			Expression expression) {
		EList<Adapter> adapters = expression.eAdapters();
		for (Adapter adapter : adapters) {
			if (adapter instanceof SmLayoutInformationAdapter) {
				return (SmLayoutInformationAdapter) adapter;
			}
		}
		return null;
	}

	@Override
	public Map<?, ?> getLoadOptions() {
		return Collections.emptyMap();
	}
}

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
package org.antlr.runtime3_4_0.misc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IntToIntHashMapTest {
	
	private interface IntFunc {
		public int calc(int x);
	}
	
	@Test
	public void testRemoval() {
		IntToIntHashMap map = new IntToIntHashMap(4, 0.75);
		map.setValueForMissingEntries(-1);
		
		IntToIntHashMap.collisions = 0;
		map.put(1, 3);
		assertEquals(1, map.size());
		map.put(5, 7);
		assertEquals(2, map.size());
		map.put(9, 11);
		assertEquals(3, map.size());
		
		assertEquals(3, IntToIntHashMap.collisions);
		map.removeEntries(6);
		
		assertEquals(-1, map.get(1));
		assertEquals(-1, map.get(5));
		assertEquals(11, map.get(9));

		assertEquals(1, map.size());
	}
	
	@Test
	public void test() {
		// initialize test data
		runTest(1000000, new IntFunc() {
			public int calc(int index) {
				return index + 1;
			}
		}, new IntFunc() {
			public int calc(int index) {
				return index + 13;
			}
		});

		runTest(1000000, new IntFunc() {
			public int calc(int index) {
				return index * 7 + 1;
			}
		}, new IntFunc() {
			public int calc(int index) {
				return index + 11;
			}
		});

		runTest(1000000, new IntFunc() {
			public int calc(int index) {
				return index * 7 + 3;
			}
		}, new IntFunc() {
			public int calc(int index) {
				return index + 12;
			}
		});
	}

	private void runTest(int size, IntFunc keyFunction, IntFunc valueFunction) {
		IntToIntHashMap map = new IntToIntHashMap();

		int[] keys = new int[size];
		int[] values = new int[size];
		for (int i = 0; i < keys.length; i++) {
			keys[i] = keyFunction.calc(i);
			values[i] = valueFunction.calc(i);
		}
		
		// fill map
		for (int i = 0; i < keys.length; i++) {
			map.put(keys[i], values[i]);
		}
		// check size
		assertEquals(size, map.size());
		
		for (int i = 0; i < keys.length; i++) {
			//System.out.println("get(" + i + ")");
			int key = keys[i];
			int value = map.get(key);
			assertEquals(values[i], value);
		}
		
		// remove all keys
		map.removeEntries(Integer.MAX_VALUE);
		assertEquals(0, map.size());
	}

}

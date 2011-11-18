package org.antlr.runtime3_4_0.misc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IntToIntHashMapTest {
	
	private interface IntFunc {
		public int calc(int x);
	}

	@Test
	public void test() {
		// initialize test data
		runTest(1000000, new IntFunc() {
			public int calc(int index) {
				return index;
			}
		}, new IntFunc() {
			public int calc(int index) {
				return index + 13;
			}
		});

		runTest(1000000, new IntFunc() {
			public int calc(int index) {
				return index * 7;
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
		
		for (int i = 0; i < keys.length; i++) {
			//System.out.println("get(" + i + ")");
			int key = keys[i];
			int value = map.get(key);
			assertEquals(values[i], value);
		}
	}

}

package org.emftext.sdk.codegen.resource.generators.util;

public class BinaryIntegerSplitter {

	private final int value;
	private int operations = 1;

	public BinaryIntegerSplitter(int value) {
		this.value = value;
	}
	
	public String getComputationCode() {
		if (value == 0) {
			return "";
		}
		
		StringBuilder result = new StringBuilder();
		int left = value;
		while (left > 0) {
			boolean lowestBitIsSet = left % 2 == 1;
			if (lowestBitIsSet) {
				result.append("1");
			} else {
				result.append("0");
			}
			operations++;
			
			left = left / 2;
			if (left > 0) {
				result.append(",");
			}
		}
		return result.toString();
	}

	public int getOperations() {
		return operations;
	}
}

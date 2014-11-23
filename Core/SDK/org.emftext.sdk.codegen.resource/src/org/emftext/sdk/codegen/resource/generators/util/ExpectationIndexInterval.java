package org.emftext.sdk.codegen.resource.generators.util;

public class ExpectationIndexInterval {

	private final String metaclassAccessor;
	private final int start;
	private int end;

	public ExpectationIndexInterval(String metaclassAccessor, int start) {
		this.metaclassAccessor = metaclassAccessor;
		this.start = start;
	}

	public void close(int end) {
		this.end = end;
	}

	public String getMetaclassAccessor() {
		return metaclassAccessor;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}
}

package org.emftext.sdk.codegen.util;

public interface Component {
	public void enable();
	public boolean isEnabled();
	public String toString(int tabs);
}

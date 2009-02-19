package org.emftext.sdk.codegen.composites;

/**
 * A component is a piece of text that can be used to 
 * compose text documents. A component can be atomic
 * (a string) or composed of other components. Components
 * can be enabled and converted to strings.
 */
public interface Component {
	public boolean isEnabled();
	public String toString(int tabs);
}

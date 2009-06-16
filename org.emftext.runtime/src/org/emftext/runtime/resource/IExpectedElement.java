/**
 * 
 */
package org.emftext.runtime.resource;

/**
 * An element that is expected at a given position in a resource
 * stream.
 */
public interface IExpectedElement {

	// TODO mseifert: figure out whether we really have to expose this interface
	// it does not contain any methods because the implementing classes
	// share no common functionality. They basically share the property
	// to be potentially expected.

	// TODO mseifert: remove this
	public void setPosition(
			int startIncludingHiddenTokens, 
			int startExcludingHiddenTokens, 
			int endIncludingHiddenTokens,
			int endExcludingHiddenTokens
	);

	public boolean isAt(int cursorIndex);

	public boolean isUnknown(int cursorIndex);
}
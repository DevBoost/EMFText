package org.emftext.sdk.concretesyntax.resource.cs;

// An element that is expected at a given position in a resource
// stream.
public interface ICsExpectedElement {
	
	public void setPosition(int startIncludingHiddenTokens, int startExcludingHiddenTokens);
	public int getStartExcludingHiddenTokens();
	public int getStartIncludingHiddenTokens();
	public String getPrefix();
	public void setPrefix(String prefix);
	public String getScopeID();
	public boolean discardFollowingExpectations();
}

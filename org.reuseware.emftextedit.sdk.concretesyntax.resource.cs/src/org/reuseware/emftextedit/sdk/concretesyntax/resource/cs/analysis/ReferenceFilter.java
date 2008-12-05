package org.reuseware.emftextedit.sdk.concretesyntax.resource.cs.analysis;

public interface ReferenceFilter<T> {
	public String accept(T target);
}

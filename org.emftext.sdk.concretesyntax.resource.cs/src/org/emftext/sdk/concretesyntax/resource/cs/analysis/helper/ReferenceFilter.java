package org.emftext.sdk.concretesyntax.resource.cs.analysis.helper;

public interface ReferenceFilter<T> {
	public String accept(T target);
}

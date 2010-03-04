package org.emftext.sdk.util;

/**
 * An interface for classes that can convert object of 
 * 'SourceType' to a string.
 *
 * @param <SourceType> the type of the object to convert
 */
public interface ToStringConverter<SourceType> {

	public String toString(SourceType sourceObject);
}

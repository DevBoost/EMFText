package org.emftext.runtime.resource;

import java.util.Map;

/**
 * Implementors of this interface can be configured by a
 * map of options (or parameters).
 */
public interface IConfigurable {
	public void setOptions(Map<?,?> options);
}

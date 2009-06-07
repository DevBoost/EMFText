package org.emftext.runtime.resource;

/**
 * This interface is extended by all other EMFText runtime
 * API interfaces for generated components. It provides
 * access to the plug-in meta information.
 */
public interface ITextResourcePluginPart {

	public ITextResourcePluginMetaInformation getMetaInformation();
}

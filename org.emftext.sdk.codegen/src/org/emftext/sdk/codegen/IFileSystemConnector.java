package org.emftext.sdk.codegen;

import java.io.File;

import org.emftext.sdk.IPluginDescriptor;

/**
 * The IFileSystemConnector interface is needed to use code
 * generators both within Eclipse where Plug-ins are located
 * in the workspace and within ANT tasks where Plug-ins are
 * located in the file system.
 */
public interface IFileSystemConnector {

	/**
	 * Returns the folder in the file system where the given plug-in
	 * can be found.
	 * 
	 * @param plugin the plug-in to locate
	 * @return a folder in the file system
	 */
	public File getProjectFolder(IPluginDescriptor plugin);
}

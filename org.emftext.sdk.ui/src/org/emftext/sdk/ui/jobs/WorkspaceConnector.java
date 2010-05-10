package org.emftext.sdk.ui.jobs;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.IFileSystemConnector;

/**
 * An implementation of IFileSystemConnector that uses the Eclipse
 * workspace to determine the location of plug-ins.
 */
public class WorkspaceConnector implements IFileSystemConnector {

	public File getProjectFolder(IPluginDescriptor plugin) {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(plugin.getName());
		return project.getLocation().toFile().getAbsoluteFile();
	}
}

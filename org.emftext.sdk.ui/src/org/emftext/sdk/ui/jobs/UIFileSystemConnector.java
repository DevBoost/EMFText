package org.emftext.sdk.ui.jobs;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.IFileSystemConnector;

public class UIFileSystemConnector implements IFileSystemConnector {

	public File getProjectFolder(IPluginDescriptor plugin) {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(plugin.getName());
		return project.getLocation().toFile().getAbsoluteFile();
	}
}

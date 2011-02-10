/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.parameters;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IContext;

/**
 * A parameter class that can be used to specify the content of manifest
 * files.
 */
public class ManifestParameters<ContextType extends IContext<ContextType>> extends AbstractArtifactParameter<ContextType, ManifestParameters<ContextType>> {

	public ManifestParameters(ArtifactDescriptor<ContextType, ManifestParameters<ContextType>> artifact) {
		super(artifact);
	}

	private String bundleName;
	private String activatorClass;
	private IPluginDescriptor plugin;
	private Collection<String> requiredBundles = new LinkedHashSet<String>();
	private Collection<String> exportedPackages = new LinkedHashSet<String>();

	public void setBundleName(String bundleName) {
		this.bundleName = bundleName;
	}

	public void setActivatorClass(String activatorClass) {
		this.activatorClass = activatorClass;
	}

	public void setPlugin(IPluginDescriptor plugin) {
		this.plugin = plugin;
	}

	public String getBundleName() {
		return bundleName;
	}

	public String getActivatorClass() {
		return activatorClass;
	}

	public IPluginDescriptor getPlugin() {
		return plugin;
	}

	public Collection<String> getRequiredBundles() {
		return requiredBundles;
	}

	public Collection<String> getExportedPackages() {
		return exportedPackages;
	}
}

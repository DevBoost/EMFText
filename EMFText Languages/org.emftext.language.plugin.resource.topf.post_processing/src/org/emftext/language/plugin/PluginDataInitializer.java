/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.plugin;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.ModelEntry;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.emftext.language.plugin.resource.topf.ITopfProblem;
import org.emftext.language.plugin.resource.topf.ITopfQuickFix;
import org.emftext.language.plugin.resource.topf.ITopfResourcePostProcessor;
import org.emftext.language.plugin.resource.topf.ITopfResourcePostProcessorProvider;
import org.emftext.language.plugin.resource.topf.TopfEProblemSeverity;
import org.emftext.language.plugin.resource.topf.TopfEProblemType;
import org.emftext.language.plugin.resource.topf.mopp.TopfResource;

public class PluginDataInitializer implements ITopfResourcePostProcessorProvider,
		ITopfResourcePostProcessor {

	private Map<String, ExtensionPoint> ids2eps = new HashMap<String, ExtensionPoint>();
	private TopfResource resource;;

	public void process(TopfResource resource) {
		this.resource = (TopfResource) resource;
		EList<EObject> contents = resource.getContents();
		for (EObject root : contents) {
			if (root instanceof ToolProductFamily) {
				initialise((ToolProductFamily) root);
			}
		}
	}

	private void initialise(ToolProductFamily family) {
		family.setRequiredPlugins(PluginFactory.eINSTANCE.createRequiredPlugins());
		for (Plugin plugin : family.getPlugins()) {
			initialise(family, plugin);
		}
	}

	private void initialise(ToolProductFamily family, Plugin plugin) {
		initialisePluginInformation(plugin, family);
		initialiseExtensionPoints(plugin, family);
		initialiseExtensions(plugin, family);
	}

	private void initialiseExtensions(Plugin plugin, ToolProductFamily family) {
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IExtension[] extensions = extensionRegistry.getExtensions(plugin
				.getPluginId());
		for (IExtension extension : extensions) {
			if (!containsExtension(plugin.getExtensions(), extension
					.getUniqueIdentifier())) {
				Extension es = PluginFactory.eINSTANCE.createExtension();
				es.setExtensionId(extension.getUniqueIdentifier());
				es.setName(extension.getLabel());
				plugin.getExtensions().add(es);


				String extensionPointUniqueIdentifier = extension.getExtensionPointUniqueIdentifier();
				IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(extensionPointUniqueIdentifier);
				IContributor contributor = extensionPoint.getContributor();
				if (getPlugin(contributor.getName(), family) == null) {
					String contributorName = contributor.getName();
					Plugin imported = PluginFactory.eINSTANCE.createPlugin();
					imported.setPluginId(contributorName);
					family.getRequiredPlugins().getRequired().add(imported);
					initialise(family, imported);
					initialiseExtensionPoints(imported, family);
					initialiseExtensions(imported, family);
				}
				es.setBinds(lookupExtensionPoint(extensionPointUniqueIdentifier));
			}
		}
	}


	private ExtensionPoint lookupExtensionPoint(
			String extensionPointUniqueIdentifier) {
		return ids2eps.get(extensionPointUniqueIdentifier);
	}

	private void initialiseExtensionPoints(Plugin plugin,
			ToolProductFamily family) {
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IExtensionPoint[] extensionPoints = extensionRegistry
				.getExtensionPoints(plugin.getPluginId());
		for (IExtensionPoint extensionPoint : extensionPoints) {
			if (!containsExtensionPoint(plugin.getExtensionPoints(),
					extensionPoint.getUniqueIdentifier())) {
				final ExtensionPoint ep = PluginFactory.eINSTANCE.createExtensionPoint();
				ep.setName(extensionPoint.getLabel());
				ep.setExtensionPointId(extensionPoint.getUniqueIdentifier());
				ep.setSchema(extensionPoint.getSchemaReference());
				plugin.getExtensionPoints().add(ep);

				ids2eps.put(ep.getExtensionPointId(), ep);

				if (family.getPlugins().contains(plugin)) {
					IExtension[] pointsExtensions = extensionPoint.getExtensions();
					for (IExtension extension : pointsExtensions) {
						IContributor contributor = extension.getContributor();
						if (getPlugin(contributor.getName(), family) == null) {
							final String contributorName = contributor.getName();
							resource.addProblem(new ITopfProblem() {

								public TopfEProblemType getType() {
									return TopfEProblemType.ANALYSIS_PROBLEM;
								}

								public String getMessage() {
									return "The plug-in " + contributorName + " extends the families extension point " + ep.getExtensionPointId() + " and " +
										"should be considered as plug-in of the tool product family.";
								}

								public Collection<ITopfQuickFix> getQuickFixes() {
									return null;
								}

								public TopfEProblemSeverity getSeverity() {
									return TopfEProblemSeverity.WARNING;
								}
							}, plugin);
						}

					}
				}
			}
		}
	}

	private void initialisePluginInformation(Plugin plugin, ToolProductFamily family) {

		ModelEntry entry = PluginRegistry.findEntry(plugin.getPluginId()) ;
		if (entry == null) {
			resource.addProblem(new ITopfProblem() {

				public TopfEProblemType getType() {
					return TopfEProblemType.ANALYSIS_PROBLEM;
				}

				public String getMessage() {
					return "Plug-In was not found";
				}

				public Collection<ITopfQuickFix> getQuickFixes() {
					return null;
				}

				public TopfEProblemSeverity getSeverity() {
					return TopfEProblemSeverity.ERROR;
				}
			}, plugin);
		}
		IPluginModelBase model = entry.getModel();
		plugin.setName(model.getBundleDescription().getName());
		plugin.setVersion(model.getBundleDescription().getVersion().toString());


	}

	public ITopfResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	private boolean containsExtension(EList<Extension> extensions,
			String uniqueIdentifier) {
		for (Extension extension : extensions) {
			if ( extension.getExtensionId() != null && extension.getExtensionId().equals(uniqueIdentifier))
				return true;
		}
		return false;
	}

	private boolean containsExtensionPoint(
			EList<ExtensionPoint> extensionPoints, String uniqueIdentifier) {
		for (ExtensionPoint ep : extensionPoints) {
			if ( ep.getExtensionPointId() != null && ep.getExtensionPointId().equals(uniqueIdentifier))
				return true;
		}
		return false;
	}


	private Plugin getPlugin(String name, ToolProductFamily family) {
		for (Plugin p : family.getPlugins()) {
			if (p.getPluginId() != null && p.getPluginId().equals(name)) return p;
		}
		for (Plugin p : family.getRequiredPlugins().getRequired()) {
			if (p.getPluginId() != null && p.getPluginId().equals(name)) return p;
		}

		return null;
	}

	public void terminate() {
		// do nothing
	}
}

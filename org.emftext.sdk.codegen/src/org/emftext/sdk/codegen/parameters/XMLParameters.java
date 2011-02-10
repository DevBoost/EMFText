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

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IContext;
import org.emftext.sdk.codegen.parameters.xml.XMLElement;

public class XMLParameters<ContextType extends IContext<ContextType>> extends AbstractArtifactParameter<ContextType, XMLParameters<ContextType>> {

	private XMLElement xmlContent;
	private IPluginDescriptor plugin;

	public XMLParameters(ArtifactDescriptor<ContextType, XMLParameters<ContextType>> artifact, IPluginDescriptor plugin, XMLElement content) {
		super(artifact);
		this.plugin = plugin;
		this.xmlContent = content;
	}

	public XMLElement getXmlContent() {
		return xmlContent;
	}

	public IPluginDescriptor getPlugin() {
		return plugin;
	}
}

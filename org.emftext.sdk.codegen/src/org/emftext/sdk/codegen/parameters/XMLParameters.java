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

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
/*
 * 
 */
package org.emftext.language.secprop.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.emftext.language.secprop.diagram.providers.SecpropElementTypes;

/**
 * @generated
 */
public class SecpropPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createObjects1Group());
		paletteRoot.add(createConnections2Group());
	}

	/**
	 * Creates "Objects" palette tool group
	 * @generated
	 */
	private PaletteContainer createObjects1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Objects1Group_title);
		paletteContainer.setId("createObjects1Group"); //$NON-NLS-1$
		paletteContainer.add(createAccess1CreationTool());
		paletteContainer.add(createData2CreationTool());
		paletteContainer.add(createElement3CreationTool());
		paletteContainer.add(createEncryption4CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Connections" palette tool group
	 * @generated
	 */
	private PaletteContainer createConnections2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Connections2Group_title);
		paletteContainer.setId("createConnections2Group"); //$NON-NLS-1$
		paletteContainer.add(createChannel1CreationTool());
		paletteContainer.add(createChannelAssignment2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAccess1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(SecpropElementTypes.Access_3001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Access1CreationTool_title,
				Messages.Access1CreationTool_desc, types);
		entry.setId("createAccess1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(SecpropElementTypes
				.getImageDescriptor(SecpropElementTypes.Access_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createData2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(SecpropElementTypes.Data_2002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Data2CreationTool_title,
				Messages.Data2CreationTool_desc, types);
		entry.setId("createData2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(SecpropElementTypes
				.getImageDescriptor(SecpropElementTypes.Data_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createElement3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(SecpropElementTypes.Element_2001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Element3CreationTool_title,
				Messages.Element3CreationTool_desc, types);
		entry.setId("createElement3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(SecpropElementTypes
				.getImageDescriptor(SecpropElementTypes.Element_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEncryption4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(SecpropElementTypes.Encryption_3002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Encryption4CreationTool_title,
				Messages.Encryption4CreationTool_desc, types);
		entry.setId("createEncryption4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(SecpropElementTypes
				.getImageDescriptor(SecpropElementTypes.Encryption_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createChannel1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(SecpropElementTypes.Channel_4001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Channel1CreationTool_title,
				Messages.Channel1CreationTool_desc, types);
		entry.setId("createChannel1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(SecpropElementTypes
				.getImageDescriptor(SecpropElementTypes.Channel_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createChannelAssignment2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(SecpropElementTypes.DataChannel_4002);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.ChannelAssignment2CreationTool_title,
				Messages.ChannelAssignment2CreationTool_desc, types);
		entry.setId("createChannelAssignment2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(SecpropElementTypes
				.getImageDescriptor(SecpropElementTypes.DataChannel_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}

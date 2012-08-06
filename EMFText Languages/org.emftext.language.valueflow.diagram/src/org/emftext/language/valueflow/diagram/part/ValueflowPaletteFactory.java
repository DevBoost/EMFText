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
package org.emftext.language.valueflow.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.emftext.language.valueflow.diagram.providers.ValueflowElementTypes;

/**
 * @generated
 */
public class ValueflowPaletteFactory {

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
		paletteContainer.add(createAgent1CreationTool());
		paletteContainer.add(createGiveState2CreationTool());
		paletteContainer.add(createModel3CreationTool());
		paletteContainer.add(createTakeState4CreationTool());
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
		paletteContainer.add(createGiveTo1CreationTool());
		paletteContainer.add(createNextState2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAgent1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ValueflowElementTypes.Agent_2001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Agent1CreationTool_title,
				Messages.Agent1CreationTool_desc, types);
		entry.setId("createAgent1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ValueflowElementTypes
				.getImageDescriptor(ValueflowElementTypes.Agent_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGiveState2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ValueflowElementTypes.GiveState_3001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.GiveState2CreationTool_title,
				Messages.GiveState2CreationTool_desc, types);
		entry.setId("createGiveState2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ValueflowElementTypes
				.getImageDescriptor(ValueflowElementTypes.GiveState_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createModel3CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.Model3CreationTool_title,
				Messages.Model3CreationTool_desc, null, null) {
		};
		entry.setId("createModel3CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTakeState4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ValueflowElementTypes.TakeState_3002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.TakeState4CreationTool_title,
				Messages.TakeState4CreationTool_desc, types);
		entry.setId("createTakeState4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ValueflowElementTypes
				.getImageDescriptor(ValueflowElementTypes.TakeState_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGiveTo1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ValueflowElementTypes.GiveStateGiveTo_4002);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.GiveTo1CreationTool_title,
				Messages.GiveTo1CreationTool_desc, types);
		entry.setId("createGiveTo1CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(ValueflowElementTypes
						.getImageDescriptor(ValueflowElementTypes.GiveStateGiveTo_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNextState2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ValueflowElementTypes.StateNextState_4001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.NextState2CreationTool_title,
				Messages.NextState2CreationTool_desc, types);
		entry.setId("createNextState2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ValueflowElementTypes
				.getImageDescriptor(ValueflowElementTypes.StateNextState_4001));
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

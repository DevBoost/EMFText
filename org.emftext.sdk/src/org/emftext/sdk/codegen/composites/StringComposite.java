/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.composites;

import java.util.ArrayList;
import java.util.List;

/**
 * A StringComposite can be used to compose text fragments. In contrast to
 * a StringBuilder or StringBuffer, this class can enable and disable text
 * fragments. This is useful when text is composed, but later unnecessary 
 * parts need to be removed.
 * 
 * This class is used by the code generators to insert variable declarations
 * only if they are referenced.
 */
public class StringComposite {
	
	/**
	 * A Node is the atomic part of a tree.
	 */
	public interface Node {
		public Tree getParent();
	}
	
	/**
	 * A CompositeNode is part of a tree and contains exactly
	 * one StringComponent.
	 */
	public class ComponentNode implements Node {

		private StringComponent component;
		private Tree parent;

		public ComponentNode(Tree parent, StringComponent component) {
			this.parent = parent;
			this.component = component;
		}

		public StringComponent getComponent() {
			return component;
		}
		
		public Tree getParent() {
			return parent;
		}
	}
	
	/**
	 * A Tree is a container for Nodes. Since trees are
	 * nodes as well, they can contain further trees. 
	 */
	public class Tree implements Node {
		
		private List<Node> children = new ArrayList<Node>();
		private Tree parent;

		public Tree(Tree parent) {
			this.parent = parent;
			if (parent != null) {
				parent.addChildNode(this);
			}
		}

		public List<Node> getChildNodes() {
			return children;
		}

		public void addChildNode(Node node) {
			children.add(node);
		}

		public Tree getParent() {
			return parent;
		}
	}

	// we do intentionally not use the platform specific line separation
	// character, because the files that are generated using this StringComposite
	// shall look the same on all platforms. Eclipse does understand the different
	// kinds of line separators anyway and treats them correctly on all platforms.
	public static final String LINE_BREAK = "\n";
	
	private List<StringComponent> components = new ArrayList<StringComponent>();

	private List<String> lineBreakers = new ArrayList<String>();
	private List<String> indentationStarters = new ArrayList<String>();
	private List<String> indentationStoppers = new ArrayList<String>();

	private boolean enabled;

	public StringComposite() {
		this(true);
	}

	public StringComposite(boolean enabled) {
		super();
		this.enabled = enabled;
	}
	
	public void addIndentationStarter(String starter) {
		indentationStarters.add(starter);
	}

	public void addIndentationStopper(String stopper) {
		indentationStoppers.add(stopper);
	}

	public void addLineBreaker(String lineBreaker) {
		lineBreakers.add(lineBreaker);
	}

	public StringComposite addLineBreak() {
		add(LINE_BREAK);
		return this;
	}
	
	public StringComposite add(String text) {
		StringComponent component = new StringComponent(text, null);
		add(component);
		return this;
	}

	public StringComposite add(StringComponent component) {
		components.add(component);
		return this;
	}
	
	public void add(StringComposite other) {
		components.addAll(other.components);
	}
	
	@Override
	public String toString() {
		return toString(0, true);
	}
	
	public String toString(int tabs, boolean doLineBreaks) {
		StringBuilder builder = null;
		
		enableComponents();
		
		// then add enabled components to the builder
		for (Component component : components) {
			if (isIndendationStopper(component)) {
				tabs--;
			}
			if (component.isEnabled()) {
				String text = component.toString(tabs);
				if (builder == null) {
					builder = new StringBuilder();
				}
				builder.append(text);
				if (doLineBreaks && isLineBreaker(component)) {
					builder.append(LINE_BREAK);
				}
			}
			if (isIndendationStarter(component)) {
				tabs++;
			}
		}
		if (builder == null) {
			return "";
		}
		return builder.toString();
	}

	private void enableComponents() {
		List<ComponentNode> disabledComponents = new ArrayList<ComponentNode>();

		// find the scoping depth for the disabled components
		Tree subTree = new Tree(null);
		for (int i = 0; i < components.size(); i++) {
			StringComponent component = components.get(i);
			final ComponentNode node = new ComponentNode(subTree, component);

			final boolean isStarter = isIndendationStarter(component);
			final boolean isStopper = isIndendationStopper(component);
			final Tree parent = subTree.getParent();
			if (isStarter) {
				if (isStopper) {
					if (parent != null) {
						subTree = parent;
					}
					subTree.addChildNode(node);
					subTree = new Tree(subTree);
				} else {
					subTree.addChildNode(node);
					subTree = new Tree(subTree);
				}
			} else {
				if (isStopper) {
					if (parent != null) {
						subTree = parent;
					}
					subTree.addChildNode(node);
				} else {
					subTree.addChildNode(node);
				}
			}
			if (!component.isEnabled()) {
				disabledComponents.add(node);
			}
		}
		
		for (ComponentNode disabledComponent : disabledComponents) {
			// deep search right siblings
			List<Node> siblings = disabledComponent.getParent().getChildNodes();
			boolean right = false;
			for (Node sibling : siblings) {
				if (sibling == disabledComponent) {
					right = true;
					continue;
				}
				if (!right) {
					continue;
				}
				enable(disabledComponent.getComponent(), sibling);
			}
		}
	}

	private void enable(StringComponent component, Node node) {
		if (node instanceof Tree) {
			List<Node> children = ((Tree) node).getChildNodes();
			for (Node child : children) {
				enable(component, child);
			}
		} else {
			StringComponent nodeComponent = ((ComponentNode) node).getComponent();
			if (nodeComponent.isEnabled()) {
				String text = nodeComponent.getText();
				component.enable(text);
			}
		}
	}

	protected boolean isLineBreaker(Component component) {
		for (String starter : lineBreakers) {
			if (component.toString().endsWith(starter)) {
				return true;
			}
		}
		return false;
	}

	protected boolean isIndendationStarter(Component component) {
		for (String starter : indentationStarters) {
			if (component.toString().endsWith(starter)) {
				return true;
			}
		}
		return false;
	}

	protected boolean isIndendationStopper(Component component) {
		for (String stopper : indentationStoppers) {
			if (component.toString().startsWith(stopper)) {
				return true;
			}
		}
		return false;
	}

	private static final int MAX_TABS = 20;
	private static final String[] TAB_STRINGS = new String[20];
	
	public static String getTabText(int tabs) {
		if (tabs >= MAX_TABS) {
			return createTabString(tabs);
		}
		String tabString = TAB_STRINGS[tabs];
		if (tabString == null) {
			TAB_STRINGS[tabs] = createTabString(tabs);
		}
		return TAB_STRINGS[tabs];
	}

	private static String createTabString(int tabs) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < tabs; i++) {
			builder.append('\t');
		}
		return builder.toString();
	}

	public boolean isEnabled() {
		return enabled;
	}
}

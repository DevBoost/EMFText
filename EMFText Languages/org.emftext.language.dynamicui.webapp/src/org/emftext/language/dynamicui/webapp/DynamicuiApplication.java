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
package org.emftext.language.dynamicui.webapp;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.emftext.language.dynamicui.Property;
import org.emftext.language.dynamicui.UIElement;
import org.emftext.language.dynamicui.resource.dynamicui.DynamicuiEProblemType;
import org.emftext.language.dynamicui.resource.dynamicui.mopp.DynamicuiNewFileContentProvider;
import org.emftext.language.dynamicui.resource.dynamicui.mopp.DynamicuiResource;
import org.emftext.language.dynamicui.resource.dynamicui.util.DynamicuiResourceUtil;

import com.vaadin.Application;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.terminal.gwt.server.WebApplicationContext;
import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * The DynamicuiApplication shows how a DSL can be embedded in a Vaadin web 
 * application to configure its UI dynamically.
 */
public class DynamicuiApplication extends Application {

	private static final long serialVersionUID = 6301887334501776618L;

	private static final boolean SHOW_FANCY_STUFF = true;

	// this is where we put the dynamic UI elements
	private VerticalLayout content;
	// this is fancy stuff we'll explore later on
	private Tree tree;
	private HierarchicalContainer dataSource;
	private Table table;

	@Override
	public void init() {
		WebApplicationContext context = (WebApplicationContext) getContext();
		HttpSession httpSession = context.getHttpSession();
		ServletContext servletContext = httpSession.getServletContext();
		servletContext.setAttribute(DynamicuiApplication.class.getName(), this);
		
		Window mainWindow = new Window("DynamicuiApplication");
		
		HorizontalLayout inputArea = new HorizontalLayout();
		// first, we create the text area where we'll enter the UI model
		TextArea tf = new TextArea();
		tf.setRows(20);
		tf.setColumns(40);
		tf.setStyleName("typewriter");
		inputArea.addComponent(tf);
		mainWindow.addComponent(inputArea);

		// second, we create fancy stuff that is not shown yet
		addTreeAndTable(inputArea);
		
		// third, we add an empty container that will be dynamically
		// filled according to the model that we enter in the text area
		content = new VerticalLayout();
		mainWindow.addComponent(content);
		
		setMainWindow(mainWindow);
		setTheme("org.emftext.language.dynamicui.webapp.theme");

		tf.addListener(new TextChangeListener() {
			
			private static final long serialVersionUID = -8513916974596658539L;

			public void textChange(TextChangeEvent event) {
				handleTextChange(event.getText());
			}
		});
		
		tf.setValue(new DynamicuiNewFileContentProvider().getNewFileContent(null));
	}

	/**
	 * The text in the text area has change, so we need to parse it and
	 * create a dynamic UI.
	 */
	protected void handleTextChange(String text) {
		// parse the text - one line of code!
		UIElement rootElement = DynamicuiResourceUtil.getResourceContent(text);
		// remove the previous dynamic UI
		content.removeAllComponents();
		dataSource.removeAllItems();
		if (rootElement != null) {
			addDynamicComponent(rootElement, content);
			updateHiddenFancyStuff(rootElement);
		}
	}

	/**
	 * Uses the given UI element and creates a corresponding Vaadin
	 * widget. If the UI element contains children, this method is
	 * called recursively.
	 */
	private void addDynamicComponent(UIElement element, ComponentContainer parent) {
		if (element == null) {
			return;
		}
		String name = element.getName();
		dataSource.addItem(element);
		if (parent != content) {
			dataSource.setParent(element, element.eContainer());
		}
		dataSource.setChildrenAllowed(element, false);
		String className = "com.vaadin.ui." + name;
		try {
			Class<?> clazz = Class.forName(className);
			Object newInstance = clazz.newInstance();
			
			if (newInstance instanceof Component) {
				Component component = (Component) newInstance;
				parent.addComponent(component);
				setProperties(element, component);

				if (component instanceof ComponentContainer) {
					List<UIElement> children = element.getChildren();
					for (UIElement child : children) {
						dataSource.setChildrenAllowed(element, true);
						addDynamicComponent(child, (ComponentContainer) component);
					}
				}
			}
		} catch (Exception e) {
			addError(element, "Can't create class '" + className + "'");
		}
	}

	private void setProperties(UIElement element, Component component) {
		// set properties
		List<Property> properties = element.getProperties();
		for (Property property : properties) {
			setProperty(element, component, property);
		}
	}

	private void setProperty(UIElement element, Component component, Property property) {
		
		String propertyName = property.getName();
		String value = property.getValue();
		try {
			Method method = component.getClass().getMethod("set" + propertyName, String.class);
			method.invoke(component, value);
		} catch (Exception e) {
			addError(property, "Can't set property '" + propertyName + "'");
		}
	}

	private void addError(EObject causingObject, String message) {
		DynamicuiResource eResource = (DynamicuiResource) causingObject.eResource();
		eResource.addError(message, DynamicuiEProblemType.ANALYSIS_PROBLEM, causingObject);
	}

	private void updateHiddenFancyStuff(UIElement rootElement) {
		// update fancy stuff
		updateParseErrorTable(rootElement);
		tree.expandItemsRecursively(rootElement);
	}

	private void addTreeAndTable(HorizontalLayout inputArea) {
		VerticalLayout treeAndTable = new VerticalLayout();
		// a tree showing the model
		tree = new Tree();
		dataSource = new HierarchicalContainer();
		tree.setContainerDataSource(dataSource);
		tree.setWidth("50%");
		
		// a table showing the parse errors
		table = new Table();
		table.setHeight("70px");
		table.setWidth("500px");
        table.addContainerProperty("Message", String.class, null);
        table.addContainerProperty("Line", Integer.class, null);

        if (SHOW_FANCY_STUFF) {
            treeAndTable.addComponent(table);
    		treeAndTable.addComponent(tree);
		}

		inputArea.addComponent(treeAndTable);
	}

	private void updateParseErrorTable(UIElement rootElement) {
		table.removeAllItems();
		Resource eResource = rootElement.eResource();
		EList<Diagnostic> errors = eResource.getErrors();
		for (Diagnostic error : errors) {
			table.addItem(new Object[] {error.getMessage(), error.getLine()}, errors.indexOf(error));
		}
	}

	public void removeTreeContent() {
		dataSource.removeAllItems();
		tree.removeAllItems();
	}
}

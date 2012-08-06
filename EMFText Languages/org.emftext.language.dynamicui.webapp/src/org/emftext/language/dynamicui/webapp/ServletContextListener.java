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

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

/**
 * The purpose of this ServletContextListener is to remove all objects from the
 * application that are not serializable.
 * 
 * TODO fix this class
 */
public class ServletContextListener implements javax.servlet.ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
	}
	
	public void contextDestroyed(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();
		
		String key = DynamicuiApplication.class.getName();
		
		Object app = servletContext.getAttribute(key);
		if (app != null && app instanceof DynamicuiApplication) {
			DynamicuiApplication dynamicuiApplication = (DynamicuiApplication) app;
			dynamicuiApplication.removeTreeContent();
			servletContext.setAttribute(key, null);
		}
	}
}

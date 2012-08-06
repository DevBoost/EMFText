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
package org.emftext.language.appflow.test;

import static junit.framework.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.appflow.AppFlowFactory;
import org.emftext.language.appflow.AppFlowPackage;
import org.emftext.language.appflow.Application;
import org.emftext.language.appflow.actions.ActionsPackage;
import org.emftext.language.appflow.commons.CommonsPackage;
import org.emftext.language.appflow.resource.appflow.mopp.AppflowMetaInformation;
import org.emftext.language.appflow.screenmodel.Screen;
import org.emftext.language.appflow.screenmodel.ScreenmodelFactory;
import org.emftext.language.appflow.screenmodel.ScreenmodelPackage;
import org.emftext.language.appflow.statemodel.StatemodelFactory;
import org.emftext.language.appflow.statemodel.StatemodelPackage;
import org.emftext.language.appflow.widgets.Button;
import org.emftext.language.appflow.widgets.Panel;
import org.emftext.language.appflow.widgets.TextField;
import org.emftext.language.appflow.widgets.WidgetsFactory;
import org.emftext.language.appflow.widgets.WidgetsPackage;
import org.junit.Test;

public class PrintingTest {

	public PrintingTest(){
		registerFactories();
	}

	private void registerFactories() {
		EPackage.Registry.INSTANCE.put(AppFlowPackage.eNS_URI, AppFlowPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(StatemodelPackage.eNS_URI, StatemodelPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(CommonsPackage.eNS_URI, CommonsPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(ActionsPackage.eNS_URI, ActionsPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(ScreenmodelPackage.eNS_URI, ScreenmodelPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(WidgetsPackage.eNS_URI, WidgetsPackage.eINSTANCE);

		new AppflowMetaInformation().registerResourceFactory();
	}
	
	@Test
	public void testIndentationPrinting(){
		Application application = AppFlowFactory.eINSTANCE.createApplication();
		application.setName("TestApp");
		application.setStatemodel(StatemodelFactory.eINSTANCE.createStateModel());
		Screen screen = ScreenmodelFactory.eINSTANCE.createScreen();
		application.getScreens().add(screen);
		Button button = WidgetsFactory.eINSTANCE.createButton();
		button.setName("testButton");
		Panel panel = WidgetsFactory.eINSTANCE.createPanel();
		panel.setName("TestPanel");
		TextField textField1 = WidgetsFactory.eINSTANCE.createTextField();
		textField1.setName("testTextField1");
		TextField textField2 = WidgetsFactory.eINSTANCE.createTextField();
		textField2.setName("testTextField2");
		panel.getCompounds().add(textField1);
		panel.getCompounds().add(textField2);
		screen.getCompounds().add(button);
		screen.getCompounds().add(panel);
		ResourceSet rs = new ResourceSetImpl();
		URI uri = URI.createURI("testApp.appflow");
		Resource importedResource = rs.createResource(uri);
		importedResource.getContents().add(application);
		OutputStream os = new ByteArrayOutputStream();
		try {
			importedResource.save(os, null);
			String printedAF = os.toString();
			System.out.println(printedAF);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}

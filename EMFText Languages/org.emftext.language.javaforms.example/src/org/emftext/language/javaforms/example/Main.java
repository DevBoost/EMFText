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
package org.emftext.language.javaforms.example;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class Main extends ApplicationWindow {
		
	public Main() {
		super(null);
	}

	public void run() {
		// Don't return from open() until window closes
		setBlockOnOpen(true);
		// Open the main window
		open();
		// Dispose the display
		Display.getCurrent().dispose();
	}
	
	public Control createContents(Composite parent) {
		Test2Wizard wizard = new Test2Wizard();
		WizardDialog dialog = new WizardDialog(Display.getCurrent().getActiveShell(), wizard);
		dialog.create();
		dialog.open();
		return null;
	}
	
	public static void main(String[] args) {
		new Main().run();
	}
}

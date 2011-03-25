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
package org.emftext.sdk.ui.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class CustomizeSyntaxWizard extends Wizard implements INewWizard {

	private IWorkbench workbench;
	private CustomSyntaxPage page;
	private IFile genModelFile;

	public CustomizeSyntaxWizard(IFile genModelFile) {
		this.genModelFile = genModelFile;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
	}
	
	public void addPages() {
		page = new CustomSyntaxPage(workbench, genModelFile);
		addPage(page);
	}

	@Override
	public boolean performFinish() {
		return false;
	}
}

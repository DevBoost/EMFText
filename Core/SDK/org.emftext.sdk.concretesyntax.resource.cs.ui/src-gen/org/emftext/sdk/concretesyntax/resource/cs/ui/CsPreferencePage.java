/*******************************************************************************
 * Copyright (c) 2006-2013
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

package org.emftext.sdk.concretesyntax.resource.cs.ui;

/**
 * The root preference page
 */
public class CsPreferencePage extends org.eclipse.jface.preference.PreferencePage implements org.eclipse.ui.IWorkbenchPreferencePage {
	
	public void init(org.eclipse.ui.IWorkbench workbench) {
		setPreferenceStore(org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin.getDefault().getPreferenceStore());
		setDescription("Cs Text Editor Preferences");
	}
	
	@Override	
	protected org.eclipse.swt.widgets.Control createContents(org.eclipse.swt.widgets.Composite parent) {
		org.eclipse.swt.widgets.Composite settingComposite = new org.eclipse.swt.widgets.Composite(parent, org.eclipse.swt.SWT.NONE);
		org.eclipse.swt.layout.GridLayout layout = new org.eclipse.swt.layout.GridLayout();
		org.eclipse.swt.layout.GridData gd;
		layout.numColumns= 1;
		layout.marginHeight= 0;
		layout.marginWidth= 0;
		gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.BEGINNING);
		settingComposite.setLayout(layout);
		settingComposite.setLayoutData(gd);
		org.eclipse.swt.widgets.Link link = new org.eclipse.swt.widgets.Link(settingComposite, org.eclipse.swt.SWT.NONE);
		link.setText("Go to <A href=\"http://www.emftext.org\">www.emftext.org</A> for more information.");
		link.setSize(140, 40);
		link.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				if (e.text.startsWith("http")) org.eclipse.swt.program.Program.launch(e.text);
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {}
		});
		return settingComposite;
	}
	
}

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

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class Test2Wizard extends Wizard {

	private String name;
	private int age;
	private String guardian;
	private int vegetarian;

	@Override
	public boolean performFinish() {
		return true;
	}

	@Override
	public void addPages() {
		addPage(new WizardPage("Personal Details", "Personal Details", null) {

			public void createControl(Composite parent) {
				GridData gd = new GridData(SWT.FILL, SWT.BOTTOM, true, false, 1, 1);
				GridData gd2 = new GridData(SWT.FILL, SWT.BOTTOM, true, false, 2, 1);
	
				Composite composite = new Composite(parent, SWT.NONE);
				// create the desired layout for this wizard page
				GridLayout gl = new GridLayout();
				gl.numColumns = 2;
				composite.setLayout(gl);
	
				Label question = new Label(composite, NONE);
				question.setText("Name");

				Text text = new Text(composite, SWT.SINGLE);
				text.setLayoutData(gd);
				question.setLayoutData(gd);
				// TODO handle conditional item
				boolean isEnabled = true;
				if (isEnabled) {
				}
				
				setControl(composite);
			}
		});
		addPage(new WizardPage("Personal Details", "Personal Details", null) {

			public void createControl(Composite parent) {
				GridData gd = new GridData(SWT.FILL, SWT.BOTTOM, true, false, 1, 1);
				GridData gd2 = new GridData(SWT.FILL, SWT.BOTTOM, true, false, 2, 1);
	
				Composite composite = new Composite(parent, SWT.NONE);
				// create the desired layout for this wizard page
				GridLayout gl = new GridLayout();
				gl.numColumns = 2;
				composite.setLayout(gl);
	
				Label question = new Label(composite, NONE);
				question.setText("Age");

				Spinner spinner = new Spinner(composite, SWT.NONE);
				spinner.setLayoutData(gd);
				question.setLayoutData(gd);
				// TODO handle conditional item
				boolean isEnabled = true;
				if (isEnabled) {
				}
				
				setControl(composite);
			}
		});
		addPage(new WizardPage("Personal Details", "Personal Details", null) {

			public void createControl(Composite parent) {
				GridData gd = new GridData(SWT.FILL, SWT.BOTTOM, true, false, 1, 1);
				GridData gd2 = new GridData(SWT.FILL, SWT.BOTTOM, true, false, 2, 1);
	
				Composite composite = new Composite(parent, SWT.NONE);
				// create the desired layout for this wizard page
				GridLayout gl = new GridLayout();
				gl.numColumns = 2;
				composite.setLayout(gl);
	
				Label question = new Label(composite, NONE);
				question.setText("Legal Guardian");

				Text text = new Text(composite, SWT.SINGLE);
				text.setLayoutData(gd);
				question.setLayoutData(gd);
				// TODO handle conditional item
				boolean isEnabled = true;
				isEnabled = age < 18;
				if (isEnabled) {
				}
				
				setControl(composite);
			}
		});
		addPage(new WizardPage("Personal Details", "Personal Details", null) {

			public void createControl(Composite parent) {
				GridData gd = new GridData(SWT.FILL, SWT.BOTTOM, true, false, 1, 1);
				GridData gd2 = new GridData(SWT.FILL, SWT.BOTTOM, true, false, 2, 1);
	
				Composite composite = new Composite(parent, SWT.NONE);
				// create the desired layout for this wizard page
				GridLayout gl = new GridLayout();
				gl.numColumns = 2;
				composite.setLayout(gl);
	
				Label question = new Label(composite, NONE);
				question.setText("Vegetarian");

				int type = SWT.RADIO;
				{
					Button radioButton = new Button(composite, type);
					radioButton.setLayoutData(gd2);
					String optionName = "yes";
					if (optionName == null) {
						optionName = "";
					}
					radioButton.setText(optionName);
				}
				{
					Button radioButton = new Button(composite, type);
					radioButton.setLayoutData(gd2);
					String optionName = "no";
					if (optionName == null) {
						optionName = "";
					}
					radioButton.setText(optionName);
				}
				question.setLayoutData(gd2);
				// TODO handle conditional item
				boolean isEnabled = true;
				if (isEnabled) {
				}
				
				setControl(composite);
			}
		});
		addPage(new WizardPage("Personal Details", "Personal Details", null) {

			public void createControl(Composite parent) {
				GridData gd = new GridData(SWT.FILL, SWT.BOTTOM, true, false, 1, 1);
				GridData gd2 = new GridData(SWT.FILL, SWT.BOTTOM, true, false, 2, 1);
	
				Composite composite = new Composite(parent, SWT.NONE);
				// create the desired layout for this wizard page
				GridLayout gl = new GridLayout();
				gl.numColumns = 2;
				composite.setLayout(gl);
	
				Label question = new Label(composite, NONE);
				question.setText("Want free beer?");

				int type = SWT.RADIO;
				{
					Button radioButton = new Button(composite, type);
					radioButton.setLayoutData(gd2);
					String optionName = "yes";
					if (optionName == null) {
						optionName = "";
					}
					radioButton.setText(optionName);
				}
				{
					Button radioButton = new Button(composite, type);
					radioButton.setLayoutData(gd2);
					String optionName = "no";
					if (optionName == null) {
						optionName = "";
					}
					radioButton.setText(optionName);
				}
				question.setLayoutData(gd2);
				// TODO handle conditional item
				boolean isEnabled = true;
				isEnabled = name.contains("Mirko");
				if (isEnabled) {
				}
				
				setControl(composite);
			}
		});
	}
}

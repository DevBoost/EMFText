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
package org.emftext.language.dbschema.resource.dbschema.ui;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.emftext.language.dbschema.DBSchema;
import org.emftext.language.dbschema.discovery.SchemaReader;
import org.emftext.language.dbschema.resource.dbschema.IDbschemaResourceProvider;
import org.emftext.language.dbschema.resource.dbschema.IDbschemaTextResource;
import org.emftext.language.dbschema.resource.dbschema.mopp.DbschemaMetaInformation;
import org.emftext.language.dbschema.resource.dbschema.mopp.DbschemaPlugin;

public class DbschemaConnectionParameterPage extends WizardPage implements IDbschemaResourceProvider {

	private SourceViewer sourceViewer;
	private DbschemaColorManager colorManager;
	private IDbschemaTextResource schemaResource;
	private Text driverText;
	private Text connnectionText;
	private Text databaseText;
	private Text userText;
	private Text passwordText;
	private Button selectImportButton;

	public DbschemaConnectionParameterPage(String pageName) {
		super(pageName);
		setTitle("Select how to create the dbschema file.");
		setDescription("You can either create an empty file or read a schema from an existing database using a JDBC connection.");
		schemaResource = (IDbschemaTextResource) new ResourceSetImpl().createResource(URI.createURI("temp." + new DbschemaMetaInformation().getSyntaxName()));
	}

	public void createControl(Composite parent) {
		Listener changeListener = new Listener() {
			
			public void handleEvent(Event event) {
				update();
			}
		};

		Composite container = new Composite(parent, SWT.FILL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 1;
		//layout.verticalSpacing = 9;
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		container.setLayoutData(gd);
		
		Group keywordGroup = createGroup(container, "Select creation method", 1);
		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		//gd.grabExcessVerticalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		keywordGroup.setLayoutData(gd);
		
		Button button1 = new Button(keywordGroup, SWT.RADIO);
		button1.setText("&Create empty database schema");
		button1.addListener(SWT.Selection, changeListener);

		selectImportButton = new Button(keywordGroup, SWT.RADIO);
		selectImportButton.setText("&Import database schema using JDBC");
		selectImportButton.addListener(SWT.Selection, changeListener);
		selectImportButton.setSelection(false);
		button1.setSelection(true);
		
		Composite parameterContainer = new Composite(keywordGroup, SWT.NULL);
		layout = new GridLayout();
		layout.numColumns = 2;
		parameterContainer.setLayout(layout);
		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		parameterContainer.setLayoutData(gd);

		Label label1 = new Label(parameterContainer, SWT.NULL);
		label1.setText("JDBC driver class");
		driverText = new Text(parameterContainer, SWT.BORDER);
		driverText.setText("com.mysql.jdbc.Driver");
		driverText.addListener(SWT.Modify, changeListener);
		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		driverText.setLayoutData(gd);
		
		Label label2 = new Label(parameterContainer, SWT.NULL);
		label2.setText("JDBC connection string");
		connnectionText = new Text(parameterContainer, SWT.BORDER);
		connnectionText.setText("jdbc:mysql://localhost/mySchema");
		connnectionText.addListener(SWT.Modify, changeListener);
		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		connnectionText.setLayoutData(gd);

		Label label3 = new Label(parameterContainer, SWT.NULL);
		label3.setText("JDBC database name");
		databaseText = new Text(parameterContainer, SWT.BORDER);
		databaseText.setText("mySchema");
		databaseText.addListener(SWT.Modify, changeListener);
		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		databaseText.setLayoutData(gd);

		Label label4 = new Label(parameterContainer, SWT.NULL);
		label4.setText("JDBC user");
		userText = new Text(parameterContainer, SWT.BORDER);
		userText.setText("user");
		userText.addListener(SWT.Modify, changeListener);
		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		userText.setLayoutData(gd);

		Label label5 = new Label(parameterContainer, SWT.NULL);
		label5.setText("JDBC passwort");
		passwordText = new Text(parameterContainer, SWT.BORDER | SWT.PASSWORD);
		passwordText.setText("pass");
		passwordText.addListener(SWT.Modify, changeListener);
		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		passwordText.setLayoutData(gd);

		Group previewGroup = createGroup(container, "Preview", 1);
		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace = true;
		gd.verticalAlignment = SWT.FILL;
		gd.horizontalAlignment = SWT.FILL;
		previewGroup.setLayoutData(gd);

		sourceViewer = new SourceViewer(previewGroup, null, SWT.READ_ONLY | SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
		sourceViewer.getTextWidget().setFont(JFaceResources.getTextFont());
		sourceViewer.setDocument(new Document());
		sourceViewer.getTextWidget().setLayoutData(gd);
		colorManager = new DbschemaColorManager();
		sourceViewer.configure(new DbschemaSourceViewerConfiguration(this, null, null, colorManager));

		setControl(container);
		update();
	}

	protected void update() {
		boolean doImport = selectImportButton.getSelection();
		connnectionText.setEnabled(doImport);
		driverText.setEnabled(doImport);
		databaseText.setEnabled(doImport);
		userText.setEnabled(doImport);
		passwordText.setEnabled(doImport);
		
		sourceViewer.getTextWidget().setEnabled(doImport);
		if (doImport) {
			generatePreview();
		} else {
			sourceViewer.getDocument().set("");
		}
	}

	private void generatePreview() {
		SchemaReader reader = new SchemaReader();
		DBSchema schema;
		try {
			schema = reader.discoverSchema(
				driverText.getText(),
				connnectionText.getText(),
				databaseText.getText(),
				userText.getText(),
				passwordText.getText()
			);
			schemaResource.getContents().clear();
			schemaResource.getContents().add(schema);
			sourceViewer.getDocument().set(getResourceContent(null));
		} catch (Exception e) {
			sourceViewer.getDocument().set("Invalid database connection settings: " + e.getMessage());
		}
	}

	public String getResourceContent(String newName) {
		if (schemaResource.getContents().isEmpty()) {
			return new org.emftext.language.dbschema.resource.dbschema.mopp.DbschemaMetaInformation().getNewFileContentProvider().getNewFileContent(newName);
		} else {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			try {
				schemaResource.save(outputStream, null);
			} catch (IOException e) {
				DbschemaPlugin.logError("Exception while printing model.", e);
			}
			return outputStream.toString();
		}
	}
	
	private Group createGroup(Composite parent, String title, int columns) {
		Group group = new Group(parent, SWT.NONE);
		group.setText(title);
		GridLayout gl = new GridLayout();
		gl.numColumns = columns;
		group.setLayout(gl);
		return group;
	}

	public IDbschemaTextResource getResource() {
		return schemaResource;
	}
}

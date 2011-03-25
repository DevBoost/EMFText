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

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IWorkbench;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.resource.cs.ICsResourceProvider;
import org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.ui.CsColorManager;
import org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditorConfiguration;
import org.emftext.sdk.ui.AbstractSyntaxGenerator;

public class CustomSyntaxPage extends WizardPage implements Listener, ICsResourceProvider {
	
	private IFile genModelFile;

	private CsColorManager csColorManager;
	private CsResource csResource;
	// UI elements
	private SourceViewer sourceViewer;
	private Button buttonUseKeywords;

	public CustomSyntaxPage(IWorkbench workbench, IFile genModelFile) {
		super("Syntax customization");
		setTitle("Syntax customization");
		setDescription("Customize the syntax according to your needs");
		this.genModelFile = genModelFile;
	}

	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout gl = new GridLayout();
		gl.numColumns = 1;
		composite.setLayout(gl);

		Composite viewer = new Composite(composite, SWT.NONE);
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace = true;
		gd.verticalAlignment = SWT.FILL;
		gd.horizontalAlignment = SWT.FILL;
		viewer.setLayoutData(gd);
		viewer.setLayout(gl);

		sourceViewer = new SourceViewer(viewer, null, SWT.READ_ONLY | SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
		sourceViewer.getTextWidget().setFont(JFaceResources.getTextFont());
		sourceViewer.setDocument(new Document());
		sourceViewer.getTextWidget().setLayoutData(gd);
		csColorManager = new CsColorManager();
		sourceViewer.configure(new CsEditorConfiguration(this, null, null, csColorManager));

		buttonUseKeywords = new Button(composite, SWT.CHECK);
		buttonUseKeywords.setText("Keywords");
		buttonUseKeywords.setSelection(true);
		Listener changeListener = new Listener() {
			
			public void handleEvent(Event event) {
				regenerateSyntax();
			}
		};
		buttonUseKeywords.addListener(SWT.Selection, changeListener);

		setControl(composite);		
		setPageComplete(true);

		regenerateSyntax();
	}

	protected void regenerateSyntax() {
		ResourceSet rs = new ResourceSetImpl();
		Resource genResource = rs.getResource(URI.createPlatformResourceURI(genModelFile.getFullPath().toString(), true), true);
		final GenModel genModel = (GenModel) genResource.getContents().get(0);
		csResource = (CsResource) new ResourceSetImpl().createResource(URI.createURI("customSyntaxPreview." + new CsMetaInformation().getSyntaxName()));
		
		ConcreteSyntax syntax = AbstractSyntaxGenerator.CS_FACTORY.createConcreteSyntax();
		GenPackage genPackage = genModel.getGenPackages().get(0);
		syntax.setPackage(genPackage);
		syntax.setName(genPackage.getNSName());
		csResource.getContents().clear();
		csResource.getContents().add(syntax);
		
		CustomSyntaxConfiguration configuration = new CustomSyntaxConfiguration();
		configuration.setUseKeywords(buttonUseKeywords.getSelection());
		CustomSyntaxGenerator generator = new CustomSyntaxGenerator(configuration);
		generator.fillSyntax(syntax, genModel);
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			csResource.save(outputStream, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sourceViewer.getDocument().set(outputStream.toString());
	}

	public void handleEvent(Event event) {
		// TODO Auto-generated method stub
	}

	@Override
	public void dispose() {
		csColorManager.dispose();
		super.dispose();
	}

	public ICsTextResource getResource() {
		return csResource;
	}
}

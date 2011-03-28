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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.resource.cs.ICsResourceProvider;
import org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.ui.CsColorManager;
import org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditorConfiguration;
import org.emftext.sdk.ui.AbstractSyntaxGenerator;
import org.emftext.sdk.ui.wizards.CustomSyntaxConfiguration.KeywordStyle;

public class CustomSyntaxPage extends WizardPage implements ICsResourceProvider {
	
	private IFile genModelFile;

	private CsColorManager csColorManager;
	private CsResource csResource;
	// UI elements
	private SourceViewer sourceViewer;
	private Button buttonNoKeywords;

	private Button buttonLowerKeywords;

	private Button buttonUpperKeywords;

	private Button buttonCapitalizedKeywords;

	private Button useSingleLineComments;

	private Text singleLineCommentPrefix;

	private Button useMultiLineComments;

	private Text multiLineCommentPrefix;

	private Button encloseFeatures;

	private Text encloseFeatureStart;

	private Text encloseFeatureEnd;

	private Text multiLineCommentSuffix;

	private Button qualifyAttributes;

	private Button qualifyContainments;

	private Button qualifyCrossReferences;

	private Text qualificationDelimiter;

	private Button terminateTerminalElements;

	private Text terminator;

	private Combo stringQuote;

	private Button booleanAttributesFirst;

	private Button quoteStringAttributes;

	public CustomSyntaxPage(IWorkbench workbench, IFile genModelFile) {
		super("Syntax customization");
		setTitle("Syntax customization");
		setDescription("Customize the syntax according to your needs");
		this.genModelFile = genModelFile;
	}

	public void createControl(Composite parent) {
		Composite composite = createComposite(parent, 1);

		GridLayout gl = new GridLayout();
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

		Listener changeListener = new Listener() {
			
			public void handleEvent(Event event) {
				update();
			}
		};

		Group keywordComposite = createGroup(composite, "Keywords", 4);
		buttonNoKeywords = new Button(keywordComposite, SWT.RADIO);
		buttonNoKeywords.setText("none");
		buttonNoKeywords.addListener(SWT.Selection, changeListener);
		buttonLowerKeywords = new Button(keywordComposite, SWT.RADIO);
		buttonLowerKeywords.setText("lower");
		buttonLowerKeywords.addListener(SWT.Selection, changeListener);
		buttonUpperKeywords = new Button(keywordComposite, SWT.RADIO);
		buttonUpperKeywords.setText("upper");
		buttonUpperKeywords.addListener(SWT.Selection, changeListener);
		buttonCapitalizedKeywords = new Button(keywordComposite, SWT.RADIO);
		buttonCapitalizedKeywords.setText("capitalized");
		buttonCapitalizedKeywords.addListener(SWT.Selection, changeListener);

		buttonLowerKeywords.setSelection(true);

		Group slCommentComposite = createGroup(composite, "Comments", 5);
		useMultiLineComments = new Button(slCommentComposite, SWT.CHECK);
		useMultiLineComments.setText("Use multi line comments");
		useMultiLineComments.addListener(SWT.Selection, changeListener);
		Label multiLineCommentLabel = new Label(slCommentComposite, SWT.NONE);
		multiLineCommentLabel.setText("Prefix");
		multiLineCommentPrefix = new Text(slCommentComposite, SWT.BORDER);
		multiLineCommentPrefix.setText("/*");
		multiLineCommentPrefix.addListener(SWT.Modify, changeListener);
		Label multiLineCommentLabel2 = new Label(slCommentComposite, SWT.NONE);
		multiLineCommentLabel2.setText("Suffix");
		multiLineCommentSuffix = new Text(slCommentComposite, SWT.BORDER);
		multiLineCommentSuffix.setText("*/");
		multiLineCommentSuffix.addListener(SWT.Modify, changeListener);
		useMultiLineComments.setSelection(false);

		useSingleLineComments = new Button(slCommentComposite, SWT.CHECK);
		useSingleLineComments.setText("Use single line comments");
		useSingleLineComments.addListener(SWT.Selection, changeListener);
		Label singeLineCommentLabel = new Label(slCommentComposite, SWT.NONE);
		singeLineCommentLabel.setText("Prefix");
		singleLineCommentPrefix = new Text(slCommentComposite, SWT.BORDER);
		singleLineCommentPrefix.setText("//");
		singleLineCommentPrefix.addListener(SWT.Modify, changeListener);
		useSingleLineComments.setSelection(true);

		Group containmentComposite = createGroup(composite, "Feature Grouping", 5);
		encloseFeatures = new Button(containmentComposite, SWT.CHECK);
		encloseFeatures.setText("Enclose features");
		encloseFeatures.addListener(SWT.Selection, changeListener);
		Label startEncloseLabel = new Label(containmentComposite, SWT.NONE);
		startEncloseLabel.setText("Start");
		encloseFeatureStart = new Text(containmentComposite, SWT.BORDER);
		encloseFeatureStart.setText("{");
		encloseFeatureStart.addListener(SWT.Modify, changeListener);
		Label endEncloseLabel = new Label(containmentComposite, SWT.NONE);
		endEncloseLabel.setText("End");
		encloseFeatureEnd = new Text(containmentComposite, SWT.BORDER);
		encloseFeatureEnd.setText("}");
		encloseFeatureEnd.addListener(SWT.Modify, changeListener);
		encloseFeatures.setSelection(false);

		terminateTerminalElements = new Button(containmentComposite, SWT.CHECK);
		terminateTerminalElements.setText("Terminate terminal elements");
		terminateTerminalElements.addListener(SWT.Selection, changeListener);
		Label terminatorLabel = new Label(containmentComposite, SWT.NONE);
		terminatorLabel.setText("Terminator");
		terminator = new Text(containmentComposite, SWT.BORDER);
		terminator.setText(";");
		terminator.addListener(SWT.Modify, changeListener);
		terminateTerminalElements.setSelection(false);
		
		Group qualificationComposite = createGroup(composite, "Feature Qualification", 5);
		qualifyAttributes = new Button(qualificationComposite, SWT.CHECK);
		qualifyAttributes.setText("Attributes");
		qualifyAttributes.addListener(SWT.Selection, changeListener);
		qualifyContainments = new Button(qualificationComposite, SWT.CHECK);
		qualifyContainments.setText("Containment references");
		qualifyContainments.addListener(SWT.Selection, changeListener);
		qualifyCrossReferences = new Button(qualificationComposite, SWT.CHECK);
		qualifyCrossReferences.setText("Non-containment references");
		qualifyCrossReferences.addListener(SWT.Selection, changeListener);
		Label delimiterLabel = new Label(qualificationComposite, SWT.NONE);
		delimiterLabel.setText("Delimiter");
		qualificationDelimiter = new Text(qualificationComposite, SWT.BORDER);
		qualificationDelimiter.setText(":");
		qualificationDelimiter.addListener(SWT.Modify, changeListener);

		Group attributeComposite = createGroup(composite, "Attributes", 5);
		booleanAttributesFirst = new Button(attributeComposite, SWT.CHECK);
		booleanAttributesFirst.setText("Modifier style for boolean attributes");
		booleanAttributesFirst.addListener(SWT.Selection, changeListener);
		quoteStringAttributes = new Button(attributeComposite, SWT.CHECK);
		quoteStringAttributes.setText("Quote string attributes");
		quoteStringAttributes.addListener(SWT.Selection, changeListener);
		stringQuote = new Combo(attributeComposite, SWT.DROP_DOWN | SWT.BORDER);
		stringQuote.setItems(new String[] {"Double quotes", "Single quotes"});
		stringQuote.select(0);
		stringQuote.addListener(SWT.Selection, changeListener);

		setControl(composite);
		setPageComplete(true);

		update();
	}

	protected void update() {
		singleLineCommentPrefix.setEnabled(useSingleLineComments.getSelection());
		multiLineCommentPrefix.setEnabled(useMultiLineComments.getSelection());
		multiLineCommentSuffix.setEnabled(useMultiLineComments.getSelection());
		
		encloseFeatureStart.setEnabled(encloseFeatures.getSelection());
		encloseFeatureEnd.setEnabled(encloseFeatures.getSelection());
		
		terminator.setEnabled(terminateTerminalElements.getSelection());
		
		qualificationDelimiter.setEnabled(
				qualifyAttributes.getSelection() ||
				qualifyContainments.getSelection() ||
				qualifyCrossReferences.getSelection());
		
		stringQuote.setEnabled(quoteStringAttributes.getSelection());
		regenerateSyntax();
	}

	private Composite createComposite(Composite parent, int columns) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout gl = new GridLayout();
		gl.numColumns = columns;
		composite.setLayout(gl);
		return composite;
	}

	private Group createGroup(Composite parent, String title, int columns) {
		Group group = new Group(parent, SWT.NONE);
		group.setText(title);
		GridLayout gl = new GridLayout();
		gl.numColumns = columns;
		group.setLayout(gl);
		return group;
	}

	private CustomSyntaxConfiguration createConfiguration() {
		CustomSyntaxConfiguration configuration = new CustomSyntaxConfiguration();
		if (buttonNoKeywords.getSelection()) {
			configuration.setKeywordStyle(KeywordStyle.NO_KEYWORDS);
		}
		if (buttonLowerKeywords.getSelection()) {
			configuration.setKeywordStyle(KeywordStyle.LOWER);
		}
		if (buttonUpperKeywords.getSelection()) {
			configuration.setKeywordStyle(KeywordStyle.UPPER);
		}
		if (buttonCapitalizedKeywords.getSelection()) {
			configuration.setKeywordStyle(KeywordStyle.CAPITALIZED);
		}
		configuration.setUseSingleLineComments(useSingleLineComments.getSelection());
		configuration.setSingleLineCommentPrefix(singleLineCommentPrefix.getText());
		
		configuration.setUseMultiLineComments(useMultiLineComments.getSelection());
		configuration.setMultiLineCommentPrefix(multiLineCommentPrefix.getText());
		configuration.setMultiLineCommentSuffix(multiLineCommentSuffix.getText());
		
		configuration.setEncloseContainments(encloseFeatures.getSelection());
		configuration.setContainmentOpener(encloseFeatureStart.getText());
		configuration.setContainmentCloser(encloseFeatureEnd.getText());
		
		configuration.setQualifyAttributes(qualifyAttributes.getSelection());
		configuration.setQualifyContainments(qualifyContainments.getSelection());
		configuration.setQualifyCrossReferences(qualifyCrossReferences.getSelection());
		configuration.setQualificationDelimiter(qualificationDelimiter.getText());
		
		configuration.setTerminateTerminalElements(terminateTerminalElements.getSelection());
		configuration.setTerminatingKeyword(terminator.getText());
		
		configuration.setSeparateBooleanAttributes(booleanAttributesFirst.getSelection());
		configuration.setQuoteStringAttributes(quoteStringAttributes.getSelection());
		if (stringQuote.getSelectionIndex() == 0) {
			configuration.setStringAttributeQuote("\"");
		}
		if (stringQuote.getSelectionIndex() == 1) {
			configuration.setStringAttributeQuote("'");
		}
		return configuration;
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
		
		CustomSyntaxConfiguration configuration = createConfiguration();
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

	@Override
	public void dispose() {
		csColorManager.dispose();
		super.dispose();
	}

	public ICsTextResource getResource() {
		return csResource;
	}
}

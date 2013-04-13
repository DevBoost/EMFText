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
import org.emftext.sdk.EMFTextSDKPlugin;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.resource.cs.ICsResourceProvider;
import org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.ui.CsColorManager;
import org.emftext.sdk.concretesyntax.resource.cs.ui.CsSourceViewerConfiguration;
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
	private Text multiLineCommentSuffix;

	private Button encloseFeatures;
	private Text encloseFeatureStart;
	private Text encloseFeatureEnd;

	private Button qualifyAttributes;
	private Button qualifyContainments;
	private Button qualifyCrossReferences;
	private Text qualificationDelimiter;

	private Button terminateTerminalElements;
	private Text terminator;

	private Button quoteStringAttributes;
	private Combo stringQuote;

	private Button modifierStyleForBooleanAttributes;
	private Button modifierStyleForEnumAttributes;

	private Button quoteIdentifierAttributes;

	private Combo identifierQuote;

	private Button allowDashInIdentifiers;

	private Button allowUnderscoreInIdentifiers;

	private Button allowIdentifiersStartingWithDigits;
	
	private Button generateRulesForImports;

	public CustomSyntaxPage(IWorkbench workbench, IFile genModelFile) {
		super("Syntax customization");
		setTitle("Syntax customization");
		setDescription("Customize the syntax according to your needs");
		this.genModelFile = genModelFile;
	}

	public void createControl(Composite parent) {
		Composite composite = createComposite(parent, 2);

		GridLayout gl = new GridLayout();
		Composite viewer = new Composite(composite, SWT.NONE);
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace = true;
		gd.verticalAlignment = SWT.FILL;
		gd.horizontalAlignment = SWT.FILL;
		gd.horizontalSpan = 2;
		viewer.setLayoutData(gd);
		viewer.setLayout(gl);

		sourceViewer = new SourceViewer(viewer, null, SWT.READ_ONLY | SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
		sourceViewer.getTextWidget().setFont(JFaceResources.getTextFont());
		sourceViewer.setDocument(new Document());
		sourceViewer.getTextWidget().setLayoutData(gd);
		csColorManager = new CsColorManager();
		sourceViewer.configure(new CsSourceViewerConfiguration(this, null, csColorManager));

		Listener changeListener = new Listener() {
			
			public void handleEvent(Event event) {
				update();
			}
		};

		createKeywordsGroup(composite, changeListener);
		createFeatureQualificationGroup(composite, changeListener);
		createCommentsGroup(composite, changeListener);
		createFeatureOptionsGroup(composite, changeListener);
		createAttributeGroup(composite, changeListener);
		createIdentifiersGroup(composite, changeListener);
		createImportsGroup(composite, changeListener);

		setControl(composite);
		setPageComplete(true);

		update();
	}

	private void createImportsGroup(Composite composite, Listener changeListener) {
		Group importsGroup = createGroup(composite, "Imports", 2);
		generateRulesForImports = new Button(importsGroup, SWT.CHECK);
		generateRulesForImports.setText("Generate syntax rules for imported packages");
		generateRulesForImports.addListener(SWT.Selection, changeListener);
		generateRulesForImports.setSelection(true);
	}

	private void createKeywordsGroup(Composite composite,
			Listener changeListener) {
		Group keywordGroup = createGroup(composite, "Keywords", 4);
		buttonNoKeywords = new Button(keywordGroup, SWT.RADIO);
		buttonNoKeywords.setText("none");
		buttonNoKeywords.addListener(SWT.Selection, changeListener);
		buttonLowerKeywords = new Button(keywordGroup, SWT.RADIO);
		buttonLowerKeywords.setText("lower");
		buttonLowerKeywords.addListener(SWT.Selection, changeListener);
		buttonUpperKeywords = new Button(keywordGroup, SWT.RADIO);
		buttonUpperKeywords.setText("upper");
		buttonUpperKeywords.addListener(SWT.Selection, changeListener);
		buttonCapitalizedKeywords = new Button(keywordGroup, SWT.RADIO);
		buttonCapitalizedKeywords.setText("capitalized");
		buttonCapitalizedKeywords.addListener(SWT.Selection, changeListener);

		buttonLowerKeywords.setSelection(true);
	}

	private void createCommentsGroup(Composite composite,
			Listener changeListener) {
		Group commentGroup = createGroup(composite, "Comments", 5);
		useMultiLineComments = new Button(commentGroup, SWT.CHECK);
		useMultiLineComments.setText("Use multi line comments");
		useMultiLineComments.addListener(SWT.Selection, changeListener);
		Label multiLineCommentLabel = new Label(commentGroup, SWT.NONE);
		multiLineCommentLabel.setText("Prefix");
		multiLineCommentPrefix = new Text(commentGroup, SWT.BORDER);
		multiLineCommentPrefix.setText("/*");
		multiLineCommentPrefix.addListener(SWT.Modify, changeListener);
		Label multiLineCommentLabel2 = new Label(commentGroup, SWT.NONE);
		multiLineCommentLabel2.setText("Suffix");
		multiLineCommentSuffix = new Text(commentGroup, SWT.BORDER);
		multiLineCommentSuffix.setText("*/");
		multiLineCommentSuffix.addListener(SWT.Modify, changeListener);
		useMultiLineComments.setSelection(false);

		useSingleLineComments = new Button(commentGroup, SWT.CHECK);
		useSingleLineComments.setText("Use single line comments");
		useSingleLineComments.addListener(SWT.Selection, changeListener);
		Label singeLineCommentLabel = new Label(commentGroup, SWT.NONE);
		singeLineCommentLabel.setText("Prefix");
		singleLineCommentPrefix = new Text(commentGroup, SWT.BORDER);
		singleLineCommentPrefix.setText("//");
		singleLineCommentPrefix.addListener(SWT.Modify, changeListener);
		useSingleLineComments.setSelection(true);
	}

	private void createFeatureOptionsGroup(Composite composite,
			Listener changeListener) {
		Group featureOptionsGroup = createGroup(composite, "Feature Grouping", 5);
		encloseFeatures = new Button(featureOptionsGroup, SWT.CHECK);
		encloseFeatures.setText("Enclose features");
		encloseFeatures.addListener(SWT.Selection, changeListener);
		Label startEncloseLabel = new Label(featureOptionsGroup, SWT.NONE);
		startEncloseLabel.setText("Start");
		encloseFeatureStart = new Text(featureOptionsGroup, SWT.BORDER);
		encloseFeatureStart.setText("{");
		encloseFeatureStart.addListener(SWT.Modify, changeListener);
		Label endEncloseLabel = new Label(featureOptionsGroup, SWT.NONE);
		endEncloseLabel.setText("End");
		encloseFeatureEnd = new Text(featureOptionsGroup, SWT.BORDER);
		encloseFeatureEnd.setText("}");
		encloseFeatureEnd.addListener(SWT.Modify, changeListener);
		encloseFeatures.setSelection(false);

		terminateTerminalElements = new Button(featureOptionsGroup, SWT.CHECK);
		terminateTerminalElements.setText("Terminate terminal elements");
		terminateTerminalElements.addListener(SWT.Selection, changeListener);
		Label terminatorLabel = new Label(featureOptionsGroup, SWT.NONE);
		terminatorLabel.setText("Terminator");
		terminator = new Text(featureOptionsGroup, SWT.BORDER);
		terminator.setText(";");
		terminator.addListener(SWT.Modify, changeListener);
		terminateTerminalElements.setSelection(false);
	}

	private void createFeatureQualificationGroup(Composite composite,
			Listener changeListener) {
		Group qualificationComposite = createGroup(composite, "Keywords for Features", 5);
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
	}

	private void createAttributeGroup(Composite composite,
			Listener changeListener) {
		Group attributeComposite = createGroup(composite, "Attributes", 3);
		modifierStyleForBooleanAttributes = new Button(attributeComposite, SWT.CHECK);
		modifierStyleForBooleanAttributes.setText("Modifier style for boolean attributes");
		modifierStyleForBooleanAttributes.addListener(SWT.Selection, changeListener);
		quoteStringAttributes = new Button(attributeComposite, SWT.CHECK);
		quoteStringAttributes.setText("Quote string attributes");
		quoteStringAttributes.addListener(SWT.Selection, changeListener);
		stringQuote = new Combo(attributeComposite, SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
		stringQuote.setItems(new String[] {"Double quotes", "Single quotes"});
		stringQuote.select(0);
		stringQuote.addListener(SWT.Selection, changeListener);
		
		modifierStyleForEnumAttributes = new Button(attributeComposite, SWT.CHECK);
		modifierStyleForEnumAttributes.setText("Modifier style for enum attributes");
		modifierStyleForEnumAttributes.addListener(SWT.Selection, changeListener);
	}

	private void createIdentifiersGroup(Composite composite,
			Listener changeListener) {
		Group identifierComposite = createGroup(composite, "Identifiers", 3);
		allowDashInIdentifiers = new Button(identifierComposite, SWT.CHECK);
		allowDashInIdentifiers.setText("Allow dash");
		allowDashInIdentifiers.addListener(SWT.Selection, changeListener);
		allowDashInIdentifiers.setSelection(true);
		allowUnderscoreInIdentifiers = new Button(identifierComposite, SWT.CHECK);
		allowUnderscoreInIdentifiers.setText("Allow underscore");
		allowUnderscoreInIdentifiers.addListener(SWT.Selection, changeListener);
		allowUnderscoreInIdentifiers.setSelection(true);
		allowIdentifiersStartingWithDigits = new Button(identifierComposite, SWT.CHECK);
		allowIdentifiersStartingWithDigits.setText("Allow digits as first character");
		allowIdentifiersStartingWithDigits.addListener(SWT.Selection, changeListener);
		allowIdentifiersStartingWithDigits.setSelection(false);

		quoteIdentifierAttributes = new Button(identifierComposite, SWT.CHECK);
		quoteIdentifierAttributes.setText("Quote identifiers");
		quoteIdentifierAttributes.addListener(SWT.Selection, changeListener);
		identifierQuote = new Combo(identifierComposite, SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
		identifierQuote.setItems(new String[] {"Double quotes", "Single quotes"});
		identifierQuote.select(0);
		identifierQuote.addListener(SWT.Selection, changeListener);
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
		identifierQuote.setEnabled(quoteIdentifierAttributes.getSelection());
		
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
		
		configuration.setGenerateRulesForImportedModels(generateRulesForImports.getSelection());
		
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
		
		configuration.setModifierStyleForBooleanAttributes(modifierStyleForBooleanAttributes.getSelection());
		configuration.setModifierStyleForEnumAttributes(modifierStyleForEnumAttributes.getSelection());
		configuration.setQuoteStringAttributes(quoteStringAttributes.getSelection());
		if (stringQuote.getSelectionIndex() == 0) {
			configuration.setStringAttributeQuote("\"");
		}
		if (stringQuote.getSelectionIndex() == 1) {
			configuration.setStringAttributeQuote("'");
		}
		configuration.setQuoteIdentifierAttributes(quoteIdentifierAttributes.getSelection());
		if (identifierQuote.getSelectionIndex() == 0) {
			configuration.setIdentifierAttributeQuote("\"");
		}
		if (identifierQuote.getSelectionIndex() == 1) {
			configuration.setIdentifierAttributeQuote("'");
		}
		
		configuration.setIdentifiersWithDash(allowDashInIdentifiers.getSelection());
		configuration.setIdentifiersWithUnderscore(allowUnderscoreInIdentifiers.getSelection());
		configuration.setIdentifiersWithDigitsFirst(allowIdentifiersStartingWithDigits.getSelection());
		
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
			EMFTextSDKPlugin.logError("Exception while printing syntax for preview.", e);
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

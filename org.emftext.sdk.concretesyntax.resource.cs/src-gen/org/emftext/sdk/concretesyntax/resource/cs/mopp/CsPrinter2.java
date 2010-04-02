/*******************************************************************************
 * Copyright (c) 2006-2010 
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

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

public class CsPrinter2 implements org.emftext.sdk.concretesyntax.resource.cs.ICsTextPrinter {
	
	public final static java.lang.String NEW_LINE = java.lang.System.getProperties().getProperty("line.separator");
	// Holds the resource that is associated with this printer. may be null if the printer is used stand alone.
	private org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource resource;
	private java.io.PrintWriter writer;
	private java.util.Map<?, ?> options;
	private org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolverFactory tokenResolverFactory = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenResolverFactory();
	private boolean startedPrintingElement = false;
	
	public CsPrinter2(java.io.OutputStream outputStream, org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource resource) {
		super();
		this.writer = new java.io.PrintWriter(new java.io.BufferedOutputStream(outputStream));
		this.resource = resource;
	}
	
	public void print(org.eclipse.emf.ecore.EObject element) throws java.io.IOException {
		doPrint(element);
		writer.flush();
	}
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element) {
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (writer == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		startedPrintingElement = true;
		if (element instanceof org.emftext.sdk.concretesyntax.ConcreteSyntax) {
			print_org_emftext_sdk_concretesyntax_ConcreteSyntax((org.emftext.sdk.concretesyntax.ConcreteSyntax) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.Import) {
			print_org_emftext_sdk_concretesyntax_Import((org.emftext.sdk.concretesyntax.Import) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.Option) {
			print_org_emftext_sdk_concretesyntax_Option((org.emftext.sdk.concretesyntax.Option) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.Rule) {
			print_org_emftext_sdk_concretesyntax_Rule((org.emftext.sdk.concretesyntax.Rule) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.Sequence) {
			print_org_emftext_sdk_concretesyntax_Sequence((org.emftext.sdk.concretesyntax.Sequence) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.Choice) {
			print_org_emftext_sdk_concretesyntax_Choice((org.emftext.sdk.concretesyntax.Choice) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.CsString) {
			print_org_emftext_sdk_concretesyntax_CsString((org.emftext.sdk.concretesyntax.CsString) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken) {
			print_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken((org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken) {
			print_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken((org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.PlaceholderInQuotes) {
			print_org_emftext_sdk_concretesyntax_PlaceholderInQuotes((org.emftext.sdk.concretesyntax.PlaceholderInQuotes) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.Containment) {
			print_org_emftext_sdk_concretesyntax_Containment((org.emftext.sdk.concretesyntax.Containment) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.CompoundDefinition) {
			print_org_emftext_sdk_concretesyntax_CompoundDefinition((org.emftext.sdk.concretesyntax.CompoundDefinition) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.WhiteSpaces) {
			print_org_emftext_sdk_concretesyntax_WhiteSpaces((org.emftext.sdk.concretesyntax.WhiteSpaces) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.LineBreak) {
			print_org_emftext_sdk_concretesyntax_LineBreak((org.emftext.sdk.concretesyntax.LineBreak) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.NormalTokenDefinition) {
			print_org_emftext_sdk_concretesyntax_NormalTokenDefinition((org.emftext.sdk.concretesyntax.NormalTokenDefinition) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.PartialTokenDefinition) {
			print_org_emftext_sdk_concretesyntax_PartialTokenDefinition((org.emftext.sdk.concretesyntax.PartialTokenDefinition) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.TokenPriorityDirective) {
			print_org_emftext_sdk_concretesyntax_TokenPriorityDirective((org.emftext.sdk.concretesyntax.TokenPriorityDirective) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.AtomicRegex) {
			print_org_emftext_sdk_concretesyntax_AtomicRegex((org.emftext.sdk.concretesyntax.AtomicRegex) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.RegexReference) {
			print_org_emftext_sdk_concretesyntax_RegexReference((org.emftext.sdk.concretesyntax.RegexReference) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.PLUS) {
			print_org_emftext_sdk_concretesyntax_PLUS((org.emftext.sdk.concretesyntax.PLUS) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.STAR) {
			print_org_emftext_sdk_concretesyntax_STAR((org.emftext.sdk.concretesyntax.STAR) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.QUESTIONMARK) {
			print_org_emftext_sdk_concretesyntax_QUESTIONMARK((org.emftext.sdk.concretesyntax.QUESTIONMARK) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.Abstract) {
			print_org_emftext_sdk_concretesyntax_Abstract((org.emftext.sdk.concretesyntax.Abstract) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.TokenStyle) {
			print_org_emftext_sdk_concretesyntax_TokenStyle((org.emftext.sdk.concretesyntax.TokenStyle) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.Annotation) {
			print_org_emftext_sdk_concretesyntax_Annotation((org.emftext.sdk.concretesyntax.Annotation) element);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.KeyValuePair) {
			print_org_emftext_sdk_concretesyntax_KeyValuePair((org.emftext.sdk.concretesyntax.KeyValuePair) element);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	public void print_org_emftext_sdk_concretesyntax_ConcreteSyntax(org.emftext.sdk.concretesyntax.ConcreteSyntax eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_Import(org.emftext.sdk.concretesyntax.Import eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_Option(org.emftext.sdk.concretesyntax.Option eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_2);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_Rule(org.emftext.sdk.concretesyntax.Rule eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_Sequence(org.emftext.sdk.concretesyntax.Sequence eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_4);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_Choice(org.emftext.sdk.concretesyntax.Choice eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_5);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_CsString(org.emftext.sdk.concretesyntax.CsString eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_6);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken(org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken(org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_PlaceholderInQuotes(org.emftext.sdk.concretesyntax.PlaceholderInQuotes eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_Containment(org.emftext.sdk.concretesyntax.Containment eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_CompoundDefinition(org.emftext.sdk.concretesyntax.CompoundDefinition eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_WhiteSpaces(org.emftext.sdk.concretesyntax.WhiteSpaces eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_12);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_LineBreak(org.emftext.sdk.concretesyntax.LineBreak eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_NormalTokenDefinition(org.emftext.sdk.concretesyntax.NormalTokenDefinition eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_PartialTokenDefinition(org.emftext.sdk.concretesyntax.PartialTokenDefinition eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_15);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_TokenPriorityDirective(org.emftext.sdk.concretesyntax.TokenPriorityDirective eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_16);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_AtomicRegex(org.emftext.sdk.concretesyntax.AtomicRegex eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_RegexReference(org.emftext.sdk.concretesyntax.RegexReference eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_PLUS(org.emftext.sdk.concretesyntax.PLUS eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_19);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_STAR(org.emftext.sdk.concretesyntax.STAR eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_20);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_QUESTIONMARK(org.emftext.sdk.concretesyntax.QUESTIONMARK eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_21);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_Abstract(org.emftext.sdk.concretesyntax.Abstract eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_22);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_TokenStyle(org.emftext.sdk.concretesyntax.TokenStyle eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_Annotation(org.emftext.sdk.concretesyntax.Annotation eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	public void print_org_emftext_sdk_concretesyntax_KeyValuePair(org.emftext.sdk.concretesyntax.KeyValuePair eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// we create a copy of the original list of layout information object in order
		// to be able to remove used informations
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_25);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	// creates a tree of decorator objects which reflects the syntax tree that is
	// attached to the given syntax element
	public org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator getDecoratorTree(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSyntaxElement syntaxElement) {
		org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSyntaxElement[] children = syntaxElement.getChildren();
		int childCount = children.length;
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator[] childDecorators = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator[childCount];
		for (int i = 0; i < childCount; i++) {
			childDecorators[i] = getDecoratorTree(children[i]);
		}
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decorator = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator(syntaxElement, childDecorators);
		return decorator;
	}
	
	public void decorateTree(org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = initializePrintCountingMap(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator> keywordsToPrint = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator>();
		decorateTreeBasic(decorator, eObject, printCountingMap, keywordsToPrint);
		for (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator keywordToPrint : keywordsToPrint) {
			// for keywords the concrete index does not matter, but we must add one to indicate that
			// the keyword needs to be printed here
			keywordToPrint.addIndexToPrint(0);
		}
	}
	
	// tries to decorate the decorator with an attribute value, or reference holds by eObject
	// returns true if an attribute value or reference was found
	public boolean decorateTreeBasic(org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap, java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator> keywordsToPrint) {
		boolean foundFeatureToPrint = false;
		org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSyntaxElement syntaxElement = decorator.getDecoratedElement();
		org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality cardinality = syntaxElement.getCardinality();
		boolean isFirstIteration = true;
		while (true) {
			java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator> subKeywordsToPrint = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator>();
			boolean keepDecorating = false;
			if (syntaxElement instanceof org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword) {
				subKeywordsToPrint.add(decorator);
			} else if (syntaxElement instanceof org.emftext.sdk.concretesyntax.resource.cs.grammar.CsTerminal) {
				org.emftext.sdk.concretesyntax.resource.cs.grammar.CsTerminal terminal = (org.emftext.sdk.concretesyntax.resource.cs.grammar.CsTerminal) syntaxElement;
				org.eclipse.emf.ecore.EStructuralFeature feature = terminal.getFeature();
				int countLeft = printCountingMap.get(feature.getName());
				if (countLeft > terminal.getMandatoryOccurencesAfter()) {
					decorator.addIndexToPrint(countLeft);
					printCountingMap.put(feature.getName(), countLeft - 1);
					keepDecorating = true;
				}
			}
			for (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator childDecorator : decorator.getChildDecorators()) {
				keepDecorating |= decorateTreeBasic(childDecorator, eObject, printCountingMap, subKeywordsToPrint);
				if (syntaxElement instanceof org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice) {
					break;
				}
			}
			foundFeatureToPrint |= keepDecorating;
			// we only print keywords if a feature was printed or the syntax element in mandatory
			if (cardinality == org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE) {
				keywordsToPrint.addAll(subKeywordsToPrint);
			} else if (cardinality == org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.PLUS) {
				if (isFirstIteration) {
					keywordsToPrint.addAll(subKeywordsToPrint);
				} else {
					if (keepDecorating) {
						keywordsToPrint.addAll(subKeywordsToPrint);
					}
				}
			} else if (keepDecorating && (cardinality == org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR || cardinality == org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.QUESTIONMARK)) {
				keywordsToPrint.addAll(subKeywordsToPrint);
			}
			if (cardinality == org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE || cardinality == org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.QUESTIONMARK) {
				break;
			} else if (!keepDecorating) {
				break;
			}
			isFirstIteration = false;
		}
		return foundFeatureToPrint;
	}
	
	public boolean printTree(org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject, java.util.List<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement> foundFormattingElements, java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations) {
		org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSyntaxElement printElement = decorator.getDecoratedElement();
		org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality cardinality = printElement.getCardinality();
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement> cloned = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>();
		cloned.addAll(foundFormattingElements);
		boolean foundSomethingAtAll = false;
		boolean foundSomethingToPrint;
		while (true) {
			foundSomethingToPrint = false;
			java.lang.Integer indexToPrint = decorator.getNextIndexToPrint();
			if (indexToPrint != null) {
				if (printElement instanceof org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword) {
					printKeyword(eObject, (org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword) printElement, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				} else if (printElement instanceof org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder) {
					org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder placeholder = (org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder) printElement;
					printFeature(eObject, placeholder, indexToPrint, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				} else if (printElement instanceof org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment) {
					org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment containment = (org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment) printElement;
					printContainedObject(eObject, containment, indexToPrint, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				}
			}
			if (foundSomethingToPrint) {
				foundSomethingAtAll = true;
			}
			if (printElement instanceof org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace) {
				foundFormattingElements.add((org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace) printElement);
			}
			if (printElement instanceof org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak) {
				foundFormattingElements.add((org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak) printElement);
			}
			for (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator childDecorator : decorator.getChildDecorators()) {
				foundSomethingToPrint |= printTree(childDecorator, eObject, foundFormattingElements, layoutInformations);
			}
			if (cardinality == org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE || cardinality == org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.QUESTIONMARK) {
				break;
			} else if (!foundSomethingToPrint) {
				break;
			}
		}
		// we only print formatting elements if a feature was printed or the syntax element in mandatory
		if (!foundSomethingAtAll && (cardinality == org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR || cardinality == org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.QUESTIONMARK)) {
			foundFormattingElements.clear();
			foundFormattingElements.addAll(cloned);
		}
		return foundSomethingToPrint;
	}
	
	public void printKeyword(org.eclipse.emf.ecore.EObject eObject, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword keyword, java.util.List<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement> foundFormattingElements, java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation layoutInformation = getLayoutInformation(layoutInformations, keyword, null, eObject);
		printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);
		writer.write(keyword.getValue());
	}
	
	public void printFeature(org.eclipse.emf.ecore.EObject eObject, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder placeholder, int count, java.util.List<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement> foundFormattingElements, java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations) {
		org.eclipse.emf.ecore.EStructuralFeature feature = placeholder.getFeature();
		if (feature instanceof org.eclipse.emf.ecore.EAttribute) {
			printAttribute(eObject, (org.eclipse.emf.ecore.EAttribute) feature, placeholder, count, foundFormattingElements, layoutInformations);
		} else {
			printReference(eObject, (org.eclipse.emf.ecore.EReference) feature, placeholder, count, foundFormattingElements, layoutInformations);
		}
	}
	
	public void printAttribute(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EAttribute attribute, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder placeholder, int count, java.util.List<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement> foundFormattingElements, java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations) {
		java.lang.String result;
		java.lang.Object attributeValue = getValue(eObject, attribute, count);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation layoutInformation = getLayoutInformation(layoutInformations, placeholder, attributeValue, eObject);
		java.lang.String visibleTokenText = getVisibleTokenText(layoutInformation);
		// if there is text for the attribute we use it
		if (visibleTokenText != null) {
			result = visibleTokenText;
		} else {
			// if no text is available, the attribute is deresolved to obtain its textual representation
			org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(placeholder.getTokenName());
			tokenResolver.setOptions(getOptions());
			java.lang.String deResolvedValue = tokenResolver.deResolve(attributeValue, attribute, eObject);
			result = deResolvedValue;
		}
		if (result != null && !"".equals(result)) {
			printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);
		}
		// write result
		writer.write(result);
	}
	
	public void printContainedObject(org.eclipse.emf.ecore.EObject eObject, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment containment, int count, java.util.List<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement> foundFormattingElements, java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations) {
		org.eclipse.emf.ecore.EStructuralFeature reference = containment.getFeature();
		java.lang.Object o = getValue(eObject, reference, count);
		doPrint((org.eclipse.emf.ecore.EObject) o);
	}
	
	public void printFormattingElements(java.util.List<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement> foundFormattingElements, java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation layoutInformation) {
		java.lang.String hiddenTokenText = getHiddenTokenText(layoutInformation);
		if (hiddenTokenText != null) {
			// removed used information
			layoutInformations.remove(layoutInformation);
			writer.write(hiddenTokenText);
			foundFormattingElements.clear();
			startedPrintingElement = false;
			return;
		}
		if (foundFormattingElements.size() > 0) {
			for (org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement foundFormattingElement : foundFormattingElements) {
				if (foundFormattingElement instanceof org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace) {
					int amount = ((org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace) foundFormattingElement).getAmount();
					for (int i = 0; i < amount; i++) {
						writer.write(" ");
					}
				}
				if (foundFormattingElement instanceof org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak) {
					int tabs = ((org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak) foundFormattingElement).getTabs();
					writer.write(NEW_LINE);
					for (int i = 0; i < tabs; i++) {
						writer.write("\t");
					}
				}
			}
			foundFormattingElements.clear();
			startedPrintingElement = false;
		} else {
			if (startedPrintingElement) {
				startedPrintingElement = false;
			} else {
				writer.write("");
			}
		}
	}
	
	private Object getValue(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EStructuralFeature feature, int count) {
		// get value of reference
		java.lang.Object o = eObject.eGet(feature);
		if (o instanceof java.util.List<?>) {
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			o = list.get(index);
		}
		return o;
	}
	
	public void printReference(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EReference reference, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder placeholder, int count, java.util.List<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement> foundFormattingElements, java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations) {
		java.lang.Object referencedObject = getValue(eObject, reference, count);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation layoutInformation = getLayoutInformation(layoutInformations, placeholder, referencedObject, eObject);
		printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);
		// nc-references must always be printed by deresolving the reference
		// we cannot use the visible token information, because deresolving
		// usually depends on attribute of the reference object instead of the
		// object itself
		org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(placeholder.getTokenName());
		tokenResolver.setOptions(getOptions());
		org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver referenceResolver = getReferenceResolverSwitch().getResolver(reference);
		referenceResolver.setOptions(getOptions());
		java.lang.String deresolvedReference = referenceResolver.deResolve((org.eclipse.emf.ecore.EObject) referencedObject, eObject, reference);
		java.lang.String deresolvedToken = tokenResolver.deResolve(deresolvedReference, reference, eObject);
		// write result
		writer.write(deresolvedToken);
	}
	
	public java.util.Map<java.lang.String, java.lang.Integer> initializePrintCountingMap(org.eclipse.emf.ecore.EObject eObject) {
		// the printCountingMap contains a mapping from feature names to
		// the number of remaining elements that still need to be printed.
		// the map is initialized with the number of elements stored in each structural
		// feature. for lists this is the list size. for non-multiple features it is either
		// 1 (if the feature is set) or 0 (if the feature is null).
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.LinkedHashMap<java.lang.String, java.lang.Integer>();
		java.util.List<org.eclipse.emf.ecore.EStructuralFeature> features = eObject.eClass().getEAllStructuralFeatures();
		for (org.eclipse.emf.ecore.EStructuralFeature feature : features) {
			int count = 0;
			java.lang.Object featureValue = eObject.eGet(feature);
			if (featureValue != null) {
				if (featureValue instanceof java.util.List<?>) {
					count = ((java.util.List<?>) featureValue).size();
				} else {
					count = 1;
				}
			}
			printCountingMap.put(feature.getName(), count);
		}
		return printCountingMap;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource getResource() {
		return resource;
	}
	
	protected org.emftext.sdk.concretesyntax.resource.cs.mopp.CsReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsReferenceResolverSwitch) new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final java.lang.String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsProblem(errorMessage, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType.ERROR), cause);
	}
	
	protected org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter getLayoutInformationAdapter(org.eclipse.emf.ecore.EObject element) {
		for (org.eclipse.emf.common.notify.Adapter adapter : element.eAdapters()) {
			if (adapter instanceof org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter) {
				return (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter) adapter;
			}
		}
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter newAdapter = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter();
		element.eAdapters().add(newAdapter);
		return newAdapter;
	}
	
	private org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation getLayoutInformation(java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSyntaxElement syntaxElement, java.lang.Object object, org.eclipse.emf.ecore.EObject container) {
		for (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation layoutInformation : layoutInformations) {
			if (syntaxElement == layoutInformation.getSyntaxElement()) {
				if (object == null) {
					return layoutInformation;
				} else if (object == layoutInformation.getObject(container)) {
					return layoutInformation;
				}
			}
		}
		return null;
	}
	
	private java.lang.String getHiddenTokenText(org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation layoutInformation) {
		if (layoutInformation != null) {
			return layoutInformation.getHiddenTokenText();
		} else {
			return null;
		}
	}
	
	private java.lang.String getVisibleTokenText(org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation layoutInformation) {
		if (layoutInformation != null) {
			return layoutInformation.getVisibleTokenText();
		} else {
			return null;
		}
	}
	
}

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
	
	private class PrintToken {
		
		private String text;
		private String tokenName;
		
		public PrintToken(String text, String tokenName) {
			this.text = text;
			this.tokenName = tokenName;
		}
		
		public String getText() {
			return text;
		}
		
		public String getTokenName() {
			return tokenName;
		}
		
	}
	
	public final static java.lang.String NEW_LINE = java.lang.System.getProperties().getProperty("line.separator");
	
	/**
	 * Holds the resource that is associated with this printer. May be null if the
	 * printer is used stand alone.
	 */
	private org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource resource;
	
	private java.util.Map<?, ?> options;
	private java.io.OutputStream outputStream;
	private java.util.List<PrintToken> tokenOutputStream;
	private org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolverFactory tokenResolverFactory = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenResolverFactory();
	private boolean handleTokenSpaceAutomatically = false;
	private int tokenSpace = 0;
	private boolean startedPrintingElement = false;
	
	public CsPrinter2(java.io.OutputStream outputStream, org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	public void print(org.eclipse.emf.ecore.EObject element) throws java.io.IOException {
		tokenOutputStream = new java.util.ArrayList<PrintToken>();
		doPrint(element);
		java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.BufferedOutputStream(outputStream));
		if (handleTokenSpaceAutomatically) {
			printSmart(writer);
		} else {
			printBasic(writer);
		}
		writer.flush();
	}
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element) {
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (outputStream == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		startedPrintingElement = true;
		if (element instanceof org.emftext.sdk.concretesyntax.ConcreteSyntax) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.Import) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.Option) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_2);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.Rule) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.Sequence) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_4);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.Choice) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_5);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.CsString) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_6);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.PlaceholderInQuotes) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.Containment) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.CompoundDefinition) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.WhiteSpaces) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_12);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.LineBreak) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.NormalTokenDefinition) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.PartialTokenDefinition) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_15);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.TokenPriorityDirective) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_16);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.AtomicRegex) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.RegexReference) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.PLUS) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_19);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.STAR) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_20);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.QUESTIONMARK) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_21);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.Abstract) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_22);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.TokenStyle) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.Annotation) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.KeyValuePair) {
			printInternal(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_25);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	public void printInternal(org.eclipse.emf.ecore.EObject eObject, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSyntaxElement ruleElement) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// create a copy of the original list of layout information object in order to be
		// able to remove used informations during printing
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxElementDecorator decoratorTree = getDecoratorTree(ruleElement);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement>(), layoutInformations);
	}
	
	/**
	 * creates a tree of decorator objects which reflects the syntax tree that is
	 * attached to the given syntax element
	 */
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
			// for keywords the concrete index does not matter, but we must add one to
			// indicate that the keyword needs to be printed here. Thus, we use 0 as index.
			keywordToPrint.addIndexToPrint(0);
		}
	}
	
	/**
	 * Tries to decorate the decorator with an attribute value, or reference holded by
	 * eObject. Returns true if an attribute value or reference was found.
	 */
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
			// only print keywords if a feature was printed or the syntax element is mandatory
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
		// only print formatting elements if a feature was printed or the syntax element
		// is mandatory
		if (!foundSomethingAtAll && (cardinality == org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR || cardinality == org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.QUESTIONMARK)) {
			foundFormattingElements.clear();
			foundFormattingElements.addAll(cloned);
		}
		return foundSomethingToPrint;
	}
	
	public void printKeyword(org.eclipse.emf.ecore.EObject eObject, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword keyword, java.util.List<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement> foundFormattingElements, java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation layoutInformation = getLayoutInformation(layoutInformations, keyword, null, eObject);
		printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);
		String value = keyword.getValue();
		tokenOutputStream.add(new PrintToken(value, "'" + value + "'"));
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
			// if no text is available, the attribute is deresolved to obtain its textual
			// representation
			org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(placeholder.getTokenName());
			tokenResolver.setOptions(getOptions());
			java.lang.String deResolvedValue = tokenResolver.deResolve(attributeValue, attribute, eObject);
			result = deResolvedValue;
		}
		if (result != null && !"".equals(result)) {
			printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);
		}
		// write result to the output stream
		tokenOutputStream.add(new PrintToken(result, placeholder.getTokenName()));
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
			tokenOutputStream.add(new PrintToken(hiddenTokenText, null));
			foundFormattingElements.clear();
			startedPrintingElement = false;
			return;
		}
		if (foundFormattingElements.size() > 0) {
			for (org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement foundFormattingElement : foundFormattingElements) {
				if (foundFormattingElement instanceof org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace) {
					int amount = ((org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace) foundFormattingElement).getAmount();
					for (int i = 0; i < amount; i++) {
						tokenOutputStream.add(new PrintToken(" ", null));
					}
				}
				if (foundFormattingElement instanceof org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak) {
					int tabs = ((org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak) foundFormattingElement).getTabs();
					tokenOutputStream.add(new PrintToken(NEW_LINE, null));
					for (int i = 0; i < tabs; i++) {
						tokenOutputStream.add(new PrintToken("\t", null));
					}
				}
			}
			foundFormattingElements.clear();
			startedPrintingElement = false;
		} else {
			if (startedPrintingElement) {
				startedPrintingElement = false;
			} else {
				if (!handleTokenSpaceAutomatically) {
					tokenOutputStream.add(new PrintToken(getWhiteSpaceString(tokenSpace), null));
				}
			}
		}
	}
	
	private Object getValue(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EStructuralFeature feature, int count) {
		// get value of feature
		java.lang.Object o = eObject.eGet(feature);
		if (o instanceof java.util.List<?>) {
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			o = list.get(index);
		}
		return o;
	}
	
	@SuppressWarnings("unchecked")	
	public void printReference(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EReference reference, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder placeholder, int count, java.util.List<org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFormattingElement> foundFormattingElements, java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation> layoutInformations) {
		java.lang.Object referencedObject = getValue(eObject, reference, count);
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation layoutInformation = getLayoutInformation(layoutInformations, placeholder, referencedObject, eObject);
		printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);
		// NC-References must always be printed by deresolving the reference. We cannot
		// use the visible token information, because deresolving usually depends on
		// attribute values of the referenced object instead of the object itself.
		String tokenName = placeholder.getTokenName();
		org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);
		tokenResolver.setOptions(getOptions());
		org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver referenceResolver = getReferenceResolverSwitch().getResolver(reference);
		referenceResolver.setOptions(getOptions());
		java.lang.String deresolvedReference = referenceResolver.deResolve((org.eclipse.emf.ecore.EObject) referencedObject, eObject, reference);
		java.lang.String deresolvedToken = tokenResolver.deResolve(deresolvedReference, reference, eObject);
		// write result to output stream
		tokenOutputStream.add(new PrintToken(deresolvedToken, tokenName));
	}
	
	public java.util.Map<java.lang.String, java.lang.Integer> initializePrintCountingMap(org.eclipse.emf.ecore.EObject eObject) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
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
	
	protected String getWhiteSpaceString(int count) {
		return getRepeatingString(count, ' ');
	}
	
	private String getRepeatingString(int count, char character) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < count; i++) {
			result.append(character);
		}
		return result.toString();
	}
	
	public void setHandleTokenSpaceAutomatically(boolean handleTokenSpaceAutomatically) {
		this.handleTokenSpaceAutomatically = handleTokenSpaceAutomatically;
	}
	
	public void setTokenSpace(int tokenSpace) {
		this.tokenSpace = tokenSpace;
	}
	
	/**
	 * Prints the current tokenOutputStream to the given writer (as it is).
	 */
	public void printBasic(java.io.PrintWriter writer) throws java.io.IOException {
		for (PrintToken nextToken : tokenOutputStream) {
			writer.write(nextToken.getText());
		}
	}
	
	/**
	 * Prints the current tokenOutputStream to the given writer.
	 * 
	 * This methods implements smart whitespace printing. It does so by writing output
	 * to a token stream instead of printing the raw token text to a PrintWriter.
	 * Tokens in this stream hold both the text and the type of the token (i.e., its
	 * name).
	 * 
	 * To decide where whitespace is needed, sequences of successive tokens are
	 * searched that can be printed without separating whitespace. To determine such
	 * groups we start with two successive non-whitespace tokens, concatenate their
	 * text and use the generated ANTLR lexer to split the text. If the resulting
	 * token sequence of the concatenated text is exactly the same as the one that is
	 * to be printed, no whitespace is needed. The tokens in the sequence are checked
	 * both regarding their type and their text. If two tokens successfully form a
	 * group a third one is added and so on.
	 */
	public void printSmart(java.io.PrintWriter writer) throws java.io.IOException {
		// stores the text of the current group of tokens. this text is given to the lexer
		// to check whether it can be correctly scanned.
		StringBuilder currentBlock = new StringBuilder();
		// stores the index of the first token of the current group.
		int currentBlockStart = 0;
		// stores the text that was already successfully checked (i.e., is can be scanned
		// correctly and can thus be printed).
		String validBlock = "";
		for (int i = 0; i < tokenOutputStream.size(); i++) {
			PrintToken tokenI = tokenOutputStream.get(i);
			currentBlock.append(tokenI.getText());
			// if declared or preserved whitespace is found - print block
			if (tokenI.getTokenName() == null) {
				writer.write(currentBlock.toString());
				// reset all values
				currentBlock = new StringBuilder();
				currentBlockStart = i + 1;
				validBlock = "";
				continue;
			}
			// now check whether the current block can be scanned
			org.emftext.sdk.concretesyntax.resource.cs.ICsTextScanner scanner = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation().createLexer();
			scanner.setText(currentBlock.toString());
			// retrieve all tokens from scanner and add them to list 'tempTokens'
			java.util.List<org.emftext.sdk.concretesyntax.resource.cs.ICsTextToken> tempTokens = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.ICsTextToken>();
			org.emftext.sdk.concretesyntax.resource.cs.ICsTextToken nextToken = scanner.getNextToken();
			while (nextToken != null) {
				tempTokens.add(nextToken);
			}
			boolean sequenceIsValid = true;
			// check whether the current block was scanned to the same token sequence
			for (int t = 0; t < tempTokens.size(); t++) {
				PrintToken printTokenT = tokenOutputStream.get(currentBlockStart + t);
				org.emftext.sdk.concretesyntax.resource.cs.ICsTextToken tempToken = tempTokens.get(t);
				if (!tempToken.getText().equals(printTokenT.getText())) {
					sequenceIsValid = false;
					break;
				}
				String commonTokenName = tempToken.getName();
				if (!commonTokenName.equals(printTokenT.getTokenName())) {
					sequenceIsValid = false;
					break;
				}
			}
			if (sequenceIsValid) {
				// sequence is still valid, try adding one more token in the next iteration of the
				// loop
				validBlock += tokenI.getText();
			} else {
				// sequence is not valid, must print whitespace to separate tokens
				// print text that is valid so far
				writer.write(validBlock);
				// print separating whitespace
				writer.write(" ");
				// add current token as initial value for next iteration
				currentBlock = new StringBuilder(tokenI.getText());
				currentBlockStart = i;
				validBlock = tokenI.getText();
			}
		}
		// flush remaining valid text to writer
		writer.write(validBlock);
	}
	
}

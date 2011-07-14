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

package org.emftext.sdk.concretesyntax.resource.cs.util;

/**
 * This class provides basic infrastructure to interpret models. To implement
 * concrete interpreters, subclass this abstract interpreter and override the
 * interprete_* methods. The interpretation can be customized by binding the two
 * type parameters (ResultType, ContextType). The former is returned by all
 * interprete_* methods, while the latter is passed from method to method while
 * traversing the model. The concrete traversal strategy can also be exchanged.
 * One can use a static traversal strategy by pushing all objects to interpret on
 * the interpretation stack (using addObjectToInterprete()) before calling
 * interprete(). Alternatively, the traversal strategy can be dynamic by pushing
 * objects on the interpretation stack during interpretation.
 */
public class AbstractCsInterpreter<ResultType, ContextType> {
	
	private java.util.Stack<org.eclipse.emf.ecore.EObject> interpretationStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	private java.util.List<org.emftext.sdk.concretesyntax.resource.cs.ICsInterpreterListener> listeners = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.ICsInterpreterListener>();
	private org.eclipse.emf.ecore.EObject nextObjectToInterprete;
	private Object currentContext;
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		org.eclipse.emf.ecore.EObject next = null;
		currentContext = context;
		while (!interpretationStack.empty()) {
			try {
				next = interpretationStack.pop();
			} catch (java.util.EmptyStackException ese) {
				// this can happen when the interpreter was terminated between the call to empty()
				// and pop()
				break;
			}
			nextObjectToInterprete = next;
			notifyListeners(next);
			result = interprete(next, context);
			if (!continueInterpretation(context, result)) {
				break;
			}
		}
		currentContext = null;
		return result;
	}
	
	/**
	 * Override this method to stop the overall interpretation depending on the result
	 * of the interpretation of a single model elements.
	 */
	public boolean continueInterpretation(ContextType context, ResultType result) {
		return true;
	}
	
	public ResultType interprete(org.eclipse.emf.ecore.EObject object, ContextType context) {
		ResultType result = null;
		if (object instanceof org.emftext.sdk.concretesyntax.DefaultTokenStyleAdder) {
			result = interprete_org_emftext_sdk_concretesyntax_DefaultTokenStyleAdder((org.emftext.sdk.concretesyntax.DefaultTokenStyleAdder) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.EClassUtil) {
			result = interprete_org_emftext_sdk_concretesyntax_EClassUtil((org.emftext.sdk.concretesyntax.EClassUtil) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof java.util.Map.Entry<?,?>) {
			result = interprete_java_util_Map_Entry((java.util.Map.Entry<?,?>) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.GenClassCache) {
			result = interprete_org_emftext_sdk_concretesyntax_GenClassCache((org.emftext.sdk.concretesyntax.GenClassCache) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.KeyValuePair) {
			result = interprete_org_emftext_sdk_concretesyntax_KeyValuePair((org.emftext.sdk.concretesyntax.KeyValuePair) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.Annotable) {
			result = interprete_org_emftext_sdk_concretesyntax_Annotable((org.emftext.sdk.concretesyntax.Annotable) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.Annotation) {
			result = interprete_org_emftext_sdk_concretesyntax_Annotation((org.emftext.sdk.concretesyntax.Annotation) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.TokenStyle) {
			result = interprete_org_emftext_sdk_concretesyntax_TokenStyle((org.emftext.sdk.concretesyntax.TokenStyle) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.Option) {
			result = interprete_org_emftext_sdk_concretesyntax_Option((org.emftext.sdk.concretesyntax.Option) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.EnumLiteralTerminal) {
			result = interprete_org_emftext_sdk_concretesyntax_EnumLiteralTerminal((org.emftext.sdk.concretesyntax.EnumLiteralTerminal) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.EnumTerminal) {
			result = interprete_org_emftext_sdk_concretesyntax_EnumTerminal((org.emftext.sdk.concretesyntax.EnumTerminal) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.BooleanTerminal) {
			result = interprete_org_emftext_sdk_concretesyntax_BooleanTerminal((org.emftext.sdk.concretesyntax.BooleanTerminal) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.PlaceholderInQuotes) {
			result = interprete_org_emftext_sdk_concretesyntax_PlaceholderInQuotes((org.emftext.sdk.concretesyntax.PlaceholderInQuotes) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken) {
			result = interprete_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken((org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken) {
			result = interprete_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken((org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.Placeholder) {
			result = interprete_org_emftext_sdk_concretesyntax_Placeholder((org.emftext.sdk.concretesyntax.Placeholder) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.Containment) {
			result = interprete_org_emftext_sdk_concretesyntax_Containment((org.emftext.sdk.concretesyntax.Containment) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.TokenPriorityDirective) {
			result = interprete_org_emftext_sdk_concretesyntax_TokenPriorityDirective((org.emftext.sdk.concretesyntax.TokenPriorityDirective) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.QuotedTokenDefinition) {
			result = interprete_org_emftext_sdk_concretesyntax_QuotedTokenDefinition((org.emftext.sdk.concretesyntax.QuotedTokenDefinition) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.TokenRedefinition) {
			result = interprete_org_emftext_sdk_concretesyntax_TokenRedefinition((org.emftext.sdk.concretesyntax.TokenRedefinition) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.NormalTokenDefinition) {
			result = interprete_org_emftext_sdk_concretesyntax_NormalTokenDefinition((org.emftext.sdk.concretesyntax.NormalTokenDefinition) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.CompleteTokenDefinition) {
			result = interprete_org_emftext_sdk_concretesyntax_CompleteTokenDefinition((org.emftext.sdk.concretesyntax.CompleteTokenDefinition) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.PartialTokenDefinition) {
			result = interprete_org_emftext_sdk_concretesyntax_PartialTokenDefinition((org.emftext.sdk.concretesyntax.PartialTokenDefinition) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.ReferencableTokenDefinition) {
			result = interprete_org_emftext_sdk_concretesyntax_ReferencableTokenDefinition((org.emftext.sdk.concretesyntax.ReferencableTokenDefinition) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.NamedTokenDefinition) {
			result = interprete_org_emftext_sdk_concretesyntax_NamedTokenDefinition((org.emftext.sdk.concretesyntax.NamedTokenDefinition) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.AbstractTokenDefinition) {
			result = interprete_org_emftext_sdk_concretesyntax_AbstractTokenDefinition((org.emftext.sdk.concretesyntax.AbstractTokenDefinition) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.TokenDirective) {
			result = interprete_org_emftext_sdk_concretesyntax_TokenDirective((org.emftext.sdk.concretesyntax.TokenDirective) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.RegexReference) {
			result = interprete_org_emftext_sdk_concretesyntax_RegexReference((org.emftext.sdk.concretesyntax.RegexReference) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.AtomicRegex) {
			result = interprete_org_emftext_sdk_concretesyntax_AtomicRegex((org.emftext.sdk.concretesyntax.AtomicRegex) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.RegexComposite) {
			result = interprete_org_emftext_sdk_concretesyntax_RegexComposite((org.emftext.sdk.concretesyntax.RegexComposite) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.RegexPart) {
			result = interprete_org_emftext_sdk_concretesyntax_RegexPart((org.emftext.sdk.concretesyntax.RegexPart) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.RegexOwner) {
			result = interprete_org_emftext_sdk_concretesyntax_RegexOwner((org.emftext.sdk.concretesyntax.RegexOwner) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.RegexComposer) {
			result = interprete_org_emftext_sdk_concretesyntax_RegexComposer((org.emftext.sdk.concretesyntax.RegexComposer) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.CompoundDefinition) {
			result = interprete_org_emftext_sdk_concretesyntax_CompoundDefinition((org.emftext.sdk.concretesyntax.CompoundDefinition) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.LineBreak) {
			result = interprete_org_emftext_sdk_concretesyntax_LineBreak((org.emftext.sdk.concretesyntax.LineBreak) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.WhiteSpaces) {
			result = interprete_org_emftext_sdk_concretesyntax_WhiteSpaces((org.emftext.sdk.concretesyntax.WhiteSpaces) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.CsString) {
			result = interprete_org_emftext_sdk_concretesyntax_CsString((org.emftext.sdk.concretesyntax.CsString) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.Terminal) {
			result = interprete_org_emftext_sdk_concretesyntax_Terminal((org.emftext.sdk.concretesyntax.Terminal) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.CardinalityDefinition) {
			result = interprete_org_emftext_sdk_concretesyntax_CardinalityDefinition((org.emftext.sdk.concretesyntax.CardinalityDefinition) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.Definition) {
			result = interprete_org_emftext_sdk_concretesyntax_Definition((org.emftext.sdk.concretesyntax.Definition) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.Sequence) {
			result = interprete_org_emftext_sdk_concretesyntax_Sequence((org.emftext.sdk.concretesyntax.Sequence) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.Choice) {
			result = interprete_org_emftext_sdk_concretesyntax_Choice((org.emftext.sdk.concretesyntax.Choice) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.Rule) {
			result = interprete_org_emftext_sdk_concretesyntax_Rule((org.emftext.sdk.concretesyntax.Rule) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.SyntaxElement) {
			result = interprete_org_emftext_sdk_concretesyntax_SyntaxElement((org.emftext.sdk.concretesyntax.SyntaxElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.Import) {
			result = interprete_org_emftext_sdk_concretesyntax_Import((org.emftext.sdk.concretesyntax.Import) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.ConcreteSyntax) {
			result = interprete_org_emftext_sdk_concretesyntax_ConcreteSyntax((org.emftext.sdk.concretesyntax.ConcreteSyntax) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.GenPackageDependentElement) {
			result = interprete_org_emftext_sdk_concretesyntax_GenPackageDependentElement((org.emftext.sdk.concretesyntax.GenPackageDependentElement) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_GenPackageDependentElement(org.emftext.sdk.concretesyntax.GenPackageDependentElement object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_ConcreteSyntax(org.emftext.sdk.concretesyntax.ConcreteSyntax object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Import(org.emftext.sdk.concretesyntax.Import object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_SyntaxElement(org.emftext.sdk.concretesyntax.SyntaxElement object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Rule(org.emftext.sdk.concretesyntax.Rule object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Choice(org.emftext.sdk.concretesyntax.Choice object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Sequence(org.emftext.sdk.concretesyntax.Sequence object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Definition(org.emftext.sdk.concretesyntax.Definition object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_CardinalityDefinition(org.emftext.sdk.concretesyntax.CardinalityDefinition object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Terminal(org.emftext.sdk.concretesyntax.Terminal object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_CsString(org.emftext.sdk.concretesyntax.CsString object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_WhiteSpaces(org.emftext.sdk.concretesyntax.WhiteSpaces object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_LineBreak(org.emftext.sdk.concretesyntax.LineBreak object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_CompoundDefinition(org.emftext.sdk.concretesyntax.CompoundDefinition object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_RegexComposer(org.emftext.sdk.concretesyntax.RegexComposer object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_RegexOwner(org.emftext.sdk.concretesyntax.RegexOwner object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_RegexPart(org.emftext.sdk.concretesyntax.RegexPart object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_RegexComposite(org.emftext.sdk.concretesyntax.RegexComposite object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_AtomicRegex(org.emftext.sdk.concretesyntax.AtomicRegex object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_RegexReference(org.emftext.sdk.concretesyntax.RegexReference object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_TokenDirective(org.emftext.sdk.concretesyntax.TokenDirective object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_AbstractTokenDefinition(org.emftext.sdk.concretesyntax.AbstractTokenDefinition object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_NamedTokenDefinition(org.emftext.sdk.concretesyntax.NamedTokenDefinition object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_ReferencableTokenDefinition(org.emftext.sdk.concretesyntax.ReferencableTokenDefinition object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_PartialTokenDefinition(org.emftext.sdk.concretesyntax.PartialTokenDefinition object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_CompleteTokenDefinition(org.emftext.sdk.concretesyntax.CompleteTokenDefinition object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_NormalTokenDefinition(org.emftext.sdk.concretesyntax.NormalTokenDefinition object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_TokenRedefinition(org.emftext.sdk.concretesyntax.TokenRedefinition object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_QuotedTokenDefinition(org.emftext.sdk.concretesyntax.QuotedTokenDefinition object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_TokenPriorityDirective(org.emftext.sdk.concretesyntax.TokenPriorityDirective object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Containment(org.emftext.sdk.concretesyntax.Containment object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Placeholder(org.emftext.sdk.concretesyntax.Placeholder object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken(org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken(org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_PlaceholderInQuotes(org.emftext.sdk.concretesyntax.PlaceholderInQuotes object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_BooleanTerminal(org.emftext.sdk.concretesyntax.BooleanTerminal object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_EnumTerminal(org.emftext.sdk.concretesyntax.EnumTerminal object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_EnumLiteralTerminal(org.emftext.sdk.concretesyntax.EnumLiteralTerminal object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Option(org.emftext.sdk.concretesyntax.Option object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_TokenStyle(org.emftext.sdk.concretesyntax.TokenStyle object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Annotation(org.emftext.sdk.concretesyntax.Annotation object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Annotable(org.emftext.sdk.concretesyntax.Annotable object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_KeyValuePair(org.emftext.sdk.concretesyntax.KeyValuePair object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_GenClassCache(org.emftext.sdk.concretesyntax.GenClassCache object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_java_util_Map_Entry(java.util.Map.Entry<?,?> object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_EClassUtil(org.emftext.sdk.concretesyntax.EClassUtil object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_DefaultTokenStyleAdder(org.emftext.sdk.concretesyntax.DefaultTokenStyleAdder object, ContextType context) {
		return null;
	}
	
	private void notifyListeners(org.eclipse.emf.ecore.EObject element) {
		for (org.emftext.sdk.concretesyntax.resource.cs.ICsInterpreterListener listener : listeners) {
			listener.handleInterpreteObject(element);
		}
	}
	/**
	 * Adds the given object to the interpretation stack. Attention: Objects that are
	 * added first, are interpret last.
	 */
	public void addObjectToInterprete(org.eclipse.emf.ecore.EObject object) {
		interpretationStack.push(object);
	}
	
	/**
	 * Adds the given collection of objects to the interpretation stack. Attention:
	 * Collections that are added first, are interpret last.
	 */
	public void addObjectsToInterprete(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		for (org.eclipse.emf.ecore.EObject object : objects) {
			addObjectToInterprete(object);
		}
	}
	
	/**
	 * Adds the given collection of objects in reverse order to the interpretation
	 * stack.
	 */
	public void addObjectsToInterpreteInReverseOrder(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		java.util.List<org.eclipse.emf.ecore.EObject> reverse = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>(objects.size());
		reverse.addAll(objects);
		java.util.Collections.reverse(reverse);
		addObjectsToInterprete(reverse);
	}
	
	/**
	 * Adds the given object and all its children to the interpretation stack such
	 * that they are interpret in top down order.
	 */
	public void addObjectTreeToInterpreteTopDown(org.eclipse.emf.ecore.EObject root) {
		java.util.List<org.eclipse.emf.ecore.EObject> objects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
		objects.add(root);
		java.util.Iterator<org.eclipse.emf.ecore.EObject> it = root.eAllContents();
		while (it.hasNext()) {
			org.eclipse.emf.ecore.EObject eObject = (org.eclipse.emf.ecore.EObject) it.next();
			objects.add(eObject);
		}
		addObjectsToInterpreteInReverseOrder(objects);
	}
	
	public void addListener(org.emftext.sdk.concretesyntax.resource.cs.ICsInterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(org.emftext.sdk.concretesyntax.resource.cs.ICsInterpreterListener listener) {
		return listeners.remove(listener);
	}
	
	public org.eclipse.emf.ecore.EObject getNextObjectToInterprete() {
		return nextObjectToInterprete;
	}
	
	public java.util.Stack<org.eclipse.emf.ecore.EObject> getInterpretationStack() {
		return interpretationStack;
	}
	
	public void terminate() {
		interpretationStack.clear();
	}
	
	public Object getCurrentContext() {
		return currentContext;
	}
	
}

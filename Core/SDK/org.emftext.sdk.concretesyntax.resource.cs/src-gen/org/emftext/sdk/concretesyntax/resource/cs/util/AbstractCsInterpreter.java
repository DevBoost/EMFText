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

package org.emftext.sdk.concretesyntax.resource.cs.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.concretesyntax.AbstractTokenDefinition;
import org.emftext.sdk.concretesyntax.Annotable;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.AtomicRegex;
import org.emftext.sdk.concretesyntax.BooleanTerminal;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.DefaultTokenStyleAdder;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.EClassUtil;
import org.emftext.sdk.concretesyntax.EnumLiteralTerminal;
import org.emftext.sdk.concretesyntax.EnumTerminal;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.concretesyntax.GenPackageDependentElement;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.KeyValuePair;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.NamedTokenDefinition;
import org.emftext.sdk.concretesyntax.NormalTokenDefinition;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.PartialTokenDefinition;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
import org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken;
import org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken;
import org.emftext.sdk.concretesyntax.QuotedTokenDefinition;
import org.emftext.sdk.concretesyntax.ReferencableTokenDefinition;
import org.emftext.sdk.concretesyntax.RegexComposer;
import org.emftext.sdk.concretesyntax.RegexComposite;
import org.emftext.sdk.concretesyntax.RegexOwner;
import org.emftext.sdk.concretesyntax.RegexPart;
import org.emftext.sdk.concretesyntax.RegexReference;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.SyntaxElement;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.TokenDirective;
import org.emftext.sdk.concretesyntax.TokenPriorityDirective;
import org.emftext.sdk.concretesyntax.TokenRedefinition;
import org.emftext.sdk.concretesyntax.TokenStyle;
import org.emftext.sdk.concretesyntax.WhiteSpaces;

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
	
	private Stack<EObject> interpretationStack = new Stack<EObject>();
	private List<org.emftext.sdk.concretesyntax.resource.cs.ICsInterpreterListener> listeners = new ArrayList<org.emftext.sdk.concretesyntax.resource.cs.ICsInterpreterListener>();
	private EObject nextObjectToInterprete;
	private Object currentContext;
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		EObject next = null;
		currentContext = context;
		while (!interpretationStack.empty()) {
			try {
				next = interpretationStack.pop();
			} catch (EmptyStackException ese) {
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
	
	public ResultType interprete(EObject object, ContextType context) {
		ResultType result = null;
		if (object instanceof org.emftext.sdk.concretesyntax.ConcreteSyntax) {
			result = interprete_org_emftext_sdk_concretesyntax_ConcreteSyntax((org.emftext.sdk.concretesyntax.ConcreteSyntax) object, context);
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
		if (object instanceof org.emftext.sdk.concretesyntax.GenPackageDependentElement) {
			result = interprete_org_emftext_sdk_concretesyntax_GenPackageDependentElement((org.emftext.sdk.concretesyntax.GenPackageDependentElement) object, context);
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
		if (object instanceof org.emftext.sdk.concretesyntax.Choice) {
			result = interprete_org_emftext_sdk_concretesyntax_Choice((org.emftext.sdk.concretesyntax.Choice) object, context);
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
		if (object instanceof org.emftext.sdk.concretesyntax.CsString) {
			result = interprete_org_emftext_sdk_concretesyntax_CsString((org.emftext.sdk.concretesyntax.CsString) object, context);
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
		if (object instanceof org.emftext.sdk.concretesyntax.LineBreak) {
			result = interprete_org_emftext_sdk_concretesyntax_LineBreak((org.emftext.sdk.concretesyntax.LineBreak) object, context);
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
		if (object instanceof org.emftext.sdk.concretesyntax.Definition) {
			result = interprete_org_emftext_sdk_concretesyntax_Definition((org.emftext.sdk.concretesyntax.Definition) object, context);
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
		if (object instanceof org.emftext.sdk.concretesyntax.RegexComposer) {
			result = interprete_org_emftext_sdk_concretesyntax_RegexComposer((org.emftext.sdk.concretesyntax.RegexComposer) object, context);
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
		if (object instanceof org.emftext.sdk.concretesyntax.RegexComposite) {
			result = interprete_org_emftext_sdk_concretesyntax_RegexComposite((org.emftext.sdk.concretesyntax.RegexComposite) object, context);
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
		if (object instanceof org.emftext.sdk.concretesyntax.RegexReference) {
			result = interprete_org_emftext_sdk_concretesyntax_RegexReference((org.emftext.sdk.concretesyntax.RegexReference) object, context);
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
		if (object instanceof org.emftext.sdk.concretesyntax.PartialTokenDefinition) {
			result = interprete_org_emftext_sdk_concretesyntax_PartialTokenDefinition((org.emftext.sdk.concretesyntax.PartialTokenDefinition) object, context);
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
		if (object instanceof org.emftext.sdk.concretesyntax.TokenRedefinition) {
			result = interprete_org_emftext_sdk_concretesyntax_TokenRedefinition((org.emftext.sdk.concretesyntax.TokenRedefinition) object, context);
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
		if (object instanceof org.emftext.sdk.concretesyntax.CompleteTokenDefinition) {
			result = interprete_org_emftext_sdk_concretesyntax_CompleteTokenDefinition((org.emftext.sdk.concretesyntax.CompleteTokenDefinition) object, context);
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
		if (object instanceof org.emftext.sdk.concretesyntax.TokenPriorityDirective) {
			result = interprete_org_emftext_sdk_concretesyntax_TokenPriorityDirective((org.emftext.sdk.concretesyntax.TokenPriorityDirective) object, context);
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
		if (object instanceof org.emftext.sdk.concretesyntax.Containment) {
			result = interprete_org_emftext_sdk_concretesyntax_Containment((org.emftext.sdk.concretesyntax.Containment) object, context);
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
		if (object instanceof org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken) {
			result = interprete_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken((org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken) object, context);
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
		if (object instanceof org.emftext.sdk.concretesyntax.Placeholder) {
			result = interprete_org_emftext_sdk_concretesyntax_Placeholder((org.emftext.sdk.concretesyntax.Placeholder) object, context);
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
		if (object instanceof org.emftext.sdk.concretesyntax.EnumTerminal) {
			result = interprete_org_emftext_sdk_concretesyntax_EnumTerminal((org.emftext.sdk.concretesyntax.EnumTerminal) object, context);
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
		if (object instanceof org.emftext.sdk.concretesyntax.Option) {
			result = interprete_org_emftext_sdk_concretesyntax_Option((org.emftext.sdk.concretesyntax.Option) object, context);
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
		if (object instanceof org.emftext.sdk.concretesyntax.Annotation) {
			result = interprete_org_emftext_sdk_concretesyntax_Annotation((org.emftext.sdk.concretesyntax.Annotation) object, context);
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
		if (object instanceof org.emftext.sdk.concretesyntax.KeyValuePair) {
			result = interprete_org_emftext_sdk_concretesyntax_KeyValuePair((org.emftext.sdk.concretesyntax.KeyValuePair) object, context);
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
		if (object instanceof java.util.Map.Entry<?,?>) {
			result = interprete_java_util_Map_Entry((java.util.Map.Entry<?,?>) object, context);
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
		if (object instanceof org.emftext.sdk.concretesyntax.DefaultTokenStyleAdder) {
			result = interprete_org_emftext_sdk_concretesyntax_DefaultTokenStyleAdder((org.emftext.sdk.concretesyntax.DefaultTokenStyleAdder) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_GenPackageDependentElement(GenPackageDependentElement genPackageDependentElement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_ConcreteSyntax(ConcreteSyntax concreteSyntax, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Import(Import _import, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_SyntaxElement(SyntaxElement syntaxElement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Rule(Rule rule, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Choice(Choice choice, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Sequence(Sequence sequence, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Definition(Definition definition, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_CardinalityDefinition(CardinalityDefinition cardinalityDefinition, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Terminal(Terminal terminal, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_CsString(CsString csString, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_WhiteSpaces(WhiteSpaces whiteSpaces, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_LineBreak(LineBreak lineBreak, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_CompoundDefinition(CompoundDefinition compoundDefinition, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_RegexComposer(RegexComposer regexComposer, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_RegexOwner(RegexOwner regexOwner, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_RegexPart(RegexPart regexPart, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_RegexComposite(RegexComposite regexComposite, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_AtomicRegex(AtomicRegex atomicRegex, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_RegexReference(RegexReference regexReference, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_TokenDirective(TokenDirective tokenDirective, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_AbstractTokenDefinition(AbstractTokenDefinition abstractTokenDefinition, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_NamedTokenDefinition(NamedTokenDefinition namedTokenDefinition, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_ReferencableTokenDefinition(ReferencableTokenDefinition referencableTokenDefinition, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_PartialTokenDefinition(PartialTokenDefinition partialTokenDefinition, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_CompleteTokenDefinition(CompleteTokenDefinition completeTokenDefinition, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_NormalTokenDefinition(NormalTokenDefinition normalTokenDefinition, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_TokenRedefinition(TokenRedefinition tokenRedefinition, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_QuotedTokenDefinition(QuotedTokenDefinition quotedTokenDefinition, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_TokenPriorityDirective(TokenPriorityDirective tokenPriorityDirective, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Containment(Containment containment, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Placeholder(Placeholder placeholder, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken(PlaceholderUsingSpecifiedToken placeholderUsingSpecifiedToken, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken(PlaceholderUsingDefaultToken placeholderUsingDefaultToken, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_PlaceholderInQuotes(PlaceholderInQuotes placeholderInQuotes, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_BooleanTerminal(BooleanTerminal booleanTerminal, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_EnumTerminal(EnumTerminal enumTerminal, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_EnumLiteralTerminal(EnumLiteralTerminal enumLiteralTerminal, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Option(Option option, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_TokenStyle(TokenStyle tokenStyle, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Annotation(Annotation annotation, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Annotable(Annotable annotable, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_KeyValuePair(KeyValuePair keyValuePair, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_GenClassCache(GenClassCache genClassCache, ContextType context) {
		return null;
	}
	
	public ResultType interprete_java_util_Map_Entry(Entry<?,?> genClassCacheEntry, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_EClassUtil(EClassUtil eClassUtil, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_DefaultTokenStyleAdder(DefaultTokenStyleAdder defaultTokenStyleAdder, ContextType context) {
		return null;
	}
	
	private void notifyListeners(EObject element) {
		for (org.emftext.sdk.concretesyntax.resource.cs.ICsInterpreterListener listener : listeners) {
			listener.handleInterpreteObject(element);
		}
	}
	
	/**
	 * Adds the given object to the interpretation stack. Attention: Objects that are
	 * added first, are interpret last.
	 */
	public void addObjectToInterprete(EObject object) {
		interpretationStack.push(object);
	}
	
	/**
	 * Adds the given collection of objects to the interpretation stack. Attention:
	 * Collections that are added first, are interpret last.
	 */
	public void addObjectsToInterprete(Collection<? extends EObject> objects) {
		for (EObject object : objects) {
			addObjectToInterprete(object);
		}
	}
	
	/**
	 * Adds the given collection of objects in reverse order to the interpretation
	 * stack.
	 */
	public void addObjectsToInterpreteInReverseOrder(Collection<? extends EObject> objects) {
		List<EObject> reverse = new ArrayList<EObject>(objects.size());
		reverse.addAll(objects);
		Collections.reverse(reverse);
		addObjectsToInterprete(reverse);
	}
	
	/**
	 * Adds the given object and all its children to the interpretation stack such
	 * that they are interpret in top down order.
	 */
	public void addObjectTreeToInterpreteTopDown(EObject root) {
		List<EObject> objects = new ArrayList<EObject>();
		objects.add(root);
		Iterator<EObject> it = root.eAllContents();
		while (it.hasNext()) {
			EObject eObject = (EObject) it.next();
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
	
	public EObject getNextObjectToInterprete() {
		return nextObjectToInterprete;
	}
	
	public Stack<EObject> getInterpretationStack() {
		return interpretationStack;
	}
	
	public void terminate() {
		interpretationStack.clear();
	}
	
	public Object getCurrentContext() {
		return currentContext;
	}
	
}

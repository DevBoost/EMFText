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

package org.emftext.sdk.concretesyntax.resource.cs.util;

public class AbstractCsInterpreter<ResultType, ContextType> {
	
	private java.util.Stack<org.eclipse.emf.ecore.EObject> interpretationStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		while (!interpretationStack.empty()) {
			org.eclipse.emf.ecore.EObject next = interpretationStack.pop();
			result = interprete(next, context);
		}
		return result;
	}
	
	public ResultType interprete(org.eclipse.emf.ecore.EObject object, ContextType context) {
		ResultType result = null;
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
		if (object instanceof org.emftext.sdk.concretesyntax.Abstract) {
			result = interprete_org_emftext_sdk_concretesyntax_Abstract((org.emftext.sdk.concretesyntax.Abstract) object, context);
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
		if (object instanceof org.emftext.sdk.concretesyntax.AbstractTokenDefinition) {
			result = interprete_org_emftext_sdk_concretesyntax_AbstractTokenDefinition((org.emftext.sdk.concretesyntax.AbstractTokenDefinition) object, context);
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
		if (object instanceof org.emftext.sdk.concretesyntax.TokenDirective) {
			result = interprete_org_emftext_sdk_concretesyntax_TokenDirective((org.emftext.sdk.concretesyntax.TokenDirective) object, context);
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
		if (object instanceof org.emftext.sdk.concretesyntax.QUESTIONMARK) {
			result = interprete_org_emftext_sdk_concretesyntax_QUESTIONMARK((org.emftext.sdk.concretesyntax.QUESTIONMARK) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.STAR) {
			result = interprete_org_emftext_sdk_concretesyntax_STAR((org.emftext.sdk.concretesyntax.STAR) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.PLUS) {
			result = interprete_org_emftext_sdk_concretesyntax_PLUS((org.emftext.sdk.concretesyntax.PLUS) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.sdk.concretesyntax.Cardinality) {
			result = interprete_org_emftext_sdk_concretesyntax_Cardinality((org.emftext.sdk.concretesyntax.Cardinality) object, context);
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
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Cardinality(org.emftext.sdk.concretesyntax.Cardinality object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_PLUS(org.emftext.sdk.concretesyntax.PLUS object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_STAR(org.emftext.sdk.concretesyntax.STAR object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_QUESTIONMARK(org.emftext.sdk.concretesyntax.QUESTIONMARK object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_CompoundDefinition(org.emftext.sdk.concretesyntax.CompoundDefinition object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_TokenDirective(org.emftext.sdk.concretesyntax.TokenDirective object, ContextType context) {
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
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_AbstractTokenDefinition(org.emftext.sdk.concretesyntax.AbstractTokenDefinition object, ContextType context) {
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
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Option(org.emftext.sdk.concretesyntax.Option object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_sdk_concretesyntax_Abstract(org.emftext.sdk.concretesyntax.Abstract object, ContextType context) {
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
	
	public void addObjectToInterprete(org.eclipse.emf.ecore.EObject object) {
		interpretationStack.push(object);
	}
	
}

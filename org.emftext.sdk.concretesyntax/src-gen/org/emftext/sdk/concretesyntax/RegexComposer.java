/**
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
 *  
 */
package org.emftext.sdk.concretesyntax;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Regex Composer</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getRegexComposer()
 * @model
 * @generated
 */
public interface RegexComposer extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model visitedTokensMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='visitedTokens.add(token);\r\n\njava.lang.StringBuilder result = new java.lang.StringBuilder();\nif (token instanceof org.emftext.sdk.concretesyntax.RegexComposite) {\n\torg.emftext.sdk.concretesyntax.RegexComposite composite = ( org.emftext.sdk.concretesyntax.RegexComposite) token;\n\tfor ( org.emftext.sdk.concretesyntax.RegexPart part : composite.getRegexParts()) {\n\t\tif (part instanceof org.emftext.sdk.concretesyntax.AtomicRegex) {\n\t\t\tresult.append(part.getRegex());\n\t\t} else if (part instanceof org.emftext.sdk.concretesyntax.RegexReference) {\n\t\t\torg.emftext.sdk.concretesyntax.RegexReference reference = ( org.emftext.sdk.concretesyntax.RegexReference) part;\n\t\t\torg.emftext.sdk.concretesyntax.AbstractTokenDefinition target = reference.getTarget();\n\t\t\tif (target == null) {\n\t\t\t\tcontinue;\n\t\t\t}\n\t\t\tif (target.eIsProxy()) {\n\t\t\t\tcontinue;\n\t\t\t}\n\t\t\tif (visitedTokens.contains(target)) {\n\t\t\t\tcontinue;\n\t\t\t}\n\t\t\torg.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.AbstractTokenDefinition> subVisitedTokens = new org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.AbstractTokenDefinition>();\n\t\t\tsubVisitedTokens.addAll(visitedTokens);\n\t\t\tresult.append(getComposedRegex(target, subVisitedTokens));\n\t\t}\n\t}\n} else if (token instanceof org.emftext.sdk.concretesyntax.RegexOwner) {\n\torg.emftext.sdk.concretesyntax.RegexOwner owner = ( org.emftext.sdk.concretesyntax.RegexOwner) token;\n\tresult.append(owner.getRegex());\n}\nreturn result.toString();'"
	 * @generated
	 */
	String getComposedRegex(AbstractTokenDefinition token, EList<AbstractTokenDefinition> visitedTokens);

} // RegexComposer

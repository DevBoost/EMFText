/**
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Software Technology Group - TU Dresden, Germany 
 *       - initial API and implementation
 * 
 *
 * $Id$
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='visitedTokens .add ( token ) ; \r\njava.lang.StringBuilder result = new java.lang.StringBuilder ( ) ; \r\nif ( token instanceof org.emftext.sdk.concretesyntax.RegexComposite ) { \r\n\torg.emftext.sdk.concretesyntax.RegexComposite composite = ( org.emftext.sdk.concretesyntax.RegexComposite ) token ; \r\n\tfor ( org.emftext.sdk.concretesyntax.RegexPart part : composite .getRegexParts ( ) ) { \r\n\t\tif ( part instanceof org.emftext.sdk.concretesyntax.AtomicRegex ) { \r\n\t\t\tresult .append ( part .getRegex ( ) ) ; \r\n\t\t} else if ( part instanceof org.emftext.sdk.concretesyntax.RegexReference ) { \r\n\t\t\torg.emftext.sdk.concretesyntax.RegexReference reference = ( org.emftext.sdk.concretesyntax.RegexReference ) part ; \r\n\t\t\torg.emftext.sdk.concretesyntax.AbstractTokenDefinition target = reference .getTarget ( ) ; \r\n\t\t\tif ( target == null ) { \r\n\t\t\t\tcontinue ; \r\n\t\t\t} \r\n\t\t\tif ( target .eIsProxy ( ) ) { \r\n\t\t\t\tcontinue ; \r\n\t\t\t} \r\n\t\t\tif ( visitedTokens .contains ( target ) ) { \r\n\t\t\t\tcontinue ; \r\n\t\t\t} \r\n\t\t\torg.eclipse.emf.common.util.EList < org.emftext.sdk.concretesyntax.AbstractTokenDefinition > subVisitedTokens = new org.eclipse.emf.common.util.BasicEList < org.emftext.sdk.concretesyntax.AbstractTokenDefinition > ( ) ; \r\n\t\t\tsubVisitedTokens .addAll ( visitedTokens ) ; \r\n\t\t\tresult .append ( getComposedRegex ( target , subVisitedTokens ) ) ; \r\n\t\t} \r\n\t} \r\n} else if ( token instanceof org.emftext.sdk.concretesyntax.RegexOwner ) { \r\n\torg.emftext.sdk.concretesyntax.RegexOwner owner = ( org.emftext.sdk.concretesyntax.RegexOwner ) token ; \r\n\tresult .append ( owner .getRegex ( ) ) ; \r\n} \r\nreturn result .toString ( ) ; \r\n'"
	 * @generated
	 */
	String getComposedRegex(AbstractTokenDefinition token, EList<AbstractTokenDefinition> visitedTokens);

} // RegexComposer

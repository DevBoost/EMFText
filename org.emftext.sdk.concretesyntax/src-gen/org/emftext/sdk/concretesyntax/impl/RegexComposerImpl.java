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
package org.emftext.sdk.concretesyntax.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.emftext.sdk.concretesyntax.AbstractTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.RegexComposer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Regex Composer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RegexComposerImpl extends EObjectImpl implements RegexComposer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegexComposerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConcretesyntaxPackage.Literals.REGEX_COMPOSER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComposedRegex(AbstractTokenDefinition token, EList<AbstractTokenDefinition> visitedTokens) {
		visitedTokens .add ( token ) ; 
		java.lang.StringBuilder result = new java.lang.StringBuilder ( ) ; 
		if ( token instanceof org.emftext.sdk.concretesyntax.RegexComposite ) { 
			org.emftext.sdk.concretesyntax.RegexComposite composite = ( org.emftext.sdk.concretesyntax.RegexComposite ) token ; 
			for ( org.emftext.sdk.concretesyntax.RegexPart part : composite .getRegexParts ( ) ) { 
				if ( part instanceof org.emftext.sdk.concretesyntax.AtomicRegex ) { 
					result .append ( part .getRegex ( ) ) ; 
				} else if ( part instanceof org.emftext.sdk.concretesyntax.RegexReference ) { 
					org.emftext.sdk.concretesyntax.RegexReference reference = ( org.emftext.sdk.concretesyntax.RegexReference ) part ; 
					org.emftext.sdk.concretesyntax.AbstractTokenDefinition target = reference .getTarget ( ) ; 
					if ( target == null ) { 
						continue ; 
					} 
					if ( target .eIsProxy ( ) ) { 
						continue ; 
					} 
					if ( visitedTokens .contains ( target ) ) { 
						continue ; 
					} 
					org.eclipse.emf.common.util.EList < org.emftext.sdk.concretesyntax.AbstractTokenDefinition > subVisitedTokens = new org.eclipse.emf.common.util.BasicEList < org.emftext.sdk.concretesyntax.AbstractTokenDefinition > ( ) ; 
					subVisitedTokens .addAll ( visitedTokens ) ; 
					result .append ( getComposedRegex ( target , subVisitedTokens ) ) ; 
				} 
			} 
		} else if ( token instanceof org.emftext.sdk.concretesyntax.RegexOwner ) { 
			org.emftext.sdk.concretesyntax.RegexOwner owner = ( org.emftext.sdk.concretesyntax.RegexOwner ) token ; 
			result .append ( owner .getRegex ( ) ) ; 
		} 
		return result .toString ( ) ; 
		
	}

} //RegexComposerImpl

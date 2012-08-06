/*******************************************************************************
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
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.sdk.generatorconfig.impl;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

import org.emftext.sdk.concretesyntax.AtomicRegex;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.NormalTokenDefinition;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
import org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken;
import org.emftext.sdk.concretesyntax.Terminal;

import org.emftext.sdk.concretesyntax.impl.DefinitionImpl;

import org.emftext.sdk.generatorconfig.Feature;
import org.emftext.sdk.generatorconfig.GeneratorconfigPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class FeatureImpl extends DefinitionImpl implements Feature {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorconfigPackage.Literals.FEATURE;
	}

	/**
	 * 
	 * @generated NOT
	 */
	private NormalTokenDefinition createToken(String name, String expression) {
		ConcretesyntaxFactory concretesyntaxFactory = ConcretesyntaxPackage.eINSTANCE.getConcretesyntaxFactory();
		NormalTokenDefinition newToken = concretesyntaxFactory.createNormalTokenDefinition();
		newToken.setName(name);
		AtomicRegex regex = concretesyntaxFactory.createAtomicRegex();
		regex.setAtomicExpression(expression);
		newToken.getRegexParts().add(regex);
		return newToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Definition> getDefinition(GenFeature genFeature) {
		EList<Definition> parts = new BasicEList<Definition>();
		ConcretesyntaxFactory concretesyntaxFactory = ConcretesyntaxPackage.eINSTANCE.getConcretesyntaxFactory();
		NormalTokenDefinition intToken = createToken("INTEGER", "('-')?('1'..'9')('0'..'9')*|'0'");
		NormalTokenDefinition floatToken = createToken("FLOAT", "('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ ");
		
		Terminal content = null;
		if (genFeature.getEcoreFeature() instanceof EReference && ((EReference)genFeature.getEcoreFeature()).isContainment() ) {
			content = concretesyntaxFactory.createContainment();
		}
		else{
			String typeName = genFeature.getEcoreFeature().getEType().getInstanceClassName();
			if (genFeature.isStringType()) {
				PlaceholderInQuotes placeholder = concretesyntaxFactory.createPlaceholderInQuotes();
				placeholder.setPrefix("\"");
				placeholder.setSuffix("\"");
				content = placeholder;
			}
			else if (typeName == null) {
				content = concretesyntaxFactory.createPlaceholderUsingSpecifiedToken();
			}
			else if(typeName.equals("String")) {
				PlaceholderInQuotes placeholder = concretesyntaxFactory.createPlaceholderInQuotes();
				placeholder.setPrefix("\"");
				placeholder.setSuffix("\"");
				content = placeholder;
			}
			
			else if(typeName.equals("int") || typeName.equals("long")  || typeName.equals("short")){
				PlaceholderUsingSpecifiedToken placeholder = concretesyntaxFactory.createPlaceholderUsingSpecifiedToken();
				placeholder.setToken(intToken);
				content = placeholder;
			}
			
			else if(typeName.equals("float") || typeName.equals("double")){
				PlaceholderUsingSpecifiedToken placeholder = concretesyntaxFactory.createPlaceholderUsingSpecifiedToken();
				placeholder.setToken(floatToken);
				content = placeholder;
			}										
			else {
				content = concretesyntaxFactory.createPlaceholderUsingSpecifiedToken();
			}
			
			
		}									
		content.setFeature(genFeature);
		parts.add(content);
		return parts;
	}

} //FeatureImpl

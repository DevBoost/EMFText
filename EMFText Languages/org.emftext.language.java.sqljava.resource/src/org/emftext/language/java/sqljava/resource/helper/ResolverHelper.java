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
package org.emftext.language.java.sqljava.resource.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.imports.ClassifierImport;
import org.emftext.language.java.references.ElementReference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.resource.java.IJavaQuickFix;
import org.emftext.language.java.resource.java.IJavaReferenceMapping;
import org.emftext.language.java.resource.java.IJavaReferenceResolveResult;
import org.emftext.language.java.resource.java.analysis.ClassifierImportClassifierReferenceResolver;
import org.emftext.language.java.resource.java.analysis.ClassifierReferenceTargetReferenceResolver;
import org.emftext.language.java.resource.java.analysis.ElementReferenceTargetReferenceResolver;
import org.emftext.language.java.types.ClassifierReference;

public class ResolverHelper {

	public static ReferenceableElement getResolvedElement(String name, ElementReference reference){
		
		ResolverHelper helper = new ResolverHelper();
		JavaReferenceResolveResult<ReferenceableElement> result =
			helper.new JavaReferenceResolveResult<ReferenceableElement>();
		
		ResolverHelper.resolve(name, reference, null, -1, false, result);
		ReferenceableElement referencableElement = null;
		
		if(result.wasResolved())
			referencableElement = ((JavaReferenceMapping<ReferenceableElement>)result.getMappings().iterator().next()).getElement();
		return referencableElement;
		
	}
	
	public static ConcreteClassifier getResolvedClassifier(String name, ClassifierImport reference){
		
		ResolverHelper helper = new ResolverHelper();
		JavaReferenceResolveResult<ConcreteClassifier> result =
			helper.new JavaReferenceResolveResult<ConcreteClassifier>();
		
		ResolverHelper.resolve(name, reference, null, -1, false, result);
		ConcreteClassifier concreteClassifier = null;
		
		if(result.wasResolved())
			concreteClassifier = (ConcreteClassifier)((JavaReferenceMapping<ConcreteClassifier>)result.getMappings().iterator().next()).getElement();
		return concreteClassifier;
		
	} 
	
	public static ConcreteClassifier getResolvedClassifier(String name, ClassifierReference reference){
		
		ResolverHelper helper = new ResolverHelper();
		JavaReferenceResolveResult<Classifier> result =
			helper.new JavaReferenceResolveResult<Classifier>();
		
		ResolverHelper.resolve(name, reference, null, -1, false, result);
		ConcreteClassifier concreteClassifier = null;
		
		if(result.wasResolved())
			concreteClassifier = (ConcreteClassifier)((JavaReferenceMapping<Classifier>)result.getMappings().iterator().next()).getElement();
		return concreteClassifier;
		
	} 
	
	public class JavaReferenceMapping<ReferenceType> implements IJavaReferenceMapping<ReferenceType>{

		URI uri;
		ReferenceType element;
		String identifier;
		String warning;
		
		
		
		public JavaReferenceMapping(URI uri, ReferenceType element,
				String identifier, String warning) {
			super();
			this.uri = uri;
			this.element = element;
			this.identifier = identifier;
			this.warning = warning;
		}

		public String getIdentifier() {
			return identifier;
		}

		public String getWarning() {
			return warning;
		}

		public URI getUri() {
			return uri;
		}

		public ReferenceType getElement() {
			return element;
		}
	}
	
	public class JavaReferenceResolveResult<ReferenceType> implements IJavaReferenceResolveResult<ReferenceType>{
		
		Collection<IJavaReferenceMapping<ReferenceType>> mappings = 
			new ArrayList<IJavaReferenceMapping<ReferenceType>>();
		
		String errorMessage = "";
		
		public boolean wasResolvedUniquely() {
			return false;
		}
		
		public boolean wasResolvedMultiple() {
			return mappings.size() > 1;
		}
		
		public boolean wasResolved() {
			return mappings.size() > 0;
		}
		
		public void setErrorMessage(String message) {
			errorMessage = message;
		}

		public Collection<IJavaReferenceMapping<ReferenceType>> getMappings() {
			return mappings;
		}

		public String getErrorMessage() {
			return errorMessage;
		}
		
		public void addMapping(String identifier, URI newIdentifier) {
			mappings.add(new JavaReferenceMapping<ReferenceType>(newIdentifier, null, identifier, ""));
		}
		
		public void addMapping(String identifier, URI newIdentifier, String warning) {
			mappings.add(new JavaReferenceMapping<ReferenceType>(newIdentifier, null, identifier, warning));
		}
		
		public void addMapping(String identifier, ReferenceType target) {
			mappings.add(new JavaReferenceMapping<ReferenceType>(null, target, identifier, ""));
		}
		
		public void addMapping(String identifier, ReferenceType target, String warning) {
			mappings.add(new JavaReferenceMapping<ReferenceType>(null, target, identifier, warning));
		}

		public Collection<IJavaQuickFix> getQuickFixes() {
			return Collections.emptySet();
		}

		public void addQuickFix(IJavaQuickFix quickFix) {
			// TODO Auto-generated method stub
		}
	}
	
	private static void resolve(String identifier, ElementReference container, EReference reference, int position, boolean resolveFuzzy, IJavaReferenceResolveResult<ReferenceableElement> result) {
		
		ElementReferenceTargetReferenceResolver delegate = 
			new ElementReferenceTargetReferenceResolver();
		
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
		
	}
	
	private static void resolve(String identifier, ClassifierReference container, EReference reference, int position, boolean resolveFuzzy, IJavaReferenceResolveResult<Classifier> result){
		
		ClassifierReferenceTargetReferenceResolver delegate = 
			new ClassifierReferenceTargetReferenceResolver();
		
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	private static void resolve(String identifier, ClassifierImport container, EReference reference, int position, boolean resolveFuzzy, IJavaReferenceResolveResult<ConcreteClassifier> result){
		
	ClassifierImportClassifierReferenceResolver delegate = 
			new ClassifierImportClassifierReferenceResolver();
		
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}

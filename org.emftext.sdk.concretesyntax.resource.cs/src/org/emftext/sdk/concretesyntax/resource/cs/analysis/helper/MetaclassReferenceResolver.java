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
package org.emftext.sdk.concretesyntax.resource.cs.analysis.helper;

import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.emftext.sdk.codegen.util.GenClassUtil;
import org.emftext.sdk.codegen.util.Pair;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult;
import org.emftext.sdk.finders.GenClassFinder;

/**
 * A resolver for EMF generator classes. The classes must be identified
 * by string of the form 'package.SubPackage.ClassName'. 
 */
public class MetaclassReferenceResolver {

	
	private interface MetaClassFilter {
		public String accept(String importPrefix, GenClass genClass);
		public boolean isFuzzy();
	}
	
	public static abstract class CustomMatchCondition {
		
		private final GenClassUtil genClassUtil = new GenClassUtil();
		private String message = null;
		
		public abstract boolean matches(GenClass genClass);
			
		public GenClassUtil getGenClassUtil(){
			return genClassUtil;
		}
		
		public void setMessage(String message){
			this.message = message;
		}
		
		public String getMessage() {
			return message;
		}

	}
	
	private GenClassFinder genClassFinder = new GenClassFinder();

	public String deResolve(EObject element, EObject container, EReference reference){
		GenClass genClass = (GenClass)element;
		ConcreteSyntax syntax = getConcreteSyntax(container);
		GenPackage genPackage = genClass.getGenPackage();
		if (genPackage == null) {
			return null;
		}
		EPackage ePackage = genPackage.getEcorePackage();
		if (ePackage == null) {
			return null;
		}
		String packageURI = ePackage.getNsURI();
		if(syntax.getPackage().getNSName().equals(packageURI))
			return genClass.getName();
		else{
			String prefix = "";
			for (Import aImport : syntax.getImports()) {
				if (aImport.getPackage().getNSURI().equals(packageURI)){
					prefix = aImport.getPrefix() + GenClassFinder.DOT;					
				}
			}
			return prefix + genClass.getName();
		}
	}

	private ConcreteSyntax getConcreteSyntax(EObject container) {
		while(!(container instanceof ConcreteSyntax)) {
			container = container.eContainer();
			//was before: Assert.isNotNull(container);
			//container might be null during fuzzy resolving
			if (container == null) {
				return null;
			}
		}
		return (ConcreteSyntax) container;
	}

	public void doResolve(String identifier, EObject container,
			EReference reference, int position, boolean resolveFuzzy, ICsReferenceResolveResult<GenClass> result, CustomMatchCondition matchCondition) {
		
		if (resolveFuzzy) {
			doResolveFuzzy(getConcreteSyntax(container), identifier, result, matchCondition);
		} else {
			doResolveStrict(getConcreteSyntax(container), identifier, result, matchCondition);
		}
	}

	private void doResolveFuzzy(ConcreteSyntax syntax, final String identifier, ICsReferenceResolveResult<GenClass> result, CustomMatchCondition matchCondition) {
		doResolveMetaclass(syntax, new MetaClassFilter() {

			public String accept(String importPrefix, GenClass genClass) {
				String genClassName = genClass.getName();
				String name;
				if (importPrefix != null) {
					name = importPrefix + genClassName;
				} else {
					name = genClassName;
				}
				if (name.startsWith(identifier)) {
					return name;
				}
				return null;
			}
			
			public boolean isFuzzy(){
				return true;
			}
		}, identifier, result, matchCondition);
	}

	private void doResolveMetaclass(ConcreteSyntax syntax, MetaClassFilter filter, String ident, ICsReferenceResolveResult<GenClass> result, CustomMatchCondition matchCondition) {
		// first collect all generator classes
		List<Pair<String, GenClass>> prefixedGenClasses = genClassFinder.findAllGenClassesAndPrefixes(syntax, true, true);
		// then check which are accepted by the filter
		for (Pair<String, GenClass> prefixedGenClass : prefixedGenClasses) {
			String prefix = prefixedGenClass.getLeft();
			GenClass genClass = prefixedGenClass.getRight();
			String identifier = filter.accept(prefix, genClass);
			if (identifier != null) {
				if(matchCondition.matches(genClass)){
					result.addMapping(identifier, genClass);
				}
				else if(filter.isFuzzy()){
					continue;
				}
				else{
					result.setErrorMessage(matchCondition.getMessage());
				}
				if (!filter.isFuzzy()) {
					break;
				}
			}
		}
		
		if (result.getErrorMessage() == null && (result.getMappings() == null || result.getMappings().isEmpty())) {
			result.setErrorMessage("EClass \"" + ident + "\" does not exist");
		}
	}


	private void doResolveStrict(ConcreteSyntax container,
			final String identifier, ICsReferenceResolveResult<GenClass> result, CustomMatchCondition customMatchCondition) {
		
		doResolveMetaclass(container, new MetaClassFilter() {

			public String accept(String prefix, GenClass genClass) {
				String genClassName = genClass.getName();
				if (identifier.equals((prefix == null ? "" : prefix) + genClassName)) {
					return identifier;
				}
				return null;
			}
			
			public boolean isFuzzy(){
				return false;
			}
		}, identifier, result, customMatchCondition);
	}
}

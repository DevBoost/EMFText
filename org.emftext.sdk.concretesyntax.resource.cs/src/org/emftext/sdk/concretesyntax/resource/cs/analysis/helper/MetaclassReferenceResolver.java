/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.concretesyntax.resource.cs.analysis.helper;

import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
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

	private final static GenClassUtil genClassUtil = new GenClassUtil();
	
	private interface MetaClassFilter {
		public String accept(String importPrefix, GenClass genClass);
		public boolean isFuzzy();
	}

	private GenClassFinder genClassFinder = new GenClassFinder();

	public String deResolve(EObject element, EObject container, EReference reference){
		GenClass genClass = (GenClass)element;
		ConcreteSyntax syntax = getConcreteSyntax(container);
		String packageURI = genClass.getGenPackage().getNSURI();
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
			EReference reference, int position, boolean resolveFuzzy, ICsReferenceResolveResult<GenClass> result, GenClass requiredSuperType, boolean canBeAbstract) {
		
		if (resolveFuzzy) {
			doResolveFuzzy(getConcreteSyntax(container), identifier, result, requiredSuperType, canBeAbstract);
		} else {
			doResolveStrict(getConcreteSyntax(container), identifier, result, requiredSuperType, canBeAbstract);
		}
	}

	private void doResolveFuzzy(ConcreteSyntax syntax, final String identifier, ICsReferenceResolveResult<GenClass> result, GenClass requiredSuperType, boolean canBeAbstract) {
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
		}, identifier, result, requiredSuperType, canBeAbstract);
	}

	private void doResolveMetaclass(ConcreteSyntax syntax, MetaClassFilter filter, String ident, ICsReferenceResolveResult<GenClass> result, GenClass requiredSuperType, boolean canBeAbstract) {
		// first collect all generator classes
		List<Pair<String, GenClass>> prefixedGenClasses = genClassFinder.findAllGenClassesAndPrefixes(syntax, true, true);
		// then check which are accepted by the filter
		for (Pair<String, GenClass> prefixedGenClass : prefixedGenClasses) {
			String prefix = prefixedGenClass.getLeft();
			GenClass genClass = prefixedGenClass.getRight();
			String identifier = filter.accept(prefix, genClass);
			if (identifier != null) {
				if (!canBeAbstract && genClassUtil.isNotConcrete(genClass)) {
					if (filter.isFuzzy()) {
						continue;
					} else {
						result.setErrorMessage("EClass \"" + ident + "\" does exist, but is "+(genClass.getEcoreClass().isInterface()?"interface":"abstract")+".");
					}
				}	
				else{
					if (hasRequiredSupertype(genClass, requiredSuperType)) {
						result.addMapping(identifier, genClass);
					}
					else {
						result.setErrorMessage("EClass \"" + ident + "\" does exist, but is not a subtype of \"" + requiredSuperType.getName() + "\".");
					}
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

	private boolean hasRequiredSupertype(GenClass genClass,
			GenClass requiredSuperType) {
		if (requiredSuperType == null) {
			return true;
		}
		if (genClass.equals(requiredSuperType)) {
			return true;
		}
		for (EClass superTypeCand : genClass.getEcoreClass().getEAllSuperTypes()) {
			if (namesAndPackageURIsAreEqual(requiredSuperType.getEcoreClass(), superTypeCand)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean namesAndPackageURIsAreEqual(EClass classA,
			EClass classB) {
		return namesAreEqual(classA, classB) && 
			packageURIsAreEqual(classA, classB);
	}

	private boolean packageURIsAreEqual(EClass classA,
			EClass classB) {
		return classA.getEPackage().getNsURI().equals(
				classB.getEPackage().getNsURI());
	}

	private boolean namesAreEqual(EClass classA, EClass classB) {
		return classA.getName().equals(classB.getName());
	}

	private void doResolveStrict(ConcreteSyntax container,
			final String identifier, ICsReferenceResolveResult<GenClass> result, GenClass requiredSuperType, boolean canBeAbstract) {
		
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
		}, identifier, result, requiredSuperType, canBeAbstract);
	}
}

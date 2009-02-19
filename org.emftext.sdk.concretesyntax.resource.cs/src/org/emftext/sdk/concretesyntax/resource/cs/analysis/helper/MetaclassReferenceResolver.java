package org.emftext.sdk.concretesyntax.resource.cs.analysis.helper;

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.sdk.codegen.util.Pair;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
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

	private GenClassFinder genClassFinder = new GenClassFinder();

	public String deResolve(EObject element, EObject container, EReference reference){
		GenClass genClass = (GenClass)element;
		genClass.getGenPackage().getNSName();
		ConcreteSyntax syntax = getConcreteSyntax(container);
		if(syntax.getPackage().getNSName().equals(genClass.getGenPackage().getNSName()))
			return genClass.getName();
		else{
			String prefix = "";
			for (Import aImport : syntax.getImports()) {
				if (aImport.getPackage().getNSName().equals(genClass.getGenPackage().getNSName())){
					prefix = aImport.getPrefix() + GenClassFinder.DOT;					
				}
			}
			return prefix + genClass.getName();
		}
	}

	private ConcreteSyntax getConcreteSyntax(EObject container) {
		while(!(container instanceof ConcreteSyntax)) {
			container = container.eContainer();
			Assert.isNotNull(container);
		}
		return (ConcreteSyntax) container;
	}

	public void doResolve(String identifier, EObject container,
			EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult result, GenClass requiredSuperType, boolean canBeAbstract) {
		
		if (resolveFuzzy) {
			doResolveFuzzy(getConcreteSyntax(container), identifier, result, requiredSuperType, canBeAbstract);
		} else {
			doResolveStrict(getConcreteSyntax(container), identifier, result, requiredSuperType, canBeAbstract);
		}
	}

	private void doResolveFuzzy(ConcreteSyntax syntax, final String identifier, IReferenceResolveResult result, GenClass requiredSuperType, boolean canBeAbstract) {
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

	private void doResolveMetaclass(ConcreteSyntax syntax, MetaClassFilter filter, String ident, IReferenceResolveResult result, GenClass requiredSuperType, boolean canBeAbstract) {
		// first collect all generator classes
		List<Pair<String, GenClass>> prefixedGenClasses = genClassFinder.findAllGenClassesAndPrefixes(syntax, true, true);
		// then check which are accepted by the filter
		for (Pair<String, GenClass> prefixedGenClass : prefixedGenClasses) {
			String prefix = prefixedGenClass.getLeft();
			GenClass genClass = prefixedGenClass.getRight();
			String identifier = filter.accept(prefix, genClass);
			if (identifier != null) {
				if (!canBeAbstract && isInterfaceOrAbstract(genClass)) {
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

	private boolean isInterfaceOrAbstract(GenClass genClass) {
		return genClass.getEcoreClass().isAbstract() || genClass.getEcoreClass().isInterface();
	}


	private void doResolveStrict(ConcreteSyntax container,
			final String identifier, IReferenceResolveResult result, GenClass requiredSuperType, boolean canBeAbstract) {
		
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

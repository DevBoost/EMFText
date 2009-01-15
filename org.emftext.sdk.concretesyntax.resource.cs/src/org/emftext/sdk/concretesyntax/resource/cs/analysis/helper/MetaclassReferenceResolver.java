package org.emftext.sdk.concretesyntax.resource.cs.analysis.helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IResolveResult;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.Rule;

/**
 * A resolver for EMF generator classes. The classes must be identified
 * by string of the form 'package.SubPackage.ClassName'. 
 */
public class MetaclassReferenceResolver {

	private interface MetaClassFilter {
		public String accept(String importPrefix, GenClass genClass);
		public boolean isFuzzy();
	}

	private static final String DOT = ".";
	
	public String deResolve(EObject element, EObject container, EReference reference){
		GenClass genClass = (GenClass)element;
		genClass.getGenPackage().getNSName();
		ConcreteSyntax syntax = getConcreteSyntax(container);
		if(syntax.getPackage().getNSName().equals(genClass.getGenPackage().getNSName()))
			return genClass.getName();
		else{
			String prefix = "";
			for (Import aImport : syntax.getImports()) {
				if(aImport.getPackage().getNSName().equals(genClass.getGenPackage().getNSName())){
					prefix = aImport.getPrefix() + DOT;					
				}

			}
			return prefix + genClass.getName();
		}
	}

	private ConcreteSyntax getConcreteSyntax(EObject container) {
		if (container instanceof Rule) {
			Rule rule = (Rule) container;
			return rule.getSyntax();
		} else {
			return (ConcreteSyntax) container;
		}
	}

	public void doResolve(String identifier, EObject container,
			EReference reference, int position, boolean resolveFuzzy, IResolveResult result) {
		
		if (resolveFuzzy) {
			doResolveFuzzy(getConcreteSyntax(container), identifier, result);
		} else {
			doResolveStrict(getConcreteSyntax(container), identifier, result);
		}
	}

	public void doResolveFuzzy(ConcreteSyntax syntax, final String identifier, IResolveResult result) {
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
		}, identifier, result);
	}

	private void doResolveMetaclass(ConcreteSyntax syntax, MetaClassFilter filter, String ident, IResolveResult result) {
		// first collect all generator classes
		List<Pair<String, GenClass>> prefixedGenClasses = findAllGenClasses(null, syntax);
		// then check which are accepted by the filter
		for (Pair<String, GenClass> prefixedGenClass : prefixedGenClasses) {
			String prefix = prefixedGenClass.getLeft();
			GenClass genClass = prefixedGenClass.getRight();
			String identifier = filter.accept(prefix, genClass);
			if (identifier != null) {
				if (isInterfaceOrAbstract(genClass)) {
					if (filter.isFuzzy()) {
						continue;
					} else {
						result.setErrorMessage("EClass \"" + ident + "\" does exist, but is "+(genClass.getEcoreClass().isInterface()?"interface":"abstract")+".");
					}
				}	
				else{
					result.addMapping(identifier, genClass);
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

	private boolean isInterfaceOrAbstract(GenClass genClass) {
		return genClass.getEcoreClass().isAbstract() || genClass.getEcoreClass().isInterface();
	}


	private List<Pair<String, GenClass>> findAllGenClasses(String prefix, ConcreteSyntax syntax) {
		List<Pair<String, GenClass>> foundClasses = new ArrayList<Pair<String, GenClass>>();
		if (syntax == null) {
			return foundClasses;
		}
		// first add all generator classes contained in the generator package
		// that is referenced by the concrete syntax
		GenPackage genPackage = syntax.getPackage();
		foundClasses.addAll(findAllGenClasses(prefix, genPackage));
		// the add the imported generator classes
		for (Import nextImport : syntax.getImports()) {
			final List<Pair<String, GenClass>> classesInImportedPackage = findAllGenClasses((prefix == null ? "" : prefix + DOT) + nextImport.getPrefix(), nextImport.getPackage());
			foundClasses.addAll(classesInImportedPackage);
		}
		return foundClasses;
	}

	private List<Pair<String, GenClass>> findAllGenClasses(String prefix, GenPackage genPackage) {
		List<Pair<String, GenClass>> foundClasses = new ArrayList<Pair<String, GenClass>>();
		// first add all generator classes in the package itself
		final EList<GenClass> genClasses = genPackage.getGenClasses();
		for (GenClass genClass : genClasses) {
			foundClasses.add(new Pair<String, GenClass>(prefix == null ? "" : prefix + DOT, genClass));
		}
		// then add all generator classes contained in sub packages
		for (GenPackage subPackage : genPackage.getSubGenPackages()) {
			final List<Pair<String, GenClass>> classesInSubPackage = findAllGenClasses((prefix == null ? "" : prefix + DOT) + subPackage.getPrefix(), subPackage);
			foundClasses.addAll(classesInSubPackage);
		}
		return foundClasses;
	}

	private void doResolveStrict(ConcreteSyntax container,
			final String identifier, IResolveResult result) {
		
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
		}, identifier, result);
	}
}

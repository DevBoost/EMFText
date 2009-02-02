package org.emftext.sdk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;

/**
 * A GenClassFinder can be used to look up all generator classes that are 
 * available in a concrete syntax specification. This may include classes
 * from imported generator packages, from imported syntaxes and nested or 
 * used packages of both.
 */
public class GenClassFinder {
	
	public static final String DOT = ".";
	
	/**
	 * Returns all generator classes in the given syntax.
	 * 
	 * @param syntax the syntax to search in
	 * @param includingImports indicates whether included package shall be included in the search
	 * 
	 * @return a found classes
	 */
	public List<GenClass> findAllGenClasses(ConcreteSyntax syntax, boolean includingImports) {
		List<Pair<String, GenClass>> foundClassesAndPrefixes = findAllGenClassesAndPrefixes(syntax, includingImports);
		return convertToGenClassList(foundClassesAndPrefixes);
	}

	/**
	 * Returns all generator classes in the given syntax including their prefixes.
	 * 
	 * @param syntax the syntax to search in
	 * @param includingImports indicates whether included package shall be included in the search
	 * 
	 * @return a found classes
	 */
	public List<Pair<String, GenClass>> findAllGenClassesAndPrefixes(ConcreteSyntax syntax, boolean includingImports) {
		return findAllGenClassesAndPrefixes(null, syntax, includingImports);
	}
	
	private List<Pair<String, GenClass>> findAllGenClassesAndPrefixes(String prefix, ConcreteSyntax syntax, boolean includingImports) {
		List<Pair<String, GenClass>> foundClasses = new ArrayList<Pair<String, GenClass>>();
		if (syntax == null) {
			return foundClasses;
		}
		// first add all generator classes contained in the generator package
		// that is referenced by the concrete syntax
		GenPackage genPackage = syntax.getPackage();
		foundClasses.addAll(findAllGenClassesAndPrefixes(prefix, genPackage));

		// second add classes from used generator packages
	    for (GenPackage usedGenPackage : genPackage.getGenModel().getUsedGenPackages()) {
	    	foundClasses.addAll(findAllGenClassesAndPrefixes(prefix, usedGenPackage));
		}
		
		// then add the imported generator classes
	    if (includingImports) {
	    	foundClasses.addAll(findGenClassesAndPrefixesInImports(prefix, syntax));
	    }
		return foundClasses;
	}

	private List<GenClass> convertToGenClassList(
			final List<Pair<String, GenClass>> foundClassesAndPrefixes) {
		List<GenClass> foundClasses = new ArrayList<GenClass>();
		for (Pair<String, GenClass> prefixAndGenClass : foundClassesAndPrefixes) {
			foundClasses.add(prefixAndGenClass.getRight());
		}
		return foundClasses;
	}
	
	private List<Pair<String, GenClass>> findGenClassesAndPrefixesInImports(String prefix, ConcreteSyntax syntax) {
		List<Pair<String, GenClass>> foundClasses = new ArrayList<Pair<String, GenClass>>();
		for (Import nextImport : syntax.getImports()) {
			final List<Pair<String, GenClass>> classesInImportedPackage = findAllGenClassesAndPrefixes((prefix == null ? "" : prefix + DOT) + nextImport.getPrefix(), nextImport.getPackage());
			foundClasses.addAll(classesInImportedPackage);
		}
		return foundClasses;
	}

	private List<Pair<String, GenClass>> findAllGenClassesAndPrefixes(String prefix, GenPackage genPackage) {
		List<Pair<String, GenClass>> foundClasses = new ArrayList<Pair<String, GenClass>>();
		if(genPackage == null) {
			return foundClasses;
		}
		// first add all generator classes in the package itself
		EList<GenClass> genClasses = genPackage.getGenClasses();
		for (GenClass genClass : genClasses) {
			foundClasses.add(new Pair<String, GenClass>(prefix == null ? "" : prefix + DOT, genClass));
		}
		// then add all generator classes contained in sub packages
		for (GenPackage subPackage : genPackage.getSubGenPackages()) {
			List<Pair<String, GenClass>> classesInSubPackage = findAllGenClassesAndPrefixes((prefix == null ? "" : prefix + DOT) + subPackage.getPrefix(), subPackage);
			foundClasses.addAll(classesInSubPackage);
		}
		return foundClasses;
	}

	public Map<String, Collection<String>> findAllSuperclasses(	Collection<GenClass> allGenClasses) {
		HashMap<String, Collection<String>> genClasses2superNames = new HashMap<String, Collection<String>>();
	    
	    for (GenClass genClass : allGenClasses) {
			Collection<String> supertypes = new LinkedList<String>();
			for (EClass c : genClass.getEcoreClass().getEAllSuperTypes()) {
				supertypes.add(c.getName());
			}
			genClasses2superNames.put(genClass.getEcoreClass().getName(), supertypes);
		}
	    return genClasses2superNames;
	}
}

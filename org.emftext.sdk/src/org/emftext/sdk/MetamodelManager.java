package org.emftext.sdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.GenPackageDependentElement;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.finders.IConcreteSyntaxFinder;
import org.emftext.sdk.finders.IConcreteSyntaxFinderResult;
import org.emftext.sdk.finders.IGenPackageFinder;
import org.emftext.sdk.finders.IGenPackageFinderResult;

/**
 * The MetamodelManager uses finders to search for generator packages and
 * concrete syntaxes.
 */
public class MetamodelManager {
	
	private List<IGenPackageFinder> genPackageFinders = new ArrayList<IGenPackageFinder>();
	private List<IConcreteSyntaxFinder> concreteSyntaxFinders = new ArrayList<IConcreteSyntaxFinder>();
	
	public MetamodelManager() {
		super();
	}
	
	public void addConcreteSyntaxFinder(IConcreteSyntaxFinder finder) {
		if (finder == null) {
			return;
		}
		concreteSyntaxFinders.add(finder);
	}
	
	public void addGenPackageFinder(IGenPackageFinder finder) {
		if (finder == null) {
			return;
		}
		genPackageFinders.add(finder);
	}

	public GenPackage findGenPackage(GenPackageDependentElement container, String nsURI, String locationHint, ITextResource resource) {
		if (nsURI == null) {
			return null;
		}
		
		for (IGenPackageFinder finder : genPackageFinders) {
			IGenPackageFinderResult finderResult = finder.findGenPackage(nsURI, locationHint, container, resource);
			if (finderResult != null) {
				GenPackage foundPackage = finderResult.getResult();
				if (foundPackage != null) {
					return foundPackage;
				}
			}
		}
		return null;
	}

	public ConcreteSyntax findConcreteSyntax(String csName, String locationHint, Import container, GenPackage genPackage, ITextResource textResource) {
		if (csName == null || genPackage == null || genPackage.getEcorePackage() == null) {
			return null;
		}
		
		String csURI = getConcreteSyntaxURI(csName, genPackage);
		for (IConcreteSyntaxFinder finder : concreteSyntaxFinders) {
			IConcreteSyntaxFinderResult finderResult = finder.findConcreteSyntax(csURI, locationHint, container, textResource);
			if (finderResult != null) {
				ConcreteSyntax foundSyntax = finderResult.getConcreteSyntax();
				if (foundSyntax != null) {
					return foundSyntax;
				}
			}
		}
		return null;
	}

	public static String getConcreteSyntaxURI(String csName, GenPackage genPackage) {
		return genPackage.getNSURI() + "%%" + csName;
	}

	public static Map<String, GenPackage> getGenPackages(GenModel genModel) {
		Map<String, GenPackage> genPackages = new HashMap<String, GenPackage>();
		for(GenPackage genPackage : genModel.getGenPackages()) {
			genPackages.putAll(getNestedPackages(genPackage));
		}
		
		// added to resolve imported GenPackages too. 
		for(GenPackage genPackage : genModel.getUsedGenPackages()) {
			if(genPackage.getEcorePackage() != null) {
				genPackages.putAll(getNestedPackages(genPackage));
			}
		}
		return genPackages;
	}


	private static Map<String, GenPackage> getNestedPackages(GenPackage genPackage) {
		
		Map<String, GenPackage> result = new HashMap<String, GenPackage>();
		result.put(genPackage.getNSURI(), genPackage);
		for (GenPackage nextNested : genPackage.getNestedGenPackages()) {
			result.putAll(getNestedPackages(nextNested));
		}
		return result;
	}
}

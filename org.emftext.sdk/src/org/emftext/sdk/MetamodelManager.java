package org.emftext.sdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

// FIXME the cache is not used right now, because new instances of this class are
// created for each request
/**
 * The MetamodelManager uses finders to search for generator packages and
 * concrete syntaxes. Found packages are stored in a cache.
 */
public class MetamodelManager {
	
	private List<IGenPackageFinder> genPackageFinders = new ArrayList<IGenPackageFinder>();
	private MetamodelCache modelCache = new MetamodelCache();
	
	private List<IConcreteSyntaxFinder> concreteSyntaxFinders = new ArrayList<IConcreteSyntaxFinder>();
	
	/**
	 * The MetamodelCache maps namespace URIs to generator packages.
	 */
	private class MetamodelCache {
		
		private Map<String,IGenPackageFinderResult> internalCache = new HashMap<String,IGenPackageFinderResult>();
		
		public boolean isCached(String nsURI) {
			IGenPackageFinderResult result = internalCache.get(nsURI);
			if (result != null) {
				return !result.hasChanged();
			}
			return false;
		}
		
		public GenPackage load(String nsURI) {
			return internalCache.get(nsURI).getResult();
		}
		
		public void store(String nsURI, IGenPackageFinderResult foundPackage) {
			internalCache.put(nsURI, foundPackage);
		}
	}
	
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

	public GenPackage findGenPackage(EObject container, String nsURI, ITextResource resource) {
		if (nsURI == null) {
			return null;
		}
		
		if (modelCache.isCached(nsURI)) {
			return modelCache.load(nsURI);
		}
		
		boolean foundMultiple = false;
		GenPackage foundPackage = null;
		for (IGenPackageFinder finder : genPackageFinders) {
			IGenPackageFinderResult finderResult = finder.findGenPackage(nsURI, resource);
			if (finderResult != null) {
				modelCache.store(nsURI, finderResult);
				if (foundPackage != null || finderResult.foundMultiple()) {
					foundMultiple = true;
				}
				foundPackage = finderResult.getResult();
			}
		}
		if (foundMultiple) {
			resource.addError("Found multiple generator models for URI '" + nsURI + "'.", container);
		}
		return foundPackage;
	}

	public ConcreteSyntax findConcreteSyntax(String csName, EObject container, GenPackage genPackage, ITextResource textResource) {
		if (csName == null || genPackage == null) {
			return null;
		}
		
		String csURI = getConcreteSyntaxURI(csName, genPackage);
		ConcreteSyntax foundSyntax = null;
		boolean foundMultiple = false;
		for (IConcreteSyntaxFinder finder : concreteSyntaxFinders) {
			IConcreteSyntaxFinderResult finderResult = finder.findConcreteSyntax(csURI, textResource);
			//TODO add some check if there are several copies of the same models, maybe prefer copies in same folder...
			if (finderResult != null) {
				if (foundSyntax != null || finderResult.foundMultiple()) {
					foundMultiple = true;
				}
				foundSyntax = finderResult.getConcreteSyntax();
			}
		}
		if (foundMultiple) {
	        textResource.addError("Found multiple CS definitions matching '" + csName + "'.", container);
		}
		return foundSyntax;
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

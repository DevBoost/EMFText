package org.emftext.sdk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ITextResource;

/**
 * A helper class that can be used search for generator packages, 
 * syntaxes and finders.
 */
public class MetamodelHelper {
	
	public final static String GEN_PACKAGE_FINDER_KEY = "GEN_PACKAGE_FINDER";
	public final static String CONCRETE_SYNTAX_FINDER_KEY = "CONCRETE_SYNTAX_FINDER";
	
	public GenPackage findGenPackage(Map<?,?> options, String fragment, ITextResource resource) {
		MetamodelManager mmManager = createMetaModelManager(options);
		return mmManager.findGenPackage(fragment, resource);
	}

	public EObject findConcreteSyntax(Map<?, ?> options, String fragment,
			GenPackage genPackage, ITextResource resource) {
		MetamodelManager mmManager = createMetaModelManager(options);
		return mmManager.findConcreteSyntax(fragment, genPackage, resource);
	}

	private MetamodelManager createMetaModelManager(Map<?, ?> options) {
		MetamodelManager mmManager = new MetamodelManager();
		List<IGenPackageFinder> genPackageFinders = findFinders(options, GEN_PACKAGE_FINDER_KEY, IGenPackageFinder.class);
		for (IGenPackageFinder finder : genPackageFinders) {
			mmManager.addGenPackageFinder(finder);
		}
		List<IConcreteSyntaxFinder> concreteSyntaxFinders = findFinders(options, CONCRETE_SYNTAX_FINDER_KEY, IConcreteSyntaxFinder.class);
		for (IConcreteSyntaxFinder finder : concreteSyntaxFinders) {
			mmManager.addConcreteSyntaxFinder(finder);
		}
		return mmManager;
	}

	@SuppressWarnings("unchecked")
	private <T> List<T> findFinders(Map<?, ?> options, String key, Class<T> type) {
		List<T> finders = new ArrayList<T>();
		if (options == null) {
			return finders;
		}
		if (!options.containsKey(key)) {
			return finders;
		}
		Object value = options.get(key);
		if (value == null) {
			return finders;
		}
		if (type.isInstance(value)) {
			finders.add((T) value);
			return finders;
		}
		if (value instanceof List) {
			List<?> values = (List<?>) value;
			for (Object next : values) {
				if (type.isInstance(next)) {
					finders.add((T) next);
				}
			}
		}
		return finders;
	}
}

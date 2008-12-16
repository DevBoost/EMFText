package org.emftext.sdk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ITextResource;

public class MetamodelHelper {
	
	public final static String GEN_PACKAGE_FINDER_KEY = "GEN_PACKAGE_FINDER";
	
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
		List<IGenPackageFinder> finders = findGenPackageFinder(options);
		for (IGenPackageFinder finder : finders) {
			mmManager.addGenPackageFinder(finder);
		}
		return mmManager;
	}

	private List<IGenPackageFinder> findGenPackageFinder(Map<?, ?> options) {
		List<IGenPackageFinder> finders = new ArrayList<IGenPackageFinder>();
		if (options == null) {
			return finders;
		}
		if (!options.containsKey(GEN_PACKAGE_FINDER_KEY)) {
			return finders;
		}
		Object value = options.get(GEN_PACKAGE_FINDER_KEY);
		if (value == null) {
			return finders;
		}
		if (value instanceof IGenPackageFinder) {
			finders.add((IGenPackageFinder) value);
			return finders;
		}
		if (value instanceof List) {
			List<?> values = (List<?>) value;
			for (Object next : values) {
				if (next instanceof IGenPackageFinder) {
					finders.add((IGenPackageFinder) next);
				}
			}
		}
		return finders;
	}
}

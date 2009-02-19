package org.emftext.sdk.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.emftext.runtime.IOptionProvider;
import org.emftext.sdk.MetamodelHelper;
import org.emftext.sdk.finders.ConcreteSyntaxByHintFinder;
import org.emftext.sdk.finders.ConcreteSyntaxInRegistryFinder;
import org.emftext.sdk.finders.GenPackageByHintFinder;
import org.emftext.sdk.finders.GenPackageByNameFinder;
import org.emftext.sdk.finders.GenPackageInRegistryFinder;
import org.emftext.sdk.finders.IConcreteSyntaxFinder;
import org.emftext.sdk.finders.IGenPackageFinder;

/**
 * A provider for different load options used by the SDK of
 * EMFText. Among these are various finders for generator 
 * packages.
 */
public class SDKOptionProvider implements IOptionProvider {

	public SDKOptionProvider() {
		super();
	}

	public Map<?, ?> getOptions() {
		List<IGenPackageFinder> genPackageFinders = new ArrayList<IGenPackageFinder>(2);
		genPackageFinders.add(new GenPackageByHintFinder());
		genPackageFinders.add(new GenPackageByNameFinder());
		genPackageFinders.add(new GenPackageInRegistryFinder());
		
		List<IConcreteSyntaxFinder> concreteSyntaxFinders = new ArrayList<IConcreteSyntaxFinder>(2);
		concreteSyntaxFinders.add(new ConcreteSyntaxByHintFinder());
		concreteSyntaxFinders.add(new ConcreteSyntaxInRegistryFinder());
		
		Map<String, List<? extends Object>> options = new HashMap<String, List<? extends Object>>();
		options.put(MetamodelHelper.GEN_PACKAGE_FINDER_KEY, genPackageFinders);
		options.put(MetamodelHelper.CONCRETE_SYNTAX_FINDER_KEY, concreteSyntaxFinders);
		return options;
	}
}

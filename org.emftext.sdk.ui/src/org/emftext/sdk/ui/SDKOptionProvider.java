package org.emftext.sdk.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.emftext.runtime.IOptionProvider;
import org.emftext.sdk.ConcreteSyntaxInRegistryFinder;
import org.emftext.sdk.ConcreteSyntaxInWorkspaceFinder;
import org.emftext.sdk.GenPackageInRegistryFinder;
import org.emftext.sdk.GenPackageInWorkspaceFinder;
import org.emftext.sdk.IConcreteSyntaxFinder;
import org.emftext.sdk.IGenPackageFinder;
import org.emftext.sdk.MetamodelHelper;

public class SDKOptionProvider implements IOptionProvider {

	public SDKOptionProvider() {
		super();
	}

	public Map<?, ?> getOptions() {
		List<IGenPackageFinder> genPackageFinders = new ArrayList<IGenPackageFinder>(2);
		genPackageFinders.add(new GenPackageInWorkspaceFinder());
		genPackageFinders.add(new GenPackageInRegistryFinder());
		
		List<IConcreteSyntaxFinder> concreteSyntaxFinders = new ArrayList<IConcreteSyntaxFinder>(2);
		concreteSyntaxFinders.add(new ConcreteSyntaxInWorkspaceFinder());
		concreteSyntaxFinders.add(new ConcreteSyntaxInRegistryFinder());
		
		Map<String, List<? extends Object>> options = new HashMap<String, List<? extends Object>>();
		options.put(MetamodelHelper.GEN_PACKAGE_FINDER_KEY, genPackageFinders);
		options.put(MetamodelHelper.CONCRETE_SYNTAX_FINDER_KEY, concreteSyntaxFinders);
		return options;
	}
}

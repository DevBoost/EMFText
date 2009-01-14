package org.emftext.sdk.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.emftext.runtime.IOptionProvider;
import org.emftext.sdk.GenPackageInRegistryFinder;
import org.emftext.sdk.GenPackageInWorkspaceFinder;
import org.emftext.sdk.IGenPackageFinder;
import org.emftext.sdk.MetamodelHelper;

public class SDKOptionProvider implements IOptionProvider {

	public SDKOptionProvider() {
		super();
	}

	public Map<?, ?> getOptions() {
		List<IGenPackageFinder> finders = new ArrayList<IGenPackageFinder>(2);
		finders.add(new GenPackageInWorkspaceFinder());
		finders.add(new GenPackageInRegistryFinder());
		
		Map<String, List<IGenPackageFinder>> options = new HashMap<String, List<IGenPackageFinder>>();
		options.put(MetamodelHelper.GEN_PACKAGE_FINDER_KEY, finders);
		return options;
	}
}

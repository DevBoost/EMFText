package org.reuseware.emftextedit.sdk.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.reuseware.emftextedit.runtime.ui.OptionProvider;
import org.reuseware.emftextedit.sdk.GenPackageFinder;
import org.reuseware.emftextedit.sdk.GenPackageInRegistryFinder;
import org.reuseware.emftextedit.sdk.GenPackageInWorkspaceFinder;
import org.reuseware.emftextedit.sdk.MetamodelHelper;

public class DefaultOptionProvider implements OptionProvider {

	public DefaultOptionProvider() {
		super();
	}

	public Map<?, ?> getOptions() {
		List<GenPackageFinder> finders = new ArrayList<GenPackageFinder>(2);
		finders.add(new GenPackageInWorkspaceFinder());
		finders.add(new GenPackageInRegistryFinder());
		
		Map<String, List<GenPackageFinder>> options = new HashMap<String, List<GenPackageFinder>>();
		options.put(MetamodelHelper.GEN_PACKAGE_FINDER_KEY, finders);
		return options;
	}
}

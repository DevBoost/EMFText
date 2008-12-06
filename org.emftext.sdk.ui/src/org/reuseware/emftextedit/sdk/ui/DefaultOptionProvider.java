package org.reuseware.emftextedit.sdk.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.reuseware.emftextedit.runtime.IOptionProvider;
import org.reuseware.emftextedit.sdk.IGenPackageFinder;
import org.reuseware.emftextedit.sdk.GenPackageInRegistryFinder;
import org.reuseware.emftextedit.sdk.GenPackageInWorkspaceFinder;
import org.reuseware.emftextedit.sdk.MetamodelHelper;

public class DefaultOptionProvider implements IOptionProvider {

	public DefaultOptionProvider() {
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

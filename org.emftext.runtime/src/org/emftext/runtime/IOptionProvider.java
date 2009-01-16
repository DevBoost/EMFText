package org.emftext.runtime;

import java.util.Map;

public interface IOptionProvider {
	
	public static final String CS_NAME = "csName";
	
	public Map<?,?> getOptions();
}

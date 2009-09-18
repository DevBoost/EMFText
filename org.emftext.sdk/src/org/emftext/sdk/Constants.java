package org.emftext.sdk;

import org.emftext.runtime.resource.IReferenceResolver;
import org.emftext.runtime.resource.ITokenResolver;

public interface Constants {
	public String JAVA_FILE_EXTENSION = ".java";

	public String CLASS_SUFFIX_TOKEN_RESOLVER = ITokenResolver.class.getSimpleName().substring(1);
	public String CLASS_SUFFIX_REFERENCE_RESOLVER = IReferenceResolver.class.getSimpleName().substring(1);
	public String CLASS_SUFFIX_DEFAULT_RESOLVER_DELEFATE = "DefaultResolverDelegate";

	public String UI_PACKAGE = "ui";
}

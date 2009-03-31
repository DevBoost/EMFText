package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.io.InputStream;

public interface IArtifact {

	public File getTargetFile();
	public InputStream getContentStream();
}

package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.io.InputStream;

/**
 * A common interface for all artifacts that are generated.
 */
public interface IArtifact {

	public File getTargetFile();
	public InputStream getContentStream();
}

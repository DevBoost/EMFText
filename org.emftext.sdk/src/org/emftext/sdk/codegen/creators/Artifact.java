package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.io.InputStream;

/**
 * A default implementation of the IArtifact interface holding the
 * target file and the content stream.
 */
public class Artifact implements IArtifact {

	private File targetFile;
	private InputStream contentStream;
	
	public Artifact(File targetFile, InputStream contentStream) {
		super();
		this.targetFile = targetFile;
		this.contentStream = contentStream;
	}

	public File getTargetFile() {
		return targetFile;
	}

	public InputStream getContentStream() {
		return contentStream;
	}
}

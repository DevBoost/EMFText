package org.emftext.runtime;

import java.io.InputStream;

public interface InputStreamProcessorProvider {
	public InputStreamProcessor getInputStreamProcessor(InputStream inputStream);
}

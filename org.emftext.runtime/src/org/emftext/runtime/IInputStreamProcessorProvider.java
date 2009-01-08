package org.emftext.runtime;

import java.io.InputStream;

public interface IInputStreamProcessorProvider {
	public InputStreamProcessor getInputStreamProcessor(InputStream inputStream);
}

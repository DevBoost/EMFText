package org.emftext.sdk.concretesyntax.resource.cs;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

public class CsResourceImpl extends org.emftext.runtime.resource.impl.AbstractTextResource {
	private org.emftext.runtime.resource.IReferenceResolver analyser;


	public CsResourceImpl() {
		super();
	}

	public CsResourceImpl(URI uri) {
		super(uri);
	}

	protected void doLoad(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		java.io.InputStream actualInputStream = inputStream;
		Object inputStreamPreProcessorProvider = options.get(org.emftext.runtime.IOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER);
		if (inputStreamPreProcessorProvider != null) {
			if (inputStreamPreProcessorProvider instanceof org.emftext.runtime.IInputStreamProcessorProvider) {
				actualInputStream = ((org.emftext.runtime.IInputStreamProcessorProvider) inputStreamPreProcessorProvider).getInputStreamProcessor(inputStream);
			}
		}
		org.emftext.runtime.resource.ITextParser p = new CsParser(new org.antlr.runtime.CommonTokenStream(new CsLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream))));
		p.setResource(this);
		p.setOptions(options);
		EObject root = p.parse();
		while (root != null) {
			getContents().add(root);
			root = null;
		}

		org.emftext.runtime.resource.IConfigurable analyser = getReferenceResolverSwitch();

		analyser.setOptions(options);
	}
	
	protected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {
		org.emftext.runtime.resource.ITextPrinter p = new CsPrinter(outputStream, this);
		for(EObject root : getContents()) {
			p.print(root);
		}
	}

	public String[] getTokenNames() {
		return new CsParser(null).getTokenNames();
	}

	public Object getScanner() {
		return new CsLexer();
	}

	public org.emftext.runtime.resource.IReferenceResolver getReferenceResolverSwitch() {
		if (analyser == null) {
			analyser = new CsTreeAnalyser();
		}
		return analyser;
	}

	public void doUnload(){
		super.doUnload();
		analyser=null;
	}
}

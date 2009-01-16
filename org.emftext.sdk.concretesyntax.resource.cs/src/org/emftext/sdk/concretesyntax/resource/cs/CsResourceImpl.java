package org.emftext.sdk.concretesyntax.resource.cs;

public class CsResourceImpl extends org.emftext.runtime.resource.impl.AbstractTextResource {
	private org.emftext.runtime.resource.IReferenceResolver resolverSwitch;


	public CsResourceImpl() {
		super();
	}

	public CsResourceImpl(org.eclipse.emf.common.util.URI uri) {
		super(uri);
	}

	protected void doLoad(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		java.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(options);
		java.io.InputStream actualInputStream = inputStream;
		Object inputStreamPreProcessorProvider = loadOptions.get(org.emftext.runtime.IOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER);
		if (inputStreamPreProcessorProvider != null) {
			if (inputStreamPreProcessorProvider instanceof org.emftext.runtime.IInputStreamProcessorProvider) {
				actualInputStream = ((org.emftext.runtime.IInputStreamProcessorProvider) inputStreamPreProcessorProvider).getInputStreamProcessor(inputStream);
			}
		}
		org.emftext.runtime.resource.ITextParser p = new CsParser(new org.antlr.runtime.CommonTokenStream(new CsLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream))));
		p.setResource(this);
		p.setOptions(loadOptions);
		org.eclipse.emf.ecore.EObject root = p.parse();
		while (root != null) {
			getContents().add(root);
			root = null;
		}

		org.emftext.runtime.resource.IConfigurable resolverSwitch = getReferenceResolverSwitch();

		resolverSwitch.setOptions(loadOptions);
	}

	protected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {
		org.emftext.runtime.resource.ITextPrinter p = new CsPrinter(outputStream, this);
		for(org.eclipse.emf.ecore.EObject root : getContents()) {
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
		if (resolverSwitch == null) {
			resolverSwitch = new CsReferenceResolverSwitch();
		}
		return resolverSwitch;
	}

	public void doUnload(){
		super.doUnload();
		resolverSwitch = null;
	}

	@Override
	protected String getSyntaxName() {
		return "cs";
	}
}

package org.emftext.sdk.concretesyntax.resource.cs;

public class CsResource extends org.emftext.runtime.resource.impl.AbstractTextResource {
	
	private org.emftext.runtime.resource.IReferenceResolverSwitch resolverSwitch;
	
	public CsResource() {
		super();
	}
	
	public CsResource(org.eclipse.emf.common.util.URI uri) {
		super(uri);
	}
	
	protected void doLoad(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		resetLocationMap();
		java.lang.String encoding = null;
		java.io.InputStream actualInputStream = inputStream;
		java.lang.Object inputStreamPreProcessorProvider = null;
		if (options!=null) {
			inputStreamPreProcessorProvider = options.get(org.emftext.runtime.IOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER);
		}
		if (inputStreamPreProcessorProvider != null) {
			if (inputStreamPreProcessorProvider instanceof org.emftext.runtime.IInputStreamProcessorProvider) {
				org.emftext.runtime.IInputStreamProcessorProvider provider = (org.emftext.runtime.IInputStreamProcessorProvider) inputStreamPreProcessorProvider;
				org.emftext.runtime.InputStreamProcessor processor = provider.getInputStreamProcessor(inputStream);
				actualInputStream = processor;
				encoding = processor.getOutputEncoding();
			}
		}
		
		org.emftext.sdk.concretesyntax.resource.cs.CsParser parser;
		if (encoding == null) {
			parser = new CsParser(new org.antlr.runtime.CommonTokenStream(new CsLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream))));
		} else {
			parser = new CsParser(new org.antlr.runtime.CommonTokenStream(new CsLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream, encoding))));
		}
		parser.setResource(this);
		parser.setOptions(options);
		org.emftext.runtime.resource.IReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		referenceResolverSwitch.setOptions(options);
		parser.setReferenceResolverSwitch((org.emftext.sdk.concretesyntax.resource.cs.CsReferenceResolverSwitch) referenceResolverSwitch);
		org.eclipse.emf.ecore.EObject root = parser.parse();
		if (root != null) {
			getContents().add(root);
		}
		getReferenceResolverSwitch().setOptions(options);
		runPostProcessors(options);
	}
	
	protected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {
		org.emftext.sdk.concretesyntax.resource.cs.CsPrinter printer = new org.emftext.sdk.concretesyntax.resource.cs.CsPrinter(outputStream, this);
		org.emftext.runtime.resource.IReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		referenceResolverSwitch.setOptions(options);
		printer.setReferenceResolverSwitch((org.emftext.sdk.concretesyntax.resource.cs.CsReferenceResolverSwitch) referenceResolverSwitch);
		for(org.eclipse.emf.ecore.EObject root : getContents()) {
			printer.print(root);
		}
	}
	
	public String[] getTokenNames() {
		return new CsParser(null).getTokenNames();
	}
	
	@Override 	protected String getSyntaxName() {
		return "cs";
	}
	
	public Object getScanner() {
		return new CsLexer();
	}
	
	public org.emftext.runtime.resource.IReferenceResolverSwitch getReferenceResolverSwitch() {
		if (resolverSwitch == null) {
			resolverSwitch = new org.emftext.sdk.concretesyntax.resource.cs.CsReferenceResolverSwitch();
		}
		return resolverSwitch;
	}
	
	protected void doUnload(){
		super.doUnload();
		resolverSwitch = null;
	}

	public org.emftext.runtime.resource.ITokenStyle getDefaultTokenStyle(java.lang.String tokenName) {
		return null;
	}
}

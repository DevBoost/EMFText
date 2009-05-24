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
		
		org.emftext.runtime.resource.ITextParser parser = new org.emftext.sdk.concretesyntax.resource.cs.CsParser().createInstance(actualInputStream, encoding);
		parser.setResource(this);
		parser.setOptions(options);
		org.emftext.runtime.resource.IReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		referenceResolverSwitch.setOptions(options);
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
		if ("NUMBER".equals(tokenName)) {
			return new org.emftext.runtime.resource.impl.BasicTokenStyle(new int[] {0x00, 0xD0, 0xFF}, false, false, false, false);
		}
		if ("HEXNUMBER".equals(tokenName)) {
			return new org.emftext.runtime.resource.impl.BasicTokenStyle(new int[] {0x00, 0xD0, 0xFF}, false, false, false, false);
		}
		if ("DEFINE".equals(tokenName)) {
			return new org.emftext.runtime.resource.impl.BasicTokenStyle(new int[] {0xFF, 0x90, 0x00}, true, false, false, false);
		}
		if ("PREDEFINED".equals(tokenName)) {
			return new org.emftext.runtime.resource.impl.BasicTokenStyle(new int[] {0xFF, 0x90, 0x00}, true, false, false, false);
		}
		if ("COMMENTS".equals(tokenName)) {
			return new org.emftext.runtime.resource.impl.BasicTokenStyle(new int[] {0x00, 0x80, 0x00}, false, false, false, false);
		}
		return null;
	}
}

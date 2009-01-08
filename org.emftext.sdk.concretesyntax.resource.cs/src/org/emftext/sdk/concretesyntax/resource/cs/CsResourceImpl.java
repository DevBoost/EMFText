package org.emftext.sdk.concretesyntax.resource.cs;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
import org.emftext.sdk.concretesyntax.STAR;
import org.emftext.sdk.concretesyntax.Sequence;

public class CsResourceImpl extends org.emftext.runtime.resource.impl.TextResourceImpl {
	private org.emftext.runtime.resource.IReferenceResolver analyser;


	public CsResourceImpl() {
		super();
	}

	public CsResourceImpl(URI uri) {
		super(uri);
	}

	protected void doLoad(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		java.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(options);
		java.io.InputStream actualInputStream = inputStream;
		Object inputStreamPreProcessorProvider = loadOptions.get(org.emftext.runtime.IOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER);
		if (inputStreamPreProcessorProvider != null) {
			if (inputStreamPreProcessorProvider instanceof org.emftext.runtime.InputStreamProcessorProvider) {
				actualInputStream = ((org.emftext.runtime.InputStreamProcessorProvider) inputStreamPreProcessorProvider).getInputStreamProcessor(inputStream);
			}
		}
		org.emftext.runtime.resource.ITextParser p = new CsParser(new org.antlr.runtime.CommonTokenStream(new CsLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream))));
		p.setResource(this);
		p.setOptions(loadOptions);
		EObject root = p.parse();
		while (root != null) {
			getContents().add(root);
			root = null;
		}

		org.emftext.runtime.resource.IConfigurable analyser = getTreeAnalyser();

		analyser.setOptions(loadOptions);

		checkForOptionalKeywords();
	}
	
	private static final String OPTIONAL_KEYWORD_WARNING = 
		"The keyword might be used stand alone and will not be reprinted in such case: ";
	
	protected void checkForOptionalKeywords() {
		for(Iterator<EObject> i = getAllContents(); i.hasNext(); ) {
			EObject next = i.next();
			if (next instanceof CompoundDefinition) {
				CompoundDefinition compoundDefinition = (CompoundDefinition) next;
				if (compoundDefinition.getCardinality() instanceof QUESTIONMARK) {
					for (Sequence sequence : compoundDefinition.getDefinitions().getOptions()) {
						boolean containsKeyword = false;
						boolean restOptional = true;
						
						for (Definition definition : sequence.getParts()) {
							
							if (definition instanceof CsString) {
								containsKeyword = true;
							}
							else if (!(definition.getCardinality() instanceof QUESTIONMARK ||
									definition.getCardinality() instanceof STAR)) {
								restOptional = false;
							}
						}
						if(containsKeyword && restOptional) {
							for (Definition definition : sequence.getParts()) {
								if (definition instanceof CsString) {
									CsString csString = (CsString) definition;
									addWarning(
											OPTIONAL_KEYWORD_WARNING + csString.getValue(),
											definition);
								}
							}
						}
					}
				}
			}
		}
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

	public org.emftext.runtime.resource.IReferenceResolver getTreeAnalyser() {
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

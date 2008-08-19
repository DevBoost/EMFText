package org.reuseware.emftextedit.resource.impl;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.reuseware.emftextedit.resource.EMFTextOCLValidator;
import org.reuseware.emftextedit.resource.TextDiagnostic;
import org.reuseware.emftextedit.resource.TextResource;

/**
 * Base implementation for all generated text resources. 
 * It implements the specifications from {@link TextResource}.
 * 
 * @author Jendrik Johannes (jj2)
 */
public class TextResourceImpl extends ResourceImpl implements TextResource {
	
	protected EMap<EObject, Integer> columnInfo    = new BasicEMap<EObject, Integer>();
	protected EMap<EObject, Integer> lineInfo      = new BasicEMap<EObject, Integer>();
	protected EMap<EObject, Integer> charStartInfo = new BasicEMap<EObject, Integer>();
	protected EMap<EObject, Integer> charEndInfo   = new BasicEMap<EObject, Integer>();	
	
	/**
	 * Extends the super implementation by clearing all information about element
	 * positions.
	 */
	public void doUnload() {
		super.doUnload();
		
		//clear concrete syntax information
		columnInfo.clear();
		lineInfo.clear();
		charStartInfo.clear();
		charEndInfo.clear();
		
		
	}
	

	@Override
	public void load(Map<?, ?> options) throws IOException {
		super.load(options);
		
		EList<EObject> contents = getContents();
		EMFTextOCLValidator oclValidator = new EMFTextOCLValidator();
		Set<EObject> distinctObjects = new HashSet<EObject>();
		distinctObjects.addAll(contents);
		for (EObject eobject : distinctObjects) {
			// TODO check if this leads to performance problems  
			// - due to traversing some objects more than once
		
			oclValidator.analyse(eobject);
		}
	}


	/**
	 * Creates a empty instance.
	 */
	public TextResourceImpl() {
		super();
	}

	/**
	 * Creates an instance with the given URI.
	 * 
	 * @param uri The URI.
	 */
	public TextResourceImpl(URI uri) {
		super(uri);	
	}
	  
	public void setElementLine(EObject element, int line) {
		if (element == null) return;
		if (lineInfo.containsKey(element)) return;
		lineInfo.put(element, line);
	}
	
	public int getElementLine(EObject element) {
		if (!lineInfo.containsKey(element)) return -1;
		return lineInfo.get(element);
	}
	
	public void setElementColumn(EObject element, int column) {
		if (element == null) return;
		if (columnInfo.containsKey(element)) return;
		columnInfo.put(element, column);
	}	
	
	public int getElementColumn(EObject element) {
		if (!columnInfo.containsKey(element)) return -1;
		return columnInfo.get(element);
	}
	
	public void setElementCharStart(EObject element, int charStart) {
		if (element == null) return;
		if (charStartInfo.containsKey(element)) return;
		charStartInfo.put(element, charStart);
	}	
	
	public int getElementCharStart(EObject element) {
		if (!charStartInfo.containsKey(element)) return -1;
		return charStartInfo.get(element);
	}	
	
	public void setElementCharEnd(EObject element, int charEnd) {
		if (element == null) return;
		if (charEndInfo.containsKey(element)) {
			if (charEndInfo.get(element) > charEnd) return;
		}
		charEndInfo.put(element, charEnd);
	}	
	
	public int getElementCharEnd(EObject element) {
		if (!charEndInfo.containsKey(element)) return -1;
		return charEndInfo.get(element);
	}	
	
	public void addError(String message, EObject element) {
		getErrors().add(new ElementBasedTextDiagnosticImpl(message, element));
	}
	
	public void addWarning(String message, EObject element) {
		getWarnings().add(new ElementBasedTextDiagnosticImpl(message, element));
	}
	
	public void addError(String message, int column, int line, int charStart,
			int charEnd) {
		getErrors().add(new PositionBasedTextDiagnosticImpl(message, column, line, charStart, charEnd));
		
	}

	public void addWarning(String message, int column, int line, int charStart,
			int charEnd) {
		getWarnings().add(new PositionBasedTextDiagnosticImpl(message, column, line, charStart, charEnd));
	}
	
	public String[] getTokenNames() {
		return new String[]{};
	}
	
	public Object getScanner() {
		return null;
	}
	
	public class ElementBasedTextDiagnosticImpl implements TextDiagnostic {

		protected EObject element;
		protected String message;
		
		protected ElementBasedTextDiagnosticImpl(String message, EObject element) {
			this.element = element;
			this.message = message;
		}
		
		public int getCharStart() {
			if (!charStartInfo.containsKey(element)) return 0;
			return charStartInfo.get(element);
		}
		
		public int getCharEnd() {
			if (!charEndInfo.containsKey(element)) return 0;
			return charEndInfo.get(element);
		}
		
		public int getColumn() {
			if (!columnInfo.containsKey(element)) return 0;
			return columnInfo.get(element);
		}

		public int getLine() {
			if (!lineInfo.containsKey(element)) return 0;
			return lineInfo.get(element);
		}

		public String getLocation() {
			return getURI().toString();
		}

		public String getMessage() {
			return message;
		}
		
	}
	
	public class PositionBasedTextDiagnosticImpl implements TextDiagnostic {

		protected int column;
		protected int line;
		protected int charStart;
		protected int charEnd;
		protected String message;
		
		protected PositionBasedTextDiagnosticImpl(String message,int column, int line, int charStart,
				int charEnd) {
			
			this.column = column;
			this.line = line;
			this.charStart = charStart;
			this.charEnd = charEnd;
			this.message = message;
		}
		
		public int getCharStart() {
			return charStart;
		}
		
		public int getCharEnd() {
			return charEnd;
		}
		
		public int getColumn() {
			return column;
		}

		public int getLine() {
			return line;
		}

		public String getLocation() {
			return getURI().toString();
		}

		public String getMessage() {
			return message;
		}
	}
}

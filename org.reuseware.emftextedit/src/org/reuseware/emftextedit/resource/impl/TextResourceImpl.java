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
	 * Used during {@link #load(java.util.Map)} to determine whether OCL
	 * constraints should be validated.
	 */
	public static final String OPTION_NO_VALIDATE = "TR_NO_VALIDATE_OCL"; 
	
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

		if (options != null
				&& Boolean.TRUE.equals(options
						.get(TextResourceImpl.OPTION_NO_VALIDATE))) {
		} else {
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
	  
	private int getMapValue(EMap<EObject, Integer> map, EObject element) {
		if (!map.containsKey(element)) return -1;
		return map.get(element);
	}
	
	private void setMapValue(EMap<EObject, Integer> map, EObject element, int line) {
		if (element == null) return;
		if (map.containsKey(element)) return;
		map.put(element, line);
	}
	
	public void setElementLine(EObject element, int line) {
		setMapValue(lineInfo, element, line);
	}

	public int getElementLine(EObject element) {
		return getMapValue(lineInfo, element);
	}

	public void setElementColumn(EObject element, int column) {
		setMapValue(columnInfo, element, column);
	}	
	
	public int getElementColumn(EObject element) {
		return getMapValue(columnInfo, element);
	}
	
	public void setElementCharStart(EObject element, int charStart) {
		setMapValue(charStartInfo, element, charStart);
	}	
	
	public int getElementCharStart(EObject element) {
		return getMapValue(charStartInfo, element);
	}	
	
	public void setElementCharEnd(EObject element, int charEnd) {
		if (element == null) return;
		if (charEndInfo.containsKey(element)) {
			// TODO jjohannes: this is strange behavior since
			// it deviates from the other set methods. maybe 
			// this code should be better placed in callers of
			// this method?
			if (charEndInfo.get(element) > charEnd) return;
		}
		charEndInfo.put(element, charEnd);
	}	
	
	public int getElementCharEnd(EObject element) {
		return getMapValue(charEndInfo, element);
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
	
	// TODO jjohannes: should we replace this method with an abstract one?
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
		
		private int getMapValue(EMap<EObject,Integer> map) {
			if (!map.containsKey(element)) {
				return 0;
			}
			return map.get(element);
		}
		
		public int getCharStart() {
			return getMapValue(charStartInfo);
		}

		public int getCharEnd() {
			return getMapValue(charEndInfo);
		}
		
		public int getColumn() {
			return getMapValue(columnInfo);
		}

		public int getLine() {
			return getMapValue(lineInfo);
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

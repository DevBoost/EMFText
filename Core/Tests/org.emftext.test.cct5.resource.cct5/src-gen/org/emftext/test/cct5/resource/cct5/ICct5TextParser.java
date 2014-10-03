/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5;

import java.util.List;
import org.eclipse.emf.ecore.EClass;

/**
 * A text parser parses a text into a tree of <code>EObject</code>s. It is
 * associated with a <code>TextResource</code>.
 */
public interface ICct5TextParser extends org.emftext.test.cct5.resource.cct5.ICct5Configurable {
	
	/**
	 * <p>
	 * Parses the content given to the parser and create a tree of EObjects. The root
	 * of this tree is wrapped together with some commands that might be executed
	 * after parsing into a result object.
	 * </p>
	 * 
	 * @return the result of the parse process
	 */
	public org.emftext.test.cct5.resource.cct5.ICct5ParseResult parse();
	
	/**
	 * <p>
	 * Parses the document and returns a list of expected elements. Each expected
	 * element covers a range in the input stream.
	 * </p>
	 * <p>
	 * If the parser implementation can not determine expected elements null can be
	 * returned. This method is used by the code completion to figure out which
	 * proposals can be shown to users for a given cursor position. The class
	 * <code>type</code> is used as start symbol. If <code>type</code> is
	 * <code>null</code>, the start symbols from the syntax specification are used.
	 * The <code>cursorPosition</code> is used to discard expected elements, which
	 * will not be needed.
	 * </p>
	 */
	public List<org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedTerminal> parseToExpectedElements(EClass type, org.emftext.test.cct5.resource.cct5.ICct5TextResource dummyResource, int cursorOffset);
	
	/**
	 * Signals the parse to terminate parsing as soon as possible. This method must be
	 * called from a different thread than the one calling parse().
	 */
	public void terminate();
	
}

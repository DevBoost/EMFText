package org.reuseware.emftextedit.resource;

import org.eclipse.emf.ecore.EObject;

/**
 * A text parser parses a text into a tree of <code>EObject</code>s.
 * It is associated with a <code>TextResource</code>.
 * 
 * @author Jendrik Johannes (jj2)
 *
 */
public interface EMFTextParser {

	/**
	 * Set the associate text resource.
	 * 
	 * @param resource The text resource.
	 */
    public void setResource(TextResource resource);
    
    /**
     * Get the associated text resource.
     * 
     * @return The text resource.
     */
    public TextResource getResource();
    
    /**
     * Return the root element of the <code>EObject</code>-Tree. 
     * Parse some content if this is necessary to obtain the tree.
     * 
     * @return The root object.
     */
	public EObject parse();
}

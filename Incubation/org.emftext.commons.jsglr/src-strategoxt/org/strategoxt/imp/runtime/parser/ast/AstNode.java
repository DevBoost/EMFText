package org.strategoxt.imp.runtime.parser.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lpg.runtime.IAst;
import lpg.runtime.IAstVisitor;
import lpg.runtime.IPrsStream;
import lpg.runtime.IToken;

import org.eclipse.core.resources.IResource;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermPrinter;
import org.spoofax.interpreter.terms.InlinePrinter;
//import org.strategoxt.imp.runtime.Environment;
import org.strategoxt.imp.runtime.parser.tokens.SGLRToken;
//import org.strategoxt.imp.runtime.stratego.adapter.IStrategoAstNode;

/**
 * A node of an SGLR abstract syntax tree.
 *
 * @author Lennart Kats <L.C.L.Kats add tudelft.nl>
 */
public class AstNode implements IAst, Iterable<AstNode> {
	// Globally unique object (circumvent interning)

	/** The sort name for strings. */
	public static final String STRING_SORT = new String("<string>");

	// TODO2: Read-only array list
	static final ArrayList<AstNode> EMPTY_LIST = new ArrayList<AstNode>(0);
	
	protected final ArrayList<AstNode> children;
	
	private final String sort;
	
	private String constructor;
	
	private IStrategoTerm term;
	
	private IToken leftToken, rightToken;
	
	private AstNode parent;
		
	// Accessors
	
	/**
	 * Returns the constructor name of this node, or null if not applicable. 
	 */
	public String getConstructor() {
		return constructor;
	}
	
	public void setConstructor(String constructor) {
		this.constructor = constructor;
	}
	
	public String getSort() {
		return sort;
	}
	
	public boolean isList() {
		return false;
	}
	
	public IResource getResource() {
		return getRoot().getResource();
	}
	
	// (concrete type exposed by IAst interface)
	public final ArrayList<AstNode> getChildren() {
		assert EMPTY_LIST.size() == 0;
		
		return children;
	}

	/** Get the leftmost token associated with this node. */
	public IToken getLeftIToken() {
		return leftToken;
	}

	/** Get the leftmost token associated with this node. */
	public IToken getRightIToken() {
		return rightToken;
	}

	/** Set the leftmost token associated with this node. */
	protected void setLeftIToken(IToken value) {
		leftToken = value;
	}

	/** Set the leftmost token associated with this node. */
	protected void setRightIToken(IToken value) {
		rightToken = value;
	}

	public AstNode getParent() {
		return parent;
	}

	private void setParent(AstNode value) {
		parent = value;
	}
	
	public RootAstNode getRoot() {
		AstNode result = this;
		while (result.getParent() != null)
			result = result.getParent();
		if (!(result instanceof RootAstNode))
			throw new IllegalStateException("Tree not initialized using RootAstNode.create()");
		else
			return (RootAstNode) result;
	}
	
	public IStrategoTerm getTerm() {
//		if (term != null) return term;
		//else return Environment.getTermFactory().wrap(this);
		return term;
	}
	
	// Initialization
	
	/**
	 * Create a new AST node and set it to be the parent node of its children.
	 */
	public AstNode(String sort, IToken leftToken, IToken rightToken, String constructor,
			ArrayList<AstNode> children) {
		
		assert children != null;
		
		this.constructor = constructor;
		this.sort = sort;
		this.leftToken = leftToken;
		this.rightToken = rightToken;
		this.children = children;
		
		if (leftToken != null)
			setReferences(leftToken, rightToken, children);
	}

	private void setReferences(IToken leftToken, IToken rightToken, ArrayList<AstNode> children) {
		IPrsStream parseStream = leftToken.getIPrsStream();
		int tokenIndex = leftToken.getTokenIndex();
		int endTokenIndex = rightToken.getTokenIndex();

		// Set ast node for tokens before children, and set parent references
		for (int childIndex = 0, size = children.size(); childIndex < size; childIndex++) {
			AstNode child = children.get(childIndex);
			child.setParent(this);
			
			int childStart = child.getLeftIToken().getTokenIndex();
			int childEnd = child.getRightIToken().getTokenIndex();
			
			while (tokenIndex < childStart) {
				SGLRToken token = (SGLRToken) parseStream.getTokenAt(tokenIndex++);
				if (token.getAstNode() == null)
					token.setAstNode(this);
			}
			
			tokenIndex = childEnd + 1; 
		}
		
		// Set ast node for tokens after children
		while (tokenIndex <= endTokenIndex) {
			SGLRToken token = (SGLRToken) parseStream.getTokenAt(tokenIndex++);
			token.setAstNode(this);
		}
	}
	
	// General access
	
	public Iterator<AstNode> iterator() {
		return children.iterator();
	}
	
	// map(getSort)
	public static List<String> getSorts(List<? extends AstNode> children) {
  	  List<String> result = new ArrayList<String>(children.size());
  	  
  	  for (AstNode node : children) {
  		  result.add(node.getSort());
  	  }
  	  
  	  return result;
	}
	
	@Override
	public int hashCode() {
		return getTerm().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AstNode) {
			return this == obj || ((AstNode) obj).getTerm().equals(getTerm());
		} else {
			return false;
		}
	}
	
	// Visitor support
	
	public void accept(IAstVisitor visitor) {
		if (visitor.preVisit(this)) {
			for (int i = 0, size = children.size(); i < size; i++) {
				children.get(i).accept(visitor);
			}
		}
		
		visitor.postVisit(this);
	}
	
	// LPG legacy/compatibility
	
	/**
	 * Get all children (including the null ones).
	 * 
	 * @deprecated  Unused; ATermAstNode does not include null children.
	 */
	@Deprecated
	public ArrayList<AstNode> getAllChildren() {
		return getChildren();
	}

	@Deprecated
	public IToken[] getPrecedingAdjuncts() {
		return getLeftIToken().getPrecedingAdjuncts();
	}
	
	@Deprecated
	public IToken[] getFollowingAdjuncts() {
		return getRightIToken().getFollowingAdjuncts();
	}

	@Deprecated
	public AstNode getNextAst() {
		return null;
	}

	/**
	 * Pretty prints the AST formed by this node.
	 * 
	 * @see #prettyPrint(ITermPrinter)
	 * @see #yield()
	 */
	@Override
	public final String toString() {
		ITermPrinter result = new InlinePrinter();
		prettyPrint(result);
		return result.getString();
	}
	
	public void prettyPrint(ITermPrinter printer) {
		printer.print(constructor == null ? "<null>" : constructor);
		//sb.append(':');
		//sb.append(sort);
		printer.print("(");
		if (getChildren().size() > 0) {
			getChildren().get(0).prettyPrint(printer);
			for (int i = 1; i < getChildren().size(); i++) {
				printer.print(",");
				getChildren().get(i).prettyPrint(printer);
			}
		}
		printer.print(")");
	}

	/**
	 * Return the input string that formed this AST.
	 */
	public String yield() {
		return getLeftIToken().getIPrsStream().toString(getLeftIToken(), getRightIToken());
	}
}

/*
 [Adapted from BSD licence]
 Copyright (c) 2003-2005 Terence Parr
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.antlr.stringtemplate.misc;

import antlr.collections.AST;

import javax.swing.event.*;
import javax.swing.tree.*;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.*;

import java.util.*;
import java.lang.reflect.Constructor;

/** A model that pulls data from a string template hierarchy.  This code
 *  is extremely ugly!
 */
public class JTreeStringTemplateModel implements TreeModel {
	static Map classNameToWrapperMap = new HashMap();

	static {
		classNameToWrapperMap.put("org.antlr.stringtemplate.StringTemplate",
								  StringTemplateWrapper.class);
		classNameToWrapperMap.put("org.antlr.stringtemplate.language.ASTExpr",
								  ExprWrapper.class);
		classNameToWrapperMap.put("java.util.Hashtable",
								  HashMapWrapper.class);
		classNameToWrapperMap.put("java.util.ArrayList",
								  ListWrapper.class);
		classNameToWrapperMap.put("java.util.Vector",
								  ListWrapper.class);
	}
	static abstract class Wrapper {
		public abstract int getChildCount(Object parent);
		public abstract int getIndexOfChild(Object parent, Object child);
		public abstract Object getChild(Object parent, int index);
		public abstract Object getWrappedObject();
		public boolean isLeaf(Object node) {
			return true;
		}
	}

	static class StringTemplateWrapper extends Wrapper {
		StringTemplate st = null;
		public StringTemplateWrapper(Object o) {
			this.st = (StringTemplate)o;
		}
		public Object getWrappedObject() {
			return getStringTemplate();
		}
		public StringTemplate getStringTemplate() {
			return st;
		}
		public Object getChild(Object parent, int index) {
			StringTemplate st = ((StringTemplateWrapper)parent).getStringTemplate();
			if ( index==0 ) {
				// System.out.println("chunk type index "+index+" is attributes");
				// return attributes
				return new HashMapWrapper(st.getAttributes());
			}
			Expr chunk =
					(Expr) st.getChunks().get(index-1);
			// System.out.println("chunk type index "+index+" is "+chunk.getClass().getName());
			if ( chunk instanceof StringRef ) {
				return chunk;
			}
			return new ExprWrapper(chunk);
		}
		public int getChildCount(Object parent) {
			return st.getChunks().size()+1; // extra one is attribute list
		}
		public int getIndexOfChild(Object parent, Object child) {
			if ( child instanceof Wrapper ) {
                child = ((Wrapper)child).getWrappedObject();
			}
			int index = st.getChunks().indexOf(child)+1;
			// System.out.println("index of "+child+" is "+index);
			return index;
		}
		public boolean isLeaf(Object node) {
			return false;
		}
		public String toString() {
			if ( st==null ) {
				return "<invalid template>";
			}
			return st.getName();
		}
	}

	static class ExprWrapper extends Wrapper {
		Expr expr = null;
		public ExprWrapper(Object o) {
			this.expr = (Expr)o;
		}
		public Expr getExpr() {
			return expr;
		}
		public Object getWrappedObject() {
			return expr;
		}
		public Object getChild(Object parent, int index) {
			Expr expr = ((ExprWrapper)parent).getExpr();
			if ( expr instanceof ConditionalExpr ) {
				// System.out.println("return wrapped subtemplate");
				return new StringTemplateWrapper(
						((ConditionalExpr)expr).getSubtemplate()
				);
			}
			if ( expr instanceof ASTExpr ) {
				ASTExpr astExpr = (ASTExpr)expr;
				AST root = astExpr.getAST();
				if ( root.getType()==
				     ActionEvaluatorTokenTypes.INCLUDE )
				{
					switch (index) {
						case 0 :
							return root.getFirstChild().getNextSibling().toStringList();
						case 1 :
							String templateName = root.getFirstChild().getText();
							StringTemplate enclosingST = expr.getEnclosingTemplate();
							StringTemplateGroup group = enclosingST.getGroup();
							StringTemplate embedded =
									group.getEmbeddedInstanceOf(enclosingST,
																templateName);
							return new StringTemplateWrapper(embedded);
					}
				}
			}
			return "<invalid>";
		}
		public int getChildCount(Object parent) {
			if ( expr instanceof ConditionalExpr ) {
				return 1;
			}
			AST tree = ((ASTExpr)expr).getAST();
			if ( tree.getType()==ActionEvaluatorTokenTypes.INCLUDE ) {
				return 2;  // one for args and one for template
			}
			return 0;
		}
		public int getIndexOfChild(Object parent, Object child) {
			//System.out.println("Get index of child of "+parent.getClass().getName());
			if ( expr instanceof ConditionalExpr ) {
				return 0;
			}
			return -1;
		}
		public boolean isLeaf(Object node) {
			if ( expr instanceof ConditionalExpr ) {
				return false;
			}
			if ( expr instanceof ASTExpr ) {
				AST tree = ((ASTExpr)expr).getAST();
				if ( tree.getType()==ActionEvaluatorTokenTypes.INCLUDE ) {
					return false;
				}
			}
			return true;
		}
		/** Display different things depending on the ASTExpr type */
		public String toString() {
			if ( expr instanceof ASTExpr ) {
				AST tree = ((ASTExpr)expr).getAST();
				if ( tree.getType()==ActionEvaluatorTokenTypes.INCLUDE ) {
					return "$include$";
				}
				return "$"+((ASTExpr)expr).getAST().toStringList()+"$";
			}
			if ( expr instanceof StringRef ) {
				return expr.toString();
			}
			return "<invalid node type>";
		}
	}

	static class ListWrapper extends Wrapper {
		List v = null;
		public ListWrapper(Object o) {
			v = (List)o;
		}
		public int getChildCount(Object parent) {
			return v.size();
		}

		public int getIndexOfChild(Object parent, Object child) {
			if ( child instanceof Wrapper ) {
                child = ((Wrapper)child).getWrappedObject();
			}
			return v.indexOf(child);
		}

		public Object getChild(Object parent, int index) {
			return v.get(index);
		}

		public Object getWrappedObject() {
			return v;
		}

		public boolean isLeaf(Object node) {
			return false;
		}
	}

	/** Wrap an entry in a map so that name appears as the root and the value
	 *  appears as the child or children.
	 */
	static class MapEntryWrapper extends Wrapper {
		Object key, value;
		public MapEntryWrapper(Object key, Object value) {
			this.key = key;
			this.value = value;
		}
		public Object getWrappedObject() {
			return wrap(value);
		}
		public int getChildCount(Object parent) {
			if ( value instanceof Wrapper ) {
				return ((Wrapper)value).getChildCount(value);
			}
			return 1;
		}

		public int getIndexOfChild(Object parent, Object child) {
			if ( value instanceof Wrapper ) {
				return ((Wrapper)value).getIndexOfChild(value, child);
			}
			return 0;
		}

		public Object getChild(Object parent, int index) {
			if ( value instanceof Wrapper ) {
				return ((Wrapper)value).getChild(value, index);
			}
			return value;
		}

		public boolean isLeaf(Object node) {
			return false;
		}

		public String toString() {
			return key.toString();
		}
	}

	static class HashMapWrapper extends Wrapper {
		HashMap table;
		public HashMapWrapper(Object o) {
			this.table = (HashMap)o;
		}
		public Object getWrappedObject() {
			return table;
		}
		public Object getChild(Object parent, int index) {
			List attributes = getTableAsListOfKeys();
			String key = (String)attributes.get(index);
			Object attr = table.get(key);
			Object wrappedAttr = wrap(attr);
			return new MapEntryWrapper(key, wrappedAttr);
		}
		public int getChildCount(Object parent) {
			List attributes = getTableAsListOfKeys();
			return attributes.size();
		}
		public int getIndexOfChild(Object parent, Object child) {
			List attributes = getTableAsListOfKeys();
			return attributes.indexOf(child);
		}
		public boolean isLeaf(Object node) {
			return false;
		}
		public String toString() {
			return "attributes";
		}
		private List getTableAsListOfKeys() {
			if ( table==null ) {
				return new LinkedList();
			}
			Set keys = table.keySet();
			List v = new LinkedList();
			for (Iterator itr = keys.iterator(); itr.hasNext();) {
				String attributeName = (String) itr.next();
				v.add(attributeName);
			}
			return v;
		}

	}

    Wrapper root = null;

	/** Get a wrapper object by adding "Wrapper" to class name.
	 *  If not present, return the object.
	 */
	public static Object wrap(Object o) {
		Object wrappedObject = o;
		Class wrapperClass = null;
		try {
			wrapperClass = (Class)classNameToWrapperMap.get(o.getClass().getName());
			Constructor ctor = wrapperClass.getConstructor(new Class[]{Object.class});
			wrappedObject = ctor.newInstance(new Object[] {o});
		}
		catch (Exception e) {
			// some problem...oh well, just use the object
			;
		}
		return wrappedObject;
	}

    public JTreeStringTemplateModel(StringTemplate st) {
        if (st == null) {
            throw new IllegalArgumentException("root is null");
        }
        root = new StringTemplateWrapper(st);
    }

    public void addTreeModelListener(TreeModelListener l) {
    }

    /** Get a child object.  If Conditional then return subtemplate.
	 *  If ASTExpr and INCLUDE then return ith chunk of sub StringTemplate
	 */
	public Object getChild(Object parent, int index) {
		//System.out.println("Get index "+index+" of "+parent.toString()+":"+parent.getClass().getName());
        if (parent == null) {
            return null;
        }
		return ((Wrapper)parent).getChild(parent, index);
    }

    public int getChildCount(Object parent) {
        if (parent == null) {
            throw new IllegalArgumentException("root is null");
        }
		return ((Wrapper)parent).getChildCount(parent);
    }

    public int getIndexOfChild(Object parent, Object child) {
        if (parent == null || child == null) {
            throw new IllegalArgumentException("root or child is null");
        }
		return ((Wrapper)parent).getIndexOfChild(parent,child);
    }

    public Object getRoot() {
        return root;
    }

    public boolean isLeaf(Object node) {
        if (node == null) {
            throw new IllegalArgumentException("node is null");
        }
		if ( node instanceof Wrapper ) {
			return ((Wrapper)node).isLeaf(node);
		}
		return true;
    }

    public void removeTreeModelListener(TreeModelListener l) {
    }

    public void valueForPathChanged(TreePath path, Object newValue) {
        System.out.println("heh, who is calling this mystery method?");
    }
}

/*
 [The "BSD licence"]
 Copyright (c) 2005-2006 Terence Parr
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
package org.antlr.runtime.tree;

import org.antlr.runtime.Token;

/** A tree node that is wrapper for a Token object. */
public class CommonTree extends BaseTree {
	/** What token indexes bracket all tokens associated with this node
	 *  and below?
	 */
	public int startIndex=-1, stopIndex=-1;

	/** A single token is the payload */
	public Token token;

	public CommonTree() { }
	
	public CommonTree(CommonTree node) {
		super(node);
		this.token = node.token;
	}

	public CommonTree(Token t) {
		this.token = t;
	}

	public Token getToken() {
		return token;
	}

	public Tree dupNode() {
		return new CommonTree(this);
	}

	public boolean isNil() {
		return token==null;
	}

	public int getType() {
		if ( token==null ) {
			return 0;
		}
		return token.getType();
	}

	public String getText() {
		if ( token==null ) {
			return null;
		}
		return token.getText();
	}

	public int getLine() {
		if ( token==null || token.getLine()==0 ) {
			if ( getChildCount()>0 ) {
				return getChild(0).getLine();
			}
			return 0;
		}
		return token.getLine();
	}

	public int getCharPositionInLine() {
		if ( token==null || token.getCharPositionInLine()==-1 ) {
			if ( getChildCount()>0 ) {
				return getChild(0).getCharPositionInLine();
			}
			return 0;
		}
		return token.getCharPositionInLine();
	}

	public int getTokenStartIndex() {
		if ( startIndex==-1 && token!=null ) {
			return token.getTokenIndex();
		}
		return startIndex;
	}

	public void setTokenStartIndex(int index) {
		startIndex = index;
	}

	public int getTokenStopIndex() {
		if ( stopIndex==-1 && token!=null ) {
			return token.getTokenIndex();
		}
		return stopIndex;
	}

	public void setTokenStopIndex(int index) {
		stopIndex = index;
	}

	public String toString() {
		if ( isNil() ) {
			return "nil";
		}
		return token.getText();
	}
}

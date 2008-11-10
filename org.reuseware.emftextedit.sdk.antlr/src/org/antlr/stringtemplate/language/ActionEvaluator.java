// $ANTLR 2.7.7 (2006-01-29): "eval.g" -> "ActionEvaluator.java"$

/*
 [The "BSD licence"]
 Copyright (c) 2003-2004 Terence Parr
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
package org.antlr.stringtemplate.language;
import org.antlr.stringtemplate.*;
import java.util.*;
import java.io.*;
import java.lang.reflect.*;

import antlr.TreeParser;
import antlr.Token;
import antlr.collections.AST;
import antlr.RecognitionException;
import antlr.ANTLRException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.collections.impl.BitSet;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;


public class ActionEvaluator extends antlr.TreeParser       implements ActionEvaluatorTokenTypes
 {

    public static class NameValuePair {
        public String name;
        public Object value;
    };

    protected StringTemplate self = null;
    protected StringTemplateWriter out = null;
    protected ASTExpr chunk = null;

    /** Create an evaluator using attributes from self */
    public ActionEvaluator(StringTemplate self, ASTExpr chunk, StringTemplateWriter out) {
        this.self = self;
        this.chunk = chunk;
        this.out = out;
    }
 
	public void reportError(RecognitionException e) {
		self.error("eval tree parse error", e);
	}
public ActionEvaluator() {
	tokenNames = _tokenNames;
}

	public final int  action(AST _t) throws RecognitionException {
		int numCharsWritten=0;
		
		org.antlr.stringtemplate.language.StringTemplateAST action_AST_in = (_t == ASTNULL) ? null : (org.antlr.stringtemplate.language.StringTemplateAST)_t;
		
		Object e=null;
		
		
		try {      // for error handling
			e=expr(_t);
			_t = _retTree;
			numCharsWritten = chunk.writeAttribute(self,e,out);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return numCharsWritten;
	}
	
	public final Object  expr(AST _t) throws RecognitionException {
		Object value=null;
		
		org.antlr.stringtemplate.language.StringTemplateAST expr_AST_in = (_t == ASTNULL) ? null : (org.antlr.stringtemplate.language.StringTemplateAST)_t;
		
		Object a=null, b=null, e=null;
		Map argumentContext=null;
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case PLUS:
			{
				AST __t3 = _t;
				org.antlr.stringtemplate.language.StringTemplateAST tmp1_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,PLUS);
				_t = _t.getFirstChild();
				a=expr(_t);
				_t = _retTree;
				b=expr(_t);
				_t = _retTree;
				value = chunk.add(a,b);
				_t = __t3;
				_t = _t.getNextSibling();
				break;
			}
			case APPLY:
			case MULTI_APPLY:
			{
				value=templateApplication(_t);
				_t = _retTree;
				break;
			}
			case ID:
			case DOT:
			case ANONYMOUS_TEMPLATE:
			case STRING:
			case INT:
			{
				value=attribute(_t);
				_t = _retTree;
				break;
			}
			case INCLUDE:
			{
				value=templateInclude(_t);
				_t = _retTree;
				break;
			}
			case FUNCTION:
			{
				value=function(_t);
				_t = _retTree;
				break;
			}
			case LIST:
			{
				value=list(_t);
				_t = _retTree;
				break;
			}
			case VALUE:
			{
				AST __t4 = _t;
				org.antlr.stringtemplate.language.StringTemplateAST tmp2_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,VALUE);
				_t = _t.getFirstChild();
				e=expr(_t);
				_t = _retTree;
				_t = __t4;
				_t = _t.getNextSibling();
				
						StringWriter buf = new StringWriter();
						StringTemplateWriter sw =
							self.getGroup().getStringTemplateWriter(buf);
						int n = chunk.writeAttribute(self,e,sw);
						if ( n > 0 ) {
						    value = buf.toString();
						}
				
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return value;
	}
	
/** Apply template(s) to an attribute; can be applied to another apply
 *  result.
 */
	public final Object  templateApplication(AST _t) throws RecognitionException {
		Object value=null;
		
		org.antlr.stringtemplate.language.StringTemplateAST templateApplication_AST_in = (_t == ASTNULL) ? null : (org.antlr.stringtemplate.language.StringTemplateAST)_t;
		org.antlr.stringtemplate.language.StringTemplateAST anon = null;
		
		Object a=null;
		Vector templatesToApply=new Vector();
		List attributes = new ArrayList();
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case APPLY:
			{
				AST __t14 = _t;
				org.antlr.stringtemplate.language.StringTemplateAST tmp3_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,APPLY);
				_t = _t.getFirstChild();
				a=expr(_t);
				_t = _retTree;
				{
				int _cnt16=0;
				_loop16:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_t.getType()==TEMPLATE)) {
						template(_t,templatesToApply);
						_t = _retTree;
					}
					else {
						if ( _cnt16>=1 ) { break _loop16; } else {throw new NoViableAltException(_t);}
					}
					
					_cnt16++;
				} while (true);
				}
				value = chunk.applyListOfAlternatingTemplates(self,a,templatesToApply);
				_t = __t14;
				_t = _t.getNextSibling();
				break;
			}
			case MULTI_APPLY:
			{
				AST __t17 = _t;
				org.antlr.stringtemplate.language.StringTemplateAST tmp4_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,MULTI_APPLY);
				_t = _t.getFirstChild();
				{
				int _cnt19=0;
				_loop19:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_tokenSet_0.member(_t.getType()))) {
						a=expr(_t);
						_t = _retTree;
						attributes.add(a);
					}
					else {
						if ( _cnt19>=1 ) { break _loop19; } else {throw new NoViableAltException(_t);}
					}
					
					_cnt19++;
				} while (true);
				}
				org.antlr.stringtemplate.language.StringTemplateAST tmp5_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,COLON);
				_t = _t.getNextSibling();
				anon = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,ANONYMOUS_TEMPLATE);
				_t = _t.getNextSibling();
				
							StringTemplate anonymous = anon.getStringTemplate();
							templatesToApply.addElement(anonymous);
							value = chunk.applyTemplateToListOfAttributes(self,
																		  attributes,
																		  anon.getStringTemplate());
							
				_t = __t17;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return value;
	}
	
	public final Object  attribute(AST _t) throws RecognitionException {
		Object value=null;
		
		org.antlr.stringtemplate.language.StringTemplateAST attribute_AST_in = (_t == ASTNULL) ? null : (org.antlr.stringtemplate.language.StringTemplateAST)_t;
		org.antlr.stringtemplate.language.StringTemplateAST prop = null;
		org.antlr.stringtemplate.language.StringTemplateAST i3 = null;
		org.antlr.stringtemplate.language.StringTemplateAST i = null;
		org.antlr.stringtemplate.language.StringTemplateAST s = null;
		org.antlr.stringtemplate.language.StringTemplateAST at = null;
		
		Object obj = null;
		Object propName = null;
		Object e = null;
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case DOT:
			{
				AST __t33 = _t;
				org.antlr.stringtemplate.language.StringTemplateAST tmp6_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,DOT);
				_t = _t.getFirstChild();
				obj=expr(_t);
				_t = _retTree;
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case ID:
				{
					prop = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
					match(_t,ID);
					_t = _t.getNextSibling();
					propName = prop.getText();
					break;
				}
				case VALUE:
				{
					AST __t35 = _t;
					org.antlr.stringtemplate.language.StringTemplateAST tmp7_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
					match(_t,VALUE);
					_t = _t.getFirstChild();
					e=expr(_t);
					_t = _retTree;
					_t = __t35;
					_t = _t.getNextSibling();
					if (e!=null) {propName=e;}
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				_t = __t33;
				_t = _t.getNextSibling();
				value = chunk.getObjectProperty(self,obj,propName);
				break;
			}
			case ID:
			{
				i3 = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				
				value=self.getAttribute(i3.getText());
				
				break;
			}
			case INT:
			{
				i = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,INT);
				_t = _t.getNextSibling();
				value=new Integer(i.getText());
				break;
			}
			case STRING:
			{
				s = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,STRING);
				_t = _t.getNextSibling();
				
					value=s.getText();
					
				break;
			}
			case ANONYMOUS_TEMPLATE:
			{
				at = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,ANONYMOUS_TEMPLATE);
				_t = _t.getNextSibling();
				
					value=at.getText();
						if ( at.getText()!=null ) {
							StringTemplate valueST =new StringTemplate(self.getGroup(), at.getText());
							valueST.setEnclosingInstance(self);
							valueST.setName("<anonymous template argument>");
							value = valueST;
					}
					
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return value;
	}
	
	public final Object  templateInclude(AST _t) throws RecognitionException {
		Object value=null;
		
		org.antlr.stringtemplate.language.StringTemplateAST templateInclude_AST_in = (_t == ASTNULL) ? null : (org.antlr.stringtemplate.language.StringTemplateAST)_t;
		org.antlr.stringtemplate.language.StringTemplateAST id = null;
		org.antlr.stringtemplate.language.StringTemplateAST a1 = null;
		org.antlr.stringtemplate.language.StringTemplateAST a2 = null;
		
		StringTemplateAST args = null;
		String name = null;
		Object n = null;
		
		
		try {      // for error handling
			AST __t10 = _t;
			org.antlr.stringtemplate.language.StringTemplateAST tmp8_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
			match(_t,INCLUDE);
			_t = _t.getFirstChild();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ID:
			{
				id = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				a1 = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				if ( _t==null ) throw new MismatchedTokenException();
				_t = _t.getNextSibling();
				name=id.getText(); args=a1;
				break;
			}
			case VALUE:
			{
				AST __t12 = _t;
				org.antlr.stringtemplate.language.StringTemplateAST tmp9_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,VALUE);
				_t = _t.getFirstChild();
				n=expr(_t);
				_t = _retTree;
				a2 = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				if ( _t==null ) throw new MismatchedTokenException();
				_t = _t.getNextSibling();
				_t = __t12;
				_t = _t.getNextSibling();
				if (n!=null) {name=n.toString();} args=a2;
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			_t = __t10;
			_t = _t.getNextSibling();
			
			if ( name!=null ) {
				value = chunk.getTemplateInclude(self, name, args);
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return value;
	}
	
	public final Object  function(AST _t) throws RecognitionException {
		Object value=null;
		
		org.antlr.stringtemplate.language.StringTemplateAST function_AST_in = (_t == ASTNULL) ? null : (org.antlr.stringtemplate.language.StringTemplateAST)_t;
		
		Object a;
		
		
		try {      // for error handling
			AST __t21 = _t;
			org.antlr.stringtemplate.language.StringTemplateAST tmp10_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
			match(_t,FUNCTION);
			_t = _t.getFirstChild();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_first:
			{
				org.antlr.stringtemplate.language.StringTemplateAST tmp11_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,LITERAL_first);
				_t = _t.getNextSibling();
				a=singleFunctionArg(_t);
				_t = _retTree;
				value=chunk.first(a);
				break;
			}
			case LITERAL_rest:
			{
				org.antlr.stringtemplate.language.StringTemplateAST tmp12_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,LITERAL_rest);
				_t = _t.getNextSibling();
				a=singleFunctionArg(_t);
				_t = _retTree;
				value=chunk.rest(a);
				break;
			}
			case LITERAL_last:
			{
				org.antlr.stringtemplate.language.StringTemplateAST tmp13_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,LITERAL_last);
				_t = _t.getNextSibling();
				a=singleFunctionArg(_t);
				_t = _retTree;
				value=chunk.last(a);
				break;
			}
			case LITERAL_length:
			{
				org.antlr.stringtemplate.language.StringTemplateAST tmp14_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,LITERAL_length);
				_t = _t.getNextSibling();
				a=singleFunctionArg(_t);
				_t = _retTree;
				value=chunk.length(a);
				break;
			}
			case LITERAL_strip:
			{
				org.antlr.stringtemplate.language.StringTemplateAST tmp15_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,LITERAL_strip);
				_t = _t.getNextSibling();
				a=singleFunctionArg(_t);
				_t = _retTree;
				value=chunk.strip(a);
				break;
			}
			case LITERAL_trunc:
			{
				org.antlr.stringtemplate.language.StringTemplateAST tmp16_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,LITERAL_trunc);
				_t = _t.getNextSibling();
				a=singleFunctionArg(_t);
				_t = _retTree;
				value=chunk.trunc(a);
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			_t = __t21;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return value;
	}
	
/** create a new list of expressions as a new multi-value attribute */
	public final Object  list(AST _t) throws RecognitionException {
		Object value=null;
		
		org.antlr.stringtemplate.language.StringTemplateAST list_AST_in = (_t == ASTNULL) ? null : (org.antlr.stringtemplate.language.StringTemplateAST)_t;
		
		Object e = null;
		List elements = new ArrayList();
		
		
		try {      // for error handling
			AST __t6 = _t;
			org.antlr.stringtemplate.language.StringTemplateAST tmp17_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
			match(_t,LIST);
			_t = _t.getFirstChild();
			{
			int _cnt8=0;
			_loop8:
			do {
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case APPLY:
				case MULTI_APPLY:
				case INCLUDE:
				case VALUE:
				case FUNCTION:
				case LIST:
				case ID:
				case PLUS:
				case DOT:
				case ANONYMOUS_TEMPLATE:
				case STRING:
				case INT:
				{
					e=expr(_t);
					_t = _retTree;
					
								  	if ( e!=null ) {
								  		elements.add(e);
								  	}
								  	
					break;
				}
				case NOTHING:
				{
					org.antlr.stringtemplate.language.StringTemplateAST tmp18_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
					match(_t,NOTHING);
					_t = _t.getNextSibling();
					
					List nullSingleton = new ArrayList() {{add(null);}};
					elements.add(nullSingleton.iterator()); // add a blank
					
					break;
				}
				default:
				{
					if ( _cnt8>=1 ) { break _loop8; } else {throw new NoViableAltException(_t);}
				}
				}
				_cnt8++;
			} while (true);
			}
			_t = __t6;
			_t = _t.getNextSibling();
			value = new Cat(elements);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return value;
	}
	
	public final void template(AST _t,
		Vector templatesToApply
	) throws RecognitionException {
		
		org.antlr.stringtemplate.language.StringTemplateAST template_AST_in = (_t == ASTNULL) ? null : (org.antlr.stringtemplate.language.StringTemplateAST)_t;
		org.antlr.stringtemplate.language.StringTemplateAST t = null;
		org.antlr.stringtemplate.language.StringTemplateAST args = null;
		org.antlr.stringtemplate.language.StringTemplateAST anon = null;
		org.antlr.stringtemplate.language.StringTemplateAST args2 = null;
		
		Map argumentContext = null;
		Object n = null;
		
		
		try {      // for error handling
			AST __t26 = _t;
			org.antlr.stringtemplate.language.StringTemplateAST tmp19_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
			match(_t,TEMPLATE);
			_t = _t.getFirstChild();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ID:
			{
				t = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				args = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				if ( _t==null ) throw new MismatchedTokenException();
				_t = _t.getNextSibling();
				
				String templateName = t.getText();
				StringTemplateGroup group = self.getGroup();
				StringTemplate embedded = group.getEmbeddedInstanceOf(self, templateName);
				if ( embedded!=null ) {
				embedded.setArgumentsAST(args);
				templatesToApply.addElement(embedded);
				}
				
				break;
			}
			case ANONYMOUS_TEMPLATE:
			{
				anon = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,ANONYMOUS_TEMPLATE);
				_t = _t.getNextSibling();
				
				StringTemplate anonymous = anon.getStringTemplate();
				// to properly see overridden templates, always set
				// anonymous' group to be self's group
								anonymous.setGroup(self.getGroup());
				templatesToApply.addElement(anonymous);
				
				break;
			}
			case VALUE:
			{
				AST __t28 = _t;
				org.antlr.stringtemplate.language.StringTemplateAST tmp20_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,VALUE);
				_t = _t.getFirstChild();
				n=expr(_t);
				_t = _retTree;
				args2 = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				if ( _t==null ) throw new MismatchedTokenException();
				_t = _t.getNextSibling();
				
									StringTemplate embedded = null;
									if ( n!=null ) {
										String templateName = n.toString();
										StringTemplateGroup group = self.getGroup();
										embedded = group.getEmbeddedInstanceOf(self, templateName);
										if ( embedded!=null ) {
											embedded.setArgumentsAST(args2);
											templatesToApply.addElement(embedded);
										}
									}
									
				_t = __t28;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			_t = __t26;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final Object  singleFunctionArg(AST _t) throws RecognitionException {
		Object value=null;
		
		org.antlr.stringtemplate.language.StringTemplateAST singleFunctionArg_AST_in = (_t == ASTNULL) ? null : (org.antlr.stringtemplate.language.StringTemplateAST)_t;
		
		try {      // for error handling
			AST __t24 = _t;
			org.antlr.stringtemplate.language.StringTemplateAST tmp21_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
			match(_t,SINGLEVALUEARG);
			_t = _t.getFirstChild();
			value=expr(_t);
			_t = _retTree;
			_t = __t24;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return value;
	}
	
	public final boolean  ifCondition(AST _t) throws RecognitionException {
		boolean value=false;
		
		org.antlr.stringtemplate.language.StringTemplateAST ifCondition_AST_in = (_t == ASTNULL) ? null : (org.antlr.stringtemplate.language.StringTemplateAST)_t;
		
		Object a=null, b=null;
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case APPLY:
			case MULTI_APPLY:
			case INCLUDE:
			case VALUE:
			case FUNCTION:
			case LIST:
			case ID:
			case PLUS:
			case DOT:
			case ANONYMOUS_TEMPLATE:
			case STRING:
			case INT:
			{
				a=ifAtom(_t);
				_t = _retTree;
				value = chunk.testAttributeTrue(a);
				break;
			}
			case NOT:
			{
				AST __t30 = _t;
				org.antlr.stringtemplate.language.StringTemplateAST tmp22_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,NOT);
				_t = _t.getFirstChild();
				a=ifAtom(_t);
				_t = _retTree;
				_t = __t30;
				_t = _t.getNextSibling();
				value = !chunk.testAttributeTrue(a);
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return value;
	}
	
	public final Object  ifAtom(AST _t) throws RecognitionException {
		Object value=null;
		
		org.antlr.stringtemplate.language.StringTemplateAST ifAtom_AST_in = (_t == ASTNULL) ? null : (org.antlr.stringtemplate.language.StringTemplateAST)_t;
		
		try {      // for error handling
			value=expr(_t);
			_t = _retTree;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return value;
	}
	
/** self is assumed to be the enclosing context as foo(x=y) must find y in
 *  the template that encloses the ref to foo(x=y).  We must pass in
 *  the embedded template (the one invoked) so we can check formal args
 *  in rawSetArgumentAttribute.
 */
	public final Map  argList(AST _t,
		StringTemplate embedded, Map initialContext
	) throws RecognitionException {
		Map argumentContext=null;
		
		org.antlr.stringtemplate.language.StringTemplateAST argList_AST_in = (_t == ASTNULL) ? null : (org.antlr.stringtemplate.language.StringTemplateAST)_t;
		
		argumentContext = initialContext;
		if ( argumentContext==null ) {
		argumentContext=new HashMap();
		}
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ARGS:
			{
				AST __t37 = _t;
				org.antlr.stringtemplate.language.StringTemplateAST tmp23_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,ARGS);
				_t = _t.getFirstChild();
				{
				_loop39:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_t.getType()==ASSIGN||_t.getType()==DOTDOTDOT)) {
						argumentAssignment(_t,embedded,argumentContext);
						_t = _retTree;
					}
					else {
						break _loop39;
					}
					
				} while (true);
				}
				_t = __t37;
				_t = _t.getNextSibling();
				break;
			}
			case SINGLEVALUEARG:
			{
				singleTemplateArg(_t,embedded,argumentContext);
				_t = _retTree;
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return argumentContext;
	}
	
	public final void argumentAssignment(AST _t,
		StringTemplate embedded, Map argumentContext
	) throws RecognitionException {
		
		org.antlr.stringtemplate.language.StringTemplateAST argumentAssignment_AST_in = (_t == ASTNULL) ? null : (org.antlr.stringtemplate.language.StringTemplateAST)_t;
		org.antlr.stringtemplate.language.StringTemplateAST arg = null;
		
		Object e = null;
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ASSIGN:
			{
				AST __t43 = _t;
				org.antlr.stringtemplate.language.StringTemplateAST tmp24_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,ASSIGN);
				_t = _t.getFirstChild();
				arg = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				e=expr(_t);
				_t = _retTree;
				_t = __t43;
				_t = _t.getNextSibling();
				
					    if ( e!=null ) {
							self.rawSetArgumentAttribute(embedded,argumentContext,arg.getText(),e);
						}
					
				break;
			}
			case DOTDOTDOT:
			{
				org.antlr.stringtemplate.language.StringTemplateAST tmp25_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
				match(_t,DOTDOTDOT);
				_t = _t.getNextSibling();
				embedded.setPassThroughAttributes(true);
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void singleTemplateArg(AST _t,
		StringTemplate embedded, Map argumentContext
	) throws RecognitionException {
		
		org.antlr.stringtemplate.language.StringTemplateAST singleTemplateArg_AST_in = (_t == ASTNULL) ? null : (org.antlr.stringtemplate.language.StringTemplateAST)_t;
		
		Object e = null;
		
		
		try {      // for error handling
			AST __t41 = _t;
			org.antlr.stringtemplate.language.StringTemplateAST tmp26_AST_in = (org.antlr.stringtemplate.language.StringTemplateAST)_t;
			match(_t,SINGLEVALUEARG);
			_t = _t.getFirstChild();
			e=expr(_t);
			_t = _retTree;
			_t = __t41;
			_t = _t.getNextSibling();
			
				    if ( e!=null ) {
				    	String soleArgName = null;
				    	// find the sole defined formal argument for embedded
				    	boolean error = false;
						Map formalArgs = embedded.getFormalArguments();
						if ( formalArgs!=null ) {
							Set argNames = formalArgs.keySet();
							if ( argNames.size()==1 ) {
								soleArgName = (String)argNames.toArray()[0];
								//System.out.println("sole formal arg of "+embedded.getName()+" is "+soleArgName);
							}
							else {
								error=true;
							}
						}
						else {
							error=true;
						}
						if ( error ) {
							self.error("template "+embedded.getName()+
							           " must have exactly one formal arg in template context "+
									   self.getEnclosingInstanceStackString());
					   	}
					   	else {
					   		self.rawSetArgumentAttribute(embedded,argumentContext,soleArgName,e);
					   	}
				    }
				
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"APPLY",
		"MULTI_APPLY",
		"ARGS",
		"INCLUDE",
		"\"if\"",
		"VALUE",
		"TEMPLATE",
		"FUNCTION",
		"SINGLEVALUEARG",
		"LIST",
		"NOTHING",
		"SEMI",
		"LPAREN",
		"RPAREN",
		"\"elseif\"",
		"COMMA",
		"ID",
		"ASSIGN",
		"COLON",
		"NOT",
		"PLUS",
		"DOT",
		"\"first\"",
		"\"rest\"",
		"\"last\"",
		"\"length\"",
		"\"strip\"",
		"\"trunc\"",
		"\"super\"",
		"ANONYMOUS_TEMPLATE",
		"STRING",
		"INT",
		"LBRACK",
		"RBRACK",
		"DOTDOTDOT",
		"TEMPLATE_ARGS",
		"NESTED_ANONYMOUS_TEMPLATE",
		"ESC_CHAR",
		"WS",
		"WS_CHAR"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 60180933296L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	}
	

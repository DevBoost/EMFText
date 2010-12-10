/*
 [The "BSD licence"]
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
package org.antlr.stringtemplate.language;

import antlr.RecognitionException;
import antlr.collections.AST;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateWriter;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/** A conditional reference to an embedded subtemplate. */
public class ConditionalExpr extends ASTExpr {
	StringTemplate subtemplate = null;
	List elseIfSubtemplates = null;
	StringTemplate elseSubtemplate = null;

	protected static class ElseIfClauseData {
		ASTExpr expr;
		StringTemplate st;
	}

	public ConditionalExpr(StringTemplate enclosingTemplate, AST tree) {
		super(enclosingTemplate,tree,null);
	}

	public void setSubtemplate(StringTemplate subtemplate) {
		this.subtemplate = subtemplate;
	}

	public void addElseIfSubtemplate(final ASTExpr conditionalTree,
									 final StringTemplate subtemplate)
	{
		if ( elseIfSubtemplates==null ) {
			elseIfSubtemplates = new ArrayList();
		}
		ElseIfClauseData d = new ElseIfClauseData() {{
			expr = conditionalTree;
			st = subtemplate;
		}};
		elseIfSubtemplates.add(d);
	}

	public StringTemplate getSubtemplate() {
		return subtemplate;
	}

	public StringTemplate getElseSubtemplate() {
		return elseSubtemplate;
	}

	public void setElseSubtemplate(StringTemplate elseSubtemplate) {
		this.elseSubtemplate = elseSubtemplate;
	}

	/** To write out the value of a condition expr, invoke the evaluator in eval.g
	 *  to walk the condition tree computing the boolean value.  If result
	 *  is true, then write subtemplate.
	 */
	public int write(StringTemplate self, StringTemplateWriter out) throws IOException {
		if ( exprTree==null || self==null || out==null ) {
			return 0;
		}
		// System.out.println("evaluating conditional tree: "+exprTree.toStringList());
		ActionEvaluator eval =
				new ActionEvaluator(self,this,out);
		int n = 0;
		try {
			boolean testedTrue = false;
			// get conditional from tree and compute result
			AST cond = exprTree.getFirstChild();
			boolean includeSubtemplate = eval.ifCondition(cond); // eval and write out tree
			// System.out.println("subtemplate "+subtemplate);
			// IF
			if ( includeSubtemplate ) {
				n = writeSubTemplate(self, out, subtemplate);
				testedTrue = true;
			}
			// ELSEIF
			else if ( elseIfSubtemplates!=null && elseIfSubtemplates.size()>0 ) {
				for (int i=0; i<elseIfSubtemplates.size(); i++) {
					ElseIfClauseData elseIfClause =
						(ElseIfClauseData)elseIfSubtemplates.get(i);
					includeSubtemplate = eval.ifCondition(elseIfClause.expr.exprTree);
					if ( includeSubtemplate ) {
						writeSubTemplate(self, out, elseIfClause.st);
						testedTrue = true;
						break;
					}
				}
			}
			// ELSE
			if ( !testedTrue && elseSubtemplate!=null ) {
				// evaluate ELSE clause if present and IF condition failed
				StringTemplate s = elseSubtemplate.getInstanceOf();
				s.setEnclosingInstance(self);
				s.setGroup(self.getGroup());
				s.setNativeGroup(self.getNativeGroup());
				n = s.write(out);
			}
            // cond==false and no else => MISSING output not empty
            if ( !testedTrue && elseSubtemplate==null ) n = MISSING;
		}
		catch (RecognitionException re) {
			self.error("can't evaluate tree: "+exprTree.toStringList(), re);
		}
		return n;
	}

	protected int writeSubTemplate(StringTemplate self,
								   StringTemplateWriter out,
								   StringTemplate subtemplate)
		throws IOException
	{
		/* To evaluate the IF chunk, make a new instance whose enclosingInstance
		 * points at 'self' so get attribute works.  Otherwise, enclosingInstance
		 * points at the template used to make the precompiled code.  We need a
		 * new template instance every time we exec this chunk to get the new
		 * "enclosing instance" pointer.
		 */
		StringTemplate s = subtemplate.getInstanceOf();
		s.setEnclosingInstance(self);
		// make sure we evaluate in context of enclosing template's
		// group so polymorphism works. :)
		s.setGroup(self.getGroup());
		s.setNativeGroup(self.getNativeGroup());
		return s.write(out);
	}
}

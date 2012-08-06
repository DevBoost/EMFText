header {
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
}

class ActionEvaluator extends TreeParser;

options {
    importVocab=ActionParser;
    ASTLabelType = "org.antlr.stringtemplate.language.StringTemplateAST";
}

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
}

action returns [int numCharsWritten=0]
{
    Object e=null;
}
    :   e=expr {numCharsWritten = chunk.writeAttribute(self,e,out);}
    ;

expr returns [Object value=null]
{
    Object a=null, b=null, e=null;
    Map argumentContext=null;
}
    :   #(PLUS a=expr b=expr {value = chunk.add(a,b);})
    |   value=templateApplication
    |   value=attribute
    |   value=templateInclude
    |	value=function
    |	value=list
    |   #(VALUE e=expr)
        // convert to string (force early eval)
        {
		StringWriter buf = new StringWriter();
		StringTemplateWriter sw =
			self.getGroup().getStringTemplateWriter(buf);
		int n = chunk.writeAttribute(self,e,sw);
		if ( n > 0 ) {
		    value = buf.toString();
		}
        }
    ;

/** create a new list of expressions as a new multi-value attribute */
list returns [Object value=null]
{
Object e = null;
List elements = new ArrayList();
}
	:	#(	LIST
			(	e=expr
			  	{
			  	if ( e!=null ) {
			  		elements.add(e);
			  	}
			  	}
            |   NOTHING
                {
                List nullSingleton = new ArrayList() {{add(null);}};
                elements.add(nullSingleton.iterator()); // add a blank
                }
			)+
		 )
         {value = new Cat(elements);}
	;

templateInclude returns [Object value=null]
{
    StringTemplateAST args = null;
    String name = null;
    Object n = null;
}
    :   #( INCLUDE
//        {value = chunk.getTemplateInclude(self, name.getText(), #args);}
            (   id:ID a1:.
                {name=id.getText(); args=#a1;}

            |   #( VALUE n=expr a2:. )
                {if (n!=null) {name=n.toString();} args=#a2;}

            )
         )
        {
        if ( name!=null ) {
        	value = chunk.getTemplateInclude(self, name, args);
        }
        }
    ;

/** Apply template(s) to an attribute; can be applied to another apply
 *  result.
 */
templateApplication returns [Object value=null]
{
Object a=null;
Vector templatesToApply=new Vector();
List attributes = new ArrayList();
}
    :   #(  APPLY a=expr
    		(template[templatesToApply])+
	        {value = chunk.applyListOfAlternatingTemplates(self,a,templatesToApply);}
         )
    |	#(	MULTI_APPLY (a=expr {attributes.add(a);} )+ COLON
			anon:ANONYMOUS_TEMPLATE
			{
			StringTemplate anonymous = anon.getStringTemplate();
			templatesToApply.addElement(anonymous);
			value = chunk.applyTemplateToListOfAttributes(self,
														  attributes,
														  anon.getStringTemplate());
			}
    	 )
    ;

function returns [Object value=null]
{
Object a;
}
    :	#(	FUNCTION
    		(	"first" a=singleFunctionArg	{value=chunk.first(a);}
    		|	"rest" 	a=singleFunctionArg	{value=chunk.rest(a);}
    		|	"last"  a=singleFunctionArg	{value=chunk.last(a);}
    		|	"length" a=singleFunctionArg	{value=chunk.length(a);}
    		|	"strip" a=singleFunctionArg	{value=chunk.strip(a);}
    		|	"trunc" a=singleFunctionArg	{value=chunk.trunc(a);}
    		)

    	 )
	;

singleFunctionArg returns [Object value=null]
	:	#( SINGLEVALUEARG value=expr )
	;

template[Vector templatesToApply]
{
Map argumentContext = null;
Object n = null;
}
    :   #(  TEMPLATE
            (   t:ID args:. // don't eval argList now; must re-eval each iteration
                {
                String templateName = t.getText();
                StringTemplateGroup group = self.getGroup();
                StringTemplate embedded = group.getEmbeddedInstanceOf(self, templateName);
                if ( embedded!=null ) {
                    embedded.setArgumentsAST(#args);
                    templatesToApply.addElement(embedded);
                }
                }

            |	anon:ANONYMOUS_TEMPLATE
                {
                StringTemplate anonymous = anon.getStringTemplate();
                // to properly see overridden templates, always set
                // anonymous' group to be self's group
				anonymous.setGroup(self.getGroup());
                templatesToApply.addElement(anonymous);
                }

            |   #(  VALUE n=expr args2:.
					{
					StringTemplate embedded = null;
					if ( n!=null ) {
						String templateName = n.toString();
						StringTemplateGroup group = self.getGroup();
						embedded = group.getEmbeddedInstanceOf(self, templateName);
						if ( embedded!=null ) {
							embedded.setArgumentsAST(#args2);
							templatesToApply.addElement(embedded);
						}
					}
					}
                 )
            )
         )
    ;

ifCondition returns [boolean value=false]
{
    Object a=null, b=null;
}
    :   a=ifAtom {value = chunk.testAttributeTrue(a);}
    |   #(NOT a=ifAtom) {value = !chunk.testAttributeTrue(a);}
	;

ifAtom returns [Object value=null]
    :   value=expr
    ;

attribute returns [Object value=null]
{
    Object obj = null;
    Object propName = null;
    Object e = null;
}
    :   #( DOT obj=expr
           ( prop:ID {propName = prop.getText();}
           // don't force early eval here in case it's a map
           // we need the right type on the key.
           // E.g., <aMap.keys:{k|<k>:<aMap.(k)>}>
           // If aMap has Integer keys, can't convert k to string then lookup.
           | #(VALUE e=expr) {if (e!=null) {propName=e;}}
           )
         )
        {value = chunk.getObjectProperty(self,obj,propName);}

    |   i3:ID
        {
        value=self.getAttribute(i3.getText());
        }

    |   i:INT {value=new Integer(i.getText());}

    |   s:STRING
    	{
    	value=s.getText();
    	}

    |   at:ANONYMOUS_TEMPLATE
    	{
    	value=at.getText();
		if ( at.getText()!=null ) {
			StringTemplate valueST =new StringTemplate(self.getGroup(), at.getText());
			valueST.setEnclosingInstance(self);
			valueST.setName("<anonymous template argument>");
			value = valueST;
    	}
    	}
    ;

/** self is assumed to be the enclosing context as foo(x=y) must find y in
 *  the template that encloses the ref to foo(x=y).  We must pass in
 *  the embedded template (the one invoked) so we can check formal args
 *  in rawSetArgumentAttribute.
 */
argList[StringTemplate embedded, Map initialContext]
    returns [Map argumentContext=null]
{
    argumentContext = initialContext;
    if ( argumentContext==null ) {
        argumentContext=new HashMap();
    }
}
    :   #( ARGS (argumentAssignment[embedded,argumentContext])* )
    |	singleTemplateArg[embedded,argumentContext]
	;

singleTemplateArg[StringTemplate embedded, Map argumentContext]
{
    Object e = null;
}
	:	#( SINGLEVALUEARG e=expr )
	    {
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
	;

argumentAssignment[StringTemplate embedded, Map argumentContext]
{
    Object e = null;
}
	:	#( ASSIGN arg:ID e=expr )
	    {
	    if ( e!=null ) {
			self.rawSetArgumentAttribute(embedded,argumentContext,arg.getText(),e);
		}
	    }
	|	DOTDOTDOT {embedded.setPassThroughAttributes(true);}
	;


package org.reuseware.emftextedit.concretesyntax.resource.cs.analysis;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EObject;
import org.reuseware.emftextedit.codegen.regex.ANTLRexpLexer;
import org.reuseware.emftextedit.codegen.regex.ANTLRexpParser;
import org.reuseware.emftextedit.resource.TokenResolver;
import org.reuseware.emftextedit.resource.TextResource;
import org.reuseware.emftextedit.resource.impl.JavaBasedTokenResolver;

public class CsQUOTED_36_36TokenResolver extends JavaBasedTokenResolver implements TokenResolver{ 
	@Override
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = super.deResolve(value,feature,container);
		result = "$" + result;
		result += "$";
		result = result.replaceAll(java.util.regex.Pattern.quote("$"),"\\\\\\$");
		return result;
	}

	@Override
	public Object resolve(String lexem, EStructuralFeature feature, EObject container, TextResource resource) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0,lexem.length()-1);
		lexem = lexem.replaceAll("\\\\"+java.util.regex.Pattern.quote("$"),"\\$");
		checkANTLRRegex(lexem,resource,container);
		return lexem;
	}
	
    private boolean checkANTLRRegex(String regex, TextResource resource, EObject container){
    	ByteArrayOutputStream out = new ByteArrayOutputStream();
    	PrintWriter w = new PrintWriter(new BufferedOutputStream(out));
    	w.print(regex);
    	w.flush();
    	w.close(); 
    	
    	try{
    		ANTLRexpLexer l = new ANTLRexpLexer(new ANTLRInputStream(new  ByteArrayInputStream(out.toByteArray())));
    		ANTLRexpParser p = new ANTLRexpParser(new CommonTokenStream(l));
         	p.root();
         	if(!p.recExceptions.isEmpty()){
         		for(RecognitionException e:p.recExceptions){
         			String message = l.getErrorMessage(e,l.getTokenNames());
         			if(message==null||message.equals(""))
         				message = p.getErrorMessage(e,p.getTokenNames());
         			resource.addError(message,container);
         		}
         		return false;
         	}
         	
        }catch(Exception e){
        	resource.addError(e.getMessage(),container);
        	return false;
        }
       return true;
    }
    
}

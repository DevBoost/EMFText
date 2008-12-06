package org.emftext.sdk.codegen.regex;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import org.antlr.Tool;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.CommonTokenStream;

public class RunAntlr {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		System.out.println(System.getProperty("user.dir"));
	      Tool antlrTool = new Tool(new String[]{"-o",System.getProperty("user.dir"), "src/org/reuseware/emftextedit/codegen/regex/ANTLRexp.g"});
	        antlrTool.process();

	     	ByteArrayOutputStream out = new ByteArrayOutputStream();
	    	PrintWriter w = new PrintWriter(new BufferedOutputStream(out));
	    	w.print("'(");
	    	w.flush();
	    	w.close();  
	    	ANTLRexpLexer lexer = (new ANTLRexpLexer(new ANTLRInputStream(new  ByteArrayInputStream(out.toByteArray()))));
	    	
	    	ANTLRexpParser p = new ANTLRexpParser(new CommonTokenStream(lexer));
	    	
	    	try{
	         	p.root();System.out.println(p.recExceptions.size());
	        
	        }catch(RecognitionException e){
	        	System.out.println(p.recExceptions.size());
	        	System.out.println("s"+p.getErrorMessage(e,p.getTokenNames()));
	        	
	        	
	        }
	  
	}

}

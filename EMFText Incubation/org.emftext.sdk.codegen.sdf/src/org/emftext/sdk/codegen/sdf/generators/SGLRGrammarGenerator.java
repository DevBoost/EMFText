package org.emftext.sdk.codegen.sdf.generators;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.regexp.resource.regexp_antlr.mopp.Regexp_antlrMetaInformation;
import org.emftext.language.regexp.resource.regexp_sdf.IRegexp_sdfTextPrinter;
import org.emftext.language.regexp.resource.regexp_sdf.mopp.Regexp_sdfMetaInformation;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;
import org.emftext.sdk.codegen.sdf.ESDFArtifact;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.PLUS;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.STAR;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.WhiteSpaces;
 
 /**
  * An experimental (incomplete) generator for the SGLR compiler
  * framework.
  */
public class SGLRGrammarGenerator extends BaseGenerator {

	/**
	 * The name of the EOF token which can be printed to force end of file after a parse from the root. 
	 */
	public static final String EOF_TOKEN_NAME = "EOF";
	
	private ConcreteSyntax concreteSyntax;
	
	private Map<String, String> assignments;
	
	public SGLRGrammarGenerator() {
		super();
	}
	
	public SGLRGrammarGenerator(GenerationContext context) {
		super(context, ESDFArtifact.SGLR_GRAMMAR);
		this.context = context;
		this.concreteSyntax = context.getConcreteSyntax();
		assignments = new LinkedHashMap<String,String>();
	}

	private String generateID(String name) {
		int id = name.hashCode();
		return id > 0 ? "P"+id : "N"+(-1)*id;
	}
	
	private Map<String,List<String>> rewriteDefinitions(Choice choice, String className) {
				
		Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>( );
		
		StringBuffer sb = new StringBuffer( );
				
		try {
			
			for ( Sequence option : choice.getOptions( ) ){
		
				for ( Definition def : option.getParts( ) ) {
					
					if ( def instanceof LineBreak || def instanceof WhiteSpaces ) {
						continue;
					} else if ( def instanceof CsString ) {
						String value = ( ( CsString ) def ).getValue( );
						sb.append( "\"" + value + "\"" );
					} else if ( def instanceof Containment ) {
						
						final Containment containment = ( Containment ) def;
						final GenFeature genFeature = containment.getFeature( );
										
						EList<GenClass> types; 
						if ( !containment.getTypes( ).isEmpty( ) ) {
							types = containment.getTypes( );
						}
						else {
							types = new BasicEList<GenClass>( );
							types.add( genFeature.getTypeGenClass( ) );
						}
						
						String metaClass = types.get( 0 ).getName( );
						
						String name = className + "." + genFeature.getName();	
						rules.put( generateID(name), Arrays.asList( new String[] { generateID(metaClass) } ) );
						sb.append( generateID(name) );
						
						assignments.put(generateID(metaClass), metaClass);						
						assignments.put(generateID(name), name);
					}
					else if ( def instanceof Placeholder ) {
						String name = ( ( Placeholder ) def ).getToken( ).getName( );
						String attributeName = ((Placeholder) def).getFeature().getName();
						String ruleName = className + "." + attributeName;
						sb.append( generateID(ruleName) );
						rules.put(generateID(ruleName), Arrays.asList( new String[] {generateID(name)}));
						assignments.put( generateID(ruleName), ruleName );
					} 
					else if (def instanceof CompoundDefinition) {
						final CompoundDefinition compound = ( CompoundDefinition ) def;

						String _id = "GENERIC";
						
						Map<String, List<String>> additionalRules = rewriteDefinitions( compound.getDefinition( ), className );
						
						if( additionalRules.size( ) == 2 ){
							sb.append( "(" + additionalRules.get( generateID( className )).get(0) + ")" + calculateCardinality( compound.getCardinality() ) );
							for ( String key : additionalRules.keySet() ){
								if( !key.equals(generateID(className)) ){
									rules.put(key, additionalRules.get(key));
									assignments.put(generateID(className), className);
								}
							}
						} else {
							sb.append( additionalRules.size() );
							rules.putAll( additionalRules );
							sb.append( _id );
						}
					}
			
					sb.append( " " );
				}
		
				List<String> productions = rules.get( className );
		
				if( productions != null )
					productions.add( sb.toString( ) );
					
				else {
					productions = new LinkedList<String>( );
					productions.add( sb.toString( ) );
				}
				
				rules.put( generateID(className), productions );
				
				if(	!choice.eClass().isAbstract() ){
					assignments.put(generateID(className), className);
				}
			}
	
			} catch ( Exception e ){
				sb.append( "         " );
				sb.append( e.toString( ) );
			}
			
			return rules;
	
	}
	
	private String calculateCardinality( Cardinality cardinality){

		if( cardinality instanceof PLUS ){
			return "+";
		}
		else if( cardinality instanceof QUESTIONMARK ){
			return "?";
		}	
		else if( cardinality instanceof STAR){
			return "*";
		}
			
		return "";
	}

	private Map<String, List<String>> rewriteRules( EList<Rule> syntax){
		
		Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>( );
		
		for( Rule rule : syntax ){
			
			String className = rule.getMetaclass( ).getName( );
			List<GenClass> superClasses = rule.getMetaclass( ).getExtendedGenClasses( );
									
			for ( GenClass extendedClass : superClasses ) {
				List<String> merged = rules.get( generateID(extendedClass.getName()) );
				
				if( merged == null )
					merged = new ArrayList<String>( );
				
				merged.add( generateID( className ));				
			
				rules.put( generateID( extendedClass.getName() ), merged );
			}
			
			
			for ( Entry<String, List<String>> entry : rewriteDefinitions( rule.getDefinition( ), className ).entrySet( ) ){
				String key = entry.getKey( );
				
				List<String> merged = rules.get( key );
				
				if( merged == null )
					merged = new ArrayList<String>( );
				
				merged.addAll( entry.getValue( ) );
				rules.put( key, merged );
			}
		}
		
		return rules;
	}
	
	private void addSyntax( StringBuffer sb){
		
		Map<String, List<String>> rules = rewriteRules( concreteSyntax.getRules( ) );
		
		sb.append( "   sorts\n" );
		sb.append( "         " );
		for( Entry<String, List<String>> rule : rules.entrySet( ) ){
			sb.append( " " + rule.getKey( ) );
		}
		for ( CompleteTokenDefinition definition : concreteSyntax.getActiveTokens( ) ) {
			sb.append( " " + generateID(definition.getName( )) );
		}
		
		sb.append( "\n\n" );
		
		// write token definitions
		sb.append( "   lexical syntax\n\n" );
		for ( CompleteTokenDefinition definition : concreteSyntax.getActiveTokens( ) ) {	
			String id = generateID(definition.getName());
			if( id.equals("P1668381247"))
				sb.append( "~[\\013\\010]*" + " -> " + id + "\n" );
			else	
				sb.append( translateAndFix( definition.getRegex( ) ) + " -> " + id + "\n" );
		}
		sb.append( "\n" );
		
		// write restrictions
		//sb.append( "   context-free restrictions\n\n" );
		
		// write rules
		sb.append( "   context-free syntax\n\n" );
		for( Entry<String, List<String>> rule : rules.entrySet( ) ){
			for( String production : rule.getValue( ) ){
				String assign = assignments.get(rule.getKey());
				
				if (assign != null) {
					String[] parts = assign.split("\\.");
					assign = assign == null ? "" : " {cons(\"" + parts[parts.length-1] + "\")}";
				} else {
					assign = "";
				}
				
				sb.append( "         " );
				sb.append( production + " -> " + rule.getKey( ) + assign + "\n" );
			}
		}
		sb.append( "\n" );
		
		// write priorities
		//sb.append( "   context-free priorities\n\n" );
		
		
		// create imports
		sb.append( "imports Layout\n" );
		sb.append( "module Layout\n"

					+ "exports\n"
					+ "lexical syntax\n"
					+ "[\\ \\t\\n] -> LAYOUT\n"

					+ "context-free restrictions\n"
					+ "LAYOUT? -/- [\\ \\t\\n]\n" );
	}
	
	private String translateAndFix(String antlrRegexp){
		String sdfRegexp = translate( antlrRegexp );
		
//		if( true ) return sdfRegexp;
		
		sdfRegexp = sdfRegexp.replaceAll("\\[\\\"\\]", "[\\\\\"]");
		sdfRegexp = sdfRegexp.replaceAll("\\\\r", "\\\\013");
		sdfRegexp = sdfRegexp.replaceAll("\\\\n", "\\\\010");
		sdfRegexp = sdfRegexp.replaceAll("\\\\t", "\\\\009");
		sdfRegexp = sdfRegexp.replaceAll("\\\\f", "\\\\012");		
		sdfRegexp = sdfRegexp.replaceAll("_", "\\\\_");
		sdfRegexp = sdfRegexp.replaceAll("\\[\\-\\]", "[\\\\-]");
		
		java.lang.String regex = "(?<=[^\\\\])\\\"((\\\\\\\")|[^\\\"])*\\\"";
		Matcher stringExp = Pattern.compile(regex).matcher(sdfRegexp);
		while( stringExp.find() ){
			String group = stringExp.group();
			group = group.substring(1);
			group = group.substring(0, group.length()-1);
			String replace = "";
			System.out.println( group );
			
			java.lang.String regex2 = "(\\\\[0-9]{3})|(\\\\[.\\_\\-])|([a-z0-9])";
			Matcher character = Pattern.compile( regex2 ).matcher(group);
			
			while( character.find() ){
				if(character.group().length() > 1){
					replace += "[\\" + character.group() + "]";					
				} else {
					replace += "[" + character.group() + "]";
				}
			}

			sdfRegexp = sdfRegexp.replaceFirst(regex, replace);
		}
		
		regex = "(\\\\u[a-f0-9]{4})";
		Matcher unicode = Pattern.compile(regex).matcher(sdfRegexp);
		while( unicode.find() ){
			String group = unicode.group();
			sdfRegexp = sdfRegexp.replaceFirst(regex, unicode2ascii( group ));
		}
		
		sdfRegexp = sdfRegexp.replaceAll("[\\ ]", "\\\\ ");
		sdfRegexp = sdfRegexp.replaceAll("\\[\\?\\]", "[\\\\?]");
		sdfRegexp = sdfRegexp.replaceAll("\\[\\+\\]", "[\\\\+]");
		sdfRegexp = sdfRegexp.replaceAll("\\[\\*\\]", "[\\\\*]");
		sdfRegexp = sdfRegexp.replaceAll("\\[\\.\\]", "([\\\\.])");
		sdfRegexp = sdfRegexp.replaceAll("\\(\\.\\)", "([\\\\.])");
		
 		return sdfRegexp;
		
// 		return antlrRegexp;
	}
	
	private static String unicode2ascii(String unicode){
		String hex = unicode.substring(2);
		
		System.out.println( hex );
		
		int dec = 0;
		
		for( int i=3; i>=0; i--){
			char index = hex.substring(i,i+1).charAt(0);
			
			switch( index ){
				
			case 'a': dec += Math.pow(10, i+1); break;
			case 'b': dec += Math.pow(11, i+1); break;
			case 'c': dec += Math.pow(12, i+1); break;
			case 'd': dec += Math.pow(13, i+1); break;
			case 'e': dec += Math.pow(14, i+1); break;
			case 'f': dec += Math.pow(15, i+1); break;
			default: dec += Math.pow( Integer.parseInt( index+"" ), i+1);
			}
		} 
 
		if( dec > 255 ){
			dec = 255;
		}
		
		return "\\\\"+dec;
	}

	private String translate(String antlrRegexp) {
		EObject root = parse(antlrRegexp, new Regexp_antlrMetaInformation().getSyntaxName());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		IRegexp_sdfTextPrinter printer = new Regexp_sdfMetaInformation().createPrinter(out, null);
		try {
			printer.print(root);
		} catch (IOException e) {
		
		}
		String result = out.toString();
		
		return result;
	}
	
	public EObject parse(String nextRegexp, String syntaxType) {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createURI("temp." + syntaxType));
		try {
			System.out.println("parse(): " + nextRegexp);
			r.load(new ByteArrayInputStream(nextRegexp.getBytes()), null);
			EList<Diagnostic> errors = r.getErrors();
			for (Diagnostic error : errors) {
				System.out.println("Error: " + error.getMessage() + "(" + error.getColumn() + ")");
			}
			EList<EObject> contents = r.getContents();
			return contents.get(0);
		} catch (IOException e) {
		}
		return null;
	}
	
	public Collection<GenerationProblem> getCollectedErrors() {
 		return null;
 	}
	
	private void addHeader( StringBuffer sb ){
		sb.append( "definition " );
		sb.append( "module Main\n\n" );
		sb.append( "hiddens\n\n   context-free start-symbols\n\n");
		for( GenClass symbol : concreteSyntax.getActiveStartSymbols( ) ){
			sb.append( "         " );
			sb.append( generateID( symbol.getName( ) ) + " " );
		}
		sb.append( "\n\n" );
		sb.append( "exports\n\n" );
	}
	
	private String generateParseTable(String inputfile) throws IOException, InterruptedException {
		File definition = new File( "definition.sdf" );
		
		
	    Writer output = new BufferedWriter(new FileWriter( definition ));
	    try {
	      output.write( inputfile );
	    }
	    finally {
	      output.close();
	    }
		
	    // TODO use sdf2table from path or allow configuration
		Process sdf2table = Runtime.getRuntime().exec("/usr/local/bin/sdf2table -t " + definition.getAbsolutePath());
		sdf2table.waitFor();
		
		StringBuilder contents = new StringBuilder();
    	String path = definition.getAbsolutePath();
    	String parseTable = path.substring(0, path.length()-3) + "tbl";
    	
    	if (!new File(parseTable).exists()) {
    		return null;
    	}
    	
	    try {
	    	BufferedReader input =  new BufferedReader(new FileReader(parseTable));
	    	try {
	    		String line = null;
	    		while (( line = input.readLine()) != null){
	    			contents.append(line);
	    			contents.append(System.getProperty("line.separator"));
	    		}
	    	}
	    	finally {
	    		input.close();
	    		new File(path.substring(0, path.length()-3) + "tbl").delete();
	    	}
	    }
	    catch (IOException ex){
	      ex.printStackTrace();
	    } finally {
	    	definition.delete();
	    }

	    return contents.toString();
	}
	
	public boolean generate(PrintWriter writer) {
		StringBuffer sb = new StringBuffer( );	
		
		try {
			addHeader( sb );
//			addRestrictions( sb );
			addSyntax( sb );
 
			writer.print(sb.toString());
			
//			String parseTable = generateParseTable( sb.toString() );
//			if( parseTable == null )
//				return false;
//			
//			writer.print( parseTable );
			
		} catch( Exception ex ) {
			writer.print( sb.toString() );
			return false;
		}
		
		return true;
	}

	public Collection<GenerationProblem> getCollectedProblems() {
		return null;
 	}
 
 	public IGenerator newInstance(GenerationContext context) {
		return new SGLRGrammarGenerator(context);
 	}
}

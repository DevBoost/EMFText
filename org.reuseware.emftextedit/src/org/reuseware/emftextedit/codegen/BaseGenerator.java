package org.reuseware.emftextedit.codegen;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

/**
 * A basic implementation for generators which generate java or antlr code. 
 * 
 * @author skarol
 */
public abstract class BaseGenerator implements IGenerator {
	
	private static String[] RESERVED_WORDS = new String[] {
		"abstract", 
		"assert", 
		"boolean", 
		"break", 
		"byte", 
		"case", 
		"catch", 
		"char", 
		"class", 
		"const", 
		"continue",  
		"default", 
		"do", 
		"double", 
		"else", 
		"enum", 
		"extends",
		"false", 
		"final", 
		"finally", 
		"float", 
		"for", 
		"goto", 
		"if", 
		"implements", 
		"import", 
		"instanceof", 
		"int", 
		"interface", 
		"long", 
		"native", 
		"new", 
		"null",
		"package", 
		"private", 
		"protected", 
		"public", 
		"return", 
		"short", 
		"static", 
		"strictfp", 
		"super", 
		"switch", 
		"synchronized", 
		"this", 
		"throw", 
		"throws", 
		"transient",
		"true",
		"try", 
		"void", 
		"volatile", 
		"while", 
	};
	
	protected static final Map<String, String> javaNativeTypeMapping;
	static {
		javaNativeTypeMapping = new HashMap<String, String>();
		
		javaNativeTypeMapping.put("int", "Integer");
		javaNativeTypeMapping.put("short", "Short");
		javaNativeTypeMapping.put("long","Long");
		javaNativeTypeMapping.put("double","Double");
		javaNativeTypeMapping.put("byte","Byte");
		javaNativeTypeMapping.put("boolean","Boolean");
		javaNativeTypeMapping.put("float","Float");
	}

	
	private List<GenerationProblem> problems;
	private String className;
	private String packageName;

	
	public BaseGenerator(String className, String packageName){
		problems = new LinkedList<GenerationProblem>();
		this.className = className;
		this.packageName = packageName;
	}
	
	/**
	 * A ResourceGenerator generates its output on a PrintWriter. All its GenerationProblems should be reported
	 * via addProblem(GenerationProblem).<br/> 
	 * Important:  Even with valid output there might be problems.
	 * 
	 * @param out - the target stream to write on
	 * @return true, iff the result is valid
	 */
	public abstract boolean generate(PrintWriter out);
	
	
	/**
	 * Can be used by base classes to collect problems.
	 * 
	 * @param problem
	 */
	protected void addProblem(GenerationProblem problem){
		problems.add(problem);
	}
	
	public Collection<GenerationProblem> getOccuredProblems(){
		return (problems.isEmpty()?null:problems);
	}
	
    /**
     * Capitalizes the first letter of the given string.
     * 
     * @param s a string.
     * @return the modified string.
     */
    protected static String cap(String s) {
        String h = s.substring(0, 1).toUpperCase();
        String t = s.substring(1);      
        return h + t ;
    }
    
  
    
    /**
     * Converts the first letter of the given string to lower case.
     * 
     * @param s a string
     * @return the modified string.
     */
    protected static String low(String s) {
        String h = s.substring(0, 1).toLowerCase();
        String t = s.substring(1);      
        return h + t ;
    }
	
	/**
	 * Returns a valid identifier using the list of <code>RESERVED_WORDS</code>. If the given
	 * identifier is a Java keywords it is prefixed with an underscore. Otherwise the identifier 
	 * itself is returned. The identifier is also converted to lower string.
	 * 
	 * @param identifier an identifier.
	 * @return an identifier that does not lead to conflicts.
	 */
    protected static String getLowerCase(String identifier) {
    	identifier = identifier.toLowerCase();
    	if (isReserveredWord(identifier)) {
    		return "keyword" + identifier;
    	}
    	return identifier;
    }
    
    private static boolean isReserveredWord(String identifier) {
		for (String word : RESERVED_WORDS) {
			if (word.toLowerCase().equals(identifier)) {
				return true;
			}
		}
		return false;
	}

	protected String getResourceClassName(){
    	return className;
    }
    
    protected String getResourcePackageName(){
    	return packageName;
    }
    
    protected String getObjectTypeName(String typeName){
    	if(BaseGenerator.javaNativeTypeMapping.containsKey(typeName)){
    		return BaseGenerator.javaNativeTypeMapping.get(typeName);
    	}
    	return typeName;
    }
    
}

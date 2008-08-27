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
		
		javaNativeTypeMapping.put("int", "java.lang.Integer");
		javaNativeTypeMapping.put("short", "java.lang.Short");
		javaNativeTypeMapping.put("long", "java.lang.Long");
		javaNativeTypeMapping.put("double", "java.lang.Double");
		javaNativeTypeMapping.put("byte", "java.lang.Byte");
		javaNativeTypeMapping.put("boolean", "java.lang.Boolean");
		javaNativeTypeMapping.put("float", "java.lang.Float");
		javaNativeTypeMapping.put("char", "java.lang.Character");
	}

	
	private List<GenerationProblem> errors;
	private List<GenerationProblem> warnings;
	private String className;
	private String packageName;

	
	public BaseGenerator(String className, String packageName){
		errors = new LinkedList<GenerationProblem>();
		warnings = new LinkedList<GenerationProblem>();
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
		if (problem.getSeverity().equals(GenerationProblem.Severity.ERROR)) {
			errors.add(problem);
		}
		else {
			warnings.add(problem);
		}
	}
	
	
	public Collection<GenerationProblem> getOccuredErrors(){
		return (errors.isEmpty()?null:errors);
	}
	
	public Collection<GenerationProblem> getOccuredWarnings(){
		return (warnings.isEmpty()?null:warnings);
	}
	
	public Collection<GenerationProblem> getOccuredWarningsAndErrors(){
		List<GenerationProblem> allProblems = new LinkedList<GenerationProblem>(errors);
		allProblems.addAll(warnings);
		return (allProblems.isEmpty()?null:allProblems);
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

package org.reuseware.emftextedit.codegen;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.reuseware.emftextedit.codegen.IGenerator.GenerationProblem.Severity;
import org.reuseware.emftextedit.codegen.regex.ANTLRexpLexer;
import org.reuseware.emftextedit.codegen.regex.ANTLRexpParser;
import org.reuseware.emftextedit.concretesyntax.Cardinality;
import org.reuseware.emftextedit.concretesyntax.Choice;
import org.reuseware.emftextedit.concretesyntax.CompoundDefinition;
import org.reuseware.emftextedit.concretesyntax.ConcreteSyntax;
import org.reuseware.emftextedit.concretesyntax.ConcretesyntaxPackage;
import org.reuseware.emftextedit.concretesyntax.Containment;
import org.reuseware.emftextedit.concretesyntax.CsString;
import org.reuseware.emftextedit.concretesyntax.DecoratedToken;
import org.reuseware.emftextedit.concretesyntax.DefinedPlaceholder;
import org.reuseware.emftextedit.concretesyntax.Definition;
import org.reuseware.emftextedit.concretesyntax.DerivedPlaceholder;
import org.reuseware.emftextedit.concretesyntax.LineBreak;
import org.reuseware.emftextedit.concretesyntax.NewDefinedToken;
import org.reuseware.emftextedit.concretesyntax.Option;
import org.reuseware.emftextedit.concretesyntax.PLUS;
import org.reuseware.emftextedit.concretesyntax.PreDefinedToken;
import org.reuseware.emftextedit.concretesyntax.QUESTIONMARK;
import org.reuseware.emftextedit.concretesyntax.Rule;
import org.reuseware.emftextedit.concretesyntax.Sequence;
import org.reuseware.emftextedit.concretesyntax.Terminal;
import org.reuseware.emftextedit.concretesyntax.TokenDefinition;
import org.reuseware.emftextedit.concretesyntax.WhiteSpaces;

/**
 * The text parser generator maps from one or more conretesyntaxes (*.cs) and 
 * one or more ecore gen-models to an ANTLR parser specification. 
 * If the derived specification does not contain syntactical conflicts which 
 * could break the ANTLR generation algorithm or the ANTLR parsing algorithm 
 * (e.g. ambiguities in the cfg or in token definitions which are not checked by this generator) 
 * it can be used to generate a text parser which allows to create metamodel 
 * instances from plain text files.
 * 
 * 
 * @author skarol
 *
 */

public class TextParserGenerator extends BaseGenerator{
	
	private static final String CS_OPTION_AUTOFIX_SIMPLE_LEFTRECURSION = "autofixSimpleLeftrecursion";
	/**
	 * The standard token type name (used when no userdefined tokentype is referenced 
	 * and no pre- and suffixes are given).
	 */
	public static final String STD_TOKEN_NAME = "TEXT";
	private static final String STD_TOKEN_DEF  = "('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+";
	
	/**
	 * The whitespace token definition.
	 */
	public static final String WS_TOKEN_NAME = "WS";
	private static final String WS_TOKEN_DEF = "(' ' | '\\t' | '\\f')";
	
	/**
	 * The line break token definition.
	 */
	public static final String LB_TOKEN_NAME = "LB";
	private static final String LB_TOKEN_DEF = "('\\r\\n' | '\\r' | '\\n')";
	
	/**
	 * The name prefix of derived tokendefinitions. 
	 * The full name later is constructed by DERIVED_TOKEN_NAME+_+PREFIXCODE+_+SUFFIXCODE.  
	 */
	public static final String DERIVED_TOKEN_NAME= "QUOTED";
	
	
	/**
	 * These class/interface definitions bring automatically derived TokenDefinitions 
	 * and userdefined TokenDefinitions together. 
	 * 
	 * 
	 * @author skarol
	 *
	 */
	
	
	public static interface InternalTokenDefinition{
		public String getName();
		public String getExpression();
		//might be null
		public String getPrefix();
		//might be null
		public String getSuffix();
		//might be null
		public TokenDefinition getBaseDefinition();
		
		public boolean isReferenced();
		
		public boolean isDerived();
	}
	
	private static class InternalTokenDefinitionImpl implements InternalTokenDefinition{
		private String name;
		private String expression;
		private String prefix;
		private String suffix;
		private PreDefinedToken base;
		private boolean implicitlyReferenced;
		
		public InternalTokenDefinitionImpl(String name, String expression, String prefix, String suffix, PreDefinedToken base, boolean implicitlyReferenced){
			this.name = name;
			this.expression = expression;
			this.prefix = prefix;
			this.suffix = suffix;
			this.base = base;
			this.implicitlyReferenced = implicitlyReferenced;
		}
		
		public String getName() {
			return name;
		}
		public String getExpression() {
			return expression;
		}
		public String getPrefix() {
			return prefix;
		}
		public String getSuffix() {
			return suffix;
		}
		
		public PreDefinedToken getBaseDefinition(){
			return base;
		}
		
		public void setBaseDefinition(PreDefinedToken newBase){
			base = newBase;
		}
		
		public boolean isReferenced(){
			return base==null?implicitlyReferenced:!base.getAttributeReferences().isEmpty();
		}
		
		public boolean isDerived(){
			return true;
		}
	}
	
	private static class TokenDefinitionAdapter implements InternalTokenDefinition{
		private NewDefinedToken adaptee;
		
		public TokenDefinitionAdapter(NewDefinedToken adaptee){
			if(adaptee==null)
				throw new NullPointerException("Adaptee shouldnt be null!");
			this.adaptee = adaptee;
		}

		public TokenDefinition getBaseDefinition() {
			return adaptee;
		}

		public String getExpression() {
			return adaptee.getRegex();
		}

		public String getName() {
			return adaptee.getName();
		}

		public String getPrefix() {
			if(adaptee instanceof DecoratedToken)
				return ((DecoratedToken)adaptee).getPrefix();
			return null;
		}

		public String getSuffix() {
			if(adaptee instanceof DecoratedToken)
				return ((DecoratedToken)adaptee).getSuffix();
			return null;
		}
		
		public boolean isReferenced(){
			return !adaptee.getAttributeReferences().isEmpty();
		}
		
		public boolean isDerived(){
			return false;
		}
	}
	
	
	
	private ConcreteSyntax source;
	private String tokenResolverFactoryName;
	
	private Map<String,InternalTokenDefinition> derivedTokens;
	private Collection<InternalTokenDefinition> printedTokens;
	
	//Map to collect all (non-containment) references that will contain proxies after parsing.
	private Collection<GenFeature> proxyReferences;
	//TODO Mapping only for strings might possibly cause name clashes ...
	private Map<String, Collection<String>> genClasses2superNames;
	private Collection<GenClass> allGenClasses;
	private Map<DerivedPlaceholder,String> placeholder2TokenName;
	
	
	public TextParserGenerator(ConcreteSyntax cs, String csClassName,String csPackageName, String tokenResolverFactoryName){
		super(csClassName,csPackageName);
		source = cs;
		this.tokenResolverFactoryName = tokenResolverFactoryName;
	}
	
	private void initCaches(){
		proxyReferences = new LinkedList<GenFeature>();
		derivedTokens = new HashMap<String,InternalTokenDefinition>();
		placeholder2TokenName = new HashMap<DerivedPlaceholder,String>();
		
		derivedTokens.put(LB_TOKEN_NAME,new InternalTokenDefinitionImpl(LB_TOKEN_NAME,LB_TOKEN_DEF,null,null,null,false));
		derivedTokens.put(WS_TOKEN_NAME,new InternalTokenDefinitionImpl(WS_TOKEN_NAME,WS_TOKEN_DEF,null,null,null,false));
		
		printedTokens = new LinkedList<InternalTokenDefinition>();
		
	    genClasses2superNames = new HashMap<String, Collection<String>>();
	    allGenClasses = new LinkedList<GenClass>(source.getPackage().getGenClasses()); 
	        	
	    for(GenPackage usedGP : source.getPackage().getGenModel().getUsedGenPackages()) {
			allGenClasses.addAll(usedGP.getGenClasses());
		}
		
	    for (GenClass genClass : allGenClasses) {
			HashSet<String> supertypes = new HashSet<String>();
			for (EClass c : genClass.getEcoreClass().getEAllSuperTypes()) {
				supertypes.add(c.getName());
			}
			this.genClasses2superNames.put(genClass.getEcoreClass().getName(), supertypes);
		}

	}
	
	public boolean generate(PrintWriter out){
		initCaches();
		
	    EList<GenPackage> usedGenpackages = new BasicEList<GenPackage>(source.getPackage().getGenModel().getUsedGenPackages()); 
		usedGenpackages.add(0,source.getPackage());
	    
        String csName = super.getResourceClassName();

        out.println("grammar " + csName + ";");
        out.println("options {superClass = EMFTextParserImpl; backtrack = true;}");
        out.println();
        
        //the lexer: package def. and error handling
        out.println("@lexer::header{");
        out.println("package " + super.getResourcePackageName() + ";");
        out.println();
        out.println("}");
        out.println();
        
        out.println("@lexer::members{");
        out.println("\tpublic java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();");
        out.println("\tpublic java.util.List<Integer> lexerExceptionsPosition       = new java.util.ArrayList<Integer>();");
        out.println();
        out.println("\tpublic void reportError(RecognitionException e) {"); 
        out.println("\t\tlexerExceptions.add(e);\n"); 
        out.println("\t\tlexerExceptionsPosition.add(((ANTLRStringStream)input).index());");
        out.println("\t}");
        out.println("}");
        
        //the parser: package def. and entry (doParse) method 
        out.println("@header{");
        out.println("package " + super.getResourcePackageName() + ";");
        out.println();
        
        printGenPackageImports(usedGenpackages,out);
        printDefaultImports(out);
        
        out.println("}");
        out.println();
        
        out.println("@members{");  
        out.println("\tprivate TokenResolverFactory tokenResolverFactory = new " + tokenResolverFactoryName +"();");
        out.println();
        out.println("\tprotected EObject doParse() throws RecognitionException {");
        out.println("\t\t((" + csName + "Lexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;"); //required because the lexer class can not be subclassed
        out.println("\t\t((" + csName + "Lexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;"); //required because the lexer class can not be subclassed
        out.println("\t\treturn start();" );
        out.println("\t}");
        out.println("}");
        out.println();
        
        printStartRule(out);
        
		EList<GenClass> eClassesWithSyntax = new BasicEList<GenClass>();
	    Map<GenClass,Collection<Terminal>> eClassesReferenced = new HashMap<GenClass,Collection<Terminal>>();
	    
	    printGrammarRules(out,eClassesWithSyntax,eClassesReferenced);
	
	    printImplicitChoiceRules(out,eClassesWithSyntax,eClassesReferenced);
	    
	    printTokenDefinitions(out);
	    
	    return this.getOccuredErrors()==null;

	}
	
	private void printStartRule(PrintWriter out){
	       //do the start symbol rule
        out.println("start");
        out.println("returns [ EObject element = null]");
        out.println(":  ");
        int count = 0;
        for(Iterator<GenClass> i = source.getStartSymbols().iterator(); i.hasNext(); ) {
            GenClass aStart = i.next();
            out.println("c" + count + " = " + getLowerCase(aStart.getName()) + "{ element = c" + count + "; }"); 
            if (i.hasNext()) 
            	out.println("\t|  ");
            count++;
        }
        out.println();
        out.println(";");
        out.println();
	}
	
	private void printRightRecursion(PrintWriter out, Rule rule, EList<GenClass> eClassesWithSyntax, Map<GenClass, Collection<Terminal>> classesReferenced) {
		
		String ruleName = rule.getMetaclass().getName();
		GenClass recursiveType = rule.getMetaclass();
		GenPackage genPackage = rule.getMetaclass().getGenPackage();
		
		Rule tailCopy = (Rule) EcoreUtil.copy(rule);
		Rule ruleCopy = (Rule) EcoreUtil.copy(rule);
	    
		
        EList<Sequence> options = tailCopy.getDefinition().getOptions();
        
        String recurseName = "";
        List<Sequence> sequencesToRemove = new ArrayList<Sequence>();
        
        for (Sequence sequence : options) {
        	int indexRecurse = 0;
        	
        	EList<Definition> parts = sequence.getParts();
			for (Definition definition : parts) {
				if (definition instanceof Containment) {
					Containment c = (Containment) definition;
					GenClass featureType = c.getFeature().getTypeGenClass();
					if (recursiveType.equals(featureType) || 
							this.genClasses2superNames.get(featureType.getName()).contains(recursiveType.getName()) ||
							this.genClasses2superNames.get(recursiveType.getName()).contains(featureType.getName())) {
						indexRecurse = parts.indexOf(definition);	
						recurseName = c.getFeature().getName();
						break;	
					}
				}
			}
			if (parts.size()-1 == indexRecurse ) {
				sequencesToRemove.add(sequence);
			} else {
				
				for (int i = 0; i <= indexRecurse; i++)	{
					parts.remove(i);
				}
			}
			
        }
        for (Sequence sequence : sequencesToRemove) {
			tailCopy.getDefinition().getOptions().remove(sequence);
		}
        
    	out.print(getLowerCase(ruleName) +  "_tail");
        out.println(" returns [DummyEObject element = null]");
        out.println("@init{");
        out.println("\telement = new DummyEObject(\""+ ruleName +"\", \""+recurseName+"\");");
        out.println("}");
        out.println(":");
        
        printChoice(tailCopy.getDefinition(),tailCopy,out,0,classesReferenced,proxyReferences,"\t");
        
        out.println(";");
        out.println();
        
        
        out.print(getLowerCase(ruleName));
        out.println(" returns [" + ruleName + " element = null]");
        out.println("@init{");
        out.println("\telement = " + genPackage.getPrefix() + "Factory.eINSTANCE.create" + rule.getMetaclass().getName() + "();");
        out.println("\tList<EObject> dummyEObjects  = new ArrayList<EObject>();");
        out.println("}");
        out.println(":");
       
        Choice choice = ConcretesyntaxPackage.eINSTANCE.getConcretesyntaxFactory().createChoice();
        
        Sequence newSequence = ConcretesyntaxPackage.eINSTANCE.getConcretesyntaxFactory().createSequence();
        Choice reducedChoice = ConcretesyntaxPackage.eINSTANCE.getConcretesyntaxFactory().createChoice();
        
        CompoundDefinition compound = ConcretesyntaxPackage.eINSTANCE.getConcretesyntaxFactory().createCompoundDefinition();
        compound.setDefinitions(reducedChoice);
        newSequence.getParts().add(compound);
        
        choice.getOptions().add(newSequence);
        List<Sequence> recursionFreeSequences = new ArrayList<Sequence>();
        
        LeftRecursionDetector lrd = new LeftRecursionDetector(this.genClasses2superNames, this.source);
        
        for (Sequence sequence : ruleCopy.getDefinition().getOptions()) {
        	Rule leftProducingRule = lrd.findLeftProducingRule(rule.getMetaclass(), sequence, rule);
        	if (leftProducingRule == null) {
        		recursionFreeSequences.add(sequence);
 			}	
		}
        reducedChoice.getOptions().addAll(recursionFreeSequences);
        
        ruleCopy.setDefinition(choice);
        
        printChoice(ruleCopy.getDefinition(),ruleCopy,out,0,classesReferenced,proxyReferences,"\t");
        
        
        out.println(" ( dummyEObject = "+ getLowerCase(ruleName) +  "_tail { dummyEObjects.add(dummyEObject);} )*");
        out.println("{\n\telement = (" + ruleName+ ") apply(element, dummyEObjects);}");
        out.println(";");
        out.println();
        
        eClassesWithSyntax.add(rule.getMetaclass());
        
	}
	
	private void printGrammarRules(PrintWriter out,EList<GenClass> eClassesWithSyntax, Map<GenClass,Collection<Terminal>> eClassesReferenced){
        
		for(Rule rule : source.getAllRules()) {
        	LeftRecursionDetector lrd = new LeftRecursionDetector(this.genClasses2superNames, this.source);
        	Rule recursionRule = lrd.findLeftRecursion(rule);
            if (recursionRule != null) {
            	Option option = GeneratorUtil.getOptionByName(CS_OPTION_AUTOFIX_SIMPLE_LEFTRECURSION, source.getOptions());
            	boolean autofix = (option == null) ? false : Boolean.parseBoolean(option.getValue());
            	if(lrd.isDirectLeftRecursive(rule)) {// direct left recursion
            		if (autofix) {
            			System.out.println();
                    	printRightRecursion(out, rule, eClassesWithSyntax, eClassesReferenced);	
                    	
    					
    					Collection<GenClass> subClasses = GeneratorUtil.getSubClassesWithCS(rule.getMetaclass(),source.getAllRules());
                        if(!subClasses.isEmpty()){
                        	out.println("\t|//derived choice rules for sub-classes: ");
                        	printSubClassChoices(out,subClasses);
                        	out.println();
                        }
                        
                        String message = "Applied experimental autofix: Rule " +  rule.getMetaclass().getName() + " is direct left recursive by rule " + recursionRule.getMetaclass().getName()+ 
                    	".";
                    	GenerationProblem generationWarning = new GenerationProblem(message, Severity.HINT, rule, null);
                		addProblem(generationWarning);
                		continue;
            		}
            		else {
            			String message = "Warning: Rule " +  rule.getMetaclass().getName() + " is direct left recursive by rule " + recursionRule.getMetaclass().getName();
                  		GenerationProblem generationWarning = new GenerationProblem(message, Severity.HINT, rule, null);
                  		addProblem(generationWarning);
                		printGrammarRule(rule, out, eClassesWithSyntax, eClassesReferenced);
            		}
            	}
            	else {
            		String message = "Rule " +  rule.getMetaclass().getName() + " is mutual left recursive by rule " + recursionRule.getMetaclass().getName()+" ! Please restructure the grammar.";
            		GenerationProblem generationWarning = new GenerationProblem(message, Severity.HINT, rule, null);
              		addProblem(generationWarning);
            		printGrammarRule(rule, out, eClassesWithSyntax, eClassesReferenced);
            	}
            
            }
            else {
            	printGrammarRule(rule, out, eClassesWithSyntax, eClassesReferenced);
            }
            
            
         	
        }
	}
	
   
	private void printGrammarRule(Rule rule, PrintWriter out,EList<GenClass> eClassesWithSyntax, Map<GenClass,Collection<Terminal>> eClassesReferenced) {
		String ruleName = rule.getMetaclass().getName();
        GenPackage genPackage = rule.getMetaclass().getGenPackage();
        
        out.print(getLowerCase(ruleName));
        out.println(" returns [" + ruleName + " element = null]");
        out.println("@init{");
        out.println("\telement = " + genPackage.getPrefix() + "Factory.eINSTANCE.create" + rule.getMetaclass().getName() + "();");
        out.println("}");
        out.println(":");
        
        printChoice(rule.getDefinition(),rule,out,0,eClassesReferenced,proxyReferences,"\t");
        
        Collection<GenClass> subClasses = GeneratorUtil.getSubClassesWithCS(rule.getMetaclass(),source.getAllRules());
        if(!subClasses.isEmpty()){
        	out.println("\t|//derived choice rules for sub-classes: ");
        	printSubClassChoices(out,subClasses);
        	out.println();
        }
        
        out.println(";");
        out.println();
        
        eClassesWithSyntax.add(rule.getMetaclass());
	}
	

	private int printChoice(Choice choice, Rule rule, PrintWriter out, int count,Map<GenClass,Collection<Terminal>> eClassesReferenced, Collection<GenFeature> proxyReferences, String indent) {
    	Iterator<Sequence> it = choice.getOptions().iterator();
    	while(it.hasNext()){
    		Sequence seq = it.next();
            count = printSequence(seq, rule, out, count, eClassesReferenced, proxyReferences, indent);
            if(it.hasNext()){
            	out.println();
            	out.print(indent);
            	out.println("|");
            }
    	}
    	//out.println();
        return count;
    }
	
    private int printSequence(Sequence sequence, Rule rule, PrintWriter out, int count,Map<GenClass,Collection<Terminal>> eClassesReferenced, Collection<GenFeature> proxyReferences, String indent) {
    	Iterator<Definition> it = sequence.getParts().iterator();
    	while(it.hasNext()){
    		Definition def = it.next();
    		if(def instanceof LineBreak || def instanceof WhiteSpaces)
    			continue;
    		String cardinality = computeCardinalityString(def.getCardinality());
    		if(cardinality!=null){
    			out.println(indent+"(");
    			indent += "\t";
    		}
    		if(def instanceof CompoundDefinition){
            	CompoundDefinition compoundDef = (CompoundDefinition) def;
                out.println(indent+"(");
                count = printChoice(compoundDef.getDefinitions(), rule,out, count, eClassesReferenced, proxyReferences, indent+"\t");
                out.print(indent+")");
    		}
    		else if(def instanceof CsString){
    			CsString terminal = (CsString) def;
    	        out.print(indent+"'" + terminal.getValue().replaceAll("'", "\\\\'") + "'");
    		}
    		else{
    			assert def instanceof Terminal;
    			count = printTerminal((Terminal)def,rule,out,count,eClassesReferenced,proxyReferences,indent);
    		}
    		if(cardinality!=null){
    			indent = indent.substring(1);
    			out.println();
    			out.print(indent+")"+cardinality);
    		}
    		
    			out.println();
    	}
    	return count;
    }
    
    private int printTerminal(Terminal terminal,Rule rule,PrintWriter out, int count,Map<GenClass,Collection<Terminal>> eClassesReferenced, Collection<GenFeature> proxyReferences, String indent){
    	final EStructuralFeature sf = terminal.getFeature().getEcoreFeature();
		final String ident = "a" + count;
    	final String proxyIdent = "proxy";
    	
		String expressionToBeSet = null;
    	String resolvements = "";
    	
    	out.print(indent);
    	out.print(ident + " = ");
    	
    	if(terminal instanceof Containment){
    		assert ((EReference)sf).isContainment(); 
            out.print(getLowerCase(sf.getEType().getName())); 
            if(!(terminal.getFeature().getEcoreFeature() instanceof EAttribute)){
                //remember which classes are referenced to add choice rules for these classes later
                if (!eClassesReferenced.keySet().contains(terminal.getFeature().getTypeGenClass())) {
                  	eClassesReferenced.put(terminal.getFeature().getTypeGenClass(),new HashSet<Terminal>());
                }
               
                eClassesReferenced.get(terminal.getFeature().getTypeGenClass()).add(terminal);            	
            }
            expressionToBeSet = ident;
    	}
    	else if (sf instanceof EAttribute && sf.getEType() instanceof EEnum) {
    		
    		EEnum enumeration = (EEnum) sf.getEType();
    		out.print("(");
    		String resolvedLiteral = "resolvedLiteral";
    		EList<EEnumLiteral> literals = enumeration.getELiterals();
			if (literals.size() > 0) {
    			out.print("'" + literals.get(0) + "'" );
    			for (EEnumLiteral lit : literals.subList(1, literals.size())) {
        			out.print(" | " + "'" + lit + "'");
        		}
			}
    		
    		out.print(")");
    		
    		
			String packagePrefix = sf.getEType().getEPackage().getName();
			resolvements += "Object " + resolvedLiteral + " = " + sf.getEType().getName() + ".get("+ ident + ".getText());"; 
    		expressionToBeSet = resolvedLiteral;
        	
    	    
    	}
        else {
        	
        	String tokenName = null;
        	if(terminal instanceof DerivedPlaceholder){
        		DerivedPlaceholder placeholder = (DerivedPlaceholder)terminal;
         		InternalTokenDefinition definition = deriveTokenDefinition(placeholder.getPrefix(),placeholder.getSuffix());
        		tokenName = definition.getName();
            	placeholder2TokenName.put(placeholder,tokenName);
        	}
        	else{
        		assert terminal instanceof DefinedPlaceholder;
        		DefinedPlaceholder placeholder = (DefinedPlaceholder)terminal;
        		tokenName = placeholder.getToken().getName();
        	
        	}
        	
        	out.print(tokenName);
        	
        	String targetTypeName = null;
        	String resolvedIdent = "resolved";
        	String preResolved = resolvedIdent+"Object";
        	String resolverIdent = resolvedIdent+"Resolver";
           	resolvements += "TokenResolver " +resolverIdent +" = tokenResolverFactory.createTokenResolver(\"" + tokenName + "\");";
        	resolvements += "Object " + preResolved + " ="+resolverIdent+".resolve(" +ident+ ".getText(),element.eClass().getEStructuralFeature(\"" + sf.getName() + "\"),element,getResource());";
        	resolvements += "if(" + preResolved + "==null)throw new TokenConversionException("+ident+","+resolverIdent+".getErrorMessage());";
        	
        	if(sf instanceof EReference){
        		targetTypeName = "String";
        		expressionToBeSet = proxyIdent;
   
        		//a subtype that can be instantiated as a proxy
            	GenClass instanceType = terminal.getFeature().getTypeGenClass();
            	String proxyTypeName = null;
            	String genPackagePrefix = null;
            	
            	if(instanceType.isAbstract()||instanceType.isInterface()){
            		for(GenClass instanceCand : allGenClasses){
            			Collection<String> supertypes = genClasses2superNames.get(instanceCand.getEcoreClass().getName());		
            			if (!instanceCand.isAbstract()&&!instanceCand.isInterface()&&supertypes.contains(instanceType.getEcoreClass().getName())) {
        					genPackagePrefix = instanceCand.getGenPackage().getPrefix();
        	            	proxyTypeName = instanceCand.getName();
        	            	break;
        				}            			
            		}
            	}
            	else{
            		proxyTypeName = instanceType.getName();
            		genPackagePrefix = instanceType.getGenPackage().getPrefix();
            	}
            	
            	resolvements += targetTypeName + " " + resolvedIdent + " = (" + targetTypeName + ") "+preResolved+";";
	           	
            	//resolvements += targetTypeName + " " + resolvedIdent + " = (" + targetTypeName + ") tokenResolverFactory.createTokenResolver(\"" + tokenName + "\").resolve(" +ident+ ".getText(),element.eClass().getEStructuralFeature(\"" + sf.getName() + "\"),element,getResource());";
	           	resolvements += proxyTypeName + " " + expressionToBeSet + " = " + genPackagePrefix + "Factory.eINSTANCE.create" + proxyTypeName + "();" 
				+ "((InternalEObject)" + expressionToBeSet + ").eSetProxyURI((resource.getURI()==null?URI.createURI(\"dummy\"):resource.getURI()).appendFragment(" + resolvedIdent + ")); ";
	        
	           	//remember where proxies have to be resolved
            	proxyReferences.add(terminal.getFeature());

        	}
        	else{
        		
        		EAttribute attr = (EAttribute)sf;
        		if (! ( attr.getEType() instanceof EEnum) ){
                   	targetTypeName = attr.getEAttributeType().getInstanceClassName();        			
        		}
               	resolvements += targetTypeName + " " + resolvedIdent + " = (" + getObjectTypeName(targetTypeName) + ")" + preResolved + ";";
        		expressionToBeSet = "resolved";
        	}
        }
        	
    	out.print("{");
    	out.print(resolvements);
        if(sf.getUpperBound()==1){
           out.print("element.eSet(element.eClass().getEStructuralFeature(\"" + sf.getName() + "\"), " + expressionToBeSet +"); ");
        }
        else{
            //TODO Warning, if a value is used twice. 
        	//whatever...
            out.print("((List) element.eGet(element.eClass().getEStructuralFeature(\"" + sf.getName() + "\"))).add(" + expressionToBeSet +"); ");
        }
        
        if(terminal instanceof Containment){
            out.print("getResource().setElementCharStart(element, getResource().getElementCharStart(" + ident + ")); "); 
            out.print("getResource().setElementCharEnd(element, getResource().getElementCharEnd(" + ident + ")); "); 
            out.print("getResource().setElementColumn(element, getResource().getElementColumn(" + ident + ")); "); 
            out.print("getResource().setElementLine(element, getResource().getElementLine(" + ident + "));"); 
        }else{
            out.print("getResource().setElementCharStart(element, ((CommonToken)" + ident + ").getStartIndex()); "); 
            out.print("getResource().setElementCharEnd(element, ((CommonToken)" + ident + ").getStopIndex()); ");    
            out.print("getResource().setElementColumn(element, " + ident + ".getCharPositionInLine()); ");    
            out.print("getResource().setElementLine(element, " + ident + ".getLine()); ");
            if(sf instanceof EReference){
            	//additionally set position information for the proxy instance	
                out.print("getResource().setElementCharStart(" + proxyIdent + ", ((CommonToken)" + ident + ").getStartIndex()); "); 
                out.print("getResource().setElementCharEnd(" + proxyIdent + ", ((CommonToken)" + ident + ").getStopIndex()); ");    
                out.print("getResource().setElementColumn(" + proxyIdent + ", " + ident + ".getCharPositionInLine()); ");    
                out.print("getResource().setElementLine(" + proxyIdent + ", " + ident + ".getLine()); ");
            }
        }
    	
        out.print("}");
    	return ++count;	
    }
    
    
    private void printImplicitChoiceRules(PrintWriter out, EList<GenClass> eClassesWithSyntax, Map<GenClass,Collection<Terminal>> eClassesReferenced){
        
    	for(GenClass referencedClass : eClassesReferenced.keySet()) {
            if(!cointainsEqualByName(eClassesWithSyntax,referencedClass)) {
            	//rule not explicitly defined in CS: most likely a choice rule in the AS
            	Collection<GenClass> subClasses = GeneratorUtil.getSubClassesWithCS(referencedClass,source.getAllRules());
            	
            	if (subClasses.isEmpty()) {
            	  String message = "Referenced class '"+referencedClass.getName()+"' has no defined concrete Syntax.";
            	  for(Terminal terminal:eClassesReferenced.get(referencedClass)){
            		  addProblem(new GenerationProblem(message,terminal));
            	  }
               }
               else {
               	
                   out.println(getLowerCase(referencedClass.getName()));
                   out.println("returns [" + referencedClass.getName() + " element = null]");
                   out.println(":");
                   printSubClassChoices(out,subClasses);
                   out.println();
                   out.println(";");
                   out.println();
                   
                   //add import .... shouldnt it already be there?
                   //GenPackage p = referencedClass.getGenPackage();
                   //s.insert(importIdx, "import " + ( p.getBasePackage()==null?"": p.getBasePackage() + "." )+ p.getEcorePackage().getName() + "." + referencedClass.getName() + ";\n");
                   //referenced class now has syntax
                   eClassesWithSyntax.add(referencedClass);
               }
               
           }
       }	
    }
    
    private void printSubClassChoices(PrintWriter out, Collection<GenClass> subClasses){
        int count = 0;
        for(Iterator<GenClass> i = subClasses.iterator(); i.hasNext(); ) {
            GenClass subRef = i.next();
            out.print("\tc" + count + " = " + getLowerCase(subRef.getName()) + "{ element = c" + count + "; }"); 
            if (i.hasNext()) 
         	   out.println("\t|");
            count++;
        }
    }
    
 
      
    private boolean cointainsEqualByName(EList<GenClass> list, GenClass o){
    	for(GenClass entry:list){
     		EClass entryClass = entry.getEcoreClass();
     		EClass oClass = o.getEcoreClass();
     		if(entryClass.getName().equals(oClass.getName())&&entryClass.getEPackage().getNsURI().equals(oClass.getEPackage().getNsURI())){
     			return true;
     		}
    	}
    	return false;
    }
    
    /**
     * <p>Derives a Tokendefinition from the given prefix and suffix char. If the suffix is valued -1,
     * a standard Definition using the static values STD_TOKEN_NAME and STD_TOKEN_DEF will be created and registered 
     * (if not yet been done) and returned. If additionally a prefix is given, the tokens name will be the conjunction
     * of the value STD_TOKEN_NAME, "_", "prefix", "_". The resulting regular expression is constructed by prepending
     * the prefix to the value STD_TOKEN_DEF.  </p>
     * <p>
     * If suffix is given a Tokendefinition, matching the given prefix (if there) first and than matching all characters,
     * excepting the suffix, is created and returned. The name of this definition is the conjunction of the value 
     * in DERIVED_TOKEN_NAME, "_", prefix, "_" and suffix. </p>
     * 
     * @param pref
     * @param suff
     * @return
     */
    
    private InternalTokenDefinition deriveTokenDefinition(String pref, String suff){
    	String derivedTokenName = null;
    	if(suff!=null&&suff.length()>0){
        	String derivedExpression = null;
    		if(pref!=null&&pref.length()>0){
    			derivedTokenName = DERIVED_TOKEN_NAME + "_" + deriveCodeSequence(pref) + "_" + deriveCodeSequence(suff);
    			if(!derivedTokens.containsKey(derivedTokenName)){
    				derivedExpression = "(~('"+ escapeLiteralChars(suff) +"')|('\\\\''"+escapeLiteralChars(suff)+"'))*";
    				InternalTokenDefinition result =  new InternalTokenDefinitionImpl(derivedTokenName,derivedExpression,pref,suff,null,true);
    				derivedTokens.put(derivedTokenName,result);
    			}	
    		}
    		else{
       			derivedTokenName = DERIVED_TOKEN_NAME + "_" + "_" + deriveCodeSequence(suff);
    			if(!derivedTokens.containsKey(derivedTokenName)){
    				derivedExpression =  "(~('"+ escapeLiteralChars(suff) +"')|( '\\\\' '"+escapeLiteralChars(suff)+"' ))* '";
    				InternalTokenDefinition result =  new InternalTokenDefinitionImpl(derivedTokenName,derivedExpression,null,suff,null,true);
    				derivedTokens.put(derivedTokenName,result);
    			}	
    		}
		}
    	else{
    		if(pref!=null&&pref.length()>0){
				String derivedExpression = null;
    			derivedTokenName = STD_TOKEN_NAME + "_" + deriveCodeSequence(pref) + "_";
				if(!derivedTokens.containsKey(derivedTokenName)){
					derivedExpression =  STD_TOKEN_DEF;
					InternalTokenDefinition result = new InternalTokenDefinitionImpl(derivedTokenName,derivedExpression,pref,null,null,true);
					derivedTokens.put(derivedTokenName,result);
				}
    		}
    		else{
    			derivedTokenName = STD_TOKEN_NAME;
    			if(!derivedTokens.containsKey(derivedTokenName)){
    				InternalTokenDefinition result = new InternalTokenDefinitionImpl(derivedTokenName,STD_TOKEN_DEF,null,null,null,true);
    				derivedTokens.put(derivedTokenName,result);
    			}

    		}
    	}
    	return derivedTokens.get(derivedTokenName);
    }
    
    private String deriveCodeSequence(String original){
    	char[] chars = original.toCharArray();
    	String result = "";
    	for(int i=0;i<chars.length;i++){
    		if(chars[i]<10)
    			result += "0";
    		result += (int)chars[i];                     
    	}
    	return result;
    }
    
    
    private String escapeLiteralChar(char candidate){
    	String result = "";
    	switch (candidate){
    		case '\'': case '\\': 
    			result += "\\";
    		default:
    			result += candidate;
    	}
    	return result;
    }
    
    /**
     * Used to escape prefix/suffix strings (surrounded by "'" in ANTLR).
     * 
     */
    private String escapeLiteralChars(String candidate){
    	StringBuffer escaped = new StringBuffer();
    	char[] chars = candidate.toCharArray();
    	for(int i=0;i<chars.length;i++){
    		escaped.append(escapeLiteralChar(chars[i]));
    	}
    		
    	return escaped.toString();
    }
    
  
	
	private void printTokenDefinitions(PrintWriter out){
		Set<String> processedTokenNames = new HashSet<String>();
		Collection<TokenDefinition> userDefinedTokens = source.getTokens();
		for(TokenDefinition def:userDefinedTokens){
			if(def.getName().charAt(0)<'A'||def.getName().charAt(0)>'Z'){
				addProblem(new GenerationProblem("Token names must start with capital letter.",def));
				continue;
			}
			if(processedTokenNames.contains(def.getName().toLowerCase())){
				addProblem(new GenerationProblem("Tokenname already in use (ignoring case).",def));
				continue;
			}
			if(def instanceof NewDefinedToken){
				InternalTokenDefinition defAdapter = new TokenDefinitionAdapter((NewDefinedToken)def);
				
				if(!checkANTLRRegex(defAdapter)){ 
					
					continue;
				}
				printToken(defAdapter,out);
				processedTokenNames.add(defAdapter.getName().toLowerCase());
				printedTokens.add(defAdapter);
			}
			else if(def instanceof PreDefinedToken){
				if(derivedTokens.get(def.getName())!=null){
					InternalTokenDefinition defAdapter = derivedTokens.remove(def.getName());
					printToken(defAdapter,out);
					processedTokenNames.add(defAdapter.getName().toLowerCase());
					printedTokens.add(defAdapter);
				}
				else{
					addProblem(new GenerationProblem("Token is neither predefined nor derived.",def));
				}
			}
		}
		//finally process untouched derived definitions
		for(String tokenName:derivedTokens.keySet()){
			InternalTokenDefinition def = derivedTokens.get(tokenName);
			printToken(def,out);
			processedTokenNames.add(tokenName.toLowerCase());
			printedTokens.add(def);
		}
	}
	
	private void printToken(InternalTokenDefinition def, PrintWriter out){
		out.println(def.getName());
		out.println(":");
		out.print("\t");
		
		if(def.getPrefix()!=null && def.getPrefix().length()>0){
			String regex = "('" + escapeLiteralChars(def.getPrefix()) + "')";
			out.print(regex);
		}
		
		out.print(def.getExpression());
		
		if(def.getSuffix()!=null && def.getPrefix().length()>0){
			String regex = "('" + escapeLiteralChars(def.getSuffix()) + "')";
			out.print(regex);
		}
		
		out.println(def.isReferenced()?"":"{ channel=99; }");
		out.println(";");
	}
	
	
	private void printGenPackageImports(Collection<GenPackage> usedGenpackages, PrintWriter out){    
        
		for(GenPackage p:usedGenpackages){
            out.println("//+++++++++++++++++++++++imports for "+p.getQualifiedPackageName()+" begin++++++++++++++++++++++");
			for(GenClass genClass : p.getGenClasses()) {
			   if(genClass.getEcoreClass().getName()==null){
				   out.println("//No ecore class for genClass: "+genClass.getName());
			   }else{
	               out.println("import " + genClass.getQualifiedInterfaceName() + ";");        	
	               out.println("//Implementation: "+genClass.getQualifiedClassName());
			   }
            }
			for(GenEnum genEnum : p.getGenEnums()) {
				   if(genEnum.getEcoreEnum().getName() == null){
					   out.println("//No ecore class for genClass: " + genEnum.getName());
				   }else{
		               out.println("import " + genEnum.getQualifiedName() + ";");        	
		               out.println("//Implementation: "+genEnum.getQualifiedName());
				   }
	            }
            String usedPackagePrefix = p.getBasePackage()==null?"":(p.getBasePackage() + ".");
        	out.println("import " + usedPackagePrefix + p.getEcorePackage().getName() + ".*;");
			out.println("import " + usedPackagePrefix + p.getEcorePackage().getName() + ".impl.*;");
        }		
	}
	
	private void printDefaultImports(PrintWriter out){
        out.println("import org.reuseware.emftextedit.resource.*;");
        out.println("import org.reuseware.emftextedit.resource.impl.*;");
        out.println("import org.eclipse.emf.ecore.EObject;");
        out.println("import org.eclipse.emf.ecore.InternalEObject;");
        out.println("import org.eclipse.emf.common.util.URI;");
	}
	

	/**
	 * @return The tokendefinitions which were printed during last 
	 * execution for printing token resolvers.
	 */
	
	public Collection<InternalTokenDefinition> getPrintedTokenDefinitions(){
		return printedTokens;
	}
	
	/**
	 * @return All features which will be replaced with a proxy during a parse 
	 * and therefore need proxy resolvers.
	 */
	
	public Collection<GenFeature> getProxyReferences(){
		return proxyReferences;
	}
	
	/**
	 * 
	 * @return A mapping between derived Placeholders and Tokennames
	 */
	public Map<DerivedPlaceholder,String> getPlaceHolderTokenMapping(){
		return placeholder2TokenName;
	}
	
    
    private String computeCardinalityString(Cardinality card){
    	if(card==null)
    		return null;
    	else if(card instanceof PLUS)
    		return "+";
    	else if(card instanceof QUESTIONMARK)
    		return "?";
    	else
    		return "*";
    }
   
    private boolean checkANTLRRegex(InternalTokenDefinition def){
    	ByteArrayOutputStream out = new ByteArrayOutputStream();
    	PrintWriter w = new PrintWriter(new BufferedOutputStream(out));
    	w.print(def.getExpression());
    	w.flush();
    	w.close(); 
    	
    	try{
    		ANTLRexpLexer lexer = new ANTLRexpLexer(new ANTLRInputStream(new  ByteArrayInputStream(out.toByteArray())));
    		ANTLRexpParser parser = new ANTLRexpParser(new CommonTokenStream(lexer));
         	parser.root();
         	if(!parser.recExceptions.isEmpty()){
         		for(RecognitionException e:parser.recExceptions){
         			String message = lexer.getErrorMessage(e,lexer.getTokenNames());
         			if(message==null||message.equals(""))
         				message = parser.getErrorMessage(e,parser.getTokenNames());
         			addProblem(new GenerationProblem(message, def.getBaseDefinition()));
         		}
         		return false;
         	}
         	
        }catch(Exception e){
        	addProblem(new GenerationProblem(e.getMessage(), def.getBaseDefinition()));
        	return false;
        }
       return true;
    }
    
}

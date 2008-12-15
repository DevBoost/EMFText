package org.emftext.sdk.codegen;

import static org.emftext.runtime.StandardTokenDefinitions.LB_TOKEN_DEF;
import static org.emftext.runtime.StandardTokenDefinitions.LB_TOKEN_NAME;
import static org.emftext.runtime.StandardTokenDefinitions.STD_TOKEN_DEF;
import static org.emftext.runtime.StandardTokenDefinitions.STD_TOKEN_NAME;
import static org.emftext.runtime.StandardTokenDefinitions.WS_TOKEN_DEF;
import static org.emftext.runtime.StandardTokenDefinitions.WS_TOKEN_NAME;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.emftext.runtime.resource.TokenConversionException;
import org.emftext.runtime.resource.TokenResolver;
import org.emftext.runtime.resource.TokenResolverFactory;
import org.emftext.runtime.resource.impl.EMFTextParserImpl;
import org.emftext.sdk.codegen.GenerationProblem.Severity;
import org.emftext.sdk.codegen.regex.ANTLRexpLexer;
import org.emftext.sdk.codegen.regex.ANTLRexpParser;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.DecoratedToken;
import org.emftext.sdk.concretesyntax.DefinedPlaceholder;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.DerivedPlaceholder;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.NewDefinedToken;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.PLUS;
import org.emftext.sdk.concretesyntax.PreDefinedToken;
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.WhiteSpaces;

/**
 * The text parser generator maps from one or more concrete syntaxes (*.cs) and 
 * one or more Ecore generator models to an ANTLR parser specification. 
 * If the derived specification does not contain syntactical conflicts which 
 * could break the ANTLR generation algorithm or the ANTLR parsing algorithm 
 * (e.g. ambiguities in the configuration or in token definitions which are 
 * not checked by this generator) it can be used to generate a text parser 
 * which allows to create metamodel instances from plain text files.
 * 
 * @author skarol
 */
public class TextParserGenerator extends BaseGenerator {
	

	
	/**
	 * The name of the EOF token which can be printed to force end of file after a parse from the root. 
	 */
	public static final String EOF_TOKEN_NAME = "EOF";
	
	/**
	 * The name prefix of derived tokendefinitions. 
	 * The full name later is constructed by DERIVED_TOKEN_NAME+_+PREFIXCODE+_+SUFFIXCODE.  
	 */
	public static final String DERIVED_TOKEN_NAME= "QUOTED";
	
	/**
	 * These class/interface definitions bring automatically derived TokenDefinitions 
	 * and user-defined TokenDefinitions together. 
	 * 
	 * @author skarol
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
		private boolean implicitlyReferenced;
		
		public TokenDefinitionAdapter(NewDefinedToken adaptee){
			this(adaptee,false);
		}
		
		public TokenDefinitionAdapter(NewDefinedToken adaptee,boolean implicitlyReferenced){
			if(adaptee==null)
				throw new NullPointerException("Adaptee shouldnt be null!");
			this.adaptee = adaptee;
			this.implicitlyReferenced = implicitlyReferenced;
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
			return implicitlyReferenced||!adaptee.getAttributeReferences().isEmpty();
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
	
	private String standardTextTokenName;
	private boolean forceEOFToken;
	private boolean useDefaultTokens;
	
	public TextParserGenerator(ConcreteSyntax cs, String csClassName,String csPackageName, String tokenResolverFactoryName){
		super(csClassName,csPackageName);
		source = cs;
		this.tokenResolverFactoryName = tokenResolverFactoryName;
	}
	
	private void initOptions(){
		Option currentOption = GeneratorUtil.getOptionByName(ICodeGenOptions.CS_OPTION_STD_TOKEN_NAME,source.getOptions());
		standardTextTokenName = currentOption == null ? STD_TOKEN_NAME : currentOption.getValue();
		if (standardTextTokenName == null) {
			standardTextTokenName = STD_TOKEN_NAME;
		}
		char firstLetter = standardTextTokenName.charAt(0);
		//can this check be done by OCL?
		if (!(firstLetter >= 'A' && firstLetter <= 'Z')) {
			addProblem(new GenerationProblem("Token names must start with a capital letter.", currentOption,Severity.ERROR));
		}
		currentOption = GeneratorUtil.getOptionByName(ICodeGenOptions.CS_OPTION_FORCE_EOF,source.getOptions());
		forceEOFToken = currentOption == null ? true : Boolean.parseBoolean(currentOption.getValue());
		currentOption = GeneratorUtil.getOptionByName(ICodeGenOptions.CS_OPTION_USE_DEFAULT_TOKENS,source.getOptions());
		useDefaultTokens = currentOption==null?true:(currentOption.getValue().equals("false")?false:true);
	}
	
	private void initCaches(){
		proxyReferences = new LinkedList<GenFeature>();
		derivedTokens = new HashMap<String,InternalTokenDefinition>();
		placeholder2TokenName = new HashMap<DerivedPlaceholder,String>();
		
		if(useDefaultTokens){
			derivedTokens.put(LB_TOKEN_NAME,new InternalTokenDefinitionImpl(LB_TOKEN_NAME,LB_TOKEN_DEF,null,null,null,false));
			derivedTokens.put(WS_TOKEN_NAME,new InternalTokenDefinitionImpl(WS_TOKEN_NAME,WS_TOKEN_DEF,null,null,null,false));			
		}
		
		printedTokens = new LinkedList<InternalTokenDefinition>();
		
	    genClasses2superNames = new HashMap<String, Collection<String>>();
	    
	    allGenClasses = new LinkedList<GenClass>();
	    
	    for(GenPackage includedGP : source.getPackage().getGenModel().getGenPackages()){
	    	allGenClasses.addAll(includedGP.getGenClasses());
	    }
	    
	    for(GenPackage usedGP : source.getPackage().getGenModel().getUsedGenPackages()) {
			allGenClasses.addAll(usedGP.getGenClasses());
		}
		
	    for (GenClass genClass : allGenClasses) {
			Collection<String> supertypes = new LinkedList<String>();
			for (EClass c : genClass.getEcoreClass().getEAllSuperTypes()) {
				supertypes.add(c.getName());
			}
			genClasses2superNames.put(genClass.getEcoreClass().getName(), supertypes);
		}
	}
	
	public boolean generate(PrintWriter out){
		initOptions();
		initCaches();
		
        String csName = super.getResourceClassName();

        out.println("grammar " + csName + ";");
        out.println("options {superClass = " + EMFTextParserImpl.class.getSimpleName() + "; backtrack = true;}");
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
        
        printDefaultImports(out);
        
        out.println("}");
        out.println();
        
        out.println("@members{");  
        out.println("\tprivate " + TokenResolverFactory.class.getName() + " tokenResolverFactory = new " + tokenResolverFactoryName +"();");
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
	    Map<GenClass, Collection<Terminal>> eClassesReferenced = new LinkedHashMap<GenClass, Collection<Terminal>>();
	    
	    printGrammarRules(out, eClassesWithSyntax, eClassesReferenced);
	    printImplicitChoiceRules(out, eClassesWithSyntax, eClassesReferenced);
	    
	    printTokenDefinitions(out);
	    
	    return getOccuredErrors().size() == 0;
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
        if(forceEOFToken) {
        	out.println("\t"+ EOF_TOKEN_NAME);
        }
        out.println();
        out.println(";");
        out.println();
	}
	
	private void printRightRecursion(PrintWriter out, Rule rule, EList<GenClass> eClassesWithSyntax, Map<GenClass, Collection<Terminal>> classesReferenced) {
		
		String ruleName = rule.getMetaclass().getName();
		GenClass recursiveType = rule.getMetaclass();
		
		{	
			Copier copier = new Copier(true, true);
			Rule ruleCopy = (Rule) copier.copy(rule);
			copier.copyReferences();	    
			
	 
	        
	        out.print(getLowerCase(ruleName));
	        out.println(" returns [" + ruleName + " element = null]");
	        out.println("@init{");
			out.println("\telement = " + getCreateObjectCall(recursiveType) + ";");
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
		}
			
		{
			Rule tailCopy = rule;
			
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
	        out.println("\telement = new DummyEObject(" + getCreateObjectCall(rule.getMetaclass()) + "()" +", \""+recurseName+"\");");
	        out.println("}");
	        out.println(":");
	        
	        printChoice(tailCopy.getDefinition(),tailCopy,out,0,classesReferenced,proxyReferences,"\t");
	        
	        out.println(";");
	        out.println();
		}
	    eClassesWithSyntax.add(rule.getMetaclass());
	        
	}

	private String getCreateObjectCall(GenClass genClass) {
		GenPackage genPackage = genClass.getGenPackage();
		return genPackage.getQualifiedFactoryClassName() + ".eINSTANCE.create" + genClass.getName() + "()";
	}
	
	private void printGrammarRules(PrintWriter out,EList<GenClass> eClassesWithSyntax, Map<GenClass,Collection<Terminal>> eClassesReferenced){
        
		for(Rule rule : source.getAllRules()) {
        	LeftRecursionDetector lrd = new LeftRecursionDetector(this.genClasses2superNames, this.source);
        	Rule recursionRule = lrd.findLeftRecursion(rule);
            if (recursionRule != null) {
            	Option option = GeneratorUtil.getOptionByName(ICodeGenOptions.CS_OPTION_AUTOFIX_SIMPLE_LEFTRECURSION, source.getOptions());
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
                        
                        String message = "Applied experimental autofix: Rule \"" +  rule.getMetaclass().getName() + "\" is direct left recursive by rule \"" + recursionRule.getMetaclass().getName() + 
                    	"\".";
                    	GenerationProblem generationWarning = new GenerationProblem(message, rule, Severity.WARNING);
                		addProblem(generationWarning);
                		continue;
            		}
            		else {
            			String message = "Warning: Rule \"" +  rule.getMetaclass().getName() + "\" is direct left recursive by rule \"" + recursionRule.getMetaclass().getName() + "\".";
                  		GenerationProblem generationWarning = new GenerationProblem(message, rule, Severity.WARNING);
                  		addProblem(generationWarning);
                		printGrammarRule(rule, out, eClassesWithSyntax, eClassesReferenced);
            		}
            	}
            	else {
            		String message = "Rule \"" +  rule.getMetaclass().getName() + "\" is mutual left recursive by rule \"" + recursionRule.getMetaclass().getName()+"\"! Please restructure the grammar.";
            		GenerationProblem generationWarning = new GenerationProblem(message, rule, Severity.WARNING);
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
		GenClass genClass = rule.getMetaclass();

        String ruleName = genClass.getName();
        
		String qualifiedClassName = genClass.getQualifiedInterfaceName();
        
        out.print(getLowerCase(ruleName));
		out.println(" returns [" + qualifiedClassName + " element = null]");
        out.println("@init{");
		out.println("\telement = " + getCreateObjectCall(genClass) + ";");
        out.println("}");
        out.println(":");
        
        printChoice(rule.getDefinition(),rule,out,0,eClassesReferenced,proxyReferences,"\t");
        
        Collection<GenClass> subClasses = GeneratorUtil.getSubClassesWithCS(genClass, source.getAllRules());
        if(!subClasses.isEmpty()){
        	out.println("\t|//derived choice rules for sub-classes: ");
        	printSubClassChoices(out,subClasses);
        	out.println();
        }
        
        out.println(";");
        out.println();
        
        eClassesWithSyntax.add(genClass);
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
    			count = printCsString((CsString) def, rule, out, count, eClassesReferenced, proxyReferences, indent);
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
    
    private int printCsString(CsString csString,Rule rule,PrintWriter out, int count,Map<GenClass,Collection<Terminal>> eClassesReferenced, Collection<GenFeature> proxyReferences, String indent){
    	final String ident = "a" + count;
    	out.print(indent+ident+" = '" + csString.getValue().replaceAll("'", "\\\\'") + "'");
    	out.print("{copyLocalizationInfos((CommonToken)" + ident + ", element); }"); 
    	return ++count;

    }
    
    private int printTerminal(Terminal terminal,Rule rule,PrintWriter out, int count,Map<GenClass,Collection<Terminal>> eClassesReferenced, Collection<GenFeature> proxyReferences, String indent){
    	final GenFeature genFeature = terminal.getFeature();
		final EStructuralFeature eFeature = genFeature.getEcoreFeature();
		final String ident = "a" + count;
    	final String proxyIdent = "proxy";
    	
		String expressionToBeSet = null;
    	String resolvements = "";
    	
    	out.print(indent);
    	out.print(ident + " = ");
    	
    	if(terminal instanceof Containment){
    		assert ((EReference)eFeature).isContainment(); 
            out.print(getLowerCase(eFeature.getEType().getName())); 
            if(!(genFeature.getEcoreFeature() instanceof EAttribute)){
                //remember which classes are referenced to add choice rules for these classes later
                if (!eClassesReferenced.keySet().contains(genFeature.getTypeGenClass())) {
                  	eClassesReferenced.put(genFeature.getTypeGenClass(), new HashSet<Terminal>());
                }
               
                eClassesReferenced.get(genFeature.getTypeGenClass()).add(terminal);            	
            }
            expressionToBeSet = ident;
    	}
        else {
        	
        	String tokenName = null;
        	if(terminal instanceof DerivedPlaceholder){
        		
        		DerivedPlaceholder placeholder = (DerivedPlaceholder) terminal;
        		String prefix = placeholder.getPrefix();
				String suffix = placeholder.getSuffix();
				boolean prefixIsEmpty = prefix==null || prefix.length()==0;
				boolean suffixIsEmpty = suffix==null || suffix.length()==0;
				
				if(!useDefaultTokens && prefixIsEmpty && suffixIsEmpty) {
        			addProblem(new GenerationProblem("Default tokens switched off. Define prefix/suffix or token reference here.",placeholder));
         		} else {
        			InternalTokenDefinition definition = deriveTokenDefinition(prefix, suffix);
            		tokenName = definition.getName();
                	placeholder2TokenName.put(placeholder,tokenName);
        		}
        	}
        	else{
        		assert terminal instanceof DefinedPlaceholder;
        		DefinedPlaceholder placeholder = (DefinedPlaceholder) terminal;
        		tokenName = placeholder.getToken().getName();
        	}
        	
        	out.print(tokenName);
        	
        	String targetTypeName = null;
        	String resolvedIdent = "resolved";
        	String preResolved = resolvedIdent+"Object";
        	String resolverIdent = resolvedIdent+"Resolver";
           	resolvements += TokenResolver.class.getName() + " " +resolverIdent +" = tokenResolverFactory.createTokenResolver(\"" + tokenName + "\");";
           	resolvements += resolverIdent +".setOptions(getOptions());";
        	resolvements += "Object " + preResolved + " ="+resolverIdent+".resolve(" +ident+ ".getText(),element.eClass().getEStructuralFeature(\"" + eFeature.getName() + "\"),element,getResource());";
        	resolvements += "if(" + preResolved + "==null) throw new " + TokenConversionException.class.getName() + "("+ident+","+resolverIdent+".getErrorMessage());";
        	
        	if(eFeature instanceof EReference){
        		targetTypeName = "String";
        		expressionToBeSet = proxyIdent;
   
        		//a subtype that can be instantiated as a proxy
            	GenClass instanceType = genFeature.getTypeGenClass();
            	GenClass proxyType = null;
            	String genPackagePrefix = null;
            	
            	if(instanceType.isAbstract()||instanceType.isInterface()){
            		for(GenClass instanceCand : allGenClasses){
            			Collection<String> supertypes = genClasses2superNames.get(instanceCand.getEcoreClass().getName());		
            			if (!instanceCand.isAbstract()&&!instanceCand.isInterface()&&supertypes.contains(instanceType.getEcoreClass().getName())) {
        					genPackagePrefix = instanceCand.getGenPackage().getPrefix();
        	            	proxyType = instanceCand;
        	            	break;
        				}            			
            		}
            	}
            	else{
            		proxyType = instanceType;
            		genPackagePrefix = instanceType.getGenPackage().getPrefix();
            	}
            	if (genPackagePrefix == null) {
            		addProblem(new GenerationProblem("The type of non-containment reference '" + eFeature.getName() + "' is abstract and has no concrete sub classes.", eFeature, GenerationProblem.Severity.ERROR));
            	}
            	resolvements += targetTypeName + " " + resolvedIdent + " = (" + targetTypeName + ") "+preResolved+";";
	           	
            	//resolvements += targetTypeName + " " + resolvedIdent + " = (" + targetTypeName + ") tokenResolverFactory.createTokenResolver(\"" + tokenName + "\").resolve(" +ident+ ".getText(),element.eClass().getEStructuralFeature(\"" + sf.getName() + "\"),element,getResource());";
            	// TODO if the code above will be used again 'resolvements += resolverIdent +".setOptions(getOptions()));";' must be added!
	           	resolvements += proxyType.getQualifiedInterfaceName() + " " + expressionToBeSet + " = " + getCreateObjectCall(proxyType) + ";" 
				+ "((InternalEObject)" + expressionToBeSet + ").eSetProxyURI((resource.getURI()==null?URI.createURI(\"dummy\"):resource.getURI()).appendFragment(" + resolvedIdent + ")); ";
	        
	           	//remember where proxies have to be resolved
            	proxyReferences.add(genFeature);

        	}
        	else{
        		EAttribute attr = (EAttribute)eFeature;
        		if(attr.getEType() instanceof EEnum){
        			EEnum enumType = (EEnum)attr.getEType();
        			targetTypeName = enumType.getName();
        		}
        		else{
            		targetTypeName = attr.getEAttributeType().getInstanceClassName();        			
        		}
               	resolvements += targetTypeName + " " + resolvedIdent + " = (" + getObjectTypeName(targetTypeName) + ")" + preResolved + ";";
        		expressionToBeSet = "resolved";
        	}
        }
        	
    	out.print("{");
    	out.print(resolvements);
        if(eFeature.getUpperBound()==1){
           out.print("element.eSet(element.eClass().getEStructuralFeature(\"" + eFeature.getName() + "\"), " + expressionToBeSet +"); ");
        }
        else{
            //TODO Warning, if a value is used twice. 
        	//whatever...
            out.print("((List) element.eGet(element.eClass().getEStructuralFeature(\"" + eFeature.getName() + "\"))).add(" + expressionToBeSet +"); ");
        }
        
        if(terminal instanceof Containment){
            out.print("copyLocalizationInfos(" + ident + ", element); "); 
        }else{
            out.print("copyLocalizationInfos((CommonToken) " + ident + ", element); "); 
            if(eFeature instanceof EReference){
            	//additionally set position information for the proxy instance	
                out.print("copyLocalizationInfos((CommonToken) " + ident + ", " + proxyIdent + "); "); 
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
                   out.println("returns [" + referencedClass.getQualifiedInterfaceName() + " element = null]");
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
     * @param prefix
     * @param suffix
     * @return
     */
    
    private InternalTokenDefinition deriveTokenDefinition(String prefix, String suffix) {
    	String derivedTokenName = null;
    	boolean suffixIsSet = suffix!=null && suffix.length() > 0;
		boolean prefixIsSet = prefix!=null && prefix.length() > 0;
		
		if (suffixIsSet) {
        	String derivedExpression = null;
    		if (prefixIsSet) {
    			derivedTokenName = DERIVED_TOKEN_NAME + "_" + deriveCodeSequence(prefix) + "_" + deriveCodeSequence(suffix);
    			if (!tokenExists(derivedTokenName)) {
    				derivedExpression = "(~('" + escapeLiteralChars(suffix) + "')|('\\\\''" + escapeLiteralChars(suffix) + "'))*";
    				addTokenDefinition(derivedTokenName, derivedExpression, prefix, suffix);
    			}
    		} else {
       			derivedTokenName = DERIVED_TOKEN_NAME + "_" + "_" + deriveCodeSequence(suffix);
    			if (!tokenExists(derivedTokenName)) {
    				derivedExpression =  "(~('" + escapeLiteralChars(suffix) + "')|( '\\\\' '" + escapeLiteralChars(suffix)+"' ))* '";
    				addTokenDefinition(derivedTokenName, derivedExpression, null, suffix);
    			}	
    		}
		}
    	else{
    		if (prefixIsSet) {
				String derivedExpression = null;
    			derivedTokenName = standardTextTokenName + "_" + deriveCodeSequence(prefix) + "_";
				if (!tokenExists(derivedTokenName)) {
					derivedExpression = getStandardTokenExpression();
    				addTokenDefinition(derivedTokenName, derivedExpression, prefix, null);
				}
    		} else {
    			derivedTokenName = standardTextTokenName;
    			if (!tokenExists(derivedTokenName)) {
    				addTokenDefinition(derivedTokenName, getStandardTokenExpression(), null, null);
    			}
    		}
    	}
    	return derivedTokens.get(derivedTokenName);
    }

	private String getStandardTokenExpression() {
		if (!STD_TOKEN_NAME.equals(standardTextTokenName)) {
			Collection<TokenDefinition> tokens = source.getTokens();
			for (TokenDefinition token : tokens) {
				String tokenName = token.getName();
				if (tokenName.equals(standardTextTokenName)) {
					if (token instanceof NewDefinedToken) {
						return new TokenDefinitionAdapter((NewDefinedToken) token).getExpression();
					}
				}
			}
		}
		return STD_TOKEN_DEF;
	}

	private boolean tokenExists(String derivedTokenName) {
		boolean exists = derivedTokens.containsKey(derivedTokenName);
		return exists;
	}

	private void addTokenDefinition(String tokenName, String expression, String prefix, String suffix) {
		//System.out.println("TextParserGenerator.addTokenDefinition(" + tokenName + ", " + expression + ")");
		InternalTokenDefinition newDefintion =  new InternalTokenDefinitionImpl(tokenName,expression,prefix,suffix,null,true);
		derivedTokens.put(tokenName, newDefintion);
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
				addProblem(new GenerationProblem("Token names must start with a capital letter.",def));
				continue;
			}
			if(processedTokenNames.contains(def.getName().toLowerCase())){
				addProblem(new GenerationProblem("Tokenname already in use (ignoring case).",def));
				continue;
			}
			if(def instanceof NewDefinedToken){
				InternalTokenDefinition derivedDef = derivedTokens.remove(def.getName());
				InternalTokenDefinition defAdapter = null;
				if(derivedDef==null){
					defAdapter = new TokenDefinitionAdapter((NewDefinedToken)def);
				}		
				else{
					defAdapter = new TokenDefinitionAdapter((NewDefinedToken)def,derivedDef.isReferenced());
				}
				
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
		
		out.println(def.isReferenced() ? "" : "{ channel=99; }");
		out.println(";");
	}
	
	private void printDefaultImports(PrintWriter out){
        out.println("import org.eclipse.emf.ecore.EObject;");
        out.println("import org.eclipse.emf.ecore.InternalEObject;");
        out.println("import org.eclipse.emf.common.util.URI;");
        out.println("import " + EMFTextParserImpl.class.getName() + ";");
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

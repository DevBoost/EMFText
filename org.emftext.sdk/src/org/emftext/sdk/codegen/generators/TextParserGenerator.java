package org.emftext.sdk.codegen.generators;

import static org.emftext.runtime.IStandardTokenDefinitions.LB_TOKEN_DEF;
import static org.emftext.runtime.IStandardTokenDefinitions.LB_TOKEN_NAME;
import static org.emftext.runtime.IStandardTokenDefinitions.STD_TOKEN_DEF;
import static org.emftext.runtime.IStandardTokenDefinitions.STD_TOKEN_NAME;
import static org.emftext.runtime.IStandardTokenDefinitions.WS_TOKEN_DEF;
import static org.emftext.runtime.IStandardTokenDefinitions.WS_TOKEN_NAME;

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
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.emftext.runtime.resource.ITokenResolveResult;
import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.ITokenResolverFactory;
import org.emftext.runtime.resource.impl.AbstractEMFTextParser;
import org.emftext.runtime.resource.impl.TokenResolveResult;
import org.emftext.sdk.analysis.LeftRecursionDetector;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.ICodeGenOptions;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.GenerationProblem.Severity;
import org.emftext.sdk.codegen.regex.ANTLRexpLexer;
import org.emftext.sdk.codegen.regex.ANTLRexpParser;
import org.emftext.sdk.codegen.util.GeneratorUtil;
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
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.NewDefinedToken;
import org.emftext.sdk.concretesyntax.PLUS;
import org.emftext.sdk.concretesyntax.PreDefinedToken;
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.WhiteSpaces;
import org.emftext.sdk.finders.GenClassFinder;

/**
 * The text parser generator maps from one or more concrete syntaxes (*.cs) and 
 * one or more Ecore generator models to an ANTLR parser specification. 
 * If the derived specification does not contain syntactical conflicts which 
 * could break the ANTLR generation algorithm or the ANTLR parsing algorithm 
 * (e.g. ambiguities in the configuration or in token definitions which are 
 * not checked by this generator) it can be used to generate a text parser 
 * which allows to create metamodel instances from plain text files.
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
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
	 * @author Sven Karol (Sven.Karol@tu-dresden.de)
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
		public boolean isCollect();
	}
	
	/**
	 * TODO skarol: add comment
	 */
	private static class InternalTokenDefinitionImpl implements InternalTokenDefinition{
		private String name;
		private String expression;
		private String prefix;
		private String suffix;
		private PreDefinedToken base;
		private boolean implicitlyReferenced;
		private boolean isCollect;
		
		public InternalTokenDefinitionImpl(String name, String expression, String prefix, String suffix, PreDefinedToken base, boolean implicitlyReferenced, boolean isCollect){
			this.name = name;
			this.expression = expression;
			this.prefix = prefix;
			this.suffix = suffix;
			this.base = base;
			this.implicitlyReferenced = implicitlyReferenced;
			this.isCollect = isCollect;
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

		public boolean isCollect() {
			return isCollect;
		}
	}
	
	/**
	 * TODO skarol: add comment
	 */
	private static class TokenDefinitionAdapter implements InternalTokenDefinition {
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

		public boolean isCollect() {
			return adaptee.getAttributeName() != null;
		}
	}
	
	
	
	private ConcreteSyntax conreteSyntax;
	private String tokenResolverFactoryName;
	
	private Map<String,InternalTokenDefinition> derivedTokens;
	private Collection<InternalTokenDefinition> printedTokens;
	
	/** 
	 * A map to collect all (non-containment) references that will contain proxy 
	 * objects after parsing.
	 */
	private Collection<GenFeature> nonContainmentReferences;
	
	/**
	 * A map that projects the fully qualified name of generator classes to 
	 * the set of fully qualified names of all their super classes. 
	 */
	private Map<String, Collection<String>> genClassNames2superClassNames;
	private Collection<GenClass> allGenClasses;
	private Map<DerivedPlaceholder,String> placeholder2TokenName;
	
	private String standardTextTokenName;
	private boolean forceEOFToken;
	private boolean usePredefinedTokens;
	private GenClassFinder genClassFinder = new GenClassFinder();
	
	public TextParserGenerator(GenerationContext context) {
		super(context.getPackageName(), context.getCapitalizedConcreteSyntaxName());
		conreteSyntax = context.getConcreteSyntax();
		tokenResolverFactoryName = context.getTokenResolverFactoryClassName();
	}
	
	private void initOptions() {
		standardTextTokenName = OptionManager.INSTANCE.getStringOptionValue(conreteSyntax, ICodeGenOptions.CS_OPTION_STD_TOKEN_NAME);
		if (standardTextTokenName == null) {
			standardTextTokenName = STD_TOKEN_NAME;
		}
		char firstLetter = standardTextTokenName.charAt(0);
		//can this check be done by OCL?
		if (!(firstLetter >= 'A' && firstLetter <= 'Z')) {
			addProblem(new GenerationProblem("Token names must start with a capital letter.", conreteSyntax, Severity.ERROR));
		}
		forceEOFToken = OptionManager.INSTANCE.getBooleanOptionValue(conreteSyntax, ICodeGenOptions.CS_OPTION_FORCE_EOF);
		usePredefinedTokens = OptionManager.INSTANCE.getBooleanOptionValue(conreteSyntax, ICodeGenOptions.CS_OPTION_USE_PREDEFINED_TOKENS);
	}
	
	private void initCaches(){
		nonContainmentReferences = new LinkedList<GenFeature>();
		placeholder2TokenName = new HashMap<DerivedPlaceholder,String>();
		
		derivedTokens = new HashMap<String,InternalTokenDefinition>();
		if (usePredefinedTokens) {
			derivedTokens.put(LB_TOKEN_NAME,new InternalTokenDefinitionImpl(LB_TOKEN_NAME,LB_TOKEN_DEF,null,null,null,false,false));
			derivedTokens.put(WS_TOKEN_NAME,new InternalTokenDefinitionImpl(WS_TOKEN_NAME,WS_TOKEN_DEF,null,null,null,false,false));			
		}
		
		printedTokens = new LinkedList<InternalTokenDefinition>();
	    allGenClasses = genClassFinder.findAllGenClasses(conreteSyntax, true, true);
	    genClassNames2superClassNames = genClassFinder.findAllSuperclasses(allGenClasses);
	}
	
	public boolean generate(PrintWriter out){
		initOptions();
		initCaches();
		
        String csName = getResourceClassName();
        String lexerName = getLexerName(csName);

        out.println("grammar " + csName + ";");
        out.println("options {\n" +
        				"\tsuperClass = " + AbstractEMFTextParser.class.getSimpleName() + "; ");
        boolean backtracking = OptionManager.INSTANCE.getBooleanOptionValue(conreteSyntax, ICodeGenOptions.ANTLR_BACKTRACKING);
        boolean memoize = OptionManager.INSTANCE.getBooleanOptionValue(conreteSyntax, ICodeGenOptions.ANTLR_MEMOIZE);
        
        out.println("\tbacktrack = " + backtracking + ";");
        out.println("\tmemoize = " + memoize + ";");
        out.println("}");
        
        //the lexer: package def. and error handling
        out.println("@lexer::header{");
        out.println("package " + super.getResourcePackageName() + ";");
        out.println();
        out.println("}");
        out.println();
        
        out.println("@lexer::members{");
        out.println("\tpublic " + java.util.List.class.getName() + "<" + RecognitionException.class.getName() + "> lexerExceptions  = new " + java.util.ArrayList.class.getName() + "<" + RecognitionException.class.getName() + ">();");
        out.println("\tpublic " + java.util.List.class.getName() + "<" + Integer.class.getName() + "> lexerExceptionsPosition       = new " + java.util.ArrayList.class.getName() + "<" + Integer.class.getName() + ">();");
        out.println();
        out.println("\tpublic void reportError(" + RecognitionException.class.getName() + " e) {"); 
        out.println("\t\tlexerExceptions.add(e);\n"); 
        out.println("\t\tlexerExceptionsPosition.add(((" + ANTLRStringStream.class.getName() + ")input).index());");
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
        out.println("\tprivate " + ITokenResolverFactory.class.getName() + " tokenResolverFactory = new " + tokenResolverFactoryName +"();");
        out.println("\tprivate int lastPosition;");
        out.println("\tprivate " + TokenResolveResult.class.getName() + " tokenResolveResult = new " + TokenResolveResult.class.getName() + "();");

        out.println();
        out.println("\tprotected EObject doParse() throws RecognitionException {");
        out.println("\tlastPosition = 0;");
		out.println("\t\t((" + lexerName + ")getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;"); //required because the lexer class can not be subclassed
        out.println("\t\t((" + lexerName + ")getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;"); //required because the lexer class can not be subclassed
        out.println("\t\treturn start();" );
        out.println("\t}");
        out.println();
        
        out.println("\t@SuppressWarnings(\"unchecked\")");
        out.println("\tprivate boolean addObjectToList(" + EObject.class.getName() + " element, int featureID, " + Object.class.getName() + " proxy) {");
        out.println("\t\treturn ((" + List.class.getName() + "<" + Object.class.getName() + ">) element.eGet(element.eClass().getEStructuralFeature(featureID))).add(proxy);");
        out.println("\t}");
        out.println();

        out.println("\tprivate " + TokenResolveResult.class.getName() + " getFreshTokenResolveResult() {");
        out.println("\t\ttokenResolveResult.clear();");
        out.println("\t\treturn tokenResolveResult;");
        out.println("\t}");
        out.println();
        
        List<TokenDefinition> collectTokenDefinitions = collectCollectTokenDefinitions(conreteSyntax.getTokens());       
        out.println("\tprotected void collectHiddenTokens(" + EObject.class.getName() + " element, Object o) {");
        if (!collectTokenDefinitions.isEmpty()) {          
            //out.println("\t\tSystem.out.println(\"collectHiddenTokens(\" + element.getClass().getSimpleName() + \", \" + o + \") \");");
            out.println("\t\tint currentPos = getTokenStream().index();");
            out.println("\t\tif (currentPos == 0) {");
            out.println("\t\t\treturn;");
            out.println("\t\t}");
            out.println("\t\tint endPos = currentPos - 1;");
            out.println("\t\tfor (; endPos >= lastPosition; endPos--) {");
            out.println("\t\t\t" + org.antlr.runtime.Token.class.getName() + " token = getTokenStream().get(endPos);");
            out.println("\t\t\tint _channel = token.getChannel();");
            out.println("\t\t\tif (_channel != 99) {");
            out.println("\t\t\t\tbreak;");
            out.println("\t\t\t}");
            out.println("\t\t}");
            out.println("\t\tfor (int pos = lastPosition; pos < endPos; pos++) {");
            out.println("\t\t\t" + org.antlr.runtime.Token.class.getName() + " token = getTokenStream().get(pos);");
            out.println("\t\t\tint _channel = token.getChannel();");
            out.println("\t\t\tif (_channel == 99) {");
            //out.println("\t\t\t\tSystem.out.println(\"\t\" + token);");

            for (TokenDefinition tokenDefinition : collectTokenDefinitions) {
        		String attributeName = tokenDefinition.getAttributeName();
    	        // figure out which feature the token belongs to
    			out.println("\t\t\t\tif (token.getType() == " + lexerName + "." + tokenDefinition.getName() + ") {");
    			// Unfortunately, we must use the feature name instead of the constant here,
    			// because collect-in tokens can be stored in arbitrary classes. Therefore, 
    			// we do not know the EClass of the element at generation time.
    	        out.println("\t\t\t\t\t" + EStructuralFeature.class.getName() + " feature = element.eClass().getEStructuralFeature(\"" + attributeName + "\");");
    	        out.println("\t\t\t\t\tif (feature != null) {");
    	        out.println("\t\t\t\t\t\t// call token resolver");
    	        
    			String identifierPrefix = "resolved";
    			String resolverIdentifier = identifierPrefix + "Resolver";
    			String resolvedObjectIdentifier = identifierPrefix + "Object";
    			String resolveResultIdentifier = identifierPrefix + "Result";
    			
    			out.println("\t\t\t\t\t\t" + ITokenResolver.class.getName() + " " + resolverIdentifier +" = tokenResolverFactory.createCollectInTokenResolver(\"" + attributeName + "\");");
    			out.println("\t\t\t\t\t\t" + resolverIdentifier +".setOptions(getOptions());");
    			out.println("\t\t\t\t\t\t" + ITokenResolveResult.class.getName() + " " + resolveResultIdentifier + " = getFreshTokenResolveResult();"); 
    			out.println("\t\t\t\t\t\t" + resolverIdentifier + ".resolve(token.getText(), feature, " + resolveResultIdentifier + ");");
    			out.println("\t\t\t\t\t\tjava.lang.Object " + resolvedObjectIdentifier + " = " + resolveResultIdentifier + ".getResolvedToken();");
    			out.println("\t\t\t\t\t\tif (" + resolvedObjectIdentifier + " == null) {");
    			out.println("\t\t\t\t\t\t\tgetResource().addError(" + resolveResultIdentifier + ".getErrorMessage(), ((CommonToken) token).getLine(), ((CommonToken) token).getCharPositionInLine(), ((CommonToken) token).getStartIndex(), ((CommonToken) token).getStopIndex());\n");
    			out.println("\t\t\t\t\t\t}");
    			out.println("\t\t\t\t\t\tif (java.lang.String.class.isInstance(" + resolvedObjectIdentifier + ")) {");
    	        out.println("\t\t\t\t\t\t\t((java.util.List) element.eGet(feature)).add((String) " + resolvedObjectIdentifier + ");");
    	        out.println("\t\t\t\t\t\t} else {");
    	        out.println("\t\t\t\t\t\t\tSystem.out.println(\"WARNING: Attribute " + attributeName + " for token \" + token + \" has wrong type in element \" + element + \" (expected java.lang.String).\");");
    	        out.println("\t\t\t\t\t\t}");
    	        out.println("\t\t\t\t\t} else {");
    	        out.println("\t\t\t\t\t\tSystem.out.println(\"WARNING: Attribute " + attributeName + " for token \" + token + \" was not found in element \" + element + \".\");");
    	        out.println("\t\t\t\t\t}");
    			out.println("\t\t\t\t}");
            }

            out.println("\t\t\t}");
            out.println("\t\t}");
            out.println("\t\tlastPosition = (endPos<0?0:endPos);");
        }   
        out.println("\t}");
        out.println("}");
        out.println();
        
        printStartRule(out);
        
		EList<GenClass> eClassesWithSyntax = new BasicEList<GenClass>();
	    Map<GenClass, Collection<Terminal>> eClassesReferenced = new LinkedHashMap<GenClass, Collection<Terminal>>();
	    
	    printGrammarRules(out, eClassesWithSyntax, eClassesReferenced);
	    printImplicitChoiceRules(out, eClassesWithSyntax, eClassesReferenced);
	    
	    printTokenDefinitions(out);
	    
	    return getCollectedErrors().size() == 0;
	}
	
	private List<TokenDefinition> collectCollectTokenDefinitions(List<TokenDefinition> tokenDefinitions){
		List<TokenDefinition> collectList = new LinkedList<TokenDefinition>();		
		for(TokenDefinition tokenDefinition:tokenDefinitions){
			String attributeName = tokenDefinition.getAttributeName();
			if (attributeName != null) {
				collectList.add(tokenDefinition);
			}			
		}
		return collectList;
	}
	
	private String getLexerName(String csName) {
		return csName + "Lexer";
	}
	
	private void printStartRule(PrintWriter out){
	       //do the start symbol rule
        out.println("start");
        out.println("returns [ EObject element = null]");
        out.println(":  ");
    	out.println("\t(");
        int count = 0;
        for (Iterator<GenClass> i = conreteSyntax.getActiveStartSymbols().iterator(); i.hasNext(); ) {
            GenClass aStart = i.next();
            out.println("c" + count + " = " + getLowerCase(aStart.getName()) + "{ element = c" + count + "; }"); 
            if (i.hasNext()) { 
            	out.println("\t|  ");
            }
            count++;
        }
    	out.println("\t)");
        if (forceEOFToken) {
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
			// TODO here collectHiddenTokens() should be called
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
	        
	        LeftRecursionDetector lrd = new LeftRecursionDetector(genClassNames2superClassNames, conreteSyntax);
	        
	        for (Sequence sequence : ruleCopy.getDefinition().getOptions()) {
	        	Rule leftProducingRule = lrd.findLeftProducingRule(rule.getMetaclass(), sequence, rule);
	        	if (leftProducingRule == null) {
	        		recursionFreeSequences.add(sequence);
	 			}	
			}
	        reducedChoice.getOptions().addAll(recursionFreeSequences);
	        
	        ruleCopy.setDefinition(choice);
	        
	        printChoice(ruleCopy.getDefinition(),ruleCopy,out,0,classesReferenced,nonContainmentReferences,"\t");
	        
	        
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
								genClassNames2superClassNames.get(featureType.getQualifiedInterfaceName()).contains(recursiveType.getQualifiedInterfaceName()) ||
								genClassNames2superClassNames.get(recursiveType.getQualifiedInterfaceName()).contains(featureType.getQualifiedInterfaceName())) {
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
			// TODO here collectHiddenTokens() should be called
	        out.println("}");
	        out.println(":");
	        
	        printChoice(tailCopy.getDefinition(),tailCopy,out,0,classesReferenced,nonContainmentReferences,"\t");
	        
	        out.println(";");
	        out.println();
		}
	    eClassesWithSyntax.add(rule.getMetaclass());
	        
	}

	private String getCreateObjectCall(GenClass genClass) {
		GenPackage genPackage = genClass.getGenPackage();
		return genPackage.getQualifiedFactoryClassName() + ".eINSTANCE.create" + genClass.getName() + "()";
	}
	
	private void printGrammarRules(PrintWriter out, EList<GenClass> eClassesWithSyntax, Map<GenClass,Collection<Terminal>> eClassesReferenced) {
        
		for(Rule rule : conreteSyntax.getAllRules()) {
			
        	LeftRecursionDetector lrd = new LeftRecursionDetector(genClassNames2superClassNames, conreteSyntax);
        	Rule recursionRule = lrd.findLeftRecursion(rule);
            if (recursionRule != null) {
                boolean autofix = OptionManager.INSTANCE.getBooleanOptionValue(conreteSyntax, ICodeGenOptions.CS_OPTION_AUTOFIX_SIMPLE_LEFTRECURSION);
            	if(lrd.isDirectLeftRecursive(rule)) {// direct left recursion
            		if (autofix) {
            			System.out.println();
                    	printRightRecursion(out, rule, eClassesWithSyntax, eClassesReferenced);	
                    	
    					
    					Collection<GenClass> subClasses = GeneratorUtil.getSubClassesWithCS(rule.getMetaclass(),conreteSyntax.getAllRules());
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
        out.println("}");
        out.println(":");
        
        printChoice(rule.getDefinition(),rule,out,0,eClassesReferenced,nonContainmentReferences,"\t");
        
        Collection<GenClass> subClasses = GeneratorUtil.getSubClassesWithCS(genClass, conreteSyntax.getAllRules());
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
    	out.print("{ ");
    	out.print("if (element == null) {");
    	out.print("element = " + getCreateObjectCall(rule.getMetaclass()) + ";");
    	out.print("} ");
    	out.print("collectHiddenTokens(element, (CommonToken)" + ident + ");");
    	out.print("copyLocalizationInfos((CommonToken)" + ident + ", element); }"); 
    	return ++count;

    }
    
    private int printTerminal(Terminal terminal, Rule rule, PrintWriter out, int count,Map<GenClass,Collection<Terminal>> eClassesReferenced, Collection<GenFeature> proxyReferences, String indent){
    	final GenClass genClass = rule.getMetaclass();
    	final GenFeature genFeature = terminal.getFeature();
		final EStructuralFeature eFeature = genFeature.getEcoreFeature();
		final String ident = "a" + count;
    	final String proxyIdent = "proxy";
    	
    	StringBuffer resolvements = new StringBuffer();
    	
    	out.print(indent);
		out.print("(");
    	
    	if(terminal instanceof Containment){
    		assert ((EReference)eFeature).isContainment(); 
    		Containment containment = (Containment) terminal;
    		
    		EList<GenClass> types; 
    		//is there an explicit type defined?
    		if (!containment.getTypes().isEmpty()) {
    			types = containment.getTypes();
    		}
    		else {
    			types = new BasicEList<GenClass>();
    			types.add(genFeature.getTypeGenClass());
    		}

    		int internalCount = 0;
    		for(GenClass type : types) {
    			if (internalCount != 0) {
    				out.print("|");
    			}
    			
                String internalIdent = ident + "_" + internalCount;
    	    	out.print(internalIdent + " = ");
                out.print(getLowerCase(type.getName())); 
                
                if(!(genFeature.getEcoreFeature() instanceof EAttribute)){
                    //remember which classes are referenced to add choice rules for these classes later
                    if (!eClassesReferenced.keySet().contains(type)) {
                      	eClassesReferenced.put(type, new HashSet<Terminal>());
                    }
                   
                    eClassesReferenced.get(type).add(terminal);            	
                }
                
            	printTerminalAction(terminal, rule, out, genClass, genFeature,
        				eFeature, internalIdent, proxyIdent, internalIdent, resolvements);
            	
            	internalCount++;
    		}
    	}
        else {
        	out.print(ident + " = ");
        	String tokenName = null;
        	if(terminal instanceof DerivedPlaceholder){
        		
        		DerivedPlaceholder placeholder = (DerivedPlaceholder) terminal;
        		String prefix = placeholder.getPrefix();
				String suffix = placeholder.getSuffix();

				InternalTokenDefinition definition = deriveTokenDefinition(prefix, suffix);
            	tokenName = definition.getName();
                placeholder2TokenName.put(placeholder,tokenName);
        	}
        	else{
        		assert terminal instanceof DefinedPlaceholder;
        		DefinedPlaceholder placeholder = (DefinedPlaceholder) terminal;
        		tokenName = placeholder.getToken().getName();
        	}
        	
        	out.print(tokenName);
        	
        	String targetTypeName = null;
        	String resolvedIdent = "resolved";
        	String preResolved = resolvedIdent + "Object";
        	String resolverIdent = "tokenResolver";
           	resolvements.append(ITokenResolver.class.getName() + " " +resolverIdent +" = tokenResolverFactory.createTokenResolver(\"" + tokenName + "\");\n");
           	resolvements.append(resolverIdent +".setOptions(getOptions());\n");
           	resolvements.append(ITokenResolveResult.class.getName() + " result = getFreshTokenResolveResult();\n");
           	resolvements.append(resolverIdent + ".resolve(" +ident+ ".getText(), element.eClass().getEStructuralFeature(" + GeneratorUtil.getFeatureConstant(genClass, genFeature) + "), result);\n");
           	resolvements.append("Object " + preResolved + " = result.getResolvedToken();\n");
           	resolvements.append("if (" + preResolved + " == null) {\n");
           	resolvements.append("\tgetResource().addError(result.getErrorMessage(), ((CommonToken) " + ident + ").getLine(), ((CommonToken) " + ident + ").getCharPositionInLine(), ((CommonToken) " + ident + ").getStartIndex(), ((CommonToken) " + ident + ").getStopIndex());\n");
           	resolvements.append("}\n");
        	
           	String expressionToBeSet = null;
           	
        	if (eFeature instanceof EReference) {
        		targetTypeName = "String";
        		expressionToBeSet = proxyIdent;
   
        		//a subtype that can be instantiated as a proxy
            	GenClass instanceType = genFeature.getTypeGenClass();
            	GenClass proxyType = null;
            	String genPackagePrefix = null;
            	
            	if(instanceType.isAbstract() || instanceType.isInterface()) {
            		for(GenClass instanceCand : allGenClasses) {
            			Collection<String> supertypes = genClassNames2superClassNames.get(instanceCand.getQualifiedInterfaceName());		
            			if (!instanceCand.isAbstract() && 
            				!instanceCand.isInterface() &&
            				supertypes.contains(instanceType.getQualifiedInterfaceName())) {
        					genPackagePrefix = instanceCand.getGenPackage().getPrefix();
        	            	proxyType = instanceCand;
        	            	break;
        				}            			
            		}
            	} else {
            		proxyType = instanceType;
            		genPackagePrefix = instanceType.getGenPackage().getPrefix();
            	}
            	if (genPackagePrefix == null) {
            		addProblem(new GenerationProblem("The type of non-containment reference '" + eFeature.getName() + "' is abstract and has no concrete sub classes.", eFeature, GenerationProblem.Severity.ERROR));
            	}
            	resolvements.append(targetTypeName + " " + resolvedIdent + " = (" + targetTypeName + ") "+preResolved+";\n");
            	resolvements.append(proxyType.getQualifiedInterfaceName() + " " + expressionToBeSet + " = " + getCreateObjectCall(proxyType) + ";\n"); 
            	resolvements.append("collectHiddenTokens(element, " + expressionToBeSet + ");\n");
            	resolvements.append("getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(" + GeneratorUtil.getFeatureConstant(genClass, genFeature) + "), " + resolvedIdent + ", "+ proxyIdent + ");\n");
	           	//remember where proxies have to be resolved
            	proxyReferences.add(genFeature);
        	}
        	else{
        		// the feature is an EAttribute
       			targetTypeName = genFeature.getQualifiedListItemType(null);
               	resolvements.append("\t" + targetTypeName + " " + resolvedIdent + " = (" + getObjectTypeName(targetTypeName) + ")" + preResolved + ";\n");
        		expressionToBeSet = "resolved";
        	}
        	
        	printTerminalAction(terminal, rule, out, genClass, genFeature,
    				eFeature, ident, proxyIdent, expressionToBeSet, resolvements);
        }
    	
		out.print(")");
    	return ++count;	
    }

	private void printTerminalAction(Terminal terminal, Rule rule,
			PrintWriter out, final GenClass genClass,
			final GenFeature genFeature, final EStructuralFeature eFeature,
			final String ident, final String proxyIdent,
			String expressionToBeSet, StringBuffer resolvements) {
		out.print("{");
    	out.println("if (element == null) {");
    	out.println("\telement = " + getCreateObjectCall(rule.getMetaclass()) + "; ");
    	out.println("}");
    	out.println(resolvements);
    	out.println("if (" + expressionToBeSet + " != null) {");
        if (eFeature.getUpperBound() == 1) {
           out.println("element.eSet(element.eClass().getEStructuralFeature(" + GeneratorUtil.getFeatureConstant(genClass, genFeature) + "), " + expressionToBeSet +"); ");
        } else {
            // TODO jjohannes: "Warning, if a value is used twice. whatever..."
            out.println("addObjectToList(element, " + GeneratorUtil.getFeatureConstant(genClass, genFeature) + ", " + expressionToBeSet +"); ");
        }
        out.println("}");
        out.println("collectHiddenTokens(element, " + expressionToBeSet + ");");
        if (terminal instanceof Containment) {
            out.println("copyLocalizationInfos(" + ident + ", element); "); 
        } else {
            out.println("copyLocalizationInfos((CommonToken) " + ident + ", element); "); 
            if (eFeature instanceof EReference) {
            	//additionally set position information for the proxy instance	
                out.println("copyLocalizationInfos((CommonToken) " + ident + ", " + proxyIdent + "); "); 
            }
        }
    	
        out.println("}");
	}
    
    
	private void printImplicitChoiceRules(PrintWriter out, EList<GenClass> eClassesWithSyntax, Map<GenClass,Collection<Terminal>> eClassesReferenced){
        
    	for(GenClass referencedClass : eClassesReferenced.keySet()) {
            if(!cointainsEqualByName(eClassesWithSyntax,referencedClass)) {
            	//rule not explicitly defined in CS: most likely a choice rule in the AS
            	Collection<GenClass> subClasses = GeneratorUtil.getSubClassesWithCS(referencedClass,conreteSyntax.getAllRules());
            	
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
			Collection<TokenDefinition> tokens = conreteSyntax.getTokens();
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
		InternalTokenDefinition newDefintion =  new InternalTokenDefinitionImpl(tokenName, expression, prefix, suffix, null, true, false);
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
		printUserDefinedTokenDefinitions(out, processedTokenNames);
		printDerivedTokenDefinitions(out, processedTokenNames);
	}

	private void printUserDefinedTokenDefinitions(PrintWriter out,
			Set<String> processedTokenNames) {
		Collection<TokenDefinition> userDefinedTokens = getTokens(conreteSyntax);
		for (TokenDefinition tokenDefinition : userDefinedTokens) {
			if (tokenDefinition.getName().charAt(0) < 'A' || tokenDefinition.getName().charAt(0) > 'Z') {
				addProblem(new GenerationProblem("Token names must start with a capital letter.",tokenDefinition));
				continue;
			}
			if (processedTokenNames.contains(tokenDefinition.getName().toLowerCase())) {
				addProblem(new GenerationProblem("Tokenname already in use (ignoring case).",tokenDefinition));
				continue;
			}
			if (tokenDefinition instanceof NewDefinedToken) {
				InternalTokenDefinition derivedDef = derivedTokens.remove(tokenDefinition.getName());
				InternalTokenDefinition defAdapter = null;
				if(derivedDef==null){
					defAdapter = new TokenDefinitionAdapter((NewDefinedToken)tokenDefinition);
				}		
				else{
					defAdapter = new TokenDefinitionAdapter((NewDefinedToken)tokenDefinition,derivedDef.isReferenced());
				}
				
				if(!checkANTLRRegex(defAdapter)){ 
						continue;
				}
				printToken(defAdapter,out);
				processedTokenNames.add(defAdapter.getName().toLowerCase());
				printedTokens.add(defAdapter);
			}
			else if(tokenDefinition instanceof PreDefinedToken){
				if(derivedTokens.get(tokenDefinition.getName())!=null){
					InternalTokenDefinition defAdapter = derivedTokens.remove(tokenDefinition.getName());
					printToken(defAdapter,out);
					processedTokenNames.add(defAdapter.getName().toLowerCase());
					printedTokens.add(defAdapter);
				}
				else{
					addProblem(new GenerationProblem("Token is neither predefined nor derived.",tokenDefinition));
				}
			}
		}
	}
	
	private Collection<TokenDefinition> getTokens(ConcreteSyntax syntax) {
		Collection<TokenDefinition> tokens = new LinkedHashSet<TokenDefinition>();
		tokens.addAll(syntax.getTokens());
		for (Import nextImport : syntax.getImports()) {
			ConcreteSyntax nextSyntax = nextImport.getConcreteSyntax();
			if (nextSyntax != null) {
				tokens.addAll(nextSyntax.getTokens());
			}
		}
		return tokens;
	}

	private void printDerivedTokenDefinitions(PrintWriter out,
			Set<String> processedTokenNames) {
		//finally process untouched derived definitions
		for (String tokenName : derivedTokens.keySet()) {
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
		
		out.println(def.isReferenced() && !def.isCollect() ? "" : "{ _channel = 99; }");
		out.println(";");
	}
	
	private void printDefaultImports(PrintWriter out){
        out.println("import org.eclipse.emf.ecore.EObject;");
        out.println("import org.eclipse.emf.ecore.InternalEObject;");
        out.println("import org.eclipse.emf.common.util.URI;");
        out.println("import " + AbstractEMFTextParser.class.getName() + ";");
	}
	

	/**
	 * @return The token definitions which were printed during last 
	 * execution for printing token resolvers.
	 */
	public Collection<InternalTokenDefinition> getPrintedTokenDefinitions(){
		return printedTokens;
	}
	
	/**
	 * @return All features which will be replaced with a proxy during a parse 
	 * and therefore need reference resolvers.
	 */
	
	public Collection<GenFeature> getProxyReferences(){
		return nonContainmentReferences;
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

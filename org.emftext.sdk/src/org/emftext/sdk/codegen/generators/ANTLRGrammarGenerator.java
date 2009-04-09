/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.ANTLRStringStream;
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
import org.emftext.runtime.IOptions;
import org.emftext.runtime.resource.ITokenResolveResult;
import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.ITokenResolverFactory;
import org.emftext.runtime.resource.impl.AbstractEMFTextParser;
import org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory;
import org.emftext.runtime.resource.impl.TokenResolveResult;
import org.emftext.runtime.resource.impl.UnexpectedContentTypeException;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.GenerationProblem.Severity;
import org.emftext.sdk.codegen.composites.ANTLRGrammarComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.util.GeneratorUtil;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.PLUS;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.WhiteSpaces;
import org.emftext.sdk.finders.GenClassFinder;
import org.emftext.sdk.syntax_analysis.LeftRecursionDetector;

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
public class ANTLRGrammarGenerator extends BaseGenerator {
	
	/**
	 * The name of the EOF token which can be printed to force end of file after a parse from the root. 
	 */
	public static final String EOF_TOKEN_NAME = "EOF";
	
	private ConcreteSyntax conrceteSyntax;
	private String tokenResolverFactoryName;
	private String qualifiedReferenceResolverSwitchName;
	
	/** 
	 * A map to collect all (non-containment) references that will contain proxy 
	 * objects after parsing.
	 */
	//private Collection<GenFeature> nonContainmentReferences;
	
	/**
	 * A map that projects the fully qualified name of generator classes to 
	 * the set of fully qualified names of all their super classes. 
	 */
	private Map<String, Collection<String>> genClassNames2superClassNames;
	private Collection<GenClass> allGenClasses;
	
	private boolean forceEOFToken;
	private GenClassFinder genClassFinder = new GenClassFinder();

	private GenerationContext context;

	public ANTLRGrammarGenerator(GenerationContext context) {
		super(context.getPackageName(), context.getCapitalizedConcreteSyntaxName());
		this.context = context;
		qualifiedReferenceResolverSwitchName = context.getQualifiedReferenceResolverSwitchClassName();
		conrceteSyntax = context.getConcreteSyntax();
		tokenResolverFactoryName = context.getTokenResolverFactoryClassName();
	}
	
	private void initOptions() {
		forceEOFToken = OptionManager.INSTANCE.getBooleanOptionValue(conrceteSyntax, OptionTypes.FORCE_EOF);
	}
	
	private void initCaches(){
	    allGenClasses = genClassFinder.findAllGenClasses(conrceteSyntax, true, true);
	    genClassNames2superClassNames = genClassFinder.findAllSuperclasses(allGenClasses);
	}
	
	public boolean generate(PrintWriter pw){
		initOptions();
		initCaches();
		
        String csName = getResourceClassName();
        String lexerName = getLexerName(csName);
        boolean backtracking = OptionManager.INSTANCE.getBooleanOptionValue(conrceteSyntax, OptionTypes.ANTLR_BACKTRACKING);
        boolean memoize = OptionManager.INSTANCE.getBooleanOptionValue(conrceteSyntax, OptionTypes.ANTLR_MEMOIZE);
                
        StringComposite sc = new ANTLRGrammarComposite();

        sc.add("grammar " + csName + ";");
        sc.addLineBreak();
        
        sc.add("options {");
        sc.add("superClass = " + AbstractEMFTextParser.class.getSimpleName() + ";");
        sc.add("backtrack = " + backtracking + ";");
        sc.add("memoize = " + memoize + ";");
        sc.add("}");
        sc.addLineBreak();
        
        //the lexer: package definition and error handling
        sc.add("@lexer::header {");
        sc.add("package " + super.getResourcePackageName() + ";");
        sc.add("}");
        sc.addLineBreak();
        
        sc.add("@lexer::members {");
        sc.add("public " + java.util.List.class.getName() + "<" + RecognitionException.class.getName() + "> lexerExceptions  = new " + java.util.ArrayList.class.getName() + "<" + RecognitionException.class.getName() + ">();");
        sc.add("public " + java.util.List.class.getName() + "<" + Integer.class.getName() + "> lexerExceptionsPosition       = new " + java.util.ArrayList.class.getName() + "<" + Integer.class.getName() + ">();");
        sc.addLineBreak();
        sc.add("public void reportError(" + RecognitionException.class.getName() + " e) {"); 
        sc.add("lexerExceptions.add(e);"); 
        sc.add("lexerExceptionsPosition.add(((" + ANTLRStringStream.class.getName() + ")input).index());");
        sc.add("}");
        sc.add("}");
        
        //the parser: package definition and entry (doParse) method 
        sc.add("@header{");
        sc.add("package " + super.getResourcePackageName() + ";");
        sc.addLineBreak();
        
        printDefaultImports(sc);
        
        sc.add("}");
        sc.addLineBreak();
        
        sc.add("@members{");  
        sc.add("private " + ITokenResolverFactory.class.getName() + " tokenResolverFactory = new " + tokenResolverFactoryName +"();");
        sc.add("private int lastPosition;");
        sc.add("private " + TokenResolveResult.class.getName() + " tokenResolveResult = new " + TokenResolveResult.class.getName() + "();");
        sc.add("private " + qualifiedReferenceResolverSwitchName + " referenceResolverSwitch;");
        
        sc.addLineBreak();
        sc.add("protected EObject doParse() throws RecognitionException {");
        sc.add("lastPosition = 0;");
		sc.add("((" + lexerName + ")getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;"); //required because the lexer class can not be subclassed
        sc.add("((" + lexerName + ")getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;"); //required because the lexer class can not be subclassed
        sc.add("Object typeObject = null;");
        sc.add("Map<?,?> options = getOptions();");
        sc.add("if (options != null) {");
        	sc.add("typeObject = options.get(IOptions.RESOURCE_CONTENT_TYPE);");
        sc.add("}");
   		sc.add("if (typeObject == null) {");
   			sc.add("return start();");
   		sc.add("} else if (typeObject instanceof EClass) {");
   			sc.add("EClass type = (EClass)typeObject;");
   			for(Rule rule:conrceteSyntax.getAllRules()){
   				String qualifiedClassName = rule.getMetaclass().getQualifiedInterfaceName();
   				String ruleName = getLowerCase(rule.getMetaclass().getName());
   				sc.add("if (type.getInstanceClass() == " + qualifiedClassName +".class) {");
   				sc.add("return " + ruleName + "();");
   				sc.add("}");
   			}
		sc.add("}");
		sc.add("throw new " + UnexpectedContentTypeException.class.getName() + "(typeObject);");
        sc.add("}");
        sc.addLineBreak();
  
        
        sc.add("@SuppressWarnings(\"unchecked\")");
        sc.add("private boolean addObjectToList(" + EObject.class.getName() + " element, int featureID, " + Object.class.getName() + " proxy) {");
        sc.add("return ((" + List.class.getName() + "<" + Object.class.getName() + ">) element.eGet(element.eClass().getEStructuralFeature(featureID))).add(proxy);");
        sc.add("}");
        sc.addLineBreak();

        sc.add("private " + TokenResolveResult.class.getName() + " getFreshTokenResolveResult() {");
        sc.add("tokenResolveResult.clear();");
        sc.add("return tokenResolveResult;");
        sc.add("}");
        sc.addLineBreak();
        

        List<TokenDefinition> collectTokenDefinitions = collectCollectTokenDefinitions(conrceteSyntax.getTokens());       
        sc.add("protected void collectHiddenTokens(" + EObject.class.getName() + " element) {");
        if (!collectTokenDefinitions.isEmpty()) {          
            //sc.add("System.out.println(\"collectHiddenTokens(\" + element.getClass().getSimpleName() + \", \" + o + \") \");");
            sc.add("int currentPos = getTokenStream().index();");
            sc.add("if (currentPos == 0) {");
            sc.add("return;");
            sc.add("}");
            sc.add("int endPos = currentPos - 1;");
            sc.add("for (; endPos >= lastPosition; endPos--) {");
            sc.add(org.antlr.runtime.Token.class.getName() + " token = getTokenStream().get(endPos);");
            sc.add("int _channel = token.getChannel();");
            sc.add("if (_channel != 99) {");
            sc.add("break;");
            sc.add("}");
            sc.add("}");
            sc.add("for (int pos = lastPosition; pos < endPos; pos++) {");
            sc.add(org.antlr.runtime.Token.class.getName() + " token = getTokenStream().get(pos);");
            sc.add("int _channel = token.getChannel();");
            sc.add("if (_channel == 99) {");
            //sc.add("System.out.println(\"\t\" + token);");

            for (TokenDefinition tokenDefinition : collectTokenDefinitions) {
        		String attributeName = tokenDefinition.getAttributeName();
    	        // figure out which feature the token belongs to
    			sc.add("if (token.getType() == " + lexerName + "." + tokenDefinition.getName() + ") {");
    			// Unfortunately, we must use the feature name instead of the constant here,
    			// because collect-in tokens can be stored in arbitrary classes. Therefore, 
    			// we do not know the EClass of the element at generation time.
    	        sc.add(EStructuralFeature.class.getName() + " feature = element.eClass().getEStructuralFeature(\"" + attributeName + "\");");
    	        sc.add("if (feature != null) {");
    	        sc.add("// call token resolver");
    	        
    			String identifierPrefix = "resolved";
    			String resolverIdentifier = identifierPrefix + "Resolver";
    			String resolvedObjectIdentifier = identifierPrefix + "Object";
    			String resolveResultIdentifier = identifierPrefix + "Result";
    			
    			sc.add(ITokenResolver.class.getName() + " " + resolverIdentifier +" = tokenResolverFactory.createCollectInTokenResolver(\"" + attributeName + "\");");
    			sc.add(resolverIdentifier +".setOptions(getOptions());");
    			sc.add(ITokenResolveResult.class.getName() + " " + resolveResultIdentifier + " = getFreshTokenResolveResult();"); 
    			sc.add(resolverIdentifier + ".resolve(token.getText(), feature, " + resolveResultIdentifier + ");");
    			sc.add("java.lang.Object " + resolvedObjectIdentifier + " = " + resolveResultIdentifier + ".getResolvedToken();");
    			sc.add("if (" + resolvedObjectIdentifier + " == null) {");
    			sc.add("getResource().addError(" + resolveResultIdentifier + ".getErrorMessage(), ((CommonToken) token).getLine(), ((CommonToken) token).getCharPositionInLine(), ((CommonToken) token).getStartIndex(), ((CommonToken) token).getStopIndex());\n");
    			sc.add("}");
    			sc.add("if (java.lang.String.class.isInstance(" + resolvedObjectIdentifier + ")) {");
    	        sc.add("((java.util.List) element.eGet(feature)).add((String) " + resolvedObjectIdentifier + ");");
    	        sc.add("} else {");
    	        sc.add("System.out.println(\"WARNING: Attribute " + attributeName + " for token \" + token + \" has wrong type in element \" + element + \" (expected java.lang.String).\");");
    	        sc.add("}");
    	        sc.add("} else {");
    	        sc.add("System.out.println(\"WARNING: Attribute " + attributeName + " for token \" + token + \" was not found in element \" + element + \".\");");
    	        sc.add("}");
    			sc.add("}");
            }

            sc.add("}");
            sc.add("}");
            sc.add("lastPosition = (endPos < 0 ? 0 : endPos);");
        }   
        sc.add("}");
        
        sc.add("public void setReferenceResolverSwitch(" + context.getQualifiedReferenceResolverSwitchClassName() + " referenceResolverSwitch) {");
        sc.add("this.referenceResolverSwitch = referenceResolverSwitch;");
        sc.add("}");

        sc.add("}");
        sc.addLineBreak();
        
        
        printStartRule(sc);
        
		EList<GenClass> eClassesWithSyntax = new BasicEList<GenClass>();
	    Map<GenClass, Collection<Terminal>> eClassesReferenced = new LinkedHashMap<GenClass, Collection<Terminal>>();
	    
	    printGrammarRules(sc, eClassesWithSyntax, eClassesReferenced);
	    printImplicitChoiceRules(sc, eClassesWithSyntax, eClassesReferenced);
	    
	    printTokenDefinitions(sc);
	    
	    pw.print(sc.toString());
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
	
	private void printStartRule(StringComposite sc){
	       //do the start symbol rule
        sc.add("start ");
        sc.add("returns [ EObject element = null]");
        sc.add(":");
    	sc.add("(");
        int count = 0;
        for (Iterator<GenClass> i = conrceteSyntax.getActiveStartSymbols().iterator(); i.hasNext(); ) {
            GenClass aStart = i.next();
            sc.add("c" + count + " = " + getLowerCase(aStart.getName()) + "{ element = c" + count + "; }"); 
            if (i.hasNext()) { 
            	sc.add("|  ");
            }
            count++;
        }
    	sc.add(")");
        if (forceEOFToken) {
        	sc.add(EOF_TOKEN_NAME);
        }
        sc.addLineBreak();
        sc.add(";");
        sc.addLineBreak();
	}
	
	private void printRightRecursion(StringComposite sc, Rule rule, EList<GenClass> eClassesWithSyntax, Map<GenClass, Collection<Terminal>> classesReferenced) {
		
		String ruleName = rule.getMetaclass().getName();
		GenClass recursiveType = rule.getMetaclass();
		
		{	
			Copier copier = new Copier(true, true);
			Rule ruleCopy = (Rule) copier.copy(rule);
			copier.copyReferences();	    
			
	 
	        
	        sc.add(getLowerCase(ruleName));
	        sc.add(" returns [" + ruleName + " element = null]");
	        sc.add("@init{");
			sc.add("element = " + getCreateObjectCall(recursiveType) + ";");
	        sc.add("collectHiddenTokens(element);");
	        sc.add("List<EObject> dummyEObjects  = new ArrayList<EObject>();");
	        sc.add("}");
	        sc.add(":");
	       
	        Choice choice = ConcretesyntaxPackage.eINSTANCE.getConcretesyntaxFactory().createChoice();
	        
	        Sequence newSequence = ConcretesyntaxPackage.eINSTANCE.getConcretesyntaxFactory().createSequence();
	        Choice reducedChoice = ConcretesyntaxPackage.eINSTANCE.getConcretesyntaxFactory().createChoice();
	        
	        CompoundDefinition compound = ConcretesyntaxPackage.eINSTANCE.getConcretesyntaxFactory().createCompoundDefinition();
	        compound.setDefinitions(reducedChoice);
	        newSequence.getParts().add(compound);
	        
	        choice.getOptions().add(newSequence);
	        List<Sequence> recursionFreeSequences = new ArrayList<Sequence>();
	        
	        LeftRecursionDetector lrd = new LeftRecursionDetector(genClassNames2superClassNames, conrceteSyntax);
	        
	        for (Sequence sequence : ruleCopy.getDefinition().getOptions()) {
	        	Rule leftProducingRule = lrd.findLeftProducingRule(rule.getMetaclass(), sequence, rule);
	        	if (leftProducingRule == null) {
	        		recursionFreeSequences.add(sequence);
	 			}	
			}
	        reducedChoice.getOptions().addAll(recursionFreeSequences);
	        
	        ruleCopy.setDefinition(choice);
	        
	        printChoice(ruleCopy.getDefinition(), ruleCopy, sc, 0, classesReferenced);
	        
	        sc.add(" ( dummyEObject = "+ getLowerCase(ruleName) +  "_tail { dummyEObjects.add(dummyEObject);} )*");
	        sc.add("{");
	        sc.add("element = (" + ruleName+ ") apply(element, dummyEObjects);");
	        sc.add("}");
	        sc.add(";");
	        sc.addLineBreak();
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
	        
	    	sc.add(getLowerCase(ruleName) +  "_tail");
	        sc.add(" returns [DummyEObject element = null]");
	        sc.add("@init{");
	        sc.add("element = new DummyEObject(" + getCreateObjectCall(rule.getMetaclass()) + "()" +", \""+recurseName+"\");");
	        sc.add("collectHiddenTokens(element);");
	        sc.add("}");
	        sc.add(":");
	        
	        printChoice(tailCopy.getDefinition(), tailCopy, sc, 0, classesReferenced);
	        
	        sc.add(";");
	        sc.addLineBreak();
		}
	    eClassesWithSyntax.add(rule.getMetaclass());
	        
	}

	private String getCreateObjectCall(GenClass genClass) {
		GenPackage genPackage = genClass.getGenPackage();
		if (Map.Entry.class.getName().equals(genClass.getEcoreClass().getInstanceClassName())) {
			return "new DummyEObject("+ genPackage.getQualifiedPackageClassName() + ".eINSTANCE.get" + genClass.getName() 
					+ "(),\"" + genClass.getName() + "\")";
	    } else {
	    	return genPackage.getQualifiedFactoryInterfaceName() + ".eINSTANCE.create" + genClass.getName() + "()";
	    }
	}
	
	private void printGrammarRules(StringComposite sc, EList<GenClass> eClassesWithSyntax, Map<GenClass,Collection<Terminal>> eClassesReferenced) {
        
		for(Rule rule : conrceteSyntax.getAllRules()) {
			
        	LeftRecursionDetector lrd = new LeftRecursionDetector(genClassNames2superClassNames, conrceteSyntax);
        	Rule recursionRule = lrd.findLeftRecursion(rule);
            if (recursionRule != null) {
                boolean autofix = OptionManager.INSTANCE.getBooleanOptionValue(conrceteSyntax, OptionTypes.AUTOFIX_SIMPLE_LEFTRECURSION);
            	if(lrd.isDirectLeftRecursive(rule)) {// direct left recursion
            		if (autofix) {
                    	printRightRecursion(sc, rule, eClassesWithSyntax, eClassesReferenced);	
    					
    					Collection<GenClass> subClasses = GeneratorUtil.getSubClassesWithSyntax(rule.getMetaclass(), conrceteSyntax);
                        if(!subClasses.isEmpty()){
                        	sc.add("|//derived choice rules for sub-classes: ");
                        	printSubClassChoices(sc,subClasses);
                        	sc.addLineBreak();
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
                		printGrammarRule(rule, sc, eClassesWithSyntax, eClassesReferenced);
            		}
            	}
            	else {
            		String message = "Rule \"" +  rule.getMetaclass().getName() + "\" is mutual left recursive by rule \"" + recursionRule.getMetaclass().getName()+"\"! Please restructure the grammar.";
            		GenerationProblem generationWarning = new GenerationProblem(message, rule, Severity.WARNING);
              		addProblem(generationWarning);
            		printGrammarRule(rule, sc, eClassesWithSyntax, eClassesReferenced);
            	}
            
            }
            else {
            	printGrammarRule(rule, sc, eClassesWithSyntax, eClassesReferenced);
            }
        }
	}
	
   
	private void printGrammarRule(Rule rule, StringComposite sc, EList<GenClass> eClassesWithSyntax, Map<GenClass,Collection<Terminal>> eClassesReferenced) {
		GenClass genClass = rule.getMetaclass();
		
	    String ruleName = genClass.getName();
		String qualifiedClassName = genClass.getQualifiedInterfaceName();
        
        sc.add(getLowerCase(ruleName));
		if (Map.Entry.class.getName().equals(genClass.getEcoreClass().getInstanceClassName())) {
			sc.add(" returns [DummyEObject element = null]");
		} else {
			sc.add(" returns [" + qualifiedClassName + " element = null]");
		}
        
        sc.add("@init{");
        sc.add("}");
        sc.add(":");
        
        printChoice(rule.getDefinition(), rule, sc, 0, eClassesReferenced);
        
        Collection<GenClass> subClasses = GeneratorUtil.getSubClassesWithSyntax(genClass, conrceteSyntax);
        if(!subClasses.isEmpty()){
        	sc.add("|//derived choice rules for sub-classes: ");
        	sc.addLineBreak();
        	printSubClassChoices(sc,subClasses);
        	sc.addLineBreak();
        }
    
        sc.add(";");
    	sc.addLineBreak();
        
        eClassesWithSyntax.add(genClass);
	}

	private int printChoice(Choice choice, Rule rule, StringComposite sc, int count,Map<GenClass,Collection<Terminal>> eClassesReferenced) {
    	Iterator<Sequence> it = choice.getOptions().iterator();
    	while(it.hasNext()){
    		Sequence seq = it.next();
            count = printSequence(seq, rule, sc, count, eClassesReferenced);
            if(it.hasNext()){
            	sc.addLineBreak();
            	sc.add("|");
            }
    	}
        return count;
    }
	
    private int printSequence(Sequence sequence, Rule rule, StringComposite sc, int count,Map<GenClass,Collection<Terminal>> eClassesReferenced) {
    	Iterator<Definition> it = sequence.getParts().iterator();
    	while(it.hasNext()){
    		Definition def = it.next();
    		if(def instanceof LineBreak || def instanceof WhiteSpaces)
    			continue;
    		String cardinality = computeCardinalityString(def);
    		if(cardinality!=null){
    			sc.add("(");
    		}
    		if(def instanceof CompoundDefinition){
            	CompoundDefinition compoundDef = (CompoundDefinition) def;
                sc.add("(");
                count = printChoice(compoundDef.getDefinitions(), rule,sc, count, eClassesReferenced);
                sc.add(")");
    		}
    		else if(def instanceof CsString){
    			count = printCsString((CsString) def, rule, sc, count, eClassesReferenced);
    		}
    		else{
    			assert def instanceof Terminal;
    			count = printTerminal((Terminal) def, rule, sc, count, eClassesReferenced);
    		}
    		if(cardinality!=null){
    			sc.addLineBreak();
    			sc.add(")" + cardinality);
    		}
    		
    		sc.addLineBreak();
    	}
    	return count;
    }
    
    private int printCsString(CsString csString, Rule rule, StringComposite sc, int count, Map<GenClass,Collection<Terminal>> eClassesReferenced){
    	final String identifier = "a" + count;
    	sc.add(identifier + " = '" + csString.getValue().replaceAll("'", "\\\\'") + "' {");
    	sc.add("if (element == null) {");
    	sc.add("element = " + getCreateObjectCall(rule.getMetaclass()) + ";");
    	sc.add("}");
    	sc.add("collectHiddenTokens(element);");
    	sc.add("copyLocalizationInfos((CommonToken)" + identifier + ", element);");
    	sc.add("}"); 
    	return ++count;
    }
    
    private int printTerminal(Terminal terminal, Rule rule, StringComposite sc, int count,Map<GenClass,Collection<Terminal>> eClassesReferenced){
    	final GenClass genClass = rule.getMetaclass();
    	final GenFeature genFeature = terminal.getFeature();
		final EStructuralFeature eFeature = genFeature.getEcoreFeature();
		final String ident = "a" + count;
    	final String proxyIdent = "proxy";
    	
    	StringComposite resolvements = new ANTLRGrammarComposite();
    	
		sc.add("(");
    	
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
    				sc.add("|");
    			}
    			
                String internalIdent = ident + "_" + internalCount;
    	    	sc.add(internalIdent + " = " + getLowerCase(type.getName())); 
                
                if(!(genFeature.getEcoreFeature() instanceof EAttribute)){
                    //remember which classes are referenced to add choice rules for these classes later
                    if (!eClassesReferenced.keySet().contains(type)) {
                      	eClassesReferenced.put(type, new HashSet<Terminal>());
                    }
                   
                    eClassesReferenced.get(type).add(terminal);            	
                }
                
            	printTerminalAction(terminal, rule, sc, genClass, genFeature,
        				eFeature, internalIdent, proxyIdent, internalIdent, resolvements);
            	
            	internalCount++;
    		}
    	} else {
    		assert terminal instanceof Placeholder;
    		Placeholder placeholder = (Placeholder) terminal;
    		TokenDefinition token = placeholder.getToken();
    		String tokenName = token.getName();
        	
        	sc.add(ident + " = " + tokenName);
        	sc.addLineBreak();
        	
        	String targetTypeName = null;
        	String resolvedIdent = "resolved";
        	String preResolved = resolvedIdent + "Object";
        	String resolverIdent = "tokenResolver";
           	resolvements.add(ITokenResolver.class.getName() + " " +resolverIdent +" = tokenResolverFactory.createTokenResolver(\"" + tokenName + "\");");
           	resolvements.add(resolverIdent +".setOptions(getOptions());");
           	resolvements.add(ITokenResolveResult.class.getName() + " result = getFreshTokenResolveResult();");
           	resolvements.add(resolverIdent + ".resolve(" +ident+ ".getText(), element.eClass().getEStructuralFeature(" + GeneratorUtil.getFeatureConstant(genClass, genFeature) + "), result);");
           	resolvements.add("Object " + preResolved + " = result.getResolvedToken();");
           	resolvements.add("if (" + preResolved + " == null) {");
           	resolvements.add("getResource().addError(result.getErrorMessage(), ((CommonToken) " + ident + ").getLine(), ((CommonToken) " + ident + ").getCharPositionInLine(), ((CommonToken) " + ident + ").getStartIndex(), ((CommonToken) " + ident + ").getStopIndex());");
           	resolvements.add("}");
        	
           	String expressionToBeSet = null;
           	
        	if (eFeature instanceof EReference) {
        		targetTypeName = "String";
        		expressionToBeSet = proxyIdent;
   
        		//a sub type that can be instantiated as a proxy
            	GenClass instanceType = genFeature.getTypeGenClass();
            	GenClass proxyType = null;
            	
            	if (instanceType.isAbstract() || instanceType.isInterface()) {
            		for(GenClass instanceCand : allGenClasses) {
            			Collection<String> supertypes = genClassNames2superClassNames.get(instanceCand.getQualifiedInterfaceName());		
            			if (!instanceCand.isAbstract() && 
            				!instanceCand.isInterface() &&
            				supertypes.contains(instanceType.getQualifiedInterfaceName())) {
        	            	proxyType = instanceCand;
        	            	break;
        				}
            		}
            	} else {
            		proxyType = instanceType;
            	}
            	resolvements.add(targetTypeName + " " + resolvedIdent + " = (" + targetTypeName + ") "+preResolved+";");
            	resolvements.add(proxyType.getQualifiedInterfaceName() + " " + expressionToBeSet + " = " + getCreateObjectCall(proxyType) + ";"); 
            	resolvements.add("collectHiddenTokens(element);");
            	resolvements.add("getResource().registerContextDependentProxy(new "+ ContextDependentURIFragmentFactory.class.getName() + "<" + genFeature.getGenClass().getQualifiedInterfaceName() + ", " + genFeature.getTypeGenClass().getQualifiedInterfaceName() + ">(" + context.getReferenceResolverAccessor("referenceResolverSwitch",genFeature) + "), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(" + GeneratorUtil.getFeatureConstant(genClass, genFeature) + "), " + resolvedIdent + ", "+ proxyIdent + ");");
	           	// remember that we must resolve proxy objects for this feature
            	context.addNonContainmentReference(genFeature);
        	}
        	else{
        		// the feature is an EAttribute
       			targetTypeName = genFeature.getQualifiedListItemType(null);
               	resolvements.add(targetTypeName + " " + resolvedIdent + " = (" + getObjectTypeName(targetTypeName) + ")" + preResolved + ";");
        		expressionToBeSet = "resolved";
        	}
        	
        	printTerminalAction(terminal, rule, sc, genClass, genFeature,
    				eFeature, ident, proxyIdent, expressionToBeSet, resolvements);
        }
    	
		sc.add(")");
    	return ++count;	
    }

	private void printTerminalAction(Terminal terminal, Rule rule,
			StringComposite sc, final GenClass genClass,
			final GenFeature genFeature, final EStructuralFeature eFeature,
			final String ident, final String proxyIdent,
			String expressionToBeSet, StringComposite resolvements) {
		sc.add("{");
    	sc.add("if (element == null) {");
    	sc.add("element = " + getCreateObjectCall(rule.getMetaclass()) + ";");
    	sc.add("}");
    	sc.add(resolvements);
		sc.add("if (" + expressionToBeSet + " != null) {");
		if (eFeature.getUpperBound() == 1) {
			if (Map.Entry.class.getName().equals(eFeature.getEType().getInstanceClassName())) {
				sc.add("addMapEntry(element, element.eClass().getEStructuralFeature("
								+ GeneratorUtil.getFeatureConstant(genClass,
										genFeature)
								+ "), "
								+ expressionToBeSet
								+ ");");
			} else {
				sc.add("element.eSet(element.eClass().getEStructuralFeature("
						+ GeneratorUtil.getFeatureConstant(genClass, genFeature)
						+ "), " + expressionToBeSet + ");");
			}
		} else {
			if (Map.Entry.class.getName().equals(eFeature.getEType().getInstanceClassName())) {
				sc.add("addMapEntry(element, element.eClass().getEStructuralFeature("
								+ GeneratorUtil.getFeatureConstant(genClass,
										genFeature)
								+ "), "
								+ expressionToBeSet
								+ ");");
			} else {
				sc.add("addObjectToList(element, "
						+ GeneratorUtil.getFeatureConstant(genClass, genFeature)
						+ ", " + expressionToBeSet + ");");
			}
		}
		sc.add("}");
        sc.add("collectHiddenTokens(element);");
        if (terminal instanceof Containment) {
            sc.add("copyLocalizationInfos(" + ident + ", element); "); 
        } else {
            sc.add("copyLocalizationInfos((CommonToken) " + ident + ", element);"); 
            if (eFeature instanceof EReference) {
            	//additionally set position information for the proxy instance	
                sc.add("copyLocalizationInfos((CommonToken) " + ident + ", " + proxyIdent + ");"); 
            }
        }
    	
        sc.add("}");
	}
    
    
	private void printImplicitChoiceRules(StringComposite sc, EList<GenClass> eClassesWithSyntax, Map<GenClass,Collection<Terminal>> eClassesReferenced){

		for(GenClass referencedClass : eClassesReferenced.keySet()) {
			if(!containsEqualByName(eClassesWithSyntax,referencedClass)) {
				//rule not explicitly defined in CS: most likely a choice rule in the AS
				Collection<GenClass> subClasses = GeneratorUtil.getSubClassesWithSyntax(referencedClass, conrceteSyntax);

				if (!subClasses.isEmpty()) {
					sc.add(getLowerCase(referencedClass.getName()));
					sc.add(" returns [" + referencedClass.getQualifiedInterfaceName() + " element = null]");
					sc.add(":");
					printSubClassChoices(sc, subClasses);
					sc.addLineBreak();
					sc.add(";");
					sc.addLineBreak();

					eClassesWithSyntax.add(referencedClass);
				}
			}
		}	
	}
    
    private void printSubClassChoices(StringComposite sc, Collection<GenClass> subClasses){
        int count = 0;
        for(Iterator<GenClass> i = subClasses.iterator(); i.hasNext(); ) {
            GenClass subRef = i.next();
            sc.add("c" + count + " = " + getLowerCase(subRef.getName()) + "{ element = c" + count + "; }"); 
            if (i.hasNext()) {
         	   sc.add("|");
            }
            count++;
        }
    }
    
 
      
    private boolean containsEqualByName(EList<GenClass> list, GenClass o){
    	for(GenClass entry:list){
     		EClass entryClass = entry.getEcoreClass();
     		EClass oClass = o.getEcoreClass();
     		if(entryClass.getName().equals(oClass.getName())&&entryClass.getEPackage().getNsURI().equals(oClass.getEPackage().getNsURI())){
     			return true;
     		}
    	}
    	return false;
    }
    
	private void printTokenDefinitions(StringComposite sc) {
		for (TokenDefinition tokenDefinition : conrceteSyntax.getAllTokens()) {
			printToken(tokenDefinition, sc);
		}
	}
	
	private void printToken(TokenDefinition definition, StringComposite sc){
		sc.add(definition.getName());
		sc.add(":");
		
		sc.add(definition.getRegex());
		
		if (definition.isHidden()) {
			sc.add("{ _channel = 99; }");
		}
		sc.add(";");
	}
	
	private void printDefaultImports(StringComposite sc){
        sc.add("import " + org.eclipse.emf.ecore.EObject.class.getName() + ";");
        sc.add("import " + org.eclipse.emf.ecore.InternalEObject.class.getName() + ";");
        sc.add("import " + org.eclipse.emf.common.util.URI.class.getName() + ";");
        sc.add("import " + AbstractEMFTextParser.class.getName() + ";");
        sc.add("import " + IOptions.class.getName() + ";");
        sc.add("import " + UnexpectedContentTypeException.class.getName() + ";");
        sc.add("import " + EClass.class.getName() + ";");
	}
	
    private String computeCardinalityString(Definition definition){
    	Cardinality cardinality = null;
    	if (definition instanceof CardinalityDefinition) {
    		cardinality = ((CardinalityDefinition) definition).getCardinality();
    	}
    	if(cardinality==null)
    		return null;
    	else if(cardinality instanceof PLUS)
    		return "+";
    	else if(cardinality instanceof QUESTIONMARK)
    		return "?";
    	else
    		return "*";
    }
}

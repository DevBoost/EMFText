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

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.IntStream;
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
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.resource.ILocationMap;
import org.emftext.runtime.resource.ITextParser;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.ITokenResolveResult;
import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.ITokenResolverFactory;
import org.emftext.runtime.resource.impl.AbstractEMFTextParser;
import org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory;
import org.emftext.runtime.resource.impl.DummyEObject;
import org.emftext.runtime.resource.impl.ExpectedCsString;
import org.emftext.runtime.resource.impl.ExpectedStructuralFeature;
import org.emftext.runtime.resource.impl.IExpectedElement;
import org.emftext.runtime.resource.impl.ReachedCursorIndexException;
import org.emftext.runtime.resource.impl.TokenResolveResult;
import org.emftext.runtime.resource.impl.UnexpectedContentTypeException;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.GenerationProblem.Severity;
import org.emftext.sdk.codegen.composites.ANTLRGrammarComposite;
import org.emftext.sdk.codegen.composites.StringComponent;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.util.GenClassUtil;
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
 * which allows to create model instances from plain text files.
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
public class ANTLRGrammarGenerator extends BaseGenerator {
	
	// constants for class names used in the generated code
	private static final String ARRAY_LIST = ArrayList.class.getName();
	private static final String COMMON_TOKEN = CommonToken.class.getName();
	private static final String DUMMY_E_OBJECT = DummyEObject.class.getName();
	private static final String E_CLASS = EClass.class.getName();
	private static final String E_OBJECT = EObject.class.getName();
	private static final String E_REFERENCE = EReference.class.getName();
	private static final String INTEGER = Integer.class.getName();
	private static final String I_EXPECTED_ELEMENT = IExpectedElement.class.getName();
	private static final String I_LOCATION_MAP = ILocationMap.class.getName();
	private static final String I_OPTIONS = IOptions.class.getName();
	private static final String I_TEXT_RESOURCE = ITextResource.class.getName();
	private static final String LIST = List.class.getName();
	private static final String OBJECT = Object.class.getName();
	private static final String RECOGNITION_EXCEPTION = RecognitionException.class.getName();

	/**
	 * The name of the EOF token which can be printed to force end of file after a parse from the root. 
	 */
	public static final String EOF_TOKEN_NAME = "EOF";
	
	private static final GenClassUtil genClassUtil = new GenClassUtil();

	private ConcreteSyntax concreteSyntax;
	private String tokenResolverFactoryName;
	
	/**
	 * A map that projects the fully qualified name of generator classes to 
	 * the set of fully qualified names of all their super classes. 
	 */
	private Map<String, Collection<String>> genClassNames2superClassNames;
	private Collection<GenClass> allGenClasses;
	
	private boolean forceEOFToken;
	private GenClassFinder genClassFinder = new GenClassFinder();

	private GenerationContext context;

	private GeneratorUtil generatorUtil = new GeneratorUtil();

	public ANTLRGrammarGenerator(GenerationContext context) {
		super(context.getPackageName(), context.getCapitalizedConcreteSyntaxName());
		this.context = context;
		concreteSyntax = context.getConcreteSyntax();
		tokenResolverFactoryName = context.getTokenResolverFactoryClassName();
	}
	
	private void initOptions() {
		forceEOFToken = OptionManager.INSTANCE.getBooleanOptionValue(concreteSyntax, OptionTypes.FORCE_EOF);
	}
	
	private void initCaches(){
	    allGenClasses = genClassFinder.findAllGenClasses(concreteSyntax, true, true);
	    genClassNames2superClassNames = genClassFinder.findAllSuperclasses(allGenClasses);
	}
	
	public boolean generate(PrintWriter writer){
		initOptions();
		initCaches();
		
        String csName = getResourceClassName();
        String lexerName = getLexerName(csName);
        String parserName = getParserName(csName);
        boolean backtracking = OptionManager.INSTANCE.getBooleanOptionValue(concreteSyntax, OptionTypes.ANTLR_BACKTRACKING);
        boolean memoize = OptionManager.INSTANCE.getBooleanOptionValue(concreteSyntax, OptionTypes.ANTLR_MEMOIZE);
                
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
        sc.add("public " + LIST + "<" + RECOGNITION_EXCEPTION + "> lexerExceptions  = new " + ARRAY_LIST + "<" + RECOGNITION_EXCEPTION + ">();");
        sc.add("public " + LIST + "<" + INTEGER + "> lexerExceptionsPosition       = new " + ARRAY_LIST + "<" + INTEGER + ">();");
        sc.addLineBreak();
        sc.add("public void reportError(" + RECOGNITION_EXCEPTION + " e) {"); 
        sc.add("lexerExceptions.add(e);"); 
        sc.add("lexerExceptionsPosition.add(((" + ANTLRStringStream.class.getName() + ") input).index());");
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
        addFields(sc);
        sc.addLineBreak();
        addMethods(lexerName, parserName, sc);
        sc.add("}");
        sc.addLineBreak();
        
        addRules(sc);
	    addTokenDefinitions(sc);
	    
	    writer.print(sc.toString());
	    return getCollectedErrors().size() == 0;
	}

	private void addRules(StringComposite sc) {
		printStartRule(sc);
        
		EList<GenClass> eClassesWithSyntax = new BasicEList<GenClass>();
	    Map<GenClass, Collection<Terminal>> eClassesReferenced = new LinkedHashMap<GenClass, Collection<Terminal>>();
	    
	    printGrammarRules(sc, eClassesWithSyntax, eClassesReferenced);
	    printImplicitChoiceRules(sc, eClassesWithSyntax, eClassesReferenced);
	}

	private void addMethods(String lexerName, String parserName,
			StringComposite sc) {
		addDefaultConstructor(parserName, sc);
        sc.addLineBreak();

        addGetTypeObjectMethod(sc);
        sc.addLineBreak();
        
        addGetReferenceResolverSwitchMethod(sc);
        sc.addLineBreak();
        
        addDoParseMethod(lexerName, sc);
        sc.addLineBreak();
  
        addAddObjectToListMethod(sc);
        sc.addLineBreak();

        addGetFreshTokenResolveResultMethod(sc);
        sc.addLineBreak();
        
        addCollectHiddenTokensMethod(lexerName, sc);
		sc.addLineBreak();
        
        addCreateInstanceMethod(lexerName, parserName, sc);
		sc.addLineBreak();

		addParseToIndexMethod(sc);
		sc.addLineBreak();
		
		addGetParseToIndexTypeObjectMethod(sc);
		sc.addLineBreak();

		addRegisterContextDependentProxyMethod(sc);
		sc.addLineBreak();

		addAddErrorToResourceMethod(sc);
		sc.addLineBreak();

		addCopyLocalizationInfosMethod1(sc);
		sc.addLineBreak();

		addCopyLocalizationInfosMethod2(sc);
		sc.addLineBreak();

		addTerminateParsingIfCursorReachedMethod(sc);
		sc.addLineBreak();

		addRecoverFromMismatchedTokenMethod(sc);
	}

	private void addDefaultConstructor(String parserName, StringComposite sc) {
		sc.add("// This default constructor is only used to call createInstance() on it");
        sc.add("public " + parserName + "() {");
        sc.add("super();");
        sc.add("}");
	}

	private void addGetTypeObjectMethod(StringComposite sc) {
		sc.add("protected java.lang.Object getTypeObject() {");
        sc.add("java.lang.Object typeObject = getParseToIndexTypeObject();");
        sc.add("if (typeObject != null) {");
        	sc.add("return typeObject;");
    	sc.add("}");
        sc.add(Map.class.getName() + "<?,?> options = getOptions();");
        sc.add("if (options != null) {");
        	sc.add("typeObject = options.get(" + I_OPTIONS + ".RESOURCE_CONTENT_TYPE);");
        sc.add("}");
        sc.add("return typeObject;");
        sc.add("}");
	}

	private void addGetReferenceResolverSwitchMethod(StringComposite sc) {
		sc.add("protected " + context.getQualifiedReferenceResolverSwitchClassName() + " getReferenceResolverSwitch() {");
        sc.add(I_TEXT_RESOURCE + " resource = getResource();");
        sc.add("if (resource == null) {");
        sc.add("return null;");
        sc.add("}");
        sc.add("return (" + context.getQualifiedReferenceResolverSwitchClassName() + ") resource.getReferenceResolverSwitch();");
        sc.add("}");
	}

	private void addDoParseMethod(String lexerName, StringComposite sc) {
		sc.add("protected " + E_OBJECT + " doParse() throws " + RECOGNITION_EXCEPTION + " {");
        sc.add(new StringComponent("lastPosition = 0;", "lastPosition"));
		sc.add("((" + lexerName + ") getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;"); //required because the lexer class can not be subclassed
        sc.add("((" + lexerName + ") getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;"); //required because the lexer class can not be subclassed

   		sc.add("java.lang.Object typeObject = getTypeObject();");
   		sc.add("if (typeObject == null) {");
   			sc.add("return start();");
   		sc.add("} else if (typeObject instanceof " + E_CLASS + ") {");
   			sc.add(E_CLASS + " type = (" + E_CLASS + ") typeObject;");
   			for (Rule rule : concreteSyntax.getAllRules()) {
   				String qualifiedClassName = rule.getMetaclass().getQualifiedInterfaceName();
   				String ruleName = getRuleName(rule.getMetaclass());
   				sc.add("if (type.getInstanceClass() == " + qualifiedClassName +".class) {");
   				sc.add("return " + ruleName + "();");
   				sc.add("}");
   			}
		sc.add("}");
		sc.add("throw new " + UnexpectedContentTypeException.class.getName() + "(typeObject);");
        sc.add("}");
	}

	private void addAddObjectToListMethod(StringComposite sc) {
		sc.add("@SuppressWarnings(\"unchecked\")");
        sc.add("private boolean addObjectToList(" + E_OBJECT + " element, int featureID, " + OBJECT + " proxy) {");
        sc.add("return ((" + LIST + "<" + OBJECT + ">) element.eGet(element.eClass().getEStructuralFeature(featureID))).add(proxy);");
        sc.add("}");
	}

	private void addGetFreshTokenResolveResultMethod(StringComposite sc) {
		sc.add("private " + TokenResolveResult.class.getName() + " getFreshTokenResolveResult() {");
        sc.add("tokenResolveResult.clear();");
        sc.add("return tokenResolveResult;");
        sc.add("}");
	}

	private void addCollectHiddenTokensMethod(String lexerName,
			StringComposite sc) {
		List<TokenDefinition> collectTokenDefinitions = collectCollectTokenDefinitions(concreteSyntax.getTokens());       
        sc.add("protected void collectHiddenTokens(" + E_OBJECT + " element) {");
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
    			sc.add(OBJECT + " " + resolvedObjectIdentifier + " = " + resolveResultIdentifier + ".getResolvedToken();");
    			sc.add("if (" + resolvedObjectIdentifier + " == null) {");
    			sc.add("addErrorToResource(" + resolveResultIdentifier + ".getErrorMessage(), ((" + COMMON_TOKEN + ") token).getLine(), ((" + COMMON_TOKEN + ") token).getCharPositionInLine(), ((" + COMMON_TOKEN + ") token).getStartIndex(), ((" + COMMON_TOKEN + ") token).getStopIndex());\n");
    			sc.add("}");
    			sc.add("if (java.lang.String.class.isInstance(" + resolvedObjectIdentifier + ")) {");
    	        sc.add("((" + LIST + ") element.eGet(feature)).add((java.lang.String) " + resolvedObjectIdentifier + ");");
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
	}

	private void addCreateInstanceMethod(String lexerName, String parserName,
			StringComposite sc) {
		sc.add("public " + ITextParser.class.getName() + " createInstance(" + InputStream.class.getName() + " actualInputStream, " + String.class.getName() + " encoding) {");
		sc.add("try {");
		sc.add("if (encoding == null) {");
		sc.add("return new " + parserName + "(new " + CommonTokenStream.class.getName() + "(new " + lexerName + "(new " + ANTLRInputStream.class.getName() + "(actualInputStream))));");
		sc.add("} else {");
		sc.add("return new " + parserName + "(new " + CommonTokenStream.class.getName() + "(new " + lexerName + "(new " + ANTLRInputStream.class.getName() + "(actualInputStream, encoding))));");
		sc.add("}");
		sc.add("} catch (" + IOException.class.getName() + " e) {");
		sc.add(EMFTextRuntimePlugin.class.getName() + ".logError(\"Error while creating parser.\", e);");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
	}

	private void addFields(StringComposite sc) {
        sc.add("private " + ITokenResolverFactory.class.getName() + " tokenResolverFactory = new " + tokenResolverFactoryName +"();");
        sc.add(new StringComponent("private int lastPosition;", "lastPosition"));
        sc.add("private " + TokenResolveResult.class.getName() + " tokenResolveResult = new " + TokenResolveResult.class.getName() + "();");
		sc.add("private int stopIndex = -1;");
		sc.add("private " + OBJECT + " parseToIndexTypeObject;");
		sc.add("private int lastTokenIndex = 0;");
	}

	private void addParseToIndexMethod(StringComposite sc) {
		sc.add("public " + I_EXPECTED_ELEMENT + " parseToIndex(int index, " + E_CLASS +  " type) {");
		sc.add("stopIndex = index;");
		sc.add("parseToIndexTypeObject = type;");
		sc.add("try {");
		sc.add("parse();");
		sc.add("} catch (" + ReachedCursorIndexException.class.getName() + " pcie) {");
		sc.add("final " + I_EXPECTED_ELEMENT + " expectedElement = pcie.getExpectedElement();");
		sc.add("return expectedElement;");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
	}

	private void addGetParseToIndexTypeObjectMethod(StringComposite sc) {
		sc.add("public " + OBJECT + " getParseToIndexTypeObject() {");
		sc.add("return parseToIndexTypeObject;");
		sc.add("}");
	}

	private void addRegisterContextDependentProxyMethod(StringComposite sc) {
		sc.add("protected <ContainerType extends " + E_OBJECT + ", ReferenceType extends " + E_OBJECT + "> void registerContextDependentProxy(" +
				ContextDependentURIFragmentFactory.class.getName() + "<ContainerType, ReferenceType> factory," +
				"ContainerType element, " + E_REFERENCE + " reference, String id," +
				E_OBJECT + " proxy) {");
		sc.add("");
		sc.add(I_TEXT_RESOURCE + " resource = getResource();");
		sc.add("if (resource == null) {");
		sc.add("// the resource can be null if the parser is used for");
		sc.add("// code completion");
		sc.add("return;");
		sc.add("}");
		sc.add("resource.registerContextDependentProxy(factory, element, reference, id, proxy);");
		sc.add("}");
	}

	private void addAddErrorToResourceMethod(StringComposite sc) {
		sc.add("protected void addErrorToResource(java.lang.String errorMessage, int line,");
		sc.add("int charPositionInLine, int startIndex, int stopIndex) {");
		sc.add(I_TEXT_RESOURCE + " resource = getResource();");
		sc.add("if (resource == null) {");
		sc.add("// the resource can be null if the parser is used for");
		sc.add("// code completion");
		sc.add("return;");
		sc.add("}");
		sc.add("resource.addError(errorMessage, line, charPositionInLine, startIndex, stopIndex);");
		sc.add("}");
	}

	private void addCopyLocalizationInfosMethod1(StringComposite sc) {
		sc.add("protected void copyLocalizationInfos(" + E_OBJECT + " source, " + E_OBJECT + " target) {");
		sc.add(I_TEXT_RESOURCE + " resource = getResource();");
		sc.add("if (resource == null) {");
		sc.add("// the resource can be null if the parser is used for");
		sc.add("// code completion");
		sc.add("return;");
		sc.add("}");
		sc.add("final " + I_LOCATION_MAP + " locationsMap = resource.getLocationMap();");
		sc.add("locationsMap.setCharStart(target, locationsMap.getCharStart(source)); ");
		sc.add("locationsMap.setCharEnd(target, locationsMap.getCharEnd(source)); ");
		sc.add("locationsMap.setColumn(target, locationsMap.getColumn(source)); ");
		sc.add("locationsMap.setLine(target, locationsMap.getLine(source));");
		sc.add("}");
	}

	private void addCopyLocalizationInfosMethod2(StringComposite sc) {
		sc.add("protected void copyLocalizationInfos(" + COMMON_TOKEN + " source, " + E_OBJECT + " target) {");
		sc.add(I_TEXT_RESOURCE + " resource = getResource();");
		sc.add("if (resource == null) {");
		sc.add("// the resource can be null if the parser is used for");
		sc.add("// code completion");
		sc.add("return;");
		sc.add("}");
		sc.add("final " + I_LOCATION_MAP + " locationsMap = resource.getLocationMap();");
		sc.add("locationsMap.setCharStart(target, source.getStartIndex()); ");
		sc.add("locationsMap.setCharEnd(target, source.getStopIndex());	");
		sc.add("locationsMap.setColumn(target, source.getCharPositionInLine());	");
		sc.add("locationsMap.setLine(target, source.getLine());");
		sc.add("}");
	}

	private void addTerminateParsingIfCursorReachedMethod(StringComposite sc) {
		sc.add("public void terminateParsingIfCursorIndexReached(" + I_EXPECTED_ELEMENT + " expectedElement) {");
		sc.add("if (this.stopIndex < 0) {");
		sc.add("return;");
		sc.add("}");
		sc.add("if (lastTokenIndex >= input.size()) {");
		sc.add("throw new " + ReachedCursorIndexException.class.getName() + "(expectedElement);");
		sc.add("}");
		sc.add("final " + COMMON_TOKEN + " lastToken = (" + COMMON_TOKEN + ") input.get(lastTokenIndex);");
		sc.add(COMMON_TOKEN + " currentToken = null;");
		sc.add("");
		sc.add("final int currentTokenIndex = java.lang.Math.max(0, Math.min(input.size() - 1, input.index()));");
		sc.add("for (int index = lastTokenIndex; index < currentTokenIndex; index++) {");
		sc.add("final " + COMMON_TOKEN + " tokenAtIndex = (" + COMMON_TOKEN + ") input.get(index);");
		sc.add("currentToken = tokenAtIndex;");
		sc.add("java.lang.System.out.println(\"TOKEN: \" + tokenAtIndex);");
		sc.add("}");
		sc.add("lastTokenIndex = java.lang.Math.max(0, currentTokenIndex);");
		sc.add("if (currentToken != null) {");
		sc.add("final int start = lastToken.getStartIndex();");
		sc.add("final int end = currentToken.getStopIndex();");
		sc.add("java.lang.System.out.println(\"At \" + start + \"-\" + end + \": \" + expectedElement);");
		sc.add("boolean reachedStopIndex = end >= this.stopIndex - 1;");
		sc.add("if (reachedStopIndex) {");
		sc.add("throw new " + ReachedCursorIndexException.class.getName() + "(expectedElement);");
		sc.add("}");
		sc.add("} else {");
		sc.add("java.lang.System.out.println(\"At ?-?: \" + expectedElement);");
		sc.add("throw new " + ReachedCursorIndexException.class.getName() + "(expectedElement);");
		sc.add("}");
		sc.add("}");
	}

	private void addRecoverFromMismatchedTokenMethod(StringComposite sc) {
		sc.add("public " + OBJECT + " recoverFromMismatchedToken(" + IntStream.class.getName() + " input, int ttype, " + BitSet.class.getName() + " follow) throws " + RECOGNITION_EXCEPTION + " {");
		sc.add("if (stopIndex < 0) {");
		sc.add("return super.recoverFromMismatchedToken(input, ttype, follow);");
		sc.add("} else {");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
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
	
	private String getParserName(String csName) {
		return csName + "Parser";
	}
	
	private void printStartRule(StringComposite sc){
	       //do the start symbol rule
        sc.add("start ");
        sc.add("returns [ " + E_OBJECT + " element = null]");
        sc.add(":");
    	sc.add("(");
        int count = 0;
        for (Iterator<GenClass> i = concreteSyntax.getActiveStartSymbols().iterator(); i.hasNext(); ) {
            GenClass aStart = i.next();
            sc.add("c" + count + " = " + getRuleName(aStart) + "{ element = c" + count + "; }"); 
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
		
		String ruleName = getRuleName(rule.getMetaclass());
		GenClass recursiveType = rule.getMetaclass();
		
		{	
			Copier copier = new Copier(true, true);
			Rule ruleCopy = (Rule) copier.copy(rule);
			copier.copyReferences();	    
			
	 
	        
	        sc.add(ruleName);
	        sc.add(" returns [" + recursiveType.getQualifiedInterfaceName() + " element = null]");
	        sc.add("@init{");
			sc.add("element = " + getCreateObjectCall(recursiveType) + ";");
	        sc.add("collectHiddenTokens(element);");
	        sc.add(LIST + "<" + E_OBJECT + "> dummyEObjects  = new " + ARRAY_LIST + "<" + E_OBJECT + ">();");
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
	        
	        LeftRecursionDetector lrd = new LeftRecursionDetector(genClassNames2superClassNames, concreteSyntax);
	        
	        for (Sequence sequence : ruleCopy.getDefinition().getOptions()) {
	        	Rule leftProducingRule = lrd.findLeftProducingRule(rule.getMetaclass(), sequence, rule);
	        	if (leftProducingRule == null) {
	        		recursionFreeSequences.add(sequence);
	 			}	
			}
	        reducedChoice.getOptions().addAll(recursionFreeSequences);
	        
	        ruleCopy.setDefinition(choice);
	        
	        printChoice(ruleCopy.getDefinition(), ruleCopy, sc, 0, classesReferenced);
	        
	        sc.add(" ( dummyEObject = "+ ruleName +  "_tail { dummyEObjects.add(dummyEObject);} )*");
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
	        
	    	sc.add(ruleName +  "_tail");
	        sc.add(" returns [" + DUMMY_E_OBJECT + " element = null]");
	        sc.add("@init{");
	        sc.add("element = new " + DUMMY_E_OBJECT + "(" + getCreateObjectCall(rule.getMetaclass()) + "()" +", \""+recurseName+"\");");
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
			return "new " + DUMMY_E_OBJECT + "("+ genPackage.getQualifiedPackageClassName() + ".eINSTANCE.get" + genClass.getName() 
					+ "(),\"" + genClass.getName() + "\")";
	    } else {
	    	return genPackage.getQualifiedFactoryInterfaceName() + ".eINSTANCE.create" + genClass.getName() + "()";
	    }
	}
	
	private void printGrammarRules(StringComposite sc, EList<GenClass> eClassesWithSyntax, Map<GenClass,Collection<Terminal>> eClassesReferenced) {
        
		for (Rule rule : concreteSyntax.getAllRules()) {
			
        	LeftRecursionDetector lrd = new LeftRecursionDetector(genClassNames2superClassNames, concreteSyntax);
        	Rule recursionRule = lrd.findLeftRecursion(rule);
            if (recursionRule != null) {
                boolean autofix = OptionManager.INSTANCE.getBooleanOptionValue(concreteSyntax, OptionTypes.AUTOFIX_SIMPLE_LEFTRECURSION);
            	if(lrd.isDirectLeftRecursive(rule)) {// direct left recursion
            		if (autofix) {
                    	printRightRecursion(sc, rule, eClassesWithSyntax, eClassesReferenced);	
    					
    					Collection<GenClass> subClasses = generatorUtil.getSubClassesWithSyntax(rule.getMetaclass(), concreteSyntax);
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
		
	    String ruleName = getRuleName(genClass);
		String qualifiedClassName = genClass.getQualifiedInterfaceName();
        
        sc.add(ruleName);
		if (Map.Entry.class.getName().equals(genClass.getEcoreClass().getInstanceClassName())) {
			sc.add(" returns [" + DUMMY_E_OBJECT + " element = null]");
		} else {
			sc.add(" returns [" + qualifiedClassName + " element = null]");
		}
        
        sc.add("@init{");
        sc.add("}");
        sc.add(":");
        
        printChoice(rule.getDefinition(), rule, sc, 0, eClassesReferenced);
        
        Collection<GenClass> subClasses = generatorUtil.getSubClassesWithSyntax(genClass, concreteSyntax);
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

	private String getRuleName(GenClass genClass) {
		String interfaceName = genClass.getQualifiedInterfaceName();
		String ruleName = interfaceName.replace("_", "_005F");
		ruleName = ruleName.replace(".", "_");
		return "rule_" + ruleName;
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
    	final String escapedCsString = csString.getValue().replaceAll("'", "\\\\'");
		sc.add(identifier + " = '" + escapedCsString + "' {");
		// we must use the unicode representation for the % character, because
		// StringTemplate does treat % special
    	sc.add("terminateParsingIfCursorIndexReached(new " + ExpectedCsString.class.getName() + "(\"" + escapedCsString.replace("%", "\\u0025") + "\"));");
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
    	    	sc.add(internalIdent + " = " + getRuleName(type)); 
                
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
           	resolvements.add(resolverIdent + ".resolve(" +ident+ ".getText(), element.eClass().getEStructuralFeature(" + generatorUtil.getFeatureConstant(genClass, genFeature) + "), result);");
           	resolvements.add(OBJECT + " " + preResolved + " = result.getResolvedToken();");
           	resolvements.add("if (" + preResolved + " == null) {");
           	resolvements.add("addErrorToResource(result.getErrorMessage(), ((" + COMMON_TOKEN + ") " + ident + ").getLine(), ((" + COMMON_TOKEN + ") " + ident + ").getCharPositionInLine(), ((" + COMMON_TOKEN + ") " + ident + ").getStartIndex(), ((" + COMMON_TOKEN + ") " + ident + ").getStopIndex());");
           	resolvements.add("}");
        	
           	String expressionToBeSet = null;
           	
        	if (eFeature instanceof EReference) {
        		targetTypeName = "String";
        		expressionToBeSet = proxyIdent;
   
        		//a sub type that can be instantiated as a proxy
            	GenClass instanceType = genFeature.getTypeGenClass();
            	GenClass proxyType = null;
            	
            	if (genClassUtil.isNotConcrete(instanceType)) {
            		// TODO mseifert: replace this code with a call to class GenClassFinder
            		for(GenClass instanceCand : allGenClasses) {
            			Collection<String> supertypes = genClassNames2superClassNames.get(instanceCand.getQualifiedInterfaceName());		
            			if (genClassUtil.isConcrete(instanceCand) &&
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
            	resolvements.add("registerContextDependentProxy(new "+ ContextDependentURIFragmentFactory.class.getName() + "<" + genFeature.getGenClass().getQualifiedInterfaceName() + ", " + genFeature.getTypeGenClass().getQualifiedInterfaceName() + ">(" + context.getReferenceResolverAccessor(genFeature) + "), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(" + generatorUtil.getFeatureConstant(genClass, genFeature) + "), " + resolvedIdent + ", "+ proxyIdent + ");");
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
    	sc.add("terminateParsingIfCursorIndexReached(new " + ExpectedStructuralFeature.class.getName() + "(" + 
    			genClass.getGenPackage().getReflectionPackageName() + "." +
    			genClass.getGenPackage().getPackageInterfaceName() +
    			".eINSTANCE.get" + genClass.getClassifierAccessorName() + "()" + 
    			".getEStructuralFeature(" +
					generatorUtil.getFeatureConstant(genClass, genFeature) +
				")"+
    			"));");
    	sc.add("if (element == null) {");
    	sc.add("element = " + getCreateObjectCall(rule.getMetaclass()) + ";");
    	sc.add("}");
    	sc.add(resolvements);
		sc.add("if (" + expressionToBeSet + " != null) {");
		if (eFeature.getUpperBound() == 1) {
			if (Map.Entry.class.getName().equals(eFeature.getEType().getInstanceClassName())) {
				sc.add("addMapEntry(element, element.eClass().getEStructuralFeature("
								+ generatorUtil.getFeatureConstant(genClass, genFeature)
								+ "), "
								+ expressionToBeSet
								+ ");");
			} else {
				sc.add("element.eSet(element.eClass().getEStructuralFeature("
						+ generatorUtil.getFeatureConstant(genClass, genFeature)
						+ "), " + expressionToBeSet + ");");
			}
		} else {
			if (Map.Entry.class.getName().equals(eFeature.getEType().getInstanceClassName())) {
				sc.add("addMapEntry(element, element.eClass().getEStructuralFeature("
								+ generatorUtil.getFeatureConstant(genClass,
										genFeature)
								+ "), "
								+ expressionToBeSet
								+ ");");
			} else {
				sc.add("addObjectToList(element, "
						+ generatorUtil.getFeatureConstant(genClass, genFeature)
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
				Collection<GenClass> subClasses = generatorUtil.getSubClassesWithSyntax(referencedClass, concreteSyntax);

				if (!subClasses.isEmpty()) {
					sc.add(getRuleName(referencedClass));
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
            sc.add("c" + count + " = " + getRuleName(subRef) + "{ element = c" + count + "; }"); 
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
    
	private void addTokenDefinitions(StringComposite sc) {
		for (TokenDefinition tokenDefinition : concreteSyntax.getAllTokens()) {
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
	
	private void printDefaultImports(StringComposite sc) {
		// do not add imports here
		// all classes used by the generated parser must be
		// fully qualified
        sc.add("import " + AbstractEMFTextParser.class.getName() + ";");
	}
	
    private String computeCardinalityString(Definition definition) {
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

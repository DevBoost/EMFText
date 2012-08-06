package org.emftext.sdk.codegen.sdf.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;
import org.emftext.sdk.codegen.sdf.ESDFArtifact;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.finders.GenClassFinder;
import org.emftext.sdk.util.StringUtil;

public class SGLRParserGenerator extends JavaBaseGenerator {

	private final GenClassFinder genClassFinder = new GenClassFinder();
	
	public SGLRParserGenerator() {
		super();
	}

	public SGLRParserGenerator(GenerationContext context){
		super(context, ESDFArtifact.SGLR_PARSER);
	}
	
	@Override
	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		
		sc.add("import java.io.FileNotFoundException;");
		sc.add("import java.io.IOException;");
		sc.add("import java.io.InputStream;");
		sc.add("import java.util.Map;");
		sc.addLineBreak();

		sc.add("import org.spoofax.jsglr.InvalidParseTableException;");
		sc.add("import org.spoofax.jsglr.SGLRException;");
		sc.add("import org.emftext.commons.jsglr.AbstractSyntaxTreeVisitor;");
		sc.add("import org.strategoxt.imp.runtime.parser.JSGLRI;");
		sc.add("import org.strategoxt.imp.runtime.parser.ast.RootAstNode;");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " implements " + iTextParserClassName + " {");
		sc.addLineBreak();

		sc.add("private static java.util.Map<String,String> mappings;");
		sc.addLineBreak();
		
		sc.add("static {");
		sc.add("mappings = new java.util.HashMap<String,String>();");
		
		for (CompleteTokenDefinition definition : super.getContext().getConcreteSyntax().getActiveTokens( ) ) {				
			sc.add( "mappings.put(\"" + generateID(definition.getName( )) + "\",\"" + definition.getName( ) +"\");" );
		}
		
		for( Rule rule : super.getContext().getConcreteSyntax().getRules() ){
			String className = rule.getMetaclass( ).getName( );
			List<GenClass> superClasses = rule.getMetaclass( ).getExtendedGenClasses( );
									
			for ( GenClass extendedClass : superClasses ) {
				sc.add( "mappings.put(\"" + generateID(extendedClass.getName()) + "\",\"" + extendedClass.getName() +"\");" );
			}
						
			for ( Entry<String, String> entry : rewriteDefinitions( rule.getDefinition( ), className ).entrySet( ) ){
				sc.add( "mappings.put(\"" + entry.getKey() + "\",\"" + entry.getValue() +"\");" );
			}
		}

		sc.add("};");
		sc.addLineBreak();
		
		sc.add("private InputStream source;");
		sc.add("private String encoding = \"UTF-8\";");
		sc.addLineBreak();
		
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super();");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public " + getResourceClassName() + "(InputStream in) {");
		sc.add("source = in;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public " + getResourceClassName() + "(InputStream in, String encoding) {");
		sc.add("source = in;");
		sc.add("this.encoding = encoding;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public void terminate() {");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public void setOptions(Map<?, ?> options) {");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public "+ iTextParserClassName +" createInstance(java.io.InputStream actualInputStream, java.lang.String encoding) {");
		sc.add("if (encoding == null) {");
		sc.add("return new "+ getResourceClassName() +"(actualInputStream);");
		sc.add("} else {");
		sc.add("return new "+ getResourceClassName() +"(actualInputStream, encoding);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		
		String path = getContext().getANTLRGrammarFile().getAbsolutePath();
		path = path.substring(0, path.length() - 2) + ".sdf";
		
		sc.add("public String getGrammarFileName() {");
		sc.add("return \"" + StringUtil.escapeToJavaString(path) + "\";");
		sc.add("}");
		sc.addLineBreak();
		
		String startSymbol = super.getContext().getConcreteSyntax().getActiveStartSymbols( ).get(0).getName();
		Set<GenClass> allGenClasses = genClassFinder.findAllGenClasses(super.getContext().getConcreteSyntax(), true, true);
		GenClass genClass = allGenClasses.toArray(new GenClass[0])[0];
		
		String factoryClass = genClass.getGenPackage().getQualifiedFactoryClassName();
		String factoryInterface = genClass.getGenPackage().getQualifiedFactoryInterfaceName();
		String packageName = genClass.getGenPackage().getQualifiedPackageName();

		sc.add("public " + iParseResultClassName + " parse() {");
		//sc.add("ParseTableManager ptm = new ParseTableManager();");
		sc.add("try {");
		sc.add("JSGLRI sglr = new JSGLRI(getGrammarFileName(), \"" + generateID(startSymbol) + "\");");
		sc.add("RootAstNode t = sglr.parse(source, \"" + generateID(startSymbol) + "\");");
		sc.add(factoryInterface + " factory = new " + factoryClass + "();");
		sc.add("AbstractSyntaxTreeVisitor visitor = new AbstractSyntaxTreeVisitor(factory , null, \"" + packageName + "\", null, null);");
		sc.add("t.accept(visitor);");
		sc.add(parseResultClassName + " result = new " + parseResultClassName + "();");
		sc.add("result.setRoot(visitor.getNode());");
		sc.add("return result;");
		sc.add("} catch (FileNotFoundException e) {");
		sc.add("e.printStackTrace();");
		sc.add("} catch (IOException e) {");
		sc.add("e.printStackTrace();");
		sc.add("} catch (InvalidParseTableException e) {");
		sc.add("e.printStackTrace();");
		sc.add("} catch (SGLRException e) {");
		sc.add("e.printStackTrace();");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();

		sc.add("public " + LIST + "<" + expectedTerminalClassName + "> parseToExpectedElements(" + E_CLASS + " type, " + iTextResourceClassName + " resource) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();

		sc.add("}");
		
		return true;
	}
	
	private Map<String,String> rewriteDefinitions( Choice choice, String className ){
		
		Map<String, String> rules = new HashMap<String, String>( );
		
	//	StringBuffer sb = new StringBuffer( );
		
		try {
			for ( Sequence option : choice.getOptions( ) ){		
				for ( Definition def : option.getParts( ) ) {
					if ( def instanceof Containment ) {
						
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

						rules.put(generateID(metaClass), metaClass);
						
						String name = className + "." + genFeature.getName();	
						rules.put( generateID(name), name );
					} else if (def instanceof CompoundDefinition ){
						final CompoundDefinition compound = ( CompoundDefinition ) def;
						rewriteDefinitions( compound.getDefinition( ), className);
					}
				}
			}
			
			rules.put( generateID(className), className );
			
		} catch (Exception e){
			
		}
		
		return rules;
	}

	private String generateID(String name){
		int id = name.hashCode();
		return id > 0 ? "P" + id : "N"+(-1)*id;
	}
	
	public IGenerator newInstance(GenerationContext context) {
		return new SGLRParserGenerator(context);
	}
}

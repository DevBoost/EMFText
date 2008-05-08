package org.reuseware.emftextedit.codegen;

import java.io.PrintWriter;
import java.util.Iterator;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.reuseware.emftextedit.concretesyntax.Choice;
import org.reuseware.emftextedit.concretesyntax.ConcreteSyntax;
import org.reuseware.emftextedit.concretesyntax.CompoundDefinition;
import org.reuseware.emftextedit.concretesyntax.CsString;
import org.reuseware.emftextedit.concretesyntax.Definition;
import org.reuseware.emftextedit.concretesyntax.LineBreak;
import org.reuseware.emftextedit.concretesyntax.PLUS;
import org.reuseware.emftextedit.concretesyntax.Rule;
import org.reuseware.emftextedit.concretesyntax.STAR;
import org.reuseware.emftextedit.concretesyntax.Sequence;
import org.reuseware.emftextedit.concretesyntax.Terminal;
import org.reuseware.emftextedit.concretesyntax.WhiteSpaces;

/**
 *Untested 
 *
 */
public class TextPrinterGenerator extends BaseGenerator{

	private ConcreteSyntax source;
	
	
	public TextPrinterGenerator(ConcreteSyntax cs, String csPrinterClassName, String csPackageName){
		super(csPrinterClassName, csPackageName);
		source = cs;
	}
	
	@Override
	public boolean generate(PrintWriter out) {
		out.print(generatePrinter());
		return true;
	}
	
	//TODO just copied .... does not work recently 
	
    protected String generatePrinter()  {
        StringBuffer s = new StringBuffer();
        String csName = source.getName();
        
        s.append("package " + super.getResourcePackageName() + "; \n\n");
        
        s.append("import org.eclipse.emf.ecore.EObject;\n");
        //import all the packages ecore model packages required
        for(Rule rule : source.getAllRules()) {
        	GenPackage p = rule.getMetaclass().getGenPackage();
        	String classImport = (p.getBasePackage()==null?"":p.getBasePackage() + ".") + p.getEcorePackage().getName() + "." + rule.getMetaclass().getName();
            s.append("import "+ classImport + ";\n");
        }
        s.append("import java.util.List;\n");
        s.append("import java.io.OutputStream;\n\n");
        s.append("import org.reuseware.emftextedit.resource.*;\n");
        s.append("import org.reuseware.emftextedit.resource.impl.*;\n\n");
        
        s.append("public class " + super.getResourceClassName() + " extends EMFTextPrinterImpl {\n\n");

        s.append("    public " + super.getResourceClassName() + "(OutputStream o, TextResource resource) {\n");
        s.append("        super(o, resource);\n");
        s.append("    }\n\n");      
        
        s.append("    protected String doPrint(EObject element, String globaltab) {\n");
        s.append("        if (element == null) return null;\n\n");
        s.append("        StringBuffer s0 = new StringBuffer();\n");
        s.append("        boolean nullResult0 = false;\n");
        s.append("        Object value = null;\n");
        
        String elseString = "";
        
        //iterate over all rules
        for(Rule rule: source.getAllRules()) {
        	GenClass genClass = rule.getMetaclass();
            
            s.append("        " + elseString + "if (element instanceof " + genClass.getName() + ") {\n");
            s.append("            " + genClass.getName() + " " + getLowerCase(genClass.getName()) + " = (" + genClass.getName() + ") element;\n");
            s.append("            String result = null;\n");
            s.append("            String localtab = \"\";\n");
            
            for(GenFeature sf : genClass.getAllGenFeatures()) {
                if (sf.getEcoreFeature().getUpperBound() != 1) {
                    s.append("            int " + sf.getName() + "Idx = 0;\n");
                }
            }         
            
            //call print rule method for the rule
            generatePrinterRule(rule.getDefinition(), genClass, s, 0);
            
            s.append("        }\n");
            elseString = "else ";
        }
        s.append("        else {\n");
        s.append("            resource.addWarning(\"The " + csName + " printer can not handle \" + element.eClass().getName() + \" elements\", element);\n");
        s.append("        }\n");
        s.append("        return s0.toString();\n"); //TODO FATAL if nullResult0 == false
        s.append("    }\n\n");
        
        s.append("}\n");
        
        return s.toString();
    }
    
    
    /**
     * Generates printer code for definitions.
     */
    private void generatePrinterRule(Definition def, GenClass genClass, StringBuffer s, int count) {
        int inCounter = count;
        
        if(def.getCardinality() != null) {
            count++;
            s.append("            {\n");
            s.append("            StringBuffer s" + count +" = new StringBuffer();\n");
            s.append("            boolean nullResult" + count +" = false;\n\n");
           	s.append("            String tabbuffer" + count + " = globaltab;\n");
        	s.append("            globaltab = globaltab.concat(localtab);\n");
            //s.append("            s" + count + ".append(\"\\n");
            //for(int i=0; i< (counter)*4; i++) s.append(" ");
            //s.append("\");\n");
            
            if (def.getCardinality() instanceof STAR || def.getCardinality() instanceof PLUS) {
                s.append("            do {\n");                        
                //s.append("            s" + count + ".append(\"    \");\n");
            }
        }
        
        if (def instanceof CompoundDefinition) {//TODO what about PLUS? 
        	CompoundDefinition cDef = (CompoundDefinition) def;
            generatePrinterRule(cDef.getDefinitions(), genClass, s, count);
        }
        if (def instanceof CsString) {
            CsString terminal = (CsString) def;
            s.append("            s" + count + ".append(\"" + terminal.getValue().replaceAll("\"", "\\\\\"") + " \");\n");
        }
        if (def instanceof Terminal) {
        	Terminal      t = (Terminal) def;
            GenFeature   sf = t.getFeature();
            
            if (sf.getEcoreFeature().getEType() instanceof EDataType) { //FIXME EEnums
            	if (!(sf.getEcoreFeature().getEType() instanceof EEnum)) {
	            	String methodPrefix = "get";
	            	if (sf.getEcoreFeature().getEType().getInstanceClassName().equals("boolean")) methodPrefix = "is";
	                s.append("            value = " + getLowerCase(genClass.getName()) + "." + methodPrefix + cap(sf.getName()) + "();\n");
	                s.append("            if (value != null) result = value.toString() + \" \";\n"); 
            	}
            	else {
            		//FIXME EEnums	
            	}
            }
            else {
                if (sf.getEcoreFeature().getUpperBound() != 1) {
                    s.append("            if(" + getLowerCase(genClass.getName()) + ".get" + cap(sf.getName()) + "().size() <= " + sf.getName() + "Idx) result = null;\n");
                    s.append("            else {result = doPrint((EObject)" + getLowerCase(genClass.getName()) + ".get" + cap(sf.getName()) + "().get(" + sf.getName() + "Idx), globaltab.concat(localtab)); " + sf.getName() + "Idx++; }\n");
                }
                else {
                    s.append("            result = doPrint(" + getLowerCase(genClass.getName()) + ".get" + cap(sf.getName()) + "(), globaltab.concat(localtab));\n");
                }
            }
            s.append("            if (result != null) s" + count +  ".append(result);\n");
            s.append("            else nullResult" + count + " = true;\n");
        }
        if (def instanceof WhiteSpaces) {
        	int ammount = ((WhiteSpaces) def).getAmmount();
        	if (ammount == 0) {
        		s.append("            s" + count + ".deleteCharAt(s" + count + ".length() - 1);\n");
        	}
        	else if (ammount > 1) {
           		s.append("            s" + count + ".append(\"");
           		for (int i = 1; i < ammount; i++) {
           			s.append(" ");
           		}
           		s.append("\");\n");
        	}
        }
        if (def instanceof LineBreak) {
        	int tab = ((LineBreak)def).getTab();
       		s.append("            localtab = \"");
       		for (int i = 0; i < tab; i++) {
       			s.append(" ");
       		}
       		s.append("\";\n");
       		
       		s.append("            s" + count + ".append(\"\\n\");\n");
       		s.append("            s" + count + ".append(globaltab);\n");
       		s.append("            s" + count + ".append(localtab);\n");
        }

         
        if(def.getCardinality() != null) {
            //s.append("            s" + counter + ".append(\"\\n");
            //for(int i=0; i< (counter)*4; i++) s.append(" ");
            //s.append("\");\n");
            s.append("            if (!nullResult" + count +") {s" + inCounter + ".append(s" + count + "); s" + count + " = new StringBuffer();}\n");
            if (def.getCardinality() instanceof STAR || def.getCardinality() instanceof PLUS) {
                s.append("            } while (!nullResult" + count + ");\n");
            }
        	s.append("            globaltab = tabbuffer" + count + ";\n");
            s.append("            }\n");           
        }

        s.append("\n");
    }
    
    /**
     * Generates printer coder for sequences.
     */
    private void generatePrinterRule(Sequence sequence, GenClass genClass, StringBuffer s, int count)  {

        for (Iterator<Definition> i = sequence.getParts().iterator(); i.hasNext(); ) {
        	generatePrinterRule(i.next(), genClass,s,count);
        }
    }

    /**
     * Generates printer coder for choices
     * <p>
     * <i>Implementation not completed (always first choice is taken at the moment)!</i>
     */
    private void generatePrinterRule(Choice choice, GenClass genClass, StringBuffer s, int count) {
        Iterator<Sequence> i = choice.getOptions().iterator();
        generatePrinterRule(i.next(), genClass, s, count);
        //FIXME always takes first possibility; checking and validation needed (in the whole pretty printer)
    }


}

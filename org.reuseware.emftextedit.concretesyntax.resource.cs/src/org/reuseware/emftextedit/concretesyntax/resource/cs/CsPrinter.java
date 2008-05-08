package org.reuseware.emftextedit.concretesyntax.resource.cs; 

import org.eclipse.emf.ecore.EObject;
import org.reuseware.emftextedit.concretesyntax.ConcreteSyntax;
import org.reuseware.emftextedit.concretesyntax.Import;
import org.reuseware.emftextedit.concretesyntax.Rule;
import org.reuseware.emftextedit.concretesyntax.Sequence;
import org.reuseware.emftextedit.concretesyntax.Choice;
import org.reuseware.emftextedit.concretesyntax.CsString;
import org.reuseware.emftextedit.concretesyntax.DefinedPlaceholder;
import org.reuseware.emftextedit.concretesyntax.DerivedPlaceholder;
import org.reuseware.emftextedit.concretesyntax.Containment;
import org.reuseware.emftextedit.concretesyntax.CompoundDefinition;
import org.reuseware.emftextedit.concretesyntax.PLUS;
import org.reuseware.emftextedit.concretesyntax.STAR;
import org.reuseware.emftextedit.concretesyntax.QUESTIONMARK;
import org.reuseware.emftextedit.concretesyntax.WhiteSpaces;
import org.reuseware.emftextedit.concretesyntax.LineBreak;
import org.reuseware.emftextedit.concretesyntax.NormalToken;
import org.reuseware.emftextedit.concretesyntax.DecoratedToken;
import org.reuseware.emftextedit.concretesyntax.PreDefinedToken;
import java.util.List;
import java.io.OutputStream;

import org.reuseware.emftextedit.resource.*;
import org.reuseware.emftextedit.resource.impl.*;

public class CsPrinter extends EMFTextPrinterImpl {

    public CsPrinter(OutputStream o, TextResource resource) {
        super(o, resource);
    }

    protected String doPrint(EObject element, String globaltab) {
        if (element == null) return null;

        StringBuffer s0 = new StringBuffer();
        boolean nullResult0 = false;
        Object value = null;
        if (element instanceof ConcreteSyntax) {
            ConcreteSyntax concretesyntax = (ConcreteSyntax) element;
            String result = null;
            String localtab = "";
            int importsIdx = 0;
            int startSymbolsIdx = 0;
            int rulesIdx = 0;
            int allRulesIdx = 0;
            int tokensIdx = 0;
            s0.append("SYNTAXDEF ");

            value = concretesyntax.getName();
            if (value != null) result = value.toString() + " ";
            if (result != null) s0.append(result);
            else nullResult0 = true;

            localtab = "";
            s0.append("\n");
            s0.append(globaltab);
            s0.append(localtab);

            s0.append("FOR ");

            result = doPrint(concretesyntax.getPackage(), globaltab.concat(localtab));
            if (result != null) s0.append(result);
            else nullResult0 = true;

            localtab = "";
            s0.append("\n");
            s0.append(globaltab);
            s0.append(localtab);

            s0.append("START ");

            if(concretesyntax.getStartSymbols().size() <= startSymbolsIdx) result = null;
            else {result = doPrint((EObject)concretesyntax.getStartSymbols().get(startSymbolsIdx), globaltab.concat(localtab)); startSymbolsIdx++; }
            if (result != null) s0.append(result);
            else nullResult0 = true;

            {
            StringBuffer s1 = new StringBuffer();
            boolean nullResult1 = false;

            String tabbuffer1 = globaltab;
            globaltab = globaltab.concat(localtab);
            do {
            s1.append(", ");

            if(concretesyntax.getStartSymbols().size() <= startSymbolsIdx) result = null;
            else {result = doPrint((EObject)concretesyntax.getStartSymbols().get(startSymbolsIdx), globaltab.concat(localtab)); startSymbolsIdx++; }
            if (result != null) s1.append(result);
            else nullResult1 = true;

            if (!nullResult1) {s0.append(s1); s1 = new StringBuffer();}
            } while (!nullResult1);
            globaltab = tabbuffer1;
            }

            localtab = "";
            s0.append("\n");
            s0.append(globaltab);
            s0.append(localtab);

            localtab = "";
            s0.append("\n");
            s0.append(globaltab);
            s0.append(localtab);

            {
            StringBuffer s1 = new StringBuffer();
            boolean nullResult1 = false;

            String tabbuffer1 = globaltab;
            globaltab = globaltab.concat(localtab);
            s1.append("IMPORTS ");

            s1.append("{ ");

            {
            StringBuffer s2 = new StringBuffer();
            boolean nullResult2 = false;

            String tabbuffer2 = globaltab;
            globaltab = globaltab.concat(localtab);
            do {
            localtab = "  ";
            s2.append("\n");
            s2.append(globaltab);
            s2.append(localtab);

            if(concretesyntax.getImports().size() <= importsIdx) result = null;
            else {result = doPrint((EObject)concretesyntax.getImports().get(importsIdx), globaltab.concat(localtab)); importsIdx++; }
            if (result != null) s2.append(result);
            else nullResult2 = true;

            if (!nullResult2) {s1.append(s2); s2 = new StringBuffer();}
            } while (!nullResult2);
            globaltab = tabbuffer2;
            }

            localtab = "";
            s1.append("\n");
            s1.append(globaltab);
            s1.append(localtab);

            s1.append("} ");

            if (!nullResult1) {s0.append(s1); s1 = new StringBuffer();}
            globaltab = tabbuffer1;
            }

            localtab = "";
            s0.append("\n");
            s0.append(globaltab);
            s0.append(localtab);

            localtab = "";
            s0.append("\n");
            s0.append(globaltab);
            s0.append(localtab);

            {
            StringBuffer s1 = new StringBuffer();
            boolean nullResult1 = false;

            String tabbuffer1 = globaltab;
            globaltab = globaltab.concat(localtab);
            s1.append("TOKENS ");

            s1.append("{ ");

            {
            StringBuffer s2 = new StringBuffer();
            boolean nullResult2 = false;

            String tabbuffer2 = globaltab;
            globaltab = globaltab.concat(localtab);
            do {
            localtab = "  ";
            s2.append("\n");
            s2.append(globaltab);
            s2.append(localtab);

            if(concretesyntax.getTokens().size() <= tokensIdx) result = null;
            else {result = doPrint((EObject)concretesyntax.getTokens().get(tokensIdx), globaltab.concat(localtab)); tokensIdx++; }
            if (result != null) s2.append(result);
            else nullResult2 = true;

            s2.append("; ");

            if (!nullResult2) {s1.append(s2); s2 = new StringBuffer();}
            } while (!nullResult2);
            globaltab = tabbuffer2;
            }

            localtab = "";
            s1.append("\n");
            s1.append(globaltab);
            s1.append(localtab);

            s1.append("} ");

            if (!nullResult1) {s0.append(s1); s1 = new StringBuffer();}
            globaltab = tabbuffer1;
            }

            localtab = "";
            s0.append("\n");
            s0.append(globaltab);
            s0.append(localtab);

            localtab = "";
            s0.append("\n");
            s0.append(globaltab);
            s0.append(localtab);

            s0.append("RULES ");

            s0.append("{ ");

            localtab = "  ";
            s0.append("\n");
            s0.append(globaltab);
            s0.append(localtab);

            {
            StringBuffer s1 = new StringBuffer();
            boolean nullResult1 = false;

            String tabbuffer1 = globaltab;
            globaltab = globaltab.concat(localtab);
            do {
            if(concretesyntax.getRules().size() <= rulesIdx) result = null;
            else {result = doPrint((EObject)concretesyntax.getRules().get(rulesIdx), globaltab.concat(localtab)); rulesIdx++; }
            if (result != null) s1.append(result);
            else nullResult1 = true;
            if (!nullResult1) {s0.append(s1); s1 = new StringBuffer();}
            } while (!nullResult1);
            globaltab = tabbuffer1;
            }


            localtab = "";
            s0.append("\n");
            s0.append(globaltab);
            s0.append(localtab);

            s0.append("} ");

        }
        else if (element instanceof Import) {
            Import imporx = (Import) element;
            String result = null;
            String localtab = "";
            value = imporx.getPrefix();
            if (value != null) result = value.toString() + " ";
            if (result != null) s0.append(result);
            else nullResult0 = true;

            s0.append(": ");

            result = doPrint(imporx.getPackage(), globaltab.concat(localtab));
            if (result != null) s0.append(result);
            else nullResult0 = true;

            {
            StringBuffer s1 = new StringBuffer();
            boolean nullResult1 = false;

            String tabbuffer1 = globaltab;
            globaltab = globaltab.concat(localtab);
            s1.append("WITH ");

            s1.append("SYNTAX ");

            result = doPrint(imporx.getConcreteSyntax(), globaltab.concat(localtab));
            if (result != null) s1.append(result);
            else nullResult1 = true;

            if (!nullResult1) {s0.append(s1); s1 = new StringBuffer();}
            globaltab = tabbuffer1;
            }

        }
        else if (element instanceof Rule) {
            Rule rule = (Rule) element;
            String result = null;
            String localtab = "";
            result = doPrint(rule.getMetaclass(), globaltab.concat(localtab));
            if (result != null) s0.append(result);
            else nullResult0 = true;


            s0.append("::= ");

            result = doPrint(rule.getDefinition(), globaltab.concat(localtab));
            if (result != null) s0.append(result);
            else nullResult0 = true;

            s0.deleteCharAt(s0.length() - 1);

            s0.append("; ");

        }
        else if (element instanceof Sequence) {
            Sequence sequence = (Sequence) element;
            String result = null;
            String localtab = "";
            int partsIdx = 0;
            {
            StringBuffer s1 = new StringBuffer();
            boolean nullResult1 = false;

            String tabbuffer1 = globaltab;
            globaltab = globaltab.concat(localtab);
            do {
            if(sequence.getParts().size() <= partsIdx) result = null;
            else {result = doPrint((EObject)sequence.getParts().get(partsIdx), globaltab.concat(localtab)); partsIdx++; }
            if (result != null) s1.append(result);
            else nullResult1 = true;
            if (!nullResult1) {s0.append(s1); s1 = new StringBuffer();}
            } while (!nullResult1);
            globaltab = tabbuffer1;
            }

        }
        else if (element instanceof Choice) {
            Choice choice = (Choice) element;
            String result = null;
            String localtab = "";
            int optionsIdx = 0;
            if(choice.getOptions().size() <= optionsIdx) result = null;
            else {result = doPrint((EObject)choice.getOptions().get(optionsIdx), globaltab.concat(localtab)); optionsIdx++; }
            if (result != null) s0.append(result);
            else nullResult0 = true;

            {
            StringBuffer s1 = new StringBuffer();
            boolean nullResult1 = false;

            String tabbuffer1 = globaltab;
            globaltab = globaltab.concat(localtab);
            do {
            s1.append("| ");

            if(choice.getOptions().size() <= optionsIdx) result = null;
            else {result = doPrint((EObject)choice.getOptions().get(optionsIdx), globaltab.concat(localtab)); optionsIdx++; }
            if (result != null) s1.append(result);
            else nullResult1 = true;

            if (!nullResult1) {s0.append(s1); s1 = new StringBuffer();}
            } while (!nullResult1);
            globaltab = tabbuffer1;
            }

            s0.deleteCharAt(s0.length() - 1);

        }
        else if (element instanceof CsString) {
            CsString csstring = (CsString) element;
            String result = null;
            String localtab = "";
            value = csstring.getValue();
            if (value != null) result = value.toString() + " ";
            if (result != null) s0.append(result);
            else nullResult0 = true;

        }
        else if (element instanceof DefinedPlaceholder) {
            DefinedPlaceholder definedplaceholder = (DefinedPlaceholder) element;
            String result = null;
            String localtab = "";
            result = doPrint(definedplaceholder.getFeature(), globaltab.concat(localtab));
            if (result != null) s0.append(result);
            else nullResult0 = true;

            s0.append("[ ");

            s0.deleteCharAt(s0.length() - 1);

            result = doPrint(definedplaceholder.getToken(), globaltab.concat(localtab));
            if (result != null) s0.append(result);
            else nullResult0 = true;

            s0.deleteCharAt(s0.length() - 1);

            s0.append("] ");

            s0.deleteCharAt(s0.length() - 1);

            {
            StringBuffer s1 = new StringBuffer();
            boolean nullResult1 = false;

            String tabbuffer1 = globaltab;
            globaltab = globaltab.concat(localtab);
            result = doPrint(definedplaceholder.getCardinality(), globaltab.concat(localtab));
            if (result != null) s1.append(result);
            else nullResult1 = true;
            if (!nullResult1) {s0.append(s1); s1 = new StringBuffer();}
            globaltab = tabbuffer1;
            }

        }
        else if (element instanceof DerivedPlaceholder) {
            DerivedPlaceholder derivedplaceholder = (DerivedPlaceholder) element;
            String result = null;
            String localtab = "";
            result = doPrint(derivedplaceholder.getFeature(), globaltab.concat(localtab));
            if (result != null) s0.append(result);
            else nullResult0 = true;

            s0.append("[ ");

            {
            StringBuffer s1 = new StringBuffer();
            boolean nullResult1 = false;

            String tabbuffer1 = globaltab;
            globaltab = globaltab.concat(localtab);
            value = derivedplaceholder.getPrefix();
            if (value != null) result = value.toString() + " ";
            if (result != null) s1.append(result);
            else nullResult1 = true;

            {
            StringBuffer s2 = new StringBuffer();
            boolean nullResult2 = false;

            String tabbuffer2 = globaltab;
            globaltab = globaltab.concat(localtab);
            s2.append(", ");

            s2.deleteCharAt(s2.length() - 1);

            value = derivedplaceholder.getSuffix();
            if (value != null) result = value.toString() + " ";
            if (result != null) s2.append(result);
            else nullResult2 = true;

            if (!nullResult2) {s1.append(s2); s2 = new StringBuffer();}
            globaltab = tabbuffer2;
            }

            s1.deleteCharAt(s1.length() - 1);

            if (!nullResult1) {s0.append(s1); s1 = new StringBuffer();}
            globaltab = tabbuffer1;
            }

            s0.append("] ");

            s0.deleteCharAt(s0.length() - 1);

            {
            StringBuffer s1 = new StringBuffer();
            boolean nullResult1 = false;

            String tabbuffer1 = globaltab;
            globaltab = globaltab.concat(localtab);
            result = doPrint(derivedplaceholder.getCardinality(), globaltab.concat(localtab));
            if (result != null) s1.append(result);
            else nullResult1 = true;
            if (!nullResult1) {s0.append(s1); s1 = new StringBuffer();}
            globaltab = tabbuffer1;
            }

        }
        else if (element instanceof Containment) {
            Containment containment = (Containment) element;
            String result = null;
            String localtab = "";
            result = doPrint(containment.getFeature(), globaltab.concat(localtab));
            if (result != null) s0.append(result);
            else nullResult0 = true;

            s0.deleteCharAt(s0.length() - 1);

            {
            StringBuffer s1 = new StringBuffer();
            boolean nullResult1 = false;

            String tabbuffer1 = globaltab;
            globaltab = globaltab.concat(localtab);
            result = doPrint(containment.getCardinality(), globaltab.concat(localtab));
            if (result != null) s1.append(result);
            else nullResult1 = true;
            if (!nullResult1) {s0.append(s1); s1 = new StringBuffer();}
            globaltab = tabbuffer1;
            }

        }
        else if (element instanceof CompoundDefinition) {
            CompoundDefinition compounddefinition = (CompoundDefinition) element;
            String result = null;
            String localtab = "";
            s0.append("( ");

            result = doPrint(compounddefinition.getDefinitions(), globaltab.concat(localtab));
            if (result != null) s0.append(result);
            else nullResult0 = true;

            s0.append(") ");

            s0.deleteCharAt(s0.length() - 1);

            {
            StringBuffer s1 = new StringBuffer();
            boolean nullResult1 = false;

            String tabbuffer1 = globaltab;
            globaltab = globaltab.concat(localtab);
            result = doPrint(compounddefinition.getCardinality(), globaltab.concat(localtab));
            if (result != null) s1.append(result);
            else nullResult1 = true;
            if (!nullResult1) {s0.append(s1); s1 = new StringBuffer();}
            globaltab = tabbuffer1;
            }

        }
        else if (element instanceof PLUS) {
            PLUS plus = (PLUS) element;
            String result = null;
            String localtab = "";
            s0.append("+ ");

        }
        else if (element instanceof STAR) {
            STAR star = (STAR) element;
            String result = null;
            String localtab = "";
            s0.append("* ");

        }
        else if (element instanceof QUESTIONMARK) {
            QUESTIONMARK questionmark = (QUESTIONMARK) element;
            String result = null;
            String localtab = "";
            s0.append("? ");

        }
        else if (element instanceof WhiteSpaces) {
            WhiteSpaces whitespaces = (WhiteSpaces) element;
            String result = null;
            String localtab = "";
            value = whitespaces.getAmmount();
            if (value != null) result = value.toString() + " ";
            if (result != null) s0.append(result);
            else nullResult0 = true;

        }
        else if (element instanceof LineBreak) {
            LineBreak linebreak = (LineBreak) element;
            String result = null;
            String localtab = "";
            value = linebreak.getTab();
            if (value != null) result = value.toString() + " ";
            if (result != null) s0.append(result);
            else nullResult0 = true;

        }
        else if (element instanceof NormalToken) {
            NormalToken normaltoken = (NormalToken) element;
            String result = null;
            String localtab = "";
            int attributeReferencesIdx = 0;
            s0.append("DEFINE ");

            value = normaltoken.getName();
            if (value != null) result = value.toString() + " ";
            if (result != null) s0.append(result);
            else nullResult0 = true;

            value = normaltoken.getRegex();
            if (value != null) result = value.toString() + " ";
            if (result != null) s0.append(result);
            else nullResult0 = true;

            localtab = "";
            s0.append("\n");
            s0.append(globaltab);
            s0.append(localtab);

        }
        else if (element instanceof DecoratedToken) {
            DecoratedToken decoratedtoken = (DecoratedToken) element;
            String result = null;
            String localtab = "";
            int attributeReferencesIdx = 0;
            s0.append("DEFINE ");

            value = decoratedtoken.getName();
            if (value != null) result = value.toString() + " ";
            if (result != null) s0.append(result);
            else nullResult0 = true;

            s0.append("[ ");

            s0.deleteCharAt(s0.length() - 1);

            value = decoratedtoken.getPrefix();
            if (value != null) result = value.toString() + " ";
            if (result != null) s0.append(result);
            else nullResult0 = true;


            s0.deleteCharAt(s0.length() - 1);

            s0.append("] ");


            value = decoratedtoken.getRegex();
            if (value != null) result = value.toString() + " ";
            if (result != null) s0.append(result);
            else nullResult0 = true;

            s0.append("[ ");

            s0.deleteCharAt(s0.length() - 1);

            value = decoratedtoken.getSuffix();
            if (value != null) result = value.toString() + " ";
            if (result != null) s0.append(result);
            else nullResult0 = true;


            s0.deleteCharAt(s0.length() - 1);

            s0.append("] ");


            localtab = "";
            s0.append("\n");
            s0.append(globaltab);
            s0.append(localtab);

        }
        else if (element instanceof PreDefinedToken) {
            PreDefinedToken predefinedtoken = (PreDefinedToken) element;
            String result = null;
            String localtab = "";
            int attributeReferencesIdx = 0;
            s0.append("PREDEFINED ");

            value = predefinedtoken.getName();
            if (value != null) result = value.toString() + " ";
            if (result != null) s0.append(result);
            else nullResult0 = true;

        }
        else {
            resource.addWarning("The cs printer can not handle " + element.eClass().getName() + " elements", element);
        }
        return s0.toString();
    }

}

package org.reuseware.emftextedit.concretesyntax.resource.cs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
import java.util.Collection;
import java.util.ListIterator;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.reuseware.emftextedit.resource.*;
import org.reuseware.emftextedit.resource.impl.*;

public abstract class CsPrinterBase extends EMFTextPrinterImpl {

	protected TokenResolverFactory tokenResolverFactory = new CsTokenResolverFactory();
	protected EMFTextTreeAnalyser treeAnalyser = new CsTreeAnalyser();

	public CsPrinterBase(OutputStream o, TextResource resource) {

		super(o, resource);
	}

	protected static int matchCount(Map<String,Integer> featureCounter,Collection<String> needed){
		int pos = 0;
		int neg = 0;

		for(String featureName:featureCounter.keySet()){
			if(needed.contains(featureName)){
				int value = featureCounter.get(featureName);
				if(value==0)
					neg+=1;
				else
					pos+=1;
			}
		}
		return neg>0?-neg:pos;
	}

	protected void doPrint(EObject element,PrintWriter out,String globaltab) {
		if (element == null||out == null) throw new NullPointerException("Nothing to write or to write on.");

		if(element instanceof ConcreteSyntax){
			printConcreteSyntax((ConcreteSyntax) element,globaltab,out);
			return;
		}
		if(element instanceof Import){
			printImport((Import) element,globaltab,out);
			return;
		}
		if(element instanceof Rule){
			printRule((Rule) element,globaltab,out);
			return;
		}
		if(element instanceof Sequence){
			printSequence((Sequence) element,globaltab,out);
			return;
		}
		if(element instanceof Choice){
			printChoice((Choice) element,globaltab,out);
			return;
		}
		if(element instanceof CsString){
			printCsString((CsString) element,globaltab,out);
			return;
		}
		if(element instanceof DefinedPlaceholder){
			printDefinedPlaceholder((DefinedPlaceholder) element,globaltab,out);
			return;
		}
		if(element instanceof DerivedPlaceholder){
			printDerivedPlaceholder((DerivedPlaceholder) element,globaltab,out);
			return;
		}
		if(element instanceof Containment){
			printContainment((Containment) element,globaltab,out);
			return;
		}
		if(element instanceof CompoundDefinition){
			printCompoundDefinition((CompoundDefinition) element,globaltab,out);
			return;
		}
		if(element instanceof PLUS){
			printPLUS((PLUS) element,globaltab,out);
			return;
		}
		if(element instanceof STAR){
			printSTAR((STAR) element,globaltab,out);
			return;
		}
		if(element instanceof QUESTIONMARK){
			printQUESTIONMARK((QUESTIONMARK) element,globaltab,out);
			return;
		}
		if(element instanceof WhiteSpaces){
			printWhiteSpaces((WhiteSpaces) element,globaltab,out);
			return;
		}
		if(element instanceof LineBreak){
			printLineBreak((LineBreak) element,globaltab,out);
			return;
		}
		if(element instanceof NormalToken){
			printNormalToken((NormalToken) element,globaltab,out);
			return;
		}
		if(element instanceof DecoratedToken){
			printDecoratedToken((DecoratedToken) element,globaltab,out);
			return;
		}
		if(element instanceof PreDefinedToken){
			printPreDefinedToken((PreDefinedToken) element,globaltab,out);
			return;
		}

		resource.addWarning("The cs printer can not handle " + element.eClass().getName() + " elements", element);
	}

		public void printConcreteSyntax(ConcreteSyntax element,String outertab,PrintWriter out){
			String localtab = outertab;
			HashMap<String,Integer> printCountingMap = new HashMap<String,Integer>(7);
			Object temp;
			temp = element.getName();
			printCountingMap.put("name",temp ==null?0:1);
			temp = element.getPackage();
			printCountingMap.put("package",temp ==null?0:1);
			temp = element.getImports();
			printCountingMap.put("imports",temp ==null?0:((Collection)temp).size());
			temp = element.getStartSymbols();
			printCountingMap.put("startSymbols",temp ==null?0:((Collection)temp).size());
			temp = element.getRules();
			printCountingMap.put("rules",temp ==null?0:((Collection)temp).size());
			temp = element.getAllRules();
			printCountingMap.put("allRules",temp ==null?0:((Collection)temp).size());
			temp = element.getTokens();
			printCountingMap.put("tokens",temp ==null?0:((Collection)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("SYNTAXDEF");
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.getName();
				out.print(tokenResolverFactory.createTokenResolver("TEXT").deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("FOR");
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("package");
			if(count>0){
				Object o =element.getPackage();
				out.print(tokenResolverFactory.createTokenResolver("QUOTED_60_62").deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("package")),element.eClass().getEStructuralFeature("package"),element));
				printCountingMap.put("package",count-1);
			}
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("START");
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printConcreteSyntax_0(element,localtab,out,printCountingMap);
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<String,Integer> printCountingMap1 = new HashMap<String,Integer>(printCountingMap);
				printConcreteSyntax_1(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<String,Integer> printCountingMap1 = new HashMap<String,Integer>(printCountingMap);
			printConcreteSyntax_2(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<String,Integer>(printCountingMap);
			printConcreteSyntax_3(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("RULES");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printConcreteSyntax_4(element,localtab,out,printCountingMap);
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printConcreteSyntax_2(ConcreteSyntax element,String outertab,PrintWriter out,HashMap<String,Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("IMPORTS");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<String,Integer> printCountingMap1 = new HashMap<String,Integer>(printCountingMap);
				printConcreteSyntax_2_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printConcreteSyntax_3(ConcreteSyntax element,String outertab,PrintWriter out,HashMap<String,Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("TOKENS");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<String,Integer> printCountingMap1 = new HashMap<String,Integer>(printCountingMap);
				printConcreteSyntax_3_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printConcreteSyntax_1(ConcreteSyntax element,String outertab,PrintWriter out,HashMap<String,Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printConcreteSyntax_1_0(element,localtab,out,printCountingMap);
		}
		public void printConcreteSyntax_2_0(ConcreteSyntax element,String outertab,PrintWriter out,HashMap<String,Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (LineBreak):
			localtab += "\t\t";
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("imports");
			if(count>0){
				Object o =element.getImports();
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("imports",count-1);
			}
		}
		public void printConcreteSyntax_0(ConcreteSyntax element,String outertab,PrintWriter out,HashMap<String,Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("startSymbols"));
			int temp;
			temp=matchCount(printCountingMap,Arrays.asList("startSymbols"));
			if(temp>matches){alt=1;matches=temp;}
			switch(alt){
				case 1:
					//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
					count = printCountingMap.get("startSymbols");
					if(count>0){
						Object o =element.getStartSymbols();
						o = ((List<Object>)o).get(((List<Object>)o).size()-count);
						out.print(tokenResolverFactory.createTokenResolver("QNAME").deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("startSymbols")),element.eClass().getEStructuralFeature("startSymbols"),element));
						printCountingMap.put("startSymbols",count-1);
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("startSymbols");
					if(count>0){
						Object o =element.getStartSymbols();
						o = ((List<Object>)o).get(((List<Object>)o).size()-count);
						out.print(tokenResolverFactory.createTokenResolver("TEXT").deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("startSymbols")),element.eClass().getEStructuralFeature("startSymbols"),element));
						printCountingMap.put("startSymbols",count-1);
					}
			}
		}
		public void printConcreteSyntax_4(ConcreteSyntax element,String outertab,PrintWriter out,HashMap<String,Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (LineBreak):
			localtab += "\t\t";
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("rules");
			if(count>0){
				ListIterator it  = ((List)element.getRules()).listIterator(((List)element.getRules()).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("rules",0);
			}
		}
		public void printConcreteSyntax_1_0(ConcreteSyntax element,String outertab,PrintWriter out,HashMap<String,Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("startSymbols"));
			int temp;
			temp=matchCount(printCountingMap,Arrays.asList("startSymbols"));
			if(temp>matches){alt=1;matches=temp;}
			switch(alt){
				case 1:
					//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
					count = printCountingMap.get("startSymbols");
					if(count>0){
						Object o =element.getStartSymbols();
						o = ((List<Object>)o).get(((List<Object>)o).size()-count);
						out.print(tokenResolverFactory.createTokenResolver("QNAME").deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("startSymbols")),element.eClass().getEStructuralFeature("startSymbols"),element));
						printCountingMap.put("startSymbols",count-1);
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("startSymbols");
					if(count>0){
						Object o =element.getStartSymbols();
						o = ((List<Object>)o).get(((List<Object>)o).size()-count);
						out.print(tokenResolverFactory.createTokenResolver("TEXT").deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("startSymbols")),element.eClass().getEStructuralFeature("startSymbols"),element));
						printCountingMap.put("startSymbols",count-1);
					}
			}
		}
		public void printConcreteSyntax_3_0(ConcreteSyntax element,String outertab,PrintWriter out,HashMap<String,Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (LineBreak):
			localtab += "\t\t";
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("tokens");
			if(count>0){
				Object o =element.getTokens();
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("tokens",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
		}
		public void printImport(Import element,String outertab,PrintWriter out){
			String localtab = outertab;
			HashMap<String,Integer> printCountingMap = new HashMap<String,Integer>(3);
			Object temp;
			temp = element.getPrefix();
			printCountingMap.put("prefix",temp ==null?0:1);
			temp = element.getConcreteSyntax();
			printCountingMap.put("concreteSyntax",temp ==null?0:1);
			temp = element.getPackage();
			printCountingMap.put("package",temp ==null?0:1);
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("prefix");
			if(count>0){
				Object o =element.getPrefix();
				out.print(tokenResolverFactory.createTokenResolver("TEXT").deResolve((Object)o,element.eClass().getEStructuralFeature("prefix"),element));
				printCountingMap.put("prefix",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(":");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("package");
			if(count>0){
				Object o =element.getPackage();
				out.print(tokenResolverFactory.createTokenResolver("QUOTED_60_62").deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("package")),element.eClass().getEStructuralFeature("package"),element));
				printCountingMap.put("package",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<String,Integer> printCountingMap1 = new HashMap<String,Integer>(printCountingMap);
			printImport_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		public void printImport_0(Import element,String outertab,PrintWriter out,HashMap<String,Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("WITH");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("SYNTAX");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("concreteSyntax");
			if(count>0){
				Object o =element.getConcreteSyntax();
				out.print(tokenResolverFactory.createTokenResolver("TEXT").deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("concreteSyntax")),element.eClass().getEStructuralFeature("concreteSyntax"),element));
				printCountingMap.put("concreteSyntax",count-1);
			}
		}
		public void printRule(Rule element,String outertab,PrintWriter out){
			String localtab = outertab;
			HashMap<String,Integer> printCountingMap = new HashMap<String,Integer>(3);
			Object temp;
			temp = element.getDefinition();
			printCountingMap.put("definition",temp ==null?0:1);
			temp = element.getMetaclass();
			printCountingMap.put("metaclass",temp ==null?0:1);
			temp = element.getSyntax();
			printCountingMap.put("syntax",temp ==null?0:1);
			int count;
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printRule_0(element,localtab,out,printCountingMap);
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("::=");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("definition");
			if(count>0){
				Object o =element.getDefinition();
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("definition",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
		}
		public void printRule_0(Rule element,String outertab,PrintWriter out,HashMap<String,Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("metaclass"));
			int temp;
			temp=matchCount(printCountingMap,Arrays.asList("metaclass"));
			if(temp>matches){alt=1;matches=temp;}
			switch(alt){
				case 1:
					//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
					count = printCountingMap.get("metaclass");
					if(count>0){
						Object o =element.getMetaclass();
						out.print(tokenResolverFactory.createTokenResolver("QNAME").deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("metaclass")),element.eClass().getEStructuralFeature("metaclass"),element));
						printCountingMap.put("metaclass",count-1);
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("metaclass");
					if(count>0){
						Object o =element.getMetaclass();
						out.print(tokenResolverFactory.createTokenResolver("TEXT").deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("metaclass")),element.eClass().getEStructuralFeature("metaclass"),element));
						printCountingMap.put("metaclass",count-1);
					}
			}
		}
		public void printSequence(Sequence element,String outertab,PrintWriter out){
			String localtab = outertab;
			HashMap<String,Integer> printCountingMap = new HashMap<String,Integer>(1);
			Object temp;
			temp = element.getParts();
			printCountingMap.put("parts",temp ==null?0:((Collection)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("parts");
			if(count>0){
				ListIterator it  = ((List)element.getParts()).listIterator(((List)element.getParts()).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("parts",0);
			}
		}
		public void printChoice(Choice element,String outertab,PrintWriter out){
			String localtab = outertab;
			HashMap<String,Integer> printCountingMap = new HashMap<String,Integer>(1);
			Object temp;
			temp = element.getOptions();
			printCountingMap.put("options",temp ==null?0:((Collection)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("options");
			if(count>0){
				Object o =element.getOptions();
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("options",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<String,Integer> printCountingMap1 = new HashMap<String,Integer>(printCountingMap);
				printChoice_0(element,localtab,out1,printCountingMap1);
				if(printCountingMap.equals(printCountingMap1)){
					iterate = false;
					out1.close();
				}
				else{
					out1.flush();
					out1.close();
					out.print(sWriter.toString());
					printCountingMap.putAll(printCountingMap1);
				}
			}
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
		}
		public void printChoice_0(Choice element,String outertab,PrintWriter out,HashMap<String,Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("|");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("options");
			if(count>0){
				Object o =element.getOptions();
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("options",count-1);
			}
		}
		public void printCsString(CsString element,String outertab,PrintWriter out){
			String localtab = outertab;
			HashMap<String,Integer> printCountingMap = new HashMap<String,Integer>(2);
			Object temp;
			temp = element.getCardinality();
			printCountingMap.put("cardinality",temp ==null?0:1);
			temp = element.getValue();
			printCountingMap.put("value",temp ==null?0:1);
			int count;
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("value");
			if(count>0){
				Object o =element.getValue();
				out.print(tokenResolverFactory.createTokenResolver("QUOTED_34_34").deResolve((Object)o,element.eClass().getEStructuralFeature("value"),element));
				printCountingMap.put("value",count-1);
			}
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
		}
		public void printDefinedPlaceholder(DefinedPlaceholder element,String outertab,PrintWriter out){
			String localtab = outertab;
			HashMap<String,Integer> printCountingMap = new HashMap<String,Integer>(3);
			Object temp;
			temp = element.getCardinality();
			printCountingMap.put("cardinality",temp ==null?0:1);
			temp = element.getFeature();
			printCountingMap.put("feature",temp ==null?0:1);
			temp = element.getToken();
			printCountingMap.put("token",temp ==null?0:1);
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("feature");
			if(count>0){
				Object o =element.getFeature();
				out.print(tokenResolverFactory.createTokenResolver("TEXT").deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("feature")),element.eClass().getEStructuralFeature("feature"),element));
				printCountingMap.put("feature",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("[");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("token");
			if(count>0){
				Object o =element.getToken();
				out.print(tokenResolverFactory.createTokenResolver("TEXT").deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("token")),element.eClass().getEStructuralFeature("token"),element));
				printCountingMap.put("token",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("]");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("cardinality");
			if(count>0){
				Object o =element.getCardinality();
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("cardinality",count-1);
			}
		}
		public void printDerivedPlaceholder(DerivedPlaceholder element,String outertab,PrintWriter out){
			String localtab = outertab;
			HashMap<String,Integer> printCountingMap = new HashMap<String,Integer>(4);
			Object temp;
			temp = element.getCardinality();
			printCountingMap.put("cardinality",temp ==null?0:1);
			temp = element.getFeature();
			printCountingMap.put("feature",temp ==null?0:1);
			temp = element.getPrefix();
			printCountingMap.put("prefix",temp ==null?0:1);
			temp = element.getSuffix();
			printCountingMap.put("suffix",temp ==null?0:1);
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("feature");
			if(count>0){
				Object o =element.getFeature();
				out.print(tokenResolverFactory.createTokenResolver("TEXT").deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("feature")),element.eClass().getEStructuralFeature("feature"),element));
				printCountingMap.put("feature",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("[");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<String,Integer> printCountingMap1 = new HashMap<String,Integer>(printCountingMap);
			printDerivedPlaceholder_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("]");
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("cardinality");
			if(count>0){
				Object o =element.getCardinality();
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("cardinality",count-1);
			}
		}
		public void printDerivedPlaceholder_0(DerivedPlaceholder element,String outertab,PrintWriter out,HashMap<String,Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("prefix");
			if(count>0){
				Object o =element.getPrefix();
				out.print(tokenResolverFactory.createTokenResolver("QUOTED_39_39").deResolve((Object)o,element.eClass().getEStructuralFeature("prefix"),element));
				printCountingMap.put("prefix",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<String,Integer> printCountingMap1 = new HashMap<String,Integer>(printCountingMap);
			printDerivedPlaceholder_0_0(element,localtab,out1,printCountingMap1);
			if(printCountingMap.equals(printCountingMap1)){
				out1.close();
			}
			else{
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		public void printDerivedPlaceholder_0_0(DerivedPlaceholder element,String outertab,PrintWriter out,HashMap<String,Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("suffix");
			if(count>0){
				Object o =element.getSuffix();
				out.print(tokenResolverFactory.createTokenResolver("QUOTED_39_39").deResolve((Object)o,element.eClass().getEStructuralFeature("suffix"),element));
				printCountingMap.put("suffix",count-1);
			}
		}
		public void printContainment(Containment element,String outertab,PrintWriter out){
			String localtab = outertab;
			HashMap<String,Integer> printCountingMap = new HashMap<String,Integer>(2);
			Object temp;
			temp = element.getCardinality();
			printCountingMap.put("cardinality",temp ==null?0:1);
			temp = element.getFeature();
			printCountingMap.put("feature",temp ==null?0:1);
			int count;
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printContainment_0(element,localtab,out,printCountingMap);
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
		}
		public void printContainment_0(Containment element,String outertab,PrintWriter out,HashMap<String,Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("feature","cardinality"));
			int temp;
			temp=matchCount(printCountingMap,Arrays.asList("feature"));
			if(temp>matches){alt=1;matches=temp;}
			switch(alt){
				case 1:
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("feature");
					if(count>0){
						Object o =element.getFeature();
						out.print(tokenResolverFactory.createTokenResolver("TEXT").deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("feature")),element.eClass().getEStructuralFeature("feature"),element));
						printCountingMap.put("feature",count-1);
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("feature");
					if(count>0){
						Object o =element.getFeature();
						out.print(tokenResolverFactory.createTokenResolver("TEXT").deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("feature")),element.eClass().getEStructuralFeature("feature"),element));
						printCountingMap.put("feature",count-1);
					}
					//////////////DEFINITION PART BEGINS (Containment):
					count = printCountingMap.get("cardinality");
					if(count>0){
						Object o =element.getCardinality();
						doPrint((EObject)o,out,localtab);
						printCountingMap.put("cardinality",count-1);
					}
			}
		}
		public void printCompoundDefinition(CompoundDefinition element,String outertab,PrintWriter out){
			String localtab = outertab;
			HashMap<String,Integer> printCountingMap = new HashMap<String,Integer>(2);
			Object temp;
			temp = element.getCardinality();
			printCountingMap.put("cardinality",temp ==null?0:1);
			temp = element.getDefinitions();
			printCountingMap.put("definitions",temp ==null?0:1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("(");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("definitions");
			if(count>0){
				Object o =element.getDefinitions();
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("definitions",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(")");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("cardinality");
			if(count>0){
				Object o =element.getCardinality();
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("cardinality",count-1);
			}
		}
		public void printPLUS(PLUS element,String outertab,PrintWriter out){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("+");
		}
		public void printSTAR(STAR element,String outertab,PrintWriter out){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("*");
		}
		public void printQUESTIONMARK(QUESTIONMARK element,String outertab,PrintWriter out){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("?");
		}
		public void printWhiteSpaces(WhiteSpaces element,String outertab,PrintWriter out){
			String localtab = outertab;
			HashMap<String,Integer> printCountingMap = new HashMap<String,Integer>(2);
			Object temp;
			temp = element.getCardinality();
			printCountingMap.put("cardinality",temp ==null?0:1);
			temp = element.getAmmount();
			printCountingMap.put("ammount",temp ==null?0:1);
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("ammount");
			if(count>0){
				Object o =element.getAmmount();
				out.print(tokenResolverFactory.createTokenResolver("TEXT_35_").deResolve((Object)o,element.eClass().getEStructuralFeature("ammount"),element));
				printCountingMap.put("ammount",count-1);
			}
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
		}
		public void printLineBreak(LineBreak element,String outertab,PrintWriter out){
			String localtab = outertab;
			HashMap<String,Integer> printCountingMap = new HashMap<String,Integer>(2);
			Object temp;
			temp = element.getCardinality();
			printCountingMap.put("cardinality",temp ==null?0:1);
			temp = element.getTab();
			printCountingMap.put("tab",temp ==null?0:1);
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("tab");
			if(count>0){
				Object o =element.getTab();
				out.print(tokenResolverFactory.createTokenResolver("TEXT_33_").deResolve((Object)o,element.eClass().getEStructuralFeature("tab"),element));
				printCountingMap.put("tab",count-1);
			}
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
		}
		public void printNormalToken(NormalToken element,String outertab,PrintWriter out){
			String localtab = outertab;
			HashMap<String,Integer> printCountingMap = new HashMap<String,Integer>(3);
			Object temp;
			temp = element.getName();
			printCountingMap.put("name",temp ==null?0:1);
			temp = element.getAttributeReferences();
			printCountingMap.put("attributeReferences",temp ==null?0:((Collection)temp).size());
			temp = element.getRegex();
			printCountingMap.put("regex",temp ==null?0:1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("DEFINE");
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.getName();
				out.print(tokenResolverFactory.createTokenResolver("TEXT").deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("regex");
			if(count>0){
				Object o =element.getRegex();
				out.print(tokenResolverFactory.createTokenResolver("QUOTED_36_36").deResolve((Object)o,element.eClass().getEStructuralFeature("regex"),element));
				printCountingMap.put("regex",count-1);
			}
		}
		public void printDecoratedToken(DecoratedToken element,String outertab,PrintWriter out){
			String localtab = outertab;
			HashMap<String,Integer> printCountingMap = new HashMap<String,Integer>(5);
			Object temp;
			temp = element.getName();
			printCountingMap.put("name",temp ==null?0:1);
			temp = element.getAttributeReferences();
			printCountingMap.put("attributeReferences",temp ==null?0:((Collection)temp).size());
			temp = element.getRegex();
			printCountingMap.put("regex",temp ==null?0:1);
			temp = element.getPrefix();
			printCountingMap.put("prefix",temp ==null?0:1);
			temp = element.getSuffix();
			printCountingMap.put("suffix",temp ==null?0:1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("DEFINE");
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.getName();
				out.print(tokenResolverFactory.createTokenResolver("TEXT").deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printDecoratedToken_0(element,localtab,out,printCountingMap);
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("regex");
			if(count>0){
				Object o =element.getRegex();
				out.print(tokenResolverFactory.createTokenResolver("QUOTED_36_36").deResolve((Object)o,element.eClass().getEStructuralFeature("regex"),element));
				printCountingMap.put("regex",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printDecoratedToken_1(element,localtab,out,printCountingMap);
		}
		public void printDecoratedToken_0_0(DecoratedToken element,String outertab,PrintWriter out,HashMap<String,Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("prefix");
			if(count>0){
				Object o =element.getPrefix();
				out.print(tokenResolverFactory.createTokenResolver("QUOTED_39_39").deResolve((Object)o,element.eClass().getEStructuralFeature("prefix"),element));
				printCountingMap.put("prefix",count-1);
			}
		}
		public void printDecoratedToken_1(DecoratedToken element,String outertab,PrintWriter out,HashMap<String,Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("[");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printDecoratedToken_1_0(element,localtab,out,printCountingMap);
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("]");
		}
		public void printDecoratedToken_0(DecoratedToken element,String outertab,PrintWriter out,HashMap<String,Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("[");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printDecoratedToken_0_0(element,localtab,out,printCountingMap);
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("]");
		}
		public void printDecoratedToken_1_0(DecoratedToken element,String outertab,PrintWriter out,HashMap<String,Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("suffix");
			if(count>0){
				Object o =element.getSuffix();
				out.print(tokenResolverFactory.createTokenResolver("QUOTED_39_39").deResolve((Object)o,element.eClass().getEStructuralFeature("suffix"),element));
				printCountingMap.put("suffix",count-1);
			}
		}
		public void printPreDefinedToken(PreDefinedToken element,String outertab,PrintWriter out){
			String localtab = outertab;
			HashMap<String,Integer> printCountingMap = new HashMap<String,Integer>(2);
			Object temp;
			temp = element.getName();
			printCountingMap.put("name",temp ==null?0:1);
			temp = element.getAttributeReferences();
			printCountingMap.put("attributeReferences",temp ==null?0:((Collection)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("PREDEFINED");
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.getName();
				out.print(tokenResolverFactory.createTokenResolver("TEXT").deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				printCountingMap.put("name",count-1);
			}
		}
		}

package org.emftext.sdk.concretesyntax.resource.cs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.DefinedPlaceholder;
import org.emftext.sdk.concretesyntax.DerivedPlaceholder;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.PLUS;
import org.emftext.sdk.concretesyntax.STAR;
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
import org.emftext.sdk.concretesyntax.WhiteSpaces;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.NormalToken;
import org.emftext.sdk.concretesyntax.DecoratedToken;
import org.emftext.sdk.concretesyntax.PreDefinedToken;
import java.util.List;
import java.util.Collection;
import java.util.ListIterator;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.emftext.runtime.resource.*;
import org.emftext.runtime.resource.impl.*;

public abstract class CsPrinterBase extends EMFTextPrinterImpl {

	protected TokenResolverFactory tokenResolverFactory = new CsTokenResolverFactory();
	protected EMFTextTreeAnalyser treeAnalyser = new CsTreeAnalyser();

	public CsPrinterBase(OutputStream o, TextResource resource) {

		super(o, resource);
	}

	protected static int matchCount(Map<java.lang.String, java.lang.Integer> featureCounter, Collection<java.lang.String> needed){
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
		if(element instanceof Option){
			printOption((Option) element,globaltab,out);
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
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(8);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("package"));
			printCountingMap.put("package", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("imports"));
			printCountingMap.put("imports", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("startSymbols"));
			printCountingMap.put("startSymbols", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("rules"));
			printCountingMap.put("rules", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("allRules"));
			printCountingMap.put("allRules", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("tokens"));
			printCountingMap.put("tokens", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("options"));
			printCountingMap.put("options", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("SYNTAXDEF");
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
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
				Object o =element.eGet(element.eClass().getEStructuralFeature("package"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("package")),element.eClass().getEStructuralFeature("package"),element));
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
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
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
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
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
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
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
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			printConcreteSyntax_4(element,localtab,out1,printCountingMap1);
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
			printConcreteSyntax_5(element,localtab,out,printCountingMap);
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("}");
		}
		public void printConcreteSyntax_0(ConcreteSyntax element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("startSymbols"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("startSymbols"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
						count = printCountingMap.get("startSymbols");
						if(count>0){
							Object o =element.eGet(element.eClass().getEStructuralFeature("startSymbols"));
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QNAME");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("startSymbols")),element.eClass().getEStructuralFeature("startSymbols"),element));
							printCountingMap.put("startSymbols",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("startSymbols");
					if(count>0){
						Object o =element.eGet(element.eClass().getEStructuralFeature("startSymbols"));
						o = ((List<Object>)o).get(((List<Object>)o).size()-count);
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("startSymbols")),element.eClass().getEStructuralFeature("startSymbols"),element));
						printCountingMap.put("startSymbols",count-1);
					}
			}
		}
		public void printConcreteSyntax_3(ConcreteSyntax element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("OPTIONS");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
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
		public void printConcreteSyntax_4_0(ConcreteSyntax element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (LineBreak):
			localtab += "		";
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("tokens");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("tokens"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("tokens",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
		}
		public void printConcreteSyntax_1(ConcreteSyntax element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printConcreteSyntax_1_0(element,localtab,out,printCountingMap);
		}
		public void printConcreteSyntax_2(ConcreteSyntax element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("IMPORTS");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
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
		public void printConcreteSyntax_2_0(ConcreteSyntax element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (LineBreak):
			localtab += "		";
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("imports");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("imports"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("imports",count-1);
			}
		}
		public void printConcreteSyntax_3_0(ConcreteSyntax element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (LineBreak):
			localtab += "		";
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("options");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("options"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("options",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
		}
		public void printConcreteSyntax_5(ConcreteSyntax element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (LineBreak):
			localtab += "		";
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("rules");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("rules"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("rules"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("rules",0);
			}
		}
		public void printConcreteSyntax_4(ConcreteSyntax element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("TOKENS");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("{");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
				printConcreteSyntax_4_0(element,localtab,out1,printCountingMap1);
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
		public void printConcreteSyntax_1_0(ConcreteSyntax element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("startSymbols"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("startSymbols"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
						count = printCountingMap.get("startSymbols");
						if(count>0){
							Object o =element.eGet(element.eClass().getEStructuralFeature("startSymbols"));
							o = ((List<Object>)o).get(((List<Object>)o).size()-count);
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QNAME");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("startSymbols")),element.eClass().getEStructuralFeature("startSymbols"),element));
							printCountingMap.put("startSymbols",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("startSymbols");
					if(count>0){
						Object o =element.eGet(element.eClass().getEStructuralFeature("startSymbols"));
						o = ((List<Object>)o).get(((List<Object>)o).size()-count);
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("startSymbols")),element.eClass().getEStructuralFeature("startSymbols"),element));
						printCountingMap.put("startSymbols",count-1);
					}
			}
		}
		public void printImport(Import element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("prefix"));
			printCountingMap.put("prefix", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("concreteSyntax"));
			printCountingMap.put("concreteSyntax", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("package"));
			printCountingMap.put("package", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("prefix");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("prefix"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("prefix"),element));
				
				printCountingMap.put("prefix",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(":");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("package");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("package"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("package")),element.eClass().getEStructuralFeature("package"),element));
				printCountingMap.put("package",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
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
		public void printImport_0(Import element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("WITH");
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("SYNTAX");
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("concreteSyntax");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("concreteSyntax"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("concreteSyntax")),element.eClass().getEStructuralFeature("concreteSyntax"),element));
				printCountingMap.put("concreteSyntax",count-1);
			}
		}
		public void printOption(Option element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("value"));
			printCountingMap.put("value", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("=");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("value");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("value"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("value"),element));
				
				printCountingMap.put("value",count-1);
			}
		}
		public void printRule(Rule element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("definition"));
			printCountingMap.put("definition", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("metaclass"));
			printCountingMap.put("metaclass", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("syntax"));
			printCountingMap.put("syntax", temp == null ? 0 : 1);
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
				Object o =element.eGet(element.eClass().getEStructuralFeature("definition"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("definition",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(";");
			//////////////DEFINITION PART BEGINS (LineBreak):
			out.println();
			out.print(localtab);
		}
		public void printRule_0(Rule element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("metaclass"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("metaclass"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
						count = printCountingMap.get("metaclass");
						if(count>0){
							Object o =element.eGet(element.eClass().getEStructuralFeature("metaclass"));
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("QNAME");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("metaclass")),element.eClass().getEStructuralFeature("metaclass"),element));
							printCountingMap.put("metaclass",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("metaclass");
					if(count>0){
						Object o =element.eGet(element.eClass().getEStructuralFeature("metaclass"));
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("metaclass")),element.eClass().getEStructuralFeature("metaclass"),element));
						printCountingMap.put("metaclass",count-1);
					}
			}
		}
		public void printSequence(Sequence element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("parts"));
			printCountingMap.put("parts", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("parts");
			if(count>0){
				ListIterator it  = ((List)element.eGet(element.eClass().getEStructuralFeature("parts"))).listIterator(((List)element.eGet(element.eClass().getEStructuralFeature("parts"))).size()-count);
				while(it.hasNext()){
					Object o = it.next();
					doPrint((EObject)o,out,localtab);
				}
				printCountingMap.put("parts",0);
			}
		}
		public void printChoice(Choice element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("options"));
			printCountingMap.put("options", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("options");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("options"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("options",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			boolean iterate = true;
			while(iterate){
				StringWriter sWriter = new StringWriter();
				PrintWriter out1 = new PrintWriter(sWriter);
				HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
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
		public void printChoice_0(Choice element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("|");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("options");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("options"));
				o = ((List<Object>)o).get(((List<Object>)o).size()-count);
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("options",count-1);
			}
		}
		public void printCsString(CsString element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("cardinality"));
			printCountingMap.put("cardinality", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("value"));
			printCountingMap.put("value", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("value");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("value"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("value"),element));
				
				printCountingMap.put("value",count-1);
			}
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
		}
		public void printDefinedPlaceholder(DefinedPlaceholder element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("cardinality"));
			printCountingMap.put("cardinality", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("feature"));
			printCountingMap.put("feature", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("token"));
			printCountingMap.put("token", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("feature");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("feature"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("feature")),element.eClass().getEStructuralFeature("feature"),element));
				printCountingMap.put("feature",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("[");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("token");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("token"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("token")),element.eClass().getEStructuralFeature("token"),element));
				printCountingMap.put("token",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("]");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("cardinality");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("cardinality"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("cardinality",count-1);
			}
		}
		public void printDerivedPlaceholder(DerivedPlaceholder element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(4);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("cardinality"));
			printCountingMap.put("cardinality", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("feature"));
			printCountingMap.put("feature", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("prefix"));
			printCountingMap.put("prefix", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("suffix"));
			printCountingMap.put("suffix", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("feature");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("feature"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("feature")),element.eClass().getEStructuralFeature("feature"),element));
				printCountingMap.put("feature",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("[");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
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
				Object o =element.eGet(element.eClass().getEStructuralFeature("cardinality"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("cardinality",count-1);
			}
		}
		public void printDerivedPlaceholder_0(DerivedPlaceholder element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("prefix");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("prefix"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("prefix"),element));
				
				printCountingMap.put("prefix",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			StringWriter sWriter = new StringWriter();
			PrintWriter out1 = new PrintWriter(sWriter);
			HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
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
		public void printDerivedPlaceholder_0_0(DerivedPlaceholder element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(",");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("suffix");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("suffix"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suffix"),element));
				
				printCountingMap.put("suffix",count-1);
			}
		}
		public void printContainment(Containment element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("cardinality"));
			printCountingMap.put("cardinality", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("feature"));
			printCountingMap.put("feature", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printContainment_0(element,localtab,out,printCountingMap);
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
		}
		public void printContainment_0(Containment element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			int alt=-1;
			alt=0;
			int matches=matchCount(printCountingMap,Arrays.asList("feature","cardinality"));
			int tempMatchCount;
			tempMatchCount=matchCount(printCountingMap,Arrays.asList("feature"));
			if (tempMatchCount > matches) {
				alt = 1;
				matches = tempMatchCount;
			}
			switch(alt){
				case 1:
					{
						//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
						count = printCountingMap.get("feature");
						if(count>0){
							Object o =element.eGet(element.eClass().getEStructuralFeature("feature"));
							TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("feature")),element.eClass().getEStructuralFeature("feature"),element));
							printCountingMap.put("feature",count-1);
						}
					}
				break;
				default:
					//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
					count = printCountingMap.get("feature");
					if(count>0){
						Object o =element.eGet(element.eClass().getEStructuralFeature("feature"));
						TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(treeAnalyser.deResolve((EObject)o,element,(EReference)element.eClass().getEStructuralFeature("feature")),element.eClass().getEStructuralFeature("feature"),element));
						printCountingMap.put("feature",count-1);
					}
					//////////////DEFINITION PART BEGINS (Containment):
					count = printCountingMap.get("cardinality");
					if(count>0){
						Object o =element.eGet(element.eClass().getEStructuralFeature("cardinality"));
						doPrint((EObject)o,out,localtab);
						printCountingMap.put("cardinality",count-1);
					}
			}
		}
		public void printCompoundDefinition(CompoundDefinition element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("cardinality"));
			printCountingMap.put("cardinality", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("definitions"));
			printCountingMap.put("definitions", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("(");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("definitions");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("definitions"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("definitions",count-1);
			}
			//////////////DEFINITION PART BEGINS (CsString):
			out.print(")");
			//////////////DEFINITION PART BEGINS (Containment):
			count = printCountingMap.get("cardinality");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("cardinality"));
				doPrint((EObject)o,out,localtab);
				printCountingMap.put("cardinality",count-1);
			}
		}
		public void printPLUS(PLUS element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("+");
		}
		public void printSTAR(STAR element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("*");
		}
		public void printQUESTIONMARK(QUESTIONMARK element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("?");
		}
		public void printWhiteSpaces(WhiteSpaces element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("cardinality"));
			printCountingMap.put("cardinality", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("amount"));
			printCountingMap.put("amount", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("amount");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("amount"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT_35_");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("amount"),element));
				
				printCountingMap.put("amount",count-1);
			}
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
		}
		public void printLineBreak(LineBreak element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("cardinality"));
			printCountingMap.put("cardinality", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("tab"));
			printCountingMap.put("tab", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("tab");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("tab"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT_33_");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("tab"),element));
				
				printCountingMap.put("tab",count-1);
			}
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
		}
		public void printNormalToken(NormalToken element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("attributeReferences"));
			printCountingMap.put("attributeReferences", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("regex"));
			printCountingMap.put("regex", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("DEFINE");
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("regex");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("regex"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("regex"),element));
				
				printCountingMap.put("regex",count-1);
			}
		}
		public void printDecoratedToken(DecoratedToken element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("attributeReferences"));
			printCountingMap.put("attributeReferences", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			temp = element.eGet(element.eClass().getEStructuralFeature("regex"));
			printCountingMap.put("regex", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("prefix"));
			printCountingMap.put("prefix", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("suffix"));
			printCountingMap.put("suffix", temp == null ? 0 : 1);
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("DEFINE");
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
				printCountingMap.put("name",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printDecoratedToken_0(element,localtab,out,printCountingMap);
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("regex");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("regex"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("regex"),element));
				
				printCountingMap.put("regex",count-1);
			}
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printDecoratedToken_1(element,localtab,out,printCountingMap);
		}
		public void printDecoratedToken_1(DecoratedToken element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("[");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printDecoratedToken_1_0(element,localtab,out,printCountingMap);
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("]");
		}
		public void printDecoratedToken_0_0(DecoratedToken element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("prefix");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("prefix"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("prefix"),element));
				
				printCountingMap.put("prefix",count-1);
			}
		}
		public void printDecoratedToken_0(DecoratedToken element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("[");
			//////////////DEFINITION PART BEGINS (CompoundDefinition):
			printDecoratedToken_0_0(element,localtab,out,printCountingMap);
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("]");
		}
		public void printDecoratedToken_1_0(DecoratedToken element,String outertab,PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
			String localtab = outertab;
			int count;
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("suffix");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("suffix"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("suffix"),element));
				
				printCountingMap.put("suffix",count-1);
			}
		}
		public void printPreDefinedToken(PreDefinedToken element,String outertab,PrintWriter out){
			String localtab = outertab;
			java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
			Object temp;
			temp = element.eGet(element.eClass().getEStructuralFeature("name"));
			printCountingMap.put("name", temp == null ? 0 : 1);
			temp = element.eGet(element.eClass().getEStructuralFeature("attributeReferences"));
			printCountingMap.put("attributeReferences", temp == null ? 0 : ((java.util.Collection<?>)temp).size());
			int count;
			//////////////DEFINITION PART BEGINS (CsString):
			out.print("PREDEFINED");
			//////////////DEFINITION PART BEGINS (WhiteSpaces):
			out.print(" ");
			//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
			count = printCountingMap.get("name");
			if(count>0){
				Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
				TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object)o,element.eClass().getEStructuralFeature("name"),element));
				
				printCountingMap.put("name",count-1);
			}
		}
		}

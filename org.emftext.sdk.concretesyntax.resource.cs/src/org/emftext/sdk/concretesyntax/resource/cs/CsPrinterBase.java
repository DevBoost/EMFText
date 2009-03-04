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
package org.emftext.sdk.concretesyntax.resource.cs;

public abstract class CsPrinterBase extends org.emftext.runtime.resource.impl.AbstractEMFTextPrinter {
	
	protected org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new CsTokenResolverFactory();
	protected org.emftext.runtime.resource.IReferenceResolverSwitch referenceResolverSwitch = new CsReferenceResolverSwitch();
	
	public CsPrinterBase(java.io.OutputStream o, org.emftext.runtime.resource.ITextResource resource) {
		super(o, resource);
	}
	
	protected static int matchCount(java.util.Map<java.lang.String, java.lang.Integer> featureCounter, java.util.Collection<java.lang.String> needed){
		int pos = 0;
		int neg = 0;
		
		for(java.lang.String featureName:featureCounter.keySet()){
			if(needed.contains(featureName)){
				int value = featureCounter.get(featureName);
				if (value == 0) {
					neg += 1;
				} else {
					pos += 1;
				}
			}
		}
		return neg > 0 ? -neg : pos;
	}
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element, java.io.PrintWriter out, java.lang.String globaltab) {
		if (element == null || out == null) throw new java.lang.NullPointerException("Nothing to write or to write on.");
		
		if (element instanceof org.emftext.sdk.concretesyntax.ConcreteSyntax) {
			print_org_emftext_sdk_concretesyntax_ConcreteSyntax((org.emftext.sdk.concretesyntax.ConcreteSyntax) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.Import) {
			print_org_emftext_sdk_concretesyntax_Import((org.emftext.sdk.concretesyntax.Import) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.Option) {
			print_org_emftext_sdk_concretesyntax_Option((org.emftext.sdk.concretesyntax.Option) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.Rule) {
			print_org_emftext_sdk_concretesyntax_Rule((org.emftext.sdk.concretesyntax.Rule) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.Sequence) {
			print_org_emftext_sdk_concretesyntax_Sequence((org.emftext.sdk.concretesyntax.Sequence) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.Choice) {
			print_org_emftext_sdk_concretesyntax_Choice((org.emftext.sdk.concretesyntax.Choice) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.CsString) {
			print_org_emftext_sdk_concretesyntax_CsString((org.emftext.sdk.concretesyntax.CsString) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.DefinedPlaceholder) {
			print_org_emftext_sdk_concretesyntax_DefinedPlaceholder((org.emftext.sdk.concretesyntax.DefinedPlaceholder) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.DerivedPlaceholder) {
			print_org_emftext_sdk_concretesyntax_DerivedPlaceholder((org.emftext.sdk.concretesyntax.DerivedPlaceholder) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.Containment) {
			print_org_emftext_sdk_concretesyntax_Containment((org.emftext.sdk.concretesyntax.Containment) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.CompoundDefinition) {
			print_org_emftext_sdk_concretesyntax_CompoundDefinition((org.emftext.sdk.concretesyntax.CompoundDefinition) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.WhiteSpaces) {
			print_org_emftext_sdk_concretesyntax_WhiteSpaces((org.emftext.sdk.concretesyntax.WhiteSpaces) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.LineBreak) {
			print_org_emftext_sdk_concretesyntax_LineBreak((org.emftext.sdk.concretesyntax.LineBreak) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.NormalToken) {
			print_org_emftext_sdk_concretesyntax_NormalToken((org.emftext.sdk.concretesyntax.NormalToken) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.PreDefinedToken) {
			print_org_emftext_sdk_concretesyntax_PreDefinedToken((org.emftext.sdk.concretesyntax.PreDefinedToken) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.PLUS) {
			print_org_emftext_sdk_concretesyntax_PLUS((org.emftext.sdk.concretesyntax.PLUS) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.STAR) {
			print_org_emftext_sdk_concretesyntax_STAR((org.emftext.sdk.concretesyntax.STAR) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.QUESTIONMARK) {
			print_org_emftext_sdk_concretesyntax_QUESTIONMARK((org.emftext.sdk.concretesyntax.QUESTIONMARK) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.sdk.concretesyntax.Abstract) {
			print_org_emftext_sdk_concretesyntax_Abstract((org.emftext.sdk.concretesyntax.Abstract) element, globaltab, out);
			return;
		}
		
		resource.addWarning("The cs printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	public void print_org_emftext_sdk_concretesyntax_ConcreteSyntax(org.emftext.sdk.concretesyntax.ConcreteSyntax element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(12);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE));
		printCountingMap.put("package", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT));
		printCountingMap.put("packageLocationHint", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS));
		printCountingMap.put("startSymbols", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ACTIVE_START_SYMBOLS));
		printCountingMap.put("activeStartSymbols", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ALL_START_SYMBOLS));
		printCountingMap.put("allStartSymbols", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS));
		printCountingMap.put("imports", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS));
		printCountingMap.put("options", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS));
		printCountingMap.put("tokens", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES));
		printCountingMap.put("rules", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ALL_RULES));
		printCountingMap.put("allRules", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER));
		printCountingMap.put("modifier", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("modifier");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER));
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("modifier",count-1);
		}
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("SYNTAXDEF");
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME), element));
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
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve(CsReferenceResolverSwitch.getGenPackageDependentElementPackageReferenceResolver().deResolve((org.eclipse.emf.codegen.ecore.genmodel.GenPackage) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE)), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), element));
			printCountingMap.put("package",count-1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_sdk_concretesyntax_ConcreteSyntax_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		//////////////DEFINITION PART BEGINS (LineBreak):
		out.println();
		out.print(localtab);
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_sdk_concretesyntax_ConcreteSyntax_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_sdk_concretesyntax_ConcreteSyntax_2(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_sdk_concretesyntax_ConcreteSyntax_3(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_sdk_concretesyntax_ConcreteSyntax_4(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
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
		print_org_emftext_sdk_concretesyntax_ConcreteSyntax_5(element, localtab, out, printCountingMap);
		//////////////DEFINITION PART BEGINS (LineBreak):
		out.println();
		out.print(localtab);
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("}");
	}
	public void print_org_emftext_sdk_concretesyntax_ConcreteSyntax_1_1_0(org.emftext.sdk.concretesyntax.ConcreteSyntax element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("startSymbols");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS));
			o = ((java.util.List<?>)o).get(((java.util.List<?>)o).size() - count);
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve(CsReferenceResolverSwitch.getConcreteSyntaxStartSymbolsReferenceResolver().deResolve((org.eclipse.emf.codegen.ecore.genmodel.GenClass) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS)), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), element));
			printCountingMap.put("startSymbols",count-1);
		}
	}
	public void print_org_emftext_sdk_concretesyntax_ConcreteSyntax_5(org.emftext.sdk.concretesyntax.ConcreteSyntax element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (LineBreak):
		localtab += "		";
		out.println();
		out.print(localtab);
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("rules");
		if (count > 0) {
			java.util.ListIterator<?> it  = ((java.util.List<?>) element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES))).listIterator(((java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES))).size()-count);
			while(it.hasNext()){
				java.lang.Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("rules",0);
		}
	}
	public void print_org_emftext_sdk_concretesyntax_ConcreteSyntax_1_0(org.emftext.sdk.concretesyntax.ConcreteSyntax element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("startSymbols");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS));
			o = ((java.util.List<?>)o).get(((java.util.List<?>)o).size() - count);
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve(CsReferenceResolverSwitch.getConcreteSyntaxStartSymbolsReferenceResolver().deResolve((org.eclipse.emf.codegen.ecore.genmodel.GenClass) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS)), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), element));
			printCountingMap.put("startSymbols",count-1);
		}
	}
	public void print_org_emftext_sdk_concretesyntax_ConcreteSyntax_3(org.emftext.sdk.concretesyntax.ConcreteSyntax element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
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
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			print_org_emftext_sdk_concretesyntax_ConcreteSyntax_3_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
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
	public void print_org_emftext_sdk_concretesyntax_ConcreteSyntax_2_0(org.emftext.sdk.concretesyntax.ConcreteSyntax element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (LineBreak):
		localtab += "		";
		out.println();
		out.print(localtab);
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("imports");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS));
			o = ((java.util.List<?>)o).get(((java.util.List<?>)o).size() - count);
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("imports",count-1);
		}
	}
	public void print_org_emftext_sdk_concretesyntax_ConcreteSyntax_4(org.emftext.sdk.concretesyntax.ConcreteSyntax element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
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
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			print_org_emftext_sdk_concretesyntax_ConcreteSyntax_4_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
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
	public void print_org_emftext_sdk_concretesyntax_ConcreteSyntax_1_1(org.emftext.sdk.concretesyntax.ConcreteSyntax element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(",");
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		print_org_emftext_sdk_concretesyntax_ConcreteSyntax_1_1_0(element, localtab, out, printCountingMap);
	}
	public void print_org_emftext_sdk_concretesyntax_ConcreteSyntax_2(org.emftext.sdk.concretesyntax.ConcreteSyntax element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
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
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			print_org_emftext_sdk_concretesyntax_ConcreteSyntax_2_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
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
	public void print_org_emftext_sdk_concretesyntax_ConcreteSyntax_4_0(org.emftext.sdk.concretesyntax.ConcreteSyntax element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (LineBreak):
		localtab += "		";
		out.println();
		out.print(localtab);
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("tokens");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS));
			o = ((java.util.List<?>)o).get(((java.util.List<?>)o).size() - count);
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("tokens",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(";");
	}
	public void print_org_emftext_sdk_concretesyntax_ConcreteSyntax_0(org.emftext.sdk.concretesyntax.ConcreteSyntax element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("packageLocationHint");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT), element));
			printCountingMap.put("packageLocationHint",count-1);
		}
	}
	public void print_org_emftext_sdk_concretesyntax_ConcreteSyntax_1(org.emftext.sdk.concretesyntax.ConcreteSyntax element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("START");
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		print_org_emftext_sdk_concretesyntax_ConcreteSyntax_1_0(element, localtab, out, printCountingMap);
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			print_org_emftext_sdk_concretesyntax_ConcreteSyntax_1_1(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	public void print_org_emftext_sdk_concretesyntax_ConcreteSyntax_3_0(org.emftext.sdk.concretesyntax.ConcreteSyntax element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (LineBreak):
		localtab += "		";
		out.println();
		out.print(localtab);
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("options");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS));
			o = ((java.util.List<?>)o).get(((java.util.List<?>)o).size() - count);
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("options",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(";");
	}
	
	public void print_org_emftext_sdk_concretesyntax_Import(org.emftext.sdk.concretesyntax.Import element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(5);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE));
		printCountingMap.put("package", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE_LOCATION_HINT));
		printCountingMap.put("packageLocationHint", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PREFIX));
		printCountingMap.put("prefix", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX));
		printCountingMap.put("concreteSyntax", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT));
		printCountingMap.put("csLocationHint", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("prefix");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PREFIX));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PREFIX), element));
			printCountingMap.put("prefix",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(":");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("package");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve(CsReferenceResolverSwitch.getGenPackageDependentElementPackageReferenceResolver().deResolve((org.eclipse.emf.codegen.ecore.genmodel.GenPackage) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE)), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), element));
			printCountingMap.put("package",count-1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_sdk_concretesyntax_Import_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_sdk_concretesyntax_Import_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	public void print_org_emftext_sdk_concretesyntax_Import_1_0(org.emftext.sdk.concretesyntax.Import element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("csLocationHint");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT), element));
			printCountingMap.put("csLocationHint",count-1);
		}
	}
	public void print_org_emftext_sdk_concretesyntax_Import_0(org.emftext.sdk.concretesyntax.Import element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("packageLocationHint");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE_LOCATION_HINT));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE_LOCATION_HINT), element));
			printCountingMap.put("packageLocationHint",count-1);
		}
	}
	public void print_org_emftext_sdk_concretesyntax_Import_1(org.emftext.sdk.concretesyntax.Import element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
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
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve(CsReferenceResolverSwitch.getImportConcreteSyntaxReferenceResolver().deResolve((org.emftext.sdk.concretesyntax.ConcreteSyntax) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX)), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), element));
			printCountingMap.put("concreteSyntax",count-1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_sdk_concretesyntax_Import_1_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_org_emftext_sdk_concretesyntax_Option(org.emftext.sdk.concretesyntax.Option element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__NAME));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__NAME), element));
			printCountingMap.put("name",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("=");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__VALUE));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__VALUE), element));
			printCountingMap.put("value",count-1);
		}
	}
	
	public void print_org_emftext_sdk_concretesyntax_Rule(org.emftext.sdk.concretesyntax.Rule element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__DEFINITION));
		printCountingMap.put("definition", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS));
		printCountingMap.put("metaclass", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__SYNTAX));
		printCountingMap.put("syntax", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (LineBreak):
		out.println();
		out.print(localtab);
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("metaclass");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve(CsReferenceResolverSwitch.getRuleMetaclassReferenceResolver().deResolve((org.eclipse.emf.codegen.ecore.genmodel.GenClass) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS)), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), element));
			printCountingMap.put("metaclass",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("::=");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("definition");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__DEFINITION));
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("definition",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(";");
		//////////////DEFINITION PART BEGINS (LineBreak):
		out.println();
		out.print(localtab);
	}
	
	public void print_org_emftext_sdk_concretesyntax_Sequence(org.emftext.sdk.concretesyntax.Sequence element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.SEQUENCE__PARTS));
		printCountingMap.put("parts", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("parts");
		if (count > 0) {
			java.util.ListIterator<?> it  = ((java.util.List<?>) element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.SEQUENCE__PARTS))).listIterator(((java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.SEQUENCE__PARTS))).size()-count);
			while(it.hasNext()){
				java.lang.Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("parts",0);
		}
	}
	
	public void print_org_emftext_sdk_concretesyntax_Choice(org.emftext.sdk.concretesyntax.Choice element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS));
		printCountingMap.put("options", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("options");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS));
			o = ((java.util.List<?>)o).get(((java.util.List<?>)o).size() - count);
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("options",count-1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			print_org_emftext_sdk_concretesyntax_Choice_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
	}
	public void print_org_emftext_sdk_concretesyntax_Choice_0(org.emftext.sdk.concretesyntax.Choice element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("|");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("options");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS));
			o = ((java.util.List<?>)o).get(((java.util.List<?>)o).size() - count);
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("options",count-1);
		}
	}
	
	public void print_org_emftext_sdk_concretesyntax_CsString(org.emftext.sdk.concretesyntax.CsString element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CS_STRING__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CS_STRING__VALUE));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CS_STRING__VALUE), element));
			printCountingMap.put("value",count-1);
		}
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
	}
	
	public void print_org_emftext_sdk_concretesyntax_DefinedPlaceholder(org.emftext.sdk.concretesyntax.DefinedPlaceholder element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__CARDINALITY));
		printCountingMap.put("cardinality", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__FEATURE));
		printCountingMap.put("feature", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__TOKEN));
		printCountingMap.put("token", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("feature");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__FEATURE));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve(CsReferenceResolverSwitch.getTerminalFeatureReferenceResolver().deResolve((org.eclipse.emf.codegen.ecore.genmodel.GenFeature) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__FEATURE)), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__FEATURE), element));
			printCountingMap.put("feature",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("[");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("token");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__TOKEN));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve(CsReferenceResolverSwitch.getDefinedPlaceholderTokenReferenceResolver().deResolve((org.emftext.sdk.concretesyntax.TokenDefinition) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__TOKEN)), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__TOKEN), element));
			printCountingMap.put("token",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("]");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("cardinality");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__CARDINALITY));
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("cardinality",count-1);
		}
	}
	
	public void print_org_emftext_sdk_concretesyntax_DerivedPlaceholder(org.emftext.sdk.concretesyntax.DerivedPlaceholder element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(4);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__CARDINALITY));
		printCountingMap.put("cardinality", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__FEATURE));
		printCountingMap.put("feature", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__PREFIX));
		printCountingMap.put("prefix", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__SUFFIX));
		printCountingMap.put("suffix", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("feature");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__FEATURE));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve(CsReferenceResolverSwitch.getTerminalFeatureReferenceResolver().deResolve((org.eclipse.emf.codegen.ecore.genmodel.GenFeature) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__FEATURE)), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__FEATURE), element));
			printCountingMap.put("feature",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("[");
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_sdk_concretesyntax_DerivedPlaceholder_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
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
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__CARDINALITY));
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("cardinality",count-1);
		}
	}
	public void print_org_emftext_sdk_concretesyntax_DerivedPlaceholder_0(org.emftext.sdk.concretesyntax.DerivedPlaceholder element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("prefix");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__PREFIX));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__PREFIX), element));
			printCountingMap.put("prefix",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(",");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("suffix");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__SUFFIX));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__SUFFIX), element));
			printCountingMap.put("suffix",count-1);
		}
	}
	
	public void print_org_emftext_sdk_concretesyntax_Containment(org.emftext.sdk.concretesyntax.Containment element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY));
		printCountingMap.put("cardinality", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE));
		printCountingMap.put("feature", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES));
		printCountingMap.put("types", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("feature");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve(CsReferenceResolverSwitch.getTerminalFeatureReferenceResolver().deResolve((org.eclipse.emf.codegen.ecore.genmodel.GenFeature) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE)), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), element));
			printCountingMap.put("feature",count-1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_sdk_concretesyntax_Containment_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("cardinality");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY));
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("cardinality",count-1);
		}
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
	}
	public void print_org_emftext_sdk_concretesyntax_Containment_0_0(org.emftext.sdk.concretesyntax.Containment element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(",");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("types");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES));
			o = ((java.util.List<?>)o).get(((java.util.List<?>)o).size() - count);
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve(CsReferenceResolverSwitch.getContainmentTypesReferenceResolver().deResolve((org.eclipse.emf.codegen.ecore.genmodel.GenClass) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES)), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), element));
			printCountingMap.put("types",count-1);
		}
	}
	public void print_org_emftext_sdk_concretesyntax_Containment_0(org.emftext.sdk.concretesyntax.Containment element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(":");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("types");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES));
			o = ((java.util.List<?>)o).get(((java.util.List<?>)o).size() - count);
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve(CsReferenceResolverSwitch.getContainmentTypesReferenceResolver().deResolve((org.eclipse.emf.codegen.ecore.genmodel.GenClass) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES)), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), element));
			printCountingMap.put("types",count-1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			print_org_emftext_sdk_concretesyntax_Containment_0_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_org_emftext_sdk_concretesyntax_CompoundDefinition(org.emftext.sdk.concretesyntax.CompoundDefinition element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY));
		printCountingMap.put("cardinality", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__DEFINITIONS));
		printCountingMap.put("definitions", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("(");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("definitions");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__DEFINITIONS));
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("definitions",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(")");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("cardinality");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY));
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("cardinality",count-1);
		}
	}
	
	public void print_org_emftext_sdk_concretesyntax_WhiteSpaces(org.emftext.sdk.concretesyntax.WhiteSpaces element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.WHITE_SPACES__AMOUNT));
		printCountingMap.put("amount", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("#");
		//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
		count = printCountingMap.get("amount");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.WHITE_SPACES__AMOUNT));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("NUMBER");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.WHITE_SPACES__AMOUNT), element));
			printCountingMap.put("amount",count-1);
		}
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
	}
	
	public void print_org_emftext_sdk_concretesyntax_LineBreak(org.emftext.sdk.concretesyntax.LineBreak element, java.lang.String outertab, java.io.PrintWriter out) {
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB));
		printCountingMap.put("tab", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("!");
		//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
		count = printCountingMap.get("tab");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("NUMBER");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB), element));
			printCountingMap.put("tab",count-1);
		}
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
	}
	
	public void print_org_emftext_sdk_concretesyntax_NormalToken(org.emftext.sdk.concretesyntax.NormalToken element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(4);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__ATTRIBUTE_REFERENCES));
		printCountingMap.put("attributeReferences", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__ATTRIBUTE_NAME));
		printCountingMap.put("attributeName", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__REGEX));
		printCountingMap.put("regex", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("DEFINE");
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__NAME));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__NAME), element));
			printCountingMap.put("name",count-1);
		}
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("regex");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__REGEX));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__REGEX), element));
			printCountingMap.put("regex",count-1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_sdk_concretesyntax_NormalToken_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	public void print_org_emftext_sdk_concretesyntax_NormalToken_0(org.emftext.sdk.concretesyntax.NormalToken element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("COLLECT");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("IN");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("attributeName");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__ATTRIBUTE_NAME));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__ATTRIBUTE_NAME), element));
			printCountingMap.put("attributeName",count-1);
		}
	}
	
	public void print_org_emftext_sdk_concretesyntax_PreDefinedToken(org.emftext.sdk.concretesyntax.PreDefinedToken element, java.lang.String outertab, java.io.PrintWriter out) {
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PRE_DEFINED_TOKEN__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PRE_DEFINED_TOKEN__ATTRIBUTE_REFERENCES));
		printCountingMap.put("attributeReferences", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PRE_DEFINED_TOKEN__ATTRIBUTE_NAME));
		printCountingMap.put("attributeName", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = null;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("PREDEFINED");
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PRE_DEFINED_TOKEN__NAME));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PRE_DEFINED_TOKEN__NAME), element));
			printCountingMap.put("name",count-1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_sdk_concretesyntax_PreDefinedToken_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	public void print_org_emftext_sdk_concretesyntax_PreDefinedToken_0(org.emftext.sdk.concretesyntax.PreDefinedToken element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("COLLECT");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("IN");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("attributeName");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PRE_DEFINED_TOKEN__ATTRIBUTE_NAME));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
			resolver.setOptions(getOptions());
			out.print(resolver.deResolve((java.lang.Object) o, element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PRE_DEFINED_TOKEN__ATTRIBUTE_NAME), element));
			printCountingMap.put("attributeName",count-1);
		}
	}
	
	public void print_org_emftext_sdk_concretesyntax_PLUS(org.emftext.sdk.concretesyntax.PLUS element, java.lang.String outertab, java.io.PrintWriter out) {
		// print collected hidden tokens
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("+");
	}
	
	public void print_org_emftext_sdk_concretesyntax_STAR(org.emftext.sdk.concretesyntax.STAR element, java.lang.String outertab, java.io.PrintWriter out) {
		// print collected hidden tokens
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("*");
	}
	
	public void print_org_emftext_sdk_concretesyntax_QUESTIONMARK(org.emftext.sdk.concretesyntax.QUESTIONMARK element, java.lang.String outertab, java.io.PrintWriter out) {
		// print collected hidden tokens
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("?");
	}
	
	public void print_org_emftext_sdk_concretesyntax_Abstract(org.emftext.sdk.concretesyntax.Abstract element, java.lang.String outertab, java.io.PrintWriter out) {
		// print collected hidden tokens
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("ABSTRACT");
	}
	
}

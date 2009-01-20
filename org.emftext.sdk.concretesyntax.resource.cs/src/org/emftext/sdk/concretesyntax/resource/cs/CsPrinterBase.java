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

		if(element instanceof org.emftext.sdk.concretesyntax.ConcreteSyntax){
			print_org_emftext_sdk_concretesyntax_ConcreteSyntax((org.emftext.sdk.concretesyntax.ConcreteSyntax) element, globaltab, out);
			return;
		}
		if(element instanceof org.emftext.sdk.concretesyntax.Import){
			print_org_emftext_sdk_concretesyntax_Import((org.emftext.sdk.concretesyntax.Import) element, globaltab, out);
			return;
		}
		if(element instanceof org.emftext.sdk.concretesyntax.Option){
			print_org_emftext_sdk_concretesyntax_Option((org.emftext.sdk.concretesyntax.Option) element, globaltab, out);
			return;
		}
		if(element instanceof org.emftext.sdk.concretesyntax.Rule){
			print_org_emftext_sdk_concretesyntax_Rule((org.emftext.sdk.concretesyntax.Rule) element, globaltab, out);
			return;
		}
		if(element instanceof org.emftext.sdk.concretesyntax.Sequence){
			print_org_emftext_sdk_concretesyntax_Sequence((org.emftext.sdk.concretesyntax.Sequence) element, globaltab, out);
			return;
		}
		if(element instanceof org.emftext.sdk.concretesyntax.Choice){
			print_org_emftext_sdk_concretesyntax_Choice((org.emftext.sdk.concretesyntax.Choice) element, globaltab, out);
			return;
		}
		if(element instanceof org.emftext.sdk.concretesyntax.CsString){
			print_org_emftext_sdk_concretesyntax_CsString((org.emftext.sdk.concretesyntax.CsString) element, globaltab, out);
			return;
		}
		if(element instanceof org.emftext.sdk.concretesyntax.DefinedPlaceholder){
			print_org_emftext_sdk_concretesyntax_DefinedPlaceholder((org.emftext.sdk.concretesyntax.DefinedPlaceholder) element, globaltab, out);
			return;
		}
		if(element instanceof org.emftext.sdk.concretesyntax.DerivedPlaceholder){
			print_org_emftext_sdk_concretesyntax_DerivedPlaceholder((org.emftext.sdk.concretesyntax.DerivedPlaceholder) element, globaltab, out);
			return;
		}
		if(element instanceof org.emftext.sdk.concretesyntax.Containment){
			print_org_emftext_sdk_concretesyntax_Containment((org.emftext.sdk.concretesyntax.Containment) element, globaltab, out);
			return;
		}
		if(element instanceof org.emftext.sdk.concretesyntax.CompoundDefinition){
			print_org_emftext_sdk_concretesyntax_CompoundDefinition((org.emftext.sdk.concretesyntax.CompoundDefinition) element, globaltab, out);
			return;
		}
		if(element instanceof org.emftext.sdk.concretesyntax.PLUS){
			print_org_emftext_sdk_concretesyntax_PLUS((org.emftext.sdk.concretesyntax.PLUS) element, globaltab, out);
			return;
		}
		if(element instanceof org.emftext.sdk.concretesyntax.STAR){
			print_org_emftext_sdk_concretesyntax_STAR((org.emftext.sdk.concretesyntax.STAR) element, globaltab, out);
			return;
		}
		if(element instanceof org.emftext.sdk.concretesyntax.QUESTIONMARK){
			print_org_emftext_sdk_concretesyntax_QUESTIONMARK((org.emftext.sdk.concretesyntax.QUESTIONMARK) element, globaltab, out);
			return;
		}
		if(element instanceof org.emftext.sdk.concretesyntax.WhiteSpaces){
			print_org_emftext_sdk_concretesyntax_WhiteSpaces((org.emftext.sdk.concretesyntax.WhiteSpaces) element, globaltab, out);
			return;
		}
		if(element instanceof org.emftext.sdk.concretesyntax.LineBreak){
			print_org_emftext_sdk_concretesyntax_LineBreak((org.emftext.sdk.concretesyntax.LineBreak) element, globaltab, out);
			return;
		}
		if(element instanceof org.emftext.sdk.concretesyntax.NormalToken){
			print_org_emftext_sdk_concretesyntax_NormalToken((org.emftext.sdk.concretesyntax.NormalToken) element, globaltab, out);
			return;
		}
		if(element instanceof org.emftext.sdk.concretesyntax.DecoratedToken){
			print_org_emftext_sdk_concretesyntax_DecoratedToken((org.emftext.sdk.concretesyntax.DecoratedToken) element, globaltab, out);
			return;
		}
		if(element instanceof org.emftext.sdk.concretesyntax.PreDefinedToken){
			print_org_emftext_sdk_concretesyntax_PreDefinedToken((org.emftext.sdk.concretesyntax.PreDefinedToken) element, globaltab, out);
			return;
		}

		resource.addWarning("The cs printer can not handle " + element.eClass().getName() + " elements", element);
	}

	public void print_org_emftext_sdk_concretesyntax_ConcreteSyntax(org.emftext.sdk.concretesyntax.ConcreteSyntax element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(8);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature("name"));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("package"));
		printCountingMap.put("package", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("imports"));
		printCountingMap.put("imports", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature("startSymbols"));
		printCountingMap.put("startSymbols", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature("rules"));
		printCountingMap.put("rules", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature("allRules"));
		printCountingMap.put("allRules", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature("tokens"));
		printCountingMap.put("tokens", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature("options"));
		printCountingMap.put("options", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("SYNTAXDEF");
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("name");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object)o,element.eClass().getEStructuralFeature("name"),element));
				
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
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");resolver.setOptions(getOptions());out.print(resolver.deResolve(referenceResolverSwitch.deResolve((org.eclipse.emf.ecore.EObject)o, element, (org.eclipse.emf.ecore.EReference)element.eClass().getEStructuralFeature("package")),element.eClass().getEStructuralFeature("package"),element));
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
		print_org_emftext_sdk_concretesyntax_ConcreteSyntax_0(element,localtab,out,printCountingMap);
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		boolean iterate = true;
		while(iterate){
			java.io.StringWriter sWriter = new java.io.StringWriter();
			java.io.PrintWriter out1 = new java.io.PrintWriter(sWriter);
			java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			print_org_emftext_sdk_concretesyntax_ConcreteSyntax_1(element,localtab,out1,printCountingMap1);
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
		java.io.StringWriter sWriter = new java.io.StringWriter();
		java.io.PrintWriter out1 = new java.io.PrintWriter(sWriter);
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_sdk_concretesyntax_ConcreteSyntax_2(element,localtab,out1,printCountingMap1);
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
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_sdk_concretesyntax_ConcreteSyntax_3(element,localtab,out1,printCountingMap1);
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
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_sdk_concretesyntax_ConcreteSyntax_4(element,localtab,out1,printCountingMap1);
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
		print_org_emftext_sdk_concretesyntax_ConcreteSyntax_5(element,localtab,out,printCountingMap);
		//////////////DEFINITION PART BEGINS (LineBreak):
		out.println();
		out.print(localtab);
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("}");
	}
	public void print_org_emftext_sdk_concretesyntax_ConcreteSyntax_4(org.emftext.sdk.concretesyntax.ConcreteSyntax element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
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
			java.io.StringWriter sWriter = new java.io.StringWriter();
			java.io.PrintWriter out1 = new java.io.PrintWriter(sWriter);
			java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			print_org_emftext_sdk_concretesyntax_ConcreteSyntax_4_0(element,localtab,out1,printCountingMap1);
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
	public void print_org_emftext_sdk_concretesyntax_ConcreteSyntax_3_0(org.emftext.sdk.concretesyntax.ConcreteSyntax element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (LineBreak):
		localtab += "		";
		out.println();
		out.print(localtab);
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("options");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("options"));
			o = ((java.util.List<?>)o).get(((java.util.List<?>)o).size() - count);
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("options",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(";");
	}
	public void print_org_emftext_sdk_concretesyntax_ConcreteSyntax_2(org.emftext.sdk.concretesyntax.ConcreteSyntax element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
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
			java.io.StringWriter sWriter = new java.io.StringWriter();
			java.io.PrintWriter out1 = new java.io.PrintWriter(sWriter);
			java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			print_org_emftext_sdk_concretesyntax_ConcreteSyntax_2_0(element,localtab,out1,printCountingMap1);
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
	public void print_org_emftext_sdk_concretesyntax_ConcreteSyntax_4_0(org.emftext.sdk.concretesyntax.ConcreteSyntax element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (LineBreak):
		localtab += "		";
		out.println();
		out.print(localtab);
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("tokens");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("tokens"));
			o = ((java.util.List<?>)o).get(((java.util.List<?>)o).size() - count);
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("tokens",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(";");
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
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("imports"));
			o = ((java.util.List<?>)o).get(((java.util.List<?>)o).size() - count);
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("imports",count-1);
		}
	}
	public void print_org_emftext_sdk_concretesyntax_ConcreteSyntax_0(org.emftext.sdk.concretesyntax.ConcreteSyntax element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		int alt=-1;
		alt=0;
		int matches=matchCount(printCountingMap, java.util.Arrays.asList("startSymbols"));
		int tempMatchCount;
		tempMatchCount=matchCount(printCountingMap, java.util.Arrays.asList("startSymbols"));
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
						o = ((java.util.List<?>)o).get(((java.util.List<?>)o).size() - count);
						org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QNAME");resolver.setOptions(getOptions());out.print(resolver.deResolve(referenceResolverSwitch.deResolve((org.eclipse.emf.ecore.EObject)o, element, (org.eclipse.emf.ecore.EReference)element.eClass().getEStructuralFeature("startSymbols")),element.eClass().getEStructuralFeature("startSymbols"),element));
						printCountingMap.put("startSymbols",count-1);
					}
				}
			break;
			default:
				//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
				count = printCountingMap.get("startSymbols");
				if(count>0){
					Object o =element.eGet(element.eClass().getEStructuralFeature("startSymbols"));
					o = ((java.util.List<?>)o).get(((java.util.List<?>)o).size() - count);
					org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(referenceResolverSwitch.deResolve((org.eclipse.emf.ecore.EObject)o, element, (org.eclipse.emf.ecore.EReference)element.eClass().getEStructuralFeature("startSymbols")),element.eClass().getEStructuralFeature("startSymbols"),element));
					printCountingMap.put("startSymbols",count-1);
				}
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
		if(count>0){
			java.util.ListIterator<?> it  = ((java.util.List<?>) element.eGet(element.eClass().getEStructuralFeature("rules"))).listIterator(((java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature("rules"))).size()-count);
			while(it.hasNext()){
				java.lang.Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("rules",0);
		}
	}
	public void print_org_emftext_sdk_concretesyntax_ConcreteSyntax_1(org.emftext.sdk.concretesyntax.ConcreteSyntax element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(",");
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		print_org_emftext_sdk_concretesyntax_ConcreteSyntax_1_0(element,localtab,out,printCountingMap);
	}
	public void print_org_emftext_sdk_concretesyntax_ConcreteSyntax_3(org.emftext.sdk.concretesyntax.ConcreteSyntax element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
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
			java.io.StringWriter sWriter = new java.io.StringWriter();
			java.io.PrintWriter out1 = new java.io.PrintWriter(sWriter);
			java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			print_org_emftext_sdk_concretesyntax_ConcreteSyntax_3_0(element,localtab,out1,printCountingMap1);
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
	public void print_org_emftext_sdk_concretesyntax_ConcreteSyntax_1_0(org.emftext.sdk.concretesyntax.ConcreteSyntax element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		int alt=-1;
		alt=0;
		int matches=matchCount(printCountingMap, java.util.Arrays.asList("startSymbols"));
		int tempMatchCount;
		tempMatchCount=matchCount(printCountingMap, java.util.Arrays.asList("startSymbols"));
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
						o = ((java.util.List<?>)o).get(((java.util.List<?>)o).size() - count);
						org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QNAME");resolver.setOptions(getOptions());out.print(resolver.deResolve(referenceResolverSwitch.deResolve((org.eclipse.emf.ecore.EObject)o, element, (org.eclipse.emf.ecore.EReference)element.eClass().getEStructuralFeature("startSymbols")),element.eClass().getEStructuralFeature("startSymbols"),element));
						printCountingMap.put("startSymbols",count-1);
					}
				}
			break;
			default:
				//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
				count = printCountingMap.get("startSymbols");
				if(count>0){
					Object o =element.eGet(element.eClass().getEStructuralFeature("startSymbols"));
					o = ((java.util.List<?>)o).get(((java.util.List<?>)o).size() - count);
					org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(referenceResolverSwitch.deResolve((org.eclipse.emf.ecore.EObject)o, element, (org.eclipse.emf.ecore.EReference)element.eClass().getEStructuralFeature("startSymbols")),element.eClass().getEStructuralFeature("startSymbols"),element));
					printCountingMap.put("startSymbols",count-1);
				}
		}
	}

	public void print_org_emftext_sdk_concretesyntax_Import(org.emftext.sdk.concretesyntax.Import element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature("prefix"));
		printCountingMap.put("prefix", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("concreteSyntax"));
		printCountingMap.put("concreteSyntax", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("package"));
		printCountingMap.put("package", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("prefix");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("prefix"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object)o,element.eClass().getEStructuralFeature("prefix"),element));
				
			printCountingMap.put("prefix",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(":");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("package");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("package"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");resolver.setOptions(getOptions());out.print(resolver.deResolve(referenceResolverSwitch.deResolve((org.eclipse.emf.ecore.EObject)o, element, (org.eclipse.emf.ecore.EReference)element.eClass().getEStructuralFeature("package")),element.eClass().getEStructuralFeature("package"),element));
			printCountingMap.put("package",count-1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		java.io.StringWriter sWriter = new java.io.StringWriter();
		java.io.PrintWriter out1 = new java.io.PrintWriter(sWriter);
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_sdk_concretesyntax_Import_0(element,localtab,out1,printCountingMap1);
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
	public void print_org_emftext_sdk_concretesyntax_Import_0(org.emftext.sdk.concretesyntax.Import element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
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
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(referenceResolverSwitch.deResolve((org.eclipse.emf.ecore.EObject)o, element, (org.eclipse.emf.ecore.EReference)element.eClass().getEStructuralFeature("concreteSyntax")),element.eClass().getEStructuralFeature("concreteSyntax"),element));
			printCountingMap.put("concreteSyntax",count-1);
		}
	}

	public void print_org_emftext_sdk_concretesyntax_Option(org.emftext.sdk.concretesyntax.Option element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature("name"));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("value"));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("name");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object)o,element.eClass().getEStructuralFeature("name"),element));
				
			printCountingMap.put("name",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("=");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("value");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("value"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object)o,element.eClass().getEStructuralFeature("value"),element));
				
			printCountingMap.put("value",count-1);
		}
	}

	public void print_org_emftext_sdk_concretesyntax_Rule(org.emftext.sdk.concretesyntax.Rule element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature("definition"));
		printCountingMap.put("definition", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("metaclass"));
		printCountingMap.put("metaclass", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("syntax"));
		printCountingMap.put("syntax", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (LineBreak):
		out.println();
		out.print(localtab);
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		print_org_emftext_sdk_concretesyntax_Rule_0(element,localtab,out,printCountingMap);
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("::=");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("definition");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("definition"));
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("definition",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(";");
		//////////////DEFINITION PART BEGINS (LineBreak):
		out.println();
		out.print(localtab);
	}
	public void print_org_emftext_sdk_concretesyntax_Rule_0(org.emftext.sdk.concretesyntax.Rule element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		int alt=-1;
		alt=0;
		int matches=matchCount(printCountingMap, java.util.Arrays.asList("metaclass"));
		int tempMatchCount;
		tempMatchCount=matchCount(printCountingMap, java.util.Arrays.asList("metaclass"));
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
						org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QNAME");resolver.setOptions(getOptions());out.print(resolver.deResolve(referenceResolverSwitch.deResolve((org.eclipse.emf.ecore.EObject)o, element, (org.eclipse.emf.ecore.EReference)element.eClass().getEStructuralFeature("metaclass")),element.eClass().getEStructuralFeature("metaclass"),element));
						printCountingMap.put("metaclass",count-1);
					}
				}
			break;
			default:
				//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
				count = printCountingMap.get("metaclass");
				if(count>0){
					Object o =element.eGet(element.eClass().getEStructuralFeature("metaclass"));
					org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(referenceResolverSwitch.deResolve((org.eclipse.emf.ecore.EObject)o, element, (org.eclipse.emf.ecore.EReference)element.eClass().getEStructuralFeature("metaclass")),element.eClass().getEStructuralFeature("metaclass"),element));
					printCountingMap.put("metaclass",count-1);
				}
		}
	}

	public void print_org_emftext_sdk_concretesyntax_Sequence(org.emftext.sdk.concretesyntax.Sequence element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature("parts"));
		printCountingMap.put("parts", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("parts");
		if(count>0){
			java.util.ListIterator<?> it  = ((java.util.List<?>) element.eGet(element.eClass().getEStructuralFeature("parts"))).listIterator(((java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature("parts"))).size()-count);
			while(it.hasNext()){
				java.lang.Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("parts",0);
		}
	}

	public void print_org_emftext_sdk_concretesyntax_Choice(org.emftext.sdk.concretesyntax.Choice element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(1);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature("options"));
		printCountingMap.put("options", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("options");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("options"));
			o = ((java.util.List<?>)o).get(((java.util.List<?>)o).size() - count);
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("options",count-1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		boolean iterate = true;
		while(iterate){
			java.io.StringWriter sWriter = new java.io.StringWriter();
			java.io.PrintWriter out1 = new java.io.PrintWriter(sWriter);
			java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
			print_org_emftext_sdk_concretesyntax_Choice_0(element,localtab,out1,printCountingMap1);
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
	public void print_org_emftext_sdk_concretesyntax_Choice_0(org.emftext.sdk.concretesyntax.Choice element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("|");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("options");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("options"));
			o = ((java.util.List<?>)o).get(((java.util.List<?>)o).size() - count);
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("options",count-1);
		}
	}

	public void print_org_emftext_sdk_concretesyntax_CsString(org.emftext.sdk.concretesyntax.CsString element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature("cardinality"));
		printCountingMap.put("cardinality", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("value"));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("value");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("value"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object)o,element.eClass().getEStructuralFeature("value"),element));
				
			printCountingMap.put("value",count-1);
		}
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
	}

	public void print_org_emftext_sdk_concretesyntax_DefinedPlaceholder(org.emftext.sdk.concretesyntax.DefinedPlaceholder element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature("cardinality"));
		printCountingMap.put("cardinality", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("feature"));
		printCountingMap.put("feature", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("token"));
		printCountingMap.put("token", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("feature");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("feature"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(referenceResolverSwitch.deResolve((org.eclipse.emf.ecore.EObject)o, element, (org.eclipse.emf.ecore.EReference)element.eClass().getEStructuralFeature("feature")),element.eClass().getEStructuralFeature("feature"),element));
			printCountingMap.put("feature",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("[");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("token");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("token"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(referenceResolverSwitch.deResolve((org.eclipse.emf.ecore.EObject)o, element, (org.eclipse.emf.ecore.EReference)element.eClass().getEStructuralFeature("token")),element.eClass().getEStructuralFeature("token"),element));
			printCountingMap.put("token",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("]");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("cardinality");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("cardinality"));
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("cardinality",count-1);
		}
	}

	public void print_org_emftext_sdk_concretesyntax_DerivedPlaceholder(org.emftext.sdk.concretesyntax.DerivedPlaceholder element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(4);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature("cardinality"));
		printCountingMap.put("cardinality", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("feature"));
		printCountingMap.put("feature", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("prefix"));
		printCountingMap.put("prefix", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("suffix"));
		printCountingMap.put("suffix", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("feature");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("feature"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(referenceResolverSwitch.deResolve((org.eclipse.emf.ecore.EObject)o, element, (org.eclipse.emf.ecore.EReference)element.eClass().getEStructuralFeature("feature")),element.eClass().getEStructuralFeature("feature"),element));
			printCountingMap.put("feature",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("[");
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		java.io.StringWriter sWriter = new java.io.StringWriter();
		java.io.PrintWriter out1 = new java.io.PrintWriter(sWriter);
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_sdk_concretesyntax_DerivedPlaceholder_0(element,localtab,out1,printCountingMap1);
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
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("cardinality",count-1);
		}
	}
	public void print_org_emftext_sdk_concretesyntax_DerivedPlaceholder_0_0(org.emftext.sdk.concretesyntax.DerivedPlaceholder element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(",");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("suffix");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("suffix"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object)o,element.eClass().getEStructuralFeature("suffix"),element));
				
			printCountingMap.put("suffix",count-1);
		}
	}
	public void print_org_emftext_sdk_concretesyntax_DerivedPlaceholder_0(org.emftext.sdk.concretesyntax.DerivedPlaceholder element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("prefix");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("prefix"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object)o,element.eClass().getEStructuralFeature("prefix"),element));
				
			printCountingMap.put("prefix",count-1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		java.io.StringWriter sWriter = new java.io.StringWriter();
		java.io.PrintWriter out1 = new java.io.PrintWriter(sWriter);
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_sdk_concretesyntax_DerivedPlaceholder_0_0(element,localtab,out1,printCountingMap1);
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

	public void print_org_emftext_sdk_concretesyntax_Containment(org.emftext.sdk.concretesyntax.Containment element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature("cardinality"));
		printCountingMap.put("cardinality", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("feature"));
		printCountingMap.put("feature", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("type"));
		printCountingMap.put("type", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("feature");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("feature"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(referenceResolverSwitch.deResolve((org.eclipse.emf.ecore.EObject)o, element, (org.eclipse.emf.ecore.EReference)element.eClass().getEStructuralFeature("feature")),element.eClass().getEStructuralFeature("feature"),element));
			printCountingMap.put("feature",count-1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		java.io.StringWriter sWriter = new java.io.StringWriter();
		java.io.PrintWriter out1 = new java.io.PrintWriter(sWriter);
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_sdk_concretesyntax_Containment_0(element,localtab,out1,printCountingMap1);
		if(printCountingMap.equals(printCountingMap1)){
			out1.close();
		}
		else{
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("cardinality");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("cardinality"));
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("cardinality",count-1);
		}
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
	}
	public void print_org_emftext_sdk_concretesyntax_Containment_0(org.emftext.sdk.concretesyntax.Containment element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(":");
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		print_org_emftext_sdk_concretesyntax_Containment_0_0(element,localtab,out,printCountingMap);
	}
	public void print_org_emftext_sdk_concretesyntax_Containment_0_0(org.emftext.sdk.concretesyntax.Containment element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		int alt=-1;
		alt=0;
		int matches=matchCount(printCountingMap, java.util.Arrays.asList("type"));
		int tempMatchCount;
		tempMatchCount=matchCount(printCountingMap, java.util.Arrays.asList("type"));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt){
			case 1:
				{
					//////////////DEFINITION PART BEGINS (DefinedPlaceholder):
					count = printCountingMap.get("type");
					if(count>0){
						Object o =element.eGet(element.eClass().getEStructuralFeature("type"));
						org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QNAME");resolver.setOptions(getOptions());out.print(resolver.deResolve(referenceResolverSwitch.deResolve((org.eclipse.emf.ecore.EObject)o, element, (org.eclipse.emf.ecore.EReference)element.eClass().getEStructuralFeature("type")),element.eClass().getEStructuralFeature("type"),element));
						printCountingMap.put("type",count-1);
					}
				}
			break;
			default:
				//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
				count = printCountingMap.get("type");
				if(count>0){
					Object o =element.eGet(element.eClass().getEStructuralFeature("type"));
					org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");resolver.setOptions(getOptions());out.print(resolver.deResolve(referenceResolverSwitch.deResolve((org.eclipse.emf.ecore.EObject)o, element, (org.eclipse.emf.ecore.EReference)element.eClass().getEStructuralFeature("type")),element.eClass().getEStructuralFeature("type"),element));
					printCountingMap.put("type",count-1);
				}
		}
	}

	public void print_org_emftext_sdk_concretesyntax_CompoundDefinition(org.emftext.sdk.concretesyntax.CompoundDefinition element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature("cardinality"));
		printCountingMap.put("cardinality", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("definitions"));
		printCountingMap.put("definitions", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("(");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("definitions");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("definitions"));
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("definitions",count-1);
		}
		//////////////DEFINITION PART BEGINS (CsString):
		out.print(")");
		//////////////DEFINITION PART BEGINS (Containment):
		count = printCountingMap.get("cardinality");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("cardinality"));
			doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			printCountingMap.put("cardinality",count-1);
		}
	}

	public void print_org_emftext_sdk_concretesyntax_PLUS(org.emftext.sdk.concretesyntax.PLUS element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("+");
	}

	public void print_org_emftext_sdk_concretesyntax_STAR(org.emftext.sdk.concretesyntax.STAR element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("*");
	}

	public void print_org_emftext_sdk_concretesyntax_QUESTIONMARK(org.emftext.sdk.concretesyntax.QUESTIONMARK element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(0);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("?");
	}

	public void print_org_emftext_sdk_concretesyntax_WhiteSpaces(org.emftext.sdk.concretesyntax.WhiteSpaces element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature("cardinality"));
		printCountingMap.put("cardinality", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("amount"));
		printCountingMap.put("amount", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("amount");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("amount"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT_35_");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object)o,element.eClass().getEStructuralFeature("amount"),element));
				
			printCountingMap.put("amount",count-1);
		}
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
	}

	public void print_org_emftext_sdk_concretesyntax_LineBreak(org.emftext.sdk.concretesyntax.LineBreak element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(2);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature("cardinality"));
		printCountingMap.put("cardinality", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("tab"));
		printCountingMap.put("tab", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("tab");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("tab"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT_33_");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object)o,element.eClass().getEStructuralFeature("tab"),element));
				
			printCountingMap.put("tab",count-1);
		}
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
	}

	public void print_org_emftext_sdk_concretesyntax_NormalToken(org.emftext.sdk.concretesyntax.NormalToken element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(4);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature("name"));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("attributeReferences"));
		printCountingMap.put("attributeReferences", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature("attributeName"));
		printCountingMap.put("attributeName", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("regex"));
		printCountingMap.put("regex", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("DEFINE");
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("name");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object)o,element.eClass().getEStructuralFeature("name"),element));
				
			printCountingMap.put("name",count-1);
		}
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("regex");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("regex"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object)o,element.eClass().getEStructuralFeature("regex"),element));
				
			printCountingMap.put("regex",count-1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		java.io.StringWriter sWriter = new java.io.StringWriter();
		java.io.PrintWriter out1 = new java.io.PrintWriter(sWriter);
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_sdk_concretesyntax_NormalToken_0(element,localtab,out1,printCountingMap1);
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
	public void print_org_emftext_sdk_concretesyntax_NormalToken_0(org.emftext.sdk.concretesyntax.NormalToken element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("COLLECT");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("IN");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("attributeName");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("attributeName"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object)o,element.eClass().getEStructuralFeature("attributeName"),element));
				
			printCountingMap.put("attributeName",count-1);
		}
	}

	public void print_org_emftext_sdk_concretesyntax_DecoratedToken(org.emftext.sdk.concretesyntax.DecoratedToken element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(6);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature("name"));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("attributeReferences"));
		printCountingMap.put("attributeReferences", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature("attributeName"));
		printCountingMap.put("attributeName", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("regex"));
		printCountingMap.put("regex", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("prefix"));
		printCountingMap.put("prefix", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("suffix"));
		printCountingMap.put("suffix", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("DEFINE");
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("name");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object)o,element.eClass().getEStructuralFeature("name"),element));
				
			printCountingMap.put("name",count-1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		print_org_emftext_sdk_concretesyntax_DecoratedToken_0(element,localtab,out,printCountingMap);
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("regex");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("regex"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object)o,element.eClass().getEStructuralFeature("regex"),element));
				
			printCountingMap.put("regex",count-1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		print_org_emftext_sdk_concretesyntax_DecoratedToken_1(element,localtab,out,printCountingMap);
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		java.io.StringWriter sWriter = new java.io.StringWriter();
		java.io.PrintWriter out1 = new java.io.PrintWriter(sWriter);
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_sdk_concretesyntax_DecoratedToken_2(element,localtab,out1,printCountingMap1);
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
	public void print_org_emftext_sdk_concretesyntax_DecoratedToken_2(org.emftext.sdk.concretesyntax.DecoratedToken element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("COLLECT");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("IN");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("attributeName");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("attributeName"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object)o,element.eClass().getEStructuralFeature("attributeName"),element));
				
			printCountingMap.put("attributeName",count-1);
		}
	}
	public void print_org_emftext_sdk_concretesyntax_DecoratedToken_0(org.emftext.sdk.concretesyntax.DecoratedToken element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("[");
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		print_org_emftext_sdk_concretesyntax_DecoratedToken_0_0(element,localtab,out,printCountingMap);
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("]");
	}
	public void print_org_emftext_sdk_concretesyntax_DecoratedToken_1_0(org.emftext.sdk.concretesyntax.DecoratedToken element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("suffix");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("suffix"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object)o,element.eClass().getEStructuralFeature("suffix"),element));
				
			printCountingMap.put("suffix",count-1);
		}
	}
	public void print_org_emftext_sdk_concretesyntax_DecoratedToken_1(org.emftext.sdk.concretesyntax.DecoratedToken element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("[");
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		print_org_emftext_sdk_concretesyntax_DecoratedToken_1_0(element,localtab,out,printCountingMap);
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("]");
	}
	public void print_org_emftext_sdk_concretesyntax_DecoratedToken_0_0(org.emftext.sdk.concretesyntax.DecoratedToken element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("prefix");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("prefix"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object)o,element.eClass().getEStructuralFeature("prefix"),element));
				
			printCountingMap.put("prefix",count-1);
		}
	}

	public void print_org_emftext_sdk_concretesyntax_PreDefinedToken(org.emftext.sdk.concretesyntax.PreDefinedToken element, java.lang.String outertab, java.io.PrintWriter out){
		java.lang.String localtab = outertab;
		java.util.Map<java.lang.String, java.lang.Integer> printCountingMap = new java.util.HashMap<java.lang.String, java.lang.Integer>(3);
		java.lang.Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature("name"));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature("attributeReferences"));
		printCountingMap.put("attributeReferences", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature("attributeName"));
		printCountingMap.put("attributeName", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("PREDEFINED");
		//////////////DEFINITION PART BEGINS (WhiteSpaces):
		out.print(" ");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("name");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("name"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object)o,element.eClass().getEStructuralFeature("name"),element));
				
			printCountingMap.put("name",count-1);
		}
		//////////////DEFINITION PART BEGINS (CompoundDefinition):
		java.io.StringWriter sWriter = new java.io.StringWriter();
		java.io.PrintWriter out1 = new java.io.PrintWriter(sWriter);
		java.util.HashMap<java.lang.String, java.lang.Integer> printCountingMap1 = new java.util.HashMap<java.lang.String, java.lang.Integer>(printCountingMap);
		print_org_emftext_sdk_concretesyntax_PreDefinedToken_0(element,localtab,out1,printCountingMap1);
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
	public void print_org_emftext_sdk_concretesyntax_PreDefinedToken_0(org.emftext.sdk.concretesyntax.PreDefinedToken element, java.lang.String outertab, java.io.PrintWriter out, java.util.Map<java.lang.String, java.lang.Integer> printCountingMap){
		java.lang.String localtab = outertab;
		int count;
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("COLLECT");
		//////////////DEFINITION PART BEGINS (CsString):
		out.print("IN");
		//////////////DEFINITION PART BEGINS (DerivedPlaceholder):
		count = printCountingMap.get("attributeName");
		if(count>0){
			Object o =element.eGet(element.eClass().getEStructuralFeature("attributeName"));
			org.emftext.runtime.resource.ITokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((java.lang.Object)o,element.eClass().getEStructuralFeature("attributeName"),element));
				
			printCountingMap.put("attributeName",count-1);
		}
	}

}

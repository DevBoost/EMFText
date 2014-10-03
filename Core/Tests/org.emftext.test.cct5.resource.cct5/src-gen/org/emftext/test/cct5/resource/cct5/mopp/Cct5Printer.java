/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;

public class Cct5Printer implements org.emftext.test.cct5.resource.cct5.ICct5TextPrinter {
	
	protected org.emftext.test.cct5.resource.cct5.ICct5TokenResolverFactory tokenResolverFactory = new org.emftext.test.cct5.resource.cct5.mopp.Cct5TokenResolverFactory();
	
	protected OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private org.emftext.test.cct5.resource.cct5.ICct5TextResource resource;
	
	private Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public Cct5Printer(OutputStream outputStream, org.emftext.test.cct5.resource.cct5.ICct5TextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	protected int matchCount(Map<String, Integer> featureCounter, Collection<String> needed) {
		int pos = 0;
		int neg = 0;
		
		for (String featureName : featureCounter.keySet()) {
			if (needed.contains(featureName)) {
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
	
	protected void doPrint(EObject element, PrintWriter out, String globaltab) {
		if (element == null) {
			throw new IllegalArgumentException("Nothing to write.");
		}
		if (out == null) {
			throw new IllegalArgumentException("Nothing to write on.");
		}
		
		if (element instanceof org.emftext.test.cct5.Farm) {
			print_org_emftext_test_cct5_Farm((org.emftext.test.cct5.Farm) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.test.cct5.Farmer) {
			print_org_emftext_test_cct5_Farmer((org.emftext.test.cct5.Farmer) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.test.cct5.Animal) {
			print_org_emftext_test_cct5_Animal((org.emftext.test.cct5.Animal) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.test.cct5.Diet) {
			print_org_emftext_test_cct5_Diet((org.emftext.test.cct5.Diet) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected org.emftext.test.cct5.resource.cct5.mopp.Cct5ReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.emftext.test.cct5.resource.cct5.mopp.Cct5ReferenceResolverSwitch) new org.emftext.test.cct5.resource.cct5.mopp.Cct5MetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, EObject cause) {
		org.emftext.test.cct5.resource.cct5.ICct5TextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.emftext.test.cct5.resource.cct5.mopp.Cct5Problem(errorMessage, org.emftext.test.cct5.resource.cct5.Cct5EProblemType.PRINT_PROBLEM, org.emftext.test.cct5.resource.cct5.Cct5EProblemSeverity.WARNING), cause);
	}
	
	public void setOptions(Map<?,?> options) {
		this.options = options;
	}
	
	public Map<?,?> getOptions() {
		return options;
	}
	
	public void setEncoding(String encoding) {
		if (encoding != null) {
			this.encoding = encoding;
		}
	}
	
	public String getEncoding() {
		return encoding;
	}
	
	public org.emftext.test.cct5.resource.cct5.ICct5TextResource getResource() {
		return resource;
	}
	
	/**
	 * Calls {@link #doPrint(EObject, PrintWriter, String)} and writes the result to
	 * the underlying output stream.
	 */
	public void print(EObject element) throws java.io.IOException {
		PrintWriter out = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(outputStream), encoding));
		doPrint(element, out, "");
		out.flush();
	}
	
	public void print_org_emftext_test_cct5_Farm(org.emftext.test.cct5.Farm element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.FARM__ANIMAL));
		printCountingMap.put("Animal", temp == null ? 0 : ((Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.FARM__FARMER));
		printCountingMap.put("Farmer", temp == null ? 0 : ((Collection<?>) temp).size());
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("Farm");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_emftext_test_cct5_Farm_0(element, localtab, out, printCountingMap);
		iterate = true;
		while (iterate) {
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
			print_org_emftext_test_cct5_Farm_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new StringWriter();
			out1 = new PrintWriter(sWriter);
			printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
			print_org_emftext_test_cct5_Farm_1(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_org_emftext_test_cct5_Farm_0(org.emftext.test.cct5.Farm element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("Farmer");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.FARM__FARMER));
			List<?> list = (List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("Farmer", count - 1);
		}
	}
	
	public void print_org_emftext_test_cct5_Farm_1(org.emftext.test.cct5.Farm element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("Animal");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.FARM__ANIMAL));
			List<?> list = (List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("Animal", count - 1);
		}
	}
	
	
	public void print_org_emftext_test_cct5_Farmer(org.emftext.test.cct5.Farmer element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.FARMER__NAME));
		printCountingMap.put("Name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.FARMER__DIET));
		printCountingMap.put("Diet", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("BEGIN_FARMER");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("Name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.FARMER__NAME));
			if (o != null) {
				org.emftext.test.cct5.resource.cct5.ICct5TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.FARMER__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("Name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("Diet");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("Diet");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.FARMER__DIET));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("Diet", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("END_FARMER");
		out.print(" ");
	}
	
	
	public void print_org_emftext_test_cct5_Animal(org.emftext.test.cct5.Animal element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.ANIMAL__NAME));
		printCountingMap.put("Name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.ANIMAL__FEEDING_INSTRUCTION));
		printCountingMap.put("FeedingInstruction", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("BEGIN_ANIMAL");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("Name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.ANIMAL__NAME));
			if (o != null) {
				org.emftext.test.cct5.resource.cct5.ICct5TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.ANIMAL__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("Name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("FeedingInstruction");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("FeedingInstruction");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.ANIMAL__FEEDING_INSTRUCTION));
			if (o != null) {
				doPrint((EObject) o, out, localtab);
			}
			printCountingMap.put("FeedingInstruction", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("END_ANIMAL");
		out.print(" ");
	}
	
	
	public void print_org_emftext_test_cct5_Diet(org.emftext.test.cct5.Diet element, String outertab, PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		Map<String, Integer> printCountingMap = new LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.DIET__TYPE));
		printCountingMap.put("Type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.DIET__FAVORITE_DISH));
		printCountingMap.put("FavoriteDish", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		PrintWriter out1 = null;
		Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("Type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.DIET__TYPE));
			if (o != null) {
				org.emftext.test.cct5.resource.cct5.ICct5TokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.DIET__TYPE), element));
				out.print(" ");
			}
			printCountingMap.put("Type", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new StringWriter();
		out1 = new PrintWriter(sWriter);
		printCountingMap1 = new LinkedHashMap<String, Integer>(printCountingMap);
		print_org_emftext_test_cct5_Diet_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_org_emftext_test_cct5_Diet_0(org.emftext.test.cct5.Diet element, String outertab, PrintWriter out, Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("favored");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("FavoriteDish");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.DIET__FAVORITE_DISH));
			if (o != null) {
				org.emftext.test.cct5.resource.cct5.ICct5TokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.DIET__FAVORITE_DISH), element));
				out.print(" ");
			}
			printCountingMap.put("FavoriteDish", count - 1);
		}
	}
	
	
}

package org.emftext.sdk.concretesyntax.resource.cs.analysis; 

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.ResolveResult;
import org.emftext.runtime.resource.impl.ReferenceResolverImpl;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;

// TODO mseifert: check whether resolving start symbols with dots does still work
public class ConcreteSyntaxStartSymbolsReferenceResolver extends ReferenceResolverImpl {
	
	//struct to hold GenClass and declarad namespace prefix in cs
	private static class PrefixGenClassParam{
		public final GenClass genClass;
		public final String importPrefix;
		
		public PrefixGenClassParam(GenClass genClass, String prefix){
			this.importPrefix = prefix;
			if(genClass==null)
				throw new NullPointerException();
			this.genClass = genClass;
		}
	}
	
	
	@Override
	protected void doResolve(String identifier, EObject container,
			EReference reference, int position, boolean resolveFuzzy, ResolveResult result) {

		if (resolveFuzzy) {
			doResolveFuzzy(identifier, container, result);
		} else {
			doResolveStrict(identifier, container, result);
		}
	}

	private void doResolveStrict(
			final String identifier, final EObject container, ResolveResult result) {
		final String pack;
		final String clazz;
		if (identifier.contains(".")) {
			pack = identifier.split("\\.")[0];
			clazz = identifier.split("\\.")[1];
		} else {
			pack = null;
			clazz = identifier;
		}

		doResolveStartSymbol(identifier, container, new ReferenceFilter<PrefixGenClassParam>() {

			public String accept(PrefixGenClassParam param) {
				String genClassName = param.genClass.getName();
				if (!(clazz.equals(genClassName))) {
					return null;
				}
				if (pack == null) {
					return genClassName;
				}
				if (!(pack.equals(param.importPrefix))) {
					return null;
				}
				return genClassName;
			}
			
		}, result);
	}

	public void doResolveFuzzy(final String identifier, EObject container, ResolveResult result) {
		
		doResolveStartSymbol(identifier, container, new ReferenceFilter<PrefixGenClassParam>() {

			public String accept(PrefixGenClassParam param) {
				String genClassName = param.genClass.getName();
				if (genClassName == null) {
					return null;
				}
				if (genClassName.startsWith(identifier)) {
					return genClassName;
				}
				return null;
			}
			
		}, result);
	}

	private void doResolveStartSymbol(String identifier, EObject container, ReferenceFilter<PrefixGenClassParam> filter, ResolveResult result) {
		ConcreteSyntax cs = (ConcreteSyntax) container;
		
		if (cs.getPackage().eIsProxy()) {
			result.setErrorMessage(getErrorMessage(identifier));
			return;
		}
		
		for (Import aImport : cs.getImports()) {
			for(GenClass genClass : aImport.getPackage().getGenClasses()) {
				String foundIdentifier = filter.accept(new PrefixGenClassParam(genClass,aImport.getPrefix()));
				if (foundIdentifier != null) {
					result.addMapping(foundIdentifier, genClass);
				}
			}				
		}
		for(GenClass genClass : cs.getPackage().getGenClasses()) {
			String foundIdentifier = filter.accept(new PrefixGenClassParam(genClass,null));
			if (foundIdentifier != null) {
				result.addMapping(foundIdentifier, genClass);
			}
		}
		
		result.setErrorMessage(getErrorMessage(identifier));
	}

	@Override
	public String deResolve(EObject element, EObject container, EReference reference){
		GenClass genClass = (GenClass)element;
		genClass.getGenPackage().getNSName();
		ConcreteSyntax cs = (ConcreteSyntax) container;
		if (cs.getPackage().getNSName().equals(genClass.getGenPackage().getNSName())) {
			return genClass.getName();
		} else {
			String prefix = "";
			for (Import aImport : cs.getImports()) {
				if(aImport.getPackage().getNSName().equals(genClass.getGenPackage().getNSName())){
					prefix = aImport.getPrefix() + ".";					
				}
			}
			return prefix + genClass.getName();
		}
	}

	private String getErrorMessage(String identifier) {
		return "EClass \"" + identifier + "\" does not exist";
	}
}

package org.reuseware.emftextedit.sdk.concretesyntax.resource.cs.analysis; 

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.reuseware.emftextedit.runtime.resource.ResolveResult;
import org.reuseware.emftextedit.runtime.resource.impl.ReferenceResolverImpl;
import org.reuseware.emftextedit.sdk.concretesyntax.ConcreteSyntax;
import org.reuseware.emftextedit.sdk.concretesyntax.Import;

// TODO mseifert: check whether resolving start symbols with dots does still work
public class ConcreteSyntaxStartSymbolsReferenceResolver extends ReferenceResolverImpl {
	
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
			final String proxyURIFragment, EObject container, ResolveResult result) {
		final String pack;
		final String clazz;
		if (proxyURIFragment.contains(".")) {
			pack = proxyURIFragment.split("\\.")[0];
			clazz = proxyURIFragment.split("\\.")[1];
		} else {
			pack = null;
			clazz = proxyURIFragment;
		}

		doResolveStartSymbol(proxyURIFragment, container, new ReferenceFilter<GenClass>() {

			public String accept(GenClass genClass) {
				String genClassName = genClass.getName();
				if (!(clazz.equals(genClassName))) {
					return null;
				}
				if (pack == null) {
					return genClassName;
				}
				if (!(pack.equals(((Import) genClass.eContainer().eContainer()).getPrefix()))) {
					return null;
				}
				return genClassName;
			}
			
		}, result);
	}

	public void doResolveFuzzy(final String proxyURIFragment, EObject container, ResolveResult result) {
		
		doResolveStartSymbol(proxyURIFragment, container, new ReferenceFilter<GenClass>() {

			public String accept(GenClass genClass) {
				String genClassName = genClass.getName();
				if (genClassName == null) {
					return null;
				}
				if (genClassName.startsWith(proxyURIFragment)) {
					return genClassName;
				}
				return null;
			}
			
		}, result);
	}

	private void doResolveStartSymbol(String proxyURIFragment, EObject container, ReferenceFilter<GenClass> filter, ResolveResult result) {
		ConcreteSyntax cs = (ConcreteSyntax) container;
		
		if (cs.getPackage().eIsProxy()) {
			result.addError(getErrorMessage(proxyURIFragment));
			return;
		}
		
		for (Import aImport : cs.getImports()) {
			for(GenClass genClass : aImport.getPackage().getGenClasses()) {
				String identifier = filter.accept(genClass);
				if (identifier != null) {
					result.addMapping(identifier, genClass);
				}
			}				
		}
		for(GenClass genClass : cs.getPackage().getGenClasses()) {
			String identifier = filter.accept(genClass);
			if (identifier != null) {
				result.addMapping(identifier, genClass);
			}
		}
		
		result.addError(getErrorMessage(proxyURIFragment));
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

	private String getErrorMessage(String proxyURIFragment) {
		return "EClass \"" + proxyURIFragment + "\" does not exist";
	}
}

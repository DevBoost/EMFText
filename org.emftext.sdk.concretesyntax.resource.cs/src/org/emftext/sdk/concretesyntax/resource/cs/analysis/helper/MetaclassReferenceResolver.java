package org.emftext.sdk.concretesyntax.resource.cs.analysis.helper;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IResolveResult;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.Rule;

public class MetaclassReferenceResolver {

	private interface MetaClassFilter {
		public String accept(Import importObject, GenClass genClass);
	}

	private static final String DOT = ".";
	
	public String deResolve(EObject element, EObject container, EReference reference){
		GenClass genClass = (GenClass)element;
		genClass.getGenPackage().getNSName();
		ConcreteSyntax syntax = getConcreteSyntax(container);
		if(syntax.getPackage().getNSName().equals(genClass.getGenPackage().getNSName()))
			return genClass.getName();
		else{
			String prefix = "";
			for (Import aImport : syntax.getImports()) {
				if(aImport.getPackage().getNSName().equals(genClass.getGenPackage().getNSName())){
					prefix = aImport.getPrefix() + DOT;					
				}

			}
			return prefix + genClass.getName();
		}
	}

	private ConcreteSyntax getConcreteSyntax(EObject container) {
		if (container instanceof Rule) {
			Rule rule = (Rule) container;
			return rule.getSyntax();
		} else {
			return (ConcreteSyntax) container;
		}
	}

	public void doResolve(String identifier, EObject container,
			EReference reference, int position, boolean resolveFuzzy, IResolveResult result) {

		if (resolveFuzzy) {
			doResolveFuzzy(getConcreteSyntax(container), identifier, result);
		} else {
			doResolveStrict(getConcreteSyntax(container), identifier, result);
		}
	}

	public void doResolveFuzzy(ConcreteSyntax syntax, final String identifier, IResolveResult result) {
		doResolveMetaclass(syntax, new MetaClassFilter() {

			public String accept(Import importObject, GenClass genClass) {
				String genClassName = genClass.getName();
				String name;
				if (importObject != null) {
					name = importObject.getPrefix() + DOT;
					name += genClassName;
				} else {
					name = genClassName;
				}
				if (name.startsWith(identifier)) {
					return name;
				}
				return null;
			}
		}, identifier, result);
	}

	private void doResolveMetaclass(ConcreteSyntax syntax, MetaClassFilter filter, String ident, IResolveResult result) {
		
		for (Import aImport : syntax.getImports()) {
			for(GenClass genClass : aImport.getPackage().getGenClasses()) {
				if(genClass.getEcoreClass().isAbstract()||genClass.getEcoreClass().isInterface())
					continue;
				String identifier = filter.accept(aImport, genClass);
				if (identifier != null) {
					result.addMapping(identifier, genClass);
				}
			}				
		}
		for(GenClass genClass : syntax.getPackage().getGenClasses()) {
			if(genClass.getEcoreClass().isAbstract()||genClass.getEcoreClass().isInterface())
				continue;
			String identifier = filter.accept(null, genClass);
			if (identifier != null) {
				result.addMapping(identifier, genClass);
			}
		}
		result.setErrorMessage("EClass \"" + ident + "\" does not exist");
	}


	private void doResolveStrict(ConcreteSyntax container,
			final String identifier, IResolveResult result) {
		
		final String[] packageAndClass = splitIdentifier(identifier);
		doResolveMetaclass(container, new MetaClassFilter() {

			public String accept(Import importObject, GenClass genClass) {
				String genClassName = genClass.getName();
				if (importObject != null) {
					if (importObject.getPrefix().equals(packageAndClass[0])) {
						if (genClassName.equals(packageAndClass[1])) {
							return genClassName;
						}
					}
				} else {
					if (genClassName.equals(packageAndClass[1])) {
						return genClassName;
					}
				}
				return null;
			}
		}, identifier, result);
	}

	private String[] splitIdentifier(String identifier) {
		final String packageName;
		final String className;
		if (identifier.contains(DOT)) {
			final String[] split = identifier.split("\\" + DOT);
			packageName = split[0];
			if (split.length > 1) {
				className = split[1];
			} else {
				className = "";
			}
		} else {
			packageName = null;
			className = identifier;
		}
		return new String[] {packageName, className};
	}
}

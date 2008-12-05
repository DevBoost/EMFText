package org.reuseware.emftextedit.sdk.concretesyntax.resource.cs.analysis; 

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.reuseware.emftextedit.runtime.resource.ResolveResult;
import org.reuseware.emftextedit.runtime.resource.impl.ReferenceResolverImpl;
import org.reuseware.emftextedit.sdk.concretesyntax.ConcreteSyntax;
import org.reuseware.emftextedit.sdk.concretesyntax.Import;
import org.reuseware.emftextedit.sdk.concretesyntax.Rule;

public class RuleMetaclassReferenceResolver extends ReferenceResolverImpl {
	
	private interface MetaClassFilter {
		public String accept(Import importObject, GenClass genClass);
	}
	
	@Override
	protected void doResolve(final String identifier, EObject container,
			EReference reference, int position, boolean resolveFuzzy, ResolveResult result) {

		final String[] packageAndClass = splitIdentifier(identifier);
		if (resolveFuzzy) {
			doResolveFuzzy(container, packageAndClass, result);
		} else {
			doResolveStrict(container, packageAndClass, result);
		}
	}

	private void doResolveStrict(EObject container,
			final String[] packageAndClass, ResolveResult result) {
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
		}, packageAndClass, result);
	}
	
	private String[] splitIdentifier(String identifier) {
		final String packageName;
		final String className;
		if (identifier.contains(".")) {
			packageName = identifier.split("\\.")[0];
			className = identifier.split("\\.")[1];
		} else {
			packageName = null;
			className = identifier;
		}
		return new String[] {packageName, className};
	}

	private String mergeIdentifier(String[] packageAndClass) {
		final String packageName = packageAndClass[0];
		final String className = packageAndClass[1];
		if (packageName == null) {
			return className;
		} else {
			return packageName + "." + className;
		}
	}

	protected void doResolveMetaclass(EObject container, MetaClassFilter filter, String[] packageAndClass, ResolveResult result) {
		
		if (!(container instanceof Rule)) {
			return;
		}
		Rule rule = (Rule) container;
		for (Import aImport : rule.getSyntax().getImports()) {
			for(GenClass genClass : aImport.getPackage().getGenClasses()) {
				String identifier = filter.accept(aImport, genClass);
				if (identifier != null) {
					result.addMapping(identifier, genClass);
				}
			}				
		}
		for(GenClass genClass : rule.getSyntax().getPackage().getGenClasses()) {
			String identifier = filter.accept(null, genClass);
			if (identifier != null) {
				result.addMapping(identifier, genClass);
			}
		}
		result.addError("EClass \"" + mergeIdentifier(packageAndClass) + "\" does not exist");
	}

	@Override
	public String deResolve(EObject element, EObject container,EReference reference){
		GenClass genClass = (GenClass)element;
		genClass.getGenPackage().getNSName();
		Rule rule = (Rule) container;
		ConcreteSyntax cs = rule.getSyntax();
		if(cs.getPackage().getNSName().equals(genClass.getGenPackage().getNSName()))
			return genClass.getName();
		else{
			String prefix = "";
			for (Import aImport : cs.getImports()) {
				if(aImport.getPackage().getNSName().equals(genClass.getGenPackage().getNSName())){
					prefix = aImport.getPrefix()+".";					
				}

			}
			return prefix+genClass.getName();
		}

	}

	public void doResolveFuzzy(EObject container, final String[] packageAndClass, ResolveResult result) {

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
					if (genClassName.startsWith(packageAndClass[1])) {
						return genClassName;
					}
				}
				return null;
			}
		}, packageAndClass, result);
	}
}

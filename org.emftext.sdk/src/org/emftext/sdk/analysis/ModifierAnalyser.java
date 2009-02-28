package org.emftext.sdk.analysis;

import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.Abstract;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * An analyser that checks whether the modifier ABSTRACT is used
 * correctly.
 */
public class ModifierAnalyser extends AbstractAnalyser {

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		List<GenClass> symbols = syntax.getActiveStartSymbols();
		Abstract modifier = syntax.getModifier();
		boolean isDeclaredAbstract = modifier != null;
		if (isDeclaredAbstract) {
			// assert there is no start symbol (not a 
			// declared one and not an imported one)
			if (symbols.size() > 0) {
				resource.addError("Syntax has start symbols (" + getListOfNames(symbols) + "), but is declared abstract.", modifier);
			}
		} else {
			// assert the is at least one start symbol (either a 
			// declared one or an imported one)
			if (symbols.size() == 0) {
				resource.addError("Syntax has no start symbols, but is not declared abstract.", syntax);
			}
		}
	}

	private String getListOfNames(List<GenClass> classes) {
		boolean isFirst = true;
		String listOfNames = "";
		for (GenClass symbol : classes) {
			if (!isFirst) {
				listOfNames += ", ";
			}
			isFirst = false;
			listOfNames += symbol.getName();
		}
		return listOfNames;
	}
}

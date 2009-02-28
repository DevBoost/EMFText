package org.emftext.sdk.analysis;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * An analyser that looks for explicit choices in the syntax
 * definition. Such choices are not reflected in the models
 * after parsing and can thus cause a result different from
 * the original text after printing.
 */
public class ChoiceAnalyser extends AbstractAnalyser {

	private static final String EXPLICIT_CHOICES_MAY_CAUSE_REPRINT_PROBLEMS = 
		"Explicit syntax choices are not reflected in model instances and may thus cause problem when printing models.";

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		Iterator<EObject> iterator = syntax.eAllContents();
		while (iterator.hasNext()) {
			EObject next = iterator.next();
			if (next instanceof Choice) {
				Choice choice = (Choice) next;
				if (choice.getOptions().size() > 1) {
					resource.addWarning(
							EXPLICIT_CHOICES_MAY_CAUSE_REPRINT_PROBLEMS,
							choice);
				}
			}
		}
	}

}

package org.emftext.sdk.syntax_annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.emftext.runtime.resource.ITextDiagnostic;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.util.EObjectUtil;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.AnnotationType;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;

public class SuppressWarnings extends AbstractPostProcessor {

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		Collection<Diagnostic> warningsToRemove = new ArrayList<Diagnostic>();
		Collection<Annotation> annotations = EObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getAnnotation());
		for (Annotation annotation : annotations) {
			AnnotationType type = annotation.getType();
			if (type == AnnotationType.SUPPRESS_WARNINGS) {
				EObject annotatedElement = annotation.eContainer();
				List<Diagnostic> warnings = resource.getWarnings();
				for (Diagnostic warning : warnings) {
					if (warning instanceof ITextDiagnostic) {
						ITextDiagnostic textWarning = (ITextDiagnostic) warning;
						if (wasCausedBy(textWarning, annotatedElement)) {
							// TODO check type of the warnings
							warningsToRemove.add(warning);
						}
					}
				}
			}
		}
		for (Diagnostic warningToRemove : warningsToRemove) {
			resource.getWarnings().remove(warningToRemove);
		}
	}

	private boolean wasCausedBy(ITextDiagnostic textWarning,
			EObject annotatedElement) {
		if (textWarning.wasCausedBy(annotatedElement)) {
			return true;
		}
		Iterator<EObject> children = annotatedElement.eAllContents();
		while (children.hasNext()) {
			EObject child = children.next();
			if (textWarning.wasCausedBy(child)) {
				return true;
			}
		}
		return false;
	}
}

package org.emftext.sdk.analysis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.finders.GenClassFinder;

public class ReferencesToAbstractClassesAnalyser extends AbstractAnalyser {

	private final static GenClassFinder genClassFinder = new GenClassFinder();

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		List<Placeholder> danglingReferences = getReferencesToAbstractClassesWithConcreteSubtypes(syntax);
		for (Placeholder next : danglingReferences) {
			GenFeature genFeature = next.getFeature();
			resource.addError("The type of non-containment reference '" + genFeature.getName() + "' is abstract and has no concrete sub classes.", next);
		}
	}

	public List<Placeholder> getReferencesToAbstractClassesWithConcreteSubtypes(ConcreteSyntax syntax) {
		
		List<Placeholder> referencesToAbstractClassesWithConcreteSubtypes = new ArrayList<Placeholder>();
		
		Set<GenClass> allGenClasses = genClassFinder.findAllGenClasses(syntax, true, true);
		Map<String, Collection<String>> genClassNames2superClassNames = genClassFinder.findAllSuperclasses(allGenClasses);

		final TreeIterator<EObject> allContents = syntax.eAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (next instanceof Placeholder) {
				Placeholder placeholder = (Placeholder) next;
				GenFeature genFeature = placeholder.getFeature();
				final EStructuralFeature ecoreFeature = genFeature.getEcoreFeature();
				if (!(ecoreFeature instanceof EReference)) {
					continue;
				}
				EReference ecoreReference = (EReference) ecoreFeature;
				if (ecoreReference.isContainer()) {
					continue;
				}
            	GenClass genFeatureType = genFeature.getTypeGenClass();
				if (isNotConcrete(genFeatureType)) {
					boolean foundConcreteSubClass = false;
            		for (GenClass nextGenClass : allGenClasses) {
            			Collection<String> supertypes = genClassNames2superClassNames.get(nextGenClass.getQualifiedInterfaceName());		
            			if (isConcrete(nextGenClass) &&
            				supertypes.contains(genFeatureType.getQualifiedInterfaceName())) {
            				foundConcreteSubClass = true;
        	            	break;
        				}
            		}
            		if (!foundConcreteSubClass) {
            			referencesToAbstractClassesWithConcreteSubtypes.add(placeholder);
            		}
            	}
			}
		}
		return referencesToAbstractClassesWithConcreteSubtypes;
	}

	private boolean isConcrete(GenClass genFeatureType) {
		return !isNotConcrete(genFeatureType);
	}

	private boolean isNotConcrete(GenClass genFeatureType) {
		return genFeatureType.isAbstract() || genFeatureType.isInterface();
	}
}

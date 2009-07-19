package org.emftext.test.scannerless_parser;

import junit.framework.TestCase;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.emftext.test.grammar_features.ConcreteSubclassA;
import org.emftext.test.grammar_features.Grammar_featuresFactory;
import org.emftext.test.grammar_features.Grammar_featuresPackage;
import org.emftext.test.grammar_features.Root;

public class CommandFrameworkTest extends TestCase {

	public void testCommands() {
		Root root = Grammar_featuresFactory.eINSTANCE.createRoot();
		EStructuralFeature featureID = root.eClass().getEStructuralFeature(Grammar_featuresPackage.ROOT__CHILDREN);
		
		ConcreteSubclassA classA = Grammar_featuresFactory.eINSTANCE.createConcreteSubclassA();
		
		AdapterFactory adapterFactory = new AdapterFactory() {

			public Object adapt(Object object, Object type) {
				return null;
			}

			public Adapter adapt(Notifier target, Object type) {
				return null;
			}

			public void adaptAllNew(Notifier notifier) {
			}

			public Adapter adaptNew(Notifier target, Object type) {
				return null;
			}

			public boolean isFactoryForType(Object type) {
				return false;
			}
		};
		CommandStack commandStack = null;
		EditingDomain ed = new AdapterFactoryEditingDomain(adapterFactory, commandStack);
		Command set = AddCommand.create(ed, root, featureID, classA);
		set.execute();
		
		assertEquals("Root{ConcreteSubclassA}", EObjectTestUtil.convertToString(root));
	}
}

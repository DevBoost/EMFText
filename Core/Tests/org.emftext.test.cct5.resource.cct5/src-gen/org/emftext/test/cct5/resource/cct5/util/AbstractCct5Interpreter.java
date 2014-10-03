/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import org.eclipse.emf.ecore.EObject;
import org.emftext.test.cct5.Animal;
import org.emftext.test.cct5.Diet;
import org.emftext.test.cct5.Farm;
import org.emftext.test.cct5.Farmer;
import org.emftext.test.cct5.NamedElement;

/**
 * This class provides basic infrastructure to interpret models. To implement
 * concrete interpreters, subclass this abstract interpreter and override the
 * interprete_* methods. The interpretation can be customized by binding the two
 * type parameters (ResultType, ContextType). The former is returned by all
 * interprete_* methods, while the latter is passed from method to method while
 * traversing the model. The concrete traversal strategy can also be exchanged.
 * One can use a static traversal strategy by pushing all objects to interpret on
 * the interpretation stack (using addObjectToInterprete()) before calling
 * interprete(). Alternatively, the traversal strategy can be dynamic by pushing
 * objects on the interpretation stack during interpretation.
 */
public class AbstractCct5Interpreter<ResultType, ContextType> {
	
	private Stack<EObject> interpretationStack = new Stack<EObject>();
	private List<org.emftext.test.cct5.resource.cct5.ICct5InterpreterListener> listeners = new ArrayList<org.emftext.test.cct5.resource.cct5.ICct5InterpreterListener>();
	private EObject nextObjectToInterprete;
	private ContextType currentContext;
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		EObject next = null;
		currentContext = context;
		while (!interpretationStack.empty()) {
			try {
				next = interpretationStack.pop();
			} catch (EmptyStackException ese) {
				// this can happen when the interpreter was terminated between the call to empty()
				// and pop()
				break;
			}
			nextObjectToInterprete = next;
			notifyListeners(next);
			result = interprete(next, context);
			if (!continueInterpretation(context, result)) {
				break;
			}
		}
		currentContext = null;
		return result;
	}
	
	/**
	 * Override this method to stop the overall interpretation depending on the result
	 * of the interpretation of a single model elements.
	 */
	public boolean continueInterpretation(ContextType context, ResultType result) {
		return true;
	}
	
	public ResultType interprete(EObject object, ContextType context) {
		ResultType result = null;
		if (object instanceof org.emftext.test.cct5.Farmer) {
			result = interprete_org_emftext_test_cct5_Farmer((org.emftext.test.cct5.Farmer) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.test.cct5.Animal) {
			result = interprete_org_emftext_test_cct5_Animal((org.emftext.test.cct5.Animal) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.test.cct5.NamedElement) {
			result = interprete_org_emftext_test_cct5_NamedElement((org.emftext.test.cct5.NamedElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.test.cct5.Diet) {
			result = interprete_org_emftext_test_cct5_Diet((org.emftext.test.cct5.Diet) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.test.cct5.Farm) {
			result = interprete_org_emftext_test_cct5_Farm((org.emftext.test.cct5.Farm) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_org_emftext_test_cct5_NamedElement(NamedElement namedElement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_test_cct5_Farmer(Farmer farmer, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_test_cct5_Diet(Diet diet, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_test_cct5_Animal(Animal animal, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_test_cct5_Farm(Farm farm, ContextType context) {
		return null;
	}
	
	private void notifyListeners(EObject element) {
		for (org.emftext.test.cct5.resource.cct5.ICct5InterpreterListener listener : listeners) {
			listener.handleInterpreteObject(element);
		}
	}
	
	/**
	 * Adds the given object to the interpretation stack. Attention: Objects that are
	 * added first, are interpret last.
	 */
	public void addObjectToInterprete(EObject object) {
		interpretationStack.push(object);
	}
	
	/**
	 * Adds the given collection of objects to the interpretation stack. Attention:
	 * Collections that are added first, are interpret last.
	 */
	public void addObjectsToInterprete(Collection<? extends EObject> objects) {
		for (EObject object : objects) {
			addObjectToInterprete(object);
		}
	}
	
	/**
	 * Adds the given collection of objects in reverse order to the interpretation
	 * stack.
	 */
	public void addObjectsToInterpreteInReverseOrder(Collection<? extends EObject> objects) {
		List<EObject> reverse = new ArrayList<EObject>(objects.size());
		reverse.addAll(objects);
		Collections.reverse(reverse);
		addObjectsToInterprete(reverse);
	}
	
	/**
	 * Adds the given object and all its children to the interpretation stack such
	 * that they are interpret in top down order.
	 */
	public void addObjectTreeToInterpreteTopDown(EObject root) {
		List<EObject> objects = new ArrayList<EObject>();
		objects.add(root);
		Iterator<EObject> it = root.eAllContents();
		while (it.hasNext()) {
			EObject eObject = (EObject) it.next();
			objects.add(eObject);
		}
		addObjectsToInterpreteInReverseOrder(objects);
	}
	
	public void addListener(org.emftext.test.cct5.resource.cct5.ICct5InterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(org.emftext.test.cct5.resource.cct5.ICct5InterpreterListener listener) {
		return listeners.remove(listener);
	}
	
	public EObject getNextObjectToInterprete() {
		return nextObjectToInterprete;
	}
	
	public Stack<EObject> getInterpretationStack() {
		return interpretationStack;
	}
	
	public void terminate() {
		interpretationStack.clear();
	}
	
	public ContextType getCurrentContext() {
		return currentContext;
	}
	
}

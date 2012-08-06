/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.petrinets.resource.petrinets.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.petrinets.Arc;
import org.emftext.language.petrinets.BasicFunction;
import org.emftext.language.petrinets.BooleanExpression;
import org.emftext.language.petrinets.BooleanLiteral;
import org.emftext.language.petrinets.Call;
import org.emftext.language.petrinets.ConsumingArc;
import org.emftext.language.petrinets.DoubleLiteral;
import org.emftext.language.petrinets.EClassLiteral;
import org.emftext.language.petrinets.Expression;
import org.emftext.language.petrinets.FloatLiteral;
import org.emftext.language.petrinets.FreeVariable;
import org.emftext.language.petrinets.Function;
import org.emftext.language.petrinets.FunctionCall;
import org.emftext.language.petrinets.FunctionType;
import org.emftext.language.petrinets.InitialisedVariable;
import org.emftext.language.petrinets.IntegerLiteral;
import org.emftext.language.petrinets.ListFunction;
import org.emftext.language.petrinets.LongLiteral;
import org.emftext.language.petrinets.MemberCallExpression;
import org.emftext.language.petrinets.NestedExpression;
import org.emftext.language.petrinets.PGenericType;
import org.emftext.language.petrinets.PList;
import org.emftext.language.petrinets.Parameter;
import org.emftext.language.petrinets.PetriNet;
import org.emftext.language.petrinets.PetrinetsFactory;
import org.emftext.language.petrinets.Place;
import org.emftext.language.petrinets.ProducingArc;
import org.emftext.language.petrinets.StringLiteral;
import org.emftext.language.petrinets.TypedElement;
import org.emftext.language.petrinets.UnaryMinus;
import org.emftext.language.petrinets.Variable;
import org.emftext.language.petrinets.VariableCall;
import org.emftext.language.petrinets.impl.PetrinetsFactoryImpl;

public class FunctionCallAnalysisHelper {

	private static FunctionCallAnalysisHelper theInstance;
	private Map<EClassifier, List<Function>> functionCache;
	private Map<String, List<Function>> basicFunctions;

	private FunctionCallAnalysisHelper() {
		functionCache = new HashMap<EClassifier, List<Function>>();
		basicFunctions = new HashMap<String, List<Function>>();
		initBasicFunctionCache();
	}

	private void initBasicFunctionCache() {
		ResourceSetImpl rs = new ResourceSetImpl();
		URI uri = URI
				.createPlatformPluginURI(
						"/org.emftext.language.petrinets.resource.petrinets/library/standardlib.petrinets",
						true);
		Resource resource = rs.getResource(uri, true);
		if (resource.getContents().size() == 1) {
			PetriNet p = (PetriNet) resource.getContents().get(0);
			EList<Function> functions = p.getFunctions();
			for (Function function : functions) {
				if (function instanceof BasicFunction) {
					EClassifier context = ((BasicFunction) function)
							.getContext();
					if (context.getInstanceClassName() != null) {
						addBasicFunction(context.getInstanceClassName(),
								function);
					}
					addBasicFunction(context.getName(), function);

				}
				if (function instanceof ListFunction) {
					PList eList = PetrinetsFactory.eINSTANCE.createPList();
					addBasicFunction(eList.getName(), function);
				}

			}
		}
	}

	private void addBasicFunction(String context, Function function) {
		List<Function> list = basicFunctions.get(context);
		if (list == null) {
			list = new ArrayList<Function>();
			basicFunctions.put(context, list);
		}
		list.add(function);
	}

	public static FunctionCallAnalysisHelper getInstance() {
		if (theInstance == null) {
			theInstance = new FunctionCallAnalysisHelper();
		}
		return theInstance;
	}

	public List<Function> getDeclaredFunctions(FunctionCall container) {
		List<Function> functions = new ArrayList<Function>();
		EClassifier contextType = getContextType(container);

		if (contextType != null) {
			addFunctionsToList(functions, contextType);
		}
		return functions;
	}

	public EClassifier getContextType(Call call) {
		MemberCallExpression memberCalLExp = (MemberCallExpression) call.eContainer();
		EClassifier contextType = null;
		
		int index = memberCalLExp.getCalls().indexOf(call);
		if (index > 0) {
			Call previousCall = memberCalLExp.getCalls().get(index-1);
			if (previousCall != null) {
				contextType = getType(previousCall);
				return contextType;
			}
		}
		else {
			contextType = getType(memberCalLExp.getTarget());
			return contextType;
		}
		EObject container = call.eContainer();

		while (!(container instanceof Arc) && container != null) {
			container = container.eContainer();
		}
		if (container instanceof Arc) {
			contextType = calculateArcContextType((Arc) container);
		}
		return contextType;
	}

	public void addFunctions(List<Function> functions, EClassifier type) {
		List<Function> basics = getMatchingBasicFunctions(type);
		if (basics != null) {
			functions.addAll(basics);
		}
		List<Function> cachedFunctions = functionCache.get(type);
		if (cachedFunctions == null) {
			cachedFunctions = calculateFunctions(type);
			functionCache.put(type, cachedFunctions);
		}
		functions.addAll(cachedFunctions);

	}

	private List<Function> getMatchingBasicFunctions(EClassifier type) {
		List<Function> fs = new ArrayList<Function>();
		List<String> types = new ArrayList<String>();
		types.add(type.getInstanceClassName());
		types.add(type.getName());
		types.add("java.lang.Object");
		if (type instanceof EClass) {
			EClass c = (EClass) type;
			EList<EClass> eAllSuperTypes = c.getEAllSuperTypes();
			for (EClass st : eAllSuperTypes) {
				types.add(st.getInstanceClassName());
				types.add(st.getName());
			}
		}
		for(String typename : types ) {
			List<Function> typeFunctions = basicFunctions.get(typename);
			if (typeFunctions != null)
				fs.addAll(typeFunctions);
		}
		
		return fs;
	}

	private List<Function> calculateFunctions(EClassifier type) {
		List<Function> functions = new ArrayList<Function>();
		if (type.eIsProxy())
			return functions;
		PetrinetsFactory factory = PetrinetsFactoryImpl.eINSTANCE;
		
		if (type instanceof EClass) {
			EClass cls = (EClass) type;
			EList<EStructuralFeature> eStructuralFeatures = cls
					.getEAllStructuralFeatures();
			for (EStructuralFeature eStructuralFeature : eStructuralFeatures) {
				Function getter = factory.createBasicFunction();
				String name = eStructuralFeature.getName();
				name = name.substring(0, 1).toUpperCase() + name.substring(1);
				if ("boolean".equals(eStructuralFeature.getEType().getInstanceClassName())) {
					getter.setName("is" + name);
				} else {
					getter.setName("get" + name);
				}
				EClassifier eType = eStructuralFeature.getEType();
				if (eStructuralFeature.getUpperBound() == -1) {
					PList elist = PetrinetsFactoryImpl.eINSTANCE.createPList();
					elist.setType(eType);
					eType = elist;
				}
				getter.setType(eType);
				functions.add(getter);

				if (eStructuralFeature.getUpperBound() == 1) {
					Function setter = factory.createBasicFunction();
					setter.setName("set" + name);
					setter.setFunctionType(FunctionType.WRITE);
					Parameter parameter = factory.createParameter();
					parameter.setType(eType);
					parameter.setName(eStructuralFeature.getName());
					setter.getParameters().add(parameter);
					functions.add(setter);
				}
			}
			EList<EOperation> eOperations = cls.getEOperations();
			for (EOperation eOperation : eOperations) {
				Function f = factory.createBasicFunction();
				f.setName(eOperation.getName());
				f.setLibrary(false);
				f.setFunctionType(FunctionType.READ);
				f.setContext(cls);
				EClassifier eType = eOperation.getEType();
				if (eOperation.getUpperBound() == -1) {
					PList elist = PetrinetsFactoryImpl.eINSTANCE.createPList();
					elist.setType(eType);
					eType = elist;
				}
				f.setType(eType);
				functions.add(f);
			}
		}
		if (type instanceof EEnum) {
			Function getter = factory.createBasicFunction();
			getter.setName("getLiteral");
			getter.setType(EcorePackage.eINSTANCE.getEString());
			functions.add(getter);
		}
		return functions;
	}

	private void addFunctionsToList(List<Function> functions, EClassifier type) {
		addFunctions(functions, type);
	}

	private EClassifier calculateArcContextType(Arc arc) {
		if (arc instanceof ProducingArc) {
			Place p = ((ProducingArc) arc).getOut();
			return p.getType();
		} else if (arc instanceof ConsumingArc) {
			Place p = ((ConsumingArc) arc).getIn();
			return p.getType();
		}
		return null;
	}

	public EClassifier getType(TypedElement e) {
		if (e == null)
			return null;
		EClassifier type = e.getType();
		if (type == null) {
			type = calculateType(e);
			e.setType(type);
		}
		return type;
	}

	public EClassifier calculateType(TypedElement e) {
		if (e.eIsProxy()) return null;
		if (e instanceof FreeVariable) {
			ConsumingArc ca = (ConsumingArc) e.eContainer();
			EClassifier type = ca.getIn().getType();
			e.setType(type);
			return type;
		}
		if (e instanceof UnaryMinus) {
			UnaryMinus um = (UnaryMinus) e;
			EClassifier type = getType(um.getExpression());
			e.setType(type);
			return type;
		}
		if (e instanceof InitialisedVariable) {
			InitialisedVariable iv = (InitialisedVariable) e;
			EClassifier type = getType(iv.getInitialisation());
			e.setType(type);
			return type;
		}
		if (e instanceof VariableCall) {
			VariableCall vc = (VariableCall) e;
			Variable variable = vc.getVariable();
			if (variable.eIsProxy()) {
				resolveAllRequired(variable, vc);

			}
			if (variable == null || variable.eIsProxy())
				return null;
			EClassifier type = variable.getType();
			if (type == null) {
				if (variable instanceof InitialisedVariable) {
					Expression expression = ((InitialisedVariable) variable)
							.getInitialisation();
					if (expression != null) {
						type = getType(expression);
						expression.setType(type);
					}
				} else {
					ConsumingArc ca = (ConsumingArc) variable.eContainer();
					Place in = (Place) ca.getIn();
					type = in.getType();
				}

			}
			variable.setType(type);
			vc.setType(type);
			return type;
		}
		if (e instanceof FunctionCall) {
			FunctionCall fc = (FunctionCall) e;
			EClassifier contextType = getContextType(fc);
			EClassifier type = getFunctionReturnType(contextType, fc.getFunction());
			e.setType(type);
			return type;
		}
		if (e instanceof MemberCallExpression) {
			MemberCallExpression fc = (MemberCallExpression) e;
			Call call = fc.getCalls().get(fc.getCalls().size()-1);
			EClassifier type  = getType(call);
			e.setType(type);
			return type;
		}
		if (e instanceof StringLiteral) {
			EClassifier type = EcorePackage.eINSTANCE.getEString();
			e.setType(type);
			return type;
		}
		if (e instanceof IntegerLiteral) {
			EClassifier type = EcorePackage.eINSTANCE.getEInt();
			e.setType(type);
			return type;
		}
		if (e instanceof DoubleLiteral) {
			EClassifier type = EcorePackage.eINSTANCE.getEDouble();
			e.setType(type);
			return type;
		}
		if (e instanceof FloatLiteral) {
			EClassifier type = EcorePackage.eINSTANCE.getEFloat();
			e.setType(type);
			return type;
		}
		if (e instanceof LongLiteral) {
			EClassifier type = EcorePackage.eINSTANCE.getELong();
			e.setType(type);
			return type;
		}
		if (e instanceof BooleanLiteral) {
			EClassifier type = EcorePackage.eINSTANCE.getEBoolean();
			e.setType(type);
			return type;
		}
		if (e instanceof BooleanExpression) {
			EClassifier type = EcorePackage.eINSTANCE.getEBoolean();
			e.setType(type);
			return type;
		}
		if (e instanceof EClassLiteral) {
			EClassifier type = EcorePackage.eINSTANCE.getEClass();
			e.setType(type);
			return type;
		}
		if (e instanceof NestedExpression) {
			NestedExpression ne = (NestedExpression) e;
			Expression expression = ne.getExpression();
			EClassifier calculateType = getType(expression);
			if (calculateType != null) e.setType(calculateType);
			return calculateType;
		}
		return null;
	}

	public EClassifier getFunctionReturnType(EClassifier contextType, Function function) {
		EClassifier type = null;
		if (function.eIsProxy()) {
			function = (Function) EcoreUtil.resolve(function, function.eContainer());
		}
		if (function instanceof BasicFunction) {
			type = function.getType();
		}
		if (function instanceof ListFunction) {
			type = function.getType();
			if (type instanceof PGenericType) {
				type = getGenericTypeBinding(contextType);
			}
			if (type instanceof PList) {
				PList listType = (PList) type;
				listType.setType(getGenericTypeBinding(contextType));
				type = listType;
			}
		}
		return type;
	}

	private EClassifier getGenericTypeBinding(EClassifier contextType) {
		//EClassifier contextType = getContextType(previousCall);
		// PLIST.getContextBinding
		if (contextType instanceof PList) {
			PList listtype = (PList) contextType;
			if (listtype.getType() != null
					&& !(listtype.getType() instanceof PGenericType)) {
				return listtype.getType();
			}

		}
		return null;
	}

	private void resolveAllRequired(Variable variable, Expression container) {
		EcoreUtil.resolve(variable, container);
	}

	public boolean isSubtype(EClassifier subtype, EClassifier supertype) {
		if (subtype == null || supertype == null) return false;
		if (subtype instanceof PList && supertype instanceof PList) {
			return isSubtype(((PList) subtype).getType(),
					((PList) supertype).getType());
		}
		if (supertype.getInstanceClass() != null
				&& supertype.getInstanceClass().getName()
						.equals("java.lang.Object"))
			return true;
		if (subtype.getInstanceClassName() != null) {
			if (subtype.getInstanceClassName().equals(
					supertype.getInstanceClassName())) {
				return true;
			}
		}
		if (supertype instanceof EClass && subtype instanceof EClass) {
			return ((EClass) supertype).isSuperTypeOf((EClass) subtype);
		}

		return false;
	}
}

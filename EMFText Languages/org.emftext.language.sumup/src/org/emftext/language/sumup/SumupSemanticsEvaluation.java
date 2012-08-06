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
package org.emftext.language.sumup;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.*;
import java.util.*;

public class SumupSemanticsEvaluation {

	public class RemovalException extends Exception {
		private static final long serialVersionUID = -8317569526723196361L;
	}

	public void revertRemovalTransactions() {
		for(RemovalTransaction<?> e : removalTransactions) {
			e.revert();
		}
	}

	private class RemovalTransaction<T> {
		private List<T> list;
		private T element;
		public RemovalTransaction(List<T> l, T e) {
			list = l;
			element = e;
		}

		public void revert() {
			list.add(element);
		}
	}

	private List<RemovalTransaction<?>> removalTransactions;

	private void startTransaction() {
		assert(removalTransactions.isEmpty());
		removalTransactions = new LinkedList<RemovalTransaction<?>>();
	}
	private List<And> _place_Ands = new ArrayList<And>();

	public void add_to_place_Ands(And object) {
		{
			for(Calculation argument_2 : _place_EvaluatedCalculations) {
				for(Calculation argument_3 : _place_EvaluatedCalculations) {
					List<Object> args = new ArrayList<Object>();
					args.add(object);
					args.add(argument_2);
					args.add(argument_3);
					addPendingChange("evaluateAnd", args);}}
		}
		_place_Ands.add(object);
	}

	private void remove_from_place_Ands(And object) throws RemovalException{
		removalTransactions.add(new RemovalTransaction<And>(_place_Ands, object));
		_place_Ands.remove(object);
	}
	private List<Or> _place_Ors = new ArrayList<Or>();

	public void add_to_place_Ors(Or object) {
		{
			for(Calculation argument_2 : _place_EvaluatedCalculations) {
				for(Calculation argument_3 : _place_EvaluatedCalculations) {
					List<Object> args = new ArrayList<Object>();
					args.add(object);
					args.add(argument_2);
					args.add(argument_3);
					addPendingChange("evaluateOr", args);}}
		}
		_place_Ors.add(object);
	}

	private void remove_from_place_Ors(Or object) throws RemovalException{
		removalTransactions.add(new RemovalTransaction<Or>(_place_Ors, object));
		_place_Ors.remove(object);
	}
	private List<Unary> _place_Unaries = new ArrayList<Unary>();

	public void add_to_place_Unaries(Unary object) {
		{
			for(Calculation argument_2 : _place_EvaluatedCalculations) {
				List<Object> args = new ArrayList<Object>();
				args.add(object);
				args.add(argument_2);
				addPendingChange("evaluateUnaryMinus", args);}
		}
		{
			for(Calculation argument_2 : _place_EvaluatedCalculations) {
				List<Object> args = new ArrayList<Object>();
				args.add(object);
				args.add(argument_2);
				addPendingChange("evaluateUnary", args);}
		}
		_place_Unaries.add(object);
	}

	private void remove_from_place_Unaries(Unary object) throws RemovalException{
		removalTransactions.add(new RemovalTransaction<Unary>(_place_Unaries, object));
		_place_Unaries.remove(object);
	}
	private List<Boolean> _place_Booleans = new ArrayList<Boolean>();

	public void add_to_place_Booleans(Boolean object) {
		{
			List<Object> args = new ArrayList<Object>();
			args.add(object);
			addPendingChange("evaluateBoolean", args);
		}
		_place_Booleans.add(object);
	}

	private void remove_from_place_Booleans(Boolean object) throws RemovalException{
		removalTransactions.add(new RemovalTransaction<Boolean>(_place_Booleans, object));
		_place_Booleans.remove(object);
	}
	private List<Float> _place_Floats = new ArrayList<Float>();

	public void add_to_place_Floats(Float object) {
		{
			List<Object> args = new ArrayList<Object>();
			args.add(object);
			addPendingChange("evaluateFloat", args);
		}
		_place_Floats.add(object);
	}

	private void remove_from_place_Floats(Float object) throws RemovalException{
		removalTransactions.add(new RemovalTransaction<Float>(_place_Floats, object));
		_place_Floats.remove(object);
	}
	private List<Int> _place_Integers = new ArrayList<Int>();

	public void add_to_place_Integers(Int object) {
		{
			List<Object> args = new ArrayList<Object>();
			args.add(object);
			addPendingChange("evaluateInteger", args);
		}
		_place_Integers.add(object);
	}

	private void remove_from_place_Integers(Int object) throws RemovalException{
		removalTransactions.add(new RemovalTransaction<Int>(_place_Integers, object));
		_place_Integers.remove(object);
	}
	private List<Nested> _place_Nesteds = new ArrayList<Nested>();

	public void add_to_place_Nesteds(Nested object) {
		{
			for(Calculation argument_2 : _place_EvaluatedCalculations) {
				List<Object> args = new ArrayList<Object>();
				args.add(object);
				args.add(argument_2);
				addPendingChange("evaluateNested", args);}
		}
		_place_Nesteds.add(object);
	}

	private void remove_from_place_Nesteds(Nested object) throws RemovalException{
		removalTransactions.add(new RemovalTransaction<Nested>(_place_Nesteds, object));
		_place_Nesteds.remove(object);
	}
	private List<Multiplicative> _place_Multiplicatives = new ArrayList<Multiplicative>();

	public void add_to_place_Multiplicatives(Multiplicative object) {
		{
			for(Calculation argument_2 : _place_EvaluatedCalculations) {
				for(Calculation argument_3 : _place_EvaluatedCalculations) {
					List<Object> args = new ArrayList<Object>();
					args.add(object);
					args.add(argument_2);
					args.add(argument_3);
					addPendingChange("evaluateMultiplicativeMult", args);}}
		}
		{
			for(Calculation argument_2 : _place_EvaluatedCalculations) {
				for(Calculation argument_3 : _place_EvaluatedCalculations) {
					List<Object> args = new ArrayList<Object>();
					args.add(object);
					args.add(argument_2);
					args.add(argument_3);
					addPendingChange("evaluateMultiplicativeDiv", args);}}
		}
		{
			for(Calculation argument_2 : _place_EvaluatedCalculations) {
				for(Calculation argument_3 : _place_EvaluatedCalculations) {
					List<Object> args = new ArrayList<Object>();
					args.add(object);
					args.add(argument_2);
					args.add(argument_3);
					addPendingChange("evaluateAddititiveMinus", args);}}
		}
		_place_Multiplicatives.add(object);
	}

	private void remove_from_place_Multiplicatives(Multiplicative object) throws RemovalException{
		removalTransactions.add(new RemovalTransaction<Multiplicative>(_place_Multiplicatives, object));
		_place_Multiplicatives.remove(object);
	}
	private List<Additive> _place_Additives = new ArrayList<Additive>();

	public void add_to_place_Additives(Additive object) {
		{
			for(Calculation argument_2 : _place_EvaluatedCalculations) {
				for(Calculation argument_3 : _place_EvaluatedCalculations) {
					List<Object> args = new ArrayList<Object>();
					args.add(object);
					args.add(argument_2);
					args.add(argument_3);
					addPendingChange("evaluateAddititivePlus", args);}}
		}
		_place_Additives.add(object);
	}

	private void remove_from_place_Additives(Additive object) throws RemovalException{
		removalTransactions.add(new RemovalTransaction<Additive>(_place_Additives, object));
		_place_Additives.remove(object);
	}
	private List<Assignment> _place_Assignments = new ArrayList<Assignment>();

	public void add_to_place_Assignments(Assignment object) {
		{
			for(Calculation argument_2 : _place_EvaluatedCalculations) {
				List<Object> args = new ArrayList<Object>();
				args.add(object);
				args.add(argument_2);
				addPendingChange("evaluateAssignment", args);}
		}
		_place_Assignments.add(object);
	}

	private void remove_from_place_Assignments(Assignment object) throws RemovalException{
		removalTransactions.add(new RemovalTransaction<Assignment>(_place_Assignments, object));
		_place_Assignments.remove(object);
	}
	private List<Calculation> _place_EvaluatedCalculations = new ArrayList<Calculation>();

	public void add_to_place_EvaluatedCalculations(Calculation object) {
		{
			for(Assignment argument_1 : _place_Assignments) {
				List<Object> args = new ArrayList<Object>();
				args.add(argument_1);
				args.add(object);
				addPendingChange("evaluateAssignment", args);}
		}
		{
			for(Unary argument_1 : _place_Unaries) {
				List<Object> args = new ArrayList<Object>();
				args.add(argument_1);
				args.add(object);
				addPendingChange("evaluateUnaryMinus", args);}
		}
		{
			for(Unary argument_1 : _place_Unaries) {
				List<Object> args = new ArrayList<Object>();
				args.add(argument_1);
				args.add(object);
				addPendingChange("evaluateUnary", args);}
		}
		{
			for(Nested argument_1 : _place_Nesteds) {
				List<Object> args = new ArrayList<Object>();
				args.add(argument_1);
				args.add(object);
				addPendingChange("evaluateNested", args);}
		}
		{
			for(Or argument_1 : _place_Ors) {
				for(Calculation argument_3 : _place_EvaluatedCalculations) {
					List<Object> args = new ArrayList<Object>();
					args.add(argument_1);
					args.add(object);
					args.add(argument_3);
					addPendingChange("evaluateOr", args);}}
		}
		{
			for(Or argument_1 : _place_Ors) {
				for(Calculation argument_2 : _place_EvaluatedCalculations) {
					List<Object> args = new ArrayList<Object>();
					args.add(argument_1);
					args.add(argument_2);
					args.add(object);
					addPendingChange("evaluateOr", args);}}
		}
		{
			for(And argument_1 : _place_Ands) {
				for(Calculation argument_3 : _place_EvaluatedCalculations) {
					List<Object> args = new ArrayList<Object>();
					args.add(argument_1);
					args.add(object);
					args.add(argument_3);
					addPendingChange("evaluateAnd", args);}}
		}
		{
			for(And argument_1 : _place_Ands) {
				for(Calculation argument_2 : _place_EvaluatedCalculations) {
					List<Object> args = new ArrayList<Object>();
					args.add(argument_1);
					args.add(argument_2);
					args.add(object);
					addPendingChange("evaluateAnd", args);}}
		}
		{
			for(Multiplicative argument_1 : _place_Multiplicatives) {
				for(Calculation argument_3 : _place_EvaluatedCalculations) {
					List<Object> args = new ArrayList<Object>();
					args.add(argument_1);
					args.add(object);
					args.add(argument_3);
					addPendingChange("evaluateMultiplicativeMult", args);}}
		}
		{
			for(Multiplicative argument_1 : _place_Multiplicatives) {
				for(Calculation argument_2 : _place_EvaluatedCalculations) {
					List<Object> args = new ArrayList<Object>();
					args.add(argument_1);
					args.add(argument_2);
					args.add(object);
					addPendingChange("evaluateMultiplicativeMult", args);}}
		}
		{
			for(Multiplicative argument_1 : _place_Multiplicatives) {
				for(Calculation argument_3 : _place_EvaluatedCalculations) {
					List<Object> args = new ArrayList<Object>();
					args.add(argument_1);
					args.add(object);
					args.add(argument_3);
					addPendingChange("evaluateMultiplicativeDiv", args);}}
		}
		{
			for(Multiplicative argument_1 : _place_Multiplicatives) {
				for(Calculation argument_2 : _place_EvaluatedCalculations) {
					List<Object> args = new ArrayList<Object>();
					args.add(argument_1);
					args.add(argument_2);
					args.add(object);
					addPendingChange("evaluateMultiplicativeDiv", args);}}
		}
		{
			for(Additive argument_1 : _place_Additives) {
				for(Calculation argument_3 : _place_EvaluatedCalculations) {
					List<Object> args = new ArrayList<Object>();
					args.add(argument_1);
					args.add(object);
					args.add(argument_3);
					addPendingChange("evaluateAddititivePlus", args);}}
		}
		{
			for(Additive argument_1 : _place_Additives) {
				for(Calculation argument_2 : _place_EvaluatedCalculations) {
					List<Object> args = new ArrayList<Object>();
					args.add(argument_1);
					args.add(argument_2);
					args.add(object);
					addPendingChange("evaluateAddititivePlus", args);}}
		}
		{
			for(Multiplicative argument_1 : _place_Multiplicatives) {
				for(Calculation argument_3 : _place_EvaluatedCalculations) {
					List<Object> args = new ArrayList<Object>();
					args.add(argument_1);
					args.add(object);
					args.add(argument_3);
					addPendingChange("evaluateAddititiveMinus", args);}}
		}
		{
			for(Multiplicative argument_1 : _place_Multiplicatives) {
				for(Calculation argument_2 : _place_EvaluatedCalculations) {
					List<Object> args = new ArrayList<Object>();
					args.add(argument_1);
					args.add(argument_2);
					args.add(object);
					addPendingChange("evaluateAddititiveMinus", args);}}
		}
		_place_EvaluatedCalculations.add(object);
	}

	private void remove_from_place_EvaluatedCalculations(Calculation object) throws RemovalException{
		removalTransactions.add(new RemovalTransaction<Calculation>(_place_EvaluatedCalculations, object));
		_place_EvaluatedCalculations.remove(object);
	}
	private List<Assignment> _place_EvaluatedAssignments = new ArrayList<Assignment>();

	public void add_to_place_EvaluatedAssignments(Assignment object) {
		_place_EvaluatedAssignments.add(object);
	}

	private void remove_from_place_EvaluatedAssignments(Assignment object) throws RemovalException{
		removalTransactions.add(new RemovalTransaction<Assignment>(_place_EvaluatedAssignments, object));
		_place_EvaluatedAssignments.remove(object);
	}

	List<PendingChange> pendingChanges = new LinkedList<PendingChange>();

	private class PendingChange {
		private String transitionName;
		private List<Object> arguments;
		public PendingChange(String transitionName, List<Object> arguments) {
			this.transitionName = transitionName;
			this.arguments = arguments;
		}
	}

	private void addPendingChange(String transitionName, List<Object> arguments) {
		this.pendingChanges.add(new PendingChange(transitionName, arguments));
	}

	public void intialisePlaces(EObject model) {
		relayObject(model);
		TreeIterator<EObject> eAllContents = model.eAllContents();
		while (eAllContents.hasNext()) {
			EObject eObject = (EObject) eAllContents.next();
			relayObject(eObject);
		}
	}
	private void relayObject(EObject eObject) {
		if (eObject instanceof And) {
			add_to_place_Ands((And) eObject);
		}
		if (eObject instanceof Or) {
			add_to_place_Ors((Or) eObject);
		}
		if (eObject instanceof Unary) {
			add_to_place_Unaries((Unary) eObject);
		}
		if (eObject instanceof Boolean) {
			add_to_place_Booleans((Boolean) eObject);
		}
		if (eObject instanceof Float) {
			add_to_place_Floats((Float) eObject);
		}
		if (eObject instanceof Int) {
			add_to_place_Integers((Int) eObject);
		}
		if (eObject instanceof Nested) {
			add_to_place_Nesteds((Nested) eObject);
		}
		if (eObject instanceof Multiplicative) {
			add_to_place_Multiplicatives((Multiplicative) eObject);
		}
		if (eObject instanceof Additive) {
			add_to_place_Additives((Additive) eObject);
		}
		if (eObject instanceof Assignment) {
			add_to_place_Assignments((Assignment) eObject);
		}
	}

	public void evaluateSemantics() {
		while(this.pendingChanges.size() > 0) {
			PendingChange pc = pendingChanges.remove(0);
			if (pc.transitionName.equals("evaluateAssignment") ) {
				transition_evaluateAssignment_doFire((Assignment) pc.arguments.get(0), (Calculation) pc.arguments.get(1));
			}

			if (pc.transitionName.equals("evaluateUnaryMinus") ) {
				transition_evaluateUnaryMinus_doFire((Unary) pc.arguments.get(0), (Calculation) pc.arguments.get(1));
			}

			if (pc.transitionName.equals("evaluateUnary") ) {
				transition_evaluateUnary_doFire((Unary) pc.arguments.get(0), (Calculation) pc.arguments.get(1));
			}

			if (pc.transitionName.equals("evaluateNested") ) {
				transition_evaluateNested_doFire((Nested) pc.arguments.get(0), (Calculation) pc.arguments.get(1));
			}

			if (pc.transitionName.equals("evaluateBoolean") ) {
				transition_evaluateBoolean_doFire((Boolean) pc.arguments.get(0));
			}

			if (pc.transitionName.equals("evaluateOr") ) {
				transition_evaluateOr_doFire((Or) pc.arguments.get(0), (Calculation) pc.arguments.get(1), (Calculation) pc.arguments.get(2));
			}

			if (pc.transitionName.equals("evaluateAnd") ) {
				transition_evaluateAnd_doFire((And) pc.arguments.get(0), (Calculation) pc.arguments.get(1), (Calculation) pc.arguments.get(2));
			}

			if (pc.transitionName.equals("evaluateFloat") ) {
				transition_evaluateFloat_doFire((Float) pc.arguments.get(0));
			}

			if (pc.transitionName.equals("evaluateInteger") ) {
				transition_evaluateInteger_doFire((Int) pc.arguments.get(0));
			}

			if (pc.transitionName.equals("evaluateMultiplicativeMult") ) {
				transition_evaluateMultiplicativeMult_doFire((Multiplicative) pc.arguments.get(0), (Calculation) pc.arguments.get(1), (Calculation) pc.arguments.get(2));
			}

			if (pc.transitionName.equals("evaluateMultiplicativeDiv") ) {
				transition_evaluateMultiplicativeDiv_doFire((Multiplicative) pc.arguments.get(0), (Calculation) pc.arguments.get(1), (Calculation) pc.arguments.get(2));
			}

			if (pc.transitionName.equals("evaluateAddititivePlus") ) {
				transition_evaluateAddititivePlus_doFire((Additive) pc.arguments.get(0), (Calculation) pc.arguments.get(1), (Calculation) pc.arguments.get(2));
			}

			if (pc.transitionName.equals("evaluateAddititiveMinus") ) {
				transition_evaluateAddititiveMinus_doFire((Multiplicative) pc.arguments.get(0), (Calculation) pc.arguments.get(1), (Calculation) pc.arguments.get(2));
			}

		}
	}

	private boolean transition_evaluateAssignment_doFire(Assignment a, Calculation e) {

		// evaluate guard expression
		boolean guardSatisfied = false;
		Assignment __temp_1 = a;

		// .getCalculation()
		Calculation __temp_2 = __temp_1.getCalculation();
		// .equals()
		Calculation __temp_3 = e;

		boolean __temp_4 = __temp_2.equals(__temp_3);
		guardSatisfied = __temp_4;
		if (guardSatisfied) {
			startTransaction();
			try {
				remove_from_place_Assignments(a);
				remove_from_place_EvaluatedCalculations(e);
				} catch(RemovalException __removalException) {
					revertRemovalTransactions();
					return false;
				}
				removalTransactions.clear();
			}
			else return false;

			// floatValue initialization 
			Calculation __temp_7 = e;

			// .getResult()
			Result __temp_8 = __temp_7.getResult();
			// .getValue()
			Primitive __temp_9 = __temp_8.getValue();
			Float __temp_6 = (Float)__temp_9;
			Float __temp_5 = __temp_6;
			// .getValue()
			float __temp_10 = __temp_5.getValue();
			float floatValue = __temp_10;

			// f initialization 
			Float __temp_11 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createFloat();
			__temp_11.setValue(floatValue);

			Float f = __temp_11;

			// out initialization 
			Result __temp_12 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createResult();
			__temp_12.setValue(f);

			Result out = __temp_12;
			// init out places
			// evaluate settings for a
			a.setResult(out);
			// add a to place EvaluatedAssignments
			add_to_place_EvaluatedAssignments(a);
			return true;
		}

		private boolean transition_evaluateUnaryMinus_doFire(Unary u, Calculation e) {

			// evaluate guard expression
			boolean guardSatisfied = false;
			Unary __temp_14 = u;

			// .getCalculation()
			Calculation __temp_15 = __temp_14.getCalculation();
			// .equals()
			Calculation __temp_16 = e;

			boolean __temp_17 = __temp_15.equals(__temp_16);
			boolean __temp_13 = __temp_17;
			if (__temp_13) {
				Unary __temp_18 = u;

				// .isMinus()
				boolean __temp_19 = __temp_18.isMinus();
				__temp_13 = __temp_19;
			}
			guardSatisfied = __temp_13;
			if (guardSatisfied) {
				startTransaction();
				try {
					remove_from_place_Unaries(u);
					remove_from_place_EvaluatedCalculations(e);
					} catch(RemovalException __removalException) {
						revertRemovalTransactions();
						return false;
					}
					removalTransactions.clear();
				}
				else return false;

				// floatValue initialization 
				Calculation __temp_22 = e;

				// .getResult()
				Result __temp_23 = __temp_22.getResult();
				// .getValue()
				Primitive __temp_24 = __temp_23.getValue();
				Float __temp_21 = (Float)__temp_24;
				Float __temp_20 = __temp_21;
				// .getValue()
				float __temp_25 = __temp_20.getValue();
				// .mult()
				float __temp_27 = 1.0f;
				float __temp_26 = - __temp_27;
				float __temp_28 = 
				org.emftext.languages.petrinets.lib.StandardlibSemanticsLibrary.mult(__temp_25, __temp_26);
				float floatValue = __temp_28;

				// f initialization 
				Float __temp_29 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createFloat();
				__temp_29.setValue(floatValue);

				Float f = __temp_29;

				// out initialization 
				Result __temp_30 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createResult();
				__temp_30.setValue(f);

				Result out = __temp_30;
				// init out places
				// evaluate settings for u
				u.setResult(out);
				// add u to place EvaluatedCalculations
				add_to_place_EvaluatedCalculations(u);
				return true;
			}

			private boolean transition_evaluateUnary_doFire(Unary u, Calculation e) {

				// evaluate guard expression
				boolean guardSatisfied = false;
				Unary __temp_32 = u;

				// .getCalculation()
				Calculation __temp_33 = __temp_32.getCalculation();
				// .equals()
				Calculation __temp_34 = e;

				boolean __temp_35 = __temp_33.equals(__temp_34);
				boolean __temp_31 = __temp_35;
				if (__temp_31) {
					Unary __temp_36 = u;

					// .isMinus()
					boolean __temp_37 = __temp_36.isMinus();
					// .not()
					boolean __temp_38 = 
					org.emftext.languages.petrinets.lib.StandardlibSemanticsLibrary.not(__temp_37);
					__temp_31 = __temp_38;
				}
				guardSatisfied = __temp_31;
				if (guardSatisfied) {
					startTransaction();
					try {
						remove_from_place_Unaries(u);
						remove_from_place_EvaluatedCalculations(e);
						} catch(RemovalException __removalException) {
							revertRemovalTransactions();
							return false;
						}
						removalTransactions.clear();
					}
					else return false;

					// floatValue initialization 
					Calculation __temp_41 = e;

					// .getResult()
					Result __temp_42 = __temp_41.getResult();
					// .getValue()
					Primitive __temp_43 = __temp_42.getValue();
					Float __temp_40 = (Float)__temp_43;
					Float __temp_39 = __temp_40;
					// .getValue()
					float __temp_44 = __temp_39.getValue();
					float floatValue = __temp_44;

					// f initialization 
					Float __temp_45 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createFloat();
					__temp_45.setValue(floatValue);

					Float f = __temp_45;

					// out initialization 
					Result __temp_46 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createResult();
					__temp_46.setValue(f);

					Result out = __temp_46;
					// init out places
					// evaluate settings for u
					u.setResult(out);
					// add u to place EvaluatedCalculations
					add_to_place_EvaluatedCalculations(u);
					return true;
				}

				private boolean transition_evaluateNested_doFire(Nested n, Calculation e) {

					// evaluate guard expression
					boolean guardSatisfied = false;
					Nested __temp_47 = n;

					// .getCalculation()
					Calculation __temp_48 = __temp_47.getCalculation();
					// .equals()
					Calculation __temp_49 = e;

					boolean __temp_50 = __temp_48.equals(__temp_49);
					guardSatisfied = __temp_50;
					if (guardSatisfied) {
						startTransaction();
						try {
							remove_from_place_Nesteds(n);
							remove_from_place_EvaluatedCalculations(e);
							} catch(RemovalException __removalException) {
								revertRemovalTransactions();
								return false;
							}
							removalTransactions.clear();
						}
						else return false;

						// floatValue initialization 
						Calculation __temp_53 = e;

						// .getResult()
						Result __temp_54 = __temp_53.getResult();
						// .getValue()
						Primitive __temp_55 = __temp_54.getValue();
						Float __temp_52 = (Float)__temp_55;
						Float __temp_51 = __temp_52;
						// .getValue()
						float __temp_56 = __temp_51.getValue();
						float floatValue = __temp_56;

						// f initialization 
						Float __temp_57 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createFloat();
						__temp_57.setValue(floatValue);

						Float f = __temp_57;

						// out initialization 
						Result __temp_58 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createResult();
						__temp_58.setValue(f);

						Result out = __temp_58;
						// init out places
						// evaluate settings for n
						n.setResult(out);
						// add n to place EvaluatedCalculations
						add_to_place_EvaluatedCalculations(n);
						return true;
					}

					private boolean transition_evaluateBoolean_doFire(Boolean c) {

						// evaluate guard expression
						boolean guardSatisfied = false;
						guardSatisfied = true;
						if (guardSatisfied) {
							startTransaction();
							try {
								remove_from_place_Booleans(c);
								} catch(RemovalException __removalException) {
									revertRemovalTransactions();
									return false;
								}
								removalTransactions.clear();
							}
							else return false;

							// booleanResult initialization 
							Boolean __temp_59 = c;

							// .isValue()
							boolean __temp_60 = __temp_59.isValue();
							boolean booleanResult = __temp_60;

							// booleanLiteral initialization 
							Boolean __temp_61 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createBoolean();
							__temp_61.setValue(booleanResult);

							Boolean booleanLiteral = __temp_61;

							// out initialization 
							Result __temp_62 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createResult();
							__temp_62.setValue(booleanLiteral);

							Result out = __temp_62;
							// init out places
							// evaluate settings for c
							c.setResult(out);
							// add c to place EvaluatedCalculations
							add_to_place_EvaluatedCalculations(c);
							return true;
						}

						private boolean transition_evaluateOr_doFire(Or c, Calculation left, Calculation right) {

							// evaluate guard expression
							boolean guardSatisfied = false;
							Or __temp_64 = c;

							// .getLeft()
							Calculation __temp_65 = __temp_64.getLeft();
							// .equals()
							Calculation __temp_66 = left;

							boolean __temp_67 = __temp_65.equals(__temp_66);
							boolean __temp_63 = __temp_67;
							if (__temp_63) {
								Or __temp_68 = c;

								// .getRight()
								Calculation __temp_69 = __temp_68.getRight();
								// .equals()
								Calculation __temp_70 = right;

								boolean __temp_71 = __temp_69.equals(__temp_70);
								__temp_63 = __temp_71;
							}
							guardSatisfied = __temp_63;
							if (guardSatisfied) {
								startTransaction();
								try {
									remove_from_place_Ors(c);
									remove_from_place_EvaluatedCalculations(left);
									remove_from_place_EvaluatedCalculations(right);
									} catch(RemovalException __removalException) {
										revertRemovalTransactions();
										return false;
									}
									removalTransactions.clear();
								}
								else return false;

								// booleanResult initialization 
								Calculation __temp_75 = left;

								// .getResult()
								Result __temp_76 = __temp_75.getResult();
								// .getValue()
								Primitive __temp_77 = __temp_76.getValue();
								Boolean __temp_74 = (Boolean)__temp_77;
								Boolean __temp_73 = __temp_74;
								// .isValue()
								boolean __temp_78 = __temp_73.isValue();
								boolean __temp_72 = __temp_78;
								if (!__temp_72) {
									Calculation __temp_81 = right;

									// .getResult()
									Result __temp_82 = __temp_81.getResult();
									// .getValue()
									Primitive __temp_83 = __temp_82.getValue();
									Boolean __temp_80 = (Boolean)__temp_83;
									Boolean __temp_79 = __temp_80;
									// .isValue()
									boolean __temp_84 = __temp_79.isValue();
									__temp_72 = __temp_84;}
								boolean booleanResult = __temp_72;

								// booleanLiteral initialization 
								Boolean __temp_85 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createBoolean();
								__temp_85.setValue(booleanResult);

								Boolean booleanLiteral = __temp_85;

								// out initialization 
								Result __temp_86 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createResult();
								__temp_86.setValue(booleanLiteral);

								Result out = __temp_86;
								// init out places
								// evaluate settings for c
								c.setResult(out);
								// add c to place EvaluatedCalculations
								add_to_place_EvaluatedCalculations(c);
								return true;
							}

							private boolean transition_evaluateAnd_doFire(And c, Calculation left, Calculation right) {

								// evaluate guard expression
								boolean guardSatisfied = false;
								And __temp_88 = c;

								// .getLeft()
								Calculation __temp_89 = __temp_88.getLeft();
								// .equals()
								Calculation __temp_90 = left;

								boolean __temp_91 = __temp_89.equals(__temp_90);
								boolean __temp_87 = __temp_91;
								if (__temp_87) {
									And __temp_92 = c;

									// .getRight()
									Calculation __temp_93 = __temp_92.getRight();
									// .equals()
									Calculation __temp_94 = right;

									boolean __temp_95 = __temp_93.equals(__temp_94);
									__temp_87 = __temp_95;
								}
								guardSatisfied = __temp_87;
								if (guardSatisfied) {
									startTransaction();
									try {
										remove_from_place_Ands(c);
										remove_from_place_EvaluatedCalculations(left);
										remove_from_place_EvaluatedCalculations(right);
										} catch(RemovalException __removalException) {
											revertRemovalTransactions();
											return false;
										}
										removalTransactions.clear();
									}
									else return false;

									// booleanResult initialization 
									Calculation __temp_99 = left;

									// .getResult()
									Result __temp_100 = __temp_99.getResult();
									// .getValue()
									Primitive __temp_101 = __temp_100.getValue();
									Boolean __temp_98 = (Boolean)__temp_101;
									Boolean __temp_97 = __temp_98;
									// .isValue()
									boolean __temp_102 = __temp_97.isValue();
									boolean __temp_96 = __temp_102;
									if (__temp_96) {
										Calculation __temp_105 = right;

										// .getResult()
										Result __temp_106 = __temp_105.getResult();
										// .getValue()
										Primitive __temp_107 = __temp_106.getValue();
										Boolean __temp_104 = (Boolean)__temp_107;
										Boolean __temp_103 = __temp_104;
										// .isValue()
										boolean __temp_108 = __temp_103.isValue();
										__temp_96 = __temp_108;
									}
									boolean booleanResult = __temp_96;

									// booleanLiteral initialization 
									Boolean __temp_109 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createBoolean();
									__temp_109.setValue(booleanResult);

									Boolean booleanLiteral = __temp_109;

									// out initialization 
									Result __temp_110 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createResult();
									__temp_110.setValue(booleanLiteral);

									Result out = __temp_110;
									// init out places
									// evaluate settings for c
									c.setResult(out);
									// add c to place EvaluatedCalculations
									add_to_place_EvaluatedCalculations(c);
									return true;
								}

								private boolean transition_evaluateFloat_doFire(Float c) {

									// evaluate guard expression
									boolean guardSatisfied = false;
									guardSatisfied = true;
									if (guardSatisfied) {
										startTransaction();
										try {
											remove_from_place_Floats(c);
											} catch(RemovalException __removalException) {
												revertRemovalTransactions();
												return false;
											}
											removalTransactions.clear();
										}
										else return false;

										// floatValue initialization 
										Float __temp_111 = c;

										// .getValue()
										float __temp_112 = __temp_111.getValue();
										float floatValue = __temp_112;

										// floatLiteral initialization 
										Float __temp_113 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createFloat();
										__temp_113.setValue(floatValue);

										Float floatLiteral = __temp_113;

										// out initialization 
										Result __temp_114 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createResult();
										__temp_114.setValue(floatLiteral);

										Result out = __temp_114;
										// init out places
										// evaluate settings for c
										c.setResult(out);
										// add c to place EvaluatedCalculations
										add_to_place_EvaluatedCalculations(c);
										return true;
									}

									private boolean transition_evaluateInteger_doFire(Int c) {

										// evaluate guard expression
										boolean guardSatisfied = false;
										guardSatisfied = true;
										if (guardSatisfied) {
											startTransaction();
											try {
												remove_from_place_Integers(c);
												} catch(RemovalException __removalException) {
													revertRemovalTransactions();
													return false;
												}
												removalTransactions.clear();
											}
											else return false;

											// floatValue initialization 
											Int __temp_115 = c;

											// .getValue()
											int __temp_116 = __temp_115.getValue();
											// .floatValue()
											float __temp_117 = 
											org.emftext.languages.petrinets.lib.StandardlibSemanticsLibrary.floatValue(__temp_116);
											float floatValue = __temp_117;

											// floatLiteral initialization 
											Float __temp_118 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createFloat();
											__temp_118.setValue(floatValue);

											Float floatLiteral = __temp_118;

											// out initialization 
											Result __temp_119 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createResult();
											__temp_119.setValue(floatLiteral);

											Result out = __temp_119;
											// init out places
											// evaluate settings for c
											c.setResult(out);
											// add c to place EvaluatedCalculations
											add_to_place_EvaluatedCalculations(c);
											return true;
										}

										private boolean transition_evaluateMultiplicativeMult_doFire(Multiplicative c, Calculation left, Calculation right) {

											// evaluate guard expression
											boolean guardSatisfied = false;
											Multiplicative __temp_121 = c;

											// .getOperator()
											MultplicativeOperator __temp_122 = __temp_121.getOperator();
											// .getLiteral()
											java.lang.String __temp_123 = __temp_122.getLiteral();
											// .equals()
											String __temp_124 = "*";
											boolean __temp_125 = __temp_123.equals(__temp_124);
											boolean __temp_120 = __temp_125;
											if (__temp_120) {
												Multiplicative __temp_127 = c;

												// .getLeft()
												Calculation __temp_128 = __temp_127.getLeft();
												// .equals()
												Calculation __temp_129 = left;

												boolean __temp_130 = __temp_128.equals(__temp_129);
												boolean __temp_126 = __temp_130;
												if (__temp_126) {
													Multiplicative __temp_131 = c;

													// .getRight()
													Calculation __temp_132 = __temp_131.getRight();
													// .equals()
													Calculation __temp_133 = right;

													boolean __temp_134 = __temp_132.equals(__temp_133);
													__temp_126 = __temp_134;
												}
												__temp_120 = __temp_126;
											}
											guardSatisfied = __temp_120;
											if (guardSatisfied) {
												startTransaction();
												try {
													remove_from_place_Multiplicatives(c);
													remove_from_place_EvaluatedCalculations(left);
													remove_from_place_EvaluatedCalculations(right);
													} catch(RemovalException __removalException) {
														revertRemovalTransactions();
														return false;
													}
													removalTransactions.clear();
												}
												else return false;

												// floatValue initialization 
												Calculation __temp_137 = left;

												// .getResult()
												Result __temp_138 = __temp_137.getResult();
												// .getValue()
												Primitive __temp_139 = __temp_138.getValue();
												Float __temp_136 = (Float)__temp_139;
												Float __temp_135 = __temp_136;
												// .getValue()
												float __temp_140 = __temp_135.getValue();
												// .mult()
												Calculation __temp_143 = right;

												// .getResult()
												Result __temp_144 = __temp_143.getResult();
												// .getValue()
												Primitive __temp_145 = __temp_144.getValue();
												Float __temp_142 = (Float)__temp_145;
												Float __temp_141 = __temp_142;
												// .getValue()
												float __temp_146 = __temp_141.getValue();
												float __temp_147 = 
												org.emftext.languages.petrinets.lib.StandardlibSemanticsLibrary.mult(__temp_140, __temp_146);
												float floatValue = __temp_147;

												// floatLiteral initialization 
												Float __temp_148 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createFloat();
												__temp_148.setValue(floatValue);

												Float floatLiteral = __temp_148;

												// out initialization 
												Result __temp_149 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createResult();
												__temp_149.setValue(floatLiteral);

												Result out = __temp_149;
												// init out places
												// evaluate settings for c
												c.setResult(out);
												// add c to place EvaluatedCalculations
												add_to_place_EvaluatedCalculations(c);
												return true;
											}

											private boolean transition_evaluateMultiplicativeDiv_doFire(Multiplicative c, Calculation left, Calculation right) {

												// evaluate guard expression
												boolean guardSatisfied = false;
												Multiplicative __temp_151 = c;

												// .getOperator()
												MultplicativeOperator __temp_152 = __temp_151.getOperator();
												// .getLiteral()
												java.lang.String __temp_153 = __temp_152.getLiteral();
												// .equals()
												String __temp_154 = "/";
												boolean __temp_155 = __temp_153.equals(__temp_154);
												boolean __temp_150 = __temp_155;
												if (__temp_150) {
													Multiplicative __temp_157 = c;

													// .getLeft()
													Calculation __temp_158 = __temp_157.getLeft();
													// .equals()
													Calculation __temp_159 = left;

													boolean __temp_160 = __temp_158.equals(__temp_159);
													boolean __temp_156 = __temp_160;
													if (__temp_156) {
														Multiplicative __temp_161 = c;

														// .getRight()
														Calculation __temp_162 = __temp_161.getRight();
														// .equals()
														Calculation __temp_163 = right;

														boolean __temp_164 = __temp_162.equals(__temp_163);
														__temp_156 = __temp_164;
													}
													__temp_150 = __temp_156;
												}
												guardSatisfied = __temp_150;
												if (guardSatisfied) {
													startTransaction();
													try {
														remove_from_place_Multiplicatives(c);
														remove_from_place_EvaluatedCalculations(left);
														remove_from_place_EvaluatedCalculations(right);
														} catch(RemovalException __removalException) {
															revertRemovalTransactions();
															return false;
														}
														removalTransactions.clear();
													}
													else return false;

													// floatValue initialization 
													Calculation __temp_167 = left;

													// .getResult()
													Result __temp_168 = __temp_167.getResult();
													// .getValue()
													Primitive __temp_169 = __temp_168.getValue();
													Float __temp_166 = (Float)__temp_169;
													Float __temp_165 = __temp_166;
													// .getValue()
													float __temp_170 = __temp_165.getValue();
													// .div()
													Calculation __temp_173 = right;

													// .getResult()
													Result __temp_174 = __temp_173.getResult();
													// .getValue()
													Primitive __temp_175 = __temp_174.getValue();
													Float __temp_172 = (Float)__temp_175;
													Float __temp_171 = __temp_172;
													// .getValue()
													float __temp_176 = __temp_171.getValue();
													float __temp_177 = 
													org.emftext.languages.petrinets.lib.StandardlibSemanticsLibrary.div(__temp_170, __temp_176);
													float floatValue = __temp_177;

													// floatLiteral initialization 
													Float __temp_178 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createFloat();
													__temp_178.setValue(floatValue);

													Float floatLiteral = __temp_178;

													// out initialization 
													Result __temp_179 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createResult();
													__temp_179.setValue(floatLiteral);

													Result out = __temp_179;
													// init out places
													// evaluate settings for c
													c.setResult(out);
													// add c to place EvaluatedCalculations
													add_to_place_EvaluatedCalculations(c);
													return true;
												}

												private boolean transition_evaluateAddititivePlus_doFire(Additive c, Calculation left, Calculation right) {

													// evaluate guard expression
													boolean guardSatisfied = false;
													Additive __temp_181 = c;

													// .getOperator()
													AdditiveOperator __temp_182 = __temp_181.getOperator();
													// .getLiteral()
													java.lang.String __temp_183 = __temp_182.getLiteral();
													// .equals()
													String __temp_184 = "+";
													boolean __temp_185 = __temp_183.equals(__temp_184);
													boolean __temp_180 = __temp_185;
													if (__temp_180) {
														Additive __temp_187 = c;

														// .getLeft()
														Calculation __temp_188 = __temp_187.getLeft();
														// .equals()
														Calculation __temp_189 = left;

														boolean __temp_190 = __temp_188.equals(__temp_189);
														boolean __temp_186 = __temp_190;
														if (__temp_186) {
															Additive __temp_191 = c;

															// .getRight()
															Calculation __temp_192 = __temp_191.getRight();
															// .equals()
															Calculation __temp_193 = right;

															boolean __temp_194 = __temp_192.equals(__temp_193);
															__temp_186 = __temp_194;
														}
														__temp_180 = __temp_186;
													}
													guardSatisfied = __temp_180;
													if (guardSatisfied) {
														startTransaction();
														try {
															remove_from_place_Additives(c);
															remove_from_place_EvaluatedCalculations(left);
															remove_from_place_EvaluatedCalculations(right);
															} catch(RemovalException __removalException) {
																revertRemovalTransactions();
																return false;
															}
															removalTransactions.clear();
														}
														else return false;

														// floatValue initialization 
														Calculation __temp_197 = left;

														// .getResult()
														Result __temp_198 = __temp_197.getResult();
														// .getValue()
														Primitive __temp_199 = __temp_198.getValue();
														Float __temp_196 = (Float)__temp_199;
														Float __temp_195 = __temp_196;
														// .getValue()
														float __temp_200 = __temp_195.getValue();
														// .add()
														Calculation __temp_203 = right;

														// .getResult()
														Result __temp_204 = __temp_203.getResult();
														// .getValue()
														Primitive __temp_205 = __temp_204.getValue();
														Float __temp_202 = (Float)__temp_205;
														Float __temp_201 = __temp_202;
														// .getValue()
														float __temp_206 = __temp_201.getValue();
														float __temp_207 = 
														org.emftext.languages.petrinets.lib.StandardlibSemanticsLibrary.add(__temp_200, __temp_206);
														float floatValue = __temp_207;

														// floatLiteral initialization 
														Float __temp_208 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createFloat();
														__temp_208.setValue(floatValue);

														Float floatLiteral = __temp_208;

														// out initialization 
														Result __temp_209 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createResult();
														__temp_209.setValue(floatLiteral);

														Result out = __temp_209;
														// init out places
														// evaluate settings for c
														c.setResult(out);
														// add c to place EvaluatedCalculations
														add_to_place_EvaluatedCalculations(c);
														return true;
													}

													private boolean transition_evaluateAddititiveMinus_doFire(Multiplicative c, Calculation left, Calculation right) {

														// evaluate guard expression
														boolean guardSatisfied = false;
														Multiplicative __temp_211 = c;

														// .getOperator()
														MultplicativeOperator __temp_212 = __temp_211.getOperator();
														// .getLiteral()
														java.lang.String __temp_213 = __temp_212.getLiteral();
														// .equals()
														String __temp_214 = "-";
														boolean __temp_215 = __temp_213.equals(__temp_214);
														boolean __temp_210 = __temp_215;
														if (__temp_210) {
															Multiplicative __temp_217 = c;

															// .getLeft()
															Calculation __temp_218 = __temp_217.getLeft();
															// .equals()
															Calculation __temp_219 = left;

															boolean __temp_220 = __temp_218.equals(__temp_219);
															boolean __temp_216 = __temp_220;
															if (__temp_216) {
																Multiplicative __temp_221 = c;

																// .getRight()
																Calculation __temp_222 = __temp_221.getRight();
																// .equals()
																Calculation __temp_223 = right;

																boolean __temp_224 = __temp_222.equals(__temp_223);
																__temp_216 = __temp_224;
															}
															__temp_210 = __temp_216;
														}
														guardSatisfied = __temp_210;
														if (guardSatisfied) {
															startTransaction();
															try {
																remove_from_place_Multiplicatives(c);
																remove_from_place_EvaluatedCalculations(left);
																remove_from_place_EvaluatedCalculations(right);
																} catch(RemovalException __removalException) {
																	revertRemovalTransactions();
																	return false;
																}
																removalTransactions.clear();
															}
															else return false;

															// floatValue initialization 
															Calculation __temp_227 = left;

															// .getResult()
															Result __temp_228 = __temp_227.getResult();
															// .getValue()
															Primitive __temp_229 = __temp_228.getValue();
															Float __temp_226 = (Float)__temp_229;
															Float __temp_225 = __temp_226;
															// .getValue()
															float __temp_230 = __temp_225.getValue();
															// .sub()
															Calculation __temp_233 = right;

															// .getResult()
															Result __temp_234 = __temp_233.getResult();
															// .getValue()
															Primitive __temp_235 = __temp_234.getValue();
															Float __temp_232 = (Float)__temp_235;
															Float __temp_231 = __temp_232;
															// .getValue()
															float __temp_236 = __temp_231.getValue();
															float __temp_237 = 
															org.emftext.languages.petrinets.lib.StandardlibSemanticsLibrary.sub(__temp_230, __temp_236);
															float floatValue = __temp_237;

															// floatLiteral initialization 
															Float __temp_238 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createFloat();
															__temp_238.setValue(floatValue);

															Float floatLiteral = __temp_238;

															// out initialization 
															Result __temp_239 = org.emftext.language.sumup.SumupFactory.eINSTANCE.createResult();
															__temp_239.setValue(floatLiteral);

															Result out = __temp_239;
															// init out places
															// evaluate settings for c
															c.setResult(out);
															// add c to place EvaluatedCalculations
															add_to_place_EvaluatedCalculations(c);
															return true;
														}

													}

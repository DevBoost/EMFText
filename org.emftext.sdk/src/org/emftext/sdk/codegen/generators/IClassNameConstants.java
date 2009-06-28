package org.emftext.sdk.codegen.generators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.FailedPredicateException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedNotSetException;
import org.antlr.runtime.MismatchedRangeException;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.MismatchedTreeNodeException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.resource.EProblemType;
import org.emftext.runtime.resource.IExpectedElement;
import org.emftext.runtime.resource.ILocationMap;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.impl.AbstractProblem;
import org.emftext.runtime.resource.impl.DummyEObject;
import org.emftext.runtime.util.StringUtil;

public interface IClassNameConstants {

	// constants for class names used in the generated code
	public static final String STRING_UTIL = StringUtil.class.getName();
	public static final String BIT_SET = BitSet.class.getName();
	public static final String INT_STREAM = IntStream.class.getName();
	public static final String MISMATCHED_RANGE_EXCEPTION = MismatchedRangeException.class.getName();
	public static final String FAILED_PREDICATE_EXCEPTION = FailedPredicateException.class.getName();
	public static final String MISMATCHED_NOT_SET_EXCEPTION = MismatchedNotSetException.class.getName();
	public static final String MISMATCHED_SET_EXCEPTION = MismatchedSetException.class.getName();
	public static final String EARLY_EXIT_EXCEPTION = EarlyExitException.class.getName();
	public static final String NO_VIABLE_ALT_EXCEPTION = NoViableAltException.class.getName();
	public static final String MISMATCHED_TREE_NODE_EXCEPTION = MismatchedTreeNodeException.class.getName();
	public static final String MISMATCHED_TOKEN_EXCEPTION = MismatchedTokenException.class.getName();
	public static final String ILLEGAL_ARGUMENT_EXCEPTION = IllegalArgumentException.class.getName();
	public static final String ABSTRACT_PROBLEM = AbstractProblem.class.getName();
	public static final String E_PROBLEM_TYPE = EProblemType.class.getName();
	public static final String ARRAY_LIST = ArrayList.class.getName();
	public static final String COMMON_TOKEN = CommonToken.class.getName();
	public static final String DUMMY_E_OBJECT = DummyEObject.class.getName();
	public static final String E_CLASS = EClass.class.getName();
	public static final String E_OBJECT = EObject.class.getName();
	public static final String E_REFERENCE = EReference.class.getName();
	public static final String INTEGER = Integer.class.getName();
	public static final String I_EXPECTED_ELEMENT = IExpectedElement.class.getName();
	public static final String I_LOCATION_MAP = ILocationMap.class.getName();
	public static final String I_OPTIONS = IOptions.class.getName();
	public static final String I_TEXT_RESOURCE = ITextResource.class.getName();
	public static final String LIST = List.class.getName();
	public static final String OBJECT = Object.class.getName();
	public static final String RECOGNITION_EXCEPTION = RecognitionException.class.getName();
	public static final String MATH = Math.class.getName();
	public static final String STRING = String.class.getName();
	public static final String MAP = Map.class.getName();
	public static final String COLLECTIONS = Collections.class.getName();
	public static final String E_STRUCTURAL_FEATURE = EStructuralFeature.class.getName();
}

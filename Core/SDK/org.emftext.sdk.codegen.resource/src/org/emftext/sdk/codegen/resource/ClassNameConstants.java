/*******************************************************************************
 * Copyright (c) 2006-2014
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
package org.emftext.sdk.codegen.resource;

import de.devboost.codecomposers.java.JavaComposite;

/**
 * Constants for class names used in the generated code.
 */
public class ClassNameConstants {

	public static String ABSTRACT_PREFERENCE_INITIALIZER(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer");
	}

	public static String ABSTRACT_SOURCE_LOOKUP_DIRECTOR(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.sourcelookup.AbstractSourceLookupDirector");
	}

	public static String ABSTRACT_SOURCE_LOOKUP_PARTICIPANT(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant");
	}

	public static String ADAPTER(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.common.notify.Adapter");
	}

	public static String ADAPTER_IMPL(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.common.notify.impl.AdapterImpl");
	}

	public static String ANTLR_INPUT_STREAM(JavaComposite jc) {
		return getClassName(jc, "org.antlr.runtime3_4_0.ANTLRInputStream");
	}

	public static String ANTLR_PARSER(JavaComposite jc) {
		return getClassName(jc, "org.antlr.runtime3_4_0.Parser");
	}

	public static String ANTLR_STRING_STREAM(JavaComposite jc) {
		return getClassName(jc, "org.antlr.runtime3_4_0.ANTLRStringStream");
	}

	public static String ARRAY(JavaComposite jc) {
		return getClassName(jc, "java.lang.reflect.Array");
	}

	public static String ARRAYS(JavaComposite jc) {
		return getClassName(jc, "java.util.Arrays");
	}

	public static String ASSERT(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.runtime.Assert");
	}

	public static String BASIC_COMMAND_STACK(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.common.command.BasicCommandStack");
	}

	public static String BASIC_E_LIST(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.common.util.BasicEList");
	}

	public static String BASIC_E_MAP(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.common.util.BasicEMap");
	}

	public static String BASIC_E_OBJECT_IMPL(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.impl.BasicEObjectImpl");
	}

	public static String BASIC_INTERNAL_E_LIST(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.util.BasicInternalEList");
	}

	public static String BIT_SET(JavaComposite jc) {
		return getClassName(jc, "org.antlr.runtime3_4_0.BitSet");
	}

	public static String BUFFERED_INPUT_STREAM(JavaComposite jc) {
		return getClassName(jc, "java.io.BufferedInputStream");
	}

	public static String BUFFERED_OUTPUT_STREAM(JavaComposite jc) {
		return getClassName(jc, "java.io.BufferedOutputStream");
	}

	public static String BUFFERED_READER(JavaComposite jc) {
		return getClassName(jc, "java.io.BufferedReader");
	}

	public static String BUNDLE(JavaComposite jc) {
		return getClassName(jc, "org.osgi.framework.Bundle");
	}

	public static String BUNDLE_CONTEXT(JavaComposite jc) {
		return getClassName(jc, "org.osgi.framework.BundleContext");
	}

	public static String BYTE_ARRAY_INPUT_STREAM(JavaComposite jc) {
		return getClassName(jc, "java.io.ByteArrayInputStream");
	}

	public static String BYTE_ARRAY_OUTPUT_STREAM(JavaComposite jc) {
		return getClassName(jc, "java.io.ByteArrayOutputStream");
	}

	public static String CHANGE_DESCRIPTION(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.change.ChangeDescription");
	}

	public static String CHANGE_RECORDER(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.change.util.ChangeRecorder");
	}

	public static String COLLECTION(JavaComposite jc) {
		return getClassName(jc, "java.util.Collection");
	}

	public static String COLLECTIONS(JavaComposite jc) {
		return getClassName(jc, "java.util.Collections");
	}

	public static String COMMON_TOKEN(JavaComposite jc) {
		return getClassName(jc, "org.antlr.runtime3_4_0.CommonToken");
	}

	public static String COMMON_TOKEN_STREAM(JavaComposite jc) {
		return getClassName(jc, "org.antlr.runtime3_4_0.CommonTokenStream");
	}

	public static String COMPARABLE(JavaComposite jc) {
		return jc.getClassName(Comparable.class);
	}

	public static String COMPARATOR(JavaComposite jc) {
		return getClassName(jc, "java.util.Comparator");
	}

	public static String CONNECT_EXCEPTION(JavaComposite jc) {
		return getClassName(jc, "java.net.ConnectException");
	}

	public static String CONSTRAINT_STATUS(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.validation.model.ConstraintStatus");
	}

	public static String CORE_EXCEPTION(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.runtime.CoreException");
	}

	public static String DEBUG_ELEMENT(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.model.DebugElement");
	}

	public static String DEBUG_EVENT(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.DebugEvent");
	}

	public static String DEBUG_EXCEPTION(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.DebugException");
	}

	public static String DEBUG_PLUGIN(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.DebugPlugin");
	}

	public static String DIAGNOSTIC(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.common.util.Diagnostic");
	}

	public static String DIAGNOSTICIAN(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.util.Diagnostician");
	}

	public static String DOCUMENT_LISTENER(JavaComposite jc) {
		return getClassName(jc, "javax.swing.event.DocumentListener");
	}

	public static String E_ATTRIBUTE(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.EAttribute");
	}

	public static String E_CLASS(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.EClass");
	}

	public static String E_CLASSIFIER(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.EClassifier");
	}

	public static String E_DATA_TYPE(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.EDataType");
	}

	public static String E_ENUM(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.EEnum");
	}

	public static String E_ENUM_LITERAL(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.EEnumLiteral");
	}

	public static String E_FACTORY(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.EFactory");
	}

	public static String E_LIST(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.common.util.EList");
	}

	public static String E_MAP(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.common.util.EMap");
	}

	public static String E_NOTIFICATION_IMPL(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.impl.ENotificationImpl");
	}

	public static String E_OBJECT(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.EObject");
	}

	public static String E_OBJECT_IMPL(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.impl.EObjectImpl");
	}

	public static String E_OPERATION(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.EOperation");
	}

	public static String E_PACKAGE(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.EPackage");
	}

	public static String E_REFERENCE(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.EReference");
	}

	public static String E_STRUCTURAL_FEATURE(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.EStructuralFeature");
	}

	public static String EARLY_EXIT_EXCEPTION(JavaComposite jc) {
		return getClassName(jc, "org.antlr.runtime3_4_0.EarlyExitException");
	}

	public static String ECORE_FACTORY(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.EcoreFactory");
	}

	public static String ECORE_PLUGIN(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.plugin.EcorePlugin");
	}

	public static String ECORE_UTIL(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.util.EcoreUtil");
	}

	public static String ECORE_UTIL_EQUALITY_HELPER(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper");
	}

	public static String ECORE_VALIDATOR(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.util.EcoreValidator");
	}

	public static String EDITOR(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.codegen.ecore.templates.editor.Editor");
	}

	public static String EMF_MODEL_VALIDATION_PLUGIN(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.validation.internal.EMFModelValidationPlugin");
	}

	public static String EMPTY_STACK_EXCEPTION(JavaComposite jc) {
		return getClassName(jc, "java.util.EmptyStackException");
	}

	public static String ENUMERATOR(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.common.util.Enumerator");
	}

	public static String EVALUATION_MODE(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.validation.model.EvaluationMode");
	}

	public static String FAILED_PREDICATE_EXCEPTION(JavaComposite jc) {
		return getClassName(jc, "org.antlr.runtime3_4_0.FailedPredicateException");
	}

	public static String FEATURE_MAP(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.util.FeatureMap");
	}

	public static String FIELD(JavaComposite jc) {
		return getClassName(jc, "java.lang.reflect.Field");
	}

	public static String FILE(JavaComposite jc) {
		return getClassName(jc, "java.io.File");
	}

	public static String FILE_INPUT_STREAM(JavaComposite jc) {
		return getClassName(jc, "java.io.FileInputStream");
	}

	public static String FILE_LOCATOR(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.runtime.FileLocator");
	}

	public static String FILE_NOT_FOUND_EXCEPTION(JavaComposite jc) {
		return getClassName(jc, "java.io.FileNotFoundException");
	}

	public static String FILE_OUTPUT_STREAM(JavaComposite jc) {
		return getClassName(jc, "java.io.FileOutputStream");
	}

	public static String GEN_CLASS(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.codegen.ecore.genmodel.GenClass");
	}

	public static String GEN_FEATURE(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.codegen.ecore.genmodel.GenFeature");
	}

	public static String GEN_PACKAGE(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.codegen.ecore.genmodel.GenPackage");
	}

	private static String getClassName(JavaComposite jc,
			String qualifiedClassName) {
		return de.devboost.codecomposers.java.ClassNameConstants.getClassName(
				jc, qualifiedClassName);
	}

	public static String I_ADAPTABLE(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.runtime.IAdaptable");
	}

	public static String I_ADAPTER_FACTORY(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.runtime.IAdapterFactory");
	}

	public static String I_BATCH_VALIDATOR(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.validation.service.IBatchValidator");
	}

	public static String I_BREAKPOINT(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.model.IBreakpoint");
	}

	public static String I_BREAKPOINT_MANAGER(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.IBreakpointManager");
	}

	public static String I_COMMAND(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.resources.ICommand");
	}

	public static String I_CONFIGURATION_ELEMENT(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.runtime.IConfigurationElement");
	}

	public static String I_CONTAINER(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.resources.IContainer");
	}

	public static String I_DEBUG_TARGET(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.model.IDebugTarget");
	}

	public static String I_EXECUTABLE_EXTENSION(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.runtime.IExecutableExtension");
	}

	public static String I_EXTENSION_REGISTRY(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.runtime.IExtensionRegistry");
	}

	public static String I_FILE(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.resources.IFile");
	}

	public static String I_LAUNCH(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.ILaunch");
	}

	public static String I_LAUNCH_CONFIGURATION(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.ILaunchConfiguration");
	}

	public static String I_LAUNCH_MANAGER(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.ILaunchManager");
	}

	public static String I_LIVE_VALIDATOR(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.validation.service.ILiveValidator");
	}

	public static String I_MARKER(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.resources.IMarker");
	}

	public static String I_MARKER_DELTA(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.resources.IMarkerDelta");
	}

	public static String I_MEMORY_BLOCK(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.model.IMemoryBlock");
	}

	public static String I_PATH(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.runtime.IPath");
	}

	public static String I_PROCESS(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.model.IProcess");
	}

	public static String I_PROGRESS_MONITOR(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.runtime.IProgressMonitor");
	}

	public static String I_PROJECT(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.resources.IProject");
	}

	public static String I_PROJECT_DESCRIPTION(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.resources.IProjectDescription");
	}

	public static String I_PROJECT_NATURE(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.resources.IProjectNature");
	}

	public static String I_REGISTER_GROUP(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.model.IRegisterGroup");
	}

	public static String I_RESOURCE(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.resources.IResource");
	}

	public static String I_RESOURCE_CHANGE_EVENT(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.resources.IResourceChangeEvent");
	}

	public static String I_RESOURCE_CHANGE_LISTENER(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.resources.IResourceChangeListener");
	}

	public static String I_RESOURCE_DELTA(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.resources.IResourceDelta");
	}

	public static String I_RESOURCE_DELTA_VISITOR(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.resources.IResourceDeltaVisitor");
	}

	public static String I_RESOURCE_VISITOR(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.resources.IResourceVisitor");
	}

	public static String I_SCHEDULING_RULE(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.runtime.jobs.ISchedulingRule");
	}

	public static String I_SOURCE_CONTAINER(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.sourcelookup.ISourceContainer");
	}

	public static String I_SOURCE_CONTAINER_TYPE(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.sourcelookup.ISourceContainerType");
	}

	public static String I_SOURCE_LOOKUP_DIRECTOR(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.sourcelookup.ISourceLookupDirector");
	}

	public static String I_SOURCE_LOOKUP_PARTICIPANT(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.sourcelookup.ISourceLookupParticipant");
	}

	public static String I_SOURCE_PATH_COMPUTER_DELEGATE(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.sourcelookup.ISourcePathComputerDelegate");
	}

	public static String I_STACK_FRAME(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.model.IStackFrame");
	}

	public static String I_STATUS(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.runtime.IStatus");
	}

	public static String I_STREAMS_PROXY(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.model.IStreamsProxy");
	}

	public static String I_THREAD(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.model.IThread");
	}

	public static String I_VALUE(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.model.IValue");
	}

	public static String I_VARIABLE(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.model.IVariable");
	}

	public static String I_WORKSPACE(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.resources.IWorkspace");
	}

	public static String I_WORKSPACE_ROOT(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.resources.IWorkspaceRoot");
	}

	public static String I_WORKSPACE_RUNNABLE(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.resources.IWorkspaceRunnable");
	}

	public static String IDENTITY_HASH_MAP(JavaComposite jc) {
		return getClassName(jc, "java.util.IdentityHashMap");
	}

	public static String ILLEGAL_ACCESS_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(IllegalAccessException.class);
	}

	public static String ILLEGAL_ARGUMENT_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(IllegalArgumentException.class);
	}

	public static String INCREMENTAL_PROJECT_BUILDER(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.resources.IncrementalProjectBuilder");
	}

	public static String INPUT_STREAM(JavaComposite jc) {
		return getClassName(jc, "java.io.InputStream");
	}

	public static String INPUT_STREAM_READER(JavaComposite jc) {
		return getClassName(jc, "java.io.InputStreamReader");
	}

	public static String INT_STREAM(JavaComposite jc) {
		return getClassName(jc, "org.antlr.runtime3_4_0.IntStream");
	}

	public static String INTERNAL_E_LIST(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.util.InternalEList");
	}

	public static String INTERNAL_E_OBJECT(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.InternalEObject");
	}

	public static String INVOCATION_HANDLER(JavaComposite jc) {
		return getClassName(jc, "java.lang.reflect.InvocationHandler");
	}

	public static String INVOCATION_TARGET_EXCEPTION(JavaComposite jc) {
		return getClassName(jc, "java.lang.reflect.InvocationTargetException");
	}

	public static String IO_EXCEPTION(JavaComposite jc) {
		return getClassName(jc, "java.io.IOException");
	}

	public static String JOB(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.runtime.jobs.Job");
	}

	public static String LAUNCH_CONFIGURATION_DELEGATE(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.model.LaunchConfigurationDelegate");
	}

	public static String LEXER(JavaComposite jc) {
		return getClassName(jc, "org.antlr.runtime3_4_0.Lexer");
	}

	public static String LINE_BREAKPOINT(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.model.LineBreakpoint");
	}

	public static String LINKED_LIST(JavaComposite jc) {
		return getClassName(jc, "java.util.LinkedList");
	}

	public static String LIST_ITERATOR(JavaComposite jc) {
		return getClassName(jc, "java.util.ListIterator");
	}

	public static String LISTENER_LIST(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.runtime.ListenerList");
	}

	public static String LOCALE(JavaComposite jc) {
		return getClassName(jc, "java.util.Locale");
	}

	public static String MALFORMED_URL_EXCEPTION(JavaComposite jc) {
		return getClassName(jc, "java.net.MalformedURLException");
	}

	public static String MANY_INVERSE(JavaComposite jc) {
		return jc.getClassName("org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList.ManyInverse");
	}

	public static String MAP(JavaComposite jc) {
		return getClassName(jc, "java.util.Map");
	}
	
	public static String MATCHER(JavaComposite jc) {
		return getClassName(jc, "java.util.regex.Matcher");
	}

	public static String MESSAGE_DIGEST(JavaComposite jc) {
		return getClassName(jc, "java.security.MessageDigest");
	}

	public static String METHOD(JavaComposite jc) {
		return getClassName(jc, "java.lang.reflect.Method");
	}

	public static String MISMATCHED_NOT_SET_EXCEPTION(JavaComposite jc) {
		return getClassName(jc, "org.antlr.runtime3_4_0.MismatchedNotSetException");
	}

	public static String MISMATCHED_RANGE_EXCEPTION(JavaComposite jc) {
		return getClassName(jc, "org.antlr.runtime3_4_0.MismatchedRangeException");
	}

	public static String MISMATCHED_SET_EXCEPTION(JavaComposite jc) {
		return getClassName(jc, "org.antlr.runtime3_4_0.MismatchedSetException");
	}

	public static String MISMATCHED_TOKEN_EXCEPTION(JavaComposite jc) {
		return getClassName(jc, "org.antlr.runtime3_4_0.MismatchedTokenException");
	}

	public static String MISMATCHED_TREE_NODE_EXCEPTION(JavaComposite jc) {
		return getClassName(jc, "org.antlr.runtime3_4_0.MismatchedTreeNodeException");
	}

	public static String MISSING_RESOURCE_EXCEPTION(JavaComposite jc) {
		return getClassName(jc, "java.util.MissingResourceException");
	}

	public static String MODEL_VALIDATION_SERVICE(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.validation.service.ModelValidationService");
	}

	public static String MODIFIER(JavaComposite jc) {
		return getClassName(jc, "java.lang.reflect.Modifier");
	}

	public static String NO_SUCH_ALGORITHM_EXCEPTION(JavaComposite jc) {
		return getClassName(jc, "java.security.NoSuchAlgorithmException");
	}

	public static String NO_SUCH_FIELD_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(NoSuchFieldException.class);
	}

	public static String NO_VIABLE_ALT_EXCEPTION(JavaComposite jc) {
		return getClassName(jc, "org.antlr.runtime3_4_0.NoViableAltException");
	}

	public static String NOTIFICATION(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.common.notify.Notification");
	}

	public static String NOTIFICATION_CHAIN(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.common.notify.NotificationChain");
	}

	public static String NOTIFIER(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.common.notify.Notifier");
	}

	public static String NULL_POINTER_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(NullPointerException.class);
	}

	public static String OUTPUT_STREAM(JavaComposite jc) {
		return getClassName(jc, "java.io.OutputStream");
	}

	public static String OUTPUT_STREAM_WRITER(JavaComposite jc) {
		return getClassName(jc, "java.io.OutputStreamWriter");
	}

	public static String PATH(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.runtime.Path");
	}

	public static String PATTERN(JavaComposite jc) {
		return getClassName(jc, "java.util.regex.Pattern");
	}

	public static String PLATFORM(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.runtime.Platform");
	}

	public static String PLUGIN(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.runtime.Plugin");
	}

	public static String PRINT_STREAM(JavaComposite jc) {
		return getClassName(jc, "java.io.PrintStream");
	}

	public static String PRINTER_WRITER(JavaComposite jc) {
		return getClassName(jc, "java.io.PrintWriter");
	}

	public static String PROPERTY_TESTER(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.expressions.PropertyTester");
	}

	public static String PROXY(JavaComposite jc) {
		return getClassName(jc, "java.lang.reflect.Proxy");
	}

	public static String PUSHBACK_READER(JavaComposite jc) {
		return getClassName(jc, "java.io.PushbackReader");
	}

	public static String READER(JavaComposite jc) {
		return getClassName(jc, "java.io.Reader");
	}

	public static String RECOGNITION_EXCEPTION(JavaComposite jc) {
		return getClassName(jc, "org.antlr.runtime3_4_0.RecognitionException");
	}

	public static String RECOGNIZER_SHARED_STATE(JavaComposite jc) {
		return getClassName(jc, "org.antlr.runtime3_4_0.RecognizerSharedState");
	}

	public static String RESOURCE(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.resource.Resource");
	}

	public static String RESOURCE_BUNDLE(JavaComposite jc) {
		return getClassName(jc, "java.util.ResourceBundle");
	}

	public static String RESOURCE_DIAGNOSTIC(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.resource.Resource.Diagnostic");
	}

	public static String RESOURCE_FACTORY(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.resource.Resource.Factory");
	}

	public static String RESOURCE_IMPL(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.resource.impl.ResourceImpl");
	}

	public static String RESOURCE_SET(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.resource.ResourceSet");
	}

	public static String RESOURCE_SET_IMPL(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.resource.impl.ResourceSetImpl");
	}

	public static String RESOURCES_PLUGIN(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.resources.ResourcesPlugin");
	}

	public static String RUNTIME_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(RuntimeException.class);
	}

	public static String SAFE_RUNNER(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.runtime.SafeRunner");
	}

	public static String SECURITY_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(SecurityException.class);
	}

	public static String SERVER_SOCKET(JavaComposite jc) {
		return getClassName(jc, "java.net.ServerSocket");
	}

	public static String SETTING(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.EStructuralFeature.Setting");
	}

	public static String SOCKET(JavaComposite jc) {
		return getClassName(jc, "java.net.Socket");
	}

	public static String STACK(JavaComposite jc) {
		return getClassName(jc, "java.util.Stack");
	}

	public static String STATUS(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.runtime.Status");
	}

	public static String STRING_READER(JavaComposite jc) {
		return getClassName(jc, "java.io.StringReader");
	}

	public static String STRING_WRITER(JavaComposite jc) {
		return getClassName(jc, "java.io.StringWriter");
	}

	public static String SUB_PROGRESS_MONITOR(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.core.runtime.SubProgressMonitor");
	}

	public static String TIMER(JavaComposite jc) {
		return getClassName(jc, "java.util.Timer");
	}

	public static String TIMER_TASK(JavaComposite jc) {
		return getClassName(jc, "java.util.TimerTask");
	}

	public static String TOKEN(JavaComposite jc) {
		return getClassName(jc, "org.antlr.runtime3_4_0.Token");
	}

	public static String TOKEN_STREAM(JavaComposite jc) {
		return getClassName(jc, "org.antlr.runtime3_4_0.TokenStream");
	}

	public static String TREE_MAP(JavaComposite jc) {
		return getClassName(jc, "java.util.TreeMap");
	}

	public static String UNKNOWN_HOST_EXCEPTION(JavaComposite jc) {
		return getClassName(jc, "java.net.UnknownHostException");
	}

	public static String URI(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.common.util.URI");
	}

	public static String URI_CONVERTER(JavaComposite jc) {
		return getClassName(jc, "org.eclipse.emf.ecore.resource.URIConverter");
	}

	public static String URL(JavaComposite jc) {
		return getClassName(jc, "java.net.URL");
	}

	public static String ZIP_ENTRY(JavaComposite jc) {
		return getClassName(jc, "java.util.zip.ZipEntry");
	}

	public static String ZIP_FILE(JavaComposite jc) {
		return getClassName(jc, "java.util.zip.ZipFile");
	}
}

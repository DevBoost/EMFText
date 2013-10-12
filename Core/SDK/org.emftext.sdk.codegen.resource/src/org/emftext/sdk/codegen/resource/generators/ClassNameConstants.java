/*******************************************************************************
 * Copyright (c) 2006-2013
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
package org.emftext.sdk.codegen.resource.generators;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.PushbackReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.swing.event.DocumentListener;

import org.antlr.runtime3_4_0.ANTLRInputStream;
import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.BitSet;
import org.antlr.runtime3_4_0.CommonToken;
import org.antlr.runtime3_4_0.CommonTokenStream;
import org.antlr.runtime3_4_0.EarlyExitException;
import org.antlr.runtime3_4_0.FailedPredicateException;
import org.antlr.runtime3_4_0.IntStream;
import org.antlr.runtime3_4_0.Lexer;
import org.antlr.runtime3_4_0.MismatchedNotSetException;
import org.antlr.runtime3_4_0.MismatchedRangeException;
import org.antlr.runtime3_4_0.MismatchedSetException;
import org.antlr.runtime3_4_0.MismatchedTokenException;
import org.antlr.runtime3_4_0.MismatchedTreeNodeException;
import org.antlr.runtime3_4_0.NoViableAltException;
import org.antlr.runtime3_4_0.RecognitionException;
import org.antlr.runtime3_4_0.Token;
import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.templates.editor.Editor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreValidator;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ILiveValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import de.devboost.codecomposers.java.JavaComposite;

/**
 * Constants for class names used in the generated code.
 */
@SuppressWarnings("restriction")
public class ClassNameConstants extends
		de.devboost.codecomposers.java.ClassNameConstants {

	public static String ABSTRACT_PREFERENCE_INITIALIZER(JavaComposite jc) {
		return jc.getClassName(AbstractPreferenceInitializer.class);
	}

	public static String ADAPTER(JavaComposite jc) {
		return jc.getClassName(Adapter.class);
	}

	public static String ADAPTER_IMPL(JavaComposite jc) {
		return jc.getClassName(AdapterImpl.class);
	}

	public static String ANTLR_INPUT_STREAM(JavaComposite jc) {
		return jc.getClassName(ANTLRInputStream.class);
	}

	public static String ANTLR_PARSER(JavaComposite jc) {
		return jc.getClassName(org.antlr.runtime3_4_0.Parser.class);
	}

	public static String ANTLR_STRING_STREAM(JavaComposite jc) {
		return jc.getClassName(ANTLRStringStream.class);
	}

	public static String ARRAY(JavaComposite jc) {
		return jc.getClassName(java.lang.reflect.Array.class);
	}

	public static String ARRAYS(JavaComposite jc) {
		return jc.getClassName(java.util.Arrays.class);
	}

	public static String ASSERT(JavaComposite jc) {
		return jc.getClassName(Assert.class);
	}

	public static String BASIC_COMMAND_STACK(JavaComposite jc) {
		return jc.getClassName(BasicCommandStack.class);
	}

	public static String BASIC_E_LIST(JavaComposite jc) {
		return jc.getClassName(BasicEList.class);
	}

	public static String BASIC_E_MAP(JavaComposite jc) {
		return jc.getClassName(BasicEMap.class);
	}

	public static String BASIC_E_OBJECT_IMPL(JavaComposite jc) {
		return jc.getClassName(BasicEObjectImpl.class);
	}

	public static String BASIC_INTERNAL_E_LIST(JavaComposite jc) {
		return jc.getClassName(BasicInternalEList.class);
	}

	public static String BIT_SET(JavaComposite jc) {
		return jc.getClassName(BitSet.class);
	}

	public static String BUFFERED_INPUT_STREAM(JavaComposite jc) {
		return jc.getClassName(BufferedInputStream.class);
	}

	public static String BUFFERED_OUTPUT_STREAM(JavaComposite jc) {
		return jc.getClassName(BufferedOutputStream.class);
	}

	public static String BUFFERED_READER(JavaComposite jc) {
		return jc.getClassName(BufferedReader.class);
	}

	public static String BUNDLE(JavaComposite jc) {
		return jc.getClassName(Bundle.class);
	}

	public static String BUNDLE_CONTEXT(JavaComposite jc) {
		return jc.getClassName(BundleContext.class);
	}

	public static String BYTE_ARRAY_INPUT_STREAM(JavaComposite jc) {
		return jc.getClassName(ByteArrayInputStream.class);
	}

	public static String BYTE_ARRAY_OUTPUT_STREAM(JavaComposite jc) {
		return jc.getClassName(ByteArrayOutputStream.class);
	}

	public static String CHANGE_DESCRIPTION(JavaComposite jc) {
		return jc.getClassName(ChangeDescription.class);
	}

	public static String CHANGE_RECORDER(JavaComposite jc) {
		return jc.getClassName(ChangeRecorder.class);
	}

	public static String COLLECTION(JavaComposite jc) {
		return jc.getClassName(Collection.class);
	}

	public static String COLLECTIONS(JavaComposite jc) {
		return jc.getClassName(Collections.class);
	}

	public static String COMMON_TOKEN(JavaComposite jc) {
		return jc.getClassName(CommonToken.class);
	}

	public static String COMMON_TOKEN_STREAM(JavaComposite jc) {
		return jc.getClassName(CommonTokenStream.class);
	}

	public static String COMPARABLE(JavaComposite jc) {
		return jc.getClassName(Comparable.class);
	}

	public static String COMPARATOR(JavaComposite jc) {
		return jc.getClassName(Comparator.class);
	}

	public static String CONNECT_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(ConnectException.class);
	}

	public static String CONSTRAINT_STATUS(JavaComposite jc) {
		return jc.getClassName(ConstraintStatus.class);
	}

	public static String CORE_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(CoreException.class);
	}

	public static String DIAGNOSTIC(JavaComposite jc) {
		return jc.getClassName(org.eclipse.emf.common.util.Diagnostic.class);
	}

	public static String DIAGNOSTICIAN(JavaComposite jc) {
		return jc.getClassName(org.eclipse.emf.ecore.util.Diagnostician.class);
	}

	public static String DOCUMENT_LISTENER(JavaComposite jc) {
		return jc.getClassName(DocumentListener.class);
	}

	public static String EARLY_EXIT_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(EarlyExitException.class);
	}

	public static String ECORE_FACTORY(JavaComposite jc) {
		return jc.getClassName(EcoreFactory.class);
	}

	public static String ECORE_PLUGIN(JavaComposite jc) {
		return jc.getClassName(EcorePlugin.class);
	}

	public static String ECORE_UTIL(JavaComposite jc) {
		return jc.getClassName(EcoreUtil.class);
	}

	public static String ECORE_UTIL_EQUALITY_HELPER(JavaComposite jc) {
		return jc.getClassName(EcoreUtil.EqualityHelper.class
				.getCanonicalName());
	}

	public static String ECORE_VALIDATOR(JavaComposite jc) {
		return jc.getClassName(EcoreValidator.class);
	}

	public static String EDITOR(JavaComposite jc) {
		return jc.getClassName(Editor.class);
	}

	public static String ELEMENT_BASED_TEXT_DIAGNOSTIC(JavaComposite jc) {
		return jc.getClassName("ElementBasedTextDiagnostic");
	}

	public static String EMF_MODEL_VALIDATION_PLUGIN(JavaComposite jc) {
		return jc
				.getClassName(org.eclipse.emf.validation.internal.EMFModelValidationPlugin.class);
	}

	public static String EMPTY_STACK_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(EmptyStackException.class);
	}

	public static String ENUMERATOR(JavaComposite jc) {
		return jc.getClassName(Enumerator.class);
	}

	public static String EVALUATION_MODE(JavaComposite jc) {
		return jc.getClassName(EvaluationMode.class);
	}

	public static String E_ATTRIBUTE(JavaComposite jc) {
		return jc.getClassName(EAttribute.class);
	}

	public static String E_CLASS(JavaComposite jc) {
		return jc.getClassName(EClass.class);
	}

	public static String E_CLASSIFIER(JavaComposite jc) {
		return jc.getClassName(EClassifier.class);
	}

	public static String E_DATA_TYPE(JavaComposite jc) {
		return jc.getClassName(EDataType.class);
	}

	public static String E_ENUM(JavaComposite jc) {
		return jc.getClassName(EEnum.class);
	}

	public static String E_ENUM_LITERAL(JavaComposite jc) {
		return jc.getClassName(EEnumLiteral.class);
	}

	public static String E_FACTORY(JavaComposite jc) {
		return jc.getClassName(EFactory.class);
	}

	public static String E_LIST(JavaComposite jc) {
		return jc.getClassName(EList.class);
	}

	public static String E_MAP(JavaComposite jc) {
		return jc.getClassName(EMap.class);
	}

	public static String E_NOTIFICATION_IMPL(JavaComposite jc) {
		return jc.getClassName(ENotificationImpl.class);
	}

	public static String E_OBJECT(JavaComposite jc) {
		return jc.getClassName(EObject.class);
	}

	public static String E_OBJECT_IMPL(JavaComposite jc) {
		return jc.getClassName(EObjectImpl.class);
	}

	public static String E_OPERATION(JavaComposite jc) {
		return jc.getClassName(EOperation.class);
	}

	public static String E_PACKAGE(JavaComposite jc) {
		return jc.getClassName(EPackage.class);
	}

	public static String E_REFERENCE(JavaComposite jc) {
		return jc.getClassName(EReference.class);
	}

	public static String E_STRUCTURAL_FEATURE(JavaComposite jc) {
		return jc.getClassName(EStructuralFeature.class);
	}

	public static String FAILED_PREDICATE_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(FailedPredicateException.class);
	}

	public static String FEATURE_MAP(JavaComposite jc) {
		return jc.getClassName(FeatureMap.class);
	}

	public static String FIELD(JavaComposite jc) {
		return jc.getClassName(Field.class);
	}

	public static String FILE(JavaComposite jc) {
		return jc.getClassName(File.class);
	}

	public static String FILE_INPUT_STREAM(JavaComposite jc) {
		return jc.getClassName(FileInputStream.class);
	}

	public static String FILE_LOCATOR(JavaComposite jc) {
		return jc.getClassName(FileLocator.class);
	}

	public static String FILE_NOT_FOUND_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(FileNotFoundException.class);
	}

	public static String FILE_OUTPUT_STREAM(JavaComposite jc) {
		return jc.getClassName(FileOutputStream.class);
	}

	public static String GEN_CLASS(JavaComposite jc) {
		return jc.getClassName(GenClass.class);
	}

	public static String GEN_FEATURE(JavaComposite jc) {
		return jc.getClassName(GenFeature.class);
	}

	public static String GEN_PACKAGE(JavaComposite jc) {
		return jc.getClassName(GenPackage.class);
	}

	public static String IDENTITY_HASH_MAP(JavaComposite jc) {
		return jc.getClassName(IdentityHashMap.class);
	}

	public static String ILLEGAL_ACCESS_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(IllegalAccessException.class);
	}

	public static String ILLEGAL_ARGUMENT_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(IllegalArgumentException.class);
	}

	public static String INCREMENTAL_PROJECT_BUILDER(JavaComposite jc) {
		return jc.getClassName(IncrementalProjectBuilder.class);
	}

	public static String INPUT_STREAM(JavaComposite jc) {
		return jc.getClassName(InputStream.class);
	}

	public static String INPUT_STREAM_READER(JavaComposite jc) {
		return jc.getClassName(InputStreamReader.class);
	}

	public static String INTERNAL_E_LIST(JavaComposite jc) {
		return jc.getClassName(InternalEList.class);
	}

	public static String INTERNAL_E_OBJECT(JavaComposite jc) {
		return jc.getClassName(InternalEObject.class);
	}

	public static String INT_STREAM(JavaComposite jc) {
		return jc.getClassName(IntStream.class);
	}

	public static String INVOCATION_HANDLER(JavaComposite jc) {
		return jc.getClassName(InvocationHandler.class);
	}

	public static String INVOCATION_TARGET_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(InvocationTargetException.class);
	}

	public static String IO_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(IOException.class);
	}

	public static String ITERATOR(JavaComposite jc) {
		return jc.getClassName(Iterator.class);
	}

	public static String I_ADAPTABLE(JavaComposite jc) {
		return jc.getClassName(org.eclipse.core.runtime.IAdaptable.class);
	}

	public static String I_ADAPTER_FACTORY(JavaComposite jc) {
		return jc.getClassName(IAdapterFactory.class);
	}

	public static String I_BATCH_VALIDATOR(JavaComposite jc) {
		return jc.getClassName(IBatchValidator.class);
	}

	public static String I_COMMAND(JavaComposite jc) {
		return jc.getClassName(ICommand.class);
	}

	public static String I_CONFIGURATION_ELEMENT(JavaComposite jc) {
		return jc.getClassName(IConfigurationElement.class);
	}

	public static String I_CONTAINER(JavaComposite jc) {
		return jc.getClassName(IContainer.class);
	}

	public static String I_EXECUTABLE_EXTENSION(JavaComposite jc) {
		return jc.getClassName(IExecutableExtension.class);
	}

	public static String I_EXTENSION_REGISTRY(JavaComposite jc) {
		return jc.getClassName(IExtensionRegistry.class);
	}

	public static String I_FILE(JavaComposite jc) {
		return jc.getClassName(IFile.class);
	}

	public static String I_LIVE_VALIDATOR(JavaComposite jc) {
		return jc.getClassName(ILiveValidator.class);
	}

	public static String I_MARKER(JavaComposite jc) {
		return jc.getClassName(IMarker.class);
	}

	public static String I_MARKER_DELTA(JavaComposite jc) {
		return jc.getClassName(IMarkerDelta.class);
	}

	public static String I_PATH(JavaComposite jc) {
		return jc.getClassName(IPath.class);
	}

	public static String I_PROGRESS_MONITOR(JavaComposite jc) {
		return jc.getClassName(IProgressMonitor.class);
	}

	public static String I_PROJECT(JavaComposite jc) {
		return jc.getClassName(IProject.class);
	}

	public static String I_PROJECT_DESCRIPTION(JavaComposite jc) {
		return jc.getClassName(IProjectDescription.class);
	}

	public static String I_PROJECT_NATURE(JavaComposite jc) {
		return jc.getClassName(IProjectNature.class);
	}

	public static String I_RESOURCE(JavaComposite jc) {
		return jc.getClassName(IResource.class);
	}

	public static String I_RESOURCE_CHANGE_EVENT(JavaComposite jc) {
		return jc.getClassName(IResourceChangeEvent.class);
	}

	public static String I_RESOURCE_CHANGE_LISTENER(JavaComposite jc) {
		return jc.getClassName(IResourceChangeListener.class);
	}

	public static String I_RESOURCE_DELTA(JavaComposite jc) {
		return jc.getClassName(IResourceDelta.class);
	}

	public static String I_RESOURCE_DELTA_VISITOR(JavaComposite jc) {
		return jc.getClassName(IResourceDeltaVisitor.class);
	}

	public static String I_RESOURCE_VISITOR(JavaComposite jc) {
		return jc.getClassName(IResourceVisitor.class);
	}

	public static String I_STATUS(JavaComposite jc) {
		return jc.getClassName(IStatus.class);
	}

	public static String I_WORKSPACE(JavaComposite jc) {
		return jc.getClassName(IWorkspace.class);
	}

	public static String I_WORKSPACE_ROOT(JavaComposite jc) {
		return jc.getClassName(IWorkspaceRoot.class);
	}

	public static String I_WORKSPACE_RUNNABLE(JavaComposite jc) {
		return jc.getClassName(IWorkspaceRunnable.class);
	}

	public static String JOB(JavaComposite jc) {
		return jc.getClassName(org.eclipse.core.runtime.jobs.Job.class);
	}

	public static String LEXER(JavaComposite jc) {
		return jc.getClassName(Lexer.class);
	}

	public static String LINKED_HASH_MAP(JavaComposite jc) {
		return jc.getClassName(LinkedHashMap.class);
	}

	public static String LINKED_HASH_SET(JavaComposite jc) {
		return jc.getClassName(LinkedHashSet.class);
	}

	public static String LINKED_LIST(JavaComposite jc) {
		return jc.getClassName(LinkedList.class);
	}

	public static String LISTENER_LIST(JavaComposite jc) {
		return jc.getClassName(ListenerList.class);
	}

	public static String LIST_ITERATOR(JavaComposite jc) {
		return jc.getClassName(ListIterator.class);
	}

	public static String MALFORMED_URL_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(MalformedURLException.class);
	}

	public static String MANY_INVERSE(JavaComposite jc) {
		return jc
				.getClassName(EObjectWithInverseResolvingEList.ManyInverse.class
						.getCanonicalName());
	}

	public static String MAP(JavaComposite jc) {
		return jc.getClassName(Map.class);
	}

	public static String MAP_ENTRY(JavaComposite jc) {
		return jc.getClassName(Map.Entry.class.getCanonicalName());
	}

	public static String MATCHER(JavaComposite jc) {
		return jc.getClassName(Matcher.class);
	}

	public static String MESSAGE_DIGEST(JavaComposite jc) {
		return jc.getClassName(MessageDigest.class);
	}

	public static String METHOD(JavaComposite jc) {
		return jc.getClassName(java.lang.reflect.Method.class);
	}

	public static String MISMATCHED_NOT_SET_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(MismatchedNotSetException.class);
	}

	public static String MISMATCHED_RANGE_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(MismatchedRangeException.class);
	}

	public static String MISMATCHED_SET_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(MismatchedSetException.class);
	}

	public static String MISMATCHED_TOKEN_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(MismatchedTokenException.class);
	}

	public static String MISMATCHED_TREE_NODE_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(MismatchedTreeNodeException.class);
	}

	public static String MODEL_VALIDATION_SERVICE(JavaComposite jc) {
		return jc.getClassName(ModelValidationService.class);
	}

	public static String MODIFIER(JavaComposite jc) {
		return jc.getClassName(java.lang.reflect.Modifier.class);
	}

	public static String NOTIFICATION(JavaComposite jc) {
		return jc.getClassName(Notification.class);
	}

	public static String NOTIFICATION_CHAIN(JavaComposite jc) {
		return jc.getClassName(NotificationChain.class);
	}

	public static String NOTIFIER(JavaComposite jc) {
		return jc.getClassName(Notifier.class);
	}

	public static String NO_SUCH_ALGORITHM_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(NoSuchAlgorithmException.class);
	}

	public static String NO_SUCH_FIELD_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(NoSuchFieldException.class);
	}

	public static String NO_VIABLE_ALT_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(NoViableAltException.class);
	}

	public static String NULL_POINTER_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(NullPointerException.class);
	}

	public static String OUTPUT_STREAM(JavaComposite jc) {
		return jc.getClassName(OutputStream.class);
	}

	public static String OUTPUT_STREAM_WRITER(JavaComposite jc) {
		return jc.getClassName(OutputStreamWriter.class);
	}

	public static String PATH(JavaComposite jc) {
		return jc.getClassName(Path.class);
	}

	public static String PATTERN(JavaComposite jc) {
		return jc.getClassName(java.util.regex.Pattern.class);
	}

	public static String PLATFORM(JavaComposite jc) {
		return jc.getClassName(Platform.class);
	}

	public static String PLUGIN(JavaComposite jc) {
		return jc.getClassName(Plugin.class);
	}

	public static String POSITION_BASED_TEXT_DIAGNOSTIC(JavaComposite jc) {
		return jc.getClassName("PositionBasedTextDiagnostic");
	}

	public static String PRINTER_WRITER(JavaComposite jc) {
		return jc.getClassName(PrintWriter.class);
	}

	public static String PRINT_STREAM(JavaComposite jc) {
		return jc.getClassName(PrintStream.class);
	}

	public static String PROPERTY_TESTER(JavaComposite jc) {
		return jc.getClassName(PropertyTester.class);
	}

	public static String PROXY(JavaComposite jc) {
		return jc.getClassName(Proxy.class);
	}

	public static String PUSHBACK_READER(JavaComposite jc) {
		return jc.getClassName(PushbackReader.class);
	}

	public static String READER(JavaComposite jc) {
		return jc.getClassName(Reader.class);
	}

	public static String RECOGNITION_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(RecognitionException.class);
	}

	public static String RECOGNIZER_SHARED_STATE(JavaComposite jc) {
		return jc
				.getClassName(org.antlr.runtime3_4_0.RecognizerSharedState.class);
	}

	public static String RESOLVER_SWITCH_FIELD_NAME(JavaComposite jc) {
		return jc.getClassName("resolverSwitch");
	}

	public static String RESOURCE(JavaComposite jc) {
		return jc.getClassName(org.eclipse.emf.ecore.resource.Resource.class);
	}

	public static String RESOURCES_PLUGIN(JavaComposite jc) {
		return jc.getClassName(ResourcesPlugin.class);
	}

	public static String RESOURCE_BUNDLE(JavaComposite jc) {
		return jc.getClassName(ResourceBundle.class);
	}

	public static String RESOURCE_DIAGNOSTIC(JavaComposite jc) {
		return jc.getClassName(Diagnostic.class.getCanonicalName());
	}

	public static String RESOURCE_FACTORY(JavaComposite jc) {
		return jc.getClassName(Resource.Factory.class.getCanonicalName());
	}

	public static String RESOURCE_IMPL(JavaComposite jc) {
		return jc.getClassName(ResourceImpl.class);
	}

	public static String RESOURCE_SET(JavaComposite jc) {
		return jc.getClassName(ResourceSet.class);
	}

	public static String RESOURCE_SET_IMPL(JavaComposite jc) {
		return jc.getClassName(ResourceSetImpl.class);
	}

	public static String RUNTIME_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(RuntimeException.class);
	}

	public static String SAFE_RUNNER(JavaComposite jc) {
		return jc.getClassName(SafeRunner.class);
	}

	public static String SECURITY_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(SecurityException.class);
	}

	public static String SERVER_SOCKET(JavaComposite jc) {
		return jc.getClassName(ServerSocket.class);
	}

	public static String SET(JavaComposite jc) {
		return jc.getClassName(Set.class);
	}

	public static String SETTING(JavaComposite jc) {
		return jc.getClassName(Setting.class.getCanonicalName());
	}

	public static String SOCKET(JavaComposite jc) {
		return jc.getClassName(Socket.class);
	}

	public static String STACK(JavaComposite jc) {
		return jc.getClassName(Stack.class);
	}

	public static String STATUS(JavaComposite jc) {
		return jc.getClassName(Status.class);
	}

	public static String STRING_READER(JavaComposite jc) {
		return jc.getClassName(StringReader.class);
	}

	public static String STRING_WRITER(JavaComposite jc) {
		return jc.getClassName(StringWriter.class);
	}

	public static String TIMER(JavaComposite jc) {
		return jc.getClassName(Timer.class);
	}

	public static String TIMER_TASK(JavaComposite jc) {
		return jc.getClassName(TimerTask.class);
	}

	public static String TOKEN(JavaComposite jc) {
		return jc.getClassName(Token.class);
	}

	public static String TOKEN_STREAM(JavaComposite jc) {
		return jc.getClassName(org.antlr.runtime3_4_0.TokenStream.class);
	}

	public static String TREE_MAP(JavaComposite jc) {
		return jc.getClassName(TreeMap.class);
	}

	public static String UNKNOWN_HOST_EXCEPTION(JavaComposite jc) {
		return jc.getClassName(UnknownHostException.class);
	}

	public static String URI(JavaComposite jc) {
		return jc.getClassName(org.eclipse.emf.common.util.URI.class);
	}

	public static String URI_CONVERTER(JavaComposite jc) {
		return jc.getClassName(URIConverter.class);
	}

	public static String URL(JavaComposite jc) {
		return jc.getClassName(URL.class);
	}

	public static String ZIP_ENTRY(JavaComposite jc) {
		return jc.getClassName(ZipEntry.class);
	}

	public static String ZIP_FILE(JavaComposite jc) {
		return jc.getClassName(ZipFile.class);
	}

	public static String I_SCHEDULING_RULE(JavaComposite jc) {
		return jc.getClassName(ISchedulingRule.class);
	}

	// for the classes contained in the org.eclipse.debug plug-in, we use string
	// constants instead of referencing the class objects, because this cause
	// trouble in some environments (e.g., PDE build).
	//
	// this fixes bug 1815: Replace class name constants from DebugUI plug-in
	// with static strings
	public static String ABSTRACT_SOURCE_LOOKUP_DIRECTOR(JavaComposite jc) {
		return jc
				.getClassName("org.eclipse.debug.core.sourcelookup.AbstractSourceLookupDirector");
	}

	public static String ABSTRACT_SOURCE_LOOKUP_PARTICIPANT(JavaComposite jc) {
		return jc
				.getClassName("org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant");
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

	public static String I_BREAKPOINT(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.model.IBreakpoint");
	}

	public static String I_BREAKPOINT_MANAGER(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.IBreakpointManager");
	}

	public static String I_DEBUG_TARGET(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.model.IDebugTarget");
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

	public static String I_MEMORY_BLOCK(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.model.IMemoryBlock");
	}

	public static String I_PROCESS(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.model.IProcess");
	}

	public static String I_REGISTER_GROUP(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.model.IRegisterGroup");
	}

	public static String I_SOURCE_CONTAINER(JavaComposite jc) {
		return jc
				.getClassName("org.eclipse.debug.core.sourcelookup.ISourceContainer");
	}

	public static String I_SOURCE_CONTAINER_TYPE(JavaComposite jc) {
		return jc
				.getClassName("org.eclipse.debug.core.sourcelookup.ISourceContainerType");
	}

	public static String I_SOURCE_LOOKUP_DIRECTOR(JavaComposite jc) {
		return jc
				.getClassName("org.eclipse.debug.core.sourcelookup.ISourceLookupDirector");
	}

	public static String I_SOURCE_LOOKUP_PARTICIPANT(JavaComposite jc) {
		return jc
				.getClassName("org.eclipse.debug.core.sourcelookup.ISourceLookupParticipant");
	}

	public static String I_SOURCE_PATH_COMPUTER_DELEGATE(JavaComposite jc) {
		return jc
				.getClassName("org.eclipse.debug.core.sourcelookup.ISourcePathComputerDelegate");
	}

	public static String I_STACK_FRAME(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.model.IStackFrame");
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

	public static String LAUNCH_CONFIGURATION_DELEGATE(JavaComposite jc) {
		return jc
				.getClassName("org.eclipse.debug.core.model.LaunchConfigurationDelegate");
	}

	public static String LINE_BREAKPOINT(JavaComposite jc) {
		return jc.getClassName("org.eclipse.debug.core.model.LineBreakpoint");
	}
}

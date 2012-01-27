/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

public class CsResource extends org.eclipse.emf.ecore.resource.impl.ResourceImpl implements org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource {
	
	public class ElementBasedTextDiagnostic implements org.emftext.sdk.concretesyntax.resource.cs.ICsTextDiagnostic {
		
		private final org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap locationMap;
		private final org.eclipse.emf.common.util.URI uri;
		private final org.eclipse.emf.ecore.EObject element;
		private final org.emftext.sdk.concretesyntax.resource.cs.ICsProblem problem;
		
		public ElementBasedTextDiagnostic(org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap locationMap, org.eclipse.emf.common.util.URI uri, org.emftext.sdk.concretesyntax.resource.cs.ICsProblem problem, org.eclipse.emf.ecore.EObject element) {
			super();
			this.uri = uri;
			this.locationMap = locationMap;
			this.element = element;
			this.problem = problem;
		}
		
		public String getMessage() {
			return problem.getMessage();
		}
		
		public org.emftext.sdk.concretesyntax.resource.cs.ICsProblem getProblem() {
			return problem;
		}
		
		public String getLocation() {
			return uri.toString();
		}
		
		public int getCharStart() {
			return Math.max(0, locationMap.getCharStart(element));
		}
		
		public int getCharEnd() {
			return Math.max(0, locationMap.getCharEnd(element));
		}
		
		public int getColumn() {
			return Math.max(0, locationMap.getColumn(element));
		}
		
		public int getLine() {
			return Math.max(0, locationMap.getLine(element));
		}
		
		public org.eclipse.emf.ecore.EObject getElement() {
			return element;
		}
		
		public boolean wasCausedBy(org.eclipse.emf.ecore.EObject element) {
			if (this.element == null) {
				return false;
			}
			return this.element.equals(element);
		}
		
		public String toString() {
			return getMessage() + " at " + getLocation() + " line " + getLine() + ", column " + getColumn();
		}
	}
	
	public class PositionBasedTextDiagnostic implements org.emftext.sdk.concretesyntax.resource.cs.ICsTextDiagnostic {
		
		private final org.eclipse.emf.common.util.URI uri;
		
		private int column;
		private int line;
		private int charStart;
		private int charEnd;
		private org.emftext.sdk.concretesyntax.resource.cs.ICsProblem problem;
		
		public PositionBasedTextDiagnostic(org.eclipse.emf.common.util.URI uri, org.emftext.sdk.concretesyntax.resource.cs.ICsProblem problem, int column, int line, int charStart, int charEnd) {
			
			super();
			this.uri = uri;
			this.column = column;
			this.line = line;
			this.charStart = charStart;
			this.charEnd = charEnd;
			this.problem = problem;
		}
		
		public org.emftext.sdk.concretesyntax.resource.cs.ICsProblem getProblem() {
			return problem;
		}
		
		public int getCharStart() {
			return charStart;
		}
		
		public int getCharEnd() {
			return charEnd;
		}
		
		public int getColumn() {
			return column;
		}
		
		public int getLine() {
			return line;
		}
		
		public String getLocation() {
			return uri.toString();
		}
		
		public String getMessage() {
			return problem.getMessage();
		}
		
		public boolean wasCausedBy(org.eclipse.emf.ecore.EObject element) {
			return false;
		}
		
		public String toString() {
			return getMessage() + " at " + getLocation() + " line " + getLine() + ", column " + getColumn();
		}
	}
	
	private org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolverSwitch resolverSwitch;
	private org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap locationMap;
	private int proxyCounter = 0;
	private org.emftext.sdk.concretesyntax.resource.cs.ICsTextParser parser;
	private java.util.Map<String, org.emftext.sdk.concretesyntax.resource.cs.ICsContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>> internalURIFragmentMap = new java.util.LinkedHashMap<String, org.emftext.sdk.concretesyntax.resource.cs.ICsContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>>();
	private java.util.Map<String, org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix> quickFixMap = new java.util.LinkedHashMap<String, org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix>();
	private java.util.Map<?, ?> loadOptions;
	
	/**
	 * If a post-processor is currently running, this field holds a reference to it.
	 * This reference is used to terminate post-processing if needed.
	 */
	private org.emftext.sdk.concretesyntax.resource.cs.ICsResourcePostProcessor runningPostProcessor;
	
	/**
	 * A flag to indicate whether reloading of the resource shall be cancelled.
	 */
	private boolean terminateReload = false;
	
	protected org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation metaInformation = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation();
	
	public CsResource() {
		super();
		resetLocationMap();
	}
	
	public CsResource(org.eclipse.emf.common.util.URI uri) {
		super(uri);
		resetLocationMap();
	}
	
	protected void doLoad(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		this.loadOptions = options;
		resetLocationMap();
		this.terminateReload = false;
		String encoding = getPlatformResourceEncoding();
		java.io.InputStream actualInputStream = inputStream;
		Object inputStreamPreProcessorProvider = null;
		if (options != null) {
			inputStreamPreProcessorProvider = options.get(org.emftext.sdk.concretesyntax.resource.cs.ICsOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER);
		}
		if (inputStreamPreProcessorProvider != null) {
			if (inputStreamPreProcessorProvider instanceof org.emftext.sdk.concretesyntax.resource.cs.ICsInputStreamProcessorProvider) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsInputStreamProcessorProvider provider = (org.emftext.sdk.concretesyntax.resource.cs.ICsInputStreamProcessorProvider) inputStreamPreProcessorProvider;
				org.emftext.sdk.concretesyntax.resource.cs.mopp.CsInputStreamProcessor processor = provider.getInputStreamProcessor(inputStream);
				actualInputStream = processor;
				encoding = processor.getOutputEncoding();
			}
		}
		
		parser = getMetaInformation().createParser(actualInputStream, encoding);
		parser.setOptions(options);
		org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		referenceResolverSwitch.setOptions(options);
		org.emftext.sdk.concretesyntax.resource.cs.ICsParseResult result = parser.parse();
		// dispose parser, we don't need it anymore
		parser = null;
		clearState();
		getContentsInternal().clear();
		org.eclipse.emf.ecore.EObject root = null;
		if (result != null) {
			root = result.getRoot();
			if (root != null) {
				getContentsInternal().add(root);
			}
			java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>> commands = result.getPostParseCommands();
			if (commands != null) {
				for (org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>  command : commands) {
					command.execute(this);
				}
			}
		}
		getReferenceResolverSwitch().setOptions(options);
		if (getErrors().isEmpty()) {
			runPostProcessors(options);
			if (root != null) {
				runValidators(root);
			}
		}
	}
	
	public void reload(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		try {
			isLoaded = false;
			java.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(options);
			doLoad(inputStream, loadOptions);
			resolveAfterParsing();
		} catch (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException tpe) {
			// do nothing - the resource is left unchanged if this exception is thrown
		}
		isLoaded = true;
	}
	
	public void cancelReload() {
		org.emftext.sdk.concretesyntax.resource.cs.ICsTextParser parserCopy = parser;
		if (parserCopy != null) {
			parserCopy.terminate();
		}
		this.terminateReload = true;
		org.emftext.sdk.concretesyntax.resource.cs.ICsResourcePostProcessor runningPostProcessorCopy = runningPostProcessor;
		if (runningPostProcessorCopy != null) {
			runningPostProcessorCopy.terminate();
		}
	}
	
	protected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {
		org.emftext.sdk.concretesyntax.resource.cs.ICsTextPrinter printer = getMetaInformation().createPrinter(outputStream, this);
		org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		referenceResolverSwitch.setOptions(options);
		for (org.eclipse.emf.ecore.EObject root : getContentsInternal()) {
			printer.print(root);
		}
	}
	
	protected String getSyntaxName() {
		return "cs";
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolverSwitch getReferenceResolverSwitch() {
		if (resolverSwitch == null) {
			resolverSwitch = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsReferenceResolverSwitch();
		}
		return resolverSwitch;
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation getMetaInformation() {
		return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation();
	}
	
	protected void resetLocationMap() {
		if (isLocationMapEnabled()) {
			locationMap = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLocationMap();
		} else {
			locationMap = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsDevNullLocationMap();
		}
	}
	
	public void addURIFragment(String internalURIFragment, org.emftext.sdk.concretesyntax.resource.cs.ICsContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment) {
		internalURIFragmentMap.put(internalURIFragment, uriFragment);
	}
	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(org.emftext.sdk.concretesyntax.resource.cs.ICsContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, ContainerType container, org.eclipse.emf.ecore.EReference reference, String id, org.eclipse.emf.ecore.EObject proxyElement, int position) {
		org.eclipse.emf.ecore.InternalEObject proxy = (org.eclipse.emf.ecore.InternalEObject) proxyElement;
		String internalURIFragment = org.emftext.sdk.concretesyntax.resource.cs.ICsContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX + (proxyCounter++) + "_" + id;
		org.emftext.sdk.concretesyntax.resource.cs.ICsContextDependentURIFragment<?> uriFragment = factory.create(id, container, reference, position, proxy);
		proxy.eSetProxyURI(getURI().appendFragment(internalURIFragment));
		addURIFragment(internalURIFragment, uriFragment);
	}
	
	public org.eclipse.emf.ecore.EObject getEObject(String id) {
		if (internalURIFragmentMap.containsKey(id)) {
			org.emftext.sdk.concretesyntax.resource.cs.ICsContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment = internalURIFragmentMap.get(id);
			boolean wasResolvedBefore = uriFragment.isResolved();
			org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result = null;
			// catch and report all Exceptions that occur during proxy resolving
			try {
				result = uriFragment.resolve();
			} catch (Exception e) {
				String message = "An expection occured while resolving the proxy for: "+ id + ". (" + e.toString() + ")";
				addProblem(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsProblem(message, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType.UNRESOLVED_REFERENCE, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemSeverity.ERROR), uriFragment.getProxy());
				new org.emftext.sdk.concretesyntax.resource.cs.util.CsRuntimeUtil().logError(message, e);
			}
			if (result == null) {
				// the resolving did call itself
				return null;
			}
			if (!wasResolvedBefore && !result.wasResolved()) {
				attachResolveError(result, uriFragment.getProxy());
				return null;
			} else if (!result.wasResolved()) {
				return null;
			} else {
				org.eclipse.emf.ecore.EObject proxy = uriFragment.getProxy();
				// remove an error that might have been added by an earlier attempt
				removeDiagnostics(proxy, getErrors());
				// remove old warnings and attach new
				removeDiagnostics(proxy, getWarnings());
				attachResolveWarnings(result, proxy);
				org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping = result.getMappings().iterator().next();
				org.eclipse.emf.ecore.EObject resultElement = getResultElement(uriFragment, mapping, proxy, result.getErrorMessage());
				org.eclipse.emf.ecore.EObject container = uriFragment.getContainer();
				replaceProxyInLayoutAdapters(container, proxy, resultElement);
				return resultElement;
			}
		} else {
			return super.getEObject(id);
		}
	}
	
	protected void replaceProxyInLayoutAdapters(org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EObject proxy, org.eclipse.emf.ecore.EObject target) {
		for (org.eclipse.emf.common.notify.Adapter adapter : container.eAdapters()) {
			if (adapter instanceof org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter) {
				org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter) adapter;
				layoutInformationAdapter.replaceProxy(proxy, target);
			}
		}
	}
	
	protected org.eclipse.emf.ecore.EObject getResultElement(org.emftext.sdk.concretesyntax.resource.cs.ICsContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment, org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping, org.eclipse.emf.ecore.EObject proxy, final String errorMessage) {
		if (mapping instanceof org.emftext.sdk.concretesyntax.resource.cs.ICsURIMapping<?>) {
			org.eclipse.emf.common.util.URI uri = ((org.emftext.sdk.concretesyntax.resource.cs.ICsURIMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetIdentifier();
			if (uri != null) {
				org.eclipse.emf.ecore.EObject result = null;
				try {
					result = this.getResourceSet().getEObject(uri, true);
				} catch (Exception e) {
					// we can catch exceptions here, because EMF will try to resolve again and handle
					// the exception
				}
				if (result == null || result.eIsProxy()) {
					// unable to resolve: attach error
					if (errorMessage == null) {
						assert(false);
					} else {
						addProblem(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsProblem(errorMessage, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType.UNRESOLVED_REFERENCE, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemSeverity.ERROR), proxy);
					}
				}
				return result;
			}
			return null;
		} else if (mapping instanceof org.emftext.sdk.concretesyntax.resource.cs.ICsElementMapping<?>) {
			org.eclipse.emf.ecore.EObject element = ((org.emftext.sdk.concretesyntax.resource.cs.ICsElementMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetElement();
			org.eclipse.emf.ecore.EReference reference = uriFragment.getReference();
			org.eclipse.emf.ecore.EReference oppositeReference = uriFragment.getReference().getEOpposite();
			if (!uriFragment.getReference().isContainment() && oppositeReference != null) {
				if (reference.isMany()) {
					org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList.ManyInverse<org.eclipse.emf.ecore.EObject> list = org.emftext.sdk.concretesyntax.resource.cs.util.CsCastUtil.cast(element.eGet(oppositeReference, false));										// avoids duplicate entries in the reference caused by adding to the
					// oppositeReference
					list.basicAdd(uriFragment.getContainer(),null);
				} else {
					uriFragment.getContainer().eSet(uriFragment.getReference(), element);
				}
			}
			return element;
		} else {
			assert(false);
			return null;
		}
	}
	
	protected void removeDiagnostics(org.eclipse.emf.ecore.EObject cause, java.util.List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> diagnostics) {
		// remove all errors/warnings from this resource
		for (org.eclipse.emf.ecore.resource.Resource.Diagnostic errorCand : new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(diagnostics)) {
			if (errorCand instanceof org.emftext.sdk.concretesyntax.resource.cs.ICsTextDiagnostic) {
				if (((org.emftext.sdk.concretesyntax.resource.cs.ICsTextDiagnostic) errorCand).wasCausedBy(cause)) {
					diagnostics.remove(errorCand);
					if (new org.emftext.sdk.concretesyntax.resource.cs.util.CsRuntimeUtil().isEclipsePlatformAvailable()) {
						org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMarkerHelper.unmark(this, cause);
					}
				}
			}
		}
	}
	
	protected void attachResolveError(org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult<?> result, org.eclipse.emf.ecore.EObject proxy) {
		// attach errors to this resource
		assert result != null;
		final String errorMessage = result.getErrorMessage();
		if (errorMessage == null) {
			assert(false);
		} else {
			addProblem(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsProblem(errorMessage, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType.UNRESOLVED_REFERENCE, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemSeverity.ERROR, result.getQuickFixes()), proxy);
		}
	}
	
	protected void attachResolveWarnings(org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result, org.eclipse.emf.ecore.EObject proxy) {
		assert result != null;
		assert result.wasResolved();
		if (result.wasResolved()) {
			for (org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping : result.getMappings()) {
				final String warningMessage = mapping.getWarning();
				if (warningMessage == null) {
					continue;
				}
				addProblem(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsProblem(warningMessage, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType.UNRESOLVED_REFERENCE, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemSeverity.WARNING), proxy);
			}
		}
	}
	
	/**
	 * Extends the super implementation by clearing all information about element
	 * positions.
	 */
	protected void doUnload() {
		super.doUnload();
		clearState();
		loadOptions = null;
	}
	
	protected void runPostProcessors(java.util.Map<?, ?> loadOptions) {
		if (new org.emftext.sdk.concretesyntax.resource.cs.util.CsRuntimeUtil().isEclipsePlatformAvailable()) {
			org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMarkerHelper.unmark(this, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType.ANALYSIS_PROBLEM);
		}
		if (terminateReload) {
			return;
		}
		// first, run the generated post processor
		runPostProcessor(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResourcePostProcessor());
		if (loadOptions == null) {
			return;
		}
		// then, run post processors that are registered via the load options extension
		// point
		Object resourcePostProcessorProvider = loadOptions.get(org.emftext.sdk.concretesyntax.resource.cs.ICsOptions.RESOURCE_POSTPROCESSOR_PROVIDER);
		if (resourcePostProcessorProvider != null) {
			if (resourcePostProcessorProvider instanceof org.emftext.sdk.concretesyntax.resource.cs.ICsResourcePostProcessorProvider) {
				runPostProcessor(((org.emftext.sdk.concretesyntax.resource.cs.ICsResourcePostProcessorProvider) resourcePostProcessorProvider).getResourcePostProcessor());
			} else if (resourcePostProcessorProvider instanceof java.util.Collection<?>) {
				java.util.Collection<?> resourcePostProcessorProviderCollection = (java.util.Collection<?>) resourcePostProcessorProvider;
				for (Object processorProvider : resourcePostProcessorProviderCollection) {
					if (terminateReload) {
						return;
					}
					if (processorProvider instanceof org.emftext.sdk.concretesyntax.resource.cs.ICsResourcePostProcessorProvider) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsResourcePostProcessorProvider csProcessorProvider = (org.emftext.sdk.concretesyntax.resource.cs.ICsResourcePostProcessorProvider) processorProvider;
						org.emftext.sdk.concretesyntax.resource.cs.ICsResourcePostProcessor postProcessor = csProcessorProvider.getResourcePostProcessor();
						runPostProcessor(postProcessor);
					}
				}
			}
		}
	}
	
	protected void runPostProcessor(org.emftext.sdk.concretesyntax.resource.cs.ICsResourcePostProcessor postProcessor) {
		try {
			this.runningPostProcessor = postProcessor;
			postProcessor.process(this);
		} catch (Exception e) {
			new org.emftext.sdk.concretesyntax.resource.cs.util.CsRuntimeUtil().logError("Exception while running a post-processor.", e);
		}
		this.runningPostProcessor = null;
	}
	
	public void load(java.util.Map<?, ?> options) throws java.io.IOException {
		java.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(options);
		super.load(loadOptions);
		resolveAfterParsing();
	}
	
	protected void resolveAfterParsing() {
	}
	
	public void setURI(org.eclipse.emf.common.util.URI uri) {
		// because of the context dependent proxy resolving it is essential to resolve all
		// proxies before the URI is changed which can cause loss of object identities
		org.eclipse.emf.ecore.util.EcoreUtil.resolveAll(this);
		super.setURI(uri);
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void addProblem(org.emftext.sdk.concretesyntax.resource.cs.ICsProblem problem, org.eclipse.emf.ecore.EObject element) {
		ElementBasedTextDiagnostic diagnostic = new ElementBasedTextDiagnostic(locationMap, getURI(), problem, element);
		getDiagnostics(problem.getSeverity()).add(diagnostic);
		if (new org.emftext.sdk.concretesyntax.resource.cs.util.CsRuntimeUtil().isEclipsePlatformAvailable() && isMarkerCreationEnabled()) {
			org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMarkerHelper.mark(this, diagnostic);
		}
		addQuickFixesToQuickFixMap(problem);
	}
	
	public void addProblem(org.emftext.sdk.concretesyntax.resource.cs.ICsProblem problem, int column, int line, int charStart, int charEnd) {
		PositionBasedTextDiagnostic diagnostic = new PositionBasedTextDiagnostic(getURI(), problem, column, line, charStart, charEnd);
		getDiagnostics(problem.getSeverity()).add(diagnostic);
		if (new org.emftext.sdk.concretesyntax.resource.cs.util.CsRuntimeUtil().isEclipsePlatformAvailable() && isMarkerCreationEnabled()) {
			org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMarkerHelper.mark(this, diagnostic);
		}
		addQuickFixesToQuickFixMap(problem);
	}
	
	protected void addQuickFixesToQuickFixMap(org.emftext.sdk.concretesyntax.resource.cs.ICsProblem problem) {
		java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix> quickFixes = problem.getQuickFixes();
		if (quickFixes != null) {
			for (org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix quickFix : quickFixes) {
				if (quickFix != null) {
					quickFixMap.put(quickFix.getContextAsString(), quickFix);
				}
			}
		}
	}
	
	@Deprecated	
	public void addError(String message, org.eclipse.emf.ecore.EObject cause) {
		addError(message, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType.UNKNOWN, cause);
	}
	
	public void addError(String message, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType type, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsProblem(message, type, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemSeverity.ERROR), cause);
	}
	
	@Deprecated	
	public void addWarning(String message, org.eclipse.emf.ecore.EObject cause) {
		addWarning(message, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType.UNKNOWN, cause);
	}
	
	public void addWarning(String message, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType type, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsProblem(message, type, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemSeverity.WARNING), cause);
	}
	
	protected java.util.List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getDiagnostics(org.emftext.sdk.concretesyntax.resource.cs.CsEProblemSeverity severity) {
		if (severity == org.emftext.sdk.concretesyntax.resource.cs.CsEProblemSeverity.ERROR) {
			return getErrors();
		} else {
			return getWarnings();
		}
	}
	
	protected java.util.Map<Object, Object> addDefaultLoadOptions(java.util.Map<?, ?> loadOptions) {
		java.util.Map<Object, Object> loadOptionsCopy = org.emftext.sdk.concretesyntax.resource.cs.util.CsMapUtil.copySafelyToObjectToObjectMap(loadOptions);
		// first add static option provider
		loadOptionsCopy.putAll(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsOptionProvider().getOptions());
		
		// second, add dynamic option providers that are registered via extension
		if (new org.emftext.sdk.concretesyntax.resource.cs.util.CsRuntimeUtil().isEclipsePlatformAvailable()) {
			new org.emftext.sdk.concretesyntax.resource.cs.util.CsEclipseProxy().getDefaultLoadOptionProviderExtensions(loadOptionsCopy);
		}
		return loadOptionsCopy;
	}
	
	/**
	 * Extends the super implementation by clearing all information about element
	 * positions.
	 */
	protected void clearState() {
		// clear concrete syntax information
		resetLocationMap();
		internalURIFragmentMap.clear();
		getErrors().clear();
		getWarnings().clear();
		if (new org.emftext.sdk.concretesyntax.resource.cs.util.CsRuntimeUtil().isEclipsePlatformAvailable() && isMarkerCreationEnabled()) {
			org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMarkerHelper.unmark(this, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType.UNKNOWN);
			org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMarkerHelper.unmark(this, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType.SYNTAX_ERROR);
			org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMarkerHelper.unmark(this, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType.UNRESOLVED_REFERENCE);
		}
		proxyCounter = 0;
		resolverSwitch = null;
	}
	
	/**
	 * Returns a copy of the contents of this resource wrapped in a list that
	 * propagates changes to the original resource list. Wrapping is required to make
	 * sure that clients which obtain a reference to the list of contents do not
	 * interfere when changing the list.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.EObject> getContents() {
		return new org.emftext.sdk.concretesyntax.resource.cs.util.CsCopiedEObjectInternalEList((org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.EObject>) super.getContents());
	}
	
	/**
	 * Returns the raw contents of this resource.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.EObject> getContentsInternal() {
		return super.getContents();
	}
	
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getWarnings() {
		return new org.emftext.sdk.concretesyntax.resource.cs.util.CsCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getWarnings());
	}
	
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getErrors() {
		return new org.emftext.sdk.concretesyntax.resource.cs.util.CsCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getErrors());
	}
	
	protected void runValidators(org.eclipse.emf.ecore.EObject root) {
		// checking constraints provided by EMF validator classes was disabled by option
		// 'disableEValidators'.
		
		// checking EMF validation constraints was disabled either by option
		// 'disableEMFValidationConstraints' or 'removeEclipseDependentCode'.
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix getQuickFix(String quickFixContext) {
		return quickFixMap.get(quickFixContext);
	}
	
	public boolean isMarkerCreationEnabled() {
		if (loadOptions == null) {
			return true;
		}
		return !loadOptions.containsKey(org.emftext.sdk.concretesyntax.resource.cs.ICsOptions.DISABLE_CREATING_MARKERS_FOR_PROBLEMS);
	}
	
	protected boolean isLocationMapEnabled() {
		if (loadOptions == null) {
			return true;
		}
		return !loadOptions.containsKey(org.emftext.sdk.concretesyntax.resource.cs.ICsOptions.DISABLE_LOCATION_MAP);
	}
	
	/**
	 * Returns the encoding for this resource that is specified in the workspace file
	 * properties or determined by the default workspace encoding in Eclipse.
	 */
	protected String getPlatformResourceEncoding() {
		if (uri.isPlatform()) {
			String platformString = uri.toPlatformString(true);
			org.eclipse.core.resources.IResource platformResource = org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
			if (platformResource instanceof org.eclipse.core.resources.IFile) {
				org.eclipse.core.resources.IFile file = (org.eclipse.core.resources.IFile) platformResource;
				try {
					return file.getCharset();
				} catch (org.eclipse.core.runtime.CoreException ce) {
					new org.emftext.sdk.concretesyntax.resource.cs.util.CsRuntimeUtil().logWarning("Could not determine encoding of platform resource: " + uri.toString(), ce);
				}
			}
		}
		return null;
	}
	
}

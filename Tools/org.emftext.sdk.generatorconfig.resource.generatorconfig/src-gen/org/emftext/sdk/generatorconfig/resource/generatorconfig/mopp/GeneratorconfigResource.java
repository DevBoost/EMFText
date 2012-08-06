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
package org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp;

public class GeneratorconfigResource extends org.eclipse.emf.ecore.resource.impl.ResourceImpl implements org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource {

	public class ElementBasedTextDiagnostic implements org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextDiagnostic {

		private final org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigLocationMap locationMap;
		private final org.eclipse.emf.common.util.URI uri;
		private final org.eclipse.emf.ecore.EObject element;
		private final org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigProblem problem;

		public ElementBasedTextDiagnostic(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigLocationMap locationMap, org.eclipse.emf.common.util.URI uri, org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigProblem problem, org.eclipse.emf.ecore.EObject element) {
			super();
			this.uri = uri;
			this.locationMap = locationMap;
			this.element = element;
			this.problem = problem;
		}

		public java.lang.String getMessage() {
			return problem.getMessage();
		}

		public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigProblem getProblem() {
			return problem;
		}

		public java.lang.String getLocation() {
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

		public boolean wasCausedBy(org.eclipse.emf.ecore.EObject element) {
			if (this.element == null) {
				return false;
			}
			return this.element.equals(element);
		}
	}

	public class PositionBasedTextDiagnostic implements org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextDiagnostic {

		private final org.eclipse.emf.common.util.URI uri;

		private int column;
		private int line;
		private int charStart;
		private int charEnd;
		private org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigProblem problem;

		public PositionBasedTextDiagnostic(org.eclipse.emf.common.util.URI uri, org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigProblem problem, int column, int line, int charStart, int charEnd) {

			super();
			this.uri = uri;
			this.column = column;
			this.line = line;
			this.charStart = charStart;
			this.charEnd = charEnd;
			this.problem = problem;
		}

		public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigProblem getProblem() {
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

		public java.lang.String getLocation() {
			return uri.toString();
		}

		public java.lang.String getMessage() {
			return problem.getMessage();
		}

		public boolean wasCausedBy(org.eclipse.emf.ecore.EObject element) {
			return false;
		}
	}

	private org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceResolverSwitch resolverSwitch;
	private org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigLocationMap locationMap;
	private int proxyCounter = 0;
	private org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextParser parser;
	private java.util.Map<java.lang.String, org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>> internalURIFragmentMap = new java.util.HashMap<java.lang.String, org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>>();

	public GeneratorconfigResource() {
		super();
		resetLocationMap();
	}

	public GeneratorconfigResource(org.eclipse.emf.common.util.URI uri) {
		super(uri);
		resetLocationMap();
	}

	protected void doLoad(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		java.lang.String encoding = null;
		java.io.InputStream actualInputStream = inputStream;
		java.lang.Object inputStreamPreProcessorProvider = null;
		if (options!=null) {
			inputStreamPreProcessorProvider = options.get(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER);
		}
		if (inputStreamPreProcessorProvider != null) {
			if (inputStreamPreProcessorProvider instanceof org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigInputStreamProcessorProvider) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigInputStreamProcessorProvider provider = (org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigInputStreamProcessorProvider) inputStreamPreProcessorProvider;
				org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigInputStreamProcessor processor = provider.getInputStreamProcessor(inputStream);
				actualInputStream = processor;
				encoding = processor.getOutputEncoding();
			}
		}

		parser = getMetaInformation().createParser(actualInputStream, encoding);
		parser.setOptions(options);
		org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		referenceResolverSwitch.setOptions(options);
		org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigParseResult result = parser.parse();
		clearState();
		getContents().clear();
		if (result != null) {
			org.eclipse.emf.ecore.EObject root = result.getRoot();
			if (root != null) {
				getContents().add(root);
			}
			java.util.Collection<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigCommand<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource>> commands = result.getPostParseCommands();
			if (commands != null) {
				for (org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigCommand<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource>  command : commands) {
					command.execute(this);
				}
			}
		}
		getReferenceResolverSwitch().setOptions(options);
		if (getErrors().isEmpty()) {
			runPostProcessors(options);
		}
	}

	public void reload(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		try {
			isLoaded = false;
			java.util.Map<java.lang.Object, java.lang.Object> loadOptions = addDefaultLoadOptions(options);
			doLoad(inputStream, loadOptions);
		} catch (org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException tpe) {
			// do nothing - the resource is left unchanged if this exception is thrown
		}
		isLoaded = true;
	}

	public void cancelReload() {
		org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextParser parserCopy = parser;
		parserCopy.terminate();
	}

	protected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {
		org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigPrinter printer = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigPrinter(outputStream, this);
		org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		referenceResolverSwitch.setOptions(options);
		for(org.eclipse.emf.ecore.EObject root : getContents()) {
			printer.print(root);
		}
	}

	protected String getSyntaxName() {
		return "generatorconfig";
	}

	public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceResolverSwitch getReferenceResolverSwitch() {
		if (resolverSwitch == null) {
			resolverSwitch = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigReferenceResolverSwitch();
		}
		return resolverSwitch;
	}

	public org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigMetaInformation getMetaInformation() {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigMetaInformation();
	}

	protected void resetLocationMap() {
		locationMap = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigLocationMap();
	}

	public void addURIFragment(java.lang.String internalURIFragment, org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment) {
		internalURIFragmentMap.put(internalURIFragment, uriFragment);
	}

	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, ContainerType container, org.eclipse.emf.ecore.EReference reference, java.lang.String id, org.eclipse.emf.ecore.EObject proxyElement) {
		int pos = -1;
		if (reference.isMany()) {
			pos = ((java.util.List<?>)container.eGet(reference)).size();
		}
		org.eclipse.emf.ecore.InternalEObject proxy = (org.eclipse.emf.ecore.InternalEObject) proxyElement;
		java.lang.String internalURIFragment = org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX + (proxyCounter++) + "_" + id;
		org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigContextDependentURIFragment<?> uriFragment = factory.create(id, container, reference, pos, proxy);
		proxy.eSetProxyURI(getURI().appendFragment(internalURIFragment));
		addURIFragment(internalURIFragment, uriFragment);
	}

	public org.eclipse.emf.ecore.EObject getEObject(String id) {
		if (internalURIFragmentMap.containsKey(id)) {
			org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment = internalURIFragmentMap.get(id);
			boolean wasResolvedBefore = uriFragment.isResolved();
			org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result = uriFragment.resolve();
			if (result == null) {
				//the resolving did call itself
				return null;
			}
			if (!wasResolvedBefore && !result.wasResolved()) {
				attachErrors(result, uriFragment.getProxy());
				return null;
			} else if (!result.wasResolved()) {
				return null;
			} else {
				//remove an error that might have been added by an earlier attempt
				removeDiagnostics(uriFragment.getProxy(), getErrors());
				//remove old warnings and attach new
				removeDiagnostics(uriFragment.getProxy(), getWarnings());
				attachWarnings(result, uriFragment.getProxy());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping = result.getMappings().iterator().next();
				return getResultElement(uriFragment, mapping, uriFragment.getProxy(), result.getErrorMessage());
			}
		} else {
			return super.getEObject(id);
		}
	}

	private org.eclipse.emf.ecore.EObject getResultElement(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment, org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping, org.eclipse.emf.ecore.EObject proxy, final java.lang.String errorMessage) {
		if (mapping instanceof org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigURIMapping<?>) {
			org.eclipse.emf.common.util.URI uri = ((org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigURIMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetIdentifier();
			if (uri != null) {
				org.eclipse.emf.ecore.EObject result = null;
				try {
					result = this.getResourceSet().getEObject(uri, true);
				} catch (java.lang.Exception e) {
					//we can catch exceptions here, because EMF will try to resolve again and handle the exception
				}
				if (result == null || result.eIsProxy()) {
					//unable to resolve: attach error
					if (errorMessage == null) {
						assert(false);
					} else {
						addProblem(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigProblem(errorMessage, org.emftext.sdk.generatorconfig.resource.generatorconfig.GeneratorconfigEProblemType.ERROR), proxy);
					}
				}
				return result;
			}
			return null;
		} else if (mapping instanceof org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigElementMapping<?>) {
			org.eclipse.emf.ecore.EObject element = ((org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigElementMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetElement();
			org.eclipse.emf.ecore.EReference reference = uriFragment.getReference();
			org.eclipse.emf.ecore.EReference oppositeReference = uriFragment.getReference().getEOpposite();
			if (!uriFragment.getReference().isContainment() && oppositeReference != null) {
				if (reference.isMany()) {
					org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList.ManyInverse<org.eclipse.emf.ecore.EObject> list = org.emftext.sdk.generatorconfig.resource.generatorconfig.util.GeneratorconfigCastUtil.cast(element.eGet(oppositeReference, false));										//avoids duplicate entries in the reference caused by adding to the oppositeReference
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

	private void removeDiagnostics(org.eclipse.emf.ecore.EObject proxy, java.util.List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> diagnostics) {
		// remove errors/warnings from resource
		for (org.eclipse.emf.ecore.resource.Resource.Diagnostic errorCand : new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(diagnostics)) {
			if (errorCand instanceof org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextDiagnostic) {
				if (((org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextDiagnostic) errorCand).wasCausedBy(proxy)) {
					diagnostics.remove(errorCand);
				}
			}
		}
	}

	private void attachErrors(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceResolveResult<?> result, org.eclipse.emf.ecore.EObject proxy) {
		// attach errors to resource
		assert result != null;
		final java.lang.String errorMessage = result.getErrorMessage();
		if (errorMessage == null) {
			assert(false);
		} else {
			addProblem(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigProblem(errorMessage, org.emftext.sdk.generatorconfig.resource.generatorconfig.GeneratorconfigEProblemType.ERROR), proxy);
		}
	}

	private void attachWarnings(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result, org.eclipse.emf.ecore.EObject proxy) {
		assert result != null;
		assert result.wasResolved();
		if (result.wasResolved()) {
			for (org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping : result.getMappings()) {
				final java.lang.String warningMessage = mapping.getWarning();
				if (warningMessage == null) {
					continue;
				}
				addProblem(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigProblem(warningMessage, org.emftext.sdk.generatorconfig.resource.generatorconfig.GeneratorconfigEProblemType.ERROR), proxy);
			}
		}
	}

	// Extends the super implementation by clearing all information about element positions.
	protected void doUnload() {
		super.doUnload();
		clearState();
	}

	protected void runPostProcessors(java.util.Map<?, ?> loadOptions) {
		if (loadOptions == null) {
			return;
		}
		java.lang.Object resourcePostProcessorProvider = loadOptions.get(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigOptions.RESOURCE_POSTPROCESSOR_PROVIDER);
		if (resourcePostProcessorProvider != null) {
			if (resourcePostProcessorProvider instanceof org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigResourcePostProcessorProvider) {
				((org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigResourcePostProcessorProvider) resourcePostProcessorProvider).getResourcePostProcessor().process(this);
			} else if (resourcePostProcessorProvider instanceof java.util.Collection<?>) {
				java.util.Collection<?> resourcePostProcessorProviderCollection = (java.util.Collection<?>) resourcePostProcessorProvider;
				for (Object processorProvider : resourcePostProcessorProviderCollection) {
					if (processorProvider instanceof org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigResourcePostProcessorProvider) {
						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigResourcePostProcessorProvider csProcessorProvider = (org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigResourcePostProcessorProvider) processorProvider;
						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigResourcePostProcessor postProcessor = csProcessorProvider.getResourcePostProcessor();
						try {
							postProcessor.process(this);
						} catch (java.lang.Exception e) {
							org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigPlugin.logError("Exception while running a post-processor.", e);
						}
					}
				}
			}
		}
	}

	public void load(java.util.Map<?, ?> options) throws java.io.IOException {
		java.util.Map<java.lang.Object, java.lang.Object> loadOptions = addDefaultLoadOptions(options);
		super.load(loadOptions);
	}

	public void setURI(org.eclipse.emf.common.util.URI uri) {
		//because of the context dependent proxy resolving it is
		//essential to resolve all proxies before the URI is changed
		//which can cause loss of object identities
		org.eclipse.emf.ecore.util.EcoreUtil.resolveAll(this);
		super.setURI(uri);
	}

	public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigLocationMap getLocationMap() {
		return locationMap;
	}

	public void addProblem(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigProblem problem, org.eclipse.emf.ecore.EObject element) {
		getDiagnostics(problem.getType()).add(new ElementBasedTextDiagnostic(locationMap, getURI(), problem, element));
	}

	public void addProblem(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigProblem problem, int column, int line, int charStart, int charEnd) {
		getDiagnostics(problem.getType()).add(new PositionBasedTextDiagnostic(getURI(), problem, column, line, charStart, charEnd));
	}

	public void addError(java.lang.String message, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigProblem(message, org.emftext.sdk.generatorconfig.resource.generatorconfig.GeneratorconfigEProblemType.ERROR), cause);
	}

	public void addWarning(java.lang.String message, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigProblem(message, org.emftext.sdk.generatorconfig.resource.generatorconfig.GeneratorconfigEProblemType.WARNING), cause);
	}

	private java.util.List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getDiagnostics(org.emftext.sdk.generatorconfig.resource.generatorconfig.GeneratorconfigEProblemType type) {
		if (type == org.emftext.sdk.generatorconfig.resource.generatorconfig.GeneratorconfigEProblemType.ERROR) {
			return getErrors();
		} else {
			return getWarnings();
		}
	}

	protected java.util.Map<java.lang.Object, java.lang.Object> addDefaultLoadOptions(java.util.Map<?, ?> loadOptions) {
		java.util.Map<java.lang.Object, java.lang.Object> loadOptionsCopy = org.emftext.sdk.generatorconfig.resource.generatorconfig.util.GeneratorconfigMapUtil.copySafelyToObjectToObjectMap(loadOptions);
		if (org.eclipse.core.runtime.Platform.isRunning()) {
			// find default load option providers
			org.eclipse.core.runtime.IExtensionRegistry extensionRegistry = org.eclipse.core.runtime.Platform.getExtensionRegistry();
			org.eclipse.core.runtime.IConfigurationElement configurationElements[] = extensionRegistry.getConfigurationElementsFor(org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigPlugin.EP_DEFAULT_LOAD_OPTIONS_ID);
			for (org.eclipse.core.runtime.IConfigurationElement element : configurationElements) {
				try {
					org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigOptionProvider provider = (org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigOptionProvider) element.createExecutableExtension("class");
					final java.util.Map<?, ?> options = provider.getOptions();
					final java.util.Collection<?> keys = options.keySet();
					for (java.lang.Object key : keys) {
						addLoadOption(loadOptionsCopy, key, options.get(key));
					}
				} catch (org.eclipse.core.runtime.CoreException ce) {
					org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigPlugin.logError("Exception while getting default options.", ce);
				}
			}
		}
		return loadOptionsCopy;
	}

	// Adds a new key,value pair to the list of options. If there
	// is already an option with the same key, the two values are
	// collected in a list.
	private void addLoadOption(java.util.Map<java.lang.Object, java.lang.Object> options,java.lang.Object key, java.lang.Object value) {
		// check if there is already an option set
		if (options.containsKey(key)) {
			java.lang.Object currentValue = options.get(key);
			if (currentValue instanceof java.util.List<?>) {
				// if the current value is a list, we add the new value to
				// this list
				java.util.List<?> currentValueAsList = (java.util.List<?>) currentValue;
				java.util.List<java.lang.Object> currentValueAsObjectList = org.emftext.sdk.generatorconfig.resource.generatorconfig.util.GeneratorconfigListUtil.copySafelyToObjectList(currentValueAsList);
				if (value instanceof java.util.Collection<?>) {
					currentValueAsObjectList.addAll((java.util.Collection<?>) value);
				} else {
					currentValueAsObjectList.add(value);
				}
				options.put(key, currentValueAsObjectList);
			} else {
				// if the current value is not a list, we create a fresh list
				// and add both the old (current) and the new value to this list
				java.util.List<java.lang.Object> newValueList = new java.util.ArrayList<java.lang.Object>();
				newValueList.add(currentValue);
				if (value instanceof java.util.Collection<?>) {
					newValueList.addAll((java.util.Collection<?>) value);
				} else {
					newValueList.add(value);
				}
				options.put(key, newValueList);
			}
		} else {
			options.put(key, value);
		}
	}

	// Extends the super implementation by clearing all information about element positions.
	protected void clearState() {
		//clear concrete syntax information
		resetLocationMap();
		internalURIFragmentMap.clear();
		getErrors().clear();
		getWarnings().clear();
		proxyCounter = 0;
		resolverSwitch = null;
	}

	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.EObject> getContents() {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.util.GeneratorconfigCopiedEObjectInternalEList((org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.EObject>) super.getContents());
	}

	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getWarnings() {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.util.GeneratorconfigCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getWarnings());
	}

	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getErrors() {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.util.GeneratorconfigCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getErrors());
	}

}

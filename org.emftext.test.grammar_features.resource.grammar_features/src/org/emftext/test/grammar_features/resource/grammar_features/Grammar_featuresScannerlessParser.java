package org.emftext.test.grammar_features.resource.grammar_features;

public class Grammar_featuresScannerlessParser extends org.emftext.runtime.resource.impl.AbstractEMFTextParser {
	
	public interface ICommandContext {
		
		public org.eclipse.emf.ecore.EObject getCurrentContainer();
		
		public org.eclipse.emf.ecore.EObject getCurrentObject();
		
		public void pushCurrentContainer(org.eclipse.emf.ecore.EObject newContainer);
		
		public void popCurrentContainer();
	}
	
	public static class CommandContext implements ICommandContext {
		
		private java.util.Stack<org.eclipse.emf.ecore.EObject> containerStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
		private org.eclipse.emf.ecore.EObject currentObject;
		
		public org.eclipse.emf.ecore.EObject getCurrentContainer() {
			if (containerStack.isEmpty()) {
				return null;
			} else {
				return containerStack.peek();
			}
		}
		
		public org.eclipse.emf.ecore.EObject getCurrentObject() {
			return currentObject;
		}
		
		public void pushCurrentContainer(org.eclipse.emf.ecore.EObject newContainer) {
			containerStack.push(newContainer);
			currentObject = newContainer;
		}
		
		public void popCurrentContainer() {
			currentObject = containerStack.pop();
		}
	}
	
	public interface ICommand {
		public void execute(ICommandContext context);
	}
	
	public static class CreateObjectCommand implements ICommand {
		
		private org.eclipse.emf.ecore.EClass eClass;
		
		public CreateObjectCommand(org.eclipse.emf.ecore.EClass eClass) {
			this.eClass = eClass;
		}
		
		public void execute(ICommandContext context) {
			org.eclipse.emf.ecore.EObject object = eClass.getEPackage().getEFactoryInstance().create(eClass);
			context.pushCurrentContainer(object);
		}
	}
	
	public class AddContainedObjectCommand implements ICommand {
		
		private int featureID;
		
		public AddContainedObjectCommand(int featureID) {
			this.featureID = featureID;
		}
		
		public void execute(ICommandContext context) {
			org.eclipse.emf.ecore.EObject container = context.getCurrentContainer();
			org.eclipse.emf.ecore.EObject object = context.getCurrentObject();
			addObjectToFeature(container, object, featureID);
		}
	}
	
	public class SetAttributeValueCommand implements ICommand {
		
		private int featureID;
		private int start;
		private int end;
		private java.lang.String tokenName;
		
		public SetAttributeValueCommand(int start, int end, String tokenName, int featureID) {
			this.start = start;
			this.end = end;
			this.tokenName = tokenName;
			this.featureID = featureID;
		}
		
		public void execute(ICommandContext context) {
			java.lang.String match = content.substring(start, end);
			org.eclipse.emf.ecore.EObject currentObject = context.getCurrentObject();
			// call token resolver
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			org.eclipse.emf.ecore.EStructuralFeature feature = currentObject.eClass().getEStructuralFeature(featureID);
			tokenResolver.resolve(match, feature, result);
			java.lang.Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				// add error to resource
				addErrorToResource(result.getErrorMessage(), start, end);
			} else {
				// add proxy (if feature is a non-containment reference)
				assert feature instanceof org.eclipse.emf.ecore.EAttribute;
				addObjectToFeature(currentObject, resolvedObject, featureID);
			}
		}
	}
	
	public class AddProxyCommand<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> implements ICommand {
		
		private int featureID;
		private int start;
		private int end;
		private java.lang.String tokenName;
		private org.eclipse.emf.ecore.EClass proxyClass;
		private org.emftext.runtime.resource.IReferenceResolver<ContainerType, ReferenceType> referenceResolver;
		
		public AddProxyCommand(int start, int end, String tokenName, int featureID, org.eclipse.emf.ecore.EClass proxyClass, org.emftext.runtime.resource.IReferenceResolver<ContainerType, ReferenceType> referenceResolver) {
			this.start = start;
			this.end = end;
			this.tokenName = tokenName;
			this.featureID = featureID;
			this.proxyClass = proxyClass;
			this.referenceResolver = referenceResolver;
		}
		
		public void execute(ICommandContext context) {
			java.lang.String match = content.substring(start, end);
			org.eclipse.emf.ecore.EObject currentObject = context.getCurrentObject();
			// call token resolver
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);
			tokenResolver.setOptions(getOptions());
			org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
			org.eclipse.emf.ecore.EStructuralFeature feature = currentObject.eClass().getEStructuralFeature(featureID);
			tokenResolver.resolve(match, feature, result);
			java.lang.Object resolvedObject = result.getResolvedToken();
			if (resolvedObject == null) {
				// add error to resource
				addErrorToResource(result.getErrorMessage(), start, end);
			} else {
				// call reference resolver (feature is a non-containment reference)
				java.lang.String resolvedString = (java.lang.String) resolvedObject;
				org.eclipse.emf.ecore.EObject proxyObject = proxyClass.getEPackage().getEFactoryInstance().create(proxyClass);
				registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<ContainerType, ReferenceType>(referenceResolver), (ContainerType) currentObject, (org.eclipse.emf.ecore.EReference) feature, resolvedString, proxyObject);
				// add proxy
				assert feature instanceof org.eclipse.emf.ecore.EReference;
				addObjectToFeature(currentObject, proxyObject, featureID);
				setLocalizationInfo(proxyObject, start, end);
			}
		}
		
		protected void registerContextDependentProxy(org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory,ContainerType element, org.eclipse.emf.ecore.EReference reference, String id,org.eclipse.emf.ecore.EObject proxy) {
			org.emftext.runtime.resource.ITextResource resource = getResource();
			if (resource == null) {
				// the resource can be null if the parser is used for
				// code completion
				return;
			}
			resource.registerContextDependentProxy(factory, element, reference, id, proxy);
		}
		
	}
	
	public static class PopContainerCommand implements ICommand {
		public void execute(ICommandContext context) {
			context.popCurrentContainer();
		}
	}
	
	public class SetLocationCommand implements ICommand {
		public int start;
		public int end;
		
		public SetLocationCommand(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public void execute(ICommandContext context) {
			org.emftext.runtime.resource.ITextResource resource = getResource();
			if (resource == null) {
				// the resource can be null if the parser is used for
				// code completion
				return;
			}
			org.eclipse.emf.ecore.EObject currentContainer = context.getCurrentContainer();
			setLocalizationInfo(currentContainer, start, end);
		}
	}
	
	public static class ParseError {
		private java.lang.String message;
		private int offset;
		
		public ParseError(java.lang.String message, int offset) {
			this.message = message;
			this.offset = offset;
		}
		
		public java.lang.String getMessage() {
			return message;
		}
		
		public int getOffset() {
			return offset;
		}
		
	}
	
	private java.io.InputStreamReader inputStream;
	// the current position in the content
	private int offset;
	private boolean scanMode;
	// the current position in the content (ignoring trailing unused tokens (e.g., whitespaces)
	private int offsetIgnoringUnusedTokens;
	private java.lang.String content = "";
	private java.util.LinkedList<ICommand> commands;
	private org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new org.emftext.test.grammar_features.resource.grammar_features.Grammar_featuresTokenResolverFactory();
	private org.emftext.runtime.resource.impl.TokenResolveResult tokenResolveResult = new org.emftext.runtime.resource.impl.TokenResolveResult();
	private java.util.Map<?, ?> options;
	private org.emftext.runtime.resource.ITextResource resource;
	private ParseError parseError;
	private java.util.List<org.emftext.runtime.resource.ITextToken> tokens;
	
	private final static java.util.regex.Pattern TOKEN_TEXT = java.util.regex.Pattern.compile("\\A[a-zA-Z]+");
	private final static java.util.regex.Pattern TOKEN_WHITESPACE = java.util.regex.Pattern.compile("\\A[ \\t]");
	private final static java.util.regex.Pattern TOKEN_LINEBREAK = java.util.regex.Pattern.compile("\\A[\\n\\r]");
	private final static java.lang.String[] tokenNames = new java.lang.String[] {"TEXT","WHITESPACE","LINEBREAK"};
	
	public Grammar_featuresScannerlessParser() {
		super(null);
	}
	
	public Grammar_featuresScannerlessParser(java.io.InputStream inputStream, java.lang.String encoding) {
		super(null);
		this.inputStream = new java.io.InputStreamReader(inputStream);
		try {
			int next;
			while ((next = this.inputStream.read()) >= 0) {
				this.content += (char) next;
			}
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}
	
	public org.emftext.runtime.resource.ITextParser createInstance(java.io.InputStream inputStream, java.lang.String encoding) {
		return new Grammar_featuresScannerlessParser(inputStream, encoding);
	}
	
	public org.emftext.runtime.resource.ITextResource getResource() {
		return resource;
	}
	
	public org.eclipse.emf.ecore.EObject parse() {
		parseError = null;
		boolean tryOtherStartSymbols = true;
		// try start symbol: Root
		if (tryOtherStartSymbols) {
			offset = 0;
			offsetIgnoringUnusedTokens = 0;
			commands = new java.util.LinkedList<ICommand>();
			boolean success = parse_Root();
			if (success) {
				if (offset != content.length()) {
					addParseError(new ParseError("EOF (end of file) expected.", offset));
				} else {
					tryOtherStartSymbols = false;
				}
			} else {
			}
		}
		// try start symbol: SecondRoot
		if (tryOtherStartSymbols) {
			offset = 0;
			offsetIgnoringUnusedTokens = 0;
			commands = new java.util.LinkedList<ICommand>();
			boolean success = parse_SecondRoot();
			if (success) {
				if (offset != content.length()) {
					addParseError(new ParseError("EOF (end of file) expected.", offset));
				} else {
					tryOtherStartSymbols = false;
				}
			} else {
			}
		}
		// build content tree by executing commands
		ICommandContext context = new CommandContext();
		// do not execute the last pop container command to obtain
		// the root element
		for (int c = 0; c < commands.size() - 1; c++) {
			ICommand command = commands.get(c);
			command.execute(context);
		}
		commands = null;
		if (!tryOtherStartSymbols) {
			parseError = null;
		}
		addParseErrorToResource();
		// return root element
		return context.getCurrentContainer();
	}
	
	public java.util.List<org.emftext.runtime.resource.IExpectedElement> parseToExpectedElements(org.eclipse.emf.ecore.EClass type) {
		return null;
	}
	
	public void setResource(org.emftext.runtime.resource.ITextResource resource) {
		this.resource = resource;
	}
	
	public java.util.Map<?, ?> getOptions() {
		return options;
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		this.options = options;
	}
	
	public boolean matches(java.lang.String keyword) {
		boolean matches = content.startsWith(keyword, offset);
		if (matches) {
			offset += keyword.length();
			matchUnusedTokens();
		} else {
			addParseError(new ParseError("Parse error: Keyword " + keyword + " expected.", offset));
		}
		return matches;
	}
	
	public java.lang.String matchesUsedToken(java.util.regex.Pattern pattern, java.lang.String name, java.lang.String tokenName) {
		java.lang.String match = matchesRegexp(pattern, name, false);
		if (match != null) {
			matchUnusedTokens();
			return match;
		} else {
			addParseError(new ParseError("Parse error: Expected token " + tokenName + ".", offset));
			return null;
		}
	}
	
	public boolean matchUnusedTokens() {
		while (true) {
			boolean found = false;
			// TODO add tokens to collect-in features
			found |= null != matchesRegexp(TOKEN_WHITESPACE, "unused TOKEN_WHITESPACE", true);
			// TODO add tokens to collect-in features
			found |= null != matchesRegexp(TOKEN_LINEBREAK, "unused TOKEN_LINEBREAK", true);
			if (!found) {
				break;
			}
		}
		return true;
	}
	
	public java.lang.String matchesRegexp(java.util.regex.Pattern pattern, String name, boolean isUnusedToken) {
		java.lang.String tail = content.substring(offset);
		java.util.regex.Matcher matcher = pattern.matcher(tail);
		boolean matches = matcher.find();
		if (matches) {
			int start = matcher.start();
			int end = matcher.end();
			java.lang.String match = tail.substring(start, end);
			offset = offset + end;
			if (!isUnusedToken) {
				offsetIgnoringUnusedTokens = offset;
			}
			return match;
		} else {
			return null;
		}
	}
	
	public void discardCommands(int index) {
		commands.subList(index, commands.size()).clear();
	}
	
	public void addParseError(ParseError pe) {
		if (parseError == null || pe.getOffset() >= parseError.getOffset()) {
			parseError = pe;
		}
	}
	
	public void addObjectToFeature(org.eclipse.emf.ecore.EObject container, java.lang.Object object, int featureConstant) {
		org.eclipse.emf.ecore.EStructuralFeature eFeature = container.eClass().getEStructuralFeature(featureConstant);
		if (eFeature.getUpperBound() == 1) {
			if (java.util.Map.Entry.class.getName().equals(eFeature.getEType().getInstanceClassName())) {
				addMapEntry(container, eFeature, (org.emftext.runtime.resource.impl.DummyEObject) object);
			} else {
				container.eSet(eFeature, object);
			}
		} else {
			if (java.util.Map.Entry.class.getName().equals(eFeature.getEType().getInstanceClassName())) {
				addMapEntry(container, eFeature, (org.emftext.runtime.resource.impl.DummyEObject) object);
			} else {
				addObjectToList(container, featureConstant, object);
			}
		}
	}
	
	protected void addMapEntry(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EStructuralFeature structuralFeature, org.emftext.runtime.resource.impl.DummyEObject dummy) {
		java.lang.Object value = element.eGet(structuralFeature);
		java.lang.Object mapKey = dummy.getValueByName("key");
		java.lang.Object mapValue = dummy.getValueByName("value");
		if (value instanceof org.eclipse.emf.common.util.EMap<?, ?>) {
			org.eclipse.emf.common.util.EMap<java.lang.Object, java.lang.Object> valueMap = org.emftext.runtime.util.MapUtil.castToEMap(value);
			if (mapKey != null && mapValue != null) {
				valueMap.put(mapKey, mapValue);
			}
		}
	}
	
	private boolean addObjectToList(org.eclipse.emf.ecore.EObject element, int featureID, java.lang.Object proxy) {
		return ((java.util.List<java.lang.Object>) element.eGet(element.eClass().getEStructuralFeature(featureID))).add(proxy);
	}
	
	private org.emftext.runtime.resource.impl.TokenResolveResult getFreshTokenResolveResult() {
		tokenResolveResult.clear();
		return tokenResolveResult;
	}
	
	protected org.emftext.test.grammar_features.resource.grammar_features.Grammar_featuresReferenceResolverSwitch getReferenceResolverSwitch() {
		org.emftext.runtime.resource.ITextResource resource = getResource();
		if (resource == null) {
			return null;
		}
		return (org.emftext.test.grammar_features.resource.grammar_features.Grammar_featuresReferenceResolverSwitch) resource.getMetaInformation().getReferenceResolverSwitch();
	}
	
	public void addErrorToResource(java.lang.String message, int start, int end) {
		int line = org.emftext.runtime.util.StringUtil.getLine(content, start);
		int charPositionInLine  = org.emftext.runtime.util.StringUtil.getCharPositionInLine(content, start);
		addErrorToResource(message, line, charPositionInLine, start, end);
	}
	
	protected void addErrorToResource(final java.lang.String errorMessage, int line, int charPositionInLine, int startIndex, int stopIndex) {
		org.emftext.runtime.resource.ITextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the parser is used for
			// code completion
			return;
		}
		resource.addProblem(new org.emftext.runtime.resource.impl.AbstractProblem() {
			public org.emftext.runtime.resource.EProblemType getType() {
				return org.emftext.runtime.resource.EProblemType.ERROR;
			}
			public java.lang.String getMessage() {
				return errorMessage;
			}
		}, line, charPositionInLine, startIndex, stopIndex);
	}
	
	public void addParseErrorToResource() {
		if (parseError == null) {
			return;
		}
		int offset = parseError.getOffset();
		addErrorToResource(parseError.getMessage(), offset, offset);
	}
	
	public void setLocalizationInfo(org.eclipse.emf.ecore.EObject object, int start, int end) {
		// the resource may be null if the parse is used in standalone mode
		if (resource == null) {
			return;
		}
		java.lang.Integer[] lineAndPosition = org.emftext.runtime.util.StringUtil.getLineAndCharPosition(content, start);
		int line = lineAndPosition[0];
		int column = lineAndPosition[1];
		final org.emftext.runtime.resource.ILocationMap locationMap = resource.getLocationMap();
		locationMap.setCharStart(object, start);
		locationMap.setCharEnd(object, end);
		locationMap.setLine(object, line);
		locationMap.setColumn(object, column);
	}
	
	public void setScanMode() {
		scanMode = true;
	}
	public java.lang.String[] getTokenNames() {
		return tokenNames;
	}
	public java.util.List<org.emftext.runtime.resource.ITextToken> getTokens() {
		return tokens;
	}
	public boolean parse_Root() {
		org.eclipse.emf.ecore.EClass eClass = org.emftext.test.grammar_features.Grammar_featuresPackage.eINSTANCE.getRoot();
		int commandIndexBackup = commands.size();
		int startOffset = offset;
		commands.add(new CreateObjectCommand(eClass));
		boolean success = parse_Root_choice();
		if (success) {
			commands.add(new SetLocationCommand(startOffset, offsetIgnoringUnusedTokens - 1));
			commands.add(new PopContainerCommand());
			return true;
		} else {
			discardCommands(commandIndexBackup);
			return false;
		}
	}
	
	public boolean parse_Root_choice() {
		// begin options
		if (parse_Root_choice_sequence0()) {
			return true;
		}
		// end options
		return false;
	}
	
	public boolean parse_Root_choice_sequence0() {
		boolean matchedAll = true;
		int offsetCopy = offset;
		// begin part
		matchedAll = parse_Root_choice_sequence0_terminal_STAR0();
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// this sequence is valid
		return true;
	}
	
	public boolean parse_Root_choice_sequence0_terminal_STAR0() {
		boolean matched = true;
		while (matched) {
			// handle containment reference 'children'
			matched &= parse_Root_choice_sequence0_containment0();
		}
		// TODO backtrack
		return true;
	}
	
	public boolean parse_Root_choice_sequence0_containment0() {
		int offsetCopy = this.offset;
		// try subclass AlternativeSyntax
		{
			// restore old offset
			this.offset = offsetCopy;
			// TODO backtrack
			boolean success = parse_AlternativeSyntax();
			if (success) {
				// add command to add element to the containment reference
				commands.add(new AddContainedObjectCommand(0));
				return true;
			} else {
			}
		}
		// try subclass ConcreteSubclassA
		{
			// restore old offset
			this.offset = offsetCopy;
			// TODO backtrack
			boolean success = parse_ConcreteSubclassA();
			if (success) {
				// add command to add element to the containment reference
				commands.add(new AddContainedObjectCommand(0));
				return true;
			} else {
			}
		}
		// try subclass ConcreteSubclassB
		{
			// restore old offset
			this.offset = offsetCopy;
			// TODO backtrack
			boolean success = parse_ConcreteSubclassB();
			if (success) {
				// add command to add element to the containment reference
				commands.add(new AddContainedObjectCommand(0));
				return true;
			} else {
			}
		}
		// try subclass MandatoryContainment
		{
			// restore old offset
			this.offset = offsetCopy;
			// TODO backtrack
			boolean success = parse_MandatoryContainment();
			if (success) {
				// add command to add element to the containment reference
				commands.add(new AddContainedObjectCommand(0));
				return true;
			} else {
			}
		}
		// try subclass OptionalContainment
		{
			// restore old offset
			this.offset = offsetCopy;
			// TODO backtrack
			boolean success = parse_OptionalContainment();
			if (success) {
				// add command to add element to the containment reference
				commands.add(new AddContainedObjectCommand(0));
				return true;
			} else {
			}
		}
		// try subclass PlusContainment
		{
			// restore old offset
			this.offset = offsetCopy;
			// TODO backtrack
			boolean success = parse_PlusContainment();
			if (success) {
				// add command to add element to the containment reference
				commands.add(new AddContainedObjectCommand(0));
				return true;
			} else {
			}
		}
		// try subclass StarContainment
		{
			// restore old offset
			this.offset = offsetCopy;
			// TODO backtrack
			boolean success = parse_StarContainment();
			if (success) {
				// add command to add element to the containment reference
				commands.add(new AddContainedObjectCommand(0));
				return true;
			} else {
			}
		}
		// try subclass MandatoryNonContainment
		{
			// restore old offset
			this.offset = offsetCopy;
			// TODO backtrack
			boolean success = parse_MandatoryNonContainment();
			if (success) {
				// add command to add element to the containment reference
				commands.add(new AddContainedObjectCommand(0));
				return true;
			} else {
			}
		}
		// try subclass OptionalNonContainment
		{
			// restore old offset
			this.offset = offsetCopy;
			// TODO backtrack
			boolean success = parse_OptionalNonContainment();
			if (success) {
				// add command to add element to the containment reference
				commands.add(new AddContainedObjectCommand(0));
				return true;
			} else {
			}
		}
		// try subclass PlusNonContainment
		{
			// restore old offset
			this.offset = offsetCopy;
			// TODO backtrack
			boolean success = parse_PlusNonContainment();
			if (success) {
				// add command to add element to the containment reference
				commands.add(new AddContainedObjectCommand(0));
				return true;
			} else {
			}
		}
		// try subclass StarNonContainment
		{
			// restore old offset
			this.offset = offsetCopy;
			// TODO backtrack
			boolean success = parse_StarNonContainment();
			if (success) {
				// add command to add element to the containment reference
				commands.add(new AddContainedObjectCommand(0));
				return true;
			} else {
			}
		}
		// try subclass CompoundOptional
		{
			// restore old offset
			this.offset = offsetCopy;
			// TODO backtrack
			boolean success = parse_CompoundOptional();
			if (success) {
				// add command to add element to the containment reference
				commands.add(new AddContainedObjectCommand(0));
				return true;
			} else {
			}
		}
		// try subclass CompoundStar
		{
			// restore old offset
			this.offset = offsetCopy;
			// TODO backtrack
			boolean success = parse_CompoundStar();
			if (success) {
				// add command to add element to the containment reference
				commands.add(new AddContainedObjectCommand(0));
				return true;
			} else {
			}
		}
		// try subclass CompoundPlus
		{
			// restore old offset
			this.offset = offsetCopy;
			// TODO backtrack
			boolean success = parse_CompoundPlus();
			if (success) {
				// add command to add element to the containment reference
				commands.add(new AddContainedObjectCommand(0));
				return true;
			} else {
			}
		}
		// try subclass ClassWithAttributes
		{
			// restore old offset
			this.offset = offsetCopy;
			// TODO backtrack
			boolean success = parse_ClassWithAttributes();
			if (success) {
				// add command to add element to the containment reference
				commands.add(new AddContainedObjectCommand(0));
				return true;
			} else {
			}
		}
		// no subclass matched
		return false;
	}
	
	public boolean parse_AlternativeSyntax() {
		org.eclipse.emf.ecore.EClass eClass = org.emftext.test.grammar_features.Grammar_featuresPackage.eINSTANCE.getAlternativeSyntax();
		int commandIndexBackup = commands.size();
		int startOffset = offset;
		commands.add(new CreateObjectCommand(eClass));
		boolean success = parse_AlternativeSyntax_choice();
		if (success) {
			commands.add(new SetLocationCommand(startOffset, offsetIgnoringUnusedTokens - 1));
			commands.add(new PopContainerCommand());
			return true;
		} else {
			discardCommands(commandIndexBackup);
			return false;
		}
	}
	
	public boolean parse_AlternativeSyntax_choice() {
		// begin options
		if (parse_AlternativeSyntax_choice_sequence0()) {
			return true;
		}
		if (parse_AlternativeSyntax_choice_sequence1()) {
			return true;
		}
		// end options
		return false;
	}
	
	public boolean parse_AlternativeSyntax_choice_sequence0() {
		boolean matchedAll = true;
		int offsetCopy = offset;
		// begin part
		// match cs string "alternativeA"
		matchedAll &= matches("alternativeA");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// this sequence is valid
		return true;
	}
	
	public boolean parse_AlternativeSyntax_choice_sequence1() {
		boolean matchedAll = true;
		int offsetCopy = offset;
		// begin part
		// match cs string "alternativeB"
		matchedAll &= matches("alternativeB");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// this sequence is valid
		return true;
	}
	
	public boolean parse_ConcreteSubclassA() {
		org.eclipse.emf.ecore.EClass eClass = org.emftext.test.grammar_features.Grammar_featuresPackage.eINSTANCE.getConcreteSubclassA();
		int commandIndexBackup = commands.size();
		int startOffset = offset;
		commands.add(new CreateObjectCommand(eClass));
		boolean success = parse_ConcreteSubclassA_choice();
		if (success) {
			commands.add(new SetLocationCommand(startOffset, offsetIgnoringUnusedTokens - 1));
			commands.add(new PopContainerCommand());
			return true;
		} else {
			discardCommands(commandIndexBackup);
			return false;
		}
	}
	
	public boolean parse_ConcreteSubclassA_choice() {
		// begin options
		if (parse_ConcreteSubclassA_choice_sequence0()) {
			return true;
		}
		// end options
		return false;
	}
	
	public boolean parse_ConcreteSubclassA_choice_sequence0() {
		boolean matchedAll = true;
		int offsetCopy = offset;
		// begin part
		// match cs string "concreteA"
		matchedAll &= matches("concreteA");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// this sequence is valid
		return true;
	}
	
	public boolean parse_ConcreteSubclassB() {
		org.eclipse.emf.ecore.EClass eClass = org.emftext.test.grammar_features.Grammar_featuresPackage.eINSTANCE.getConcreteSubclassB();
		int commandIndexBackup = commands.size();
		int startOffset = offset;
		commands.add(new CreateObjectCommand(eClass));
		boolean success = parse_ConcreteSubclassB_choice();
		if (success) {
			commands.add(new SetLocationCommand(startOffset, offsetIgnoringUnusedTokens - 1));
			commands.add(new PopContainerCommand());
			return true;
		} else {
			discardCommands(commandIndexBackup);
			return false;
		}
	}
	
	public boolean parse_ConcreteSubclassB_choice() {
		// begin options
		if (parse_ConcreteSubclassB_choice_sequence0()) {
			return true;
		}
		// end options
		return false;
	}
	
	public boolean parse_ConcreteSubclassB_choice_sequence0() {
		boolean matchedAll = true;
		int offsetCopy = offset;
		// begin part
		// match cs string "concreteB"
		matchedAll &= matches("concreteB");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// this sequence is valid
		return true;
	}
	
	public boolean parse_MandatoryContainment() {
		org.eclipse.emf.ecore.EClass eClass = org.emftext.test.grammar_features.Grammar_featuresPackage.eINSTANCE.getMandatoryContainment();
		int commandIndexBackup = commands.size();
		int startOffset = offset;
		commands.add(new CreateObjectCommand(eClass));
		boolean success = parse_MandatoryContainment_choice();
		if (success) {
			commands.add(new SetLocationCommand(startOffset, offsetIgnoringUnusedTokens - 1));
			commands.add(new PopContainerCommand());
			return true;
		} else {
			discardCommands(commandIndexBackup);
			return false;
		}
	}
	
	public boolean parse_MandatoryContainment_choice() {
		// begin options
		if (parse_MandatoryContainment_choice_sequence0()) {
			return true;
		}
		// end options
		return false;
	}
	
	public boolean parse_MandatoryContainment_choice_sequence0() {
		boolean matchedAll = true;
		int offsetCopy = offset;
		// begin part
		// match cs string "mc"
		matchedAll &= matches("mc");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// begin part
		matchedAll = parse_MandatoryContainment_choice_sequence0_terminal_ONE1();
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// this sequence is valid
		return true;
	}
	
	public boolean parse_MandatoryContainment_choice_sequence0_terminal_ONE1() {
		boolean matched = true;
		// handle containment reference 'reference'
		matched &= parse_MandatoryContainment_choice_sequence0_containment1();
		return matched;
	}
	
	public boolean parse_MandatoryContainment_choice_sequence0_containment1() {
		int offsetCopy = this.offset;
		// try subclass X
		{
			// restore old offset
			this.offset = offsetCopy;
			// TODO backtrack
			boolean success = parse_X();
			if (success) {
				// add command to add element to the containment reference
				commands.add(new AddContainedObjectCommand(0));
				return true;
			} else {
			}
		}
		// no subclass matched
		return false;
	}
	
	public boolean parse_OptionalContainment() {
		org.eclipse.emf.ecore.EClass eClass = org.emftext.test.grammar_features.Grammar_featuresPackage.eINSTANCE.getOptionalContainment();
		int commandIndexBackup = commands.size();
		int startOffset = offset;
		commands.add(new CreateObjectCommand(eClass));
		boolean success = parse_OptionalContainment_choice();
		if (success) {
			commands.add(new SetLocationCommand(startOffset, offsetIgnoringUnusedTokens - 1));
			commands.add(new PopContainerCommand());
			return true;
		} else {
			discardCommands(commandIndexBackup);
			return false;
		}
	}
	
	public boolean parse_OptionalContainment_choice() {
		// begin options
		if (parse_OptionalContainment_choice_sequence0()) {
			return true;
		}
		// end options
		return false;
	}
	
	public boolean parse_OptionalContainment_choice_sequence0() {
		boolean matchedAll = true;
		int offsetCopy = offset;
		// begin part
		// match cs string "oc"
		matchedAll &= matches("oc");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// begin part
		matchedAll = parse_OptionalContainment_choice_sequence0_terminal_QUESTIONMARK1();
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// this sequence is valid
		return true;
	}
	
	public boolean parse_OptionalContainment_choice_sequence0_terminal_QUESTIONMARK1() {
		boolean matched = true;
		// handle containment reference 'reference'
		matched &= parse_OptionalContainment_choice_sequence0_containment1();
		return true;
	}
	
	public boolean parse_OptionalContainment_choice_sequence0_containment1() {
		int offsetCopy = this.offset;
		// try subclass X
		{
			// restore old offset
			this.offset = offsetCopy;
			// TODO backtrack
			boolean success = parse_X();
			if (success) {
				// add command to add element to the containment reference
				commands.add(new AddContainedObjectCommand(0));
				return true;
			} else {
			}
		}
		// no subclass matched
		return false;
	}
	
	public boolean parse_PlusContainment() {
		org.eclipse.emf.ecore.EClass eClass = org.emftext.test.grammar_features.Grammar_featuresPackage.eINSTANCE.getPlusContainment();
		int commandIndexBackup = commands.size();
		int startOffset = offset;
		commands.add(new CreateObjectCommand(eClass));
		boolean success = parse_PlusContainment_choice();
		if (success) {
			commands.add(new SetLocationCommand(startOffset, offsetIgnoringUnusedTokens - 1));
			commands.add(new PopContainerCommand());
			return true;
		} else {
			discardCommands(commandIndexBackup);
			return false;
		}
	}
	
	public boolean parse_PlusContainment_choice() {
		// begin options
		if (parse_PlusContainment_choice_sequence0()) {
			return true;
		}
		// end options
		return false;
	}
	
	public boolean parse_PlusContainment_choice_sequence0() {
		boolean matchedAll = true;
		int offsetCopy = offset;
		// begin part
		// match cs string "pc"
		matchedAll &= matches("pc");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// begin part
		matchedAll = parse_PlusContainment_choice_sequence0_terminal_PLUS1();
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// this sequence is valid
		return true;
	}
	
	public boolean parse_PlusContainment_choice_sequence0_terminal_PLUS1() {
		boolean matched = true;
		boolean matchedAtLeastOnce = false;
		while (matched) {
			// handle containment reference 'reference'
			matched &= parse_PlusContainment_choice_sequence0_containment1();
			matchedAtLeastOnce |= matched;
		}
		// TODO backtrack
		return matchedAtLeastOnce;
	}
	
	public boolean parse_PlusContainment_choice_sequence0_containment1() {
		int offsetCopy = this.offset;
		// try subclass X
		{
			// restore old offset
			this.offset = offsetCopy;
			// TODO backtrack
			boolean success = parse_X();
			if (success) {
				// add command to add element to the containment reference
				commands.add(new AddContainedObjectCommand(0));
				return true;
			} else {
			}
		}
		// no subclass matched
		return false;
	}
	
	public boolean parse_StarContainment() {
		org.eclipse.emf.ecore.EClass eClass = org.emftext.test.grammar_features.Grammar_featuresPackage.eINSTANCE.getStarContainment();
		int commandIndexBackup = commands.size();
		int startOffset = offset;
		commands.add(new CreateObjectCommand(eClass));
		boolean success = parse_StarContainment_choice();
		if (success) {
			commands.add(new SetLocationCommand(startOffset, offsetIgnoringUnusedTokens - 1));
			commands.add(new PopContainerCommand());
			return true;
		} else {
			discardCommands(commandIndexBackup);
			return false;
		}
	}
	
	public boolean parse_StarContainment_choice() {
		// begin options
		if (parse_StarContainment_choice_sequence0()) {
			return true;
		}
		// end options
		return false;
	}
	
	public boolean parse_StarContainment_choice_sequence0() {
		boolean matchedAll = true;
		int offsetCopy = offset;
		// begin part
		// match cs string "sc"
		matchedAll &= matches("sc");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// begin part
		matchedAll = parse_StarContainment_choice_sequence0_terminal_STAR1();
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// this sequence is valid
		return true;
	}
	
	public boolean parse_StarContainment_choice_sequence0_terminal_STAR1() {
		boolean matched = true;
		while (matched) {
			// handle containment reference 'reference'
			matched &= parse_StarContainment_choice_sequence0_containment1();
		}
		// TODO backtrack
		return true;
	}
	
	public boolean parse_StarContainment_choice_sequence0_containment1() {
		int offsetCopy = this.offset;
		// try subclass X
		{
			// restore old offset
			this.offset = offsetCopy;
			// TODO backtrack
			boolean success = parse_X();
			if (success) {
				// add command to add element to the containment reference
				commands.add(new AddContainedObjectCommand(0));
				return true;
			} else {
			}
		}
		// no subclass matched
		return false;
	}
	
	public boolean parse_MandatoryNonContainment() {
		org.eclipse.emf.ecore.EClass eClass = org.emftext.test.grammar_features.Grammar_featuresPackage.eINSTANCE.getMandatoryNonContainment();
		int commandIndexBackup = commands.size();
		int startOffset = offset;
		commands.add(new CreateObjectCommand(eClass));
		boolean success = parse_MandatoryNonContainment_choice();
		if (success) {
			commands.add(new SetLocationCommand(startOffset, offsetIgnoringUnusedTokens - 1));
			commands.add(new PopContainerCommand());
			return true;
		} else {
			discardCommands(commandIndexBackup);
			return false;
		}
	}
	
	public boolean parse_MandatoryNonContainment_choice() {
		// begin options
		if (parse_MandatoryNonContainment_choice_sequence0()) {
			return true;
		}
		// end options
		return false;
	}
	
	public boolean parse_MandatoryNonContainment_choice_sequence0() {
		boolean matchedAll = true;
		int offsetCopy = offset;
		// begin part
		// match cs string "mnc"
		matchedAll &= matches("mnc");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// begin part
		matchedAll = parse_MandatoryNonContainment_choice_sequence0_terminal_ONE1();
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// this sequence is valid
		return true;
	}
	
	public boolean parse_MandatoryNonContainment_choice_sequence0_terminal_ONE1() {
		boolean matched = true;
		// match regexp "('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+"
		int offsetBeforeMatch = offset;
		String match = matchesUsedToken(TOKEN_TEXT, "TOKEN_TEXT", "TEXT");
		matched &= (match != null);
		if (matched) {
			commands.add(new AddProxyCommand<org.emftext.test.grammar_features.MandatoryNonContainment, org.emftext.test.grammar_features.X>(offsetBeforeMatch, offsetBeforeMatch + match.length(), "TEXT", org.emftext.test.grammar_features.Grammar_featuresPackage.MANDATORY_NON_CONTAINMENT__REFERENCE, org.emftext.test.grammar_features.Grammar_featuresPackage.eINSTANCE.getX(), getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMandatoryNonContainmentReferenceReferenceResolver()));
		}
		return matched;
	}
	
	public boolean parse_OptionalNonContainment() {
		org.eclipse.emf.ecore.EClass eClass = org.emftext.test.grammar_features.Grammar_featuresPackage.eINSTANCE.getOptionalNonContainment();
		int commandIndexBackup = commands.size();
		int startOffset = offset;
		commands.add(new CreateObjectCommand(eClass));
		boolean success = parse_OptionalNonContainment_choice();
		if (success) {
			commands.add(new SetLocationCommand(startOffset, offsetIgnoringUnusedTokens - 1));
			commands.add(new PopContainerCommand());
			return true;
		} else {
			discardCommands(commandIndexBackup);
			return false;
		}
	}
	
	public boolean parse_OptionalNonContainment_choice() {
		// begin options
		if (parse_OptionalNonContainment_choice_sequence0()) {
			return true;
		}
		// end options
		return false;
	}
	
	public boolean parse_OptionalNonContainment_choice_sequence0() {
		boolean matchedAll = true;
		int offsetCopy = offset;
		// begin part
		// match cs string "onc"
		matchedAll &= matches("onc");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// begin part
		matchedAll = parse_OptionalNonContainment_choice_sequence0_terminal_QUESTIONMARK1();
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// this sequence is valid
		return true;
	}
	
	public boolean parse_OptionalNonContainment_choice_sequence0_terminal_QUESTIONMARK1() {
		boolean matched = true;
		// match regexp "('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+"
		int offsetBeforeMatch = offset;
		String match = matchesUsedToken(TOKEN_TEXT, "TOKEN_TEXT", "TEXT");
		matched &= (match != null);
		if (matched) {
			commands.add(new AddProxyCommand<org.emftext.test.grammar_features.OptionalNonContainment, org.emftext.test.grammar_features.X>(offsetBeforeMatch, offsetBeforeMatch + match.length(), "TEXT", org.emftext.test.grammar_features.Grammar_featuresPackage.OPTIONAL_NON_CONTAINMENT__REFERENCE, org.emftext.test.grammar_features.Grammar_featuresPackage.eINSTANCE.getX(), getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getOptionalNonContainmentReferenceReferenceResolver()));
		}
		return true;
	}
	
	public boolean parse_PlusNonContainment() {
		org.eclipse.emf.ecore.EClass eClass = org.emftext.test.grammar_features.Grammar_featuresPackage.eINSTANCE.getPlusNonContainment();
		int commandIndexBackup = commands.size();
		int startOffset = offset;
		commands.add(new CreateObjectCommand(eClass));
		boolean success = parse_PlusNonContainment_choice();
		if (success) {
			commands.add(new SetLocationCommand(startOffset, offsetIgnoringUnusedTokens - 1));
			commands.add(new PopContainerCommand());
			return true;
		} else {
			discardCommands(commandIndexBackup);
			return false;
		}
	}
	
	public boolean parse_PlusNonContainment_choice() {
		// begin options
		if (parse_PlusNonContainment_choice_sequence0()) {
			return true;
		}
		// end options
		return false;
	}
	
	public boolean parse_PlusNonContainment_choice_sequence0() {
		boolean matchedAll = true;
		int offsetCopy = offset;
		// begin part
		// match cs string "pnc"
		matchedAll &= matches("pnc");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// begin part
		matchedAll = parse_PlusNonContainment_choice_sequence0_terminal_PLUS1();
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// this sequence is valid
		return true;
	}
	
	public boolean parse_PlusNonContainment_choice_sequence0_terminal_PLUS1() {
		boolean matched = true;
		boolean matchedAtLeastOnce = false;
		while (matched) {
			// match regexp "('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+"
			int offsetBeforeMatch = offset;
			String match = matchesUsedToken(TOKEN_TEXT, "TOKEN_TEXT", "TEXT");
			matched &= (match != null);
			if (matched) {
				commands.add(new AddProxyCommand<org.emftext.test.grammar_features.PlusNonContainment, org.emftext.test.grammar_features.X>(offsetBeforeMatch, offsetBeforeMatch + match.length(), "TEXT", org.emftext.test.grammar_features.Grammar_featuresPackage.PLUS_NON_CONTAINMENT__REFERENCE, org.emftext.test.grammar_features.Grammar_featuresPackage.eINSTANCE.getX(), getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPlusNonContainmentReferenceReferenceResolver()));
			}
			matchedAtLeastOnce |= matched;
		}
		// TODO backtrack
		return matchedAtLeastOnce;
	}
	
	public boolean parse_StarNonContainment() {
		org.eclipse.emf.ecore.EClass eClass = org.emftext.test.grammar_features.Grammar_featuresPackage.eINSTANCE.getStarNonContainment();
		int commandIndexBackup = commands.size();
		int startOffset = offset;
		commands.add(new CreateObjectCommand(eClass));
		boolean success = parse_StarNonContainment_choice();
		if (success) {
			commands.add(new SetLocationCommand(startOffset, offsetIgnoringUnusedTokens - 1));
			commands.add(new PopContainerCommand());
			return true;
		} else {
			discardCommands(commandIndexBackup);
			return false;
		}
	}
	
	public boolean parse_StarNonContainment_choice() {
		// begin options
		if (parse_StarNonContainment_choice_sequence0()) {
			return true;
		}
		// end options
		return false;
	}
	
	public boolean parse_StarNonContainment_choice_sequence0() {
		boolean matchedAll = true;
		int offsetCopy = offset;
		// begin part
		// match cs string "snc"
		matchedAll &= matches("snc");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// begin part
		matchedAll = parse_StarNonContainment_choice_sequence0_terminal_STAR1();
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// this sequence is valid
		return true;
	}
	
	public boolean parse_StarNonContainment_choice_sequence0_terminal_STAR1() {
		boolean matched = true;
		while (matched) {
			// match regexp "('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+"
			int offsetBeforeMatch = offset;
			String match = matchesUsedToken(TOKEN_TEXT, "TOKEN_TEXT", "TEXT");
			matched &= (match != null);
			if (matched) {
				commands.add(new AddProxyCommand<org.emftext.test.grammar_features.StarNonContainment, org.emftext.test.grammar_features.X>(offsetBeforeMatch, offsetBeforeMatch + match.length(), "TEXT", org.emftext.test.grammar_features.Grammar_featuresPackage.STAR_NON_CONTAINMENT__REFERENCE, org.emftext.test.grammar_features.Grammar_featuresPackage.eINSTANCE.getX(), getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getStarNonContainmentReferenceReferenceResolver()));
			}
		}
		// TODO backtrack
		return true;
	}
	
	public boolean parse_CompoundOptional() {
		org.eclipse.emf.ecore.EClass eClass = org.emftext.test.grammar_features.Grammar_featuresPackage.eINSTANCE.getCompoundOptional();
		int commandIndexBackup = commands.size();
		int startOffset = offset;
		commands.add(new CreateObjectCommand(eClass));
		boolean success = parse_CompoundOptional_choice();
		if (success) {
			commands.add(new SetLocationCommand(startOffset, offsetIgnoringUnusedTokens - 1));
			commands.add(new PopContainerCommand());
			return true;
		} else {
			discardCommands(commandIndexBackup);
			return false;
		}
	}
	
	public boolean parse_CompoundOptional_choice() {
		// begin options
		if (parse_CompoundOptional_choice_sequence0()) {
			return true;
		}
		// end options
		return false;
	}
	
	public boolean parse_CompoundOptional_choice_sequence0() {
		boolean matchedAll = true;
		int offsetCopy = offset;
		// begin part
		// match cs string "co"
		matchedAll &= matches("co");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// begin part
		matchedAll = parse_CompoundOptional_choice_sequence0_compound_QUESTIONMARK1();
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// this sequence is valid
		return true;
	}
	
	public boolean parse_CompoundOptional_choice_sequence0_compound_QUESTIONMARK1() {
		boolean matched = true;
		// handle compound definition
		matched = parse_CompoundOptional_choice_sequence0_compound_QUESTIONMARK1_compound();
		return true;
	}
	
	public boolean parse_CompoundOptional_choice_sequence0_compound_QUESTIONMARK1_compound() {
		// begin options
		if (parse_CompoundOptional_choice_sequence0_compound_QUESTIONMARK1_compound_sequence0()) {
			return true;
		}
		// end options
		return false;
	}
	
	public boolean parse_CompoundOptional_choice_sequence0_compound_QUESTIONMARK1_compound_sequence0() {
		boolean matchedAll = true;
		int offsetCopy = offset;
		// begin part
		// match cs string "a"
		matchedAll &= matches("a");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// begin part
		// match cs string "b"
		matchedAll &= matches("b");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// this sequence is valid
		return true;
	}
	
	public boolean parse_CompoundStar() {
		org.eclipse.emf.ecore.EClass eClass = org.emftext.test.grammar_features.Grammar_featuresPackage.eINSTANCE.getCompoundStar();
		int commandIndexBackup = commands.size();
		int startOffset = offset;
		commands.add(new CreateObjectCommand(eClass));
		boolean success = parse_CompoundStar_choice();
		if (success) {
			commands.add(new SetLocationCommand(startOffset, offsetIgnoringUnusedTokens - 1));
			commands.add(new PopContainerCommand());
			return true;
		} else {
			discardCommands(commandIndexBackup);
			return false;
		}
	}
	
	public boolean parse_CompoundStar_choice() {
		// begin options
		if (parse_CompoundStar_choice_sequence0()) {
			return true;
		}
		// end options
		return false;
	}
	
	public boolean parse_CompoundStar_choice_sequence0() {
		boolean matchedAll = true;
		int offsetCopy = offset;
		// begin part
		// match cs string "cs"
		matchedAll &= matches("cs");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// begin part
		matchedAll = parse_CompoundStar_choice_sequence0_compound_STAR1();
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// this sequence is valid
		return true;
	}
	
	public boolean parse_CompoundStar_choice_sequence0_compound_STAR1() {
		boolean matched = true;
		while (matched) {
			// handle compound definition
			matched = parse_CompoundStar_choice_sequence0_compound_STAR1_compound();
		}
		// TODO backtrack
		return true;
	}
	
	public boolean parse_CompoundStar_choice_sequence0_compound_STAR1_compound() {
		// begin options
		if (parse_CompoundStar_choice_sequence0_compound_STAR1_compound_sequence0()) {
			return true;
		}
		// end options
		return false;
	}
	
	public boolean parse_CompoundStar_choice_sequence0_compound_STAR1_compound_sequence0() {
		boolean matchedAll = true;
		int offsetCopy = offset;
		// begin part
		// match cs string "a"
		matchedAll &= matches("a");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// begin part
		// match cs string "b"
		matchedAll &= matches("b");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// this sequence is valid
		return true;
	}
	
	public boolean parse_CompoundPlus() {
		org.eclipse.emf.ecore.EClass eClass = org.emftext.test.grammar_features.Grammar_featuresPackage.eINSTANCE.getCompoundPlus();
		int commandIndexBackup = commands.size();
		int startOffset = offset;
		commands.add(new CreateObjectCommand(eClass));
		boolean success = parse_CompoundPlus_choice();
		if (success) {
			commands.add(new SetLocationCommand(startOffset, offsetIgnoringUnusedTokens - 1));
			commands.add(new PopContainerCommand());
			return true;
		} else {
			discardCommands(commandIndexBackup);
			return false;
		}
	}
	
	public boolean parse_CompoundPlus_choice() {
		// begin options
		if (parse_CompoundPlus_choice_sequence0()) {
			return true;
		}
		// end options
		return false;
	}
	
	public boolean parse_CompoundPlus_choice_sequence0() {
		boolean matchedAll = true;
		int offsetCopy = offset;
		// begin part
		// match cs string "cp"
		matchedAll &= matches("cp");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// begin part
		matchedAll = parse_CompoundPlus_choice_sequence0_compound_PLUS1();
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// this sequence is valid
		return true;
	}
	
	public boolean parse_CompoundPlus_choice_sequence0_compound_PLUS1() {
		boolean matched = true;
		boolean matchedAtLeastOnce = false;
		while (matched) {
			// handle compound definition
			matched = parse_CompoundPlus_choice_sequence0_compound_PLUS1_compound();
			matchedAtLeastOnce |= matched;
		}
		// TODO backtrack
		return matchedAtLeastOnce;
	}
	
	public boolean parse_CompoundPlus_choice_sequence0_compound_PLUS1_compound() {
		// begin options
		if (parse_CompoundPlus_choice_sequence0_compound_PLUS1_compound_sequence0()) {
			return true;
		}
		// end options
		return false;
	}
	
	public boolean parse_CompoundPlus_choice_sequence0_compound_PLUS1_compound_sequence0() {
		boolean matchedAll = true;
		int offsetCopy = offset;
		// begin part
		// match cs string "a"
		matchedAll &= matches("a");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// begin part
		// match cs string "b"
		matchedAll &= matches("b");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// this sequence is valid
		return true;
	}
	
	public boolean parse_X() {
		org.eclipse.emf.ecore.EClass eClass = org.emftext.test.grammar_features.Grammar_featuresPackage.eINSTANCE.getX();
		int commandIndexBackup = commands.size();
		int startOffset = offset;
		commands.add(new CreateObjectCommand(eClass));
		boolean success = parse_X_choice();
		if (success) {
			commands.add(new SetLocationCommand(startOffset, offsetIgnoringUnusedTokens - 1));
			commands.add(new PopContainerCommand());
			return true;
		} else {
			discardCommands(commandIndexBackup);
			return false;
		}
	}
	
	public boolean parse_X_choice() {
		// begin options
		if (parse_X_choice_sequence0()) {
			return true;
		}
		// end options
		return false;
	}
	
	public boolean parse_X_choice_sequence0() {
		boolean matchedAll = true;
		int offsetCopy = offset;
		// begin part
		// match cs string "x"
		matchedAll &= matches("x");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// begin part
		matchedAll = parse_X_choice_sequence0_compound_QUESTIONMARK1();
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// this sequence is valid
		return true;
	}
	
	public boolean parse_X_choice_sequence0_compound_QUESTIONMARK1() {
		boolean matched = true;
		// handle compound definition
		matched = parse_X_choice_sequence0_compound_QUESTIONMARK1_compound();
		return true;
	}
	
	public boolean parse_X_choice_sequence0_compound_QUESTIONMARK1_compound() {
		// begin options
		if (parse_X_choice_sequence0_compound_QUESTIONMARK1_compound_sequence0()) {
			return true;
		}
		// end options
		return false;
	}
	
	public boolean parse_X_choice_sequence0_compound_QUESTIONMARK1_compound_sequence0() {
		boolean matchedAll = true;
		int offsetCopy = offset;
		// begin part
		// match cs string ":"
		matchedAll &= matches(":");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// begin part
		matchedAll = parse_X_choice_sequence0_compound_QUESTIONMARK1_compound_sequence0_terminal_ONE1();
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// this sequence is valid
		return true;
	}
	
	public boolean parse_X_choice_sequence0_compound_QUESTIONMARK1_compound_sequence0_terminal_ONE1() {
		boolean matched = true;
		// match regexp "('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+"
		int offsetBeforeMatch = offset;
		String match = matchesUsedToken(TOKEN_TEXT, "TOKEN_TEXT", "TEXT");
		matched &= (match != null);
		if (matched) {
			commands.add(new SetAttributeValueCommand(offsetBeforeMatch, offsetBeforeMatch + match.length(), "TEXT", org.emftext.test.grammar_features.Grammar_featuresPackage.X__NAME));
		}
		return matched;
	}
	
	public boolean parse_ClassWithAttributes() {
		org.eclipse.emf.ecore.EClass eClass = org.emftext.test.grammar_features.Grammar_featuresPackage.eINSTANCE.getClassWithAttributes();
		int commandIndexBackup = commands.size();
		int startOffset = offset;
		commands.add(new CreateObjectCommand(eClass));
		boolean success = parse_ClassWithAttributes_choice();
		if (success) {
			commands.add(new SetLocationCommand(startOffset, offsetIgnoringUnusedTokens - 1));
			commands.add(new PopContainerCommand());
			return true;
		} else {
			discardCommands(commandIndexBackup);
			return false;
		}
	}
	
	public boolean parse_ClassWithAttributes_choice() {
		// begin options
		if (parse_ClassWithAttributes_choice_sequence0()) {
			return true;
		}
		// end options
		return false;
	}
	
	public boolean parse_ClassWithAttributes_choice_sequence0() {
		boolean matchedAll = true;
		int offsetCopy = offset;
		// begin part
		// match cs string "cwa"
		matchedAll &= matches("cwa");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// begin part
		matchedAll = parse_ClassWithAttributes_choice_sequence0_terminal_ONE1();
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// begin part
		matchedAll = parse_ClassWithAttributes_choice_sequence0_terminal_ONE2();
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// this sequence is valid
		return true;
	}
	
	public boolean parse_ClassWithAttributes_choice_sequence0_terminal_ONE1() {
		boolean matched = true;
		// match regexp "('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+"
		int offsetBeforeMatch = offset;
		String match = matchesUsedToken(TOKEN_TEXT, "TOKEN_TEXT", "TEXT");
		matched &= (match != null);
		if (matched) {
			commands.add(new SetAttributeValueCommand(offsetBeforeMatch, offsetBeforeMatch + match.length(), "TEXT", org.emftext.test.grammar_features.Grammar_featuresPackage.CLASS_WITH_ATTRIBUTES__A1));
		}
		return matched;
	}
	
	public boolean parse_ClassWithAttributes_choice_sequence0_terminal_ONE2() {
		boolean matched = true;
		// match regexp "('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+"
		int offsetBeforeMatch = offset;
		String match = matchesUsedToken(TOKEN_TEXT, "TOKEN_TEXT", "TEXT");
		matched &= (match != null);
		if (matched) {
			commands.add(new SetAttributeValueCommand(offsetBeforeMatch, offsetBeforeMatch + match.length(), "TEXT", org.emftext.test.grammar_features.Grammar_featuresPackage.CLASS_WITH_ATTRIBUTES__A2));
		}
		return matched;
	}
	
	public boolean parse_SecondRoot() {
		org.eclipse.emf.ecore.EClass eClass = org.emftext.test.grammar_features.Grammar_featuresPackage.eINSTANCE.getSecondRoot();
		int commandIndexBackup = commands.size();
		int startOffset = offset;
		commands.add(new CreateObjectCommand(eClass));
		boolean success = parse_SecondRoot_choice();
		if (success) {
			commands.add(new SetLocationCommand(startOffset, offsetIgnoringUnusedTokens - 1));
			commands.add(new PopContainerCommand());
			return true;
		} else {
			discardCommands(commandIndexBackup);
			return false;
		}
	}
	
	public boolean parse_SecondRoot_choice() {
		// begin options
		if (parse_SecondRoot_choice_sequence0()) {
			return true;
		}
		// end options
		return false;
	}
	
	public boolean parse_SecondRoot_choice_sequence0() {
		boolean matchedAll = true;
		int offsetCopy = offset;
		// begin part
		// match cs string "SecondRoot"
		matchedAll &= matches("SecondRoot");
		if (!matchedAll) {
			// stop matching the sequence
			offset = offsetCopy;
			return false;
		}
		// this sequence is valid
		return true;
	}
	
}

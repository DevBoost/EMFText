/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.antlr.runtime3_4_0.CommonToken;
import org.antlr.runtime3_4_0.Parser;
import org.antlr.runtime3_4_0.RecognizerSharedState;
import org.antlr.runtime3_4_0.Token;
import org.antlr.runtime3_4_0.TokenStream;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;

public abstract class Cct5ANTLRParserBase extends Parser implements org.emftext.test.cct5.resource.cct5.ICct5TextParser {
	
	/**
	 * The index of the last token that was handled by retrieveLayoutInformation().
	 */
	private int lastPosition2;
	
	/**
	 * A collection to store all anonymous tokens.
	 */
	protected List<CommonToken> anonymousTokens = new ArrayList<CommonToken>();
	
	/**
	 * A collection that is filled with commands to be executed after parsing. This
	 * collection is cleared before parsing starts and returned as part of the parse
	 * result object.
	 */
	protected Collection<org.emftext.test.cct5.resource.cct5.ICct5Command<org.emftext.test.cct5.resource.cct5.ICct5TextResource>> postParseCommands;
	
	/**
	 * A copy of the options that were used to load the text resource. This map is
	 * filled when the parser is created.
	 */
	private Map<?, ?> options;
	
	/**
	 * A flag that indicates whether this parser runs in a special mode where the
	 * location map is not filled. If this flag is set to true, copying localization
	 * information for elements is not performed. This improves time and memory
	 * consumption.
	 */
	protected boolean disableLocationMap = false;
	
	/**
	 * A flag that indicates whether this parser runs in a special mode where layout
	 * information is not recorded. If this flag is set to true, no layout information
	 * adapters are created. This improves time and memory consumption.
	 */
	protected boolean disableLayoutRecording = false;
	
	/**
	 * A flag to indicate that the parser should stop parsing as soon as possible. The
	 * flag is set to false before parsing starts. It can be set to true by invoking
	 * the terminateParsing() method from another thread. This feature is used, when
	 * documents are parsed in the background (i.e., while editing them). In order to
	 * cancel running parsers, the parsing process can be terminated. This is done
	 * whenever a document changes, because the previous content of the document is
	 * not valid anymore and parsing the old content is not necessary any longer.
	 */
	protected boolean terminateParsing;
	
	/**
	 * A reusable container for the result of resolving tokens.
	 */
	private org.emftext.test.cct5.resource.cct5.mopp.Cct5TokenResolveResult tokenResolveResult = new org.emftext.test.cct5.resource.cct5.mopp.Cct5TokenResolveResult();
	
	protected org.emftext.test.cct5.resource.cct5.mopp.Cct5MetaInformation metaInformation = new org.emftext.test.cct5.resource.cct5.mopp.Cct5MetaInformation();
	
	public Cct5ANTLRParserBase(TokenStream input) {
		super(input);
	}
	
	public Cct5ANTLRParserBase(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}
	
	protected void retrieveLayoutInformation(EObject element, org.emftext.test.cct5.resource.cct5.grammar.Cct5SyntaxElement syntaxElement, Object object, boolean ignoreTokensAfterLastVisibleToken) {
		if (disableLayoutRecording || element == null) {
			return;
		}
		// null must be accepted, since the layout information that is found at the end of
		// documents (just before the EOF character) is not associated with a particular
		// syntax element.
		boolean isElementToStore = syntaxElement == null;
		isElementToStore |= syntaxElement instanceof org.emftext.test.cct5.resource.cct5.grammar.Cct5Placeholder;
		isElementToStore |= syntaxElement instanceof org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword;
		isElementToStore |= syntaxElement instanceof org.emftext.test.cct5.resource.cct5.grammar.Cct5EnumerationTerminal;
		isElementToStore |= syntaxElement instanceof org.emftext.test.cct5.resource.cct5.grammar.Cct5BooleanTerminal;
		if (!isElementToStore) {
			return;
		}
		org.emftext.test.cct5.resource.cct5.mopp.Cct5LayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(element);
		StringBuilder anonymousText = new StringBuilder();
		for (CommonToken anonymousToken : anonymousTokens) {
			anonymousText.append(anonymousToken.getText());
		}
		int currentPos = getTokenStream().index();
		if (currentPos == 0) {
			return;
		}
		int endPos = currentPos - 1;
		if (ignoreTokensAfterLastVisibleToken) {
			for (; endPos >= this.lastPosition2; endPos--) {
				Token token = getTokenStream().get(endPos);
				int _channel = token.getChannel();
				if (_channel != 99) {
					break;
				}
			}
		}
		StringBuilder hiddenTokenText = new StringBuilder();
		hiddenTokenText.append(anonymousText);
		StringBuilder visibleTokenText = new StringBuilder();
		CommonToken firstToken = null;
		for (int pos = this.lastPosition2; pos <= endPos; pos++) {
			Token token = getTokenStream().get(pos);
			if (firstToken == null) {
				firstToken = (CommonToken) token;
			}
			if (anonymousTokens.contains(token)) {
				continue;
			}
			int _channel = token.getChannel();
			if (_channel == 99) {
				hiddenTokenText.append(token.getText());
			} else {
				visibleTokenText.append(token.getText());
			}
		}
		int offset = -1;
		if (firstToken != null) {
			offset = firstToken.getStartIndex();
		}
		layoutInformationAdapter.addLayoutInformation(new org.emftext.test.cct5.resource.cct5.mopp.Cct5LayoutInformation(syntaxElement, object, offset, hiddenTokenText.toString(), visibleTokenText.toString()));
		this.lastPosition2 = (endPos < 0 ? 0 : endPos + 1);
		anonymousTokens.clear();
	}
	
	protected org.emftext.test.cct5.resource.cct5.mopp.Cct5LayoutInformationAdapter getLayoutInformationAdapter(EObject element) {
		for (Adapter adapter : element.eAdapters()) {
			if (adapter instanceof org.emftext.test.cct5.resource.cct5.mopp.Cct5LayoutInformationAdapter) {
				return (org.emftext.test.cct5.resource.cct5.mopp.Cct5LayoutInformationAdapter) adapter;
			}
		}
		org.emftext.test.cct5.resource.cct5.mopp.Cct5LayoutInformationAdapter newAdapter = new org.emftext.test.cct5.resource.cct5.mopp.Cct5LayoutInformationAdapter();
		element.eAdapters().add(newAdapter);
		return newAdapter;
	}
	
	protected <ContainerType extends EObject, ReferenceType extends EObject> void registerContextDependentProxy(final org.emftext.test.cct5.resource.cct5.mopp.Cct5ContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, final ContainerType container, final EReference reference, final String id, final EObject proxy) {
		final int position;
		if (reference.isMany()) {
			position = ((List<?>) container.eGet(reference)).size();
		} else {
			position = -1;
		}
		
		postParseCommands.add(new org.emftext.test.cct5.resource.cct5.ICct5Command<org.emftext.test.cct5.resource.cct5.ICct5TextResource>() {
			public boolean execute(org.emftext.test.cct5.resource.cct5.ICct5TextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.registerContextDependentProxy(factory, container, reference, id, proxy, position);
				return true;
			}
		});
	}
	
	protected Map<?,?> getOptions() {
		return options;
	}
	
	public void setOptions(Map<?,?> options) {
		this.options = options;
		this.disableLocationMap = !isLocationMapEnabled();
		this.disableLayoutRecording = !isLayoutInformationRecordingEnabled();
	}
	
	/**
	 * Creates a dynamic Java proxy that mimics the interface of the given class.
	 */
	@SuppressWarnings("unchecked")
	public <T> T createDynamicProxy(Class<T> clazz) {
		Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class<?>[]{clazz, EObject.class, InternalEObject.class}, new InvocationHandler() {
			
			private EObject dummyObject = new EObjectImpl() {};
			
			public Object invoke(Object object, Method method, Object[] args) throws Throwable {
				// search in dummyObject for the requested method
				Method[] methodsInDummy = dummyObject.getClass().getMethods();
				for (Method methodInDummy : methodsInDummy) {
					boolean matches = true;
					if (methodInDummy.getName().equals(method.getName())) {
						Class<?>[] parameterTypes = method.getParameterTypes();
						Class<?>[] parameterTypesInDummy = methodInDummy.getParameterTypes();
						if (parameterTypes.length == parameterTypesInDummy.length) {
							for (int p = 0; p < parameterTypes.length; p++) {
								Class<?> parameterType = parameterTypes[p];
								Class<?> parameterTypeInDummy = parameterTypesInDummy[p];
								if (!parameterType.equals(parameterTypeInDummy)) {
									matches = false;
								}
							}
						} else {
							matches = false;
						}
					} else {
						matches = false;
					}
					if (matches) {
						return methodInDummy.invoke(dummyObject, args);
					}
				}
				return null;
			}
		});
		return (T) proxy;
	}
	
	public void terminate() {
		terminateParsing = true;
	}
	
	protected void addMapEntry(EObject element, EStructuralFeature structuralFeature, org.emftext.test.cct5.resource.cct5.mopp.Cct5DummyEObject dummy) {
		Object value = element.eGet(structuralFeature);
		Object mapKey = dummy.getValueByName("key");
		Object mapValue = dummy.getValueByName("value");
		if (value instanceof EMap<?, ?>) {
			EMap<Object, Object> valueMap = org.emftext.test.cct5.resource.cct5.util.Cct5MapUtil.castToEMap(value);
			if (mapKey != null && mapValue != null) {
				valueMap.put(mapKey, mapValue);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean addObjectToList(EObject container, int featureID, Object object) {
		EClass eClass = container.eClass();
		EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(featureID);
		Object value = container.eGet(eStructuralFeature);
		return ((List<Object>) value).add(object);
	}
	
	@SuppressWarnings("unchecked")
	public boolean addObjectToList(EObject container, EStructuralFeature feature, Object object) {
		Object value = container.eGet(feature);
		return ((List<Object>) value).add(object);
	}
	
	protected EObject apply(EObject target, List<EObject> dummyEObjects) {
		EObject currentTarget = target;
		for (EObject object : dummyEObjects) {
			assert(object instanceof org.emftext.test.cct5.resource.cct5.mopp.Cct5DummyEObject);
			org.emftext.test.cct5.resource.cct5.mopp.Cct5DummyEObject dummy = (org.emftext.test.cct5.resource.cct5.mopp.Cct5DummyEObject) object;
			EObject newEObject = dummy.applyTo(currentTarget);
			currentTarget = newEObject;
		}
		return currentTarget;
	}
	
	protected org.emftext.test.cct5.resource.cct5.mopp.Cct5TokenResolveResult getFreshTokenResolveResult() {
		tokenResolveResult.clear();
		return tokenResolveResult;
	}
	
	protected org.emftext.test.cct5.resource.cct5.mopp.Cct5ReferenceResolverSwitch getReferenceResolverSwitch() {
		org.emftext.test.cct5.resource.cct5.mopp.Cct5ReferenceResolverSwitch resolverSwitch = (org.emftext.test.cct5.resource.cct5.mopp.Cct5ReferenceResolverSwitch) metaInformation.getReferenceResolverSwitch();
		resolverSwitch.setOptions(options);
		return resolverSwitch;
	}
	
	public boolean isLayoutInformationRecordingEnabled() {
		if (options == null) {
			return true;
		}
		Object value = options.get(org.emftext.test.cct5.resource.cct5.ICct5Options.DISABLE_LAYOUT_INFORMATION_RECORDING);
		return value == null || Boolean.FALSE.equals(value);
	}
	
	public boolean isLocationMapEnabled() {
		if (options == null) {
			return true;
		}
		Object value = options.get(org.emftext.test.cct5.resource.cct5.ICct5Options.DISABLE_LOCATION_MAP);
		return value == null || Boolean.FALSE.equals(value);
	}
	
}

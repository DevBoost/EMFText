package org.emftext.sdk.codegen;

import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.IInputStreamProcessorProvider;
import org.emftext.runtime.IOptionProvider;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.InputStreamProcessor;
import org.emftext.runtime.resource.EProblemType;
import org.emftext.runtime.resource.IBracketPair;
import org.emftext.runtime.resource.ICommand;
import org.emftext.runtime.resource.IContextDependentURIFragment;
import org.emftext.runtime.resource.IElementMapping;
import org.emftext.runtime.resource.IExpectedElement;
import org.emftext.runtime.resource.IHoverTextProvider;
import org.emftext.runtime.resource.ILocationMap;
import org.emftext.runtime.resource.IParseResult;
import org.emftext.runtime.resource.IProblem;
import org.emftext.runtime.resource.IReferenceMapping;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.IReferenceResolver;
import org.emftext.runtime.resource.IReferenceResolverSwitch;
import org.emftext.runtime.resource.ITextDiagnostic;
import org.emftext.runtime.resource.ITextParser;
import org.emftext.runtime.resource.ITextPrinter;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.ITextResourcePluginMetaInformation;
import org.emftext.runtime.resource.ITextScanner;
import org.emftext.runtime.resource.ITextToken;
import org.emftext.runtime.resource.ITokenResolveResult;
import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.ITokenResolverFactory;
import org.emftext.runtime.resource.ITokenStyle;
import org.emftext.runtime.resource.IURIMapping;
import org.emftext.runtime.resource.impl.AbstractBracketPair;
import org.emftext.runtime.resource.impl.AbstractEMFTextParser;
import org.emftext.runtime.resource.impl.AbstractEMFTextScanner;
import org.emftext.runtime.resource.impl.AbstractParseResult;
import org.emftext.runtime.resource.impl.AbstractProblem;
import org.emftext.runtime.resource.impl.AbstractReferenceMapping;
import org.emftext.runtime.resource.impl.AbstractTextResource;
import org.emftext.runtime.resource.impl.AbstractTextResourcePluginMetaInformation;
import org.emftext.runtime.resource.impl.AbstractTokenResolver;
import org.emftext.runtime.resource.impl.AbstractTokenStyle;
import org.emftext.runtime.resource.impl.TerminateParsingException;
import org.emftext.runtime.resource.impl.code_completion.CodeCompletionHelper;
import org.emftext.runtime.ui.AntlrTokenHelper;
import org.emftext.runtime.ui.IBackgroundParsingListener;
import org.emftext.runtime.ui.IBackgroundParsingStrategy;
import org.emftext.runtime.ui.MarkerHelper;
import org.emftext.runtime.ui.impl.AbstractBackgroundParsingListener;
import org.emftext.runtime.ui.impl.AbstractBackgroundParsingStrategy;
import org.emftext.runtime.ui.preferences.PreferenceConstants;
import org.emftext.runtime.ui.preferences.PreferenceInitializer;
import org.emftext.runtime.ui.preferences.SyntaxColoringHelper;
import org.emftext.runtime.ui.preferences.SyntaxColoringHelper.StyleProperty;
import org.emftext.runtime.util.CastUtil;
import org.emftext.runtime.util.CopiedEList;
import org.emftext.runtime.util.CopiedEObjectInternalEList;
import org.emftext.runtime.util.EObjectUtil;
import org.emftext.runtime.util.ListUtil;
import org.emftext.runtime.util.MapUtil;
import org.emftext.runtime.util.StringUtil;

public class ClassNameHelper {

	private GenerationContext context;

	public ClassNameHelper(GenerationContext context) {
		super();
		this.context = context;
	}

	// EMFText Runtime Classes
	public String getABSTRACT_BACKGROUND_PARSING_STRATEGY() {
		return AbstractBackgroundParsingStrategy.class.getName();
	}

	public String getABSTRACT_BACKGROUND_PARSING_LISTENER() {
		return AbstractBackgroundParsingListener.class.getName();
	}

	public String getABSTRACT_BRACKET_PAIR() {
		return AbstractBracketPair.class.getName();
	}

	public String getABSTRACT_EMF_TEXT_PARSER() {
		return AbstractEMFTextParser.class.getName();
	}

	public String getABSTRACT_EMF_TEXT_SCANNER() {
		return AbstractEMFTextScanner.class.getName();
	}

	public String getABSTRACT_PARSE_RESULT() {
		return AbstractParseResult.class.getName();
	}

	public String getABSTRACT_PROBLEM() {
		return AbstractProblem.class.getName();
	}

	public String getABSTRACT_REFERENCE_MAPPING() {
		return AbstractReferenceMapping.class.getName();
	}

	public String getABSTRACT_TEXT_RESOURCE() {
		return AbstractTextResource.class.getName();
	}

	public String getABSTRACT_TEXT_RESOURCE_PLUGIN_META_INFORMATION() {
		return AbstractTextResourcePluginMetaInformation.class.getName();
	}

	public String getABSTRACT_TOKEN_RESOLVER() {
		return AbstractTokenResolver.class.getName();
	}

	public String getABSTRACT_TOKEN_STYLE() {
		return AbstractTokenStyle.class.getName();
	}

	public String getANTLR_TOKEN_HELPER() {
		return AntlrTokenHelper.class.getName();
	}

	public String getCAST_UTIL() {
		return CastUtil.class.getName();
	}

	public String getCODE_COMPLETION_HELPER() {
		return CodeCompletionHelper.class.getName();
	}

	public String getCOPIED_E_LIST() {
		return CopiedEList.class.getName();
	}

	public String getCOPIED_E_OBJECT_INTERNAL_E_LIST() {
		return CopiedEObjectInternalEList.class.getName();
	}

	public String getEMFTEXT_RUNTIME_PLUGIN() {
		return EMFTextRuntimePlugin.class.getName();
	}

	public String getE_OBJECT_UTIL() {
		return EObjectUtil.class.getName();
	}

	public String getE_PROBLEM_TYPE() {
		return EProblemType.class.getName();
	}

	public String getINPUT_STREAM_PROCESSOR() {
		return InputStreamProcessor.class.getName();
	}

	public String getI_BACKGROUND_PARSING_LISTENER() {
		return IBackgroundParsingListener.class.getName();
	}

	public String getI_BACKGROUND_PARSING_STRATEGY() {
		return IBackgroundParsingStrategy.class.getName();
	}

	public String getI_BRACKET_PAIR() {
		return IBracketPair.class.getName();
	}

	public String getI_COMMAND() {
		return ICommand.class.getName();
	}

	public String getI_CONTEXT_DEPENDENT_URI_FRAGMENT() {
		return IContextDependentURIFragment.class.getName();
	}

	public String getI_ELEMENT_MAPPING() {
		return IElementMapping.class.getName();
	}

	public String getI_EXPECTED_ELEMENT() {
		return IExpectedElement.class.getName();
	}

	public String getI_HOVER_TEXT_PROVIDER() {
		return IHoverTextProvider.class.getName();
	}

	public String getI_INPUT_STREAM_PROCESSOR_PROVIDER() {
		return IInputStreamProcessorProvider.class.getName();
	}

	public String getI_LOCATION_MAP() {
		return ILocationMap.class.getName();
	}

	public String getI_OPTIONS() {
		return IOptions.class.getName();
	}

	public String getI_OPTION_PROVIDER() {
		return IOptionProvider.class.getName();
	}

	public String getI_PARSE_RESULT() {
		return IParseResult.class.getName();
	}

	public String getI_PROBLEM() {
		return IProblem.class.getName();
	}

	public String getI_REFERENCE_MAPPING() {
		return IReferenceMapping.class.getName();
	}

	public String getI_REFERENCE_RESOLVER() {
		return IReferenceResolver.class.getName();
	}

	public String getI_REFERENCE_RESOLVER_SWITCH() {
		return IReferenceResolverSwitch.class.getName();
	}

	public String getI_REFERENCE_RESOLVE_RESULT() {
		return IReferenceResolveResult.class.getName();
	}

	public String getI_RESOURCE_POST_PROCESSOR() {
		return IResourcePostProcessor.class.getName();
	}

	public String getI_TEXT_DIAGNOSTIC() {
		return ITextDiagnostic.class.getName();
	}

	public String getI_TEXT_PARSER() {
		return ITextParser.class.getName();
	}

	public String getI_TEXT_PRINTER() {
		return ITextPrinter.class.getName();
	}

	public String getI_TEXT_RESOURCE() {
		return ITextResource.class.getName();
	}

	public String getI_TEXT_RESOURCE_PLUGIN_META_INFORMATION() {
		return ITextResourcePluginMetaInformation.class.getName();
	}

	public String getI_TEXT_SCANNER() {
		return ITextScanner.class.getName();
	}

	public String getI_TEXT_TOKEN() {
		return ITextToken.class.getName();
	}

	public String getI_TOKEN_RESOLVER() {
		return ITokenResolver.class.getName();
	}

	public String getI_TOKEN_RESOLVER_FACTORY() {
		return ITokenResolverFactory.class.getName();
	}

	public String getI_TOKEN_RESOLVE_RESULT() {
		return ITokenResolveResult.class.getName();
	}

	public String getI_TOKEN_STYLE() {
		return ITokenStyle.class.getName();
	}

	public String getI_URI_MAPPING() {
		return IURIMapping.class.getName();
	}

	public String getLIST_UTIL() {
		return ListUtil.class.getName();
	}

	public String getMAP_UTIL() {
		return MapUtil.class.getName();
	}

	public String getMARKER_HELPER() {
		return MarkerHelper.class.getName();
	}

	public String getPREFERENCE_CONSTANTS() {
		return PreferenceConstants.class.getName();
	}

	public String getPREFERENCE_INITIALIZER() {
		return PreferenceInitializer.class.getName();
	}

	public String getSTRING_UTIL() {
		return StringUtil.class.getName();
	}

	public String getSTYLE_PROPERTY() {
		return StyleProperty.class.getCanonicalName();
	}

	public String getSYNTAX_COLORING_HELPER() {
		return SyntaxColoringHelper.class.getName();
	}

	public String getTERMINATE_PARSING_EXCEPTION() {
		return TerminateParsingException.class.getName();
	}
}

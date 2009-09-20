package org.emftext.sdk.codegen;

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
import org.emftext.runtime.ui.AntlrTokenHelper;
import org.emftext.runtime.ui.IBackgroundParsingListener;
import org.emftext.runtime.ui.IBackgroundParsingStrategy;
import org.emftext.runtime.ui.impl.AbstractBackgroundParsingListener;
import org.emftext.runtime.ui.impl.AbstractBackgroundParsingStrategy;

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
		return context.getQualifiedClassName(EArtifact.CAST_UTIL);
	}

	public String getCODE_COMPLETION_HELPER() {
		return context.getQualifiedClassName(EArtifact.CODE_COMPLETION_HELPER);
	}

	public String getCOPIED_E_LIST() {
		return context.getQualifiedClassName(EArtifact.COPIED_E_LIST);
	}

	public String getCOPIED_E_OBJECT_INTERNAL_E_LIST() {
		return context.getQualifiedClassName(EArtifact.COPIED_E_OBJECT_INTERNAL_E_LIST);
	}

	public String getEMFTEXT_RUNTIME_PLUGIN() {
		return context.getQualifiedClassName(EArtifact.PLUGIN_ACTIVATOR);
	}

	public String getE_OBJECT_UTIL() {
		return context.getQualifiedClassName(EArtifact.E_OBJECT_UTIL);
	}

	public String getE_PROBLEM_TYPE() {
		return context.getQualifiedClassName(EArtifact.E_PROBLEM_TYPE);
	}

	public String getINPUT_STREAM_PROCESSOR() {
		return context.getQualifiedClassName(EArtifact.INPUT_STREAM_PROCESSOR);
	}

	public String getI_BACKGROUND_PARSING_LISTENER() {
		return IBackgroundParsingListener.class.getName();
	}

	public String getI_BACKGROUND_PARSING_STRATEGY() {
		return IBackgroundParsingStrategy.class.getName();
	}

	public String getI_BRACKET_PAIR() {
		return context.getQualifiedClassName(EArtifact.I_BRACKET_PAIR);
	}

	public String getI_COMMAND() {
		return context.getQualifiedClassName(EArtifact.I_COMMAND);
	}

	public String getI_CONTEXT_DEPENDENT_URI_FRAGMENT() {
		return context.getQualifiedClassName(EArtifact.I_CONTEXT_DEPENDENT_URI_FRAGMENT);
	}

	public String getI_ELEMENT_MAPPING() {
		return context.getQualifiedClassName(EArtifact.I_ELEMENT_MAPPING);
	}

	public String getI_EXPECTED_ELEMENT() {
		return context.getQualifiedClassName(EArtifact.I_EXPECTED_ELEMENT);
	}

	public String getI_HOVER_TEXT_PROVIDER() {
		return context.getQualifiedClassName(EArtifact.I_HOVER_TEXT_PROVIDER);
	}

	public String getI_INPUT_STREAM_PROCESSOR_PROVIDER() {
		return context.getQualifiedClassName(EArtifact.I_INPUT_STREAM_PROCESSOR_PROVIDER);
	}

	public String getI_LOCATION_MAP() {
		return context.getQualifiedClassName(EArtifact.I_LOCATION_MAP);
	}

	public String getI_OPTIONS() {
		return context.getQualifiedClassName(EArtifact.I_OPTIONS);
	}

	public String getI_OPTION_PROVIDER() {
		return context.getQualifiedClassName(EArtifact.I_OPTION_PROVIDER);
	}

	public String getI_PARSE_RESULT() {
		return context.getQualifiedClassName(EArtifact.I_PARSE_RESULT);
	}

	public String getI_PROBLEM() {
		return context.getQualifiedClassName(EArtifact.I_PROBLEM);
	}

	public String getI_REFERENCE_MAPPING() {
		return context.getQualifiedClassName(EArtifact.I_REFERENCE_MAPPING);
	}

	public String getI_REFERENCE_RESOLVER() {
		return context.getQualifiedClassName(EArtifact.I_REFERENCE_RESOLVER);
	}

	public String getI_REFERENCE_RESOLVER_SWITCH() {
		return context.getQualifiedClassName(EArtifact.I_REFERENCE_RESOLVER_SWITCH);
	}

	public String getI_REFERENCE_RESOLVE_RESULT() {
		return context.getQualifiedClassName(EArtifact.I_REFERENCE_RESOLVE_RESULT);
	}

	public String getI_RESOURCE_POST_PROCESSOR() {
		return context.getQualifiedClassName(EArtifact.I_RESOURCE_POST_PROCESSOR);
	}

	public String getI_TEXT_DIAGNOSTIC() {
		return context.getQualifiedClassName(EArtifact.I_TEXT_DIAGNOSTIC);
	}

	public String getI_TEXT_PARSER() {
		return context.getQualifiedClassName(EArtifact.I_TEXT_PARSER);
	}

	public String getI_TEXT_PRINTER() {
		return context.getQualifiedClassName(EArtifact.I_TEXT_PRINTER);
	}

	public String getI_TEXT_RESOURCE() {
		return context.getQualifiedClassName(EArtifact.I_TEXT_RESOURCE);
	}

	public String getI_TEXT_RESOURCE_PLUGIN_META_INFORMATION() {
		return context.getQualifiedClassName(EArtifact.I_TEXT_RESOURCE_PLUGIN_META_INFORMATION);
	}

	public String getI_TEXT_SCANNER() {
		return context.getQualifiedClassName(EArtifact.I_TEXT_SCANNER);
	}

	public String getI_TEXT_TOKEN() {
		return context.getQualifiedClassName(EArtifact.I_TEXT_TOKEN);
	}

	public String getI_TOKEN_RESOLVER() {
		return context.getQualifiedClassName(EArtifact.I_TOKEN_RESOLVER);
	}

	public String getI_TOKEN_RESOLVER_FACTORY() {
		return context.getQualifiedClassName(EArtifact.I_TOKEN_RESOLVER_FACTORY);
	}

	public String getI_TOKEN_RESOLVE_RESULT() {
		return context.getQualifiedClassName(EArtifact.I_TOKEN_RESOLVE_RESULT);
	}

	public String getI_TOKEN_STYLE() {
		return context.getQualifiedClassName(EArtifact.I_TOKEN_STYLE);
	}

	public String getI_URI_MAPPING() {
		return context.getQualifiedClassName(EArtifact.IURI_MAPPING);
	}

	public String getLIST_UTIL() {
		return context.getQualifiedClassName(EArtifact.LIST_UTIL);
	}

	public String getMAP_UTIL() {
		return context.getQualifiedClassName(EArtifact.MAP_UTIL);
	}

	public String getMARKER_HELPER() {
		return context.getQualifiedClassName(EArtifact.MARKER_HELPER);
	}

	public String getPREFERENCE_CONSTANTS() {
		return context.getQualifiedClassName(EArtifact.PREFERENCE_CONSTANTS);
	}

	public String getPREFERENCE_INITIALIZER() {
		return context.getQualifiedClassName(EArtifact.PREFERENCE_INITIALIZER);
	}

	public String getSTRING_UTIL() {
		return context.getQualifiedClassName(EArtifact.STRING_UTIL);
	}

	public String getSTYLE_PROPERTY() {
		return getSYNTAX_COLORING_HELPER() + ".StyleProperty";
	}

	public String getSYNTAX_COLORING_HELPER() {
		return context.getQualifiedClassName(EArtifact.SYNTAX_COLORING_HELPER);
	}

	public String getTERMINATE_PARSING_EXCEPTION() {
		return TerminateParsingException.class.getName();
	}
}

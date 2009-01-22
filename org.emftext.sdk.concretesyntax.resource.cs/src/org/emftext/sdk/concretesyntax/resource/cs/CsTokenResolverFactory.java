package org.emftext.sdk.concretesyntax.resource.cs;

public class CsTokenResolverFactory extends org.emftext.runtime.resource.impl.AbstractTokenResolverFactory implements org.emftext.runtime.resource.ITokenResolverFactory {

	public CsTokenResolverFactory(){
		super.registerTokenResolver("TEXT", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsTEXTTokenResolver());
		super.registerTokenResolver("QNAME", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQNAMETokenResolver());
		super.registerTokenResolver("TEXT_33_", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsTEXT_33_TokenResolver());
		super.registerTokenResolver("QUOTED_36_36", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_36_36TokenResolver());
		super.registerTokenResolver("QUOTED_39_39", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_39_39TokenResolver());
		super.registerTokenResolver("QUOTED_60_62", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_60_62TokenResolver());
		super.registerTokenResolver("TEXT_35_", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsTEXT_35_TokenResolver());
		super.registerTokenResolver("QUOTED_34_34", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_34_34TokenResolver());
	}
}

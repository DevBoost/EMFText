package org.emftext.sdk.concretesyntax.resource.cs;

public class CsTokenResolverFactory extends org.emftext.runtime.resource.impl.AbstractTokenResolverFactory implements org.emftext.runtime.resource.ITokenResolverFactory {
	
	public CsTokenResolverFactory() {
		super.registerTokenResolver("QUALIFIED_NAME", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUALIFIED_NAMETokenResolver());
		super.registerTokenResolver("NUMBER", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsNUMBERTokenResolver());
		super.registerTokenResolver("HEXNUMBER", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsHEXNUMBERTokenResolver());
		super.registerTokenResolver("QUOTED_60_62", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_60_62TokenResolver());
		super.registerTokenResolver("QUOTED_34_34", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_34_34TokenResolver());
		super.registerTokenResolver("QUOTED_39_39", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_39_39TokenResolver());
		super.registerTokenResolver("QUOTED_36_36", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_36_36TokenResolver());
	}
}

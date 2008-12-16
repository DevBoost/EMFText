package org.emftext.sdk.concretesyntax.resource.cs;

import org.emftext.runtime.resource.ITokenResolverFactory;
import org.emftext.runtime.resource.impl.BasicTokenResolverFactory;

import org.emftext.sdk.concretesyntax.resource.cs.analysis.*;

public class CsTokenResolverFactory extends BasicTokenResolverFactory implements ITokenResolverFactory{

	public CsTokenResolverFactory(){
		super.registerTokenResolver("TEXT",new CsTEXTTokenResolver());
		super.registerTokenResolver("TEXT_33_",new CsTEXT_33_TokenResolver());
		super.registerTokenResolver("QUOTED_36_36",new CsQUOTED_36_36TokenResolver());
		super.registerTokenResolver("QUOTED_60_62",new CsQUOTED_60_62TokenResolver());
		super.registerTokenResolver("TEXT_35_",new CsTEXT_35_TokenResolver());
		super.registerTokenResolver("QUOTED_39_39",new CsQUOTED_39_39TokenResolver());
		super.registerTokenResolver("QUOTED_34_34",new CsQUOTED_34_34TokenResolver());
		super.registerTokenResolver("QNAME",new CsQNAMETokenResolver());
	}
}

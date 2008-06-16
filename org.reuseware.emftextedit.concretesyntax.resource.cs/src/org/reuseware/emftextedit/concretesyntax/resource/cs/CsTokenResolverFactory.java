package org.reuseware.emftextedit.concretesyntax.resource.cs;

import org.reuseware.emftextedit.resource.TokenResolverFactory;
import org.reuseware.emftextedit.resource.impl.BasicTokenResolverFactory;

import org.reuseware.emftextedit.concretesyntax.resource.cs.analysis.*;

public class CsTokenResolverFactory extends BasicTokenResolverFactory implements TokenResolverFactory{

	public CsTokenResolverFactory(){
		super.registerTokenResolver("QUOTED_39_39",new CsQUOTED_39_39TokenResolver());
		super.registerTokenResolver("TEXT_33_",new CsTEXT_33_TokenResolver());
		super.registerTokenResolver("TEXT",new CsTEXTTokenResolver());
		super.registerTokenResolver("QUOTED_36_36",new CsQUOTED_36_36TokenResolver());
		super.registerTokenResolver("QNAME",new CsQNAMETokenResolver());
		super.registerTokenResolver("QUOTED_34_34",new CsQUOTED_34_34TokenResolver());
		super.registerTokenResolver("TEXT_35_",new CsTEXT_35_TokenResolver());
		super.registerTokenResolver("QUOTED_60_62",new CsQUOTED_60_62TokenResolver());
	}
}

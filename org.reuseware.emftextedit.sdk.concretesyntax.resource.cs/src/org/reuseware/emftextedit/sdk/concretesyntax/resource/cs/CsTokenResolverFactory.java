package org.reuseware.emftextedit.sdk.concretesyntax.resource.cs;

import org.reuseware.emftextedit.runtime.resource.TokenResolverFactory;
import org.reuseware.emftextedit.runtime.resource.impl.BasicTokenResolverFactory;
import org.reuseware.emftextedit.sdk.concretesyntax.resource.cs.analysis.CsQNAMETokenResolver;
import org.reuseware.emftextedit.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_34_34TokenResolver;
import org.reuseware.emftextedit.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_36_36TokenResolver;
import org.reuseware.emftextedit.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_39_39TokenResolver;
import org.reuseware.emftextedit.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_60_62TokenResolver;
import org.reuseware.emftextedit.sdk.concretesyntax.resource.cs.analysis.CsTEXTTokenResolver;
import org.reuseware.emftextedit.sdk.concretesyntax.resource.cs.analysis.CsTEXT_33_TokenResolver;
import org.reuseware.emftextedit.sdk.concretesyntax.resource.cs.analysis.CsTEXT_35_TokenResolver;

public class CsTokenResolverFactory extends BasicTokenResolverFactory implements TokenResolverFactory{

	public CsTokenResolverFactory(){
		super.registerTokenResolver("QUOTED_60_62",new CsQUOTED_60_62TokenResolver());
		super.registerTokenResolver("QUOTED_34_34",new CsQUOTED_34_34TokenResolver());
		super.registerTokenResolver("TEXT",new CsTEXTTokenResolver());
		super.registerTokenResolver("QUOTED_36_36",new CsQUOTED_36_36TokenResolver());
		super.registerTokenResolver("QNAME",new CsQNAMETokenResolver());
		super.registerTokenResolver("QUOTED_39_39",new CsQUOTED_39_39TokenResolver());
		super.registerTokenResolver("TEXT_33_",new CsTEXT_33_TokenResolver());
		super.registerTokenResolver("TEXT_35_",new CsTEXT_35_TokenResolver());
	}
}

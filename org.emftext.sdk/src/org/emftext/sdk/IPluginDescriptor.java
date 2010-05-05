package org.emftext.sdk;

import org.emftext.sdk.concretesyntax.ConcreteSyntax;

public interface IPluginDescriptor {

	public abstract String getBasePackage(ConcreteSyntax syntax);

	public abstract String getName(ConcreteSyntax syntax);

}
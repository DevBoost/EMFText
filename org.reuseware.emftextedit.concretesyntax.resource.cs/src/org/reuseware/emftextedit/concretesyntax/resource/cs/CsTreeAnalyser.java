package org.reuseware.emftextedit.concretesyntax.resource.cs; 

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.reuseware.emftextedit.resource.TextResource;
import org.reuseware.emftextedit.resource.impl.*;

import org.reuseware.emftextedit.concretesyntax.DefinedPlaceholder;
import org.reuseware.emftextedit.concretesyntax.Import;
import org.reuseware.emftextedit.concretesyntax.Terminal;
import org.reuseware.emftextedit.concretesyntax.ConcreteSyntax;
import org.reuseware.emftextedit.concretesyntax.Rule;
import org.reuseware.emftextedit.concretesyntax.resource.cs.analysis.*;

public class CsTreeAnalyser extends EMFTextTreeAnalyserImpl {

	protected DefinedPlaceholderTokenProxyResolver definedPlaceholderTokenProxyResolver = new DefinedPlaceholderTokenProxyResolver();

	protected ImportPackageProxyResolver importPackageProxyResolver = new ImportPackageProxyResolver();

	protected TerminalFeatureProxyResolver terminalFeatureProxyResolver = new TerminalFeatureProxyResolver();

	protected ImportConcreteSyntaxProxyResolver importConcreteSyntaxProxyResolver = new ImportConcreteSyntaxProxyResolver();

	protected ConcreteSyntaxStartSymbolsProxyResolver concreteSyntaxStartSymbolsProxyResolver = new ConcreteSyntaxStartSymbolsProxyResolver();

	protected ConcreteSyntaxPackageProxyResolver concreteSyntaxPackageProxyResolver = new ConcreteSyntaxPackageProxyResolver();

	protected RuleMetaclassProxyResolver ruleMetaclassProxyResolver = new RuleMetaclassProxyResolver();

	protected EObject resolveProxy(InternalEObject proxy, EObject container, EReference reference, TextResource resource, boolean reportErrors) {
		if (container instanceof DefinedPlaceholder && reference.getFeatureID() == 2) {
			return definedPlaceholderTokenProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
			}
		if (container instanceof Import && reference.getFeatureID() == 2) {
			return importPackageProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
			}
		if (container instanceof Terminal && reference.getFeatureID() == 1) {
			return terminalFeatureProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
			}
		if (container instanceof Import && reference.getFeatureID() == 1) {
			return importConcreteSyntaxProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
			}
		if (container instanceof ConcreteSyntax && reference.getFeatureID() == 3) {
			return concreteSyntaxStartSymbolsProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
			}
		if (container instanceof ConcreteSyntax && reference.getFeatureID() == 1) {
			return concreteSyntaxPackageProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
			}
		if (container instanceof Rule && reference.getFeatureID() == 1) {
			return ruleMetaclassProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
			}
		return null;
	}

}

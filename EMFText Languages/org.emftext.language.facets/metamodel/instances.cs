SYNTAXDEF facet_classification
FOR <http://description/1.0> <description.genmodel>
START FragmentDescription

IMPORTS {
	org.eclipse.emf.ecore : <http://www.eclipse.org/emf/2002/Ecore>
}

OPTIONS {
	basePackage = "org.emftext.language.facets.resource.facet_classification";
	resourcePluginID = "org.emftext.language.facets.resource.facet_classification";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

RULES {
	
	FragmentDescription ::= "FragmentDescription" subject['<','>'] facets*;

	Facet ::= 
		type['"','"'] values['"','"']* 
		;
}
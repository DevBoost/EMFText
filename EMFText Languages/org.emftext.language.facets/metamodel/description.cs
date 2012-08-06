SYNTAXDEF facet_definition
FOR <http://description/1.0>
START FacetDefinition

IMPORTS {
	org.eclipse.emf.ecore : <http://www.eclipse.org/emf/2002/Ecore>
}

OPTIONS {
	basePackage = "org.emftext.language.facets.resource.facet_definition";
	resourcePluginID = "org.emftext.language.facets.resource.facet_definition";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE T_MULTIVALUE $'multi'$;
}

TOKENSTYLES {
	"T_MULTIVALUE" COLOR #800000, BOLD;
}

RULES {
	
	FacetDefinition ::= "FacetDefinition"  facetTypes*;

	DateFacet ::= 
		multiValue[T_MULTIVALUE]? "DateFacet" 
		name['"','"'] (description['(',')'])? ":" values ("," values)* 
		//derivationData
		//query['"','"']
		;
	
	ListFacet ::= 
		multiValue[T_MULTIVALUE]? "ListFacet"  
		name['"','"'] (description['(',')'])? ":" values ("," values)* 
		//derivationData
		//query['"','"']
		;
	
	RangeFacet ::= 
		multiValue[T_MULTIVALUE]? "RangeFacet"  
		name['"','"'] (description['(',')'])? ":" values ("," values)* 
		//derivationData
		//query['"','"']
		;
	
	TreeFacet ::= 
		multiValue[T_MULTIVALUE]? "TreeFacet" 
		name['"','"'] (description['(',')'])? ":" values ("," values)* 
		//derivationData
		//query['"','"']
		;
	
	FreeTextFacet ::=  
		multiValue[T_MULTIVALUE]? "FreeTextFacet" 
		name['"','"'] (description['(',')'])? ":" values ("," values)* 
		//derivationData
		//query['"','"']
		;
	
	FacetValue ::= 
		name['"','"'] (description['(',')'])?
		//value 
		children*;
}
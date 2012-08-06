SYNTAXDEF MF
FOR <http://www.emftext.org/language/manifest>
START Manifest

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";

	usePredefinedTokens = "false";
	//overridePluginXML = "false";
	//overrideManifest = "false";
	//overrideBuildProperties = "true";
	//overrideClasspath = "true";
	//overrideProjectFile = "false";

	resourcePluginID = "org.emftext.language.manifest.resource.manifest";
	basePackage = "org.emftext.language.manifest.resource.manifest";
	resourceUIPluginID = "org.emftext.language.manifest.resource.manifest.ui";
	uiBasePackage = "org.emftext.language.manifest.resource.manifest.ui";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
} 

TOKENS {
//	DEFINE INTEGER$('1'..'9')('0'..'9')*|'0'$;
//	DEFINE FLOAT$('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+$;
	
//	DEFINE BOOLEAN$ 'TRUE' | 'true' | 'FALSE' | 'false'$;
	DEFINE LITERAL$ '"' ( ~( '\u0022' | '\u005C' ) | ('\\'('t'|'b'|'n'|'r'|'f'|'\\'|'\"'|'\'')) )* '"' $;
//	DEFINE VARIABLE$ (('?') | ('\u0024')) ('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-')+ $;
//	DEFINE NODE$ '_:'('A'..'Z' | 'a'..'z' | '\u00C0'..'\u00D6' | '\u00D8'..'\u00F6' | '\u00F8'..'\u02FF' | '\u0370'..'\u037D' | '\u037F'..'\u1FFF' | '\u200C'..'\u200D' | '\u2070'..'\u218F' | '\u2C00'..'\u2FEF' | '\u3001'..'\uD7FF' | '\uF900'..'\uFDCF' | '\uFDF0'..'\uFFFD' | '_' | '0'..'9' ) (('A'..'Z' | 'a'..'z' | '\u00C0'..'\u00D6'| '\u00D8'..'\u00F6' | '\u00F8'..'\u02FF' | '\u0370'..'\u037D' | '\u037F'..'\u1FFF' | '\u200C'..'\u200D' | '\u2070'..'\u218F' | '\u2C00'..'\u2FEF' | '\u3001'..'\uD7FF' | '\uF900'..'\uFDCF' | '\uFDF0'..'\uFFFD' | '_' | '0'..'9' | '\u00B7' | '\u0300'..'\u036F' | '\u203F'..'\u2040' | '.' )* ('A'..'Z' | 'a'..'z' | '\u00C0'..'\u00D6'| '\u00D8'..'\u00F6' | '\u00F8'..'\u02FF' | '\u0370'..'\u037D' | '\u037F'..'\u1FFF' | '\u200C'..'\u200D' | '\u2070'..'\u218F' | '\u2C00'..'\u2FEF' | '\u3001'..'\uD7FF' | '\uF900'..'\uFDCF' | '\uFDF0'..'\uFFFD' | '_' | '.' | '0'..'9' | '\u00B7' | '\u0300'..'\u036F' | '\u203F'..'\u2040'))? $ ;
//	DEFINE FULLIRI$ '<' (~( '^' | '<' | '>' | '"' | '{' | '}' | '`' | '\\' | '\u0000'..'\u0020' ))* '>' $;
//	DEFINE ABBRIRI$ ((('A'..'Z' | 'a'..'z' | '\u00C0'..'\u00D6' | '\u00D8'..'\u00F6' | '\u00F8'..'\u02FF' | '\u0370'..'\u037D' | '\u037F'..'\u1FFF' | '\u200C'..'\u200D' | '\u2070'..'\u218F' | '\u2C00'..'\u2FEF' | '\u3001'..'\uD7FF' | '\uF900'..'\uFDCF' | '\uFDF0'..'\uFFFD' | '_' | '-' | '0'..'9' ) ('A'..'Z' | 'a'..'z' | '\u00C0'..'\u00D6' | '\u00D8'..'\u00F6' | '\u00F8'..'\u02FF' | '\u0370'..'\u037D' | '\u037F'..'\u1FFF' | '\u200C'..'\u200D' | '\u2070'..'\u218F' | '\u2C00'..'\u2FEF' | '\u3001'..'\uD7FF' | '\uF900'..'\uFDCF' | '\uFDF0'..'\uFFFD' | '_' | '-' | '0'..'9' | '\u00B7' | '\u0300'..'\u036F' | '\u203F'..'\u2040' | '.' )*) |
//	((('A'..'Z' | 'a'..'z' | '\u00C0'..'\u00D6' | '\u00D8'..'\u00F6' | '\u00F8'..'\u02FF' | '\u0370'..'\u037D' | '\u037F'..'\u1FFF' | '\u200C'..'\u200D' | '\u2070'..'\u218F' | '\u2C00'..'\u2FEF' | '\u3001'..'\uD7FF' | '\uF900'..'\uFDCF' | '\uFDF0'..'\uFFFD') ('A'..'Z' | 'a'..'z' | '\u00C0'..'\u00D6' | '\u00D8'..'\u00F6' | '\u00F8'..'\u02FF' | '\u0370'..'\u037D' | '\u037F'..'\u1FFF' | '\u200C'..'\u200D' | '\u2070'..'\u218F' | '\u2C00'..'\u2FEF' | '\u3001'..'\uD7FF' | '\uF900'..'\uFDCF' | '\uFDF0'..'\uFFFD' | '_' | '-' | '0'..'9' | '\u00B7' | '\u0300'..'\u036F' | '\u203F'..'\u2040' | '.')*) ':'
//	('A'..'Z' | 'a'..'z' | '\u00C0'..'\u00D6' | '\u00D8'..'\u00F6' | '\u00F8'..'\u02FF' | '\u0370'..'\u037D' | '\u037F'..'\u1FFF' | '\u200C'..'\u200D' | '\u2070'..'\u218F' | '\u2C00'..'\u2FEF' | '\u3001'..'\uD7FF' | '\uF900'..'\uFDCF' | '\uFDF0'..'\uFFFD' | '_' | '-' | '0'..'9' ) ('A'..'Z' | 'a'..'z' | '\u00C0'..'\u00D6' | '\u00D8'..'\u00F6' | '\u00F8'..'\u02FF' | '\u0370'..'\u037D' | '\u037F'..'\u1FFF' | '\u200C'..'\u200D' | '\u2070'..'\u218F' | '\u2C00'..'\u2FEF' | '\u3001'..'\uD7FF' | '\uF900'..'\uFDCF' | '\uFDF0'..'\uFFFD' | '_' | '-' | '0'..'9' | '\u00B7' | '\u0300'..'\u036F' | '\u203F'..'\u2040' | '.' )*))$;
//	DEFINE VERSION $(('0'..'9')+ '.'?)+$;
//	DEFINE MFTOKEN $('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-')+$;
//	DEFINE BUNDLE $('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' | '.')+$;
//	DEFINE URL $('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' | '.' | ':' | '/')+$;
	DEFINE ALPHANUMEXT $('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' | '.' | '(' | ')' | '/' | '%' | '&' | '<' | '>' | '\u0024' | ':')+$; //',' ' '
	
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
	DEFINE COMMENT$'//'(~('\n'|'\r'|'\uffff'))*$;
	
//	DEFINE PATH $'"'? ( '/' | ('/'? (~( '/' | '"' | '\u000D' | '\u000A' | '\u0000'))+ )+ )'"'?$;
}

TOKENSTYLES{
	"Manifest-Version:" COLOR #7F0055, BOLD;
	"Bundle-ActivationPolicy:" COLOR #7F0055, BOLD;
	"Bundle-Activator:" COLOR #7F0055, BOLD;
	"Bundle-Category:" COLOR #7F0055, BOLD;
	"Bundle-ClassPath:" COLOR #7F0055, BOLD;
	"Bundle-ContactAddress:" COLOR #7F0055, BOLD;
	"Bundle-Copyright:" COLOR #7F0055, BOLD;
	"Bundle-Description:" COLOR #7F0055, BOLD;
	"Bundle-DocURL:" COLOR #7F0055, BOLD;
	"Bundle-Icon:" COLOR #7F0055, BOLD;
	"Bundle-License:" COLOR #7F0055, BOLD;
	"Bundle-Localization:" COLOR #7F0055, BOLD;
	"Bundle-ManifestVersion:" COLOR #7F0055, BOLD;
	"Bundle-Name:" COLOR #7F0055, BOLD;
	"Bundle-NativeCode:" COLOR #7F0055, BOLD;
	"Bundle-RequiredExecutionEnvironment:" COLOR #7F0055, BOLD;
	"Bundle-SymbolicName:" COLOR #7F0055, BOLD;
	"Bundle-UpdateLocation:" COLOR #7F0055, BOLD;
	"Bundle-Vendor:" COLOR #7F0055, BOLD;
	"Bundle-Version:" COLOR #7F0055, BOLD;
	"Dynamic-ImportPackage:" COLOR #7F0055, BOLD;
	"Export-Package:" COLOR #7F0055, BOLD;
	"Fragment-Host:" COLOR #7F0055, BOLD;
	"Import-Package:" COLOR #7F0055, BOLD;
	"Require-Bundle:" COLOR #7F0055, BOLD;
	"Eclipse-LazyStart:" COLOR #7F0055, BOLD;
	
	
	"ImportBundle" COLOR #7F0055, BOLD;
	"ImportLibrary" COLOR #7F0055, BOLD;
	"IncludeResource" COLOR #7F0055, BOLD;
	"ModuleScope" COLOR #7F0055, BOLD;
	"ModuleType" COLOR #7F0055, BOLD;
	"PrivatePackage" COLOR #7F0055, BOLD;
	"WebContextPath" COLOR #7F0055, BOLD;
	"WebDispatcherServletUrlPatterns" COLOR #7F0055, BOLD;
	"WebFilterMappings" COLOR #7F0055, BOLD;
}

RULES{
	
	// Parameter
	Directive::= token[ALPHANUMEXT] ":=" (argument[LITERAL] | argument[ALPHANUMEXT]); //MFTOKEN
	Attribute::= token[ALPHANUMEXT] "=" (argument[LITERAL] | argument[ALPHANUMEXT]); //MFTOKEN
	
	// Paths
	Path::= id[ALPHANUMEXT]; //PATH
	PathExtended::= path[ALPHANUMEXT]; //PATH "."
	
	// PackageName
	PackageName::= id[ALPHANUMEXT]; //BUNDLE
	
	// Manifest
	Manifest::= ("Manifest-Version:" manifestVersion[ALPHANUMEXT])? (elements !0)* !0;
													// VERSION
	
	// Elements
	BundleActivationPolicy::= "Bundle-ActivationPolicy:" "lazy" (";" directive)*;
	
	BundleActivator::= "Bundle-Activator:" id[ALPHANUMEXT]; //BUNDLE
	
	BundleCategory::= "Bundle-Category:" category[ALPHANUMEXT] ("," category[ALPHANUMEXT])*; //BUNDLE
	
	BundleClassPath::= "Bundle-ClassPath:" entry ("," entry)*;
	Entry::= path (";" path)* (";" parameter)*;
	
	BundleContactAddress::= "Bundle-ContactAddress:" id[ALPHANUMEXT];
	
	BundleCopyright::= "Bundle-Copyright:" id[ALPHANUMEXT];
	
	BundleDescription::= "Bundle-Description:" id[ALPHANUMEXT];
	
	BundleDocURL::= "Bundle-DocURL:" id[ALPHANUMEXT]; //URL
	
	BundleIcon::= "Bundle-Icon:" url[ALPHANUMEXT] (";" "size" "=" size[ALPHANUMEXT])? (";" url[ALPHANUMEXT] (";" "size" "=" size[ALPHANUMEXT])?)*; //URL INTEGER
	
	BundleLicense::= "Bundle-License:" license ("," license)*; // "<<EXTERNAL>>"
	License::= name[ALPHANUMEXT] (";" licenseAttr)* ; //MFTOKEN
	Description::= "description" "=" description[LITERAL];
	Link::= "link" "=" url[ALPHANUMEXT]; //URL
	
	BundleLocalization::= "Bundle-Localization:" id[ALPHANUMEXT]; //PATH
	
	BundleManifestVersion::= "Bundle-ManifestVersion:" id[ALPHANUMEXT]; //INTEGER
	
	BundleName::= "Bundle-Name:" id[ALPHANUMEXT]+;
	
	BundleNativeCode::= "Bundle-NativeCode:" nativeCode ("," nativeCode)* ("," "*")?;
	NativeCode::= path (";" path)* (";" parameter )+;
	
	BundleRequiredExecutionEnvironment::= "Bundle-RequiredExecutionEnvironment:" eeName[ALPHANUMEXT] ("," eeName[ALPHANUMEXT])*; //PATH
	
	BundleSymbolicName::= "Bundle-SymbolicName:" symbolicName[ALPHANUMEXT] (";" parameter )*; //BUNDLE
	
	BundleUpdateLocation::= "Bundle-UpdateLocation:" id[ALPHANUMEXT]; //URL
	
	BundleVendor::= "Bundle-Vendor:" id[ALPHANUMEXT]+; // not correct
	
	//BundleVersion::= "Bundle-Version:" major[INTEGER] ("." minor[INTEGER] ("." micro[INTEGER] ("." qualifier[ALPHANUMEXT])?)?)?;
	BundleVersion::= "Bundle-Version:" qualifier[ALPHANUMEXT];
	
	DynamicImportPackage::= "Dynamic-ImportPackage:" dynamicDescription ("," dynamicDescription)*;
	DynamicDescription::= wildcardName (";" wildcardName)* (";" parameter )*;
	WildcardName::= packageName | packageName ".*" | "*";
	
	ExportPackage::= !0 "Export-Package:" export ("," !0 #1 export)*;
	Export::= packageName (";" packageName)* (";" parameter)*;
	
	FragmentHost::= "Fragment-Host:" symbolicName[ALPHANUMEXT] (";" parameter)*; //BUNDLE
	
	ImportPackage::= "Import-Package:" import ("," import)*;
	Import::= packageName (";" packageName)* (";" parameter)*;
	
	RequireBundle::= !0 "Require-Bundle:" requireBundleDescription ("," !0 #1 requireBundleDescription)*;
	RequireBundleDescription::= symbolicName[ALPHANUMEXT] (";" parameter)*; //BUNDLE
	
	EclipseLazyStart::= "Eclipse-LazyStart:" value[ALPHANUMEXT]; //BOOLEAN
	
	
	// Not in specification, but on homepage: http://www.osgi.org/Specifications/ReferenceHeaders
	ImportBundle::= "ImportBundle"  "{" ( "id"  ":" id[LITERAL]  )* "}"  ;
	
	ImportLibrary::= "ImportLibrary"  "{" ( "id"  ":" id[LITERAL]  )* "}"  ;
	
	IncludeResource::= "IncludeResource"  "{" ( "id"  ":" id[LITERAL]  )* "}"  ;
	
	ModuleScope::= "ModuleScope"  "{" ( "id"  ":" id[LITERAL]  )* "}"  ;
	
	ModuleType::= "ModuleType"  "{" ( "id"  ":" id[LITERAL]  )* "}"  ;
	
	PrivatePackage::= "PrivatePackage"  "{" ( "id"  ":" id[LITERAL]  )* "}"  ;
	
	WebContextPath::= "WebContextPath"  "{" ( "id"  ":" id[LITERAL]  )* "}"  ;
	
	WebDispatcherServletUrlPatterns::= "WebDispatcherServletUrlPatterns"  "{" ( "id"  ":" id[LITERAL]  )* "}"  ;
	
	WebFilterMappings::= "WebFilterMappings"  "{" ( "id"  ":" id[LITERAL]  )* "}"  ;
	
}
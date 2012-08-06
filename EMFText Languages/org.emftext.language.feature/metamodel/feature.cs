//*******************************************************************************
// Copyright (c) 2006-2010 
// Software Technology Group, Dresden University of Technology
// 
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0 
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
// 
// Contributors:
//   Software Technology Group - TU Dresden, Germany 
//      - initial API and implementation
// ******************************************************************************/

SYNTAXDEF feature
FOR <http://www.tudresden.de/feature>
START FeatureModel

OPTIONS {
 	licenceHeader ="../../org.dropsbox/licence.txt";
	tokenspace = "1";
	resourcePluginID = "org.emftext.language.feature.resource.feature";
	basePackage = "org.emftext.language.feature.resource.feature";
	resourceUIPluginID = "org.emftext.language.feature.resource.feature.ui";
	uiBasePackage = "org.emftext.language.feature.resource.feature.ui";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS{
		DEFINE COMMENT$'//'(~('\n'|'\r'))*$;
		DEFINE INTEGER$('-')?('1'..'9')('0'..'9')*|'0'$;
		DEFINE FLOAT$('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}

RULES{
		
		FeatureModel::= "FeatureModel"  name['"','"'] 
						( "{" "constraints"  ( constraints ";")? "}" )? 
						root;
		Constraint::= "Constraint" language[] ":" expression['"','"'];
		Feature::= "Feature" name['"','"'] 
					("(" minCardinality[INTEGER] ".." maxCardinality[INTEGER] ")")?
					("[" attributes* "]")? 
					( groups* )?  ;
		Group::= "Group" ("(" minCardinality[INTEGER] ".." maxCardinality[INTEGER] ")" )?
				   ("{" childFeatures* "}")?;
		Attribute::= type[] name[] #1 "=" value['"','"'] !2;
		
}
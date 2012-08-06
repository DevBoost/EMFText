//*******************************************************************************
// Copyright (c) 2006-2009 
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

SYNTAXDEF ecore_change
FOR <http://www.eclipse.org/emf/2003/Change>
START ChangeDescription

OPTIONS {
 	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	resourcePluginID = "org.emftext.language.ecore.change.resource.ecore_change";
	basePackage = "org.emftext.language.ecore.change.resource.ecore_change";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

RULES {
	ChangeDescription ::= objectChanges*;
	EObjectToChangesMapEntry ::= "change" value* "in" key[];
	FeatureChange ::= "feature" featureName[] "to" value[];
}
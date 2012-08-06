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

SYNTAXDEF mch
FOR <http://www.computing.surrey.ac.uk/metamodels/B>
START Machine

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
	basePackage = "org.emftext.language.b.resource.mch";
	resourcePluginID = "org.emftext.language.b.resource.mch";
	uiBasePackage = "org.emftext.language.b.resource.mch.ui";
	resourceUIPluginID = "org.emftext.language.b.resource.mch.ui";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
}

RULES {
	
	Machine ::= 
		"MACHINE" name[]
		("SET" sets (";" sets)*)?
		("VARIABLES" variables ("," variables)*)?
		("INVARIANT" invariants ("/\\\\" invariants)*)?
		("INITIALISATION" initialisations ("||" initialisations)*)?
		("OPERATIONS" operations (";" operations)*)?
		"END"
		;
	
	SET ::= name[];

	Variable ::= name[]; // | "preceeds"  ":" preceeds[]| "type"  ":" type[] )* "}"  ;

	// TODO this will not work, since expressions do not confirm to the default
	// token (TEXT)	
	Expression ::= expression[];
	Action     ::= expression[];
	Predicate  ::= expression[];
	Any        ::= expression[];
	If         ::= expression[];
	Begin      ::= expression[];
	
	Operation ::= outputs "<--" name[] ("(" inputs ")")? "=="
		("PRE" preconditions ("/\\\\")* "THEN")?
		statements ("||" statements)*
		"END";
	
	Skip ::= "SKIP";
	
	// TODO the EGL script does only write variables that are defined?!
	VariableList ::= variables ("," variables)*;
}
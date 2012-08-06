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

SYNTAXDEF tvl
FOR <http://www.emftext.org/language/threevaluedlogic>
START Formula

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	backtracking = "true";
	memoize = "true";
	reloadGeneratorModel = "true";
	tokenspace = "1";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENSTYLES {
	"OR" COLOR #00a5f2, BOLD;
	"AND" COLOR #00a5f2, BOLD;
	"NOT" COLOR #00a5f2, BOLD;
	"(" COLOR #00a5f2, BOLD;
	")" COLOR #00a5f2, BOLD;
}

RULES {
	@Operator(type="binary_left_associative",weight="1", superclass="Formula")
	Or       ::= children "OR" children;
	
	@Operator(type="binary_left_associative",weight="2", superclass="Formula")
	And      ::= children "AND" children;
	
	@Operator(type="unary_prefix", weight="3", superclass="Formula")
	Negation ::= "NOT" body;
	
	@Operator(type="primitive", weight="4", superclass="Formula")
	Nested   ::= "(" body ")";

	@Operator(type="primitive", weight="4", superclass="Formula")
	Constant ::= value[];
}
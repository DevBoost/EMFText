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

SYNTAXDEF pico
FOR <http://www.emftext.org/language/pico>
START Program

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	usePredefinedTokens = "false";
	overrideLaunchConfigurationDelegate = "false";
	additionalExports = "org.emftext.language.pico.resource.pico.interpreter";
}

TOKENS {
	DEFINE PICOID $('a'..'z')('a'..'z'|'0'..'9')*$;
	DEFINE INTEGER $('0'..'9')+$;

	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
}

RULES {

	Program ::= "begin" declarations statements (";" statements)* "end" ;
	
	Declarations ::= "declare" idTypes ("," idTypes)* ";" ;
	
	IDType ::= picoID[PICOID] ":" type[natural : "natural", string : "string", nil : "nil"] ;
	
	
	Assignment::= left[PICOID] ":=" right;
	
	IfStatement::= "if" condition "then" then* "else" else* "fi";
	
	WhileStatement::= "while" condition "do" body* "od";
	
	@Operator(type="primitive", weight="5", superclass="Expression")
	VariableReference ::= variable[PICOID];
	
	@Operator(type="primitive", weight="5", superclass="Expression")
	Natural ::= value[INTEGER];
	
	@Operator(type="primitive", weight="5", superclass="Expression")
	String ::= value['"','"'];
	
	@Operator(type="primitive", weight="5", superclass="Expression")
	NilLiteral ::= "nil";

	@Operator(type="binary_left_associative", weight="2", superclass="Expression")
	AdditiveExpression ::= left plus["+" : "-"] right;

	@Operator(type="binary_left_associative", weight="3", superclass="Expression")
	MultiplicativeExpression ::= left times["*" : "/"] right;

	@Operator(type="binary_left_associative", weight="4", superclass="Expression")
	ComparatorExpression ::= left comparator[lowerThan : "<", greaterThan : ">", equals : "="] right;
	// TODO add other expressions
}
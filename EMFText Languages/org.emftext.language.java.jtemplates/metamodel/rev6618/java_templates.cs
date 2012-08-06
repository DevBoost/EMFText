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

SYNTAXDEF java_template
FOR <http://www.emftext.org/language/java_templates>
START JavaTemplate

IMPORTS {
	java : <http://www.emftext.org/java> <../../org.emftext.language.java/metamodel/java.genmodel> 
		WITH SYNTAX java <../../org.emftext.language.java/metamodel/java.cs>
}

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	usePredefinedTokens = "false";
}

TOKENSTYLES {
	"<%TEMPLATE" COLOR #C00000, BOLD; 
	"INPUT=" COLOR #C00000, BOLD;
	"<%IF" COLOR #C00000, BOLD;
	"<%FOR" COLOR #C00000, BOLD;
	"<%=" COLOR #C00000, BOLD;
	"%>" COLOR #C00000, BOLD;
	"<%ENDFOR%>" COLOR #C00000, BOLD;
	"<%ENDIF%>" COLOR #C00000, BOLD;
	"SL_COMMENT" COLOR #00A000, ITALIC;
}

RULES {
	JavaTemplate ::= "<%TEMPLATE" "INPUT=" inputMetaClass[STRING_LITERAL] "%>" body;
	
	PhNamedElementName ::= "<%=" expression[STRING_LITERAL] "%>";
	
	IfElseAssignmentExpression ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ELSE%>" elseBody "<%ENDIF%>";
	IfElseUnaryExpression ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ELSE%>" elseBody "<%ENDIF%>";
	IfForLoop ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	IfElseStatementContainer ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ELSE%>" elseBody "<%ENDIF%>";
	IfParametrizable ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForParametrizable ::= "<%FOR" expression[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfMemberContainer ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForMemberContainer ::= "<%FOR" expression[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfElseUnaryModificationExpression ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ELSE%>" elseBody "<%ENDIF%>";
	IfExplicitConstructorCall ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	IfConditionalExpression ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	IfElseInstanceOfExpression ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ELSE%>" elseBody "<%ENDIF%>";
	IfStatementListContainer ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForStatementListContainer ::= "<%FOR" expression[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfCondition ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	IfElseTypeReference ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ELSE%>" elseBody "<%ENDIF%>";
	IfElsePrimitiveTypeReference ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ELSE%>" elseBody "<%ENDIF%>";
	IfElseAnnotationInstance ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ELSE%>" elseBody "<%ENDIF%>";
	IfReference ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	IfTypeArgumentable ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForTypeArgumentable ::= "<%FOR" expression[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfModifiable ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForModifiable ::= "<%FOR" expression[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfElseSingleAnnotationParameter ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ELSE%>" elseBody "<%ENDIF%>";
	IfImportingElement ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForImportingElement ::= "<%FOR" expression[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfElseMember ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ELSE%>" elseBody "<%ENDIF%>";
	IfElseNamedElement ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ELSE%>" elseBody "<%ENDIF%>";
	IfAnnotableAndModifiable ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForAnnotableAndModifiable ::= "<%FOR" expression[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfAnnotationInstance ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	IfArrayInitializer ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForArrayInitializer ::= "<%FOR" expression[STRING_LITERAL] "%>" body "<%ENDFOR%>";
	IfSwitch ::= "<%IF" expression[STRING_LITERAL] "%>" body "<%ENDIF%>";
	ForSwitch ::= "<%FOR" expression[STRING_LITERAL] "%>" body "<%ENDFOR%>";
}

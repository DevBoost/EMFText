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

SYNTAXDEF customsandwich
FOR <http://www.emftext.org/language/customsandwich>
START RecipeTemplate

IMPORTS {
	sandwich : <http://www.emftext.org/language/sandwich> WITH SYNTAX sandwich <../../org.emftext.language.sandwich/metamodel/sandwich.cs>
}

OPTIONS {
 	licenceHeader ="../../org.dropsbox/licence.txt";
	usePredefinedTokens = "false";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	tokenspace = "1";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENSTYLES {
	"<%TEMPLATE INPUT=" COLOR #C00000, BOLD;
	"<%IF" COLOR #C00000, BOLD;
	"<%FOR" COLOR #C00000, BOLD;
	"<%=" COLOR #C00000, BOLD;
	"%>" COLOR #C00000, BOLD;
	"<%ELSE%>" COLOR #C00000, BOLD;
	"<%ENDFOR%>" COLOR #C00000, BOLD;
	"<%ENDIF%>" COLOR #C00000, BOLD;
	"QUOTED_34_34" COLOR #C08000, BOLD;
}

RULES {
	RecipeTemplate ::= "<%TEMPLATE INPUT=" inputMetaClass['"','"'] "%>" body;
	IfFeatureRecipeIngredients ::= "<%IF" expression['"','"'] "%>" body "<%ENDIF%>";
	ForFeatureRecipeIngredients ::= "<%FOR" (variable[] ":")? expression['"','"'] "%>" body "<%ENDFOR%>";
	IfFeatureRecipeInstructions ::= "<%IF" expression['"','"'] "%>" body "<%ENDIF%>";
	ForFeatureRecipeInstructions ::= "<%FOR" (variable[] ":")? expression['"','"'] "%>" body "<%ENDFOR%>";
	IfElseFeatureInstructionUsing ::= "<%IF" expression['"','"'] "%>" thenBody "<%ELSE%>" elseBody "<%ENDIF%>";
	PhFeatureIngredientName ::= "<%=" expression['"','"'] "%>";
}
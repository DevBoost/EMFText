SYNTAXDEF tcl
FOR <http://www.emftext.org/language/tcltk>
START TclScript

IMPORTS {
	tcl : <http://www.emftext.org/language/tcltk/tcl>
	otcl : <http://www.emftext.org/language/tcltk/otcl>
	reuse : <http://www.emftext.org/language/tcltk/reuse>
}

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	usePredefinedTokens = "false";
	//reloadGeneratorModel = "true";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS{
	DEFINE T_NONEWLINE $'-''nonewline'$;
	DEFINE COMMENT $'#'(~('\r\n'|'\r'|'\n'))*$;
	DEFINE VAR     $'\u0024' (~('\r\n'|'\r'|'\n'|' '|'\t'|'\f'|'\u0024'|'#'|'['|']'|'{'|'}'|'"'|';'))+$;
	DEFINE WS      $(' '|'\t'|'\f')+$;
	DEFINE TEXT    $(~('\r\n'|'\r'|'\n'|' '|'\t'|'\f'|'\u0024'|'#'|'['|']'|'{'|'}'|'"'|';')) (~('\r\n'|'\r'|'\n'|' '|'\t'|'\f'|'#'|'['|']'|'{'|'}'|'"'|';'))*$;
	//$ = \u0024
}

TOKENSTYLES {
	"COMMENT" COLOR #000080, ITALIC;

}

RULES{
	TclScript::= ("\r\n" | ";" |"\n" | "\r")* (commands ("\r\n" | ";" |"\n" | "\r")+)*;
	
	//TCL Commands
	tcl.Comment::= value[COMMENT];
	
	tcl.Procedure::= "proc" name arguments body;
	
	tcl.Set::= "set" variable value?;

	tcl.Expr::= "expr"  arguments+;
	
	tcl.If::= "if" ifExpression (("then")? ifBody) ("elseif" elseIfExpressions elseIfBodies)* ("else" elseBody)?;
	
	tcl.For::= "for" start test next body;
	
	tcl.Puts::= "puts" (nonewline[T_NONEWLINE])? string channelId? ; //TODO string and chanelId should be changed in order, but the parser won't do
	
	//OTCL Commands
	otcl.Class::= "Class" name ("-superclass" superclass)?;
	
	otcl.InstanceProcedure::= class "instproc" name arguments body;
	
	otcl.New::= "new" class;
	
	otcl.ObjectSet ::= object "set" variable value?;
	
	otcl.ObjectProcedure::= object "proc" name arguments body;
	
	//OTCL Values
	otcl.Self::= "$self";

	//TCL Values - this needs to stay at the end
	tcl.ProcedureCall::= procedure arguments*;
	
	tcl.Compound ::= "\"" ("\r\n" | ";" |"\n" | "\r")* commands? (("\r\n" | ";" |"\n" | "\r")+ commands)* ("\r\n" | ";" |"\n" | "\r")* "\"";
	
	tcl.Block::=    "{"  ("\r\n" | ";" |"\n" | "\r")* commands? (("\r\n" | ";" |"\n" | "\r")+ commands)* ("\r\n" | ";" |"\n" | "\r")* "}";
	
	tcl.Word::= value[];
	
	tcl.VariableSubstitution::= setting[VAR];
	
	tcl.CommandSubstitution::= "[" command "]";
	
	//TODO complete list of build-in commands: http://www.tcl.tk/man/tcl8.4/TclCmd/contents.htm
}
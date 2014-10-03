SYNTAXDEF cct5
FOR <http://www.emftext.org/language/cct5>
START Farm


OPTIONS {
	reloadGeneratorModel = "true";
}


RULES {
	
	Farm ::= "Farm" "{"
		(Farmer)+
		(Animal)*
	"}";
	
	Farmer ::= "BEGIN_FARMER" Name[TEXT]
		"Diet" ":" Diet
	"END_FARMER";
	
	Animal ::= "BEGIN_ANIMAL" Name[TEXT]
		"FeedingInstruction" ":" FeedingInstruction
	"END_ANIMAL";
	
	Diet ::= Type[TEXT] ("favored" FavoriteDish['"', '"'])?;  
}
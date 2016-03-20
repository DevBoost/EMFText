SYNTAXDEF cct5
FOR <http://www.emftext.org/language/cct5>
START Hospital, Farm

OPTIONS {
	licenceHeader = "../../org.dropsbox/licence.txt";
}

RULES {
	
	Farm ::= "BEGIN_FARM"
		(Farmer)+
		(Animal)*
		(InventoryItem)?
	"END_FARM";
	
	Hospital ::= "BEGIN_HOSPITAL"
		(Animal)*
		(InventoryItem)?
	"END_HOSPITAL";
	
	Farmer ::= "BEGIN_FARMER" Name[TEXT]
		"Diet" ":" Diet
	"END_FARMER";
	
	Animal ::= "BEGIN_ANIMAL" Name[TEXT]
		"FeedingInstruction" ":" FeedingInstruction
	"END_ANIMAL";
	
	Diet ::= Type[TEXT] ("favored" FavoriteDish['"', '"'])?;
	
	InventoryItem ::= "BEGIN_INVENTORY" Name[TEXT] "END_INVENTORY";
}

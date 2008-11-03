package org.antlr.stringtemplate;

/** When group files derive from another group, we have to know how to
 *  load that group and its supergroups.  This interface also knows how
 *  to load interfaces.
 */
public interface StringTemplateGroupLoader {
	/** Load the group called groupName from somewhere.  Return null
	 *  if no group is found.
	 */
	public StringTemplateGroup loadGroup(String groupName);

	/** Load a group with a specified superGroup.  Groups with
	 *  region definitions must know their supergroup to find templates
	 *  during parsing.
	 */
	public StringTemplateGroup loadGroup(String groupName,
										 StringTemplateGroup superGroup);


	/** Specify the template lexer to use for parsing templates.  If null,
	 *  it assumes angle brackets <...>.
	 */
	public StringTemplateGroup loadGroup(String groupName,
										 Class templateLexer,
										 StringTemplateGroup superGroup);

	/** Load the interface called interfaceName from somewhere.  Return null
	 *  if no interface is found.
	 */
	public StringTemplateGroupInterface loadInterface(String interfaceName);
}

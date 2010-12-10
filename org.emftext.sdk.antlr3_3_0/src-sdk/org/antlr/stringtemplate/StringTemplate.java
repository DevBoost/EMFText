/*
 [The "BSD licence"]
 Copyright (c) 2003-2005 Terence Parr
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.antlr.stringtemplate;

import java.io.*;
import java.util.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.antlr.stringtemplate.language.*;
import antlr.*;
import antlr.collections.AST;
import antlr.collections.ASTEnumeration;

/** A <TT>StringTemplate</TT> is a "document" with holes in it where you can stick
 *  values.  <TT>StringTemplate</TT> breaks up your template into chunks of text and
 *  attribute expressions.  <TT>StringTemplate</TT> ignores everything outside
 *  of attribute expressions, treating it as just text to spit
 *  out when you call <TT>StringTemplate.toString()</TT>.
 *
 */
public class StringTemplate {
	public static final String VERSION = "3.2.1"; // September 22, 2009

	/** <@r()> */
	public static final int REGION_IMPLICIT = 1;
	/** <@r>...<@end> */
	public static final int REGION_EMBEDDED = 2;
	/** @t.r() ::= "..." defined manually by coder */
	public static final int REGION_EXPLICIT = 3;

	/** An automatically created aggregate of properties.
	 *
	 *  I often have lists of things that need to be formatted, but the list
	 *  items are actually pieces of data that are not already in an object.  I
	 *  need ST to do something like:
	 *
	 *  Ter=3432
	 *  Tom=32234
	 *  ....
	 *
	 *  using template:
	 *
	 *  $items:{it.name$=$it.type$}$
	 *
	 *  This example will call getName() on the objects in items attribute, but
	 *  what if they aren't objects?  I have perhaps two parallel arrays
	 *  instead of a single array of objects containing two fields.  One
	 *  solution is allow Maps to be handled like properties so that it.name
	 *  would fail getName() but then see that it's a Map and do
	 *  it.get("name") instead.
	 *
	 *  This very clean approach is espoused by some, but the problem is that
	 *  it's a hole in my separation rules.  People can put the logic in the
	 *  view because you could say: "go get bob's data" in the view:
	 *
	 *  Bob's Phone: $db.bob.phone$
	 *
	 *  A view should not be part of the program and hence should never be able
	 *  to go ask for a specific person's data.
	 *
	 *  After much thought, I finally decided on a simple solution.  I've
	 *  added setAttribute variants that pass in multiple property values,
	 *  with the property names specified as part of the name using a special
	 *  attribute name syntax: "name.{propName1,propName2,...}".  This
	 *  object is a special kind of HashMap that hopefully prevents people
	 *  from passing a subclass or other variant that they have created as
	 *  it would be a loophole.  Anyway, the ASTExpr.getObjectProperty()
	 *  method looks for Aggregate as a special case and does a get() instead
	 *  of getPropertyName.
	 */
	public static final class Aggregate {
		protected HashMap properties = new HashMap();
		/** Allow StringTemplate to add values, but prevent the end
		 *  user from doing so.
		 */
		protected void put(String propName, Object propValue) {
			properties.put(propName, propValue);
		}
		public Object get(String propName) {
			return properties.get(propName);
		}
		public String toString() {
			return properties.toString();
		}
	}

	/** Just an alias for ArrayList, but this way I can track whether a
	 *  list is something ST created or it's an incoming list.
	 */
	public static final class STAttributeList extends ArrayList {
		public STAttributeList(int size) { super(size); }
		public STAttributeList() { super(); }
	}

	public static final String ANONYMOUS_ST_NAME = "anonymous";

	/** track probable issues like setting attribute that is not referenced. */
	static boolean lintMode = false;

	protected List referencedAttributes = null;

	/** What's the name of this template? */
	protected String name = ANONYMOUS_ST_NAME;

	private static int templateCounter=0;
	private static synchronized int getNextTemplateCounter() {
		templateCounter++;
		return templateCounter;
	}
	/** reset the template ID counter to 0; public so that testing routine
	 *  can access but not really of interest to the user.
	 */
	public static void resetTemplateCounter() {
		templateCounter = 0;
	}

	protected int templateID = getNextTemplateCounter();

	/** Enclosing instance if I'm embedded within another template.
	 *  IF-subtemplates are considered embedded as well.
	 */
	protected StringTemplate enclosingInstance = null;

	/** If this template is an embedded template such as when you apply
	 *  a template to an attribute, then the arguments passed to this
	 *  template represent the argument context--a set of values
	 *  computed by walking the argument assignment list.  For example,
	 *  <name:bold(item=name, foo="x")> would result in an
	 *  argument context of {[item=name], [foo="x"]} for this
	 *  template.  This template would be the bold() template and
	 *  the enclosingInstance would point at the template that held
	 *  that <name:bold(...)> template call.  When you want to get
	 *  an attribute value, you first check the attributes for the
	 *  'self' template then the arg context then the enclosingInstance
	 *  like resolving variables in pascal-like language with nested
	 *  procedures.
	 *
	 *  With multi-valued attributes such as <faqList:briefFAQDisplay()>
	 *  attribute "i" is set to 1..n.
	 */
	protected Map argumentContext = null;

	/** If this template is embedded in another template, the arguments
	 *  must be evaluated just before each application when applying
	 *  template to a list of values.  The "it" attribute must change
	 *  with each application so that $names:bold(item=it)$ works.  If
	 *  you evaluate once before starting the application loop then it
	 *  has a single fixed value.  Eval.g saves the AST rather than evaluating
	 *  before invoking applyListOfAlternatingTemplates().  Each iteration
	 *  of a template application to a multi-valued attribute, these args
	 *  are re-evaluated with an initial context of {[it=...], [i=...]}.
	 */
	protected StringTemplateAST argumentsAST = null;

	/** When templates are defined in a group file format, the attribute
	 *  list is provided including information about attribute cardinality
	 *  such as present, optional, ...  When this information is available,
	 *  rawSetAttribute should do a quick existence check as should the
	 *  invocation of other templates.  So if you ref bold(item="foo") but
	 *  item is not defined in bold(), then an exception should be thrown.
	 *  When actually rendering the template, the cardinality is checked.
	 *  This is a Map<String,FormalArgument>.
	 */
	protected LinkedHashMap formalArguments = FormalArgument.UNKNOWN;

	/** How many formal arguments to this template have default values
	 *  specified?
	 */
	protected int numberOfDefaultArgumentValues = 0;

	/** Normally, formal parameters hide any attributes inherited from the
	 *  enclosing template with the same name.  This is normally what you
	 *  want, but makes it hard to invoke another template passing in all
	 *  the data.  Use notation now: <otherTemplate(...)> to say "pass in
	 *  all data".  Works great.  Can also say <otherTemplate(foo="xxx",...)>
	 */
	protected boolean passThroughAttributes = false;

	/** What group originally defined the prototype for this template?
	 *  This affects the set of templates I can refer to.  super.t() must
	 *  always refer to the super of the original group.
	 *
	 *  group base;
	 *  t ::= "base";
	 *
	 *  group sub;
	 *  t ::= "super.t()2"
	 *
	 *  group subsub;
	 *  t ::= "super.t()3"
	 */
	protected StringTemplateGroup nativeGroup;

	/** This template was created as part of what group?  Even if this
	 *  template was created from a prototype in a supergroup, its group
	 *  will be the subgroup.  That's the way polymorphism works.
	 */
	protected StringTemplateGroup group;


	/** If this template is defined within a group file, what line number? */
	protected int groupFileLine;

	/** Where to report errors */
	StringTemplateErrorListener listener = null;

	/** The original, immutable pattern/language (not really used again after
	 *  initial "compilation", setup/parsing).
	 */
	protected String pattern;

	/** Map an attribute name to its value(s).  These values are set by outside
	 *  code via st.setAttribute(name, value).  StringTemplate is like self in
	 *  that a template is both the "class def" and "instance".  When you
	 *  create a StringTemplate or setTemplate, the text is broken up into chunks
	 *  (i.e., compiled down into a series of chunks that can be evaluated later).
	 *  You can have multiple
	 */
	protected Map attributes;

	/** A Map<Class,Object> that allows people to register a renderer for
	 *  a particular kind of object to be displayed in this template.  This
	 *  overrides any renderer set for this template's group.
	 *
	 *  Most of the time this map is not used because the StringTemplateGroup
	 *  has the general renderer map for all templates in that group.
	 *  Sometimes though you want to override the group's renderers.
	  */
	protected Map attributeRenderers;

	/** A list of alternating string and ASTExpr references.
	 *  This is compiled to when the template is loaded/defined and walked to
	 *  write out a template instance.
	 */
	protected List chunks;

	/** If someone refs <@r()> in template t, an implicit
	 *
	 *   @t.r() ::= ""
	 *
	 *  is defined, but you can overwrite this def by defining your
	 *  own.  We need to prevent more than one manual def though.  Between
	 *  this var and isEmbeddedRegion we can determine these cases.
	 */
	protected int regionDefType;

	/** Does this template come from a <@region>...<@end> embedded in
	 *  another template?
	 */
	protected boolean isRegion;

	/** Set of implicit and embedded regions for this template */
	protected Set regions;

	public static StringTemplateGroup defaultGroup =
		new StringTemplateGroup("defaultGroup", ".");

	/** Create a blank template with no pattern and no attributes */
	public StringTemplate() {
		group = defaultGroup; // make sure has a group even if default
	}

	/** Create an anonymous template.  It has no name just
	 *  chunks (which point to this anonymous template) and attributes.
	 */
	public StringTemplate(String template) {
		this(null, template);
	}

	public StringTemplate(String template, Class lexer) {
		this();
		setGroup(new StringTemplateGroup("defaultGroup", lexer));
		setTemplate(template);
	}

	/** Create an anonymous template with no name, but with a group */
	public StringTemplate(StringTemplateGroup group, String template) {
		this();
		if ( group!=null ) {
			setGroup(group);
		}
		setTemplate(template);
	}

	public StringTemplate(StringTemplateGroup group,
						  String template,
						  HashMap attributes)
	{
		this(group,template);
		this.attributes = attributes;
	}

	/** Make the 'to' template look exactly like the 'from' template
	 *  except for the attributes.  This is like creating an instance
	 *  of a class in that the executable code is the same (the template
	 *  chunks), but the instance data is blank (the attributes).  Do
	 *  not copy the enclosingInstance pointer since you will want this
	 *  template to eval in a context different from the examplar.
	 */
	protected void dup(StringTemplate from, StringTemplate to) {
		to.attributeRenderers = from.attributeRenderers;
		to.pattern = from.pattern;
		to.chunks = from.chunks;
		to.formalArguments = from.formalArguments;
		to.numberOfDefaultArgumentValues = from.numberOfDefaultArgumentValues;
		to.name = from.name;
		to.group = from.group;
		to.nativeGroup = from.nativeGroup;
		to.listener = from.listener;
		to.regions = from.regions;
		to.isRegion = from.isRegion;
		to.regionDefType = from.regionDefType;
	}

	/** Make an instance of this template; it contains an exact copy of
	 *  everything (except the attributes and enclosing instance pointer).
	 *  So the new template refers to the previously compiled chunks of this
	 *  template but does not have any attribute values.
	 */
	public StringTemplate getInstanceOf() {
		StringTemplate t = null;
		if ( nativeGroup!=null ) {
			// create a template using the native group for this template
			// but it's "group" is set to this.group by dup after creation so
			// polymorphism still works.
			t = nativeGroup.createStringTemplate();
		}
		else {
			t = group.createStringTemplate();
		}
		dup(this, t);
		return t;
	}

	public StringTemplate getEnclosingInstance() {
		return enclosingInstance;
	}

	public StringTemplate getOutermostEnclosingInstance() {
		if ( enclosingInstance!=null ) {
			return enclosingInstance.getOutermostEnclosingInstance();
		}
		return this;
	}

	public void setEnclosingInstance(StringTemplate enclosingInstance) {
		if ( this==enclosingInstance ) {
			throw new IllegalArgumentException("cannot embed template "+getName()+" in itself");
		}
		// set the parent for this template
		this.enclosingInstance = enclosingInstance;
	}

	public Map getArgumentContext() {
		return argumentContext;
	}

	public void setArgumentContext(Map ac) {
		argumentContext = ac;
	}

	public StringTemplateAST getArgumentsAST() {
		return argumentsAST;
	}

	public void setArgumentsAST(StringTemplateAST argumentsAST) {
		this.argumentsAST = argumentsAST;
	}

	public String getName() {
		return name;
	}

	public String getOutermostName() {
		if ( enclosingInstance!=null ) {
			return enclosingInstance.getOutermostName();
		}
		return getName();
	}

	public void setName(String name) {
		this.name = name;
	}

	public StringTemplateGroup getGroup() {
		return group;
	}

	public void setGroup(StringTemplateGroup group) {
		this.group = group;
	}

	public StringTemplateGroup getNativeGroup() {
		return nativeGroup;
	}

	public void setNativeGroup(StringTemplateGroup nativeGroup) {
		this.nativeGroup = nativeGroup;
	}

	/** Return the outermost template's group file line number */
	public int getGroupFileLine() {
		if ( enclosingInstance!=null ) {
			return enclosingInstance.getGroupFileLine();
		}
		return groupFileLine;
	}

	public void setGroupFileLine(int groupFileLine) {
		this.groupFileLine = groupFileLine;
	}

	public void setTemplate(String template) {
		this.pattern = template;
		breakTemplateIntoChunks();
	}

	public String getTemplate() {
		return pattern;
	}

	public void setErrorListener(StringTemplateErrorListener listener) {
		this.listener = listener;
	}

	public StringTemplateErrorListener getErrorListener() {
		if ( listener==null ) {
			return group.getErrorListener();
		}
		return listener;
	}

	public void reset() {
		attributes = new HashMap(); // just throw out table and make new one
	}

	public void setPredefinedAttributes() {
		if ( !inLintMode() ) {
			return; // only do this method so far in lint mode
		}
	}

	public void removeAttribute(String name) {
		if ( attributes!=null ) attributes.remove(name);
	}

	/** Set an attribute for this template.  If you set the same
	 *  attribute more than once, you get a multi-valued attribute.
	 *  If you send in a StringTemplate object as a value, it's
	 *  enclosing instance (where it will inherit values from) is
	 *  set to 'this'.  This would be the normal case, though you
	 *  can set it back to null after this call if you want.
	 *  If you send in a List plus other values to the same
	 *  attribute, they all get flattened into one List of values.
	 *  This will be a new list object so that incoming objects are
	 *  not altered.
	 *  If you send in an array, it is converted to an ArrayIterator.
	 */
	public void setAttribute(String name, Object value) {
		if ( value==null || name==null ) {
			return;
		}
		if ( name.indexOf('.')>=0 ) {
			throw new IllegalArgumentException("cannot have '.' in attribute names");
		}
		if ( attributes==null ) {
			attributes = new HashMap();
		}

		if ( value instanceof StringTemplate ) {
			((StringTemplate)value).setEnclosingInstance(this);
		}
		else {
			// convert value if array
			value = ASTExpr.convertArrayToList(value);
		}

		// convert plain collections
		// get exactly in this scope (no enclosing)
		Object o = this.attributes.get(name);
		if ( o==null ) { // new attribute
			rawSetAttribute(this.attributes, name, value);
			return;
		}
		// it will be a multi-value attribute
		//System.out.println("exists: "+name+"="+o);
		STAttributeList v = null;
		if ( o.getClass() == STAttributeList.class ) { // already a list made by ST
			v = (STAttributeList)o;
		}
		else if ( o instanceof List ) { // existing attribute is non-ST List
			// must copy to an ST-managed list before adding new attribute
			List listAttr = (List)o;
			v = new STAttributeList(listAttr.size());
			v.addAll(listAttr);
			rawSetAttribute(this.attributes, name, v); // replace attribute w/list
		}
		else {
			// non-list second attribute, must convert existing to ArrayList
			v = new STAttributeList(); // make list to hold multiple values
			// make it point to list now
			rawSetAttribute(this.attributes, name, v); // replace attribute w/list
			v.add(o);  // add previous single-valued attribute
		}
		if ( value instanceof List ) {
			// flatten incoming list into existing
			if ( v!=value ) { // avoid weird cyclic add
				v.addAll((List)value);
			}
		}
		else {
			v.add(value);
		}
	}

	/** Convenience method to box ints */
	public void setAttribute(String name, int value) {
		setAttribute(name, new Integer(value));
	}

	/** Set an aggregate attribute with two values.  The attribute name
	 *  must have the format: "name.{propName1,propName2}".
	 */
	public void setAttribute(String aggrSpec, Object v1, Object v2) {
		setAttribute(aggrSpec, new Object[] {v1,v2});
	}

	public void setAttribute(String aggrSpec, Object v1, Object v2, Object v3) {
		setAttribute(aggrSpec, new Object[] {v1,v2,v3});
	}

	public void setAttribute(String aggrSpec, Object v1, Object v2, Object v3, Object v4) {
		setAttribute(aggrSpec, new Object[] {v1,v2,v3,v4});
	}

	public void setAttribute(String aggrSpec, Object v1, Object v2, Object v3, Object v4, Object v5) {
		setAttribute(aggrSpec, new Object[] {v1,v2,v3,v4,v5});
	}

	/** Create an aggregate from the list of properties in aggrSpec and fill
	 *  with values from values array.  This is not publically visible because
	 *  it conflicts semantically with setAttribute("foo",new Object[] {...});
	 */
	protected void setAttribute(String aggrSpec, Object[] values) {
		List properties = new ArrayList();
		String aggrName = parseAggregateAttributeSpec(aggrSpec, properties);
		if ( values==null || properties.size()==0 ) {
			throw new IllegalArgumentException("missing properties or values for '"+aggrSpec+"'");
		}
		if ( values.length != properties.size() ) {
			throw new IllegalArgumentException("number of properties in '"+aggrSpec+"' != number of values");
		}
		Aggregate aggr = new Aggregate();
		for (int i = 0; i < values.length; i++) {
			Object value = values[i];
			if ( value instanceof StringTemplate ) {
				((StringTemplate)value).setEnclosingInstance(this);
			}
			else {
				value = ASTExpr.convertArrayToList(value);
			}
			aggr.put((String)properties.get(i), value);
		}
		setAttribute(aggrName, aggr);
	}

	/** Split "aggrName.{propName1,propName2}" into list [propName1,propName2]
	 *  and the aggrName. Space is allowed around ','.
	 */
	protected String parseAggregateAttributeSpec(String aggrSpec, List properties) {
		int dot = aggrSpec.indexOf('.');
		if ( dot<=0 ) {
			throw new IllegalArgumentException("invalid aggregate attribute format: "+
					aggrSpec);
		}
		String aggrName = aggrSpec.substring(0, dot);
		String propString = aggrSpec.substring(dot+1, aggrSpec.length());
		boolean error = true;
		StringTokenizer tokenizer = new StringTokenizer(propString, "{,}", true);
		match:
		if ( tokenizer.hasMoreTokens() ) {
			String token = tokenizer.nextToken(); // advance to {
			token = token.trim();
			if ( token.equals("{") ) {
				token = tokenizer.nextToken();    // advance to first prop name
				token = token.trim();
				properties.add(token);
				token = tokenizer.nextToken();    // advance to a comma
				token = token.trim();
				while ( token.equals(",") ) {
					token = tokenizer.nextToken();    // advance to a prop name
					token = token.trim();
					properties.add(token);
					token = tokenizer.nextToken();    // advance to a "," or "}"
					token = token.trim();
				}
				if ( token.equals("}") ) {
					error = false;
				}
			}
		}
		if ( error ) {
			throw new IllegalArgumentException("invalid aggregate attribute format: "+
					aggrSpec);
		}
		return aggrName;
	}

	/** Map a value to a named attribute.  Throw NoSuchElementException if
	 *  the named attribute is not formally defined in self's specific template
	 *  and a formal argument list exists.
	 */
	protected void rawSetAttribute(Map attributes,
								   String name,
								   Object value)
	{
		if ( formalArguments!=FormalArgument.UNKNOWN &&
			getFormalArgument(name)==null )
		{
			// a normal call to setAttribute with unknown attribute
			throw new NoSuchElementException("no such attribute: "+name+
											 " in template context "+
											 getEnclosingInstanceStackString());
		}
		if ( value == null ) {
			return;
		}
		attributes.put(name, value);
	}

	/** Argument evaluation such as foo(x=y), x must
	 *  be checked against foo's argument list not this's (which is
	  *  the enclosing context).  So far, only eval.g uses arg self as
	 *  something other than "this".
	 */
	public void rawSetArgumentAttribute(StringTemplate embedded,
										Map attributes,
										String name,
										Object value)
	{
		if ( embedded.formalArguments!=FormalArgument.UNKNOWN &&
			 embedded.getFormalArgument(name)==null )
		{
			throw new NoSuchElementException("template "+embedded.getName()+
											 " has no such attribute: "+name+
											 " in template context "+
											 getEnclosingInstanceStackString());
		}
		if ( value == null ) {
			return;
		}
		attributes.put(name, value);
	}

	public Object getAttribute(String name) {
		Object v = get(this,name);
        if ( v==null ) {
            checkNullAttributeAgainstFormalArguments(this, name);
        }
        return v;
	}

	/** Walk the chunks, asking them to write themselves out according
	 *  to attribute values of 'this.attributes'.  This is like evaluating or
	 *  interpreting the StringTemplate as a program using the
	 *  attributes.  The chunks will be identical (point at same list)
	 *  for all instances of this template.
	 */
	public int write(StringTemplateWriter out) throws IOException {
		if ( group.debugTemplateOutput ) {
			group.emitTemplateStartDebugString(this,out);
		}
		int n = 0;
        boolean missing = true;
		setPredefinedAttributes();
		setDefaultArgumentValues();
		for (int i=0; chunks!=null && i<chunks.size(); i++) {
			Expr a = (Expr)chunks.get(i);
			int chunkN = a.write(this, out);
			// expr-on-first-line-with-no-output NEWLINE => NEWLINE
			if ( chunkN<=0 && i==0 && (i+1)<chunks.size() &&
				 chunks.get(i+1) instanceof NewlineRef )
			{
				//System.out.println("found pure first-line-blank \\n pattern");
				i++; // skip next NEWLINE;
				continue;
			}
			// NEWLINE expr-with-no-output NEWLINE => NEWLINE
			// Indented $...$ have the indent stored with the ASTExpr
			// so the indent does not come out as a StringRef
			if ( chunkN<=0 &&
				(i-1)>=0 && chunks.get(i-1) instanceof NewlineRef &&
				(i+1)<chunks.size() && chunks.get(i+1) instanceof NewlineRef )
			{
				//System.out.println("found pure \\n blank \\n pattern");
				i++; // make it skip over the next chunk, the NEWLINE
			}
            if ( chunkN!=ASTExpr.MISSING ) {
                n += chunkN;
                missing = false;
            }
		}
		if ( group.debugTemplateOutput ) {
			group.emitTemplateStopDebugString(this,out);
		}
		if ( lintMode ) checkForTrouble();
		if ( missing && chunks!=null && chunks.size()>0 ) return ASTExpr.MISSING;
        return n;
	}

	/** Resolve an attribute reference.  It can be in four possible places:
	 *
	 *  1. the attribute list for the current template
	 *  2. if self is an embedded template, somebody invoked us possibly
	 *     with arguments--check the argument context
	 *  3. if self is an embedded template, the attribute list for the enclosing
	 *     instance (recursively up the enclosing instance chain)
	 *  4. if nothing is found in the enclosing instance chain, then it might
	 *     be a map defined in the group or the its supergroup etc...
	 *
	 *  Attribute references are checked for validity.  If an attribute has
	 *  a value, its validity was checked before template rendering.
	 *  If the attribute has no value, then we must check to ensure it is a
	 *  valid reference.  Somebody could reference any random value like $xyz$;
	 *  formal arg checks before rendering cannot detect this--only the ref
	 *  can initiate a validity check.  So, if no value, walk up the enclosed
	 *  template tree again, this time checking formal parameters not
	 *  attributes Map.  The formal definition must exist even if no value.
	 *
	 *  To avoid infinite recursion in toString(), we have another condition
	 *  to check regarding attribute values.  If your template has a formal
	 *  argument, foo, then foo will hide any value available from "above"
	 *  in order to prevent infinite recursion.
	 *
	 *  This method is not static so people can override functionality.
	 */
	public Object get(StringTemplate self, String attribute) {
        /*
		System.out.println("### get("+self.getEnclosingInstanceStackString()+", "+attribute+")");
		System.out.println("attributes="+(self.attributes!=null?self.attributes.keySet().toString():"none"));
		*/
		if ( self==null ) {
			return null;
		}

		if ( lintMode ) {
			self.trackAttributeReference(attribute);
		}

		// is it here?
		Object o = null;
		if ( self.attributes!=null ) {
			o = self.attributes.get(attribute);
		}

		// nope, check argument context in case embedded
		if ( o==null ) {
			Map argContext = self.getArgumentContext();
			if ( argContext!=null ) {
				o = argContext.get(attribute);
			}
		}

		if ( o==null &&
			 !self.passThroughAttributes &&
			 self.getFormalArgument(attribute)!=null )
		{
			// if you've defined attribute as formal arg for this
			// template and it has no value, do not look up the
			// enclosing dynamic scopes.  This avoids potential infinite
			// recursion.
			return null;
		}

		// not locally defined, check enclosingInstance if embedded
		if ( o==null && self.enclosingInstance!=null ) {
            /*
            System.out.println("looking for "+getName()+"."+attribute+" in super="+
                    enclosingInstance.getName());
             */
			Object valueFromEnclosing = get(self.enclosingInstance, attribute);
            /*
			if ( valueFromEnclosing==null ) {
				checkNullAttributeAgainstFormalArguments(self, attribute);
			}
			*/
			o = valueFromEnclosing;
		}

		// not found and no enclosing instance to look at
		else if ( o==null && self.enclosingInstance==null ) {
			// It might be a map in the group or supergroup...
			o = self.group.getMap(attribute);
		}

		return o;
	}

	/** Walk a template, breaking it into a list of
	 *  chunks: Strings and actions/expressions.
	 */
	protected void breakTemplateIntoChunks() {
		//System.out.println("parsing template: "+pattern);
		if ( pattern==null ) {
			return;
		}
		try {
			// instead of creating a specific template lexer, use
			// an instance of the class specified by the user.
			// The default is DefaultTemplateLexer.
			// The only constraint is that you use an ANTLR lexer
			// so I can use the special ChunkToken.
			Class lexerClass = group.getTemplateLexerClass();
			Constructor ctor =
					lexerClass.getConstructor(
						new Class[] {StringTemplate.class,Reader.class}
					);
			CharScanner chunkStream =
					(CharScanner) ctor.newInstance(
						new Object[] {this,new StringReader(pattern)}
					);
			chunkStream.setTokenObjectClass("org.antlr.stringtemplate.language.ChunkToken");
			TemplateParser chunkifier = new TemplateParser(chunkStream);
			chunkifier.template(this);
			//System.out.println("chunks="+chunks);
		}
		catch (Exception e) {
			String name = "<unknown>";
			String outerName = getOutermostName();
			if ( getName()!=null ) {
				name = getName();
			}
			if ( outerName!=null && !name.equals(outerName) ) {
				name = name+" nested in "+outerName;
			}
			error("problem parsing template '"+name+"'", e);
		}
	}

	public ASTExpr parseAction(String action) {
		//System.out.println("parse action "+action);
		ActionLexer lexer =
			new ActionLexer(new StringReader(action.toString()));
		ActionParser parser =
			new ActionParser(lexer, this);
		parser.setASTNodeClass("org.antlr.stringtemplate.language.StringTemplateAST");
		lexer.setTokenObjectClass("org.antlr.stringtemplate.language.StringTemplateToken");
		ASTExpr a = null;
		try {
			Map options = parser.action();
			AST tree = parser.getAST();
			if ( tree!=null ) {
				if ( tree.getType()==ActionParser.CONDITIONAL ) {
					a = new ConditionalExpr(this,tree);
				}
				else {
					a = new ASTExpr(this,tree,options);
				}
			}
		}
		catch (RecognitionException re) {
			error("Can't parse chunk: "+action.toString(), re);
		}
		catch (TokenStreamException tse) {
			error("Can't parse chunk: "+action.toString(), tse);
		}
		return a;
	}

	public int getTemplateID() {
		return templateID;
	}

	public Map getAttributes() {
		return attributes;
	}

	/** Get a list of the strings and subtemplates and attribute
	 *  refs in a template.
	 */
	public List getChunks() {
		return chunks;
	}

	public void addChunk(Expr e) {
		if ( chunks==null ) {
			chunks = new ArrayList();
		}
		chunks.add(e);
	}

	public void setAttributes(Map attributes) {
		this.attributes = attributes;
	}

	// F o r m a l  A r g  S t u f f

	public Map getFormalArguments() {
		return formalArguments;
	}

	public void setFormalArguments(LinkedHashMap args) {
		formalArguments = args;
	}

	/** Set any default argument values that were not set by the
	 *  invoking template or by setAttribute directly.  Note
	 *  that the default values may be templates.  Their evaluation
	 *  context is the template itself and, hence, can see attributes
	 *  within the template, any arguments, and any values inherited
	 *  by the template.
	 *
	 *  Default values are stored in the argument context rather than
	 *  the template attributes table just for consistency's sake.
	 */
	public void setDefaultArgumentValues() {
        //System.out.println("setDefaultArgumentValues; "+name+": argctx="+argumentContext+", n="+numberOfDefaultArgumentValues);
		if ( numberOfDefaultArgumentValues==0 ) {
			return;
		}
		if ( argumentContext==null ) {
			argumentContext = new HashMap();
		}
		if ( formalArguments!=FormalArgument.UNKNOWN ) {
            //System.out.println("formal args="+formalArguments.keySet());
			Set argNames = formalArguments.keySet();
			for (Iterator it = argNames.iterator(); it.hasNext();) {
				String argName = (String) it.next();
				// use the default value then
				FormalArgument arg =
					(FormalArgument)formalArguments.get(argName);
				if ( arg.defaultValueST!=null ) {
                    //System.out.println("default value="+arg.defaultValueST.chunks);
                    //System.out.println(getEnclosingInstanceStackString()+": get "+argName+" argctx="+argumentContext);
					Object existingValue = getAttribute(argName);
                    //System.out.println("existing value="+existingValue);
					if ( existingValue==null ) { // value unset?
                        Object defaultValue = arg.defaultValueST;
						// if no value for attribute, set arg context
						// to the default value.  We don't need an instance
						// here because no attributes can be set in
						// the arg templates by the user.
                        int nchunks = arg.defaultValueST.chunks.size();
                        if ( nchunks==1 ) {
                            // If default arg is template with single expression
                            // wrapped in parens, x={<(...)>}, then eval to string
                            // rather than setting x to the template for later
                            // eval.
                            Object a = arg.defaultValueST.chunks.get(0);
                            if ( a instanceof ASTExpr ) {
                                ASTExpr e = (ASTExpr)a;
                                if ( e.getAST().getType()==ActionEvaluator.VALUE ) {
                                    defaultValue = e.evaluateExpression(this, e.getAST());
                                }
                            }
                        }
                        argumentContext.put(argName, defaultValue);
					}
				}
			}
		}
	}

	/** From this template upward in the enclosing template tree,
	 *  recursively look for the formal parameter.
	 */
	public FormalArgument lookupFormalArgument(String name) {
		FormalArgument arg = getFormalArgument(name);
		if ( arg==null && enclosingInstance!=null ) {
			arg = enclosingInstance.lookupFormalArgument(name);
		}
		return arg;
	}

	public FormalArgument getFormalArgument(String name) {
		return (FormalArgument)formalArguments.get(name);
	}

	public void defineEmptyFormalArgumentList() {
		setFormalArguments(new LinkedHashMap());
	}

	public void defineFormalArgument(String name) {
		defineFormalArgument(name,null);
	}

	public void defineFormalArguments(List names) {
		if ( names==null ) {
			return;
		}
		for (int i = 0; i < names.size(); i++) {
			String name = (String) names.get(i);
			defineFormalArgument(name);
		}
	}

	public void defineFormalArgument(String name, StringTemplate defaultValue) {
        /*
        System.out.println("define formal arg "+this.name+"."+name+
                           ", def value="+(defaultValue!=null?defaultValue.chunks:"null"));
                           */
		if ( defaultValue!=null ) {
			numberOfDefaultArgumentValues++;
		}
		FormalArgument a = new FormalArgument(name,defaultValue);
		if ( formalArguments==FormalArgument.UNKNOWN ) {
			formalArguments = new LinkedHashMap();
		}
		formalArguments.put(name, a);
	}

	/** Normally if you call template y from x, y cannot see any attributes
	 *  of x that are defined as formal parameters of y.  Setting this
	 *  passThroughAttributes to true, will override that and allow a
	 *  template to see through the formal arg list to inherited values.
	 */
	public void setPassThroughAttributes(boolean passThroughAttributes) {
		this.passThroughAttributes = passThroughAttributes;
	}

	/** Specify a complete map of what object classes should map to which
	 *  renderer objects.
	 */
	public void setAttributeRenderers(Map renderers) {
		this.attributeRenderers = renderers;
	}

	/** Register a renderer for all objects of a particular type.  This
	 *  overrides any renderer set in the group for this class type.
	 */
	public void registerRenderer(Class attributeClassType, AttributeRenderer renderer) {
		if ( attributeRenderers==null ) {
			attributeRenderers = new HashMap();
		}
		attributeRenderers.put(attributeClassType, renderer);
	}

	/** What renderer is registered for this attributeClassType for
	 *  this template.  If not found, the template's group is queried.
	 */
	public AttributeRenderer getAttributeRenderer(Class attributeClassType) {
		AttributeRenderer renderer = null;
		if ( attributeRenderers!=null ) {
			renderer = (AttributeRenderer)attributeRenderers.get(attributeClassType);
		}
		if ( renderer!=null ) {
			// found it!
			return renderer;
		}

		// we have no renderer overrides for the template or none for class arg
		// check parent template if we are embedded
		if ( enclosingInstance!=null ) {
			return enclosingInstance.getAttributeRenderer(attributeClassType);
		}
		// else check group
		return group.getAttributeRenderer(attributeClassType);
	}

	// U T I L I T Y  R O U T I N E S

	public void error(String msg) {
		error(msg, null);
	}

	public void warning(String msg) {
		if ( getErrorListener()!=null ) {
			getErrorListener().warning(msg);
		}
		else {
			System.err.println("StringTemplate: warning: "+msg);
		}
	}

	public void error(String msg, Throwable e) {
		if ( getErrorListener()!=null ) {
			getErrorListener().error(msg,e);
		}
		else {
			if ( e!=null ) {
				System.err.println("StringTemplate: error: "+msg+": "+e.toString());
				if ( e instanceof InvocationTargetException ) {
					e = ((InvocationTargetException)e).getTargetException();
				}
				e.printStackTrace(System.err);
			}
			else {
				System.err.println("StringTemplate: error: "+msg);
			}
		}
	}

	/** Make StringTemplate check your work as it evaluates templates.
	 *  Problems are sent to error listener.   Currently warns when
	 *  you set attributes that are not used.
	 */
	public static void setLintMode(boolean lint) {
		StringTemplate.lintMode = lint;
	}

	public static boolean inLintMode() {
		return lintMode;
	}

	/** Indicates that 'name' has been referenced in this template. */
	protected void trackAttributeReference(String name) {
		if ( referencedAttributes==null ) {
			referencedAttributes = new ArrayList();
		}
		referencedAttributes.add(name);
	}

	/** Look up the enclosing instance chain (and include this) to see
	 *  if st is a template already in the enclosing instance chain.
	 */
	public static boolean isRecursiveEnclosingInstance(StringTemplate st) {
		if ( st==null ) {
			return false;
		}
		StringTemplate p = st.enclosingInstance;
		if ( p==st ) {
			return true; // self-recursive
		}
		// now look for indirect recursion
		while ( p!=null ) {
			if ( p==st ) {
				return true;
			}
			p = p.enclosingInstance;
		}
		return false;
	}

	public String getEnclosingInstanceStackTrace() {
		StringBuffer buf = new StringBuffer();
		Set seen = new HashSet();
		StringTemplate p = this;
		while ( p!=null ) {
			if ( seen.contains(p) ) {
				buf.append(p.getTemplateDeclaratorString());
				buf.append(" (start of recursive cycle)");
				buf.append("\n");
				buf.append("...");
				break;
			}
			seen.add(p);
			buf.append(p.getTemplateDeclaratorString());
			if ( p.attributes!=null ) {
				buf.append(", attributes=[");
				int i = 0;
				for (Iterator iter = p.attributes.keySet().iterator(); iter.hasNext();) {
					String attrName = (String) iter.next();
					if ( i>0 ) {
						buf.append(", ");
					}
					i++;
					buf.append(attrName);
					Object o = p.attributes.get(attrName);
					if ( o instanceof StringTemplate ) {
						StringTemplate st = (StringTemplate)o;
						buf.append("=");
						buf.append("<");
						buf.append(st.getName());
						buf.append("()@");
						buf.append(String.valueOf(st.getTemplateID()));
						buf.append(">");
					}
					else if ( o instanceof List ) {
						buf.append("=List[..");
						List list = (List)o;
						int n=0;
						for (int j = 0; j < list.size(); j++) {
							Object listValue = list.get(j);
							if ( listValue instanceof StringTemplate ) {
								if ( n>0 ) {
									buf.append(", ");
								}
								n++;
								StringTemplate st = (StringTemplate)listValue;
								buf.append("<");
								buf.append(st.getName());
								buf.append("()@");
								buf.append(String.valueOf(st.getTemplateID()));
								buf.append(">");
							}
						}
						buf.append("..]");
					}
				}
				buf.append("]");
			}
			if ( p.referencedAttributes!=null ) {
				buf.append(", references=");
				buf.append(p.referencedAttributes);
			}
			buf.append(">\n");
			p = p.enclosingInstance;
		}
		/*
				if ( enclosingInstance!=null ) {
				buf.append(enclosingInstance.getEnclosingInstanceStackTrace());
				}
				*/
		return buf.toString();
	}

	public String getTemplateDeclaratorString() {
		StringBuffer buf = new StringBuffer();
		buf.append("<");
		buf.append(getName());
		buf.append("(");
		buf.append(formalArguments.keySet());
		buf.append(")@");
		buf.append(String.valueOf(getTemplateID()));
		buf.append(">");
		return buf.toString();
	}

	protected String getTemplateHeaderString(boolean showAttributes) {
		if ( showAttributes ) {
			StringBuffer buf = new StringBuffer();
			buf.append(getName());
			if ( attributes!=null ) {
				buf.append(attributes.keySet());
			}
			return buf.toString();
		}
		return getName();
	}

	/** Find "missing attribute" and "cardinality mismatch" errors.
	 *  Excecuted before a template writes its chunks out.
	 *  When you find a problem, throw an IllegalArgumentException.
	 *  We must check the attributes as well as the incoming arguments
	 *  in argumentContext.
	protected void checkAttributesAgainstFormalArguments() {
		Set args = formalArguments.keySet();
		/*
		if ( (attributes==null||attributes.size()==0) &&
			 (argumentContext==null||argumentContext.size()==0) &&
			 formalArguments.size()!=0 )
		{
			throw new IllegalArgumentException("missing argument(s): "+args+" in template "+getName());
		}
		Iterator iter = args.iterator();
		while ( iter.hasNext() ) {
			String argName = (String)iter.next();
			FormalArgument arg = getFormalArgument(argName);
			int expectedCardinality = arg.getCardinality();
			Object value = getAttribute(argName);
			int actualCardinality = getActualArgumentCardinality(value);
			// if intersection of expected and actual is empty, mismatch
			if ( (expectedCardinality&actualCardinality)==0 ) {
				throw new IllegalArgumentException("cardinality mismatch: "+
						argName+"; expected "+
						FormalArgument.getCardinalityName(expectedCardinality)+
						" found cardinality="+getObjectLength(value));
			}
		}
	}
*/

	/** A reference to an attribute with no value, must be compared against
	 *  the formal parameter to see if it exists; if it exists all is well,
	 *  but if not, throw an exception.
	 *
	 *  Don't do the check if no formal parameters exist for this template;
	 *  ask enclosing.
	 */
	protected void checkNullAttributeAgainstFormalArguments(
			StringTemplate self,
			String attribute)
	{
		if ( self.getFormalArguments()==FormalArgument.UNKNOWN ) {
			// bypass unknown arg lists
			if ( self.enclosingInstance!=null ) {
				checkNullAttributeAgainstFormalArguments(
						self.enclosingInstance,
						attribute);
			}
			return;
		}
		FormalArgument formalArg = self.lookupFormalArgument(attribute);
		if ( formalArg == null ) {
			throw new NoSuchElementException("no such attribute: "+attribute+
											 " in template context "+getEnclosingInstanceStackString());
		}
	}

	/** Executed after evaluating a template.  For now, checks for setting
	 *  of attributes not reference.
	 */
	protected void checkForTrouble() {
		// we have table of set values and list of values referenced
		// compare, looking for SET BUT NOT REFERENCED ATTRIBUTES
		if ( attributes==null ) {
			return;
		}
		Set names = attributes.keySet();
		Iterator iter = names.iterator();
		// if in names and not in referenced attributes, trouble
		while ( iter.hasNext() ) {
			String name = (String)iter.next();
			if ( referencedAttributes!=null &&
				!referencedAttributes.contains(name) )
			{
				warning(getName()+": set but not used: "+name);
			}
		}
		// can do the reverse, but will have lots of false warnings :(
	}

	/** If an instance of x is enclosed in a y which is in a z, return
	 *  a String of these instance names in order from topmost to lowest;
	 *  here that would be "[z y x]".
	 */
	public String getEnclosingInstanceStackString() {
		List names = new LinkedList();
		StringTemplate p = this;
		while ( p!=null ) {
			String name = p.getName();
			names.add(0,name+(p.passThroughAttributes?"(...)":""));
			p = p.enclosingInstance;
		}
		return names.toString().replaceAll(",","");
	}

	public boolean isRegion() {
		return isRegion;
	}

	public void setIsRegion(boolean isRegion) {
		this.isRegion = isRegion;
	}

	public void addRegionName(String name) {
		if ( regions==null ) {
			regions = new HashSet();
		}
		regions.add(name);
	}

	/** Does this template ref or embed region name? */
	public boolean containsRegionName(String name) {
		if ( regions==null ) {
			return false;
		}
		return regions.contains(name);
	}

	public int getRegionDefType() {
		return regionDefType;
	}

	public void setRegionDefType(int regionDefType) {
		this.regionDefType = regionDefType;
	}

	public String toDebugString() {
		StringBuffer buf = new StringBuffer();
		buf.append("template-"+getTemplateDeclaratorString()+":");
		buf.append("chunks=");
		if ( chunks!=null ) {
			buf.append(chunks.toString());
		}
		buf.append("attributes=[");
		if ( attributes!=null ) {
			Set attrNames = attributes.keySet();
			int n=0;
			for (Iterator iter = attrNames.iterator(); iter.hasNext();) {
				if ( n>0 ) {
					buf.append(',');
				}
				String name = (String) iter.next();
				buf.append(name+"=");
				Object value = attributes.get(name);
				if ( value instanceof StringTemplate ) {
					buf.append(((StringTemplate)value).toDebugString());
				}
				else {
					buf.append(value);
				}
				n++;
			}
			buf.append("]");
		}
		return buf.toString();
	}

	/** Don't print values, just report the nested structure with attribute names.
	 *  Follow (nest) attributes that are templates only.
	 */
	public String toStructureString() {
		return toStructureString(0);
	}

	public String toStructureString(int indent) {
		StringBuffer buf = new StringBuffer();
		for (int i=1; i<=indent; i++) { // indent
			buf.append("  ");
		}
		buf.append(getName());
		buf.append(attributes.keySet());
		buf.append(":\n");
		if ( attributes!=null ) {
			Set attrNames = attributes.keySet();
			for (Iterator iter = attrNames.iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				Object value = attributes.get(name);
				if ( value instanceof StringTemplate ) { // descend
					buf.append(((StringTemplate)value).toStructureString(indent+1));
				}
				else {
					if ( value instanceof List ) {
						List alist = (List)value;
						for (int i = 0; i < alist.size(); i++) {
							Object o = (Object) alist.get(i);
							if ( o instanceof StringTemplate ) { // descend
								buf.append(((StringTemplate)o).toStructureString(indent+1));
							}
						}
					}
					else if ( value instanceof Map ) {
						Map m = (Map)value;
						Collection mvalues = m.values();
						for (Iterator iterator = mvalues.iterator(); iterator.hasNext();) {
							Object o = (Object) iterator.next();
							if ( o instanceof StringTemplate ) { // descend
								buf.append(((StringTemplate)o).toStructureString(indent+1));
							}
						}
					}
				}
			}
		}
		return buf.toString();
	}

	/*
	public String getDOTForDependencyGraph(boolean showAttributes) {
		StringBuffer buf = new StringBuffer();
		buf.append("digraph prof {\n");
		HashMap edges = new HashMap();
		this.getDependencyGraph(edges, showAttributes);
		Set sourceNodes = edges.keySet();
		// for each source template
		for (Iterator it = sourceNodes.iterator(); it.hasNext();) {
			String src = (String) it.next();
			Set targetNodes = (Set)edges.get(src);
			// for each target template
			for (Iterator it2 = targetNodes.iterator(); it2.hasNext();) {
				String trg = (String) it2.next();
				buf.append('"');
				buf.append(src);
				buf.append('"');
				buf.append("->");
				buf.append('"');
				buf.append(trg);
				buf.append("\"\n");
			}
		}
		buf.append("}");
		return buf.toString();
	}
*/

	/** Generate a DOT file for displaying the template enclosure graph; e.g.,
		digraph prof {
		  "t1" -> "t2"
		  "t1" -> "t3"
		  "t4" -> "t5"
		}
	*/
	public StringTemplate getDOTForDependencyGraph(boolean showAttributes) {
		String structure =
			"digraph StringTemplateDependencyGraph {\n" +
			"node [shape=$shape$, $if(width)$width=$width$,$endif$" +
			"      $if(height)$height=$height$,$endif$ fontsize=$fontsize$];\n" +
			"$edges:{e|\"$e.src$\" -> \"$e.trg$\"\n}$" +
			"}\n";
		StringTemplate graphST = new StringTemplate(structure);
		HashMap edges = new HashMap();
		this.getDependencyGraph(edges, showAttributes);
		Set sourceNodes = edges.keySet();
		// for each source template
		for (Iterator it = sourceNodes.iterator(); it.hasNext();) {
			String src = (String) it.next();
			Set targetNodes = (Set)edges.get(src);
			// for each target template
			for (Iterator it2 = targetNodes.iterator(); it2.hasNext();) {
				String trg = (String) it2.next();
				graphST.setAttribute("edges.{src,trg}", src, trg);
			}
		}
		graphST.setAttribute("shape", "none");
		graphST.setAttribute("fontsize", "11");
		graphST.setAttribute("height", "0"); // make height
		return graphST;
	}

	/** Get a list of n->m edges where template n contains template m.
	 *  The map you pass in is filled with edges: key->value.  Useful
	 *  for having DOT print out an enclosing template graph.  It
	 *  finds all direct template invocations too like <foo()> but not
	 *  indirect ones like <(name)()>.
	 *
	 *  Ack, I just realized that this is done statically and hence
	 *  cannot see runtime arg values on statically included templates.
	 *  Hmm...someday figure out to do this dynamically as if we were
	 *  evaluating the templates.  There will be extra nodes in the tree
	 *  because we are static like method and method[...] with args.
	 */
	public void getDependencyGraph(Map edges, boolean showAttributes) {
		String srcNode = this.getTemplateHeaderString(showAttributes);
		if ( attributes!=null ) {
			Set attrNames = attributes.keySet();
			for (Iterator iter = attrNames.iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				Object value = attributes.get(name);
				if ( value instanceof StringTemplate ) {
					String targetNode =
						((StringTemplate)value).getTemplateHeaderString(showAttributes);
					putToMultiValuedMap(edges,srcNode,targetNode);
					((StringTemplate)value).getDependencyGraph(edges,showAttributes); // descend
				}
				else {
					if ( value instanceof List ) {
						List alist = (List)value;
						for (int i = 0; i < alist.size(); i++) {
							Object o = (Object) alist.get(i);
							if ( o instanceof StringTemplate ) {
								String targetNode =
									((StringTemplate)o).getTemplateHeaderString(showAttributes);
								putToMultiValuedMap(edges,srcNode,targetNode);
								((StringTemplate)o).getDependencyGraph(edges,showAttributes); // descend
							}
						}
					}
					else if ( value instanceof Map ) {
						Map m = (Map)value;
						Collection mvalues = m.values();
						for (Iterator iterator = mvalues.iterator(); iterator.hasNext();) {
							Object o = (Object) iterator.next();
							if ( o instanceof StringTemplate ) {
								String targetNode =
									((StringTemplate)o).getTemplateHeaderString(showAttributes);
								putToMultiValuedMap(edges,srcNode,targetNode);
								((StringTemplate)o).getDependencyGraph(edges,showAttributes); // descend
							}
						}
					}
				}
			}
		}
		// look in chunks too for template refs
		for (int i = 0; chunks!=null && i < chunks.size(); i++) {
			Expr expr = (Expr) chunks.get(i);
			if ( expr instanceof ASTExpr ) {
				ASTExpr e = (ASTExpr)expr;
				AST tree = e.getAST();
				AST includeAST =
					new CommonAST(new CommonToken(ActionEvaluator.INCLUDE,"include"));
				ASTEnumeration it = tree.findAllPartial(includeAST);
				while (it.hasMoreNodes()) {
					AST t = (AST) it.nextNode();
					String templateInclude = t.getFirstChild().getText();
					System.out.println("found include "+templateInclude);
					putToMultiValuedMap(edges,srcNode,templateInclude);
					StringTemplateGroup group = getGroup();
					if ( group!=null ) {
						StringTemplate st = group.getInstanceOf(templateInclude);
						// descend into the reference template
						st.getDependencyGraph(edges, showAttributes);
					}
				}
			}
		}
	}

	/** Manage a hash table like it has multiple unique values.  Map<Object,Set>. */
	protected void putToMultiValuedMap(Map map, Object key, Object value) {
		HashSet bag = (HashSet)map.get(key);
		if ( bag==null ) {
			bag = new HashSet();
			map.put(key, bag);
		}
		bag.add(value);
	}

	public void printDebugString() {
		System.out.println("template-"+getName()+":");
		System.out.print("chunks=");
		System.out.println(chunks.toString());
		if ( attributes==null ) {
			return;
		}
		System.out.print("attributes=[");
		Set attrNames = attributes.keySet();
		int n=0;
		for (Iterator iter = attrNames.iterator(); iter.hasNext();) {
			if ( n>0 ) {
				System.out.print(',');
			}
			String name = (String) iter.next();
			Object value = attributes.get(name);
			if ( value instanceof StringTemplate ) {
				System.out.print(name+"=");
				((StringTemplate)value).printDebugString();
			}
			else {
				if ( value instanceof List ) {
					ArrayList alist = (ArrayList)value;
					for (int i = 0; i < alist.size(); i++) {
						Object o = (Object) alist.get(i);
						System.out.print(name+"["+i+"] is "+o.getClass().getName()+"=");
						if ( o instanceof StringTemplate ) {
							((StringTemplate)o).printDebugString();
						}
						else {
							System.out.println(o);
						}
					}
				}
				else {
					System.out.print(name+"=");
					System.out.println(value);
				}
			}
			n++;
		}
		System.out.print("]\n");
	}

	public String toString() {
		return toString(StringTemplateWriter.NO_WRAP);
	}

	public String toString(int lineWidth) {
		StringWriter out = new StringWriter();
		// Write the output to a StringWriter
		StringTemplateWriter wr = group.getStringTemplateWriter(out);
		wr.setLineWidth(lineWidth);
		try {
			write(wr);
		}
		catch (IOException io) {
			error("Got IOException writing to writer "+wr.getClass().getName());
		}
		// reset so next toString() does not wrap; normally this is a new writer
		// each time, but just in case they override the group to reuse the
		// writer.
		wr.setLineWidth(StringTemplateWriter.NO_WRAP);
		return out.toString();
	}

}

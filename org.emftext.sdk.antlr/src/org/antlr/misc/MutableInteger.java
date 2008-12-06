package org.antlr.misc;

/** Java won't let you modify an Integer; not sure how that's more
 *  efficient, but...here's one that let's you modify it.
 *  Frightening I have to implement this myself. Blech.
 */
public class MutableInteger {
	public int value;
	public MutableInteger() {
		this(0);
	}
	public MutableInteger(int value) {
		this.value = value;
	}
}

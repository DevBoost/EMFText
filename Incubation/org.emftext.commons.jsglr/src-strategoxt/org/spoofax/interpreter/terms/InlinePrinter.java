package org.spoofax.interpreter.terms;

public class InlinePrinter implements ITermPrinter {
	private final StringBuilder out;
	
	public InlinePrinter() {
		out = new StringBuilder();
	}
	
	public String getString() {
		return out.toString();
	}

	public void print(String string) {
		if (string.matches("^ *$")) {
			return ;
		}
		out.append(string);
	}

	public void indent(int i) {
	}

	public void nextIndentOff() {
	}

	public void outdent(int i) {
	}
	
	@Override
	public String toString() {
	    return getString();
	}
	
	public void reset() {
	    out.setLength(0);
	}

	public void println(String string, boolean b) {
		if (string.matches("^ *$")) {
			return ;
		}
		out.append(string);
	}

	public void println(String string) {
		out.append(string);
	}
}

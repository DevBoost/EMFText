package org.emftext.sdk.codegen.util;

import java.util.ArrayList;
import java.util.List;

/**
 * A StringComposite can be used to compose text fragments. In contrast to
 * a StringBuilder or StringBuffer, this class can enable and disable text
 * fragments. This is useful when text is composed, but later unnecessary 
 * parts need to be removed.
 * This class is used by the code generators to insert variable declarations
 * only if they are referenced.
 */
public class StringComposite implements Component {
	
	public static final String LINE_BREAK = "\n";
	
	private List<Component> components = new ArrayList<Component>();
	private boolean enabled;
	
	public StringComposite() {
		this(true);
	}

	public StringComposite(boolean enabled) {
		this.enabled = enabled;
	}

	public StringComposite tab() {
		components.add(new Tab());
		return this;
	}
	
	public StringComposite newline() {
		return println();
	}
	
	public StringComposite backTab() {
		components.add(new BackTab());
		return this;
	}
	
	public StringComposite println() {
		println("");
		return this;
	}
	
	public StringComposite println(String text) {
		print(text + LINE_BREAK);
		return this;
	}

	public StringComposite println(final Component component) {
		components.add(new StringComponent("") {

			@Override
			public String getText() {
				return component.toString() + LINE_BREAK;
			}

			@Override
			public boolean isEnabled() {
				return component.isEnabled();
			}
		});
		return this;
	}
	
	public StringComposite print(String text) {
		StringComponent component = new StringComponent(text);
		component.enable();
		print(component);
		return this;
	}
	

	public StringComposite print(StringComponent component) {
		components.add(component);
		return this;
	}
	
	@Override
	public String toString() {
		return toString(0);
	}
	
	public String toString(int tabs) {
		StringBuilder builder = new StringBuilder();
		for (Component component : components) {
			if (component instanceof Tab) {
				tabs++;
			} else if (component instanceof BackTab) {
				tabs--;
				assert tabs >= 0;
			} else {
				if (component.isEnabled()) {
					String text = component.toString(tabs);
					builder.append(text);
				}
			}
		}
		assert tabs == 0;
		return builder.toString();
	}

	public static String getTabText(int tabs) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < tabs; i++) {
			builder.append('\t');
		}
		return builder.toString();
	}

	public void enable() {
		for (Component component : components) {
			component.enable();
		}
		this.enabled = true;
	}

	public boolean isEnabled() {
		return enabled;
	}
}

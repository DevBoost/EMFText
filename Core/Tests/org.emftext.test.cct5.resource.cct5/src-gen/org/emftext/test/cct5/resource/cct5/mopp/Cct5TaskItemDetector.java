/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * The Cct5TaskItemDetector is used to find task items in text documents. The
 * current implementation searches for specific keywords to detect task items. The
 * Cct5TaskItemDetector is used both by the TaskItemBuilder and the editor.
 */
public class Cct5TaskItemDetector {
	
	/**
	 * This regular expression is used to split string at the line breaks. It is
	 * precompiled for performance reasons.
	 */
	private static final Pattern LINE_BREAK_REGEX = Pattern.compile("(\r\n|\r|\n)");
	
	/**
	 * This is an array of all keywords that indicate task items. The array is public
	 * to allow customizations.
	 */
	public static String[] TASK_ITEM_KEYWORDS = new String[] {"TODO", "FIXME", "XXX"};
	
	public List<org.emftext.test.cct5.resource.cct5.mopp.Cct5TaskItem> findTaskItems(String text, int line, int charStart) {
		List<org.emftext.test.cct5.resource.cct5.mopp.Cct5TaskItem> foundItems = new ArrayList<org.emftext.test.cct5.resource.cct5.mopp.Cct5TaskItem>();
		String remainingText = text;
		boolean continueSearch = true;
		int localCharStart = charStart;
		while (remainingText != null && continueSearch) {
			continueSearch = false;
			for (String keyword : TASK_ITEM_KEYWORDS) {
				int index = remainingText.indexOf(keyword);
				if (index >= 0) {
					continueSearch = true;
					String message = remainingText.substring(index);
					// stop at end of line and check whether the next lines do also contain task items
					int eolIndex = remainingText.indexOf("\n", index);
					if (eolIndex < 0) {
						eolIndex = remainingText.indexOf("\r", index);
					}
					if (eolIndex > 0) {
						message = remainingText.substring(index, eolIndex);
						if (message.startsWith("\r")) {
							message = message.substring(1);
						}
						if (message.startsWith("\n")) {
							message = message.substring(1);
						}
						message = message.trim();
						remainingText = remainingText.substring(eolIndex);
					} else {
						remainingText = null;
					}
					// This is a somewhat arbitrary heuristics to remove the end delimiters from
					// multi-line comments. Since comments are usually implemented using hidden
					// (unused) tokens, there are no token resolvers that could be used to strip
					// delimiters. Thus, this is a reasonable default which reflects the fact that
					// many languages use Java-style multi-line comments.
					if (message.endsWith("*/")) {
						message = message.substring(0, message.length() - 2);
					}
					message = message.trim();
					
					int offset = index + localCharStart;
					int end = offset + keyword.length();
					int localLine = line + LINE_BREAK_REGEX.split(text.substring(0, offset - charStart), 0).length - 1;
					foundItems.add(new org.emftext.test.cct5.resource.cct5.mopp.Cct5TaskItem(keyword, message, localLine, offset, end));
					localCharStart += eolIndex;
					// stop looping over the keywords, we've found one
					break;
				}
			}
		}
		return foundItems;
	}
	
}

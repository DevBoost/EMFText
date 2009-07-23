package org.emftext.runtime.ui.extensions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.emftext.runtime.ui.ColorManager;
import org.emftext.runtime.ui.EMFTextRuntimeUIPlugin;
import org.emftext.runtime.ui.preferences.PreferenceConstants;

/**
 * A container for all bracket pairs. This calls is used by the EMFTextEditor.
 */
public class BracketSet {

	/**
	 * A single pair of brackets.
	 */
	private class BracketPair {

		private String[] brackets;

		public BracketPair(String open, String close) {
			brackets = new String[] { open, close };
		}

		public String open() {
			return brackets[0];
		}

		public String close() {
			return brackets[1];
		}
	}

	private final class ClosingListener implements VerifyListener, ModifyListener, VerifyKeyListener {
		private int closingLength = -1;
		private boolean closingAdded = false;
		private boolean isEmbraced = false;

		/**
		 * Automatic closing will be activated if the text about
		 * to insert is a bracket, and the next character in 
		 * TextWidget is not a double quote.
		 * 
		 * TODO the double quote is just one special case!
		 * 
		 * @see org.eclipse.swt.events.VerifyListener#verifyText(org.eclipse.swt.events.VerifyEvent)
		 */
		public void verifyText(VerifyEvent e) {
			if (isOpen(e.text)
					&& (textWidget.getCaretOffset() == textWidget.getCharCount() || !textWidget.getTextRange(textWidget.getCaretOffset(), 1)
							.matches("[\"\']"))) {
				closingAdded = true;
				String close = getCounterpart(e.text);
				e.text += close;
				closingLength = close.length();
			}
		}

		public void modifyText(ModifyEvent e) {
			if (closingAdded) {
				closingAdded = false;
				textWidget.setCaretOffset(textWidget.getCaretOffset() - closingLength);
				closingLength = -1;
			}
			if (isEmbraced) {
				isEmbraced = false;
				textWidget.replaceTextRange(textWidget.getCaretOffset(), 1, "");
			}
		}

		/**
		 * This is for the Backspace key, if you want to delete a
		 * previous character.
		 * 
		 * @see org.eclipse.swt.custom.VerifyKeyListener#verifyKey(org.eclipse.swt.events.VerifyEvent)
		 */
		public void verifyKey(VerifyEvent e) {
			int caret = textWidget.getCaretOffset();
			if (caret == 0 || e.keyCode != SWT.BS || caret == textWidget.getCharCount()) {
				return;
			}
			String prevStr = textWidget.getTextRange(textWidget.getCaretOffset() - 1, 1);
			String nextStr = textWidget.getTextRange(textWidget.getCaretOffset(), 1);
			if (e.keyCode == SWT.BS && isOpen(prevStr) && getCounterpart(prevStr).equals(nextStr)) {
				isEmbraced = true;
			}
		}
	}

	private List<BracketPair> bracketPairs;
	private ISourceViewer viewer;
	private StyledText textWidget;
	private IPreferenceStore preferenceStore;
	private String language;

	/**
	 * @param sourceViewer
	 *            take the ISourceViewer to handle the TextWidget of the
	 *            EMFTextEditor.
	 * @param ps
	 *            take the IPreferenceStore to get the stored values.
	 */
	public BracketSet(ISourceViewer sourceViewer, String extension) {
		bracketPairs = new ArrayList<BracketPair>();
		// TODO hoang-kim is this call really necessary?
		new ColorManager();
		if (sourceViewer != null) {
			viewer = sourceViewer;
			textWidget = viewer.getTextWidget();
		}
		preferenceStore = EMFTextRuntimeUIPlugin.getDefault().getPreferenceStore();
		language = extension;
		if (sourceViewer != null && preferenceStore != null) {
			resetBrackets();
			addListeners();
		}
	}

	/**
	 * Check whether the string is the open bracket.
	 * 
	 * @param text the text to check
	 * @return <code>true</code> if text is an opening bracket. E.g. to decide to
	 *         search forward or backward.
	 */
	public boolean isOpen(String text) {
		for (BracketPair bracketPair : bracketPairs) {
			if (text.equals(bracketPair.open())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check whether the string is a bracket.
	 * 
	 * @param text the text to check
	 * @return <code>true</code> if it exists in the bracket set.
	 */
	public boolean isBracket(String text) {
		for (BracketPair bracketPair : bracketPairs) {
			if (text.equals(bracketPair.open()) || text.equals(bracketPair.close())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds the bracket pair to this bracket set.
	 * 
	 * @param open the open bracket
	 * @param close the close bracket
	 * @return <code>true</code> if successful
	 */
	public boolean addBracketPair(String open, String close) {
		if (isBracket(open) || isBracket(close)) {
			return false;
		}
		bracketPairs.add(new BracketPair(open, close));
		return true;
	}

	/**
	 * Removes all bracket pairs from this bracket set, reloading 
	 * the default bracket set.
	 * 
	 * @return <code>true</code> if successful.
	 */
	public boolean resetBrackets() {
		String bStore = preferenceStore.getString(language + PreferenceConstants.EDITOR_BRACKETS_SUFFIX);
		if (bStore == null || bStore.equals("")) {
			return false;
		}
		setBrackets(bStore);
		return true;
	}

	/**
	 * @param bracket
	 *            one part of a bracket pair
	 * @return the other part
	 */
	public String getCounterpart(String bracket) {
		for (BracketPair bracketPair : bracketPairs) {
			if (bracket.equals(bracketPair.open())) {
				return bracketPair.close();
			}
			if (bracket.equals(bracketPair.close())) {
				return bracketPair.open();
			}
		}
		return null;
	}

	public int size() {
		return bracketPairs.size();
	}

	/**
	 * Removes the bracket pair at the given index.
	 * 
	 * @param index the index of a bracket pair
	 * @return a String array of the bracket pair
	 */
	public String[] removeAt(int index) {
		BracketPair b = bracketPairs.remove(index);
		if (b != null) {
			return new String[] { b.open(), b.close() };
		}
		return null;
	}

	/**
	 * Removes the given bracket pair.
	 * 
	 * @param open the opening bracket
	 * @param close the closing bracket
	 * @return <code>true</code> if removed successfully
	 */
	public boolean remove(String open, String close) {
		for (BracketPair bracketPair : bracketPairs) {
			if (bracketPair.open().equals(open) && bracketPair.close().equals(close)) {
				bracketPairs.remove(bracketPair);
				return true;
			}
		}
		return false;
	}

	/**
	 * Take a String array in the form {"{ and }",...}
	 * 
	 * @param bracketsAsArray
	 *            brackets
	 */
	public void removeBracketPairs(String bracketsAsArray[]) {
		for (String bracket : bracketsAsArray) {
			String[] tmp = bracket.split(" and ");
			remove(tmp[0], tmp[1]);
		}
	}

	/**
	 * Remove the old bracket set and set the given bracket set.
	 * 
	 * @param bracketsString
	 *            bracket set
	 * @return <code>true</code> if successful
	 */
	public boolean setBrackets(String bracketsString) {
		if (bracketsString.length() % 2 != 0 || bracketsString.equals("")) {
			return false;
		}
		bracketPairs = new ArrayList<BracketPair>();
		for (int i = 0; i < bracketsString.length() / 2; i++) {
			addBracketPair("" + bracketsString.charAt(i * 2), "" + bracketsString.charAt(i * 2 + 1));
		}
		return true;
	}

	/**
	 * Get a String[] of brackets.
	 * 
	 * @return String[] of brackets like {"{ and }","( )"}.
	 */
	public String[] getBracketStringArray() {
		String[] ret = new String[bracketPairs.size()];
		int i = 0;
		for (BracketPair bracketPair : bracketPairs) {
			// TODO introduce constant for " and "
			ret[i] = bracketPair.open() + " and " + bracketPair.close();
			i++;
		}
		return ret;
	}

	/**
	 * @return String
	 */
	public String getBracketString() {
		if (bracketPairs.size() < 1) {
			return "";
		}
		String result = "";
		for (BracketPair bracketPair : bracketPairs) {
			result += bracketPair.open() + bracketPair.close();
		}
		return result;
	}

	private void addListeners() {
		ClosingListener fClosingListener = new ClosingListener();
		textWidget.addVerifyListener(fClosingListener);
		textWidget.addVerifyKeyListener(fClosingListener);
		textWidget.addModifyListener(fClosingListener);
	}

	public void matchingBrackets() {
		IDocument doc = viewer.getDocument();
		ProjectionViewer projectionViewer = null;
		if (viewer instanceof ProjectionViewer) {
			projectionViewer = (ProjectionViewer) viewer;
		}
		if (doc == null) {
			return;
		}
		int caretOffset = textWidget.getCaretOffset();
		if (projectionViewer != null) {
			caretOffset = projectionViewer.widgetOffset2ModelOffset(caretOffset);
		}
		final String prevStr;
		try {
			prevStr = "" + doc.getChar(caretOffset - 1);
		} catch (BadLocationException e) {
			e.printStackTrace();
			return;
		}
		if (!isBracket(prevStr) || prevStr.equals(getCounterpart(prevStr))) {
			return;
		}
		boolean isForward = isOpen(prevStr);
		final String toFindStr = getCounterpart(prevStr);
		int boundary = isForward ? doc.getLength() : -1;
		int position = isForward ? caretOffset : caretOffset - 2;
		String currentStr;
		int count = 0;
		try {
			while (position != boundary) {
				currentStr = "" + doc.getChar(position);
				if (toFindStr.equals(currentStr) && count == 0) {
					break;
				} else if (prevStr.equals(currentStr)) {
					count++;
				} else if (currentStr.equals(toFindStr)) {
					count--;
				}
				position += isForward ? 1 : -1;
			}
		} catch (BadLocationException e) {
			e.printStackTrace();
			return;
		}
		if (position != -1 && position != doc.getLength()) {
			doc.addPositionCategory(ExtensionConstants.POSITION_CATEGORY_BRACKET);
			try {
				doc.addPosition(ExtensionConstants.POSITION_CATEGORY_BRACKET, new Position(position, 1));
				doc.addPosition(ExtensionConstants.POSITION_CATEGORY_BRACKET, new Position(caretOffset - 1, 1));
			} catch (BadLocationException e) {
				e.printStackTrace();
			} catch (BadPositionCategoryException e) {
				e.printStackTrace();
			}
		}
	}
}

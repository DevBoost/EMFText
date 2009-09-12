/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.runtime.ui.extensions;

import java.util.ArrayList;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.emftext.runtime.resource.IBracketPair;
import org.emftext.runtime.ui.EMFTextRuntimeUIPlugin;
import org.emftext.runtime.ui.preferences.PreferenceConstants;

/**
 * A container for all bracket pairs.
 * 
 * @author Tan-Ky Hoang-Kim
 */
public class BracketSet {

	// the separator between a bracket pair, should not contain escape needed
	// character, it will be used as regular expression
	public final static String BRACKET_SEPARATOR = " and ";
	private final static PositionHelper positionHelper = new PositionHelper();

	private ArrayList<IBracketPair> bracketPairs;
	private ISourceViewer viewer;
	private String languageID;
	private StyledText textWidget;
	private IPreferenceStore preferenceStore;

	/**
	 * A single pair of brackets.
	 */
	private class BracketPair implements IBracketPair {

		private final String[] brackets;
		private boolean closingEnabledInside;

		public BracketPair(String opening, String closing, boolean closingEnabledInside) {
			brackets = new String[] { opening, closing };
			this.closingEnabledInside = closingEnabledInside;
		}

		public String getClosingBracket() {
			return brackets[1];
		}

		public String getOpeningBracket() {
			return brackets[0];
		}

		public boolean isClosingEnabledInside() {// false to test
			return closingEnabledInside;
		}
		
		public void setClosingEnabledInside(boolean closingEnabledInside) {
			this.closingEnabledInside=closingEnabledInside;
		}
	}

	/**
	 * A listener for the automatic closing.
	 */
	private class ClosingListener implements VerifyListener, ModifyListener, VerifyKeyListener {
		private int closingLength = -1;
		private int addedPosition = -1;
		private boolean closingAdded = false;
		private boolean isEmbraced = false;
		private String closing;

		/**
		 * Automatic closing will be activated if the text about to insert is a
		 * bracket.
		 * 
		 * @see org.eclipse.swt.events.VerifyListener#verifyText(org.eclipse.swt.events.VerifyEvent)
		 */
		public void verifyText(VerifyEvent e) {
			int caret = textWidget.getCaretOffset();
			if (!isOpeningBracket(e.text)) {
				return;
			}
			if (caret > 0 && caret < textWidget.getCharCount()) {
				IBracketPair bracketPair = getBracketPair(
						textWidget.getTextRange(caret - 1, 1), 
						textWidget.getTextRange(caret, 1));
				if (bracketPair != null
						&& !bracketPair.isClosingEnabledInside())
					return;
			}
			closingAdded = true;
			closing = getCounterpart(e.text);
			e.text += closing;
			closingLength = closing.length();
		}

		/**
		 * After a change there are two cases which have to be considered:
		 * <ul>
		 * <li>if an automatic closing happened the caret will be set between
		 * the bracket pair</li>
		 * <li>if a bracket opening is deleted on the left side of the caret the
		 * bracket closing on the right side of this caret is deleted as well</li>
		 * </ul>
		 */
		public void modifyText(ModifyEvent e) {
			if (closingAdded) {
				closingAdded = false;
				addedPosition = textWidget.getCaretOffset() - closingLength;
				textWidget.setCaretOffset(addedPosition);
				closingLength = -1;
			}
			if (isEmbraced) {
				isEmbraced = false;
				textWidget.replaceTextRange(textWidget.getCaretOffset(), 1, "");
			}
		}

		/**
		 * This is for the Backspace key, if you want to delete a previous
		 * character.
		 * 
		 * @see org.eclipse.swt.custom.VerifyKeyListener#verifyKey(org.eclipse.swt.events.VerifyEvent)
		 */
		public void verifyKey(VerifyEvent e) {
			int caretOffset = textWidget.getCaretOffset();
			int caret = caretOffset;
			// Discard the closing bracket if there is one
			if (closing != null && closing.equals("" + e.character) && addedPosition == caret) {
				e.doit = false;
				textWidget.setCaretOffset(caret + 1);
			}
			closing = null;
			addedPosition = -1;
			
			if (caret == 0 || e.keyCode != SWT.BS || caret == textWidget.getCharCount()) {
				return;
			}
			String prevStr = textWidget.getTextRange(caretOffset - 1, 1);
			String nextStr = textWidget.getTextRange(caretOffset, 1);
			if (e.keyCode == SWT.BS && isOpeningBracket(prevStr) && getCounterpart(prevStr).equals(nextStr)) {
				isEmbraced = true;
			}
		}
	}

	/**
	 * Creates a bracket set to manage the bracket pairs.
	 * 
	 * @param sourceViewer
	 *            the source viewer for matching brackets
	 * @param extension
	 *            the file extension of the DSL
	 */
	public BracketSet(ISourceViewer sourceViewer, String extension) {
		languageID = extension;
		this.bracketPairs = new ArrayList<IBracketPair>();
		if (sourceViewer != null) {
			viewer = sourceViewer;
			textWidget = viewer.getTextWidget();
		}
		preferenceStore = EMFTextRuntimeUIPlugin.getDefault().getPreferenceStore();
		if (sourceViewer != null && preferenceStore != null) {
			resetBrackets();
			addListeners();
		}
	}

	/**
	 * Checks whether the given string is an open bracket.
	 * 
	 * @param bracket
	 *            the bracket part to check
	 * @return <code>true</code> if text is an opening bracket. E.g. to decide
	 *         to search forward or backward
	 */
	public boolean isOpeningBracket(String bracket) {
		for (IBracketPair bracketPair : bracketPairs) {
			if (bracket.equals(bracketPair.getOpeningBracket())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks whether the string is a bracket.
	 * 
	 * @param bracket
	 *            the text to check
	 * @return <code>true</code> if it exists in the bracket set.
	 */
	public boolean isBracket(String bracket) {
		for (IBracketPair bracketPair : bracketPairs) {
			if (bracket.equals(bracketPair.getOpeningBracket()) || bracket.equals(bracketPair.getClosingBracket())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the bracket pair with the given opening and closing.
	 * 
	 * @param opening the opening string
	 * @param closing the closing string
	 * 
	 * @return a bracket pair
	 */
	public IBracketPair getBracketPair(String opening, String closing) {
		for (IBracketPair bracketPair : bracketPairs) {
			if (bracketPair.getOpeningBracket().equals(opening) && bracketPair.getClosingBracket().equals(closing)) {
				return bracketPair;
			}
		}
		return null;
	}
	
	public IBracketPair getBracketPair(int index) {
		try {
			return bracketPairs.get(index);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Adds the bracket pair to this bracket set.
	 * 
	 * @param opening
	 *            the opening bracket
	 * @param closing
	 *            the closing bracket
	 * @return <code>true</code> if successful
	 */
	public boolean addBracketPair(String opening, String closing, boolean closingEnabledInside) {
		if (isBracket(opening) || isBracket(closing)) {
			return false;
		}
		bracketPairs.add(new BracketPair(opening, closing, closingEnabledInside));
		return true;
	}
	
	/**
	 * Sets whether other bracket pairs shall be automatically closed, when used inside of this bracket pair.
	 * @param bracketPair the bracket pair to change
	 * @return <code>true</code> if successful
	 */
	public boolean setClosingEnabledInside(IBracketPair bracketPair, boolean closingEnabledInside) {
		if (bracketPair instanceof BracketPair) {
			((BracketPair) bracketPair).setClosingEnabledInside(closingEnabledInside);
			return true;
		}
		return false;
	}

	/**
	 * Removes all bracket pairs from this bracket set, reload the bracket set
	 * from the preference store.
	 * 
	 * @return <code>true</code> if successful
	 * @see IPreferenceStore
	 */
	public boolean resetBrackets() {
		String bracketPairs = preferenceStore.getString(languageID + PreferenceConstants.EDITOR_BRACKETS_SUFFIX);
		if (bracketPairs == null) {
			return false;
		}
		setBrackets(bracketPairs);
		return true;
	}

	/**
	 * Gets the counter part of a bracket.
	 * 
	 * @param bracket
	 *            one part of a bracket pair
	 * @return the other part. If the given <code>String</code> is not a bracket
	 *         return <code>null</code>
	 */
	public String getCounterpart(String bracket) {
		for (IBracketPair bracketPair : bracketPairs) {
			if (bracket.equals(bracketPair.getOpeningBracket())) {
				return bracketPair.getClosingBracket();
			}
			if (bracket.equals(bracketPair.getClosingBracket())) {
				return bracketPair.getOpeningBracket();
			}
		}
		return null;
	}

	/**
	 * @return the count of bracket pairs in this bracket set
	 */
	public int size() {
		return bracketPairs.size();
	}

	/**
	 * Removes the given bracket pair.
	 * 
	 * @param opening the opening bracket
	 * @param closing the closing bracket
	 * 
	 * @return the removed bracket pair. If there was none null is returned
	 */
	public IBracketPair remove(String opening, String closing) {
		for (IBracketPair bracketPair : bracketPairs) {
			if (bracketPair.getOpeningBracket().equals(opening) && bracketPair.getClosingBracket().equals(closing)) {
				bracketPairs.remove(bracketPair);
				return bracketPair;
			}
		}
		return null;
	}

	/**
	 * Removes brackets.
	 * 
	 * @param bracketsAsArray
	 *            a list of bracket pairs in the form
	 *            <code>String[]{"{BRACKET_SEPARATOR",...}</code> .
	 */
	public void removeBracketPairs(String bracketsAsArray[]) {
		for (String bracket : bracketsAsArray) {
			String[] tmp = bracket.split(BRACKET_SEPARATOR);
			remove(tmp[0], tmp[1]);
		}
	}

	/**
	 * Removes the old bracket set and set the given bracket set. It is useful
	 * to take a stored <code>String</code> in a preference store. A bracket pair
	 * contains of opening, closing and isClosingEnabledInside = {'1','0')
	 * 
	 * @param bracketSet
	 *            the bracket set as a <code>String</code> in the form "()0<>0[]1",
	 *            it has to have a length == 3*n
	 * @return <code>true</code> if successful
	 */
	public boolean setBrackets(String bracketSet) {
		if (bracketSet.length() % 3 != 0) {
			return false;
		}
		bracketPairs = new ArrayList<IBracketPair>();
		for (int i = 0; i < bracketSet.length() / 3; i++) {
			addBracketPair("" + bracketSet.charAt(i * 3), "" + bracketSet.charAt(i * 3 + 1), bracketSet.charAt(i * 3 + 2) != '0');
		}
		return true;
	}

	/**
	 * Gets a list of bracket pairs. This call is for the list in the preference page.
	 * 
	 * @return a list of bracket pairs in the form
	 *         <code>String[]{"{BRACKET_SEPARATOR}","(BRACKET_SEPARATOR)"}</code>
	 *         .
	 */
	public String[] getBracketArray() {
		String[] ret = new String[bracketPairs.size()];
		int i = 0;
		for (IBracketPair bracketPair : bracketPairs) {
			ret[i] = bracketPair.getOpeningBracket() + BRACKET_SEPARATOR + bracketPair.getClosingBracket();
			i++;
		}
		return ret;
	}

	/**
	 * Gets this bracket set as <code>String</code>. It is useful to store in
	 * the <code>IPreferenceStore</code>.
	 * 
	 * @return String the bracket set in the form "()<>[]"
	 * @see IPreferenceStore
	 */
	public String getBracketString() {
		if (bracketPairs.size() < 1) {
			return "";
		}
		String result = "";
		for (IBracketPair bracketPair : bracketPairs) {
			String isClosingStr = "0";
			if (bracketPair.isClosingEnabledInside()) {
				isClosingStr = "1";
			}
			result += bracketPair.getOpeningBracket() + bracketPair.getClosingBracket() + isClosingStr;
		}
		return result;
	}

	/**
	 * Adds listeners to a {@link StyledText} to handle bracket automatic
	 * closing.
	 */
	private void addListeners() {
		ClosingListener closingListener = new ClosingListener();
		textWidget.addVerifyListener(closingListener);
		textWidget.addVerifyKeyListener(closingListener);
		textWidget.addModifyListener(closingListener);
	}

	/**
	 * Searches the matching bracket at the left side of the caret. The position
	 * information will be stored in the <code>IDocument</code> in the category
	 * <code>ExtensionConstants.PositionCategory.BRACKET</code>.
	 * 
	 * @see IDocument
	 * @see Position
	 */
	public void matchingBrackets() {
		IDocument document = viewer.getDocument();
		ProjectionViewer projectionViewer = null;
		if (viewer instanceof ProjectionViewer) {
			projectionViewer = (ProjectionViewer) viewer;
		}
		if (document == null) {
			return;
		}
		int caretOffset = textWidget.getCaretOffset();
		if (projectionViewer != null) {
			caretOffset = projectionViewer.widgetOffset2ModelOffset(caretOffset);
		}
		final String prevStr;
		if (caretOffset == 0) {
			return;
		}
		try {
			prevStr = "" + document.getChar(caretOffset - 1);
		} catch (BadLocationException e) {
			e.printStackTrace();
			return;
		}
		if (!isBracket(prevStr) || prevStr.equals(getCounterpart(prevStr))) {
			return;
		}
		boolean isForward = isOpeningBracket(prevStr);
		final String toFindStr = getCounterpart(prevStr);
		int boundary = isForward ? document.getLength() : -1;
		int position = isForward ? caretOffset : caretOffset - 2;
		String currentStr;
		int count = 0;
		try {
			while (position != boundary) {
				currentStr = "" + document.getChar(position);
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
		if (position != -1 && position != document.getLength()) {
			positionHelper.addPosition(document, PositionCategory.BRACKET.toString(), position, 1);
			positionHelper.addPosition(document, PositionCategory.BRACKET.toString(), caretOffset - 1, 1);
		}
	}
}

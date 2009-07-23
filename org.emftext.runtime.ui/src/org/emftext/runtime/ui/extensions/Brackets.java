/**
 * 
 */
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

//TODO mseifert: align this class with the EMFText coding style
/**
 * @author BluAngel Provide Brackets for EMFTextEditor.
 */
public class Brackets {

	/**
	 * @author BluAngel Is a bracket element
	 */
	private class Bracket {

		private String[] bracket;

		public Bracket(String open, String close) {
			bracket = new String[] { open, close };
		}

		public String open() {
			return bracket[0];
		}

		public String close() {
			return bracket[1];
		}
	}

	private final class ClosingListener implements VerifyListener,
			ModifyListener, VerifyKeyListener {
		private int closingLength = -1;
		private boolean closingAdded = false;
		private boolean isEmbraced = false;

		/*
		 * (non-Javadoc) Automatical closing will be activated if the text about
		 * to insert is a bracket, and the next character in TextWidget is not a
		 * ".
		 * 
		 * @see
		 * org.eclipse.swt.events.VerifyListener#verifyText(org.eclipse.swt.
		 * events.VerifyEvent)
		 */
		public void verifyText(VerifyEvent e) {
			if (isOpen(e.text)
					&& (text.getCaretOffset()==text.getCharCount()
					|| !text.getTextRange(text.getCaretOffset(), 1).matches(
							"[\"\']"))) {
				closingAdded = true;
				String close = getCounterpart(e.text);
				e.text += close;
				closingLength = close.length();
			}
		}

		public void modifyText(ModifyEvent e) {
			if (closingAdded) {
				closingAdded = false;
				text.setCaretOffset(text.getCaretOffset() - closingLength);
				closingLength = -1;
			}
			if (isEmbraced) {
				isEmbraced = false;
				text.replaceTextRange(text.getCaretOffset(), 1, "");
			}
		}

		/*
		 * (non-Javadoc) This is for the Backspace key, if you want to delete a
		 * previous character.
		 * 
		 * @see
		 * org.eclipse.swt.custom.VerifyKeyListener#verifyKey(org.eclipse.swt
		 * .events.VerifyEvent)
		 */
		public void verifyKey(VerifyEvent e) {
			int caret = text.getCaretOffset();
			if (caret == 0||e.keyCode != SWT.BS||caret == text.getCharCount())
				return;
			String prevStr = text.getTextRange(text.getCaretOffset() - 1, 1);
			String nextStr = text.getTextRange(text.getCaretOffset(), 1);
			if (e.keyCode == SWT.BS && isOpen(prevStr)&& getCounterpart(prevStr).equals(nextStr)) {
				isEmbraced = true;
			}

		}

	}

	private List<Bracket> brackets;
	private ISourceViewer viewer;
	private StyledText text;
	private IPreferenceStore store;
	private String language;
	
	/**
	 * @param sourceviewer
	 *            take the ISourceViewer to handle the TextWidget of the
	 *            EMFTextEditor.
	 * @param ps
	 *            take the IPreferenceStore to get the stored values.
	 */
	public Brackets(ISourceViewer sourceviewer, String extension) {
		brackets = new ArrayList<Bracket>();
		new ColorManager();
		if (sourceviewer != null) {
			viewer = sourceviewer;
			text = viewer.getTextWidget();
		}
		store = EMFTextRuntimeUIPlugin.getDefault().getPreferenceStore();
		language=extension;
		if (sourceviewer != null && store != null) {
			resetBrackets();
			addListeners();
		}
	}

	/**
	 * Check whether this String is the open bracket.
	 * 
	 * @param open
	 *            bracket
	 * @return <code>true</code> if it is a open bracket. E.g. to decide to
	 *         search forward or backward.
	 */
	public boolean isOpen(String open) {
		for (Bracket b : brackets) {
			if (open.equals(b.open()))
				return true;
		}
		return false;
	}

	/**
	 * Check whether this String is assigned as a bracket.
	 * 
	 * @param bracket
	 *            part
	 * @return <code>true</code> if it exists in the bracket set.
	 */
	public boolean isBracket(String bracket) {
		for (Bracket b : brackets) {
			if (bracket.equals(b.open()) || bracket.equals(b.close()))
				return true;
		}
		return false;
	}

	/**
	 * Add this bracket to the bracket set.
	 * 
	 * @param open
	 *            the open bracket
	 * @param close
	 *            the close bracket
	 * @return <code>true</code> if successful
	 */
	public boolean add(String open, String close) {
		if (isBracket(open) || isBracket(close))
			return false;
		brackets.add(new Bracket(open, close));
		return true;
	}

	/**
	 * Remove the old bracket set, reload the current bracket set.
	 * 
	 * @return <code>true</code> if successful.
	 */
	public boolean resetBrackets() {
		String bStore=store.getString(language
				+ PreferenceConstants.EDITOR_BRACKETS_SUFFIX);
		if (bStore==null||bStore.equals(""))
			return false;
		setBrackets(bStore);
		return true;
	}

	/**
	 * @param bracket
	 *            one part of a bracket pair
	 * @return the other part
	 */
	public String getCounterpart(String bracket) {
		for (Bracket b : brackets) {
			if (bracket.equals(b.open()))
				return b.close();
			if (bracket.equals(b.close()))
				return b.open();
		}
		return null;
	}

	public int size() {
		return brackets.size();
	}

	/**
	 * Remove the bracket pair at this specific index.
	 * 
	 * @param idx
	 *            the index of a bracket pair
	 * @return a String array of the bracket pair
	 */
	public String[] removeAt(int idx) {
		Bracket b = brackets.remove(idx);
		if (b != null)
			return new String[] { b.open(), b.close() };
		return null;
	}

	/**
	 * Remove this bracket pair.
	 * 
	 * @param open
	 *            bracket
	 * @param close
	 *            bracket
	 * @return <code>true</code> if remove successfully
	 */
	public boolean remove(String open, String close) {
		for (Bracket b : brackets) {
			if (b.open().equals(open) && b.close().equals(close)) {
				brackets.remove(b);
				return true;
			}
		}
		return false;
	}

	/**
	 * Take a String array in the form {"{ and }",...}
	 * 
	 * @param br
	 *            brackets
	 */
	public void removeBrackets(String br[]) {
		for (String b : br) {
			String[] tmp = b.split(" and ");
			remove(tmp[0], tmp[1]);
		}
	}

	/**
	 * Remove the old bracket set and set the given bracket set.
	 * 
	 * @param bracketsStr
	 *            bracket set
	 * @return <code>true</code> if successful
	 */
	public boolean setBrackets(String bracketsStr) {
		if (bracketsStr.length() % 2 != 0 || bracketsStr.equals(""))
			return false;
		brackets = new ArrayList<Bracket>();
		for (int i = 0; i < bracketsStr.length() / 2; i++) {
			add("" + bracketsStr.charAt(i * 2), ""
					+ bracketsStr.charAt(i * 2 + 1));
		}
		return true;
	}

	/**
	 * Get a String[] of brackets.
	 * 
	 * @return String[] of brackets like {"{ and }","( )"}.
	 */
	public String[] getBracketStringArray() {
		String[] ret = new String[brackets.size()];
		int i = 0;
		for (Bracket b : brackets) {
			ret[i] = b.open() + " and " + b.close();
			i++;
		}
		return ret;
	}

	/**
	 * @return String
	 */
	public String getBracketString() {
		if (brackets.size() < 1)
			return "";
		String ret = "";
		for (Bracket b : brackets) {
			ret += b.open() + b.close();
		}
		return ret;
	}

	private void addListeners() {
		ClosingListener fClosingListener = new ClosingListener();
		text.addVerifyListener(fClosingListener);
		text.addVerifyKeyListener(fClosingListener);
		text.addModifyListener(fClosingListener);
	}

	public void matchingBrackets() {
		IDocument doc = viewer.getDocument();
		ProjectionViewer pviewer=null;
		if (viewer instanceof ProjectionViewer) 
			pviewer=(ProjectionViewer)viewer;
		if (doc == null)
			return;
		int caret = text.getCaretOffset();
		if (pviewer!=null)
			caret = pviewer.widgetOffset2ModelOffset(caret);
		final String prevStr;
		try {
			prevStr = "" + doc.getChar(caret - 1);
		} catch (BadLocationException e) {
			e.printStackTrace();
			return;
		}
		if (!isBracket(prevStr) || prevStr.equals(getCounterpart(prevStr)))
			return;
		boolean isForward = isOpen(prevStr);
		final String toFindStr = getCounterpart(prevStr);
		int boundary = isForward ? doc.getLength() : -1;
		int pos = isForward ? caret : caret - 2;
		String currentStr;
		int count = 0;
		try {
			while (pos != boundary) {
				currentStr = "" + doc.getChar(pos);
				if (toFindStr.equals(currentStr) && count == 0)
					break;
				else if (prevStr.equals(currentStr))
					count++;
				else if (currentStr.equals(toFindStr))
					count--;
				pos += isForward ? 1 : -1;
			}
		} catch (BadLocationException e) {
			e.printStackTrace();
			return;
		}
		if (pos != -1 && pos != doc.getLength()) {
			doc.addPositionCategory(ExtensionConstants.POSITION_CATEGORY_BRACKET);
			try {
				doc.addPosition(ExtensionConstants.POSITION_CATEGORY_BRACKET, new Position(pos,1));
				doc.addPosition(ExtensionConstants.POSITION_CATEGORY_BRACKET, new Position(caret-1,1));
			} catch (BadLocationException e) {
				e.printStackTrace();
			} catch (BadPositionCategoryException e) {
				e.printStackTrace();
			}
		}
	}
}

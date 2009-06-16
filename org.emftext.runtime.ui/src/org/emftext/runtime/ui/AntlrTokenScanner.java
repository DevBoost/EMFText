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
package org.emftext.runtime.ui;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Token;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.ui.preferences.PreferenceConstants;

/**
 * An adapter from the Eclipse <code>ITokenScanner</code> interface
 * to the ANTLR <code>Lexer</code> interface.
 */
public class AntlrTokenScanner implements ITokenScanner {
    
	private final static TokenHelper tokenHelper = new TokenHelper();
	
    private Lexer lexer;
    private Token current;
    private String[] tokenNames;
    private String languageId;
    private IPreferenceStore store;
    private ColorManager colorManager;
    private int offset = 0;
    
    /**
     * @param resource The <code>ITextResource</code> from which the <code>Lexer</code> can be determined.
     * @param fileExtension The file extension for which this instance should be used for coloring
     * @param colorManager A manager to obtain color objects
     */
    public AntlrTokenScanner(ITextResource resource, String fileExtension, ColorManager colorManager) {
        this.lexer      = (Lexer) resource.getScanner();
        this.tokenNames = resource.getMetaInformation().getTokenNames();
        this.languageId = fileExtension;
        this.store      = EMFTextRuntimeUIPlugin.getDefault().getPreferenceStore();
        this.colorManager = colorManager;
    }

    public int getTokenLength() {
        return ((CommonToken)current).getStopIndex() - ((CommonToken)current).getStartIndex() + 1;
    }

    public int getTokenOffset() {
        return offset + ((CommonToken)current).getStartIndex();
    }

    public IToken nextToken() {
        current = lexer.nextToken();
        
        if (!tokenHelper.canBeUsedForSyntaxColoring(current)) {
            return org.eclipse.jface.text.rules.Token.EOF;
        }

        TextAttribute ta = null;

        String tokenName = tokenHelper.getTokenName(tokenNames, current.getType());
        if (tokenName != null) {
	        String prefix = languageId + "_" + tokenName;
	        if (store.getBoolean(prefix + PreferenceConstants.EDITOR_ENABLE_SUFFIX)) {
	            String colorKey = prefix + PreferenceConstants.EDITOR_COLOR_SUFFIX;
				Color color = colorManager.getColor(PreferenceConverter.getColor(store, colorKey));
	            int style = SWT.NORMAL;
	
	            if (store.getBoolean(prefix + PreferenceConstants.EDITOR_BOLD_SUFFIX)) {
	                style = style | SWT.BOLD;
	            }
	            if (store.getBoolean(prefix + PreferenceConstants.EDITOR_ITALIC_SUFFIX)) {
	                style = style | SWT.ITALIC;
	            }
	            if (store.getBoolean(prefix + PreferenceConstants.EDITOR_STRIKETHROUGH_SUFFIX)) {
	                style = style | TextAttribute.STRIKETHROUGH;
	            }
	            if (store.getBoolean(prefix + PreferenceConstants.EDITOR_UNDERLINE_SUFFIX)) {
	                style = style | TextAttribute.UNDERLINE;
	            }
	            
	            ta = new TextAttribute(color, null, style);
	
	        }
        }
        
        //potential performance improvement for large files in the future:
        //build a map of tokens and reuse them instead of creating new ones
        return new org.eclipse.jface.text.rules.Token(ta);
    }

    public void setRange(IDocument document, int offset, int length) {
        this.offset = offset;
        try {
            lexer.setCharStream(new ANTLRStringStream(document.get(offset, length)));
        } catch (BadLocationException e) {
            EMFTextRuntimePlugin.logError("Unexpected error:", e);
        }
    }

}

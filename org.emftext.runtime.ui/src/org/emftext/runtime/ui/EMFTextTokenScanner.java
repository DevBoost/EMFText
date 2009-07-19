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
import org.emftext.runtime.resource.ITextLexer;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.ITextToken;
import org.emftext.runtime.ui.preferences.SyntaxColoringHelper;
import org.emftext.runtime.ui.preferences.SyntaxColoringHelper.StyleProperty;

/**
 * An adapter from the Eclipse <code>ITokenScanner</code> interface
 * to the EMFText <code>ITextLexer</code> interface.
 * 
 * TODO once this class is generated we might not need
 * ITextResourcePluginMetaInformation.createLexer() anymore
 */
public class EMFTextTokenScanner implements ITokenScanner {
    
    private ITextLexer lexer;
    private ITextToken currentToken;
    private int offset;
    private String languageId;
    private IPreferenceStore store;
    private ColorManager colorManager;

    /**
     * @param resource The <code>ITextResource</code> from which the <code>Lexer</code> can be determined.
     * @param fileExtension The file extension for which this instance should be used for coloring
     * @param colorManager A manager to obtain color objects
     */
    public EMFTextTokenScanner(ITextResource resource, ColorManager colorManager) {
        this.lexer      = resource.getMetaInformation().createLexer();
        this.languageId = resource.getMetaInformation().getSyntaxName();
        this.store      = EMFTextRuntimeUIPlugin.getDefault().getPreferenceStore();
        this.colorManager = colorManager;
    }

    public int getTokenLength() {
    	return currentToken.getLength();
    }

    public int getTokenOffset() {
        return offset + currentToken.getOffset();
    }

    public IToken nextToken() {
        currentToken = lexer.getNextToken();

        if (currentToken == null || !currentToken.canBeUsedForSyntaxHighlighting()) {
            return org.eclipse.jface.text.rules.Token.EOF;
        }

        TextAttribute ta = null;

        String tokenName = currentToken.getName();
        if (tokenName != null) {
	        String enableKey = SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, StyleProperty.ENABLE);
	        if (store.getBoolean(enableKey)) {
	            String colorKey = SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, StyleProperty.COLOR);
				Color color = colorManager.getColor(PreferenceConverter.getColor(store, colorKey));
	            int style = SWT.NORMAL;
	
	            if (store.getBoolean(SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, StyleProperty.BOLD))) {
	                style = style | SWT.BOLD;
	            }
	            if (store.getBoolean(SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, StyleProperty.ITALIC))) {
	                style = style | SWT.ITALIC;
	            }
	            if (store.getBoolean(SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, StyleProperty.STRIKETHROUGH))) {
	                style = style | TextAttribute.STRIKETHROUGH;
	            }
	            if (store.getBoolean(SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, StyleProperty.UNDERLINE))) {
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
        	lexer.setText(document.get(offset, length));
        } catch (BadLocationException e) {
            EMFTextRuntimePlugin.logError("Unexpected error:", e);
        }
    }
}

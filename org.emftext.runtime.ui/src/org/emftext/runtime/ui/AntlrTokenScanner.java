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
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.ui.preferences.PreferenceConstants;

public class AntlrTokenScanner implements ITokenScanner {
    
    private Lexer lexer;
    private Token current;
    private String[] tokenNames;
    private String languageId;
    private IPreferenceStore store;
    private ColorManager colorManager;
    private int offset = 0;
    
    public AntlrTokenScanner(ITextResource resource, String fileExtension, ColorManager colorManager) {
        this.lexer      = (Lexer) resource.getScanner();
        this.tokenNames = resource.getTokenNames();
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
        
        //TODO when do up and down occur??
        if (current.getType() == Token.EOF || current.getType() == Token.UP || current.getType() == Token.DOWN) {
            return org.eclipse.jface.text.rules.Token.EOF;
        }
        if (current.getType() == 4) {
            return org.eclipse.jface.text.rules.Token.WHITESPACE;
        } 
        if (current.getType() < 6) {
            return org.eclipse.jface.text.rules.Token.UNDEFINED;
        }
 
        //TODO build a map of tokens and reuse them instead of creating new ones
        String tt     = tokenNames[current.getType()];
        if (tt.startsWith("'"))
            tt = tt.substring(1,tt.length()-1).trim();
        String prefix = languageId + "_" + tt;
        
        TextAttribute ta = null;
        if (store.getBoolean(prefix + PreferenceConstants.EDITOR_ENABLE_SUFFIX)) {
            Color color = colorManager.getColor(PreferenceConverter.getColor(store,prefix + PreferenceConstants.EDITOR_COLOR_SUFFIX));
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
            
            ta = new TextAttribute(color,null,style);

        }
        return new org.eclipse.jface.text.rules.Token(ta);
        
        //TODO parser errors 
    }

    public void setRange(IDocument document, int offset, int length) {
        this.offset = offset;
        try {
            lexer.setCharStream(new ANTLRStringStream(document.get(offset, length)));
        } catch (BadLocationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

package lpg.runtime;

public interface IToken
{
    public static final char EOF = '\uffff';

    public int getKind();
    public void setKind(int kind);

    public int getStartOffset();
    public void setStartOffset(int startOffset);

    public int getEndOffset();
    public void setEndOffset(int endOffset);

    public int getTokenIndex();
    public void setTokenIndex(int i);
    
    public int getAdjunctIndex();
    public void setAdjunctIndex(int i);
    
    public IToken[] getPrecedingAdjuncts();
    public IToken[] getFollowingAdjuncts();

    public ILexStream getILexStream();
    /**
     * @deprecated replaced by {@link #getILexStream()}
     */
    public ILexStream getLexStream();
    
    public IPrsStream getIPrsStream();
    /**
     * @deprecated replaced by {@link #getIPrsStream()}
     */
    public IPrsStream getPrsStream();
    
    public int getLine();
    public int getColumn();
    public int getEndLine();
    public int getEndColumn();

    /**
     * @deprecated replaced by toString()
     */
    public abstract String getValue(char[] inputChars);

    public abstract String toString();
}

/*
 * Created on 30. aug.. 2006
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU General Public License, v2
 */
package org.spoofax.interpreter.terms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



public interface ITermFactory extends IStrategoTermBuilder {

    public IStrategoTerm parseFromFile(String path) throws IOException;
    public IStrategoTerm parseFromStream(InputStream inputStream) throws IOException;
    public IStrategoTerm parseFromString(String text);
    public void unparseToFile(IStrategoTerm t, OutputStream ous) throws IOException;

    public IStrategoAppl replaceAppl(IStrategoConstructor constructor, IStrategoTerm[] kids, IStrategoAppl old);
    public IStrategoList replaceList(IStrategoTerm[] kids, IStrategoList old);
    public IStrategoTuple replaceTuple(IStrategoTerm[] kids, IStrategoTuple old);

}

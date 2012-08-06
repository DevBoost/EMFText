/*
 * Created on 30. aug.. 2006
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU General Public License, v2
 */
package org.spoofax.interpreter.terms;

public interface IStrategoConstructor extends IStrategoTerm {

    @Deprecated
    public IStrategoAppl instantiate(ITermFactory factory, IStrategoTerm... kids);
    @Deprecated
    public IStrategoAppl instantiate(ITermFactory factory, IStrategoList kids);

    public String getName();
    public int getArity();

}

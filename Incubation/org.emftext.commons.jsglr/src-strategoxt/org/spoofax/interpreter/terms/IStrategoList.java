/*
 * Created on 30. aug.. 2006
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU General Public License, v2
 */
package org.spoofax.interpreter.terms;


public interface IStrategoList extends IStrategoTerm {

    public IStrategoTerm get(int index);

    public int size();

    /**
     * @deprecated Use
     *             {@link IStrategoTermBuilder#makeListCons(IStrategoTerm, IStrategoList)}
     *             instead.
     */
    @Deprecated
    public IStrategoList prepend(IStrategoTerm prefix);

    public IStrategoTerm head();

    // FIXME this should go into the factory -- it may be a builder
    public IStrategoList tail();

    public boolean isEmpty();

}

/*
 * Created on 08.aug.2005
 *
 * Copyright (c) 2005, Karl Trygve Kalleberg <karltk near strategoxt.org>
 * 
 * Licensed under the GNU General Public License, v2
 */
package org.spoofax.interpreter.terms;

import java.util.Collection;


public interface IStrategoTermBuilder {
    
    public IStrategoConstructor makeConstructor(String string, int arity);

    // TODO: Remove makeAppl() and makeList() overloads to avoid accidental invocation
    
    /**
     * @deprecated Use {@link #makeAppl(IStrategoConstructor, IStrategoTerm...)} instead.
     */
    @Deprecated
    public IStrategoAppl makeAppl(IStrategoConstructor ctr, IStrategoList kids);
    public IStrategoAppl makeAppl(IStrategoConstructor ctr, IStrategoTerm... terms);

    public IStrategoInt makeInt(int i);
    public IStrategoReal makeReal(double d);
    public IStrategoTuple makeTuple(IStrategoTerm... terms);
    public IStrategoString makeString(String s);
    public IStrategoList makeList(IStrategoTerm... terms);
    public IStrategoList makeList(Collection<IStrategoTerm> terms);

    /**
     * @deprecated Use {@link #makeListCons(IStrategoTerm, IStrategoList)} instead. 
     */
    @Deprecated
    public IStrategoList makeList(IStrategoTerm head, IStrategoList tail);
    public IStrategoList makeListCons(IStrategoTerm head, IStrategoList tail);
    
    public IStrategoTerm annotateTerm(IStrategoTerm term, IStrategoList annotations);

    public boolean hasConstructor(String ctorName, int arity);
    
}



package org.spoofax.interpreter.terms;




public interface IStrategoAppl extends IStrategoTerm {

    public IStrategoConstructor getConstructor();
    public IStrategoTerm[] getArguments();

}

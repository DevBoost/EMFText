package org.spoofax.jsglr;

/**
 * @author Lennart Kats <lennart add lclnet.nl>
 * 
 * @see SGLR#setRecoverHandler(RecoverAlgorithm)
 */
public final class StructureRecoveryAlgorithm extends NoRecovery {
    
    private final IRecoveryParser recoverer;
    
    public StructureRecoveryAlgorithm() {
        this(null);
    }
    
    public StructureRecoveryAlgorithm(IRecoveryParser recoverer) {
        this.recoverer = recoverer;
    }
    
    
    @Override
    public void initialize(SGLR parser) {
        parser.setUseStructureRecovery(true, recoverer);
    }
}

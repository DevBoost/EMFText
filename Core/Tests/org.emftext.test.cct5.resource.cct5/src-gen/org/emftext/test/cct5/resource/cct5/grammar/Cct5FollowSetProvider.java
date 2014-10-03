/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.grammar;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * This class provides the follow sets for all terminals of the grammar. These
 * sets are used during code completion.
 */
public class Cct5FollowSetProvider {
	
	public final static org.emftext.test.cct5.resource.cct5.ICct5ExpectedElement TERMINALS[] = new org.emftext.test.cct5.resource.cct5.ICct5ExpectedElement[16];
	
	public final static EStructuralFeature[] FEATURES = new EStructuralFeature[4];
	
	public final static org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[] LINKS = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[12];
	
	public final static org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[] EMPTY_LINK_ARRAY = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[0];
	
	public static void initializeTerminals0() {
		TERMINALS[0] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedCsString(org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_0_0_0_0);
		TERMINALS[1] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedCsString(org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_0_0_0_1);
		TERMINALS[2] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedCsString(org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_1_0_0_0);
		TERMINALS[3] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedCsString(org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_2_0_0_0);
		TERMINALS[4] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedCsString(org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_0_0_0_4);
		TERMINALS[5] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedStructuralFeature(org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_1_0_0_1);
		TERMINALS[6] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedCsString(org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_1_0_0_2);
		TERMINALS[7] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedCsString(org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_1_0_0_3);
		TERMINALS[8] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedStructuralFeature(org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_3_0_0_0);
		TERMINALS[9] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedCsString(org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_1_0_0_5);
		TERMINALS[10] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedStructuralFeature(org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_2_0_0_1);
		TERMINALS[11] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedCsString(org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_2_0_0_2);
		TERMINALS[12] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedCsString(org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_2_0_0_3);
		TERMINALS[13] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedCsString(org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_2_0_0_5);
		TERMINALS[14] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedCsString(org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_3_0_0_1_0_0_0);
		TERMINALS[15] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedStructuralFeature(org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_3_0_0_1_0_0_1);
	}
	
	public static void initializeTerminals() {
		initializeTerminals0();
	}
	
	public static void initializeFeatures0() {
		FEATURES[0] = org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarm().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.FARM__FARMER);
		FEATURES[1] = org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarmer().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.FARMER__DIET);
		FEATURES[2] = org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarm().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.FARM__ANIMAL);
		FEATURES[3] = org.emftext.test.cct5.Cct5Package.eINSTANCE.getAnimal().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.ANIMAL__FEEDING_INSTRUCTION);
	}
	
	public static void initializeFeatures() {
		initializeFeatures0();
	}
	
	public static void initializeLinks0() {
		LINKS[0] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature(org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarmer(), FEATURES[0]);
		LINKS[1] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature(org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarmer(), FEATURES[0]);
		LINKS[2] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature(org.emftext.test.cct5.Cct5Package.eINSTANCE.getAnimal(), FEATURES[2]);
		LINKS[3] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature(org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarmer(), FEATURES[0]);
		LINKS[4] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature(org.emftext.test.cct5.Cct5Package.eINSTANCE.getAnimal(), FEATURES[2]);
		LINKS[5] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature(org.emftext.test.cct5.Cct5Package.eINSTANCE.getAnimal(), FEATURES[2]);
		LINKS[6] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature(org.emftext.test.cct5.Cct5Package.eINSTANCE.getAnimal(), FEATURES[2]);
		LINKS[7] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature(org.emftext.test.cct5.Cct5Package.eINSTANCE.getDiet(), FEATURES[1]);
		LINKS[8] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature(org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarmer(), FEATURES[0]);
		LINKS[9] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature(org.emftext.test.cct5.Cct5Package.eINSTANCE.getAnimal(), FEATURES[2]);
		LINKS[10] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature(org.emftext.test.cct5.Cct5Package.eINSTANCE.getDiet(), FEATURES[3]);
		LINKS[11] = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature(org.emftext.test.cct5.Cct5Package.eINSTANCE.getAnimal(), FEATURES[2]);
	}
	
	public static void initializeLinks() {
		initializeLinks0();
	}
	
	public static void wire0() {
		TERMINALS[0].addFollower(TERMINALS[1], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[2], new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[] {new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature(org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarmer(), FEATURES[0]), });
		TERMINALS[2].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
		TERMINALS[5].addFollower(TERMINALS[6], EMPTY_LINK_ARRAY);
		TERMINALS[6].addFollower(TERMINALS[7], EMPTY_LINK_ARRAY);
		TERMINALS[7].addFollower(TERMINALS[8], new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[] {new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature(org.emftext.test.cct5.Cct5Package.eINSTANCE.getDiet(), FEATURES[1]), });
		TERMINALS[9].addFollower(TERMINALS[2], new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[] {new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature(org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarmer(), FEATURES[0]), });
		TERMINALS[9].addFollower(TERMINALS[3], new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[] {new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature(org.emftext.test.cct5.Cct5Package.eINSTANCE.getAnimal(), FEATURES[2]), });
		TERMINALS[9].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[3].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[10].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[11].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[12].addFollower(TERMINALS[8], new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[] {new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature(org.emftext.test.cct5.Cct5Package.eINSTANCE.getDiet(), FEATURES[3]), });
		TERMINALS[13].addFollower(TERMINALS[3], new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[] {new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature(org.emftext.test.cct5.Cct5Package.eINSTANCE.getAnimal(), FEATURES[2]), });
		TERMINALS[13].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[8].addFollower(TERMINALS[14], EMPTY_LINK_ARRAY);
		TERMINALS[8].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[8].addFollower(TERMINALS[13], EMPTY_LINK_ARRAY);
		TERMINALS[14].addFollower(TERMINALS[15], EMPTY_LINK_ARRAY);
		TERMINALS[15].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[15].addFollower(TERMINALS[13], EMPTY_LINK_ARRAY);
	}
	
	public static void wire() {
		wire0();
	}
	
	static {
		// initialize the arrays
		initializeTerminals();
		initializeFeatures();
		initializeLinks();
		// wire the terminals
		wire();
	}
}

/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.grammar;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

public class Cct5GrammarInformationProvider {
	
	public final static EStructuralFeature ANONYMOUS_FEATURE = EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static Cct5GrammarInformationProvider INSTANCE = new Cct5GrammarInformationProvider();
	
	private Set<String> keywords;
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword CCT5_0_0_0_0 = INSTANCE.getCCT5_0_0_0_0();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword getCCT5_0_0_0_0() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword("Farm", org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword CCT5_0_0_0_1 = INSTANCE.getCCT5_0_0_0_1();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword getCCT5_0_0_0_1() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword("{", org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Containment CCT5_0_0_0_2_0_0_0 = INSTANCE.getCCT5_0_0_0_2_0_0_0();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Containment getCCT5_0_0_0_2_0_0_0() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Containment(org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarm().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.FARM__FARMER), org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE, new EClass[] {org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarmer(), }, 0);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Sequence CCT5_0_0_0_2_0_0 = INSTANCE.getCCT5_0_0_0_2_0_0();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Sequence getCCT5_0_0_0_2_0_0() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Sequence(org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE, CCT5_0_0_0_2_0_0_0);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice CCT5_0_0_0_2_0 = INSTANCE.getCCT5_0_0_0_2_0();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice getCCT5_0_0_0_2_0() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice(org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE, CCT5_0_0_0_2_0_0);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Compound CCT5_0_0_0_2 = INSTANCE.getCCT5_0_0_0_2();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Compound getCCT5_0_0_0_2() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Compound(CCT5_0_0_0_2_0, org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.PLUS);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Containment CCT5_0_0_0_3_0_0_0 = INSTANCE.getCCT5_0_0_0_3_0_0_0();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Containment getCCT5_0_0_0_3_0_0_0() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Containment(org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarm().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.FARM__ANIMAL), org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE, new EClass[] {org.emftext.test.cct5.Cct5Package.eINSTANCE.getAnimal(), }, 0);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Sequence CCT5_0_0_0_3_0_0 = INSTANCE.getCCT5_0_0_0_3_0_0();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Sequence getCCT5_0_0_0_3_0_0() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Sequence(org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE, CCT5_0_0_0_3_0_0_0);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice CCT5_0_0_0_3_0 = INSTANCE.getCCT5_0_0_0_3_0();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice getCCT5_0_0_0_3_0() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice(org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE, CCT5_0_0_0_3_0_0);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Compound CCT5_0_0_0_3 = INSTANCE.getCCT5_0_0_0_3();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Compound getCCT5_0_0_0_3() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Compound(CCT5_0_0_0_3_0, org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.STAR);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword CCT5_0_0_0_4 = INSTANCE.getCCT5_0_0_0_4();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword getCCT5_0_0_0_4() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword("}", org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Sequence CCT5_0_0_0 = INSTANCE.getCCT5_0_0_0();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Sequence getCCT5_0_0_0() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Sequence(org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE, CCT5_0_0_0_0, CCT5_0_0_0_1, CCT5_0_0_0_2, CCT5_0_0_0_3, CCT5_0_0_0_4);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice CCT5_0_0 = INSTANCE.getCCT5_0_0();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice getCCT5_0_0() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice(org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE, CCT5_0_0_0);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Rule CCT5_0 = INSTANCE.getCCT5_0();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Rule getCCT5_0() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Rule(org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarm(), CCT5_0_0, org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword CCT5_1_0_0_0 = INSTANCE.getCCT5_1_0_0_0();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword getCCT5_1_0_0_0() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword("BEGIN_FARMER", org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Placeholder CCT5_1_0_0_1 = INSTANCE.getCCT5_1_0_0_1();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Placeholder getCCT5_1_0_0_1() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Placeholder(org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarmer().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.FARMER__NAME), "TEXT", org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE, 0);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword CCT5_1_0_0_2 = INSTANCE.getCCT5_1_0_0_2();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword getCCT5_1_0_0_2() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword("Diet", org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword CCT5_1_0_0_3 = INSTANCE.getCCT5_1_0_0_3();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword getCCT5_1_0_0_3() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword(":", org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Containment CCT5_1_0_0_4 = INSTANCE.getCCT5_1_0_0_4();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Containment getCCT5_1_0_0_4() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Containment(org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarmer().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.FARMER__DIET), org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE, new EClass[] {org.emftext.test.cct5.Cct5Package.eINSTANCE.getDiet(), }, 0);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword CCT5_1_0_0_5 = INSTANCE.getCCT5_1_0_0_5();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword getCCT5_1_0_0_5() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword("END_FARMER", org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Sequence CCT5_1_0_0 = INSTANCE.getCCT5_1_0_0();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Sequence getCCT5_1_0_0() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Sequence(org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE, CCT5_1_0_0_0, CCT5_1_0_0_1, CCT5_1_0_0_2, CCT5_1_0_0_3, CCT5_1_0_0_4, CCT5_1_0_0_5);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice CCT5_1_0 = INSTANCE.getCCT5_1_0();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice getCCT5_1_0() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice(org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE, CCT5_1_0_0);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Rule CCT5_1 = INSTANCE.getCCT5_1();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Rule getCCT5_1() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Rule(org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarmer(), CCT5_1_0, org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword CCT5_2_0_0_0 = INSTANCE.getCCT5_2_0_0_0();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword getCCT5_2_0_0_0() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword("BEGIN_ANIMAL", org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Placeholder CCT5_2_0_0_1 = INSTANCE.getCCT5_2_0_0_1();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Placeholder getCCT5_2_0_0_1() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Placeholder(org.emftext.test.cct5.Cct5Package.eINSTANCE.getAnimal().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.ANIMAL__NAME), "TEXT", org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE, 0);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword CCT5_2_0_0_2 = INSTANCE.getCCT5_2_0_0_2();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword getCCT5_2_0_0_2() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword("FeedingInstruction", org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword CCT5_2_0_0_3 = INSTANCE.getCCT5_2_0_0_3();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword getCCT5_2_0_0_3() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword(":", org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Containment CCT5_2_0_0_4 = INSTANCE.getCCT5_2_0_0_4();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Containment getCCT5_2_0_0_4() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Containment(org.emftext.test.cct5.Cct5Package.eINSTANCE.getAnimal().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.ANIMAL__FEEDING_INSTRUCTION), org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE, new EClass[] {org.emftext.test.cct5.Cct5Package.eINSTANCE.getDiet(), }, 0);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword CCT5_2_0_0_5 = INSTANCE.getCCT5_2_0_0_5();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword getCCT5_2_0_0_5() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword("END_ANIMAL", org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Sequence CCT5_2_0_0 = INSTANCE.getCCT5_2_0_0();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Sequence getCCT5_2_0_0() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Sequence(org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE, CCT5_2_0_0_0, CCT5_2_0_0_1, CCT5_2_0_0_2, CCT5_2_0_0_3, CCT5_2_0_0_4, CCT5_2_0_0_5);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice CCT5_2_0 = INSTANCE.getCCT5_2_0();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice getCCT5_2_0() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice(org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE, CCT5_2_0_0);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Rule CCT5_2 = INSTANCE.getCCT5_2();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Rule getCCT5_2() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Rule(org.emftext.test.cct5.Cct5Package.eINSTANCE.getAnimal(), CCT5_2_0, org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Placeholder CCT5_3_0_0_0 = INSTANCE.getCCT5_3_0_0_0();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Placeholder getCCT5_3_0_0_0() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Placeholder(org.emftext.test.cct5.Cct5Package.eINSTANCE.getDiet().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.DIET__TYPE), "TEXT", org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE, 0);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword CCT5_3_0_0_1 = INSTANCE.getCCT5_3_0_0_1();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword getCCT5_3_0_0_1() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword("with", org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Placeholder CCT5_3_0_0_2_0_0_0 = INSTANCE.getCCT5_3_0_0_2_0_0_0();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Placeholder getCCT5_3_0_0_2_0_0_0() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Placeholder(org.emftext.test.cct5.Cct5Package.eINSTANCE.getDiet().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.DIET__FAVORITE_DISH), "QUOTED_34_34", org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE, 0);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword CCT5_3_0_0_2_0_0_1 = INSTANCE.getCCT5_3_0_0_2_0_0_1();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword getCCT5_3_0_0_2_0_0_1() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword("as favorite dish", org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Sequence CCT5_3_0_0_2_0_0 = INSTANCE.getCCT5_3_0_0_2_0_0();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Sequence getCCT5_3_0_0_2_0_0() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Sequence(org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE, CCT5_3_0_0_2_0_0_0, CCT5_3_0_0_2_0_0_1);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice CCT5_3_0_0_2_0 = INSTANCE.getCCT5_3_0_0_2_0();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice getCCT5_3_0_0_2_0() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice(org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE, CCT5_3_0_0_2_0_0);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Compound CCT5_3_0_0_2 = INSTANCE.getCCT5_3_0_0_2();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Compound getCCT5_3_0_0_2() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Compound(CCT5_3_0_0_2_0, org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Sequence CCT5_3_0_0 = INSTANCE.getCCT5_3_0_0();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Sequence getCCT5_3_0_0() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Sequence(org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE, CCT5_3_0_0_0, CCT5_3_0_0_1, CCT5_3_0_0_2);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice CCT5_3_0 = INSTANCE.getCCT5_3_0();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice getCCT5_3_0() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Choice(org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE, CCT5_3_0_0);
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Rule CCT5_3 = INSTANCE.getCCT5_3();
	private org.emftext.test.cct5.resource.cct5.grammar.Cct5Rule getCCT5_3() {
		return new org.emftext.test.cct5.resource.cct5.grammar.Cct5Rule(org.emftext.test.cct5.Cct5Package.eINSTANCE.getDiet(), CCT5_3_0, org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality.ONE);
	}
	
	
	public static String getSyntaxElementID(org.emftext.test.cct5.resource.cct5.grammar.Cct5SyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (Field field : org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.class.getFields()) {
			Object fieldValue;
			try {
				fieldValue = field.get(null);
				if (fieldValue == syntaxElement) {
					String id = field.getName();
					return id;
				}
			} catch (Exception e) { }
		}
		return null;
	}
	
	public static org.emftext.test.cct5.resource.cct5.grammar.Cct5SyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (org.emftext.test.cct5.resource.cct5.grammar.Cct5SyntaxElement) org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static org.emftext.test.cct5.resource.cct5.grammar.Cct5Rule[] RULES = new org.emftext.test.cct5.resource.cct5.grammar.Cct5Rule[] {
		CCT5_0,
		CCT5_1,
		CCT5_2,
		CCT5_3,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new LinkedHashSet<String>();
			for (org.emftext.test.cct5.resource.cct5.grammar.Cct5Rule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(org.emftext.test.cct5.resource.cct5.grammar.Cct5SyntaxElement element, Set<String> keywords) {
		if (element instanceof org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword) {
			keywords.add(((org.emftext.test.cct5.resource.cct5.grammar.Cct5Keyword) element).getValue());
		} else if (element instanceof org.emftext.test.cct5.resource.cct5.grammar.Cct5BooleanTerminal) {
			keywords.add(((org.emftext.test.cct5.resource.cct5.grammar.Cct5BooleanTerminal) element).getTrueLiteral());
			keywords.add(((org.emftext.test.cct5.resource.cct5.grammar.Cct5BooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof org.emftext.test.cct5.resource.cct5.grammar.Cct5EnumerationTerminal) {
			org.emftext.test.cct5.resource.cct5.grammar.Cct5EnumerationTerminal terminal = (org.emftext.test.cct5.resource.cct5.grammar.Cct5EnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (org.emftext.test.cct5.resource.cct5.grammar.Cct5SyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}

/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.test.printing.test;

import org.emftext.test.printing.M1;
import org.emftext.test.printing.M10;
import org.emftext.test.printing.M11;
import org.emftext.test.printing.M12;
import org.emftext.test.printing.M13;
import org.emftext.test.printing.M14;
import org.emftext.test.printing.M16;
import org.emftext.test.printing.M17;
import org.emftext.test.printing.M17a;
import org.emftext.test.printing.M18;
import org.emftext.test.printing.M19;
import org.emftext.test.printing.M20;
import org.emftext.test.printing.M21;
import org.emftext.test.printing.M22;
import org.emftext.test.printing.M28;
import org.emftext.test.printing.M29;
import org.emftext.test.printing.M3;
import org.emftext.test.printing.M30;
import org.emftext.test.printing.M31;
import org.emftext.test.printing.M33;
import org.emftext.test.printing.M34;
import org.emftext.test.printing.M35;
import org.emftext.test.printing.M36;
import org.emftext.test.printing.M37;
import org.emftext.test.printing.M4;
import org.emftext.test.printing.M40;
import org.emftext.test.printing.M41;
import org.emftext.test.printing.M42;
import org.emftext.test.printing.M43SubA;
import org.emftext.test.printing.M43SubB;
import org.emftext.test.printing.M5;
import org.emftext.test.printing.M6;
import org.emftext.test.printing.PrintingFactory;
import org.emftext.test.printing.T1M1;
import org.emftext.test.printing.T1M2SubA;
import org.emftext.test.printing.T1M2SubB;
import org.emftext.test.printing.T1M2SubC;

public class Printer2Test extends AbstractPrintingTestCase {

	private final static PrintingFactory FACTORY = PrintingFactory.eINSTANCE;

	public void testT1() {
		T1M1 t1m1 = FACTORY.createT1M1();
		T1M2SubA t1subA = FACTORY.createT1M2SubA();
		T1M2SubB t1subB = FACTORY.createT1M2SubB();
		T1M2SubC t1subC = FACTORY.createT1M2SubC();
		
		t1m1.getM2s().add(t1subA);
		t1m1.getM2s().add(t1subB);
		t1m1.getM2s().add(t1subC);
		
		assertPrinting(t1m1, 
				"t1m1{a t1m2a b t1m2b c t1m2c}", 
				"t1m1 { a t1m2a b t1m2b c t1m2c }", 
				false
			);
	}
	
	public void testM42() {
		M42 m42 = FACTORY.createM42();
		
		M43SubA m43a = FACTORY.createM43SubA();
		M43SubB m43b = FACTORY.createM43SubB();
		
		m42.getM43s().add(m43a);
		m42.getM43s().add(m43b);
		
		assertPrinting(m42, 
			"m42{m43a,m43b}", 
			"m42 { m43a , m43b }",
			false
		);
	}
	
	public void testM40() {
		M40 m40 = FACTORY.createM40();
		assertPrinting(
				m40, 
				"m40{" + NEW_LINE + "}", 
				"m40 {" + NEW_LINE + "}"
		);
		
		M41 m41 = FACTORY.createM41();
		m40.getContainment().add(m41);

		assertPrinting(
				m40, 
				"m40{" + NEW_LINE +
				"\t" + "m41{" + NEW_LINE +
				"\t" + "}" + NEW_LINE +
				"}", 
				"m40 {" + NEW_LINE +
				"\t" + "m41 {" + NEW_LINE +
				"\t" + "}" + NEW_LINE +
				"}"
		);
	}

	public void testM36() {
		M36 m36 = FACTORY.createM36();
		M37 m37a = FACTORY.createM37();
		m37a.setM38(FACTORY.createM38());
		M37 m37b = FACTORY.createM37();
		m37b.setM38(FACTORY.createM38());
		M37 m37c = FACTORY.createM37();
		m37c.setM38(FACTORY.createM38());
		m36.getM37().add(m37a);
		m36.getM37().add(m37b);
		m36.getM37().add(m37c);
		
		String expected = "m36" + NEW_LINE +
			"\tm37 m38," + NEW_LINE + 
			"\tm37 m38," + NEW_LINE + 
			"\tm37 m38,";
		assertPrinting(m36, expected, expected.replace(",", " ,"));
	}

	public void testM35() {
		M35 m35 = FACTORY.createM35();
		m35.getContainments().add(FACTORY.createM35SubConcreteA());
		m35.getContainments().add(FACTORY.createM35SubConcreteB());
		// the old printer cannot handle subclass restrictions correctly
		assertPrinting(m35, "m35 m35a,m35b", "m35 m35a , m35b", false);
	}

	public void testM34() {
		M34 m34 = FACTORY.createM34();
		m34.getContainments().add(FACTORY.createM1());
		m34.getContainments().add(FACTORY.createM1());
		assertPrinting(m34, "m34 m1,m1", "m34 m1 , m1");
	}

	public void testM33() {
		String expected = "m33" + NEW_LINE + "m1";
		M33 m33 = FACTORY.createM33();
		m33.setContainment(FACTORY.createM1());
		assertPrinting(m33, expected, expected);
	}

	public void testM32() {
		String expected = "m32a" + NEW_LINE + NEW_LINE + "m32b";
		assertPrinting(FACTORY.createM32(), expected, expected);
	}

	public void testM31() {
		M31 a = FACTORY.createM31();
		a.setName("na");
		M31 b1 = FACTORY.createM31();
		b1.setName("nb1");
		M31 b2 = FACTORY.createM31();
		b2.setName("nb2");
		M31 c = FACTORY.createM31();
		c.setName("nc");
		
		a.getContainments().add(b1);
		a.getContainments().add(b2);
		b1.getContainments().add(c);
		
		String expectedFromSmart = 
			"m31{" + NEW_LINE + 
			"\t" + "na" + NEW_LINE + 
			"\t" + "m31{" + NEW_LINE + 
			"\t" + "\t" + "nb1" + NEW_LINE + 
			"\t" + "\t" + "m31{" + NEW_LINE + 
			"\t" + "\t" + "\t" + "nc" + NEW_LINE + 
			"\t" + "\t" + "}" + NEW_LINE + 
			"\t" + "}" + NEW_LINE + 
			"\t" + "m31{" + NEW_LINE + 
			"\t" + "\t" + "nb2" + NEW_LINE + 
			"\t" + "}" + NEW_LINE + 
			"}" 
			;
		String expectedFromBasic = expectedFromSmart.replace("m31{", "m31 {");
		assertPrinting(a, expectedFromSmart, expectedFromBasic, false);
	}

	public void testM1() {
		assertPrinting(FACTORY.createM1(), "m1", "m1");
	}

	public void testM2() {
		assertPrinting(FACTORY.createM2(), "m2a m2b", "m2a m2b");
	}

	public void testM3() {
		M3 m3 = FACTORY.createM3();
		m3.setName("myName");
		assertPrinting(m3, "m3 myName", "m3 myName");
	}

	public void testM4() {
		M4 m4 = FACTORY.createM4();
		m4.getNames().add("name1");
		m4.getNames().add("name2");
		m4.getNames().add("name3");
		assertPrinting(m4, "m4 name1 name2 name3", "m4 name1 name2 name3");
	}

	public void testM5() {
		M5 m5 = FACTORY.createM5();
		m5.getNames().add("name1");
		m5.getNames().add("name2");
		m5.getNames().add("name3");
		assertPrinting(m5, "m5 name1,name2,name3,", "m5 name1 , name2 , name3 ,");
	}

	public void testM6() {
		M6 m6 = FACTORY.createM6();
		m6.getNames().add("name1");
		m6.getNames().add("name2");
		m6.getNames().add("name3");
		assertPrinting(m6, "m6 name1,name2,name3", "m6 name1 , name2 , name3");
	}

	public void testM7() {
		assertPrinting(FACTORY.createM7(), "m7a", "m7a");
	}

	public void testM8() {
		assertPrinting(FACTORY.createM8(), "m8a", "m8a");
	}

	public void testM9() {
		assertPrinting(FACTORY.createM9(), "m9a m9b", "m9a m9b");
	}

	public void testM10() {
		M10 m10 = FACTORY.createM10();
		m10.setName("name");
		m10.setReference(m10);
		assertPrinting(m10, "m10 name ->name", "m10 name -> name");
	}

	public void testM11() {
		M1 m1 = FACTORY.createM1();
		
		M11 m11 = FACTORY.createM11();
		m11.setContainment(m1);
		assertPrinting(m11, "m11 m1", "m11 m1");
	}

	public void testM12() {
		M1 m1a = FACTORY.createM1();
		M1 m1b = FACTORY.createM1();
		
		M12 m12 = FACTORY.createM12();
		m12.getContainments().add(m1a);
		m12.getContainments().add(m1b);
		assertPrinting(m12, "m12 m1 m1", "m12 m1 m1");
	}

	public void testM13() {
		M1 m1a = FACTORY.createM1();
		M1 m1b = FACTORY.createM1();
		
		M13 m13 = FACTORY.createM13();
		m13.getContainments().add(m1a);
		m13.getContainments().add(m1b);
		assertPrinting(m13, "m13 m1,m1,", "m13 m1 , m1 ,");
	}

	public void testM14() {
		M1 m1a = FACTORY.createM1();
		M1 m1b = FACTORY.createM1();
		
		M14 m14 = FACTORY.createM14();
		m14.getContainments().add(m1a);
		m14.getContainments().add(m1b);
		assertPrinting(m14, "m14 m1,m1", "m14 m1 , m1");
	}

	public void testM15() {
		assertPrinting(FACTORY.createM15(), "m15a  m15b", "m15a  m15b");
	}

	public void testM16() {
		M16 m16 = FACTORY.createM16();
		m16.getNames().add("name1");
		m16.getNames().add("name2");
		m16.getNames().add("name3");
		assertPrinting(m16, "m16 name1   name2   name3", "m16 name1   name2   name3");
	}

	public void testM17() {
		M17 m17 = FACTORY.createM17();
		m17.getNames().add("name1");
		m17.getNames().add("name2");
		m17.getNames().add("name3");
		assertPrinting(m17, 
				"m17" + NEW_LINE + "\tname1" + NEW_LINE + "\tname2" + NEW_LINE + "\tname3",
				"m17" + NEW_LINE + "\tname1" + NEW_LINE + "\tname2" + NEW_LINE + "\tname3"
		);
	}

	public void testM17a() {
		M17a m17a = FACTORY.createM17a();
		m17a.getContainments().add(FACTORY.createM17b());
		m17a.getContainments().add(FACTORY.createM17b());
		m17a.getContainments().add(FACTORY.createM17b());
		assertPrinting(m17a, 
				"m17a{" + NEW_LINE + "\tm17b" + NEW_LINE + "\tm17b" + NEW_LINE + "\tm17b}",
				"m17a {" + NEW_LINE + "\tm17b" + NEW_LINE + "\tm17b" + NEW_LINE + "\tm17b }"
		);
	}

	public void testM18() {
		M18 m18 = FACTORY.createM18();
		assertPrinting(m18, "m18a", "m18a");
	}

	public void testM19() {
		M19 m19 = FACTORY.createM19();
		m19.getNames().add("name1");
		m19.getNames().add("name2");
		m19.getNames().add("name3");
		assertPrinting(
			m19, 
			"m19 name1,name2,name3", 
			"m19 name1 , name2 , name3"
		);
	}

	public void testM20() {
		M20 m20 = FACTORY.createM20();
		assertPrinting(m20, "m20a m20b", "m20a m20b");
		
		m20.getNames().add("name1");
		m20.getNames().add("name2");
		assertPrinting(
			m20, 
			"m20a name1 name2 m20b", 
			"m20aname1name2 m20b", 
			false);
	}

	public void testM21() {
		M21 m21 = FACTORY.createM21();
		m21.getNames().add("name1");
		assertPrinting(m21, "name1", "name1");

		m21.getNames().add("name2");
		assertPrinting(m21, "name1.name2", "name1 . name2");
	}

	public void testM22() {
		M22 m22 = FACTORY.createM22();
		assertPrinting(m22, "[]", "[ ]");

		m22.getNames().add("name1");
		assertPrinting(m22, "[name1]", "[ name1 ]");
	}

	public void testM28() {
		M28 m28 = FACTORY.createM28();
		assertPrinting(m28, "m28 a", "m28 a");
		
		m28.getNames().add("name1");
		m28.getNames().add("name2");
		assertPrinting(m28, "m28 name1 name2", "m28 name1 name2", false);
	}

	public void testM29() {
		M29 m29 = FACTORY.createM29();
		assertPrinting(m29, "m29 a", "m29 a");
		
		m29.getNames().add("name1");
		m29.getNames().add("name2");
		assertPrinting(m29, "m29 name1 name2", "m29 name1 name2", false);
	}

	public void testM30() {
		M30 m30 = FACTORY.createM30();
		
		m30.getA().add("a1");
		m30.getA().add("a2");
		
		m30.getB().add("b1");
		
		m30.getC().add("c1");
		m30.getC().add("c2");
		m30.getC().add("c3");
		
		String expected = "m30 a a1 a a2 b b1 c c1 c c2 c c3";
		assertPrinting(m30, expected, expected, true);
	}
}

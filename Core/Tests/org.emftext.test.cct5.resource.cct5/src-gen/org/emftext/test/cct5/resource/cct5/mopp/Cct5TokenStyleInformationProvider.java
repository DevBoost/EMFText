/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;


public class Cct5TokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public org.emftext.test.cct5.resource.cct5.ICct5TokenStyle getDefaultTokenStyle(String tokenName) {
		if ("Farm".equals(tokenName)) {
			return new org.emftext.test.cct5.resource.cct5.mopp.Cct5TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("BEGIN_FARMER".equals(tokenName)) {
			return new org.emftext.test.cct5.resource.cct5.mopp.Cct5TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Diet".equals(tokenName)) {
			return new org.emftext.test.cct5.resource.cct5.mopp.Cct5TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("END_FARMER".equals(tokenName)) {
			return new org.emftext.test.cct5.resource.cct5.mopp.Cct5TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("BEGIN_ANIMAL".equals(tokenName)) {
			return new org.emftext.test.cct5.resource.cct5.mopp.Cct5TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("FeedingInstruction".equals(tokenName)) {
			return new org.emftext.test.cct5.resource.cct5.mopp.Cct5TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("END_ANIMAL".equals(tokenName)) {
			return new org.emftext.test.cct5.resource.cct5.mopp.Cct5TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("favored".equals(tokenName)) {
			return new org.emftext.test.cct5.resource.cct5.mopp.Cct5TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_34_34".equals(tokenName)) {
			return new org.emftext.test.cct5.resource.cct5.mopp.Cct5TokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new org.emftext.test.cct5.resource.cct5.mopp.Cct5TokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}

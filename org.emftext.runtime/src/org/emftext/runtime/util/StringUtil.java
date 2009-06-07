/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.runtime.util;

/**
 * A utility class that provides some common methods to work
 * with Strings.
 */
public class StringUtil {

	 /**
     * Capitalizes the first letter of the given string.
     * 
     * @param text a string.
     * @return the modified string.
     */
    public static String capitalize(String text) {
        String h = text.substring(0, 1).toUpperCase();
        String t = text.substring(1);      
        return h + t;
    }

    /**
     * Returns the part of 'tail' that is not present at the end of
     * 'text'. For example if text = 'abc' and tail = 'cd' this method
     * returns 'd'. If 'tail' can not be found at the end of 'text',
     * 'tail' is returned as is.
     * 
     * @param text
     * @param tail
     * @return
     */
    public static String getMissingTail(String text, String tail) {
		for (int i = 1; i < tail.length(); i++) {
			int endIndex = text.length();
			int end = Math.max(0, endIndex);
			int start = Math.max(0, end - i);
			String contentTail = text.substring(start, end);
			String proposalHead = tail.substring(0, i);
			if (contentTail.equals(proposalHead)) {
				return tail.substring(i);
			}
		}
		return tail;
	}
}

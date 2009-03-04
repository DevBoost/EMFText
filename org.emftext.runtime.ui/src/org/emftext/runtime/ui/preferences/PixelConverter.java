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
package org.emftext.runtime.ui.preferences;

import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Control;

import org.eclipse.jface.dialogs.Dialog;

/**
 * A utility class for pixel conversion.
 */
public class PixelConverter {
    
    private FontMetrics fFontMetrics;
    
    public PixelConverter(Control control) {
        GC gc = new GC(control);
        gc.setFont(control.getFont());
        fFontMetrics= gc.getFontMetrics();
        gc.dispose();
    }
    
    /**
     * see org.eclipse.jface.dialogs.DialogPage#convertHeightInCharsToPixels(int)
     */
    public int convertHeightInCharsToPixels(int chars) {
        return Dialog.convertHeightInCharsToPixels(fFontMetrics, chars);
    }

    /**
     * see org.eclipse.jface.dialogs.DialogPage#convertHorizontalDLUsToPixels(int)
     */
    public int convertHorizontalDLUsToPixels(int dlus) {
        return Dialog.convertHorizontalDLUsToPixels(fFontMetrics, dlus);
    }

    /**
     * see org.eclipse.jface.dialogs.DialogPage#convertVerticalDLUsToPixels(int)
     */
    public int convertVerticalDLUsToPixels(int dlus) {
        return Dialog.convertVerticalDLUsToPixels(fFontMetrics, dlus);
    }
    
    /**
     * see org.eclipse.jface.dialogs.DialogPage#convertWidthInCharsToPixels(int)
     */
    public int convertWidthInCharsToPixels(int chars) {
        return Dialog.convertWidthInCharsToPixels(fFontMetrics, chars);
    }   

}



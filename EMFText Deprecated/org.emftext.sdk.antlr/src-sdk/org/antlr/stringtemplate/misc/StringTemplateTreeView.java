/*
 [Adapted from BSD licence]
 Copyright (c) 2003-2005 Terence Parr
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package org.antlr.stringtemplate.misc;

import org.antlr.stringtemplate.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

/** This class visually illustrates a StringTemplate instance including
 *  the chunks (text + expressions) and the attributes table.  It correctly
 *  handles nested templates and so on.  A prototype really, but may prove
 *  useful for debugging StringTemplate applications.  Use it like this:
 *
 *  <pre>
 *  StringTemplate st = ...;
 *  StringTemplateTreeView viz =
 *  		new StringTemplateTreeView("sample",st);
 *  viz.setVisible(true);
 * </Pre>
 */
public class StringTemplateTreeView extends JFrame {
    // The initial width and height of the frame
    static final int WIDTH = 200;
    static final int HEIGHT = 300;

    public StringTemplateTreeView(String label, StringTemplate st) {
        super(label);

        JTreeStringTemplatePanel tp =
				new JTreeStringTemplatePanel(new JTreeStringTemplateModel(st), null);
        Container content = getContentPane();
        content.add(tp, BorderLayout.CENTER);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Frame f = (Frame)e.getSource();
                f.setVisible(false);
                f.dispose();
                // System.exit(0);
            }
        });
        setSize(WIDTH, HEIGHT);
    }

    public static void main(String args[]) {
		StringTemplateGroup group = new StringTemplateGroup("dummy");
		StringTemplate bold = group.defineTemplate("bold", "<b>$attr$</b>");
		StringTemplate banner = group.defineTemplate("banner", "the banner");
		StringTemplate st = new StringTemplate(
				group,
				"<html>\n" +  // doesn't like the first < and doesn't show :(
				"$banner(a=b)$"+
				"<p><b>$name$:$email$</b>"+
				"$if(member)$<i>$fontTag$member</font></i>$endif$"
		);
		st.setAttribute("name", "Terence");
		st.setAttribute("name", "Tom");
		st.setAttribute("email", "parrt@cs.usfca.edu");
		st.setAttribute("templateAttr", bold);
        StringTemplateTreeView frame =
				new StringTemplateTreeView("StringTemplate JTree Example", st);
        frame.setVisible(true);
    }
}

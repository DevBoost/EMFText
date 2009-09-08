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

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.emftext.runtime.ui.EMFTextRuntimeUIPlugin;

// TODO add some meaningful content to this global preference page
// maybe links to the preference pages below or a link to the web 
// site
/**
 * The root preference page for EMFText.
 * 
 * @author Tan-Ky Hoang-Kim
 */
public class EMFTextPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage{

	public void init(IWorkbench workbench) {
		setPreferenceStore(EMFTextRuntimeUIPlugin.getDefault().getPreferenceStore());
		setDescription("The fastest way to refinable, durable and evolution-resistant textual syntaxes for EMF models!");
	}
	
    @Override
    protected Control createContents(Composite parent) {
        Composite settingComposite = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        GridData gd;
        layout.numColumns= 1;
        layout.marginHeight= 0;
        layout.marginWidth= 0;
        gd = new GridData(GridData.BEGINNING);
        settingComposite.setLayout(layout);
        settingComposite.setLayoutData(gd);
		
		Link link = new Link(settingComposite, SWT.NONE);
		link.setText("Go to our <A href=\"http://st.inf.tu-dresden.de/reuseware/index.php/EMFText\">site</A> for more information.");
		link.setSize(140, 40);
		
		link.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.text.startsWith("http"));
					Program.launch(e.text);
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
        
    	return settingComposite;
    }
}

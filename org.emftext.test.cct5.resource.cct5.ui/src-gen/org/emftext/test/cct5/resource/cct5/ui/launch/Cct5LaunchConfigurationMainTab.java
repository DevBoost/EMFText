/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.ui.launch;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * <p>
 * A class that provides the main tab to parameterize launch configurations.
 * </p>
 * <p>
 * Set the overrideLaunchConfigurationMainTab option to false to customize this
 * class.
 * </p>
 */
public class Cct5LaunchConfigurationMainTab extends AbstractLaunchConfigurationTab {
	
	private Label uriLabel;
	private Text uriText;
	private Button workspaceButton;
	private Button fileSystemButton;
	
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(1, true);
		comp.setLayout(layout);
		
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		comp.setLayoutData(gd);
		
		Group group = new Group(comp, SWT.NONE);
		group.setText("Launch parameters");
		group.setLayout(new GridLayout(3, false));
		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		group.setLayoutData(gd);
		
		uriLabel = new Label(group, SWT.NONE);
		uriLabel.setText("Resource to execute:");
		gd = new GridData();
		uriLabel.setLayoutData(gd);
		
		uriText = new Text(group, SWT.SINGLE | SWT.BORDER);
		uriText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		uriText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent evt) {
				updateLaunchConfigurationDialog();
			}
		});
		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		gd.horizontalSpan = 2;
		uriText.setLayoutData(gd);
		
		workspaceButton = new Button(group, SWT.PUSH);
		workspaceButton.setText("Workspace...");
		workspaceButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				handleBrowseWorkspace();
			}
			
		});
		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.RIGHT;
		gd.horizontalSpan = 2;
		workspaceButton.setLayoutData(gd);
		
		fileSystemButton = new Button(group, SWT.PUSH);
		fileSystemButton.setText("File System...");
		fileSystemButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				handleBrowseFileSystem();
			}
			
		});
		gd = new GridData();
		gd.horizontalAlignment = SWT.RIGHT;
		fileSystemButton.setLayoutData(gd);
		
		setControl(comp);
	}
	
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}
	
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			uriText.setText(configuration.getAttribute(org.emftext.test.cct5.resource.cct5.launch.Cct5LaunchConfigurationDelegate.ATTR_RESOURCE_URI, ""));
			// more initialization code can be added here
		} catch (CoreException e) {
			org.emftext.test.cct5.resource.cct5.mopp.Cct5Plugin.logError("Can't initialize launch configuration tab.", e);
		}
	}
	
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(org.emftext.test.cct5.resource.cct5.launch.Cct5LaunchConfigurationDelegate.ATTR_RESOURCE_URI, uriText.getText());
	}
	
	public String getName() {
		return "Main";
	}
	
	@Override
	public Image getImage() {
		return org.emftext.test.cct5.resource.cct5.ui.Cct5ImageProvider.INSTANCE.getImage("icons/launch_tab_main_icon.gif");
	}
	
	protected void handleBrowseFileSystem() {
		FileDialog dialog = new FileDialog(getControl().getShell());
		dialog.setText("Select resource to launch");
		String result = dialog.open();
		if (result != null) {
			uriText.setText(URI.createFileURI(result).toString());
		}
	}
	
	protected void handleBrowseWorkspace() {
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getControl().getShell(), new WorkbenchLabelProvider(), new WorkbenchContentProvider());
		
		dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		dialog.addFilter(new ViewerFilter() {
			
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if (element instanceof IFile) {
					IFile file = (IFile) element;
					return file.getFileExtension().equals(new org.emftext.test.cct5.resource.cct5.mopp.Cct5MetaInformation().getSyntaxName());
				}
				return true;
			}
		});
		dialog.setAllowMultiple(false);
		dialog.setTitle("Select model to launch");
		dialog.setMessage("Resource to launch");
		dialog.setValidator(new ISelectionStatusValidator() {
			public IStatus validate(Object[] selection) {
				if (selection.length > 0 && selection[0] instanceof IFile)				return new Status(IStatus.OK, org.emftext.test.cct5.resource.cct5.ui.Cct5UIPlugin.PLUGIN_ID, IStatus.OK, "", null);
				
				return new Status(IStatus.ERROR, org.emftext.test.cct5.resource.cct5.ui.Cct5UIPlugin.PLUGIN_ID, IStatus.ERROR, "", null);
			}
		});
		if (dialog.open() == Window.OK) {
			IFile file = (IFile) dialog.getFirstResult();
			uriText.setText(URI.createPlatformResourceURI(file.getFullPath().makeRelative().toString(), true).toString());
		}
	}
	
}

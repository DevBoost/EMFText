/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.ui.debug;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IChildrenCountUpdate;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IChildrenUpdate;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IElementContentProvider;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IElementLabelProvider;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IHasChildrenUpdate;
import org.eclipse.debug.internal.ui.viewers.model.provisional.ILabelUpdate;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTarget;
import org.eclipse.ui.texteditor.ITextEditor;

@SuppressWarnings("restriction")
public class Cct5AdapterFactory implements IAdapterFactory {
	
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adaptableObject instanceof ITextEditor) {
			ITextEditor editorPart = (ITextEditor) adaptableObject;
			IResource resource = (IResource) editorPart.getEditorInput().getAdapter(IResource.class);
			if (resource != null) {
				String extension = resource.getFileExtension();
				if (extension != null && extension.equals(new org.emftext.test.cct5.resource.cct5.mopp.Cct5MetaInformation().getSyntaxName())) {
					return new org.emftext.test.cct5.resource.cct5.ui.Cct5UIMetaInformation().createResourceAdapter(adaptableObject, adapterType, resource);
				}
			}
		}
		if (adapterType == IElementLabelProvider.class && adaptableObject instanceof org.emftext.test.cct5.resource.cct5.debug.Cct5DebugVariable) {
			final org.emftext.test.cct5.resource.cct5.debug.Cct5DebugVariable variable = (org.emftext.test.cct5.resource.cct5.debug.Cct5DebugVariable) adaptableObject;
			return new IElementLabelProvider() {
				
				public void update(ILabelUpdate[] updates) {
					for (ILabelUpdate update : updates) {
						try {
							update.setLabel(variable.getName(), 0);
							update.setLabel(variable.getValue().getValueString(), 1);
							update.done();
						} catch (DebugException e) {
						}
					}
				}
			};
		}
		if (adapterType == IElementContentProvider.class && adaptableObject instanceof org.emftext.test.cct5.resource.cct5.debug.Cct5DebugVariable) {
			final org.emftext.test.cct5.resource.cct5.debug.Cct5DebugVariable variable = (org.emftext.test.cct5.resource.cct5.debug.Cct5DebugVariable) adaptableObject;
			return new IElementContentProvider() {
				
				public void update(IChildrenCountUpdate[] updates) {
					try {
						for (IChildrenCountUpdate update : updates) {
							IValue value = variable.getValue();
							org.emftext.test.cct5.resource.cct5.debug.Cct5DebugValue castedValue = (org.emftext.test.cct5.resource.cct5.debug.Cct5DebugValue) value;
							update.setChildCount(castedValue.getVariableCount());
							update.done();
						}
					} catch (DebugException e) {
						e.printStackTrace();
					}
				}
				
				public void update(IChildrenUpdate[] updates) {
					try {
						IValue value = variable.getValue();
						org.emftext.test.cct5.resource.cct5.debug.Cct5DebugValue castedValue = (org.emftext.test.cct5.resource.cct5.debug.Cct5DebugValue) value;
						for (IChildrenUpdate update : updates) {
							int offset = update.getOffset();
							int length = update.getLength();
							for (int i = offset; i < offset + length; i++) {
								IVariable variable = castedValue.getChild(i);
								update.setChild(variable, i);
							}
							update.done();
						}
					} catch (DebugException e) {
						e.printStackTrace();
					}
				}
				
				public void update(IHasChildrenUpdate[] updates) {
					for (IHasChildrenUpdate update : updates) {
						try {
							update.setHasChilren(variable.getValue().hasVariables());
							update.done();
						} catch (DebugException e) {
							e.printStackTrace();
						}
					}
				}
			};
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public Class[] getAdapterList() {
		return new Class[] {IToggleBreakpointsTarget.class};
	}
	
}

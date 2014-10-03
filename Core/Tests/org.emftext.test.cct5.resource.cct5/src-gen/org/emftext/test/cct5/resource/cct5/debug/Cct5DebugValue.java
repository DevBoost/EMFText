/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.debug;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

public class Cct5DebugValue extends org.emftext.test.cct5.resource.cct5.debug.Cct5DebugElement implements IValue {
	
	private org.emftext.test.cct5.resource.cct5.debug.Cct5DebugTarget debugTarget;
	private IVariable[] variables;
	private String referenceTypeName;
	private String valueString;
	private Map<String, Long> children;
	
	public Cct5DebugValue(org.emftext.test.cct5.resource.cct5.debug.Cct5DebugTarget target, String id, String valueString, String referenceTypeName, Map<String, Long> children) {
		super(target);
		this.debugTarget = target;
		this.valueString = valueString;
		this.referenceTypeName = referenceTypeName;
		this.children = children;
	}
	
	public String getReferenceTypeName() throws DebugException {
		return referenceTypeName;
	}
	
	public String getValueString() throws DebugException {
		return valueString;
	}
	
	public boolean isAllocated() throws DebugException {
		return true;
	}
	
	public IVariable[] getVariables() throws DebugException {
		if (variables == null) {
			// request variables from debug client
			Collection<Long> childIDs = children.values();
			String[] childIDStrings = new String[childIDs.size()];
			int i = 0;
			for (Long childID : childIDs) {
				childIDStrings[i++] = childID.toString();
			}
			IVariable[] response = debugTarget.getDebugProxy().getVariables(childIDStrings);
			variables = response;
		}
		return variables;
	}
	
	public boolean hasVariables() throws DebugException {
		return this.children.keySet().size() > 0;
	}
	
	public IVariable getChild(int index) {
		Set<String> keySet = this.children.keySet();
		Iterator<String> iterator = keySet.iterator();
		String keyAtIndex = iterator.next();
		for (int i = 0; i < index; i++) {
			keyAtIndex = iterator.next();
		}
		Long childID = this.children.get(keyAtIndex);
		IVariable[] response = debugTarget.getDebugProxy().getVariables(childID.toString());
		return response[0];
	}
	
	public int getVariableCount() {
		return this.children.keySet().size();
	}
	
}

/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.debug;

import java.util.List;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;

public class Cct5DebugThread extends org.emftext.test.cct5.resource.cct5.debug.Cct5DebugElement implements IThread, org.emftext.test.cct5.resource.cct5.debug.ICct5DebugEventListener {
	
	private boolean suspended = false;
	private org.emftext.test.cct5.resource.cct5.debug.Cct5DebugTarget debugTarget;
	
	public Cct5DebugThread(org.emftext.test.cct5.resource.cct5.debug.Cct5DebugTarget target) {
		super(target);
		this.debugTarget = target;
	}
	
	public IBreakpoint[] getBreakpoints() {
		return null;
	}
	
	public String getName() throws DebugException {
		return "Thread [main]";
	}
	
	public int getPriority() throws DebugException {
		return 0;
	}
	
	public IStackFrame[] getStackFrames() throws DebugException {
		if (isSuspended()) {
			org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage stack = this.debugTarget.getDebugProxy().getStack();
			String framesData = stack.getArgument(0);
			if (framesData != null && !"".equals(framesData)) {
				List<String> frames = org.emftext.test.cct5.resource.cct5.util.Cct5StringUtil.decode(framesData, '#');
				IStackFrame[] theFrames = new IStackFrame[frames.size()];
				for (int i = 0; i < frames.size(); i++) {
					String data = frames.get(i);
					theFrames[frames.size() - i - 1] = new org.emftext.test.cct5.resource.cct5.debug.Cct5StackFrame(getTarget(), data);
				}
				return theFrames;
			}
		}
		return new IStackFrame[0];
	}
	
	public IStackFrame getTopStackFrame() throws DebugException {
		IStackFrame[] frames = getStackFrames();
		if (frames.length > 0) {
			return frames[0];
		}
		return null;
	}
	
	public boolean hasStackFrames() throws DebugException {
		return isSuspended();
	}
	
	public boolean canResume() {
		return isSuspended();
	}
	
	public boolean canSuspend() {
		return !isSuspended();
	}
	
	public boolean isSuspended() {
		return suspended && !isTerminated();
	}
	
	public void resume() throws DebugException {
		debugTarget.getDebugProxy().resume();
		suspended = false;
	}
	
	public void suspend() throws DebugException {
		suspended = true;
		fireSuspendEvent(DebugEvent.BREAKPOINT);
	}
	
	public boolean canStepInto() {
		return true;
	}
	
	public boolean canStepOver() {
		return true;
	}
	
	public boolean canStepReturn() {
		return true;
	}
	
	public boolean isStepping() {
		return false;
	}
	
	public void stepInto() throws DebugException {
		getTarget().getDebugProxy().stepInto();
	}
	
	public void stepOver() throws DebugException {
		getTarget().getDebugProxy().stepOver();
	}
	
	public void stepReturn() throws DebugException {
		getTarget().getDebugProxy().stepReturn();
	}
	
	public boolean canTerminate() {
		return !isTerminated();
	}
	
	public boolean isTerminated() {
		return getDebugTarget().isTerminated();
	}
	
	public void terminate() throws DebugException {
		getTarget().getDebugProxy().terminate();
	}
	
	public void handleMessage(org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage message) {
		if (message.hasType(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes.STARTED)) {
			fireCreationEvent();
		} else if (message.hasType(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes.RESUMED)) {
			suspended = false;
			fireResumeEvent(0);
		} else if (message.hasType(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes.SUSPENDED)) {
			suspended = true;
			fireSuspendEvent(DebugEvent.BREAKPOINT);
		} else if (message.hasType(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes.TERMINATED)) {
			// ignore this event
		} else {
			System.out.println("ERROR " + this.getClass().getName() + ".handleMessage(" + message + ") unknown event");
		}
	}
	
	public org.emftext.test.cct5.resource.cct5.debug.Cct5DebugTarget getTarget() {
		return debugTarget;
	}
	
}

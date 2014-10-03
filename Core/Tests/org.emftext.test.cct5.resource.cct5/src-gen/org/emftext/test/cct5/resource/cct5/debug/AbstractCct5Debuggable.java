/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.debug;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;

public abstract class AbstractCct5Debuggable {
	
	/**
	 * The list of breakpoints, where each breakpoint is represented by its location
	 * (a string) and the line number
	 */
	private List<org.emftext.test.cct5.resource.cct5.util.Cct5Pair<String, Integer>> lineBreakpoints = new ArrayList<org.emftext.test.cct5.resource.cct5.util.Cct5Pair<String, Integer>>();
	private PrintStream outputStream;
	private ServerSocket server;
	private boolean debugMode;
	private boolean suspend;
	
	private org.emftext.test.cct5.resource.cct5.debug.Cct5DebugCommunicationHelper communicationHelper = new org.emftext.test.cct5.resource.cct5.debug.Cct5DebugCommunicationHelper();
	
	public void startEventSocket(int eventPort) {
		try {
			// starting event server socket (waiting for connection)...
			server = new ServerSocket(eventPort);
			Socket accept = server.accept();
			// starting event server socket done (connection established).
			outputStream = new PrintStream(accept.getOutputStream());
		} catch (Exception e) {
			new org.emftext.test.cct5.resource.cct5.util.Cct5RuntimeUtil().logError("Can't create socket connection while launching.", e);
		}
	}
	
	public void stopEventSocket() {
		try {
			server.close();
		} catch (IOException e) {
			new org.emftext.test.cct5.resource.cct5.util.Cct5RuntimeUtil().logError("Exception while closing socket.", e);
		}
	}
	
	public void sendEvent(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes command, boolean sendOnlyInDebugMode, String... arguments) {
		if (isDebugMode() || !sendOnlyInDebugMode) {
			org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage message = new org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage(command, arguments);
			communicationHelper.sendEvent(message, outputStream);
		}
	}
	
	public void evaluateLineBreakpoint(URI uri, int currentLine) {
		if (isDebugMode()) {
			String platformString = uri.toPlatformString(true);
			IResource member = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
			if (member == null) {
				return;
			}
			String location = member.getRawLocation().toPortableString();
			for (int i = 0; i < lineBreakpoints.size(); i++) {
				org.emftext.test.cct5.resource.cct5.util.Cct5Pair<String, Integer> breakpointLocationAndLine = lineBreakpoints.get(i);
				String breakpointLocation = breakpointLocationAndLine.getLeft();
				Integer breakpointLine = breakpointLocationAndLine.getRight();
				if (breakpointLine.intValue() == currentLine && breakpointLocation.equals(location)) {
					// suspending...
					setSuspend(true);
					sendEvent(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes.SUSPENDED, true, new String[] {"breakpoint", "" + currentLine});
					break;
				}
			}
			waitIfSuspended();
		}
	}
	
	public void waitIfSuspended() {
		try {
			while (isSuspend()) {
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
		}
		sendEvent(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes.RESUMED, true);
	}
	
	public void addLineBreakpoint(String location, int line) {
		lineBreakpoints.add(new org.emftext.test.cct5.resource.cct5.util.Cct5Pair<String, Integer>(location, new Integer(line)));
	}
	
	public void removeLineBreakpoint(String location, int line) {
		lineBreakpoints.remove(new org.emftext.test.cct5.resource.cct5.util.Cct5Pair<String, Integer>(location, new Integer(line)));
	}
	
	public void resume() {
		setSuspend(false);
	}
	
	public void terminate() {
		sendEvent(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes.TERMINATED, false);
		stopEventSocket();
	}
	
	public boolean isDebugMode() {
		return debugMode;
	}
	
	public void setDebugMode(boolean debugMode) {
		this.debugMode = debugMode;
	}
	
	public boolean isSuspend() {
		return suspend;
	}
	
	public void setSuspend(boolean suspend) {
		this.suspend = suspend;
	}
	
	/**
	 * This method must be called before the actual execution of the interpreter or
	 * generated code. Its purpose is to send an event to the debug server to signal
	 * that the debuggable has started and wait until the server has installed all
	 * breakpoints and signals to resume (i.e., to start the actual execution).
	 */
	public void startUpAndWait() {
		// suspend here after startup to wait for the installation of deferred breakpoints
		if (isDebugMode()) {
			sendEvent(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes.STARTED, true);
			setSuspend(true);
			// wait until server sends the RESUME event
			while (isSuspend()) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					throw new RuntimeException(e.getMessage());
				}
			}
			// confirm that the debuggable was resumed
			sendEvent(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes.RESUMED, true);
		}
	}
	
	public abstract void stepOver();
	public abstract void stepInto();
	public abstract void stepReturn();
	public abstract String[] getStack();
	public abstract Map<String, Object> getFrameVariables(String stackFrame);
}

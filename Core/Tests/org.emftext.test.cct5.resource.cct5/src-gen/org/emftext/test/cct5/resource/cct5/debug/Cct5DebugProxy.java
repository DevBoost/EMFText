/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.debug;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

/**
 * The DebugProxy allows to communicate between the interpreter, which runs in a
 * separate thread or process and the Eclipse Debug framework (i.e., the
 * DebugTarget class).
 */
public class Cct5DebugProxy {
	
	public static final int STARTUP_DELAY = 1000;
	
	private PrintStream output;
	
	private BufferedReader reader;
	
	private org.emftext.test.cct5.resource.cct5.debug.Cct5DebugTarget debugTarget;
	
	private org.emftext.test.cct5.resource.cct5.debug.Cct5DebugCommunicationHelper communicationHelper = new org.emftext.test.cct5.resource.cct5.debug.Cct5DebugCommunicationHelper();
	
	public Cct5DebugProxy(org.emftext.test.cct5.resource.cct5.debug.Cct5DebugTarget debugTarget, int requestPort) throws UnknownHostException, IOException {
		this.debugTarget = debugTarget;
		// give interpreter a chance to start
		try {
			Thread.sleep(STARTUP_DELAY);
		} catch (InterruptedException e) {
		}
		startSocket(requestPort);
	}
	
	private void startSocket(int requestPort) throws UnknownHostException, IOException {
		// creating client proxy socket (trying to connect)...
		Socket client = new Socket("localhost", requestPort);
		// creating client proxy socket - done. (connected)
		try {
			BufferedInputStream input = new BufferedInputStream(client.getInputStream());
			reader = new BufferedReader(new InputStreamReader(input));
		} catch (IOException e) {
			System.out.println(e);
		}
		try {
			output = new PrintStream(client.getOutputStream());
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void resume() {
		sendCommand(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes.RESUME);
	}
	
	public void stepOver() {
		sendCommand(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes.STEP_OVER);
	}
	
	public void stepInto() {
		sendCommand(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes.STEP_INTO);
	}
	
	public void stepReturn() {
		sendCommand(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes.STEP_RETURN);
	}
	
	public void terminate() {
		sendCommand(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes.EXIT);
	}
	
	public org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage getStack() {
		return sendCommandAndRead(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes.GET_STACK);
	}
	
	public void addLineBreakpoint(String location, int line) {
		org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage message = new org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes.ADD_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public void removeLineBreakpoint(String location, int line) {
		org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage message = new org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes.REMOVE_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public IVariable[] getStackVariables(String stackFrame) {
		org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage response = sendCommandAndRead(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes.GET_FRAME_VARIABLES, new String[] {stackFrame});
		String[] ids = response.getArguments();
		// fetch all variables
		IVariable[] variables = getVariables(ids);
		return variables;
	}
	
	public IVariable[] getVariables(String... requestedIDs) {
		org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage response = sendCommandAndRead(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes.GET_VARIABLES, requestedIDs);
		String[] varStrings = response.getArguments();
		org.emftext.test.cct5.resource.cct5.debug.Cct5DebugVariable[] variables  = new org.emftext.test.cct5.resource.cct5.debug.Cct5DebugVariable[varStrings.length];
		int i = 0;
		for (String varString : varStrings) {
			Map<String, String> properties = org.emftext.test.cct5.resource.cct5.util.Cct5StringUtil.convertFromString(varString);
			
			// convert varString to variables and values
			String valueString = properties.get("!valueString");
			String valueRefType = "valueRefType";
			Map<String, Long> childVariables = new TreeMap<String, Long>(new Comparator<String>() {
				public int compare(String s1, String s2) {
					return s1.compareToIgnoreCase(s2);
				}
			});
			for (String property : properties.keySet()) {
				// ignore special properties - they are not children
				if (property.startsWith("!")) {
					continue;
				}
				childVariables.put(property, Long.parseLong(properties.get(property)));
			}
			String id = properties.get("!id");
			IValue value = new org.emftext.test.cct5.resource.cct5.debug.Cct5DebugValue(debugTarget, id, valueString, valueRefType, childVariables);
			
			String variableName = properties.get("!name");
			String variableRefType = properties.get("!type");
			
			org.emftext.test.cct5.resource.cct5.debug.Cct5DebugVariable variable = new org.emftext.test.cct5.resource.cct5.debug.Cct5DebugVariable(debugTarget, variableName, value, variableRefType);
			variables[i++] = variable;
		}
		return variables;
	}
	
	private void sendCommand(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes command, String... parameters) {
		org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage message = new org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage(command, parameters);
		communicationHelper.sendEvent(message, output);
	}
	
	private org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage sendCommandAndRead(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes command, String... parameters) {
		org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage message = new org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage(command, parameters);
		return communicationHelper.sendAndReceive(message, output, reader);
	}
	
}

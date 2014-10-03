/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.debug;

import java.util.ArrayList;
import java.util.List;

/**
 * DebugMessages are exchanged between the debug server (the Eclipse debug
 * framework) and the debug client (a running process or interpreter). To exchange
 * messages they are serialized and sent over sockets.
 */
public class Cct5DebugMessage {
	
	private static final char DELIMITER = ':';
	private org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes messageType;
	private String[] arguments;
	
	public Cct5DebugMessage(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes messageType, String[] arguments) {
		super();
		this.messageType = messageType;
		this.arguments = arguments;
	}
	
	public Cct5DebugMessage(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes messageType, List<String> arguments) {
		super();
		this.messageType = messageType;
		this.arguments = new String[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			this.arguments[i] = arguments.get(i);
		}
	}
	
	public org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes getMessageType() {
		return messageType;
	}
	
	public String[] getArguments() {
		return arguments;
	}
	
	public String serialize() {
		List<String> parts = new ArrayList<String>();
		parts.add(messageType.name());
		for (String argument : arguments) {
			parts.add(argument);
		}
		return org.emftext.test.cct5.resource.cct5.util.Cct5StringUtil.encode(DELIMITER, parts);
	}
	
	public static Cct5DebugMessage deserialize(String response) {
		List<String> parts = org.emftext.test.cct5.resource.cct5.util.Cct5StringUtil.decode(response, DELIMITER);
		String messageType = parts.get(0);
		String[] arguments = new String[parts.size() - 1];
		for (int i = 1; i < parts.size(); i++) {
			arguments[i - 1] = parts.get(i);
		}
		org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes type = org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes.valueOf(messageType);
		Cct5DebugMessage message = new Cct5DebugMessage(type, arguments);
		return message;
	}
	
	public boolean hasType(org.emftext.test.cct5.resource.cct5.debug.ECct5DebugMessageTypes type) {
		return this.messageType == type;
	}
	
	public String getArgument(int index) {
		return getArguments()[index];
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "[" + messageType.name() + ": " + org.emftext.test.cct5.resource.cct5.util.Cct5StringUtil.explode(arguments, ", ") + "]";
	}
	
}

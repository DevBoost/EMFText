/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.debug;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Cct5DebugCommunicationHelper {
	
	public void sendEvent(org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage message, PrintStream stream) {
		synchronized (stream) {
			stream.println(message.serialize());
		}
	}
	
	/**
	 * <p>
	 * Sends a message using the given stream and waits for an answer.
	 * </p>
	 * 
	 * @param messageType the type of message to send
	 * @param stream the stream to send the message to
	 * @param reader the reader to obtain the answer from
	 * @param parameters additional parameter to send
	 * 
	 * @return the answer that is received
	 */
	public org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage sendAndReceive(org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage message, PrintStream stream, BufferedReader reader) {
		synchronized (stream) {
			sendEvent(message, stream);
			org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage response = receive(reader);
			return response;
		}
	}
	
	/**
	 * <p>
	 * Receives a message from the given reader. This method block until a message has
	 * arrived.
	 * </p>
	 * 
	 * @param reader the read to obtain the message from
	 * 
	 * @return the received message
	 */
	public org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage receive(BufferedReader reader) {
		try {
			String response = reader.readLine();
			if (response == null) {
				return null;
			}
			org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage receivedMessage = org.emftext.test.cct5.resource.cct5.debug.Cct5DebugMessage.deserialize(response);
			return receivedMessage;
		} catch (IOException e) {
			return null;
		}
	}
	
}

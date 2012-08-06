package jjtraveler;

import jjtraveler.Visitable;
import jjtraveler.Visitor;

/** 
 * A class to represent a visting event: the fact that a visitable
 * node is visited by a particular visitor.
 */

public class Event {
 
    Visitor visitor;
    Visitable node;
    long timeStamp;
    

    public Event(Visitor v, Visitable n) {
	visitor = v;
	node = n;
	timeStamp = System.currentTimeMillis();
    }

    public String toString() {
	return visitor + ".visit(" + node + ")";
    }

    public boolean equals(Object o) {
	boolean result = false;
	if (o instanceof Event) {
	    Event e = (Event) o;
	    result = toString()==e.toString();
	}
	return result;
    }
    public int hashCode() {
	return toString().hashCode();
    }

    /**
     * Return the time (in milliseconds) at which the event was generated.
     */
    public long getTimeStamp() {
	return timeStamp;
    }
}

package org.reuseware.lib.java.pattern.observer;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class Observer {

	protected List<Subject> subjects;

	public Observer() {
		subjects = new LinkedList<Observer>(); 
	}

	public void update() {
		Iterator<Subject> it
		it = subjects.iterator();
		
		while(it.hasNext()) {
			Subject subject
			subject = it.next();
			subject.notify();
		}
	}

	public List<Subject> getSubjects() {
		return subjects;
	}
	
}
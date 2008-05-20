package org.reuseware.lib.java.pattern.observer;

import java.util.List;
import java.util.LinkedList;

public class Subject {

	protected List<Observer> observers;

	public Subject() {
		observers = new LinkedList<Observer>(); 
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	
	public void notify() {
		<<notifyCallOut>>
	}
}
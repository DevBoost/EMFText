package org.reuseware.test;

public class Folder {

	public void someMethod() {
		export ->notifyMe<- {
		    someMethod();
		} 
	}

}
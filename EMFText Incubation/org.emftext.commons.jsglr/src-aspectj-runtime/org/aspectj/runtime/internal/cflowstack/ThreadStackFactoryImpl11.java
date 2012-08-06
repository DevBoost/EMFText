/* *******************************************************************
 * Copyright (c) 2004 IBM Corporation
 * 
 * All rights reserved. 
 * This program and the accompanying materials are made available 
 * under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *  
 * Contributors: 
 *    Andy Clement     initial implementation 
 * ******************************************************************/
package org.aspectj.runtime.internal.cflowstack;


public class ThreadStackFactoryImpl11 implements ThreadStackFactory {

	public ThreadStack getNewThreadStack() {
		return new ThreadStackImpl11();
	}
	
	public ThreadCounter getNewThreadCounter() {
		return new ThreadCounterImpl11();
	}

}

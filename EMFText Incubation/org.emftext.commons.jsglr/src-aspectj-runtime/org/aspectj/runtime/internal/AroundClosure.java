/* *******************************************************************
 * Copyright (c) 1999-2001 Xerox Corporation, 
 *               2002 Palo Alto Research Center, Incorporated (PARC).
 * All rights reserved. 
 * This program and the accompanying materials are made available 
 * under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *  
 * Contributors: 
 *     Xerox/PARC     initial implementation 
 *    Alex Vasseur    wired up for @AJ proceeding
 *    Andy Clement 23-06-06 added extras for @AJ
 * ******************************************************************/


package org.aspectj.runtime.internal;

import org.aspectj.lang.ProceedingJoinPoint;

public abstract class AroundClosure {
    protected Object[] state;

    // Records with the related joinpoint has a this or a target and whether 
    // either of them are bound in the pointcut.  Set in the 'link' call made
    // at each matching join point... (see pr126167)
    // bit6 being 1 means the flags haven't been initialized
    protected int bitflags = 0x100000; 
    protected Object[] preInitializationState;

    public AroundClosure() {
    }
    
    public AroundClosure(Object[] state) {
    	this.state = state;
    }
    
    public int getFlags() {return bitflags;}

    public Object[] getState() {
      return state;
    }
    
	public Object[] getPreInitializationState() {
		return preInitializationState;
	}

	/**
	 * This takes in the same arguments as are passed to the proceed
	 * call in the around advice (with primitives coerced to Object types)
	 */
    public abstract Object run(Object[] args) throws Throwable;

    /**
     * This method is called to implicitly associate the closure with the joinpoint
     * as required for @AJ aspect proceed()
     */
    public ProceedingJoinPoint linkClosureAndJoinPoint() {
        //TODO is this cast safe ?
        ProceedingJoinPoint jp = (ProceedingJoinPoint)state[state.length-1];
        jp.set$AroundClosure(this);
        return jp;
    }

    /**
     * This method is called to implicitly associate the closure with the joinpoint
     * as required for @AJ aspect proceed()
     */
    public ProceedingJoinPoint linkClosureAndJoinPoint(int flags) {
        //TODO is this cast safe ?
        ProceedingJoinPoint jp = (ProceedingJoinPoint)state[state.length-1];
        jp.set$AroundClosure(this);
        this.bitflags = flags;
        return jp;
    }
}

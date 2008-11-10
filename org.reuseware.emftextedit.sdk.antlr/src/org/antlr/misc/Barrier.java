package org.antlr.misc;

/**A very simple barrier wait.  Once a thread has requested a
 * wait on the barrier with waitForRelease, it cannot fool the
 * barrier into releasing by "hitting" the barrier multiple times--
 * the thread is blocked on the wait().
 */
public class Barrier {
    protected int threshold;
    protected int count = 0;

    public Barrier(int t) {
        threshold = t;
    }

    public synchronized void waitForRelease()
        throws InterruptedException
    {
        count++;
        // The final thread to reach barrier resets barrier and
        // releases all threads
        if ( count==threshold ) {
            // notify blocked threads that threshold has been reached
            action(); // perform the requested operation
            notifyAll();
        }
        else while ( count<threshold ) {
            wait();
        }
    }

    /** What to do when everyone reaches barrier */
    public void action() {
    }
}

package jjtraveler;

public class LoggerTest extends VisitorTestCase {

    public LoggerTest(String test) {
	super(test);
    }

    public void testEventTiming() throws InterruptedException {
	Logger l = new Logger();
	l.log(new Event(null,null));
	Thread.sleep(100);
	l.log(new Event(null,null));
	assertTrue(l.getElapsedTime() >= 0);
    }

}

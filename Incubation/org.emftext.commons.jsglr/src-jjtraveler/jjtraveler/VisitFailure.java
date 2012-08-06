package jjtraveler;

/**
 * The VisitFailure exception is used to model success and failure of visitor
 * combinators. On failure, the exception is raised. At choice points, the try
 * and catch constructs are used to recover from failed visits.
 */

public class VisitFailure extends Exception {
	private static final long serialVersionUID = -1190261403667634678L;

	private String message;

	public VisitFailure() {
		super();
		this.message = "";
	}

	public VisitFailure(String msg) {
		super();
		this.message = msg;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String toString() {
		return message;
	}

}

package jjtraveler;

public class IfThenElse implements Visitor {

    Visitor condition;
    Visitor trueCase;
    Visitor falseCase;

    public IfThenElse(Visitor c, Visitor t, Visitor f) {
	condition = c;
	trueCase = t;
	falseCase = f;
    }

    public IfThenElse(Visitor c, Visitor t) {
	condition = c;
	trueCase = t;
	falseCase = new Identity();
    }


    public Visitable visit(Visitable x) throws VisitFailure {
	boolean success;
	Visitable result;
	try {
	    condition.visit(x);
	    success = true;
	} catch (VisitFailure vf) {
	    success = false;
	}
	if (success) {
	    result = trueCase.visit(x);
	} else {
	    result = falseCase.visit(x);
	}
	return result;
    }
}

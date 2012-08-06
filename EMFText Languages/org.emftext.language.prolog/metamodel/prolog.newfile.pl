d(3,4).
d(X,2).

dExpr(Tn,X,DT) :- dTerm(TX,DT).

dExpr(E+T,X,DE+DT) :- dExpr(E,X,DE), dTerm(T,X,DT, F_, 'asd'), X is [cos(pi)].

test(C,x, R).
test(X).
test(muh(d),X).

list([a,b,c | [d,e]] ).

package aterm;

import java.util.Iterator;

public class ATermListIterator implements Iterator<ATerm> {
  private ATermList _current;

  public ATermListIterator(ATermList list) {
    _current = list;
  }
  
  public boolean hasNext() {
    return _current.getLength() != 0;
  }
  
  public ATerm next() {
    ATerm result = _current.getFirst();
    _current = _current.getNext();
    return result;
  }
  
  public void remove() {
    throw new UnsupportedOperationException("ATermListIterator does not support remove");
  }
}

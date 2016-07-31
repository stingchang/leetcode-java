// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Integer cur;
    private Iterator<Integer> iterator;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator();
	    cur = iterator.hasNext()?iterator.next():null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return cur;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer i = cur;
	    cur = iterator.next();
	}

	@Override
	public boolean hasNext() {
	    return iterator.hasNext() || cur == null;
	}
}
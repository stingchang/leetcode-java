public class MinStack {

 private Stack<Integer> stack;
	private Stack<int[]> minVal;

	/** initialize your data structure here. */
	public MinStack() {
		stack = new Stack<>();
		minVal = new Stack<>();
	}

	public void push(int x) {
		if (stack.isEmpty()) {

			minVal.push(new int[] { x, 1 });
		} else {
			int[] minArr = minVal.peek();
			if (x >= minArr[0]) {
				minArr[1] += 1;
			} else {
				minVal.push(new int[] { x, 1 });
			}

		}

		stack.push(x);
	}

	public void pop() {
		if (stack.isEmpty())
			throw new EmptyStackException();
		
		stack.pop();
		if(minVal.peek()[1]>1){
			minVal.peek()[1]-=1;
		} else {
			minVal.pop();
		}
	}

	public int top() {
		if (stack.isEmpty())
			throw new EmptyStackException();
		
		return stack.peek();
	}

	public int getMin() {
		if (stack.isEmpty())
			throw new EmptyStackException();
		
		return minVal.peek()[0];
	}
	
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
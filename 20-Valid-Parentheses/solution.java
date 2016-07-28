public class Solution {
    public boolean isValid(String s) {
        // Use a stack to keep track of the parenthesis
        Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '[' || c == '(' || c == '{')
				stack.push(c);
			else if (stack.isEmpty()) {
				return false;
			} else if (c == ')') {
				if (stack.pop() != '(')
					return false;
			} else if (c == ']') {
				if (stack.pop() != '[')
					return false;
			} else if (c == '}') {
				if (stack.pop() != '{')
					return false;
			}
		}

		return stack.isEmpty() ? true : false;
    }
}
package stackAndQueues;

import java.util.Stack;

public class ValidParentheses_20 {
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			} 
			else if (s.charAt(i) == ')' && !stack.isEmpty()) {
					if (stack.peek() == '(') {
						stack.pop();
					} else {
						return false;
					}
				}
				
			else if (s.charAt(i) == ']' && !stack.isEmpty()) {
					if (stack.peek() == '[') {
						stack.pop();
					} else {
						return false;
					}
				}
				
			else if (s.charAt(i) == '}' && !stack.isEmpty()) {
					if (stack.peek() == '{') {
						stack.pop();
					} else {
						return false;
					}
				}
			else {
				return false;
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "[])";
		System.out.println(isValid(s));
	}

}

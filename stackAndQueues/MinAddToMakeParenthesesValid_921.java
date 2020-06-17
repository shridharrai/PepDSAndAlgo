package stackAndQueues;

import java.util.Stack;

public class MinAddToMakeParenthesesValid_921 {
	public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			} else {
				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				} else {
					stack.push(s.charAt(i));
				}
			}
		}
		return stack.size();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "())";
		System.out.println(minAddToMakeValid(s));
	}

}

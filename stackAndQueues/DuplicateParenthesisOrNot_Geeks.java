package stackAndQueues;

import java.util.Stack;

public class DuplicateParenthesisOrNot_Geeks {
	//O(n)
	public static boolean findDuplicateparenthesis(String s) {
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ')') {
				stack.push(s.charAt(i));
			} else {
				int count = 0;
				while (stack.peek() != '(') {
					stack.pop();
					count++;
				}
				stack.pop();
				if (count == 0) {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "((a+(b))+(c+d))";
		System.out.println(findDuplicateparenthesis(s));
	}

}

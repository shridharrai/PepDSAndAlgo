package stackAndQueues;

import java.util.Stack;

public class LengthOfLongestUnbalancedSubseq {
	//O(n)
	public static int unbalancedSubseq(String str) {
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.push(str.charAt(i));
			} else {
				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				} else {
					stack.push(str.charAt(i));
				}
			}
		}
		if (stack.isEmpty()) {
			return str.length()-1;
		} else {
			return str.length();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "()()())";
		System.out.println(unbalancedSubseq(str));
	}

}

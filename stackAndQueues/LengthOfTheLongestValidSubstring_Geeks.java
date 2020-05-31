package stackAndQueues;

import java.util.Stack;

public class LengthOfTheLongestValidSubstring_Geeks {
	//O(n)
	public static int longestValidSubstring(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int ans = Integer.MIN_VALUE;
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (stack.peek() != -1 && s.charAt(stack.peek()) == '(') {
					stack.pop();
					int j = stack.peek();
					ans = Math.max(ans, i-j);
				} else {
					stack.push(i);
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "()(()))))";
		System.out.println(longestValidSubstring(s));
	}

}

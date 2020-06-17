package stackAndQueues;

import java.util.Stack;

public class RemoveKDigits_402 {
	//O(n)
	public static String removeKdigits(String num, int k) {
		Stack<Character> stack = new Stack<Character>();
		stack.push(num.charAt(0));
		for (int i = 1; i < num.length(); i++) {
			if (!stack.isEmpty() && stack.peek() > num.charAt(i)) {
				while (!stack.isEmpty() && (stack.peek() > num.charAt(i) && k > 0)) {
					stack.pop();
					k--;
				}
				stack.push(num.charAt(i));
			} else {
				stack.push(num.charAt(i));
			}
		}
		while (k != 0) {
			stack.pop();
			k--;
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		sb.reverse();
		System.out.println(sb);
		if (sb.length() > 0 && sb.charAt(0) == '0') {
			while (sb.charAt(0) == '0') {
				sb.delete(0, 1);
			}
		}
		return new String(sb);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "32001432219";
		int k = 5;
		System.out.println(removeKdigits(num, k));
	}

}

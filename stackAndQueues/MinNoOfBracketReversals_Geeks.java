package stackAndQueues;

import java.util.Stack;

public class MinNoOfBracketReversals_Geeks {
	//O(n)
	public static int minNoReversals(String s) {
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '{') {
				stack.push(s.charAt(i));
			} else {
				if (!stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
				} else {
					stack.push(s.charAt(i));
				}
			}
		}

		int oc = 0;
		int cc = 0;
		while (!stack.isEmpty()) {
			char bracket = stack.pop();
			if (bracket == '{') {
				oc++;
			} else {
				cc++;
			}
		}
		
		if (oc%2 == 0 && cc%2 == 0) {
			return (oc/2 + cc/2);
		} else if (oc%2 != 0 && cc%2 != 0) {
			return (oc/2 + cc/2 + 2);
		} else {
			return -1;    //Not Possible
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "}{{}}{{{"; 
		System.out.println(minNoReversals(s));
	}

}

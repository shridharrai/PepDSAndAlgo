package stackAndQueues;

import java.util.Stack;

public class ValidateStackSequences_946 {
	//O(n)
	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(pushed[0]);
		int i = 1;
		int j = 0;
		while (i < pushed.length) {
			while (!stack.isEmpty() && stack.peek() == popped[j]) {
				stack.pop();
				j++;
			}
			stack.push(pushed[i]);
			i++;
		}
		while (j < popped.length && stack.peek() == popped[j]) {
			stack.pop();
			j++;
		}
		if (stack.isEmpty() && j == popped.length) {
			return true;
		} else {
			return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pushed = {1,2,3,4,5};
		int[] popped = {4,3,5,1,2};
		System.out.println(validateStackSequences(pushed, popped));
	}

}

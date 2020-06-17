package stackAndQueues;

import java.util.Stack;

public class PostfixEvaluation {
	public static int evaluate(String exp) {
		char[] arr = exp.toCharArray();
		Stack<Integer> values = new Stack<Integer>();
		for (int i = 0; i < arr.length; i++) {
			//If number encountered
			if (Character.isDigit(arr[i])) {
				values.push(arr[i] - '0');
			} else {
				values.push(calculate(arr[i], values.pop(), values.pop()));
			}
		}
		return values.pop();
	}
	
	public static int calculate(char op, int a, int b) {
		switch (op) {
		case '+':
			return b+a;
		case '-':
			return b-a;
		case '*':
			return b*a;
		case '/':
			return b/a;
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp = "231*+341*+-";
		System.out.println(evaluate(exp));
	}

}

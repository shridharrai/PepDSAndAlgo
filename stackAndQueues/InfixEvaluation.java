package stackAndQueues;

import java.util.Stack;

public class InfixEvaluation {
	public static int evaluate(String exp) {
		char[] arr = exp.toCharArray();
		Stack<Integer> values = new Stack<Integer>();
		Stack<Character> ops = new Stack<Character>();
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ' ') {
				continue;
			}
			//If number encountered
			if (arr[i] >= '0' && arr[i] <= '9') {
				StringBuffer buffer = new StringBuffer();
				while (i < arr.length && arr[i] >= '0' && arr[i] <= '9') {
					buffer.append(arr[i]);
					i++;
				}
				values.push(Integer.parseInt(buffer.toString()));
			}
			else if (arr[i] == '(') {
				ops.push(arr[i]);
			}
			else if (arr[i] == ')') {
				while (ops.peek() != '(') {
					values.push(calculate(ops.pop(), values.pop(), values.pop()));
				}
				ops.pop();
			}
			//If any operator encounter
			else {
				while (!ops.empty() && precedence(arr[i], ops.peek())) {
					values.push(calculate(ops.pop(), values.pop(), values.pop()));
				}
				ops.push(arr[i]);
			}
		}
		while (!ops.empty()) {
			values.push(calculate(ops.pop(), values.pop(), values.pop()));
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
	
	//If op2 has greater or equal precendence then return true otherwise false
	public static boolean precedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')') {
			return false;
		}
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
			return false;
		}
		else {
			return true;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "2 + 3 * 1 - ( 3 + 4 / 1 ) + ( 2 * 3 )";
		System.out.println(evaluate(s));
	}

}

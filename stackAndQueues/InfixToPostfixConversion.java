package stackAndQueues;

import java.util.Stack;

public class InfixToPostfixConversion {
	public static String conversion(String exp) {
		char[] arr = exp.toCharArray();
		Stack<String> values = new Stack<String>();
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
				values.push(buffer.toString());
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
	
	public static String calculate(char op, String a, String b) {
		return b+a+op;
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
		String exp = "2 + 3 * 1 - ( 3 + 4 * 1 )";
		System.out.println(conversion(exp));
	}

}

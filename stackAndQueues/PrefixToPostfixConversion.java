package stackAndQueues;

import java.util.Stack;

public class PrefixToPostfixConversion {
	public static String convert(String exp) {
		Stack<String> ans = new Stack<String>();
		
		for (int i = exp.length()-1; i >= 0; i--) {
			if (Character.isDigit(exp.charAt(i))) {
				ans.push(exp.charAt(i)+"");
			} else {
				ans.push(calculate(exp.charAt(i), ans.pop(), ans.pop()));
			}
		}
		return ans.pop();
	}
	
	public static String calculate(char op, String a, String b) {
		return a+b+op;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp = "-+2*31+3*41";
		System.out.println(convert(exp));
	}

}

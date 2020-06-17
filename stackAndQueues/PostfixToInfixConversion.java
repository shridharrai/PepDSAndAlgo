package stackAndQueues;

import java.util.Stack;

public class PostfixToInfixConversion {
	public static String convert(String exp) {
           Stack<String> ans = new Stack<String>();
		
		for (int i = 0; i < exp.length(); i++) {
			if (Character.isDigit(exp.charAt(i))) {
				ans.push(exp.charAt(i)+"");
			} else {
				ans.push(calculate(exp.charAt(i), ans.pop(), ans.pop()));
			}
		}
		return ans.pop();
	}
	
	public static String calculate(char op, String a, String b) {
		return '('+b+op+a+')';
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp = "231*+341*+-";
		System.out.println(convert(exp));
	}

}

package arraysAndStrings;

public class MultiplyStrings_43 {
	public static void multiply(String num1, String num2) {
		int[] ans = new int[num1.length() + num2.length()];
//		char[] arr1 = 
		for (int j = num2.length()-1; j >= 0; j--) {
			for (int i = num1.length()-1; i >= 0; i--) {
				int idx1 = i+j;
				int idx2 = i+j+1;
				int prod = Integer.parseInt(num1.charAt(i) + "") * Integer.parseInt(num2.charAt(j) + "");
				int finalProd = prod + ans[idx2];
				ans[idx2] = (finalProd%10);
				ans[idx1] = ans[idx1] + (finalProd/10);
			}
		}
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
//		return ;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num1 = "123";
		String num2 = "456";
		multiply(num1, num2);
	}

}

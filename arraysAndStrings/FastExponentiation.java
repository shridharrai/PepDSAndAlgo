package arraysAndStrings;

public class FastExponentiation {
//	O(logn)
	public static int exponentiation(int x, int n) {
		int ans = 1;
		while (n != 1) {
			if (n%2 != 0) {
				ans = ans * x;
				n--;
			}
			x = x*x;
			n = n/2;
		}
		ans = ans * x;
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 3;
		int n = 8;
		System.out.println(exponentiation(x, n));
	}

}

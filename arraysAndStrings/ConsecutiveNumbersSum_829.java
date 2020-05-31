package arraysAndStrings;

public class ConsecutiveNumbersSum_829 {
	//O(math.sqrt(n))
	public static int consecutiveNumbersSum(int N) {
		int ans = 0;
		for (int k = 1; k < Math.sqrt(2*N); k++) {
			if ((N - (k*(k-1)/2)) % k == 0) {
				ans++;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 15;
		System.out.println(consecutiveNumbersSum(n));
	}

}

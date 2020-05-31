package arraysAndStrings;

public class MaxConsecutiveOnesII_Premium {
	//O(n)
	public static int findMaxConsecutiveOnes(int[] nums) {
		int idx = -1;
		int j = 0;
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				j = idx + 1;
				idx = i;
			}
			ans = Math.max(ans, i-j+1);
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,0,1,1,0};
		System.out.println(findMaxConsecutiveOnes(arr));
	}

}

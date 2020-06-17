package arraysAndStrings;

public class TrappingRainWater_42 {
	//O(n)
	public static int trap(int[] height) {
		int leftmax = 0;
		int rightmax = 0;
		int i = 0;
		int j = height.length-1;
		int ans = 0;
		while (i < j) {
			if (height[i] <= height[j]) {
				if (height[i] <= leftmax) {
					ans = ans +(leftmax-height[i]);
				}
				leftmax = Math.max(leftmax, height[i]);
				i++;
			} else {
				if (height[j] <= rightmax) {
					ans = ans +(rightmax-height[j]);
				}
				rightmax = Math.max(rightmax, height[j]);
				--j;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));
	}

}

package arraysAndStrings;

public class ContainerWithMostWater_11 {
	//O(n)
	public static int maxArea(int[] height) {
		int i = 0;
		int j = height.length - 1;
		int max = 0;
		while (i < j) {
			int temp = (j-i) * Math.min(height[i], height[j]);
			if (temp > max) {
				max = temp;
			}
			if (height[i] <= height[j]) {
				i++;
			} else {
				j--;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(arr));
	}

}

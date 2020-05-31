package arraysAndStrings;

public class LargestNoAtleastTwiceToOthers_747 {
	//O(n)
	public static int dominantIndex(int[] nums) {
		int max = 0;
		int idx = -1;
		int secMax = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
				idx = i;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > secMax && nums[i] != max) {
				secMax = nums[i];
			}
		}
//		System.out.println(max);
//		System.out.println(secMax);
		if (max >= secMax*2) {
			return idx;
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,6,1,0};
		System.out.println(dominantIndex(arr));
	}

}

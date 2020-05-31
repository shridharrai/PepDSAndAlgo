package arraysAndStrings;

public class MaximumProductSubarrray_152 {
	//O(n)
	public static int maxProduct(int[] nums) {
		int posProd = nums[0];
		int negProd = nums[0];
		int overallMaxProd = posProd;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > 0) {
				posProd = Math.max(nums[i], posProd*nums[i]);
				negProd = Math.min(nums[i], negProd*nums[i]);
			} else {
				int temp = posProd;
				posProd = Math.max(nums[i], negProd*nums[i]);
				negProd = Math.min(nums[i], temp*nums[i]);
			}
			overallMaxProd = Math.max(posProd, overallMaxProd);
		}
		return overallMaxProd;
	}
	
	public static int maxProduct1(int[] nums) {
		int prefixprod = 1;
		int suffixprod = 1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				prefixprod = 1;
			} else {
				prefixprod = prefixprod * nums[i];
				max = Math.max(max, prefixprod);
			}
		}
		
		for (int i = nums.length-1; i >= 0; i--) {
			if (nums[i] == 0) {
				suffixprod = 1;
			} else {
				suffixprod = suffixprod * nums[i];
				max = Math.max(max, suffixprod);
			}
		}
		
		return Math.max(max, 0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-2,0,-1};
		System.out.println(maxProduct1(arr));
	}

}

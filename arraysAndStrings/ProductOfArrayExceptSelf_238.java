package arraysAndStrings;

public class ProductOfArrayExceptSelf_238 {
	public static int[] productExceptSelf(int[] nums) {
		int[] ans = new int[nums.length];
		ans[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			ans[i] = nums[i] * ans[i-1];
		}
		int suffixProduct = 1;
		for (int i = ans.length-1; i >= 0; i--) {
			if (i == 0) {
				ans[i] = suffixProduct * 1;
			}
			else {
			ans[i] = ans[i-1] * suffixProduct;
			suffixProduct = suffixProduct * nums[i];
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		int ans[] = productExceptSelf(arr);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

}

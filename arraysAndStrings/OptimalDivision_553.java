package arraysAndStrings;

public class OptimalDivision_553 {
	//O(n)
	public static String optimalDivision(int[] nums) {
		StringBuilder sb = new StringBuilder();
		sb.append(nums[0]);
		sb.append("/");
		sb.append("(");
		for (int i = 1; i < nums.length; i++) {
			sb.append(nums[i]);
			if (i != nums.length-1) {
				sb.append("/");
			}
		}
		sb.append(")");
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1000,100,10,2};
		System.out.println(optimalDivision(arr));
	}

}

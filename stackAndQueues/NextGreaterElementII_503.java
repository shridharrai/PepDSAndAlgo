package stackAndQueues;

import java.util.Stack;

public class NextGreaterElementII_503 {
	//O(n)
	public static int[] nextGreaterElements(int[] nums) {
		int[] ans = new int[nums.length];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		
		for (int i = 1; i < 2*ans.length; i++) {
			int num = nums[i%nums.length];
			while (!stack.isEmpty() && nums[stack.peek()] < num) {
				ans[stack.pop()] = num;
			}
			if (i < nums.length) {
				stack.push(i);
			}
		}
		
		while (!stack.isEmpty()) {
			ans[stack.pop()] = -1;
		}
		
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,9,1,4,10,8,7,6};
		nextGreaterElements(arr);
	}

}

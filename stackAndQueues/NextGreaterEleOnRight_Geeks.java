package stackAndQueues;

import java.util.Stack;

public class NextGreaterEleOnRight_Geeks {
	//O(n)
	public static int[] nextGreater(int[] nums) {
		int[] ans = new int[nums.length];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		
		for (int i = 1; i < ans.length; i++) {
			int num = nums[i];
			while (!stack.isEmpty() && nums[stack.peek()] < num) {
				ans[stack.pop()] = num;
			}
			stack.push(i);
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
		int[] arr = {4,2,1,10,3,9,7,20,18};
		nextGreater(arr);
	}

}

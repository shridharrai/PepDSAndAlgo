package stackAndQueues;

import java.util.Stack;

public class LargestRectangleInHistogram_84 {
	//O(n)
	public static int largestRectangleArea(int[] heights) {
		int omax = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		int nsr = 0;
		int nsl = 0;
		int height = 0;
		
		for (int i = 1; i < heights.length; i++) {
			int num = heights[i];
			while (!stack.isEmpty() && heights[stack.peek()] > num) {
				nsr = i;
				height = heights[stack.pop()];
				if (!stack.isEmpty()) {
					nsl = stack.peek();	
				} else {
					nsl = -1;
				}
				int area = height * (nsr-nsl-1);
				omax = Math.max(omax, area);
			}
			stack.push(i);
		}
		
		while (!stack.isEmpty()) {
			nsr = heights.length;
			height = heights[stack.pop()];
			if (!stack.isEmpty()) {
				nsl = stack.peek();	
			} else {
				nsl = -1;
			}
			int area = height * (nsr-nsl-1);
			omax = Math.max(omax, area);
		}
		return omax;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(arr));
	}

}

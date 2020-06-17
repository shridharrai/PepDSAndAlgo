package stackAndQueues;

import java.util.Arrays;

public class ImplementKStacksInSingleArray_Geeks {
	private int[] arr;
	private int[] next;
	private int[] top;
	private int free;
	public ImplementKStacksInSingleArray_Geeks(int k, int n) {
		arr = new int[n];
		next = new int[n];
		top = new int[k];
		free = 0;
		Arrays.fill(top, -1);
		Arrays.setAll(next, i -> i+1);
		next[n-1] = -1;
		System.out.println(Arrays.toString(top));
		System.out.println(Arrays.toString(next));
	}
	public void push(int x, int sn) {
		arr[free] = x;
		int nas = next[free];
		next[free] = top[sn];
		top[sn] = free;
		free = nas;
	}
	public int pop(int sn) {
		int temp = top[sn];
		int ans = arr[temp];
		arr[temp] = 0;
		top[sn] = next[temp];
		next[temp] = free;
		free = temp;
		return ans;
	}
	public void display() {
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(top));
		System.out.println(Arrays.toString(next));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementKStacksInSingleArray_Geeks stack = new ImplementKStacksInSingleArray_Geeks(3, 10);
		stack.push(4, 1);
		stack.push(6, 0);
		stack.push(7, 2);
		stack.push(8, 0);
		stack.push(5, 0);
		stack.push(9, 2);
		stack.display();
		System.out.println(stack.pop(0));
		System.out.println(stack.pop(1));
		System.out.println(stack.pop(2));
		stack.display();
	}

}

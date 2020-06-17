package stackAndQueues;

import java.util.Stack;

public class MinStack_155 {
	private int min;
	private Stack<Integer> stack;
	public MinStack_155() {
		min = -1;
		stack = new Stack<Integer>();
	}
	
	public void push(int x) {
		if (stack.isEmpty()) {
			stack.push(0);
			min = x;
		} else {
			stack.push(x-min);
			min = Math.min(x, min);
		}
	}
	
	public void pop() {
		if (stack.peek() >= 0) {
			stack.pop();
		} else {
			int store = stack.pop();
			int val = min;
			min = val - store;
		}
	}
	
	public int top() {
		if (stack.peek() >= 0) {
			int store = stack.peek();
			return store + min;
		} else {
			return min;
		}
	}
	
	public int getMin() {
		return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack_155 stack = new MinStack_155();
		stack.push(7);
		stack.push(3);
		stack.push(8);
		stack.push(7);
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.top());
	}

}

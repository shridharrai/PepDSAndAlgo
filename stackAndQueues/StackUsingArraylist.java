package stackAndQueues;

import java.util.ArrayList;

public class StackUsingArraylist {
	private ArrayList<Integer> list;
	StackUsingArraylist() {
		list = new ArrayList<Integer>();
	}
	private void push(int num) {
		list.add(num);
	}
	private int pop() {
		return list.remove(list.size()-1);
	}
	private void print() {
		System.out.println(list);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingArraylist stack = new StackUsingArraylist();
		stack.push(10);
		stack.push(7);
		stack.push(6);
		stack.push(5);
		stack.print();
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.print();
	}

}

package stackAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueuesPopEfficient {
	private Queue<Integer> q1;
	private Queue<Integer> q2;
	
	public StackUsingQueuesPopEfficient() {
		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
	}
	//O(n)
	public void push(int num) {
		q2.add(num);
		while (!q1.isEmpty()) {
			q2.add(q1.remove());
		}
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
	}
	//O(1)
	public int pop() {
		return q1.remove();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingQueuePushEfficient stack = new StackUsingQueuePushEfficient();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}

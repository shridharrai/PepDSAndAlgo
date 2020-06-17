package stackAndQueues;

import java.util.Stack;

public class QueueUsingStacksDequeueEfficient {
	private Stack<Integer> s1;
	private Stack<Integer> s2;
	
	public QueueUsingStacksDequeueEfficient() {
		// TODO Auto-generated constructor stub
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
	}
	//O(n)
	public void enqueue(int num) {
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		s1.push(num);
		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
	//O(1)
	public int dequeue() {
		return s1.pop();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingStacksEnqueueEfficient queue = new QueueUsingStacksEnqueueEfficient();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}

}

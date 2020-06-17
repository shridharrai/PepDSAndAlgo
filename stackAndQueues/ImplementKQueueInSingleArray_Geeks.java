package stackAndQueues;

import java.util.Arrays;

public class ImplementKQueueInSingleArray_Geeks {
	private int[] arr;
	private int[] next;
	private int[] front;
	private int[] rear;
	private int free;
	
	public ImplementKQueueInSingleArray_Geeks(int k, int n) {
		arr = new int[n];
		next = new int[n];
		front = new int[k];
		rear = new int[k];
		free = 0;
		Arrays.fill(front, -1);
		Arrays.fill(rear, -1);
		Arrays.setAll(next, i -> i+1);
		next[n-1] = -1;
	}
	
	public void enqueue(int x, int qn) {
		arr[free] = x;
		int nas = next[free];
		if (front[qn] == -1) {
			front[qn] = free;
			rear[qn] = free;
		} else {
			next[rear[qn]] = free;
			rear[qn] = free;
		}
		next[free] = -1;
		free = nas;
	}
	
	public int dequeue(int qn) {
		int remidx = front[qn];
		int ans = arr[remidx];
		arr[remidx] = 0;
		front[qn] = next[remidx];	
		if (next[remidx] == -1) {
			rear[qn] = -1;
		}
		next[remidx] = free;
		free = remidx;
		return ans;
	}
	
	public void display() {
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(front));
		System.out.println(Arrays.toString(rear));
		System.out.println(Arrays.toString(next));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementKQueueInSingleArray_Geeks queue = new ImplementKQueueInSingleArray_Geeks(3, 10);
		queue.enqueue(5, 2);
		queue.enqueue(6, 2);
		queue.enqueue(7, 2);
		queue.enqueue(8, 1);
		queue.enqueue(9, 1);
		queue.enqueue(3, 0);
		queue.enqueue(4, 0);
		queue.display();
		System.out.println(queue.dequeue(2));
		System.out.println(queue.dequeue(1));
		queue.display();
	}

}

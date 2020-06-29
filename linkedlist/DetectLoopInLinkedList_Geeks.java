package linkedlist;


public class DetectLoopInLinkedList_Geeks {
	private static Node head;
	private static class Node {
		int val;
		Node next;
		public Node(int data) {
			// TODO Auto-generated constructor stub
			val = data;
			next = null;
		}
	}
	
	public int isLoop() {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				break;
			}
		}
		if (fast == null || fast.next == null) {
			return 0;
		} else {
			slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow.val;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DetectLoopInLinkedList_Geeks list = new DetectLoopInLinkedList_Geeks();
		list.head = new Node(2);
		list.head.next = new Node(3);
		list.head.next.next = new Node(4);
		list.head.next.next.next = new Node(5);
		list.head.next.next.next.next = list.head;
		System.out.println(list.isLoop());
	}

}

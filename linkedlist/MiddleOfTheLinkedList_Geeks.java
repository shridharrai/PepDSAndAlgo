package linkedlist;


public class MiddleOfTheLinkedList_Geeks {
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
	public int findMiddle() {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.val;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiddleOfTheLinkedList_Geeks list = new MiddleOfTheLinkedList_Geeks();
		list.head = new Node(2);
		list.head.next = new Node(3);
		list.head.next.next = new Node(4);
		list.head.next.next.next = new Node(5);
		list.head.next.next.next.next = new Node(6);
		System.out.println(list.findMiddle());
	}

}

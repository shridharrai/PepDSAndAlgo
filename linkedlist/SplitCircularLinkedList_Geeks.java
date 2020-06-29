package linkedlist;


public class SplitCircularLinkedList_Geeks {
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
		public void splitCircular() {
			Node slow = head;
			Node fast = head;
			while (fast.next != head && fast.next.next != head) {
				slow = slow.next;
				fast = fast.next.next;
			}
			//If list size is even
			if (fast.next.next == head) {
				fast = fast.next;
			}
			//Print second half
			Node slownxt = slow.next;
			fast.next = slownxt;
			Node head1 = head;
			display(slownxt, fast);
			//Print first half
			slow.next = head1;
			display(head1, slow);
		}
		
		private void display(Node head, Node tail) {
			while (head != tail) {
				System.out.print(head.val + " ");
				head = head.next;
			}
			System.out.print(tail.val + " ");
			System.out.println();
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SplitCircularLinkedList_Geeks list = new SplitCircularLinkedList_Geeks();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = list.head;
		list.splitCircular();
	}

}

package linkedlist;

import java.util.HashMap;

public class CloneLinkedlist_Geeks {
	private static Node head;
	private HashMap<Node, Node> map = new HashMap<Node, Node>();
	private static class Node {
		int val;
		Node next;
		Node ran;
		public Node(int data) {
			// TODO Auto-generated constructor stub
			val = data;
			next = null;
			ran = null;
		}
	}
	private void cloneWithSpace(Node head) {
		Node newhead = new Node(head.val);
		Node temp = head.next;
		Node newtemp = newhead;
		map.put(head, newhead);
		while (temp.next != null) {
			Node n = new Node(temp.val);
			map.put(temp, n);
			newtemp.next = n;
			temp = temp.next;
			newtemp = n;
		}
		Node n = new Node(temp.val);
		map.put(temp, n);
		newtemp.next = n;
		n.next = null;
		
		//random linking
		temp = head;
		newtemp = newhead;
		while (newtemp != null) {
			Node oldran = temp.ran;
			Node newran = map.get(oldran);
			newtemp.ran = newran;
			temp = temp.next;
			newtemp = newtemp.next;
		}
		display(newhead);
	}
	
	private void cloneWithoutSpace(Node head) {
		//Insertion
		Node temp = head;
		while (temp != null) {
			Node temp1 = temp.next;
			Node n = new Node(temp.val);
			temp.next = n;
			n.next = temp1;
			temp = temp1;
		}
		display(head);
		//Set random
		temp = head;
		while (temp != null) {
			temp.next.ran = temp.ran.next;
			temp = temp.next.next;
		}
		//Extraction
		temp = head;
		Node newHead = temp.next;
		Node newtemp = temp.next;
		while (temp != null) {
			Node temp1 = newtemp.next;
			Node newtemp1;
			if (temp1 != null) {
				newtemp1 = temp1.next;
			} else {
				newtemp1 = null;
			}
			temp.next = temp1;
			newtemp.next = newtemp1;
			temp = temp1;
			newtemp = newtemp1;
		}
		display(head);
		display(newHead);
	}
	
	private void display(Node node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CloneLinkedlist_Geeks list = new CloneLinkedlist_Geeks();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(5);
		list.head.ran = list.head.next.next;
		list.head.next.ran = list.head.next.next.next;
		list.head.next.next.ran = list.head.next.next.next.next;
		list.head.next.next.next.ran = list.head;
		list.head.next.next.next.next.ran = list.head.next;
//		list.display(list.head);
//		list.cloneWithSpace(list.head);
		list.cloneWithoutSpace(list.head);
	}

}

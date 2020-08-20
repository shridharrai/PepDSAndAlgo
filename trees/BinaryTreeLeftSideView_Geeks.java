package trees;

import java.util.LinkedList;
import java.util.List;


class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
public class BinaryTreeLeftSideView_Geeks {
	void leftView(Node root) {
		List<Integer> list = new LinkedList<Integer>();
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		while (queue.size() != 0) {
			int count = queue.size();
			Boolean isLeft = true;
			//For every level
			while (count > 0) {
				Node rem = queue.remove();
				if (rem.left != null) {
					queue.add(rem.left);
				}
				if (rem.right != null) {
					queue.add(rem.right);
				}
				if (isLeft) {
					list.add(rem.data);
					isLeft = false;
				}
				count--;
			}
		}
		System.out.println(list);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node = new Node(10);
		node.left = new Node(20);
		node.right = new Node(30);
		node.left.left = new Node(40);
		node.left.right = new Node(60);
		BinaryTreeLeftSideView_Geeks tree = new BinaryTreeLeftSideView_Geeks();
		tree.leftView(node);
	}

}

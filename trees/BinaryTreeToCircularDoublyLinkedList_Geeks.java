package trees;


public class BinaryTreeToCircularDoublyLinkedList_Geeks {
	TreeNode root;
	private static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int val) {
		          this.val = val;
		          this.left = null;
		          this.right = null;
		      }
		  }
	//O(n)
	public TreeNode bTreeToCList(TreeNode root) {
		TreeNode tail = helper(root);
		return tail.right;
	}
	
	private TreeNode helper(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		TreeNode lefttail = helper(root.left);
		TreeNode righttail = helper(root.right);
		root.right = root.left = root;
		if (lefttail == null && righttail == null) {
			return root;
		} else if (lefttail == null) {
			return concatenate(root, righttail);
		} else if (righttail == null) {
			return concatenate(lefttail, root);
		} else {
			TreeNode node = concatenate(lefttail, root);
			return concatenate(node, righttail);
		}
	}
	
	public TreeNode concatenate(TreeNode lefttail, TreeNode righttail) {
		TreeNode lefthead = lefttail.right;
		TreeNode righthead = righttail.right;
		lefttail.right = righthead;
		righthead.left = lefttail;
		lefthead.left = righttail;
		righttail.right = lefthead;
		return righttail;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeToCircularDoublyLinkedList_Geeks tree = new BinaryTreeToCircularDoublyLinkedList_Geeks();
		tree.root = new TreeNode(10);
		tree.root.left = new TreeNode(12);
		tree.root.right = new TreeNode(15);
		tree.root.left.left = new TreeNode(25);
		tree.root.left.right = new TreeNode(30);
		tree.root.right.left = new TreeNode(36);
		TreeNode head = tree.bTreeToCList(tree.root);
		System.out.println(head.val);
		System.out.println(head.right.val);
		System.out.println(head.left.val);
		System.out.println(head.right.right.val);
		System.out.println(head.right.left.val);
		System.out.println(head.right.right.right.val);
		System.out.println(head.right.right.left.val);
		System.out.println(head.right.right.right.right.val);
		System.out.println(head.right.right.right.left.val);
		System.out.println(head.right.right.right.right.right.val);
		System.out.println(head.right.right.right.right.left.val);
		System.out.println(head.right.right.right.right.right.right.val);
		System.out.println(head.right.right.right.right.right.left.val);
	}

}

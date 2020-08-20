package trees;


public class CloneBinaryTreeWithRandomPointers_Geeks {
	TreeNode root;
	private static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode rand;
		      TreeNode(int val) {
		          this.val = val;
		          this.left = null;
		          this.right = null;
		          this.rand = null;
		      }
		  }
	
	public static TreeNode cloneTree(TreeNode tree) {
		inOrder(tree);
		preOrder(tree);
		return extraction(tree);
	}
	
	//Insertion
	private static void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		TreeNode node = new TreeNode(root.val);
		TreeNode rootp1 = root.left;
		root.left = node;
		node.left = rootp1;
		inOrder(root.right);
	}
	
	//Seeting Random pointer
	private static void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.rand != null) {
			root.left.rand = root.rand.left;
		}
		preOrder(root.left.left);
		preOrder(root.right);
	}
	
	private static TreeNode extraction(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		TreeNode left = extraction(root.left.left);
		TreeNode right = extraction(root.right);
		if (left == null && right == null) {
			TreeNode myClone = root.left;
			root.left = null;
			return myClone;
		} else if (left == null) {
			TreeNode myClone = root.left;
			root.left = null;
			myClone.right = right;
			return myClone;
		} else if (right == null) {
			TreeNode myClone = root.left;
			root.left = root.left.left;
			myClone.left = left;
			return myClone;
		} else {
			TreeNode myClone = root.left;
			root.left = root.left.left;
			myClone.left = left;
			myClone.right = right;
			return myClone;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CloneBinaryTreeWithRandomPointers_Geeks tree = new CloneBinaryTreeWithRandomPointers_Geeks();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		tree.root.right.left.left = new TreeNode(8);
		tree.root.right.right.right = new TreeNode(9);
		TreeNode cloned = CloneBinaryTreeWithRandomPointers_Geeks.cloneTree(tree.root);
		System.out.println(cloned.val);
		System.out.println(cloned.left.val);
		System.out.println(cloned.right.val);
		System.out.println(cloned.left.left.val);
		System.out.println(cloned.left.right.val);
		System.out.println(cloned.right.left.val);
		System.out.println(cloned.right.right.val);
		System.out.println(cloned.right.left.left.val);
		System.out.println(cloned.right.right.right.val);
	}

}

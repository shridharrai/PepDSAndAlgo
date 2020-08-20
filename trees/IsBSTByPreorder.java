package trees;


public class IsBSTByPreorder {
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
	
	//O(n)
	public boolean isBST(TreeNode root) {
		return preOrder(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	

	private boolean preOrder(TreeNode root, int minValue, int maxValue) {
		// TODO Auto-generated method stub
		if (root == null) {
			return true;
		}
		if (root.val<minValue || root.val>maxValue) {
			return false;
		}
		return (preOrder(root.left, minValue, root.val-1) && preOrder(root.right, root.val+1, maxValue));
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsBSTByPreorder tree = new IsBSTByPreorder();
		tree.root = new TreeNode(100);
		tree.root.left = new TreeNode(50);
		tree.root.right = new TreeNode(150);
		tree.root.left.left = new TreeNode(25);
		tree.root.left.right = new TreeNode(75);
		tree.root.left.right.left = new TreeNode(63);
		tree.root.left.right.right = new TreeNode(87);
		tree.root.right.left = new TreeNode(125);
		tree.root.right.right = new TreeNode(175);
		tree.root.right.right.left = new TreeNode(163);
		tree.root.right.right.right = new TreeNode(187);
		System.out.println(tree.isBST(tree.root));
	}

}

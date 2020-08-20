package trees;


public class FlattenBinaryTreeToLinkedList_114 {
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
	
	public void flatten(TreeNode root) {
		helper(root);
	}
	
	private TreeNode helper(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		TreeNode lefttail = helper(root.left);
		TreeNode righttail = helper(root.right);
		if (lefttail == null && righttail == null) {
			return root;
		} else if (lefttail == null) {
			return righttail;
		} else if (righttail == null) {
			TreeNode lefthead = root.left;
			root.right = lefthead;
			root.left = null;
			return lefttail;
		} else {
			TreeNode righthead = root.right;
			TreeNode lefthead = root.left;
			root.right = lefthead;
			root.left = null;
			lefttail.right = righthead;
			return righttail;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

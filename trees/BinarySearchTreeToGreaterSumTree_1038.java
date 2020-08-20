package trees;


public class BinarySearchTreeToGreaterSumTree_1038 {
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
	int sum = 0;
	
	public TreeNode bstToGst(TreeNode root) {
		inOrder(root);
		return root;
	}
	
	private void inOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.right);
		sum = sum + node.val;
		node.val = sum;
		inOrder(node.left);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}

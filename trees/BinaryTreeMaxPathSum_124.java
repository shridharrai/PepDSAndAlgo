package trees;

public class BinaryTreeMaxPathSum_124 {
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
	private int result = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		maxSumRec(root);
		return result;
	}
	
	public int maxSumRec(TreeNode root) {
		//Base case
		if (root == null) {
			return 0;
		}
		
		int left = maxSumRec(root.left);
		int right = maxSumRec(root.right);
		
		int maxlinearpathsum = Math.max(Math.max(left, right)+root.val, root.val);
		int overallmaxpathsum = Math.max(maxlinearpathsum, root.val+left+right);
		
		result = Math.max(result, overallmaxpathsum);
		return maxlinearpathsum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeMaxPathSum_124 tree = new BinaryTreeMaxPathSum_124();
		tree.root = new TreeNode(-10);
		tree.root.left = new TreeNode(9);
		tree.root.right = new TreeNode(20);
		tree.root.left.left = new TreeNode(-4);
		tree.root.left.right = new TreeNode(15);
		tree.root.left.right.left = new TreeNode(7);
		tree.root.left.right.right = new TreeNode(10);
		tree.root.right.left = new TreeNode(15);
		tree.root.right.right = new TreeNode(7);
		System.out.println(tree.maxPathSum(tree.root));
	}

}

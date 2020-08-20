package trees;


public class DistributeCoinsInBinaryTree_979 {
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
	int ans = 0;
	//O(n)
	public int distributeCoins(TreeNode root) {
		postorder(root);
		return ans;
	}
	
	public int postorder(TreeNode curr) {
		if (curr == null) {
			return 0;
		}
		
		int left = postorder(curr.left);
		int right = postorder(curr.right);
		ans = ans + Math.abs(left) + Math.abs(right);
		return (left + right + curr.val - 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(0);
		node.left = new TreeNode(3);
		node.right = new TreeNode(2);
		node.left.left = new TreeNode(0);
		node.left.right = new TreeNode(1);
		node.left.right.left = new TreeNode(4);
		node.left.right.right = new TreeNode(0);
		node.right.left = new TreeNode(2);
		node.right.right = new TreeNode(0);
		node.right.right.right = new TreeNode(1);
		node.right.left.right = new TreeNode(0);
		node.right.left.right.left = new TreeNode(0);
		node.right.left.right.right = new TreeNode(0);
		DistributeCoinsInBinaryTree_979 tree = new DistributeCoinsInBinaryTree_979();
		System.out.println(tree.distributeCoins(node));
	}

}

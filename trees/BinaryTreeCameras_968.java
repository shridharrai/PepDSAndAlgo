package trees;


public class BinaryTreeCameras_968 {
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
	
	public int minCameraCover(TreeNode root) {
		int min = postOrder(root);
//		System.out.println("Min is "+min);
		if (min == 1) {
			return ++ans;
		} else {
			return ans;
		}
	}
	
	public int postOrder(TreeNode node) {
		if (node == null) {
			return 3;
		}
		if (node.left == null && node.right == null) {
			return 1;
		}
		int left = postOrder(node.left);
		int right = postOrder(node.right);
		if (left == 1 || right == 1) {
			ans++;
			return 2;
		}
		else if (left == 2 || right == 2) {
			return 3;
		}
		else {
			return 1;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(0);
		BinaryTreeCameras_968 tree = new BinaryTreeCameras_968();
		System.out.println(tree.minCameraCover(node));
	}

}

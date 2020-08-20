package trees;

import java.util.HashMap;


public class BinaryTreeFromInorderAndPostorder_106 {
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
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	//O(n)
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return construct(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
	}
	
	private TreeNode construct(int[] postorder, int psi, int pei, int[] inorder, int isi, int iei) {
		if (psi > pei || isi > iei) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[pei]);
		int idx = map.get(postorder[pei]);
		int count = iei-idx;
		root.left = construct(postorder, psi, pei-count-1, inorder, isi, idx-1);
		root.right = construct(postorder, pei-count, pei-1, inorder, idx+1, iei);
		return root;
	}
}

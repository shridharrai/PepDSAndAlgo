package trees;

import java.util.HashMap;

public class BinaryTreeFromInorderAndPreorder_105 {
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
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return construct(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
	}
	
	private TreeNode construct(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {
		if (psi > pei || isi > iei) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[psi]);
		int idx = map.get(preorder[psi]);
		int count = idx-psi;
		root.left = construct(preorder, psi+1, psi+count, inorder, isi, idx-1);
		root.right = construct(preorder, psi+count+1, pei, inorder, idx+1, iei);
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

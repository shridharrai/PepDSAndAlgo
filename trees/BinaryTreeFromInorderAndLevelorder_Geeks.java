package trees;

import java.util.HashMap;
import java.util.Scanner;

public class BinaryTreeFromInorderAndLevelorder_Geeks {
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
	//O(nlogn)
	public TreeNode buildTree(int[] inorder, int[] levelorder) {
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return construct(levelorder, inorder, 0, inorder.length-1);
	}
	
	private TreeNode construct(int[] level, int[] inorder, int isi, int iei) {
		// TODO Auto-generated method stub
		if (level.length == 0 || isi > iei) {
			return null;
		}
		TreeNode root = new TreeNode(level[0]);
		int idx = map.get(level[0]);
		int count = idx-isi;
		int[] leftlevel = new int[count];
		int[] rightlevel = new int[iei - idx];
		int j = 0,k = 0;
		
		for (int i = 1; i < level.length; i++) {
			int idx1 = map.get(level[i]);
			if (idx1 >= isi && idx1 < idx) {
				leftlevel[j] = level[i];
				j++;
			}
			else if(idx1 > idx && idx1 <= iei) {
				rightlevel[k] = level[i];
				k++;
			}
		}
		root.left = construct(leftlevel, inorder, isi, idx-1);
		root.right = construct(rightlevel, inorder, idx+1, iei);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] inorder = {5,9,30,3,15,20,7};
//		int[] levelorder = {3,9,20,5,30,15,7};
//		BinaryTreeFromInorderAndLevelorder_Geeks tree = new BinaryTreeFromInorderAndLevelorder_Geeks();
//		tree.root = tree.buildTree(inorder, levelorder);
//		System.out.println(tree.root.val);
//		System.out.println(tree.root.left.val);
//		System.out.println(tree.root.right.val);
//		System.out.println(tree.root.left.left.val);
//		System.out.println(tree.root.left.right.val);
//		System.out.println(tree.root.right.left.val);
//		System.out.println(tree.root.right.right.val);
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] inorder = new int[n];
			int[] levelorder = new int[n];
			for (int i = 0; i < n; i++) {
				inorder[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				levelorder[i] = sc.nextInt();
			}
			BinaryTreeFromInorderAndLevelorder_Geeks tree = new BinaryTreeFromInorderAndLevelorder_Geeks();
			System.out.println(tree.buildTree(inorder, levelorder).val);
		}
	}

}

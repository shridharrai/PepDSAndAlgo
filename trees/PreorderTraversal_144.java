package trees;

import java.util.ArrayList;
import java.util.List;


public class PreorderTraversal_144 {
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
	
	public List<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		TreeNode curr = root;
		
		while (curr != null) {
			//If left child is null then process it
			if (curr.left == null) {
				list.add(curr.val);
				curr = curr.right;
			} else {
				TreeNode currp1 = curr.left;
				//Find the rightmost node of currp1
				while (currp1.right != null && currp1.right != curr) {
					currp1 = currp1.right;
				}
				
				if (currp1.right == null) {
                    list.add(curr.val);
					currp1.right = curr;
					curr = curr.left;
				} else {
					
					currp1.right = null;
					curr = curr.right;
				}
			}
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PreorderTraversal_144 tree = new PreorderTraversal_144();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		System.out.println(tree.preorderTraversal(tree.root));
	}

}

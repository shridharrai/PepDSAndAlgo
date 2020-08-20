package trees;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal_145 {
	TreeNode root;
	private static class TreeNode {
		      char val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(char val) {
		          this.val = val;
		          this.left = null;
		          this.right = null;
		      }
		  }
	
	public List<Character> postorderTraversal(TreeNode root) {
		ArrayList<Character> list = new ArrayList<Character>();
		TreeNode curr = root;
		//First find reverse preorder
		while (curr != null) {
			//If right child is null then process it
			if (curr.right == null) {
				list.add(curr.val);
				curr = curr.left;
			} else {
				TreeNode currp1 = curr.right;
				//Find the leftmost node of currp1
				while (currp1.left != null && currp1.left != curr) {
					currp1 = currp1.left;
				}
				/*If leftmost node is not linked then it means right
				side is not processed so make a chain for backtracking
				and process the right side*/
				if (currp1.left == null) {
                    list.add(curr.val);
					currp1.left = curr;
					curr = curr.right;
				} else {
					/*If leftmost node is already linked then it means
					 * right side is already processed so
					 * traverse to the left side*/ 
					currp1.left = null;
					curr = curr.left;
				}
			}
		}
		//Then finally reverse the reverse preorder also
		List<Character> ans = new ArrayList<Character>();
		for (int i = list.size()-1; i >= 0; i--) {
			ans.add(list.get(i));
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PostorderTraversal_145 tree = new PostorderTraversal_145();
		tree.root = new TreeNode('a');
		tree.root.left = new TreeNode('b');
		tree.root.right = new TreeNode('l');
		tree.root.left.left = new TreeNode('c');
		tree.root.left.right = new TreeNode('e');
		tree.root.left.right.right = new TreeNode('f');
		tree.root.left.left.left = new TreeNode('d');
		tree.root.left.left.right = new TreeNode('h');
		System.out.println(tree.postorderTraversal(tree.root));
	}

}

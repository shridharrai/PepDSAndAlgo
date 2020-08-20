package trees;

import java.util.HashMap;


public class LCAOfBinaryTree_236 {
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
	HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
	HashMap<TreeNode, Integer> levelMap = new HashMap<>();
	HashMap<TreeNode, TreeNode> grandparentMap = new HashMap<>();
	int totallevels = 0;
	//O(sqrt(h))
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//		return postOrder(root, p, q);
		preOrder(root, null, 0);
		for (TreeNode key : levelMap.keySet()) {
			if (levelMap.get(key) > totallevels) {
				totallevels = levelMap.get(key);
			}
		}
		totallevels++;
		grandparentMap.put(root, null);
		grandparentpreorder(root.left);
		grandparentpreorder(root.right);
		System.out.println("Parent Map");
		for (TreeNode key : parentMap.keySet()) {
			if (parentMap.get(key) == null) {
				System.out.println(key.val + "->" + "null");
			}
			else {
				System.out.println(key.val + "->" + parentMap.get(key).val);
			}
			
		}
		System.out.println("Level Map");
		for (TreeNode key : levelMap.keySet()) {
			System.out.println(key.val + "->" + levelMap.get(key));
		}
		System.out.println("GrandParent Map");
		for (TreeNode key : grandparentMap.keySet()) {
			if (grandparentMap.get(key) == null) {
				System.out.println(key.val + "->" + "null");
			}
			else {
				System.out.println(key.val + "->" + grandparentMap.get(key).val);
			}
			
		}
		
		int level1 = levelMap.get(p);
		int level2 = levelMap.get(q);
		int box1 = level1/totallevels;
		int box2 = level2/totallevels;
		
		//Make box levels equal first
		int count = Math.abs(box1-box2);
		if (box1 > box2) {
			while (count != 0) {
				p = grandparentMap.get(p);
				count--;
			}
		} else {
			while (count != 0) {
				q = grandparentMap.get(q);
				count--;
			}
		}
		
		//Make levels equal
		level1 = levelMap.get(p);
		level2 = levelMap.get(q);
		count = Math.abs(level1-level2);
		if (level1 > level2) {
			while (count != 0) {
				p = parentMap.get(p);
				count--;
			}
		} else {
			while (count != 0) {
				q = parentMap.get(q);
				count--;
			}
		}
		
		//Check until grandparents are equal
		while (grandparentMap.get(p) != grandparentMap.get(q)) {
			p = grandparentMap.get(p);
			q = grandparentMap.get(q);
		}
		
		//Now, finally jump until intersection is find
		while (p.val != q.val) {
			p = parentMap.get(p);
			q = parentMap.get(q);
		}
		//O(h)
//		System.out.println("levels are "+totallevels);
//		int level1 = levelMap.get(p);
//		int level2 = levelMap.get(q);
//		int count = Math.abs(level1-level2);
//		if (level1 > level2) {
//			while (count != 0) {
//				p = parentMap.get(p);
//				count--;
//			}
//		} else {
//			while (count != 0) {
//				q = parentMap.get(q);
//				count--;
//			}
//		}
//			while (p.val != q.val) {
//				p = parentMap.get(p);
//				q = parentMap.get(q);
//			}
////		}
		return p;
	}
	
	//O(n)
	public TreeNode postOrder(TreeNode node, TreeNode p, TreeNode q) {
		if (node == null) {
			return null;
		}
		TreeNode left = postOrder(node.left, p, q);
		TreeNode right = postOrder(node.right, p, q);
		if (node.val == p.val || node.val == q.val) {
			return node;
		}
		if (left == null && right == null) {
			return null;
		}
		else if (left != null && right != null) {
			return node;
		} else if (left != null && right == null) {
			return left;
		} else {
			 return right;
		}
	}
	
	public void preOrder(TreeNode curr, TreeNode parent, int level) {
		if (curr == null) {
			return;
		}
		parentMap.put(curr, parent);
		levelMap.put(curr, level);
		preOrder(curr.left, curr, level+1);
		preOrder(curr.right, curr, level+1);
	}
	
	public void grandparentpreorder(TreeNode curr) {
		if (curr == null) {
			return;
		}
		
		int level = levelMap.get(curr);
		if (level % (int)(Math.ceil(Math.sqrt(totallevels))) == 0) {
			grandparentMap.put(curr, parentMap.get(curr));
		} else {
			grandparentMap.put(curr, grandparentMap.get(parentMap.get(curr)));
		}
		grandparentpreorder(curr.left);
		grandparentpreorder(curr.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(5);
		node.right = new TreeNode(1);
		node.left.left = new TreeNode(6);
		node.left.right = new TreeNode(2);
		node.left.right.left = new TreeNode(7);
		node.left.right.right = new TreeNode(4);
		node.right.left = new TreeNode(0);
		node.right.right = new TreeNode(8);
		TreeNode p = node.left;
		TreeNode q = node.right;
		LCAOfBinaryTree_236 tree = new LCAOfBinaryTree_236();
		System.out.println("LCA is "+tree.lowestCommonAncestor(node, p, q).val);
//		tree.lowestCommonAncestor(node, p, q);
	}

}

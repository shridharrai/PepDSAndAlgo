package trees;


public class SerializeAndDeserializeBinaryTree_297 {
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
	int i = 0;
	public String serialize(TreeNode root) {
		if (root == null) {
			return "#";
		}
		String left = serialize(root.left);
		String right = serialize(root.right);
		return root.val + " "+ left + " " + right;
	}
	
	public TreeNode deserialize(String data) {
		return helper(data.split(" "));
	}
	
	private TreeNode helper(String[] split) {
		// TODO Auto-generated method stub
		if (split[i].equals("#") ) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(split[i]));
		i++;
		root.left = helper(split);
		i++;
		root.right = helper(split);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SerializeAndDeserializeBinaryTree_297 tree = new SerializeAndDeserializeBinaryTree_297();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(8);
		tree.root.left.right.left = new TreeNode(6);
		String str = tree.serialize(tree.root);
		System.out.println(str);
		System.out.println(tree.deserialize(str).val);
	}

}

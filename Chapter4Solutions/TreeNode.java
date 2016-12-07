public class TreeNode {
	
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
		
	public TreeNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

	public void removeSingleChild(TreeNode n){
		if (n == this.left) this.left = null;
		else if (n == this.right) this.right = null;
	}

	public boolean whichChildAmI(TreeNode n){
		if (parent.left == n) {
			return false;
		}
		else if (parent.right == n){
			return true;
		}
		else {
			throw new UnsupportedOperationException();
		}
	}

	public static TreeNode leftmostInRightTree(TreeNode n){
		if (n == null) return null;
		else {
			while (n != null){
				n = n.left;
			}
		}
		return n;
	}
}

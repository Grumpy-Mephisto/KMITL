package code;

public class TreeNode {
    public int val;
    public TreeNode left, right, parent;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        if (left != null && right != null) {
            return "Node: " + val + " Left: " + left.val + " Right: " + right.val;
        } else if (left != null) {
            return "Node: " + val + " Left: " + left.val;
        } else if (right != null) {
            return "Node: " + val + " Right: " + right.val;
        } else {
            return "Node: " + val;
        }
    }
}

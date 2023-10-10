package code;

public class TreeNode {
    public int val;
    public TreeNode left, right, parent;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String leftStr = left == null ? "null" : String.valueOf(left.val);
        String rightStr = right == null ? "null" : String.valueOf(right.val);
        return leftStr + " ← " + val + " → " + rightStr;
    }
}

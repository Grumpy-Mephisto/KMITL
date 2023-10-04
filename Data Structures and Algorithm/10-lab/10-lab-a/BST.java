import code.TreeNode;

public class BST {
    TreeNode root;

    public BST() {
        root = null;
    }

    public void insert(int e) {
        if (root == null) {
            root = new TreeNode(e);
        } else {
            TreeNode curr = root;
            while (curr != null) {
                if (e < curr.val) {
                    if (curr.left != null) {
                        curr = curr.left;
                    } else {
                        /**
                         * Code 1
                         */
                        curr.left = new TreeNode(e);
                        curr.left.parent = curr;
                        return;
                    }
                } else {
                    if (curr.right != null) {
                        /**
                         * Code 2
                         */
                        curr = curr.right;
                    } else {
                        curr.right = new TreeNode(e);
                        curr.right.parent = curr;
                        return;
                    }
                }
            }
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public void printPreOrder() {
        printPreOrderRecurse(root);
    }

    public void printPreOrderRecurse(TreeNode root) {
        /**
         * Code 3
         */
        if (root == null) {
            return;
        }
        printPreOrderRecurse(root.left);
        System.out.print(root.val + " ");
        printPreOrderRecurse(root.right);
    }

    public void printInOrder() {
        printInOrderRecurse(root);
    }

    public void printInOrderRecurse(TreeNode root) {
        /**
         * Code 4
         */
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printInOrderRecurse(root.left);
        printInOrderRecurse(root.right);
    }

    public void printPostOrder() {
        printPostOrderRecurse(root);
    }

    public void printPostOrderRecurse(TreeNode root) {
        /**
         * Code 5
         */
        if (root == null) {
            return;
        }
        printPostOrderRecurse(root.left);
        printPostOrderRecurse(root.right);
        System.out.print(root.val + " ");
    }

    public TreeNode search(int e) {
        return searchRecurse(root, e);
    }

    public TreeNode searchRecurse(TreeNode root, int e) {
        if (root == null) {
            return null;
        }
        if (root.val == e) {
            return root;
        }
        /**
         * Code 7
         */
        if (e < root.val) {
            return searchRecurse(root.left, e);
        } else {
            return searchRecurse(root.right, e);
        }
    }

    public TreeNode searchIter(int key) {
        TreeNode curr = root;
        while (curr != null) {
            if (key < curr.val) {
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    return null;
                }
            } else {
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    return null;
                }
            }
            if (curr.val == key) {
                return curr;
            }
            /**
             * Code 8
             */
            if (curr.right == null && curr.left == null) {
                break;
            }
        }
        return null;
    }
}

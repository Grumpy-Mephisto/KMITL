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
                        curr.left = new TreeNode(e);
                        curr.left.parent = curr;
                        return;
                    }
                } else {
                    if (curr.right != null) {
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

            if (curr.right == null && curr.left == null) {
                break;
            }
        }
        return null;
    }

    public int height() {
        return root == null ? 0 : height(root);
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        /**
         * Code 9
         */
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public TreeNode findMaxFrom(TreeNode valueFrom) {
        /**
         * 10
         */
        if (valueFrom == null) {
            return null;
        }
        TreeNode curr = valueFrom;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr;
    }

    public void delete(int e, TreeNode current) {
        if (current == null) {
            return;
        }

        if (e < current.val) {
            delete(e, current.left);
        } else if (e > current.val) {
            delete(e, current.right);
        } else {
            if (current.left == null || current.right == null) {
                TreeNode temp = (current.left == null) ? current.right : current.left;
                if (current.parent.left == current) {
                    current.parent.left = temp;
                } else {
                    current.parent.right = temp;
                }

                if (temp != null) {
                    temp.parent = current.parent;
                }
            } else {
                TreeNode successor = findMaxFrom(current.left);
                /**
                 * Code 11
                 */
                current.val = successor.val;
                delete(successor.val, current.left);
            }
        }
    }

    public void delete(int e) {
        delete(e, root);
    }
}

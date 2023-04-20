package RootedTree;

public class Tree {

  Node root;

  public Tree() {
    root = null;
  }

  public void insert(String[] tokens) {
    root = insert(root, tokens, 0);
  }

  private Node insert(Node node, String[] tokens, int index) {
    if (index >= tokens.length) {
      return null;
    }

    if (isOperator(tokens[index])) {
      node = new Node(tokens[index]);
      node.left = insert(node.left, tokens, index + 1);
      node.right = insert(node.right, tokens, index + 2);
    } else {
      node = new Node(tokens[index]);
    }

    return node;
  }

  private boolean isOperator(String data) {
    return (
      data.equals("+") ||
      data.equals("-") ||
      data.equals("*") ||
      data.equals("/")
    );
  }

  public void print() {
    print(root, "", true);
  }

  private void print(Node node, String prefix, boolean isTail) {
    if (node != null) {
      System.out.println(prefix + (isTail ? "└── " : "├── ") + node.data);
      if (node.right != null) {
        print(node.right, prefix + (isTail ? "    " : "│   "), false);
      }
      if (node.left != null) {
        print(
          node.left,
          prefix + (isTail ? "    " : "│   "),
          node.right == null
        );
      }
    }
  }
}

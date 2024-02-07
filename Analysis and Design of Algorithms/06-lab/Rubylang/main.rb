class TreeNode
  # Represents a node in a binary tree.
  #
  # @param val [Object] The value stored in the node.
  # @param left [TreeNode, nil] The left child of the node.
  # @param right [TreeNode, nil] The right child of the node.
    attr_accessor :val, :left, :right
  
    def initialize(val, left = nil, right = nil)
    # Initializes a TreeNode with a value and optional left and right children.
    #
    # @param val [Object] The value stored in the node.
    # @param left [TreeNode, nil] The left child of the node.
    # @param right [TreeNode, nil] The right child of the node.
      @val = val
      @left = left
      @right = right
    end
  
    def pre_order
    # Performs a pre-order traversal of the binary tree rooted at this node.
    #
    # @return [String] The pre-order traversal of the tree.
      return '' if self.nil?
      "#{val} " + (left ? left.pre_order : '') + (right ? right.pre_order : '')
    end
  
    def in_order
    # Performs an in-order traversal of the binary tree rooted at this node.
    #
    # @return [String] The in-order traversal of the tree.
      return '' if self.nil?
      (left ? left.in_order : '') + "#{val} " + (right ? right.in_order : '')
    end
  
    def post_order
    # Performs a post-order traversal of the binary tree rooted at this node.
    #
    # @return [String] The post-order traversal of the tree.
      return '' if self.nil?
      (left ? left.post_order : '') + (right ? right.post_order : '') + "#{val} "
    end
  end
  
  def mockup_test_tree
    root = TreeNode.new('N')
    root.left = TreeNode.new('O')
    root.right = TreeNode.new('P')
    root.left.left = TreeNode.new('P')
    root.left.right = TreeNode.new('A')
    root.right.left = TreeNode.new('K')
    root.right.right = TreeNode.new('O')
    root.left.left.left = TreeNode.new('R')
    root.left.left.right = TreeNode.new('N')
    root
  end
  
  root = mockup_test_tree
  
  puts "Pre-order traversal: " + root.pre_order.strip
  puts "In-order traversal: " + root.in_order.strip
  puts "Post-order traversal: " + root.post_order.strip
  
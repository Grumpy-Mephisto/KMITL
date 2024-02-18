class TreeNode
    attr_accessor :val, :left, :right
  
    def initialize(val, left = nil, right = nil)
      @val = val
      @left = left
      @right = right
    end
  
    def pre_order
      return '' if self.nil?
      "#{val} " + (left ? left.pre_order : '') + (right ? right.pre_order : '')
    end
  
    def in_order
      return '' if self.nil?
      (left ? left.in_order : '') + "#{val} " + (right ? right.in_order : '')
    end
  
    def post_order
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
  
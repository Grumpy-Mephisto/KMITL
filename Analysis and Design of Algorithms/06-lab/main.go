//go:build main

package main

import (
	"fmt"
	"strings"
)

type TreeNode struct {
	Val   rune
	Left  *TreeNode
	Right *TreeNode
}

func (node *TreeNode) preOrder() string {
	if node == nil {
		return ""
	}
	return fmt.Sprintf("%c ", node.Val) + node.Left.preOrder() + node.Right.preOrder()
}

func (node *TreeNode) inOrder() string {
	if node == nil {
		return ""
	}
	return node.Left.inOrder() + fmt.Sprintf("%c ", node.Val) + node.Right.inOrder()
}

func (node *TreeNode) postOrder() string {
	if node == nil {
		return ""
	}
	return node.Left.postOrder() + node.Right.postOrder() + fmt.Sprintf("%c ", node.Val)
}

func main() {
	root := mockupTestTree()

	fmt.Print("Pre-order traversal: ")
	fmt.Println(strings.TrimSpace(root.preOrder()))
	fmt.Print("In-order traversal: ")
	fmt.Println(strings.TrimSpace(root.inOrder()))
	fmt.Print("Post-order traversal: ")
	fmt.Println(strings.TrimSpace(root.postOrder()))
}

func mockupTestTree() *TreeNode {
	root := &TreeNode{Val: 'N'}
	root.Left = &TreeNode{Val: 'O'}
	root.Right = &TreeNode{Val: 'P'}
	root.Left.Left = &TreeNode{Val: 'P'}
	root.Left.Right = &TreeNode{Val: 'A'}
	root.Right.Left = &TreeNode{Val: 'K'}
	root.Right.Right = &TreeNode{Val: 'O'}
	root.Left.Left.Left = &TreeNode{Val: 'R'}
	root.Left.Left.Right = &TreeNode{Val: 'N'}
	return root
}

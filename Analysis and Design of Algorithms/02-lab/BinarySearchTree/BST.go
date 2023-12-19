package main

import "fmt"

type StudentID = int

type Node struct {
	Value StudentID
	Left  *Node
	Right *Node
}

type BST struct {
	Root *Node
}

func (bst *BST) Insert(value StudentID) {
	if bst.Root == nil {
		bst.Root = &Node{Value: value}
		return
	}

	insertNode(bst.Root, value)
}

func insertNode(root *Node, value StudentID) {
	if value < root.Value {
		if root.Left == nil {
			root.Left = &Node{Value: value}
		} else {
			insertNode(root.Left, value)
		}
	} else if value > root.Value {
		if root.Right == nil {
			root.Right = &Node{Value: value}
		} else {
			insertNode(root.Right, value)
		}
	}
}

func (bst *BST) GetValues() []StudentID {
	values := []StudentID{}
	getValues(bst.Root, &values)
	return values
}

func getValues(root *Node, values *[]StudentID) {
	if root != nil {
		getValues(root.Left, values)
		*values = append(*values, root.Value)
		getValues(root.Right, values)
	}
}

func (bst *BST) FindMax() StudentID {
	if bst.Root == nil {
		return -1
	}

	current := bst.Root
	for current.Right != nil {
		current = current.Right
	}

	return current.Value
}

func (bst *BST) FindMin() StudentID {
	if bst.Root == nil {
		return -1
	}

	current := bst.Root
	for current.Left != nil {
		current = current.Left
	}

	return current.Value
}

func (bst *BST) PrintTree() {
	printTree(bst.Root)
}

func printTree(root *Node) {
	if root != nil {
		printTree(root.Left)
		fmt.Printf("%d ", root.Value)
		printTree(root.Right)
	}
}

func main() {
	studentIDs := []StudentID{12, 47, 32, 75, 16, 45, 39, 86, 23, 43}
	bst := BST{}

	for _, id := range studentIDs {
		bst.Insert(id)
		fmt.Printf("After inserting %d: ", id)
		bst.PrintTree()
		fmt.Println()
	}
	fmt.Println()

	maxValue := bst.FindMax()
	minValue := bst.FindMin()

	fmt.Println("Max value is:", maxValue)
	fmt.Println("Min value is:", minValue)
}

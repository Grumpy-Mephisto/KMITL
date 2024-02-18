package main

import (
	"container/list"
	"fmt"
)

type GraphTraversal interface {
	DFS(start byte) []byte
	BFS(start byte) []byte
}

type Graph struct {
	nodes map[byte][]byte
}

func NewGraph(L string, v [][]byte) *Graph {
	graph := &Graph{
		nodes: make(map[byte][]byte),
	}

	for i := range L {
		node := L[i]
		neighbors := []byte(v[i])
		graph.nodes[node] = neighbors
	}

	return graph
}

func (g *Graph) BuildGraph(L string, v [][]byte) {
	for i := range L {
		node := L[i]
		neighbors := []byte(v[i])
		g.nodes[node] = neighbors
	}
}

func (g *Graph) DFS(start byte) []byte {
	visited := make(map[byte]bool)
	result := []byte{}
	stack := []byte{start}

	for len(stack) > 0 {
		node := stack[len(stack)-1]
		stack = stack[:len(stack)-1]

		if !visited[node] {
			result = append(result, node)
			visited[node] = true

			for i := len(g.nodes[node]) - 1; i >= 0; i-- {
				neighbor := g.nodes[node][i]
				if !visited[neighbor] {
					stack = append(stack, neighbor)
				}
			}
		}
	}

	return result
}

func (g *Graph) BFS(start byte) []byte {
	visited := make(map[byte]bool)
	result := []byte{}
	queue := list.New()

	result = append(result, start)
	visited[start] = true
	queue.PushBack(start)

	for queue.Len() > 0 {
		node := queue.Front()
		queue.Remove(node)

		current := node.Value.(byte)
		for _, neighbor := range g.nodes[current] {
			if !visited[neighbor] {
				result = append(result, neighbor)
				visited[neighbor] = true
				queue.PushBack(neighbor)
			}
		}
	}

	return result
}

func main() {
	L := "ABCDEFGH"
	v := [][]byte{
		[]byte("GFDB"),
		[]byte("AHC"),
		[]byte("B"),
		[]byte("AE"),
		[]byte("FD"),
		[]byte("AE"),
		[]byte("A"),
		[]byte("B"),
	}

	graph := NewGraph(L, v)

	fmt.Println("Adjacent Lists:")
	for node, neighbors := range graph.nodes {
		fmt.Printf("%c: %c\n", node, neighbors)
	}

	fmt.Print("DFS: ")
	dfsResult := graph.DFS(L[0])
	for _, node := range dfsResult {
		fmt.Printf("%c ", node)
	}

	fmt.Print("\nBFS with Queue: ")
	bfsResult := graph.BFS(L[0])
	for _, node := range bfsResult {
		fmt.Printf("%c ", node)
	}

	fmt.Println()
}

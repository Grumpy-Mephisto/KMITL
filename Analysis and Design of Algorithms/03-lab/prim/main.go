// This file contains an implementation of Prim's algorithm to find the minimum spanning tree of a graph.
// It includes methods for graph initialization, edge addition, and carrying out Prim's algorithm.

package main

import (
	"fmt"
	"math"
)

const inf = math.MaxInt32

type Graph struct {
	vertices int
	matrix   [][]int
}

// init initializes the graph with a given number of vertices.
// Each element of the adjacency matrix is set to 'inf', representing no direct connection.
//
// Parameters:
// - vertices: The number of vertices in the graph.
func (g *Graph) init(vertices int) {
	g.vertices = vertices
	g.matrix = make([][]int, vertices)
	for i := range g.matrix {
		g.matrix[i] = make([]int, vertices)
		for j := range g.matrix[i] {
			g.matrix[i][j] = inf
		}
	}
}

// addEdge adds a weighted, undirected edge between two vertices in the graph.
//
// Parameters:
// - src: The source vertex of the edge.
// - dst: The destination vertex of the edge.
// - weight: The weight of the edge.
func (g *Graph) addEdge(src, dst, weight int) {
	g.matrix[src][dst] = weight
	g.matrix[dst][src] = weight
}

// prim calculates the minimum cost to construct a minimum spanning tree using Prim's algorithm.
// It starts from vertex 0 and selects the minimum weight edge from the set of edges.
//
// Returns:
// - The minimum cost to construct the minimum spanning tree.
func (g *Graph) prim() int {
	selected := make([]bool, g.vertices)
	selected[0] = true // Start from vertex 0

	minWeight := 0

	for i := 0; i < g.vertices-1; i++ {
		min := inf
		minIndex := -1

		for v := 0; v < g.vertices; v++ {
			if !selected[v] && g.matrix[i][v] < min {
				min = g.matrix[i][v]
				minIndex = v
			}
		}

		if minIndex != -1 {
			selected[minIndex] = true
			minWeight += min
		}
	}

	return minWeight
}

// getUserInput obtains an integer input from the user with a custom prompt.
// It will repeat the prompt until a valid integer is entered.
//
// Parameter:
// - prompt: The message displayed to the user asking for input.
//
// Returns:
// - The integer input provided by the user.
func getUserInput(prompt string) int {
	var input int
	fmt.Print(prompt)
	_, err := fmt.Scanln(&input)
	if err != nil {
		fmt.Println("Please enter a valid number.")
		return getUserInput(prompt)
	}
	return input
}

// main is the entry point of the program.
// It prompts the user for necessary graph information, initializes the graph, and runs Prim's algorithm to find
// the minimum spanning tree. It then prints the minimum cost of the tree.
func main() {
	fmt.Println("===== Prim's Algorithm =====")

	numOfVertices := getUserInput("Enter the number of vertices: ")
	numOfEdges := getUserInput("Enter the number of edges: ")

	g := Graph{}
	g.init(numOfVertices)

	for i := 0; i < numOfEdges; i++ {
		u := getUserInput(fmt.Sprintf("Enter vertex u for edge %d: ", i+1))
		v := getUserInput(fmt.Sprintf("Enter vertex v for edge %d: ", i+1))
		w := getUserInput(fmt.Sprintf("Enter weight w for edge %d: ", i+1))
		g.addEdge(u, v, w)
	}

	if numOfEdges < numOfVertices-1 {
		fmt.Println("Graph is not connected.")
		return
	}

	minCost := g.prim()

	fmt.Printf("Minimum cost: %d\n", minCost)
}

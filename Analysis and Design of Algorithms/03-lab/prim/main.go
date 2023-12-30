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

func (g *Graph) addEdge(src, dst, weight int) {
	g.matrix[src][dst] = weight
	g.matrix[dst][src] = weight
}

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

func readUserInput(prompt string) int {
	var input int
	fmt.Print(prompt)
	_, err := fmt.Scanln(&input)
	if err != nil {
		fmt.Println("Please enter a valid number.")
		return readUserInput(prompt)
	}
	return input
}

func main() {
	fmt.Println("===== Prim's Algorithm =====")

	graph := createAndPopulateGraph()
	minCost := calculateMinimumSpanningTree(graph)
	printMinimumCost(minCost)
}

func createAndPopulateGraph() *Graph {
	numOfVertices := readUserInput("Enter the number of vertices: ")
	numOfEdges := readUserInput("Enter the number of edges: ")
	g := Graph{}
	g.init(numOfVertices)

	if numOfEdges < numOfVertices-1 {
		fmt.Println("Graph is not connected.")
		return nil
	}

	for i := 0; i < numOfEdges; i++ {
		u := readUserInput(fmt.Sprintf("Enter vertex u for edge %d: ", i+1))
		v := readUserInput(fmt.Sprintf("Enter vertex v for edge %d: ", i+1))
		w := readUserInput(fmt.Sprintf("Enter weight w for edge %d: ", i+1))
		g.addEdge(u, v, w)
	}

	return &g
}

func calculateMinimumSpanningTree(g *Graph) int {
	return g.prim()
}

func printMinimumCost(cost int) {
	fmt.Printf("Minimum cost: %d\n", cost)
}

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

// main.go
// Package main implements a simple graph representation and algorithms to find the shortest path.
// It includes functions for graph creation, edge addition, and shortest path calculation.

package main

import (
	"fmt"
	"math"
)

const inf = math.MaxInt32

type Graph struct {
	numVertices int
	edges       [][]int
}

// newGraph creates a new graph with a specified number of vertices and initializes
// the adjacency matrix for the edges.
// numVertices: the number of vertices in the graph.
// Returns a pointer to the newly created Graph structure.
func newGraph(numVertices int) *Graph {
	graph := &Graph{
		numVertices: numVertices,
		edges:       make([][]int, numVertices),
	}

	for i := range graph.edges {
		graph.edges[i] = make([]int, numVertices)
	}

	return graph
}

// addEdge adds an edge to the graph from one vertex to another with a specified weight.
// from: the starting vertex of the edge.
// to: the ending vertex of the edge.
// weight: the weight/cost associated with the edge.
// This method has no return value and modifies the graph's edge matrix.
func (g *Graph) addEdge(from, to, weight int) {
	g.edges[from][to] = weight
}

// minDistance finds the vertex with the minimum distance value from the set of vertices
// that have not been yet visited.
// dist: array of distances from the source.
// visited: array indicating whether a vertex has been visited.
// Returns the index of the vertex with the minimum distance value.
func minDistance(dist []int, visited []bool) int {
	min := inf
	minIndex := -1

	for i, d := range dist {
		if !visited[i] && d <= min {
			min = d
			minIndex = i
		}
	}

	return minIndex
}

// shortestPath computes the shortest path from a source vertex to every other vertex in the graph.
// src: the starting vertex for the paths.
// Returns an array of minimum distances from the source to each vertex.
// The algorithm implemented is a variation of Dijkstra's algorithm.
func (g *Graph) shortestPath(src int) []int {
	dist := make([]int, g.numVertices)
	visited := make([]bool, g.numVertices)

	for i := range dist {
		dist[i] = inf
	}

	dist[src] = 0

	for count := 0; count < g.numVertices-1; count++ {
		u := minDistance(dist, visited)
		visited[u] = true

		for v := 0; v < g.numVertices; v++ {
			if !visited[v] && g.edges[u][v] != 0 && dist[u] != inf && dist[u]+g.edges[u][v] < dist[v] {
				dist[v] = dist[u] + g.edges[u][v] // make the new distance the sum of the current distance and the weight of the edge
			}
		}
	}

	return dist
}

// getUserInput prompts the user for an input and validates it as an integer.
// prompt: the message displayed to the user.
// Returns the user input as an integer. Re-prompts if the input is not a valid number.
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
	numVertices := getUserInput("Enter the number of vertices: ")

	graph := newGraph(numVertices)

	fmt.Println("Enter the graph (use '0' for no connection):")
	for i := 0; i < numVertices; i++ {
		for j := 0; j < numVertices; j++ {
			weight := getUserInput(fmt.Sprintf("Enter the weight from vertex %d to vertex %d: ", i, j))
			graph.addEdge(i, j, weight)
		}
	}

	source := getUserInput("Enter the source vertex: ")

	result := graph.shortestPath(source)

	fmt.Println("Vertex\t\tDistance from Source")
	for i := 0; i < graph.numVertices; i++ {
		fmt.Printf("%d \t\t %d\n", i, result[i])
	}
}

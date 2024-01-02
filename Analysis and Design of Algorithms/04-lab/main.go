// main.go - Dijkstra's algorithm implementation in Go.
// This file provides a simple command line application that
// allows users to create a graph with a specified number of vertices,
// add weighted edges, and compute the shortest path from a given source vertex
// using Dijkstra's algorithm.

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

// newGraph creates a new graph with a specified number of vertices.
// Inputs:
// - numVertices: The number of vertices for the graph.
// Outputs:
// - A pointer to the newly created graph with initialized edges.
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

// addEdge adds an edge between two vertices in the graph with a specified weight.
// Inputs:
// - from: Source vertex of the edge.
// - to: Destination vertex of the edge.
// - weight: Weight of the edge.
func (g *Graph) addEdge(from, to, weight int) {
	g.edges[from][to] = weight
}

// minDistance finds the vertex with the minimum distance value,
// from the set of vertices not yet included in the shortest path tree.
// Inputs:
// - dist: Array of distances from the source vertex.
// - visited: Array indicating whether a vertex has been visited.
// Outputs:
// - The index of the vertex with the minimum distance not yet visited.
func (g *Graph) minDistance(dist []int, visited []bool) int {
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

// shortestPath implements Dijkstra's single-source shortest path algorithm
// for a graph represented using adjacency matrix representation.
// Inputs:
// - src: The source vertex from which to calculate the shortest paths.
// Outputs:
// - An array of minimum distances from the source to each vertex.
func (g *Graph) shortestPath(src int) []int {
	dist := make([]int, g.numVertices)
	visited := make([]bool, g.numVertices)

	for i := range dist {
		dist[i] = inf
	}

	dist[src] = 0

	for count := 0; count < g.numVertices-1; count++ {
		u := g.minDistance(dist, visited)
		visited[u] = true

		for v := 0; v < g.numVertices; v++ {
			if !visited[v] && g.edges[u][v] != 0 && dist[u] != inf && dist[u]+g.edges[u][v] < dist[v] {
				dist[v] = dist[u] + g.edges[u][v] // make the new distance the sum of the current distance and the weight of the edge
			}
		}
	}

	return dist
}

// printResult prints the constructed distance array.
// Inputs:
// - result: The array containing distances from the source to each vertex.
func (g *Graph) printResult(result []int) {
	fmt.Println("Vertex\t\tDistance from Source")
	for i, r := range result {
		fmt.Printf("%d \t\t %d\n", i, r)
	}
}

// getUserInput prompts the user for input with a specified prompt,
// and returns the user's input as an integer.
// Inputs:
// - prompt: The prompt to display to the user.
// Outputs:
// - The user's input converted to an integer.
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

	graph.printResult(result)
}

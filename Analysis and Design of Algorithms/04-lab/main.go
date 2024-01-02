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

func (g *Graph) addEdge(from, to, weight int) {
	g.edges[from][to] = weight
}

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

func (g *Graph) printResult(result []int) {
	fmt.Println("Vertex\t\tDistance from Source")
	for i, r := range result {
		fmt.Printf("%d \t\t %d\n", i, r)
	}
}

func getUserInputs() (int, [][]int, int) {
	numVertices := getUserInput("Enter the number of vertices: ")
	weights := make([][]int, numVertices)
	fmt.Println("Enter the graph (use '0' for no connection):")
	for i := 0; i < numVertices; i++ {
		weights[i] = make([]int, numVertices)
		for j := 0; j < numVertices; j++ {
			weights[i][j] = getUserInput(fmt.Sprintf("Enter the weight from vertex %d to vertex %d: ", i, j))
		}
	}
	source := getUserInput("Enter the source vertex: ")
	return numVertices, weights, source
}

func createGraph(numVertices int, weights [][]int) *Graph {
	graph := newGraph(numVertices)
	for i := 0; i < numVertices; i++ {
		for j := 0; j < numVertices; j++ {
			graph.addEdge(i, j, weights[i][j])
		}
	}
	return graph
}

func printShortestPaths(graph *Graph, source int) {
	result := graph.shortestPath(source)
	graph.printResult(result)
}

func main() {
	numVertices, weights, source := getUserInputs()
	graph := createGraph(numVertices, weights)
	printShortestPaths(graph, source)
}

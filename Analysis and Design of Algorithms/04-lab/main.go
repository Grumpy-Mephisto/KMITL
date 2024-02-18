package main

import (
	"fmt"
	"math"
)

const inf = math.MaxInt32

/*
Graph represents a graph data structure with a given number of vertices and weighted edges.
*/
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

/*
shortestPath finds the shortest path from the source node to all other nodes in the graph.
It returns an array of distances representing the shortest path from the source node to each node in the graph.
*/
func (g *GraphTraversal) shortestPath(src int) []int {
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

/*
printResult outputs the result representing the shortest path to each node from the source node in the graph.
*/
// It takes an array of distances as input and prints each node with the corresponding distance from the source node.
func (g *GraphTraversal) printResult(result []int) {
	fmt.Println("Vertex\t\tDistance from Source")
	for i, r := range result {
		fmt.Printf("%d \t\t %d\n", i, r)
	}
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

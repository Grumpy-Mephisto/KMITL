package main

import (
	"fmt"
	"sort"
)

// This file implements the Kruskal's algorithm for finding the minimum spanning tree of a graph.
// The algorithm works by sorting all the edges from low weight to high and adding them into the 
// spanning tree in order, skipping those whose addition would create a cycle.

type Edge struct {
	src, dest, weight int
}

type Graph struct {
	V, E int
	edge []Edge
}

// addEdge adds an edge with a source, destination, and weight to the graph.
//
// Parameters:
//   src - The source vertex of the edge.
//   dest - The destination vertex of the edge.
//   weight - The weight of the edge.
//
// It doesn't return anything.
func (g *Graph) addEdge(src, dest, weight int) {
	g.edge = append(g.edge, Edge{src, dest, weight})
}

type subset struct {
	parent, rank int
}

// newUnionFind initializes a new Union-Find data structure.
func newUnionFind(numOfElements int) []subset {
	subsets := make([]subset, numOfElements)
	for i := range subsets {
		subsets[i].parent = i
		subsets[i].rank = 0
	}
	return subsets
}

// find finds the representative element of the set that the given element belongs to.
func find(subsets []subset, i int) int {
	if subsets[i].parent != i {
		subsets[i].parent = find(subsets, subsets[i].parent)
	}
	return subsets[i].parent
}

// union merges two sets together.
// union merges the set containing element x with the set containing element y.
//
// Parameters:
//   subsets - A slice of subset elements representing the Union-Find data structure.
//   x - An element of the first set.
//   y - An element of the second set.
//
// It doesn't return anything.
func union(subsets []subset, x, y int) {
	xroot := find(subsets, x)
	yroot := find(subsets, y)

	if subsets[xroot].rank < subsets[yroot].rank {
		subsets[xroot].parent = yroot
	} else if subsets[xroot].rank > subsets[yroot].rank {
		subsets[yroot].parent = xroot
	} else {
		subsets[yroot].parent = xroot
		subsets[xroot].rank++
	}
}

// kruskal executes the Kruskal's algorithm on the given graph.
// kruskal performs Kruskal's algorithm on the provided graph to find the minimum spanning tree.
//
// Parameters:
//   graph - A pointer to the Graph struct on which to perform Kruskal's algorithm.
//
// The function prints the edges of the minimum spanning tree and doesn't return anything.
func kruskal(graph *Graph) {
	sort.Slice(graph.edge, func(i, j int) bool {
		return graph.edge[i].weight < graph.edge[j].weight
	})

	subsets := newUnionFind(graph.V)

	for _, edge := range graph.edge {
		x := find(subsets, edge.src)
		y := find(subsets, edge.dest)

		if x != y {
			fmt.Printf("%d -- %d == %d\n", edge.src, edge.dest, edge.weight)
			union(subsets, x, y)
		}
	}
}

// getUserInput collects the vertices and edges of a graph from user input.
//
// The function prompts the user to input the number of vertices and edges followed by each edge's source, destination, and weight.
//
// Returns a pointer to the newly created Graph struct populated with vertices and edges.
func getUserInput() *Graph {
	var V, E int
	fmt.Scan(&V, &E)

	graph := &Graph{V: V, E: E}

	for i := 0; i < E; i++ {
		var src, dest, weight int
		fmt.Scan(&src, &dest, &weight)
		graph.addEdge(src, dest, weight)
	}

	return graph
}

// main is the entry point of the program. It initializes the graph based on user input and executes Kruskal's algorithm.
//
// The function doesn't accept any parameters and doesn't return anything. It calls getUserInput to get the graph data and then calls kruskal to execute the algorithm.
func main() {
	graph := getUserInput()
	kruskal(graph)
}

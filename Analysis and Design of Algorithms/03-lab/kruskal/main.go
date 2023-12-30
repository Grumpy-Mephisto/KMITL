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

// addEdge adds an edge to the graph.
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

// getUserInput gets the user's input for the graph.
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

// main is the entry point of the program. It calls the other functions in order to execute the 
// Kruskal's algorithm on the user's input graph.
func main() {
	graph := getUserInput()
	kruskal(graph)
}

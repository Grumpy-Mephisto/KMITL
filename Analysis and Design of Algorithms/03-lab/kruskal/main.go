// This file contains an implementation of Kruskal's algorithm to find the minimum spanning tree of a graph.
// It includes structures and methods for graph representation and the union-find algorithm.

package main

import (
	"fmt"
	"sort"
)

type Edge struct {
	u, v, w int
}

type Graph struct {
	edges []Edge
}

func (g *Graph) addEdge(u, v, w int) {
	g.edges = append(g.edges, Edge{u, v, w})
}

type UnionFind struct {
	parent []int
	rank   []int
}

func newUnionFind(size int) *UnionFind {
	uf := UnionFind{
		parent: make([]int, size),
		rank:   make([]int, size),
	}

	for i := range uf.parent {
		uf.parent[i] = i
		uf.rank[i] = 0 // rank is the depth of the tree
	}

	return &uf
}

// find returns the representative of the set that element x is part of.
// It uses path compression to flatten the structure of the tree for efficiency.
// 
// Parameter:
// - x: the element for which to find the representative.
// 
// Returns:
// - The representative of the set containing x.
func (uf *UnionFind) find(x int) int {
	if uf.parent[x] != x {
		uf.parent[x] = uf.find(uf.parent[x])
	}
	return uf.parent[x]
}

func (uf *UnionFind) union(x, y int) {
	rootX, rootY := uf.find(x), uf.find(y)
	if uf.rank[rootX] < uf.rank[rootY] {
		uf.parent[rootX] = rootY
	} else if uf.rank[rootX] > uf.rank[rootY] {
		uf.parent[rootY] = rootX
	} else {
		uf.parent[rootY] = rootX
		uf.rank[rootX]++
	}
}

// kruskal calculates the minimum cost to construct a minimum spanning tree using Kruskal's algorithm.
// 
// Returns:
// - The minimum cost to construct the minimum spanning tree.
func (g *Graph) kruskal() int {
	sort.Slice(g.edges, func(i, j int) bool {
		return g.edges[i].w < g.edges[j].w
	})

	uf := newUnionFind(len(g.edges))
	minCost := 0

	for _, edge := range g.edges {
		if uf.find(edge.u) != uf.find(edge.v) {
			uf.union(edge.u, edge.v)
			minCost += edge.w
		}
	}

	return minCost
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
	fmt.Println("===== Kruskal's Algorithm =====")

	numOfVertices := getUserInput("Enter the number of vertices: ")
	numOfEdges := getUserInput("Enter the number of edges: ")

	g := Graph{}

	for i := 0; i < numOfEdges; i++ {
		u := getUserInput(fmt.Sprintf("Enter vertex u for edge %d: ", i+1))
		v := getUserInput(fmt.Sprintf("Enter vertex v for edge %d: ", i+1))
		w := getUserInput(fmt.Sprintf("Enter weight w for edge %d: ", i+1))
		g.addEdge(u, v, w)
	}

	if len(g.edges) < (numOfVertices - 1) {
		fmt.Println("Minimum spanning tree not possible: insufficient edges")
		return
	}

	minCost := g.kruskal()

	fmt.Printf("Minimum cost: %d\n", minCost)
}

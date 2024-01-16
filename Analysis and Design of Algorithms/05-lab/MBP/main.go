package main

import (
	"fmt"
	"math"
)

const inf = math.MaxInt32

type Graph struct {
	V     int
	Edges [][]int
}

func newGraph() *Graph {
	edges := make([][]int, 0)
	return &Graph{0, edges}
}

func (g *Graph) addEdge(u, v, w int) {
	g.Edges = append(g.Edges, []int{u, v, w})
	if u > g.V {
		g.V = u
	}
	if v > g.V {
		g.V = v
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

func floydWarshall(g *Graph) [][][]int {
	n := g.V
	distances := make([][][]int, n+1)

	for k := 0; k <= n; k++ {
		distances[k] = make([][]int, n)
		for i := range distances[k] {
			distances[k][i] = make([]int, n)
			for j := range distances[k][i] {
				if i == j {
					distances[k][i][j] = 0
				} else {
					distances[k][i][j] = inf
				}
			}
		}
	}

	for _, edge := range g.Edges {
		u, v, w := edge[0], edge[1], edge[2]
		distances[0][u-1][v-1] = w
		distances[0][v-1][u-1] = w
	}

	for k := 1; k <= n; k++ {
		for i := 0; i < n; i++ {
			for j := 0; j < n; j++ {
				distances[k][i][j] = distances[k-1][i][j]
				if distances[k][i][j] > distances[k-1][i][k-1]+distances[k-1][k-1][j] {
					distances[k][i][j] = distances[k-1][i][k-1] + distances[k-1][k-1][j]
				}
			}
		}
	}

	return distances
}

func main() {
	g := newGraph()

	for {
		u := getUserInput("Enter the start vertex (0 to exit): ")
		if u == 0 {
			break
		}
		v := getUserInput("Enter the end vertex: ")
		w := getUserInput("Enter the weight: ")
		g.addEdge(u, v, w)
	}

	fmt.Println("The graph is:")
	fmt.Printf("Vertices: %d\n", g.V)
	fmt.Println("Edge List:")
	for _, edge := range g.Edges {
		fmt.Printf("Start: %d, End: %d, Weight: %d\n", edge[0], edge[1], edge[2])
	}

	distances := floydWarshall(g)

	for k := 0; k <= g.V; k++ {
		fmt.Printf("\nMinimum Bottleneck Distances for k=%d:\n", k)
		for i := 0; i < g.V; i++ {
			for j := 0; j < g.V; j++ {
				if distances[k][i][j] == inf {
					fmt.Printf("∞\t")
					continue
				}
				fmt.Printf("%d\t", distances[k][i][j])
			}
			fmt.Println()
		}
	}
}

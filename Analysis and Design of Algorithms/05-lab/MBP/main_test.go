package main

import (
	"reflect"
	"testing"
)

func TestBottleNeckPath(t *testing.T) {
	testCases := []struct {
		name           string
		graphEdges     [][]int
		expectedResult [][]int
	}{
		{
			name: "Test Case 1",
			graphEdges: [][]int{
				{1, 2, 2},
				{1, 3, 5},
				{1, 4, 3},
				{1, 5, 15},
				{2, 3, 2},
				{2, 4, 3},
				{2, 5, 20},
				{3, 4, 10},
				{4, 5, 20},
			},
			expectedResult: [][]int{
				{0, 0, 0, 0, 0, 0},
				{0, 0, 2, 2, 3, 15},
				{0, 2, 0, 2, 3, 15},
				{0, 2, 2, 0, 3, 15},
				{0, 3, 3, 3, 0, 15},
				{0, 15, 15, 15, 15, 0},
			},
		},
		{
			name: "Test Case 2",
			graphEdges: [][]int{
				{1, 2, 3},
				{2, 3, 2},
				{3, 1, 5},
			},
			expectedResult: [][]int{
				{0, 0, 0, 0},
				{0, 0, 3, 3},
				{0, 3, 0, 2},
				{0, 3, 2, 0},
			},
		},
	}

	for _, tc := range testCases {
		t.Run(tc.name, func(t *testing.T) {
			g := newGraph()
			for _, edge := range tc.graphEdges {
				g.addEdge(edge[0], edge[1], edge[2])
			}

			distances := make([][]int, g.V+1)
			for i := range distances {
				distances[i] = make([]int, g.V+1)
			}

			for i := 1; i <= g.V; i++ {
				for j := 1; j <= g.V; j++ {
					if i == j {
						distances[i][j] = 0
					} else {
						distances[i][j] = inf
					}
				}
			}

			for _, edge := range g.Edges {
				distances[edge[0]][edge[1]] = edge[2]
			}

			result := bottleNeckPath(g, distances)

			if !reflect.DeepEqual(result, tc.expectedResult) {
				t.Errorf("BottleNeckPath test failed. Expected:\n%v\nGot:\n%v", tc.expectedResult, result)
			}
		})
	}
}

func BenchmarkBottleNeckPath(b *testing.B) {
	testCases := []struct {
		name           string
		graphEdges     [][]int
		expectedResult [][]int
	}{
		{
			name: "Test Case 1",
			graphEdges: [][]int{
				{1, 2, 2},
				{1, 3, 5},
				{1, 4, 3},
				{1, 5, 15},
				{2, 3, 2},
				{2, 4, 3},
				{2, 5, 20},
				{3, 4, 10},
				{4, 5, 20},
			},
			expectedResult: [][]int{
				{0, 0, 0, 0, 0, 0},
				{0, 0, 2, 2, 3, 15},
				{0, 2, 0, 2, 3, 15},
				{0, 2, 2, 0, 3, 15},
				{0, 3, 3, 3, 0, 15},
				{0, 15, 15, 15, 15, 0},
			},
		},
		{
			name: "Test Case 2",
			graphEdges: [][]int{
				{1, 2, 3},
				{2, 3, 2},
				{3, 1, 5},
			},
			expectedResult: [][]int{
				{0, 0, 0, 0},
				{0, 0, 3, 3},
				{0, 3, 0, 2},
				{0, 3, 2, 0},
			},
		},
	}

	for _, tc := range testCases {
		b.Run(tc.name, func(b *testing.B) {
			g := newGraph()
			for _, edge := range tc.graphEdges {
				g.addEdge(edge[0], edge[1], edge[2])
			}

			distances := make([][]int, g.V+1)
			for i := range distances {
				distances[i] = make([]int, g.V+1)
			}

			for i := 1; i <= g.V; i++ {
				for j := 1; j <= g.V; j++ {
					if i == j {
						distances[i][j] = 0
					} else {
						distances[i][j] = inf
					}
				}
			}

			for _, edge := range g.Edges {
				distances[edge[0]][edge[1]] = edge[2]
			}

			for i := 0; i < b.N; i++ {
				bottleNeckPath(g, distances)
			}
		})
	}
}

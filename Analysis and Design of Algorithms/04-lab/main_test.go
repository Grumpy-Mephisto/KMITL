// main_test.go
// This file contains unit tests for graph operations.

package main

import (
	"testing"
)

// TestShortestPathAlgorithm verifies the shortestPath method's correctness.
// This function runs through multiple cases to ensure correct shortest paths are calculated.
func TestShortestPathAlgorithm(t *testing.T) {
	testCases := []struct {
		name           string
		graph          Graph
		source         int
		expectedOutput []int
	}{
		{
			name: "Case 1",
			graph: Graph{
				numVertices: 3,
				edges: [][]int{
					{0, 1, 3},
					{1, 0, 2},
					{3, 2, 0},
				},
			},
			source:         0,
			expectedOutput: []int{0, 1, 3},
		},
		{
			name: "Case 2",
			graph: Graph{
				numVertices: 4,
				edges: [][]int{
					{0, 1, 0, 3},
					{1, 0, 2, 0},
					{0, 2, 0, 4},
					{3, 0, 4, 0},
				},
			},
			source:         2,
			expectedOutput: []int{3, 2, 0, 4},
		},
		{
			name: "Case 3",
			graph: Graph{
				numVertices: 5,
				edges: [][]int{
					{0, 1, 7, 0, 0},
					{0, 0, 1, 4, 3},
					{0, 0, 0, 7, 0},
					{0, 0, 0, 0, 0},
					{0, 0, 1, 2, 0},
				},
			},
			source:         0,
			expectedOutput: []int{0, 1, 2, 5, 4},
		},
	}

	for _, tc := range testCases {
		t.Run(tc.name, func(t *testing.T) {
			actualOutput := tc.graph.shortestPath(tc.source)

			for i, val := range actualOutput {
				if val != tc.expectedOutput[i] {
					t.Errorf("Test case %s failed: expected %v, got %v", tc.name, tc.expectedOutput, actualOutput)
					break
				}
			}
		})
	}
}

// TestNewGraphInitialization checks that a new graph is initialized correctly.
// It asserts that the number of vertices and edge weights are set as expected.
func TestNewGraphInitialization(t *testing.T) {
	testCases := []struct {
		name                string
		numVertices         int
		expectedNumVertices int
	}{
		{
			name:                "Case 1",
			numVertices:         4,
			expectedNumVertices: 4,
		},
		{
			name:                "Case 2",
			numVertices:         5,
			expectedNumVertices: 5,
		},
	}

	for _, tc := range testCases {
		t.Run(tc.name, func(t *testing.T) {
			graph := newGraph(tc.numVertices)

			if graph.numVertices != tc.expectedNumVertices {
				t.Errorf("Expected number of vertices: %d, got: %d", tc.expectedNumVertices, graph.numVertices)
			}

			for i := 0; i < tc.numVertices; i++ {
				for j := 0; j < tc.numVertices; j++ {
					if graph.edges[i][j] != 0 {
						t.Errorf("Expected edge weight: 0, got: %d at (%d, %d)", graph.edges[i][j], i, j)
					}
				}
			}
		})
	}
}

// TestAddEdge ensures that edges are added to the graph with correct weights.
// The function inspects edge weights after addition to verify correctness.
func TestAddEdge(t *testing.T) {
	testCases := []struct {
		name                string
		graph               Graph
		from, to, weight    int
		expectedEdgeWeights [][]int
	}{
		{
			name: "Case 1",
			graph: Graph{
				numVertices: 3,
				edges: [][]int{
					{0, 1, 3},
					{1, 0, 2},
					{3, 2, 0},
				},
			},
			from:   0,
			to:     2,
			weight: 5,
			expectedEdgeWeights: [][]int{
				{0, 1, 5},
				{1, 0, 2},
				{3, 2, 0},
			},
		},
		{
			name: "Case 2",
			graph: Graph{
				numVertices: 4,
				edges: [][]int{
					{0, 1, 0, 3},
					{1, 0, 2, 0},
					{0, 2, 0, 4},
					{3, 0, 4, 0},
				},
			},
			from:   1,
			to:     3,
			weight: 5,
			expectedEdgeWeights: [][]int{
				{0, 1, 0, 3},
				{1, 0, 2, 5},
				{0, 2, 0, 4},
				{3, 0, 4, 0},
			},
		},
	}

	for _, tc := range testCases {
		t.Run(tc.name, func(t *testing.T) {
			tc.graph.addEdge(tc.from, tc.to, tc.weight)

			for i := 0; i < tc.graph.numVertices; i++ {
				for j := 0; j < tc.graph.numVertices; j++ {
					if tc.graph.edges[i][j] != tc.expectedEdgeWeights[i][j] {
						t.Errorf("Test case %s failed: expected %v, got %v", tc.name, tc.expectedEdgeWeights, tc.graph.edges)
					}
				}
			}
		})
	}
}

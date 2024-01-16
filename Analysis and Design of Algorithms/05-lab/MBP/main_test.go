package main_test

import (
	"testing"

	"github.com/path/to/Analysis and Design of Algorithms/05-lab/MBP"

	"github.com/path/to/Analysis and Design of Algorithms/05-lab/MBP/main"
)

import (
	"testing"

	"github.com/path/to/Analysis and Design of Algorithms/05-lab/MBP"
)

func TestFloydWarshallSecond(t *testing.T) {
	// Test case 1: Check if the algorithm correctly initializes the distances matrix
	graph := &main.Graph{
		V: 4,
		Edges: [][]int{
			{0, 1, 3},
			{0, 2, 7},
			{1, 2, 2},
			{1, 3, 5},
			{2, 3, 1},
		},
	}

	expectedDistances := [][][]int{
		{
			{0, 3, 7, inf},
			{3, 0, 2, 5},
			{7, 2, 0, 1},
			{inf, 5, 1, 0},
		},
	}

	distances := main.FloydWarshall(graph)
	if !compareDistances(distances, expectedDistances) {
		t.Errorf("Test case 1 failed: Incorrect distances matrix")
	}

	// Test case 2: Check if the algorithm correctly finds the shortest path in a graph
	graph2 := &main.Graph{
		V: 3,
		Edges: [][]int{{0, 1, 1}, {1, 2, 1}},
	}

	expectedDistances2 := [][][]int{{
		{0, 1, 2},
		{inf, 0, 1},
		{inf, inf, 0},
	}}

distances2 := main.FloydWarshall(graph2)
if !compareDistances(distances2, expectedDistances2) {
	t.Errorf("Test case 2 failed: Incorrect distances matrix")
}

// Test case 3: Check if the algorithm handles negative cycles
graph3 := &main.Graph{
	V: 3,
	Edges: [][]int{{0, 1, 1}, {1, 2, -1}, {2, 0, -1}},
}

expectedDistances3 := [][][]int{{
	{0, 1, 0},
	{-1, 0, -1},
	{1, 2, 0},
}}

distances3 := main.FloydWarshall(graph3)
if !compareDistances(distances3, expectedDistances3) {
	t.Errorf("Test case 3 failed: Incorrect distances matrix")
}

// Test case 4: Check if the algorithm handles a disconnected graph
graph4 := &main.Graph{
	V: 3,
	Edges: [][]int{{0, 1, 1}},
}

expectedDistances4 := [][][]int{{
	{0, 1, inf},
	{inf, 0, inf},
	{inf, inf, 0},
}}

distances4 := main.FloydWarshall(graph4)
if !compareDistances(distances4, expectedDistances4) {
	t.Errorf("Test case 4 failed: Incorrect distances matrix")
}

// Test case 5: Check if the algorithm handles a graph with negative weights
graph5 := &main.Graph{
	V: 3,
	Edges: [][]int{{0, 1, -1}, {1, 2, -2}},
}

expectedDistances5 := [][][]int{{
	{0, -1, -3},
	{inf, 0, -2},
	{inf, inf, 0},
}}

distances5 := main.FloydWarshall(graph5)
if !compareDistances(distances5, expectedDistances5) {
	t.Errorf("Test case 5 failed: Incorrect distances matrix")
}

// Test case 5: Test case description
// ...
}

func compareDistances(distances, expectedDistances [][][]int) bool {
	// Implement the comparison logic for distances matrix
	// ...
}

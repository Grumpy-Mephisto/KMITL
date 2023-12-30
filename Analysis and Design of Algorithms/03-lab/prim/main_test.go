// This file contains tests for the implementation of Prim's algorithm and the main function in the main.go file.
package main

import (
	"os"
	"strings"
	"testing"
)

// TestPrimAlgorithm tests the implementation of Prim's algorithm on different test cases.
// Each test case includes a graph and the expected minimum cost of a spanning tree.
// The function asserts that the actual output from the algorithm matches the expected output.
func TestPrimAlgorithm(t *testing.T) {
	testCases := []struct {
		name           string
		graph          Graph
		expectedOutput int
	}{
		{
			name: "Test Case 1",
			graph: func() Graph {
				g := Graph{}
				g.init(6)

				edges := [][]int{
					{1, 2, 10},
					{1, 5, 45},
					{1, 4, 30},
					{2, 3, 50},
					{2, 5, 40},
					{5, 3, 35},
					{6, 4, 20},
					{6, 2, 25},
					{6, 5, 55},
					{6, 3, 15},
				}

				for _, edge := range edges {
					u, v, w := edge[0]-1, edge[1]-1, edge[2]
					g.addEdge(u, v, w)
				}
				return g
			}(),
			expectedOutput: 105,
		},
		{
			name: "Test Case 2",
			graph: func() Graph {
				g := Graph{}
				g.init(4)

				edges := [][]int{
					{1, 2, 10},
					{1, 3, 6},
					{1, 4, 5},
					{2, 4, 15},
					{3, 4, 4},
				}

				for _, edge := range edges {
					u, v, w := edge[0]-1, edge[1]-1, edge[2]
					g.addEdge(u, v, w)
				}
				return g
			}(),
			expectedOutput: 5,
		},
	}

	for _, tc := range testCases {
		t.Run(tc.name, func(t *testing.T) {
			actualOutput := tc.graph.prim()
			if actualOutput != tc.expectedOutput {
				t.Errorf("Test case %s: expected %d, got %d", tc.name, tc.expectedOutput, actualOutput)
			}
		})
	}
}

// TestMain tests the main function with different inputs and expected outputs.
// The function redirects standard input and output to temporary files, runs the main function,
// and then checks the output against the expected output. The function tests both valid and invalid inputs.
func TestMain(t *testing.T) {
	t.Run("Valid input", func(t *testing.T) {
		testCases := []struct {
			name           string
			input          string
			expectedOutput string
		}{
			{
				name:           "Valid input test with 4 vertices and 5 edges",
				input:          "4\n5\n1\n2\n10\n1\n3\n6\n1\n4\n5\n2\n4\n15\n3\n4\n4\n",
				expectedOutput: "Minimum cost: 5\n",
			},
			{
				name:           "Valid input test with 6 vertices and 10 edges",
				input:          "6\n10\n1\n2\n10\n1\n5\n45\n1\n4\n30\n2\n3\n50\n2\n5\n40\n5\n3\n35\n6\n4\n20\n6\n2\n25\n6\n5\n55\n6\n3\n15\n",
				expectedOutput: "Minimum cost: 105\n",
			},
		}

		for _, tc := range testCases {
			t.Run(tc.name, func(t *testing.T) {
				inputFile, _ := os.CreateTemp("", "")
				outputFile, _ := os.CreateTemp("", "")

				inputFile.WriteString(tc.input)
				inputFile.Seek(0, 0)

				oldStdin := os.Stdin
				oldStdout := os.Stdout

				os.Stdin = inputFile
				os.Stdout = outputFile

				main()

				os.Stdin = oldStdin
				os.Stdout = oldStdout

				output, _ := os.ReadFile(outputFile.Name())
				if !strings.Contains(string(output), tc.expectedOutput) {
					t.Errorf("Expected output to contain %s, but got %s", tc.expectedOutput, string(output))
				}
			})
		}
	})

	t.Run("Invalid input", func(t *testing.T) {
		testCases := []struct {
			name           string
			input          string
			expectedOutput string
		}{
			{
				name:           "Invalid input test with use of spaces",
				input:          "\n\n\n4\n5\n1\n2\n10\n1\n3\n6\n1\n4\n5\n2\n4\n15\n3\n4\n4\n",
				expectedOutput: "Please enter a valid number.\n",
			},
			{
				name:           "Invalid input test with use of alphabets",
				input:          "a\n5\n1\n2\n10\n1\n3\n6\n1\n4\n5\n2\n4\n15\n3\n4\n4\n",
				expectedOutput: "Please enter a valid number.\n",
			},
			{
				name:           "Invalid input test with negative number of vertices",
				input:          "-1\n5\n1\n2\n10\n1\n3\n6\n1\n4\n5\n2\n4\n15\n3\n4\n4\n",
				expectedOutput: "Invalid input.\n",
			},
			{
				name:           "Invalid input test with negative number of edges",
				input:          "4\n-1\n1\n2\n10\n1\n3\n6\n1\n4\n5\n2\n4\n15\n3\n4\n4\n",
				expectedOutput: "Invalid input.\n",
			},
			{
				name:           "Invalid input test with negative start vertex",
				input:          "4\n5\n-1\n2\n10\n1\n3\n6\n1\n4\n5\n2\n4\n15\n3\n4\n4\n",
				expectedOutput: "Invalid vertex index entered.\n",
			},
			{
				name:           "Invalid input test with negative end vertex",
				input:          "4\n5\n1\n-1\n10\n1\n3\n6\n1\n4\n5\n2\n4\n15\n3\n4\n4\n",
				expectedOutput: "Invalid vertex index entered.\n",
			},
			{
				name:           "Invalid input test with negative weight",
				input:          "4\n5\n1\n2\n-1\n1\n3\n6\n1\n4\n5\n2\n4\n15\n3\n4\n4\n",
				expectedOutput: "Invalid weight entered. Weight must be a positive number.\n",
			},
			{
				name:           "Graph not connected test",
				input:          "5\n3\n1\n2\n10\n2\n3\n6\n1\n4\n5\n",
				expectedOutput: "Graph is not connected.\n",
			},
		}

		for _, tc := range testCases {
			t.Run(tc.name, func(t *testing.T) {
				inputFile, _ := os.CreateTemp("", "")
				outputFile, _ := os.CreateTemp("", "")

				inputFile.WriteString(tc.input)
				inputFile.Seek(0, 0)

				oldStdin := os.Stdin
				oldStdout := os.Stdout

				os.Stdin = inputFile
				os.Stdout = outputFile

				main()

				os.Stdin = oldStdin
				os.Stdout = oldStdout

				output, _ := os.ReadFile(outputFile.Name())
				if !strings.Contains(string(output), tc.expectedOutput) {
					t.Errorf("Expected output to contain %s, but got %s", tc.expectedOutput, string(output))
				}
			})
		}
	})
}

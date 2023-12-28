// Package main contains the tests for the implementation of Kruskal's algorithm.
// It verifies the functionality and correctness of the algorithm's process to determine the minimum spanning tree.

package main

import (
	"os"
	"strings"
	"testing"
)

// TestKruskalAlgorithm checks the correctness of the kruskal function.
// It runs several test cases, each representing a graph, to verify that the minimum spanning tree costs match the expected results.
//
// Parameters:
// - t *testing.T: The test handler provided by the testing package.
//
// Side Effects:
// - If the test fails, the test handler will log the error.
func TestKruskalAlgorithm(t *testing.T) {
	testCases := []struct {
		name           string
		edges          []Edge
		numOfVertices  int
		expectedOutput int
	}{
		{
			name: "Test Case 1",
			edges: []Edge{
				{0, 1, 4},
				{0, 7, 8},
				{1, 2, 8},
				{1, 7, 11},
				{2, 3, 7},
				{2, 8, 2},
				{2, 5, 4},
				{3, 4, 9},
				{3, 5, 14},
				{4, 5, 10},
				{5, 6, 2},
				{6, 7, 1},
				{6, 8, 6},
				{7, 8, 7},
			},
			numOfVertices:  9,
			expectedOutput: 37,
		},
	}

	for _, tc := range testCases {
		t.Run(tc.name, func(t *testing.T) {
			g := Graph{}
			for _, edge := range tc.edges {
				g.addEdge(edge.u, edge.v, edge.w)
			}

			minCost := g.kruskal()

			if minCost != tc.expectedOutput {
				t.Errorf("Test Case %s failed: got %d, expected %d", tc.name, minCost, tc.expectedOutput)
			}
		})
	}
}

// TestMain checks the main function's handling of user inputs and outputs.
// It verifies that the main function processes inputs correctly and generates the expected output.
//
// Note that this test uses temporary files to simulate user input and capture output.
//
// Parameters:
// - t *testing.T: The test handler provided by the testing package.
//
// Side Effects:
// - If the test fails, the test handler will log the error.
// - Creates temporary files which are cleaned up after the test.
func TestMain(t *testing.T) {
	t.Run("Valid input", func(t *testing.T) {
		testCases := []struct {
			name           string
			input          string
			expectedOutput string
		}{
			{
				name:           "Test Case 1",
				input:          "9\n14\n0\n1\n4\n0\n7\n8\n1\n2\n8\n1\n7\n11\n2\n3\n7\n2\n8\n2\n2\n5\n4\n3\n4\n9\n3\n5\n14\n4\n5\n10\n5\n6\n2\n6\n7\n1\n6\n8\n6\n7\n8\n7\n8\n7\n",
				expectedOutput: "Minimum cost: 37",
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
				name:           "Test Case 1",
				input:          "a\n14\n0\n1\n4\n0\n7\n8\n1\n2\n8\n1\n7\n11\n2\n3\n7\n2\n8\n2\n2\n5\n4\n3\n4\n9\n3\n5\n14\n4\n5\n10\n5\n6\n2\n6\n7\n1\n6\n8\n6\n7\n8\n7\n8\n7\n",
				expectedOutput: "Please enter a valid number.",
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

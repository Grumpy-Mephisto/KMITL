package main

import (
	"os"
	"strings"
	"testing"
)

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

func TestMainFunction(t *testing.T) {
	testCases := []struct {
		name           string
		input          string
		expectedOutput []float64
	}{
		// TODO: Add test cases here
	}

	for _, tc := range testCases {
		t.Run(tc.name, func(t *testing.T) {
			// TODO: Implement the testing logic for main function
			// Simulate input and capture the output
			// Assert the output matches the expected roots of the quadratic equation
			// If not, use t.Errorf to report an error
		})
	}
}

// Package main contains unit tests for Prim's algorithm implementation.
// It includes tests for the algorithm correctness and the main function execution.

package main

import (
	"os"
	"strings"
	"testing"
)

// TestPrimAlgorithm checks the correctness of the Prim's algorithm implementation.
// It runs a test case to ensure that the calculated minimum cost to construct
// a minimum spanning tree is as expected.
//
// Parameters:
// - t *testing.T: The test handler provided by the testing package.
//
// Side Effects:
// - If the test fails, the error is logged and the test state is set to failed.
func TestPrimAlgorithm(t *testing.T) {
	testCases := []struct {
		name           string
		graph          Graph
		expectedOutput int
	}{
		{
			name: "Test Case 1",
			graph: Graph{
				vertices: 4,
				matrix: [][]int{
					{0, 10, 6, 5},
					{10, 0, inf, 15},
					{6, inf, 0, 4},
					{5, 15, 4, 0},
				},
			},
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

func TestMain(t *testing.T) {
	t.Run("Valid input", func(t *testing.T) {
		testCases := []struct {
			name           string
			input          string
			expectedOutput string
		}{
			{
				name:           "Valid input test",
				input:          "4\n5\n0\n1\n10\n0\n2\n6\n0\n3\n5\n1\n3\n15\n2\n3\n4\n",
				expectedOutput: "Minimum cost: 5\n",
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
				name:           "Invalid input test",
				input:          "a\n2\n0\n1\n10\n",
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

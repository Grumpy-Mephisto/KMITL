package main

import (
	"bytes"
	"os"
	"strings"
	"testing"
)

// //// Test //// //
// TestShortestPathAlgorithm tests the shortestPath function in the Graph struct.
// It creates several test cases with different graphs and expected outputs,
// then checks if the actual output matches the expected output.
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

func TestPrintResult(t *testing.T) {
	testCases := []struct {
		name           string
		graph          Graph
		source         int
		expectedOutput string
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
			expectedOutput: "Vertex\t\tDistance from Source\n0 \t\t 0\n1 \t\t 1\n2 \t\t 3\n",
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
			expectedOutput: "Vertex\t\tDistance from Source\n0 \t\t 3\n1 \t\t 2\n2 \t\t 0\n3 \t\t 4\n",
		},
	}

	for _, tc := range testCases {
		t.Run(tc.name, func(t *testing.T) {
			result := tc.graph.shortestPath(tc.source)

			originalStdout := os.Stdout
			r, w, _ := os.Pipe()
			os.Stdout = w

			tc.graph.printResult(result)

			_ = w.Close()
			os.Stdout = originalStdout

			var buf bytes.Buffer
			_, _ = buf.ReadFrom(r)
			actualOutput := buf.String()

			if strings.Compare(actualOutput, tc.expectedOutput) != 0 {
				t.Errorf("Test case %s failed: expected %v, got %v", tc.name, tc.expectedOutput, actualOutput)
			}
		})
	}
}

// TestMainWithInput tests the main function by creating temporary input and output files
// and then checks if the output of the main function matches the expected output.
func TestMainWithInput(t *testing.T) {
	t.Run("Successful run", func(t *testing.T) {
		testCases := []struct {
			name           string
			input          string
			expectedOutput string
		}{
			{
				name:           "Case 1",
				input:          "3\n0\n1\n3\n1\n0\n2\n3\n2\n0\n0\n",
				expectedOutput: "Vertex\t\tDistance from Source\n0 \t\t 0\n1 \t\t 1\n2 \t\t 3\n",
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

// //// Benchmarks //// //
func BenchmarkShortestPathAlgorithm(b *testing.B) {
	for i := 0; i < b.N; i++ {
		graph := Graph{
			numVertices: 5,
			edges: [][]int{
				{0, 1, 7, 0, 0},
				{0, 0, 1, 4, 3},
				{0, 0, 0, 7, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 1, 2, 0},
			},
		}

		graph.shortestPath(0)
	}
}

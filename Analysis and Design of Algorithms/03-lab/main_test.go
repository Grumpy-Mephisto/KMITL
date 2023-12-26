package main

import (
	"os"
	"strings"
	"testing"
)

func TestKnapsackAlgorithm(t *testing.T) {
	testCases := []struct {
		name             string
		knapsackCapacity int
		items            []Item
		expectedResult   int
	}{
		{
			name:             "Test Case 1",
			knapsackCapacity: 50,
			items:            []Item{{Profit: 60, Weight: 10}, {Profit: 100, Weight: 20}, {Profit: 120, Weight: 30}},
			expectedResult:   240,
		},
		{
			name:             "Test Case 2",
			knapsackCapacity: 0,
			items:            []Item{{Profit: 60, Weight: 10}, {Profit: 100, Weight: 20}, {Profit: 120, Weight: 30}},
			expectedResult:   0,
		},
		{
			name:             "Test Case 3",
			knapsackCapacity: 45,
			items:            []Item{{Profit: 76, Weight: 8}, {Profit: 51, Weight: 13}, {Profit: 51, Weight: 12}, {Profit: 43, Weight: 15}, {Profit: 70, Weight: 20}},
			expectedResult:   220,
		},
	}

	for _, tc := range testCases {
		t.Run(tc.name, func(t *testing.T) {
			result := knapsackAlgorithm(tc.knapsackCapacity, tc.items)
			if result != tc.expectedResult {
				t.Errorf("Expected %d, but got %d", tc.expectedResult, result)
			}
		})
	}
}

func TestMain(t *testing.T) {
	t.Run("Test Case 1", func(t *testing.T) {
		testCases := []struct {
			name           string
			input          string
			expectedOutput string
		}{
			{
				name:           "Test Case 1",
				input:          "3\n50\n60\n10\n100\n20\n120\n30\n",
				expectedOutput: "Knapsack Algorithm Result: 240",
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

	t.Run("Get Input Invalid", func(t *testing.T) {
		testCases := []struct {
			name           string
			input          string
			expectedOutput string
		}{
			{
				name:           "Test Case 1",
				input:          "a\n3\n50\n60\n10\n100\n20\n120\n30\n",
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

	t.Run("Weight Invalid", func(t *testing.T) {
		testCases := []struct {
			name           string
			input          string
			expectedOutput string
		}{
			{
				name:           "Test Case 1",
				input:          "3\n50\n60\na\n100\n20\n120\n30\n",
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

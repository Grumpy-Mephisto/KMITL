package main

import (
	"fmt"
)

type LCS struct {
	matrix [][]int
}

func NewLCS(rows, cols int) LCS {
	matrix := make([][]int, rows)
	for i := range matrix {
		matrix[i] = make([]int, cols)
	}
	return LCS{matrix: matrix}
}

func (l *LCS) FindLCSLength(str1, str2 string) int {
	for i := 1; i < len(str1)+1; i++ {
		for j := 1; j < len(str2)+1; j++ {
			if str1[i-1] == str2[j-1] {
				l.matrix[i][j] = l.matrix[i-1][j-1] + 1
			} else {
				l.matrix[i][j] = max(l.matrix[i-1][j], l.matrix[i][j-1])
			}
		}
	}
	return l.matrix[len(str1)][len(str2)]
}

func (l *LCS) FindLCS(str1, str2 string) string {
	i, j := len(str1), len(str2)
	var lcs string

	for i > 0 && j > 0 {
		if str1[i-1] == str2[j-1] {
			lcs = string(str1[i-1]) + lcs
			i--
			j--
		} else if l.matrix[i-1][j] > l.matrix[i][j-1] {
			i--
		} else {
			j--
		}
	}
	return lcs
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func getUserInput(prompt string) string {
	var input string
	fmt.Print(prompt)
	_, err := fmt.Scanln(&input)
	if err != nil {
		fmt.Println("Invalid input. Please enter a valid string.")
		return getUserInput(prompt)
	}
	return input
}

func main() {
	str1 := getUserInput("Enter first string: ")
	str2 := getUserInput("Enter second string: ")

	lcs := NewLCS(len(str1)+1, len(str2)+1)
	lcs.FindLCSLength(str1, str2)
	lcsString := lcs.FindLCS(str1, str2)

	fmt.Printf("Longest Common Subsequence: %s\n", lcsString)
	fmt.Printf("Length of Longest Common Subsequence: %d\n", len(lcsString))
}

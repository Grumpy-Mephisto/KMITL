/*
Package main provides ...
*/
package main

import (
	"fmt"
)

type LCS struct {
	matrix [][]int
}

/*
NewLCS creates a new instance of the LCS struct with the specified number of rows and columns.
It returns the initialized LCS struct.
*/
func NewLCS(rows, cols int) LCS {
	matrix := make([][]int, rows)
	for i := range matrix {
		matrix[i] = make([]int, cols)
	}
	return LCS{matrix: matrix}
}

/*
findLCSLength finds the length of the Longest Common Subsequence (LCS) between two strings.
It takes two strings as input and returns the length of the LCS.
*/
func (l *LCS) findLCSLength(str1, str2 string) int {
	m, n := len(str1), len(str2)

	for i := 1; i <= m; i++ {
		for j := 1; j <= n; j++ {
			if str1[i-1] == str2[j-1] {
				l.matrix[i][j] = l.matrix[i-1][j-1] + 1
			} else {
				l.matrix[i][j] = max(l.matrix[i-1][j], l.matrix[i][j-1])
			}
		}
	}

	return l.matrix[m][n]
}

/*
max returns the maximum of two integers.
It takes two integers as input and returns the maximum value.
*/
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

/*
main is the entry point of the program.
It initializes the LCS struct, finds the length of the LCS between two strings,
and prints the result.
*/
func main() {
	str1 := "ABCBDAB"
	str2 := "BDCAB"

	lcs := NewLCS(len(str1)+1, len(str2)+1)
	length := lcs.findLCSLength(str1, str2)

	fmt.Printf("Length of Longest Common Subsequence: %d\n", length)
}

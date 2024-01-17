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

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	str1 := "ABCBDAB"
	str2 := "BDCAB"

	lcs := NewLCS(len(str1)+1, len(str2)+1)
	length := lcs.findLCSLength(str1, str2)

	fmt.Printf("Length of Longest Common Subsequence: %d\n", length)
}

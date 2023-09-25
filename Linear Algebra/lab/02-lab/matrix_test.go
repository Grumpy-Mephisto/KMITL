package main

import (
	"reflect"
	"testing"
)

func TestMatrixCreate(t *testing.T) {
	testCases := []struct {
		rows, cols int
		expected   [][]int
	}{
		{0, 0, nil},
		{2, 3, [][]int{{0, 0, 0}, {0, 0, 0}}},
		{3, 2, [][]int{{0, 0}, {0, 0}, {0, 0}}},
	}

	for _, tc := range testCases {
		result := matrixCreate(tc.rows, tc.cols)
		if !reflect.DeepEqual(result, tc.expected) {
			t.Errorf("matrixCreate(%d, %d) = %v; want %v", tc.rows, tc.cols, result, tc.expected)
		}
	}
}

func TestMatrixMultiply(t *testing.T) {
	testCases := []struct {
		matrix1, matrix2 [][]int
		expected         [][]int
	}{
		{
			[][]int{{1, 2}, {3, 4}},
			[][]int{{5, 6}, {7, 8}},
			[][]int{{19, 22}, {43, 50}},
		},
		{
			[][]int{{1, 2, 3}, {4, 5, 6}},
			[][]int{{7, 8}, {9, 10}, {11, 12}},
			[][]int{{58, 64}, {139, 154}},
		},
		{
			[][]int{{1, 2}, {3, 4}},
			[][]int{{5, 6}, {7, 8}, {9, 10}},
			nil,
		},
	}

	for _, tc := range testCases {
		result := matrixMultiply(tc.matrix1, tc.matrix2)
		if !reflect.DeepEqual(result, tc.expected) {
			t.Errorf("matrixMultiply(%v, %v) = %v; want %v", tc.matrix1, tc.matrix2, result, tc.expected)
		}
	}
}

func TestMatrixTranspose(t *testing.T) {
	testCases := []struct {
		matrix   [][]int
		expected [][]int
	}{
		{
			[][]int{{1, 2}, {3, 4}},
			[][]int{{1, 3}, {2, 4}},
		},
		{
			[][]int{{1, 2, 3}, {4, 5, 6}},
			[][]int{{1, 4}, {2, 5}, {3, 6}},
		},
		{
			[][]int{{1}},
			[][]int{{1}},
		},
	}

	for _, tc := range testCases {
		result := matrixTranspose(tc.matrix)
		if !reflect.DeepEqual(result, tc.expected) {
			t.Errorf("matrixTranspose(%v) = %v; want %v", tc.matrix, result, tc.expected)
		}
	}
}

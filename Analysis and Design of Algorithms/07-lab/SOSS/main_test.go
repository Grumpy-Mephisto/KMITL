package main

import (
	"math"
	"testing"
)

func TestNewSubset(t *testing.T) {
	testCases := []struct {
		Name   string
		Binary string
		Sum    int
	}{
		{"Test 1", "1111", 34},
		{"Test 2", "0000", 0},
		{"Test 3", "1010", 24},
	}

	for _, tc := range testCases {
		t.Run(tc.Name, func(t *testing.T) {
			subset := NewSubset(tc.Binary, tc.Sum)
			if subset.sum != tc.Sum {
				t.Errorf("Expected sum of %d, got %d", tc.Sum, subset.sum)
			}
			if subset.binaryRep != tc.Binary {
				t.Errorf("Expected binaryRep of '%s', got '%s'", tc.Binary, subset.binaryRep)
			}
		})
	}
}

func TestGenerateSubsets(t *testing.T) {
	testCases := []struct {
		Name       string
		Set        []int
		SubsetsLen int
		TargetSum  int
	}{
		{"Test 1", []int{11, 13, 3, 7}, 16, 34},
		{"Test 2", []int{1, 2, 3, 4}, 16, 10},
		{"Test 3", []int{1, 2, 3, 4, 5}, 32, 15},
	}

	for _, tc := range testCases {
		t.Run(tc.Name, func(t *testing.T) {
			subsets, targetSum := GenerateSubsets(tc.Set)
			if len(subsets) != tc.SubsetsLen {
				t.Errorf("Expected %d subsets, got %d", tc.SubsetsLen, len(subsets))
			}
			if targetSum != tc.TargetSum {
				t.Errorf("Expected targetSum of %d, got %d", tc.TargetSum, targetSum)
			}
		})
	}
}

func BenchmarkGenerateSubsets(b *testing.B) {
	set := []int{math.MaxInt32, math.MaxInt32, math.MaxInt32, math.MaxInt32}
	for i := 0; i < b.N; i++ {
		GenerateSubsets(set)
	}
}

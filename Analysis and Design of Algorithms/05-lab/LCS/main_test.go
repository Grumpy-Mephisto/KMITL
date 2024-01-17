package main

import "testing"

func TestNewLCS(t *testing.T) {
	lcs := NewLCS(3, 4)
	if len(lcs.matrix) != 3 {
		t.Errorf("Expected matrix rows to be 3, got %d", len(lcs.matrix))
	}
	if len(lcs.matrix[0]) != 4 {
		t.Errorf("Expected matrix columns to be 4, got %d", len(lcs.matrix[0]))
	}
}

func TestFindLCSLength(t *testing.T) {
	lcs := NewLCS(3, 4)
	str1 := "ABCBDAB"
	str2 := "BDCAB"
	length := lcs.findLCSLength(str1, str2)
	if length != 4 {
		t.Errorf("Expected LCS length to be 4, got %d", length)
	}
}

func TestMax(t *testing.T) {
	a := 5
	b := 10
	result := max(a, b)
	if result != b {
		t.Errorf("Expected max value to be %d, got %d", b, result)
	}
}

func TestMain(t *testing.T) {
	// TODO: Write test cases for the main function
}

package main

import (
	"fmt"
	"testing"
)

func generateRandomString(length int) string {
	var letters = []rune("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")
	b := make([]rune, length)
	for i := range b {
		b[i] = letters[i%len(letters)]
	}
	return string(b)
}

func TestFindLCSLength(t *testing.T) {
	testCases := []struct {
		name   string
		str1   string
		str2   string
		length int
	}{
		{"Basic LCS", "AXYT", "AYZX", 2},
		{"Same Strings", "ABCDEF", "ABCDEF", 6},
		{"No Common Subsequence", "ABCDEF", "GHIJKL", 0},
		{"One Empty String", "", "ABCDEF", 0},
		{"Both Empty Strings", "", "", 0},
		{"Homework", "ABCBCAB", "BDCABD", 4},
	}

	for _, test := range testCases {
		t.Run(test.name, func(t *testing.T) {
			lcs := NewLCS(len(test.str1)+1, len(test.str2)+1)
			got := lcs.FindLCSLength(test.str1, test.str2)
			if got != test.length {
				t.Errorf("FindLCSLength(%q, %q) = %d; want %d", test.str1, test.str2, got, test.length)
			}
		})
	}
}

func TestFindLCS(t *testing.T) {
	testCases := []struct {
		name     string
		str1     string
		str2     string
		expected string
	}{
		{"Basic LCS", "AXYT", "AYZX", "AY"},
		{"Same Strings", "ABCDEF", "ABCDEF", "ABCDEF"},
		{"No Common Subsequence", "ABCDEF", "GHIJKL", ""},
		{"One Empty String", "", "ABCDEF", ""},
		{"Both Empty Strings", "", "", ""},
		{"Homework", "ABCBCAB", "BDCABD", "BCAB"},
	}

	for _, test := range testCases {
		t.Run(test.name, func(t *testing.T) {
			lcs := NewLCS(len(test.str1)+1, len(test.str2)+1)
			lcs.FindLCSLength(test.str1, test.str2)
			got := lcs.FindLCS(test.str1, test.str2)
			if got != test.expected {
				t.Errorf("%s: FindLCS(%q, %q) = %q; want %q", test.name, test.str1, test.str2, got, test.expected)
			}
		})
	}
}

func BenchmarkFindLCSLength(b *testing.B) {
	testCases := []struct {
		name string
		str1 string
		str2 string
	}{
		{"Short Strings", "ABCBCAB", "BDCABD"},
		{"Medium Strings", generateRandomString(50), generateRandomString(50)},
		{"Long Strings", generateRandomString(100), generateRandomString(100)},
	}

	for _, test := range testCases {
		b.Run(fmt.Sprintf("%s (%d x %d)", test.name, len(test.str1), len(test.str2)), func(b *testing.B) {
			for i := 0; i < b.N; i++ {
				lcs := NewLCS(len(test.str1)+1, len(test.str2)+1)
				lcs.FindLCSLength(test.str1, test.str2)
			}
		})
	}
}

func BenchmarkFindLCS(b *testing.B) {
	testCases := []struct {
		name string
		str1 string
		str2 string
	}{
		{"Short Strings", "ABCBCAB", "BDCABD"},
		{"Medium Strings", generateRandomString(50), generateRandomString(50)},
		{"Long Strings", generateRandomString(100), generateRandomString(100)},
	}

	for _, test := range testCases {
		b.Run(fmt.Sprintf("%s (%d x %d)", test.name, len(test.str1), len(test.str2)), func(b *testing.B) {
			for i := 0; i < b.N; i++ {
				lcs := NewLCS(len(test.str1)+1, len(test.str2)+1)
				lcs.FindLCSLength(test.str1, test.str2)
				lcs.FindLCS(test.str1, test.str2)
			}
		})
	}
}

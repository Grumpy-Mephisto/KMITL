package main

import (
	"testing"
)

func TestTraversal(t *testing.T) {
	expectedCases := []struct {
		name      string
		expected  string
		traversal func() string
	}{
		{
			name:     "Pre-order",
			expected: "N O P R N A P K O ",
			traversal: func() string {
				root := mockupTestTree()
				return root.preOrder()
			},
		},
		{
			name:     "In-order",
			expected: "R P N O A N K P O ",
			traversal: func() string {
				root := mockupTestTree()
				return root.inOrder()
			},
		},
		{
			name:     "Post-order",
			expected: "R N P A O K O P N ",
			traversal: func() string {
				root := mockupTestTree()
				return root.postOrder()
			},
		},
	}

	for _, tc := range expectedCases {
		t.Run(tc.name, func(t *testing.T) {
			result := tc.traversal()
			if result != tc.expected {
				t.Errorf("%s() = %q, want %q", tc.name, result, tc.expected)
			}
		})
	}
}

func BenchmarkTraversal(b *testing.B) {
	benchmarkCases := []struct {
		name      string
		traversal func() string
	}{
		{
			name: "Pre-order",
			traversal: func() string {
				root := mockupTestTree()
				return root.preOrder()
			},
		},
		{
			name: "In-order",
			traversal: func() string {
				root := mockupTestTree()
				return root.inOrder()
			},
		},
		{
			name: "Post-order",
			traversal: func() string {
				root := mockupTestTree()
				return root.postOrder()
			},
		},
	}

	for _, bc := range benchmarkCases {
		b.Run(bc.name, func(b *testing.B) {
			for i := 0; i < b.N; i++ {
				bc.traversal()
			}
		})
	}
}

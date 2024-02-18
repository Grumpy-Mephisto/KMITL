package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

import (
	"testing"

	"gotest.tools/assert"
)

func TestDFS(t *testing.T) {
	L := "ABCDEFGH"
	v := [][]byte{
		[]byte("GFDB"),
		[]byte("AHC"),
		[]byte("B"),
		[]byte("AE"),
		[]byte("FD"),
		[]byte("AE"),
		[]byte("A"),
		[]byte("B"),
	}

	graph := NewGraph(L, v)

	expectedResult := []byte{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'}
	actualResult := graph.DFS(L[0])

	assert.Equal(t, expectedResult, actualResult, "DFS result does not match expected result")
}

func TestBFS(t *testing.T) {
	L := "ABCDEFGH"
	v := [][]byte{
		[]byte("GFDB"),
		[]byte("AHC"),
		[]byte("B"),
		[]byte("AE"),
		[]byte("FD"),
		[]byte("AE"),
		[]byte("A"),
		[]byte("B"),
	}

	graph := NewGraph(L, v)

	expectedResult := []byte{'A', 'G', 'H', 'F', 'D', 'B', 'C', 'E'}
	actualResult := graph.BFS(L[0])

	assert.Equal(t, expectedResult, actualResult, "BFS result does not match expected result")
}

package main

import (
	"fmt"
	"strconv"
)

type SubsetCalculator interface {
	FindSubsets(set []int, targetSum int)
}

type SubsetCalculatorImpl struct{}

func NewSubsetCalculator() *SubsetCalculatorImpl {
	return &SubsetCalculatorImpl{}
}

func (s *SubsetCalculatorImpl) FindSubsets(set []int, targetSum int) {
	N := 1 << uint(len(set))
	fmt.Println("ix\tx\treverseX\tSum")
	for ix := 0; ix < N; ix++ {
		sum := 0
		for j := 0; j < len(set); j++ {
			if (ix>>uint(j))%2 == 1 {
				sum += set[j]
			}
		}
		binary := strconv.FormatInt(int64(ix), 2)
		binary = padLeft(binary, len(set), '0')
		reversedBinary := reverseString(binary)
		if sum == targetSum {
			fmt.Printf("%d\t%s\t%s\t\t%d📌\n", ix, binary, reversedBinary, sum)
		} else {
			fmt.Printf("%d\t%s\t%s\t\t%d\n", ix, binary, reversedBinary, sum)
		}
	}
}

func padLeft(str string, length int, char rune) string {
	for len(str) < length {
		str = string(char) + str
	}
	return str
}

func reverseString(s string) string {
	runes := []rune(s)
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
	return string(runes)
}

func main() {
	W := []int{11, 13, 3, 7}
	targetSum := W[1] + W[2] + W[3]

	fmt.Println("Student ID: 65050437")
	calculator := NewSubsetCalculator()
	fmt.Println("Target Sum:", targetSum)
	calculator.FindSubsets(W, targetSum)
}

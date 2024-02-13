package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

type Subset struct {
	binaryRep string
	sum       int
}

func NewSubset(binaryRep string, sum int) *Subset {
	return &Subset{binaryRep: binaryRep, sum: sum}
}

func GenerateSubsets(set []int) ([]*Subset, int) {
	subsets := make([]*Subset, 1<<len(set))
	maxBinaryLength := len(set)
	targetSum := 0

	for i := range subsets {
		binaryRep := fmt.Sprintf("%0*b", maxBinaryLength, i)
		sum := 0

		for j, bit := range binaryRep {
			if bit == '1' {
				sum += set[j]
			}
		}

		subsets[i] = NewSubset(binaryRep, sum)
		if i < len(set) { // Only sum set elements once
			targetSum += set[i]
		}
	}

	return subsets, targetSum
}

func printSubsets(subsets []*Subset, targetSum int) string {
	var sb strings.Builder
	maxBinaryLength := len(subsets[0].binaryRep)
	indexWidth := len(fmt.Sprintf("%d", len(subsets)-1))
	sumWidth := len(fmt.Sprintf("%d", targetSum))

	headerFormat := fmt.Sprintf("| %%-%ds | %%-%ds | %%%ds | %%-5s |\n", indexWidth, maxBinaryLength, sumWidth)
	separator := strings.Repeat("-", len(fmt.Sprintf(headerFormat, "Index", "Subset (Binary)", "Sum", "Match")))

	sb.WriteString(separator + "\n")
	sb.WriteString(fmt.Sprintf(headerFormat, "Index", "Subset (Binary)", "Sum", "Match"))
	sb.WriteString(separator + "\n")

	for i, subset := range subsets {
		matchIndicator := "No"
		if subset.sum == targetSum {
			matchIndicator = "Yes"
		}
		sb.WriteString(fmt.Sprintf(headerFormat, fmt.Sprintf("%d", i), subset.binaryRep, fmt.Sprintf("%d", subset.sum), matchIndicator))
	}
	sb.WriteString(separator + "\n")
	return sb.String()
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)

	fmt.Print("Enter set elements separated by space: ")
	scanner.Scan()
	input := scanner.Text()
	inputElements := strings.Split(input, " ")

	W := make([]int, len(inputElements))
	for i, element := range inputElements {
		num, err := strconv.Atoi(element)
		if err != nil {
			fmt.Fprintf(os.Stderr, "Error reading set element: %v\n", err)
			os.Exit(1)
		}
		W[i] = num
	}

	fmt.Print("Enter target sum (Press enter for the sum of all elements): ")
	scanner.Scan()
	targetSumInput := scanner.Text()
	targetSum := 0
	if targetSumInput != "" {
		var err error
		targetSum, err = strconv.Atoi(targetSumInput)
		if err != nil {
			fmt.Fprintf(os.Stderr, "Error reading target sum: %v\n", err)
			os.Exit(1)
		}
	}

	subsets, defaultSum := GenerateSubsets(W)
	if targetSum == 0 {
		targetSum = defaultSum
	}

	fmt.Println(printSubsets(subsets, targetSum))
}

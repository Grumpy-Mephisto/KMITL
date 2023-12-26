package main

import (
	"fmt"
)

type Item struct {
	Profit int
	Weight int
}

func performKnapsackAlgorithm(knapsackCapacity int, items []Item) int {
	numOfObjects := len(items)

	densityArr := make([]float64, numOfObjects)
	kpResultantSolutionArr := make([]int, numOfObjects)

	knapsackResultantProfit := 0

	for i := 0; i < numOfObjects; i++ {
		densityArr[i] = float64(items[i].Profit) / float64(items[i].Weight)
	}

	for i := 0; i < numOfObjects-1; i++ {
		for j := i + 1; j < numOfObjects; j++ {
			if densityArr[i] < densityArr[j] {
				densityArr[i], densityArr[j] = densityArr[j], densityArr[i]
				items[i], items[j] = items[j], items[i]
			}
		}
	}

	for i := 0; i < numOfObjects; i++ {
		if items[i].Weight <= knapsackCapacity {
			knapsackCapacity -= items[i].Weight
			knapsackResultantProfit += items[i].Profit
			kpResultantSolutionArr[i] = 1
		} else if knapsackCapacity != 0 {
			knapsackResultantProfit += int(float64(items[i].Profit) * (float64(knapsackCapacity) / float64(items[i].Weight)))
			kpResultantSolutionArr[i] = knapsackCapacity / items[i].Weight
			knapsackCapacity = 0
		} else {
			kpResultantSolutionArr[i] = 0
		}
	}

	return knapsackResultantProfit
}

func printOutput(result int) {
	fmt.Println("Knapsack Algorithm Result:", result)
	fmt.Println("===== Thank you for using the Knapsack Algorithm =====")
}



func main() {
	fmt.Println("===== Welcome to the Knapsack Algorithm =====")

	numOfObjects := getUserInput("Enter the number of objects: ")

	knapsackCapacity := getUserInput("Enter the knapsack capacity: ")

	items := make([]Item, numOfObjects)
	for i := 0; i < numOfObjects; i++ {
		profit := getUserInput(fmt.Sprintf("Enter profit for item %d: ", i+1))
		weight := getUserInput(fmt.Sprintf("Enter weight for item %d: ", i+1))
		items[i] = Item{Profit: profit, Weight: weight}
	}

	knapsackResult := performKnapsackAlgorithm(knapsackCapacity, items)
	printOutput(knapsackResult)
}

package main

import (
	"fmt"
)

type Item struct {
	Profit int
	Weight int
}

func knapsackAlgorithm(knapsackCapacity int, items []Item) int {
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

func getInput(prompt string) int {
	var input int
	fmt.Print(prompt)
	_, err := fmt.Scanln(&input)
	if err != nil {
		fmt.Println("Please enter a valid number.")
		return getInput(prompt)
	}
	return input
}

func main() {
	fmt.Println("===== Welcome to the Knapsack Algorithm =====")

	numOfObjects := getInput("Enter the number of objects: ")

	knapsackCapacity := getInput("Enter the knapsack capacity: ")

	items := make([]Item, numOfObjects)

	for i := 0; i < numOfObjects; i++ {
		profit := getInput(fmt.Sprintf("Enter profit for item %d: ", i+1))
		weight := getInput(fmt.Sprintf("Enter weight for item %d: ", i+1))

		if weight > knapsackCapacity {
			fmt.Println("Please enter a valid weight.")
			i--
		} else {
			items[i] = Item{Profit: profit, Weight: weight}
		}
	}

	knapsackResult := knapsackAlgorithm(knapsackCapacity, items)

	fmt.Println("Knapsack Algorithm Result:", knapsackResult)
	fmt.Println("===== Thank you for using the Knapsack Algorithm =====")
}

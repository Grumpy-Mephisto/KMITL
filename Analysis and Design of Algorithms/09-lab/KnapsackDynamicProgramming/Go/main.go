package main

import (
	"fmt"
	"strings"
)

type Item struct {
	Weight int
	Profit int
}

func knapsack(items []Item, capacity int) int {
	n := len(items)
	dp := make([][]int, n+1)

	for i := range dp {
		dp[i] = make([]int, capacity+1)
	}

	for i := 1; i <= n; i++ {
		for w := 1; w <= capacity; w++ {
			if items[i-1].Weight <= w {
				dp[i][w] = max(dp[i-1][w], items[i-1].Profit+dp[i-1][w-items[i-1].Weight])
			} else {
				dp[i][w] = dp[i-1][w]
			}
		}
	}

	return dp[n][capacity]
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func dynamicProgrammingTable(items []Item, capacity int) [][]int {
	n := len(items)
	dp := make([][]int, n+1)

	for i := range dp {
		dp[i] = make([]int, capacity+1)
	}

	for i := 1; i <= n; i++ {
		for w := 1; w <= capacity; w++ {
			if items[i-1].Weight <= w {
				dp[i][w] = max(dp[i-1][w], items[i-1].Profit+dp[i-1][w-items[i-1].Weight])
			} else {
				dp[i][w] = dp[i-1][w]
			}
		}
	}

	return dp
}

func printTable(table [][]int) {
	fmt.Println("🏓 Dynamic Programming Table:")
	for i := range table {
		for _, val := range table[i] {
			fmt.Printf("%5d", val)
		}
		fmt.Println()
	}
}

func nameToOneHot(name string) ([]int, error) {
	var result []int

	name = strings.ToUpper(name)

	for _, char := range name {
		order := int(char - 'A' + 1)
		result = append(result, order)
	}

	if len(result) == 0 {
		return nil, fmt.Errorf("empty result for name: %s", name)
	}

	return result, nil
}

func main() {
	name := "Noppako"
	oneHot, err := nameToOneHot(name)
	if err != nil {
		fmt.Println("Error:", err)
		return
	}
	fmt.Printf("🔥 One-Hot Encoding for name: %s to %v\n", name, oneHot)

	items := []Item{
		{Weight: 4, Profit: oneHot[0]},
		{Weight: 10, Profit: oneHot[1]},
		{Weight: 6, Profit: oneHot[2]},
		{Weight: 9, Profit: oneHot[3]},
		{Weight: 8, Profit: oneHot[4]},
		{Weight: 1, Profit: oneHot[5]},
		{Weight: 20, Profit: oneHot[6]},
	}
	capacity := 19
	fmt.Printf("🎒 Items: %v, Capacity: %d\n", items, capacity)

	result := knapsack(items, capacity)
	fmt.Printf("🏋️ Maximum Profit: %d\n", result)

	dpTable := dynamicProgrammingTable(items, capacity)
	printTable(dpTable)
}

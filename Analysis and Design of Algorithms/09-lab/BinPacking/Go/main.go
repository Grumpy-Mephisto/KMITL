package main

import (
	"fmt"
	"sort"
	"strings"
)

type Bin struct {
	id       int
	capacity int
	items    []int
}

// Function firstFit takes a list of items and a bin capacity as input and returns a list of bins.
// It uses the First Fit algorithm to pack the items into the bins.
// The First Fit algorithm tries to fit each item into the first bin that has enough capacity.
// If no bin has enough capacity, a new bin is created.
func firstFit(items []int, binCapacity int) []Bin {
	var bins []Bin

	for _, item := range items {
		fitted := false

		for i := range bins {
			if bins[i].capacity >= item {
				bins[i].items = append(bins[i].items, item)
				bins[i].capacity -= item
				fitted = true
				break
			}
		}

		if !fitted {
			newBin := Bin{
				id:       len(bins) + 1,
				capacity: binCapacity - item,
				items:    []int{item},
			}
			bins = append(bins, newBin)
		}
	}

	return bins
}

func bestFit(items []int, binCapacity int) []Bin {
// It uses the Best Fit algorithm to pack the items into the bins.
// The Best Fit algorithm tries to fit each item into the bin with the smallest remaining capacity that can accommodate the item.
// If no bin can accommodate the item, a new bin is created.
func bestFit(items []int, binCapacity int) []Bin {
	var bins []Bin

	for _, item := range items {
		bestFitIndex := -1
		minRemainingCapacity := binCapacity + 1

		for i := range bins {
			remainingCapacity := bins[i].capacity - item
			if remainingCapacity >= 0 && remainingCapacity < minRemainingCapacity {
				bestFitIndex = i
				minRemainingCapacity = remainingCapacity
			}
		}

		if bestFitIndex != -1 {
			bins[bestFitIndex].items = append(bins[bestFitIndex].items, item)
			bins[bestFitIndex].capacity -= item
		} else {
			newBin := Bin{
				id:       len(bins) + 1,
				capacity: binCapacity - item,
				items:    []int{item},
			}
			bins = append(bins, newBin)
		}
	}

	return bins
}

func firstFitDecreasing(items []int, binCapacity int) []Bin {
	sort.Sort(sort.Reverse(sort.IntSlice(items)))
	return firstFit(items, binCapacity)
}

// Function printBins takes a list of bins as input and prints the details of each bin.
// It prints the bin ID, capacity, and the items contained in the bin.
func printBins(bins []Bin) {
	for _, bin := range bins {
		fmt.Printf("  • Bin %d (Capacity %d): %v\n", bin.id, bin.capacity, bin.items)
	}
}

func nameToOneHot(name string) []int {
	var result []int

	name = strings.ToUpper(name)

	for _, char := range name {
		order := int(char - 'A' + 1)

		if order >= 10 {
			order = order/10 + order%10
		}

		result = append(result, order)
	}

	return result
}

func main() {
	name := "Noppakorn"
	items := nameToOneHot(name)
	binCapacity := 10

	fmt.Printf("😣 Name: %s\n", name)
	fmt.Println("📦 Items:", items)
	fmt.Println("📏 Bin Capacity:", binCapacity)

	// First Fit
	firstFitBins := firstFit(items, binCapacity)
	fmt.Println("\n🥇 First Fit:")
	printBins(firstFitBins)

	// Best Fit
	bestFitBins := bestFit(items, binCapacity)
	fmt.Println("\n🥈 Best Fit:")
	printBins(bestFitBins)

	// First Fit Decreasing (FFD)
	ffdBins := firstFitDecreasing(items, binCapacity)
	fmt.Println("\n🥉 First Fit Decreasing:")
	printBins(ffdBins)
}
	ffdBins := firstFitDecreasing(items, binCapacity)
	fmt.Println("\n🥉 First Fit Decreasing:")
	printBins(ffdBins)
}
// Function firstFitDecreasing takes a list of items and a bin capacity as input and returns a list of bins.
// It uses the First Fit Decreasing algorithm to pack the items into the bins.
// The First Fit Decreasing algorithm first sorts the items in decreasing order and then applies the First Fit algorithm.
// The First Fit algorithm tries to fit each item into the first bin that has enough capacity.
// If no bin has enough capacity, a new bin is created.
func firstFitDecreasing(items []int, binCapacity int) []Bin {
	sort.Sort(sort.Reverse(sort.IntSlice(items)))
	return firstFit(items, binCapacity)
}

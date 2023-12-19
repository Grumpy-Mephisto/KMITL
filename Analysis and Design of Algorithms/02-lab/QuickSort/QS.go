package main

import (
	"fmt"
	"strings"
)

type StudentID = int

type QuickSort struct {
	Array []StudentID
}

func NewQuickSort(arr []StudentID) *QuickSort {
	return &QuickSort{Array: arr}
}

func (qs *QuickSort) Sort() {
	qs.quickSort(0, len(qs.Array)-1)
}

func (qs *QuickSort) quickSort(low, high int) {
	if low < high {
		pivotIndex := qs.partition(low, high)
		qs.printStep(low, high, pivotIndex)
		qs.quickSort(low, pivotIndex-1)  // ก่อน pivotIndex
		qs.quickSort(pivotIndex+1, high) // หลัง pivotIndex
	}
}

func (qs *QuickSort) partition(low, high int) int {
	arr := qs.Array
	pivot := arr[high] // ค่าสุดท้ายเป็น pivot
	i := low - 1       // ตัวที่จะเป็น pivot ในรอบนั้นๆ

	for j := low; j < high; j++ {
		if arr[j] < pivot { // ถ้าตัวที่ j น้อยกว่า pivot
			i++
			arr[i], arr[j] = arr[j], arr[i] // สลับตำแหน่ง
			fmt.Printf("Step: Swap: %d with %d. Array: %v\n", arr[i], arr[j], arr)
		} else {
			fmt.Printf("Step: No swap. Array: %v\n", arr)
		}
	}

	arr[i+1], arr[high] = arr[high], arr[i+1] // สลับตำแหน่ง
	return i + 1
}

func (qs *QuickSort) printStep(low, high, pivotIndex int) {
	var sb strings.Builder

	for i, v := range qs.Array {
		if i == pivotIndex {
			sb.WriteString(fmt.Sprintf("[%d] ", v))
		} else {
			sb.WriteString(fmt.Sprintf("%d ", v))
		}
	}

	fmt.Printf("Step: Pivot (%d) placed at index [%d]. Array: %s\n", qs.Array[pivotIndex], pivotIndex, sb.String())
	fmt.Println("--------------------------------------------------------------------------------------------------")
}

func main() {
	studentIDs := []StudentID{12, 47, 32, 75, 16, 45, 39, 86, 23, 43}

	qs := NewQuickSort(studentIDs)
	fmt.Println("Original array:", qs.Array)
	fmt.Println()
	qs.Sort()
	fmt.Println("Sorted array:", qs.Array)
}

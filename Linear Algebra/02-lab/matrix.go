package main

import (
	"fmt"
	"log"
)

func matrixCreate(rows int, cols int) [][]int {
	if rows <= 0 || cols <= 0 {
		return nil
	}

	matrix := make([][]int, rows)

	for i := 0; i < rows; i++ {
		matrix[i] = make([]int, cols)
	}

	return matrix
}

func matrixMultiply(matrix1 [][]int, matrix2 [][]int) [][]int {
	rows1 := len(matrix1)
	cols1 := len(matrix1[0])
	rows2 := len(matrix2)
	cols2 := len(matrix2[0])

	if cols1 != rows2 {
		return nil
	}

	product := matrixCreate(rows1, cols2)

	for i := 0; i < rows1; i++ {
		for j := 0; j < cols2; j++ {
			product[i][j] = 0
			for k := 0; k < cols1; k++ {
				product[i][j] += matrix1[i][k] * matrix2[k][j]
			}
		}
	}

	return product
}

func matrixPrint(matrix [][]int) {
	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix[i]); j++ {
			fmt.Print(matrix[i][j], " ")
		}
		fmt.Println()
	}
	fmt.Println()
}

func main() {
	var (
		rows        int
		cols        int
		matrixCount int
		matrices    [][][]int
		err         error
	)

	fmt.Print("===== Number of matrices =====\n")
	fmt.Print("Enter number of matrices: ")
	_, err = fmt.Scanf("%d", &matrixCount)
	if err != nil {
		log.Fatalf("Error reading value: %s", err)
	}

	matrices = make([][][]int, matrixCount)

	for i := 0; i < matrixCount; i++ {
		fmt.Printf("\n===== Matrix %d =====\n", i+1)
		fmt.Print("Enter number of rows: ")
		_, err = fmt.Scanf("%d", &rows)
		if err != nil {
			log.Fatalf("Error reading value: %s", err)
		}

		fmt.Print("Enter number of columns: ")
		_, err = fmt.Scanf("%d", &cols)
		if err != nil {
			log.Fatalf("Error reading value: %s", err)
		}

		matrix := matrixCreate(rows, cols)

		fmt.Printf("\n===== Enter values for matrix %d =====\n", i+1)
		for i := 0; i < rows; i++ {
			for j := 0; j < cols; j++ {
				fmt.Printf("Enter value for row %d and column %d: ", i, j)
				_, err = fmt.Scanf("%d", &matrix[i][j])
				if err != nil {
					log.Fatalf("Error reading value: %s", err)
				}
			}
		}

		matrices[i] = matrix
	}

	fmt.Println("\n===== Matrices =====")
	for i, matrix := range matrices {
		fmt.Printf("Matrix %d:\n", i+1)
		matrixPrint(matrix)
		fmt.Println()
	}

	fmt.Println("\n===== Product of Matrices =====")
	for i := 0; i < matrixCount; i++ {
		for j := 0; j < matrixCount; j++ {
			if i != j {
				fmt.Printf("Matrix %d * Matrix %d:\n", i+1, j+1)
				matrixPrint(matrixMultiply(matrices[i], matrices[j]))
			}
		}
	}
}

package main

import (
	"fmt"
	"math"
)

func main() {
	equation := "Ax^2 + Bx + C = 0"

	a, b, c := getCoefficients(equation)

	discriminant := calculateDiscriminant(a, b, c)

	root1, root2 := calculateRoots(a, b, discriminant)

	printResults(root1, root2)
}

func getCoefficients(equation string) (float64, float64, float64) {
	fmt.Println("Enter the coefficients for the equation: ", equation)

	var a, b, c float64

	fmt.Print("A: ")
	fmt.Scan(&a)

	fmt.Print("B: ")
	fmt.Scan(&b)

	fmt.Print("C: ")
	fmt.Scan(&c)

	return a, b, c
}

func calculateDiscriminant(a, b, c float64) float64 {
	if a == 0 {
		fmt.Println("A cannot be 0")
		return 0
	}

	result := math.Pow(b, 2) - 4*a*c

	return result
}

func calculateRoots(a, b, discriminant float64) (float64, float64) {
	root1 := (-b + math.Sqrt(discriminant)) / (2 * a)
	root2 := (-b - math.Sqrt(discriminant)) / (2 * a)

	return root1, root2
}

func printResults(root1, root2 float64) {
	fmt.Println("Root 1: ", root1)
	fmt.Println("Root 2: ", root2)
}

/*
Package main

Description: This file contains functions for implementing a quadratic equation solver.
             It reads coefficients from user input and calculates the roots.
*/

package main

import (
	"fmt"
	"math"
)

/*
main is the entry point of the program.
It defines the quadratic equation as a string,
gets the coefficients from the user,
calculates the discriminant and the roots,
and prints out the results.
*/

/*
FindSubsets finds subsets of a given set that sum up to a target sum.
*/

/*
padLeft pads a string with a specified character on the left side to a specified length.
*/

/*
reverseString reverses a given string.
*/
func main() {
	equation := "Ax^2 + Bx + C = 0"

	a, b, c := getCoefficients(equation)

	discriminant := calculateDiscriminant(a, b, c)

	root1, root2 := calculateRoots(a, b, discriminant)

	printResults(root1, root2)
}

/*
getCoefficients prompts the user to enter the coefficients (A, B, C) for the given quadratic equation.
It returns the coefficients as three float64 values.
*/
func getCoefficients(equation string) (float64, float64, float64) {
	fmt.Println("Enter the coefficients for the equation: ", equation)

	var a, b, c float64

		/*
	getCoefficients prompts the user to enter the coefficients (A, B, C) for the given quadratic equation.
	It returns the coefficients as three float64 values.
	*/
	fmt.Print("A: ")
	fmt.Scan(&a)

	fmt.Print("B: ")
	fmt.Scan(&b)

	fmt.Print("C: ")
	fmt.Scan(&c)

	return a, b, c
}

/*
* calculateDiscriminant computes the discriminant for the quadratic equation based on coefficients A, B, and C.
* It returns the discriminant as a float64 value.
*/

// TestNewSubset tests the NewSubset function.

// TestGenerateSubsets tests the GenerateSubsets function.

// BenchmarkGenerateSubsets benchmarks the GenerateSubsets function.

/*

/*

Description: This file contains test functions for the quadratic equation solver in main.go.

Description: This file contains test functions for the quadratic equation solver in main.go.
calculateDiscriminant computes the discriminant for the quadratic equation based on coefficients A, B, and C.
It returns the discriminant as a float64 value.
If A is 0, it outputs an error message as the equation would not be quadratic.
*/
func calculateDiscriminant(a, b, c float64) float64 {
	if a == 0 {
		fmt.Println("A cannot be 0")
		return 0
	}

	bSquared := b * b
	result := bSquared - (4 * a * c)

	return result
}

/*
calculateRoots computes the roots of the quadratic equation using the quadratic formula.
The discriminant is used to check for the presence of real roots.
It returns two float64 values representing the roots of the equation.
*/
func calculateRoots(a, b, discriminant float64) (float64, float64) {
	root1 := (-b + math.Sqrt(discriminant)) / (2 * a)
	root2 := (-b - math.Sqrt(discriminant)) / (2 * a)

	return root1, root2
}

/*
printResults outputs the results of the quadratic equation solver.
It takes two float64 values representing the roots and prints them.
*/
/*
	printResults outputs the results of the quadratic equation solver.
	It takes two float64 values representing the roots and prints them.
*/
func printResults(root1, root2 float64) {
	fmt.Println("Root 1: ", root1)
	fmt.Println("Root 2: ", root2)
}
/*
calculateRoots computes the roots of the quadratic equation using the quadratic formula.
The discriminant is used to check for the presence of real roots.
It returns two float64 values representing the roots of the equation.
*/

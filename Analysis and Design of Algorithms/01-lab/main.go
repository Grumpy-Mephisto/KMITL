/*
File: main.go
Description: This file implements a quadratic equation solver.
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
func main() {
	equation := "Ax^2 + Bx + C = 0"

	a, b, c := getCoefficients(equation)

	discriminant := calculateDiscriminant(a, b, c)

	root1, root2 := calculateRoots(a, b, discriminant)

	printResults(root1, root2)
}

/*
getCoefficients prompts the user to input the coefficients (A, B, C) for the quadratic equation
represented by the string provided as the function's argument. The user is asked to enter values for
each coefficient one at a time. The function then reads the input from the user and returns the
coefficients as three separate float64 values which can be used for further calculations in the equation.
*/
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

/*
calculateDiscriminant calculates the discriminant of a quadratic equation using the formula 'b^2 - 4ac'
based on the provided coefficients A, B, and C. The computed discriminant is essential to determine the
nature of the roots of the equation. The function returns the discriminant as a float64 value. If the leading
coefficient 'A' is zero, the function prints an error message stating "A cannot be 0" and returns a value of 0
as the discriminant, since the equation would not represent a quadratic equation without a squared term.
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
calculateRoots determines the roots of a quadratic equation using the quadratic formula:
(-b ± sqrt(discriminant)) / (2a). It takes the provided discriminant to check whether the equation
has real roots and calculates them accordingly, assuming the discriminant is not negative. The function
returns two float64 values representing the two roots of the quadratic equation. If the discriminant is
negative, meaning the equation has complex roots, these will not be calculated by this function.
*/
func calculateRoots(a, b, discriminant float64) (float64, float64) {
	root1 := (-b + math.Sqrt(discriminant)) / (2 * a)
	root2 := (-b - math.Sqrt(discriminant)) / (2 * a)

	return root1, root2
}

/*
printResults displays the calculated roots of the quadratic equation. It receives two float64 values
which correspond to the roots of the equation determined by the `calculateRoots` function. These values
are then output to the console with explanatory text; for example: "Root 1: " followed by the value of the first root.
*/
func printResults(root1, root2 float64) {
	fmt.Println("Root 1: ", root1)
	fmt.Println("Root 2: ", root2)
}

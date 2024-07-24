package main

import "fmt"

func main() {
	var (
		fahrenheit float64
		celsius float64
	)
	fmt.Print("Enter the temperature in Fahrenheit: ")
	fmt.Scanf("%f", &fahrenheit)

	celsius = (fahrenheit - 32) * 5/9

	fmt.Printf("%.2f Fahrenheit = %.2f Celsius\n", fahrenheit, celsius)
}
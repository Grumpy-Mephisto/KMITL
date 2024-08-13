package main

import (
	"fmt"
	"strings"
)

func main() {
	s1 := "This is the house that Jack built."

	fmt.Println(s1[:4])
	fmt.Println(s1[5:7])
	fmt.Println(strings.Index(s1, "This"))
	fmt.Println(strings.Index(s1, "J"))
	fmt.Println(strings.Index(s1[4:], "is") + 4)
	fmt.Println(len(s1))
	s1 = s1[5:]
	fmt.Println(s1)
	fmt.Println(len(s1))
}

package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	var a, b int
	sc := bufio.NewScanner(os.Stdin)
	for sc.Scan() {
		a, _ = strconv.Atoi(strings.Split(sc.Text(), " ")[0])
		b, _ = strconv.Atoi(strings.Split(sc.Text(), " ")[1])
		fmt.Println(a + b)
	}
}

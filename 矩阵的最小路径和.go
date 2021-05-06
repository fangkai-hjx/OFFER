package main

import (
	_ "fmt"
)

func main() {
	matrix := [][]int{
		{1, 3, 5, 9},
		{8, 1, 3, 4},
		{5, 0, 6, 1},
		{8, 8, 4, 0},
	}
	println(minPathSum(matrix))
}

//dp[i][j] = dp[i-1][]
func minPathSum(matrix [][]int) int {
	// write code here
	w, h := len(matrix)-1, len(matrix[0])-1
	dp := make([][]int, w+1)
	//初始化第一行和第一列
	for i := 0; i <= w; i++ {
		dp[i] = make([]int, h+1)
	}
	for i := 0; i < len(matrix[0]); i++ {
		if i == 0 {
			dp[0][i] = matrix[0][i]
			continue
		}
		dp[0][i] = dp[0][i-1] + matrix[0][i]
	}
	for i := 0; i < len(matrix); i++ {
		if i == 0 {
			dp[i][0] = matrix[i][0]
			continue
		}
		dp[i][0] = dp[i-1][0] + matrix[i][0]
	}

	for i := 1; i <= w; i++ {
		for j := 1; j <= h; j++ {
			if dp[i-1][j]+matrix[i][j] > 1 {

			}
		}
	}
	return 1
}

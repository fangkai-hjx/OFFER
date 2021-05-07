package main

import (
	_ "fmt"
)

func main() {
	matrix := [][]int{
		{1, 3, 5, 9},
		{8, 1, 3, 4},
		{5, 0, 6, 1},
		//{8, 8, 4, 0},
	}
	println(minPathSum(matrix))
}

//dp[i][j] = dp[i-1][]
func minPathSum(matrix [][]int) int {
	if len(matrix) == 0 {
		return 0
	}
	// write code here
	rows, cols := len(matrix)-1, len(matrix[0])-1
	dp := make([][]int, rows+1)
	for i := 0; i <= rows; i++ {
		dp[i] = make([]int, cols+1)
	}
	//初始化第一行和第一列
	dp[0][0] = matrix[0][0]
	for i := 1; i <= cols; i++ {
		dp[0][i] = dp[0][i-1] + matrix[0][i]
	}
	for i := 1; i <= rows; i++ {
		dp[i][0] = dp[i-1][0] + matrix[i][0]
	}
	for i := 1; i <= rows; i++ {
		for j := 1; j <= cols; j++ {
			if dp[i-1][j] > dp[i][j-1] {
				dp[i][j] = matrix[i][j] + dp[i][j-1]
			} else {
				dp[i][j] = matrix[i][j] + dp[i-1][j]
			}
		}
	}
	return dp[rows][cols]
}

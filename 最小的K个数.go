package main

import (
	"fmt"
	"sort"
)

//[4,5,1,6,2,7,3,8],4
func GetLeastNumbers_Solution(input []int, k int) []int {
	//TODO 1 参数校验
	if input == nil || len(input) == 0 {
		return nil
	}
	//TODO 2 排序
	sort.Ints(input)
	//TODO 3 找出最小的k个数
	res := make([]int, k)
	for i := 0; i < k; i++ {
		res[i] = input[i]
	}
	return res
}
func main() {
	fmt.Println(GetLeastNumbers_Solution([]int{4, 5, 1, 6, 2, 7, 3, 8}, 4))
}

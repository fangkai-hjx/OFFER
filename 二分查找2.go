package main

import "fmt"

func search(nums []int, target int) int {
	// write code here
	if nums == nil || len(nums) == 0 {
		return -1
	}
	left, right := 0, len(nums)-1
	for left <= right {
		middle := left + (right-left)/2
		if nums[middle] < target {
			left = middle + 1
		} else if nums[middle] > target {
			right = middle - 1
		} else if nums[middle] == target {
			for middle > 0 && (nums[middle-1] == nums[middle]) {
				middle--
			}
			return middle
		}
	}
	return -1
}
func main() {
	fmt.Println(search([]int{-2, 1, 2}, 2))
	//fmt.Println(search([]int{1,2,4,4,5},3))
	//fmt.Println(search([]int{1, 1, 1, 1, 1}, 1))
}

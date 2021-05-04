package main

import "fmt"

//[3,2,4,1,6],9
//[(3,1),(7,),(,),(,),]
func main() {
	fmt.Println(twoSum([]int{3, 2, 4, 1, 6}, 9))
}
func twoSum(numbers []int, target int) []int {
	// write code here
	if numbers == nil || len(numbers) == 0 {
		return []int{}
	}
	dict := make(map[int]int, len(numbers))
	for i, v := range numbers {
		index, ok := dict[target-v]
		if ok { //存在
			return []int{index + 1, i + 1}
		}
		//不存在
		dict[v] = i
	}
	return nil
}
func twoSum2(numbers []int, target int) []int {
	m := make(map[int]int, len(numbers))
	for i := range numbers {
		want := target - numbers[i]
		if j, has := m[want]; has {
			return []int{j + 1, i + 1}
		}
		m[numbers[i]] = i
	}
	return nil
}

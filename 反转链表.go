package main

func ReverseList(pHead *ListNode) *ListNode {
	// write code here
	if pHead == nil {
		return nil
	}
	var prev *ListNode = nil
	var post *ListNode = nil
	for pHead != nil {
		//逆转链表
		post = pHead.Next
		pHead.Next = prev
		//为下一次操作做准备
		prev = pHead
		pHead = post
	}
	return prev
}
func main() {

}

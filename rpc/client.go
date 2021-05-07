package main

import (
	"fmt"
	"net/rpc"
)

//使用步骤
//1 用rpc连接服务器
//conn.Call("服务名.方法名",传入参数,传出参数)
//2 调用远程函数
//

//结合 design
func main() {
	myClient := InitClient(":8080")
	var res string
	err := myClient.HelloWorld("方凯", &res)
	if err != nil {
		fmt.Println("HelloWorld err: ", err)
		return
	}
	fmt.Println(res)
}
func main01() {
	//1 用rpc连接服务器
	conn, err := rpc.Dial("tcp", ":8080")
	if err != nil {
		fmt.Println("Dial err:", err)
		return
	}
	defer conn.Close()
	//2 调用远程函数
	var reply string // 传出参数
	err = conn.Call("hello.HelloWorld", "黄金秀 ", &reply)
	if err != nil {
		fmt.Println("conn Call err: ", err)
		return
	}
	fmt.Println(reply)
}

package main

import (
	"fmt"
	"net"
	"net/rpc"
)

//使用步骤
//1 注册rpc服务对象。给对象绑定方法（1定义类 2绑定类方法）
//rpc.RegisterName("服务名",回调对象)
//2 创建监听器
//listener,err := net.Listen()
//3 建立连接
//conn,err := net.Accept()
//4 将连接绑定rpc服务
//rpc.ServeConn(conn)
type World struct {
}

func (w *World) HelloWorld(name string, resp *string) error {
	*resp = name + "你好！"
	//return errors.New("未知的错误！！！")
	return nil
}
func main() {
	//1 注册RPC服务，绑定对象方法
	//err := rpc.RegisterName("hello", new(World)) //第二个函数相当于回调函数
	//if err != nil {
	//	fmt.Println("注册rpc服务失败！", err)
	//	return
	//}
	err := RegisterService(new(World))
	if err != nil {
		fmt.Println("注册rpc服务失败！", err)
		return
	}
	//2 设置监听
	listener, err := net.Listen("tcp", ":8080")
	if err != nil {
		fmt.Println("net.Listen err: ", err)
		return
	}
	fmt.Println("开始监听...")
	//3 建立连接
	conn, err := listener.Accept()
	if err != nil {
		fmt.Println("Accept() err:", err)
		return
	}
	defer conn.Close()
	fmt.Println("连接成功...")
	//4 绑定服务
	rpc.ServeConn(conn)
}

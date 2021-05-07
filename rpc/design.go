package main

import (
	"net/rpc"
)

//定义一个接口，要求服务端在注册rpc对象时，能让编译器在编译期
//就检查出是否合法
type MyInterface interface {
	HelloWorld(string, *string) error
}

//调用该方法时，需要给 i 传参，参数应该时实现了HelloWorld 方法的类对象！

func RegisterService(i MyInterface) error {
	return rpc.RegisterName("hello", i)
}

//=============客户端用
//向调用本地函数一样，调用远程函数
type MyClient struct {
	c *rpc.Client
}

// 由于使用了 c 调用了 Call，因此需要初始化 C
func InitClient(addr string) MyClient {
	dial, _ := rpc.Dial("tcp", addr)
	return MyClient{c: dial}
}
func (this *MyClient) HelloWorld(a string, b *string) error {
	//参数1：参照上面的Interfave，Register而来，a传入参数，b传出参数
	return this.c.Call("hello.HelloWorld", a, b)
}

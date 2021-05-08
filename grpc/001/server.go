package main

import (
	"OFFER/grpc/001/pb"
	context "context" //上下文-----goroutine之间用来进行数据传递的API包
	"fmt"
	"google.golang.org/grpc"
	"net"
)

//定义类
type Children struct {
}

//按照接口去绑定方法
func (this *Children) SayHello(ctx context.Context, t *pb.Teacher) (*pb.Teacher, error) {
	t.Name += " 正在睡觉!!!"
	return t, nil
}
func main() {
	//1 初始化一个grpc对象
	grpcServer := grpc.NewServer()
	//2 注册服务
	pb.RegisterSayNameServer(grpcServer, new(Children))
	//3 设置监听
	listener, err := net.Listen("tcp", ":8080")
	if err != nil {
		fmt.Println("net.Lister err：", err)
		return
	}
	defer listener.Close()
	//4 启动服务
	err = grpcServer.Serve(listener)
	if err != nil {
		fmt.Println("grpcServer.Serve err：", err)
		return
	}
}

package main

import (
	"OFFER/grpc/001/pb"
	"context"
	"fmt"
	"google.golang.org/grpc"
)

func main() {
	//1. 连接 grpc 服务
	grpcConn, err := grpc.Dial(":8080", grpc.WithInsecure())
	if err != nil {
		fmt.Println("grpc.Dial err：", err)
		return
	}
	defer grpcConn.Close()
	//2. 初始化 grpc 客户端
	grpcClient := pb.NewSayNameClient(grpcConn)
	//3. 调用远程服务。
	teacher := pb.Teacher{
		Age:  18,
		Name: "fangkai",
	}
	t, err := grpcClient.SayHello(context.TODO(), &teacher)
	fmt.Println(t, err)
}

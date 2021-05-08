package main

import (
	"OFFER/grpc/002/pb"
	"context"
	"fmt"
	"github.com/hashicorp/consul/api"
	"google.golang.org/grpc"
	"strconv"
)

//服务注销
//func main()  {
//	// 1. 初始化 consul 配置
//	consuConfig := api.DefaultConfig()
//
//	// 2. 创建 consul 对象
//	consulClient, _ := api.NewClient(consuConfig)
//
//	// 3. 注销服务
//	consulClient.Agent().ServiceDeregister("fangkai")
//}
func main() {
	// 1 舒适化 consul 配置
	config := api.DefaultConfig()
	// 2 创建consul对象---可以重新consul属性，IP/Port,也可以使用默认
	client, err := api.NewClient(config)
	if err != nil {
		fmt.Println("api.NewClient", err)
		return
	}
	// 3 服务发现，
	service, _, err := client.Health().Service("grpc And Consul", "grpc", true, nil)
	target := service[0].Service.Address + ":" + strconv.Itoa(service[0].Service.Port)
	fmt.Println(target)
	main02(target)
}
func main02(target string) {
	//1 连接服务
	conn, err := grpc.Dial(target, grpc.WithInsecure())
	if err != nil {
		fmt.Println("grpc.Dial err：", err)
		return
	}
	defer conn.Close()
	//2 初始化grpc客户端
	client := pb.NewHelloClient(conn)
	person := pb.Person{
		Name: "方凯",
		Age:  111,
	}
	p, err := client.SayHello(context.TODO(), &person)
	if err != nil {
		fmt.Println("client.SayHello err：", err)
		return
	}
	fmt.Println(p, err)
}

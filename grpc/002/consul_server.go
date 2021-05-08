package main

import (
	"OFFER/grpc/002/pb"
	context "context"
	"fmt"
	"github.com/hashicorp/consul/api"
	"google.golang.org/grpc"
	"net"
)

type Children struct {
}

func (c *Children) SayHello(ctx context.Context, p *pb.Person) (*pb.Person, error) {
	p.Name = "Hello  " + p.Name
	fmt.Println("服务被调用")
	return p, nil
}
func main() {
	// 1. 初始化 consul 配置
	config := api.DefaultConfig()
	// 2. 创建 consul 对象
	client, err := api.NewClient(config)
	if err != nil {
		fmt.Println("api.NewClient", err)
		return
	}
	// 3. 告诉consul, 即将注册的服务的配置信息
	reg := api.AgentServiceRegistration{
		ID:      "fangkai",
		Tags:    []string{"grpc", "consul"},
		Name:    "grpc And Consul",
		Port:    8000,
		Address: "127.0.0.1",
		Check: &api.AgentServiceCheck{
			CheckID:  "consul grpc test",
			Interval: "5s",
			Timeout:  "1s",
			TCP:      "127.0.0.1:8000",
		},
	}
	err = client.Agent().ServiceRegister(&reg)
	if err != nil {
		fmt.Println("client.Agent err：", err)
		return
	}
	//====================================
	main01()
}
func main01() {
	// 1 grpc对象
	server := grpc.NewServer()
	// 2 注册服务
	pb.RegisterHelloServer(server, new(Children))
	// 3 设置监听
	listener, err := net.Listen("tcp", ":8000")
	if err != nil {
		fmt.Println("net.Listen err: ", err)
		return
	}
	defer listener.Close()
	//启动服务
	server.Serve(listener)
}

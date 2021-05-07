package main

import (
	"fmt"
	"sync"
	"time"
)

//五种原子操作
//1 增减
//2 比较并交换
//3 载入
//4 存储
//5 交换
//func main2() {
//	var wg sync.WaitGroup
//	wg.Add(3)
//	go func() {
//		time.Sleep(time.Second)
//		wg.Done()
//	}()
//	go func() {
//		time.Sleep(time.Second)
//		wg.Done()
//	}()
//	go func() {
//		time.Sleep(time.Second)
//		wg.Done()
//	}()
//	wg.Wait()
//	fmt.Println("g2,g3 and g3 are ender.")
//}
//func main1(){
//	sign := make(chan int,3)
//	go func() {
//		time.Sleep(time.Second)
//		sign<-2
//	}()
//	go func() {
//		time.Sleep(time.Second)
//		sign<-3
//	}()
//	go func() {
//		time.Sleep(time.Second)
//		sign<-4
//	}()
//	for i := 0; i < 3; i++ {
//		fmt.Printf("g%d is ended.\n",<-sign)
//	}
//}
// 一个[]byte的对象池，每个对象为一个[]byte
var bytePool = sync.Pool{
	New: func() interface{} {
		b := make([]byte, 800)
		return &b
	},
}

func main() {
	a := time.Now().Unix()
	// 不使用对象池
	for i := 0; i < 1000000000; i++ {
		obj := make([]byte, 800)
		_ = obj
	}
	b := time.Now().Unix()
	// 使用对象池
	for i := 0; i < 1000000000; i++ {
		obj := bytePool.Get().(*[]byte)
		bytePool.Put(obj)
	}
	c := time.Now().Unix()
	fmt.Println("without pool ", b-a, "s")
	fmt.Println("with    pool ", c-b, "s")
	fmt.Println()
}

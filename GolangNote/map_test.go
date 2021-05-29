package main

import (
	"strconv"
	"sync"
	"testing"
)


func TestOriginMaps(t *testing.T) {
	hm := NewOriginMap()
	wg := sync.WaitGroup{}
	for i := 0; i < Writer; i++ {
		wg.Add(1)
		go func(wg *sync.WaitGroup) {
			for k := 0; k < 100; k++ {
				hm.Set(strconv.Itoa(k), k*k) // 写数据
				val, _ := hm.Get(strconv.Itoa(k)) //读数据
				t.Logf("Get %d = %d", k, val)//打印读出的数据
			}
			wg.Done()
		}(&wg)
	}
	wg.Wait()
}



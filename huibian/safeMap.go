package main

import (
	"fmt"
	"sync"
)

type SafeMap struct {
	sync.Mutex
	Map map[int]int
}

func newSafeMap(size int) *SafeMap {
	sm := new(SafeMap)
	sm.Map = make(map[int]int, size)
	return sm
}
func (sm *SafeMap) readMap(key int) int {
	sm.Mutex.Lock()
	value := sm.Map[key]
	sm.Mutex.Unlock()
	return value
}
func (sm *SafeMap) writeMap(key int, value int) {
	sm.Mutex.Lock()
	sm.Map[key] = value
	sm.Mutex.Unlock()
}
func main() {
	safeMap := newSafeMap(10)
	for i := 0; i < 100000; i++ {
		go safeMap.writeMap(i, i)
		go safeMap.readMap(i)
	}
	fmt.Println(safeMap.readMap(1))
	fmt.Println(safeMap.readMap(2))
	for {

	}

}

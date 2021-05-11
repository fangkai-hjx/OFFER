package main

import (
	"fmt"
	"sync"
)

//=====================================
type Map interface {
	Set(key string, val interface{})
	Get(key string) (interface{}, bool)
	Del(key string)
}
type OriginMap struct {
	m map[string]interface{}
}

//=====================================
func NewOriginMap() *OriginMap {
	return &OriginMap{m: make(map[string]interface{})}
}
func (o *OriginMap) Get(key string) (interface{}, bool) {
	v, ok := o.m[key]
	return v, ok
}
func (o *OriginMap) Set(key string, value interface{}) {
	o.m[key] = value
}
func (o *OriginMap) Del(key string) {
	delete(o.m, key)
}

type OriginWithRWLock struct {
	m map[string]interface{}
	l sync.RWMutex
}

//=====================================
func NewOriginWithRWLock() *OriginWithRWLock {
	return &OriginWithRWLock{
		m: make(map[string]interface{}),
		l: sync.RWMutex{},
	}
}

func (o *OriginWithRWLock) Get(key string) (interface{}, bool) {
	o.l.RLock()
	v, ok := o.m[key]
	o.l.RUnlock()
	return v, ok
}
func (o *OriginWithRWLock) Set(key string, value interface{}) {
	o.l.Lock()
	o.m[key] = value
	o.l.Unlock()
}

func (o *OriginWithRWLock) Del(key string) {
	o.l.Lock()
	delete(o.m, key)
	o.l.Unlock()
}

const Writer = 1
const Readfr = 2

var s sync.RWMutex
func main() {
	//m := sync.Map{}
	//m.Store(1,1)
	//go do(m)
	//go do(m)
	//time.Sleep(1*time.Second)
	//fmt.Println(m.Load(1))
	var m map[myStruct]bool = make(map[myStruct]bool)
	m[myStruct{name: "fk"}] = false
	fmt.Println(m[myStruct{name: "fk"}])
}
type myStruct struct {
	name string
	//slice []string
} 
func do (m sync.Map) {
	i := 0
	for i < 10000 {
		m.Store(1,1)
		i++
	}
}

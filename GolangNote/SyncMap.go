package main

import "sync"

type SyncMap struct {
	m sync.Map
}

func NewSyncMap() *SyncMap {
	return &SyncMap{}
}

func (o *SyncMap) Get(key string) (interface{}, bool) {
	v, ok := o.m.Load(key)
	return v, ok
}
func (o *SyncMap) Set(key string, value interface{}) {
	o.m.Store(key, value)
}
func (o *SyncMap) Del(key string) {
	o.m.Delete(key)
}

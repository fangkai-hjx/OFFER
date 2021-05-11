package main

import (
	"strconv"
	"sync"
	"testing"
)
func benchmarkMap(b *testing.B, hm Map) {
	var wg sync.WaitGroup
	for i := 0; i < b.N; i++ {
		for j := 0; j < Writer; j++ {
			wg.Add(1)
			go func() {
				for k := 0; k < 100; k++ {
					hm.Set(strconv.Itoa(k), k*k)
					hm.Set(strconv.Itoa(k), k*k)
					hm.Del(strconv.Itoa(k))
				}
				wg.Done()
			}()
		}
		for j := 0; j < Reader; j++ {
			wg.Add(1)
			go func() {
				for k := 0; k < 100; k++ {
					hm.Get(strconv.Itoa(k))
				}
				wg.Done()
			}()
		}
	}
	wg.Wait()
}
func BenchmarkMaps(b *testing.B) {
	b.Logf("Writer: %d,Reader: %d", Writer, Reader)

	b.Run("SyncMap", func(b *testing.B) {
		hm := NewSyncMap()
		benchmarkMap(b, hm)
	})

	b.Run("map with RWLock", func(b *testing.B) {
		hm := NewOriginWithRWLock()
		benchmarkMap(b, hm)
	})
}
//func Benchmark_Add(b *testing.B) {
//	var n int
//	for i := 0; i < b.N; i++ {
//		n++
//	}
//}

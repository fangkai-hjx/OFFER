package string

import (
	"testing"
)

func BenchmarkPlusConcat(b *testing.B)    { benchmark(b, plusConcat) }
func BenchmarkSprintfConcat(b *testing.B) { benchmark(b, sprintfConcat) }
func BenchmarkBuilderConcat(b *testing.B) { benchmark(b, builderConcat) }
func BenchmarkBufferConcat(b *testing.B)  { benchmark(b, bufferConcat) }
func BenchmarkByteConcat(b *testing.B)    { benchmark(b, byteConcat) }
func BenchmarkPreByteConcat(b *testing.B) { benchmark(b, preByteConcat) }

/*
BenchmarkPlusConcat-4                 14          74525364 ns/op        530997130 B/op     10020 allocs/op-----------慢
BenchmarkSprintfConcat-4               8         132168188 ns/op        833677530 B/op     37449 allocs/op-----------慢

//strings.Builder、bytes.Buffer 和 []byte 的性能差距不大，
而且消耗的内存也十分接近，性能最好且消耗内存最小的是 preByteConcat，这种方式预分配了内存，在字符串拼接的过程中，
不需要进行字符串的拷贝，也不需要分配新的内存，因此性能最好，且内存消耗最小。
BenchmarkBuilderConcat-4            8575            143235 ns/op          522224 B/op         23 allocs/op-----------使用
BenchmarkBufferConcat-4             7062            170667 ns/op          423537 B/op         13 allocs/op
BenchmarkByteConcat-4               8004            148709 ns/op          628720 B/op         24 allocs/op
BenchmarkPreByteConcat-4           15945             75338 ns/op          212992 B/op          2 allocs/op
*/
//综合易用性和性能，一般推荐使用 strings.Builder 来拼接字符串。
//ns:纳秒
//op:操作

//The allocs/ops average only counts heap allocations, not stack allocations.
//The allocs/ops average is rounded down to the nearest integer value.

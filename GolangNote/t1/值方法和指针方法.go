package t1

import "fmt"

type Foo struct {
	name string
}

func (f *Foo) PointerMethod()  {
	fmt.Println("pointer method on",f.name)
}
func (f Foo) ValueMethod() {
	fmt.Println("value method on",f.name)
}
type Integer int

func (i Integer) name() {
	fmt.Println(i)
}
func (i *Integer) name2() {
	fmt.Println(i)
}
func NewFoo() Foo {
	return Foo{name: "right value struct"}
}
//func main() {
//	f1 := Foo{name: "value struct"} // 值类型
//	f1.PointerMethod()//) // 编译器会自动插入取地址符，变为 (&f1).PointerMethod()
//	f1.ValueMethod()
//	f2 := &Foo{name: "pointer struct"}
//	f2.PointerMethod()
//	f2.ValueMethod() // 编译器会自动解引用，变为 (*f2).PointerMethod()
//
//	NewFoo().ValueMethod()
//	//NewFoo().PointerMethod() // Error!!!
//}

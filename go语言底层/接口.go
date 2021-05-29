package main

import "fmt"

type RPCError struct {
	Code int64
	Message string
}

func (e *RPCError) Error() string {
	return fmt.Sprintf("%s, code=%d", e.Message, e.Code)
}
func NewRPCError(code int64,message string)*RPCError{
	return &RPCError{
		Code:    code,
		Message: message,
	}
}
func AsErr(err error) error {
	return err
}

type TestStruct struct {}

//调用 NilOrNot 函数时发生了隐式的类型转换，除了向方法传入参数之外，变量的赋值也会触发隐式类型转换
func NolOrNot(v interface{}) bool {
	return v == nil
}
func main() {
	var s *TestStruct
	fmt.Println(s == nil)  //true
	fmt.Println(NolOrNot(s)) //false
}

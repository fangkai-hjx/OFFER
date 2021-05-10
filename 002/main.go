package main

import (
	"crypto/md5"
	"fmt"
	uuid "github.com/satori/go.uuid"
	"io"
	"log"
	"strings"
)

//admin
//YzcmCZNvbXocrsz9dm8e
//9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d
//func ValidPassword(data []byte) []byte {
//	sha256 := sha256.New()
//	sha256.Write(data)
//	hashText := sha256.Sum(nil)
//	return hashText
//}
func getMd5String1(str string) string {
	m := md5.New()
	_, err := io.WriteString(m, str)
	if err != nil {
		log.Fatal(err)
	}
	arr := m.Sum(nil)
	return fmt.Sprintf("%x", arr)
}
func Md5Crypt(str string, salt ...interface{}) (CryptStr string) {
	if l := len(salt); l > 0 {
		slice := make([]string, l+1)
		str = fmt.Sprintf(str+strings.Join(slice, "%v"), salt...)
	}
	return fmt.Sprintf("%x", md5.Sum([]byte(str)))
}
func getMd5String2(b []byte) string {
	return fmt.Sprintf("%x", md5.Sum(b))
}
func main1() {
	str := "111111"
	string1 := getMd5String1(str)
	fmt.Println(string1)
	string2 := getMd5String2([]byte(str))
	fmt.Println(string2)
	string3 := Md5Crypt(str, "aaa")
	fmt.Println(string3) //26d102626ad5ed0bb8279b32d364b899
}
func main() {
	u1 := uuid.Must(uuid.NewV4())
	fmt.Printf("UUIDv4:%s\n", u1)
}

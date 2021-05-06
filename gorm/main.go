package main

import (
	"database/sql"
	"fmt"
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

const (
	driverName = "mysql"
	source     = "root:root@(localhost)/db1?charset=utf8mb4&parseTime=True&loc=Local"
)

//1 定义模型
type User struct {
	ID   int64
	Name sql.NullString `gorm:"default:'小王子'"`
	Age  int64
}

func main() {
	//连接数据库
	db, err := gorm.Open(driverName, source)
	if err != nil {
		panic(err.Error())
	}
	defer db.Close()
	//2 将模型与数据库中的表对应起来
	db.AutoMigrate(&User{})
	//3 创建记录
	u := User{Name: sql.NullString{"", true}, Age: 333}
	fmt.Println(db.NewRecord(&u)) //判断主键是否为空,true
	db.Debug().Create(&u)
	fmt.Println(db.NewRecord(&u)) //判断主键是否为空,false
}

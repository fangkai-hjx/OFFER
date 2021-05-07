package main

import (
	"io"
	"os"
	"sync"
)

type Data []byte

// 用于表示数据文件类型的接口类型
type DataFile interface {
	// 读取一个数据块
	Read() (rsn int64, d Data, err error)
	// 写入一个数据块
	Write(d Data) (wsn int64, err error)
	// 获取最后读取的数据块的序列号
	RSR() int64
	// 获取最后写入的数据块的序列号
	WSN() int64
	// 获取数据块的长度
	DataLen() int64
	// 关闭数据文件
	Close() error
}
type myDataFile struct {
	f       *os.File     //文件
	fmutex  sync.RWMutex //用于文件的读写锁
	woffset int64        //写操作需要用到的偏移量
	roffset int64        //读操作需要用到的偏移量
	wmutex  sync.Mutex   //
	rmutex  sync.Mutex   //
	datalen uint32       //数据块的长度
}

func NewDataFile(path string, dataLen uint32) (DataFile, error) {
	//file, err := os.Open(path)
	//if err != nil {
	//	return nil, err
	//}
	//if dataLen == 0 {
	//	return nil, errors.New("Invalid data length!")
	//}
	////df := myDataFile{f: file, datalen: dataLen}
	return nil, nil
}

//1 获取并更新读偏移量
//2 根据读偏移量去文件中读取一块数据
//3 把该数据块封装成一个Data类型值并将其作为结果值放回
func (df *myDataFile) Read() (rsn int64, d Data, err error) {
	var offset int64
	df.rmutex.Lock()
	//TODO 下面两个操作是互斥的
	offset = df.roffset
	df.roffset += int64(df.datalen) //更新偏移量
	//读取一个数据块
	rsn = offset / int64(df.datalen)  //得到读序列号
	bytes := make([]byte, df.datalen) // 一个数据块大小的字节数组
	for {
		df.fmutex.RLock()
		_, err = df.f.ReadAt(bytes, offset) //从offset开始读取一个字节快
		if err != nil {
			if err == io.EOF {
				df.fmutex.RUnlock()
				continue
			}
			df.fmutex.RUnlock()
			return
		}
		d = bytes
		df.fmutex.RUnlock()
		return
	}
}
func (df *myDataFile) Write(d Data) (wsn int64, err error) {
	var offset int64
	df.wmutex.Lock()
	//offset := df.woffset
	df.woffset += int64(df.datalen)
	df.wmutex.Unlock()
	//更新完毕
	wsn = offset / int64(df.datalen)
	var bytes []byte
	if len(d) > int(df.datalen) {
		bytes = d[:df.datalen] //截断处理
	} else {
		bytes = d
	}

	df.fmutex.Lock()
	defer df.fmutex.Unlock()
	_, err = df.f.Write(bytes)
	return
}

//锁的完整示例
//创建一个文件存放数据，同一时刻可能会有多个goroutine分别对该文件进行写操作和读操作
//func main() {
//	//os.File
//}

package main

import (
	"fmt"
	"sync"
)

func main() {
	defer func() {
		fmt.Println("Try to recover the panic.")
		if p := recover(); p != nil {
			fmt.Printf("Recovered the panic (%#v)", p)
		}
	}()
	var mutex sync.Mutex
	fmt.Println("Lock the lock.")
	mutex.Lock()
	fmt.Println("Lock the locked.")
	fmt.Println("UnLock the lock.")
	mutex.Unlock()
	fmt.Println("UnLock the lock again.")
	mutex.Unlock()
}

//两次unlock会引起panic，这是因为保证解锁的唯一性
//fatal error: sync: unlock of unlocked mutex

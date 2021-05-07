package main

//func main() {
//	var Rwm sync.RWMutex
//	locker := Rwm.RLocker()
//	locker.Lock()
//	for i := 0; i < 3; i++ {
//		go func(i int) {
//			fmt.Printf("Try to lock for reading...[%d]\n",i)
//			Rwm.RLock()
//			fmt.Printf("Locked for reading. [%d]\n",i)
//			time.Sleep(time.Second*2)
//			fmt.Printf("Try to unlock for reading. [%d]\n",i)
//			Rwm.RUnlock()
//			fmt.Printf("UnLocked for reading. [%d]\n",i)
//		}(i)
//	}
//	time.Sleep(time.Millisecond*100)
//	fmt.Println("Try to lock for writing...")
//	Rwm.Lock()
//	fmt.Println("Locked for writing.")
//}

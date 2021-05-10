package pkg


//go tool compile -S test.go
//var Id = 9527
//go.cuinfo.packagename. SDWARFINFO dupok size=0
//        0x0000 70 6b 67                                         pkg
//"".Id SNOPTRDATA size=8
//        0x0000 37 25 00 00 00 00 00 00                          7%......
//func Sqrt(x float64) float64 {
//	return math.Sqrt(x)
//}
//"".Sqrt STEXT nosplit size=17 args=0x10 locals=0x0
//        0x0000 00000 (test.go:11)       TEXT    "".Sqrt(SB), NOSPLIT|ABIInternal, $0-16
//        0x0000 00000 (test.go:11)       FUNCDATA        $0, gclocals·33cdeccccebe80329f1fdbee7f5874cb(SB)
//        0x0000 00000 (test.go:11)       FUNCDATA        $1, gclocals·33cdeccccebe80329f1fdbee7f5874cb(SB)
//        0x0000 00000 (test.go:12)       MOVSD   "".x+8(SP), X0
//        0x0006 00006 (test.go:12)       SQRTSD  X0, X0
//        0x000a 00010 (test.go:12)       MOVSD   X0, "".~r1+16(SP)
//        0x0010 00016 (test.go:12)       RET
//        0x0000 f2 0f 10 44 24 08 f2 0f 51 c0 f2 0f 11 44 24 10  ...D$...Q....D$.
//        0x0010 c3
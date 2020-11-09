package dongtaiguihua;

import java.util.ArrayList;
import java.util.List;

public class FibonaciSequence {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int n =50;
//        System.out.println(digui(n));//f(50)耗时：94481毫秒  -298632863
//        System.out.println(formDownToUp(n));//计算f（50)耗时:1毫秒
        System.out.println(dongtaiguihua(n));//计算f（50)耗时:1毫秒
        long end = System.currentTimeMillis();
        System.out.println("计算f（"+n+")耗时:"+(end-start)+"毫秒");
    }
    public static int digui(int n ){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return digui(n-1)+digui(n-2);
    }
    //记忆性搜索--》自顶向下
    public static int[] memory = new int[51];
    public static int formDownToUp(int n ){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(memory[n] == 0) memory[n] = formDownToUp(n-1)+formDownToUp(n-2);
        return memory[n];
    }
    public static int dongtaiguihua(int n){
        memory[0] = 1;
        memory[1] = 1;
        for(int i = 2;i<n;i++){
            memory[i] = memory [i-1] + memory[i-2];
        }
        return memory[n-1];
    }
}

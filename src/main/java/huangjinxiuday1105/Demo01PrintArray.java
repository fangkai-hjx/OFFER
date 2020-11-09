package huangjinxiuday1105;

import java.util.Arrays;

/**
 *
 *
 *
 *
 */
public class Demo01PrintArray {
    public static void main(String[] args) {
        int[]arry={10,20,30,40,50};
        System.out.println("dadadada");
        System.out.print("[");
        for (int i=0;i<arry.length;i++){
            if(i==arry.length-1){//最后一个元素
                System.out.print(arry[i]);
            }else{//除最后一个元素，其他元素
                System.out.print(arry[i]+",");
            }
        }
        System.out.println("]");
        System.out.println("--------- ");
        //使用面向对象
        System.out.println(Arrays.toString(arry));
        System.out.println("args = [" + args + "]");
    }
}

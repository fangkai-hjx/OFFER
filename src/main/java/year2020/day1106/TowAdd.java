package year2020.day1106;

import java.util.Arrays;

public class TowAdd {
    public static void main(String[] args) {
        System.out.println(Add(3, 4));
        System.out.println(Add(3, -4));
        System.out.println(Add(-3, 4));
        System.out.println("--------------------------");
        System.out.println(diguiAdd(3, 4));
        System.out.println(diguiAdd(3, -4));
        System.out.println(diguiAdd(-3, 4));
    }


    public static int Add(int num1, int num2) {

        int temp;
        while (num2 != 0) {
            temp = (num1 & num2) << 1;//进位和
            num1 = num1 ^ num2;//非进位和
            num2 = temp;
        }
        return num1;
    }

    //第一个参数 为 非进位 第二个 参数 为 进位
    public static int diguiAdd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return diguiAdd(num1 ^ num2, (num1 & num2) << 1);
    }
}

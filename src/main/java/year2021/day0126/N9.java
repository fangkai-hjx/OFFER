package year2021.day0126;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 */
public class N9 {
    //f(n) = f(n-1) + f(n-2)
    // n =1 1
    // n =2 2
    // n =3 3
    public int RectCover(int target) {
        if(target <= 3) return target;
        int a=1,b=2,c=3;
        for (int i = 3; i < target; i++) {
            a = b;
            b = c;
            c = a+b;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(new N9().RectCover(4));
        System.out.println(new N9().RectCover(5));
    }
}

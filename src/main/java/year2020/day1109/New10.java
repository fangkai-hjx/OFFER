package year2020.day1109;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * <p>
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 */
public class New10 {
    public static void main(String[] args) {
        New10 new10 = new New10();
        for (int i = 1; i <= 10; i++) {
            System.out.println(new10.RectCover(i));
        }
    }

    public static int RectCover(int target) {
        if (target <= 3) return target;
        int a = 1, b = 2, c = 3;
        for (int i = 3; i < target; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}

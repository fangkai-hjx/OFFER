package year2020.day1106;

public class Sum_Solution {
    public static void main(String[] args) {
        System.out.println(Sum_Solution(2));
        System.out.println(Sum_Solution(3));
        System.out.println(Sum_Solution(4));
    }

    static int sum = 0;

    static public int Sum_Solution(int n) {
        boolean x = n > 1 && Sum_Solution(n - 1) > 0;
        sum += n;
        return sum;
    }
}

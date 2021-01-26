package year2021.day0126;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class N8 {
    int[] temp ;
    public int JumpFloorII(int target) {
        //f(n) = f(0) + f(1) + f(2) + ... + f(n)
        if(target<=2) return target;
        temp = new int[target+1];
        temp[0] = 1;
        temp[1] = 1;
        temp[2] = 2;
        for (int i = 3; i <= target; i++) {
            temp[i] = getSum(i-1);
        }
        return temp[target];
    }
    public int getSum(int end){
        int sum = 0;
        for (int i = 0; i <= end; i++) {
            sum += temp[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        final N8 n8 = new N8();
        System.out.println(n8.JumpFloorII(3));
    }
}

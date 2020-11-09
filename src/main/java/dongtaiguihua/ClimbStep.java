package dongtaiguihua;

/**
 * 青蛙跳台阶
 */
public class ClimbStep {
    public static void main(String[] args) {

    }
    public static int climbStairs_Digui(int n){
        if(n==1)return 1;
        if(n==2)return 2;
        return climbStairs_Digui(n-1)+climbStairs_Digui(2);
    }
    public static int climbStairs(int n){
        int[] memory = new int[n];
        memory[0] = 1;
        memory[1] = 1;
        memory[2] = 2;
        for (int i = 0; i < n; i++) {
            memory[i] = memory[i-1] + memory[i-2];
        }
        return memory[n-1];
    }

}

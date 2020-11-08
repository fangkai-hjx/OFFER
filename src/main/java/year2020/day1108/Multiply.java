package year2020.day1108;

public class Multiply {
    public static void main(String[] args) {
        int[] A = new int[]{ 1, 2, 3, 4, 5};
        for (int i : multiply(A)) {
            System.out.println(i);
        }
    }

    static public int[] multiply(int[] A) {
        if (A == null || A.length <= 1) return null;
        int[] B = new int[A.length];
        int temp = 1;
        B[0] = 1;
        for (int i = 1; i < A.length; i++)
            B[i] = B[i - 1] * A[i - 1];
        for (int i = A.length - 2; i >= 0; i--){
            temp = temp * A[i+1];
            B[i] = B[i] * temp;
        }
        return B;
    }
}

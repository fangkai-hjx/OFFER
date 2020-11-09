package huishuo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 给出一个数字n，要求给出1-n的所有数字的排列，
 * 例如 3：[123，132，213，231，312，321]数组
 */
public class AllNumbers {
    public static int count = 0;

    public static void main(String[] argv) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();//输入N   这里用于输出1到N的全排列
        int[] key = new int[N];
        for (int i = 0; i < key.length; i++) {
            key[i] = i + 1;
        }
        check(0, key, N);
        for (ArrayList<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer+"->");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static void check(int n, int[] array, int N) {//换位函数
        int i;
        if (n == N) {//符合条件输出
            ArrayList<Integer> list = new ArrayList<>();
            for (int i1 : array) {
                list.add(i1);
            }
            result.add(list);
        }
        for (i = n; i < N; i++) {//在 结果集 中 选取 结果
            swap(array, n, i);//交换
            check(n + 1, array, N);//考虑下面分叉
            swap(array, n, i);//回溯
        }
    }

    public static void swap(int[] array, int a, int b) {
        int x = array[a];
        array[a] = array[b];
        array[b] = x;
    }
}

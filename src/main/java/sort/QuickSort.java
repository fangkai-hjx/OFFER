package sort;
// 6  1  2 7  9  3  4  5 10  8
// 5  1  2 7  9  3  4  [6] 10  8
// 5  1  2  4  3 [6]  9 7 10  8

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int nums[] = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        quick_sort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "->");
        }
    }
    // 6
    //6, 1, 2, 7, 9, 3, 4, 5, 10, 8
    //[5], 1, 2, 7, 9, 3, 4, [6], 10, 8
    //[5], 1, 2, [7], 9, 3, 4, [6], 10, 8
    //[5], 1, 2, 4, 9, 3,[6] , 7, 10, 8

    static void quick_sort(int q[], int l, int r) {
        if (l >= r) return;// 判断排序的数字长度

        int i = l, j = r, x = q[l];
        //选取双指针i,j与 中间随机值
        while (i < j) {
            //进行判断比较大小并交换值
            while (q[i] < x) i++;
            while (q[j] > x) j--;
            if (i < j) {
                //q[i] 和 q[j]交互
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
                //注意！！！使用语言有没有swap方法（如果没有建议用位运算）
            } else break;
        }
        //再将俩个部分（小于等于随机值||大于小于随机值）再次划分
        quick_sort(q, l, j);
        quick_sort(q, j + 1, r);
    }


}

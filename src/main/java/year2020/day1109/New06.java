package year2020.day1109;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 示例1
 * 输入
 * 复制
 * [3,4,5,1,2]
 * 返回值
 * 复制
 * 1
 */
public class New06 {
    public static void main(String[] args) {
        int[] ints = {3, 4, 5, 1, 2};
        System.out.println(new New06().minNumberInRotateArray(ints));
    }

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int left = 0, right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return array[left];
    }
}

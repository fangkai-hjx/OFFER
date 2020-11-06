package year2020.day1105;

public class MinNumberInRotateArray {
    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 5, 1, 2};
        int i = minNumberInRotateArray(array);
        System.out.println(i);
    }

    static public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) return -1;
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (array[mid] > array[right]) left = mid + 1;
            else if (array[mid] < array[right]) right = mid;
            else {
                right--;
            }
        }
        return array[left];
    }
}

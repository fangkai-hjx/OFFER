package sort;

public class QuickSort2 {
    private static int[] nums;

    public static void main(String[] args) {
        nums = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        quickSort( 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "->");
        }
    }

    // 6
    //6, 1, 2, 7, 9, 3, 4, 5, 10, 8   start 0  end 9
    //[5], 1, 2, 7, 9, 3, 4, [6], 10, 8   start 0  end 7
    // 5, 1, 2, [7], 9, 3, 4, [6], 10, 8 start 3  end 7
    // 5, 1, 2, [6] , 9, 3, [4] , 7, 10, 8 start 3  end 6
    // 5, 1, 2, 4 , [9], 3,[6] , 7, 10, 8 start 4  end 6
    // 5, 1, 2, 4 , [6], [3],9 , 7, 10, 8 start 4  end 5
    // 5, 1, 2, 4 , 3, [6],9 , 7, 10, 8 start 5  end 5
    public static void quickSort(int left, int right) {
        if (left >= right) return;
        int start = left;
        int end = right;
        int key = nums[start];
        while (end > start) {
            //从 右 到 左 找到 比 key 小的 数值 位置
            while (end > start && nums[end] > key) end--;
            //从 左 到 右 找到 比 key 大的 数值 位置
            while (end > start && nums[start] < key) start++;
            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
        quickSort(left,start-1);
        quickSort(start+1,right);
    }
}

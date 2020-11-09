package year2020.day1106;

//统计一个数字在升序数组中出现的次数。
//示例1
//输入
//复制
//[1,2,3,3,3,3,4,5],3
//返回值
//复制
//4
public class GetNumberOfK {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,3,3,3,4,5};
        System.out.println(GetNumberOfK(array,3));
    }

    static public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) return -1;
        int start = binSearch(array, k);
        int count = 0;
        for(int i = start;i<array.length;i++){
            if(array[i] == k){
                count ++;
                continue;
            }
        }
        return count;
    }
    static public int binSearch(int[] array,int k){
        //左边 二分查找
        int left = 0, right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (k > array[mid]){
                left = mid + 1;//[left,mid]区间的元
                // 素 都比 k小，下一轮在[mid+1,right]
            }else {
                right = mid;
            }
        }
        return left;
    }
}

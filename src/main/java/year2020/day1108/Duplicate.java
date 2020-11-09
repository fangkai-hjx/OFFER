package year2020.day1108;

/**
 * 2,3,1,0,2,5,3 i=0
 * 1,3,2,0,2,5,3 i=0
 * 3,1,2,0,2,5,3 i=0
 * 0,1,2,3,2,5,3 i=0
 * <p>
 * 0,1,2,3,2,5,3 i=1
 * 0,1,2,3,2,5,3 i=2
 * 0,1,2,3,2,5,3 i=3
 * 0,1,2,3,2,5,3 i=4---->出现重复
 */
public class Duplicate {
    public static void main(String[] args) {
        int[] array = new int[]{6,3,2,0,2,5,0};
        int[] ints = new int[1];
        boolean duplicate = duplicate2(array, array.length, ints);
        System.out.println(duplicate);
        System.out.println(ints[0]);
    }

    public static boolean duplicate2(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length == 0) {
            duplication[0] = -1;
            return false;
        }
        int[] count = new int[length];
        for(int i=0;i<length;i++){
            count[numbers[i]]++;
        }
        for(int i=0;i<length;i++){
            if(count[numbers[i]] >1){
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
    public static boolean duplicate1(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length == 0) return false;
        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] != i && numbers[numbers[i]] != numbers[i]) {
                //交换 numbers[numbers[i]] 和  numbers[i] 进行交换
                int temp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[temp] = temp;
            }
            if(numbers[i] != i && numbers[numbers[i]] == numbers[i])
            {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
}

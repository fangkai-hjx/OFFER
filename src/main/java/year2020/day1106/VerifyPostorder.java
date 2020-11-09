package year2020.day1106;

public class VerifyPostorder {
    public static void main(String[] args) {
        int[] array = new int[]{4,6,7,5};
        System.out.println(VerifySquenceOfBST(array));
    }

    private static int[] array;

    public static boolean verifyPostorder(int[] postorder) {
        array = postorder;
        return recur(0, postorder.length - 1);
    }

    public static boolean recur(int start, int end) {
        if (start >= end) return true;//这里 的 大于 号 对于  4,【6,7】,5 其中
        int memory = start;//记录第一段结束位置
        while (array[memory] < array[end]) memory++;
        int leftEnd = memory;
        while (array[memory] > array[end]) memory++;
        int rightEnd = memory;//记录第二段结束位置
        return (rightEnd == end) && recur(start, leftEnd - 1) && recur(leftEnd, rightEnd-1);
    }
    //牛客
    public static boolean VerifySquenceOfBST(int [] sequence) {
        array = sequence;
        return recur(0, sequence.length - 1);
    }
}

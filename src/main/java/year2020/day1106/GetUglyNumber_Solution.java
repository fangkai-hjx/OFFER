package year2020.day1106;

public class GetUglyNumber_Solution {
    public static void main(String[] args) {

        System.out.println(GetUglyNumber_Solution(7));
    }

    /**
     * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
     * 例如6、8都是丑数，但14不是，因为它包含质因子7。
     * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     *
     * @param index
     * @return
     */
    static public int GetUglyNumber_Solution2(int index) {//第index 个 丑数
        //1 2 3 4 5 7 8 9 10 12
        int nember = 1;
        int result = -1;
        while (true) {
            if (judge(nember) && (--index == 0)) {
                result = nember;
                break;
            }
            nember++;
        }
        return result;
    }

    //判断该数是否是丑数   2、3和5
    private static boolean judge(int member) {
        if ((member == 1) || (member == 3) || (member == 5)) return true;
        boolean flag;
        while (member >= 2) {
            flag = false;
            if (member % 2 != 0 && member % 3 != 0 && member % 5 != 0) {
                return false;
            }
            if (member % 2 == 0) {
                member = member / 2;
                flag = true;
            }
            if (member % 3 == 0) {
                member = member / 3;
                flag = true;
            }
            if (member % 5 == 0) {
                member = member / 5;
                flag = true;
            }
            if (!flag) return false;
        }
        return member == 1;
    }

    public static int GetUglyNumber_Solution(int index) {
        int[] memory = new int[index];
        memory[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < index; i++) {
            int one = memory[a] * 2;
            int two = memory[b] * 3;
            int three = memory[c] * 5;
            memory[i] = Math.min(one, Math.min(two, three));
            if (memory[i] == one) a++;
            if (memory[i] == two) b++;
            if (memory[i] == three) c++;
        }
        return memory[index-1];
    }
}

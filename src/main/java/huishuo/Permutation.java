package huishuo;

import java.util.*;

public class Permutation {
    public static void main(String[] args) {
        ArrayList<String> abcs = Permutation("a");

        for (String abc : abcs) {
            System.out.print(abc + "->");
        }
    }

    private static ArrayList<String> result = new ArrayList<>();
    private static char[] data;

    public static ArrayList<String> Permutation(String str) {
        if(str==null || str.length() == 0) return result;
        data = str.toCharArray();
        dfs(0);
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 返回相反的compare
                return o1.compareTo(o2);
            }
        });
        return result;
    }

    private static void dfs(int x) {
        if (x == data.length) {
            result.add(String.valueOf(data));//加入结果集
            return;
        }
        //遍历 可选集
        Set<Character> set = new HashSet<>();
        for (int i = x; i < data.length; i++) {
            if(set.contains(data[i]))continue;//减枝
            set.add(data[i]);
            swap(x,i);
            dfs(x+1);
            swap(i,x);
        }
    }

    private static void swap(int a, int b) {
        char temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}

package leetcode.medium;

import io.netty.util.internal.StringUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {

        String str = longestSubstring4("pwwkew");
        System.out.println(str);
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        String subString = "";
        for(int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n ; j++) {
                if(allUnique(s, i, j)) {
                    if(ans < j - i) {
                        ans = j - i;
                        subString = s.substring(i, j);
                    }
                    ans = Math.max(ans, j - i);

                }
            }
        }

        System.out.println("String : " + s);
        System.out.println("ans: " + ans);
        System.out.println("longest subString: " + subString );
        return ans;
    }

    public static Boolean allUnique(String s , Integer start, Integer end) {
        Set<Character> set = new HashSet<>(end - start);
        for(int i = start; i < end; i++) {
            Character character = s.charAt(i);
            if(set.contains(character)) {
                return Boolean.FALSE;
            } else {
                set.add(character);
            }
        }
        return Boolean.TRUE;
    }

    public static int lengthOfLongestSubstring2(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuffer sb2 = new StringBuffer("");
        sb2.append("");
        int n = s.length();
        int i = 0;
        int j = 1;
        int ans = 0;
        Set<Character> set = new HashSet<>(n);
        while (i < n &&j < n) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j = j + 1;
                ans = Math.max(ans, j -i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        System.out.println("String : " + s);
        System.out.println("ans: " + ans);
        System.out.println("longest subString: " + s.substring(i, j) );
        return ans;
    }

    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        int ans = 0;
        int i = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>(n);

        while (j < n) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }

            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j+1);

            j = j + 1;
        }

        System.out.println("String : " + s);
        System.out.println("ans: " + ans);
        System.out.println("longest subString: " + s.substring(i, j) );
        return ans;
    }

   public static String longestSubstring4(String s) {
        if(s == null || "".equals(s)) {
            return null;
        }

        //两层循环时间复杂度为O(N*N),在加上判断，时间复制度为O(N*N*N)
        //更换思虑
        int n = s.length();
        String subString = "";
        int i = 0;
        int j = 0;
        Set<Character> sets = new HashSet<>();

        //通过i,j 拆分字符串
        while (i < n && j < n) {
            //i不动，j步进
            Character character = s.charAt(j);
            //如果sets中已经包含该char，i进一
            if(sets.contains(character)) {
                sets.remove(s.charAt(i));
                i++;
            } else {
                //如果不包含，j进一，比较当前字符串长度和subString长度，取最大值
                sets.add(character);
                if(subString.length() < (j - i + 1)) {
                    subString = s.substring(i, j + 1);
                }

                j++;
            }
        }

        return subString;
    }
}

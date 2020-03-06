package leetcode.medium;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "a";
        String palindromic = longestPalindromicSubString2(s);
        System.out.println("String: " + s);
        System.out.println("palindromic : " + palindromic);
    }

    public static String longestPalindromicSubString(String s) {
        int n = s.length();;
        String palindromic = "";
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j <= n; j++) {
                String subString = s.substring(i, j);
                if(judgePalindromic(subString)) {
                    if(palindromic.length() < subString.length()) {
                        palindromic = subString;
                    }
                }
            }
        }
        return palindromic;
    }

    public static Boolean judgePalindromic(String  s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for(int index = 0; index < n / 2; index ++) {
            if(chars[index] != chars[n - 1 - index]) {
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }

    public static String longestPalindromicSubString2(String s) {
        if(s == null || "".equals(s)) { return ""; }

        Integer index = 0;
        Integer start = 0;
        Integer end = 0;

        while (index < s.length()) {
            Integer length1 = expandAroundCenter(s, index, index);
            Integer length2 = expandAroundCenter(s,index, index+ 1);
            Integer length = Math.max(length1, length2);
            if (length > end - start) {
                start = index - (length - 1) / 2;
                end = index + length / 2;
            }
            index ++;
        }

        return s.substring(start, end + 1);
    }

    public Integer expandAroundCenter2(String s, Integer left, Integer right) {
        Integer length = s.length();
        while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }

        return right - left - 1;

    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}

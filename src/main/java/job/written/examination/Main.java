package job.written.examination;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.Scanner;
import java.util.concurrent.locks.LockSupport;

public class Main {

    protected Integer pro = 1;
    Integer sec = 2;

    public static void main(String[] args) {
        LockSupport.park();
        Scanner in = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        String result = "";
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String str = in.nextLine();
            stringBuilder.append(str);

            String temp = getLongStr(stringBuilder.toString().trim());
            if(result.length() < temp.length()) {
                result = temp;
            }
        }
        System.out.println(result);
    }

    public static String getLongStr(String str) {
        if(str == null || "".equals(str)) {
            return "";
        }


        String result = "";
        Integer length = str.length();
        Integer i = 0;
        Integer j = 0;
        Character temp = str.charAt(0);
        while (j < length) {
            Character character = str.charAt(j);
            if(Character.toUpperCase(temp) != Character.toUpperCase(character)) {
                if(result.length() < (j - i)) {
                    result = str.substring(i, j );
                }
                i = j;
                temp = character;
            }

            j++;
        }

        if(result.length() < (j - i)) {
            result = result = str.substring(i, j );
        }

        return result;
    }
}
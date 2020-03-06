package job.written.examination;

public class MyTest {
    public static void main(String[] args) {
        String resultStr = "";
        Integer maxLength = -1;
        String str = "bbbbaaacccccccddddddabbddccddccccccccccccccccccb";
        Integer strLength = str.length();
        for(int i = 0; i< strLength; i++) {
            for(int j = i + 1; j < strLength; j++) {
                String subString = str.substring(i,j);
                if(verifyString(subString)) {
                    //判断是否大于最大长度
                    if(maxLength < subString.length()) {
                        maxLength = subString.length();
                        resultStr = subString;
                    }
                }
            }
        }

        System.out.println("最长重复子串为：" + resultStr);
    }

    static public Boolean verifyString(String str) {
        char[] subString = str.toCharArray();
        Integer length= subString.length;
        Integer half = subString.length / 2;
        for(int index = 0; index < half; index++) {
            if(subString[index] != subString[length-1 - index]) {
                return false;
            }
        }

        return true;
    }
}
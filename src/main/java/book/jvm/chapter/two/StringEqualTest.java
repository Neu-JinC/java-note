package book.jvm.chapter.two;

/**
 * String.intern
 * 作用如果字符串常量池里已经包含一个等于String对象的字符串
 * 则返回代表池中这个字符串对象
 * 否则将此String包含的字符串添加到常量池中，并返回这个字符串的String对象
 *
 */
public class StringEqualTest {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
//        str1.intern();
//        System.out.println(str1.intern() == str1);
        System.out.println(str1 == str1.intern());
        System.out.println("计算机软件" == str1);
        System.out.println("计算机软件" == str1.intern());
        System.out.println("计算机软件" == str1);

        String str2 = new StringBuilder("Hello").append(" ").append("World").toString();
        System.out.println(str2.intern() == str2);
    }
}
